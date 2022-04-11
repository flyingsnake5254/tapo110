package com.tplink.libtpnetwork.cameranetwork.net;

public class CameraException
  extends Exception
{
  public static final int DEVICE_NAME_EXCESSIVE = -63103;
  public static final int METHOD_DO_NOT_EXIST = -40210;
  public static final int MOTOR_BUSY = -64303;
  public static final int MOTOR_LOCKED_ROTOR = -64304;
  public static final int PRESET_ADD_MOVING = -64305;
  public static final int PRESET_SATURATED = -64306;
  public static final int SD_CARD_UNPLUGGED = -52409;
  public static final int TALK_IS_USED = -52411;
  public static final int TALK_WAY_WAS_USED = -52411;
  public static final int TOO_MANY_CLIENT = -52407;
  public static final int TOO_MANY_HTTPS_CLIENT = -52419;
  public static final int TOO_MANY_REQUEST = -52405;
  public static final int USER_ID_EMPLOYED = -71102;
  public static final int USER_ID_FULL = -71101;
  public static final int USER_ID_INVALID = -71103;
  public static final int VOD_INVALID_REQUEST = -52402;
  private final int errorCode;
  private final String message;
  private final String method;
  
  public CameraException(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.method = null;
    this.message = paramString;
  }
  
  public CameraException(int paramInt, String paramString1, String paramString2)
  {
    this.errorCode = paramInt;
    this.method = paramString1;
    this.message = paramString2;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getMethod()
  {
    return this.method;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\net\CameraException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */