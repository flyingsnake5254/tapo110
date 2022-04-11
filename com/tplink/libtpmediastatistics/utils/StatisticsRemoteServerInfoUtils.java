package com.tplink.libtpmediastatistics.utils;

public class StatisticsRemoteServerInfoUtils
{
  public static final String STAT_HOST = "analytics.tplinkcloud.com";
  public static final String STAT_HOST_BETA = "analytics-beta.tplinkcloud.com";
  
  public static String getStatServerName(String paramString)
  {
    if ((paramString != null) && (paramString.endsWith("beta.tplinkcloud.com"))) {
      return "analytics-beta.tplinkcloud.com";
    }
    return "analytics.tplinkcloud.com";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\utils\StatisticsRemoteServerInfoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */