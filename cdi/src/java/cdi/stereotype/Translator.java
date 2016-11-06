package cdi.stereotype;

import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Secure
@Named
@Singleton
@Stereotype
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
public @interface Translator {
}
