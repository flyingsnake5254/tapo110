package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Insert
{
  Class<?> entity() default Object.class;
  
  @OnConflictStrategy
  int onConflict() default 3;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Insert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */