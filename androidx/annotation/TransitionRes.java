package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD})
public @interface TransitionRes {}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\annotation\TransitionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */