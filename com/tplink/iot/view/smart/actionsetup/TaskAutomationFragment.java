package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.smart.SmartActionTaskAdapter;
import com.tplink.iot.adapter.smart.SmartActionTaskAdapter.a;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.model.smart.b;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

public class TaskAutomationFragment
  extends BaseFragment
  implements SmartActionTaskAdapter.a
{
  private c p0;
  private View q;
  private SmartActionViewModel x;
  private SmartActionTaskAdapter y;
  private ActionDetailActivity z;
  
  private void J0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(2131953945);
    ((Toolbar)this.q.findViewById(2131364275)).setNavigationOnClickListener(new a());
    Object localObject = new SmartActionTaskAdapter(this.x);
    this.y = ((SmartActionTaskAdapter)localObject);
    ((SmartActionTaskAdapter)localObject).p(this);
    localObject = (RecyclerView)this.q.findViewById(2131363820);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.z));
    ((RecyclerView)localObject).setAdapter(this.y);
  }
  
  private void K0()
  {
    this.x.u();
  }
  
  private void N0()
  {
    this.x.H().observe(this, new b());
  }
  
  public void L0(c paramc)
  {
    this.p0 = paramc;
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
    this.z = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    d.J(this.z, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    this.x = ((SmartActionViewModel)ViewModelProviders.of(this.z).get(SmartActionViewModel.class));
    J0();
    N0();
    K0();
    return this.q;
  }
  
  public void z(int paramInt)
  {
    ((ActionSetupViewModel)ViewModelProviders.of(this.z).get(ActionSetupViewModel.class)).g0((SmartInfo)this.x.v().get(paramInt));
    c localc = this.p0;
    if (localc != null) {
      localc.a();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      TaskAutomationFragment.this.d();
    }
  }
  
  class b
    implements Observer<List<b>>
  {
    b() {}
    
    public void a(@Nullable List<b> paramList)
    {
      SmartActionTaskAdapter localSmartActionTaskAdapter = TaskAutomationFragment.I0(TaskAutomationFragment.this);
      if (paramList != null) {
        paramList = TaskAutomationFragment.H0(TaskAutomationFragment.this).v();
      } else {
        paramList = new ArrayList();
      }
      localSmartActionTaskAdapter.q(paramList);
      TaskAutomationFragment.I0(TaskAutomationFragment.this).notifyDataSetChanged();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskAutomationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */