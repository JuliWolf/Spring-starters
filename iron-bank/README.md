# Spring boot

## Зависимости
1. Spring boot помогает решить проблему конфликта версий
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
1. 