package com.tplink.libtpnetwork.libwss.enumerate;

public enum WssFfsLinkStatus
{
  static
  {
    WssFfsLinkStatus localWssFfsLinkStatus1 = new WssFfsLinkStatus("LINKED", 0);
    LINKED = localWssFfsLinkStatus1;
    WssFfsLinkStatus localWssFfsLinkStatus2 = new WssFfsLinkStatus("NO_ASSOCIATION", 1);
    NO_ASSOCIATION = localWssFfsLinkStatus2;
    $VALUES = new WssFfsLinkStatus[] { localWssFfsLinkStatus1, localWssFfsLinkStatus2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\enumerate\WssFfsLinkStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */