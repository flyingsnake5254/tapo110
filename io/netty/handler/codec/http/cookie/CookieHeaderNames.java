package io.netty.handler.codec.http.cookie;

public final class CookieHeaderNames
{
  public static final String DOMAIN = "Domain";
  public static final String EXPIRES = "Expires";
  public static final String HTTPONLY = "HTTPOnly";
  public static final String MAX_AGE = "Max-Age";
  public static final String PATH = "Path";
  public static final String SAMESITE = "SameSite";
  public static final String SECURE = "Secure";
  
  public static enum SameSite
  {
    static
    {
      SameSite localSameSite1 = new SameSite("Lax", 0);
      Lax = localSameSite1;
      SameSite localSameSite2 = new SameSite("Strict", 1);
      Strict = localSameSite2;
      SameSite localSameSite3 = new SameSite("None", 2);
      None = localSameSite3;
      $VALUES = new SameSite[] { localSameSite1, localSameSite2, localSameSite3 };
    }
    
    static SameSite of(String paramString)
    {
      if (paramString != null) {
        for (SameSite localSameSite : (SameSite[])SameSite.class.getEnumConstants()) {
          if (localSameSite.name().equalsIgnoreCase(paramString)) {
            return localSameSite;
          }
        }
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\CookieHeaderNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */