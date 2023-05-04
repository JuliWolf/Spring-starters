# Spring boot

## Зависимости
1. Spring boot помогает решить проблему конфликта версий</br>
После того как все зависимости указыны в файле `pom/xml` Maven проходится по всем зависимостям и если в зависимости не указано версии, то Maven будет пытаться найти версию в родительском пакете
2. Если мы хотим использовать свой pom то
```
<dependencyManagement>
  <dependencies>
     <dependency>
        <groupId>io.spring.platform</groupId>
        <artifactId>platform-bom</artifactId>
        <version>Brussels-SR2</version>
        <type>pom</type>
        <scope>import</scope>
     </dependency>
  </dependencies>
</dependencyManagement>
```

или gradle 
```
dependencyManagement {
  imports {
    mavenBom 'org.springframework.cloud:spring-cloud-dependencies:Dalston.RELEASE'
  }
}
```

## Настройка контекста
1. Контекст есть всегда
2. Spring предлагает 2 контекста
- Если есть `javax.servlet.Servlet` + `ConfigurableWebApplicationContext` -> `AnnotationConfigEmbeddedWebApplicatonContext`
- Иначе `AnnotationConfigApplicationContext`

## Создание стартера
1. Задаем логику стартера и создаем все необходимое для ее реализации
2. Создаем класс с аннотацией `@Configuration` в которой будет происходить инициализация стартера
```
@Configuration
public class IronConfiguration {

  @Bean
  public RavenListener ravenListener () {
    return new RavenListener();
  }
}
```
3. В файле `resourses/META_INT/spring.factories` регистрируем класс конфигурации
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.ironbank.IronConfiguration
```
4. Подключаем стартер к проекту

## Как конфигурация стартера подтянется к проекту
1. Когда мы указываем аннотацию `@EnableAutoConfiguration` `importSelector` обрабатывает аннотацию и добавляет в наш контекст все необходимые бины</br>
Он использует `Spring Factories Loader`, который смотрит на файл `spring.factories` и загружает все необходимые зависимости

2. В самом Spring Boot есть свой файл `spring.factories`, который в себе хранит ряд зависимостей</br>
которые фильтруется с помощью `@Conditional`

## `@Condition`

```
@Retention(RetentionPolicy.RUNTIME)
@Conditional({OnProductionCondition.class})
public @interface ConditionOnProduction {
}
```

```
public class OnProductionCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return JOptionPane.showConfirmDialog(null, "это продакшен?") == 0;
  }
}
```

*Сколько раз будет вызываться один и тот же `@Condition` для двух разных бинов</br>
Если `@Condition` стоит над классом верхним (например с аннотацией `@Component`) то отработает по 3 раза для каждого такого класса</br>
Если `@Condition` прописана в стартере, то 2</br>
Если `@Condition` прописан внутри конфигурации, то 1 раз</br></br>

* В своей `@Condition` аннотации стоит учитывать и писать свое кеширование

## `@ConditionalOnProperty`
1. Создаем класс с аннотацией `@ConfigurationProperties("ворон")`
```
@ConfigurationProperties("ворон")
public class IronProperties {
  public List<String> getКуда() {
    return куда;
  }

  public void setКуда(List<String> куда) {
    this.куда = куда;
  }

  List<String> куда;
}
```

2. В конфигурационном файле разрешаем скан аннотаций c помощью аннотации `@EnableConfigurationProperties`</br>
чтобы наш бин появился внутри контекста приложения, к которому стартер подключается
```
@Configuration
@EnableConfigurationProperties(IronProperties.class)
public class IronConfiguration {

  @Bean
  @ConditionOnProduction
  public RavenListener ravenListener () {
    return new RavenListener();
  }
}
```

* Если условие `@ConditionalOnProperty` не выполняется, то условие `@ConditionOnProduction` даже не будет проверяться

## `@ConditionalOnMissingBean`
Если мы хотим чтобы бин создавался только в том, случае если такого бина еще нет

## Аннотация `@ConditionalOnProperty` не Repeatable
1. В аннотацию можно передать несколько параметров</br>
Но для всех параметров должно быть одной значение
2. Решение - добавить свой Condition который будет наследоваться от `AllNestedConditions` `AnyNestedConditions`
```
public class OnRavenCondition extends AllNestedConditions {
  public OnRavenCondition() {
    super(ConfigurationPhase.REGISTER_BEAN);
  }

  @ConditionalOnProperty("ворон.куда")
  public static class R {}

  @ConditionalOnProperty(value = "ворон.вкл", havingValue = "true")
  public static class C {}
}
```
