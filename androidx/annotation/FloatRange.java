package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface FloatRange
{
  double from() default Double.NEGATIVE_INFINITY;
  
  boolean fromInclusive() default true;
  
  double to() default Double.POSITIVE_INFINITY;
  
  boolean toInclusive() default true;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\annotation\FloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */