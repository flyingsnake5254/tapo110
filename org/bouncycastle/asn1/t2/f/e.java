package org.bouncycastle.asn1.t2.f;

public class e
{
  private String a;
  private int b;
  private char c;
  private StringBuffer d = new StringBuffer();
  
  public e(String paramString)
  {
    this(paramString, ',');
  }
  
  public e(String paramString, char paramChar)
  {
    this.a = paramString;
    this.b = -1;
    this.c = ((char)paramChar);
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.b != this.a.length()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String b()
  {
    if (this.b == this.a.length()) {
      return null;
    }
    int i = this.b + 1;
    this.d.setLength(0);
    int j = 0;
    int k = 0;
    while (i != this.a.length())
    {
      char c1 = this.a.charAt(i);
      if (c1 == '"')
      {
        m = k;
        if (j == 0) {
          m = k ^ 0x1;
        }
      }
      else
      {
        m = k;
        if (j == 0) {
          if (k != 0)
          {
            m = k;
          }
          else
          {
            if (c1 == '\\')
            {
              this.d.append(c1);
              m = 1;
              break label164;
            }
            if (c1 == this.c) {
              break;
            }
            this.d.append(c1);
            m = j;
            break label164;
          }
        }
      }
      this.d.append(c1);
      j = 0;
      k = m;
      int m = j;
      label164:
      i++;
      j = m;
    }
    this.b = i;
    return this.d.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */