package com.tplink.iot.view.familymanager;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.familymanager.RoomDetailAdapter;
import com.tplink.iot.adapter.familymanager.RoomDetailAdapter.f;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.Collections;
import java.util.List;

public class RoomDetailFragment
  extends BaseFragment
  implements RoomDetailAdapter.f
{
  @BindView
  Button mDeleteRoomButton;
  @BindView
  RecyclerView mRoomDeviceListRecyclerView;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private RoomDetailAdapter q;
  private RoomViewModel x;
  
  private void J0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbarTitle.setText(getString(2131953672));
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mRoomDeviceListRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mRoomDeviceListRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new RoomDetailAdapter(getActivity());
    this.q = ((RoomDetailAdapter)localObject);
    this.mRoomDeviceListRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    this.q.y(this);
  }
  
  private void K0()
  {
    this.x.n().observe(this, new b());
    this.x.s().observe(this, new c());
    this.x.u().observe(this, new d());
  }
  
  private void L0()
  {
    RoomBean localRoomBean = FamilyDataManager.INSTANCE.getCurRoombean();
    if (localRoomBean != null)
    {
      List localList = this.x.r(localRoomBean.getRoomId());
      this.q.x(localRoomBean.getRoomName(), localRoomBean.getDeviceList(), localList);
    }
  }
  
  public void W()
  {
    C0(AddDeviceActivity.class);
  }
  
  public void c0(GroupInfo paramGroupInfo)
  {
    s0.l(getActivity());
    this.x.B(paramGroupInfo.getId(), "");
  }
  
  @OnClick
  void deleteRoom()
  {
    new TPMaterialDialogV2.Builder(getContext()).j(getResources().getString(2131952468)).l(2131952391, 2131099804, null).o(2131952401, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
  }
  
  public void o0(DeviceBean paramDeviceBean)
  {
    s0.l(getActivity());
    this.x.y(FamilyDataManager.INSTANCE.getCurFamily().getFamilyId(), "", Collections.singletonList(paramDeviceBean));
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.x = ((RoomViewModel)ViewModelProviders.of(this).get(RoomViewModel.class));
    K0();
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131623954, paramMenu);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559344, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    J0();
    return paramLayoutInflater;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (2131361892 == paramMenuItem.getItemId())
    {
      C0(FamilyDetailActivity.class);
      getActivity().finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    L0();
  }
  
  public void r0()
  {
    C0(EditRoomNameActivity.class);
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      s0.l(RoomDetailFragment.this.getActivity());
      paramView = RoomDetailFragment.H0(RoomDetailFragment.this);
      FamilyDataManager localFamilyDataManager = FamilyDataManager.INSTANCE;
      paramView.l(localFamilyDataManager.getCurFamily().getFamilyId(), localFamilyDataManager.getCurRoombean().getRoomId());
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        RoomDetailFragment.this.getActivity().finish();
      } else {
        s0.n(RoomDetailFragment.this.getActivity(), 2131953328);
      }
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        RoomDetailFragment.I0(RoomDetailFragment.this);
      } else {
        s0.n(RoomDetailFragment.this.getActivity(), 2131953328);
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        RoomDetailFragment.I0(RoomDetailFragment.this);
      } else {
        s0.n(RoomDetailFragment.this.getActivity(), 2131953328);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\RoomDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */