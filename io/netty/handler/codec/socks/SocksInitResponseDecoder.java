package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

public class SocksInitResponseDecoder
  extends ReplayingDecoder<State>
{
  public SocksInitResponseDecoder()
  {
    super(State.CHECK_PROTOCOL_VERSION);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State[((State)state()).ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        throw new Error();
      }
    }
    else
    {
      if (paramByteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue())
      {
        paramList.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
        break label93;
      }
      checkpoint(State.READ_PREFERRED_AUTH_TYPE);
    }
    paramList.add(new SocksInitResponse(SocksAuthScheme.valueOf(paramByteBuf.readByte())));
    label93:
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("CHECK_PROTOCOL_VERSION", 0);
      CHECK_PROTOCOL_VERSION = localState1;
      State localState2 = new State("READ_PREFERRED_AUTH_TYPE", 1);
      READ_PREFERRED_AUTH_TYPE = localState2;
      $VALUES = new State[] { localState1, localState2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksInitResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */