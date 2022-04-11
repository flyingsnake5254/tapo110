package com.tplink.libtpnetwork.Utils;

import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class p
{
  private static final String a = "GB";
  private static final String b = "MB";
  private static final String c = "KB";
  private static final String d = "B";
  
  public static final double a(String paramString)
  {
    j.e(paramString, "space");
    String str = a;
    double d1;
    if (m.D(paramString, str, false, 2, null)) {
      d1 = Double.parseDouble(m.w(paramString, str, "", false, 4, null));
    }
    for (double d2 = 1048576;; d2 = 'Ѐ')
    {
      d2 = d1 * d2;
      break label161;
      str = b;
      if (!m.D(paramString, str, false, 2, null)) {
        break;
      }
      d1 = Double.parseDouble(m.w(paramString, str, "", false, 4, null));
    }
    str = c;
    if (m.D(paramString, str, false, 2, null))
    {
      d2 = Double.parseDouble(m.w(paramString, str, "", false, 4, null));
    }
    else
    {
      str = d;
      if (m.D(paramString, str, false, 2, null)) {
        d2 = Double.parseDouble(m.w(paramString, str, "", false, 4, null)) / 'Ѐ';
      } else {
        d2 = 0.0D;
      }
    }
    label161:
    return d2;
  }
  
  public static final int b(String paramString1, String paramString2)
  {
    j.e(paramString1, "space1");
    j.e(paramString2, "space2");
    double d1 = a(paramString1);
    double d2 = a(paramString2);
    int i;
    if (d1 > d2) {
      i = 1;
    } else if (d1 == d2) {
      i = 0;
    } else {
      i = -1;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */