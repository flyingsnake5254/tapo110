package com.google.common.base;

public final class c
{
  public static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence1.length();
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if (i != paramCharSequence2.length()) {
      return false;
    }
    int j = 0;
    while (j < i)
    {
      char c1 = paramCharSequence1.charAt(j);
      char c2 = paramCharSequence2.charAt(j);
      if (c1 != c2)
      {
        int k = b(c1);
        if ((k >= 26) || (k != b(c2))) {}
      }
      else
      {
        j++;
        continue;
      }
      return false;
    }
    return true;
  }
  
  private static int b(char paramChar)
  {
    return (char)((paramChar | 0x20) - 'a');
  }
  
  public static boolean c(char paramChar)
  {
    boolean bool;
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean d(char paramChar)
  {
    boolean bool;
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static String e(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++) {
      if (d(paramString.charAt(j)))
      {
        paramString = paramString.toCharArray();
        while (j < i)
        {
          char c = paramString[j];
          if (d(c)) {
            paramString[j] = ((char)(char)(c ^ 0x20));
          }
          j++;
        }
        return String.valueOf(paramString);
      }
    }
    return paramString;
  }
  
  public static char f(char paramChar)
  {
    char c1 = paramChar;
    if (c(paramChar))
    {
      char c2 = (char)(paramChar ^ 0x20);
      c1 = c2;
    }
    return c1;
  }
  
  public static String g(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++) {
      if (c(paramString.charAt(j)))
      {
        paramString = paramString.toCharArray();
        while (j < i)
        {
          char c = paramString[j];
          if (c(c)) {
            paramString[j] = ((char)(char)(c ^ 0x20));
          }
          j++;
        }
        return String.valueOf(paramString);
      }
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */