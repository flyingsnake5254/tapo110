package com.tplink.iot.model.firmware;

public enum EnumIoTSeriesState
{
  static
  {
    EnumIoTSeriesState localEnumIoTSeriesState1 = new EnumIoTSeriesState("IDLE", 0);
    IDLE = localEnumIoTSeriesState1;
    EnumIoTSeriesState localEnumIoTSeriesState2 = new EnumIoTSeriesState("DOWNLOADING", 1);
    DOWNLOADING = localEnumIoTSeriesState2;
    EnumIoTSeriesState localEnumIoTSeriesState3 = new EnumIoTSeriesState("INSTALLING", 2);
    INSTALLING = localEnumIoTSeriesState3;
    EnumIoTSeriesState localEnumIoTSeriesState4 = new EnumIoTSeriesState("SUCCESS", 3);
    SUCCESS = localEnumIoTSeriesState4;
    $VALUES = new EnumIoTSeriesState[] { localEnumIoTSeriesState1, localEnumIoTSeriesState2, localEnumIoTSeriesState3, localEnumIoTSeriesState4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\firmware\EnumIoTSeriesState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */