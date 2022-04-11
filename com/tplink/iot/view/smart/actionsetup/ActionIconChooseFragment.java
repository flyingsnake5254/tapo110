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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.smart.SmartAvatarAdapter;
import com.tplink.iot.adapter.smart.SmartAvatarAdapter.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;

public class ActionIconChooseFragment
  extends BaseFragment
{
  private View q;
  private ActionDetailActivity x;
  private ActionSetupViewModel y;
  
  private void J0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(2131953984);
    ((Toolbar)this.q.findViewById(2131364275)).setNavigationOnClickListener(new a());
    SmartAvatarAdapter localSmartAvatarAdapter = new SmartAvatarAdapter();
    localSmartAvatarAdapter.p(new b());
    RecyclerView localRecyclerView = (RecyclerView)this.q.findViewById(2131363820);
    localRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
    localRecyclerView.setAdapter(localSmartAvatarAdapter);
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
    this.q = paramLayoutInflater.inflate(2131558959, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.x = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    d.J(this.x, this.q.findViewById(2131364275));
    this.y = ((ActionSetupViewModel)ViewModelProviders.of(this.x).get(ActionSetupViewModel.class));
    setHasOptionsMenu(true);
    J0();
    return this.q;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      ActionIconChooseFragment.this.B0();
    }
  }
  
  class b
    implements SmartAvatarAdapter.c
  {
    b() {}
    
    public void a(String paramString)
    {
      SmartInfo localSmartInfo = ActionIconChooseFragment.H0(ActionIconChooseFragment.this).v();
      localSmartInfo.setAvatarUrl(paramString);
      ActionIconChooseFragment.H0(ActionIconChooseFragment.this).p0(localSmartInfo);
      ActionIconChooseFragment.I0(ActionIconChooseFragment.this).U0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ActionIconChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */