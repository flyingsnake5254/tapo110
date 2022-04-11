package pub.devrel.easypermissions;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface a
{
  int value();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */