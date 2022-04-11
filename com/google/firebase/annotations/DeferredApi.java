package com.google.firebase.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Inherited
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface DeferredApi {}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\annotations\DeferredApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */