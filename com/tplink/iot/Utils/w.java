package com.tplink.iot.Utils;

import android.app.Application;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.Utils.y;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.Locale;

public class w
{
  private static boolean a()
  {
    EnumCountry localEnumCountry = c.p();
    boolean bool;
    if (EnumCountry.JP == localEnumCountry) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean b()
  {
    boolean bool;
    if ((!c()) && (!a())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c()
  {
    return "ja".equalsIgnoreCase(Locale.getDefault().getLanguage());
  }
  
  public static boolean d(Throwable paramThrowable)
  {
    boolean bool;
    if (y.a(paramThrowable) == 64524) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean e(EnumIoTAvatarType paramEnumIoTAvatarType)
  {
    boolean bool;
    if ((paramEnumIoTAvatarType != EnumIoTAvatarType.PLUG) && (paramEnumIoTAvatarType != EnumIoTAvatarType.TABLE_LAMP) && (paramEnumIoTAvatarType != EnumIoTAvatarType.CEILING_LAMP) && (paramEnumIoTAvatarType != EnumIoTAvatarType.WALL_LAMP)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void f()
  {
    Object localObject1 = AppContext.c;
    if (localObject1 != null)
    {
      Object localObject2 = ((Application)localObject1).getString(2131953437);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() > 14)) {
        localObject1 = LayoutInflater.from(AppContext.c).inflate(2131559380, null);
      } else {
        localObject1 = LayoutInflater.from(AppContext.c).inflate(2131559379, null);
      }
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131363452);
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject2);
      localObject2 = new Toast(AppContext.c);
      ((Toast)localObject2).setGravity(17, 0, 0);
      ((Toast)localObject2).setView((View)localObject1);
      ((Toast)localObject2).setDuration(1);
      ((Toast)localObject2).show();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */