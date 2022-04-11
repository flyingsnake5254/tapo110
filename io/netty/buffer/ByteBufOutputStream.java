package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteBufOutputStream
  extends OutputStream
  implements DataOutput
{
  private final ByteBuf buffer;
  private final int startIndex;
  private final DataOutputStream utf8out = new DataOutputStream(this);
  
  public ByteBufOutputStream(ByteBuf paramByteBuf)
  {
    this.buffer = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "buffer"));
    this.startIndex = paramByteBuf.writerIndex();
  }
  
  public ByteBuf buffer()
  {
    return this.buffer;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.buffer.writeByte(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.buffer.writeBytes(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0) {
      return;
    }
    this.buffer.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    this.buffer.writeBoolean(paramBoolean);
  }
  
  public void writeByte(int paramInt)
    throws IOException
  {
    this.buffer.writeByte(paramInt);
  }
  
  public void writeBytes(String paramString)
    throws IOException
  {
    this.buffer.writeCharSequence(paramString, CharsetUtil.US_ASCII);
  }
  
  public void writeChar(int paramInt)
    throws IOException
  {
    this.buffer.writeChar(paramInt);
  }
  
  public void writeChars(String paramString)
    throws IOException
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++) {
      this.buffer.writeChar(paramString.charAt(j));
    }
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    this.buffer.writeDouble(paramDouble);
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    this.buffer.writeFloat(paramFloat);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.buffer.writeInt(paramInt);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    this.buffer.writeLong(paramLong);
  }
  
  public void writeShort(int paramInt)
    throws IOException
  {
    this.buffer.writeShort((short)paramInt);
  }
  
  public void writeUTF(String paramString)
    throws IOException
  {
    this.utf8out.writeUTF(paramString);
  }
  
  public int writtenBytes()
  {
    return this.buffer.writerIndex() - this.startIndex;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBufOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */