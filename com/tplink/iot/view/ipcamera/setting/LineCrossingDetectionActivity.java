package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;
import com.tplink.iot.widget.FlexibleLine;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.UniversalDialog.c;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class LineCrossingDetectionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private int H3;
  private int I3 = 3;
  private HashMap J3;
  private String p0;
  private boolean p1;
  private final ArrayList<FlexibleLine> p2 = new ArrayList();
  private int p3;
  private LineCrossingViewModel z;
  
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
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localObject;
    int j = com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0];
    this.p3 = j;
    j = kotlin.s.a.a(j * 9.0D / 16);
    this.H3 = j;
    localLayoutParams.width = this.p3;
    localLayoutParams.height = j;
    localObject = (FrameLayout)e1(i);
    j.d(localObject, "setting_area_container");
    ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
  }
  
  private final void p1()
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
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(LineCrossingViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ingViewModel::class.java)");
    localObject = (LineCrossingViewModel)localObject;
    this.z = ((LineCrossingViewModel)localObject);
    if (localObject == null) {
      j.t("viewModel");
    }
    ((LineCrossingViewModel)localObject).n(this.I3);
    t1();
  }
  
  private final void q1(List<LineCrossingDetectionRegion> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.p2.clear();
    int i = paramList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = (LineCrossingDetectionRegion)paramList.get(j);
      FlexibleLine localFlexibleLine = new FlexibleLine(this);
      localFlexibleLine.n(Integer.parseInt(((LineCrossingDetectionRegion)localObject).getPoint1X()), Integer.parseInt(((LineCrossingDetectionRegion)localObject).getPoint1Y()), Integer.parseInt(((LineCrossingDetectionRegion)localObject).getPoint2X()), Integer.parseInt(((LineCrossingDetectionRegion)localObject).getPoint2Y()), this.p3, this.H3);
      localFlexibleLine.setEditable(false);
      localObject = ((LineCrossingDetectionRegion)localObject).getDirection();
      int k = ((String)localObject).hashCode();
      if (k != 2051398)
      {
        if (k != 2081188)
        {
          if ((k == 3029889) && (((String)localObject).equals("both")))
          {
            k = 2;
            break label186;
          }
        }
        else if (((String)localObject).equals("BtoA"))
        {
          k = 1;
          break label186;
        }
      }
      else {
        ((String)localObject).equals("AtoB");
      }
      k = 0;
      label186:
      localFlexibleLine.setArrowDirection(k);
      this.p2.add(localFlexibleLine);
      localObject = (FrameLayout)e1(com.tplink.iot.a.setting_area_container);
      j++;
      ((FrameLayout)localObject).addView(localFlexibleLine, j);
    }
  }
  
  private final void r1()
  {
    LineCrossingViewModel localLineCrossingViewModel = this.z;
    if (localLineCrossingViewModel == null) {
      j.t("viewModel");
    }
    localLineCrossingViewModel.k().observe(this, new b(this));
    localLineCrossingViewModel = this.z;
    if (localLineCrossingViewModel == null) {
      j.t("viewModel");
    }
    localLineCrossingViewModel.l().observe(this, new c(this));
    localLineCrossingViewModel = this.z;
    if (localLineCrossingViewModel == null) {
      j.t("viewModel");
    }
    localLineCrossingViewModel.i().observe(this, new d(this));
  }
  
  private final void s1()
  {
    setContentView(2131558570);
    int i = com.tplink.iot.a.mtb;
    setSupportActionBar((Toolbar)e1(i));
    o1();
    ((Toolbar)e1(i)).setNavigationOnClickListener(new e(this));
    ((CheckBox)e1(com.tplink.iot.a.line_crossing_switch)).setOnClickListener(new f(this));
    ((LinearLayout)e1(com.tplink.iot.a.ll_region_edit)).setOnClickListener(this);
    ((ImageView)e1(com.tplink.iot.a.setting_cover_iv)).setOnClickListener(this);
    ((LinearLayout)e1(com.tplink.iot.a.ll_schedule)).setOnClickListener(this);
  }
  
  private final void t1()
  {
    String str = this.p0;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    l.e(str, new g(this));
  }
  
  private final void u1()
  {
    Iterator localIterator = this.p2.iterator();
    while (localIterator.hasNext())
    {
      FlexibleLine localFlexibleLine = (FlexibleLine)localIterator.next();
      ((FrameLayout)e1(com.tplink.iot.a.setting_area_container)).removeView(localFlexibleLine);
    }
  }
  
  private final void v1()
  {
    new UniversalDialog.a().q(getString(2131953210)).s(getString(2131951763)).u(getString(2131952751)).t(new i(this)).l().show(getSupportFragmentManager(), "SETTING");
  }
  
  private final void w1()
  {
    LineCrossingViewModel localLineCrossingViewModel = this.z;
    if (localLineCrossingViewModel == null) {
      j.t("viewModel");
    }
    localLineCrossingViewModel.m().observe(this, new j(this));
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
        LineCrossingRegionSettingActivity.I1(this, paramView, this.I3);
      }
      else
      {
        v1();
      }
    }
    else if (j.a(paramView, (LinearLayout)e1(com.tplink.iot.a.ll_schedule)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("deviceIdMD5");
      }
      LineCrossingScheduleSettingActivity.Y0(this, paramView, this.I3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    s1();
    p1();
    r1();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (!this.p1) {
      this.c.postDelayed(new h(this), 1500L);
    }
    LineCrossingViewModel localLineCrossingViewModel;
    if (this.I3 == 3)
    {
      localLineCrossingViewModel = this.z;
      if (localLineCrossingViewModel == null) {
        j.t("viewModel");
      }
      localLineCrossingViewModel.S();
    }
    else
    {
      localLineCrossingViewModel = this.z;
      if (localLineCrossingViewModel == null) {
        j.t("viewModel");
      }
      localLineCrossingViewModel.R();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, LineCrossingDetectionActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      Object localObject = (CheckBox)this.a.e1(com.tplink.iot.a.line_crossing_switch);
      j.d(localObject, "line_crossing_switch");
      j.d(paramBoolean, "it");
      ((CheckBox)localObject).setChecked(paramBoolean.booleanValue());
      localObject = (LinearLayout)this.a.e1(com.tplink.iot.a.ll_line_crossing_content);
      j.d(localObject, "ll_line_crossing_content");
      int i;
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 8;
      }
      ((LinearLayout)localObject).setVisibility(i);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
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
    d(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
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
    e(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void onClick(View paramView)
    {
      LineCrossingViewModel localLineCrossingViewModel = LineCrossingDetectionActivity.g1(this.c);
      paramView = (CheckBox)this.c.e1(com.tplink.iot.a.line_crossing_switch);
      j.d(paramView, "line_crossing_switch");
      localLineCrossingViewModel.W(paramView.isChecked());
    }
  }
  
  static final class g<T>
    implements b<com.tplink.libtpmediaother.database.model.c>
  {
    g(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.c paramc)
    {
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.i())))
      {
        LineCrossingDetectionActivity.l1(this.a, true);
        String str = paramc.i();
        paramc = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(paramc, "no_preview_note");
        paramc.setVisibility(4);
        com.bumptech.glide.c.u(this.a.getApplication()).s(str).x0((ImageView)this.a.e1(com.tplink.iot.a.setting_cover_iv));
        LineCrossingDetectionActivity.m1(this.a);
      }
      else
      {
        LineCrossingDetectionActivity.l1(this.a, false);
        paramc = (TextView)this.a.e1(com.tplink.iot.a.no_preview_note);
        j.d(paramc, "no_preview_note");
        paramc.setVisibility(0);
      }
    }
  }
  
  static final class h
    implements Runnable
  {
    h(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void run()
    {
      LineCrossingDetectionActivity.j1(this.c);
    }
  }
  
  static final class i
    implements UniversalDialog.c
  {
    i(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void a()
    {
      LineCrossingDetectionActivity.h1(this.a);
    }
  }
  
  static final class j<T>
    implements Observer<List<? extends LineCrossingDetectionRegion>>
  {
    j(LineCrossingDetectionActivity paramLineCrossingDetectionActivity) {}
    
    public final void a(List<LineCrossingDetectionRegion> paramList)
    {
      if ((paramList != null) && (LineCrossingDetectionActivity.f1(this.a)))
      {
        LineCrossingDetectionActivity.k1(this.a);
        LineCrossingDetectionActivity.i1(this.a, paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LineCrossingDetectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */