package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter;
import com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter.b;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.view.smart.b.f;
import com.tplink.iot.view.smart.b.g;
import com.tplink.iot.view.smart.b.h;
import com.tplink.iot.view.smart.b.i;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionDeviceChooseFragment
  extends BaseFragment
  implements SmartDeviceTriggerAdapter.b
{
  private SmartDeviceTriggerAdapter p0;
  private a p1;
  private View q;
  private ActionDetailActivity x;
  private ActionSetupViewModel y;
  private DeviceChooseViewModel z;
  
  private List<BaseALIoTDevice> H0(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = this.y.v().getActionSetting();
      Object localObject2 = new ArrayList();
      if ((localObject1 != null) && (((SmartAction)localObject1).getThings() != null)) {
        ((List)localObject2).addAll(((SmartAction)localObject1).getThings());
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(new e());
      ((List)localObject1).add(new g(new q(this)));
      ((List)localObject1).add(new h());
      ((List)localObject1).add(new i(new p((List)localObject2)));
      ((List)localObject1).add(new f());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (BaseALIoTDevice)paramList.next();
        int i = 1;
        Iterator localIterator = ((List)localObject1).iterator();
        do
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((com.tplink.iot.view.smart.b.d)localIterator.next()).a((BaseALIoTDevice)localObject2));
        int j = 0;
        if (j != 0) {
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private void I0()
  {
    this.y.r().observe(getViewLifecycleOwner(), new r(this));
  }
  
  private void J0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(2131953948);
    ((Toolbar)this.q.findViewById(2131364275)).setNavigationOnClickListener(new s(this));
    Object localObject = new SmartDeviceTriggerAdapter(this.x);
    this.p0 = ((SmartDeviceTriggerAdapter)localObject);
    ((SmartDeviceTriggerAdapter)localObject).q(this);
    localObject = (RecyclerView)this.q.findViewById(2131363820);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.x));
    ((RecyclerView)localObject).setAdapter(this.p0);
  }
  
  public void S0(a parama)
  {
    this.p1 = parama;
  }
  
  public boolean d()
  {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  public void l0(ThingInfo paramThingInfo)
  {
    if (paramThingInfo != null) {
      paramThingInfo = paramThingInfo.getThingName();
    } else {
      paramThingInfo = null;
    }
    ActionSetupViewModel localActionSetupViewModel = this.y;
    localActionSetupViewModel.f0(localActionSetupViewModel.l(paramThingInfo));
    paramThingInfo = this.p1;
    if (paramThingInfo != null) {
      paramThingInfo.a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558960, paramViewGroup, false);
    paramLayoutInflater = getActivity();
    if (!(paramLayoutInflater instanceof ActionDetailActivity)) {
      B0();
    }
    paramLayoutInflater = (ActionDetailActivity)paramLayoutInflater;
    this.x = paramLayoutInflater;
    com.tplink.iot.view.quicksetup.base.d.J(paramLayoutInflater, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    this.y = ((ActionSetupViewModel)ViewModelProviders.of(this.x).get(ActionSetupViewModel.class));
    this.z = ((DeviceChooseViewModel)ViewModelProviders.of(this.x).get(DeviceChooseViewModel.class));
    J0();
    I0();
    return this.q;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ConditionDeviceChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */