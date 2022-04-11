package b.d.d0.g2;

public class c
{
  private byte a;
  private byte b;
  
  public c(byte paramByte1, byte paramByte2)
  {
    this.a = ((byte)paramByte1);
    this.b = ((byte)paramByte2);
  }
  
  public c(byte[] paramArrayOfByte)
  {
    this.a = ((byte)paramArrayOfByte[0]);
    this.b = ((byte)paramArrayOfByte[1]);
  }
  
  public byte a()
  {
    return this.a;
  }
  
  public byte b()
  {
    return this.b;
  }
  
  public byte[] c()
  {
    return new byte[] { this.a, this.b };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */