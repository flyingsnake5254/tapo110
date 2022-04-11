package com.google.android.exoplayer2.text.u;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");
  
  @Nullable
  public static Matcher a(d0 paramd0)
  {
    Object localObject;
    do
    {
      localObject = paramd0.p();
      if (localObject == null) {
        break;
      }
      if (a.matcher((CharSequence)localObject).matches()) {
        for (;;)
        {
          localObject = paramd0.p();
          if ((localObject == null) || (((String)localObject).isEmpty())) {
            break;
          }
        }
      }
      localObject = h.a.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    return (Matcher)localObject;
    return null;
  }
  
  public static boolean b(d0 paramd0)
  {
    paramd0 = paramd0.p();
    boolean bool;
    if ((paramd0 != null) && (paramd0.startsWith("WEBVTT"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static float c(String paramString)
    throws NumberFormatException
  {
    if (paramString.endsWith("%")) {
      return Float.parseFloat(paramString.substring(0, paramString.length() - 1)) / 100.0F;
    }
    throw new NumberFormatException("Percentages must end with %");
  }
  
  public static long d(String paramString)
    throws NumberFormatException
  {
    paramString = o0.F0(paramString, "\\.");
    int i = 0;
    String[] arrayOfString = o0.E0(paramString[0], ":");
    int j = arrayOfString.length;
    long l1 = 0L;
    while (i < j)
    {
      l1 = l1 * 60L + Long.parseLong(arrayOfString[i]);
      i++;
    }
    long l2 = l1 * 1000L;
    l1 = l2;
    if (paramString.length == 2) {
      l1 = l2 + Long.parseLong(paramString[1]);
    }
    return l1 * 1000L;
  }
  
  public static void e(d0 paramd0)
    throws ParserException
  {
    int i = paramd0.e();
    if (!b(paramd0))
    {
      paramd0.P(i);
      paramd0 = String.valueOf(paramd0.p());
      if (paramd0.length() != 0) {
        paramd0 = "Expected WEBVTT. Got ".concat(paramd0);
      } else {
        paramd0 = new String("Expected WEBVTT. Got ");
      }
      throw ParserException.createForMalformedContainer(paramd0, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */