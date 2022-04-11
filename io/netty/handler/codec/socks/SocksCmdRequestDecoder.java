package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

public class SocksCmdRequestDecoder
  extends ReplayingDecoder<State>
{
  private SocksAddressType addressType;
  private SocksCmdType cmdType;
  
  public SocksCmdRequestDecoder()
  {
    super(State.CHECK_PROTOCOL_VERSION);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[((State)state()).ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label113;
        }
        throw new Error();
      }
    }
    else
    {
      if (paramByteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue())
      {
        paramList.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
        break label312;
      }
      checkpoint(State.READ_CMD_HEADER);
    }
    this.cmdType = SocksCmdType.valueOf(paramByteBuf.readByte());
    paramByteBuf.skipBytes(1);
    this.addressType = SocksAddressType.valueOf(paramByteBuf.readByte());
    checkpoint(State.READ_CMD_ADDRESS);
    label113:
    i = 1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            paramList.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
          } else {
            throw new Error();
          }
        }
        else
        {
          localObject = new byte[16];
          paramByteBuf.readBytes((byte[])localObject);
          localObject = SocksCommonUtils.ipv6toStr((byte[])localObject);
          i = paramByteBuf.readUnsignedShort();
          paramList.add(new SocksCmdRequest(this.cmdType, this.addressType, (String)localObject, i));
        }
      }
      else
      {
        localObject = SocksCommonUtils.readUsAscii(paramByteBuf, paramByteBuf.readByte());
        i = paramByteBuf.readUnsignedShort();
        paramList.add(new SocksCmdRequest(this.cmdType, this.addressType, (String)localObject, i));
      }
    }
    else
    {
      localObject = NetUtil.intToIpAddress(paramByteBuf.readInt());
      i = paramByteBuf.readUnsignedShort();
      paramList.add(new SocksCmdRequest(this.cmdType, this.addressType, (String)localObject, i));
    }
    label312:
    paramChannelHandlerContext.pipeline().remove(this);
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("CHECK_PROTOCOL_VERSION", 0);
      CHECK_PROTOCOL_VERSION = localState1;
      State localState2 = new State("READ_CMD_HEADER", 1);
      READ_CMD_HEADER = localState2;
      State localState3 = new State("READ_CMD_ADDRESS", 2);
      READ_CMD_ADDRESS = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCmdRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */