package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.ReferenceCounted;
import java.net.SocketAddress;

public final class TcpDnsResponseDecoder
  extends LengthFieldBasedFrameDecoder
{
  private final DnsResponseDecoder<SocketAddress> responseDecoder;
  
  public TcpDnsResponseDecoder()
  {
    this(DnsRecordDecoder.DEFAULT, 65536);
  }
  
  public TcpDnsResponseDecoder(DnsRecordDecoder paramDnsRecordDecoder, int paramInt)
  {
    super(paramInt, 0, 2, 0, 2);
    this.responseDecoder = new DnsResponseDecoder(paramDnsRecordDecoder)
    {
      protected DnsResponse newResponse(SocketAddress paramAnonymousSocketAddress1, SocketAddress paramAnonymousSocketAddress2, int paramAnonymousInt, DnsOpCode paramAnonymousDnsOpCode, DnsResponseCode paramAnonymousDnsResponseCode)
      {
        return new DefaultDnsResponse(paramAnonymousInt, paramAnonymousDnsOpCode, paramAnonymousDnsResponseCode);
      }
    };
  }
  
  protected Object decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf = (ByteBuf)super.decode(paramChannelHandlerContext, paramByteBuf);
    if (paramByteBuf == null) {
      return null;
    }
    try
    {
      paramChannelHandlerContext = this.responseDecoder.decode(paramChannelHandlerContext.channel().remoteAddress(), paramChannelHandlerContext.channel().localAddress(), paramByteBuf.slice());
      return paramChannelHandlerContext;
    }
    finally
    {
      paramByteBuf.release();
    }
  }
  
  protected ByteBuf extractFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.copy(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\TcpDnsResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */