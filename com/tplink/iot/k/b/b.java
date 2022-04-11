package com.tplink.iot.k.b;

import b.d.w.e.a;
import java.util.zip.CRC32;

public class b
{
  private byte a;
  private byte b;
  private short c;
  private byte d;
  private byte e;
  private short f;
  private int g;
  private int h;
  protected byte[] i = new byte[0];
  
  public b(byte paramByte1, byte paramByte2, int paramInt, String paramString)
  {
    this(paramByte1, (short)0, paramByte2, paramInt, paramString);
  }
  
  public b(byte paramByte1, short paramShort, byte paramByte2, int paramInt, String paramString)
  {
    this.a = ((byte)paramByte1);
    this.b = ((byte)0);
    this.f = ((short)paramShort);
    if (paramString != null)
    {
      paramString = paramString.getBytes();
      this.c = ((short)(short)paramString.length);
    }
    else
    {
      this.c = ((short)0);
      paramString = null;
    }
    this.d = ((byte)paramByte2);
    this.e = ((byte)0);
    this.g = c(paramInt);
    this.h = -1371942843;
    this.i = new byte[this.c + 16];
    b();
    if (paramString != null) {
      System.arraycopy(paramString, 0, this.i, 16, this.c);
    }
    a();
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
    arrayOfByte2 = a.d(this.c);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 2, 2);
    arrayOfByte2[0] = ((byte)this.d);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 4, 1);
    arrayOfByte2[0] = ((byte)this.e);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 5, 1);
    System.arraycopy(a.d(this.f), 0, arrayOfByte1, 6, 2);
    System.arraycopy(a.c(this.g), 0, arrayOfByte1, 8, 4);
    System.arraycopy(a.c(-1371942843), 0, arrayOfByte1, 12, 4);
  }
  
  private int c(int paramInt)
  {
    return paramInt + 1;
  }
  
  public byte[] d()
  {
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */