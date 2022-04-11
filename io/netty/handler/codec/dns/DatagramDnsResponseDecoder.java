package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.a
public class DatagramDnsResponseDecoder
  extends MessageToMessageDecoder<DatagramPacket>
{
  private final DnsResponseDecoder<InetSocketAddress> responseDecoder;
  
  public DatagramDnsResponseDecoder()
  {
    this(DnsRecordDecoder.DEFAULT);
  }
  
  public DatagramDnsResponseDecoder(DnsRecordDecoder paramDnsRecordDecoder)
  {
    this.responseDecoder = new DnsResponseDecoder(paramDnsRecordDecoder)
    {
      protected DnsResponse newResponse(InetSocketAddress paramAnonymousInetSocketAddress1, InetSocketAddress paramAnonymousInetSocketAddress2, int paramAnonymousInt, DnsOpCode paramAnonymousDnsOpCode, DnsResponseCode paramAnonymousDnsResponseCode)
      {
        return new DatagramDnsResponse(paramAnonymousInetSocketAddress1, paramAnonymousInetSocketAddress2, paramAnonymousInt, paramAnonymousDnsOpCode, paramAnonymousDnsResponseCode);
      }
    };
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, DatagramPacket paramDatagramPacket, List<Object> paramList)
    throws Exception
  {
    paramList.add(decodeResponse(paramChannelHandlerContext, paramDatagramPacket));
  }
  
  protected DnsResponse decodeResponse(ChannelHandlerContext paramChannelHandlerContext, DatagramPacket paramDatagramPacket)
    throws Exception
  {
    return this.responseDecoder.decode(paramDatagramPacket.sender(), paramDatagramPacket.recipient(), (ByteBuf)paramDatagramPacket.content());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */