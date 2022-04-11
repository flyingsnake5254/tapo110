package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
public @interface ChecksSdkIntAtLeast
{
  int api() default -1;
  
  String codename() default "";
  
  int lambda() default -1;
  
  int parameter() default -1;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\annotation\ChecksSdkIntAtLeast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */