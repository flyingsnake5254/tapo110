package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public abstract interface DnsRawRecord
  extends DnsRecord, ByteBufHolder
{
  public abstract DnsRawRecord copy();
  
  public abstract DnsRawRecord duplicate();
  
  public abstract DnsRawRecord replace(ByteBuf paramByteBuf);
  
  public abstract DnsRawRecord retain();
  
  public abstract DnsRawRecord retain(int paramInt);
  
  public abstract DnsRawRecord retainedDuplicate();
  
  public abstract DnsRawRecord touch();
  
  public abstract DnsRawRecord touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsRawRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */