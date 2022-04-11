package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public final class i
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
    return p(2131954156, new Object[] { Integer.valueOf(5) });
  }
  
  public int d()
  {
    return 2131231001;
  }
  
  public int e()
  {
    return 2131231001;
  }
  
  public EnumDeviceType f()
  {
    return EnumDeviceType.ENERGY;
  }
  
  public int[] g()
  {
    return null;
  }
  
  public int h()
  {
    return 2131231653;
  }
  
  public String i()
  {
    return p(2131954078, new Object[0]);
  }
  
  public int j()
  {
    return 0;
  }
  
  public List<String> k()
  {
    EnumTRVAvatarType[] arrayOfEnumTRVAvatarType = EnumTRVAvatarType.values();
    ArrayList localArrayList = new ArrayList(arrayOfEnumTRVAvatarType.length);
    int i = arrayOfEnumTRVAvatarType.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(arrayOfEnumTRVAvatarType[j].getValue());
    }
    return localArrayList;
  }
  
  public int l()
  {
    return 2131231001;
  }
  
  public String m()
  {
    return p(2131954127, new Object[0]);
  }
  
  public String n()
  {
    return p(2131954152, new Object[0]);
  }
  
  public int o()
  {
    return 2131231099;
  }
  
  public String p(@StringRes int paramInt, Object... paramVarArgs)
  {
    j.e(paramVarArgs, "formatArgs");
    return e.c.a(this, paramInt, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */