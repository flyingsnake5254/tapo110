package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

public class b
  implements Closeable, Flushable
{
  private static final String[] c = new String[''];
  private static final String[] d;
  private final Writer f;
  private boolean p0;
  private boolean p1;
  private String p2;
  private boolean p3;
  private int[] q = new int[32];
  private int x = 0;
  private String y;
  private String z;
  
  static
  {
    for (int i = 0; i <= 31; i++) {
      c[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
    }
    String[] arrayOfString = c;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    arrayOfString = (String[])arrayOfString.clone();
    d = arrayOfString;
    arrayOfString[60] = "\\u003c";
    arrayOfString[62] = "\\u003e";
    arrayOfString[38] = "\\u0026";
    arrayOfString[61] = "\\u003d";
    arrayOfString[39] = "\\u0027";
  }
  
  public b(Writer paramWriter)
  {
    z(6);
    this.z = ":";
    this.p3 = true;
    Objects.requireNonNull(paramWriter, "out == null");
    this.f = paramWriter;
  }
  
  private void A(int paramInt)
  {
    this.q[(this.x - 1)] = paramInt;
  }
  
  private void F(String paramString)
    throws IOException
  {
    String[] arrayOfString;
    if (this.p1) {
      arrayOfString = d;
    } else {
      arrayOfString = c;
    }
    this.f.write(34);
    int i = paramString.length();
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      int m = paramString.charAt(j);
      String str2;
      if (m < 128)
      {
        String str1 = arrayOfString[m];
        str2 = str1;
        if (str1 == null)
        {
          n = k;
          break label150;
        }
      }
      else if (m == 8232)
      {
        str2 = "\\u2028";
      }
      else
      {
        n = k;
        if (m != 8233) {
          break label150;
        }
        str2 = "\\u2029";
      }
      if (k < j) {
        this.f.write(paramString, k, j - k);
      }
      this.f.write(str2);
      n = j + 1;
      label150:
      j++;
    }
    if (k < i) {
      this.f.write(paramString, k, i - k);
    }
    this.f.write(34);
  }
  
  private void L()
    throws IOException
  {
    if (this.p2 != null)
    {
      a();
      F(this.p2);
      this.p2 = null;
    }
  }
  
  private void a()
    throws IOException
  {
    int i = y();
    if (i == 5) {
      this.f.write(44);
    } else {
      if (i != 3) {
        break label37;
      }
    }
    v();
    A(4);
    return;
    label37:
    throw new IllegalStateException("Nesting problem.");
  }
  
  private void c()
    throws IOException
  {
    int i = y();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6) {
            if (i == 7)
            {
              if (!this.p0) {
                throw new IllegalStateException("JSON must have only one top-level value.");
              }
            }
            else {
              throw new IllegalStateException("Nesting problem.");
            }
          }
          A(7);
        }
        else
        {
          this.f.append(this.z);
          A(5);
        }
      }
      else
      {
        this.f.append(',');
        v();
      }
    }
    else
    {
      A(2);
      v();
    }
  }
  
  private b i(int paramInt1, int paramInt2, char paramChar)
    throws IOException
  {
    int i = y();
    if ((i != paramInt2) && (i != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.p2 == null)
    {
      this.x -= 1;
      if (i == paramInt2) {
        v();
      }
      this.f.write(paramChar);
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Dangling name: ");
    localStringBuilder.append(this.p2);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void v()
    throws IOException
  {
    if (this.y == null) {
      return;
    }
    this.f.write(10);
    int i = this.x;
    for (int j = 1; j < i; j++) {
      this.f.write(this.y);
    }
  }
  
  private b x(int paramInt, char paramChar)
    throws IOException
  {
    c();
    z(paramInt);
    this.f.write(paramChar);
    return this;
  }
  
  private int y()
  {
    int i = this.x;
    if (i != 0) {
      return this.q[(i - 1)];
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  private void z(int paramInt)
  {
    int i = this.x;
    int[] arrayOfInt = this.q;
    if (i == arrayOfInt.length) {
      this.q = Arrays.copyOf(arrayOfInt, i * 2);
    }
    arrayOfInt = this.q;
    i = this.x;
    this.x = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public final void B(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
  }
  
  public final void C(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.y = null;
      this.z = ":";
    }
    else
    {
      this.y = paramString;
      this.z = ": ";
    }
  }
  
  public final void D(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public final void E(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  public b G(long paramLong)
    throws IOException
  {
    L();
    c();
    this.f.write(Long.toString(paramLong));
    return this;
  }
  
  public b H(Boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == null) {
      return w();
    }
    L();
    c();
    Writer localWriter = this.f;
    if (paramBoolean.booleanValue()) {
      paramBoolean = "true";
    } else {
      paramBoolean = "false";
    }
    localWriter.write(paramBoolean);
    return this;
  }
  
  public b I(Number paramNumber)
    throws IOException
  {
    if (paramNumber == null) {
      return w();
    }
    L();
    Object localObject = paramNumber.toString();
    if ((!this.p0) && ((((String)localObject).equals("-Infinity")) || (((String)localObject).equals("Infinity")) || (((String)localObject).equals("NaN"))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Numeric values must be finite, but was ");
      ((StringBuilder)localObject).append(paramNumber);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    c();
    this.f.append((CharSequence)localObject);
    return this;
  }
  
  public b J(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return w();
    }
    L();
    c();
    F(paramString);
    return this;
  }
  
  public b K(boolean paramBoolean)
    throws IOException
  {
    L();
    c();
    Writer localWriter = this.f;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localWriter.write(str);
    return this;
  }
  
  public void close()
    throws IOException
  {
    this.f.close();
    int i = this.x;
    if ((i <= 1) && ((i != 1) || (this.q[(i - 1)] == 7)))
    {
      this.x = 0;
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public b e()
    throws IOException
  {
    L();
    return x(1, '[');
  }
  
  public void flush()
    throws IOException
  {
    if (this.x != 0)
    {
      this.f.flush();
      return;
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  public b g()
    throws IOException
  {
    L();
    return x(3, '{');
  }
  
  public b j()
    throws IOException
  {
    return i(1, 2, ']');
  }
  
  public b k()
    throws IOException
  {
    return i(3, 5, '}');
  }
  
  public final boolean l()
  {
    return this.p3;
  }
  
  public final boolean s()
  {
    return this.p1;
  }
  
  public boolean t()
  {
    return this.p0;
  }
  
  public b u(String paramString)
    throws IOException
  {
    Objects.requireNonNull(paramString, "name == null");
    if (this.p2 == null)
    {
      if (this.x != 0)
      {
        this.p2 = paramString;
        return this;
      }
      throw new IllegalStateException("JsonWriter is closed.");
    }
    throw new IllegalStateException();
  }
  
  public b w()
    throws IOException
  {
    if (this.p2 != null) {
      if (this.p3)
      {
        L();
      }
      else
      {
        this.p2 = null;
        return this;
      }
    }
    c();
    this.f.write("null");
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\stream\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */