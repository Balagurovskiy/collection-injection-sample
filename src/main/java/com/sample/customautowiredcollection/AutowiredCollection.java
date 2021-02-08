package com.sample.customautowiredcollection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AutowiredCollection {
	Class[] value();
}
