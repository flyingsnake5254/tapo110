package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public abstract interface DnsRecordEncoder
{
  public static final DnsRecordEncoder DEFAULT = new DefaultDnsRecordEncoder();
  
  public abstract void encodeQuestion(DnsQuestion paramDnsQuestion, ByteBuf paramByteBuf)
    throws Exception;
  
  public abstract void encodeRecord(DnsRecord paramDnsRecord, ByteBuf paramByteBuf)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsRecordEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */