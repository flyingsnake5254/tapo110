package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

public class Socks4ClientDecoder
  extends ReplayingDecoder<State>
{
  public Socks4ClientDecoder()
  {
    super(State.START);
    setSingleDecode(true);
  }
  
  private void fail(List<Object> paramList, Exception paramException)
  {
    Object localObject = paramException;
    if (!(paramException instanceof DecoderException)) {
      localObject = new DecoderException(paramException);
    }
    paramException = new DefaultSocks4CommandResponse(Socks4CommandStatus.REJECTED_OR_FAILED);
    paramException.setDecoderResult(DecoderResult.failure((Throwable)localObject));
    paramList.add(paramException);
    checkpoint(State.FAILURE);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State[((State)state()).ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramByteBuf.skipBytes(actualReadableBytes());
          return;
        }
      }
      else
      {
        i = paramByteBuf.readUnsignedByte();
        if (i != 0) {
          break label140;
        }
        Socks4CommandStatus localSocks4CommandStatus = Socks4CommandStatus.valueOf(paramByteBuf.readByte());
        i = paramByteBuf.readUnsignedShort();
        String str = NetUtil.intToIpAddress(paramByteBuf.readInt());
        paramChannelHandlerContext = new io/netty/handler/codec/socksx/v4/DefaultSocks4CommandResponse;
        paramChannelHandlerContext.<init>(localSocks4CommandStatus, str, i);
        paramList.add(paramChannelHandlerContext);
        checkpoint(State.SUCCESS);
      }
      i = actualReadableBytes();
      if (i > 0)
      {
        paramList.add(paramByteBuf.readRetainedSlice(i));
        return;
        label140:
        paramByteBuf = new io/netty/handler/codec/DecoderException;
        paramChannelHandlerContext = new java/lang/StringBuilder;
        paramChannelHandlerContext.<init>();
        paramChannelHandlerContext.append("unsupported reply version: ");
        paramChannelHandlerContext.append(i);
        paramChannelHandlerContext.append(" (expected: 0)");
        paramByteBuf.<init>(paramChannelHandlerContext.toString());
        throw paramByteBuf;
      }
    }
    catch (Exception paramChannelHandlerContext)
    {
      fail(paramList, paramChannelHandlerContext);
    }
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("START", 0);
      START = localState1;
      State localState2 = new State("SUCCESS", 1);
      SUCCESS = localState2;
      State localState3 = new State("FAILURE", 2);
      FAILURE = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4ClientDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */