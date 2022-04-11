package androidx.room;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface Relation
{
  Junction associateBy() default @Junction(Object.class);
  
  Class<?> entity() default Object.class;
  
  String entityColumn();
  
  String parentColumn();
  
  String[] projection() default {};
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Relation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */