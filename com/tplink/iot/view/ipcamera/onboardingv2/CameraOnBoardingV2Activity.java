package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityCameraV2OnboardingBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class CameraOnBoardingV2Activity
  extends AppCompatActivity
  implements z1
{
  private Stack<f> c;
  private boolean d = true;
  private ActivityCameraV2OnboardingBinding f;
  private CameraOnBoardingViewModel q;
  private String x;
  
  private CameraWiredConnectingFragment A1()
  {
    J1(true);
    CameraWiredConnectingFragment localCameraWiredConnectingFragment1 = (CameraWiredConnectingFragment)getSupportFragmentManager().findFragmentByTag("CameraWiredConnectingFragment.TAG");
    CameraWiredConnectingFragment localCameraWiredConnectingFragment2 = localCameraWiredConnectingFragment1;
    if (localCameraWiredConnectingFragment1 == null) {
      localCameraWiredConnectingFragment2 = new CameraWiredConnectingFragment();
    }
    return localCameraWiredConnectingFragment2;
  }
  
  private CameraWiredSetWirelessFailedFragment B1()
  {
    J1(false);
    CameraWiredSetWirelessFailedFragment localCameraWiredSetWirelessFailedFragment1 = (CameraWiredSetWirelessFailedFragment)getSupportFragmentManager().findFragmentByTag("CameraWiredSetWirelessFailedFragment.TAG");
    CameraWiredSetWirelessFailedFragment localCameraWiredSetWirelessFailedFragment2 = localCameraWiredSetWirelessFailedFragment1;
    if (localCameraWiredSetWirelessFailedFragment1 == null) {
      localCameraWiredSetWirelessFailedFragment2 = new CameraWiredSetWirelessFailedFragment();
    }
    return localCameraWiredSetWirelessFailedFragment2;
  }
  
  private void C1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("device", "C200");
        this.q.f2(DeviceModel.fromValue((String)localObject));
      }
    }
  }
  
  private void K1(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = T0();
    this.x = paramString;
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 2034670853: 
      if (paramString.equals("CameraLocationPermissionFragment.TAG")) {
        j = 37;
      }
      break;
    case 1959267626: 
      if (paramString.equals("CameraSearchAfterSetupFragment.TAG")) {
        j = 36;
      }
      break;
    case 1951242650: 
      if (paramString.equals("CameraManualInputPwdFragment.TAG")) {
        j = 35;
      }
      break;
    case 1908828689: 
      if (paramString.equals("CameraCheckStatusFragment.TAG")) {
        j = 34;
      }
      break;
    case 1873820164: 
      if (paramString.equals("CameraSetNameFragment.TAG")) {
        j = 33;
      }
      break;
    case 1685992330: 
      if (paramString.equals("CameraConnectRouterFragment.TAG")) {
        j = 32;
      }
      break;
    case 1546490882: 
      if (paramString.equals("CameraInstallGuideFragment.TAG")) {
        j = 31;
      }
      break;
    case 1179968464: 
      if (paramString.equals("CameraNotFoundFragment.TAG")) {
        j = 30;
      }
      break;
    case 848180751: 
      if (paramString.equals("CameraWiredCompleteFragment.TAG")) {
        j = 29;
      }
      break;
    case 814977102: 
      if (paramString.equals("CameraInstallPreviewFragment.TAG")) {
        j = 28;
      }
      break;
    case 800795190: 
      if (paramString.equals("CameraConnectToPairFragment.TAG")) {
        j = 27;
      }
      break;
    case 629894554: 
      if (paramString.equals("CameraCompleteFragment.TAG")) {
        j = 26;
      }
      break;
    case 613492404: 
      if (paramString.equals("CameraWifiListFragment.TAG")) {
        j = 25;
      }
      break;
    case 488484746: 
      if (paramString.equals("CameraSaveSettingFragment.TAG")) {
        j = 24;
      }
      break;
    case 316128518: 
      if (paramString.equals("CameraResetFragment.TAG")) {
        j = 23;
      }
      break;
    case 190356596: 
      if (paramString.equals("CameraInputPwdFragment.TAG")) {
        j = 22;
      }
      break;
    case 88992822: 
      if (paramString.equals("CameraInstallHelpfulItemsFragment.TAG")) {
        j = 21;
      }
      break;
    case 82444273: 
      if (paramString.equals("CameraTroubleShootingFragment.TAG")) {
        j = 20;
      }
      break;
    case -255809040: 
      if (paramString.equals("CameraConnectApFragment.TAG")) {
        j = 19;
      }
      break;
    case -262092205: 
      if (paramString.equals("CameraBeforeInstallFragment.TAG")) {
        j = 18;
      }
      break;
    case -330190086: 
      if (paramString.equals("CameraSSIDListFragment.TAG")) {
        j = 17;
      }
      break;
    case -344620035: 
      if (paramString.equals("CameraCannotFindFragment.TAG")) {
        j = 16;
      }
      break;
    case -423499059: 
      if (paramString.equals("CameraRoomCustomFragment.TAG")) {
        j = 15;
      }
      break;
    case -426291367: 
      if (paramString.equals("CameraConnectingFragment.TAG")) {
        j = 14;
      }
      break;
    case -544527954: 
      if (paramString.equals("CameraSetLocationFragment.TAG")) {
        j = 13;
      }
      break;
    case -733694149: 
      if (paramString.equals("CameraConnectTypeFragment.TAG")) {
        j = 12;
      }
      break;
    case -772422689: 
      if (paramString.equals("CameraWiredSetWirelessFailedFragment.TAG")) {
        j = 11;
      }
      break;
    case -1001579015: 
      if (paramString.equals("CameraTapoCareIntroduceFragment.TAG")) {
        j = 10;
      }
      break;
    case -1101762370: 
      if (paramString.equals("CameraConfiguredBeforeFragment.TAG")) {
        j = 9;
      }
      break;
    case -1106653554: 
      if (paramString.equals("CameraWiredConnectingFragment.TAG")) {
        j = 8;
      }
      break;
    case -1112117856: 
      if (paramString.equals("CameraAutoUpdateHintFragment.TAG")) {
        j = 7;
      }
      break;
    case -1248588411: 
      if (paramString.equals("CameraInstructionFragment.TAG")) {
        j = 6;
      }
      break;
    case -1288075539: 
      if (paramString.equals("CameraIdentifyFragment.TAG")) {
        j = 5;
      }
      break;
    case -1516659752: 
      if (paramString.equals("CameraRoomSelectFragment.TAG")) {
        j = 4;
      }
      break;
    case -1582334756: 
      if (paramString.equals("CameraPairingFailedFragment.TAG")) {
        j = 3;
      }
      break;
    case -1612627066: 
      if (paramString.equals("CameraRescanWifiFragment.TAG")) {
        j = 2;
      }
      break;
    case -1977640039: 
      if (paramString.equals("CameraSdHintFragment.TAG")) {
        j = 1;
      }
      break;
    case -2078871525: 
      if (paramString.equals("CameraWiredConnectApFragment.TAG")) {
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
      localObject = h1();
      continue;
      localObject = s1();
      continue;
      localObject = i1();
      continue;
      localObject = T0();
      continue;
      localObject = u1();
      continue;
      localObject = X0();
      continue;
      localObject = d1();
      continue;
      localObject = j1();
      continue;
      localObject = y1();
      continue;
      localObject = f1();
      continue;
      localObject = Y0();
      continue;
      localObject = U0();
      continue;
      localObject = x1();
      continue;
      localObject = q1();
      continue;
      localObject = m1();
      continue;
      localObject = c1();
      continue;
      localObject = e1();
      continue;
      localObject = w1();
      continue;
      localObject = W0();
      continue;
      localObject = R0();
      continue;
      localObject = p1();
      continue;
      localObject = S0();
      continue;
      localObject = n1();
      continue;
      localObject = a1();
      continue;
      localObject = t1();
      continue;
      localObject = Z0();
      continue;
      localObject = B1();
      continue;
      localObject = v1();
      continue;
      localObject = V0();
      continue;
      localObject = A1();
      continue;
      localObject = Q0();
      continue;
      localObject = g1();
      continue;
      localObject = b1();
      continue;
      localObject = o1();
      continue;
      localObject = k1();
      continue;
      localObject = l1();
      continue;
      localObject = r1();
      continue;
      localObject = z1();
    }
    this.d = true;
    I1((Fragment)localObject, paramString, paramBundle, paramInt, 2131362323);
  }
  
  private void L1()
  {
    this.q.R().observe(this, new o0(this));
  }
  
  private void P0()
  {
    if (this.c.size() <= 1)
    {
      finish();
    }
    else
    {
      this.c.pop();
      f localf = (f)this.c.peek();
      K1(localf.b(), localf.a(), 4);
    }
  }
  
  private CameraAutoUpdateHintFragment Q0()
  {
    J1(false);
    CameraAutoUpdateHintFragment localCameraAutoUpdateHintFragment1 = (CameraAutoUpdateHintFragment)getSupportFragmentManager().findFragmentByTag("CameraAutoUpdateHintFragment.TAG");
    CameraAutoUpdateHintFragment localCameraAutoUpdateHintFragment2 = localCameraAutoUpdateHintFragment1;
    if (localCameraAutoUpdateHintFragment1 == null) {
      localCameraAutoUpdateHintFragment2 = new CameraAutoUpdateHintFragment();
    }
    return localCameraAutoUpdateHintFragment2;
  }
  
  private CameraBeforeInstallFragment R0()
  {
    J1(false);
    CameraBeforeInstallFragment localCameraBeforeInstallFragment1 = (CameraBeforeInstallFragment)getSupportFragmentManager().findFragmentByTag("CameraBeforeInstallFragment.TAG");
    CameraBeforeInstallFragment localCameraBeforeInstallFragment2 = localCameraBeforeInstallFragment1;
    if (localCameraBeforeInstallFragment1 == null) {
      localCameraBeforeInstallFragment2 = new CameraBeforeInstallFragment();
    }
    return localCameraBeforeInstallFragment2;
  }
  
  private CameraCannotFindFragment S0()
  {
    J1(false);
    CameraCannotFindFragment localCameraCannotFindFragment1 = (CameraCannotFindFragment)getSupportFragmentManager().findFragmentByTag("CameraCannotFindFragment.TAG");
    CameraCannotFindFragment localCameraCannotFindFragment2 = localCameraCannotFindFragment1;
    if (localCameraCannotFindFragment1 == null) {
      localCameraCannotFindFragment2 = new CameraCannotFindFragment();
    }
    return localCameraCannotFindFragment2;
  }
  
  private CameraCheckStatusFragment T0()
  {
    J1(false);
    CameraCheckStatusFragment localCameraCheckStatusFragment1 = (CameraCheckStatusFragment)getSupportFragmentManager().findFragmentByTag("CameraCheckStatusFragment.TAG");
    CameraCheckStatusFragment localCameraCheckStatusFragment2 = localCameraCheckStatusFragment1;
    if (localCameraCheckStatusFragment1 == null) {
      localCameraCheckStatusFragment2 = new CameraCheckStatusFragment();
    }
    return localCameraCheckStatusFragment2;
  }
  
  private CameraCompleteFragment U0()
  {
    J1(false);
    CameraCompleteFragment localCameraCompleteFragment1 = (CameraCompleteFragment)getSupportFragmentManager().findFragmentByTag("CameraCompleteFragment.TAG");
    CameraCompleteFragment localCameraCompleteFragment2 = localCameraCompleteFragment1;
    if (localCameraCompleteFragment1 == null) {
      localCameraCompleteFragment2 = new CameraCompleteFragment();
    }
    return localCameraCompleteFragment2;
  }
  
  private CameraConfiguredBeforeFragment V0()
  {
    J1(false);
    CameraConfiguredBeforeFragment localCameraConfiguredBeforeFragment1 = (CameraConfiguredBeforeFragment)getSupportFragmentManager().findFragmentByTag("CameraConfiguredBeforeFragment.TAG");
    CameraConfiguredBeforeFragment localCameraConfiguredBeforeFragment2 = localCameraConfiguredBeforeFragment1;
    if (localCameraConfiguredBeforeFragment1 == null) {
      localCameraConfiguredBeforeFragment2 = new CameraConfiguredBeforeFragment();
    }
    return localCameraConfiguredBeforeFragment2;
  }
  
  private CameraConnectApFragment W0()
  {
    J1(true);
    CameraConnectApFragment localCameraConnectApFragment1 = (CameraConnectApFragment)getSupportFragmentManager().findFragmentByTag("CameraConnectApFragment.TAG");
    CameraConnectApFragment localCameraConnectApFragment2 = localCameraConnectApFragment1;
    if (localCameraConnectApFragment1 == null) {
      localCameraConnectApFragment2 = new CameraConnectApFragment();
    }
    return localCameraConnectApFragment2;
  }
  
  private CameraConnectRouterFragment X0()
  {
    J1(false);
    CameraConnectRouterFragment localCameraConnectRouterFragment1 = (CameraConnectRouterFragment)getSupportFragmentManager().findFragmentByTag("CameraConnectRouterFragment.TAG");
    CameraConnectRouterFragment localCameraConnectRouterFragment2 = localCameraConnectRouterFragment1;
    if (localCameraConnectRouterFragment1 == null) {
      localCameraConnectRouterFragment2 = new CameraConnectRouterFragment();
    }
    return localCameraConnectRouterFragment2;
  }
  
  private CameraConnectToPairFragment Y0()
  {
    J1(false);
    CameraConnectToPairFragment localCameraConnectToPairFragment1 = (CameraConnectToPairFragment)getSupportFragmentManager().findFragmentByTag("CameraConnectToPairFragment.TAG");
    CameraConnectToPairFragment localCameraConnectToPairFragment2 = localCameraConnectToPairFragment1;
    if (localCameraConnectToPairFragment1 == null) {
      localCameraConnectToPairFragment2 = new CameraConnectToPairFragment();
    }
    return localCameraConnectToPairFragment2;
  }
  
  private CameraConnectTypeFragment Z0()
  {
    J1(false);
    CameraConnectTypeFragment localCameraConnectTypeFragment1 = (CameraConnectTypeFragment)getSupportFragmentManager().findFragmentByTag("CameraConnectTypeFragment.TAG");
    CameraConnectTypeFragment localCameraConnectTypeFragment2 = localCameraConnectTypeFragment1;
    if (localCameraConnectTypeFragment1 == null) {
      localCameraConnectTypeFragment2 = new CameraConnectTypeFragment();
    }
    return localCameraConnectTypeFragment2;
  }
  
  private CameraConnectingFragment a1()
  {
    J1(true);
    CameraConnectingFragment localCameraConnectingFragment1 = (CameraConnectingFragment)getSupportFragmentManager().findFragmentByTag("CameraConnectingFragment.TAG");
    CameraConnectingFragment localCameraConnectingFragment2 = localCameraConnectingFragment1;
    if (localCameraConnectingFragment1 == null) {
      localCameraConnectingFragment2 = new CameraConnectingFragment();
    }
    return localCameraConnectingFragment2;
  }
  
  private CameraIdentifyFragment b1()
  {
    J1(false);
    CameraIdentifyFragment localCameraIdentifyFragment1 = (CameraIdentifyFragment)getSupportFragmentManager().findFragmentByTag("CameraIdentifyFragment.TAG");
    CameraIdentifyFragment localCameraIdentifyFragment2 = localCameraIdentifyFragment1;
    if (localCameraIdentifyFragment1 == null) {
      localCameraIdentifyFragment2 = new CameraIdentifyFragment();
    }
    return localCameraIdentifyFragment2;
  }
  
  private CameraInputPwdFragment c1()
  {
    J1(false);
    CameraInputPwdFragment localCameraInputPwdFragment1 = (CameraInputPwdFragment)getSupportFragmentManager().findFragmentByTag("CameraInputPwdFragment.TAG");
    CameraInputPwdFragment localCameraInputPwdFragment2 = localCameraInputPwdFragment1;
    if (localCameraInputPwdFragment1 == null) {
      localCameraInputPwdFragment2 = new CameraInputPwdFragment();
    }
    return localCameraInputPwdFragment2;
  }
  
  private CameraInstallGuideFragment d1()
  {
    J1(false);
    CameraInstallGuideFragment localCameraInstallGuideFragment1 = (CameraInstallGuideFragment)getSupportFragmentManager().findFragmentByTag("CameraInstallGuideFragment.TAG");
    CameraInstallGuideFragment localCameraInstallGuideFragment2 = localCameraInstallGuideFragment1;
    if (localCameraInstallGuideFragment1 == null) {
      localCameraInstallGuideFragment2 = new CameraInstallGuideFragment();
    }
    return localCameraInstallGuideFragment2;
  }
  
  private CameraInstallHelpfulItemsFragment e1()
  {
    J1(false);
    CameraInstallHelpfulItemsFragment localCameraInstallHelpfulItemsFragment1 = (CameraInstallHelpfulItemsFragment)getSupportFragmentManager().findFragmentByTag("CameraInstallHelpfulItemsFragment.TAG");
    CameraInstallHelpfulItemsFragment localCameraInstallHelpfulItemsFragment2 = localCameraInstallHelpfulItemsFragment1;
    if (localCameraInstallHelpfulItemsFragment1 == null) {
      localCameraInstallHelpfulItemsFragment2 = new CameraInstallHelpfulItemsFragment();
    }
    return localCameraInstallHelpfulItemsFragment2;
  }
  
  private CameraInstallPreviewFragment f1()
  {
    J1(false);
    CameraInstallPreviewFragment localCameraInstallPreviewFragment1 = (CameraInstallPreviewFragment)getSupportFragmentManager().findFragmentByTag("CameraInstallPreviewFragment.TAG");
    CameraInstallPreviewFragment localCameraInstallPreviewFragment2 = localCameraInstallPreviewFragment1;
    if (localCameraInstallPreviewFragment1 == null) {
      localCameraInstallPreviewFragment2 = new CameraInstallPreviewFragment();
    }
    return localCameraInstallPreviewFragment2;
  }
  
  private CameraInstructionFragment g1()
  {
    J1(false);
    CameraInstructionFragment localCameraInstructionFragment1 = (CameraInstructionFragment)getSupportFragmentManager().findFragmentByTag("CameraInstructionFragment.TAG");
    CameraInstructionFragment localCameraInstructionFragment2 = localCameraInstructionFragment1;
    if (localCameraInstructionFragment1 == null) {
      localCameraInstructionFragment2 = new CameraInstructionFragment();
    }
    return localCameraInstructionFragment2;
  }
  
  private CameraLocationPermissionFragment h1()
  {
    J1(false);
    CameraLocationPermissionFragment localCameraLocationPermissionFragment1 = (CameraLocationPermissionFragment)getSupportFragmentManager().findFragmentByTag("CameraLocationPermissionFragment.TAG");
    CameraLocationPermissionFragment localCameraLocationPermissionFragment2 = localCameraLocationPermissionFragment1;
    if (localCameraLocationPermissionFragment1 == null) {
      localCameraLocationPermissionFragment2 = new CameraLocationPermissionFragment();
    }
    return localCameraLocationPermissionFragment2;
  }
  
  private CameraManualInputPwdFragment i1()
  {
    J1(false);
    CameraManualInputPwdFragment localCameraManualInputPwdFragment1 = (CameraManualInputPwdFragment)getSupportFragmentManager().findFragmentByTag("CameraManualInputPwdFragment.TAG");
    CameraManualInputPwdFragment localCameraManualInputPwdFragment2 = localCameraManualInputPwdFragment1;
    if (localCameraManualInputPwdFragment1 == null) {
      localCameraManualInputPwdFragment2 = new CameraManualInputPwdFragment();
    }
    return localCameraManualInputPwdFragment2;
  }
  
  private CameraNotFoundFragment j1()
  {
    J1(false);
    CameraNotFoundFragment localCameraNotFoundFragment1 = (CameraNotFoundFragment)getSupportFragmentManager().findFragmentByTag("CameraNotFoundFragment.TAG");
    CameraNotFoundFragment localCameraNotFoundFragment2 = localCameraNotFoundFragment1;
    if (localCameraNotFoundFragment1 == null) {
      localCameraNotFoundFragment2 = new CameraNotFoundFragment();
    }
    return localCameraNotFoundFragment2;
  }
  
  private CameraPairingFailedFragment k1()
  {
    J1(false);
    CameraPairingFailedFragment localCameraPairingFailedFragment1 = (CameraPairingFailedFragment)getSupportFragmentManager().findFragmentByTag("CameraPairingFailedFragment.TAG");
    CameraPairingFailedFragment localCameraPairingFailedFragment2 = localCameraPairingFailedFragment1;
    if (localCameraPairingFailedFragment1 == null) {
      localCameraPairingFailedFragment2 = new CameraPairingFailedFragment();
    }
    return localCameraPairingFailedFragment2;
  }
  
  private CameraRescanWifiFragment l1()
  {
    J1(true);
    CameraRescanWifiFragment localCameraRescanWifiFragment1 = (CameraRescanWifiFragment)getSupportFragmentManager().findFragmentByTag("CameraRescanWifiFragment.TAG");
    CameraRescanWifiFragment localCameraRescanWifiFragment2 = localCameraRescanWifiFragment1;
    if (localCameraRescanWifiFragment1 == null) {
      localCameraRescanWifiFragment2 = new CameraRescanWifiFragment();
    }
    return localCameraRescanWifiFragment2;
  }
  
  private CameraResetFragment m1()
  {
    CameraResetFragment localCameraResetFragment1 = (CameraResetFragment)getSupportFragmentManager().findFragmentByTag("CameraResetFragment.TAG");
    CameraResetFragment localCameraResetFragment2 = localCameraResetFragment1;
    if (localCameraResetFragment1 == null) {
      localCameraResetFragment2 = new CameraResetFragment();
    }
    return localCameraResetFragment2;
  }
  
  private CameraRoomCustomFragment n1()
  {
    J1(false);
    CameraRoomCustomFragment localCameraRoomCustomFragment1 = (CameraRoomCustomFragment)getSupportFragmentManager().findFragmentByTag("CameraRoomCustomFragment.TAG");
    CameraRoomCustomFragment localCameraRoomCustomFragment2 = localCameraRoomCustomFragment1;
    if (localCameraRoomCustomFragment1 == null) {
      localCameraRoomCustomFragment2 = new CameraRoomCustomFragment();
    }
    return localCameraRoomCustomFragment2;
  }
  
  private CameraRoomSelectFragment o1()
  {
    J1(false);
    CameraRoomSelectFragment localCameraRoomSelectFragment1 = (CameraRoomSelectFragment)getSupportFragmentManager().findFragmentByTag("CameraRoomSelectFragment.TAG");
    CameraRoomSelectFragment localCameraRoomSelectFragment2 = localCameraRoomSelectFragment1;
    if (localCameraRoomSelectFragment1 == null) {
      localCameraRoomSelectFragment2 = new CameraRoomSelectFragment();
    }
    return localCameraRoomSelectFragment2;
  }
  
  private CameraSSIDListFragment p1()
  {
    J1(false);
    CameraSSIDListFragment localCameraSSIDListFragment1 = (CameraSSIDListFragment)getSupportFragmentManager().findFragmentByTag("CameraSSIDListFragment.TAG");
    CameraSSIDListFragment localCameraSSIDListFragment2 = localCameraSSIDListFragment1;
    if (localCameraSSIDListFragment1 == null) {
      localCameraSSIDListFragment2 = new CameraSSIDListFragment();
    }
    return localCameraSSIDListFragment2;
  }
  
  private CameraSaveSettingFragment q1()
  {
    J1(true);
    CameraSaveSettingFragment localCameraSaveSettingFragment1 = (CameraSaveSettingFragment)getSupportFragmentManager().findFragmentByTag("CameraSaveSettingFragment.TAG");
    CameraSaveSettingFragment localCameraSaveSettingFragment2 = localCameraSaveSettingFragment1;
    if (localCameraSaveSettingFragment1 == null) {
      localCameraSaveSettingFragment2 = new CameraSaveSettingFragment();
    }
    return localCameraSaveSettingFragment2;
  }
  
  private CameraSdHintFragment r1()
  {
    J1(false);
    CameraSdHintFragment localCameraSdHintFragment1 = (CameraSdHintFragment)getSupportFragmentManager().findFragmentByTag("CameraSdHintFragment.TAG");
    CameraSdHintFragment localCameraSdHintFragment2 = localCameraSdHintFragment1;
    if (localCameraSdHintFragment1 == null) {
      localCameraSdHintFragment2 = new CameraSdHintFragment();
    }
    return localCameraSdHintFragment2;
  }
  
  private CameraSearchAfterSetupFragment s1()
  {
    J1(true);
    CameraSearchAfterSetupFragment localCameraSearchAfterSetupFragment1 = (CameraSearchAfterSetupFragment)getSupportFragmentManager().findFragmentByTag("CameraSearchAfterSetupFragment.TAG");
    CameraSearchAfterSetupFragment localCameraSearchAfterSetupFragment2 = localCameraSearchAfterSetupFragment1;
    if (localCameraSearchAfterSetupFragment1 == null) {
      localCameraSearchAfterSetupFragment2 = new CameraSearchAfterSetupFragment();
    }
    return localCameraSearchAfterSetupFragment2;
  }
  
  private CameraSetLocationFragment t1()
  {
    J1(false);
    CameraSetLocationFragment localCameraSetLocationFragment1 = (CameraSetLocationFragment)getSupportFragmentManager().findFragmentByTag("CameraSetLocationFragment.TAG");
    CameraSetLocationFragment localCameraSetLocationFragment2 = localCameraSetLocationFragment1;
    if (localCameraSetLocationFragment1 == null) {
      localCameraSetLocationFragment2 = new CameraSetLocationFragment();
    }
    return localCameraSetLocationFragment2;
  }
  
  private CameraSetNameFragment u1()
  {
    J1(false);
    CameraSetNameFragment localCameraSetNameFragment1 = (CameraSetNameFragment)getSupportFragmentManager().findFragmentByTag("CameraSetNameFragment.TAG");
    CameraSetNameFragment localCameraSetNameFragment2 = localCameraSetNameFragment1;
    if (localCameraSetNameFragment1 == null) {
      localCameraSetNameFragment2 = new CameraSetNameFragment();
    }
    return localCameraSetNameFragment2;
  }
  
  private CameraTapoCareIntroduceFragment v1()
  {
    J1(false);
    CameraTapoCareIntroduceFragment localCameraTapoCareIntroduceFragment1 = (CameraTapoCareIntroduceFragment)getSupportFragmentManager().findFragmentByTag("CameraTapoCareIntroduceFragment.TAG");
    CameraTapoCareIntroduceFragment localCameraTapoCareIntroduceFragment2 = localCameraTapoCareIntroduceFragment1;
    if (localCameraTapoCareIntroduceFragment1 == null) {
      localCameraTapoCareIntroduceFragment2 = new CameraTapoCareIntroduceFragment();
    }
    return localCameraTapoCareIntroduceFragment2;
  }
  
  private CameraTroubleShootingFragment w1()
  {
    J1(false);
    CameraTroubleShootingFragment localCameraTroubleShootingFragment1 = (CameraTroubleShootingFragment)getSupportFragmentManager().findFragmentByTag("CameraTroubleShootingFragment.TAG");
    CameraTroubleShootingFragment localCameraTroubleShootingFragment2 = localCameraTroubleShootingFragment1;
    if (localCameraTroubleShootingFragment1 == null) {
      localCameraTroubleShootingFragment2 = new CameraTroubleShootingFragment();
    }
    return localCameraTroubleShootingFragment2;
  }
  
  private CameraWifiListFragment x1()
  {
    J1(false);
    CameraWifiListFragment localCameraWifiListFragment1 = (CameraWifiListFragment)getSupportFragmentManager().findFragmentByTag("CameraWifiListFragment.TAG");
    CameraWifiListFragment localCameraWifiListFragment2 = localCameraWifiListFragment1;
    if (localCameraWifiListFragment1 == null) {
      localCameraWifiListFragment2 = new CameraWifiListFragment();
    }
    return localCameraWifiListFragment2;
  }
  
  private CameraWiredCompleteFragment y1()
  {
    J1(false);
    CameraWiredCompleteFragment localCameraWiredCompleteFragment1 = (CameraWiredCompleteFragment)getSupportFragmentManager().findFragmentByTag("CameraWiredCompleteFragment.TAG");
    CameraWiredCompleteFragment localCameraWiredCompleteFragment2 = localCameraWiredCompleteFragment1;
    if (localCameraWiredCompleteFragment1 == null) {
      localCameraWiredCompleteFragment2 = new CameraWiredCompleteFragment();
    }
    return localCameraWiredCompleteFragment2;
  }
  
  private CameraWiredConnectApFragment z1()
  {
    J1(true);
    CameraWiredConnectApFragment localCameraWiredConnectApFragment1 = (CameraWiredConnectApFragment)getSupportFragmentManager().findFragmentByTag("CameraWiredConnectApFragment.TAG");
    CameraWiredConnectApFragment localCameraWiredConnectApFragment2 = localCameraWiredConnectApFragment1;
    if (localCameraWiredConnectApFragment1 == null) {
      localCameraWiredConnectApFragment2 = new CameraWiredConnectApFragment();
    }
    return localCameraWiredConnectApFragment2;
  }
  
  public void H1()
  {
    new UniversalDialog.a().q(getString(2131953305)).u(getString(2131951760)).s(getString(2131951757)).t(new p0(this)).l().show(getSupportFragmentManager(), "");
  }
  
  protected void I1(Fragment paramFragment, String paramString, Bundle paramBundle, int paramInt1, int paramInt2)
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
  
  public void J1(boolean paramBoolean)
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
    if ((this.c.size() > 0) && (TextUtils.equals(paramString, ((f)this.c.peek()).b()))) {
      return;
    }
    int i = 0;
    Iterator localIterator = this.c.iterator();
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((f)localIterator.next()).b().equalsIgnoreCase(paramString));
    int j = 1;
    while ((j != 0) && (!((f)this.c.pop()).b().equalsIgnoreCase(paramString)) && (this.c.size() > 0)) {}
    this.c.push(localf);
    if (j != 0) {
      K1(paramString, paramBundle, 4);
    } else {
      K1(paramString, paramBundle, 3);
    }
  }
  
  public void onBackPressed()
  {
    if (this.d) {
      P0();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = ((ActivityCameraV2OnboardingBinding)DataBindingUtil.setContentView(this, 2131558477));
    paramBundle = (CameraOnBoardingViewModel)ViewModelProviders.of(this).get(CameraOnBoardingViewModel.class);
    this.q = paramBundle;
    this.f.h(paramBundle);
    this.c = new Stack();
    C1();
    L1();
    if (c.w(this.q.D())) {
      e0("CameraConnectTypeFragment.TAG", null);
    } else {
      e0("CameraCheckStatusFragment.TAG", null);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e0.a(AppContext.c);
  }
  
  public void q0()
  {
    this.d = false;
  }
  
  public void y0(String paramString)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      this.c = new Stack();
      return;
    }
    if (((Stack)localObject).size() < 0) {
      return;
    }
    localObject = (f)this.c.peek();
    do
    {
      if (((f)this.c.peek()).b().equalsIgnoreCase(paramString)) {
        break;
      }
      this.c.pop();
    } while (this.c.size() > 0);
    if (localObject != null) {
      this.c.push(localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraOnBoardingV2Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */