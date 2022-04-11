package io.netty.handler.codec.dns;

public abstract interface DnsOptPseudoRecord
  extends DnsRecord
{
  public abstract int extendedRcode();
  
  public abstract int flags();
  
  public abstract int version();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsOptPseudoRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */