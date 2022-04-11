package com.tplink.libtpanalytics.utils;

import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.database.d.b;
import java.util.Date;

public class c
{
  public static String a(long paramLong)
  {
    int i = (int)((Math.random() * 9.0D + 1.0D) * 10000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("p");
    localStringBuilder.append(i);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static void b(b paramb, e parame)
  {
    paramb.x(parame.e().k());
    long l = new Date().getTime();
    paramb.y(l);
    paramb.r(a(l));
    String str;
    if (parame.e().f() == null) {
      str = "";
    } else {
      str = com.tplink.libtpanalytics.utils.l.c.d(parame.e().f().toLowerCase());
    }
    paramb.z(str);
    paramb.v(parame.e().j());
    paramb.t(parame.e().g());
    paramb.n(parame.e().d());
    paramb.o(2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */