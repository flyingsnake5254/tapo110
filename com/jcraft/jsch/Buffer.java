package com.jcraft.jsch;

public class Buffer
{
  byte[] buffer;
  int index;
  int s;
  final byte[] tmp = new byte[4];
  
  public Buffer()
  {
    this(20480);
  }
  
  public Buffer(int paramInt)
  {
    this.buffer = new byte[paramInt];
    this.index = 0;
    this.s = 0;
  }
  
  public Buffer(byte[] paramArrayOfByte)
  {
    this.buffer = paramArrayOfByte;
    this.index = 0;
    this.s = 0;
  }
  
  static Buffer fromBytes(byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length * 4;
    int j = 0;
    for (int k = 0; k < paramArrayOfByte.length; k++) {
      i += paramArrayOfByte[k].length;
    }
    Buffer localBuffer = new Buffer(i);
    for (k = j; k < paramArrayOfByte.length; k++) {
      localBuffer.putString(paramArrayOfByte[k]);
    }
    return localBuffer;
  }
  
  void checkFreeSize(int paramInt)
  {
    int i = this.index;
    paramInt = paramInt + i + 128;
    byte[] arrayOfByte1 = this.buffer;
    if (arrayOfByte1.length < paramInt)
    {
      int j = arrayOfByte1.length * 2;
      if (j >= paramInt) {
        paramInt = j;
      }
      byte[] arrayOfByte2 = new byte[paramInt];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
      this.buffer = arrayOfByte2;
    }
  }
  
  public int getByte()
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.s;
    this.s = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int getByte(int paramInt)
  {
    int i = this.s;
    this.s = (paramInt + i);
    return i;
  }
  
  public void getByte(byte[] paramArrayOfByte)
  {
    getByte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  void getByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.buffer, this.s, paramArrayOfByte, paramInt1, paramInt2);
    this.s += paramInt2;
  }
  
  byte[][] getBytes(int paramInt, String paramString)
    throws JSchException
  {
    byte[][] arrayOfByte = new byte[paramInt][];
    int i = 0;
    while (i < paramInt)
    {
      int j = getInt();
      if (getLength() >= j)
      {
        arrayOfByte[i] = new byte[j];
        getByte(arrayOfByte[i]);
        i++;
      }
      else
      {
        throw new JSchException(paramString);
      }
    }
    return arrayOfByte;
  }
  
  byte getCommand()
  {
    return this.buffer[5];
  }
  
  public int getInt()
  {
    return getShort() << 16 & 0xFFFF0000 | getShort() & 0xFFFF;
  }
  
  public int getLength()
  {
    return this.index - this.s;
  }
  
  public long getLong()
  {
    return (getInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & getInt();
  }
  
  public byte[] getMPInt()
  {
    int i = getInt();
    int j;
    if (i >= 0)
    {
      j = i;
      if (i <= 8192) {}
    }
    else
    {
      j = 8192;
    }
    byte[] arrayOfByte = new byte[j];
    getByte(arrayOfByte, 0, j);
    return arrayOfByte;
  }
  
  public byte[] getMPIntBits()
  {
    int i = (getInt() + 7) / 8;
    byte[] arrayOfByte1 = new byte[i];
    getByte(arrayOfByte1, 0, i);
    byte[] arrayOfByte2 = arrayOfByte1;
    if ((arrayOfByte1[0] & 0x80) != 0)
    {
      arrayOfByte2 = new byte[i + 1];
      arrayOfByte2[0] = ((byte)0);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, i);
    }
    return arrayOfByte2;
  }
  
  public int getOffSet()
  {
    return this.s;
  }
  
  int getShort()
  {
    return getByte() << 8 & 0xFF00 | getByte() & 0xFF;
  }
  
  public byte[] getString()
  {
    int i = getInt();
    int j;
    if (i >= 0)
    {
      j = i;
      if (i <= 262144) {}
    }
    else
    {
      j = 262144;
    }
    byte[] arrayOfByte = new byte[j];
    getByte(arrayOfByte, 0, j);
    return arrayOfByte;
  }
  
  byte[] getString(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = getInt();
    paramArrayOfInt1[0] = getByte(i);
    paramArrayOfInt2[0] = i;
    return this.buffer;
  }
  
  public long getUInt()
  {
    return (getByte() << 8 & 0xFF00 | getByte() & 0xFF) << 16 & 0xFFFFFFFFFFFF0000 | (getByte() << 8 & 0xFF00 | getByte() & 0xFF) & 0xFFFF;
  }
  
  public void putByte(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.index;
    this.index = (i + 1);
    arrayOfByte[i] = ((byte)paramByte);
  }
  
  public void putByte(byte[] paramArrayOfByte)
  {
    putByte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void putByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.index, paramInt2);
    this.index += paramInt2;
  }
  
  public void putInt(int paramInt)
  {
    byte[] arrayOfByte = this.tmp;
    arrayOfByte[0] = ((byte)(byte)(paramInt >>> 24));
    arrayOfByte[1] = ((byte)(byte)(paramInt >>> 16));
    arrayOfByte[2] = ((byte)(byte)(paramInt >>> 8));
    arrayOfByte[3] = ((byte)(byte)paramInt);
    System.arraycopy(arrayOfByte, 0, this.buffer, this.index, 4);
    this.index += 4;
  }
  
  public void putLong(long paramLong)
  {
    byte[] arrayOfByte = this.tmp;
    arrayOfByte[0] = ((byte)(byte)(int)(paramLong >>> 56));
    arrayOfByte[1] = ((byte)(byte)(int)(paramLong >>> 48));
    arrayOfByte[2] = ((byte)(byte)(int)(paramLong >>> 40));
    arrayOfByte[3] = ((byte)(byte)(int)(paramLong >>> 32));
    System.arraycopy(arrayOfByte, 0, this.buffer, this.index, 4);
    arrayOfByte = this.tmp;
    arrayOfByte[0] = ((byte)(byte)(int)(paramLong >>> 24));
    arrayOfByte[1] = ((byte)(byte)(int)(paramLong >>> 16));
    arrayOfByte[2] = ((byte)(byte)(int)(paramLong >>> 8));
    arrayOfByte[3] = ((byte)(byte)(int)paramLong);
    System.arraycopy(arrayOfByte, 0, this.buffer, this.index + 4, 4);
    this.index += 8;
  }
  
  public void putMPInt(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if ((paramArrayOfByte[0] & 0x80) != 0)
    {
      putInt(i + 1);
      putByte((byte)0);
    }
    else
    {
      putInt(i);
    }
    putByte(paramArrayOfByte);
  }
  
  void putPad(int paramInt)
  {
    while (paramInt > 0)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.index;
      this.index = (i + 1);
      arrayOfByte[i] = ((byte)0);
      paramInt--;
    }
  }
  
  public void putString(byte[] paramArrayOfByte)
  {
    putString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void putString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    putInt(paramInt2);
    putByte(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    this.index = 0;
    this.s = 0;
  }
  
  void rewind()
  {
    this.s = 0;
  }
  
  public void setOffSet(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void shift()
  {
    int i = this.s;
    if (i == 0) {
      return;
    }
    byte[] arrayOfByte = this.buffer;
    System.arraycopy(arrayOfByte, i, arrayOfByte, 0, this.index - i);
    this.index -= this.s;
    this.s = 0;
  }
  
  void skip(int paramInt)
  {
    this.index += paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */