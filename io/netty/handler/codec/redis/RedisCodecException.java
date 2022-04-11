package io.netty.handler.codec.redis;

import io.netty.handler.codec.CodecException;

public final class RedisCodecException
  extends CodecException
{
  private static final long serialVersionUID = 5570454251549268063L;
  
  public RedisCodecException(String paramString)
  {
    super(paramString);
  }
  
  public RedisCodecException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\redis\RedisCodecException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */