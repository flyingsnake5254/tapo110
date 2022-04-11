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
import com.tplink.iot.adapter.familymanager.FamilyDetailAdapter;
import com.tplink.iot.adapter.familymanager.FamilyDetailAdapter.g;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.familymanager.FamilyViewModel;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.List;

public class FamilyDetailFragment
  extends BaseFragment
  implements FamilyDetailAdapter.g
{
  @BindView
  Button mDeleteHomeButton;
  @BindView
  RecyclerView mRoomListRecyclerView;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private boolean p0;
  private List<FamilyBean> p1;
  private boolean p2;
  private FamilyViewModel q;
  private RoomViewModel x;
  private FamilyDetailAdapter y;
  private FamilyBean z;
  
  private void L0()
  {
    Object localObject = FamilyDataManager.INSTANCE;
    this.z = ((FamilyDataManager)localObject).getCurFamily();
    localObject = ((FamilyDataManager)localObject).getFamilyList();
    this.p1 = ((List)localObject);
    if ((this.z != null) && (localObject != null) && (((List)localObject).size() != 0))
    {
      Q0();
    }
    else
    {
      this.p2 = true;
      s0.l(getActivity());
      this.q.n();
    }
  }
  
  private void N0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mRoomListRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mRoomListRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new FamilyDetailAdapter(getActivity());
    this.y = ((FamilyDetailAdapter)localObject);
    this.mRoomListRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    this.y.t(this);
  }
  
  private void O0()
  {
    new TPMaterialDialogV2.Builder(getActivity()).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void P0()
  {
    this.q.o().observe(this, new b());
    this.q.l().observe(this, new c());
    this.x.n().observe(this, new d());
  }
  
  private void Q0()
  {
    if ((this.z.getDefault()) && (this.z.getFamilyName() != null) && (this.z.getFamilyName().isEmpty())) {
      this.mToolbarTitle.setText(getResources().getString(2131952817));
    } else {
      this.mToolbarTitle.setText(this.z.getFamilyName());
    }
    this.y.s(this.z);
    if (this.z.getDefault()) {
      this.mDeleteHomeButton.setVisibility(8);
    }
  }
  
  public void E(FamilyBean paramFamilyBean)
  {
    C0(EditFamilyNameActivity.class);
  }
  
  @OnClick
  void deleteHome()
  {
    FamilyBean localFamilyBean = this.z;
    if (localFamilyBean == null)
    {
      s0.n(getActivity(), 2131953328);
      return;
    }
    if (localFamilyBean.getDeviceCount() == 0) {
      new TPMaterialDialogV2.Builder(getContext()).j(getResources().getString(2131952467)).l(2131952391, 2131099804, null).o(2131952401, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
    } else {
      s0.p(getActivity(), getString(2131954298));
    }
  }
  
  public void e0(RoomBean paramRoomBean)
  {
    s0.l(getActivity());
    this.x.l(FamilyDataManager.INSTANCE.getCurFamily().getFamilyId(), paramRoomBean.getRoomId());
  }
  
  public void k0(RoomBean paramRoomBean)
  {
    FamilyDataManager.INSTANCE.updateCurRoomBean(paramRoomBean);
    C0(RoomDetailActivity.class);
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getArguments() != null) {
      this.p0 = getArguments().getBoolean("args_key_need_add_home");
    }
    P0();
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    if (this.p0) {
      paramMenuInflater.inflate(2131623946, paramMenu);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558992, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    N0();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.p2) {
      FamilyDataManager.INSTANCE.clearData();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (2131361869 == paramMenuItem.getItemId()) {
      C0(AddFamilyActivity.class);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    L0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.q = ((FamilyViewModel)ViewModelProviders.of(this).get(FamilyViewModel.class));
    this.x = ((RoomViewModel)ViewModelProviders.of(this).get(RoomViewModel.class));
  }
  
  public void u0()
  {
    if (this.y.r() >= 32) {
      O0();
    } else {
      C0(AddRoomActivity.class);
    }
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      s0.l(FamilyDetailFragment.this.getActivity());
      FamilyDetailFragment.I0(FamilyDetailFragment.this).k(FamilyDetailFragment.H0(FamilyDetailFragment.this).getFamilyId());
    }
  }
  
  class b
    implements Observer<List<FamilyBean>>
  {
    b() {}
    
    public void a(@Nullable List<FamilyBean> paramList)
    {
      
      if ((paramList != null) && (paramList.size() != 0))
      {
        if (paramList.size() == 1)
        {
          FamilyDetailFragment.J0(FamilyDetailFragment.this);
        }
        else
        {
          FamilyDetailFragment.this.C0(FamilyListActivity.class);
          FamilyDetailFragment.this.requireActivity().finish();
        }
      }
      else {
        s0.n(FamilyDetailFragment.this.getActivity(), 2131952444);
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
        FamilyDetailFragment.this.getActivity().finish();
      } else {
        s0.n(FamilyDetailFragment.this.getActivity(), 2131953328);
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        FamilyDetailFragment.K0(FamilyDetailFragment.this).s(FamilyDataManager.INSTANCE.getCurFamily());
      } else {
        s0.n(FamilyDetailFragment.this.getActivity(), 2131953328);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */