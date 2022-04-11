package com.tplink.iot.view.group.detail;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.j;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.viewmodel.group.GroupDetailViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class GroupDetailDeviceListFragment
  extends HomeBaseFragment
  implements h
{
  private GroupDetailViewModel p0;
  private HomeMainAdapter p1;
  private GroupInfo p2;
  private View x;
  private RecyclerView y;
  private String z;
  
  private void S1()
  {
    if (getArguments() != null) {
      this.z = getArguments().getString("group_id");
    }
  }
  
  private void T1()
  {
    if ((getActivity() instanceof BaseActivity)) {
      ((BaseActivity)getActivity()).Y0();
    }
  }
  
  private void U1()
  {
    Object localObject = (RecyclerView)this.x.findViewById(2131363823);
    this.y = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(getActivity(), 2));
    localObject = new HomeMainAdapter(getActivity(), false);
    this.p1 = ((HomeMainAdapter)localObject);
    ((HomeMainAdapter)localObject).u(this);
    this.p1.setHasStableIds(true);
    this.y.setAdapter(this.p1);
  }
  
  public static GroupDetailDeviceListFragment V1(String paramString)
  {
    GroupDetailDeviceListFragment localGroupDetailDeviceListFragment = new GroupDetailDeviceListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", paramString);
    localGroupDetailDeviceListFragment.setArguments(localBundle);
    return localGroupDetailDeviceListFragment;
  }
  
  private void W1()
  {
    this.p0.p().observe(this, new a());
  }
  
  private void X1()
  {
    Object localObject = this.p2;
    if (localObject == null)
    {
      T1();
      return;
    }
    localObject = this.p0.r((GroupInfo)localObject);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.p1.s((List)localObject);
      this.y.setPadding(j.a(getActivity(), 11.0F), j.a(getActivity(), 10.0F), j.a(getActivity(), 11.0F), j.a(getActivity(), 10.0F));
      return;
    }
    T1();
  }
  
  public void J0(List<e> paramList) {}
  
  public void O0() {}
  
  public FamilyInfo P0()
  {
    return null;
  }
  
  public void b(int paramInt) {}
  
  public void f(int paramInt1, int paramInt2) {}
  
  public void i(e parame)
  {
    U0((k)parame);
  }
  
  public void j(e parame) {}
  
  protected void k1(String paramString) {}
  
  public void l(int paramInt, e parame, boolean paramBoolean)
  {
    if ((parame instanceof k)) {
      X0((k)parame, paramBoolean);
    }
  }
  
  protected void l1(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean) {}
  
  protected void o1()
  {
    this.c.post(new b());
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.x = paramLayoutInflater.inflate(2131558925, paramViewGroup, false);
    S1();
    if (TextUtils.isEmpty(this.z)) {
      return this.x;
    }
    this.p0 = ((GroupDetailViewModel)ViewModelProviders.of(this).get(GroupDetailViewModel.class));
    U1();
    W1();
    return this.x;
  }
  
  protected void p1() {}
  
  public void q1(List<e> paramList) {}
  
  public void r1(List<e> paramList) {}
  
  protected void s1(boolean paramBoolean, String paramString)
  {
    this.p0.D(false, paramString);
  }
  
  protected void t1(String paramString, boolean paramBoolean)
  {
    this.p0.F(paramString, paramBoolean);
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = GroupDetailDeviceListFragment.O1(GroupDetailDeviceListFragment.this).o(paramList, GroupDetailDeviceListFragment.N1(GroupDetailDeviceListFragment.this));
      if (paramList != null)
      {
        GroupDetailDeviceListFragment.P1(GroupDetailDeviceListFragment.this, paramList);
        GroupDetailDeviceListFragment.Q1(GroupDetailDeviceListFragment.this);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      GroupDetailDeviceListFragment.R1(GroupDetailDeviceListFragment.this).notifyDataSetChanged();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupDetailDeviceListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */