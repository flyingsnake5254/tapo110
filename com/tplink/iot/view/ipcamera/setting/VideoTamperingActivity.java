package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.VideoTamperingViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class VideoTamperingActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private final long H3 = 300L;
  private int I3 = 3;
  private final Runnable J3 = new l(this);
  private HashMap K3;
  private String p0;
  private final int p1 = 100;
  private final int p2 = 50;
  private final int p3;
  private VideoTamperingViewModel z;
  
  private final void n1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p0 = ((String)localObject);
    this.I3 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.p0;
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(VideoTamperingViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ingViewModel::class.java)");
    localObject = (VideoTamperingViewModel)localObject;
    this.z = ((VideoTamperingViewModel)localObject);
    if (localObject == null) {
      j.t("viewModel");
    }
    ((VideoTamperingViewModel)localObject).j(this.I3);
  }
  
  private final void o1()
  {
    VideoTamperingViewModel localVideoTamperingViewModel = this.z;
    if (localVideoTamperingViewModel == null) {
      j.t("viewModel");
    }
    localVideoTamperingViewModel.h().observe(this, new b(this));
    localVideoTamperingViewModel = this.z;
    if (localVideoTamperingViewModel == null) {
      j.t("viewModel");
    }
    localVideoTamperingViewModel.i().observe(this, new c(this));
    localVideoTamperingViewModel = this.z;
    if (localVideoTamperingViewModel == null) {
      j.t("viewModel");
    }
    localVideoTamperingViewModel.g().observe(this, new d(this));
    localVideoTamperingViewModel = this.z;
    if (localVideoTamperingViewModel == null) {
      j.t("viewModel");
    }
    localVideoTamperingViewModel.f().observe(this, new e(this));
  }
  
  private final void p1()
  {
    setContentView(2131558708);
    int i = a.mtb;
    setSupportActionBar((Toolbar)e1(i));
    ((Toolbar)e1(i)).setNavigationOnClickListener(new f(this));
    ((CheckBox)e1(a.video_tampering_switch)).setOnClickListener(new g(this));
    ((TextView)e1(a.sensitivity_low_btn)).setOnClickListener(new h(this));
    ((TextView)e1(a.sensitivity_normal_btn)).setOnClickListener(new i(this));
    ((TextView)e1(a.sensitivity_high_btn)).setOnClickListener(new j(this));
    ((SeekBar)e1(a.sensitivity_bar)).setOnSeekBarChangeListener(new k(this));
  }
  
  private final void q1(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if ((i >= 0) && (25 >= i))
    {
      paramSeekBar.setProgress(this.p3);
      ((TextView)e1(a.sensitivity_low_btn)).setTextColor(ContextCompat.getColor(this, 2131099799));
      ((TextView)e1(a.sensitivity_normal_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
      ((TextView)e1(a.sensitivity_high_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
    }
    else if ((25 <= i) && (75 >= i))
    {
      paramSeekBar.setProgress(this.p2);
      ((TextView)e1(a.sensitivity_low_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
      ((TextView)e1(a.sensitivity_normal_btn)).setTextColor(ContextCompat.getColor(this, 2131099799));
      ((TextView)e1(a.sensitivity_high_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
    }
    else
    {
      paramSeekBar.setProgress(this.p1);
      ((TextView)e1(a.sensitivity_low_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
      ((TextView)e1(a.sensitivity_normal_btn)).setTextColor(ContextCompat.getColor(this, 2131100201));
      ((TextView)e1(a.sensitivity_high_btn)).setTextColor(ContextCompat.getColor(this, 2131099799));
    }
  }
  
  public View e1(int paramInt)
  {
    if (this.K3 == null) {
      this.K3 = new HashMap();
    }
    View localView1 = (View)this.K3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.K3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    p1();
    n1();
    o1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    VideoTamperingViewModel localVideoTamperingViewModel;
    if (this.I3 == 3)
    {
      localVideoTamperingViewModel = this.z;
      if (localVideoTamperingViewModel == null) {
        j.t("viewModel");
      }
      localVideoTamperingViewModel.F();
    }
    else
    {
      localVideoTamperingViewModel = this.z;
      if (localVideoTamperingViewModel == null) {
        j.t("viewModel");
      }
      localVideoTamperingViewModel.G();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, VideoTamperingActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<String>
  {
    b(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void a(String paramString)
    {
      if (paramString != null)
      {
        i = paramString.hashCode();
        if (i != -1078030475)
        {
          if ((i == 3202466) && (paramString.equals("high")))
          {
            paramString = this.a;
            i = a.sensitivity_bar;
            paramString = (SeekBar)paramString.e1(i);
            j.d(paramString, "sensitivity_bar");
            paramString.setProgress(VideoTamperingActivity.h1(this.a));
            localObject = (TextView)this.a.e1(a.tv_sensitivity_title);
            j.d(localObject, "tv_sensitivity_title");
            paramString = this.a;
            ((TextView)localObject).setText(paramString.getString(2131953865, new Object[] { paramString.getString(2131953102) }));
            localObject = this.a;
            paramString = (SeekBar)((VideoTamperingActivity)localObject).e1(i);
            j.d(paramString, "sensitivity_bar");
            VideoTamperingActivity.m1((VideoTamperingActivity)localObject, paramString);
            return;
          }
        }
        else if (paramString.equals("medium"))
        {
          paramString = this.a;
          i = a.sensitivity_bar;
          paramString = (SeekBar)paramString.e1(i);
          j.d(paramString, "sensitivity_bar");
          paramString.setProgress(VideoTamperingActivity.j1(this.a));
          localObject = (TextView)this.a.e1(a.tv_sensitivity_title);
          j.d(localObject, "tv_sensitivity_title");
          paramString = this.a;
          ((TextView)localObject).setText(paramString.getString(2131953865, new Object[] { paramString.getString(2131953104) }));
          paramString = this.a;
          localObject = (SeekBar)paramString.e1(i);
          j.d(localObject, "sensitivity_bar");
          VideoTamperingActivity.m1(paramString, (SeekBar)localObject);
          return;
        }
      }
      paramString = this.a;
      int i = a.sensitivity_bar;
      paramString = (SeekBar)paramString.e1(i);
      j.d(paramString, "sensitivity_bar");
      paramString.setProgress(VideoTamperingActivity.i1(this.a));
      Object localObject = (TextView)this.a.e1(a.tv_sensitivity_title);
      j.d(localObject, "tv_sensitivity_title");
      paramString = this.a;
      ((TextView)localObject).setText(paramString.getString(2131953865, new Object[] { paramString.getString(2131953103) }));
      paramString = this.a;
      localObject = (SeekBar)paramString.e1(i);
      j.d(localObject, "sensitivity_bar");
      VideoTamperingActivity.m1(paramString, (SeekBar)localObject);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      Object localObject = (CheckBox)this.a.e1(a.video_tampering_switch);
      j.d(localObject, "video_tampering_switch");
      j.d(paramBoolean, "it");
      ((CheckBox)localObject).setChecked(paramBoolean.booleanValue());
      localObject = (ConstraintLayout)this.a.e1(a.layout_sensitivity);
      j.d(localObject, "layout_sensitivity");
      int i;
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 8;
      }
      ((ViewGroup)localObject).setVisibility(i);
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        s0.l(this.a);
      } else {
        s0.g();
      }
    }
  }
  
  static final class e<T>
    implements Observer<Boolean>
  {
    e(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        TSnackbar.y(paramBoolean, paramBoolean.getString(2131952741), 3000).N();
      }
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.onBackPressed();
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void onClick(View paramView)
    {
      VideoTamperingViewModel localVideoTamperingViewModel = VideoTamperingActivity.l1(this.c);
      paramView = (CheckBox)this.c.e1(a.video_tampering_switch);
      j.d(paramView, "video_tampering_switch");
      localVideoTamperingViewModel.L(paramView.isChecked());
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      int i = a.sensitivity_bar;
      paramView = (SeekBar)paramView.e1(i);
      j.d(paramView, "sensitivity_bar");
      paramView.setProgress(VideoTamperingActivity.i1(this.c));
      paramView = this.c;
      SeekBar localSeekBar = (SeekBar)paramView.e1(i);
      j.d(localSeekBar, "sensitivity_bar");
      VideoTamperingActivity.m1(paramView, localSeekBar);
      VideoTamperingActivity.g1(this.c).postDelayed(VideoTamperingActivity.k1(this.c), VideoTamperingActivity.f1(this.c));
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      int i = a.sensitivity_bar;
      paramView = (SeekBar)paramView.e1(i);
      j.d(paramView, "sensitivity_bar");
      paramView.setProgress(VideoTamperingActivity.j1(this.c));
      VideoTamperingActivity localVideoTamperingActivity = this.c;
      paramView = (SeekBar)localVideoTamperingActivity.e1(i);
      j.d(paramView, "sensitivity_bar");
      VideoTamperingActivity.m1(localVideoTamperingActivity, paramView);
      VideoTamperingActivity.g1(this.c).postDelayed(VideoTamperingActivity.k1(this.c), VideoTamperingActivity.f1(this.c));
    }
  }
  
  static final class j
    implements View.OnClickListener
  {
    j(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      int i = a.sensitivity_bar;
      paramView = (SeekBar)paramView.e1(i);
      j.d(paramView, "sensitivity_bar");
      paramView.setProgress(VideoTamperingActivity.h1(this.c));
      paramView = this.c;
      SeekBar localSeekBar = (SeekBar)paramView.e1(i);
      j.d(localSeekBar, "sensitivity_bar");
      VideoTamperingActivity.m1(paramView, localSeekBar);
      VideoTamperingActivity.g1(this.c).postDelayed(VideoTamperingActivity.k1(this.c), VideoTamperingActivity.f1(this.c));
    }
  }
  
  public static final class k
    implements SeekBar.OnSeekBarChangeListener
  {
    k(VideoTamperingActivity paramVideoTamperingActivity) {}
    
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
      VideoTamperingActivity.g1(this.c).removeCallbacks(VideoTamperingActivity.k1(this.c));
      VideoTamperingActivity.m1(this.c, paramSeekBar);
      VideoTamperingActivity.g1(this.c).postDelayed(VideoTamperingActivity.k1(this.c), VideoTamperingActivity.f1(this.c));
    }
  }
  
  static final class l
    implements Runnable
  {
    l(VideoTamperingActivity paramVideoTamperingActivity) {}
    
    public final void run()
    {
      Object localObject = (SeekBar)this.c.e1(a.sensitivity_bar);
      j.d(localObject, "sensitivity_bar");
      int i = ((SeekBar)localObject).getProgress();
      if (i == VideoTamperingActivity.i1(this.c)) {
        localObject = "low";
      } else if (i == VideoTamperingActivity.j1(this.c)) {
        localObject = "medium";
      } else {
        localObject = "high";
      }
      VideoTamperingActivity.l1(this.c).N((String)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\VideoTamperingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */