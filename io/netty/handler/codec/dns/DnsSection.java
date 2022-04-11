package io.netty.handler.codec.dns;

public enum DnsSection
{
  static
  {
    DnsSection localDnsSection1 = new DnsSection("QUESTION", 0);
    QUESTION = localDnsSection1;
    DnsSection localDnsSection2 = new DnsSection("ANSWER", 1);
    ANSWER = localDnsSection2;
    DnsSection localDnsSection3 = new DnsSection("AUTHORITY", 2);
    AUTHORITY = localDnsSection3;
    DnsSection localDnsSection4 = new DnsSection("ADDITIONAL", 3);
    ADDITIONAL = localDnsSection4;
    $VALUES = new DnsSection[] { localDnsSection1, localDnsSection2, localDnsSection3, localDnsSection4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */