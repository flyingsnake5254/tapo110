package com.tplink.iot.view.smart.actionsetup.conditiondevice;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.databinding.FragmentDeviceTriggerContainerBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.camera.CameraTriggerFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.camera.CameraTriggerFragment.a;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.common.DeviceTriggerSingleChoiceFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.common.DeviceTriggerSingleChoiceFragment.a;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.dut.ThermostatTriggerFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.dut.ThermostatTriggerFragment.a;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class DeviceTriggerContainerFragment
  extends IoTMVVMBaseFragment<FragmentDeviceTriggerContainerBinding>
  implements Toolbar.OnMenuItemClickListener
{
  private a H3;
  private final f I3 = h.b(new d(this));
  private final f J3 = h.b(new e(this));
  private MenuItem K3;
  private String L3 = "";
  private DeviceTriggerBaseFragment<?> M3;
  private HashMap N3;
  private ActionDetailActivity p1;
  private final f p2 = h.b(new c(this));
  private BaseALIoTDevice<?> p3;
  
  private final void U0(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if ((!paramBaseALIoTDevice.isHub()) && (!paramBaseALIoTDevice.isSensor()) && (!paramBaseALIoTDevice.isSwitch()))
    {
      if (paramBaseALIoTDevice.isCamera()) {
        this.M3 = CameraTriggerFragment.H3.a(K0());
      } else if (b.k(paramBaseALIoTDevice)) {
        this.M3 = ThermostatTriggerFragment.J3.a(K0());
      }
    }
    else {
      this.M3 = DeviceTriggerSingleChoiceFragment.H3.a(K0());
    }
    paramBaseALIoTDevice = this.M3;
    if (paramBaseALIoTDevice != null) {
      getChildFragmentManager().beginTransaction().add(2131362690, paramBaseALIoTDevice, "SubFragment").commit();
    }
  }
  
  private final ActionSetupViewModel W0()
  {
    return (ActionSetupViewModel)this.p2.getValue();
  }
  
  private final Toolbar X0()
  {
    return (Toolbar)this.I3.getValue();
  }
  
  private final TextView Y0()
  {
    return (TextView)this.J3.getValue();
  }
  
  private final void Z0(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    Object localObject = W0().v();
    if (localObject != null)
    {
      localObject = ((SmartInfo)localObject).getTriggerSetting();
      if (localObject != null)
      {
        localObject = ((SmartTrigger)localObject).getThings();
        if (localObject != null)
        {
          Iterator localIterator = ((Iterable)localObject).iterator();
          while (localIterator.hasNext())
          {
            localObject = localIterator.next();
            SmartThingTrigger localSmartThingTrigger = (SmartThingTrigger)localObject;
            j.d(localSmartThingTrigger, "it");
            if (j.a(localSmartThingTrigger.getThingName(), paramBaseALIoTDevice.getDeviceId()))
            {
              paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject;
              break label88;
            }
          }
          paramBaseALIoTDevice = null;
          label88:
          paramBaseALIoTDevice = (SmartThingTrigger)paramBaseALIoTDevice;
          if (paramBaseALIoTDevice != null)
          {
            localObject = this.M3;
            if (localObject != null) {
              ((DeviceTriggerBaseFragment)localObject).X0(paramBaseALIoTDevice);
            }
          }
        }
      }
    }
  }
  
  private final void a1()
  {
    Object localObject1 = this.p3;
    if (localObject1 != null)
    {
      SmartThingTrigger localSmartThingTrigger1 = new SmartThingTrigger();
      localSmartThingTrigger1.setThingName(((BaseALIoTDevice)localObject1).getDeviceId());
      Object localObject2 = W0().n(((BaseALIoTDevice)localObject1).getDeviceId());
      if (localObject2 != null)
      {
        localSmartThingTrigger1.setNickname(((ThingInfo)localObject2).getNickname());
        localSmartThingTrigger1.setAvatarUrl(((ThingInfo)localObject2).getAvatarUrl());
        localSmartThingTrigger1.setSubThing(((ThingInfo)localObject2).isSubThing());
        localSmartThingTrigger1.setCategory(((ThingInfo)localObject2).getCategory());
      }
      localObject2 = this.M3;
      if (localObject2 != null) {
        ((DeviceTriggerBaseFragment)localObject2).T0(localSmartThingTrigger1);
      }
      SmartInfo localSmartInfo = W0().v();
      j.d(localSmartInfo, "mActionSetupViewModel.cachedSmartInfo");
      localObject2 = localSmartInfo.getTriggerSetting();
      if (localObject2 == null) {
        localObject2 = new SmartTrigger();
      }
      Object localObject3 = ((SmartTrigger)localObject2).getThings();
      if (localObject3 == null) {
        localObject3 = new ArrayList();
      }
      int i = 1;
      String str = ((BaseALIoTDevice)localObject1).getDeviceId();
      localObject1 = ((List)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        SmartThingTrigger localSmartThingTrigger2 = (SmartThingTrigger)((Iterator)localObject1).next();
        if (j.a(str, localSmartThingTrigger2.getThingName()))
        {
          localSmartThingTrigger2.setStateReported(localSmartThingTrigger1.getStateReported());
          localSmartThingTrigger2.setEvent(localSmartThingTrigger1.getEvent());
          i = 0;
        }
      }
      if (i != 0) {
        ((List)localObject3).add(0, localSmartThingTrigger1);
      }
      ((SmartTrigger)localObject2).setThings((List)localObject3);
      ((SmartTrigger)localObject2).setManual(false);
      localSmartInfo.setTriggerSetting((SmartTrigger)localObject2);
      W0().p0(localSmartInfo);
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.N3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558919;
  }
  
  public void N0()
  {
    Object localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mActivity");
    }
    d.J((Activity)localObject1, X0());
    setHasOptionsMenu(true);
    localObject1 = W0().t();
    this.p3 = ((BaseALIoTDevice)localObject1);
    if (localObject1 == null)
    {
      B0();
      return;
    }
    if (localObject1 != null)
    {
      Object localObject2 = ((BaseALIoTDevice)localObject1).getDeviceIdMD5();
      j.d(localObject2, "device.deviceIdMD5");
      Q0((String)localObject2);
      localObject2 = X0();
      ((Toolbar)localObject2).inflateMenu(2131623954);
      ((Toolbar)localObject2).setOnMenuItemClickListener(this);
      ((Toolbar)localObject2).setNavigationOnClickListener(new b(this));
      this.K3 = ((Toolbar)localObject2).getMenu().findItem(2131361892);
      localObject2 = Y0();
      Object localObject3 = this.p1;
      if (localObject3 == null) {
        j.t("mActivity");
      }
      localObject3 = l.e((Context)localObject3, ((BaseALIoTDevice)localObject1).getDeviceType(), ((BaseALIoTDevice)localObject1).getDeviceName(), ((BaseALIoTDevice)localObject1).getDeviceModel());
      j.d(localObject3, "it");
      this.L3 = ((String)localObject3);
      p localp = p.a;
      ((TextView)localObject2).setText((CharSequence)localObject3);
      U0((BaseALIoTDevice)localObject1);
      Z0((BaseALIoTDevice)localObject1);
    }
  }
  
  public final BaseALIoTDevice<?> V0()
  {
    return this.p3;
  }
  
  public final void b1(a parama)
  {
    this.H3 = parama;
  }
  
  public final void c1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.K3;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(paramBoolean);
    }
  }
  
  public boolean d()
  {
    DeviceTriggerBaseFragment localDeviceTriggerBaseFragment = this.M3;
    boolean bool;
    if (localDeviceTriggerBaseFragment != null) {
      bool = localDeviceTriggerBaseFragment.d();
    } else {
      bool = false;
    }
    if (!bool) {
      getParentFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
    if (!(paramContext instanceof ActionDetailActivity))
    {
      B0();
      return;
    }
    this.p1 = ((ActionDetailActivity)paramContext);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 2131361892) && (this.H3 != null))
    {
      a1();
      paramMenuItem = this.H3;
      if (paramMenuItem != null) {
        paramMenuItem.a();
      }
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(DeviceTriggerContainerFragment paramDeviceTriggerContainerFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.d();
    }
  }
  
  static final class c
    extends Lambda
    implements a<ActionSetupViewModel>
  {
    c(DeviceTriggerContainerFragment paramDeviceTriggerContainerFragment)
    {
      super();
    }
    
    public final ActionSetupViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(DeviceTriggerContainerFragment.S0(this.c)).get(ActionSetupViewModel.class);
      j.d(localViewModel, "ViewModelProvider(mActiv…tupViewModel::class.java)");
      return (ActionSetupViewModel)localViewModel;
    }
  }
  
  static final class d
    extends Lambda
    implements a<Toolbar>
  {
    d(DeviceTriggerContainerFragment paramDeviceTriggerContainerFragment)
    {
      super();
    }
    
    public final Toolbar a()
    {
      return (Toolbar)DeviceTriggerContainerFragment.T0(this.c).getRoot().findViewById(2131364275);
    }
  }
  
  static final class e
    extends Lambda
    implements a<TextView>
  {
    e(DeviceTriggerContainerFragment paramDeviceTriggerContainerFragment)
    {
      super();
    }
    
    public final TextView a()
    {
      return (TextView)DeviceTriggerContainerFragment.T0(this.c).getRoot().findViewById(2131364290);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\conditiondevice\DeviceTriggerContainerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */