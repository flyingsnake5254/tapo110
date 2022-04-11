package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class Socks5CommandRequestDecoder
  extends ReplayingDecoder<State>
{
  private final Socks5AddressDecoder addressDecoder;
  
  public Socks5CommandRequestDecoder()
  {
    this(Socks5AddressDecoder.DEFAULT);
  }
  
  public Socks5CommandRequestDecoder(Socks5AddressDecoder paramSocks5AddressDecoder)
  {
    super(State.INIT);
    this.addressDecoder = ((Socks5AddressDecoder)ObjectUtil.checkNotNull(paramSocks5AddressDecoder, "addressDecoder"));
  }
  
  private void fail(List<Object> paramList, Exception paramException)
  {
    Object localObject = paramException;
    if (!(paramException instanceof DecoderException)) {
      localObject = new DecoderException(paramException);
    }
    checkpoint(State.FAILURE);
    paramException = new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, Socks5AddressType.IPv4, "0.0.0.0", 1);
    paramException.setDecoderResult(DecoderResult.failure((Throwable)localObject));
    paramList.add(paramException);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$socksx$v5$Socks5CommandRequestDecoder$State[((State)state()).ordinal()];
      Object localObject;
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
        paramChannelHandlerContext = SocksVersion.SOCKS5;
        if (i != paramChannelHandlerContext.byteValue()) {
          break label171;
        }
        paramChannelHandlerContext = Socks5CommandType.valueOf(paramByteBuf.readByte());
        paramByteBuf.skipBytes(1);
        Socks5AddressType localSocks5AddressType = Socks5AddressType.valueOf(paramByteBuf.readByte());
        localObject = this.addressDecoder.decodeAddress(localSocks5AddressType, paramByteBuf);
        i = paramByteBuf.readUnsignedShort();
        DefaultSocks5CommandRequest localDefaultSocks5CommandRequest = new io/netty/handler/codec/socksx/v5/DefaultSocks5CommandRequest;
        localDefaultSocks5CommandRequest.<init>(paramChannelHandlerContext, localSocks5AddressType, (String)localObject, i);
        paramList.add(localDefaultSocks5CommandRequest);
        checkpoint(State.SUCCESS);
      }
      i = actualReadableBytes();
      if (i > 0)
      {
        paramList.add(paramByteBuf.readRetainedSlice(i));
        return;
        label171:
        paramByteBuf = new io/netty/handler/codec/DecoderException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("unsupported version: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" (expected: ");
        ((StringBuilder)localObject).append(paramChannelHandlerContext.byteValue());
        ((StringBuilder)localObject).append(')');
        paramByteBuf.<init>(((StringBuilder)localObject).toString());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5CommandRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */