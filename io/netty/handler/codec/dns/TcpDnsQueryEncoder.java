package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.a
public final class TcpDnsQueryEncoder
  extends MessageToByteEncoder<DnsQuery>
{
  private final DnsQueryEncoder encoder;
  
  public TcpDnsQueryEncoder()
  {
    this(DnsRecordEncoder.DEFAULT);
  }
  
  public TcpDnsQueryEncoder(DnsRecordEncoder paramDnsRecordEncoder)
  {
    this.encoder = new DnsQueryEncoder(paramDnsRecordEncoder);
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, DnsQuery paramDnsQuery, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramChannelHandlerContext.alloc().ioBuffer(1024);
    }
    return paramChannelHandlerContext.alloc().heapBuffer(1024);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, DnsQuery paramDnsQuery, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf.writerIndex(paramByteBuf.writerIndex() + 2);
    this.encoder.encode(paramDnsQuery, paramByteBuf);
    paramByteBuf.setShort(0, paramByteBuf.readableBytes() - 2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\TcpDnsQueryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */