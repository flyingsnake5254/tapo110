package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter;
import com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter.b;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.view.smart.b.a;
import com.tplink.iot.view.smart.b.b;
import com.tplink.iot.view.smart.b.c;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskDeviceChooseFragment
  extends BaseFragment
  implements SmartDeviceTaskAdapter.b
{
  private ActionDetailActivity p0;
  private a p1;
  private View q;
  private ActionSetupViewModel x;
  private SmartDeviceTaskAdapter y;
  private DeviceChooseViewModel z;
  
  private List<BaseALIoTDevice> H0(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(new e());
      localArrayList2.add(new b(new b0(this)));
      localArrayList2.add(new c());
      localArrayList2.add(new a());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
        int i = 1;
        paramList = localArrayList2.iterator();
        do
        {
          j = i;
          if (!paramList.hasNext()) {
            break;
          }
        } while (((com.tplink.iot.view.smart.b.d)paramList.next()).a(localBaseALIoTDevice));
        int j = 0;
        if (j != 0) {
          localArrayList1.add(localBaseALIoTDevice);
        }
      }
    }
    return localArrayList1;
  }
  
  private void I0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(2131953948);
    ((Toolbar)this.q.findViewById(2131364275)).setNavigationOnClickListener(new z(this));
    Object localObject = new SmartDeviceTaskAdapter(this.p0, this.z);
    this.y = ((SmartDeviceTaskAdapter)localObject);
    ((SmartDeviceTaskAdapter)localObject).q(this);
    localObject = (RecyclerView)this.q.findViewById(2131363820);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.p0));
    ((RecyclerView)localObject).setAdapter(this.y);
  }
  
  private void R0()
  {
    this.x.r().observe(getViewLifecycleOwner(), new a0(this));
  }
  
  public void Q0(a parama)
  {
    this.p1 = parama;
  }
  
  public void Y(ThingInfo paramThingInfo)
  {
    if (paramThingInfo != null) {
      paramThingInfo = paramThingInfo.getThingName();
    } else {
      paramThingInfo = null;
    }
    ActionSetupViewModel localActionSetupViewModel = this.x;
    localActionSetupViewModel.f0(localActionSetupViewModel.l(paramThingInfo));
    paramThingInfo = this.p1;
    if (paramThingInfo != null) {
      paramThingInfo.a();
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
    this.q = paramLayoutInflater.inflate(2131558960, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.p0 = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    com.tplink.iot.view.quicksetup.base.d.J(this.p0, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    this.x = ((ActionSetupViewModel)ViewModelProviders.of(this.p0).get(ActionSetupViewModel.class));
    this.z = ((DeviceChooseViewModel)ViewModelProviders.of(this.p0).get(DeviceChooseViewModel.class));
    I0();
    R0();
    return this.q;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskDeviceChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */