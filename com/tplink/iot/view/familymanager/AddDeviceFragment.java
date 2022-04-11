package com.tplink.iot.view.familymanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.tplink.iot.adapter.familymanager.AddDeviceAdapter;
import com.tplink.iot.adapter.familymanager.AddDeviceAdapter.d;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddDeviceFragment
  extends BaseFragment
  implements AddDeviceAdapter.d
{
  @BindView
  TPRefreshableButton mAddDeviceBtn;
  @BindView
  RecyclerView mAddDeviceRecyclerView;
  @BindView
  TextView mNoDeviceAddedTv;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private AddDeviceAdapter q;
  private RoomViewModel x;
  
  private void L0()
  {
    C0(RoomDetailActivity.class);
    getActivity().finish();
  }
  
  private void N0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbarTitle.setText(2131951774);
    this.mAddDeviceBtn.setEnabled(false);
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mAddDeviceRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mAddDeviceRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new AddDeviceAdapter(getActivity());
    this.q = ((AddDeviceAdapter)localObject);
    this.mAddDeviceRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    this.q.v(this);
  }
  
  private void O0(List<DeviceBean> paramList, List<GroupInfo> paramList1)
  {
    s0.l(getActivity());
    int i = 1;
    int j;
    if ((paramList != null) && (!paramList.isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      for (;;)
      {
        k = i;
        if (!paramList1.hasNext()) {
          break;
        }
        localArrayList.add(((GroupInfo)paramList1.next()).getId());
      }
    }
    int k = 0;
    Object localObject = FamilyDataManager.INSTANCE;
    paramList1 = ((FamilyDataManager)localObject).getCurFamily().getFamilyId();
    localObject = ((FamilyDataManager)localObject).getCurRoombean().getRoomId();
    if ((j != 0) && (k != 0))
    {
      this.x.y(paramList1, (String)localObject, paramList);
      this.x.A(paramList1, (String)localObject, localArrayList);
    }
    else if (j != 0)
    {
      this.x.y(paramList1, (String)localObject, paramList);
    }
    else if (k != 0)
    {
      this.x.z(paramList1, (String)localObject, localArrayList);
    }
  }
  
  private void P0()
  {
    this.x.s().observe(this, new b());
    this.x.m().observe(this, new c());
  }
  
  private void Q0(List<BaseALIoTDevice> paramList)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    this.x.k(paramList, localHashMap1, localHashMap2);
    if ((localHashMap1.size() <= 0) && (localHashMap2.size() <= 0))
    {
      this.mNoDeviceAddedTv.setVisibility(0);
      this.mAddDeviceRecyclerView.setVisibility(8);
      this.mAddDeviceBtn.setVisibility(8);
    }
    else
    {
      this.mNoDeviceAddedTv.setVisibility(8);
      this.mAddDeviceRecyclerView.setVisibility(0);
      this.mAddDeviceBtn.setVisibility(0);
      this.q.t(localHashMap1, localHashMap2);
    }
  }
  
  @OnClick
  void addDevices()
  {
    this.mAddDeviceBtn.h();
    if (this.q.r() > 0) {
      new TPMaterialDialogV2.Builder(getActivity()).j(getString(2131952469)).l(2131952391, 2131099804, null).o(2131952436, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
    }
  }
  
  public boolean d()
  {
    L0();
    return super.d();
  }
  
  public void k()
  {
    TPRefreshableButton localTPRefreshableButton = this.mAddDeviceBtn;
    boolean bool;
    if (this.q.r() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localTPRefreshableButton.setEnabled(bool);
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.x = ((RoomViewModel)ViewModelProviders.of(this).get(RoomViewModel.class));
    P0();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558726, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    N0();
    return paramLayoutInflater;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      L0();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = AddDeviceFragment.this;
      AddDeviceFragment.I0(paramView, AddDeviceFragment.H0(paramView).p(), AddDeviceFragment.H0(AddDeviceFragment.this).q());
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        AddDeviceFragment.J0(AddDeviceFragment.this);
      } else {
        s0.n(AddDeviceFragment.this.getActivity(), 2131953328);
      }
    }
  }
  
  class c
    implements Observer<List<BaseALIoTDevice>>
  {
    c() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      AddDeviceFragment.K0(AddDeviceFragment.this, paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */