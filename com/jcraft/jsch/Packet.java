package com.jcraft.jsch;

public class Packet
{
  private static Random random;
  byte[] ba4 = new byte[4];
  Buffer buffer;
  
  public Packet(Buffer paramBuffer)
  {
    this.buffer = paramBuffer;
  }
  
  static void setRandom(Random paramRandom)
  {
    random = paramRandom;
  }
  
  Buffer getBuffer()
  {
    return this.buffer;
  }
  
  void padding(int paramInt)
  {
    ??? = this.buffer;
    int i = ((Buffer)???).index;
    int j = -i & paramInt - 1;
    int k = j;
    if (j < paramInt) {
      k = j + paramInt;
    }
    paramInt = i + k - 4;
    Object localObject2 = this.ba4;
    localObject2[0] = ((byte)(byte)(paramInt >>> 24));
    localObject2[1] = ((byte)(byte)(paramInt >>> 16));
    localObject2[2] = ((byte)(byte)(paramInt >>> 8));
    localObject2[3] = ((byte)(byte)paramInt);
    System.arraycopy(localObject2, 0, ((Buffer)???).buffer, 0, 4);
    this.buffer.buffer[4] = ((byte)(byte)k);
    synchronized (random)
    {
      localObject2 = random;
      Buffer localBuffer = this.buffer;
      ((Random)localObject2).fill(localBuffer.buffer, localBuffer.index, k);
      this.buffer.skip(k);
      return;
    }
  }
  
  public void reset()
  {
    this.buffer.index = 5;
  }
  
  int shift(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + 5 + 9;
    int j = -i & paramInt2 - 1;
    int k = j;
    if (j < paramInt2) {
      k = j + paramInt2;
    }
    k = k + i + paramInt3 + 32;
    Object localObject1 = this.buffer;
    Object localObject2 = ((Buffer)localObject1).buffer;
    paramInt3 = localObject2.length;
    paramInt2 = ((Buffer)localObject1).index;
    if (paramInt3 < k + paramInt2 - 5 - 9 - paramInt1)
    {
      localObject1 = new byte[paramInt2 + k - 5 - 9 - paramInt1];
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      this.buffer.buffer = ((byte[])localObject1);
    }
    localObject1 = this.buffer;
    localObject2 = ((Buffer)localObject1).buffer;
    System.arraycopy(localObject2, i, localObject2, k, ((Buffer)localObject1).index - 5 - 9 - paramInt1);
    localObject2 = this.buffer;
    ((Buffer)localObject2).index = 10;
    ((Buffer)localObject2).putInt(paramInt1);
    this.buffer.index = i;
    return k;
  }
  
  void unshift(byte paramByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.buffer.buffer;
    System.arraycopy(localObject, paramInt2, localObject, 14, paramInt3);
    localObject = this.buffer;
    ((Buffer)localObject).buffer[5] = ((byte)paramByte);
    ((Buffer)localObject).index = 6;
    ((Buffer)localObject).putInt(paramInt1);
    this.buffer.putInt(paramInt3);
    this.buffer.index = (paramInt3 + 5 + 9);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Packet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */