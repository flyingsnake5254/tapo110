package io.netty.handler.codec.http.cookie;

public abstract class CookieEncoder
{
  protected final boolean strict;
  
  protected CookieEncoder(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  protected void validateCookie(String paramString1, String paramString2)
  {
    if (this.strict)
    {
      int i = CookieUtil.firstInvalidCookieNameOctet(paramString1);
      if (i < 0)
      {
        paramString1 = CookieUtil.unwrapValue(paramString2);
        if (paramString1 != null)
        {
          i = CookieUtil.firstInvalidCookieValueOctet(paramString1);
          if (i >= 0)
          {
            paramString2 = new StringBuilder();
            paramString2.append("Cookie value contains an invalid char: ");
            paramString2.append(paramString1.charAt(i));
            throw new IllegalArgumentException(paramString2.toString());
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("Cookie value wrapping quotes are not balanced: ");
          paramString1.append(paramString2);
          throw new IllegalArgumentException(paramString1.toString());
        }
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append("Cookie name contains an invalid char: ");
        paramString2.append(paramString1.charAt(i));
        throw new IllegalArgumentException(paramString2.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\CookieEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */