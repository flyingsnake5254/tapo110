package androidx.databinding;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE})
public @interface InverseBindingMethods
{
  InverseBindingMethod[] value();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\InverseBindingMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */