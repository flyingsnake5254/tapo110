package b.d.e0.h;

public abstract class f
{
  private final int a;
  private final int b;
  
  protected f(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public abstract byte[] b(int paramInt, byte[] paramArrayOfByte);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String toString()
  {
    int i = this.a;
    byte[] arrayOfByte = new byte[i];
    StringBuilder localStringBuilder = new StringBuilder(this.b * (i + 1));
    for (i = 0; i < this.b; i++)
    {
      arrayOfByte = b(i, arrayOfByte);
      for (int j = 0; j < this.a; j++)
      {
        int k = arrayOfByte[j] & 0xFF;
        int m;
        if (k < 64)
        {
          k = 35;
          m = k;
        }
        else if (k < 128)
        {
          k = 43;
          m = k;
        }
        else if (k < 192)
        {
          k = 46;
          m = k;
        }
        else
        {
          k = 32;
          m = k;
        }
        localStringBuilder.append(m);
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */