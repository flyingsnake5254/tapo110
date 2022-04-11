package androidx.annotation.experimental;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface Experimental
{
  Level level() default Level.ERROR;
  
  public static enum Level
  {
    static
    {
      Level localLevel1 = new Level("WARNING", 0);
      WARNING = localLevel1;
      Level localLevel2 = new Level("ERROR", 1);
      ERROR = localLevel2;
      $VALUES = new Level[] { localLevel1, localLevel2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\annotation\experimental\Experimental.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */