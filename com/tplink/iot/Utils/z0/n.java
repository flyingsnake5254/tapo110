package com.tplink.iot.Utils.z0;

import android.app.Application;
import androidx.annotation.DrawableRes;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.Arrays;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class n
{
  private static final String a()
  {
    String str = h(2131954041, new Object[] { "" });
    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
    return m.t0(str).toString();
  }
  
  @DrawableRes
  public static final int b(EnumIoTCategory paramEnumIoTCategory)
  {
    if (paramEnumIoTCategory != null)
    {
      int i;
      switch (m.c[paramEnumIoTCategory.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 12: 
        i = 2131690097;
        break;
      case 11: 
        i = 2131690052;
        break;
      case 10: 
        i = 2131690049;
        break;
      case 9: 
        i = 2131689969;
        break;
      case 8: 
        i = 2131690062;
        break;
      case 6: 
      case 7: 
        i = 2131690022;
        break;
      case 5: 
        i = 2131689544;
        break;
      case 3: 
      case 4: 
        i = 2131689670;
        break;
      case 2: 
        i = 2131690034;
        break;
      case 1: 
        i = 2131689965;
      }
      return i;
    }
    return 2131689669;
  }
  
  @DrawableRes
  public static final int c(String paramString)
  {
    return b(EnumIoTCategory.fromString(paramString));
  }
  
  public static final String d(EnumIoTCategory paramEnumIoTCategory)
  {
    if (paramEnumIoTCategory != null)
    {
      switch (m.b[paramEnumIoTCategory.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 12: 
        paramEnumIoTCategory = g(2131952884);
        break;
      case 11: 
        paramEnumIoTCategory = g(2131952872);
        break;
      case 10: 
        paramEnumIoTCategory = g(2131952878);
        break;
      case 9: 
        paramEnumIoTCategory = g(2131952868);
        break;
      case 8: 
        paramEnumIoTCategory = g(2131952883);
        break;
      case 6: 
      case 7: 
        paramEnumIoTCategory = g(2131952874);
        break;
      case 5: 
        paramEnumIoTCategory = g(2131952870);
        break;
      case 3: 
      case 4: 
        paramEnumIoTCategory = g(2131952881);
        break;
      case 2: 
        paramEnumIoTCategory = g(2131952875);
        break;
      case 1: 
        paramEnumIoTCategory = g(2131952867);
      }
      return paramEnumIoTCategory;
    }
    return a();
  }
  
  public static final String e(EnumIoTCategory paramEnumIoTCategory)
  {
    if (paramEnumIoTCategory != null)
    {
      switch (m.a[paramEnumIoTCategory.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 12: 
        paramEnumIoTCategory = g(2131954078);
        break;
      case 11: 
        paramEnumIoTCategory = g(2131952871);
        break;
      case 10: 
        paramEnumIoTCategory = g(2131952877);
        break;
      case 9: 
        paramEnumIoTCategory = g(2131954030);
        break;
      case 8: 
        paramEnumIoTCategory = g(2131954061);
        break;
      case 6: 
      case 7: 
        paramEnumIoTCategory = g(2131954050);
        break;
      case 5: 
        paramEnumIoTCategory = g(2131954032);
        break;
      case 3: 
      case 4: 
        paramEnumIoTCategory = g(2131953370);
        break;
      case 2: 
        paramEnumIoTCategory = g(2131954052);
        break;
      case 1: 
        paramEnumIoTCategory = g(2131954029);
      }
      return paramEnumIoTCategory;
    }
    return a();
  }
  
  public static final String f(String paramString)
  {
    return e(EnumIoTCategory.fromString(paramString));
  }
  
  private static final String g(int paramInt)
  {
    String str = AppContext.c.getString(paramInt);
    j.d(str, "AppContext.instance.getString(resId)");
    return str;
  }
  
  private static final String h(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = AppContext.c.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    j.d(paramVarArgs, "AppContext.instance.getString(resId, *formatArgs)");
    return paramVarArgs;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */