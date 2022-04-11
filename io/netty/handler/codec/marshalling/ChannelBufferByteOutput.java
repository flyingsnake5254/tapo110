package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteOutput;

class ChannelBufferByteOutput
  implements ByteOutput
{
  private final ByteBuf buffer;
  
  ChannelBufferByteOutput(ByteBuf paramByteBuf)
  {
    this.buffer = paramByteBuf;
  }
  
  public void close()
    throws IOException
  {}
  
  public void flush()
    throws IOException
  {}
  
  ByteBuf getBuffer()
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
    this.buffer.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\ChannelBufferByteOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */