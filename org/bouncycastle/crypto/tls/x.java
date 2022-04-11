package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.util.i;

public final class x
{
  public static final x a = new x(768, "SSL 3.0");
  public static final x b = new x(769, "TLS 1.0");
  public static final x c = new x(770, "TLS 1.1");
  public static final x d = new x(771, "TLS 1.2");
  public static final x e = new x(65279, "DTLS 1.0");
  public static final x f = new x(65277, "DTLS 1.2");
  private int g;
  private String h;
  
  private x(int paramInt, String paramString)
  {
    this.g = (paramInt & 0xFFFF);
    this.h = paramString;
  }
  
  public static x b(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 3) {
      if (paramInt1 == 254) {
        switch (paramInt2)
        {
        }
      }
    }
    for (String str = "DTLS";; str = "TLS")
    {
      return f(paramInt1, paramInt2, str);
      return e;
      throw new TlsFatalAlert((short)47);
      return f;
      throw new TlsFatalAlert((short)47);
      if (paramInt2 == 0) {
        break label115;
      }
      if (paramInt2 == 1) {
        break label111;
      }
      if (paramInt2 == 2) {
        break label107;
      }
      if (paramInt2 == 3) {
        break;
      }
    }
    return d;
    label107:
    return c;
    label111:
    return b;
    label115:
    return a;
  }
  
  private static x f(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    m1.k(paramInt1);
    m1.k(paramInt2);
    paramInt1 = paramInt1 << 8 | paramInt2;
    String str = i.j(Integer.toHexString(0x10000 | paramInt1).substring(1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" 0x");
    localStringBuilder.append(str);
    return new x(paramInt1, localStringBuilder.toString());
  }
  
  public boolean a(x paramx)
  {
    boolean bool;
    if ((paramx != null) && (this.g == paramx.g)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public x c()
  {
    if (!g()) {
      return this;
    }
    if (this == e) {
      return c;
    }
    return d;
  }
  
  public int d()
  {
    return this.g >> 8;
  }
  
  public int e()
  {
    return this.g & 0xFF;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((this != paramObject) && ((!(paramObject instanceof x)) || (!a((x)paramObject)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean g()
  {
    boolean bool;
    if (d() == 254) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean h(x paramx)
  {
    int i = d();
    int j = paramx.d();
    boolean bool = false;
    if (i != j) {
      return false;
    }
    j = paramx.e() - e();
    if (g() ? j <= 0 : j >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.g;
  }
  
  public boolean i()
  {
    boolean bool;
    if (this == a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */