package b.d.d0.g2;

public class a
  extends c
{
  private short c;
  private byte d;
  private byte e;
  private short f;
  
  public a(byte paramByte1, byte paramByte2, short paramShort, byte paramByte3)
  {
    this(paramByte1, paramByte2, paramShort, paramByte3, (byte)0, (short)0);
  }
  
  public a(byte paramByte1, byte paramByte2, short paramShort1, byte paramByte3, byte paramByte4, short paramShort2)
  {
    super(paramByte1, paramByte2);
    this.c = ((short)paramShort1);
    this.d = ((byte)paramByte3);
    this.e = ((byte)paramByte4);
    this.f = ((short)paramShort2);
  }
  
  public a(c paramc, byte[] paramArrayOfByte)
  {
    super(paramc.a(), paramc.b());
    this.c = b.d.d0.f2.a.d(paramArrayOfByte, 0);
    this.d = ((byte)paramArrayOfByte[2]);
    this.e = ((byte)paramArrayOfByte[3]);
    this.f = b.d.d0.f2.a.d(paramArrayOfByte, 4);
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(super.c(), 0, arrayOfByte, 0, 2);
    System.arraycopy(b.d.d0.f2.a.b(this.c), 0, arrayOfByte, 2, 2);
    arrayOfByte[4] = ((byte)this.d);
    arrayOfByte[5] = ((byte)this.e);
    System.arraycopy(b.d.d0.f2.a.b(this.f), 0, arrayOfByte, 6, 2);
    return arrayOfByte;
  }
  
  public byte d()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */