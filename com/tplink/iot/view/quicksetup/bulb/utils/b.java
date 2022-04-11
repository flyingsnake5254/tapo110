package com.tplink.iot.view.quicksetup.bulb.utils;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import java.util.ArrayList;
import java.util.List;

public class b
{
  @StringRes
  public static int a(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131953536;
        }
        if (paramString.startsWith("P115")) {
          return 2131953571;
        }
        return 2131953570;
      }
      return 2131952858;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131952958;
    }
    return 2131953536;
  }
  
  @StringRes
  public static int b(String paramString)
  {
    paramString = l(paramString);
    if (a.a[paramString.ordinal()] != 2) {
      return 2131952438;
    }
    return 2131953298;
  }
  
  @DrawableRes
  public static int c(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return 2131230969;
      }
    }
    else if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131230977;
    }
    return 2131689532;
  }
  
  public static String d(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return AppContext.c.getString(2131953466);
      }
      return AppContext.c.getString(2131953299);
    }
    if (com.tplink.iot.g.b.c.c.j(paramString)) {
      return AppContext.c.getString(2131952955);
    }
    if (com.tplink.iot.g.b.c.c.g(paramString)) {
      return AppContext.c.getString(2131952954);
    }
    return AppContext.c.getString(2131953466);
  }
  
  public static String e(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return AppContext.c.getString(2131953466);
      }
      return AppContext.c.getString(2131953319, new Object[] { Integer.valueOf(5) });
    }
    if (com.tplink.iot.g.b.c.c.j(paramString)) {
      return AppContext.c.getString(2131952960);
    }
    if (com.tplink.iot.g.b.c.c.g(paramString)) {
      return AppContext.c.getString(2131952959);
    }
    return AppContext.c.getString(2131952959);
  }
  
  @DrawableRes
  public static int f(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return 2131689524;
      }
    }
    else if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131231456;
    }
    return 2131231455;
  }
  
  @StringRes
  public static int g(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    if (a.a[localEnumDeviceType.ordinal()] != 1) {
      return 2131951997;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131952961;
    }
    return 2131951997;
  }
  
  public static String h(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return AppContext.c.getString(2131953569);
      }
      return AppContext.c.getString(2131953569);
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return AppContext.c.getString(2131952957);
    }
    return AppContext.c.getString(2131953569);
  }
  
  @StringRes
  public static int i(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    if (a.a[localEnumDeviceType.ordinal()] != 1) {
      return 2131953314;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131952956;
    }
    return 2131953314;
  }
  
  @StringRes
  public static int j(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131954029;
        }
        return 2131953370;
      }
      return 2131954050;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131954052;
    }
    return 2131954029;
  }
  
  public static int k(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131689519;
        }
        return com.tplink.iot.view.quicksetup.base.c.d(paramString);
      }
      return 2131689688;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131690150;
    }
    return 2131689519;
  }
  
  public static EnumDeviceType l(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return EnumDeviceType.UNKNOWN;
    }
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2431941: 
      if (paramString.equals("P115")) {
        i = 8;
      }
      break;
    case 2431936: 
      if (paramString.equals("P110")) {
        i = 7;
      }
      break;
    case 2320522: 
      if (paramString.equals("L930")) {
        i = 6;
      }
      break;
    case 2320491: 
      if (paramString.equals("L920")) {
        i = 5;
      }
      break;
    case 2320429: 
      if (paramString.equals("L900")) {
        i = 4;
      }
      break;
    case 2316678: 
      if (paramString.equals("L530")) {
        i = 3;
      }
      break;
    case 2316647: 
      if (paramString.equals("L520")) {
        i = 2;
      }
      break;
    case 2316616: 
      if (paramString.equals("L510")) {
        i = 1;
      }
      break;
    case 2193577: 
      if (paramString.equals("H100")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return EnumDeviceType.UNKNOWN;
    case 7: 
    case 8: 
      return EnumDeviceType.PLUG;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      return EnumDeviceType.BULB;
    }
    return EnumDeviceType.HUB;
  }
  
  public static List<String> m(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = a.a[localEnumDeviceType.ordinal()];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          paramString = EnumBulbAvatarType.values();
          j = paramString.length;
          while (i1 < j)
          {
            localArrayList.add(paramString[i1].getName());
            i1++;
          }
        }
        paramString = EnumIoTAvatarType.values();
        k = paramString.length;
        for (i1 = j; i1 < k; i1++) {
          localArrayList.add(paramString[i1].getName());
        }
      }
      paramString = EnumHubAvatarType.values();
      j = paramString.length;
      for (i1 = k; i1 < j; i1++) {
        localArrayList.add(paramString[i1].getName());
      }
    }
    if (com.tplink.iot.g.b.c.c.i(paramString))
    {
      paramString = EnumLightStripAvatarType.values();
      j = paramString.length;
      for (i1 = m; i1 < j; i1++) {
        localArrayList.add(paramString[i1].getValue());
      }
    }
    paramString = EnumBulbAvatarType.values();
    j = paramString.length;
    for (i1 = n; i1 < j; i1++) {
      localArrayList.add(paramString[i1].getName());
    }
    return localArrayList;
  }
  
  public static int n(String paramString)
  {
    paramString = l(paramString);
    if (a.a[paramString.ordinal()] != 2) {
      return 1000;
    }
    return 500;
  }
  
  public static int[] o(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return new int[] { 2131689689 };
      }
    }
    else if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return new int[] { 2131690146 };
    }
    return null;
  }
  
  public static int[] p(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return new int[] { com.tplink.iot.view.quicksetup.base.c.j(paramString), com.tplink.iot.view.quicksetup.base.c.f(paramString) };
        }
      }
      else {
        return new int[] { 2131689690 };
      }
    }
    else if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return new int[] { 2131690146, 2131690147 };
    }
    return null;
  }
  
  public static int[] q(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if ("P115".equals(paramString)) {
            return null;
          }
          return new int[] { com.tplink.iot.view.quicksetup.base.c.j(paramString), com.tplink.iot.view.quicksetup.base.c.f(paramString) };
        }
      }
      else {
        return new int[] { 2131689690, 2131689689 };
      }
    }
    else if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return new int[] { 2131690146, 2131690147 };
    }
    return null;
  }
  
  @LayoutRes
  public static int r(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131559222;
        }
        return 2131559225;
      }
      return 2131559223;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131559224;
    }
    return 2131559222;
  }
  
  @LayoutRes
  public static int s(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131559226;
        }
        return 2131559229;
      }
      return 2131559227;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131559228;
    }
    return 2131559226;
  }
  
  public static EnumOnboardingType t(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    paramString = EnumOnboardingType.BULB_SOFT_AP;
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 2)
    {
      if (i == 3) {
        paramString = EnumOnboardingType.PLUG_SOFT_AP;
      }
    }
    else {
      paramString = EnumOnboardingType.HUB_SOFT_AP;
    }
    return paramString;
  }
  
  public static int u(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 2131689535;
        }
        return 2131690308;
      }
      return 2131231240;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131690158;
    }
    return 2131689535;
  }
  
  public static String v(String paramString)
  {
    EnumDeviceType localEnumDeviceType = l(paramString);
    int i = a.a[localEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return "Tapo_Bulb_XXXX";
        }
        return "Tapo_Plug_XXXX";
      }
      return "Tapo_Hub_XXXX";
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return "Tapo_Light Strip_XXXX";
    }
    return "Tapo_Bulb_XXXX";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */