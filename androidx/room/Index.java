package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({})
public @interface Index
{
  String name() default "";
  
  boolean unique() default false;
  
  String[] value();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Index.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */