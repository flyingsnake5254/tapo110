package com.tplink.iot.view.me;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.n.i.g;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.v0.b.a;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.view.about.AboutActivity;
import com.tplink.iot.view.account.AccountActivity;
import com.tplink.iot.view.cloudvideo.CloudVideoDeviceListActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceActivity;
import com.tplink.iot.view.feedback.DeviceTypeListActivity;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.ipcamera.memories.MemoriesActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreferenceActivity;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.notification.NotificationActivity;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.view.voice.VoiceControlActivity;
import com.tplink.iot.viewmodel.MeViewModel;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.Utils.o;
import java.util.List;

public class MeFragment
  extends BaseFragment
  implements View.OnClickListener, b.a
{
  private TextView H3;
  private View I3;
  private View J3;
  private String K3;
  private View L3;
  private MeViewModel M3;
  private CloudVideoViewModel N3;
  private boolean O3 = false;
  private TextView p0;
  private TextView p1;
  private TextView p2;
  private TextView p3;
  private View q;
  private TPCircleMaskView x;
  private TextView y;
  private TextView z;
  
  private void S0(Activity paramActivity)
  {
    BillingActivity.f1(paramActivity, e.x());
  }
  
  private void T0()
  {
    this.y = ((TextView)this.q.findViewById(2131364438));
    this.x = ((TPCircleMaskView)this.q.findViewById(2131364164));
    this.z = ((TextView)this.q.findViewById(2131364437));
    RelativeLayout localRelativeLayout1 = (RelativeLayout)this.q.findViewById(2131363290);
    TextView localTextView1 = (TextView)this.q.findViewById(2131364427);
    TextView localTextView2 = (TextView)this.q.findViewById(2131364434);
    TextView localTextView3 = (TextView)this.q.findViewById(2131364440);
    this.J3 = this.q.findViewById(2131362910);
    this.p1 = ((TextView)this.q.findViewById(2131364432));
    this.p0 = ((TextView)this.q.findViewById(2131364428));
    this.p3 = ((TextView)this.q.findViewById(2131364431));
    TextView localTextView4 = (TextView)this.q.findViewById(2131364435);
    this.I3 = this.q.findViewById(2131364816);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)this.q.findViewById(2131363885);
    this.L3 = this.q.findViewById(2131363884);
    this.H3 = ((TextView)this.q.findViewById(2131364430));
    this.p2 = ((TextView)this.q.findViewById(2131364714));
    this.q.findViewById(2131363886).setOnClickListener(this);
    localRelativeLayout1.setOnClickListener(this);
    localTextView1.setOnClickListener(this);
    localTextView2.setOnClickListener(this);
    localTextView3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p0.setOnClickListener(this);
    localTextView4.setOnClickListener(this);
    localRelativeLayout2.setOnClickListener(this);
    this.L3.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    X0();
  }
  
  private boolean U0()
  {
    return d.a();
  }
  
  private void X0()
  {
    TextView localTextView = this.p2;
    if (localTextView != null)
    {
      int i;
      if (u0.b()) {
        i = 2131952442;
      } else {
        i = 2131952440;
      }
      localTextView.setText(i);
    }
  }
  
  private void Z0(boolean paramBoolean)
  {
    View localView = this.J3;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void a1(boolean paramBoolean)
  {
    Object localObject = getResources();
    int i;
    if (paramBoolean) {
      i = 2131689650;
    } else {
      i = 2131689649;
    }
    localObject = ((Resources)localObject).getDrawable(i);
    this.p1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, (Drawable)localObject, null, null);
  }
  
  private void b1(boolean paramBoolean)
  {
    View localView = this.I3;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void c1()
  {
    this.M3.l().observe(this, new a());
    this.N3.N().observe(this, new b());
    this.M3.m().observe(this, new c());
    this.M3.k().observe(this, new d());
    this.M3.j().observe(this, new e());
    this.N3.A().observe(this, new b(this));
  }
  
  private void d1()
  {
    boolean bool = U0();
    Object localObject = this.M3;
    if (localObject != null) {
      ((MeViewModel)localObject).o(bool);
    }
    localObject = this.L3;
    if (localObject != null)
    {
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
  }
  
  public void D0()
  {
    this.N3.O();
  }
  
  public void Y0(TCAccountBean paramTCAccountBean)
  {
    if (TextUtils.isEmpty(paramTCAccountBean.getNickName())) {
      this.y.setText(f0.b(paramTCAccountBean.getEmail()));
    } else {
      this.y.setText(paramTCAccountBean.getNickName());
    }
    this.z.setText(paramTCAccountBean.getEmail());
    this.K3 = paramTCAccountBean.getAccountId();
    this.x.g(paramTCAccountBean.getAvatarUrl(), 2131689624);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = new Intent(getActivity(), LoginActivity.class);
      paramIntent.addFlags(67108864);
      TextView localTextView = this.z;
      if ((localTextView != null) && (!TextUtils.isEmpty(localTextView.getText())) && (o.h0().u())) {
        paramIntent.putExtra("SignUpEmail", this.z.getText());
      }
      startActivity(paramIntent);
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    else if (paramInt1 == 1345)
    {
      this.N3.O();
    }
    else if (paramInt1 == 1002)
    {
      X0();
    }
    else
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364440: 
      C0(VoiceControlActivity.class);
      q.u();
      break;
    case 2131364435: 
      startActivityForResult(new Intent(getActivity(), NotificationActivity.class), 1001);
      q.m();
      break;
    case 2131364434: 
      C0(DeviceTypeListActivity.class);
      break;
    case 2131364432: 
      paramView = (Boolean)this.M3.j().getValue();
      if ((paramView != null) && (paramView.booleanValue())) {
        ShareDeviceActivity.B1(getActivity(), true);
      } else {
        C0(ShareDeviceActivity.class);
      }
      break;
    case 2131364431: 
      paramView = new Intent(getActivity(), CloudVideoDeviceListActivity.class);
      getActivity().startActivity(paramView);
      w.e();
      break;
    case 2131364428: 
      startActivity(new Intent(getActivity(), MemoriesActivity.class));
      q.d();
      break;
    case 2131364427: 
      C0(AboutActivity.class);
      q.a();
      break;
    case 2131363886: 
      startActivityForResult(new Intent(getActivity(), VibrateSettingActivity.class), 1002);
      break;
    case 2131363885: 
      if (this.M3.n()) {
        s0.s(getActivity(), 2131952819);
      } else {
        FirmwareSlideActivity.q1(getActivity(), "me");
      }
      break;
    case 2131363884: 
      w.q();
      S0(getActivity());
      break;
    case 2131363290: 
      startActivityForResult(new Intent(getActivity(), AccountActivity.class), 1000);
      break;
    case 2131362910: 
      C0(CameraPreferenceActivity.class);
      q.f();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558936, paramViewGroup, false);
    this.M3 = ((MeViewModel)ViewModelProviders.of(this).get(MeViewModel.class));
    this.N3 = ((CloudVideoViewModel)ViewModelProviders.of(this).get(CloudVideoViewModel.class));
    com.tplink.iot.Utils.v0.b.a().c(this);
    T0();
    c1();
    this.M3.i();
    b.d.n.f.b.l().f("tapo_pageid_me");
    return this.q;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    com.tplink.iot.Utils.v0.b.a().d(this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    d1();
  }
  
  public void onResume()
  {
    super.onResume();
    d1();
  }
  
  class a
    implements Observer<TCAccountBean>
  {
    a() {}
    
    public void c(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean == null) {
        return;
      }
      MeFragment.this.Y0(paramTCAccountBean);
      MeFragment.H0(MeFragment.this).post(new a(this));
    }
  }
  
  class b
    implements Observer<List<OrderInfo>>
  {
    b() {}
    
    public void a(@Nullable List<OrderInfo> paramList)
    {
      if (paramList == null)
      {
        MeFragment.J0(MeFragment.this).setVisibility(8);
        MeFragment.K0(MeFragment.this, false);
      }
      else
      {
        Object localObject = MeFragment.this;
        boolean bool;
        if (paramList.size() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        MeFragment.K0((MeFragment)localObject, bool);
        localObject = MeFragment.N0(MeFragment.this).Q(paramList, MeFragment.L0(MeFragment.this));
        if (localObject != null)
        {
          MeFragment.J0(MeFragment.this).setVisibility(0);
          MeFragment.J0(MeFragment.this).setText(MeFragment.this.getString(2131952340, new Object[] { o0.r(((OrderInfo)localObject).getEndTime()) }));
        }
        else if (!MeFragment.N0(MeFragment.this).H(paramList, MeFragment.L0(MeFragment.this)))
        {
          MeFragment.J0(MeFragment.this).setVisibility(0);
          MeFragment.J0(MeFragment.this).setText(MeFragment.this.getString(2131954269));
        }
        else
        {
          MeFragment.J0(MeFragment.this).setVisibility(8);
        }
      }
      MeFragment.O0(MeFragment.this);
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean != null) {
        MeFragment.P0(MeFragment.this, paramBoolean.booleanValue());
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean != null) {
        MeFragment.Q0(MeFragment.this, paramBoolean.booleanValue());
      }
    }
  }
  
  class e
    implements Observer<Boolean>
  {
    e() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      MeFragment localMeFragment = MeFragment.this;
      boolean bool;
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      MeFragment.R0(localMeFragment, bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\me\MeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */