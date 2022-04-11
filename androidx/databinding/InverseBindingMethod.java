package androidx.databinding;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface InverseBindingMethod
{
  String attribute();
  
  String event() default "";
  
  String method() default "";
  
  Class type();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\InverseBindingMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */