package com.google.firebase.crashlytics.internal.network;

public class HttpResponse
{
  private final String body;
  private final int code;
  
  public HttpResponse(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.body = paramString;
  }
  
  public String body()
  {
    return this.body;
  }
  
  public int code()
  {
    return this.code;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\network\HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */