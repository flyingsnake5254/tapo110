package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.ReferenceCounted;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.a
public class DatagramDnsQueryEncoder
  extends MessageToMessageEncoder<AddressedEnvelope<DnsQuery, InetSocketAddress>>
{
  private final DnsQueryEncoder encoder;
  
  public DatagramDnsQueryEncoder()
  {
    this(DnsRecordEncoder.DEFAULT);
  }
  
  public DatagramDnsQueryEncoder(DnsRecordEncoder paramDnsRecordEncoder)
  {
    this.encoder = new DnsQueryEncoder(paramDnsRecordEncoder);
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> paramAddressedEnvelope)
    throws Exception
  {
    return paramChannelHandlerContext.alloc().ioBuffer(1024);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> paramAddressedEnvelope, List<Object> paramList)
    throws Exception
  {
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramAddressedEnvelope.recipient();
    DnsQuery localDnsQuery = (DnsQuery)paramAddressedEnvelope.content();
    paramChannelHandlerContext = allocateBuffer(paramChannelHandlerContext, paramAddressedEnvelope);
    try
    {
      this.encoder.encode(localDnsQuery, paramChannelHandlerContext);
      return;
    }
    finally
    {
      paramChannelHandlerContext.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsQueryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */