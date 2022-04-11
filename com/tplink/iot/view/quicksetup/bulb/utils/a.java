package com.tplink.iot.view.quicksetup.bulb.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.EnumBulbCountry;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDeviceListActivity;
import com.tplink.iot.viewmodel.quicksetup.QuickDiscoveryViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.Utils.o;
import java.util.Locale;

public class a
{
  public static String a(Context paramContext)
  {
    return EnumBulbCountry.fromString(paramContext.getResources().getConfiguration().locale.getCountry()).getName();
  }
  
  public static void b(Activity paramActivity, Class paramClass, QuickSetupInfoBundle paramQuickSetupInfoBundle, QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    if ((paramActivity != null) && (paramClass != null))
    {
      Intent localIntent = new Intent(paramActivity, paramClass);
      paramClass = new Bundle();
      paramClass.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
      if (paramQuickSetupDeviceInfoBean != null) {
        paramClass.putSerializable("device_info", paramQuickSetupDeviceInfoBean);
      }
      localIntent.putExtras(paramClass);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void c(Activity paramActivity, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    CommonQuickSetupBean localCommonQuickSetupBean = new CommonQuickSetupBean(paramQuickSetupInfoBundle.getDeviceIdMD5(), paramQuickSetupInfoBundle.getComponentResult(), paramQuickSetupInfoBundle.isSelectFollowInherit());
    localCommonQuickSetupBean.setFromQuickDiscovery(paramQuickSetupInfoBundle.isFromQuickDiscovery());
    SetupSuccessActivity.p1(paramActivity, localCommonQuickSetupBean, null, paramQuickSetupInfoBundle.getOnboardingStartTime());
  }
  
  public static void d(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    QuickDiscoveryViewModel localQuickDiscoveryViewModel = (QuickDiscoveryViewModel)new ViewModelProvider(paramBaseActivity).get(QuickDiscoveryViewModel.class);
    int i;
    if ((paramBoolean) && (localQuickDiscoveryViewModel.f())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramBaseActivity.W0(DiscoveryDeviceListActivity.class);
    }
    else
    {
      paramBaseActivity.Y0();
      paramBaseActivity.finish();
    }
  }
  
  public static boolean e(QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    boolean bool;
    if ((paramQuickSetupInfoBundle != null) && (com.tplink.iot.view.quicksetup.base.d.v(paramQuickSetupInfoBundle.getComponentResult()) > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean f(Activity paramActivity, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    boolean bool;
    if ((com.tplink.iot.view.quicksetup.base.wifi.d.a(paramActivity)) && (paramQuickSetupInfoBundle != null) && (!TextUtils.isEmpty(paramQuickSetupInfoBundle.getBulbSSID()))) {
      bool = com.tplink.iot.view.quicksetup.base.d.N(paramQuickSetupInfoBundle.getBulbSSID());
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void g(boolean paramBoolean, WirelessInfoParams paramWirelessInfoParams)
  {
    if (paramBoolean) {
      o.h0().a1(paramWirelessInfoParams);
    } else {
      o.h0().r0(paramWirelessInfoParams);
    }
  }
  
  public static void h(FragmentActivity paramFragmentActivity, final String paramString1, final String paramString2, final String paramString3)
  {
    com.tplink.iot.view.quicksetup.base.d.e0(paramFragmentActivity, new a(paramFragmentActivity, paramString1, paramString2, paramString3));
  }
  
  static final class a
    implements TPMaterialDialogV2.d
  {
    a(FragmentActivity paramFragmentActivity, String paramString1, String paramString2, String paramString3) {}
    
    public void onClick(View paramView)
    {
      e0.a(this.a);
      r.g(paramString1, paramString2, paramString3);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */