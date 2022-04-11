package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.libtpnetwork.enumerate.EnumContactSensorAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b
  implements e
{
  public String a()
  {
    return p(2131954161, new Object[0]);
  }
  
  public String b()
  {
    return p(2131954160, new Object[0]);
  }
  
  public String c()
  {
    return p(2131954149, new Object[] { Integer.valueOf(5) });
  }
  
  public int d()
  {
    return 2131231469;
  }
  
  public int e()
  {
    return 2131231421;
  }
  
  public EnumDeviceType f()
  {
    return EnumDeviceType.SENSOR;
  }
  
  public int[] g()
  {
    return null;
  }
  
  public int h()
  {
    return 2131231506;
  }
  
  public String i()
  {
    return p(2131952871, new Object[0]);
  }
  
  public int j()
  {
    return 2131231442;
  }
  
  public List<String> k()
  {
    EnumContactSensorAvatarType[] arrayOfEnumContactSensorAvatarType = EnumContactSensorAvatarType.values();
    ArrayList localArrayList = new ArrayList(arrayOfEnumContactSensorAvatarType.length);
    int i = arrayOfEnumContactSensorAvatarType.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(arrayOfEnumContactSensorAvatarType[j].getValue());
    }
    return localArrayList;
  }
  
  public int l()
  {
    return 2131231469;
  }
  
  public String m()
  {
    return p(2131954129, new Object[] { Integer.valueOf(5) });
  }
  
  public String n()
  {
    return p(2131954155, new Object[0]);
  }
  
  public int o()
  {
    return 2131231104;
  }
  
  public String p(@StringRes int paramInt, Object... paramVarArgs)
  {
    j.e(paramVarArgs, "formatArgs");
    return e.c.a(this, paramInt, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */