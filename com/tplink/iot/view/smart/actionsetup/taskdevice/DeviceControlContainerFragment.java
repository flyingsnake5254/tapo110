package com.tplink.iot.view.smart.actionsetup.taskdevice;

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
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.databinding.FragmentTaskDeviceControlContainerBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.actionsetup.taskdevice.camera.CameraControlFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.camera.CameraControlFragment.a;
import com.tplink.iot.view.smart.actionsetup.taskdevice.dut.ThermostatControlFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.dut.ThermostatControlFragment.a;
import com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment.a;
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

public final class DeviceControlContainerFragment
  extends IoTMVVMBaseFragment<FragmentTaskDeviceControlContainerBinding>
  implements Toolbar.OnMenuItemClickListener
{
  private a H3;
  private final f I3 = h.b(new d(this));
  private final f J3 = h.b(new e(this));
  private MenuItem K3;
  private String L3 = "";
  private DeviceControlBaseFragment<?> M3;
  private HashMap N3;
  private ActionDetailActivity p1;
  private final f p2 = h.b(new c(this));
  private BaseALIoTDevice<?> p3;
  
  private final void U0(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    Object localObject;
    if (paramBaseALIoTDevice.isHub())
    {
      localObject = TaskHubControlFragment.H3;
      paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIdMD5();
      j.d(paramBaseALIoTDevice, "device.deviceIdMD5");
      this.M3 = ((TaskHubControlFragment.a)localObject).a(paramBaseALIoTDevice);
    }
    else if (paramBaseALIoTDevice.isCamera())
    {
      localObject = CameraControlFragment.H3;
      paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIdMD5();
      j.d(paramBaseALIoTDevice, "device.deviceIdMD5");
      this.M3 = ((CameraControlFragment.a)localObject).a(paramBaseALIoTDevice);
    }
    else if (b.k(paramBaseALIoTDevice))
    {
      localObject = ThermostatControlFragment.J3;
      paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIdMD5();
      j.d(paramBaseALIoTDevice, "device.deviceIdMD5");
      this.M3 = ((ThermostatControlFragment.a)localObject).a(paramBaseALIoTDevice);
    }
    paramBaseALIoTDevice = this.M3;
    if (paramBaseALIoTDevice != null) {
      getChildFragmentManager().beginTransaction().add(2131362690, paramBaseALIoTDevice, "SubFragment").commit();
    }
  }
  
  private final ActionSetupViewModel X0()
  {
    return (ActionSetupViewModel)this.p2.getValue();
  }
  
  private final Toolbar Y0()
  {
    return (Toolbar)this.I3.getValue();
  }
  
  private final TextView Z0()
  {
    return (TextView)this.J3.getValue();
  }
  
  private final void a1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    Object localObject = X0().v();
    if (localObject != null)
    {
      localObject = ((SmartInfo)localObject).getActionSetting();
      if (localObject != null)
      {
        localObject = ((SmartAction)localObject).getThings();
        if (localObject != null)
        {
          Iterator localIterator = ((Iterable)localObject).iterator();
          while (localIterator.hasNext())
          {
            localObject = localIterator.next();
            SmartThingAction localSmartThingAction = (SmartThingAction)localObject;
            j.d(localSmartThingAction, "it");
            if (j.a(localSmartThingAction.getThingName(), paramBaseALIoTDevice.getDeviceId()))
            {
              paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject;
              break label88;
            }
          }
          paramBaseALIoTDevice = null;
          label88:
          paramBaseALIoTDevice = (SmartThingAction)paramBaseALIoTDevice;
          if (paramBaseALIoTDevice != null)
          {
            localObject = this.M3;
            if (localObject != null) {
              ((DeviceControlBaseFragment)localObject).X0(paramBaseALIoTDevice);
            }
          }
        }
      }
    }
  }
  
  private final void b1()
  {
    Object localObject1 = this.p3;
    if (localObject1 != null)
    {
      SmartThingAction localSmartThingAction = new SmartThingAction();
      localSmartThingAction.setThingName(((BaseALIoTDevice)localObject1).getDeviceId());
      localSmartThingAction.setDelaySeconds(X0().F());
      Object localObject2 = X0().n(((BaseALIoTDevice)localObject1).getDeviceId());
      if (localObject2 != null)
      {
        localSmartThingAction.setNickname(((ThingInfo)localObject2).getNickname());
        localSmartThingAction.setAvatarUrl(((ThingInfo)localObject2).getAvatarUrl());
        localSmartThingAction.setSubThing(((ThingInfo)localObject2).isSubThing());
        localSmartThingAction.setCategory(((ThingInfo)localObject2).getCategory());
      }
      localObject2 = this.M3;
      if (localObject2 != null) {
        ((DeviceControlBaseFragment)localObject2).T0(localSmartThingAction);
      }
      SmartInfo localSmartInfo = X0().v();
      j.d(localSmartInfo, "mActionSetupViewModel.cachedSmartInfo");
      localObject2 = localSmartInfo.getActionSetting();
      if (localObject2 == null) {
        localObject2 = new SmartAction();
      }
      Object localObject3 = ((SmartAction)localObject2).getThings();
      if (localObject3 == null) {
        localObject3 = new ArrayList();
      }
      String str = ((BaseALIoTDevice)localObject1).getDeviceId();
      Iterator localIterator = ((List)localObject3).iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        localObject1 = (SmartThingAction)localIterator.next();
        if (j.a(str, ((SmartThingAction)localObject1).getThingName()))
        {
          ((SmartThingAction)localObject1).setStateDesired(localSmartThingAction.getStateDesired());
          ((SmartThingAction)localObject1).setService(localSmartThingAction.getService());
          ((SmartThingAction)localObject1).setDelaySeconds(localSmartThingAction.getDelaySeconds());
          ((SmartThingAction)localObject1).setFutureAction(localSmartThingAction.getFutureAction());
          i = 0;
        }
      }
      if (i != 0) {
        ((List)localObject3).add(0, localSmartThingAction);
      }
      ((SmartAction)localObject2).setThings((List)localObject3);
      localObject3 = ((SmartAction)localObject2).getSmarts();
      if ((localObject3 != null) && (((List)localObject3).isEmpty() == true)) {
        ((SmartAction)localObject2).setSmarts(null);
      }
      localSmartInfo.setActionSetting((SmartAction)localObject2);
      X0().p0(localSmartInfo);
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
    return 2131558982;
  }
  
  public void N0()
  {
    Object localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mActivity");
    }
    d.J((Activity)localObject1, Y0());
    setHasOptionsMenu(true);
    localObject1 = X0().t();
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
      localObject2 = Y0();
      ((Toolbar)localObject2).inflateMenu(2131623954);
      ((Toolbar)localObject2).setOnMenuItemClickListener(this);
      ((Toolbar)localObject2).setNavigationOnClickListener(new b(this));
      this.K3 = ((Toolbar)localObject2).getMenu().findItem(2131361892);
      localObject2 = Z0();
      Object localObject3 = this.p1;
      if (localObject3 == null) {
        j.t("mActivity");
      }
      String str = l.e((Context)localObject3, ((BaseALIoTDevice)localObject1).getDeviceType(), ((BaseALIoTDevice)localObject1).getDeviceName(), ((BaseALIoTDevice)localObject1).getDeviceModel());
      j.d(str, "it");
      this.L3 = str;
      localObject3 = p.a;
      ((TextView)localObject2).setText(str);
      U0((BaseALIoTDevice)localObject1);
      a1((BaseALIoTDevice)localObject1);
    }
  }
  
  public final ActionSetupViewModel V0()
  {
    return X0();
  }
  
  public final BaseALIoTDevice<?> W0()
  {
    return this.p3;
  }
  
  public final void c1(a parama)
  {
    this.H3 = parama;
  }
  
  public boolean d()
  {
    DeviceControlBaseFragment localDeviceControlBaseFragment = this.M3;
    boolean bool;
    if (localDeviceControlBaseFragment != null) {
      bool = localDeviceControlBaseFragment.d();
    } else {
      bool = false;
    }
    if (!bool) {
      getParentFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  public final void d1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.K3;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(paramBoolean);
    }
  }
  
  public final void e1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.K3;
    if (localMenuItem != null) {
      localMenuItem.setVisible(paramBoolean);
    }
  }
  
  public final void f1(String paramString)
  {
    TextView localTextView = Z0();
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText(paramString);
  }
  
  public final void g1()
  {
    Z0().setText(this.L3);
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
      b1();
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
    b(DeviceControlContainerFragment paramDeviceControlContainerFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.d();
    }
  }
  
  static final class c
    extends Lambda
    implements a<ActionSetupViewModel>
  {
    c(DeviceControlContainerFragment paramDeviceControlContainerFragment)
    {
      super();
    }
    
    public final ActionSetupViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(DeviceControlContainerFragment.S0(this.c)).get(ActionSetupViewModel.class);
      j.d(localViewModel, "ViewModelProvider(mActiv…tupViewModel::class.java)");
      return (ActionSetupViewModel)localViewModel;
    }
  }
  
  static final class d
    extends Lambda
    implements a<Toolbar>
  {
    d(DeviceControlContainerFragment paramDeviceControlContainerFragment)
    {
      super();
    }
    
    public final Toolbar a()
    {
      return (Toolbar)DeviceControlContainerFragment.T0(this.c).getRoot().findViewById(2131364275);
    }
  }
  
  static final class e
    extends Lambda
    implements a<TextView>
  {
    e(DeviceControlContainerFragment paramDeviceControlContainerFragment)
    {
      super();
    }
    
    public final TextView a()
    {
      return (TextView)DeviceControlContainerFragment.T0(this.c).getRoot().findViewById(2131364290);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\DeviceControlContainerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */