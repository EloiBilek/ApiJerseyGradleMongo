package com.apijerseygradlemongo.config.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * @author eloi
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
	@Nonbinding
	String value();
}
