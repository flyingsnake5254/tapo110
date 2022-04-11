package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface InspectableProperty
{
  int attributeId() default 0;
  
  EnumEntry[] enumMapping() default {};
  
  FlagEntry[] flagMapping() default {};
  
  boolean hasAttributeId() default true;
  
  String name() default "";
  
  ValueType valueType() default ValueType.INFERRED;
  
  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface EnumEntry
  {
    String name();
    
    int value();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface FlagEntry
  {
    int mask() default 0;
    
    String name();
    
    int target();
  }
  
  public static enum ValueType
  {
    static
    {
      ValueType localValueType1 = new ValueType("NONE", 0);
      NONE = localValueType1;
      ValueType localValueType2 = new ValueType("INFERRED", 1);
      INFERRED = localValueType2;
      ValueType localValueType3 = new ValueType("INT_ENUM", 2);
      INT_ENUM = localValueType3;
      ValueType localValueType4 = new ValueType("INT_FLAG", 3);
      INT_FLAG = localValueType4;
      ValueType localValueType5 = new ValueType("COLOR", 4);
      COLOR = localValueType5;
      ValueType localValueType6 = new ValueType("GRAVITY", 5);
      GRAVITY = localValueType6;
      ValueType localValueType7 = new ValueType("RESOURCE_ID", 6);
      RESOURCE_ID = localValueType7;
      $VALUES = new ValueType[] { localValueType1, localValueType2, localValueType3, localValueType4, localValueType5, localValueType6, localValueType7 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\annotation\InspectableProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */