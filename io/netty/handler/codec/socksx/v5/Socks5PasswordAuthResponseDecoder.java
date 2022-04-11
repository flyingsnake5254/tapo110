package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

public class Socks5PasswordAuthResponseDecoder
  extends ReplayingDecoder<State>
{
  public Socks5PasswordAuthResponseDecoder()
  {
    super(State.INIT);
  }
  
  private void fail(List<Object> paramList, Exception paramException)
  {
    Object localObject = paramException;
    if (!(paramException instanceof DecoderException)) {
      localObject = new DecoderException(paramException);
    }
    checkpoint(State.FAILURE);
    paramException = new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.FAILURE);
    paramException.setDecoderResult(DecoderResult.failure((Throwable)localObject));
    paramList.add(paramException);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State[((State)state()).ordinal()];
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
        i = paramByteBuf.readByte();
        if (i != 1) {
          break label118;
        }
        paramChannelHandlerContext = new io/netty/handler/codec/socksx/v5/DefaultSocks5PasswordAuthResponse;
        paramChannelHandlerContext.<init>(Socks5PasswordAuthStatus.valueOf(paramByteBuf.readByte()));
        paramList.add(paramChannelHandlerContext);
        checkpoint(State.SUCCESS);
      }
      i = actualReadableBytes();
      if (i > 0)
      {
        paramList.add(paramByteBuf.readRetainedSlice(i));
        return;
        label118:
        paramChannelHandlerContext = new io/netty/handler/codec/DecoderException;
        paramByteBuf = new java/lang/StringBuilder;
        paramByteBuf.<init>();
        paramByteBuf.append("unsupported subnegotiation version: ");
        paramByteBuf.append(i);
        paramByteBuf.append(" (expected: 1)");
        paramChannelHandlerContext.<init>(paramByteBuf.toString());
        throw paramChannelHandlerContext;
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
      State localState1 = new State("INIT", 0);
      INIT = localState1;
      State localState2 = new State("SUCCESS", 1);
      SUCCESS = localState2;
      State localState3 = new State("FAILURE", 2);
      FAILURE = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5PasswordAuthResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */