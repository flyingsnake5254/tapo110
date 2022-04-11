package com.tplink.iot.Utils;

import android.text.TextUtils;
import b.d.q.b.j;
import com.tplink.libtpwifi.b;

public class y
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\"");
    boolean bool = TextUtils.equals(localStringBuilder.toString(), b.k().l());
    if ((j.b()) && (bool)) {
      return;
    }
    b.k().d(paramString1, paramString2, paramString3);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    if (!j.b()) {
      b.k().d(paramString1, paramString2, paramString3);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */