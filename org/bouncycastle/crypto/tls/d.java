package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Vector;

public abstract class d
  implements x0
{
  protected int a;
  protected Vector b;
  protected p0 c;
  
  protected d(int paramInt, Vector paramVector)
  {
    this.a = paramInt;
    this.b = paramVector;
  }
  
  public void a(p0 paramp0)
  {
    this.c = paramp0;
    paramp0 = paramp0.a();
    int i;
    if (m1.L(paramp0))
    {
      if (this.b != null) {
        break label175;
      }
      i = this.a;
      if (i != 1) {
        if (i != 3)
        {
          if (i == 5) {
            break label156;
          }
          if (i != 7) {
            if (i == 9) {
              break label156;
            }
          }
        }
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        throw new IllegalStateException("unsupported key exchange algorithm");
      }
    case 16: 
    case 17: 
      paramp0 = m1.x();
      break;
      paramp0 = m1.w();
      break;
    case 15: 
    case 18: 
    case 19: 
      label156:
      paramp0 = m1.y();
      this.b = paramp0;
      break label175;
      if (this.b != null) {
        break label176;
      }
    }
    label175:
    return;
    label176:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supported_signature_algorithms not allowed for ");
    localStringBuilder.append(paramp0);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void d()
    throws IOException
  {}
  
  public void f()
    throws IOException
  {
    if (!k()) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void g(h paramh)
    throws IOException
  {}
  
  public abstract boolean k();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */