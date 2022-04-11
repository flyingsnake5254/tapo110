package com.tplink.iot.view.ipcamera.setting.privacymask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.o;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityPrivacyMaskZonesBinding;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.privacymask.PrivacyMaskZonesViewModel;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.util.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

public final class PrivacyMaskZonesActivity
  extends BaseActivity
  implements ChangeableAreaView.a
{
  private static final String y = PrivacyMaskZonesActivity.class.getSimpleName();
  public static final a z = new a(null);
  private int H3;
  private int I3;
  private String J3;
  private ActivityPrivacyMaskZonesBinding K3;
  private PrivacyMaskZonesViewModel L3;
  private final int p0 = e.a(32, AppContext.c);
  private int p1;
  private ChangeableAreaView p2;
  private final List<ChangeableAreaView> p3 = new ArrayList();
  
  private final void A1()
  {
    Object localObject = this.K3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    localObject = ((ActivityPrivacyMaskZonesBinding)localObject).S3;
    if (localObject != null)
    {
      setSupportActionBar((Toolbar)localObject);
      ((Toolbar)localObject).setNavigationOnClickListener(new g(this));
    }
  }
  
  private final void B1()
  {
    if (!v1())
    {
      Object localObject1 = getWindow();
      kotlin.jvm.internal.j.d(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      kotlin.jvm.internal.j.d(localObject1, "window.decorView");
      ((View)localObject1).setSystemUiVisibility(0);
      localObject1 = getWindow();
      kotlin.jvm.internal.j.d(localObject1, "window");
      localObject1 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject1).flags &= 0xFBFF;
      Object localObject2 = getWindow();
      kotlin.jvm.internal.j.d(localObject2, "window");
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject1);
      getWindow().clearFlags(512);
      localObject1 = this.K3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("binding");
      }
      localObject1 = ((ActivityPrivacyMaskZonesBinding)localObject1).N3;
      kotlin.jvm.internal.j.d(localObject1, "binding.settingAreaContainer");
      localObject1 = ((FrameLayout)localObject1).getLayoutParams();
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localObject1 = new DisplayMetrics();
      WindowManager localWindowManager = getWindowManager();
      kotlin.jvm.internal.j.d(localWindowManager, "windowManager");
      localWindowManager.getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
      ((ViewGroup.MarginLayoutParams)localObject2).width = ((DisplayMetrics)localObject1).widthPixels;
      int i = o.a(this, 216.0F);
      int j = o.a(this, 30.0F);
      j = (int)((((DisplayMetrics)localObject1).widthPixels - j) / 1.7777778F) + j;
      if (i < j) {
        i = j;
      }
      ((ViewGroup.MarginLayoutParams)localObject2).height = i;
    }
  }
  
  private final void C1()
  {
    int i = this.p1;
    PrivacyMaskZonesViewModel localPrivacyMaskZonesViewModel;
    if ((i >= 0) && (4 > i))
    {
      localPrivacyMaskZonesViewModel = this.L3;
      if (localPrivacyMaskZonesViewModel == null) {
        kotlin.jvm.internal.j.t("viewModel");
      }
      localPrivacyMaskZonesViewModel.a.set(true);
    }
    else
    {
      localPrivacyMaskZonesViewModel = this.L3;
      if (localPrivacyMaskZonesViewModel == null) {
        kotlin.jvm.internal.j.t("viewModel");
      }
      localPrivacyMaskZonesViewModel.a.set(false);
    }
  }
  
  private final void D1(ChangeableAreaView paramChangeableAreaView)
  {
    ChangeableAreaView localChangeableAreaView = this.p2;
    if (localChangeableAreaView != null)
    {
      kotlin.jvm.internal.j.c(localChangeableAreaView);
      localChangeableAreaView.i(false);
    }
    this.p2 = paramChangeableAreaView;
    kotlin.jvm.internal.j.c(paramChangeableAreaView);
    paramChangeableAreaView.i(true);
  }
  
  private final void j1()
  {
    int i = this.p1;
    if (i >= 4)
    {
      C1();
      return;
    }
    this.p1 = (i + 1);
    Object localObject = new ChangeableAreaView(this);
    ((ChangeableAreaView)localObject).setAreaViewListener(this);
    int j = this.H3;
    double d = j;
    i = this.I3;
    p1((ChangeableAreaView)localObject, new d(2500, (int)(d * 2500.0D / i), 3750, (10000 - (int)(j * 2500.0D / i)) / 2));
    this.p3.add(localObject);
    ActivityPrivacyMaskZonesBinding localActivityPrivacyMaskZonesBinding = this.K3;
    if (localActivityPrivacyMaskZonesBinding == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    localActivityPrivacyMaskZonesBinding.N3.addView((View)localObject);
    D1((ChangeableAreaView)localObject);
    C1();
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((RegionEditViewModel)localObject).b.set(true);
  }
  
  private final void k1(ChangeableAreaView paramChangeableAreaView)
  {
    Object localObject = m1(paramChangeableAreaView);
    this.p3.remove(paramChangeableAreaView);
    this.p3.add(paramChangeableAreaView);
    ActivityPrivacyMaskZonesBinding localActivityPrivacyMaskZonesBinding = this.K3;
    if (localActivityPrivacyMaskZonesBinding == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    localActivityPrivacyMaskZonesBinding.N3.removeView(paramChangeableAreaView);
    p1(paramChangeableAreaView, (d)localObject);
    localObject = this.K3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    ((ActivityPrivacyMaskZonesBinding)localObject).N3.addView(paramChangeableAreaView, this.p3.size());
  }
  
  private final void l1()
  {
    Object localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((RegionEditViewModel)localObject).a.set(true);
    Iterator localIterator = this.p3.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ChangeableAreaView)localIterator.next();
      if (localObject != null)
      {
        ActivityPrivacyMaskZonesBinding localActivityPrivacyMaskZonesBinding = this.K3;
        if (localActivityPrivacyMaskZonesBinding == null) {
          kotlin.jvm.internal.j.t("binding");
        }
        localActivityPrivacyMaskZonesBinding.N3.removeView((View)localObject);
      }
    }
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((RegionEditViewModel)localObject).b.set(false);
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((RegionEditViewModel)localObject).c.set(false);
    this.p3.clear();
    this.p1 = 0;
  }
  
  private final d m1(ChangeableAreaView paramChangeableAreaView)
  {
    d locald = new d();
    locald.g((int)(paramChangeableAreaView.getLeft() * 10000 * 1.0D / (this.H3 - this.p0)));
    locald.h((int)(paramChangeableAreaView.getTop() * 10000 * 1.0D / (this.I3 - this.p0)));
    int i = paramChangeableAreaView.getWidth();
    int j = this.p0;
    locald.f((int)((i - j) * 10000 * 1.0D / (this.H3 - j)));
    j = paramChangeableAreaView.getHeight();
    i = this.p0;
    locald.e((int)((j - i) * 10000 * 1.0D / (this.I3 - i)));
    return locald;
  }
  
  private final List<d> n1()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.p3.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChangeableAreaView)((Iterator)localObject1).next();
      if (localObject2 != null) {
        localArrayList.add(m1((ChangeableAreaView)localObject2));
      }
    }
    localObject1 = y;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("stash region size");
    ((StringBuilder)localObject2).append(localArrayList.size());
    b.d.w.c.a.c((String)localObject1, ((StringBuilder)localObject2).toString());
    return localArrayList;
  }
  
  private final void o1(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      z1(this, false);
      localObject1 = getWindow();
      kotlin.jvm.internal.j.d(localObject1, "window");
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).flags |= 0x400;
      localObject1 = getWindow();
      kotlin.jvm.internal.j.d(localObject1, "window");
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    }
    else
    {
      z1(this, true);
      localObject1 = getWindow();
      kotlin.jvm.internal.j.d(localObject1, "window");
      localObject1 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject1).flags &= 0xFBFF;
      localObject2 = getWindow();
      kotlin.jvm.internal.j.d(localObject2, "window");
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject1);
    }
  }
  
  private final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363582: 
      x1();
      break;
    case 2131362489: 
      x1();
      break;
    case 2131362389: 
    case 2131362390: 
      l1();
      break;
    case 2131362256: 
      onBackPressed();
      break;
    case 2131362223: 
      paramView = this.L3;
      if (paramView == null) {
        kotlin.jvm.internal.j.t("viewModel");
      }
      paramView.o(n1());
      setRequestedOrientation(1);
      break;
    case 2131362222: 
      paramView = this.L3;
      if (paramView == null) {
        kotlin.jvm.internal.j.t("viewModel");
      }
      paramView.o(n1());
      setRequestedOrientation(0);
      break;
    case 2131361939: 
    case 2131361940: 
      j1();
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  private final void p1(ChangeableAreaView paramChangeableAreaView, d paramd)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    double d1 = paramd.c();
    double d2 = '✐';
    localLayoutParams.leftMargin = ((int)(d1 * 1.0D / d2 * (this.H3 - this.p0)));
    localLayoutParams.topMargin = ((int)(paramd.d() * 1.0D / d2 * (this.I3 - this.p0)));
    d1 = paramd.b() * 1.0D / d2;
    int i = this.H3;
    int j = this.p0;
    localLayoutParams.width = ((int)(d1 * (i - j) + j));
    d2 = paramd.a() * 1.0D / d2;
    i = this.I3;
    j = this.p0;
    localLayoutParams.height = ((int)(d2 * (i - j) + j));
    paramd = p.a;
    paramChangeableAreaView.setLayoutParams(localLayoutParams);
  }
  
  private final void q1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.J3 = ((String)localObject);
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(PrivacyMaskZonesViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…nesViewModel::class.java)");
    this.L3 = ((PrivacyMaskZonesViewModel)localObject);
  }
  
  private final void r1()
  {
    PrivacyMaskZonesViewModel localPrivacyMaskZonesViewModel = this.L3;
    if (localPrivacyMaskZonesViewModel == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localPrivacyMaskZonesViewModel.k(), this, new b(this));
  }
  
  private final void s1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558616);
    kotlin.jvm.internal.j.d(localObject, "DataBindingUtil.setConte…ivity_privacy_mask_zones)");
    ActivityPrivacyMaskZonesBinding localActivityPrivacyMaskZonesBinding = (ActivityPrivacyMaskZonesBinding)localObject;
    this.K3 = localActivityPrivacyMaskZonesBinding;
    if (localActivityPrivacyMaskZonesBinding == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    localActivityPrivacyMaskZonesBinding.i((RegionEditViewModel)localObject);
    localObject = this.K3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    ((ActivityPrivacyMaskZonesBinding)localObject).h(new c(this));
    o1(v1());
    B1();
    A1();
    u1();
    w1();
  }
  
  private final void t1(List<? extends d> paramList)
  {
    this.p3.clear();
    this.p1 = paramList.size();
    C1();
    Object localObject1 = y;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load region size = ");
    ((StringBuilder)localObject2).append(paramList.size());
    b.d.w.c.a.c((String)localObject1, ((StringBuilder)localObject2).toString());
    int i = paramList.size();
    int k;
    for (int j = 0; j < i; j = k)
    {
      localObject2 = new ChangeableAreaView(this);
      if (Build.VERSION.SDK_INT >= 23) {
        ((ChangeableAreaView)localObject2).setAreaInnerColor(getResources().getColor(2131099691, getTheme()));
      } else {
        ((ChangeableAreaView)localObject2).setAreaInnerColor(getResources().getColor(2131099691));
      }
      this.p3.add(localObject2);
      ((ChangeableAreaView)localObject2).setAreaViewListener(this);
      p1((ChangeableAreaView)localObject2, (d)paramList.get(j));
      localObject1 = this.K3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("binding");
      }
      localObject1 = ((ActivityPrivacyMaskZonesBinding)localObject1).N3;
      k = j + 1;
      ((FrameLayout)localObject1).addView((View)localObject2, k);
      if (j == paramList.size() - 1) {
        D1((ChangeableAreaView)localObject2);
      }
      localObject2 = (d)paramList.get(j);
      if ((((d)localObject2).c() == 0) && (((d)localObject2).d() == 0) && (((d)localObject2).a() == 10000) && (((d)localObject2).b() == 10000))
      {
        localObject2 = this.L3;
        if (localObject2 == null) {
          kotlin.jvm.internal.j.t("viewModel");
        }
        ((RegionEditViewModel)localObject2).c.set(true);
      }
    }
  }
  
  private final void u1()
  {
    ActivityPrivacyMaskZonesBinding localActivityPrivacyMaskZonesBinding = this.K3;
    if (localActivityPrivacyMaskZonesBinding == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    localActivityPrivacyMaskZonesBinding.getRoot().post(new d(this));
  }
  
  private final boolean v1()
  {
    Resources localResources = getResources();
    kotlin.jvm.internal.j.d(localResources, "resources");
    boolean bool;
    if (localResources.getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void w1()
  {
    String str = this.J3;
    if (str == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    b.d.q.b.l.e(str, new e(this));
  }
  
  private final void x1()
  {
    List localList = n1();
    int i = localList.size();
    Object localObject = this.J3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    w.b((String)localObject, bool, i);
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((PrivacyMaskZonesViewModel)localObject).m(localList, new f(this));
  }
  
  private final void y1()
  {
    Object localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    localObject = (List)((PrivacyMaskZonesViewModel)localObject).j().getValue();
    if (localObject != null)
    {
      l1();
      kotlin.jvm.internal.j.d(localObject, "this");
      t1((List)localObject);
      PrivacyMaskZonesViewModel localPrivacyMaskZonesViewModel = this.L3;
      if (localPrivacyMaskZonesViewModel == null) {
        kotlin.jvm.internal.j.t("viewModel");
      }
      localPrivacyMaskZonesViewModel.b.set(((Collection)localObject).isEmpty() ^ true);
    }
  }
  
  private final void z1(Activity paramActivity, boolean paramBoolean)
  {
    paramActivity = (ViewGroup)paramActivity.findViewById(16908290);
    kotlin.jvm.internal.j.d(paramActivity, "parent");
    int i = paramActivity.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramActivity.getChildAt(j);
      if ((localView instanceof ViewGroup))
      {
        localView.setFitsSystemWindows(paramBoolean);
        ((ViewGroup)localView).setClipToPadding(paramBoolean);
      }
    }
  }
  
  public void H(ChangeableAreaView paramChangeableAreaView)
  {
    kotlin.jvm.internal.j.e(paramChangeableAreaView, "view");
    if (this.p2 != paramChangeableAreaView) {
      k1(paramChangeableAreaView);
    }
    D1(paramChangeableAreaView);
  }
  
  public void O(ChangeableAreaView paramChangeableAreaView)
  {
    this.p3.remove(paramChangeableAreaView);
    Object localObject = this.K3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("binding");
    }
    ((ActivityPrivacyMaskZonesBinding)localObject).N3.removeView(paramChangeableAreaView);
    boolean bool1 = this.p3.isEmpty();
    boolean bool2 = true;
    if ((bool1 ^ true))
    {
      localObject = (ChangeableAreaView)kotlin.collections.l.F(this.p3);
      this.p2 = ((ChangeableAreaView)localObject);
      kotlin.jvm.internal.j.c(localObject);
      ((ChangeableAreaView)localObject).i(true);
    }
    this.p1 -= 1;
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    ((RegionEditViewModel)localObject).a.set(true);
    localObject = this.L3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    localObject = ((RegionEditViewModel)localObject).b;
    if (this.p1 == 0) {
      bool2 = false;
    }
    ((ObservableBoolean)localObject).set(bool2);
    if (paramChangeableAreaView != null)
    {
      paramChangeableAreaView = m1(paramChangeableAreaView);
      if ((paramChangeableAreaView.c() == 0) && (paramChangeableAreaView.d() == 0) && (paramChangeableAreaView.a() == 10000) && (paramChangeableAreaView.b() == 10000))
      {
        paramChangeableAreaView = this.L3;
        if (paramChangeableAreaView == null) {
          kotlin.jvm.internal.j.t("viewModel");
        }
        paramChangeableAreaView.c.set(false);
      }
    }
  }
  
  public void h0(ChangeableAreaView paramChangeableAreaView)
  {
    paramChangeableAreaView = this.L3;
    if (paramChangeableAreaView == null) {
      kotlin.jvm.internal.j.t("viewModel");
    }
    paramChangeableAreaView.h(n1());
  }
  
  public void onBackPressed()
  {
    if (v1()) {
      setRequestedOrientation(1);
    } else {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    kotlin.jvm.internal.j.e(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = n1();
    setContentView(2131558585);
    u1();
    o1(v1());
    l1();
    t1(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    q1();
    s1();
    r1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    kotlin.jvm.internal.j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361893) {
      x1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    C1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      Intent localIntent = new Intent(paramContext, PrivacyMaskZonesActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements b<String>
  {
    b(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity) {}
    
    public final void b(String paramString)
    {
      TSnackbar.y(this.a, paramString, -1).N();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity) {}
    
    public final void onClick(View paramView)
    {
      kotlin.jvm.internal.j.e(paramView, "v");
      PrivacyMaskZonesActivity.f1(this.c, paramView);
    }
  }
  
  static final class d
    implements Runnable
  {
    d(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity) {}
    
    public final void run()
    {
      Object localObject1 = this.c;
      Object localObject2 = PrivacyMaskZonesActivity.e1((PrivacyMaskZonesActivity)localObject1).N3;
      kotlin.jvm.internal.j.d(localObject2, "binding.settingAreaContainer");
      PrivacyMaskZonesActivity.i1((PrivacyMaskZonesActivity)localObject1, ((FrameLayout)localObject2).getWidth());
      localObject2 = this.c;
      localObject1 = PrivacyMaskZonesActivity.e1((PrivacyMaskZonesActivity)localObject2).N3;
      kotlin.jvm.internal.j.d(localObject1, "binding.settingAreaContainer");
      PrivacyMaskZonesActivity.h1((PrivacyMaskZonesActivity)localObject2, ((FrameLayout)localObject1).getHeight());
      PrivacyMaskZonesActivity.g1(this.c);
    }
  }
  
  static final class e<T>
    implements b<com.tplink.libtpmediaother.database.model.c>
  {
    e(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.c paramc)
    {
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.i())))
      {
        paramc = paramc.i();
        com.bumptech.glide.c.u(this.a.getApplication()).s(paramc).x0(PrivacyMaskZonesActivity.e1(this.a).P3);
        PrivacyMaskZonesActivity.g1(this.a);
      }
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<p>
  {
    f(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity)
    {
      super();
    }
    
    public final void a()
    {
      this.c.finish();
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(PrivacyMaskZonesActivity paramPrivacyMaskZonesActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.onBackPressed();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\privacymask\PrivacyMaskZonesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */