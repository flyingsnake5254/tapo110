package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.smart.b.a;
import com.tplink.iot.view.smart.b.b;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskAddFragment
  extends BaseFragment
{
  private ActionSetupViewModel p0;
  private DeviceChooseViewModel p1;
  private f p2;
  private ItemSmartSettingLayout q;
  private ItemSmartSettingLayout x;
  private ItemSmartSettingLayout y;
  private ActionDetailActivity z;
  
  private boolean J0(@Nullable List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new e());
      localArrayList.add(new b(new x(this)));
      localArrayList.add(new com.tplink.iot.view.smart.b.c());
      localArrayList.add(new a());
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (BaseALIoTDevice)localIterator1.next();
        Iterator localIterator2 = localArrayList.iterator();
        while (localIterator2.hasNext()) {
          if (!((com.tplink.iot.view.smart.b.d)localIterator2.next()).a(paramList))
          {
            i = 0;
            break label160;
          }
        }
        int i = 1;
        label160:
        if (i != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void K0(View paramView)
  {
    ((TextView)paramView.findViewById(2131364290)).setText(2131953944);
    ((Toolbar)paramView.findViewById(2131364275)).setNavigationOnClickListener(new b());
    this.q = ((ItemSmartSettingLayout)paramView.findViewById(2131363901));
    this.x = ((ItemSmartSettingLayout)paramView.findViewById(2131363887));
    this.y = ((ItemSmartSettingLayout)paramView.findViewById(2131363881));
    com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartOneClickBlueBackground.png").u0(new ConditionAddFragment.g(this.q));
    com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartAutoBlueBackground.png").u0(new ConditionAddFragment.g(this.x));
    com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartDeviceTriggerBlueBackground.png").u0(new ConditionAddFragment.g(this.y));
  }
  
  private void O0(@Nullable List<BaseALIoTDevice> paramList)
  {
    Object localObject1 = this.q;
    int i;
    if (this.p0.N()) {
      i = 8;
    } else {
      i = 0;
    }
    ((RelativeLayout)localObject1).setVisibility(i);
    boolean bool = this.p0.N();
    Object localObject2 = null;
    if (!bool)
    {
      this.q.setItemEnable(this.p0.J());
      localItemSmartSettingLayout = this.q;
      if (this.p0.J()) {
        localObject1 = null;
      } else {
        localObject1 = getString(2131953952);
      }
      localItemSmartSettingLayout.setItemInfo((CharSequence)localObject1);
      localItemSmartSettingLayout = this.q;
      if ((!this.p0.N()) && (this.p0.J())) {
        localObject1 = new c();
      } else {
        localObject1 = null;
      }
      localItemSmartSettingLayout.setOnClickListener((View.OnClickListener)localObject1);
    }
    this.x.setItemEnable(this.p0.I());
    ItemSmartSettingLayout localItemSmartSettingLayout = this.x;
    if (this.p0.I()) {
      localObject1 = null;
    } else {
      localObject1 = getString(2131953950);
    }
    localItemSmartSettingLayout.setItemInfo((CharSequence)localObject1);
    localItemSmartSettingLayout = this.x;
    if (!this.p0.I()) {
      localObject1 = null;
    } else {
      localObject1 = new d();
    }
    localItemSmartSettingLayout.setOnClickListener((View.OnClickListener)localObject1);
    bool = J0(paramList);
    this.y.setItemEnable(bool);
    localObject1 = this.y;
    if (bool) {
      paramList = null;
    } else {
      paramList = getString(2131953951);
    }
    ((ItemSmartSettingLayout)localObject1).setItemInfo(paramList);
    localObject1 = this.y;
    if (!bool) {
      paramList = (List<BaseALIoTDevice>)localObject2;
    } else {
      paramList = new e();
    }
    ((RelativeLayout)localObject1).setOnClickListener(paramList);
  }
  
  private void Q0()
  {
    this.p0.r().observe(getViewLifecycleOwner(), new a());
  }
  
  public void P0(f paramf)
  {
    this.p2 = paramf;
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558955, paramViewGroup, false);
    paramViewGroup = (ActionDetailActivity)getActivity();
    this.z = paramViewGroup;
    if (paramViewGroup == null) {
      B0();
    }
    this.p0 = ((ActionSetupViewModel)ViewModelProviders.of(this.z).get(ActionSetupViewModel.class));
    this.p1 = ((DeviceChooseViewModel)ViewModelProviders.of(this.z).get(DeviceChooseViewModel.class));
    com.tplink.iot.view.quicksetup.base.d.J(this.z, paramLayoutInflater.findViewById(2131364275));
    setHasOptionsMenu(true);
    K0(paramLayoutInflater);
    Q0();
    return paramLayoutInflater;
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      TaskAddFragment.H0(TaskAddFragment.this, paramList);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      TaskAddFragment.this.B0();
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (TaskAddFragment.I0(TaskAddFragment.this) != null) {
        TaskAddFragment.I0(TaskAddFragment.this).a();
      }
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      if (TaskAddFragment.I0(TaskAddFragment.this) != null) {
        TaskAddFragment.I0(TaskAddFragment.this).b();
      }
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      if (TaskAddFragment.I0(TaskAddFragment.this) != null) {
        TaskAddFragment.I0(TaskAddFragment.this).c();
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskAddFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */