package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class FixedSecureRandom
  extends SecureRandom
{
  private byte[] _data;
  private int _index;
  private int _intPad;
  
  public FixedSecureRandom(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this(paramBoolean, new byte[][] { paramArrayOfByte });
  }
  
  public FixedSecureRandom(boolean paramBoolean, byte[][] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i != paramArrayOfByte.length) {
      try
      {
        localByteArrayOutputStream.write(paramArrayOfByte[i]);
        i++;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalArgumentException("can't save value array.");
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    this._data = paramArrayOfByte;
    if (paramBoolean) {
      this._intPad = (paramArrayOfByte.length % 4);
    }
  }
  
  public FixedSecureRandom(byte[] paramArrayOfByte)
  {
    this(false, new byte[][] { paramArrayOfByte });
  }
  
  public FixedSecureRandom(byte[][] paramArrayOfByte)
  {
    this(false, paramArrayOfByte);
  }
  
  private int nextValue()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public boolean isExhausted()
  {
    boolean bool;
    if (this._index == this._data.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    System.arraycopy(this._data, this._index, paramArrayOfByte, 0, paramArrayOfByte.length);
    this._index += paramArrayOfByte.length;
  }
  
  public int nextInt()
  {
    int i = nextValue() << 24 | 0x0 | nextValue() << 16;
    int j = this._intPad;
    if (j == 2) {
      this._intPad = (j - 1);
    } else {
      i |= nextValue() << 8;
    }
    j = this._intPad;
    if (j == 1) {
      this._intPad = (j - 1);
    } else {
      i |= nextValue();
    }
    return i;
  }
  
  public long nextLong()
  {
    return nextValue() << 56 | 0L | nextValue() << 48 | nextValue() << 40 | nextValue() << 32 | nextValue() << 24 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\prng\FixedSecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */