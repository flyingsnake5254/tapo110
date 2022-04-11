package okhttp3.internal.http;

public final class HttpMethod
{
  public static boolean invalidatesCache(String paramString)
  {
    boolean bool;
    if ((!paramString.equals("POST")) && (!paramString.equals("PATCH")) && (!paramString.equals("PUT")) && (!paramString.equals("DELETE")) && (!paramString.equals("MOVE"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean permitsRequestBody(String paramString)
  {
    boolean bool;
    if ((!paramString.equals("GET")) && (!paramString.equals("HEAD"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean redirectsToGet(String paramString)
  {
    return paramString.equals("PROPFIND") ^ true;
  }
  
  public static boolean redirectsWithBody(String paramString)
  {
    return paramString.equals("PROPFIND");
  }
  
  public static boolean requiresRequestBody(String paramString)
  {
    boolean bool;
    if ((!paramString.equals("POST")) && (!paramString.equals("PUT")) && (!paramString.equals("PATCH")) && (!paramString.equals("PROPPATCH")) && (!paramString.equals("REPORT"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http\HttpMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */