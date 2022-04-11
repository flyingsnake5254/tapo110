package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;

class ChannelBufferByteInput
  implements ByteInput
{
  private final ByteBuf buffer;
  
  ChannelBufferByteInput(ByteBuf paramByteBuf)
  {
    this.buffer = paramByteBuf;
  }
  
  public int available()
    throws IOException
  {
    return this.buffer.readableBytes();
  }
  
  public void close()
    throws IOException
  {}
  
  public int read()
    throws IOException
  {
    if (this.buffer.isReadable()) {
      return this.buffer.readByte() & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = available();
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(i, paramInt2);
    this.buffer.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l1 = this.buffer.readableBytes();
    long l2 = paramLong;
    if (l1 < paramLong) {
      l2 = l1;
    }
    ByteBuf localByteBuf = this.buffer;
    localByteBuf.readerIndex((int)(localByteBuf.readerIndex() + l2));
    return l2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\ChannelBufferByteInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */