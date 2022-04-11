package com.tplink.libtpnetwork.libwss.bean.result;

public final class AppToAppLinkStatusResult
{
  private AppToAppLinking appToAppLinking;
  private String authorizationUrl;
  private boolean linkStatus;
  
  public final AppToAppLinking getAppToAppLinking()
  {
    return this.appToAppLinking;
  }
  
  public final String getAuthorizationUrl()
  {
    return this.authorizationUrl;
  }
  
  public final boolean getLinkStatus()
  {
    return this.linkStatus;
  }
  
  public final void setAppToAppLinking(AppToAppLinking paramAppToAppLinking)
  {
    this.appToAppLinking = paramAppToAppLinking;
  }
  
  public final void setAuthorizationUrl(String paramString)
  {
    this.authorizationUrl = paramString;
  }
  
  public final void setLinkStatus(boolean paramBoolean)
  {
    this.linkStatus = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppToAppLinkStatusResult( linkStatus=");
    localStringBuilder.append(this.linkStatus);
    localStringBuilder.append(", authorizationUrl=");
    localStringBuilder.append(this.authorizationUrl);
    localStringBuilder.append(", appToAppLinking=");
    localStringBuilder.append(this.appToAppLinking);
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
  
  public static final class AppToAppLinking
  {
    private Platform android;
    private Platform ios;
    
    public final Platform getAndroid()
    {
      return this.android;
    }
    
    public final Platform getIos()
    {
      return this.ios;
    }
    
    public final void setAndroid(Platform paramPlatform)
    {
      this.android = paramPlatform;
    }
    
    public final void setIos(Platform paramPlatform)
    {
      this.ios = paramPlatform;
    }
    
    public static final class Platform
    {
      private String appToAppLinkingUrl;
      
      public final String getAppToAppLinkingUrl()
      {
        return this.appToAppLinkingUrl;
      }
      
      public final void setAppToAppLinkingUrl(String paramString)
      {
        this.appToAppLinkingUrl = paramString;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\result\AppToAppLinkStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */