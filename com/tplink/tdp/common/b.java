package com.tplink.tdp.common;

import b.d.w.e.a;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.zip.CRC32;

public class b
{
  private byte a;
  private byte b;
  private short c;
  private short d;
  private byte e;
  private byte f;
  private int g;
  private int h;
  protected byte[] i = new byte[0];
  
  public b(byte paramByte1, short paramShort, byte paramByte2, String paramString)
  {
    this.a = ((byte)paramByte1);
    this.b = ((byte)0);
    this.c = ((short)paramShort);
    if (paramString != null)
    {
      paramString = paramString.getBytes();
      this.d = ((short)(short)paramString.length);
    }
    else
    {
      this.d = ((short)0);
      paramString = null;
    }
    this.e = ((byte)paramByte2);
    this.f = ((byte)0);
    this.g = c();
    this.h = 1516993677;
    this.i = new byte[this.d + 16];
    b();
    if (paramString != null) {
      System.arraycopy(paramString, 0, this.i, 16, this.d);
    }
    a();
  }
  
  public b(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer.get();
    this.b = paramByteBuffer.get();
    this.c = k(paramByteBuffer);
    this.d = k(paramByteBuffer);
    this.e = paramByteBuffer.get();
    this.f = paramByteBuffer.get();
    this.g = j(paramByteBuffer);
    this.h = j(paramByteBuffer);
  }
  
  private void a()
  {
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(this.i);
    int j = (int)localCRC32.getValue();
    this.h = j;
    System.arraycopy(a.c(j), 0, this.i, 12, 4);
  }
  
  private void b()
  {
    byte[] arrayOfByte1 = this.i;
    byte[] arrayOfByte2 = new byte[1];
    arrayOfByte2[0] = ((byte)this.a);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 1);
    arrayOfByte2[0] = ((byte)this.b);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 1, 1);
    System.arraycopy(a.d(this.c), 0, arrayOfByte1, 2, 2);
    arrayOfByte2 = a.d(this.d);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 4, 2);
    arrayOfByte2[0] = ((byte)this.e);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 6, 1);
    arrayOfByte2[0] = ((byte)this.f);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 7, 1);
    System.arraycopy(a.c(this.g), 0, arrayOfByte1, 8, 4);
    System.arraycopy(a.c(1516993677), 0, arrayOfByte1, 12, 4);
  }
  
  private int c()
  {
    return new Random().nextInt(268435456) + 0;
  }
  
  public static int j(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    return a.g(arrayOfByte);
  }
  
  public static short k(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[2];
    paramByteBuffer.get(arrayOfByte);
    return a.h(arrayOfByte);
  }
  
  public int d()
  {
    return this.h;
  }
  
  public byte[] e()
  {
    return this.i;
  }
  
  public short f()
  {
    return this.d;
  }
  
  public byte g()
  {
    return this.f;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public byte i()
  {
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */