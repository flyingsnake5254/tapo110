package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

final class DnsQueryEncoder
{
  private final DnsRecordEncoder recordEncoder;
  
  DnsQueryEncoder(DnsRecordEncoder paramDnsRecordEncoder)
  {
    this.recordEncoder = ((DnsRecordEncoder)ObjectUtil.checkNotNull(paramDnsRecordEncoder, "recordEncoder"));
  }
  
  private static void encodeHeader(DnsQuery paramDnsQuery, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeShort(paramDnsQuery.id());
    int i = (paramDnsQuery.opCode().byteValue() & 0xFF) << 14 | 0x0;
    int j = i;
    if (paramDnsQuery.isRecursionDesired()) {
      j = i | 0x100;
    }
    paramByteBuf.writeShort(j);
    paramByteBuf.writeShort(paramDnsQuery.count(DnsSection.QUESTION));
    paramByteBuf.writeShort(0);
    paramByteBuf.writeShort(0);
    paramByteBuf.writeShort(paramDnsQuery.count(DnsSection.ADDITIONAL));
  }
  
  private void encodeQuestions(DnsQuery paramDnsQuery, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramDnsQuery.count(DnsSection.QUESTION);
    for (int j = 0; j < i; j++) {
      this.recordEncoder.encodeQuestion((DnsQuestion)paramDnsQuery.recordAt(DnsSection.QUESTION, j), paramByteBuf);
    }
  }
  
  private void encodeRecords(DnsQuery paramDnsQuery, DnsSection paramDnsSection, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramDnsQuery.count(paramDnsSection);
    for (int j = 0; j < i; j++) {
      this.recordEncoder.encodeRecord(paramDnsQuery.recordAt(paramDnsSection, j), paramByteBuf);
    }
  }
  
  void encode(DnsQuery paramDnsQuery, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeHeader(paramDnsQuery, paramByteBuf);
    encodeQuestions(paramDnsQuery, paramByteBuf);
    encodeRecords(paramDnsQuery, DnsSection.ADDITIONAL, paramByteBuf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsQueryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */