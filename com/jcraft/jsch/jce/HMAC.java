package com.jcraft.jsch.jce;

import com.jcraft.jsch.MAC;
import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

abstract class HMAC
  implements MAC
{
  protected String algorithm;
  protected int bsize;
  private Mac mac;
  protected String name;
  private final byte[] tmp = new byte[4];
  
  public void doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      this.mac.doFinal(paramArrayOfByte, paramInt);
    }
    catch (ShortBufferException paramArrayOfByte)
    {
      System.err.println(paramArrayOfByte);
    }
  }
  
  public int getBlockSize()
  {
    return this.bsize;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void init(byte[] paramArrayOfByte)
    throws Exception
  {
    int i = paramArrayOfByte.length;
    int j = this.bsize;
    Object localObject = paramArrayOfByte;
    if (i > j)
    {
      localObject = new byte[j];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, j);
    }
    localObject = new SecretKeySpec((byte[])localObject, this.algorithm);
    paramArrayOfByte = Mac.getInstance(this.algorithm);
    this.mac = paramArrayOfByte;
    paramArrayOfByte.init((Key)localObject);
  }
  
  public void update(int paramInt)
  {
    byte[] arrayOfByte = this.tmp;
    arrayOfByte[0] = ((byte)(byte)(paramInt >>> 24));
    arrayOfByte[1] = ((byte)(byte)(paramInt >>> 16));
    arrayOfByte[2] = ((byte)(byte)(paramInt >>> 8));
    arrayOfByte[3] = ((byte)(byte)paramInt);
    update(arrayOfByte, 0, 4);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.mac.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMAC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */