package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.b0;
import org.bouncycastle.util.a;

public class b
  implements c
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  private int d;
  private c e = null;
  private boolean f;
  
  public b(c paramc)
  {
    this.e = paramc;
    int i = paramc.getBlockSize();
    this.d = i;
    this.a = new byte[i];
    this.b = new byte[i];
    this.c = new byte[i];
  }
  
  private int c(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.d;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      byte[] arrayOfByte = this.c;
      int j = 0;
      System.arraycopy(paramArrayOfByte1, paramInt1, arrayOfByte, 0, i);
      i = this.e.d(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
      for (paramInt1 = j; paramInt1 < this.d; paramInt1++)
      {
        j = paramInt2 + paramInt1;
        paramArrayOfByte2[j] = ((byte)(byte)(paramArrayOfByte2[j] ^ this.b[paramInt1]));
      }
      paramArrayOfByte1 = this.b;
      this.b = this.c;
      this.c = paramArrayOfByte1;
      return i;
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private int e(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.d + paramInt1 <= paramArrayOfByte1.length)
    {
      for (int i = 0; i < this.d; i++)
      {
        byte[] arrayOfByte = this.b;
        arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] ^ paramArrayOfByte1[(paramInt1 + i)]));
      }
      paramInt1 = this.e.d(this.b, 0, paramArrayOfByte2, paramInt2);
      paramArrayOfByte1 = this.b;
      System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return paramInt1;
    }
    throw new DataLengthException("input buffer too short");
  }
  
  public void a(boolean paramBoolean, e parame)
    throws IllegalArgumentException
  {
    boolean bool = this.f;
    this.f = paramBoolean;
    Object localObject;
    if ((parame instanceof b0))
    {
      localObject = (b0)parame;
      parame = ((b0)localObject).a();
      if (parame.length == this.d)
      {
        System.arraycopy(parame, 0, this.a, 0, parame.length);
        reset();
        if (((b0)localObject).b() != null)
        {
          parame = this.e;
          localObject = ((b0)localObject).b();
        }
        else
        {
          if (bool == paramBoolean) {
            break label142;
          }
          throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
      }
      else
      {
        throw new IllegalArgumentException("initialisation vector must be the same length as block size");
      }
    }
    else
    {
      reset();
      if (parame == null) {
        break label137;
      }
      c localc = this.e;
      localObject = parame;
      parame = localc;
    }
    parame.a(paramBoolean, (e)localObject);
    label137:
    if (bool == paramBoolean) {
      label142:
      return;
    }
    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e.b());
    localStringBuilder.append("/CBC");
    return localStringBuilder.toString();
  }
  
  public int d(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.f) {
      paramInt1 = e(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    } else {
      paramInt1 = c(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    return paramInt1;
  }
  
  public int getBlockSize()
  {
    return this.e.getBlockSize();
  }
  
  public void reset()
  {
    byte[] arrayOfByte = this.a;
    System.arraycopy(arrayOfByte, 0, this.b, 0, arrayOfByte.length);
    a.u(this.c, (byte)0);
    this.e.reset();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */