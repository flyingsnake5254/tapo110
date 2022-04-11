package com.tplink.ssh2;

public enum EnumSSH2Status
{
  static
  {
    EnumSSH2Status localEnumSSH2Status1 = new EnumSSH2Status("SSH2_STATUS_IDLE", 0);
    SSH2_STATUS_IDLE = localEnumSSH2Status1;
    EnumSSH2Status localEnumSSH2Status2 = new EnumSSH2Status("SSH2_STATUS_CONNECTING", 1);
    SSH2_STATUS_CONNECTING = localEnumSSH2Status2;
    EnumSSH2Status localEnumSSH2Status3 = new EnumSSH2Status("SSH2_STATUS_CONNECTED", 2);
    SSH2_STATUS_CONNECTED = localEnumSSH2Status3;
    EnumSSH2Status localEnumSSH2Status4 = new EnumSSH2Status("SSH2_STATUS_DISCONNECTED", 3);
    SSH2_STATUS_DISCONNECTED = localEnumSSH2Status4;
    $VALUES = new EnumSSH2Status[] { localEnumSSH2Status1, localEnumSSH2Status2, localEnumSSH2Status3, localEnumSSH2Status4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\EnumSSH2Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */