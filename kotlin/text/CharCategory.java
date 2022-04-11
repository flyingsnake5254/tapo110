package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.v.e;

public enum CharCategory
{
  public static final b Companion = new b(null);
  private static final f categoryMap$delegate = h.b(a.c);
  private final String code;
  private final int value;
  
  static
  {
    CharCategory localCharCategory1 = new CharCategory("UNASSIGNED", 0, 0, "Cn");
    UNASSIGNED = localCharCategory1;
    CharCategory localCharCategory2 = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
    UPPERCASE_LETTER = localCharCategory2;
    CharCategory localCharCategory3 = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
    LOWERCASE_LETTER = localCharCategory3;
    CharCategory localCharCategory4 = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
    TITLECASE_LETTER = localCharCategory4;
    CharCategory localCharCategory5 = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
    MODIFIER_LETTER = localCharCategory5;
    CharCategory localCharCategory6 = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
    OTHER_LETTER = localCharCategory6;
    CharCategory localCharCategory7 = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
    NON_SPACING_MARK = localCharCategory7;
    CharCategory localCharCategory8 = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
    ENCLOSING_MARK = localCharCategory8;
    CharCategory localCharCategory9 = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
    COMBINING_SPACING_MARK = localCharCategory9;
    CharCategory localCharCategory10 = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
    DECIMAL_DIGIT_NUMBER = localCharCategory10;
    CharCategory localCharCategory11 = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
    LETTER_NUMBER = localCharCategory11;
    CharCategory localCharCategory12 = new CharCategory("OTHER_NUMBER", 11, 11, "No");
    OTHER_NUMBER = localCharCategory12;
    CharCategory localCharCategory13 = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
    SPACE_SEPARATOR = localCharCategory13;
    CharCategory localCharCategory14 = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
    LINE_SEPARATOR = localCharCategory14;
    CharCategory localCharCategory15 = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
    PARAGRAPH_SEPARATOR = localCharCategory15;
    CharCategory localCharCategory16 = new CharCategory("CONTROL", 15, 15, "Cc");
    CONTROL = localCharCategory16;
    CharCategory localCharCategory17 = new CharCategory("FORMAT", 16, 16, "Cf");
    FORMAT = localCharCategory17;
    CharCategory localCharCategory18 = new CharCategory("PRIVATE_USE", 17, 18, "Co");
    PRIVATE_USE = localCharCategory18;
    CharCategory localCharCategory19 = new CharCategory("SURROGATE", 18, 19, "Cs");
    SURROGATE = localCharCategory19;
    CharCategory localCharCategory20 = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
    DASH_PUNCTUATION = localCharCategory20;
    CharCategory localCharCategory21 = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
    START_PUNCTUATION = localCharCategory21;
    CharCategory localCharCategory22 = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
    END_PUNCTUATION = localCharCategory22;
    CharCategory localCharCategory23 = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
    CONNECTOR_PUNCTUATION = localCharCategory23;
    CharCategory localCharCategory24 = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
    OTHER_PUNCTUATION = localCharCategory24;
    CharCategory localCharCategory25 = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
    MATH_SYMBOL = localCharCategory25;
    CharCategory localCharCategory26 = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
    CURRENCY_SYMBOL = localCharCategory26;
    CharCategory localCharCategory27 = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
    MODIFIER_SYMBOL = localCharCategory27;
    CharCategory localCharCategory28 = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
    OTHER_SYMBOL = localCharCategory28;
    CharCategory localCharCategory29 = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
    INITIAL_QUOTE_PUNCTUATION = localCharCategory29;
    CharCategory localCharCategory30 = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
    FINAL_QUOTE_PUNCTUATION = localCharCategory30;
    $VALUES = new CharCategory[] { localCharCategory1, localCharCategory2, localCharCategory3, localCharCategory4, localCharCategory5, localCharCategory6, localCharCategory7, localCharCategory8, localCharCategory9, localCharCategory10, localCharCategory11, localCharCategory12, localCharCategory13, localCharCategory14, localCharCategory15, localCharCategory16, localCharCategory17, localCharCategory18, localCharCategory19, localCharCategory20, localCharCategory21, localCharCategory22, localCharCategory23, localCharCategory24, localCharCategory25, localCharCategory26, localCharCategory27, localCharCategory28, localCharCategory29, localCharCategory30 };
  }
  
  private CharCategory(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.code = paramString;
  }
  
  public final boolean contains(char paramChar)
  {
    boolean bool;
    if (Character.getType(paramChar) == this.value) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final String getCode()
  {
    return this.code;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  static final class a
    extends Lambda
    implements a<Map<Integer, ? extends CharCategory>>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final Map<Integer, CharCategory> a()
    {
      CharCategory[] arrayOfCharCategory = CharCategory.values();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(e.b(b0.a(arrayOfCharCategory.length), 16));
      int i = arrayOfCharCategory.length;
      for (int j = 0; j < i; j++)
      {
        CharCategory localCharCategory = arrayOfCharCategory[j];
        localLinkedHashMap.put(Integer.valueOf(localCharCategory.getValue()), localCharCategory);
      }
      return localLinkedHashMap;
    }
  }
  
  public static final class b {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\CharCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */