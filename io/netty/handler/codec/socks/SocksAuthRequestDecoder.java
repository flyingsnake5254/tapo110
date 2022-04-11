package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

public class SocksAuthRequestDecoder
  extends ReplayingDecoder<State>
{
  private String username;
  
  public SocksAuthRequestDecoder()
  {
    super(State.CHECK_PROTOCOL_VERSION);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State[((State)state()).ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label97;
        }
        throw new Error();
      }
    }
    else
    {
      if (paramByteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue())
      {
        paramList.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
        break label125;
      }
      checkpoint(State.READ_USERNAME);
    }
    this.username = SocksCommonUtils.readUsAscii(paramByteBuf, paramByteBuf.readByte());
    checkpoint(State.READ_PASSWORD);
    label97:
    paramByteBuf = SocksCommonUtils.readUsAscii(paramByteBuf, paramByteBuf.readByte());
    paramList.add(new SocksAuthRequest(this.username, paramByteBuf));
    label125:
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("CHECK_PROTOCOL_VERSION", 0);
      CHECK_PROTOCOL_VERSION = localState1;
      State localState2 = new State("READ_USERNAME", 1);
      READ_USERNAME = localState2;
      State localState3 = new State("READ_PASSWORD", 2);
      READ_PASSWORD = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAuthRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */