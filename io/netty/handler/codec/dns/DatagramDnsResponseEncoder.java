package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.a
public class DatagramDnsResponseEncoder
  extends MessageToMessageEncoder<AddressedEnvelope<DnsResponse, InetSocketAddress>>
{
  private final DnsRecordEncoder recordEncoder;
  
  public DatagramDnsResponseEncoder()
  {
    this(DnsRecordEncoder.DEFAULT);
  }
  
  public DatagramDnsResponseEncoder(DnsRecordEncoder paramDnsRecordEncoder)
  {
    this.recordEncoder = ((DnsRecordEncoder)ObjectUtil.checkNotNull(paramDnsRecordEncoder, "recordEncoder"));
  }
  
  private static void encodeHeader(DnsResponse paramDnsResponse, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeShort(paramDnsResponse.id());
    int i = (paramDnsResponse.opCode().byteValue() & 0xFF) << 11 | 0x8000;
    int j = i;
    if (paramDnsResponse.isAuthoritativeAnswer()) {
      j = i | 0x400;
    }
    i = j;
    if (paramDnsResponse.isTruncated()) {
      i = j | 0x200;
    }
    j = i;
    if (paramDnsResponse.isRecursionDesired()) {
      j = i | 0x100;
    }
    i = j;
    if (paramDnsResponse.isRecursionAvailable()) {
      i = j | 0x80;
    }
    paramByteBuf.writeShort(i | paramDnsResponse.z() << 4 | paramDnsResponse.code().intValue());
    paramByteBuf.writeShort(paramDnsResponse.count(DnsSection.QUESTION));
    paramByteBuf.writeShort(paramDnsResponse.count(DnsSection.ANSWER));
    paramByteBuf.writeShort(paramDnsResponse.count(DnsSection.AUTHORITY));
    paramByteBuf.writeShort(paramDnsResponse.count(DnsSection.ADDITIONAL));
  }
  
  private void encodeQuestions(DnsResponse paramDnsResponse, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramDnsResponse.count(DnsSection.QUESTION);
    for (int j = 0; j < i; j++) {
      this.recordEncoder.encodeQuestion((DnsQuestion)paramDnsResponse.recordAt(DnsSection.QUESTION, j), paramByteBuf);
    }
  }
  
  private void encodeRecords(DnsResponse paramDnsResponse, DnsSection paramDnsSection, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramDnsResponse.count(paramDnsSection);
    for (int j = 0; j < i; j++) {
      this.recordEncoder.encodeRecord(paramDnsResponse.recordAt(paramDnsSection, j), paramByteBuf);
    }
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> paramAddressedEnvelope)
    throws Exception
  {
    return paramChannelHandlerContext.alloc().ioBuffer(1024);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, AddressedEnvelope<DnsResponse, InetSocketAddress> paramAddressedEnvelope, List<Object> paramList)
    throws Exception
  {
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramAddressedEnvelope.recipient();
    DnsResponse localDnsResponse = (DnsResponse)paramAddressedEnvelope.content();
    paramChannelHandlerContext = allocateBuffer(paramChannelHandlerContext, paramAddressedEnvelope);
    try
    {
      encodeHeader(localDnsResponse, paramChannelHandlerContext);
      encodeQuestions(localDnsResponse, paramChannelHandlerContext);
      encodeRecords(localDnsResponse, DnsSection.ANSWER, paramChannelHandlerContext);
      encodeRecords(localDnsResponse, DnsSection.AUTHORITY, paramChannelHandlerContext);
      encodeRecords(localDnsResponse, DnsSection.ADDITIONAL, paramChannelHandlerContext);
      return;
    }
    finally
    {
      paramChannelHandlerContext.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsResponseEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */