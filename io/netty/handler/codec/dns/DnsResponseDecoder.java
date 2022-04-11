package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

abstract class DnsResponseDecoder<A extends SocketAddress>
{
  private final DnsRecordDecoder recordDecoder;
  
  DnsResponseDecoder(DnsRecordDecoder paramDnsRecordDecoder)
  {
    this.recordDecoder = ((DnsRecordDecoder)ObjectUtil.checkNotNull(paramDnsRecordDecoder, "recordDecoder"));
  }
  
  private void decodeQuestions(DnsResponse paramDnsResponse, ByteBuf paramByteBuf, int paramInt)
    throws Exception
  {
    while (paramInt > 0)
    {
      paramDnsResponse.addRecord(DnsSection.QUESTION, this.recordDecoder.decodeQuestion(paramByteBuf));
      paramInt--;
    }
  }
  
  private boolean decodeRecords(DnsResponse paramDnsResponse, DnsSection paramDnsSection, ByteBuf paramByteBuf, int paramInt)
    throws Exception
  {
    while (paramInt > 0)
    {
      DnsRecord localDnsRecord = this.recordDecoder.decodeRecord(paramByteBuf);
      if (localDnsRecord == null) {
        return false;
      }
      paramDnsResponse.addRecord(paramDnsSection, localDnsRecord);
      paramInt--;
    }
    return true;
  }
  
  final DnsResponse decode(A paramA1, A paramA2, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.readUnsignedShort();
    int j = paramByteBuf.readUnsignedShort();
    if (j >> 15 != 0)
    {
      paramA1 = newResponse(paramA1, paramA2, i, DnsOpCode.valueOf((byte)(j >> 11 & 0xF)), DnsResponseCode.valueOf((byte)(j & 0xF)));
      boolean bool1 = true;
      boolean bool2;
      if ((j >> 8 & 0x1) == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramA1.setRecursionDesired(bool2);
      if ((j >> 10 & 0x1) == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramA1.setAuthoritativeAnswer(bool2);
      if ((j >> 9 & 0x1) == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramA1.setTruncated(bool2);
      if ((j >> 7 & 0x1) == 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      paramA1.setRecursionAvailable(bool2);
      paramA1.setZ(j >> 4 & 0x7);
      try
      {
        int k = paramByteBuf.readUnsignedShort();
        i = paramByteBuf.readUnsignedShort();
        j = paramByteBuf.readUnsignedShort();
        int m = paramByteBuf.readUnsignedShort();
        decodeQuestions(paramA1, paramByteBuf, k);
        if (!decodeRecords(paramA1, DnsSection.ANSWER, paramByteBuf, i)) {
          return paramA1;
        }
        if (!decodeRecords(paramA1, DnsSection.AUTHORITY, paramByteBuf, j)) {
          return paramA1;
        }
        return paramA1;
      }
      finally
      {
        paramA1.release();
      }
    }
    throw new CorruptedFrameException("not a response");
  }
  
  protected abstract DnsResponse newResponse(A paramA1, A paramA2, int paramInt, DnsOpCode paramDnsOpCode, DnsResponseCode paramDnsResponseCode)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */