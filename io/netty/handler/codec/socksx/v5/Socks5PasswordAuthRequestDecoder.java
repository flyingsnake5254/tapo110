package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.util.List;

public class Socks5PasswordAuthRequestDecoder
  extends ReplayingDecoder<State>
{
  public Socks5PasswordAuthRequestDecoder()
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
    paramException = new DefaultSocks5PasswordAuthRequest("", "");
    paramException.setDecoderResult(DecoderResult.failure((Throwable)localObject));
    paramList.add(paramException);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State[((State)state()).ordinal()];
      int j;
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
        i = paramByteBuf.readerIndex();
        j = paramByteBuf.getByte(i);
        if (j != 1) {
          break label188;
        }
        int k = paramByteBuf.getUnsignedByte(i + 1);
        int m = i + 2;
        j = paramByteBuf.getUnsignedByte(m + k);
        paramByteBuf.skipBytes(k + j + 3);
        paramChannelHandlerContext = new io/netty/handler/codec/socksx/v5/DefaultSocks5PasswordAuthRequest;
        Charset localCharset = CharsetUtil.US_ASCII;
        paramChannelHandlerContext.<init>(paramByteBuf.toString(m, k, localCharset), paramByteBuf.toString(i + 3 + k, j, localCharset));
        paramList.add(paramChannelHandlerContext);
        checkpoint(State.SUCCESS);
      }
      i = actualReadableBytes();
      if (i > 0)
      {
        paramList.add(paramByteBuf.readRetainedSlice(i));
        return;
        label188:
        paramChannelHandlerContext = new io/netty/handler/codec/DecoderException;
        paramByteBuf = new java/lang/StringBuilder;
        paramByteBuf.<init>();
        paramByteBuf.append("unsupported subnegotiation version: ");
        paramByteBuf.append(j);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5PasswordAuthRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */