package org.bouncycastle.asn1;

public class x1
{
  private String a;
  private int b;
  
  public x1(String paramString)
  {
    this.a = paramString;
    this.b = 0;
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.b != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String b()
  {
    int i = this.b;
    if (i == -1) {
      return null;
    }
    i = this.a.indexOf('.', i);
    if (i == -1)
    {
      str = this.a.substring(this.b);
      this.b = -1;
      return str;
    }
    String str = this.a.substring(this.b, i);
    this.b = (i + 1);
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */