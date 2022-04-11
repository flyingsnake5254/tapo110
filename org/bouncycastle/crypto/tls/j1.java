package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.a;

class j1
  implements i1
{
  final byte[] a;
  c0 b;
  
  j1(byte[] paramArrayOfByte, c0 paramc0)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramArrayOfByte.length >= 1) && (paramArrayOfByte.length <= 32))
      {
        this.a = a.g(paramArrayOfByte);
        this.b = paramc0;
        return;
      }
      throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
    }
    throw new IllegalArgumentException("'sessionID' cannot be null");
  }
  
  public byte[] a()
  {
    try
    {
      byte[] arrayOfByte = this.a;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean b()
  {
    try
    {
      c0 localc0 = this.b;
      boolean bool;
      if (localc0 != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public c0 c()
  {
    try
    {
      c0 localc0 = this.b;
      if (localc0 == null) {
        localc0 = null;
      } else {
        localc0 = localc0.b();
      }
      return localc0;
    }
    finally {}
  }
  
  public void invalidate()
  {
    try
    {
      c0 localc0 = this.b;
      if (localc0 != null)
      {
        localc0.a();
        this.b = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\j1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */