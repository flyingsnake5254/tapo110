package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.Date;

public final class ClientCookieDecoder
  extends CookieDecoder
{
  public static final ClientCookieDecoder LAX = new ClientCookieDecoder(false);
  public static final ClientCookieDecoder STRICT = new ClientCookieDecoder(true);
  
  private ClientCookieDecoder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public Cookie decode(String paramString)
  {
    int i = ((String)ObjectUtil.checkNotNull(paramString, "header")).length();
    Object localObject1 = null;
    if (i == 0) {
      return null;
    }
    Object localObject2 = null;
    int j = 0;
    for (;;)
    {
      int k;
      if (j != i)
      {
        k = paramString.charAt(j);
        if (k != 44) {}
      }
      else
      {
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = ((CookieBuilder)localObject2).cookie();
        }
        return paramString;
      }
      if ((k != 9) && (k != 10) && (k != 11) && (k != 12) && (k != 13) && (k != 32) && (k != 59))
      {
        k = j;
        int m = paramString.charAt(k);
        if (m == 59) {
          m = k;
        }
        int i1;
        for (int n = k;; n = i)
        {
          k = -1;
          i1 = -1;
          break label244;
          if (m == 61)
          {
            i1 = k + 1;
            if (i1 == i)
            {
              n = k;
              m = i1;
              k = 0;
              i1 = 0;
              break label244;
            }
            m = paramString.indexOf(';', i1);
            if (m <= 0) {
              m = i;
            }
            n = k;
            k = m;
            break label244;
          }
          m = k + 1;
          k = m;
          if (m != i) {
            break;
          }
        }
        label244:
        int i2 = k;
        if (k > 0)
        {
          i2 = k;
          if (paramString.charAt(k - 1) == ',') {
            i2 = k - 1;
          }
        }
        if (localObject2 == null)
        {
          localObject2 = initCookie(paramString, j, n, i1, i2);
          if (localObject2 == null) {
            return null;
          }
          localObject2 = new CookieBuilder((DefaultCookie)localObject2, paramString);
        }
        else
        {
          ((CookieBuilder)localObject2).appendAttribute(j, n, i1, i2);
        }
        j = m;
      }
      else
      {
        j++;
      }
    }
  }
  
  private static class CookieBuilder
  {
    private final DefaultCookie cookie;
    private String domain;
    private int expiresEnd;
    private int expiresStart;
    private final String header;
    private boolean httpOnly;
    private long maxAge = Long.MIN_VALUE;
    private String path;
    private CookieHeaderNames.SameSite sameSite;
    private boolean secure;
    
    CookieBuilder(DefaultCookie paramDefaultCookie, String paramString)
    {
      this.cookie = paramDefaultCookie;
      this.header = paramString;
    }
    
    private String computeValue(int paramInt1, int paramInt2)
    {
      String str;
      if (isValueDefined(paramInt1, paramInt2)) {
        str = this.header.substring(paramInt1, paramInt2);
      } else {
        str = null;
      }
      return str;
    }
    
    private static boolean isValueDefined(int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((paramInt1 != -1) && (paramInt1 != paramInt2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private long mergeMaxAgeAndExpires()
    {
      long l1 = this.maxAge;
      if (l1 != Long.MIN_VALUE) {
        return l1;
      }
      if (isValueDefined(this.expiresStart, this.expiresEnd))
      {
        Date localDate = DateFormatter.parseHttpDate(this.header, this.expiresStart, this.expiresEnd);
        if (localDate != null)
        {
          long l2 = localDate.getTime() - System.currentTimeMillis();
          l1 = l2 / 1000L;
          int i;
          if (l2 % 1000L != 0L) {
            i = 1;
          } else {
            i = 0;
          }
          return l1 + i;
        }
      }
      return Long.MIN_VALUE;
    }
    
    private void parse4(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.header.regionMatches(true, paramInt1, "Path", 0, 4)) {
        this.path = computeValue(paramInt2, paramInt3);
      }
    }
    
    private void parse6(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.header.regionMatches(true, paramInt1, "Domain", 0, 5)) {
        this.domain = computeValue(paramInt2, paramInt3);
      } else if (this.header.regionMatches(true, paramInt1, "Secure", 0, 5)) {
        this.secure = true;
      }
    }
    
    private void parse7(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.header.regionMatches(true, paramInt1, "Expires", 0, 7))
      {
        this.expiresStart = paramInt2;
        this.expiresEnd = paramInt3;
      }
      else if (this.header.regionMatches(true, paramInt1, "Max-Age", 0, 7))
      {
        setMaxAge(computeValue(paramInt2, paramInt3));
      }
    }
    
    private void parse8(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.header.regionMatches(true, paramInt1, "HTTPOnly", 0, 8)) {
        this.httpOnly = true;
      } else if (this.header.regionMatches(true, paramInt1, "SameSite", 0, 8)) {
        this.sameSite = CookieHeaderNames.SameSite.of(computeValue(paramInt2, paramInt3));
      }
    }
    
    private void setMaxAge(String paramString)
    {
      try
      {
        this.maxAge = Math.max(Long.parseLong(paramString), 0L);
        return;
      }
      catch (NumberFormatException paramString)
      {
        for (;;) {}
      }
    }
    
    void appendAttribute(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 -= paramInt1;
      if (paramInt2 == 4) {
        parse4(paramInt1, paramInt3, paramInt4);
      } else if (paramInt2 == 6) {
        parse6(paramInt1, paramInt3, paramInt4);
      } else if (paramInt2 == 7) {
        parse7(paramInt1, paramInt3, paramInt4);
      } else if (paramInt2 == 8) {
        parse8(paramInt1, paramInt3, paramInt4);
      }
    }
    
    Cookie cookie()
    {
      this.cookie.setDomain(this.domain);
      this.cookie.setPath(this.path);
      this.cookie.setMaxAge(mergeMaxAgeAndExpires());
      this.cookie.setSecure(this.secure);
      this.cookie.setHttpOnly(this.httpOnly);
      this.cookie.setSameSite(this.sameSite);
      return this.cookie;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\ClientCookieDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */