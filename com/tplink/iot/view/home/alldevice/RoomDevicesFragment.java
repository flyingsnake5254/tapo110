package com.tplink.iot.view.home.alldevice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tplink.iot.adapter.home.RoomDeviceListAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.viewmodel.home.HomeBaseViewModel;
import com.tplink.iot.viewmodel.home.HomeRoomDeviceViewModel;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomDevicesFragment
  extends HomeBaseFragment
  implements h
{
  private com.tplink.iot.devicecommon.feature.a H3;
  private HomeRoomDeviceViewModel I3;
  private HomeAllDevicesActivity J3;
  private PullToRefreshContainer p0;
  private RoomDeviceListAdapter p1;
  private RecyclerView p2;
  private View p3;
  private boolean x = false;
  private boolean y = false;
  private String z = null;
  
  private void U1()
  {
    if (this.p1.getItemCount() == 0) {
      return;
    }
    if (this.p1.q()) {
      this.p2.setPadding(j.a(getActivity(), 11.0F), 0, j.a(getActivity(), 11.0F), j.a(getActivity(), 80.0F));
    } else {
      this.p2.setPadding(j.a(getActivity(), 11.0F), j.a(getActivity(), 10.0F), j.a(getActivity(), 11.0F), j.a(getActivity(), 80.0F));
    }
  }
  
  private void Z1()
  {
    if (getArguments() != null)
    {
      this.x = getArguments().getBoolean("tag_all_devices");
      this.y = getArguments().getBoolean("tag_share_device");
      this.z = getArguments().getString("tag_room_id");
    }
  }
  
  static RoomDevicesFragment c2()
  {
    return d2(true, false, null);
  }
  
  private static RoomDevicesFragment d2(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    RoomDevicesFragment localRoomDevicesFragment = new RoomDevicesFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("tag_all_devices", paramBoolean1);
    localBundle.putBoolean("tag_share_device", paramBoolean2);
    localBundle.putString("tag_room_id", paramString);
    localRoomDevicesFragment.setArguments(localBundle);
    return localRoomDevicesFragment;
  }
  
  static RoomDevicesFragment e2(String paramString)
  {
    return d2(false, false, paramString);
  }
  
  static RoomDevicesFragment f2()
  {
    return d2(false, true, null);
  }
  
  private List<e> g2(List<e> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      if (this.x)
      {
        localArrayList.addAll(paramList);
      }
      else
      {
        Object localObject;
        if (this.y)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (e)paramList.next();
            if ((localObject instanceof k))
            {
              localObject = (k)localObject;
              if ((((k)localObject).g() != null) && (((k)localObject).g().isUserRoleTypeDevice())) {
                localArrayList.add(localObject);
              }
            }
          }
        }
        if (!TextUtils.isEmpty(this.z))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (e)paramList.next();
            if ((localObject instanceof k))
            {
              localObject = (k)localObject;
              if ((((k)localObject).g() != null) && (!((k)localObject).g().isUserRoleTypeDevice()) && (TextUtils.equals(((k)localObject).g().getRoomId(), this.z))) {
                localArrayList.add(localObject);
              }
            }
            else if ((localObject instanceof com.tplink.iot.model.home.g))
            {
              localObject = (com.tplink.iot.model.home.g)localObject;
              if ((((com.tplink.iot.model.home.g)localObject).h() != null) && (TextUtils.equals(((com.tplink.iot.model.home.g)localObject).h().getRoomId(), this.z))) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void j2()
  {
    this.I3.C().observe(getViewLifecycleOwner(), new b());
    this.I3.D().observe(getViewLifecycleOwner(), new c());
    this.I3.A().observe(getViewLifecycleOwner(), new d());
    this.I3.B().observe(getViewLifecycleOwner(), new a(this));
  }
  
  public void J0(List<e> paramList)
  {
    this.I3.f(paramList);
  }
  
  public void O0()
  {
    HomeAllDevicesActivity localHomeAllDevicesActivity = this.J3;
    if (localHomeAllDevicesActivity != null) {
      localHomeAllDevicesActivity.q1();
    }
  }
  
  public FamilyInfo P0()
  {
    return this.I3.g();
  }
  
  void V1()
  {
    List localList = this.p1.o();
    if (localList.isEmpty()) {
      return;
    }
    K0(localList);
    com.tplink.iot.Utils.x0.a.b(localList);
  }
  
  void W1()
  {
    List localList = this.p1.o();
    if (localList.isEmpty()) {
      return;
    }
    L0(localList);
    com.tplink.iot.Utils.x0.a.f(localList);
  }
  
  void X1()
  {
    List localList = this.p1.o();
    if (localList.isEmpty()) {
      return;
    }
    N0(localList);
    com.tplink.iot.Utils.x0.a.i(localList);
  }
  
  void Y1()
  {
    Object localObject = this.p1;
    if (localObject != null) {
      ((RoomDeviceListAdapter)localObject).c(false);
    }
    localObject = this.p0;
    if (localObject != null) {
      ((PullToRefreshContainer)localObject).setEnableHeader(true);
    }
  }
  
  public void b(int paramInt)
  {
    HomeAllDevicesActivity localHomeAllDevicesActivity = this.J3;
    if (localHomeAllDevicesActivity != null) {
      localHomeAllDevicesActivity.u1(paramInt, this.p1.p(), this.p1.o());
    }
  }
  
  public void f(int paramInt1, int paramInt2) {}
  
  void h2()
  {
    List localList = this.p1.o();
    if (localList.isEmpty()) {
      return;
    }
    u1(localList);
    com.tplink.iot.Utils.x0.a.h(localList);
  }
  
  public void i(e parame)
  {
    if ((parame instanceof k)) {
      U0((k)parame);
    } else if ((parame instanceof com.tplink.iot.model.home.g)) {
      V0((com.tplink.iot.model.home.g)parame);
    }
  }
  
  void i2()
  {
    List localList = this.p1.o();
    if (localList.isEmpty()) {
      return;
    }
    A1(localList);
    com.tplink.iot.Utils.x0.a.g(localList);
  }
  
  public void j(e parame)
  {
    this.I3.u();
    parame = this.J3;
    if (parame != null) {
      parame.z1();
    }
    parame = this.p0;
    if (parame != null) {
      parame.setEnableHeader(false);
    }
  }
  
  protected void k1(String paramString)
  {
    com.tplink.iot.Utils.x0.a.d(paramString);
  }
  
  public void l(int paramInt, e parame, boolean paramBoolean)
  {
    if ((parame instanceof com.tplink.iot.model.home.g)) {
      Y0((com.tplink.iot.model.home.g)parame, paramBoolean);
    } else if ((parame instanceof k)) {
      X0((k)parame, paramBoolean);
    }
  }
  
  protected void l1(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    String str = paramBaseALIoTDevice.getDeviceIdMD5();
    if (paramBaseALIoTDevice.isBulb()) {
      com.tplink.iot.Utils.x0.a.a(str, paramBoolean);
    } else if (paramBaseALIoTDevice.isPlug()) {
      com.tplink.iot.Utils.x0.a.e(str, paramBoolean);
    }
  }
  
  protected void o1()
  {
    this.c.post(new e());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeAllDevicesActivity)) {
      this.J3 = ((HomeAllDevicesActivity)paramActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558950, paramViewGroup, false);
    this.I3 = ((HomeRoomDeviceViewModel)ViewModelProviders.of(this).get(HomeRoomDeviceViewModel.class));
    Z1();
    this.H3 = new com.tplink.iot.devicecommon.feature.a();
    this.p0 = ((PullToRefreshContainer)paramLayoutInflater.findViewById(2131363828));
    this.p3 = paramLayoutInflater.findViewById(2131363174);
    paramViewGroup = (RecyclerView)paramLayoutInflater.findViewById(2131363820);
    this.p2 = paramViewGroup;
    paramViewGroup.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    paramViewGroup = new RoomDeviceListAdapter(getActivity());
    this.p1 = paramViewGroup;
    paramViewGroup.s(this);
    this.p1.setHasStableIds(true);
    this.p2.setAdapter(this.p1);
    this.p0.setHeader(new com.tplink.iot.widget.g());
    this.p0.setEnableFooter(false);
    this.p0.setListener(new a());
    j2();
    return paramLayoutInflater;
  }
  
  protected void p1() {}
  
  public void q1(List<e> paramList)
  {
    this.I3.m(paramList);
    O0();
  }
  
  public void r1(List<e> paramList)
  {
    this.I3.o(paramList);
  }
  
  protected void s1(boolean paramBoolean, String paramString)
  {
    this.I3.p(false, paramString);
  }
  
  protected void t1(String paramString, boolean paramBoolean)
  {
    this.I3.s(paramString, paramBoolean);
  }
  
  class a
    implements PullToRefreshContainer.e
  {
    a() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      RoomDevicesFragment.N1(RoomDevicesFragment.this).I();
    }
  }
  
  class b
    implements Observer<List<e>>
  {
    b() {}
    
    public void a(@Nullable List<e> paramList)
    {
      paramList = RoomDevicesFragment.O1(RoomDevicesFragment.this, paramList);
      RoomDevicesFragment.P1(RoomDevicesFragment.this).r(paramList);
      RoomDevicesFragment.Q1(RoomDevicesFragment.this);
    }
  }
  
  class c
    implements Observer<List<e>>
  {
    c() {}
    
    public void a(@Nullable List<e> paramList)
    {
      RoomDevicesFragment.R1(RoomDevicesFragment.this).A();
      if (RoomDevicesFragment.P1(RoomDevicesFragment.this).a()) {
        return;
      }
      paramList = RoomDevicesFragment.O1(RoomDevicesFragment.this, paramList);
      RoomDevicesFragment.P1(RoomDevicesFragment.this).r(paramList);
      RoomDevicesFragment.Q1(RoomDevicesFragment.this);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        RoomDevicesFragment.S1(RoomDevicesFragment.this).setVisibility(8);
        RoomDevicesFragment.T1(RoomDevicesFragment.this).setVisibility(0);
      }
      else
      {
        RoomDevicesFragment.S1(RoomDevicesFragment.this).setVisibility(0);
        RoomDevicesFragment.T1(RoomDevicesFragment.this).setVisibility(8);
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      RoomDevicesFragment.R1(RoomDevicesFragment.this).A();
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      RoomDevicesFragment.P1(RoomDevicesFragment.this).notifyDataSetChanged();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\alldevice\RoomDevicesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */