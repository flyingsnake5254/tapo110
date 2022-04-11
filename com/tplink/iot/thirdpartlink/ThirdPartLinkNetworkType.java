package com.tplink.iot.thirdpartlink;

import kotlin.jvm.internal.j;

public enum ThirdPartLinkNetworkType
{
  public static final a Companion = new a(null);
  private String value;
  
  static
  {
    ThirdPartLinkNetworkType localThirdPartLinkNetworkType1 = new ThirdPartLinkNetworkType("AMAZON", 0, "amazon");
    AMAZON = localThirdPartLinkNetworkType1;
    ThirdPartLinkNetworkType localThirdPartLinkNetworkType2 = new ThirdPartLinkNetworkType("GOOGLE", 1, "google");
    GOOGLE = localThirdPartLinkNetworkType2;
    $VALUES = new ThirdPartLinkNetworkType[] { localThirdPartLinkNetworkType1, localThirdPartLinkNetworkType2 };
  }
  
  private ThirdPartLinkNetworkType(String paramString)
  {
    this.value = paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public final void setValue(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.value = paramString;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\thirdpartlink\ThirdPartLinkNetworkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */