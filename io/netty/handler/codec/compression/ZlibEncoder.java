package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

public abstract class ZlibEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  protected ZlibEncoder()
  {
    super(false);
  }
  
  public abstract ChannelFuture close();
  
  public abstract ChannelFuture close(ChannelPromise paramChannelPromise);
  
  public abstract boolean isClosed();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */