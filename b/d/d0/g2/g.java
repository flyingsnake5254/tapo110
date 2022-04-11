package b.d.d0.g2;

public class g
{
  private e a;
  private byte[] b;
  
  public g() {}
  
  public g(e parame)
  {
    this.a = parame;
  }
  
  public g(e parame, byte[] paramArrayOfByte)
  {
    this.a = parame;
    this.b = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  public e b()
  {
    return this.a;
  }
  
  public short c()
  {
    byte[] arrayOfByte = this.b;
    int i;
    if (arrayOfByte == null) {
      i = 0;
    } else {
      i = arrayOfByte.length;
    }
    return (short)i;
  }
  
  public byte[] d()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      localObject1 = new byte[4];
    } else {
      localObject1 = ((e)localObject1).b();
    }
    byte[] arrayOfByte = this.b;
    Object localObject2 = localObject1;
    if (arrayOfByte != null)
    {
      localObject2 = localObject1;
      if (arrayOfByte.length > 0)
      {
        localObject2 = new byte[localObject1.length + arrayOfByte.length];
        System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
        arrayOfByte = this.b;
        System.arraycopy(arrayOfByte, 0, localObject2, localObject1.length, arrayOfByte.length);
      }
    }
    return (byte[])localObject2;
  }
  
  public void e(e parame)
  {
    this.a = parame;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\g2\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */