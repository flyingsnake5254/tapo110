package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityWhiteLampConfigBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.NightVisionModeViewModel;
import kotlin.jvm.internal.j;

public final class WhiteLampConfigActivity
  extends BaseActivity
{
  private NightVisionModeViewModel H3;
  private ActivityWhiteLampConfigBinding I3;
  private final Runnable J3 = new e(this);
  private final int p0 = 20;
  private final int p1 = 10;
  private final int p2;
  private String p3;
  private final int y = 40;
  private final int z = 30;
  
  private final void o1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p3 = ((String)localObject);
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(NightVisionModeViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…odeViewModel::class.java)");
    this.H3 = ((NightVisionModeViewModel)localObject);
  }
  
  private final void p1()
  {
    NightVisionModeViewModel localNightVisionModeViewModel = this.H3;
    if (localNightVisionModeViewModel == null) {
      j.t("viewModel");
    }
    localNightVisionModeViewModel.l().observe(this, new a(this));
    localNightVisionModeViewModel = this.H3;
    if (localNightVisionModeViewModel == null) {
      j.t("viewModel");
    }
    localNightVisionModeViewModel.n().observe(this, new b(this));
    localNightVisionModeViewModel = this.H3;
    if (localNightVisionModeViewModel == null) {
      j.t("viewModel");
    }
    localNightVisionModeViewModel.h().observe(this, new c(this));
  }
  
  private final void q1()
  {
    b1(2131952049);
    ActivityWhiteLampConfigBinding localActivityWhiteLampConfigBinding = this.I3;
    if (localActivityWhiteLampConfigBinding == null) {
      j.t("binding");
    }
    localActivityWhiteLampConfigBinding.c.setOnSeekBarChangeListener(new d(this));
  }
  
  private final void r1(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if ((i >= 0) && (5 >= i)) {
      paramSeekBar.setProgress(this.p2);
    } else if ((5 <= i) && (15 >= i)) {
      paramSeekBar.setProgress(this.p1);
    } else if ((15 <= i) && (25 >= i)) {
      paramSeekBar.setProgress(this.p0);
    } else if ((25 <= i) && (35 >= i)) {
      paramSeekBar.setProgress(this.z);
    } else {
      paramSeekBar.setProgress(this.y);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558711);
    j.d(paramBundle, "DataBindingUtil.setConte…tivity_white_lamp_config)");
    this.I3 = ((ActivityWhiteLampConfigBinding)paramBundle);
    o1();
    q1();
    p1();
    paramBundle = this.H3;
    if (paramBundle == null) {
      j.t("viewModel");
    }
    paramBundle.k();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.removeCallbacksAndMessages(null);
  }
  
  static final class a<T>
    implements Observer<Integer>
  {
    a(WhiteLampConfigActivity paramWhiteLampConfigActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null)
      {
        int i = paramInteger.intValue();
        int j;
        if (i < 1)
        {
          j = 1;
        }
        else
        {
          j = i;
          if (i > 5) {
            j = 5;
          }
        }
        paramInteger = WhiteLampConfigActivity.e1(this.a).c;
        j.d(paramInteger, "binding.intensityBar");
        paramInteger.setProgress((j - 1) * 10);
      }
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(WhiteLampConfigActivity paramWhiteLampConfigActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        WhiteLampConfigActivity.e1(this.a).z.b();
      } else {
        WhiteLampConfigActivity.e1(this.a).z.a();
      }
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(WhiteLampConfigActivity paramWhiteLampConfigActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        TSnackbar.x(this.a, 2131952741, 0).N();
      }
    }
  }
  
  public static final class d
    implements SeekBar.OnSeekBarChangeListener
  {
    d(WhiteLampConfigActivity paramWhiteLampConfigActivity) {}
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      j.e(paramSeekBar, "seekBar");
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      j.e(paramSeekBar, "seekBar");
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      j.e(paramSeekBar, "seekBar");
      WhiteLampConfigActivity.f1(this.c).removeCallbacks(WhiteLampConfigActivity.l1(this.c));
      WhiteLampConfigActivity.n1(this.c, paramSeekBar);
      WhiteLampConfigActivity.f1(this.c).postDelayed(WhiteLampConfigActivity.l1(this.c), 3L);
    }
  }
  
  static final class e
    implements Runnable
  {
    e(WhiteLampConfigActivity paramWhiteLampConfigActivity) {}
    
    public final void run()
    {
      SeekBar localSeekBar = WhiteLampConfigActivity.e1(this.c).c;
      j.d(localSeekBar, "binding.intensityBar");
      int i = localSeekBar.getProgress();
      int j = WhiteLampConfigActivity.g1(this.c);
      int k = 5;
      if (i == j) {
        k = 1;
      } else if (i == WhiteLampConfigActivity.h1(this.c)) {
        k = 2;
      } else if (i == WhiteLampConfigActivity.i1(this.c)) {
        k = 3;
      } else if (i == WhiteLampConfigActivity.j1(this.c)) {
        k = 4;
      } else {
        WhiteLampConfigActivity.k1(this.c);
      }
      WhiteLampConfigActivity.m1(this.c).r(k);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\WhiteLampConfigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */