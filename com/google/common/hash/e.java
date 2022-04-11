package com.google.common.hash;

import com.google.common.base.n;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class e
{
  private static final char[] c = "0123456789abcdef".toCharArray();
  
  static e h(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte);
  }
  
  public abstract byte[] a();
  
  public abstract int b();
  
  public abstract long d();
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof e;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (e)paramObject;
      bool3 = bool2;
      if (f() == ((e)paramObject).f())
      {
        bool3 = bool2;
        if (g((e)paramObject)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public abstract int f();
  
  abstract boolean g(e parame);
  
  public final int hashCode()
  {
    if (f() >= 32) {
      return b();
    }
    byte[] arrayOfByte = i();
    int i = arrayOfByte[0] & 0xFF;
    for (int j = 1; j < arrayOfByte.length; j++) {
      i |= (arrayOfByte[j] & 0xFF) << j * 8;
    }
    return i;
  }
  
  byte[] i()
  {
    return a();
  }
  
  public final String toString()
  {
    byte[] arrayOfByte = i();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int i = arrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfByte[j];
      char[] arrayOfChar = c;
      localStringBuilder.append(arrayOfChar[(k >> 4 & 0xF)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
    }
    return localStringBuilder.toString();
  }
  
  private static final class a
    extends e
    implements Serializable
  {
    final byte[] d;
    
    a(byte[] paramArrayOfByte)
    {
      this.d = ((byte[])n.o(paramArrayOfByte));
    }
    
    public byte[] a()
    {
      return (byte[])this.d.clone();
    }
    
    public int b()
    {
      byte[] arrayOfByte = this.d;
      boolean bool;
      if (arrayOfByte.length >= 4) {
        bool = true;
      } else {
        bool = false;
      }
      n.w(bool, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", arrayOfByte.length);
      arrayOfByte = this.d;
      int i = arrayOfByte[0];
      int j = arrayOfByte[1];
      int k = arrayOfByte[2];
      return (arrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
    }
    
    public long d()
    {
      byte[] arrayOfByte = this.d;
      boolean bool;
      if (arrayOfByte.length >= 8) {
        bool = true;
      } else {
        bool = false;
      }
      n.w(bool, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", arrayOfByte.length);
      return j();
    }
    
    public int f()
    {
      return this.d.length * 8;
    }
    
    boolean g(e parame)
    {
      if (this.d.length != parame.i().length) {
        return false;
      }
      int i = 0;
      boolean bool1 = true;
      for (;;)
      {
        byte[] arrayOfByte = this.d;
        if (i >= arrayOfByte.length) {
          break;
        }
        boolean bool2;
        if (arrayOfByte[i] == parame.i()[i]) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        bool1 &= bool2;
        i++;
      }
      return bool1;
    }
    
    byte[] i()
    {
      return this.d;
    }
    
    public long j()
    {
      long l = this.d[0] & 0xFF;
      for (int i = 1; i < Math.min(this.d.length, 8); i++) {
        l |= (this.d[i] & 0xFF) << i * 8;
      }
      return l;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */