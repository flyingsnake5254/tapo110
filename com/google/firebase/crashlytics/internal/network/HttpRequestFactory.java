package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

public class HttpRequestFactory
{
  public HttpGetRequest buildHttpGetRequest(String paramString)
  {
    return buildHttpGetRequest(paramString, Collections.emptyMap());
  }
  
  public HttpGetRequest buildHttpGetRequest(String paramString, Map<String, String> paramMap)
  {
    return new HttpGetRequest(paramString, paramMap);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\network\HttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */