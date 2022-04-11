package com.tplink.libtpnetwork.enumerate;

public enum EnumFeatureType
{
  private String name;
  
  static
  {
    EnumFeatureType localEnumFeatureType1 = new EnumFeatureType("ON_OFF_GRADUALLY", 0, "onOffGradually");
    ON_OFF_GRADUALLY = localEnumFeatureType1;
    EnumFeatureType localEnumFeatureType2 = new EnumFeatureType("LED_MODE", 1, "ledMode");
    LED_MODE = localEnumFeatureType2;
    EnumFeatureType localEnumFeatureType3 = new EnumFeatureType("TRIGGER_CONFIG", 2, "triggerConfig");
    TRIGGER_CONFIG = localEnumFeatureType3;
    EnumFeatureType localEnumFeatureType4 = new EnumFeatureType("ON_OFF_DELAY", 3, "onOffDelay");
    ON_OFF_DELAY = localEnumFeatureType4;
    EnumFeatureType localEnumFeatureType5 = new EnumFeatureType("DOUBLE_CLICK_CONFIG", 4, "doubleClickConfig");
    DOUBLE_CLICK_CONFIG = localEnumFeatureType5;
    EnumFeatureType localEnumFeatureType6 = new EnumFeatureType("AUTO_UPDATE_MODE", 5, "autoUpdateMode");
    AUTO_UPDATE_MODE = localEnumFeatureType6;
    EnumFeatureType localEnumFeatureType7 = new EnumFeatureType("SEGMENT_CONFIG", 6, "segmentConfig");
    SEGMENT_CONFIG = localEnumFeatureType7;
    EnumFeatureType localEnumFeatureType8 = new EnumFeatureType("FROST_PROTECTION_CONFIG", 7, "frostProtectionConfig");
    FROST_PROTECTION_CONFIG = localEnumFeatureType8;
    EnumFeatureType localEnumFeatureType9 = new EnumFeatureType("CHILD_PROTECTION_MODE", 8, "childProtectionMode");
    CHILD_PROTECTION_MODE = localEnumFeatureType9;
    EnumFeatureType localEnumFeatureType10 = new EnumFeatureType("TEMPERATURE_RANGE", 9, "temperatureRange");
    TEMPERATURE_RANGE = localEnumFeatureType10;
    EnumFeatureType localEnumFeatureType11 = new EnumFeatureType("WINDOW_OPEN_DETECTION", 10, "windowOpenDetection");
    WINDOW_OPEN_DETECTION = localEnumFeatureType11;
    EnumFeatureType localEnumFeatureType12 = new EnumFeatureType("AUTO_REMOVE_SCALE", 11, "autoRemoveScale");
    AUTO_REMOVE_SCALE = localEnumFeatureType12;
    EnumFeatureType localEnumFeatureType13 = new EnumFeatureType("SHUTDOWN_MODE", 12, "shutDownMode");
    SHUTDOWN_MODE = localEnumFeatureType13;
    EnumFeatureType localEnumFeatureType14 = new EnumFeatureType("EARLY_START", 13, "earlyStart");
    EARLY_START = localEnumFeatureType14;
    EnumFeatureType localEnumFeatureType15 = new EnumFeatureType("BATTERY_DETECTION", 14, "batteryDetection");
    BATTERY_DETECTION = localEnumFeatureType15;
    EnumFeatureType localEnumFeatureType16 = new EnumFeatureType("MUSIC_RHYTHM_GLOBAL_CONFIG", 15, "musicRhythmGlobalConfig");
    MUSIC_RHYTHM_GLOBAL_CONFIG = localEnumFeatureType16;
    EnumFeatureType localEnumFeatureType17 = new EnumFeatureType("MUSIC_RHYTHM_CRYPTO", 16, "musicRhythmCrypto");
    MUSIC_RHYTHM_CRYPTO = localEnumFeatureType17;
    $VALUES = new EnumFeatureType[] { localEnumFeatureType1, localEnumFeatureType2, localEnumFeatureType3, localEnumFeatureType4, localEnumFeatureType5, localEnumFeatureType6, localEnumFeatureType7, localEnumFeatureType8, localEnumFeatureType9, localEnumFeatureType10, localEnumFeatureType11, localEnumFeatureType12, localEnumFeatureType13, localEnumFeatureType14, localEnumFeatureType15, localEnumFeatureType16, localEnumFeatureType17 };
  }
  
  private EnumFeatureType(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumFeatureType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */