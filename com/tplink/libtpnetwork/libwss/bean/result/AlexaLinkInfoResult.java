package com.tplink.libtpnetwork.libwss.bean.result;

import java.io.Serializable;
import kotlin.jvm.internal.j;

public final class AlexaLinkInfoResult
  implements Serializable
{
  private String androidUrl;
  private String authorizationUrl;
  private String iosUrl;
  private boolean linkStatus;
  
  public AlexaLinkInfoResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.linkStatus = paramBoolean;
    this.authorizationUrl = paramString1;
    this.iosUrl = paramString2;
    this.androidUrl = paramString3;
  }
  
  public final boolean component1()
  {
    return this.linkStatus;
  }
  
  public final String component2()
  {
    return this.authorizationUrl;
  }
  
  public final String component3()
  {
    return this.iosUrl;
  }
  
  public final String component4()
  {
    return this.androidUrl;
  }
  
  public final AlexaLinkInfoResult copy(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    return new AlexaLinkInfoResult(paramBoolean, paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AlexaLinkInfoResult))
      {
        paramObject = (AlexaLinkInfoResult)paramObject;
        if ((this.linkStatus == ((AlexaLinkInfoResult)paramObject).linkStatus) && (j.a(this.authorizationUrl, ((AlexaLinkInfoResult)paramObject).authorizationUrl)) && (j.a(this.iosUrl, ((AlexaLinkInfoResult)paramObject).iosUrl)) && (j.a(this.androidUrl, ((AlexaLinkInfoResult)paramObject).androidUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAndroidUrl()
  {
    return this.androidUrl;
  }
  
  public final String getAuthorizationUrl()
  {
    return this.authorizationUrl;
  }
  
  public final String getIosUrl()
  {
    return this.iosUrl;
  }
  
  public final boolean getLinkStatus()
  {
    return this.linkStatus;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.linkStatus;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    String str = this.authorizationUrl;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.iosUrl;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.androidUrl;
    if (str != null) {
      j = str.hashCode();
    }
    return ((bool2 * true + i) * 31 + k) * 31 + j;
  }
  
  public final void setAndroidUrl(String paramString)
  {
    this.androidUrl = paramString;
  }
  
  public final void setAuthorizationUrl(String paramString)
  {
    this.authorizationUrl = paramString;
  }
  
  public final void setIosUrl(String paramString)
  {
    this.iosUrl = paramString;
  }
  
  public final void setLinkStatus(boolean paramBoolean)
  {
    this.linkStatus = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlexaLinkInfoResult(linkStatus=");
    localStringBuilder.append(this.linkStatus);
    localStringBuilder.append(", authorizationUrl=");
    localStringBuilder.append(this.authorizationUrl);
    localStringBuilder.append(", iosUrl=");
    localStringBuilder.append(this.iosUrl);
    localStringBuilder.append(", androidUrl=");
    localStringBuilder.append(this.androidUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\result\AlexaLinkInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */