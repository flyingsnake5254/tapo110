package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.a;
import com.tplink.iot.adapter.iothub.AddTriggerDeviceAdapter;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class AddTriggerDevicesFragment
  extends BaseGuardModeSettingFragment
{
  public static final a p0 = new a(null);
  private List<? extends BaseALIoTDevice<?>> H3;
  private HashMap I3;
  private final int p1 = 2131952748;
  private AddTriggerDeviceAdapter p2;
  private GuardModeConfigBean p3;
  
  private final void T0()
  {
    GuardModeConfigBean localGuardModeConfigBean = this.p3;
    if (localGuardModeConfigBean != null)
    {
      List localList = this.H3;
      if (localList != null)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localObject2;
          if (localGuardModeConfigBean.getDeviceIdList().contains(localBaseALIoTDevice.getDeviceId())) {
            localArrayList.add(localObject2);
          }
        }
        localObject1 = this.p2;
        if (localObject1 == null) {
          j.t("mAdapter");
        }
        ((AddTriggerDeviceAdapter)localObject1).t(localList, localArrayList);
      }
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected int J0()
  {
    return this.p1;
  }
  
  protected void N0()
  {
    GuardModeConfigViewModel localGuardModeConfigViewModel = L0();
    AddTriggerDeviceAdapter localAddTriggerDeviceAdapter = this.p2;
    if (localAddTriggerDeviceAdapter == null) {
      j.t("mAdapter");
    }
    localGuardModeConfigViewModel.x(localAddTriggerDeviceAdapter.q());
  }
  
  protected void O0()
  {
    L0().i().observe(getViewLifecycleOwner(), new b(this));
    L0().h().observe(getViewLifecycleOwner(), new c(this));
  }
  
  public View P0(int paramInt)
  {
    if (this.I3 == null) {
      this.I3 = new HashMap();
    }
    View localView1 = (View)this.I3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      this.I3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131558927, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = new AddTriggerDeviceAdapter(K0());
    paramBundle = (RecyclerView)P0(a.config_item_list);
    j.d(paramBundle, "config_item_list");
    paramBundle.setAdapter(paramView);
    paramBundle = p.a;
    this.p2 = paramView;
  }
  
  public static final class a {}
  
  static final class b<T>
    implements Observer<GuardModeConfigBean>
  {
    b(AddTriggerDevicesFragment paramAddTriggerDevicesFragment) {}
    
    public final void a(GuardModeConfigBean paramGuardModeConfigBean)
    {
      AddTriggerDevicesFragment.R0(this.a, paramGuardModeConfigBean);
      AddTriggerDevicesFragment.S0(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends BaseALIoTDevice<?>>>
  {
    c(AddTriggerDevicesFragment paramAddTriggerDevicesFragment) {}
    
    public final void a(List<? extends BaseALIoTDevice<?>> paramList)
    {
      AddTriggerDevicesFragment.Q0(this.a, paramList);
      AddTriggerDevicesFragment.S0(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\AddTriggerDevicesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */