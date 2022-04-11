package com.tplink.iot.Utils.v0;

import b.d.s.a.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;

public class c
{
  public static String a()
  {
    Object localObject = a.f().c();
    if (localObject != null) {
      localObject = ((TCAccountBean)localObject).getToken();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */