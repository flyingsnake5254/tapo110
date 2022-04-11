package org.apache.commons.lang.text;

import java.util.Arrays;

public abstract class c
{
  private static final c a = new a(',');
  private static final c b = new a('\t');
  private static final c c = new a(' ');
  private static final c d = new b(" \t\n\r\f".toCharArray());
  private static final c e = new d();
  private static final c f = new a('\'');
  private static final c g = new a('"');
  private static final c h = new b("'\"".toCharArray());
  private static final c i = new c();
  
  public static c c()
  {
    return d;
  }
  
  public int a(char[] paramArrayOfChar, int paramInt)
  {
    return b(paramArrayOfChar, paramInt, 0, paramArrayOfChar.length);
  }
  
  public abstract int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3);
  
  static final class a
    extends c
  {
    private final char j;
    
    a(char paramChar)
    {
      this.j = ((char)paramChar);
    }
    
    public int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.j == paramArrayOfChar[paramInt1]) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      return paramInt1;
    }
  }
  
  static final class b
    extends c
  {
    private final char[] j;
    
    b(char[] paramArrayOfChar)
    {
      paramArrayOfChar = (char[])paramArrayOfChar.clone();
      this.j = paramArrayOfChar;
      Arrays.sort(paramArrayOfChar);
    }
    
    public int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (Arrays.binarySearch(this.j, paramArrayOfChar[paramInt1]) >= 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      return paramInt1;
    }
  }
  
  static final class c
    extends c
  {
    public int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      return 0;
    }
  }
  
  static final class d
    extends c
  {
    public int b(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramArrayOfChar[paramInt1] <= ' ') {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      return paramInt1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\text\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */