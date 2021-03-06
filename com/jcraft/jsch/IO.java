package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

public class IO
{
  InputStream in;
  private boolean in_dontclose = false;
  OutputStream out;
  private boolean out_dontclose = false;
  OutputStream out_ext;
  private boolean out_ext_dontclose = false;
  
  public void close()
  {
    try
    {
      localObject = this.in;
      if ((localObject != null) && (!this.in_dontclose)) {
        ((InputStream)localObject).close();
      }
      this.in = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = this.out_ext;
          if ((localObject != null) && (!this.out_ext_dontclose)) {
            ((OutputStream)localObject).close();
          }
          this.out_ext = null;
          return;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
      }
    }
    out_close();
  }
  
  int getByte()
    throws IOException
  {
    return this.in.read();
  }
  
  void getByte(byte[] paramArrayOfByte)
    throws IOException
  {
    getByte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  void getByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    do
    {
      i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i < 0) {
        break;
      }
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
    return;
    throw new IOException("End of IO Stream Read");
  }
  
  void out_close()
  {
    try
    {
      OutputStream localOutputStream = this.out;
      if ((localOutputStream != null) && (!this.out_dontclose)) {
        localOutputStream.close();
      }
      this.out = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void put(Packet paramPacket)
    throws IOException, SocketException
  {
    OutputStream localOutputStream = this.out;
    paramPacket = paramPacket.buffer;
    localOutputStream.write(paramPacket.buffer, 0, paramPacket.index);
    this.out.flush();
  }
  
  void put(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.out.flush();
  }
  
  void put_ext(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out_ext.write(paramArrayOfByte, paramInt1, paramInt2);
    this.out_ext.flush();
  }
  
  void setExtOutputStream(OutputStream paramOutputStream)
  {
    this.out_ext = paramOutputStream;
  }
  
  void setExtOutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    this.out_ext_dontclose = paramBoolean;
    setExtOutputStream(paramOutputStream);
  }
  
  void setInputStream(InputStream paramInputStream)
  {
    this.in = paramInputStream;
  }
  
  void setInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.in_dontclose = paramBoolean;
    setInputStream(paramInputStream);
  }
  
  void setOutputStream(OutputStream paramOutputStream)
  {
    this.out = paramOutputStream;
  }
  
  void setOutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    this.out_dontclose = paramBoolean;
    setOutputStream(paramOutputStream);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\IO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */