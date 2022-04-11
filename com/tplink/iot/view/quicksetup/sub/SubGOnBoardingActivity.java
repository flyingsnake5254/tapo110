package com.tplink.iot.view.quicksetup.sub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySubGOnBoardingBinding;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupAvatarFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupGuideFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupLocationCustomFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupLocationSelectFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.SwitchQuickSetupNameFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class SubGOnBoardingActivity
  extends BaseActivity
  implements z1
{
  private ActivitySubGOnBoardingBinding p0;
  private SubGViewModel p1;
  private String p2;
  private String p3;
  private Stack<f> y;
  private boolean z = true;
  
  public static void E1(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SubGOnBoardingActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device", paramString2);
    localBundle.putString("device_id_md5", paramString1);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  public static void F1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SubGOnBoardingActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device", paramString);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void G1()
  {
    new UniversalDialog.a().q(getString(2131953305)).u(getString(2131951760)).s(getString(2131951757)).t(new k(this)).l().show(getSupportFragmentManager(), "");
  }
  
  private void J1(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new SubGHubListFragment();
    this.p3 = paramString;
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 2116895336: 
      if (paramString.equals("SubGSaveSettingFragment.TAG")) {
        j = 18;
      }
      break;
    case 1442261791: 
      if (paramString.equals("SwitchQuickSetupNameFragment")) {
        j = 17;
      }
      break;
    case 1429939226: 
      if (paramString.equals("SwitchQuickSetupLocationCustomFragment")) {
        j = 16;
      }
      break;
    case 907219621: 
      if (paramString.equals("SwitchQuickSetupLocationSelectFragment")) {
        j = 15;
      }
      break;
    case 720177901: 
      if (paramString.equals("SwitchQuickSetupAvatarFragment")) {
        j = 14;
      }
      break;
    case 675597835: 
      if (paramString.equals("SubGSetupAvatarFragment.TAG")) {
        j = 13;
      }
      break;
    case 552443414: 
      if (paramString.equals("SubGNoFoundFragment.TAG")) {
        j = 12;
      }
      break;
    case 276144573: 
      if (paramString.equals("SubGSetupNameFragment.TAG")) {
        j = 11;
      }
      break;
    case 233599464: 
      if (paramString.equals("SubGRemoveCoverFragment.TAG")) {
        j = 10;
      }
      break;
    case 20574216: 
      if (paramString.equals("SubGHubListFragment.TAG")) {
        j = 9;
      }
      break;
    case -295045252: 
      if (paramString.equals("SubGCompleteFragment.TAG")) {
        j = 8;
      }
      break;
    case -445782907: 
      if (paramString.equals("SubGSearchingDeviceFragment.TAG")) {
        j = 7;
      }
      break;
    case -757728017: 
      if (paramString.equals("SubGCheckStatusFragment.TAG")) {
        j = 6;
      }
      break;
    case -779921736: 
      if (paramString.equals("SubGSetupLocationCustomFragment.TAG")) {
        j = 5;
      }
      break;
    case -944814904: 
      if (paramString.equals("SwitchQuickSetupGuideFragment")) {
        j = 4;
      }
      break;
    case -1476370149: 
      if (paramString.equals("SubGHubEmptyFragment.TAG")) {
        j = 3;
      }
      break;
    case -1559829225: 
      if (paramString.equals("SubGGuideFirstFragment.TAG")) {
        j = 2;
      }
      break;
    case -1573373106: 
      if (paramString.equals("SubGHubFirmwareUpdateFragment.TAG")) {
        j = 1;
      }
      break;
    case -1873082429: 
      if (paramString.equals("SubGSetupLocationSelectFragment.TAG")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    }
    for (;;)
    {
      break;
      localObject = p1();
      continue;
      localObject = z1();
      continue;
      localObject = x1();
      continue;
      localObject = y1();
      continue;
      localObject = v1();
      continue;
      localObject = r1();
      continue;
      localObject = n1();
      continue;
      localObject = u1();
      continue;
      localObject = o1();
      continue;
      localObject = m1();
      continue;
      localObject = i1();
      continue;
      localObject = q1();
      continue;
      localObject = h1();
      continue;
      localObject = s1();
      continue;
      localObject = w1();
      continue;
      localObject = k1();
      paramInt = 2;
      break;
      localObject = j1();
      continue;
      localObject = l1();
      continue;
      localObject = t1();
    }
    this.z = true;
    H1((Fragment)localObject, paramString, paramBundle, paramInt, 2131362323);
  }
  
  private boolean K1(String paramString)
  {
    boolean bool;
    if ((!"SwitchQuickSetupGuideFragment".equalsIgnoreCase(paramString)) && (!"SwitchQuickSetupNameFragment".equalsIgnoreCase(paramString)) && (!"SwitchQuickSetupAvatarFragment".equalsIgnoreCase(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void L1()
  {
    this.p1.u0();
  }
  
  private void M1()
  {
    this.p1.A().observe(this, new l(this));
  }
  
  private void e1()
  {
    if (this.y.size() <= 1)
    {
      finish();
    }
    else
    {
      this.y.pop();
      f localf = (f)this.y.peek();
      J1(localf.b(), localf.a(), 4);
    }
  }
  
  private void f1()
  {
    if (!TextUtils.isEmpty(this.p2))
    {
      this.p1.A0(this.p2);
      e0("SubGRemoveCoverFragment.TAG", null);
    }
    else
    {
      e0("SubGHubListFragment.TAG", null);
    }
  }
  
  private void g1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      Bundle localBundle = ((Intent)localObject).getExtras();
      if (localBundle != null)
      {
        localObject = localBundle.getString("device", "T100");
        this.p1.z0((String)localObject);
        this.p2 = localBundle.getString("device_id_md5");
      }
    }
  }
  
  private SubGEnablePairingModeFragment h1()
  {
    I1(false);
    SubGEnablePairingModeFragment localSubGEnablePairingModeFragment1 = (SubGEnablePairingModeFragment)getSupportFragmentManager().findFragmentByTag("SubGCheckStatusFragment.TAG");
    SubGEnablePairingModeFragment localSubGEnablePairingModeFragment2 = localSubGEnablePairingModeFragment1;
    if (localSubGEnablePairingModeFragment1 == null) {
      localSubGEnablePairingModeFragment2 = new SubGEnablePairingModeFragment();
    }
    return localSubGEnablePairingModeFragment2;
  }
  
  private SubGCompleteFragment i1()
  {
    I1(false);
    SubGCompleteFragment localSubGCompleteFragment1 = (SubGCompleteFragment)getSupportFragmentManager().findFragmentByTag("SubGCompleteFragment.TAG");
    SubGCompleteFragment localSubGCompleteFragment2 = localSubGCompleteFragment1;
    if (localSubGCompleteFragment1 == null) {
      localSubGCompleteFragment2 = new SubGCompleteFragment();
    }
    return localSubGCompleteFragment2;
  }
  
  private SubGPowerUpDeviceFragment j1()
  {
    I1(false);
    SubGPowerUpDeviceFragment localSubGPowerUpDeviceFragment1 = (SubGPowerUpDeviceFragment)getSupportFragmentManager().findFragmentByTag("SubGGuideFirstFragment.TAG");
    SubGPowerUpDeviceFragment localSubGPowerUpDeviceFragment2 = localSubGPowerUpDeviceFragment1;
    if (localSubGPowerUpDeviceFragment1 == null) {
      localSubGPowerUpDeviceFragment2 = new SubGPowerUpDeviceFragment();
    }
    return localSubGPowerUpDeviceFragment2;
  }
  
  private SubGHubEmptyFragment k1()
  {
    I1(false);
    SubGHubEmptyFragment localSubGHubEmptyFragment1 = (SubGHubEmptyFragment)getSupportFragmentManager().findFragmentByTag("SubGHubEmptyFragment.TAG");
    SubGHubEmptyFragment localSubGHubEmptyFragment2 = localSubGHubEmptyFragment1;
    if (localSubGHubEmptyFragment1 == null) {
      localSubGHubEmptyFragment2 = new SubGHubEmptyFragment();
    }
    return localSubGHubEmptyFragment2;
  }
  
  private SubGHubFirmwareUpdateFragment l1()
  {
    I1(false);
    SubGHubFirmwareUpdateFragment localSubGHubFirmwareUpdateFragment1 = (SubGHubFirmwareUpdateFragment)getSupportFragmentManager().findFragmentByTag("SubGHubFirmwareUpdateFragment.TAG");
    SubGHubFirmwareUpdateFragment localSubGHubFirmwareUpdateFragment2 = localSubGHubFirmwareUpdateFragment1;
    if (localSubGHubFirmwareUpdateFragment1 == null) {
      localSubGHubFirmwareUpdateFragment2 = new SubGHubFirmwareUpdateFragment();
    }
    return localSubGHubFirmwareUpdateFragment2;
  }
  
  private SubGHubListFragment m1()
  {
    I1(false);
    SubGHubListFragment localSubGHubListFragment1 = (SubGHubListFragment)getSupportFragmentManager().findFragmentByTag("SubGHubListFragment.TAG");
    SubGHubListFragment localSubGHubListFragment2 = localSubGHubListFragment1;
    if (localSubGHubListFragment1 == null) {
      localSubGHubListFragment2 = new SubGHubListFragment();
    }
    return localSubGHubListFragment2;
  }
  
  private SubGNoFoundFragment n1()
  {
    I1(false);
    SubGNoFoundFragment localSubGNoFoundFragment1 = (SubGNoFoundFragment)getSupportFragmentManager().findFragmentByTag("SubGNoFoundFragment.TAG");
    SubGNoFoundFragment localSubGNoFoundFragment2 = localSubGNoFoundFragment1;
    if (localSubGNoFoundFragment1 == null) {
      localSubGNoFoundFragment2 = new SubGNoFoundFragment();
    }
    return localSubGNoFoundFragment2;
  }
  
  private SubGRemoveCoverFragment o1()
  {
    I1(false);
    SubGRemoveCoverFragment localSubGRemoveCoverFragment1 = (SubGRemoveCoverFragment)getSupportFragmentManager().findFragmentByTag("SubGRemoveCoverFragment.TAG");
    SubGRemoveCoverFragment localSubGRemoveCoverFragment2 = localSubGRemoveCoverFragment1;
    if (localSubGRemoveCoverFragment1 == null) {
      localSubGRemoveCoverFragment2 = new SubGRemoveCoverFragment();
    }
    return localSubGRemoveCoverFragment2;
  }
  
  private SubGSaveSettingFragment p1()
  {
    I1(true);
    SubGSaveSettingFragment localSubGSaveSettingFragment1 = (SubGSaveSettingFragment)getSupportFragmentManager().findFragmentByTag("SubGSaveSettingFragment.TAG");
    SubGSaveSettingFragment localSubGSaveSettingFragment2 = localSubGSaveSettingFragment1;
    if (localSubGSaveSettingFragment1 == null) {
      localSubGSaveSettingFragment2 = new SubGSaveSettingFragment();
    }
    return localSubGSaveSettingFragment2;
  }
  
  private SubGSearchingDeviceFragment q1()
  {
    I1(true);
    SubGSearchingDeviceFragment localSubGSearchingDeviceFragment1 = (SubGSearchingDeviceFragment)getSupportFragmentManager().findFragmentByTag("SubGSearchingDeviceFragment.TAG");
    SubGSearchingDeviceFragment localSubGSearchingDeviceFragment2 = localSubGSearchingDeviceFragment1;
    if (localSubGSearchingDeviceFragment1 == null) {
      localSubGSearchingDeviceFragment2 = new SubGSearchingDeviceFragment();
    }
    return localSubGSearchingDeviceFragment2;
  }
  
  private SubGSetupAvatarFragment r1()
  {
    I1(false);
    SubGSetupAvatarFragment localSubGSetupAvatarFragment1 = (SubGSetupAvatarFragment)getSupportFragmentManager().findFragmentByTag("SubGSetupAvatarFragment.TAG");
    SubGSetupAvatarFragment localSubGSetupAvatarFragment2 = localSubGSetupAvatarFragment1;
    if (localSubGSetupAvatarFragment1 == null) {
      localSubGSetupAvatarFragment2 = new SubGSetupAvatarFragment();
    }
    return localSubGSetupAvatarFragment2;
  }
  
  private SubGSetupLocationCustomFragment s1()
  {
    I1(false);
    SubGSetupLocationCustomFragment localSubGSetupLocationCustomFragment1 = (SubGSetupLocationCustomFragment)getSupportFragmentManager().findFragmentByTag("SubGSetupLocationCustomFragment.TAG");
    SubGSetupLocationCustomFragment localSubGSetupLocationCustomFragment2 = localSubGSetupLocationCustomFragment1;
    if (localSubGSetupLocationCustomFragment1 == null) {
      localSubGSetupLocationCustomFragment2 = new SubGSetupLocationCustomFragment();
    }
    return localSubGSetupLocationCustomFragment2;
  }
  
  private SubGSetupLocationSelectFragment t1()
  {
    I1(false);
    SubGSetupLocationSelectFragment localSubGSetupLocationSelectFragment1 = (SubGSetupLocationSelectFragment)getSupportFragmentManager().findFragmentByTag("SubGSetupLocationSelectFragment.TAG");
    SubGSetupLocationSelectFragment localSubGSetupLocationSelectFragment2 = localSubGSetupLocationSelectFragment1;
    if (localSubGSetupLocationSelectFragment1 == null) {
      localSubGSetupLocationSelectFragment2 = new SubGSetupLocationSelectFragment();
    }
    return localSubGSetupLocationSelectFragment2;
  }
  
  private SubGSetupNameFragment u1()
  {
    I1(false);
    SubGSetupNameFragment localSubGSetupNameFragment1 = (SubGSetupNameFragment)getSupportFragmentManager().findFragmentByTag("SubGSetupNameFragment.TAG");
    SubGSetupNameFragment localSubGSetupNameFragment2 = localSubGSetupNameFragment1;
    if (localSubGSetupNameFragment1 == null) {
      localSubGSetupNameFragment2 = new SubGSetupNameFragment();
    }
    return localSubGSetupNameFragment2;
  }
  
  private SwitchQuickSetupAvatarFragment v1()
  {
    I1(false);
    SwitchQuickSetupAvatarFragment localSwitchQuickSetupAvatarFragment1 = (SwitchQuickSetupAvatarFragment)getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupAvatarFragment");
    SwitchQuickSetupAvatarFragment localSwitchQuickSetupAvatarFragment2 = localSwitchQuickSetupAvatarFragment1;
    if (localSwitchQuickSetupAvatarFragment1 == null) {
      localSwitchQuickSetupAvatarFragment2 = new SwitchQuickSetupAvatarFragment();
    }
    return localSwitchQuickSetupAvatarFragment2;
  }
  
  private SwitchQuickSetupGuideFragment w1()
  {
    I1(false);
    SwitchQuickSetupGuideFragment localSwitchQuickSetupGuideFragment1 = (SwitchQuickSetupGuideFragment)getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupGuideFragment");
    SwitchQuickSetupGuideFragment localSwitchQuickSetupGuideFragment2 = localSwitchQuickSetupGuideFragment1;
    if (localSwitchQuickSetupGuideFragment1 == null) {
      localSwitchQuickSetupGuideFragment2 = new SwitchQuickSetupGuideFragment();
    }
    return localSwitchQuickSetupGuideFragment2;
  }
  
  private SwitchQuickSetupLocationCustomFragment x1()
  {
    I1(false);
    SwitchQuickSetupLocationCustomFragment localSwitchQuickSetupLocationCustomFragment1 = (SwitchQuickSetupLocationCustomFragment)getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupLocationCustomFragment");
    SwitchQuickSetupLocationCustomFragment localSwitchQuickSetupLocationCustomFragment2 = localSwitchQuickSetupLocationCustomFragment1;
    if (localSwitchQuickSetupLocationCustomFragment1 == null) {
      localSwitchQuickSetupLocationCustomFragment2 = new SwitchQuickSetupLocationCustomFragment();
    }
    return localSwitchQuickSetupLocationCustomFragment2;
  }
  
  private SwitchQuickSetupLocationSelectFragment y1()
  {
    I1(false);
    SwitchQuickSetupLocationSelectFragment localSwitchQuickSetupLocationSelectFragment1 = (SwitchQuickSetupLocationSelectFragment)getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupLocationSelectFragment");
    SwitchQuickSetupLocationSelectFragment localSwitchQuickSetupLocationSelectFragment2 = localSwitchQuickSetupLocationSelectFragment1;
    if (localSwitchQuickSetupLocationSelectFragment1 == null) {
      localSwitchQuickSetupLocationSelectFragment2 = new SwitchQuickSetupLocationSelectFragment();
    }
    return localSwitchQuickSetupLocationSelectFragment2;
  }
  
  private SwitchQuickSetupNameFragment z1()
  {
    I1(false);
    SwitchQuickSetupNameFragment localSwitchQuickSetupNameFragment1 = (SwitchQuickSetupNameFragment)getSupportFragmentManager().findFragmentByTag("SwitchQuickSetupNameFragment");
    SwitchQuickSetupNameFragment localSwitchQuickSetupNameFragment2 = localSwitchQuickSetupNameFragment1;
    if (localSwitchQuickSetupNameFragment1 == null) {
      localSwitchQuickSetupNameFragment2 = new SwitchQuickSetupNameFragment();
    }
    return localSwitchQuickSetupNameFragment2;
  }
  
  protected void H1(Fragment paramFragment, String paramString, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      if ((!paramFragment.isAdded()) && (!paramFragment.isVisible()) && (paramFragment.getArguments() == null))
      {
        paramFragment.setArguments(paramBundle);
      }
      else
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((paramBundle.get(str) instanceof String)) {
            paramFragment.getArguments().putString(str, paramBundle.getString(str));
          } else if ((paramBundle.get(str) instanceof Boolean)) {
            paramFragment.getArguments().putBoolean(str, paramBundle.getBoolean(str));
          } else if ((paramBundle.get(str) instanceof Long)) {
            paramFragment.getArguments().putLong(str, paramBundle.getLong(str));
          } else if ((paramBundle.get(str) instanceof Serializable)) {
            paramFragment.getArguments().putSerializable(str, paramBundle.getSerializable(str));
          } else if ((paramBundle.get(str) instanceof Parcelable)) {
            paramFragment.getArguments().putParcelable(str, paramBundle.getParcelable(str));
          }
        }
      }
    }
    paramBundle = com.tplink.iot.view.ipcamera.base.d.a(paramInt1);
    if ((paramBundle[0] != 0) && (paramBundle[1] != 0)) {
      localFragmentTransaction.setCustomAnimations(paramBundle[0], paramBundle[1]);
    }
    localFragmentTransaction.replace(paramInt2, paramFragment, paramString).commitAllowingStateLoss();
  }
  
  public void I1(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131099769;
    } else {
      i = 2131100206;
    }
    com.tplink.iot.view.quicksetup.base.d.b0(this, i);
  }
  
  public void e0(String paramString, Bundle paramBundle)
  {
    f localf = new f();
    localf.d(paramString);
    localf.c(paramBundle);
    if ((this.y.size() > 0) && (TextUtils.equals(paramString, ((f)this.y.peek()).b()))) {
      return;
    }
    int i = 0;
    Iterator localIterator = this.y.iterator();
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      j = i;
      if (K1(paramString)) {
        break;
      }
    } while (!((f)localIterator.next()).b().equalsIgnoreCase(paramString));
    int j = 1;
    while ((j != 0) && (!((f)this.y.pop()).b().equalsIgnoreCase(paramString)) && (this.y.size() > 0)) {}
    this.y.push(localf);
    if (j != 0) {
      J1(paramString, paramBundle, 4);
    } else {
      J1(paramString, paramBundle, 3);
    }
  }
  
  public void onBackPressed()
  {
    if (this.z) {
      e1();
    } else if ("SubGHubEmptyFragment.TAG".equals(this.p3)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p0 = ((ActivitySubGOnBoardingBinding)DataBindingUtil.setContentView(this, 2131558682));
    paramBundle = (SubGViewModel)ViewModelProviders.of(this).get(SubGViewModel.class);
    this.p1 = paramBundle;
    this.p0.h(paramBundle);
    this.y = new Stack();
    g1();
    M1();
    f1();
  }
  
  public void q0()
  {
    this.z = false;
  }
  
  public void y0(String paramString)
  {
    Object localObject = this.y;
    if (localObject == null)
    {
      this.y = new Stack();
      return;
    }
    if (((Stack)localObject).size() < 0) {
      return;
    }
    localObject = (f)this.y.peek();
    do
    {
      if (((f)this.y.peek()).b().equalsIgnoreCase(paramString)) {
        break;
      }
      this.y.pop();
    } while (this.y.size() > 0);
    if (localObject != null) {
      this.y.push(localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGOnBoardingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */