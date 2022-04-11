package com.tplink.libtpnetwork.libwss.enumerate;

public enum WssAccountLinkStatus
{
  static
  {
    WssAccountLinkStatus localWssAccountLinkStatus1 = new WssAccountLinkStatus("LINKED", 0);
    LINKED = localWssAccountLinkStatus1;
    WssAccountLinkStatus localWssAccountLinkStatus2 = new WssAccountLinkStatus("NO_ASSOCIATION", 1);
    NO_ASSOCIATION = localWssAccountLinkStatus2;
    $VALUES = new WssAccountLinkStatus[] { localWssAccountLinkStatus1, localWssAccountLinkStatus2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\enumerate\WssAccountLinkStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */