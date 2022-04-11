package com.tplink.iot.view.smart.actionsetup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.google.gson.k;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.base.BaseLocationFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingFutureAction;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView.d;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceTaskViewModel;
import com.tplink.iot.widget.BulbBrightnessView;
import com.tplink.iot.widget.colorbulb.SmartColorBulbPresetStatusView;
import com.tplink.iot.widget.colorbulb.SmartColorBulbPresetStatusView.a;
import com.tplink.iot.widget.time.TimeMinSecSelectView;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TaskDeviceControlFragment
  extends BaseLocationFragment
  implements Toolbar.OnMenuItemClickListener
{
  private SmartColorBulbPresetStatusView H3;
  private LightingEffectPresetStatusView I3;
  private TimeMinSecSelectView J3;
  private DeviceTaskViewModel K3;
  private ActionSetupViewModel L3;
  private int M3 = 0;
  private int N3;
  private e O3;
  private BulbBrightnessView p0;
  private SmartColorBulbPresetStatusView p1;
  private LightingEffectPresetStatusView p2;
  private BulbBrightnessView p3;
  private ALIoTDevice x;
  private View y;
  private RadioGroup z;
  
  private SmartThingAction T0()
  {
    Object localObject1 = new HashMap(4);
    SmartThingAction localSmartThingAction = new SmartThingAction(this.x.getThingName(), (Map)localObject1, this.L3.F());
    Object localObject2 = this.L3.n(this.x.getThingName());
    if (localObject2 != null)
    {
      localSmartThingAction.setNickname(((ThingInfo)localObject2).getNickname());
      localSmartThingAction.setAvatarUrl(((ThingInfo)localObject2).getAvatarUrl());
      localSmartThingAction.setSubThing(((ThingInfo)localObject2).isSubThing());
      localSmartThingAction.setCategory(((ThingInfo)localObject2).getCategory());
    }
    localObject2 = this.x;
    if ((localObject2 != null) && (((BaseALIoTDevice)localObject2).isCamera())) {
      ((Map)localObject1).put("type", EnumIoTCategory.CAMERA.value());
    }
    int i = this.N3;
    if (i == 2131364315)
    {
      ((Map)localObject1).put("on", Boolean.TRUE);
      localSmartThingAction.setStateDesired((Map)localObject1);
      localSmartThingAction.setService(null);
    }
    else if (i == 2131364314)
    {
      ((Map)localObject1).put("on", Boolean.FALSE);
      localSmartThingAction.setStateDesired((Map)localObject1);
      localSmartThingAction.setService(null);
    }
    else if (i == 2131364316)
    {
      localSmartThingAction.setService(new ThingServiceParams("reverseStatus", new k()));
      localSmartThingAction.setStateDesired(null);
    }
    else
    {
      Object localObject3;
      boolean bool;
      if (i == 2131363769)
      {
        ((Map)localObject1).put("on", Boolean.TRUE);
        localObject3 = this.x;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((BaseALIoTDevice)localObject3).isBulb())
          {
            bool = this.x.isSupportColorAndColorTemp();
            if (a1())
            {
              localObject2 = this.p2.getDesiredStates().toMap();
            }
            else if (bool)
            {
              localObject2 = this.p1.getDesireStates().toMap();
            }
            else
            {
              ((Map)localObject1).put("brightness", Long.valueOf(this.p0.getBrightness()));
              localObject2 = localObject1;
            }
          }
        }
        localSmartThingAction.setStateDesired((Map)localObject2);
        localSmartThingAction.setService(null);
      }
      else if (i == 2131364313)
      {
        ((Map)localObject1).put("on", Boolean.TRUE);
        localObject3 = this.x;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((BaseALIoTDevice)localObject3).isBulb())
          {
            bool = this.x.isSupportColorAndColorTemp();
            if (a1())
            {
              localObject2 = this.I3.getDesiredStates().toMap();
            }
            else if (bool)
            {
              localObject2 = this.H3.getDesireStates().toMap();
            }
            else
            {
              ((Map)localObject1).put("brightness", Long.valueOf(this.p3.getBrightness()));
              localObject2 = localObject1;
            }
          }
        }
        localObject1 = new SmartThingFutureAction();
        ((SmartThingFutureAction)localObject1).setDelaySeconds(this.J3.getSecondOfTime());
        localObject3 = new HashMap(1);
        ((Map)localObject3).put("on", Boolean.FALSE);
        ((SmartThingFutureAction)localObject1).setStateDesired((Map)localObject3);
        localSmartThingAction.setFutureAction((SmartThingFutureAction)localObject1);
        localSmartThingAction.setStateDesired((Map)localObject2);
        localSmartThingAction.setService(null);
      }
      else if (i == 2131363761)
      {
        localSmartThingAction.setService(new ThingServiceParams("increaseBrightness", new k()));
        localSmartThingAction.setStateDesired(null);
      }
      else if (i == 2131363753)
      {
        localSmartThingAction.setService(new ThingServiceParams("decreaseBrightness", new k()));
        localSmartThingAction.setStateDesired(null);
      }
      else if (i == 2131363762)
      {
        localSmartThingAction.setService(new ThingServiceParams("increaseCCT", new k()));
        localSmartThingAction.setStateDesired(null);
      }
      else if (i == 2131363754)
      {
        localSmartThingAction.setService(new ThingServiceParams("decreaseCCT", new k()));
        localSmartThingAction.setStateDesired(null);
      }
      else if (i == 2131363768)
      {
        localSmartThingAction.setService(new ThingServiceParams("randomColor", new k()));
        localSmartThingAction.setStateDesired(null);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("SmartThingAction配置：");
    ((StringBuilder)localObject2).append(i.j(localSmartThingAction));
    a.n("Smart", ((StringBuilder)localObject2).toString());
    return localSmartThingAction;
  }
  
  private void U0(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.z.check(paramInt);
    }
  }
  
  private void V0(ALIoTDevice paramALIoTDevice)
  {
    X0();
    int i = this.N3;
    int j = 0;
    int k;
    if (i == 2131363769) {
      k = 0;
    } else {
      k = 8;
    }
    if (i != 2131364313) {
      j = 8;
    }
    if ((paramALIoTDevice != null) && (this.x.isBulb()))
    {
      boolean bool = paramALIoTDevice.isSupportColorAndColorTemp();
      if (a1())
      {
        this.p2.setVisibility(k);
        this.I3.setVisibility(j);
      }
      else if (bool)
      {
        this.p1.setVisibility(k);
        this.H3.setVisibility(j);
      }
      else
      {
        this.p0.setVisibility(k);
        this.p3.setVisibility(j);
      }
    }
    this.J3.setVisibility(j);
  }
  
  private void W0()
  {
    Object localObject = this.x;
    boolean bool1 = true;
    int i = 0;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).isBulb())) {
      j = 1;
    } else {
      j = 0;
    }
    ViewKt.setVisible(this.y.findViewById(2131364315), this.K3.n());
    localObject = this.y.findViewById(2131362485);
    if ((this.K3.n()) && (j != 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ViewKt.setVisible((View)localObject, bool2);
    localObject = this.y.findViewById(2131362479);
    if ((this.K3.n()) && (j == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ViewKt.setVisible((View)localObject, bool2);
    ViewKt.setVisible(this.y.findViewById(2131364314), this.K3.n());
    ViewKt.setVisible(this.y.findViewById(2131364313), this.K3.n());
    ViewKt.setVisible(this.y.findViewById(2131362480), this.K3.n());
    localObject = this.y.findViewById(2131363769);
    if ((this.K3.n()) && (j != 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ViewKt.setVisible((View)localObject, bool2);
    ViewKt.setVisible(this.y.findViewById(2131364316), this.K3.u());
    ViewKt.setVisible(this.y.findViewById(2131362486), this.K3.u());
    ViewKt.setVisible(this.y.findViewById(2131363761), this.K3.r());
    ViewKt.setVisible(this.y.findViewById(2131363753), this.K3.o());
    localObject = this.y.findViewById(2131362474);
    if ((!this.K3.r()) && (!this.K3.o())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    ViewKt.setVisible((View)localObject, bool2);
    ViewKt.setVisible(this.y.findViewById(2131363762), this.K3.s());
    ViewKt.setVisible(this.y.findViewById(2131363754), this.K3.p());
    localObject = this.y.findViewById(2131362475);
    boolean bool2 = bool1;
    if (!this.K3.s()) {
      if (this.K3.p()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    ViewKt.setVisible((View)localObject, bool2);
    ViewKt.setVisible(this.y.findViewById(2131363768), this.K3.t());
    ViewKt.setVisible(this.y.findViewById(2131362481), this.K3.t());
    for (int j = i; j < this.z.getChildCount(); j++)
    {
      localObject = this.z.getChildAt(j);
      if (((localObject instanceof RadioButton)) && (((View)localObject).getVisibility() == 0))
      {
        this.z.check(((View)localObject).getId());
        break;
      }
    }
  }
  
  private void X0()
  {
    this.p0.setVisibility(8);
    this.p1.setVisibility(8);
    this.p2.setVisibility(8);
    this.p3.setVisibility(8);
    this.H3.setVisibility(8);
    this.I3.setVisibility(8);
  }
  
  private void Y0()
  {
    Object localObject1 = this.L3.v();
    if ((localObject1 != null) && (((SmartInfo)localObject1).getActionSetting() != null))
    {
      Object localObject2 = ((SmartInfo)localObject1).getActionSetting().getThings();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = this.x.getThingName();
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (SmartThingAction)localIterator.next();
          if (((String)localObject1).equals(((SmartThingAction)localObject2).getThingName())) {
            p1((SmartThingAction)localObject2);
          }
        }
      }
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  private void Z0()
  {
    Object localObject = (Toolbar)this.y.findViewById(2131364275);
    ((Toolbar)localObject).inflateMenu(2131623954);
    ((Toolbar)localObject).setOnMenuItemClickListener(this);
    ((Toolbar)localObject).setNavigationOnClickListener(new e0(this));
    ((TextView)this.y.findViewById(2131364290)).setText(this.x.getDeviceName());
    this.p0 = ((BulbBrightnessView)this.y.findViewById(2131364027));
    localObject = (SmartColorBulbPresetStatusView)this.y.findViewById(2131364028);
    this.p1 = ((SmartColorBulbPresetStatusView)localObject);
    ((SmartColorBulbPresetStatusView)localObject).setFragmentManager(getChildFragmentManager());
    this.p1.k(this.K3.g());
    this.p1.setDesiredStates(null);
    this.p1.setOnPresetStatusListener(new a());
    localObject = (LightingEffectPresetStatusView)this.y.findViewById(2131364029);
    this.p2 = ((LightingEffectPresetStatusView)localObject);
    ((LightingEffectPresetStatusView)localObject).setSetLightingTextViewVisible(false);
    this.p2.setFragmentManager(getChildFragmentManager());
    this.p2.setDesiredStates(null);
    this.p2.setDeviceIdMD5(this.x.getDeviceIdMD5());
    this.p2.setAutoLightViewVisible(this.K3.m());
    this.p2.setAutoLightMode(this.K3.g());
    this.p2.setOnPresetStatusChangedListener(new b());
    this.p3 = ((BulbBrightnessView)this.y.findViewById(2131363591));
    localObject = (SmartColorBulbPresetStatusView)this.y.findViewById(2131363592);
    this.H3 = ((SmartColorBulbPresetStatusView)localObject);
    ((SmartColorBulbPresetStatusView)localObject).setFragmentManager(getChildFragmentManager());
    this.H3.k(this.K3.g());
    this.H3.setDesiredStates(null);
    this.H3.setOnPresetStatusListener(new c());
    localObject = (LightingEffectPresetStatusView)this.y.findViewById(2131363593);
    this.I3 = ((LightingEffectPresetStatusView)localObject);
    ((LightingEffectPresetStatusView)localObject).setSetLightingTextViewVisible(false);
    this.I3.setFragmentManager(getChildFragmentManager());
    this.I3.setDesiredStates(null);
    this.I3.setDeviceIdMD5(this.x.getDeviceIdMD5());
    this.I3.setAutoLightViewVisible(this.K3.m());
    this.I3.setAutoLightMode(this.K3.g());
    this.I3.setOnPresetStatusChangedListener(new d());
    this.z = ((RadioGroup)this.y.findViewById(2131363858));
    localObject = (TimeMinSecSelectView)this.y.findViewById(2131364224);
    this.J3 = ((TimeMinSecSelectView)localObject);
    ((TimeMinSecSelectView)localObject).setSecondOfTime(1);
    W0();
    V0(this.x);
    this.z.setOnCheckedChangeListener(new g0(this));
    this.y.findViewById(2131362486).setOnClickListener(new h0(this));
    this.y.findViewById(2131362485).setOnClickListener(new f0(this));
    this.N3 = this.z.getCheckedRadioButtonId();
    ((RadioButton)this.y.findViewById(2131363761)).setText(2131953985);
    ((RadioButton)this.y.findViewById(2131363753)).setText(2131953956);
    ((RadioButton)this.y.findViewById(2131363762)).setText(2131953986);
    ((RadioButton)this.y.findViewById(2131363754)).setText(2131953957);
  }
  
  private boolean a1()
  {
    ALIoTDevice localALIoTDevice = this.x;
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.isLightStrip())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void p1(@NonNull SmartThingAction paramSmartThingAction)
  {
    Map localMap = paramSmartThingAction.getStateDesired();
    Object localObject = paramSmartThingAction.getService();
    int i = 0;
    int j = 0;
    if (localMap != null)
    {
      localObject = (DesiredStatesBean)i.c(i.i(localMap), DesiredStatesBean.class);
      if (localObject != null)
      {
        boolean bool1 = ((DesiredStatesBean)localObject).isOn();
        paramSmartThingAction = paramSmartThingAction.getFutureAction();
        int k = j;
        if (bool1)
        {
          k = j;
          if (paramSmartThingAction != null)
          {
            k = j;
            if (paramSmartThingAction.getDelaySeconds() > 0) {
              k = 1;
            }
          }
        }
        if (k != 0) {
          this.J3.setSecondOfTime(paramSmartThingAction.getDelaySeconds());
        }
        boolean bool2 = this.x.isBulb();
        j = 2131364314;
        if (bool2)
        {
          if (bool1)
          {
            if (k != 0) {
              i = 2131364313;
            } else {
              i = 2131364315;
            }
            j = i;
            if (localMap.containsKey("on"))
            {
              j = i;
              if (localMap.size() > 1)
              {
                bool2 = this.x.isSupportColorAndColorTemp();
                if (a1())
                {
                  if (k != 0) {
                    this.I3.setDesiredStates((DesiredStatesBean)localObject);
                  } else {
                    this.p2.setDesiredStates((DesiredStatesBean)localObject);
                  }
                }
                else if (bool2)
                {
                  if (k != 0) {
                    this.H3.setDesiredStates((DesiredStatesBean)localObject);
                  } else {
                    this.p1.setDesiredStates((DesiredStatesBean)localObject);
                  }
                }
                else if (k != 0) {
                  this.p3.f(((DesiredStatesBean)localObject).getBrightness());
                } else {
                  this.p0.f(((DesiredStatesBean)localObject).getBrightness());
                }
                if (k != 0) {
                  j = 2131364313;
                } else {
                  j = 2131363769;
                }
              }
            }
          }
        }
        else
        {
          if ((!this.x.isPlug()) && (!this.x.isSwitch())) {}
          do
          {
            j = 2131364315;
            break label333;
            if (k != 0) {
              break;
            }
          } while (bool1);
        }
        label333:
        this.z.check(j);
      }
    }
    else if (localObject != null)
    {
      paramSmartThingAction = ((ThingServiceParams)localObject).getServiceId();
      paramSmartThingAction.hashCode();
      switch (paramSmartThingAction.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  j = -1;
                  break;
                } while (!paramSmartThingAction.equals("reverseStatus"));
                j = 5;
                break;
              } while (!paramSmartThingAction.equals("increaseCCT"));
              j = 4;
              break;
            } while (!paramSmartThingAction.equals("decreaseBrightness"));
            j = 3;
            break;
          } while (!paramSmartThingAction.equals("randomColor"));
          j = 2;
          break;
        } while (!paramSmartThingAction.equals("increaseBrightness"));
        j = 1;
        break;
        j = i;
      } while (!paramSmartThingAction.equals("decreaseCCT"));
      switch (j)
      {
      default: 
        break;
      case 5: 
        U0(2131364316, this.K3.u());
        break;
      case 4: 
        U0(2131363762, this.K3.s());
        break;
      case 3: 
        U0(2131363753, this.K3.o());
        break;
      case 2: 
        U0(2131363768, this.K3.t());
        break;
      case 1: 
        U0(2131363761, this.K3.r());
        break;
      case 0: 
        U0(2131363754, this.K3.p());
      }
    }
  }
  
  private void r1()
  {
    this.K3.h().observe(getViewLifecycleOwner(), new d0(this));
    this.K3.i().observe(getViewLifecycleOwner(), new i0(this));
    this.K3.j().observe(getViewLifecycleOwner(), new c0(this));
  }
  
  public void K0()
  {
    if (this.M3 == 2131362886)
    {
      int i = this.N3;
      if (i == 2131363769)
      {
        this.p1.f();
        this.p2.g();
      }
      else if (i == 2131364313)
      {
        this.H3.f();
        this.I3.g();
      }
    }
  }
  
  public boolean d()
  {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.y = paramLayoutInflater.inflate(2131558956, paramViewGroup, false);
    if (getActivity() == null) {
      B0();
    }
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    d.J(paramLayoutInflater, this.y.findViewById(2131364275));
    setHasOptionsMenu(true);
    paramLayoutInflater = (ActionSetupViewModel)ViewModelProviders.of(paramLayoutInflater).get(ActionSetupViewModel.class);
    this.L3 = paramLayoutInflater;
    paramLayoutInflater = paramLayoutInflater.t();
    if (!(paramLayoutInflater instanceof ALIoTDevice))
    {
      B0();
      return this.y;
    }
    paramLayoutInflater = (ALIoTDevice)paramLayoutInflater;
    this.x = paramLayoutInflater;
    this.K3 = ((DeviceTaskViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramLayoutInflater.getDeviceIdMD5())).get(DeviceTaskViewModel.class));
    Z0();
    if (this.x.isBulb())
    {
      r1();
      this.K3.k();
    }
    Y0();
    return this.y;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 2131361892) && (this.O3 != null))
    {
      SmartThingAction localSmartThingAction1 = T0();
      SmartInfo localSmartInfo = this.L3.v();
      Object localObject1 = localSmartInfo.getActionSetting();
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null) {
        paramMenuItem = new SmartAction();
      }
      Object localObject2 = paramMenuItem.getThings();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = this.x.getThingName();
      Iterator localIterator = ((List)localObject1).iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        SmartThingAction localSmartThingAction2 = (SmartThingAction)localIterator.next();
        if (((String)localObject2).equals(localSmartThingAction2.getThingName()))
        {
          localSmartThingAction2.setStateDesired(localSmartThingAction1.getStateDesired());
          localSmartThingAction2.setService(localSmartThingAction1.getService());
          localSmartThingAction2.setDelaySeconds(localSmartThingAction1.getDelaySeconds());
          localSmartThingAction2.setFutureAction(localSmartThingAction1.getFutureAction());
          i = 0;
        }
      }
      if (i != 0) {
        ((List)localObject1).add(0, localSmartThingAction1);
      }
      paramMenuItem.setThings((List)localObject1);
      if ((paramMenuItem.getSmarts() != null) && (paramMenuItem.getSmarts().isEmpty())) {
        paramMenuItem.setSmarts(null);
      }
      localSmartInfo.setActionSetting(paramMenuItem);
      this.L3.p0(localSmartInfo);
      this.O3.a();
    }
    return true;
  }
  
  public void q1(e parame)
  {
    this.O3 = parame;
  }
  
  class a
    implements SmartColorBulbPresetStatusView.a
  {
    a() {}
    
    public void d()
    {
      TaskDeviceControlFragment.R0(TaskDeviceControlFragment.this, 2131362886);
      TaskDeviceControlFragment localTaskDeviceControlFragment = TaskDeviceControlFragment.this;
      localTaskDeviceControlFragment.I0(TaskDeviceControlFragment.S0(localTaskDeviceControlFragment).getDeviceIdMD5());
    }
    
    public void p() {}
  }
  
  class b
    implements LightingEffectPresetStatusView.d
  {
    b() {}
    
    public void a() {}
    
    public void q()
    {
      TaskDeviceControlFragment.R0(TaskDeviceControlFragment.this, 2131362886);
      TaskDeviceControlFragment localTaskDeviceControlFragment = TaskDeviceControlFragment.this;
      localTaskDeviceControlFragment.I0(TaskDeviceControlFragment.S0(localTaskDeviceControlFragment).getDeviceIdMD5());
    }
  }
  
  class c
    implements SmartColorBulbPresetStatusView.a
  {
    c() {}
    
    public void d()
    {
      TaskDeviceControlFragment.R0(TaskDeviceControlFragment.this, 2131362886);
      TaskDeviceControlFragment localTaskDeviceControlFragment = TaskDeviceControlFragment.this;
      localTaskDeviceControlFragment.I0(TaskDeviceControlFragment.S0(localTaskDeviceControlFragment).getDeviceIdMD5());
    }
    
    public void p() {}
  }
  
  class d
    implements LightingEffectPresetStatusView.d
  {
    d() {}
    
    public void a() {}
    
    public void q()
    {
      TaskDeviceControlFragment.R0(TaskDeviceControlFragment.this, 2131362886);
      TaskDeviceControlFragment localTaskDeviceControlFragment = TaskDeviceControlFragment.this;
      localTaskDeviceControlFragment.I0(TaskDeviceControlFragment.S0(localTaskDeviceControlFragment).getDeviceIdMD5());
    }
  }
  
  public static abstract interface e
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskDeviceControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */