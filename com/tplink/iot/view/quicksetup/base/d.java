package com.tplink.iot.view.quicksetup.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.f;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.feedback.DeviceTypeListActivity;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static int A(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      i = paramContext.getResources().getDimensionPixelSize(i);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static int B(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "sunrise_sunset");
  }
  
  public static void C(Activity paramActivity, Class paramClass, QuickSetupInfoBean paramQuickSetupInfoBean, QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    if ((paramActivity != null) && (paramClass != null))
    {
      paramClass = new Intent(paramActivity, paramClass);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
      if (paramQuickSetupDeviceInfoBean != null) {
        localBundle.putSerializable("device_info", paramQuickSetupDeviceInfoBean);
      }
      paramClass.putExtras(localBundle);
      paramActivity.startActivity(paramClass);
    }
  }
  
  public static void D(Activity paramActivity, Class paramClass, QuickSetupInfoBean paramQuickSetupInfoBean, WirelessInfoParams paramWirelessInfoParams)
  {
    if ((paramActivity != null) && (paramClass != null))
    {
      paramClass = new Intent(paramActivity, paramClass);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
      if (paramWirelessInfoParams != null) {
        localBundle.putSerializable("ap_ssid", paramWirelessInfoParams);
      }
      paramClass.putExtras(localBundle);
      paramActivity.startActivity(paramClass);
    }
  }
  
  public static void E(Activity paramActivity, Class paramClass, QuickSetupInfoBean paramQuickSetupInfoBean, WirelessInfoParams paramWirelessInfoParams, int paramInt)
  {
    if ((paramActivity != null) && (paramClass != null))
    {
      paramClass = new Intent(paramActivity, paramClass);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
      if (paramWirelessInfoParams != null) {
        localBundle.putSerializable("ap_ssid", paramWirelessInfoParams);
      }
      paramClass.putExtras(localBundle);
      paramActivity.startActivityForResult(paramClass, paramInt);
    }
  }
  
  public static void F(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = paramActivity.getResources();
      boolean bool = paramString.equals(((Resources)localObject1).getString(2131953119));
      String str = null;
      Object localObject2;
      Object localObject3;
      if (bool)
      {
        paramString = new StringBuilder();
        paramString.append("https://www.tapo.com/app/#/faqDetail/31?locale=");
        paramString.append(com.tplink.iot.model.about.d.f());
        str = paramString.toString();
        paramString = new StringBuilder();
        paramString.append(((Resources)localObject1).getString(2131953370));
        paramString.append(" ");
        paramString.append(((Resources)localObject1).getString(2131953377));
        localObject2 = paramString.toString();
        localObject3 = EnumDeviceType.PLUG.getDeviceType();
        paramString = ((Resources)localObject1).getString(2131953119);
      }
      for (;;)
      {
        break;
        if (paramString.equals(((Resources)localObject1).getString(2131953120)))
        {
          paramString = new StringBuilder();
          paramString.append("https://www.tapo.com/app/#/faqDetail/91?locale=");
          paramString.append(com.tplink.iot.model.about.d.f());
          str = paramString.toString();
          paramString = new StringBuilder();
          paramString.append(((Resources)localObject1).getString(2131953370));
          paramString.append(" ");
          paramString.append(((Resources)localObject1).getString(2131953378));
          localObject2 = paramString.toString();
          localObject3 = EnumDeviceType.PLUG.getDeviceType();
          paramString = ((Resources)localObject1).getString(2131953120);
        }
        else
        {
          if (paramString.equals(((Resources)localObject1).getString(2131953121)))
          {
            paramString = new StringBuilder();
            paramString.append(((Resources)localObject1).getString(2131953370));
            paramString.append(" ");
            paramString.append(((Resources)localObject1).getString(2131953379));
            localObject2 = paramString.toString();
            localObject3 = EnumDeviceType.PLUG.getDeviceType();
            paramString = ((Resources)localObject1).getString(2131953121);
          }
          for (str = "https://www.tp-link.com/support/faq/2985/";; str = "https://www.tp-link.com/support/faq/3112/")
          {
            break;
            if (paramString.equals(((Resources)localObject1).getString(2131953105)))
            {
              paramString = new StringBuilder();
              paramString.append("https://www.tapo.com/app/#/faqDetail/204?folder=faqdetail2&locale=");
              paramString.append(com.tplink.iot.model.about.d.f());
              str = paramString.toString();
              paramString = new StringBuilder();
              paramString.append(((Resources)localObject1).getString(2131954029));
              paramString.append(" ");
              paramString.append(((Resources)localObject1).getString(2131951841));
              localObject2 = paramString.toString();
              localObject3 = EnumDeviceType.BULB.getDeviceType();
              paramString = ((Resources)localObject1).getString(2131953105);
              break;
            }
            if (paramString.equals(((Resources)localObject1).getString(2131953106)))
            {
              paramString = new StringBuilder();
              paramString.append("https://www.tapo.com/app/#/faqDetail/204?folder=faqdetail2&locale=");
              paramString.append(com.tplink.iot.model.about.d.f());
              str = paramString.toString();
              paramString = new StringBuilder();
              paramString.append(((Resources)localObject1).getString(2131954029));
              paramString.append(" ");
              paramString.append(((Resources)localObject1).getString(2131951842));
              localObject2 = paramString.toString();
              localObject3 = EnumDeviceType.BULB.getDeviceType();
              paramString = ((Resources)localObject1).getString(2131953106);
              break;
            }
            if (paramString.equals(((Resources)localObject1).getString(2131953107)))
            {
              paramString = new StringBuilder();
              paramString.append("https://www.tapo.com/app/#/faqDetail/92?locale=");
              paramString.append(com.tplink.iot.model.about.d.f());
              str = paramString.toString();
              paramString = new StringBuilder();
              paramString.append(((Resources)localObject1).getString(2131954029));
              paramString.append(" ");
              paramString.append(((Resources)localObject1).getString(2131951843));
              localObject2 = paramString.toString();
              localObject3 = EnumDeviceType.BULB.getDeviceType();
              paramString = ((Resources)localObject1).getString(2131953107);
              break;
            }
            if ((!paramString.equals(((Resources)localObject1).getString(2131953116))) && (!paramString.equals(((Resources)localObject1).getString(2131953117))) && (!paramString.equals(((Resources)localObject1).getString(2131953118))))
            {
              if (paramString.equals(((Resources)localObject1).getString(2131953123)))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("https://www.tapo.com/app/#/faqList2?categoryType=");
                ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131953130));
                ((StringBuilder)localObject3).append(com.tplink.iot.model.about.d.a());
                str = ((StringBuilder)localObject3).toString();
                localObject3 = ((Resources)localObject1).getString(2131952878);
                localObject2 = EnumDeviceType.SENSOR.getDeviceType();
              }
              for (;;)
              {
                localObject1 = localObject2;
                localObject2 = localObject3;
                localObject3 = localObject1;
                break;
                if (paramString.equals(((Resources)localObject1).getString(2131953124)))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("https://www.tapo.com/app/#/faqList2?categoryType=");
                  ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131952471));
                  ((StringBuilder)localObject3).append(com.tplink.iot.model.about.d.a());
                  str = ((StringBuilder)localObject3).toString();
                  localObject3 = ((Resources)localObject1).getString(2131952872);
                  localObject2 = EnumDeviceType.SENSOR.getDeviceType();
                }
                else if (paramString.equals(((Resources)localObject1).getString(2131953108)))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("https://www.tapo.com/app/#/faqList2?categoryType=");
                  ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131951847));
                  ((StringBuilder)localObject3).append(com.tplink.iot.model.about.d.a());
                  str = ((StringBuilder)localObject3).toString();
                  localObject3 = ((Resources)localObject1).getString(2131952868);
                  localObject2 = EnumDeviceType.SENSOR.getDeviceType();
                }
                else
                {
                  if ((!paramString.equals(((Resources)localObject1).getString(2131953125))) && (!paramString.equals(((Resources)localObject1).getString(2131953126))))
                  {
                    paramString = null;
                    localObject2 = paramString;
                    localObject3 = localObject2;
                    break;
                  }
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("https://www.tapo.com/app/#/faqList2?categoryType=");
                  ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131954191));
                  ((StringBuilder)localObject3).append(com.tplink.iot.model.about.d.a());
                  str = ((StringBuilder)localObject3).toString();
                  localObject3 = ((Resources)localObject1).getString(2131952883);
                  localObject2 = EnumDeviceType.SWITCH.getDeviceType();
                }
              }
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131954052));
            ((StringBuilder)localObject3).append(" ");
            ((StringBuilder)localObject3).append(paramString);
            localObject2 = ((StringBuilder)localObject3).toString();
            localObject3 = EnumDeviceType.BULB.getDeviceType();
          }
        }
      }
      if (!TextUtils.isEmpty(str)) {
        HelpAndFeedbackActivity.l1(paramActivity, str, (String)localObject2, (String)localObject3, paramString);
      }
    }
  }
  
  private static void G(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, DeviceTypeListActivity.class));
  }
  
  public static void H(FragmentActivity paramFragmentActivity)
  {
    Intent localIntent = new Intent(paramFragmentActivity, MainActivity.class);
    localIntent.addFlags(67108864);
    paramFragmentActivity.startActivity(localIntent);
    paramFragmentActivity.finish();
  }
  
  public static void I(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive()) && (paramActivity.getCurrentFocus() != null)) {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 2);
      }
    }
  }
  
  public static void J(Activity paramActivity, View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 19) {
      return;
    }
    if (i >= 21)
    {
      localObject = paramActivity.getWindow();
      ((Window)localObject).clearFlags(67108864);
      ((Window)localObject).addFlags(Integer.MIN_VALUE);
      ((Window)localObject).setStatusBarColor(0);
      i = ((Window)localObject).getDecorView().getSystemUiVisibility();
      ((Window)localObject).getDecorView().setSystemUiVisibility(i | 0x400 | 0x100);
    }
    else
    {
      paramActivity.getWindow().addFlags(67108864);
    }
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height += A(paramActivity);
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + A(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static void K(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 19) {
      return;
    }
    if (i >= 21)
    {
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(67108864);
      paramActivity.addFlags(Integer.MIN_VALUE);
      paramActivity.setStatusBarColor(0);
      i = paramActivity.getDecorView().getSystemUiVisibility();
      paramActivity.getDecorView().setSystemUiVisibility(i | 0x400 | 0x100);
    }
    else
    {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  public static boolean L(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    boolean bool;
    if ((paramQuickSetupInfoBean != null) && (i(paramQuickSetupInfoBean.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean M(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.matches("Tapo_Bulb_[A-Fa-f0-9]{4}"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean N(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.equals(p()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean O(String paramString1, String paramString2)
  {
    return R(paramString1, paramString2);
  }
  
  public static boolean P(Integer paramInteger1, Integer paramInteger2)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramInteger1 != null)
    {
      bool2 = bool1;
      if (paramInteger2 != null) {
        if (paramInteger1.intValue() == 0)
        {
          bool2 = bool1;
          if (paramInteger2.intValue() == 0) {}
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private static boolean Q(String paramString1, EnumDeviceType paramEnumDeviceType, String paramString2)
  {
    EnumDeviceType localEnumDeviceType = EnumDeviceType.PLUG;
    String str = "Bulb";
    if (localEnumDeviceType == paramEnumDeviceType) {
      str = "Plug";
    } else if (EnumDeviceType.BULB == paramEnumDeviceType)
    {
      if (c.i(paramString2)) {
        str = "Light Strip";
      }
    }
    else if (EnumDeviceType.HUB == paramEnumDeviceType) {
      str = "Hub";
    }
    boolean bool = true;
    paramEnumDeviceType = String.format("Tapo_%s_[A-Fa-f0-9]{4}", new Object[] { str });
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.matches(paramEnumDeviceType))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean R(String paramString1, String paramString2)
  {
    return Q(paramString1, com.tplink.iot.view.quicksetup.bulb.utils.b.l(paramString2), paramString2);
  }
  
  private static boolean S(Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow().getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    ((Display)localObject).getRealSize(localPoint);
    localObject = paramActivity.getWindow().getDecorView();
    int i = paramActivity.getResources().getConfiguration().orientation;
    boolean bool = true;
    if (2 == i)
    {
      paramActivity = ((View)localObject).findViewById(16908290);
      if (localPoint.x != paramActivity.getWidth()) {}
    }
    else
    {
      do
      {
        bool = false;
        break;
        paramActivity = new Rect();
        ((View)localObject).getWindowVisibleDisplayFrame(paramActivity);
      } while (paramActivity.bottom == localPoint.y);
    }
    return bool;
  }
  
  public static boolean T(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.matches("Tapo_Plug_[A-Fa-f0-9]{4}"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean U(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getApplicationContext().getSystemService("power");
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext != null)) {
      bool = paramContext.isPowerSaveMode();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean V(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\"");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("\"");
      if (paramString2.equals(localStringBuilder.toString())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static boolean W(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    boolean bool;
    if ((paramQuickSetupInfoBean != null) && (w(paramQuickSetupInfoBean.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean X(CommonQuickSetupBean paramCommonQuickSetupBean)
  {
    boolean bool;
    if ((paramCommonQuickSetupBean != null) && (w(paramCommonQuickSetupBean.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean Y(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    boolean bool;
    if ((paramQuickSetupInfoBean != null) && (B(paramQuickSetupInfoBean.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void Z(QuickSetupInfoBean paramQuickSetupInfoBean, String paramString)
  {
    if (paramQuickSetupInfoBean != null) {
      r.g(paramQuickSetupInfoBean.getDeviceType(), paramQuickSetupInfoBean.getDeviceModel(), paramString);
    }
  }
  
  public static void a0(Activity paramActivity, TextView paramTextView, DeviceModel paramDeviceModel, TDPCameraDevice paramTDPCameraDevice)
  {
    d0(paramActivity, paramTextView, paramDeviceModel, paramTDPCameraDevice);
  }
  
  public static void b0(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.addFlags(Integer.MIN_VALUE);
      localWindow.setStatusBarColor(paramActivity.getResources().getColor(paramInt));
    }
    else
    {
      StatusBarUtils.n(paramActivity, ContextCompat.getColor(paramActivity, paramInt));
    }
  }
  
  public static void c0(Activity paramActivity, TextView paramTextView, final String paramString)
  {
    if ((paramActivity != null) && (paramTextView != null)) {
      if ((x.b()) && ("P100".equals(paramString)))
      {
        d0.f(paramActivity, paramTextView, 2131953300, paramActivity.getString(2131953321), paramActivity.getString(2131953509), ContextCompat.getColor(paramActivity, 2131099811), ContextCompat.getColor(paramActivity, 2131099811), new a(paramActivity), new b(paramActivity, paramString));
      }
      else
      {
        String str = paramActivity.getString(2131953509).toUpperCase();
        d0.c(paramTextView, paramActivity.getString(2131953510, new Object[] { str }), str, ContextCompat.getColor(paramActivity, 2131099811), new c(paramActivity, paramString));
      }
    }
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      paramActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  private static void d0(final Activity paramActivity, TextView paramTextView, DeviceModel paramDeviceModel, final TDPCameraDevice paramTDPCameraDevice)
  {
    if ((paramActivity != null) && (paramTextView != null)) {
      d0.f(paramActivity, paramTextView, 2131953300, paramActivity.getString(2131953321), paramActivity.getString(2131953509), ContextCompat.getColor(paramActivity, 2131099811), ContextCompat.getColor(paramActivity, 2131099811), new d(paramDeviceModel, paramActivity, paramTDPCameraDevice), new e(paramActivity));
    }
  }
  
  public static void e(Activity paramActivity, View paramView)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = A(paramActivity);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static void e0(FragmentActivity paramFragmentActivity, TPMaterialDialogV2.d paramd)
  {
    f0(paramFragmentActivity, paramd);
  }
  
  private static boolean f(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getRealMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    int j = localDisplayMetrics.widthPixels;
    localDisplayMetrics = new DisplayMetrics();
    paramActivity.getMetrics(localDisplayMetrics);
    int k = localDisplayMetrics.heightPixels;
    boolean bool;
    if ((j - localDisplayMetrics.widthPixels <= 0) && (i - k <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static TPMaterialDialogV2 f0(final FragmentActivity paramFragmentActivity, TPMaterialDialogV2.d paramd)
  {
    if ((paramFragmentActivity != null) && (!paramFragmentActivity.isDestroyed()) && (!paramFragmentActivity.isFinishing()))
    {
      paramFragmentActivity = new TPMaterialDialogV2.Builder(paramFragmentActivity).j(paramFragmentActivity.getString(2131953614)).l(2131952391, 2131099804, null).o(2131953603, 2131099808, new f(paramd, paramFragmentActivity)).g(8, 8).b(false).c(false).a();
      paramFragmentActivity.show();
      return paramFragmentActivity;
    }
    return null;
  }
  
  public static boolean g(String paramString1, String paramString2)
  {
    if (!b.d.w.e.b.c(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return true;
    }
    if (paramString2.length() < 8) {
      return false;
    }
    if (paramString2.length() > 64) {
      return false;
    }
    return b.d.w.e.b.b(paramString2);
  }
  
  public static TPMaterialDialogV2 g0(FragmentActivity paramFragmentActivity)
  {
    return h0(paramFragmentActivity, null);
  }
  
  public static void h(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    if ((paramQuickSetupInfoBean != null) && (paramQuickSetupInfoBean.getDeviceIdMD5() != null)) {
      ((QuickSetupRepository)e.d(paramQuickSetupInfoBean.getDeviceIdMD5(), QuickSetupRepository.class)).h5();
    }
  }
  
  public static TPMaterialDialogV2 h0(FragmentActivity paramFragmentActivity, TPMaterialDialogV2.d paramd)
  {
    return f0(paramFragmentActivity, paramd);
  }
  
  public static int i(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "ble_whole_setup");
  }
  
  public static void i0(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive()) && (paramActivity.getCurrentFocus() != null)) {
        localInputMethodManager.toggleSoftInput(0, 2);
      }
    }
  }
  
  public static int j(Activity paramActivity)
  {
    Resources localResources = paramActivity.getResources();
    int i = localResources.getIdentifier("navigation_bar_height", "dimen", "android");
    int j = paramActivity.getResources().getConfiguration().orientation;
    int k = 1;
    int m = 0;
    if (1 != j) {
      k = 0;
    }
    j = m;
    if (i > 0)
    {
      j = m;
      if (k != 0)
      {
        j = m;
        if (f(paramActivity))
        {
          j = m;
          if (S(paramActivity)) {
            j = localResources.getDimensionPixelSize(i);
          }
        }
      }
    }
    return j;
  }
  
  private static String k(DeviceModel paramDeviceModel)
  {
    if ((x.b()) && ((paramDeviceModel == DeviceModel.CAMERA_C100) || (paramDeviceModel == DeviceModel.CAMERA_C110) || (paramDeviceModel == DeviceModel.CAMERA_C200) || (paramDeviceModel == DeviceModel.CAMERA_C210) || (paramDeviceModel == DeviceModel.CAMERA_TC70))) {
      return "OCI_HUkCINs";
    }
    return "lNIPpRBnt4s";
  }
  
  private static String l()
  {
    if (x.b()) {
      return "Ib7m7fBpewE";
    }
    return "jff3lyZkGis";
  }
  
  private static int m(QuickSetupComponentResult paramQuickSetupComponentResult, String paramString)
  {
    if (paramQuickSetupComponentResult == null) {
      return 0;
    }
    paramQuickSetupComponentResult = paramQuickSetupComponentResult.getComponentList();
    if ((paramQuickSetupComponentResult != null) && (!paramQuickSetupComponentResult.isEmpty())) {
      return n(o(paramQuickSetupComponentResult), paramString);
    }
    return 0;
  }
  
  private static int n(HashMap<String, Integer> paramHashMap, String paramString)
  {
    if ((paramHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramHashMap.containsKey(paramString)))
    {
      paramHashMap = (Integer)paramHashMap.get(paramString);
      if (paramHashMap != null) {
        return Math.max(paramHashMap.intValue(), 0);
      }
    }
    return 0;
  }
  
  private static HashMap<String, Integer> o(List<QuickSetupComponentBean> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (QuickSetupComponentBean)localIterator.next();
        localHashMap.put(paramList.getId(), Integer.valueOf(paramList.getVerCode()));
      }
    }
    return localHashMap;
  }
  
  public static String p()
  {
    String str = com.tplink.libtpwifi.b.k().l();
    if ((str != null) && (!str.isEmpty()))
    {
      if ("<unknown ssid>".equals(str)) {
        return "<unknown ssid>";
      }
      int i = str.length();
      if (i <= 2) {
        return str;
      }
      if (str.indexOf("\"") != 0) {
        return str;
      }
      int j = str.lastIndexOf("\"");
      i--;
      if (j != i) {
        return str;
      }
      return str.substring(1, i);
    }
    return "";
  }
  
  public static String q(QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    if (paramQuickSetupInfoBean != null)
    {
      paramQuickSetupInfoBean = paramQuickSetupInfoBean.getComponentResult();
      if (paramQuickSetupInfoBean != null)
      {
        paramQuickSetupInfoBean = paramQuickSetupInfoBean.getExtraInfo();
        if (paramQuickSetupInfoBean != null) {
          return paramQuickSetupInfoBean.getDeviceModel();
        }
      }
    }
    return null;
  }
  
  public static String r(CommonQuickSetupBean paramCommonQuickSetupBean)
  {
    if (paramCommonQuickSetupBean != null)
    {
      paramCommonQuickSetupBean = paramCommonQuickSetupBean.getComponentResult();
      if (paramCommonQuickSetupBean != null)
      {
        paramCommonQuickSetupBean = paramCommonQuickSetupBean.getExtraInfo();
        if (paramCommonQuickSetupBean != null) {
          return paramCommonQuickSetupBean.getDeviceModel();
        }
      }
    }
    return null;
  }
  
  public static EnumDeviceType s(CommonQuickSetupBean paramCommonQuickSetupBean)
  {
    if (paramCommonQuickSetupBean != null)
    {
      paramCommonQuickSetupBean = paramCommonQuickSetupBean.getComponentResult();
      if (paramCommonQuickSetupBean != null)
      {
        paramCommonQuickSetupBean = paramCommonQuickSetupBean.getExtraInfo();
        if (paramCommonQuickSetupBean != null) {
          return EnumDeviceType.fromType(paramCommonQuickSetupBean.getDeviceType());
        }
      }
    }
    return null;
  }
  
  public static String t(String paramString)
  {
    if (b.e().contains(paramString)) {
      return EnumDeviceType.PLUG.getDeviceType();
    }
    if (b.a().contains(paramString)) {
      return EnumDeviceType.BULB.getDeviceType();
    }
    return EnumDeviceType.PLUG.getDeviceType();
  }
  
  public static int u(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "firmware");
  }
  
  public static int v(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "inherit");
  }
  
  public static int w(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "iot_cloud");
  }
  
  public static int x(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    return m(paramQuickSetupComponentResult, "quick_setup");
  }
  
  public static List<ScanResult> y(List<ScanResult> paramList, EnumDeviceType paramEnumDeviceType, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j;
    if ((paramList != null) && (paramList.size() > 0)) {
      for (j = 0; j < paramList.size(); j++)
      {
        ScanResult localScanResult = (ScanResult)paramList.get(j);
        if ((localScanResult != null) && (Q(localScanResult.SSID, paramEnumDeviceType, paramString))) {
          localArrayList.add(localScanResult);
        }
      }
    }
    paramEnumDeviceType = new ArrayList();
    paramList = new ArrayList();
    if (localArrayList.size() > 0) {
      for (j = i; j < localArrayList.size(); j++) {
        if (!paramList.contains(((ScanResult)localArrayList.get(j)).SSID))
        {
          paramList.add(((ScanResult)localArrayList.get(j)).SSID);
          paramEnumDeviceType.add(localArrayList.get(j));
        }
      }
    }
    return paramEnumDeviceType;
  }
  
  public static List<ScanResult> z(List<ScanResult> paramList, String paramString)
  {
    return y(paramList, com.tplink.iot.view.quicksetup.bulb.utils.b.l(paramString), paramString);
  }
  
  static final class a
    implements d0.g
  {
    a(Activity paramActivity) {}
    
    public void a()
    {
      t0.f(this.a, "XP2ePdLatwg");
    }
  }
  
  static final class b
    implements d0.f
  {
    b(Activity paramActivity, String paramString) {}
    
    public void a()
    {
      d.F(this.a, paramString);
    }
  }
  
  static final class c
    implements d0.g
  {
    c(Activity paramActivity, String paramString) {}
    
    public void a()
    {
      d.F(this.a, paramString);
    }
  }
  
  static final class d
    implements d0.g
  {
    d(DeviceModel paramDeviceModel, Activity paramActivity, TDPCameraDevice paramTDPCameraDevice) {}
    
    public void a()
    {
      Object localObject = this.a;
      if ((localObject != DeviceModel.CAMERA_C310) && (localObject != DeviceModel.CAMERA_C320WS) && (localObject != DeviceModel.CAMERA_TC65)) {
        localObject = d.b((DeviceModel)localObject);
      } else {
        localObject = d.a();
      }
      t0.f(paramActivity, (String)localObject);
      f.o(paramTDPCameraDevice);
    }
  }
  
  static final class e
    implements d0.f
  {
    e(Activity paramActivity) {}
    
    public void a()
    {
      d.c(this.a);
    }
  }
  
  static final class f
    implements TPMaterialDialogV2.d
  {
    f(TPMaterialDialogV2.d paramd, FragmentActivity paramFragmentActivity) {}
    
    public void onClick(View paramView)
    {
      TPMaterialDialogV2.d locald = this.a;
      if (locald != null) {
        locald.onClick(paramView);
      }
      d.H(paramFragmentActivity);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */