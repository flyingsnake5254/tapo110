package com.google.gson.q;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD})
public @interface b
{
  boolean nullSafe() default true;
  
  Class<?> value();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\q\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */