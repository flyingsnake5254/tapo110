package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;

public abstract class AbstractSocks5Message
  extends AbstractSocksMessage
  implements a
{
  public final SocksVersion version()
  {
    return SocksVersion.SOCKS5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\AbstractSocks5Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */