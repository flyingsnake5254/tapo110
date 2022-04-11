package com.tplink.iot.view.feedback;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.c;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.x0.b;
import com.tplink.iot.adapter.feedback.DeviceTypeListAdapter;
import com.tplink.iot.adapter.feedback.DeviceTypeListAdapter.c;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.model.about.c;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.about.AboutWebActivity;
import io.reactivex.a;

public class DeviceTypeListFragment
  extends BaseFragment
  implements DeviceTypeListAdapter.c
{
  @BindView
  RecyclerView mDeviceTypeListRecyclerView;
  @BindView
  Toolbar mToolbar;
  @BindView
  TextView mToolbarTitle;
  private DeviceTypeListAdapter q;
  
  private void I0()
  {
    Intent localIntent = new Intent(getActivity(), AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131952069));
    localIntent.putExtra("url", d.g());
    startActivity(localIntent);
    getActivity().overridePendingTransition(2130772068, 2130772067);
  }
  
  private void J0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbarTitle.setText(2131952600);
    Object localObject = new HomeSpaceItemDecoration(getActivity());
    this.mDeviceTypeListRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mDeviceTypeListRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DeviceTypeListAdapter(getActivity());
    this.q = ((DeviceTypeListAdapter)localObject);
    ((DeviceTypeListAdapter)localObject).o();
    this.mDeviceTypeListRecyclerView.setAdapter(this.q);
    this.q.p(this);
  }
  
  private void K0()
  {
    new TPMaterialDialogV2.Builder(getActivity()).d(2131559096).f(new a()).y();
  }
  
  public void O(String paramString1, String paramString2, EnumFeedbackCategory paramEnumFeedbackCategory)
  {
    HelpAndFeedbackActivity.m1(requireContext(), paramString1, paramString2, paramEnumFeedbackCategory);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558771, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    J0();
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!c.g())
    {
      c.k(true);
      if (!c.f()) {
        K0();
      }
    }
  }
  
  class a
    implements TPMaterialDialogV2.c
  {
    a() {}
    
    public void a(final TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131364343);
      localTextView.setText(2131952889);
      DeviceTypeListFragment localDeviceTypeListFragment = DeviceTypeListFragment.this;
      d0.e(localTextView, localDeviceTypeListFragment.getString(2131952889, new Object[] { localDeviceTypeListFragment.getResources().getString(2131952069) }), DeviceTypeListFragment.this.getString(2131952069), DeviceTypeListFragment.this.getResources().getColor(2131099808), new a());
      ((TextView)paramView.getRootView().findViewById(2131364325)).setOnClickListener(new b(paramTPMaterialDialogV2));
      ((TextView)paramView.findViewById(2131364552)).setOnClickListener(new c(paramTPMaterialDialogV2));
    }
    
    class a
      implements d0.g
    {
      a() {}
      
      public void a()
      {
        DeviceTypeListFragment.H0(DeviceTypeListFragment.this);
      }
    }
    
    class b
      implements View.OnClickListener
    {
      b(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        c.j(true);
        c.d();
        b.c(true);
        c.n(true).y();
        paramView = paramTPMaterialDialogV2;
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
    
    class c
      implements View.OnClickListener
    {
      c(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        b.c(false);
        paramView = paramTPMaterialDialogV2;
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\DeviceTypeListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */