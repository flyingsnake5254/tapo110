package org.apache.commons.lang.text;

public class b
  implements Cloneable
{
  protected char[] c;
  protected int d;
  private String f;
  
  public b()
  {
    this(32);
  }
  
  public b(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 32;
    }
    this.c = new char[i];
  }
  
  public b a(char paramChar)
  {
    j(l() + 1);
    char[] arrayOfChar = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfChar[i] = ((char)paramChar);
    return this;
  }
  
  public b b(double paramDouble)
  {
    return f(String.valueOf(paramDouble));
  }
  
  public b c(int paramInt)
  {
    return f(String.valueOf(paramInt));
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    b localb = (b)super.clone();
    char[] arrayOfChar1 = new char[this.c.length];
    localb.c = arrayOfChar1;
    char[] arrayOfChar2 = this.c;
    System.arraycopy(arrayOfChar2, 0, arrayOfChar1, 0, arrayOfChar2.length);
    return localb;
  }
  
  public b d(long paramLong)
  {
    return f(String.valueOf(paramLong));
  }
  
  public b e(Object paramObject)
  {
    if (paramObject == null) {
      return h();
    }
    return f(paramObject.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return k((b)paramObject);
    }
    return false;
  }
  
  public b f(String paramString)
  {
    if (paramString == null) {
      return h();
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = l();
      j(j + i);
      paramString.getChars(0, i, this.c, j);
      this.d += i;
    }
    return this;
  }
  
  public b g(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return h();
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfChar.length))
    {
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfChar.length))
      {
        if (paramInt2 > 0)
        {
          int i = l();
          j(i + paramInt2);
          System.arraycopy(paramArrayOfChar, paramInt1, this.c, i, paramInt2);
          this.d += paramInt2;
        }
        return this;
      }
      paramArrayOfChar = new StringBuffer();
      paramArrayOfChar.append("Invalid length: ");
      paramArrayOfChar.append(paramInt2);
      throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
    }
    paramArrayOfChar = new StringBuffer();
    paramArrayOfChar.append("Invalid startIndex: ");
    paramArrayOfChar.append(paramInt2);
    throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
  }
  
  public b h()
  {
    String str = this.f;
    if (str == null) {
      return this;
    }
    return f(str);
  }
  
  public int hashCode()
  {
    char[] arrayOfChar = this.c;
    int i = this.d - 1;
    int j = 0;
    while (i >= 0)
    {
      j = j * 31 + arrayOfChar[i];
      i--;
    }
    return j;
  }
  
  public b j(int paramInt)
  {
    char[] arrayOfChar1 = this.c;
    if (paramInt > arrayOfChar1.length)
    {
      char[] arrayOfChar2 = new char[paramInt * 2];
      this.c = arrayOfChar2;
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, this.d);
    }
    return this;
  }
  
  public boolean k(b paramb)
  {
    if (this == paramb) {
      return true;
    }
    int i = this.d;
    if (i != paramb.d) {
      return false;
    }
    char[] arrayOfChar = this.c;
    paramb = paramb.c;
    i--;
    while (i >= 0)
    {
      if (arrayOfChar[i] != paramb[i]) {
        return false;
      }
      i--;
    }
    return true;
  }
  
  public int l()
  {
    return this.d;
  }
  
  public String toString()
  {
    return new String(this.c, 0, this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\text\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */