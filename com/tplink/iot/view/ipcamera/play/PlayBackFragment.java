package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.m;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentPlayBackVideoBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout.a;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.util.Calendar;
import java.util.Objects;

public class PlayBackFragment
  extends BaseFragment
  implements g, com.tplink.iot.view.ipcamera.widget.a.a, ScrollPlayRatePicker.a, TimeAxisLayout.b, b, c, TouchListenerRelativeLayout.a
{
  private GLSurfaceViewGPU H3;
  private long p0 = 0L;
  private long p1 = 0L;
  private String p2;
  private l p3;
  private FragmentPlayBackVideoBinding q;
  private PlaybackMainViewModel x;
  private VodViewModel y;
  private PlayBackControlViewModel z;
  
  private void H0(View paramView)
  {
    if ((!this.x.q.get()) && (!this.x.l.get())) {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364273: 
        if ((this.y.R3.get()) || (this.y.N3.get())) {
          this.y.z();
        }
        break;
      case 2131364272: 
        this.x.E();
        break;
      case 2131364269: 
        boolean bool = this.y.R3.get() ^ true;
        this.y.R3.set(bool);
        if (bool)
        {
          if (VodMediaAPI.isStreamAlive(this.p2)) {
            VodMediaAPI.resumeDisplay(this.p2);
          } else {
            W0();
          }
        }
        else
        {
          VodMediaAPI.pauseDisplay(this.p2);
          VodMediaAPI.disableRelayTimer();
        }
        break;
      case 2131364268: 
        this.y.u();
        break;
      case 2131364262: 
        this.y.S3.set(false);
        paramView = this.x;
        paramView.D(paramView.r.get() ^ true);
        break;
      case 2131363748: 
        paramView = this.y.S3;
        paramView.set(paramView.get() ^ true);
        break;
      case 2131363663: 
        this.x.l.set(true);
        this.x.m.set(false);
        this.z.l0();
      }
    }
  }
  
  private void I0(View paramView)
  {
    if (this.x.l.get()) {
      return;
    }
    int i = paramView.getId();
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    switch (i)
    {
    default: 
      break;
    case 2131364271: 
      paramView = this.x.s;
      paramView.set(true ^ paramView.get());
      break;
    case 2131364270: 
      paramView = this.x.u;
      paramView.set(true ^ paramView.get());
      break;
    case 2131364261: 
      paramView = this.x.t;
      paramView.set(true ^ paramView.get());
      break;
    case 2131362367: 
      this.z.E();
      this.x.u.set(false);
      break;
    case 2131362364: 
      this.z.G();
      break;
    case 2131362363: 
      this.z.I();
      break;
    case 2131362227: 
      this.z.j();
      localObject = this.z;
      paramView = ((PlayBackControlViewModel)localObject).b4;
      if ((!((PlayBackControlViewModel)localObject).a4.get()) || (!this.z.c4.get())) {
        bool2 = false;
      }
      paramView.set(bool2);
      this.x.t.set(false);
      break;
    case 2131362226: 
      this.z.j();
      paramView = this.z;
      localObject = paramView.d4;
      if ((paramView.a4.get()) && (this.z.c4.get())) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      ((ObservableBoolean)localObject).set(bool2);
      this.x.t.set(false);
      break;
    case 2131362001: 
      if (this.x.r.get())
      {
        this.x.D(false);
        this.x.u.set(false);
        this.x.s.set(false);
        this.x.t.set(false);
      }
      break;
    }
  }
  
  private void V0()
  {
    long l = this.p0;
    if (l == 0L) {
      return;
    }
    double d = (this.p1 - l) / 1000.0D;
    int i = LiveMediaAPI.getConnectionType(this.p2);
    e.q(this.p2, d, m.a(i));
    this.p0 = 0L;
  }
  
  private void Z0()
  {
    this.x.y.observe(this, new g1(this));
    this.y.V3.observe(this, new j1(this));
    this.z.u().observe(this, new h1(this));
    this.z.x().observe(this, new i1(this));
    this.z.v().observe(this, new f1(this));
  }
  
  public boolean J0()
  {
    VodViewModel localVodViewModel = this.y;
    if (localVodViewModel == null) {
      return false;
    }
    return localVodViewModel.R3.get();
  }
  
  public void L() {}
  
  public void M0(d paramd)
  {
    Object localObject = this.z.C();
    localObject = new d(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
    if (paramd.b((d)localObject) > 0)
    {
      if (this.z.T3.get()) {
        this.z.G();
      }
    }
    else if (paramd.b((d)localObject) < 0) {
      this.z.I();
    }
  }
  
  public void T() {}
  
  public void W0()
  {
    if (this.y.R3.get())
    {
      l locall = this.p3;
      if ((locall != null) && (locall.b > 0) && (locall.a > 0L))
      {
        b.d.w.c.a.c("PlayBackFragment", "start play");
        this.p0 = System.currentTimeMillis();
        this.z.l0();
        this.x.n();
      }
    }
  }
  
  public void X(MotionEvent paramMotionEvent)
  {
    b.d.w.c.a.c("PlayBackFragment", "onActionUp");
    if (this.x.r.get())
    {
      float f1;
      FragmentActivity localFragmentActivity;
      if ((!this.x.t.get()) && (!this.x.u.get()) && (!this.x.s.get()))
      {
        f1 = paramMotionEvent.getY();
        if (getActivity() == null) {
          return;
        }
        paramMotionEvent = new DisplayMetrics();
        localFragmentActivity = getActivity();
        Objects.requireNonNull(localFragmentActivity);
        ((FragmentActivity)localFragmentActivity).getWindowManager().getDefaultDisplay().getRealMetrics(paramMotionEvent);
        if (f1 >= paramMotionEvent.heightPixels - paramMotionEvent.density * 50.0F)
        {
          this.x.w();
          this.x.i();
        }
        else if (this.x.v.get())
        {
          this.x.f();
          this.x.v.set(false);
        }
        else
        {
          this.x.w();
          this.x.i();
        }
      }
      else
      {
        this.x.f();
        float f2 = paramMotionEvent.getRawX();
        if (getActivity() == null) {
          return;
        }
        paramMotionEvent = new DisplayMetrics();
        localFragmentActivity = getActivity();
        Objects.requireNonNull(localFragmentActivity);
        ((FragmentActivity)localFragmentActivity).getWindowManager().getDefaultDisplay().getRealMetrics(paramMotionEvent);
        f1 = paramMotionEvent.widthPixels;
        float f3 = paramMotionEvent.density;
        if (this.x.t.get())
        {
          if (f2 < f1 - f3 * 184.0F) {
            this.x.t.set(false);
          }
        }
        else if (this.x.u.get())
        {
          if (f2 < f1 - f3 * 360.0F) {
            this.x.u.set(false);
          }
        }
        else if ((this.x.s.get()) && (f2 < f1 - f3 * 120.0F)) {
          this.x.s.set(false);
        }
      }
    }
  }
  
  public void X0(long paramLong)
  {
    if (this.y.R3.get())
    {
      b.d.w.c.a.c("PlayBackFragment", "start play");
      this.p0 = System.currentTimeMillis();
      this.z.m0(paramLong);
      this.x.n();
    }
  }
  
  public void Y0()
  {
    if (this.y.R3.get())
    {
      b.d.w.c.a.c("PlayBackFragment", "stop play");
      this.p1 = System.currentTimeMillis();
      VodMediaAPI.releaseStream(this.p2);
      VodMediaAPI.clearPlayerCache(this.p2);
      V0();
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    b.d.w.c.a.c("PlayBackFragment", "onActionDown");
  }
  
  public void e(VodPlayRate paramVodPlayRate)
  {
    VodPlayRate localVodPlayRate = (VodPlayRate)this.y.T3.get();
    this.y.T3.set(paramVodPlayRate);
    this.y.U3.set(paramVodPlayRate.getDisplayValue());
    this.y.f();
    if (VodMediaAPI.isStreamAlive(this.p2))
    {
      PlayBackControlViewModel localPlayBackControlViewModel = this.z;
      String str1 = this.p2;
      String str2 = paramVodPlayRate.getValue();
      paramVodPlayRate = this.y;
      localPlayBackControlViewModel.g(str1, str2, paramVodPlayRate.T3, paramVodPlayRate.U3, localVodPlayRate);
    }
    else
    {
      X0(this.z.P3 / 1000L);
    }
    this.y.S3.set(false);
    this.x.s.set(false);
  }
  
  public void g0(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("year ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" month ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" day ");
    localStringBuilder.append(paramInt3);
    b.d.w.c.a.c("PlayBackFragment", localStringBuilder.toString());
    this.z.u0(paramInt1, paramInt2, paramInt3);
    this.z.n0();
    this.x.u.set(false);
  }
  
  public void onClick(View paramView)
  {
    H0(paramView);
    I0(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = ((FragmentPlayBackVideoBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558943, paramViewGroup, false));
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    this.p2 = ((FragmentActivity)paramLayoutInflater).getIntent().getStringExtra("device_id_md5");
    paramLayoutInflater = (PlaybackMainViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(PlaybackMainViewModel.class);
    this.x = paramLayoutInflater;
    paramLayoutInflater.A(false, this.p2);
    this.z = ((PlayBackControlViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(PlayBackControlViewModel.class));
    paramLayoutInflater = (VodViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), this.p2)).get(VodViewModel.class);
    this.y = paramLayoutInflater;
    paramLayoutInflater.w(this.x, this.z);
    this.y.v();
    this.q.o(this);
    this.q.q(this.x);
    this.q.r(this.y);
    this.q.n(this.z);
    this.q.h(this);
    this.q.m(this);
    this.q.i(this);
    this.q.p(this);
    this.q.N3.setListener(this);
    this.q.l(this);
    Z0();
    return this.q.getRoot();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    VodMediaAPI.stopDisplay(this.p2);
    GLSurfaceViewGPU localGLSurfaceViewGPU = this.H3;
    if (localGLSurfaceViewGPU != null) {
      localGLSurfaceViewGPU.a(this.q.q);
    }
  }
  
  public void onSingleTapUp(MotionEvent paramMotionEvent)
  {
    b.d.w.c.a.c("PlayBackFragment", "onSingleTapUp");
  }
  
  public void onStart()
  {
    super.onStart();
    VodMediaAPI.bindRecordingVariable(this.y.N3);
  }
  
  public void onStop()
  {
    super.onStop();
    if (VodMediaAPI.getRecordingObservable() == this.y.N3) {
      VodMediaAPI.bindRecordingVariable(null);
    }
  }
  
  public void x(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("secondsInDay ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" minus ");
    localStringBuilder.append(paramBoolean);
    b.d.w.c.a.c("PlayBackFragment", localStringBuilder.toString());
    this.z.s0(paramInt, paramBoolean);
  }
  
  public void y0(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("byUser secondsInDay ");
      localStringBuilder.append(paramInt);
      b.d.w.c.a.c("PlayBackFragment", localStringBuilder.toString());
      this.z.z0(true);
      this.z.y0(paramInt, paramBoolean2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\PlayBackFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */