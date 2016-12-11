package com.apijerseygradlemongo.config.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author eloi
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectableProperties {
}