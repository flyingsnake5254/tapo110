package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocksInitRequestDecoder
  extends ReplayingDecoder<State>
{
  public SocksInitRequestDecoder()
  {
    super(State.CHECK_PROTOCOL_VERSION);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[((State)state()).ordinal()];
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
        paramList.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
        break label150;
      }
      checkpoint(State.READ_AUTH_SCHEMES);
    }
    int j = paramByteBuf.readByte();
    if (j > 0)
    {
      ArrayList localArrayList = new ArrayList(j);
      for (i = 0;; i++)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(SocksAuthScheme.valueOf(paramByteBuf.readByte()));
      }
    }
    Object localObject = Collections.emptyList();
    paramList.add(new SocksInitRequest((List)localObject));
    label150:
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("CHECK_PROTOCOL_VERSION", 0);
      CHECK_PROTOCOL_VERSION = localState1;
      State localState2 = new State("READ_AUTH_SCHEMES", 1);
      READ_AUTH_SCHEMES = localState2;
      $VALUES = new State[] { localState1, localState2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksInitRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */