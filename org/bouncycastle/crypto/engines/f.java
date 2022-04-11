package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.w.a0;

public class f
  extends e
{
  private int[] o = null;
  private int[] p = null;
  private int[] q = null;
  private boolean r;
  
  public void a(boolean paramBoolean, org.bouncycastle.crypto.e parame)
  {
    if ((parame instanceof a0))
    {
      parame = ((a0)parame).a();
      if ((parame.length != 24) && (parame.length != 16)) {
        throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
      }
      this.r = paramBoolean;
      localObject = new byte[8];
      System.arraycopy(parame, 0, localObject, 0, 8);
      this.o = e(paramBoolean, (byte[])localObject);
      localObject = new byte[8];
      System.arraycopy(parame, 8, localObject, 0, 8);
      this.p = e(paramBoolean ^ true, (byte[])localObject);
      if (parame.length == 24)
      {
        localObject = new byte[8];
        System.arraycopy(parame, 16, localObject, 0, 8);
        this.q = e(paramBoolean, (byte[])localObject);
      }
      else
      {
        this.q = this.o;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid parameter passed to DESede init - ");
    ((StringBuilder)localObject).append(parame.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public String b()
  {
    return "DESede";
  }
  
  public int d(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = this.o;
    if (arrayOfInt != null)
    {
      if (paramInt1 + 8 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 8 <= paramArrayOfByte2.length)
        {
          byte[] arrayOfByte = new byte[8];
          if (this.r)
          {
            c(arrayOfInt, paramArrayOfByte1, paramInt1, arrayOfByte, 0);
            c(this.p, arrayOfByte, 0, arrayOfByte, 0);
            c(this.q, arrayOfByte, 0, paramArrayOfByte2, paramInt2);
          }
          else
          {
            c(this.q, paramArrayOfByte1, paramInt1, arrayOfByte, 0);
            c(this.p, arrayOfByte, 0, arrayOfByte, 0);
            c(this.o, arrayOfByte, 0, paramArrayOfByte2, paramInt2);
          }
          return 8;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("DESede engine not initialised");
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void reset() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */