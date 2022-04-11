package org.bouncycastle.asn1;

import java.io.InputStream;

abstract class w1
  extends InputStream
{
  protected final InputStream c;
  private int d;
  
  w1(InputStream paramInputStream, int paramInt)
  {
    this.c = paramInputStream;
    this.d = paramInt;
  }
  
  int a()
  {
    return this.d;
  }
  
  protected void c(boolean paramBoolean)
  {
    InputStream localInputStream = this.c;
    if ((localInputStream instanceof t1)) {
      ((t1)localInputStream).g(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\w1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */