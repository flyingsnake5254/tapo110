package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface ForeignKey
{
  public static final int CASCADE = 5;
  public static final int NO_ACTION = 1;
  public static final int RESTRICT = 2;
  public static final int SET_DEFAULT = 4;
  public static final int SET_NULL = 3;
  
  String[] childColumns();
  
  boolean deferred() default false;
  
  Class<?> entity();
  
  @Action
  int onDelete() default 1;
  
  @Action
  int onUpdate() default 1;
  
  String[] parentColumns();
  
  @Retention(RetentionPolicy.CLASS)
  public static @interface Action {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\ForeignKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */