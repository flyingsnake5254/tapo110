package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class DnsAddressDecoder
{
  private static final int INADDRSZ4 = 4;
  private static final int INADDRSZ6 = 16;
  
  static InetAddress decodeAddress(DnsRecord paramDnsRecord, String paramString, boolean paramBoolean)
  {
    if (!(paramDnsRecord instanceof DnsRawRecord)) {
      return null;
    }
    paramDnsRecord = ((ByteBufHolder)paramDnsRecord).content();
    int i = paramDnsRecord.readableBytes();
    if ((i != 4) && (i != 16)) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramDnsRecord.getBytes(paramDnsRecord.readerIndex(), arrayOfByte);
    paramDnsRecord = paramString;
    if (paramBoolean) {
      try
      {
        paramDnsRecord = IDN.toUnicode(paramString);
      }
      catch (UnknownHostException paramDnsRecord)
      {
        break label80;
      }
    }
    paramDnsRecord = InetAddress.getByAddress(paramDnsRecord, arrayOfByte);
    return paramDnsRecord;
    label80:
    throw new Error(paramDnsRecord);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsAddressDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */