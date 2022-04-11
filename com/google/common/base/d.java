package com.google.common.base;

public abstract class d
  implements o<Character>
{
  public static d c(char paramChar1, char paramChar2)
  {
    return new b(paramChar1, paramChar2);
  }
  
  public static d e(char paramChar)
  {
    return new c(paramChar);
  }
  
  public static d g()
  {
    return e.d;
  }
  
  private static String h(char paramChar)
  {
    char[] arrayOfChar = new char[6];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 92;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 117;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 0;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0;
    tmp31_26;
    for (int i = 0; i < 4; i++)
    {
      arrayOfChar[(5 - i)] = "0123456789ABCDEF".charAt(paramChar & 0xF);
      paramChar = (char)(paramChar >> '\004');
    }
    return String.copyValueOf(arrayOfChar);
  }
  
  @Deprecated
  public boolean b(Character paramCharacter)
  {
    return f(paramCharacter.charValue());
  }
  
  public int d(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    n.r(paramInt, i);
    while (paramInt < i)
    {
      if (f(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  public abstract boolean f(char paramChar);
  
  static abstract class a
    extends d
  {}
  
  private static final class b
    extends d.a
  {
    private final char c;
    private final char d;
    
    b(char paramChar1, char paramChar2)
    {
      boolean bool;
      if (paramChar2 >= paramChar1) {
        bool = true;
      } else {
        bool = false;
      }
      n.d(bool);
      this.c = ((char)paramChar1);
      this.d = ((char)paramChar2);
    }
    
    public boolean f(char paramChar)
    {
      boolean bool;
      if ((this.c <= paramChar) && (paramChar <= this.d)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CharMatcher.inRange('");
      localStringBuilder.append(d.a(this.c));
      localStringBuilder.append("', '");
      localStringBuilder.append(d.a(this.d));
      localStringBuilder.append("')");
      return localStringBuilder.toString();
    }
  }
  
  private static final class c
    extends d.a
  {
    private final char c;
    
    c(char paramChar)
    {
      this.c = ((char)paramChar);
    }
    
    public boolean f(char paramChar)
    {
      boolean bool;
      if (paramChar == this.c) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CharMatcher.is('");
      localStringBuilder.append(d.a(this.c));
      localStringBuilder.append("')");
      return localStringBuilder.toString();
    }
  }
  
  static abstract class d
    extends d.a
  {
    private final String c;
    
    d(String paramString)
    {
      this.c = ((String)n.o(paramString));
    }
    
    public final String toString()
    {
      return this.c;
    }
  }
  
  private static final class e
    extends d.d
  {
    static final e d = new e();
    
    private e()
    {
      super();
    }
    
    public int d(CharSequence paramCharSequence, int paramInt)
    {
      n.r(paramInt, paramCharSequence.length());
      return -1;
    }
    
    public boolean f(char paramChar)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */