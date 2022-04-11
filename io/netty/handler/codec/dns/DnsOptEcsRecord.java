package io.netty.handler.codec.dns;

public abstract interface DnsOptEcsRecord
  extends DnsOptPseudoRecord
{
  public abstract byte[] address();
  
  public abstract int scopePrefixLength();
  
  public abstract int sourcePrefixLength();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsOptEcsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */