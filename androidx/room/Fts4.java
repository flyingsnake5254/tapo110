package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE})
@RequiresApi(16)
public @interface Fts4
{
  Class<?> contentEntity() default Object.class;
  
  String languageId() default "";
  
  FtsOptions.MatchInfo matchInfo() default FtsOptions.MatchInfo.FTS4;
  
  String[] notIndexed() default {};
  
  FtsOptions.Order order() default FtsOptions.Order.ASC;
  
  int[] prefix() default {};
  
  String tokenizer() default "simple";
  
  String[] tokenizerArgs() default {};
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\Fts4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */