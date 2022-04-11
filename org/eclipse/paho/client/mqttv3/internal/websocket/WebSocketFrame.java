package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class WebSocketFrame
{
  public static final int frameLengthOverhead = 6;
  private boolean closeFlag;
  private boolean fin;
  private byte opcode;
  private byte[] payload;
  
  public WebSocketFrame(byte paramByte, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.closeFlag = false;
    this.opcode = ((byte)paramByte);
    this.fin = paramBoolean;
    if (paramArrayOfByte != null) {
      this.payload = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public WebSocketFrame(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    this.closeFlag = false;
    setFinAndOpCode((byte)paramInputStream.read());
    int j = this.opcode;
    int k = 2;
    if (j == 2)
    {
      j = (byte)paramInputStream.read();
      int m;
      if ((j & 0x80) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      j = (byte)(j & 0x7F);
      if (j == 127) {
        k = 8;
      } else if (j != 126) {
        k = 0;
      }
      int n = k;
      if (k > 0)
      {
        j = 0;
        n = k;
      }
      for (;;)
      {
        n--;
        if (n < 0)
        {
          byte[] arrayOfByte;
          if (m != 0)
          {
            arrayOfByte = new byte[4];
            paramInputStream.read(arrayOfByte, 0, 4);
          }
          else
          {
            arrayOfByte = null;
          }
          this.payload = new byte[j];
          k = j;
          n = 0;
          for (;;)
          {
            if (n == j)
            {
              if (m != 0) {
                for (j = i;; j++)
                {
                  paramInputStream = this.payload;
                  if (j >= paramInputStream.length) {
                    break;
                  }
                  paramInputStream[j] = ((byte)(byte)(paramInputStream[j] ^ arrayOfByte[(j % 4)]));
                }
              }
              return;
            }
            int i1 = paramInputStream.read(this.payload, n, k);
            n += i1;
            k -= i1;
          }
        }
        j |= ((byte)paramInputStream.read() & 0xFF) << n * 8;
      }
    }
    if (j == 8)
    {
      this.closeFlag = true;
      return;
    }
    paramInputStream = new StringBuilder("Invalid Frame: Opcode: ");
    paramInputStream.append(this.opcode);
    throw new IOException(paramInputStream.toString());
  }
  
  public WebSocketFrame(byte[] paramArrayOfByte)
  {
    int i = 0;
    this.closeFlag = false;
    Object localObject = ByteBuffer.wrap(paramArrayOfByte);
    setFinAndOpCode(((ByteBuffer)localObject).get());
    int j = ((ByteBuffer)localObject).get();
    int k;
    if ((j & 0x80) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m = (byte)(j & 0x7F);
    if (m == 127) {
      j = 8;
    } else if (m == 126) {
      j = 2;
    } else {
      j = 0;
    }
    for (;;)
    {
      j--;
      if (j <= 0)
      {
        paramArrayOfByte = null;
        if (k != 0)
        {
          paramArrayOfByte = new byte[4];
          ((ByteBuffer)localObject).get(paramArrayOfByte, 0, 4);
        }
        byte[] arrayOfByte = new byte[m];
        this.payload = arrayOfByte;
        ((ByteBuffer)localObject).get(arrayOfByte, 0, m);
        if (k != 0) {
          for (j = i;; j++)
          {
            localObject = this.payload;
            if (j >= localObject.length) {
              break;
            }
            localObject[j] = ((byte)(byte)(localObject[j] ^ paramArrayOfByte[(j % 4)]));
          }
        }
        return;
      }
      m |= (((ByteBuffer)localObject).get() & 0xFF) << j * 8;
    }
  }
  
  public static void appendFinAndOpCode(ByteBuffer paramByteBuffer, byte paramByte, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = (byte)'';
    } else {
      i = 0;
    }
    paramByteBuffer.put((byte)(paramByte & 0xF | i));
  }
  
  private static void appendLength(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      int i;
      if (paramBoolean) {
        i = -128;
      } else {
        i = 0;
      }
      if (paramInt > 65535)
      {
        paramByteBuffer.put((byte)(i | 0x7F));
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)0);
        paramByteBuffer.put((byte)(paramInt >> 24 & 0xFF));
        paramByteBuffer.put((byte)(paramInt >> 16 & 0xFF));
        paramByteBuffer.put((byte)(paramInt >> 8 & 0xFF));
        paramByteBuffer.put((byte)(paramInt & 0xFF));
      }
      else if (paramInt >= 126)
      {
        paramByteBuffer.put((byte)(i | 0x7E));
        paramByteBuffer.put((byte)(paramInt >> 8));
        paramByteBuffer.put((byte)(paramInt & 0xFF));
      }
      else
      {
        paramByteBuffer.put((byte)(paramInt | i));
      }
      return;
    }
    throw new IllegalArgumentException("Length cannot be negative");
  }
  
  public static void appendLengthAndMask(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      appendLength(paramByteBuffer, paramInt, true);
      paramByteBuffer.put(paramArrayOfByte);
    }
    else
    {
      appendLength(paramByteBuffer, paramInt, false);
    }
  }
  
  public static byte[] generateMaskingKey()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    int i = localSecureRandom.nextInt(255);
    int j = localSecureRandom.nextInt(255);
    int k = localSecureRandom.nextInt(255);
    int m = localSecureRandom.nextInt(255);
    return new byte[] { (byte)i, (byte)j, (byte)k, (byte)m };
  }
  
  private void setFinAndOpCode(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.fin = bool;
    this.opcode = ((byte)(byte)(paramByte & 0xF));
  }
  
  public byte[] encodeFrame()
  {
    byte[] arrayOfByte1 = this.payload;
    int i = arrayOfByte1.length + 6;
    if (arrayOfByte1.length > 65535)
    {
      j = i + 8;
    }
    else
    {
      j = i;
      if (arrayOfByte1.length >= 126) {
        j = i + 2;
      }
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(j);
    appendFinAndOpCode(localByteBuffer, this.opcode, this.fin);
    byte[] arrayOfByte2 = generateMaskingKey();
    appendLengthAndMask(localByteBuffer, this.payload.length, arrayOfByte2);
    for (int j = 0;; j++)
    {
      arrayOfByte1 = this.payload;
      if (j >= arrayOfByte1.length)
      {
        localByteBuffer.flip();
        return localByteBuffer.array();
      }
      byte b = (byte)(arrayOfByte1[j] ^ arrayOfByte2[(j % 4)]);
      arrayOfByte1[j] = b;
      localByteBuffer.put(b);
    }
  }
  
  public byte getOpcode()
  {
    return this.opcode;
  }
  
  public byte[] getPayload()
  {
    return this.payload;
  }
  
  public boolean isCloseFlag()
  {
    return this.closeFlag;
  }
  
  public boolean isFin()
  {
    return this.fin;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */