package com.tplink.iot.view.quicksetup.sub.common;

import android.app.Application;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumSensorAvatarType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

public abstract interface e
{
  public static final a a = a.a;
  
  public abstract String a();
  
  public abstract String b();
  
  public abstract String c();
  
  @DrawableRes
  public abstract int d();
  
  @DrawableRes
  public abstract int e();
  
  public abstract EnumDeviceType f();
  
  public abstract int[] g();
  
  @DrawableRes
  public abstract int h();
  
  public abstract String i();
  
  @DrawableRes
  public abstract int j();
  
  public abstract List<String> k();
  
  @DrawableRes
  public abstract int l();
  
  public abstract String m();
  
  public abstract String n();
  
  @DrawableRes
  public abstract int o();
  
  public static final class a {}
  
  public static final class b
    implements e
  {
    public static final b b = new b();
    
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
      return null;
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
      return p(2131954127, new Object[0]);
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
  
  public static final class c
  {
    public static String a(e parame, @StringRes int paramInt, Object... paramVarArgs)
    {
      j.e(paramVarArgs, "formatArgs");
      parame = AppContext.c.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      j.d(parame, "AppContext.instance.getString(textId, *formatArgs)");
      return parame;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */