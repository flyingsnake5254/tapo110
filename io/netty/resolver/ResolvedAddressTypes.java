package io.netty.resolver;

public enum ResolvedAddressTypes
{
  static
  {
    ResolvedAddressTypes localResolvedAddressTypes1 = new ResolvedAddressTypes("IPV4_ONLY", 0);
    IPV4_ONLY = localResolvedAddressTypes1;
    ResolvedAddressTypes localResolvedAddressTypes2 = new ResolvedAddressTypes("IPV6_ONLY", 1);
    IPV6_ONLY = localResolvedAddressTypes2;
    ResolvedAddressTypes localResolvedAddressTypes3 = new ResolvedAddressTypes("IPV4_PREFERRED", 2);
    IPV4_PREFERRED = localResolvedAddressTypes3;
    ResolvedAddressTypes localResolvedAddressTypes4 = new ResolvedAddressTypes("IPV6_PREFERRED", 3);
    IPV6_PREFERRED = localResolvedAddressTypes4;
    $VALUES = new ResolvedAddressTypes[] { localResolvedAddressTypes1, localResolvedAddressTypes2, localResolvedAddressTypes3, localResolvedAddressTypes4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\ResolvedAddressTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */