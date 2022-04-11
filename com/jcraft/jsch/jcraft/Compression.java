package com.jcraft.jsch.jcraft;

import com.jcraft.jzlib.ZStream;
import java.io.PrintStream;

public class Compression
  implements com.jcraft.jsch.Compression
{
  private static final int BUF_SIZE = 4096;
  private final int buffer_margin = 52;
  private byte[] inflated_buf;
  private ZStream stream = new ZStream();
  private byte[] tmpbuf = new byte['က'];
  private int type;
  
  public byte[] compress(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    this.stream.next_in = paramArrayOfByte;
    this.stream.next_in_index = paramInt;
    this.stream.avail_in = (paramArrayOfInt[0] - paramInt);
    int i;
    Object localObject;
    do
    {
      this.stream.next_out = this.tmpbuf;
      this.stream.next_out_index = 0;
      this.stream.avail_out = 4096;
      i = this.stream.deflate(1);
      if (i != 0)
      {
        PrintStream localPrintStream = System.err;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("compress: deflate returnd ");
        ((StringBuilder)localObject).append(i);
        localPrintStream.println(((StringBuilder)localObject).toString());
        localObject = paramArrayOfByte;
        i = paramInt;
      }
      else
      {
        int j = 4096 - this.stream.avail_out;
        int k = paramArrayOfByte.length;
        i = paramInt + j;
        int m = i + 52;
        localObject = paramArrayOfByte;
        if (k < m)
        {
          localObject = new byte[m * 2];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
        }
        System.arraycopy(this.tmpbuf, 0, localObject, paramInt, j);
      }
      paramArrayOfByte = (byte[])localObject;
      paramInt = i;
    } while (this.stream.avail_out == 0);
    paramArrayOfInt[0] = i;
    return (byte[])localObject;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.stream.deflateInit(paramInt2);
      this.type = 1;
    }
    else if (paramInt1 == 0)
    {
      this.stream.inflateInit();
      this.inflated_buf = new byte['က'];
      this.type = 0;
    }
  }
  
  public byte[] uncompress(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    this.stream.next_in = paramArrayOfByte;
    this.stream.next_in_index = paramInt;
    this.stream.avail_in = paramArrayOfInt[0];
    int i = 0;
    byte[] arrayOfByte;
    for (;;)
    {
      this.stream.next_out = this.tmpbuf;
      this.stream.next_out_index = 0;
      this.stream.avail_out = 4096;
      int j = this.stream.inflate(1);
      if (j == -5) {
        break;
      }
      if (j != 0)
      {
        paramArrayOfByte = System.err;
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("uncompress: inflate returnd ");
        paramArrayOfInt.append(j);
        paramArrayOfByte.println(paramArrayOfInt.toString());
        return null;
      }
      j = this.inflated_buf.length;
      int k = i + 4096;
      if (j < k - this.stream.avail_out)
      {
        int m = this.inflated_buf.length * 2;
        j = m;
        if (m < k - this.stream.avail_out) {
          j = k - this.stream.avail_out;
        }
        arrayOfByte = new byte[j];
        System.arraycopy(this.inflated_buf, 0, arrayOfByte, 0, i);
        this.inflated_buf = arrayOfByte;
      }
      System.arraycopy(this.tmpbuf, 0, this.inflated_buf, i, 4096 - this.stream.avail_out);
      i += 4096 - this.stream.avail_out;
      paramArrayOfInt[0] = i;
    }
    if (i > paramArrayOfByte.length - paramInt)
    {
      arrayOfByte = new byte[i + paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
      System.arraycopy(this.inflated_buf, 0, arrayOfByte, paramInt, i);
      paramArrayOfByte = arrayOfByte;
    }
    else
    {
      System.arraycopy(this.inflated_buf, 0, paramArrayOfByte, paramInt, i);
    }
    paramArrayOfInt[0] = i;
    return paramArrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jcraft\Compression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */