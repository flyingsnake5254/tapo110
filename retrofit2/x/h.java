package retrofit2.x;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface h
{
  boolean hasBody() default false;
  
  String method();
  
  String path() default "";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\x\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */