package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityMotionDetectionBinding;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.UniversalDialog.c;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class MotionDetectionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private int H3;
  private int I3 = 3;
  private ActivityMotionDetectionBinding J3;
  private HashMap K3;
  private String p0;
  private boolean p1;
  private final ArrayList<ChangeableAreaView> p2 = new ArrayList();
  private int p3;
  private MotionDetectionViewModel z;
  
  private final void n1()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VideoPlayActivity.class);
    String str = this.p0;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    localIntent.putExtra("device_id_md5", str);
    startActivity(localIntent);
  }
  
  private final void o1()
  {
    int i = com.tplink.iot.a.setting_area_container;
    Object localObject = (FrameLayout)e1(i);
    j.d(localObject, "setting_area_container");
    localObject = ((FrameLayout)localObject).getLayoutParams();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    localObject = (LinearLayout.LayoutParams)localObject;
    int j = com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0];
    this.p3 = j;
    j = kotlin.s.a.a(j * 9.0D / 16);
    this.H3 = j;
    ((LinearLayout.LayoutParams)localObject).width = this.p3;
    ((LinearLayout.LayoutParams)localObject).height = j;
    FrameLayout localFrameLayout = (FrameLayout)e1(i);
    j.d(localFrameLayout, "setting_area_container");
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void p1(ChangeableAreaView paramChangeableAreaView, d paramd)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    double d1 = paramd.c();
    double d2 = '✐';
    localLayoutParams.leftMargin = kotlin.s.a.a(d1 * 1.0D / d2 * this.p3);
    localLayoutParams.topMargin = kotlin.s.a.a(paramd.d() * 1.0D / d2 * this.H3);
    localLayoutParams.width = kotlin.s.a.a(paramd.b() * 1.0D / d2 * this.p3);
    localLayoutParams.height = kotlin.s.a.a(paramd.a() * 1.0D / d2 * this.H3);
    paramChangeableAreaView.setLayoutParams(localLayoutParams);
  }
  
  private final void q1(List<? extends d> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.p2.clear();
    int i = paramList.size();
    int j = 0;
    while (j < i)
    {
      ChangeableAreaView localChangeableAreaView = new ChangeableAreaView(this);
      p1(localChangeableAreaView, (d)paramList.get(j));
      localChangeableAreaView.i(false);
      localChangeableAreaView.setCanBeEdit(false);
      this.p2.add(localChangeableAreaView);
      FrameLayout localFrameLayout = (FrameLayout)e1(com.tplink.iot.a.setting_area_container);
      j++;
      localFrameLayout.addView(localChangeableAreaView, j);
    }
  }
  
  private final void r1()
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
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(MotionDetectionViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ionViewModel::class.java)");
    this.z = ((MotionDetectionViewModel)localObject);
    ActivityMotionDetectionBinding localActivityMotionDetectionBinding = this.J3;
    if (localActivityMotionDetectionBinding == null) {
      j.t("binding");
    }
    localObject = this.z;
    if (localObject == null) {
      j.t("viewModel");
    }
    localActivityMotionDetectionBinding.i((MotionDetectionViewModel)localObject);
    localObject = this.J3;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivityMotionDetectionBinding)localObject).h(new b(this));
    localObject = this.z;
    if (localObject == null) {
      j.t("viewModel");
    }
    ((MotionDetectionViewModel)localObject).j(this.I3);
    u1();
  }
  
  private final void s1()
  {
    MotionDetectionViewModel localMotionDetectionViewModel = this.z;
    if (localMotionDetectionViewModel == null) {
      j.t("viewModel");
    }
    localMotionDetectionViewModel.a.observe(this, new c(this));
    localMotionDetectionViewModel = this.z;
    if (localMotionDetectionViewModel == null) {
      j.t("viewModel");
    }
    localMotionDetectionViewModel.d.observe(this, new d(this));
    localMotionDetectionViewModel = this.z;
    if (localMotionDetectionViewModel == null) {
      j.t("viewModel");
    }
    localMotionDetectionViewModel.e.observe(this, new e(this));
    localMotionDetectionViewModel = this.z;
    if (localMotionDetectionViewModel == null) {
      j.t("viewModel");
    }
    localMotionDetectionViewModel.f.observe(this, new f(this));
  }
  
  private final void t1()
  {
    int i = com.tplink.iot.a.mtb;
    setSupportActionBar((Toolbar)e1(i));
    o1();
    ((Toolbar)e1(i)).setNavigationOnClickListener(new g(this));
    ((CheckBox)e1(com.tplink.iot.a.video_motion_switch)).setOnClickListener(new h(this));
    ((LinearLayout)e1(com.tplink.iot.a.ll_region_edit)).setOnClickListener(this);
    ((ImageView)e1(com.tplink.iot.a.setting_cover_iv)).setOnClickListener(this);
    ((TextView)e1(com.tplink.iot.a.sensitivity_low_btn)).setOnClickListener(this);
    ((TextView)e1(com.tplink.iot.a.sensitivity_normal_btn)).setOnClickListener(this);
    ((TextView)e1(com.tplink.iot.a.sensitivity_high_btn)).setOnClickListener(this);
  }
  
  private final void u1()
  {
    String str = this.p0;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    l.e(str, new i(this));
  }
  
  private final void v1()
  {
    Iterator localIterator = this.p2.iterator();
    while (localIterator.hasNext())
    {
      ChangeableAreaView localChangeableAreaView = (ChangeableAreaView)localIterator.next();
      if (localChangeableAreaView != null) {
        ((FrameLayout)e1(com.tplink.iot.a.setting_area_container)).removeView(localChangeableAreaView);
      }
    }
  }
  
  private final void w1()
  {
    new UniversalDialog.a().q(getString(2131953210)).s(getString(2131951763)).u(getString(2131952751)).t(new k(this)).l().show(getSupportFragmentManager(), "SETTING");
  }
  
  private final void x1()
  {
    MotionDetectionViewModel localMotionDetectionViewModel = this.z;
    if (localMotionDetectionViewModel == null) {
      j.t("viewModel");
    }
    localMotionDetectionViewModel.b.observe(this, new l(this));
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
  
  public void onClick(View paramView)
  {
    if ((j.a(paramView, (ImageView)e1(com.tplink.iot.a.setting_cover_iv))) || (j.a(paramView, (LinearLayout)e1(com.tplink.iot.a.ll_region_edit))))
    {
      if (this.p1)
      {
        paramView = this.p0;
        if (paramView == null) {
          j.t("deviceIdMD5");
        }
        MotionRegionSettingActivity.M1(this, paramView, this.I3);
      }
      else
      {
        w1();
      }
    }
    else if (j.a(paramView, (TextView)e1(com.tplink.iot.a.sensitivity_low_btn)))
    {
      paramView = this.z;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.d0(0);
    }
    else if (j.a(paramView, (TextView)e1(com.tplink.iot.a.sensitivity_normal_btn)))
    {
      paramView = this.z;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.d0(30);
    }
    else if (j.a(paramView, (TextView)e1(com.tplink.iot.a.sensitivity_high_btn)))
    {
      paramView = this.z;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.d0(60);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558584);
    j.d(paramBundle, "DataBindingUtil.setConte…ctivity_motion_detection)");
    this.J3 = ((ActivityMotionDetectionBinding)paramBundle);
    t1();
    r1();
    s1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (!this.p1) {
      this.c.postDelayed(new j(this), 1500L);
    }
    MotionDetectionViewModel localMotionDetectionViewModel;
    if (this.I3 == 3)
    {
      localMotionDetectionViewModel = this.z;
      if (localMotionDetectionViewModel == null) {
        j.t("viewModel");
      }
      localMotionDetectionViewModel.R();
    }
    else
    {
      localMotionDetectionViewModel = this.z;
      if (localMotionDetectionViewModel == null) {
        j.t("viewModel");
      }
      localMotionDetectionViewModel.S();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, MotionDetectionActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements SeekBarBindingAdapter.OnStopTrackingTouch
  {
    b(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      MotionDetectionViewModel localMotionDetectionViewModel = MotionDetectionActivity.g1(this.c);
      j.d(paramSeekBar, "seekBar");
      localMotionDetectionViewModel.d0(paramSeekBar.getProgress());
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      Object localObject = (CheckBox)this.a.e1(com.tplink.iot.a.video_motion_switch);
      j.d(localObject, "video_motion_switch");
      j.d(paramBoolean, "it");
      ((CheckBox)localObject).setChecked(paramBoolean.booleanValue());
      localObject = (ConstraintLayout)this.a.e1(com.tplink.iot.a.layout_motion_content);
      j.d(localObject, "layout_motion_content");
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
    d(MotionDetectionActivity paramMotionDetectionActivity) {}
    
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
    e(MotionDetectionActivity paramMotionDetectionActivity) {}
    
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
  
  static final class f<T>
    implements Observer<Boolean>
  {
    f(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        this.a.finish();
      }
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = MotionDetectionActivity.g1(this.c);
      CheckBox localCheckBox = (CheckBox)this.c.e1(com.tplink.iot.a.video_motion_switch);
      j.d(localCheckBox, "video_motion_switch");
      paramView.b0(localCheckBox.isChecked());
    }
  }
  
  static final class i<T>
    implements b<com.tplink.libtpmediaother.database.model.c>
  {
    i(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.c paramc)
    {
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.i())))
      {
        MotionDetectionActivity.l1(this.a, true);
        paramc = paramc.i();
        TextView localTextView = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(localTextView, "no_preview_note");
        localTextView.setVisibility(4);
        com.bumptech.glide.c.u(this.a.getApplication()).s(paramc).x0((ImageView)this.a.e1(com.tplink.iot.a.setting_cover_iv));
        MotionDetectionActivity.m1(this.a);
      }
      else
      {
        MotionDetectionActivity.l1(this.a, false);
        paramc = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(paramc, "no_preview_note");
        paramc.setVisibility(0);
      }
    }
  }
  
  static final class j
    implements Runnable
  {
    j(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void run()
    {
      MotionDetectionActivity.j1(this.c);
    }
  }
  
  static final class k
    implements UniversalDialog.c
  {
    k(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void a()
    {
      MotionDetectionActivity.h1(this.a);
    }
  }
  
  static final class l<T>
    implements Observer<List<? extends d>>
  {
    l(MotionDetectionActivity paramMotionDetectionActivity) {}
    
    public final void a(List<? extends d> paramList)
    {
      if ((paramList != null) && (MotionDetectionActivity.f1(this.a)))
      {
        MotionDetectionActivity.k1(this.a);
        MotionDetectionActivity.i1(this.a, paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\MotionDetectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */