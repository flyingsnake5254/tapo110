package com.tplink.iot.view.familymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.familymanager.FamilyListAdapter;
import com.tplink.iot.adapter.familymanager.FamilyListAdapter.b;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.familymanager.FamilyViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.List;

public class FamilyListFragment
  extends BaseFragment
  implements FamilyListAdapter.b
{
  @BindView
  RecyclerView mHomeListRecyclerView;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private FamilyListAdapter q;
  private FamilyViewModel x;
  
  private void I0(boolean paramBoolean)
  {
    Intent localIntent = new Intent(getActivity(), FamilyDetailActivity.class);
    localIntent.putExtra("args_key_need_add_home", paramBoolean);
    startActivity(localIntent);
  }
  
  private void J0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbarTitle.setText(2131952829);
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mHomeListRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mHomeListRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new FamilyListAdapter(getActivity());
    this.q = ((FamilyListAdapter)localObject);
    this.mHomeListRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    this.q.o(this);
  }
  
  private void K0()
  {
    new TPMaterialDialogV2.Builder(getActivity()).j(getString(2131952673, new Object[] { Integer.valueOf(8) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void L0()
  {
    this.x.o().observe(this, new a());
  }
  
  public void H(FamilyBean paramFamilyBean)
  {
    FamilyDataManager.INSTANCE.updateCurFamilybean(paramFamilyBean);
    I0(false);
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.x = ((FamilyViewModel)ViewModelProviders.of(this).get(FamilyViewModel.class));
    FamilyDataManager.INSTANCE.clearData();
    L0();
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131623946, paramMenu);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558994, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    J0();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    FamilyDataManager.INSTANCE.clearData();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (2131361869 == paramMenuItem.getItemId()) {
      if (this.q.getItemCount() >= 8) {
        K0();
      } else {
        C0(AddFamilyActivity.class);
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
    if (FamilyDataManager.INSTANCE.getFamilyList().size() == 0) {
      s0.l(getActivity());
    }
    this.x.n();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  class a
    implements Observer<List<FamilyBean>>
  {
    a() {}
    
    public void a(@Nullable List<FamilyBean> paramList)
    {
      
      if (paramList == null) {
        s0.n(FamilyListFragment.this.getActivity(), 2131952444);
      } else {
        FamilyListFragment.H0(FamilyListFragment.this).n(paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */