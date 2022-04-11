package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.internal.StringUtil;

public class DefaultDnsRecordEncoder
  implements DnsRecordEncoder
{
  private static final int PREFIX_MASK = 7;
  
  static int calculateEcsAddressLength(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    return (paramInt1 >>> 3) + paramInt2;
  }
  
  private void encodeOptEcsRecord(DnsOptEcsRecord paramDnsOptEcsRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeRecord0(paramDnsOptEcsRecord, paramByteBuf);
    int i = paramDnsOptEcsRecord.sourcePrefixLength();
    int j = paramDnsOptEcsRecord.scopePrefixLength();
    int k = i & 0x7;
    byte[] arrayOfByte = paramDnsOptEcsRecord.address();
    int m = arrayOfByte.length << 3;
    if ((m >= i) && (i >= 0))
    {
      if (arrayOfByte.length == 4) {
        paramDnsOptEcsRecord = InternetProtocolFamily.IPv4;
      } else {
        paramDnsOptEcsRecord = InternetProtocolFamily.IPv6;
      }
      m = (short)paramDnsOptEcsRecord.addressNumber();
      int n = calculateEcsAddressLength(i, k);
      int i1 = n + 8;
      paramByteBuf.writeShort(i1);
      paramByteBuf.writeShort(8);
      paramByteBuf.writeShort(i1 - 4);
      paramByteBuf.writeShort(m);
      paramByteBuf.writeByte(i);
      paramByteBuf.writeByte(j);
      if (k > 0)
      {
        i = n - 1;
        paramByteBuf.writeBytes(arrayOfByte, 0, i);
        paramByteBuf.writeByte(padWithZeros(arrayOfByte[i], k));
      }
      else
      {
        paramByteBuf.writeBytes(arrayOfByte, 0, n);
      }
      return;
    }
    paramDnsOptEcsRecord = new StringBuilder();
    paramDnsOptEcsRecord.append(i);
    paramDnsOptEcsRecord.append(": ");
    paramDnsOptEcsRecord.append(i);
    paramDnsOptEcsRecord.append(" (expected: 0 >= ");
    paramDnsOptEcsRecord.append(m);
    paramDnsOptEcsRecord.append(')');
    throw new IllegalArgumentException(paramDnsOptEcsRecord.toString());
  }
  
  private void encodeOptPseudoRecord(DnsOptPseudoRecord paramDnsOptPseudoRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeRecord0(paramDnsOptPseudoRecord, paramByteBuf);
    paramByteBuf.writeShort(0);
  }
  
  private void encodePtrRecord(DnsPtrRecord paramDnsPtrRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeRecord0(paramDnsPtrRecord, paramByteBuf);
    encodeName(paramDnsPtrRecord.hostname(), paramByteBuf);
  }
  
  private void encodeRawRecord(DnsRawRecord paramDnsRawRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeRecord0(paramDnsRawRecord, paramByteBuf);
    paramDnsRawRecord = paramDnsRawRecord.content();
    int i = paramDnsRawRecord.readableBytes();
    paramByteBuf.writeShort(i);
    paramByteBuf.writeBytes(paramDnsRawRecord, paramDnsRawRecord.readerIndex(), i);
  }
  
  private void encodeRecord0(DnsRecord paramDnsRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeName(paramDnsRecord.name(), paramByteBuf);
    paramByteBuf.writeShort(paramDnsRecord.type().intValue());
    paramByteBuf.writeShort(paramDnsRecord.dnsClass());
    paramByteBuf.writeInt((int)paramDnsRecord.timeToLive());
  }
  
  private static byte padWithZeros(byte paramByte, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lowOrderBitsToPreserve: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 8: 
      return paramByte;
    case 7: 
      paramInt = paramByte & 0xFE;
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      for (;;)
      {
        return (byte)paramInt;
        paramInt = paramByte & 0xFC;
        continue;
        paramInt = paramByte & 0xF8;
        continue;
        paramInt = paramByte & 0xF0;
        continue;
        paramInt = paramByte & 0xE0;
        continue;
        paramInt = paramByte & 0xC0;
        continue;
        paramInt = paramByte & 0x80;
      }
    }
    return 0;
  }
  
  protected void encodeName(String paramString, ByteBuf paramByteBuf)
    throws Exception
  {
    DnsCodecUtil.encodeDomainName(paramString, paramByteBuf);
  }
  
  public final void encodeQuestion(DnsQuestion paramDnsQuestion, ByteBuf paramByteBuf)
    throws Exception
  {
    encodeName(paramDnsQuestion.name(), paramByteBuf);
    paramByteBuf.writeShort(paramDnsQuestion.type().intValue());
    paramByteBuf.writeShort(paramDnsQuestion.dnsClass());
  }
  
  public void encodeRecord(DnsRecord paramDnsRecord, ByteBuf paramByteBuf)
    throws Exception
  {
    if ((paramDnsRecord instanceof DnsQuestion))
    {
      encodeQuestion((DnsQuestion)paramDnsRecord, paramByteBuf);
    }
    else if ((paramDnsRecord instanceof DnsPtrRecord))
    {
      encodePtrRecord((DnsPtrRecord)paramDnsRecord, paramByteBuf);
    }
    else if ((paramDnsRecord instanceof DnsOptEcsRecord))
    {
      encodeOptEcsRecord((DnsOptEcsRecord)paramDnsRecord, paramByteBuf);
    }
    else if ((paramDnsRecord instanceof DnsOptPseudoRecord))
    {
      encodeOptPseudoRecord((DnsOptPseudoRecord)paramDnsRecord, paramByteBuf);
    }
    else
    {
      if (!(paramDnsRecord instanceof DnsRawRecord)) {
        break label93;
      }
      encodeRawRecord((DnsRawRecord)paramDnsRecord, paramByteBuf);
    }
    return;
    label93:
    throw new UnsupportedMessageTypeException(StringUtil.simpleClassName(paramDnsRecord));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsRecordEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */