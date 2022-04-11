package com.tplink.libtpmediastatistics;

public enum StatisticsStreamType
{
  private String value;
  
  static
  {
    StatisticsStreamType localStatisticsStreamType1 = new StatisticsStreamType("MIXED", 0, "mixed");
    MIXED = localStatisticsStreamType1;
    StatisticsStreamType localStatisticsStreamType2 = new StatisticsStreamType("VIDEO", 1, "video");
    VIDEO = localStatisticsStreamType2;
    StatisticsStreamType localStatisticsStreamType3 = new StatisticsStreamType("AUDIO", 2, "audio");
    AUDIO = localStatisticsStreamType3;
    StatisticsStreamType localStatisticsStreamType4 = new StatisticsStreamType("DOUBLE_TALK", 3, "dtspk");
    DOUBLE_TALK = localStatisticsStreamType4;
    StatisticsStreamType localStatisticsStreamType5 = new StatisticsStreamType("SD_VOD", 4, "sdvod");
    SD_VOD = localStatisticsStreamType5;
    StatisticsStreamType localStatisticsStreamType6 = new StatisticsStreamType("SD_DOWNLOAD", 5, "sd_download");
    SD_DOWNLOAD = localStatisticsStreamType6;
    $VALUES = new StatisticsStreamType[] { localStatisticsStreamType1, localStatisticsStreamType2, localStatisticsStreamType3, localStatisticsStreamType4, localStatisticsStreamType5, localStatisticsStreamType6 };
  }
  
  private StatisticsStreamType(String paramString)
  {
    this.value = paramString;
  }
  
  public static StatisticsStreamType fromValue(String paramString)
  {
    for (StatisticsStreamType localStatisticsStreamType : ) {
      if (localStatisticsStreamType.value.equalsIgnoreCase(paramString)) {
        return localStatisticsStreamType;
      }
    }
    return MIXED;
  }
  
  public String toString()
  {
    return value();
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\StatisticsStreamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */