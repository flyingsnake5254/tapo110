package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumSensorAvatarType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c
  implements e
{
  public String a()
  {
    return p(2131954161, new Object[0]);
  }
  
  public String b()
  {
    return p(2131954159, new Object[0]);
  }
  
  public String c()
  {
    return p(2131954149, new Object[] { Integer.valueOf(5) });
  }
  
  public int d()
  {
    return 2131231465;
  }
  
  public int e()
  {
    return 2131231420;
  }
  
  public EnumDeviceType f()
  {
    return EnumDeviceType.SENSOR;
  }
  
  public int[] g()
  {
    return new int[] { 2131231504 };
  }
  
  public int h()
  {
    return 2131231503;
  }
  
  public String i()
  {
    return p(2131952877, new Object[0]);
  }
  
  public int j()
  {
    return 2131231441;
  }
  
  public List<String> k()
  {
    EnumSensorAvatarType[] arrayOfEnumSensorAvatarType = EnumSensorAvatarType.values();
    ArrayList localArrayList = new ArrayList(arrayOfEnumSensorAvatarType.length);
    int i = arrayOfEnumSensorAvatarType.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(arrayOfEnumSensorAvatarType[j].getValue());
    }
    return localArrayList;
  }
  
  public int l()
  {
    return 2131231465;
  }
  
  public String m()
  {
    return p(2131954129, new Object[] { Integer.valueOf(5) });
  }
  
  public String n()
  {
    return p(2131954153, new Object[0]);
  }
  
  public int o()
  {
    return 2131231103;
  }
  
  public String p(@StringRes int paramInt, Object... paramVarArgs)
  {
    j.e(paramVarArgs, "formatArgs");
    return e.c.a(this, paramInt, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */