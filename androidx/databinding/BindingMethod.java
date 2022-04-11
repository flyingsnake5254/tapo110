package androidx.databinding;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface BindingMethod
{
  String attribute();
  
  String method();
  
  Class type();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\BindingMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */