package butterknife;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindFont
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface TypefaceStyle {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\butterknife\BindFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */