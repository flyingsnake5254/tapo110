package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.o;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.ActivityPlaybackNewIpcBinding;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.Objects;

public class PlayBackMainFragment
  extends BaseFragment
{
  private boolean p0 = false;
  private PlayBackFragment q;
  private PlayBackControlFragment x;
  private ActivityPlaybackNewIpcBinding y;
  private PlaybackMainViewModel z;
  
  private void J0()
  {
    if (this.x == null) {
      this.x = new PlayBackControlFragment();
    }
    Object localObject = getActivity();
    Objects.requireNonNull(localObject);
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction();
    if (!this.x.isAdded())
    {
      PlayBackControlFragment localPlayBackControlFragment = this.x;
      ((FragmentTransaction)localObject).add(2131362333, localPlayBackControlFragment, localPlayBackControlFragment.getClass().getName());
    }
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void K0()
  {
    if (this.q == null) {
      this.q = new PlayBackFragment();
    }
    Object localObject = getActivity();
    Objects.requireNonNull(localObject);
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction();
    if (!this.q.isAdded())
    {
      PlayBackFragment localPlayBackFragment = this.q;
      ((FragmentTransaction)localObject).add(2131364767, localPlayBackFragment, localPlayBackFragment.getClass().getName());
    }
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void Z0(String paramString)
  {
    if (getActivity() == null) {
      return;
    }
    if (this.p0) {
      return;
    }
    this.p0 = true;
    RelayLimitDialogFragment localRelayLimitDialogFragment = new RelayLimitDialogFragment();
    localRelayLimitDialogFragment.J0(paramString);
    localRelayLimitDialogFragment.L0(new b());
    localRelayLimitDialogFragment.K0(new o1(this));
    paramString = getActivity();
    Objects.requireNonNull(paramString);
    localRelayLimitDialogFragment.show(((FragmentActivity)paramString).getSupportFragmentManager(), "main.RelayLimitDialogFragment");
  }
  
  private void a1()
  {
    this.z.l().observe(this, new m1(this));
    this.z.x.observe(this, new a());
    j.d(this.z.j, this, new k1(this), new n1(this));
  }
  
  public boolean L0()
  {
    PlayBackFragment localPlayBackFragment = this.q;
    boolean bool;
    if ((localPlayBackFragment != null) && (localPlayBackFragment.J0())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void X0()
  {
    PlayBackFragment localPlayBackFragment = this.q;
    if (localPlayBackFragment != null) {
      localPlayBackFragment.W0();
    }
  }
  
  public void Y0()
  {
    PlayBackFragment localPlayBackFragment = this.q;
    if (localPlayBackFragment != null) {
      localPlayBackFragment.Y0();
    }
  }
  
  public void b1()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.z.r.get())
    {
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      ((FragmentActivity)localObject1).getWindow().getDecorView().setSystemUiVisibility(4102);
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      ((FragmentActivity)localObject1).getWindow().setFlags(1024, 1024);
      localObject2 = (RelativeLayout.LayoutParams)this.y.q.getLayoutParams();
      localObject3 = new DisplayMetrics();
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      ((FragmentActivity)localObject1).getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject3);
      ((RelativeLayout.LayoutParams)localObject2).width = ((DisplayMetrics)localObject3).widthPixels;
      ((RelativeLayout.LayoutParams)localObject2).height = ((DisplayMetrics)localObject3).heightPixels;
      this.y.c.setVisibility(8);
    }
    else
    {
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      ((FragmentActivity)localObject1).getWindow().getDecorView().setSystemUiVisibility(0);
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      localObject1 = ((FragmentActivity)localObject1).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).flags &= 0xFBFF;
      localObject2 = getActivity();
      Objects.requireNonNull(localObject2);
      ((FragmentActivity)localObject2).getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      localObject1 = getActivity();
      Objects.requireNonNull(localObject1);
      ((FragmentActivity)localObject1).getWindow().clearFlags(512);
      StatusBarUtils.l(getActivity(), true);
      localObject2 = (RelativeLayout.LayoutParams)this.y.q.getLayoutParams();
      localObject1 = new DisplayMetrics();
      localObject3 = getActivity();
      Objects.requireNonNull(localObject3);
      ((FragmentActivity)localObject3).getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
      ((RelativeLayout.LayoutParams)localObject2).width = ((DisplayMetrics)localObject1).widthPixels;
      localObject3 = getContext();
      Objects.requireNonNull(localObject3);
      int i = o.a((Context)localObject3, 271.0F);
      int j = (int)(((DisplayMetrics)localObject1).widthPixels / 1.7777778F) + o.a(getContext(), 75.0F);
      if (i >= j) {
        j = i;
      }
      ((RelativeLayout.LayoutParams)localObject2).height = j;
      this.y.c.setVisibility(0);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.y = ((ActivityPlaybackNewIpcBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558598, paramViewGroup, false));
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    ((FragmentActivity)paramLayoutInflater).getWindow().addFlags(128);
    paramLayoutInflater = getActivity().getIntent().getStringExtra("device_id_md5");
    paramViewGroup = (PlaybackMainViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), paramLayoutInflater)).get(PlaybackMainViewModel.class);
    this.z = paramViewGroup;
    paramViewGroup.B(VideoDisplayMode.PLAY_BACK);
    if (this.z.r.get()) {
      this.z.x(true);
    }
    K0();
    J0();
    a1();
    b1();
    this.y.f.setCloseBtnImageResId(2131689491);
    this.y.f.setCloseBtnClickListener(new l1(this, paramLayoutInflater));
    return this.y.getRoot();
  }
  
  public void onStart()
  {
    super.onStart();
    this.z.h();
  }
  
  public void onStop()
  {
    super.onStop();
    this.y.f.b();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    PlayBackFragment localPlayBackFragment = this.q;
    if (localPlayBackFragment != null) {
      localPlayBackFragment.setUserVisibleHint(paramBoolean);
    }
  }
  
  class a
    implements Observer<a<String>>
  {
    a() {}
    
    public void a(@Nullable a<String> parama)
    {
      parama = (String)parama.a();
      if (parama != null) {
        PlayBackMainFragment.H0(PlayBackMainFragment.this, parama);
      }
    }
  }
  
  class b
    implements RelayLimitDialogFragment.a
  {
    b() {}
    
    public void a()
    {
      PlayBackMainFragment.this.B0();
    }
    
    public void b()
    {
      PlayBackMainFragment.I0(PlayBackMainFragment.this).y.postValue(new a(Boolean.TRUE));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\PlayBackMainFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */