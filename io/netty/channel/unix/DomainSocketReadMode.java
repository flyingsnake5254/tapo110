package io.netty.channel.unix;

public enum DomainSocketReadMode
{
  static
  {
    DomainSocketReadMode localDomainSocketReadMode1 = new DomainSocketReadMode("BYTES", 0);
    BYTES = localDomainSocketReadMode1;
    DomainSocketReadMode localDomainSocketReadMode2 = new DomainSocketReadMode("FILE_DESCRIPTORS", 1);
    FILE_DESCRIPTORS = localDomainSocketReadMode2;
    $VALUES = new DomainSocketReadMode[] { localDomainSocketReadMode1, localDomainSocketReadMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\DomainSocketReadMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */