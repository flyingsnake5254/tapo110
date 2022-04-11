package com.tplink.iot.view.quicksetup.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b.d.w.c.a;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.view.ipcamera.onboardingv2.CameraOnBoardingV2Activity;
import com.tplink.iot.view.pse.PSEOnBoardingTipsActivity;
import com.tplink.iot.view.quicksetup.ble.BleAddPlugActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbGuideFirstActivity;
import com.tplink.iot.view.quicksetup.common.SelectCategoryNewActivity;
import com.tplink.iot.view.quicksetup.lightstrip.LightStripConnectPartsGuideActivity;
import com.tplink.iot.view.quicksetup.plug.SoftApPlugGuideActivity;
import com.tplink.iot.view.quicksetup.softap.common.SoftApCommonGuideActivity;
import com.tplink.iot.view.quicksetup.sub.SubGOnBoardingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final List<String> a;
  private static final List<String> b;
  private static final List<String> c;
  private static final List<String> d;
  private static final List<String> e;
  private static final List<String> f;
  private static final List<String> g;
  private static final List<String> h;
  private static final List<String> i;
  
  static
  {
    ArrayList localArrayList1 = new ArrayList();
    a = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    b = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    c = localArrayList3;
    ArrayList localArrayList4 = new ArrayList();
    d = localArrayList4;
    ArrayList localArrayList5 = new ArrayList();
    e = localArrayList5;
    ArrayList localArrayList6 = new ArrayList();
    f = localArrayList6;
    ArrayList localArrayList7 = new ArrayList();
    g = localArrayList7;
    ArrayList localArrayList8 = new ArrayList();
    h = localArrayList8;
    ArrayList localArrayList9 = new ArrayList();
    i = localArrayList9;
    localArrayList9.add("C110");
    localArrayList9.add("C210");
    localArrayList9.add("C310");
    localArrayList9.add("C320WS");
    localArrayList9.add("P100");
    localArrayList9.add("P105");
    localArrayList9.add("L530");
    localArrayList9.add("L900");
    localArrayList9.add("L920");
    localArrayList9.add("L930");
    localArrayList9.add("L930");
    localArrayList9.add("T100");
    localArrayList9.add("T110");
    localArrayList9.add("H100");
    localArrayList1.add("C100");
    localArrayList1.add("C110");
    localArrayList1.add("C200");
    localArrayList1.add("C210");
    localArrayList1.add("C310");
    localArrayList1.add("C320WS");
    localArrayList1.add("TC60");
    localArrayList1.add("TC65");
    localArrayList1.add("TC70");
    localArrayList2.add("P100");
    localArrayList2.add("P105");
    localArrayList2.add("P110");
    localArrayList2.add("P115");
    localArrayList3.add("L510");
    localArrayList3.add("L520");
    localArrayList3.add("L530");
    localArrayList4.add("L900");
    localArrayList4.add("L920");
    localArrayList5.add("H100");
    localArrayList6.add("T100");
    localArrayList6.add("T110");
    localArrayList7.add("S200B");
    localArrayList7.add("S210");
    localArrayList7.add("S220");
    localArrayList8.add("E100");
  }
  
  public static List<String> a()
  {
    return c;
  }
  
  public static List<String> b()
  {
    return a;
  }
  
  public static List<String> c()
  {
    return e;
  }
  
  public static List<String> d()
  {
    return d;
  }
  
  public static List<String> e()
  {
    return b;
  }
  
  private static void f(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("device", paramString);
    paramString = new Intent(paramActivity, CameraOnBoardingV2Activity.class);
    paramString.putExtras(localBundle);
    paramActivity.startActivity(paramString);
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    if (j(paramString))
    {
      f(paramActivity, paramString);
      return;
    }
    if (m(paramString))
    {
      if (("P105".equals(paramString)) && (w.b()))
      {
        PSEOnBoardingTipsActivity.h1(paramActivity, paramString);
        return;
      }
      if (q.j(paramString))
      {
        SoftApPlugGuideActivity.G1(paramActivity, paramString);
        return;
      }
      BleAddPlugActivity.C1(paramActivity, paramString);
      return;
    }
    if (i(paramString))
    {
      SoftAPBulbGuideFirstActivity.g1(paramActivity, paramString);
      return;
    }
    if (l(paramString))
    {
      LightStripConnectPartsGuideActivity.g1(paramActivity, paramString);
      return;
    }
    if (k(paramString))
    {
      SoftApCommonGuideActivity.D1(paramActivity, paramString);
      return;
    }
    if ((!n(paramString)) && (!o(paramString)) && (!p(paramString))) {
      return;
    }
    SubGOnBoardingActivity.F1(paramActivity, paramString);
  }
  
  public static void h(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramActivity.startActivity(new Intent(paramActivity, SelectCategoryNewActivity.class));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("original deviceModel=");
    ((StringBuilder)localObject).append(paramString);
    a.d(((StringBuilder)localObject).toString());
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (paramString.startsWith((String)localObject))
      {
        paramString = new StringBuilder();
        paramString.append("camera deviceModel=");
        paramString.append((String)localObject);
        a.d(paramString.toString());
        f(paramActivity, (String)localObject);
        return;
      }
    }
    localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (paramString.startsWith((String)localObject))
      {
        paramString = new StringBuilder();
        paramString.append("plug deviceModel=");
        paramString.append((String)localObject);
        a.d(paramString.toString());
        BleAddPlugActivity.C1(paramActivity, (String)localObject);
        return;
      }
    }
    localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (paramString.startsWith((String)localObject))
      {
        paramString = new StringBuilder();
        paramString.append("bulb deviceModel=");
        paramString.append((String)localObject);
        a.d(paramString.toString());
        SoftAPBulbGuideFirstActivity.g1(paramActivity, (String)localObject);
        return;
      }
    }
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (paramString.startsWith((String)localObject))
      {
        paramString = new StringBuilder();
        paramString.append("bulb deviceModel=");
        paramString.append((String)localObject);
        a.d(paramString.toString());
        LightStripConnectPartsGuideActivity.g1(paramActivity, (String)localObject);
        return;
      }
    }
    if (k(paramString))
    {
      SoftApCommonGuideActivity.D1(paramActivity, paramString);
      return;
    }
    if ((!n(paramString)) && (!o(paramString)) && (!p(paramString)))
    {
      paramActivity.startActivity(new Intent(paramActivity, SelectCategoryNewActivity.class));
      return;
    }
    SubGOnBoardingActivity.F1(paramActivity, paramString);
  }
  
  private static boolean i(String paramString)
  {
    return c.contains(paramString);
  }
  
  private static boolean j(String paramString)
  {
    return a.contains(paramString);
  }
  
  private static boolean k(String paramString)
  {
    return e.contains(paramString);
  }
  
  private static boolean l(String paramString)
  {
    return d.contains(paramString);
  }
  
  private static boolean m(String paramString)
  {
    return b.contains(paramString);
  }
  
  private static boolean n(String paramString)
  {
    return f.contains(paramString);
  }
  
  private static boolean o(String paramString)
  {
    return g.contains(paramString);
  }
  
  private static boolean p(String paramString)
  {
    return h.contains(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */