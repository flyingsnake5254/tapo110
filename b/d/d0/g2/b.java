package b.d.d0.g2;

import b.d.d0.f2.a;
import com.tplink.tmp.enumerate.EnumTMPAppV2PacketType;

public class b
  extends c
{
  private short c;
  private byte d;
  private byte e;
  private short f;
  private int g;
  private int h;
  private int i;
  
  public b(byte paramByte1, byte paramByte2, short paramShort1, byte paramByte3, byte paramByte4, short paramShort2, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramByte1, paramByte2);
    this.c = ((short)paramShort1);
    this.d = ((byte)paramByte3);
    this.e = ((byte)paramByte4);
    this.f = ((short)paramShort2);
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
  }
  
  public b(c paramc, byte[] paramArrayOfByte)
  {
    super(paramc.a(), paramc.b());
    this.c = a.d(paramArrayOfByte, 0);
    this.d = ((byte)paramArrayOfByte[2]);
    this.e = ((byte)paramArrayOfByte[3]);
    this.f = a.d(paramArrayOfByte, 4);
    this.g = a.c(paramArrayOfByte, 6);
    this.h = a.c(paramArrayOfByte, 10);
    this.i = a.c(paramArrayOfByte, 14);
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[20];
    System.arraycopy(super.c(), 0, arrayOfByte, 0, 2);
    System.arraycopy(a.b(this.c), 0, arrayOfByte, 2, 2);
    arrayOfByte[4] = ((byte)this.d);
    arrayOfByte[5] = ((byte)this.e);
    System.arraycopy(a.b(this.f), 0, arrayOfByte, 6, 2);
    System.arraycopy(a.a(this.g), 0, arrayOfByte, 8, 4);
    System.arraycopy(a.a(this.h), 0, arrayOfByte, 12, 4);
    System.arraycopy(a.a(this.i), 0, arrayOfByte, 16, 4);
    return arrayOfByte;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public byte e()
  {
    return this.e;
  }
  
  public byte f()
  {
    return this.d;
  }
  
  public EnumTMPAppV2PacketType g()
  {
    int j = f();
    if (j != 2)
    {
      if (j != 3)
      {
        if (j != 4)
        {
          if (j != 5) {
            return EnumTMPAppV2PacketType.TYPE_UNKNOWN;
          }
          return EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK;
        }
        return EnumTMPAppV2PacketType.TYPE_DATA_PULL;
      }
      return EnumTMPAppV2PacketType.TYPE_DATA_PUSH_ACK;
    }
    return EnumTMPAppV2PacketType.TYPE_DATA_PUSH;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */