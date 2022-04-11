package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

public enum FirmwareUpdateLevel
{
  private String level;
  
  static
  {
    FirmwareUpdateLevel localFirmwareUpdateLevel1 = new FirmwareUpdateLevel("LEVEL1", 0, "1");
    LEVEL1 = localFirmwareUpdateLevel1;
    FirmwareUpdateLevel localFirmwareUpdateLevel2 = new FirmwareUpdateLevel("LEVEL2", 1, "2");
    LEVEL2 = localFirmwareUpdateLevel2;
    FirmwareUpdateLevel localFirmwareUpdateLevel3 = new FirmwareUpdateLevel("LEVEL3", 2, "3");
    LEVEL3 = localFirmwareUpdateLevel3;
    FirmwareUpdateLevel localFirmwareUpdateLevel4 = new FirmwareUpdateLevel("LEVEL4", 3, "4");
    LEVEL4 = localFirmwareUpdateLevel4;
    $VALUES = new FirmwareUpdateLevel[] { localFirmwareUpdateLevel1, localFirmwareUpdateLevel2, localFirmwareUpdateLevel3, localFirmwareUpdateLevel4 };
  }
  
  private FirmwareUpdateLevel(String paramString)
  {
    this.level = paramString;
  }
  
  public static FirmwareUpdateLevel makeFirmwareUpdateLevel(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
          return LEVEL4;
        }
        return LEVEL3;
      }
      return LEVEL2;
    }
    return LEVEL1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\firmware\FirmwareUpdateLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */