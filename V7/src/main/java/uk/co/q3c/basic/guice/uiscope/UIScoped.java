package uk.co.q3c.basic.guice.uiscope;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.ScopeAnnotation;

@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@ScopeAnnotation
public @interface UIScoped {

}