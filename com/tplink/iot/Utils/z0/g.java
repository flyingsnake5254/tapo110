package com.tplink.iot.Utils.z0;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.devices.lightstrip.view.LightStripDetailActivity;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.bulb.BulbDetailActivity;
import com.tplink.iot.view.colorbulb.ColorBulbDetailActivity;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;

public class g
{
  @DrawableRes
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 2131689762;
    }
    if (paramString.contains("L520")) {
      return 2131689766;
    }
    if (paramString.contains("L530")) {
      return 2131689763;
    }
    return 2131689762;
  }
  
  private static int b(EnumBulbAvatarType paramEnumBulbAvatarType, int paramInt)
  {
    int i = 2131689965;
    int j;
    if (paramInt == 1) {
      j = 2131689964;
    } else if (paramInt == 2) {
      j = 2131689965;
    } else {
      j = 2131689967;
    }
    int k = j;
    if (paramEnumBulbAvatarType != null) {
      switch (a.a[paramEnumBulbAvatarType.ordinal()])
      {
      default: 
        k = j;
        break;
      case 12: 
        if (paramInt == 1) {
          k = 2131690015;
        } else if (paramInt == 2) {
          k = 2131690016;
        } else {
          k = 2131690017;
        }
        break;
      case 11: 
        if (paramInt == 1) {
          k = 2131690012;
        } else if (paramInt == 2) {
          k = 2131690013;
        } else {
          k = 2131690014;
        }
        break;
      case 10: 
        if (paramInt == 1) {
          k = 2131690009;
        } else if (paramInt == 2) {
          k = 2131690010;
        } else {
          k = 2131690011;
        }
        break;
      case 9: 
        if (paramInt == 1) {
          k = 2131690003;
        } else if (paramInt == 2) {
          k = 2131690004;
        } else {
          k = 2131690005;
        }
        break;
      case 8: 
        if (paramInt == 1) {
          k = 2131690000;
        } else if (paramInt == 2) {
          k = 2131690001;
        } else {
          k = 2131690002;
        }
        break;
      case 7: 
        if (paramInt == 1) {
          k = 2131689997;
        } else if (paramInt == 2) {
          k = 2131689998;
        } else {
          k = 2131689999;
        }
        break;
      case 6: 
        if (paramInt == 1) {
          k = 2131690089;
        } else if (paramInt == 2) {
          k = 2131690090;
        } else {
          k = 2131690091;
        }
        break;
      case 5: 
        if (paramInt == 1) {
          k = 2131690086;
        } else if (paramInt == 2) {
          k = 2131690087;
        } else {
          k = 2131690088;
        }
        break;
      case 4: 
        if (paramInt == 1) {
          k = 2131690082;
        } else if (paramInt == 2) {
          k = 2131690083;
        } else {
          k = 2131690084;
        }
        break;
      case 3: 
        if (paramInt == 1) {
          k = 2131690078;
        } else if (paramInt == 2) {
          k = 2131690079;
        } else {
          k = 2131690080;
        }
        break;
      case 2: 
        if (paramInt == 1) {
          k = 2131690075;
        } else if (paramInt == 2) {
          k = 2131690076;
        } else {
          k = 2131690077;
        }
        break;
      case 1: 
        if (paramInt == 1) {
          paramInt = 2131689964;
        } else if (paramInt == 2) {
          paramInt = i;
        } else {
          paramInt = 2131689967;
        }
        k = paramInt;
      }
    }
    return k;
  }
  
  public static int c(EnumBulbAvatarType paramEnumBulbAvatarType)
  {
    return b(paramEnumBulbAvatarType, 1);
  }
  
  public static int d(EnumBulbAvatarType paramEnumBulbAvatarType)
  {
    return b(paramEnumBulbAvatarType, 2);
  }
  
  public static int e(EnumBulbAvatarType paramEnumBulbAvatarType)
  {
    return b(paramEnumBulbAvatarType, 3);
  }
  
  public static int f(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return Color.parseColor("#D4E2EE");
  }
  
  public static int g()
  {
    return -1275077491;
  }
  
  public static void h(Context paramContext, String paramString)
  {
    if (c.h(paramString)) {
      LightStripDetailActivity.x2(paramContext, paramString);
    } else if (a.e(paramString)) {
      ColorBulbDetailActivity.Z1(paramContext, paramString);
    } else {
      BulbDetailActivity.D1(paramContext, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */