package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class v
{
  private final InputStream a;
  private final int b;
  private final byte[][] c;
  
  public v(InputStream paramInputStream)
  {
    this(paramInputStream, y1.c(paramInputStream));
  }
  
  public v(InputStream paramInputStream, int paramInt)
  {
    this.a = paramInputStream;
    this.b = paramInt;
    this.c = new byte[11][];
  }
  
  private void e(boolean paramBoolean)
  {
    InputStream localInputStream = this.a;
    if ((localInputStream instanceof t1)) {
      ((t1)localInputStream).g(paramBoolean);
    }
  }
  
  e a(int paramInt)
    throws IOException
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt == 17) {
            return new h0(this);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown BER object encountered: 0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          throw new ASN1Exception(localStringBuilder.toString());
        }
        return new f0(this);
      }
      return new p0(this);
    }
    return new d0(this);
  }
  
  public e b()
    throws IOException
  {
    int i = this.a.read();
    if (i == -1) {
      return null;
    }
    boolean bool = false;
    e(false);
    int j = i.u(this.a, i);
    if ((i & 0x20) != 0) {
      bool = true;
    }
    int k = i.s(this.a, this.b);
    if (k < 0)
    {
      if (bool)
      {
        localObject = new v(new t1(this.a, this.b), this.b);
        if ((i & 0x40) != 0) {
          return new a0(j, (v)localObject);
        }
        if ((i & 0x80) != 0) {
          return new j0(true, j, (v)localObject);
        }
        return ((v)localObject).a(j);
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    Object localObject = new r1(this.a, k);
    if ((i & 0x40) != 0) {
      return new l0(bool, j, ((r1)localObject).e());
    }
    if ((i & 0x80) != 0) {
      return new j0(bool, j, new v((InputStream)localObject));
    }
    if (bool)
    {
      if (j != 4)
      {
        if (j != 8)
        {
          if (j != 16)
          {
            if (j == 17) {
              return new e1(new v((InputStream)localObject));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" encountered");
            throw new IOException(((StringBuilder)localObject).toString());
          }
          return new c1(new v((InputStream)localObject));
        }
        return new p0(new v((InputStream)localObject));
      }
      return new d0(new v((InputStream)localObject));
    }
    if (j != 4) {
      try
      {
        localObject = i.g(j, (r1)localObject, this.c);
        return (e)localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new ASN1Exception("corrupted stream detected", localIllegalArgumentException);
      }
    }
    return new y0(localIllegalArgumentException);
  }
  
  q c(boolean paramBoolean, int paramInt)
    throws IOException
  {
    if (!paramBoolean) {
      return new g1(false, paramInt, new x0(((r1)this.a).e()));
    }
    Object localObject = d();
    if ((this.a instanceof t1))
    {
      if (((f)localObject).c() == 1) {
        localObject = new i0(true, paramInt, ((f)localObject).b(0));
      } else {
        localObject = new i0(false, paramInt, b0.a((f)localObject));
      }
      return (q)localObject;
    }
    if (((f)localObject).c() == 1) {
      localObject = new g1(true, paramInt, ((f)localObject).b(0));
    } else {
      localObject = new g1(false, paramInt, q0.a((f)localObject));
    }
    return (q)localObject;
  }
  
  f d()
    throws IOException
  {
    f localf = new f();
    for (;;)
    {
      Object localObject = b();
      if (localObject == null) {
        break;
      }
      if ((localObject instanceof s1)) {
        localObject = ((s1)localObject).b();
      } else {
        localObject = ((e)localObject).c();
      }
      localf.a((e)localObject);
    }
    return localf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */