package androidx.versionedparcelable;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public @interface VersionedParcelize
{
  boolean allowSerialization() default false;
  
  int[] deprecatedIds() default {};
  
  Class factory() default void.class;
  
  boolean ignoreParcelables() default false;
  
  boolean isCustom() default false;
  
  String jetifyAs() default "";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\versionedparcelable\VersionedParcelize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */