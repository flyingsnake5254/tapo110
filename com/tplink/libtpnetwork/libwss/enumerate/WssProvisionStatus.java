package com.tplink.libtpnetwork.libwss.enumerate;

public enum WssProvisionStatus
{
  static
  {
    WssProvisionStatus localWssProvisionStatus1 = new WssProvisionStatus("DISCOVERED", 0);
    DISCOVERED = localWssProvisionStatus1;
    WssProvisionStatus localWssProvisionStatus2 = new WssProvisionStatus("CONNECTED", 1);
    CONNECTED = localWssProvisionStatus2;
    WssProvisionStatus localWssProvisionStatus3 = new WssProvisionStatus("SECURE_CHANNEL_ESTABLISHED", 2);
    SECURE_CHANNEL_ESTABLISHED = localWssProvisionStatus3;
    WssProvisionStatus localWssProvisionStatus4 = new WssProvisionStatus("RETRIEVED_PROVISIONING_DETAILS", 3);
    RETRIEVED_PROVISIONING_DETAILS = localWssProvisionStatus4;
    WssProvisionStatus localWssProvisionStatus5 = new WssProvisionStatus("NETWORKED", 4);
    NETWORKED = localWssProvisionStatus5;
    WssProvisionStatus localWssProvisionStatus6 = new WssProvisionStatus("REGISTERED", 5);
    REGISTERED = localWssProvisionStatus6;
    WssProvisionStatus localWssProvisionStatus7 = new WssProvisionStatus("PROVISIONED", 6);
    PROVISIONED = localWssProvisionStatus7;
    WssProvisionStatus localWssProvisionStatus8 = new WssProvisionStatus("DONE", 7);
    DONE = localWssProvisionStatus8;
    $VALUES = new WssProvisionStatus[] { localWssProvisionStatus1, localWssProvisionStatus2, localWssProvisionStatus3, localWssProvisionStatus4, localWssProvisionStatus5, localWssProvisionStatus6, localWssProvisionStatus7, localWssProvisionStatus8 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\enumerate\WssProvisionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */