package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.a
public class DatagramDnsQueryDecoder
  extends MessageToMessageDecoder<DatagramPacket>
{
  private final DnsRecordDecoder recordDecoder;
  
  public DatagramDnsQueryDecoder()
  {
    this(DnsRecordDecoder.DEFAULT);
  }
  
  public DatagramDnsQueryDecoder(DnsRecordDecoder paramDnsRecordDecoder)
  {
    this.recordDecoder = ((DnsRecordDecoder)ObjectUtil.checkNotNull(paramDnsRecordDecoder, "recordDecoder"));
  }
  
  private void decodeQuestions(DnsQuery paramDnsQuery, ByteBuf paramByteBuf, int paramInt)
    throws Exception
  {
    while (paramInt > 0)
    {
      paramDnsQuery.addRecord(DnsSection.QUESTION, this.recordDecoder.decodeQuestion(paramByteBuf));
      paramInt--;
    }
  }
  
  private void decodeRecords(DnsQuery paramDnsQuery, DnsSection paramDnsSection, ByteBuf paramByteBuf, int paramInt)
    throws Exception
  {
    while (paramInt > 0)
    {
      DnsRecord localDnsRecord = this.recordDecoder.decodeRecord(paramByteBuf);
      if (localDnsRecord == null) {
        break;
      }
      paramDnsQuery.addRecord(paramDnsSection, localDnsRecord);
      paramInt--;
    }
  }
  
  private static DnsQuery newQuery(DatagramPacket paramDatagramPacket, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readUnsignedShort();
    int j = paramByteBuf.readUnsignedShort();
    boolean bool = true;
    if (j >> 15 != 1)
    {
      paramDatagramPacket = new DatagramDnsQuery((InetSocketAddress)paramDatagramPacket.sender(), (InetSocketAddress)paramDatagramPacket.recipient(), i, DnsOpCode.valueOf((byte)(j >> 11 & 0xF)));
      if ((j >> 8 & 0x1) != 1) {
        bool = false;
      }
      paramDatagramPacket.setRecursionDesired(bool);
      paramDatagramPacket.setZ(j >> 4 & 0x7);
      return paramDatagramPacket;
    }
    throw new CorruptedFrameException("not a query");
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, DatagramPacket paramDatagramPacket, List<Object> paramList)
    throws Exception
  {
    paramChannelHandlerContext = (ByteBuf)paramDatagramPacket.content();
    paramDatagramPacket = newQuery(paramDatagramPacket, paramChannelHandlerContext);
    try
    {
      int i = paramChannelHandlerContext.readUnsignedShort();
      int j = paramChannelHandlerContext.readUnsignedShort();
      int k = paramChannelHandlerContext.readUnsignedShort();
      int m = paramChannelHandlerContext.readUnsignedShort();
      decodeQuestions(paramDatagramPacket, paramChannelHandlerContext, i);
      decodeRecords(paramDatagramPacket, DnsSection.ANSWER, paramChannelHandlerContext, j);
      decodeRecords(paramDatagramPacket, DnsSection.AUTHORITY, paramChannelHandlerContext, k);
      decodeRecords(paramDatagramPacket, DnsSection.ADDITIONAL, paramChannelHandlerContext, m);
      return;
    }
    finally
    {
      paramDatagramPacket.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsQueryDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */