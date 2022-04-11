package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class CompatibleObjectEncoder
  extends MessageToByteEncoder<Serializable>
{
  private final int resetInterval;
  private int writtenObjects;
  
  public CompatibleObjectEncoder()
  {
    this(16);
  }
  
  public CompatibleObjectEncoder(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.resetInterval = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetInterval: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Serializable paramSerializable, ByteBuf paramByteBuf)
    throws Exception
  {
    paramChannelHandlerContext = newObjectOutputStream(new ByteBufOutputStream(paramByteBuf));
    try
    {
      int i = this.resetInterval;
      if (i != 0)
      {
        int j = this.writtenObjects + 1;
        this.writtenObjects = j;
        if (j % i == 0) {
          paramChannelHandlerContext.reset();
        }
      }
      paramChannelHandlerContext.writeObject(paramSerializable);
      paramChannelHandlerContext.flush();
      return;
    }
    finally
    {
      paramChannelHandlerContext.close();
    }
  }
  
  protected ObjectOutputStream newObjectOutputStream(OutputStream paramOutputStream)
    throws Exception
  {
    return new ObjectOutputStream(paramOutputStream);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\CompatibleObjectEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */