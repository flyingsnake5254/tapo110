package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

public final class RtspMethods
{
  public static final HttpMethod ANNOUNCE;
  public static final HttpMethod DESCRIBE;
  public static final HttpMethod GET_PARAMETER;
  public static final HttpMethod OPTIONS;
  public static final HttpMethod PAUSE;
  public static final HttpMethod PLAY;
  public static final HttpMethod RECORD;
  public static final HttpMethod REDIRECT;
  public static final HttpMethod SETUP;
  public static final HttpMethod SET_PARAMETER;
  public static final HttpMethod TEARDOWN;
  private static final Map<String, HttpMethod> methodMap;
  
  static
  {
    HttpMethod localHttpMethod1 = HttpMethod.OPTIONS;
    OPTIONS = localHttpMethod1;
    HttpMethod localHttpMethod2 = HttpMethod.valueOf("DESCRIBE");
    DESCRIBE = localHttpMethod2;
    HttpMethod localHttpMethod3 = HttpMethod.valueOf("ANNOUNCE");
    ANNOUNCE = localHttpMethod3;
    HttpMethod localHttpMethod4 = HttpMethod.valueOf("SETUP");
    SETUP = localHttpMethod4;
    HttpMethod localHttpMethod5 = HttpMethod.valueOf("PLAY");
    PLAY = localHttpMethod5;
    HttpMethod localHttpMethod6 = HttpMethod.valueOf("PAUSE");
    PAUSE = localHttpMethod6;
    HttpMethod localHttpMethod7 = HttpMethod.valueOf("TEARDOWN");
    TEARDOWN = localHttpMethod7;
    HttpMethod localHttpMethod8 = HttpMethod.valueOf("GET_PARAMETER");
    GET_PARAMETER = localHttpMethod8;
    HttpMethod localHttpMethod9 = HttpMethod.valueOf("SET_PARAMETER");
    SET_PARAMETER = localHttpMethod9;
    HttpMethod localHttpMethod10 = HttpMethod.valueOf("REDIRECT");
    REDIRECT = localHttpMethod10;
    HttpMethod localHttpMethod11 = HttpMethod.valueOf("RECORD");
    RECORD = localHttpMethod11;
    HashMap localHashMap = new HashMap();
    methodMap = localHashMap;
    localHashMap.put(localHttpMethod2.toString(), localHttpMethod2);
    localHashMap.put(localHttpMethod3.toString(), localHttpMethod3);
    localHashMap.put(localHttpMethod8.toString(), localHttpMethod8);
    localHashMap.put(localHttpMethod1.toString(), localHttpMethod1);
    localHashMap.put(localHttpMethod6.toString(), localHttpMethod6);
    localHashMap.put(localHttpMethod5.toString(), localHttpMethod5);
    localHashMap.put(localHttpMethod11.toString(), localHttpMethod11);
    localHashMap.put(localHttpMethod10.toString(), localHttpMethod10);
    localHashMap.put(localHttpMethod4.toString(), localHttpMethod4);
    localHashMap.put(localHttpMethod9.toString(), localHttpMethod9);
    localHashMap.put(localHttpMethod7.toString(), localHttpMethod7);
  }
  
  public static HttpMethod valueOf(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    paramString = paramString.trim().toUpperCase();
    if (!paramString.isEmpty())
    {
      HttpMethod localHttpMethod = (HttpMethod)methodMap.get(paramString);
      if (localHttpMethod != null) {
        return localHttpMethod;
      }
      return HttpMethod.valueOf(paramString);
    }
    throw new IllegalArgumentException("empty name");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */