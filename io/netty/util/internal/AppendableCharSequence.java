package io.netty.util.internal;

import java.util.Arrays;

public final class AppendableCharSequence
  implements CharSequence, Appendable
{
  private char[] chars;
  private int pos;
  
  public AppendableCharSequence(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.chars = new char[paramInt];
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (length: >= 1)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private AppendableCharSequence(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar.length >= 1)
    {
      this.chars = paramArrayOfChar;
      this.pos = paramArrayOfChar.length;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length: ");
    localStringBuilder.append(paramArrayOfChar.length);
    localStringBuilder.append(" (length: >= 1)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static char[] expand(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar.length;
    int j;
    do
    {
      j = i << 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (paramInt1 > j);
    char[] arrayOfChar = new char[j];
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt2);
    return arrayOfChar;
    throw new IllegalStateException();
  }
  
  public AppendableCharSequence append(char paramChar)
  {
    int i = this.pos;
    char[] arrayOfChar1 = this.chars;
    if (i == arrayOfChar1.length)
    {
      char[] arrayOfChar2 = new char[arrayOfChar1.length << 1];
      this.chars = arrayOfChar2;
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, arrayOfChar1.length);
    }
    arrayOfChar1 = this.chars;
    i = this.pos;
    this.pos = (i + 1);
    arrayOfChar1[i] = ((char)paramChar);
    return this;
  }
  
  public AppendableCharSequence append(CharSequence paramCharSequence)
  {
    return append(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public AppendableCharSequence append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence.length() >= paramInt2)
    {
      int i = paramInt2 - paramInt1;
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int k = this.pos;
      if (i > j - k) {
        this.chars = expand(arrayOfChar, k + i, k);
      }
      j = paramInt1;
      if ((paramCharSequence instanceof AppendableCharSequence))
      {
        System.arraycopy(((AppendableCharSequence)paramCharSequence).chars, paramInt1, this.chars, this.pos, i);
        this.pos += i;
        return this;
      }
      while (j < paramInt2)
      {
        arrayOfChar = this.chars;
        paramInt1 = this.pos;
        this.pos = (paramInt1 + 1);
        arrayOfChar[paramInt1] = paramCharSequence.charAt(j);
        j++;
      }
      return this;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public char charAt(int paramInt)
  {
    if (paramInt <= this.pos) {
      return this.chars[paramInt];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public char charAtUnsafe(int paramInt)
  {
    return this.chars[paramInt];
  }
  
  public int length()
  {
    return this.pos;
  }
  
  public void reset()
  {
    this.pos = 0;
  }
  
  public void setLength(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.pos))
    {
      this.pos = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (length: >= 0, <= ");
    localStringBuilder.append(this.pos);
    localStringBuilder.append(')');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public AppendableCharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return new AppendableCharSequence(Math.min(16, this.chars.length));
    }
    return new AppendableCharSequence(Arrays.copyOfRange(this.chars, paramInt1, paramInt2));
  }
  
  public String subStringUnsafe(int paramInt1, int paramInt2)
  {
    return new String(this.chars, paramInt1, paramInt2 - paramInt1);
  }
  
  public String substring(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    paramInt2 = this.pos;
    if ((paramInt1 <= paramInt2) && (i <= paramInt2)) {
      return new String(this.chars, paramInt1, i);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String toString()
  {
    return new String(this.chars, 0, this.pos);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\AppendableCharSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */