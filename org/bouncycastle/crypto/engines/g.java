package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.a0;

public class g
  implements m
{
  private byte[] a = null;
  private int b = 0;
  private int c = 0;
  private byte[] d = null;
  
  private void b(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
    int i = 0;
    this.b = 0;
    this.c = 0;
    if (this.a == null) {
      this.a = new byte['Ā'];
    }
    for (int j = 0; j < 256; j++) {
      this.a[j] = ((byte)(byte)j);
    }
    int k = 0;
    int m = 0;
    for (j = i; j < 256; j++)
    {
      i = paramArrayOfByte[k];
      byte[] arrayOfByte = this.a;
      m = (i & 0xFF) + arrayOfByte[j] + m & 0xFF;
      i = arrayOfByte[j];
      arrayOfByte[j] = ((byte)arrayOfByte[m]);
      arrayOfByte[m] = ((byte)i);
      k = (k + 1) % paramArrayOfByte.length;
    }
  }
  
  public void a(boolean paramBoolean, e parame)
  {
    if ((parame instanceof a0))
    {
      parame = ((a0)parame).a();
      this.d = parame;
      b(parame);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC4 init - ");
    localStringBuilder.append(parame.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
    {
      if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
      {
        for (int i = 0; i < paramInt2; i++)
        {
          int j = this.b + 1 & 0xFF;
          this.b = j;
          byte[] arrayOfByte = this.a;
          int k = arrayOfByte[j] + this.c & 0xFF;
          this.c = k;
          int m = arrayOfByte[j];
          arrayOfByte[j] = ((byte)arrayOfByte[k]);
          arrayOfByte[k] = ((byte)m);
          m = paramArrayOfByte1[(i + paramInt1)];
          paramArrayOfByte2[(i + paramInt3)] = ((byte)(byte)(arrayOfByte[(arrayOfByte[j] + arrayOfByte[k] & 0xFF)] ^ m));
        }
        return paramInt2;
      }
      throw new OutputLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */