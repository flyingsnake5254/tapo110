package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.libtpnetwork.enumerate.EnumButtonAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public final class a
  implements e
{
  public String a()
  {
    return p(2131954163, new Object[0]);
  }
  
  public String b()
  {
    return p(2131954157, new Object[0]);
  }
  
  public String c()
  {
    return p(2131954125, new Object[0]);
  }
  
  public int d()
  {
    return 2131231447;
  }
  
  public int e()
  {
    return 2131231417;
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
    return 2131230916;
  }
  
  public String i()
  {
    return p(2131954030, new Object[0]);
  }
  
  public int j()
  {
    return 2131231440;
  }
  
  public List<String> k()
  {
    EnumButtonAvatarType[] arrayOfEnumButtonAvatarType = EnumButtonAvatarType.values();
    ArrayList localArrayList = new ArrayList(arrayOfEnumButtonAvatarType.length);
    int i = arrayOfEnumButtonAvatarType.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(arrayOfEnumButtonAvatarType[j].getValue());
    }
    return localArrayList;
  }
  
  public int l()
  {
    return 2131231447;
  }
  
  public String m()
  {
    return p(2131954123, new Object[0]);
  }
  
  public String n()
  {
    return p(2131954151, new Object[0]);
  }
  
  public int o()
  {
    return 2131231100;
  }
  
  public String p(@StringRes int paramInt, Object... paramVarArgs)
  {
    j.e(paramVarArgs, "formatArgs");
    return e.c.a(this, paramInt, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */