package org.greenrobot.greendao.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface JoinProperty
{
  String name();
  
  String referencedName();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\annotation\JoinProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */