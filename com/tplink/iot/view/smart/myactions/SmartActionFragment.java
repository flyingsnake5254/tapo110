package com.tplink.iot.view.smart.myactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.adapter.smart.SmartActionAdapter;
import com.tplink.iot.adapter.smart.SmartActionAdapter.ActionHolder;
import com.tplink.iot.adapter.smart.SmartActionAdapter.b;
import com.tplink.iot.adapter.smart.SmartListItemDecoration;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.model.smart.b;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.iot.viewmodel.smart.SmartLogViewModel;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

public class SmartActionFragment
  extends BaseFragment
  implements SmartActionAdapter.b
{
  private List<b> p0 = new ArrayList();
  private SmartLogViewModel p1;
  private SmartActionViewModel p2;
  private FragmentActivity p3;
  private View q;
  private TextView x;
  private PullToRefreshContainer y;
  private SmartActionAdapter z;
  
  private void J0(RunShortCutResultBean paramRunShortCutResultBean)
  {
    if ((paramRunShortCutResultBean != null) && (paramRunShortCutResultBean.getSmartId() != null))
    {
      if (paramRunShortCutResultBean.getCode() == 404)
      {
        s0.n(this.p3, 2131953955);
        g1();
        return;
      }
      if (paramRunShortCutResultBean.isSuccess())
      {
        List localList = paramRunShortCutResultBean.getFailedDeviceNames();
        if ((localList != null) && (!localList.isEmpty())) {
          com.tplink.iot.view.smart.a.g.e(getContext(), localList, getString(2131953980), getString(2131953979));
        }
      }
      else
      {
        s0.n(this.p3, 2131953328);
      }
      this.z.E(paramRunShortCutResultBean);
    }
  }
  
  private void K0()
  {
    this.q.setPadding(0, 0, 0, 0);
    this.x = ((TextView)this.q.findViewById(2131364446));
    Object localObject = new SmartActionAdapter(this.p3, false);
    this.z = ((SmartActionAdapter)localObject);
    ((SmartActionAdapter)localObject).A(this);
    localObject = (RecyclerView)this.q.findViewById(2131363949);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.p3));
    ((RecyclerView)localObject).addItemDecoration(new SmartListItemDecoration(this.p3));
    ((RecyclerView)localObject).setAdapter(this.z);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
    localObject = (PullToRefreshContainer)this.q.findViewById(2131363828);
    this.y = ((PullToRefreshContainer)localObject);
    ((PullToRefreshContainer)localObject).setHeader(new com.tplink.iot.widget.g());
    this.y.setEnableFooter(false);
    this.y.setListener(new a());
  }
  
  private void f1()
  {
    this.p1 = ((SmartLogViewModel)ViewModelProviders.of(this).get(SmartLogViewModel.class));
    this.p2 = ((SmartActionViewModel)ViewModelProviders.of(this).get(SmartActionViewModel.class));
  }
  
  private void h()
  {
    this.z.z(this.p0);
    TextView localTextView = this.x;
    int i;
    if (this.p2.Q()) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  private void h1(String paramString, boolean paramBoolean)
  {
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(getContext());
    int i;
    if (paramBoolean) {
      i = 2131953959;
    } else {
      i = 2131953958;
    }
    localBuilder.j(getString(i)).l(2131952391, 2131099804, null).o(2131952401, 2131099808, new k(this, paramString)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void i1()
  {
    this.p2.H().observe(getViewLifecycleOwner(), new h(this));
    this.p2.w().observe(getViewLifecycleOwner(), new n(this));
    this.p2.x().observe(getViewLifecycleOwner(), new e(this));
    this.p2.A().observe(getViewLifecycleOwner(), new i(this));
    this.p2.B().observe(getViewLifecycleOwner(), new f(this));
    this.p1.h().observe(this, new j(this));
    this.p2.D().observe(this, new g(this));
    this.p2.C().observe(this, new l(this));
    this.p2.z().observe(this, new m(this));
  }
  
  public void F(SmartInfo paramSmartInfo)
  {
    s0.l(this.p3);
    this.p2.j(paramSmartInfo);
  }
  
  public void Q(SmartInfo paramSmartInfo, SmartActionAdapter.ActionHolder paramActionHolder)
  {
    v.e();
    this.p2.k(paramSmartInfo.getId());
  }
  
  public void a0()
  {
    o.h0().k("new_smart_info", null);
    ActionHistoryActivity.m1(getContext());
  }
  
  public void g1()
  {
    PullToRefreshContainer localPullToRefreshContainer = this.y;
    if (localPullToRefreshContainer != null) {
      localPullToRefreshContainer.e();
    }
  }
  
  public void h0(int paramInt)
  {
    Object localObject = this.p2.F();
    List localList = this.p2.v();
    boolean bool = false;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = ((SmartInfo)((List)localObject).get(paramInt)).getId();
      bool = true;
    }
    else if (localList != null)
    {
      int i;
      if (localObject != null) {
        i = ((List)localObject).size();
      } else {
        i = 0;
      }
      localObject = ((SmartInfo)localList.get(paramInt - i)).getId();
    }
    else
    {
      localObject = "";
    }
    h1((String)localObject, bool);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558953, paramViewGroup, false);
    setHasOptionsMenu(true);
    if (getActivity() != null) {
      this.p3 = getActivity();
    } else {
      B0();
    }
    f1();
    K0();
    i1();
    g1();
    return this.q;
  }
  
  public void q(int paramInt)
  {
    o.h0().k("new_smart_info", null);
    ActionDetailActivity.F1(getContext(), paramInt, 2);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      g1();
    } else {
      o.h0().k("new_smart_info", null);
    }
  }
  
  class a
    implements PullToRefreshContainer.e
  {
    a() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      SmartActionFragment.H0(SmartActionFragment.this).u();
      SmartActionFragment.H0(SmartActionFragment.this).r();
      SmartActionFragment.H0(SmartActionFragment.this).y();
      SmartActionFragment.H0(SmartActionFragment.this).s();
      SmartActionFragment.I0(SmartActionFragment.this).l(SmartActionFragment.I0(SmartActionFragment.this).m());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\myactions\SmartActionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */