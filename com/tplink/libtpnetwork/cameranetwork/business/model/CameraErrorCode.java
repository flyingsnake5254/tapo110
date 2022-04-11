package com.tplink.libtpnetwork.cameranetwork.business.model;

public enum CameraErrorCode
{
  private final int rawCode;
  
  static
  {
    CameraErrorCode localCameraErrorCode1 = new CameraErrorCode("SESSION_EXPIRED", 0, -40401);
    SESSION_EXPIRED = localCameraErrorCode1;
    CameraErrorCode localCameraErrorCode2 = new CameraErrorCode("DEVICE_BLOCKED", 1, -40404);
    DEVICE_BLOCKED = localCameraErrorCode2;
    CameraErrorCode localCameraErrorCode3 = new CameraErrorCode("DEVICE_FACTORY", 2, -40405);
    DEVICE_FACTORY = localCameraErrorCode3;
    CameraErrorCode localCameraErrorCode4 = new CameraErrorCode("OUT_OF_LIMIT", 3, -40406);
    OUT_OF_LIMIT = localCameraErrorCode4;
    CameraErrorCode localCameraErrorCode5 = new CameraErrorCode("OTHER_ERROR", 4, -40407);
    OTHER_ERROR = localCameraErrorCode5;
    CameraErrorCode localCameraErrorCode6 = new CameraErrorCode("SYSTEM_BLOCKED", 5, -40408);
    SYSTEM_BLOCKED = localCameraErrorCode6;
    CameraErrorCode localCameraErrorCode7 = new CameraErrorCode("NONCE_EXPIRED", 6, -40409);
    NONCE_EXPIRED = localCameraErrorCode7;
    CameraErrorCode localCameraErrorCode8 = new CameraErrorCode("FFS_NONE_PWD", 7, -90000);
    FFS_NONE_PWD = localCameraErrorCode8;
    $VALUES = new CameraErrorCode[] { localCameraErrorCode1, localCameraErrorCode2, localCameraErrorCode3, localCameraErrorCode4, localCameraErrorCode5, localCameraErrorCode6, localCameraErrorCode7, localCameraErrorCode8 };
  }
  
  private CameraErrorCode(int paramInt)
  {
    this.rawCode = paramInt;
  }
  
  public final int getRawCode()
  {
    return this.rawCode;
  }
  
  public final boolean isEqual(int paramInt)
  {
    boolean bool;
    if (this.rawCode == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\CameraErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */