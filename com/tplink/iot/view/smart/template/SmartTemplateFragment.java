package com.tplink.iot.view.smart.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.smart.SmartTemplateAdapter;
import com.tplink.iot.adapter.smart.SmartTemplateAdapter.b;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.model.smart.SmartTemplateBaseBean;
import com.tplink.iot.view.smart.SmartFragment;
import com.tplink.iot.viewmodel.smart.SmartTemplateViewModel;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import java.util.List;

public class SmartTemplateFragment
  extends BaseFragment
  implements SmartTemplateAdapter.b
{
  private boolean p0 = false;
  private View q;
  private PullToRefreshContainer x;
  private SmartTemplateAdapter y;
  private SmartTemplateViewModel z;
  
  private void N0()
  {
    Object localObject = new SmartTemplateAdapter();
    this.y = ((SmartTemplateAdapter)localObject);
    ((SmartTemplateAdapter)localObject).n(this);
    localObject = (RecyclerView)this.q.findViewById(2131363949);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getActivity()));
    ((RecyclerView)localObject).setAdapter(this.y);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
    localObject = (PullToRefreshContainer)this.q.findViewById(2131363828);
    this.x = ((PullToRefreshContainer)localObject);
    ((PullToRefreshContainer)localObject).setHeader(new g());
    this.x.setEnableFooter(false);
    this.x.setListener(new a());
  }
  
  private void O0(List<SmartTemplateBaseBean> paramList)
  {
    this.y.o(paramList);
    this.y.notifyDataSetChanged();
  }
  
  private void P0()
  {
    this.z.g();
  }
  
  private void Q0()
  {
    this.z.k().observe(getViewLifecycleOwner(), new b());
  }
  
  private void R0()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment instanceof SmartFragment)) {
      ((SmartFragment)localFragment).P0();
    }
  }
  
  public void A(int paramInt)
  {
    startActivityForResult(SmartTemplateDetailActivity.r1(getContext(), paramInt), 567);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 567) && (paramInt2 == -1)) {
      R0();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558961, paramViewGroup, false);
    setHasOptionsMenu(true);
    this.z = ((SmartTemplateViewModel)ViewModelProviders.of(this).get(SmartTemplateViewModel.class));
    N0();
    Q0();
    this.x.e();
    return this.q;
  }
  
  class a
    implements PullToRefreshContainer.e
  {
    a() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      SmartTemplateFragment.I0(SmartTemplateFragment.this, true);
      SmartTemplateFragment.J0(SmartTemplateFragment.this);
    }
  }
  
  class b
    implements Observer<List<SmartTemplateBaseBean>>
  {
    b() {}
    
    public void a(@Nullable List<SmartTemplateBaseBean> paramList)
    {
      if (SmartTemplateFragment.H0(SmartTemplateFragment.this))
      {
        SmartTemplateFragment.K0(SmartTemplateFragment.this).A();
        SmartTemplateFragment.I0(SmartTemplateFragment.this, false);
      }
      SmartTemplateFragment localSmartTemplateFragment = SmartTemplateFragment.this;
      if ((paramList == null) || (paramList.isEmpty())) {
        paramList = null;
      }
      SmartTemplateFragment.L0(localSmartTemplateFragment, paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\template\SmartTemplateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */