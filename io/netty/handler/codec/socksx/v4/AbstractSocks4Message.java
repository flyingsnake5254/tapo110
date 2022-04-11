package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;

public abstract class AbstractSocks4Message
  extends AbstractSocksMessage
  implements SocksMessage
{
  public final SocksVersion version()
  {
    return SocksVersion.SOCKS4a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\AbstractSocks4Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */