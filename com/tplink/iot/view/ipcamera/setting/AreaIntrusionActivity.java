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
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.UniversalDialog.c;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.business.model.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class AreaIntrusionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private int H3;
  private int I3 = 3;
  private HashMap J3;
  private String p0;
  private boolean p1;
  private final ArrayList<ChangeableAreaView> p2 = new ArrayList();
  private int p3;
  private AreaIntrusionViewModel z;
  
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
  
  private final void p1(ChangeableAreaView paramChangeableAreaView, c.a parama)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    double d1 = parama.c();
    double d2 = '✐';
    localLayoutParams.leftMargin = kotlin.s.a.a(d1 * 1.0D / d2 * this.p3);
    localLayoutParams.topMargin = kotlin.s.a.a(parama.d() * 1.0D / d2 * this.H3);
    localLayoutParams.width = kotlin.s.a.a(parama.b() * 1.0D / d2 * this.p3);
    localLayoutParams.height = kotlin.s.a.a(parama.a() * 1.0D / d2 * this.H3);
    paramChangeableAreaView.setLayoutParams(localLayoutParams);
  }
  
  private final void q1(List<? extends c.a> paramList)
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
      p1(localChangeableAreaView, (c.a)paramList.get(j));
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
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AreaIntrusionViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ionViewModel::class.java)");
    localObject = (AreaIntrusionViewModel)localObject;
    this.z = ((AreaIntrusionViewModel)localObject);
    if (localObject == null) {
      j.t("viewModel");
    }
    ((AreaIntrusionViewModel)localObject).o(this.I3);
    u1();
  }
  
  private final void s1()
  {
    AreaIntrusionViewModel localAreaIntrusionViewModel = this.z;
    if (localAreaIntrusionViewModel == null) {
      j.t("viewModel");
    }
    localAreaIntrusionViewModel.l().observe(this, new b(this));
    localAreaIntrusionViewModel = this.z;
    if (localAreaIntrusionViewModel == null) {
      j.t("viewModel");
    }
    localAreaIntrusionViewModel.m().observe(this, new c(this));
    localAreaIntrusionViewModel = this.z;
    if (localAreaIntrusionViewModel == null) {
      j.t("viewModel");
    }
    localAreaIntrusionViewModel.j().observe(this, new d(this));
  }
  
  private final void t1()
  {
    setContentView(2131558445);
    int i = com.tplink.iot.a.mtb;
    setSupportActionBar((Toolbar)e1(i));
    o1();
    ((Toolbar)e1(i)).setNavigationOnClickListener(new e(this));
    ((CheckBox)e1(com.tplink.iot.a.video_intrusion_switch)).setOnClickListener(new f(this));
    ((LinearLayout)e1(com.tplink.iot.a.ll_region_edit)).setOnClickListener(this);
    ((ImageView)e1(com.tplink.iot.a.setting_cover_iv)).setOnClickListener(this);
    ((LinearLayout)e1(com.tplink.iot.a.ll_schedule)).setOnClickListener(this);
  }
  
  private final void u1()
  {
    String str = this.p0;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    l.e(str, new g(this));
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
    new UniversalDialog.a().q(getString(2131953210)).s(getString(2131951763)).u(getString(2131952751)).t(new i(this)).l().show(getSupportFragmentManager(), "SETTING");
  }
  
  private final void x1()
  {
    AreaIntrusionViewModel localAreaIntrusionViewModel = this.z;
    if (localAreaIntrusionViewModel == null) {
      j.t("viewModel");
    }
    localAreaIntrusionViewModel.n().observe(this, new j(this));
  }
  
  public View e1(int paramInt)
  {
    if (this.J3 == null) {
      this.J3 = new HashMap();
    }
    View localView1 = (View)this.J3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.J3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    if ((j.a(paramView, (ImageView)e1(com.tplink.iot.a.setting_cover_iv))) || (j.a(paramView, (LinearLayout)e1(com.tplink.iot.a.ll_region_edit))))
    {
      if (this.p1)
      {
        paramView = this.p0;
        if (paramView == null) {
          j.t("deviceIdMD5");
        }
        AreaIntrusionRegionSettingActivity.M1(this, paramView, this.I3);
      }
      else
      {
        w1();
      }
    }
    else if (j.a(paramView, (LinearLayout)e1(com.tplink.iot.a.ll_schedule)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("deviceIdMD5");
      }
      IntrusionScheduleSettingActivity.Y0(this, paramView, this.I3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    t1();
    r1();
    s1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (!this.p1) {
      this.c.postDelayed(new h(this), 1500L);
    }
    AreaIntrusionViewModel localAreaIntrusionViewModel;
    if (this.I3 == 3)
    {
      localAreaIntrusionViewModel = this.z;
      if (localAreaIntrusionViewModel == null) {
        j.t("viewModel");
      }
      localAreaIntrusionViewModel.V();
    }
    else
    {
      localAreaIntrusionViewModel = this.z;
      if (localAreaIntrusionViewModel == null) {
        j.t("viewModel");
      }
      localAreaIntrusionViewModel.W();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, AreaIntrusionActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      Object localObject = (CheckBox)this.a.e1(com.tplink.iot.a.video_intrusion_switch);
      j.d(localObject, "video_intrusion_switch");
      j.d(paramBoolean, "it");
      ((CheckBox)localObject).setChecked(paramBoolean.booleanValue());
      localObject = (ConstraintLayout)this.a.e1(com.tplink.iot.a.layout_area_intrusion);
      j.d(localObject, "layout_area_intrusion");
      int i;
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 8;
      }
      ((ViewGroup)localObject).setVisibility(i);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
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
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
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
  
  static final class e
    implements View.OnClickListener
  {
    e(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void onClick(View paramView)
    {
      AreaIntrusionViewModel localAreaIntrusionViewModel = AreaIntrusionActivity.g1(this.c);
      paramView = (CheckBox)this.c.e1(com.tplink.iot.a.video_intrusion_switch);
      j.d(paramView, "video_intrusion_switch");
      localAreaIntrusionViewModel.a0(paramView.isChecked());
    }
  }
  
  static final class g<T>
    implements b<com.tplink.libtpmediaother.database.model.c>
  {
    g(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.c paramc)
    {
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.i())))
      {
        AreaIntrusionActivity.l1(this.a, true);
        String str = paramc.i();
        paramc = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(paramc, "no_preview_note");
        paramc.setVisibility(4);
        com.bumptech.glide.c.u(this.a.getApplication()).s(str).x0((ImageView)this.a.e1(com.tplink.iot.a.setting_cover_iv));
        AreaIntrusionActivity.m1(this.a);
      }
      else
      {
        AreaIntrusionActivity.l1(this.a, false);
        paramc = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(paramc, "no_preview_note");
        paramc.setVisibility(0);
      }
    }
  }
  
  static final class h
    implements Runnable
  {
    h(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void run()
    {
      AreaIntrusionActivity.j1(this.c);
    }
  }
  
  static final class i
    implements UniversalDialog.c
  {
    i(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void a()
    {
      AreaIntrusionActivity.h1(this.a);
    }
  }
  
  static final class j<T>
    implements Observer<List<? extends c.a>>
  {
    j(AreaIntrusionActivity paramAreaIntrusionActivity) {}
    
    public final void a(List<? extends c.a> paramList)
    {
      if ((paramList != null) && (AreaIntrusionActivity.f1(this.a)))
      {
        AreaIntrusionActivity.k1(this.a);
        AreaIntrusionActivity.i1(this.a, paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AreaIntrusionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */