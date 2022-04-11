package com.tplink.iot.view.feedback;

import android.app.Activity;
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
import butterknife.OnClick;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.feedback.SelectFeedbackDeviceAdapter;
import com.tplink.iot.adapter.feedback.SelectFeedbackDeviceAdapter.b;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.feedback.SelectFeedbackDeviceViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectFeedbackDeviceFragment
  extends BaseFragment
  implements SelectFeedbackDeviceAdapter.b
{
  @BindView
  TextView mFeedbackBtn;
  @BindView
  RecyclerView mSelectFeedbackDeviceRV;
  @BindView
  TipsBar mTipsBar;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private SelectFeedbackDeviceAdapter q;
  private SelectFeedbackDeviceViewModel x;
  private String y;
  private String z;
  
  private void L0(List<BaseALIoTDevice> paramList)
  {
    Object localObject = d.c(getActivity(), paramList, this.z);
    Intent localIntent = new Intent(getActivity(), FeedBackWebActivity.class);
    localIntent.putExtra("feed_back_faq_params", (String)localObject);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ArrayList)localObject).add(((BaseALIoTDevice)paramList.next()).getDeviceId());
      }
      localIntent.putStringArrayListExtra("feed_back_faq_devices", (ArrayList)localObject);
    }
    startActivity(localIntent);
    getActivity().finish();
  }
  
  private void N0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbarTitle.setText(2131952678);
    this.mFeedbackBtn.setEnabled(false);
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mSelectFeedbackDeviceRV.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mSelectFeedbackDeviceRV.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new SelectFeedbackDeviceAdapter(getActivity());
    this.q = ((SelectFeedbackDeviceAdapter)localObject);
    this.mSelectFeedbackDeviceRV.setAdapter((RecyclerView.Adapter)localObject);
    this.q.q(this);
  }
  
  private void O0()
  {
    this.x.j().observe(getViewLifecycleOwner(), new a());
  }
  
  @OnClick
  void feedback()
  {
    if ((this.q.o() != null) && (this.q.o().size() > 0)) {
      L0(this.q.o());
    }
  }
  
  public void k()
  {
    if ((this.q.o() != null) && (this.q.o().size() > 0)) {
      this.mFeedbackBtn.setEnabled(true);
    } else {
      this.mFeedbackBtn.setEnabled(false);
    }
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getArguments() != null)
    {
      this.y = getArguments().getString("help_feed_back_feedback_category");
      this.z = getArguments().getString("help_feed_back_total_product_type");
    }
    this.x = ((SelectFeedbackDeviceViewModel)ViewModelProviders.of(this).get(SelectFeedbackDeviceViewModel.class));
    O0();
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131623954, paramMenu);
    paramMenu.findItem(2131361892).setTitle(2131952460);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559350, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    N0();
    return paramLayoutInflater;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (2131361892 == paramMenuItem.getItemId()) {
      L0(null);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void v0(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mTipsBar.m(getString(2131952682), 3000L);
    }
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = SelectFeedbackDeviceFragment.I0(SelectFeedbackDeviceFragment.this).i(paramList, SelectFeedbackDeviceFragment.H0(SelectFeedbackDeviceFragment.this));
        if ((paramList != null) && (paramList.size() > 0)) {
          SelectFeedbackDeviceFragment.J0(SelectFeedbackDeviceFragment.this).p(paramList);
        } else {
          SelectFeedbackDeviceFragment.K0(SelectFeedbackDeviceFragment.this, null);
        }
      }
      else
      {
        SelectFeedbackDeviceFragment.K0(SelectFeedbackDeviceFragment.this, null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\SelectFeedbackDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */