package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public abstract interface DnsRecordDecoder
{
  public static final DnsRecordDecoder DEFAULT = new DefaultDnsRecordDecoder();
  
  public abstract DnsQuestion decodeQuestion(ByteBuf paramByteBuf)
    throws Exception;
  
  public abstract <T extends DnsRecord> T decodeRecord(ByteBuf paramByteBuf)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsRecordDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */