package com.tplink.iot.dailysummary.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.view.adapter.SummaryHomeAdapter;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.dailysummary.widget.SummarySettingDialogFragment;
import com.tplink.iot.dailysummary.widget.SummarySettingDialogFragment.b;
import com.tplink.iot.databinding.ActivityDailySummaryBinding;
import com.tplink.iot.databinding.LayoutDailySummarySettingsBinding;
import com.tplink.iot.e.a.a;
import com.tplink.iot.e.a.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class DailySummaryActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private View H3;
  private View I3;
  private View J3;
  private View K3;
  private View L3;
  private RecyclerView M3;
  private View N3;
  private View O3;
  private View P3;
  private View Q3;
  private View R3;
  private View S3;
  private View T3;
  private SwitchCompat U3;
  private SwitchCompat V3;
  private TPSmartRefreshLayout W3;
  private boolean p0;
  private String p1;
  private DailySummaryViewModel p2;
  private ActivityDailySummaryBinding p3;
  private SummaryHomeAdapter z;
  
  private final void k1()
  {
    if (getIntent().getBooleanExtra("playSummary", false))
    {
      String str = getIntent().getStringExtra("summaryDate");
      if (str != null)
      {
        SummaryPlayActivity.a locala = SummaryPlayActivity.y;
        j.d(str, "it");
        locala.a(this, str);
      }
    }
  }
  
  private final void l1()
  {
    startActivity(new Intent(this, SummaryHistoryActivity.class));
  }
  
  private final void m1()
  {
    Object localObject1 = DataBindingUtil.setContentView(this, 2131558493);
    Object localObject2 = (ActivityDailySummaryBinding)localObject1;
    Object localObject3 = this.p2;
    if (localObject3 == null) {
      j.t("mViewModel");
    }
    ((ActivityDailySummaryBinding)localObject2).h((DailySummaryViewModel)localObject3);
    ((ViewDataBinding)localObject2).setLifecycleOwner(this);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).L3;
    j.d(localObject3, "toolbarDailySummary");
    this.H3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).f;
    j.d(localObject3, "btnDailySummaryBack");
    this.I3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).y;
    j.d(localObject3, "btnSummarySettting");
    this.J3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).x;
    j.d(localObject3, "btnSummaryListViewAll");
    this.K3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).q;
    j.d(localObject3, "btnPlaySummary");
    this.L3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).J3;
    j.d(localObject3, "recyclerSummaryHomeList");
    this.M3 = ((RecyclerView)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).d;
    j.d(localObject3, "btnCreateYesterdaySummary");
    this.N3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).c;
    j.d(localObject3, "btnCancelYesterdaySummary");
    this.O3 = ((View)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).K3;
    j.d(localObject3, "refreshLayoutSummaryHome");
    this.W3 = ((TPSmartRefreshLayout)localObject3);
    localObject3 = ((ActivityDailySummaryBinding)localObject2).p1;
    Object localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).L3;
    j.d(localObject4, "layoutSummarySettings");
    this.P3 = ((View)localObject4);
    localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).d;
    j.d(localObject4, "btnSummarySettingBack");
    this.Q3 = ((View)localObject4);
    localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).c;
    j.d(localObject4, "btnSaveSetting");
    this.R3 = ((View)localObject4);
    localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).M3;
    j.d(localObject4, "switchAutoRotation");
    this.U3 = ((SwitchCompat)localObject4);
    localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).N3;
    j.d(localObject4, "switchNotify");
    this.V3 = ((SwitchCompat)localObject4);
    localObject4 = ((LayoutDailySummarySettingsBinding)localObject3).q;
    j.d(localObject4, "btnVideoCombinationRecommended");
    this.S3 = ((View)localObject4);
    localObject3 = ((LayoutDailySummarySettingsBinding)localObject3).f;
    j.d(localObject3, "btnVideoCombinationAll");
    this.T3 = ((View)localObject3);
    localObject3 = p.a;
    j.d(localObject1, "DataBindingUtil.setConte…l\n            }\n        }");
    this.p3 = ((ActivityDailySummaryBinding)localObject2);
    localObject2 = this.H3;
    if (localObject2 == null) {
      j.t("mToolbar");
    }
    d.J(this, (View)localObject2);
    localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("mViewModel");
    }
    this.z = new SummaryHomeAdapter(this, (DailySummaryViewModel)localObject2);
    localObject1 = this.M3;
    if (localObject1 == null) {
      j.t("mRecycler");
    }
    ((RecyclerView)localObject1).setLayoutManager(new LinearLayoutManager(this));
    localObject2 = this.z;
    if (localObject2 == null) {
      j.t("mAdapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.Adapter)localObject2);
    localObject2 = this.W3;
    if (localObject2 == null) {
      j.t("mRefreshLayout");
    }
    ((SmartRefreshLayout)localObject2).Q(new SmartRefreshHeader(this));
    ((SmartRefreshLayout)localObject2).G(true);
    ((SmartRefreshLayout)localObject2).N(new b(this));
  }
  
  private final void n1()
  {
    DailySummaryViewModel localDailySummaryViewModel = this.p2;
    if (localDailySummaryViewModel == null) {
      j.t("mViewModel");
    }
    localDailySummaryViewModel.j0(false);
  }
  
  private final void o1()
  {
    SummarySettingDialogFragment localSummarySettingDialogFragment = new SummarySettingDialogFragment();
    localSummarySettingDialogFragment.B0(new c(localSummarySettingDialogFragment, this));
    localSummarySettingDialogFragment.show(getSupportFragmentManager(), "SummarySettingDialogFragment");
  }
  
  private final void p1()
  {
    Object localObject = this.I3;
    if (localObject == null) {
      j.t("mBackBtn");
    }
    ((View)localObject).setOnClickListener(new g(this));
    localObject = this.J3;
    if (localObject == null) {
      j.t("mSettingBtn");
    }
    ((View)localObject).setOnClickListener(new h(this));
    localObject = this.Q3;
    if (localObject == null) {
      j.t("mSettingBackBtn");
    }
    ((View)localObject).setOnClickListener(new i(this));
    localObject = this.K3;
    if (localObject == null) {
      j.t("mViewAllBtn");
    }
    ((View)localObject).setOnClickListener(new j(this));
    localObject = this.R3;
    if (localObject == null) {
      j.t("mSettingSaveBtn");
    }
    ((View)localObject).setOnClickListener(new k(this));
    localObject = this.L3;
    if (localObject == null) {
      j.t("mPlayBtn");
    }
    ((View)localObject).setOnClickListener(new l(this));
    localObject = this.N3;
    if (localObject == null) {
      j.t("mYesterdayCreateBtn");
    }
    ((View)localObject).setOnClickListener(new m(this));
    localObject = this.O3;
    if (localObject == null) {
      j.t("mYesterdayCancelBtn");
    }
    ((View)localObject).setOnClickListener(new n(this));
    localObject = this.U3;
    if (localObject == null) {
      j.t("mSettingAutoRotationSwitch");
    }
    ((CompoundButton)localObject).setOnCheckedChangeListener(new o(this));
    localObject = this.V3;
    if (localObject == null) {
      j.t("mSettingNotifySwitch");
    }
    ((CompoundButton)localObject).setOnCheckedChangeListener(new d(this));
    localObject = this.S3;
    if (localObject == null) {
      j.t("mSettingCombinationRecommendedBtn");
    }
    ((View)localObject).setOnClickListener(new e(this));
    localObject = this.T3;
    if (localObject == null) {
      j.t("mSettingCombinationAllBtn");
    }
    ((View)localObject).setOnClickListener(new f(this));
  }
  
  private final void q1()
  {
    DailySummaryViewModel localDailySummaryViewModel = this.p2;
    if (localDailySummaryViewModel == null) {
      j.t("mViewModel");
    }
    localDailySummaryViewModel.p().observe(this, new p(this));
    localDailySummaryViewModel.o().observe(this, new q(this));
    localDailySummaryViewModel.b0().observe(this, new r(this));
    localDailySummaryViewModel.V().observe(this, new s(this));
    localDailySummaryViewModel.a0().observe(this, new t(this));
    localDailySummaryViewModel.m().observe(this, new u(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("deviceId");
    if (paramBundle == null) {
      paramBundle = "";
    }
    this.p1 = paramBundle;
    Object localObject = c.k;
    if (paramBundle == null) {
      j.t("mCurrentDeviceId");
    }
    ((c)localObject).m(paramBundle);
    paramBundle = new ViewModelProvider(this).get(DailySummaryViewModel.class);
    j.d(paramBundle, "ViewModelProvider(this).…aryViewModel::class.java)");
    localObject = (DailySummaryViewModel)paramBundle;
    ((DailySummaryViewModel)localObject).k0();
    ((DailySummaryViewModel)localObject).j0(true);
    paramBundle = p.a;
    this.p2 = ((DailySummaryViewModel)localObject);
    m1();
    p1();
    q1();
    k1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (s0.j()) {
      s0.g();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.p0)
      {
        paramKeyEvent = this.p2;
        if (paramKeyEvent == null) {
          j.t("mViewModel");
        }
        paramKeyEvent.p0(false);
      }
      else
      {
        finish();
      }
    }
    return false;
  }
  
  protected void onStart()
  {
    super.onStart();
    if (c.k.d())
    {
      DailySummaryViewModel localDailySummaryViewModel = this.p2;
      if (localDailySummaryViewModel == null) {
        j.t("mViewModel");
      }
      localDailySummaryViewModel.j0(true);
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceId");
      Intent localIntent = new Intent(paramContext, DailySummaryActivity.class);
      localIntent.putExtra("deviceId", paramString);
      paramContext.startActivity(localIntent);
      c.k.l();
    }
  }
  
  static final class b
    implements g
  {
    b(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void m(f paramf)
    {
      j.e(paramf, "it");
      DailySummaryActivity.h1(this.c);
    }
  }
  
  public static final class c
    implements SummarySettingDialogFragment.b
  {
    c(SummarySettingDialogFragment paramSummarySettingDialogFragment, DailySummaryActivity paramDailySummaryActivity) {}
    
    public void a()
    {
      this.a.dismiss();
      s0.l(jdField_this);
      DailySummaryActivity.f1(jdField_this).n0();
    }
    
    public void b()
    {
      this.a.dismiss();
    }
  }
  
  static final class d
    implements CompoundButton.OnCheckedChangeListener
  {
    d(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      DailySummaryActivity.f1(this.a).Q(paramBoolean);
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).R(false);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).R(true);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).p0(true);
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).p0(false);
    }
  }
  
  static final class j
    implements View.OnClickListener
  {
    j(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.g1(this.c);
    }
  }
  
  static final class k
    implements View.OnClickListener
  {
    k(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.i1(this.c);
    }
  }
  
  static final class l
    implements View.OnClickListener
  {
    l(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (b)DailySummaryActivity.f1(this.c).h0().getValue();
      if (paramView != null) {
        SummaryPlayActivity.y.a(this.c, paramView.c());
      }
    }
  }
  
  static final class m
    implements View.OnClickListener
  {
    m(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).k(0, 1);
    }
  }
  
  static final class n
    implements View.OnClickListener
  {
    n(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onClick(View paramView)
    {
      DailySummaryActivity.f1(this.c).k(0, 0);
    }
  }
  
  static final class o
    implements CompoundButton.OnCheckedChangeListener
  {
    o(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      DailySummaryActivity.f1(this.a).P(paramBoolean);
    }
  }
  
  static final class p<T>
    implements Observer<Boolean>
  {
    p(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      DailySummaryActivity.e1(this.a).q();
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        s0.l(this.a);
      } else if (s0.j()) {
        s0.g();
      }
    }
  }
  
  static final class q<T>
    implements Observer<Boolean>
  {
    q(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class r<T>
    implements Observer<Boolean>
  {
    r(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      DailySummaryActivity localDailySummaryActivity = this.a;
      j.d(paramBoolean, "it");
      DailySummaryActivity.j1(localDailySummaryActivity, paramBoolean.booleanValue());
    }
  }
  
  static final class s<T>
    implements Observer<Boolean>
  {
    s(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class t<T>
    implements Observer<Boolean>
  {
    t(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class u<T>
    implements Observer<Boolean>
  {
    u(DailySummaryActivity paramDailySummaryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        DailySummaryActivity localDailySummaryActivity = this.a;
        paramBoolean = localDailySummaryActivity.getString(2131952479);
        j.d(paramBoolean, "getString(R.string.daily…create_successfully_hint)");
        a.c(localDailySummaryActivity, paramBoolean, true);
      }
      else
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\DailySummaryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */