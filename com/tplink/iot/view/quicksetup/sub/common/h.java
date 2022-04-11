package com.tplink.iot.view.quicksetup.sub.common;

import androidx.annotation.StringRes;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import java.util.List;
import kotlin.jvm.internal.j;

public class h
  implements e
{
  public String a()
  {
    return p(2131954162, new Object[0]);
  }
  
  public String b()
  {
    return p(2131954158, new Object[0]);
  }
  
  public String c()
  {
    return p(2131954204, new Object[] { Integer.valueOf(5) });
  }
  
  public int d()
  {
    return 2131231471;
  }
  
  public int e()
  {
    return 2131231418;
  }
  
  public EnumDeviceType f()
  {
    return EnumDeviceType.SWITCH;
  }
  
  public int[] g()
  {
    return null;
  }
  
  public int h()
  {
    return 2131231592;
  }
  
  public String i()
  {
    return p(2131954061, new Object[0]);
  }
  
  public int j()
  {
    return 2131230993;
  }
  
  public List<String> k()
  {
    List localList = EnumSwitchAvatarType.getS210AvatarNames();
    j.d(localList, "EnumSwitchAvatarType.getS210AvatarNames()");
    return localList;
  }
  
  public int l()
  {
    return 2131231471;
  }
  
  public String m()
  {
    return p(2131954135, new Object[] { Integer.valueOf(5) });
  }
  
  public String n()
  {
    return p(2131954152, new Object[0]);
  }
  
  public int o()
  {
    return 2131231101;
  }
  
  public String p(@StringRes int paramInt, Object... paramVarArgs)
  {
    j.e(paramVarArgs, "formatArgs");
    return e.c.a(this, paramInt, paramVarArgs);
  }
  
  public static final class a
    extends h
  {
    public static final a b = new a();
  }
  
  public static final class b
    extends h
  {
    public static final b b = new b();
    
    public int d()
    {
      return 2131231472;
    }
    
    public int e()
    {
      return 2131231419;
    }
    
    public int h()
    {
      return 2131231593;
    }
    
    public int j()
    {
      return 2131231000;
    }
    
    public List<String> k()
    {
      List localList = EnumSwitchAvatarType.getS220AvatarNames();
      j.d(localList, "EnumSwitchAvatarType.getS220AvatarNames()");
      return localList;
    }
    
    public int l()
    {
      return 2131231472;
    }
    
    public int o()
    {
      return 2131231102;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */