package org.bouncycastle.crypto;

public abstract class l
  implements c, m
{
  private final c a;
  
  protected l(c paramc)
  {
    this.a = paramc;
  }
  
  public int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    int i = paramInt1 + paramInt2;
    if (i <= paramArrayOfByte1.length)
    {
      if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
      {
        while (paramInt1 < i)
        {
          paramArrayOfByte2[paramInt3] = e(paramArrayOfByte1[paramInt1]);
          paramInt3++;
          paramInt1++;
        }
        return paramInt2;
      }
      throw new OutputLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too small");
  }
  
  protected abstract byte e(byte paramByte);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */