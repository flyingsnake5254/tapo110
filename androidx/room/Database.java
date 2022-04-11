package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Database
{
  Class<?>[] entities();
  
  boolean exportSchema() default true;
  
  int version();
  
  Class<?>[] views() default {};
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Database.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */