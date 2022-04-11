package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class v
{
  private static final Pattern a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
  private static final Pattern b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
  
  @Nullable
  public static String a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (paramLong2 == -1L)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("-");
    if (paramLong2 != -1L) {
      localStringBuilder.append(paramLong1 + paramLong2 - 1L);
    }
    return localStringBuilder.toString();
  }
  
  public static long b(@Nullable String paramString1, @Nullable String paramString2)
  {
    long l1;
    Object localObject;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject = new StringBuilder(String.valueOf(paramString1).length() + 28);
        ((StringBuilder)localObject).append("Unexpected Content-Length [");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("]");
        u.c("HttpUtil", ((StringBuilder)localObject).toString());
      }
    } else {
      l1 = -1L;
    }
    long l2 = l1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = a.matcher(paramString2);
      l2 = l1;
      if (((Matcher)localObject).matches()) {
        try
        {
          long l3 = Long.parseLong((String)g.e(((Matcher)localObject).group(2))) - Long.parseLong((String)g.e(((Matcher)localObject).group(1))) + 1L;
          if (l1 < 0L)
          {
            l2 = l3;
          }
          else
          {
            l2 = l1;
            if (l1 != l3)
            {
              int i = String.valueOf(paramString1).length();
              int j = String.valueOf(paramString2).length();
              localObject = new java/lang/StringBuilder;
              ((StringBuilder)localObject).<init>(i + 26 + j);
              ((StringBuilder)localObject).append("Inconsistent headers [");
              ((StringBuilder)localObject).append(paramString1);
              ((StringBuilder)localObject).append("] [");
              ((StringBuilder)localObject).append(paramString2);
              ((StringBuilder)localObject).append("]");
              u.h("HttpUtil", ((StringBuilder)localObject).toString());
              l2 = Math.max(l1, l3);
            }
          }
        }
        catch (NumberFormatException paramString1)
        {
          paramString1 = new StringBuilder(String.valueOf(paramString2).length() + 27);
          paramString1.append("Unexpected Content-Range [");
          paramString1.append(paramString2);
          paramString1.append("]");
          u.c("HttpUtil", paramString1.toString());
          l2 = l1;
        }
      }
    }
    return l2;
  }
  
  public static long c(@Nullable String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l = -1L;
    if (bool) {
      return -1L;
    }
    paramString = b.matcher(paramString);
    if (paramString.matches()) {
      l = Long.parseLong((String)g.e(paramString.group(1)));
    }
    return l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */