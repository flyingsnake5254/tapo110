package com.tplink.libtpnetwork.cameranetwork.business.model;

public enum PlayBackEventType
{
  private String name;
  private int value;
  
  static
  {
    PlayBackEventType localPlayBackEventType1 = new PlayBackEventType("TYPE_TIMING", 0, 1, "1");
    TYPE_TIMING = localPlayBackEventType1;
    PlayBackEventType localPlayBackEventType2 = new PlayBackEventType("TYPE_MOTION", 1, 2, "2");
    TYPE_MOTION = localPlayBackEventType2;
    PlayBackEventType localPlayBackEventType3 = new PlayBackEventType("TYPE_MASK", 2, 3, "3");
    TYPE_MASK = localPlayBackEventType3;
    $VALUES = new PlayBackEventType[] { localPlayBackEventType1, localPlayBackEventType2, localPlayBackEventType3 };
  }
  
  private PlayBackEventType(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\PlayBackEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */