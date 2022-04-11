package com.tplink.libmediakit.media.audioprocess;

import java.nio.ByteBuffer;

public class a
  implements d
{
  public long a;
  public long b;
  public boolean c;
  public byte[] d;
  public ByteBuffer e;
  private int f = 8000;
  private int g = 16;
  private String h;
  
  public a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = true;
    this.d = null;
  }
  
  public a(String paramString, long paramLong, ByteBuffer paramByteBuffer)
  {
    this.h = paramString;
    this.a = paramLong;
    this.e = paramByteBuffer;
    this.d = paramByteBuffer.array();
    this.c = true;
  }
  
  public a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.h = paramString;
    this.a = paramLong;
    this.d = paramArrayOfByte;
    this.c = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public long e()
  {
    return this.b;
  }
  
  public ByteBuffer f()
  {
    if (this.e == null)
    {
      byte[] arrayOfByte = this.d;
      if (arrayOfByte != null) {
        this.e = ByteBuffer.wrap(arrayOfByte);
      } else {
        return null;
      }
    }
    return this.e;
  }
  
  public void g(ByteBuffer paramByteBuffer)
  {
    this.e = paramByteBuffer;
    this.d = paramByteBuffer.array();
  }
  
  public void h(long paramLong)
  {
    this.a = paramLong;
  }
  
  public long j()
  {
    return this.a;
  }
  
  public a k()
  {
    a locala = new a();
    locala.a = this.a;
    locala.b = this.b;
    locala.c = this.c;
    byte[] arrayOfByte1 = this.d;
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      locala.d = arrayOfByte2;
    }
    locala.g = this.g;
    locala.f = this.f;
    locala.h = this.h;
    return locala;
  }
  
  public a l()
  {
    a locala = new a();
    locala.a = this.a;
    locala.b = this.b;
    locala.c = this.c;
    locala.g = this.g;
    locala.f = this.f;
    locala.h = this.h;
    return locala;
  }
  
  public int m()
  {
    return n(this.f, this.g);
  }
  
  public int n(int paramInt1, int paramInt2)
  {
    return r() / p(paramInt1, paramInt2);
  }
  
  public String o()
  {
    return this.h;
  }
  
  public int p(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 / 8) / 1000;
  }
  
  public void q(String paramString)
  {
    this.h = paramString;
  }
  
  public int r()
  {
    byte[] arrayOfByte = this.d;
    int i;
    if (arrayOfByte != null) {
      i = arrayOfByte.length;
    } else {
      i = 0;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */