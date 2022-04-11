package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface Update
{
  Class<?> entity() default Object.class;
  
  @OnConflictStrategy
  int onConflict() default 3;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Update.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */