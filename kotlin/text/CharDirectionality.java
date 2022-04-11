package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.v.e;

public enum CharDirectionality
{
  public static final b Companion = new b(null);
  private static final f directionalityMap$delegate = h.b(a.c);
  private final int value;
  
  static
  {
    CharDirectionality localCharDirectionality1 = new CharDirectionality("UNDEFINED", 0, -1);
    UNDEFINED = localCharDirectionality1;
    CharDirectionality localCharDirectionality2 = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
    LEFT_TO_RIGHT = localCharDirectionality2;
    CharDirectionality localCharDirectionality3 = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
    RIGHT_TO_LEFT = localCharDirectionality3;
    CharDirectionality localCharDirectionality4 = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
    RIGHT_TO_LEFT_ARABIC = localCharDirectionality4;
    CharDirectionality localCharDirectionality5 = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
    EUROPEAN_NUMBER = localCharDirectionality5;
    CharDirectionality localCharDirectionality6 = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
    EUROPEAN_NUMBER_SEPARATOR = localCharDirectionality6;
    CharDirectionality localCharDirectionality7 = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
    EUROPEAN_NUMBER_TERMINATOR = localCharDirectionality7;
    CharDirectionality localCharDirectionality8 = new CharDirectionality("ARABIC_NUMBER", 7, 6);
    ARABIC_NUMBER = localCharDirectionality8;
    CharDirectionality localCharDirectionality9 = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
    COMMON_NUMBER_SEPARATOR = localCharDirectionality9;
    CharDirectionality localCharDirectionality10 = new CharDirectionality("NONSPACING_MARK", 9, 8);
    NONSPACING_MARK = localCharDirectionality10;
    CharDirectionality localCharDirectionality11 = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
    BOUNDARY_NEUTRAL = localCharDirectionality11;
    CharDirectionality localCharDirectionality12 = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
    PARAGRAPH_SEPARATOR = localCharDirectionality12;
    CharDirectionality localCharDirectionality13 = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
    SEGMENT_SEPARATOR = localCharDirectionality13;
    CharDirectionality localCharDirectionality14 = new CharDirectionality("WHITESPACE", 13, 12);
    WHITESPACE = localCharDirectionality14;
    CharDirectionality localCharDirectionality15 = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
    OTHER_NEUTRALS = localCharDirectionality15;
    CharDirectionality localCharDirectionality16 = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
    LEFT_TO_RIGHT_EMBEDDING = localCharDirectionality16;
    CharDirectionality localCharDirectionality17 = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
    LEFT_TO_RIGHT_OVERRIDE = localCharDirectionality17;
    CharDirectionality localCharDirectionality18 = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
    RIGHT_TO_LEFT_EMBEDDING = localCharDirectionality18;
    CharDirectionality localCharDirectionality19 = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
    RIGHT_TO_LEFT_OVERRIDE = localCharDirectionality19;
    CharDirectionality localCharDirectionality20 = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
    POP_DIRECTIONAL_FORMAT = localCharDirectionality20;
    $VALUES = new CharDirectionality[] { localCharDirectionality1, localCharDirectionality2, localCharDirectionality3, localCharDirectionality4, localCharDirectionality5, localCharDirectionality6, localCharDirectionality7, localCharDirectionality8, localCharDirectionality9, localCharDirectionality10, localCharDirectionality11, localCharDirectionality12, localCharDirectionality13, localCharDirectionality14, localCharDirectionality15, localCharDirectionality16, localCharDirectionality17, localCharDirectionality18, localCharDirectionality19, localCharDirectionality20 };
  }
  
  private CharDirectionality(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  static final class a
    extends Lambda
    implements a<Map<Integer, ? extends CharDirectionality>>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final Map<Integer, CharDirectionality> a()
    {
      CharDirectionality[] arrayOfCharDirectionality = CharDirectionality.values();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(e.b(b0.a(arrayOfCharDirectionality.length), 16));
      int i = arrayOfCharDirectionality.length;
      for (int j = 0; j < i; j++)
      {
        CharDirectionality localCharDirectionality = arrayOfCharDirectionality[j];
        localLinkedHashMap.put(Integer.valueOf(localCharDirectionality.getValue()), localCharDirectionality);
      }
      return localLinkedHashMap;
    }
  }
  
  public static final class b {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\CharDirectionality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */