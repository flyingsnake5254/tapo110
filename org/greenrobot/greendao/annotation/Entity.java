package org.greenrobot.greendao.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Entity
{
  boolean active() default false;
  
  boolean createInDb() default true;
  
  boolean generateConstructors() default true;
  
  boolean generateGettersSetters() default true;
  
  Index[] indexes() default {};
  
  String nameInDb() default "";
  
  Class protobuf() default void.class;
  
  String schema() default "default";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\annotation\Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */