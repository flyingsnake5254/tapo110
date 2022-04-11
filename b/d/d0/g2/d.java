package b.d.d0.g2;

public class d
{
  private c a;
  private byte[] b;
  
  public d(c paramc, byte[] paramArrayOfByte)
  {
    this.a = paramc;
    this.b = paramArrayOfByte;
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.a = new c(paramArrayOfByte[0], paramArrayOfByte[1]);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
    this.b = arrayOfByte;
    System.arraycopy(paramArrayOfByte, 2, arrayOfByte, 0, paramArrayOfByte.length - 2);
  }
  
  public c a()
  {
    return this.a;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte1 = this.a.c();
    byte[] arrayOfByte2 = this.b;
    byte[] arrayOfByte3 = arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte3 = arrayOfByte1;
      if (arrayOfByte2.length > 0)
      {
        arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
        arrayOfByte2 = this.b;
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
      }
    }
    return arrayOfByte3;
  }
  
  public void d(c paramc)
  {
    this.a = paramc;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */