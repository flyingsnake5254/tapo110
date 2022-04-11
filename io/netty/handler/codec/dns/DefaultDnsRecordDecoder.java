package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public class DefaultDnsRecordDecoder
  implements DnsRecordDecoder
{
  static final String ROOT = ".";
  
  public static String decodeName(ByteBuf paramByteBuf)
  {
    return DnsCodecUtil.decodeDomainName(paramByteBuf);
  }
  
  protected String decodeName0(ByteBuf paramByteBuf)
  {
    return decodeName(paramByteBuf);
  }
  
  public final DnsQuestion decodeQuestion(ByteBuf paramByteBuf)
    throws Exception
  {
    return new DefaultDnsQuestion(decodeName(paramByteBuf), DnsRecordType.valueOf(paramByteBuf.readUnsignedShort()), paramByteBuf.readUnsignedShort());
  }
  
  public final <T extends DnsRecord> T decodeRecord(ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.readerIndex();
    Object localObject = decodeName(paramByteBuf);
    int j = paramByteBuf.writerIndex();
    if (j - paramByteBuf.readerIndex() < 10)
    {
      paramByteBuf.readerIndex(i);
      return null;
    }
    DnsRecordType localDnsRecordType = DnsRecordType.valueOf(paramByteBuf.readUnsignedShort());
    int k = paramByteBuf.readUnsignedShort();
    long l = paramByteBuf.readUnsignedInt();
    int m = paramByteBuf.readUnsignedShort();
    int n = paramByteBuf.readerIndex();
    if (j - n < m)
    {
      paramByteBuf.readerIndex(i);
      return null;
    }
    localObject = decodeRecord((String)localObject, localDnsRecordType, k, l, paramByteBuf, n, m);
    paramByteBuf.readerIndex(n + m);
    return (T)localObject;
  }
  
  protected DnsRecord decodeRecord(String paramString, DnsRecordType paramDnsRecordType, int paramInt1, long paramLong, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
    throws Exception
  {
    if (paramDnsRecordType == DnsRecordType.PTR) {
      return new DefaultDnsPtrRecord(paramString, paramInt1, paramLong, decodeName0(paramByteBuf.duplicate().setIndex(paramInt2, paramInt2 + paramInt3)));
    }
    if ((paramDnsRecordType != DnsRecordType.CNAME) && (paramDnsRecordType != DnsRecordType.NS)) {
      return new DefaultDnsRawRecord(paramString, paramDnsRecordType, paramInt1, paramLong, paramByteBuf.retainedDuplicate().setIndex(paramInt2, paramInt2 + paramInt3));
    }
    return new DefaultDnsRawRecord(paramString, paramDnsRecordType, paramInt1, paramLong, DnsCodecUtil.decompressDomainName(paramByteBuf.duplicate().setIndex(paramInt2, paramInt2 + paramInt3)));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsRecordDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */