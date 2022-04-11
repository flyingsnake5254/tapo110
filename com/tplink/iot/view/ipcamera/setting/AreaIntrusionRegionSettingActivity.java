package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBinding;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.cameranetwork.business.model.c.a;
import com.tplink.libtpnetwork.cameranetwork.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaIntrusionRegionSettingActivity
  extends BaseActivity
  implements ChangeableAreaView.a
{
  private static final int y = e.a(32, AppContext.c);
  private int H3;
  private ActivityAreaIntrusionRegionSettingBinding I3;
  private int J3 = 3;
  private ChangeableAreaView p0;
  private AreaIntrusionViewModel p1;
  private List<ChangeableAreaView> p2 = new ArrayList();
  private int p3;
  private int z = 0;
  
  public static void M1(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AreaIntrusionRegionSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("detection_home_mode", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void N1()
  {
    b.d.q.b.l.e(this.p1.i(), new n(this));
  }
  
  private void O1()
  {
    if (this.p2.isEmpty()) {
      new UniversalDialog.a().q(getString(2131953218)).s(getString(2131951757)).r(null).u(getString(2131951764)).t(new q(this)).m(true).l().show(getSupportFragmentManager(), "REGION");
    } else {
      this.p1.b0(h1());
    }
  }
  
  private void P1()
  {
    this.p1.i.set(true);
    Iterator localIterator = this.p2.iterator();
    while (localIterator.hasNext())
    {
      ChangeableAreaView localChangeableAreaView = (ChangeableAreaView)localIterator.next();
      if (localChangeableAreaView != null) {
        this.I3.M3.removeView(localChangeableAreaView);
      }
    }
    this.p1.j.set(false);
    this.p1.k.set(false);
    this.p2.clear();
    this.z = 0;
  }
  
  public static void Q1(Activity paramActivity, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    int i = localViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      paramActivity = localViewGroup.getChildAt(j);
      if ((paramActivity instanceof ViewGroup))
      {
        paramActivity.setFitsSystemWindows(paramBoolean);
        ((ViewGroup)paramActivity).setClipToPadding(paramBoolean);
      }
    }
  }
  
  private void R1()
  {
    Toolbar localToolbar = this.I3.Q3;
    if (localToolbar != null)
    {
      setSupportActionBar(localToolbar);
      localToolbar.setNavigationOnClickListener(new j(this));
    }
  }
  
  private void S1()
  {
    if (!r1())
    {
      getWindow().getDecorView().setSystemUiVisibility(0);
      Object localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags &= 0xFBFF;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getWindow().clearFlags(512);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.I3.M3.getLayoutParams();
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      localMarginLayoutParams.width = ((DisplayMetrics)localObject).widthPixels;
      int i = b.d.q.b.o.a(this, 216.0F);
      int j = b.d.q.b.o.a(this, 30.0F);
      j = (int)((((DisplayMetrics)localObject).widthPixels - j) / 1.7777778F) + j;
      if (i < j) {
        i = j;
      }
      localMarginLayoutParams.height = i;
    }
  }
  
  private void T1()
  {
    int i = this.z;
    if ((i >= 0) && (i < 4)) {
      this.p1.i.set(true);
    } else {
      this.p1.i.set(false);
    }
  }
  
  private void U1(ChangeableAreaView paramChangeableAreaView)
  {
    ChangeableAreaView localChangeableAreaView = this.p0;
    if (localChangeableAreaView != null) {
      localChangeableAreaView.i(false);
    }
    this.p0 = paramChangeableAreaView;
    paramChangeableAreaView.i(true);
  }
  
  private void e1()
  {
    int i = this.z;
    if (i >= 4)
    {
      T1();
      return;
    }
    this.z = (i + 1);
    ChangeableAreaView localChangeableAreaView = new ChangeableAreaView(this);
    localChangeableAreaView.setAreaViewListener(this);
    int j = this.p3;
    double d = j;
    i = this.H3;
    l1(localChangeableAreaView, new c.a(2500, (int)(d * 2500.0D / i), 3750, (10000 - (int)(j * 2500.0D / i)) / 2));
    this.p2.add(localChangeableAreaView);
    this.I3.M3.addView(localChangeableAreaView);
    U1(localChangeableAreaView);
    T1();
    this.p1.j.set(true);
  }
  
  private void f1(ChangeableAreaView paramChangeableAreaView)
  {
    c.a locala = g1(paramChangeableAreaView);
    this.p2.remove(paramChangeableAreaView);
    this.p2.add(paramChangeableAreaView);
    this.I3.M3.removeView(paramChangeableAreaView);
    l1(paramChangeableAreaView, locala);
    this.I3.M3.addView(paramChangeableAreaView, this.p2.size());
  }
  
  private c.a g1(ChangeableAreaView paramChangeableAreaView)
  {
    c.a locala = new c.a();
    double d = paramChangeableAreaView.getLeft() * 10000;
    int i = this.p3;
    int j = y;
    locala.g((int)(d * 1.0D / (i - j)));
    locala.h((int)(paramChangeableAreaView.getTop() * 10000 * 1.0D / (this.H3 - j)));
    locala.f((int)((paramChangeableAreaView.getWidth() - j) * 10000 * 1.0D / (this.p3 - j)));
    locala.e((int)((paramChangeableAreaView.getHeight() - j) * 10000 * 1.0D / (this.H3 - j)));
    return locala;
  }
  
  private List<c.a> h1()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.p2.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(g1((ChangeableAreaView)((Iterator)localObject).next()));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stash region size");
    ((StringBuilder)localObject).append(localArrayList.size());
    a.e("DetectionRegionActivity", ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  private void i1()
  {
    ArrayList localArrayList = new ArrayList();
    c.a locala = new c.a();
    locala.g(0);
    locala.h(0);
    locala.e(10000);
    locala.f(10000);
    localArrayList.add(locala);
    this.p1.b0(localArrayList);
  }
  
  private void j1(boolean paramBoolean)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      Q1(this, false);
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      getWindow().setAttributes(localLayoutParams);
    }
    else
    {
      Q1(this, true);
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags &= 0xFBFF;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  private void k1()
  {
    this.I3.getRoot().post(new o(this));
  }
  
  private void l1(ChangeableAreaView paramChangeableAreaView, c.a parama)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 51;
    double d = parama.c() * 1.0D / 10000.0D;
    int i = this.p3;
    int j = y;
    localLayoutParams.leftMargin = ((int)(d * (i - j)));
    localLayoutParams.topMargin = ((int)(parama.d() * 1.0D / 10000.0D * (this.H3 - j)));
    localLayoutParams.width = ((int)(parama.b() * 1.0D / 10000.0D * (this.p3 - j) + j));
    localLayoutParams.height = ((int)(parama.a() * 1.0D / 10000.0D * (this.H3 - j) + j));
    paramChangeableAreaView.setLayoutParams(localLayoutParams);
  }
  
  private void m1(List<c.a> paramList)
  {
    this.p2.clear();
    this.z = paramList.size();
    T1();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load region size = ");
    ((StringBuilder)localObject).append(paramList.size());
    a.e("DetectionRegionActivity", ((StringBuilder)localObject).toString());
    int j;
    for (int i = 0; i < paramList.size(); i = j)
    {
      ChangeableAreaView localChangeableAreaView = new ChangeableAreaView(this);
      this.p2.add(localChangeableAreaView);
      localChangeableAreaView.setAreaViewListener(this);
      l1(localChangeableAreaView, (c.a)paramList.get(i));
      localObject = this.I3.M3;
      j = i + 1;
      ((FrameLayout)localObject).addView(localChangeableAreaView, j);
      if (i == paramList.size() - 1)
      {
        U1(localChangeableAreaView);
        this.p0.post(new m(this));
      }
      localObject = (c.a)paramList.get(i);
      if ((((c.a)localObject).c() == 0) && (((c.a)localObject).d() == 0) && (((c.a)localObject).a() == 10000) && (((c.a)localObject).b() == 10000)) {
        this.p1.k.set(true);
      }
    }
  }
  
  private void n1()
  {
    ActivityAreaIntrusionRegionSettingBinding localActivityAreaIntrusionRegionSettingBinding = (ActivityAreaIntrusionRegionSettingBinding)DataBindingUtil.setContentView(this, 2131558446);
    this.I3 = localActivityAreaIntrusionRegionSettingBinding;
    localActivityAreaIntrusionRegionSettingBinding.i(this.p1);
    this.I3.h(new h(this));
  }
  
  private void o1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    this.J3 = getIntent().getIntExtra("detection_home_mode", 3);
    this.I3 = ((ActivityAreaIntrusionRegionSettingBinding)DataBindingUtil.setContentView(this, 2131558446));
    localObject = (AreaIntrusionViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AreaIntrusionViewModel.class);
    this.p1 = ((AreaIntrusionViewModel)localObject);
    ((AreaIntrusionViewModel)localObject).o(this.J3);
  }
  
  private void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362489: 
    case 2131363582: 
      O1();
      break;
    case 2131362389: 
    case 2131362390: 
      P1();
      break;
    case 2131362256: 
      onBackPressed();
      break;
    case 2131362223: 
      setRequestedOrientation(1);
      break;
    case 2131362222: 
      setRequestedOrientation(0);
      break;
    case 2131361939: 
    case 2131361940: 
      e1();
      break;
    case 2131361937: 
    case 2131361938: 
      TSnackbar.y(this, String.format(getString(2131953801), new Object[] { Integer.valueOf(4) }), 3000).N();
    }
  }
  
  private void p1()
  {
    this.p1.k().observe(this, new k(this));
    this.p1.m().observe(this, new r(this));
    this.p1.j().observe(this, new i(this));
    this.p1.n().observe(this, new p(this));
  }
  
  private void q1()
  {
    this.I3.i(this.p1);
    this.I3.h(new h(this));
    j1(r1());
    S1();
    R1();
    k1();
    N1();
  }
  
  public void H(ChangeableAreaView paramChangeableAreaView)
  {
    if (this.p0 != paramChangeableAreaView) {
      f1(paramChangeableAreaView);
    }
    U1(paramChangeableAreaView);
  }
  
  public void O(ChangeableAreaView paramChangeableAreaView)
  {
    this.p2.remove(paramChangeableAreaView);
    this.I3.M3.removeView(paramChangeableAreaView);
    Object localObject = this.p2;
    boolean bool = true;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.p2;
      localObject = (ChangeableAreaView)((List)localObject).get(((List)localObject).size() - 1);
      this.p0 = ((ChangeableAreaView)localObject);
      ((ChangeableAreaView)localObject).i(true);
    }
    this.z -= 1;
    this.p1.i.set(true);
    localObject = this.p1.j;
    if (this.z == 0) {
      bool = false;
    }
    ((ObservableBoolean)localObject).set(bool);
    paramChangeableAreaView = g1(paramChangeableAreaView);
    if ((paramChangeableAreaView.c() == 0) && (paramChangeableAreaView.d() == 0) && (paramChangeableAreaView.a() == 10000) && (paramChangeableAreaView.b() == 10000)) {
      this.p1.k.set(false);
    }
  }
  
  public void h0(ChangeableAreaView paramChangeableAreaView)
  {
    this.p1.f(h1());
  }
  
  public void onBackPressed()
  {
    if (r1()) {
      setRequestedOrientation(1);
    } else {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = h1();
    n1();
    j1(r1());
    S1();
    if (!r1()) {
      R1();
    }
    this.I3.getRoot().post(new l(this, paramConfiguration));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o1();
    q1();
    p1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361893) {
      O1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    T1();
  }
  
  protected boolean r1()
  {
    boolean bool;
    if (getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AreaIntrusionRegionSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */