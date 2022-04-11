package b.d.d0.g2;

import b.d.d0.f2.a;

public class f
  extends e
{
  private short e;
  private byte f;
  private byte g;
  private int h;
  private int i;
  
  public f(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, short paramShort, byte paramByte5, byte paramByte6, int paramInt1, int paramInt2)
  {
    super(paramByte1, paramByte2, paramByte3, paramByte4);
    this.e = ((short)paramShort);
    this.f = ((byte)paramByte5);
    this.g = ((byte)paramByte6);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public f(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte[] paramArrayOfByte)
  {
    super(paramByte1, paramByte2, paramByte3, paramByte4);
    this.e = a.d(paramArrayOfByte, 0);
    this.f = ((byte)paramArrayOfByte[2]);
    this.g = ((byte)paramArrayOfByte[3]);
    this.h = a.c(paramArrayOfByte, 4);
    this.i = a.c(paramArrayOfByte, 8);
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(super.b(), 0, arrayOfByte, 0, 4);
    System.arraycopy(a.b(this.e), 0, arrayOfByte, 4, 2);
    arrayOfByte[6] = ((byte)this.f);
    arrayOfByte[7] = ((byte)this.g);
    System.arraycopy(a.a(this.h), 0, arrayOfByte, 8, 4);
    System.arraycopy(a.a(this.i), 0, arrayOfByte, 12, 4);
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public byte d()
  {
    return this.g;
  }
  
  public short e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public void g(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */