package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter.b;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter.a;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter.b;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.databinding.FragmentTaskHubControlBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;
import kotlin.p;

public final class TaskHubControlFragment
  extends DeviceControlBaseFragment<FragmentTaskHubControlBinding>
  implements View.OnClickListener
{
  public static final a H3 = new a(null);
  private final f I3 = h.b(new d(this));
  private b J3;
  private HashMap K3;
  
  private final List<Pair<String, Integer>> b1()
  {
    Object localObject1 = V0();
    if (localObject1 != null)
    {
      localObject1 = ((DeviceControlContainerFragment)localObject1).W0();
      if (localObject1 != null)
      {
        localObject1 = ((BaseALIoTDevice)localObject1).getDeviceId();
        break label28;
      }
    }
    localObject1 = null;
    label28:
    if (localObject1 != null)
    {
      Object localObject2 = V0();
      if (localObject2 != null)
      {
        localObject2 = ((DeviceControlContainerFragment)localObject2).V0();
        if (localObject2 != null)
        {
          localObject2 = ((ActionSetupViewModel)localObject2).v();
          if (localObject2 != null)
          {
            localObject2 = ((SmartInfo)localObject2).getTriggerSetting();
            if (localObject2 != null)
            {
              localObject2 = ((SmartTrigger)localObject2).getThings();
              if ((localObject2 != null) && (!((Collection)localObject2).isEmpty()))
              {
                Iterator localIterator = ((Iterable)localObject2).iterator();
                while (localIterator.hasNext())
                {
                  localObject2 = (SmartThingTrigger)localIterator.next();
                  j.d(localObject2, "it");
                  if (j.a(((SmartThingTrigger)localObject2).getThingName(), localObject1))
                  {
                    localObject2 = ((SmartThingTrigger)localObject2).getEvent();
                    if (localObject2 != null) {
                      localObject2 = ((ThingEventParams)localObject2).getName();
                    } else {
                      localObject2 = null;
                    }
                    if (j.a(localObject2, "alarm"))
                    {
                      i = 1;
                      break label169;
                    }
                  }
                  i = 0;
                  label169:
                  if (i != 0)
                  {
                    i = 1;
                    break label183;
                  }
                }
              }
            }
          }
        }
      }
    }
    int i = 0;
    label183:
    localObject1 = new ArrayList();
    if ((d1().o()) && (d1().p()))
    {
      ((List)localObject1).add(n.a(getString(2131954019), Integer.valueOf(0)));
      ((List)localObject1).add(n.a(getString(2131954015), Integer.valueOf(1)));
    }
    if (d1().p()) {
      ((List)localObject1).add(n.a(getString(2131952795), Integer.valueOf(3)));
    }
    if ((i == 0) && (d1().r())) {
      ((List)localObject1).add(n.a(getString(2131954009), Integer.valueOf(4)));
    }
    return (List<Pair<String, Integer>>)localObject1;
  }
  
  private final String c1(GuardModeAlarmTimeBean paramGuardModeAlarmTimeBean)
  {
    Object localObject = paramGuardModeAlarmTimeBean.getEnumType();
    int i = b.a[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        GuardModeAlarmTimeAdapter.b localb = GuardModeAlarmTimeAdapter.k;
        localObject = requireContext();
        j.d(localObject, "requireContext()");
        paramGuardModeAlarmTimeBean = localb.c((Context)localObject, paramGuardModeAlarmTimeBean.getTime());
      }
      else
      {
        throw new NoWhenBranchMatchedException();
      }
    }
    else
    {
      paramGuardModeAlarmTimeBean = getResources().getString(2131952744);
      j.d(paramGuardModeAlarmTimeBean, "resources.getString(R.string.gm_alarm_time_always)");
    }
    return paramGuardModeAlarmTimeBean;
  }
  
  private final TaskHubControlViewModel d1()
  {
    return (TaskHubControlViewModel)this.I3.getValue();
  }
  
  private final void e1(IoTMVVMBaseFragment<?> paramIoTMVVMBaseFragment)
  {
    paramIoTMVVMBaseFragment.P0(K0());
    getChildFragmentManager().beginTransaction().setCustomAnimations(2130772040, 2130772043, 2130772039, 2130772044).replace(2131362690, paramIoTMVVMBaseFragment).addToBackStack(null).commitAllowingStateLoss();
  }
  
  private final void g1(GuardModeConfigBean paramGuardModeConfigBean)
  {
    TextView localTextView = ((FragmentTaskHubControlBinding)J0()).p3;
    j.d(localTextView, "mBinding.tvAlarmType");
    localTextView.setText(GuardModeAlarmTypeAdapter.g.a(paramGuardModeConfigBean.getAlarmType()));
    ((FragmentTaskHubControlBinding)J0()).H3.setText(GuardModeAlarmVolumeAdapter.h.a(paramGuardModeConfigBean.getEnumAlarmVolume()));
    localTextView = ((FragmentTaskHubControlBinding)J0()).p2;
    j.d(localTextView, "mBinding.tvAlarmTime");
    localTextView.setText(c1(paramGuardModeConfigBean.getAlarmTime()));
  }
  
  public void H0()
  {
    HashMap localHashMap = this.K3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558983;
  }
  
  public void N0()
  {
    Object localObject1 = b1();
    Object localObject2 = ((FragmentTaskHubControlBinding)J0()).p1;
    j.d(localObject2, "mBinding.rvDeviceAction");
    localObject1 = new b((List)localObject1);
    ((SingleCheckMarkAdapter)localObject1).y(new c(this));
    p localp = p.a;
    this.J3 = ((b)localObject1);
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    localObject2 = ((FragmentTaskHubControlBinding)J0()).p1;
    j.d(localObject2, "mBinding.rvDeviceAction");
    localObject1 = ((RecyclerView)localObject2).getItemAnimator();
    localObject2 = localObject1;
    if (!(localObject1 instanceof SimpleItemAnimator)) {
      localObject2 = null;
    }
    localObject2 = (SimpleItemAnimator)localObject2;
    if (localObject2 != null) {
      ((SimpleItemAnimator)localObject2).setSupportsChangeAnimations(false);
    }
    ((FragmentTaskHubControlBinding)J0()).x.setOnClickListener(this);
    ((FragmentTaskHubControlBinding)J0()).y.setOnClickListener(this);
    ((FragmentTaskHubControlBinding)J0()).q.setOnClickListener(this);
    d1().m();
  }
  
  public void R0()
  {
    d1().i().observe(getViewLifecycleOwner(), new e(this));
  }
  
  public void T0(SmartThingAction paramSmartThingAction)
  {
    j.e(paramSmartThingAction, "thingAction");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramSmartThingAction.setStateDesired(localLinkedHashMap);
    Object localObject = this.J3;
    if (localObject != null)
    {
      localObject = (Pair)((SingleCheckMarkAdapter)localObject).t();
      if (localObject != null)
      {
        localObject = (Integer)((Pair)localObject).getSecond();
        break label54;
      }
    }
    localObject = null;
    label54:
    if ((localObject != null) && (((Integer)localObject).intValue() == 0))
    {
      localLinkedHashMap.put("guard_mode", EnumGuardMode.HOME.getValue());
      localLinkedHashMap.put("guard_on", Boolean.TRUE);
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      localLinkedHashMap.put("guard_mode", EnumGuardMode.AWAY.getValue());
      localLinkedHashMap.put("guard_on", Boolean.TRUE);
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 2))
    {
      localLinkedHashMap.put("guard_mode", EnumGuardMode.SLEEP.getValue());
      localLinkedHashMap.put("guard_on", Boolean.TRUE);
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 3))
    {
      localLinkedHashMap.put("guard_on", Boolean.FALSE);
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 4))
    {
      paramSmartThingAction.setStateDesired(null);
      paramSmartThingAction.setService(new ThingServiceParams("ring", d1().h()));
    }
  }
  
  protected void W0(SmartThingAction paramSmartThingAction)
  {
    if (paramSmartThingAction != null)
    {
      Object localObject1 = paramSmartThingAction.getStateDesired();
      Map localMap = null;
      Object localObject2 = null;
      if (localObject1 != null)
      {
        localMap = paramSmartThingAction.getStateDesired();
        j.d(localMap, "thingAction.stateDesired");
        paramSmartThingAction = localMap.get("guard_on");
        if (!(paramSmartThingAction instanceof Boolean)) {
          paramSmartThingAction = (SmartThingAction)localObject2;
        }
        if (j.a((Boolean)paramSmartThingAction, Boolean.TRUE))
        {
          paramSmartThingAction = localMap.get("guard_mode");
          if (j.a(paramSmartThingAction, EnumGuardMode.HOME.getValue()))
          {
            paramSmartThingAction = this.J3;
            if (paramSmartThingAction != null) {
              paramSmartThingAction.B(0);
            }
          }
          else if (j.a(paramSmartThingAction, EnumGuardMode.AWAY.getValue()))
          {
            paramSmartThingAction = this.J3;
            if (paramSmartThingAction != null) {
              paramSmartThingAction.B(1);
            }
          }
          else if (j.a(paramSmartThingAction, EnumGuardMode.SLEEP.getValue()))
          {
            paramSmartThingAction = this.J3;
            if (paramSmartThingAction != null) {
              paramSmartThingAction.B(2);
            }
          }
        }
        else
        {
          paramSmartThingAction = this.J3;
          if (paramSmartThingAction != null) {
            paramSmartThingAction.B(3);
          }
        }
      }
      else if (paramSmartThingAction.getService() != null)
      {
        localObject2 = paramSmartThingAction.getService();
        j.d(localObject2, "thingAction.service");
        if (j.a("ring", ((ThingServiceParams)localObject2).getServiceId()))
        {
          localObject2 = this.J3;
          if (localObject2 != null) {
            ((b)localObject2).B(4);
          }
          try
          {
            paramSmartThingAction = paramSmartThingAction.getService();
            j.d(paramSmartThingAction, "thingAction.service");
            paramSmartThingAction = paramSmartThingAction.getInputParams();
            if (paramSmartThingAction != null)
            {
              localObject2 = paramSmartThingAction.c();
              if (localObject2 != null)
              {
                paramSmartThingAction = ((i)localObject2).c().n("type");
                j.d(paramSmartThingAction, "config.asJsonObject.get(INPUT_PARAM_TYPE)");
                paramSmartThingAction = paramSmartThingAction.e();
                localObject1 = d1();
                j.d(paramSmartThingAction, "alarmType");
                ((TaskHubControlViewModel)localObject1).v(paramSmartThingAction);
                paramSmartThingAction = ((i)localObject2).c().n("volume");
                j.d(paramSmartThingAction, "config.asJsonObject.get(INPUT_PARAM_VOLUME)");
                localObject1 = paramSmartThingAction.e();
                EnumGuardModeAlarmVolume[] arrayOfEnumGuardModeAlarmVolume = EnumGuardModeAlarmVolume.values();
                int i = arrayOfEnumGuardModeAlarmVolume.length;
                for (int j = 0;; j++)
                {
                  paramSmartThingAction = localMap;
                  if (j >= i) {
                    break;
                  }
                  paramSmartThingAction = arrayOfEnumGuardModeAlarmVolume[j];
                  if (j.a(paramSmartThingAction.getValue(), localObject1)) {
                    break;
                  }
                }
                if (paramSmartThingAction == null) {
                  paramSmartThingAction = EnumGuardModeAlarmVolume.HIGH;
                }
                d1().w(paramSmartThingAction);
                paramSmartThingAction = ((i)localObject2).c().n("duration");
                j.d(paramSmartThingAction, "config.asJsonObject.get(INPUT_PARAM_DURATION)");
                j = paramSmartThingAction.a();
                if (j == 0)
                {
                  d1().u(EnumGuardModeAlarmTimeType.ALWAYS, 0);
                  return;
                }
                d1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, j);
                return;
              }
            }
            return;
          }
          catch (Exception paramSmartThingAction)
          {
            b.d.w.c.a.e("Smart", "Hub SmartAction Service JsonObject error");
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    Object localObject = getChildFragmentManager();
    j.d(localObject, "childFragmentManager");
    if (((FragmentManager)localObject).getBackStackEntryCount() != 0)
    {
      getChildFragmentManager().popBackStackImmediate();
      localObject = V0();
      if (localObject != null) {
        ((DeviceControlContainerFragment)localObject).g1();
      }
      localObject = V0();
      if (localObject != null) {
        ((DeviceControlContainerFragment)localObject).e1(true);
      }
      return true;
    }
    return false;
  }
  
  public final void f1(@StringRes int paramInt)
  {
    DeviceControlContainerFragment localDeviceControlContainerFragment = V0();
    if (localDeviceControlContainerFragment != null) {
      localDeviceControlContainerFragment.e1(false);
    }
    localDeviceControlContainerFragment = V0();
    if (localDeviceControlContainerFragment != null) {
      localDeviceControlContainerFragment.f1(getString(paramInt));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362305)) {
      e1(new TaskHubAlarmTypeFragment());
    } else if ((paramView != null) && (paramView.intValue() == 2131362306)) {
      e1(new TaskHubAlarmVolumeFragment());
    } else if ((paramView != null) && (paramView.intValue() == 2131362304)) {
      e1(new TaskHubAlarmTimeFragment());
    }
  }
  
  public static final class a
  {
    public final TaskHubControlFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      TaskHubControlFragment localTaskHubControlFragment = new TaskHubControlFragment();
      localTaskHubControlFragment.P0(paramString);
      return localTaskHubControlFragment;
    }
  }
  
  private final class b
    extends SingleCheckMarkAdapter<Pair<? extends String, ? extends Integer>>
  {
    public b()
    {
      super((List)localObject, 0);
    }
    
    public void A(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, Pair<String, Integer> paramPair, int paramInt)
    {
      j.e(paramSingleCheckMarkViewHolder, "holder");
      j.e(paramPair, "data");
      paramSingleCheckMarkViewHolder.d().setText((CharSequence)paramPair.getFirst());
    }
    
    public final void B(int paramInt)
    {
      Iterator localIterator = q().iterator();
      for (int i = 0; localIterator.hasNext(); i++)
      {
        int j;
        if (((Number)((Pair)localIterator.next()).getSecond()).intValue() == paramInt) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          break label68;
        }
      }
      i = -1;
      label68:
      z(i);
    }
  }
  
  static final class c
    extends Lambda
    implements q<Pair<? extends String, ? extends Integer>, Integer, Boolean, p>
  {
    c(TaskHubControlFragment paramTaskHubControlFragment)
    {
      super();
    }
    
    public final void a(Pair<String, Integer> paramPair, int paramInt, boolean paramBoolean)
    {
      j.e(paramPair, "data");
      LinearLayout localLinearLayout = TaskHubControlFragment.Y0(this.c).p0;
      j.d(localLinearLayout, "mBinding.llAlarmConfig");
      paramInt = ((Number)paramPair.getSecond()).intValue();
      int i = 0;
      if (paramInt == 4) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      localLinearLayout.setVisibility(paramInt);
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<TaskHubControlViewModel>
  {
    d(TaskHubControlFragment paramTaskHubControlFragment)
    {
      super();
    }
    
    public final TaskHubControlViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((Fragment)localObject, TaskHubControlFragment.Z0((TaskHubControlFragment)localObject))).get(TaskHubControlViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TaskHubControlViewModel)localObject;
    }
  }
  
  static final class e<T>
    implements Observer<GuardModeConfigBean>
  {
    e(TaskHubControlFragment paramTaskHubControlFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      if (paramGuardModeConfigBean != null) {
        TaskHubControlFragment.a1(this.a, paramGuardModeConfigBean);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\hub\TaskHubControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */