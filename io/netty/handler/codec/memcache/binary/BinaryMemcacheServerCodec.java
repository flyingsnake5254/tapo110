package io.netty.handler.codec.memcache.binary;

import io.netty.channel.CombinedChannelDuplexHandler;

public class BinaryMemcacheServerCodec
  extends CombinedChannelDuplexHandler<BinaryMemcacheRequestDecoder, BinaryMemcacheResponseEncoder>
{
  public BinaryMemcacheServerCodec()
  {
    this(8192);
  }
  
  public BinaryMemcacheServerCodec(int paramInt)
  {
    super(new BinaryMemcacheRequestDecoder(paramInt), new BinaryMemcacheResponseEncoder());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\BinaryMemcacheServerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */