package org.greenrobot.greendao.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
public @interface Keep {}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\annotation\Keep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */