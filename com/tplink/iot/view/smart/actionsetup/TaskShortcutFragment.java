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
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.model.smart.b;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskShortcutFragment
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
    ((TextView)this.q.findViewById(2131364290)).setText(2131953946);
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
    if (this.p0 != null)
    {
      ActionSetupViewModel localActionSetupViewModel = (ActionSetupViewModel)ViewModelProviders.of(this.z).get(ActionSetupViewModel.class);
      Object localObject1 = (SmartActionViewModel)ViewModelProviders.of(this.z).get(SmartActionViewModel.class);
      SmartInfo localSmartInfo = localActionSetupViewModel.v();
      Object localObject2 = ((SmartActionViewModel)localObject1).F();
      Object localObject3 = localSmartInfo.getActionSetting();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new SmartAction();
      }
      Object localObject4 = ((SmartAction)localObject1).getSmarts();
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      localObject2 = ((SmartInfo)((List)localObject2).get(paramInt)).getId();
      localObject4 = ((List)localObject3).iterator();
      paramInt = 1;
      while (((Iterator)localObject4).hasNext()) {
        if (((String)localObject2).equals(((SmartReferAction)((Iterator)localObject4).next()).getId())) {
          paramInt = 0;
        }
      }
      if (paramInt != 0)
      {
        localObject4 = new SmartReferAction((String)localObject2, 2, localActionSetupViewModel.F());
        ((SmartReferAction)localObject4).setAvatarUrl(localSmartInfo.getAvatarUrl());
        ((SmartReferAction)localObject4).setName(localSmartInfo.getName());
        ((List)localObject3).add(0, localObject4);
      }
      ((SmartAction)localObject1).setSmarts((List)localObject3);
      if ((((SmartAction)localObject1).getThings() != null) && (((SmartAction)localObject1).getThings().isEmpty())) {
        ((SmartAction)localObject1).setThings(null);
      }
      localSmartInfo.setActionSetting((SmartAction)localObject1);
      localActionSetupViewModel.l0(true);
      localActionSetupViewModel.p0(localSmartInfo);
      this.p0.a();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      TaskShortcutFragment.this.d();
    }
  }
  
  class b
    implements Observer<List<b>>
  {
    b() {}
    
    public void a(@Nullable List<b> paramList)
    {
      SmartActionTaskAdapter localSmartActionTaskAdapter = TaskShortcutFragment.I0(TaskShortcutFragment.this);
      if (paramList != null) {
        paramList = TaskShortcutFragment.H0(TaskShortcutFragment.this).F();
      } else {
        paramList = new ArrayList();
      }
      localSmartActionTaskAdapter.q(paramList);
      TaskShortcutFragment.I0(TaskShortcutFragment.this).notifyDataSetChanged();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskShortcutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */