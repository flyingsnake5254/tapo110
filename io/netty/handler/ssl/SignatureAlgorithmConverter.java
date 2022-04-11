package io.netty.handler.ssl;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SignatureAlgorithmConverter
{
  private static final Pattern PATTERN = Pattern.compile("(?:(^[a-zA-Z].+)With(.+)Encryption$)|(?:(^[a-zA-Z].+)(?:_with_|-with-|_pkcs1_|_pss_rsae_)(.+$))|(?:(^[a-zA-Z].+)_(.+$))");
  
  static String toJavaName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = PATTERN.matcher(paramString);
    if (paramString.matches())
    {
      String str = paramString.group(1);
      Object localObject1;
      Object localObject2;
      if (str != null)
      {
        localObject1 = new StringBuilder();
        localObject2 = Locale.ROOT;
        ((StringBuilder)localObject1).append(str.toUpperCase((Locale)localObject2));
        ((StringBuilder)localObject1).append("with");
        ((StringBuilder)localObject1).append(paramString.group(2).toUpperCase((Locale)localObject2));
        return ((StringBuilder)localObject1).toString();
      }
      if (paramString.group(3) != null)
      {
        localObject2 = new StringBuilder();
        str = paramString.group(4);
        localObject1 = Locale.ROOT;
        ((StringBuilder)localObject2).append(str.toUpperCase((Locale)localObject1));
        ((StringBuilder)localObject2).append("with");
        ((StringBuilder)localObject2).append(paramString.group(3).toUpperCase((Locale)localObject1));
        return ((StringBuilder)localObject2).toString();
      }
      if (paramString.group(5) != null)
      {
        localObject2 = new StringBuilder();
        str = paramString.group(6);
        localObject1 = Locale.ROOT;
        ((StringBuilder)localObject2).append(str.toUpperCase((Locale)localObject1));
        ((StringBuilder)localObject2).append("with");
        ((StringBuilder)localObject2).append(paramString.group(5).toUpperCase((Locale)localObject1));
        return ((StringBuilder)localObject2).toString();
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SignatureAlgorithmConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */