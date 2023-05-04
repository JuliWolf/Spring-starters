package com.ironstarter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional({ OnRavenCondition.class })
public @interface ConditionalOnRaven {
}
