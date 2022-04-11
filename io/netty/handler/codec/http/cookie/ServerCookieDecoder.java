package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class ServerCookieDecoder
  extends CookieDecoder
{
  public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);
  private static final String RFC2965_DOMAIN = "$Domain";
  private static final String RFC2965_PATH = "$Path";
  private static final String RFC2965_PORT = "$Port";
  private static final String RFC2965_VERSION = "$Version";
  public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
  
  private ServerCookieDecoder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private void decode(Collection<? super Cookie> paramCollection, String paramString)
  {
    int i = ((String)ObjectUtil.checkNotNull(paramString, "header")).length();
    if (i == 0) {
      return;
    }
    boolean bool = paramString.regionMatches(true, 0, "$Version", 0, 8);
    int j = 1;
    int k;
    int n;
    if (bool)
    {
      k = paramString.indexOf(';') + 1;
      m = k;
      n = j;
    }
    else
    {
      n = 0;
    }
    for (int m = 0;; m++)
    {
      if (m == i) {
        return;
      }
      int i1 = paramString.charAt(m);
      if ((i1 != 9) && (i1 != 10) && (i1 != 11) && (i1 != 12) && (i1 != 13) && (i1 != 32) && (i1 != 44) && (i1 != 59))
      {
        i1 = m;
        int i2 = paramString.charAt(i1);
        if (i2 == 59) {}
        int i3;
        int i4;
        for (i2 = i1;; i2 = i3)
        {
          i3 = -1;
          i4 = -1;
          break label278;
          if (i2 == 61)
          {
            i3 = i1 + 1;
            if (i3 == i)
            {
              i2 = i1;
              i1 = i3;
              i3 = 0;
              i4 = 0;
              break label278;
            }
            i2 = paramString.indexOf(';', i3);
            if (i2 <= 0) {
              i2 = i;
            }
            k = i1;
            i1 = i2;
            i4 = i1;
            i2 = k;
            break label278;
          }
          i2 = i1 + 1;
          i1 = i2;
          if (i2 != i) {
            break;
          }
          i3 = i;
          i1 = i2;
        }
        label278:
        if (n != 0)
        {
          k = i1;
          j = n;
          if (paramString.regionMatches(m, "$Path", 0, 5)) {
            break;
          }
          k = i1;
          j = n;
          if (paramString.regionMatches(m, "$Domain", 0, 7)) {
            break;
          }
          if (paramString.regionMatches(m, "$Port", 0, 5))
          {
            k = i1;
            j = n;
            break;
          }
        }
        DefaultCookie localDefaultCookie = initCookie(paramString, m, i2, i3, i4);
        k = i1;
        j = n;
        if (localDefaultCookie == null) {
          break;
        }
        paramCollection.add(localDefaultCookie);
        k = i1;
        j = n;
        break;
      }
    }
  }
  
  public Set<Cookie> decode(String paramString)
  {
    TreeSet localTreeSet = new TreeSet();
    decode(localTreeSet, paramString);
    return localTreeSet;
  }
  
  public List<Cookie> decodeAll(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    decode(localArrayList, paramString);
    return Collections.unmodifiableList(localArrayList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\ServerCookieDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */