package com.tplink.libtpnetwork.cameranetwork.model;

public enum FirmwareUpgradeStatus
{
  static
  {
    FirmwareUpgradeStatus localFirmwareUpgradeStatus1 = new FirmwareUpgradeStatus("DOWNLOADING", 0);
    DOWNLOADING = localFirmwareUpgradeStatus1;
    FirmwareUpgradeStatus localFirmwareUpgradeStatus2 = new FirmwareUpgradeStatus("REBOOTING", 1);
    REBOOTING = localFirmwareUpgradeStatus2;
    FirmwareUpgradeStatus localFirmwareUpgradeStatus3 = new FirmwareUpgradeStatus("NORMAL", 2);
    NORMAL = localFirmwareUpgradeStatus3;
    FirmwareUpgradeStatus localFirmwareUpgradeStatus4 = new FirmwareUpgradeStatus("UPDATE_ENABLE", 3);
    UPDATE_ENABLE = localFirmwareUpgradeStatus4;
    FirmwareUpgradeStatus localFirmwareUpgradeStatus5 = new FirmwareUpgradeStatus("FAIL", 4);
    FAIL = localFirmwareUpgradeStatus5;
    $VALUES = new FirmwareUpgradeStatus[] { localFirmwareUpgradeStatus1, localFirmwareUpgradeStatus2, localFirmwareUpgradeStatus3, localFirmwareUpgradeStatus4, localFirmwareUpgradeStatus5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\FirmwareUpgradeStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */