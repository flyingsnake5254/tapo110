package com.tplink.iot.dailysummary.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
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
import com.scwang.smart.refresh.layout.a.d;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.view.adapter.SummaryHistoryAdapter;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.dailysummary.widget.SummaryDeleteDialogFragment;
import com.tplink.iot.dailysummary.widget.SummaryDeleteDialogFragment.b;
import com.tplink.iot.databinding.ActivitySummaryHistoryBinding;
import com.tplink.iot.e.a.a;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SummaryHistoryActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private View H3;
  private View I3;
  private View J3;
  private View K3;
  private View L3;
  private View M3;
  private TPSmartRefreshLayout N3;
  private SummaryHistoryAdapter p0;
  private SummaryHistoryViewModel p1;
  private RecyclerView p2;
  private View p3;
  private ActivitySummaryHistoryBinding z;
  
  private final void j1()
  {
    SummaryHistoryViewModel localSummaryHistoryViewModel = this.p1;
    if (localSummaryHistoryViewModel == null) {
      j.t("mViewModel");
    }
    localSummaryHistoryViewModel.K();
  }
  
  private final void k1(int paramInt)
  {
    SummaryDeleteDialogFragment localSummaryDeleteDialogFragment = new SummaryDeleteDialogFragment(paramInt);
    localSummaryDeleteDialogFragment.B0(new b(localSummaryDeleteDialogFragment, this));
    localSummaryDeleteDialogFragment.show(getSupportFragmentManager(), "SummaryDeleteDialogFragment");
  }
  
  private final void l1()
  {
    Object localObject1 = DataBindingUtil.setContentView(this, 2131558684);
    Object localObject2 = (ActivitySummaryHistoryBinding)localObject1;
    Object localObject3 = this.p1;
    if (localObject3 == null) {
      j.t("mViewModel");
    }
    ((ActivitySummaryHistoryBinding)localObject2).h((SummaryHistoryViewModel)localObject3);
    ((ViewDataBinding)localObject2).setLifecycleOwner(this);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).p3;
    j.d(localObject3, "toolbarSummaryHistory");
    this.J3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).x;
    j.d(localObject3, "btnSummaryHistoryBack");
    this.p3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).p1;
    j.d(localObject3, "toolbarSummaryEdit");
    this.K3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).z;
    j.d(localObject3, "recyclerSummaryHistoryList");
    this.p2 = ((RecyclerView)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).d;
    j.d(localObject3, "btnSummaryEdit");
    this.H3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).f;
    j.d(localObject3, "btnSummaryEditClose");
    this.I3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).c;
    j.d(localObject3, "btnDeleteSummary");
    this.L3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).q;
    j.d(localObject3, "btnSummaryEditSelectAll");
    this.M3 = ((View)localObject3);
    localObject3 = ((ActivitySummaryHistoryBinding)localObject2).p0;
    j.d(localObject3, "refreshLayoutSummaryHistory");
    this.N3 = ((TPSmartRefreshLayout)localObject3);
    localObject3 = p.a;
    j.d(localObject1, "DataBindingUtil.setConte…tSummaryHistory\n        }");
    this.z = ((ActivitySummaryHistoryBinding)localObject2);
    localObject2 = this.p1;
    if (localObject2 == null) {
      j.t("mViewModel");
    }
    this.p0 = new SummaryHistoryAdapter(this, (SummaryHistoryViewModel)localObject2);
    localObject2 = this.p2;
    if (localObject2 == null) {
      j.t("mRecycler");
    }
    ((RecyclerView)localObject2).setLayoutManager(new LinearLayoutManager(this));
    localObject1 = this.p0;
    if (localObject1 == null) {
      j.t("mAdapter");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    localObject2 = this.N3;
    if (localObject2 == null) {
      j.t("mRefreshLayout");
    }
    ((SmartRefreshLayout)localObject2).Q(new SmartRefreshHeader(this));
    ((SmartRefreshLayout)localObject2).O(new SmartRefreshFooter(this));
    ((SmartRefreshLayout)localObject2).G(true);
    ((SmartRefreshLayout)localObject2).E(false);
    ((SmartRefreshLayout)localObject2).M(new c(this));
  }
  
  private final void m1(boolean paramBoolean)
  {
    SummaryHistoryViewModel localSummaryHistoryViewModel;
    if (paramBoolean)
    {
      localSummaryHistoryViewModel = this.p1;
      if (localSummaryHistoryViewModel == null) {
        j.t("mViewModel");
      }
      localSummaryHistoryViewModel.R();
    }
    else
    {
      localSummaryHistoryViewModel = this.p1;
      if (localSummaryHistoryViewModel == null) {
        j.t("mViewModel");
      }
      SummaryHistoryViewModel.X(localSummaryHistoryViewModel, false, 1, null);
    }
  }
  
  private final void n1()
  {
    View localView = this.p3;
    if (localView == null) {
      j.t("mHistoryBackBtn");
    }
    localView.setOnClickListener(new d(this));
    localView = this.H3;
    if (localView == null) {
      j.t("mEditBtn");
    }
    localView.setOnClickListener(new e(this));
    localView = this.I3;
    if (localView == null) {
      j.t("mEditBackBtn");
    }
    localView.setOnClickListener(new f(this));
    localView = this.L3;
    if (localView == null) {
      j.t("mDeleteBtn");
    }
    localView.setOnClickListener(new g(this));
    localView = this.M3;
    if (localView == null) {
      j.t("mSelectAllBtn");
    }
    localView.setOnClickListener(new h(this));
  }
  
  private final void o1()
  {
    SummaryHistoryViewModel localSummaryHistoryViewModel = this.p1;
    if (localSummaryHistoryViewModel == null) {
      j.t("mViewModel");
    }
    localSummaryHistoryViewModel.p().observe(this, new i(this));
    localSummaryHistoryViewModel.o().observe(this, new j(localSummaryHistoryViewModel, this));
    localSummaryHistoryViewModel.O().observe(this, new k(this));
    localSummaryHistoryViewModel.m().observe(this, new l(this));
    localSummaryHistoryViewModel.P().observe(this, new m(this));
    localSummaryHistoryViewModel.Q().observe(this, new n(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new ViewModelProvider(this).get(SummaryHistoryViewModel.class);
    j.d(paramBundle, "ViewModelProvider(this).…oryViewModel::class.java)");
    paramBundle = (SummaryHistoryViewModel)paramBundle;
    paramBundle.W(true);
    p localp = p.a;
    this.p1 = paramBundle;
    l1();
    n1();
    o1();
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
    if (paramInt == 4)
    {
      paramKeyEvent = this.p1;
      if (paramKeyEvent == null) {
        j.t("mViewModel");
      }
      if (j.a((Boolean)paramKeyEvent.P().getValue(), Boolean.TRUE))
      {
        paramKeyEvent = this.p1;
        if (paramKeyEvent == null) {
          j.t("mViewModel");
        }
        paramKeyEvent.J(false);
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
    if (com.tplink.iot.e.a.c.k.i())
    {
      SummaryHistoryViewModel localSummaryHistoryViewModel = this.p1;
      if (localSummaryHistoryViewModel == null) {
        j.t("mViewModel");
      }
      localSummaryHistoryViewModel.W(true);
    }
  }
  
  public final void p1(boolean paramBoolean)
  {
    SummaryHistoryViewModel localSummaryHistoryViewModel = this.p1;
    if (localSummaryHistoryViewModel == null) {
      j.t("mViewModel");
    }
    localSummaryHistoryViewModel.J(paramBoolean);
  }
  
  public static final class a {}
  
  public static final class b
    implements SummaryDeleteDialogFragment.b
  {
    b(SummaryDeleteDialogFragment paramSummaryDeleteDialogFragment, SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public void a()
    {
      this.a.dismiss();
    }
    
    public void b()
    {
      this.a.dismiss();
      SummaryHistoryActivity.h1(jdField_this).M();
    }
  }
  
  public static final class c
    implements com.scwang.smart.refresh.layout.c.f
  {
    c(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public void a(d paramd, int paramInt1, int paramInt2) {}
    
    public void c(com.scwang.smart.refresh.layout.a.c paramc, boolean paramBoolean) {}
    
    public void d(d paramd, int paramInt1, int paramInt2)
    {
      SummaryHistoryActivity.i1(this.c, false);
    }
    
    public void e(com.scwang.smart.refresh.layout.a.c paramc, int paramInt1, int paramInt2)
    {
      SummaryHistoryActivity.i1(this.c, true);
    }
    
    public void h(com.scwang.smart.refresh.layout.a.f paramf, RefreshState paramRefreshState1, RefreshState paramRefreshState2)
    {
      j.e(paramf, "refreshLayout");
      j.e(paramRefreshState1, "oldState");
      j.e(paramRefreshState2, "newState");
      paramf = SummaryHistoryActivity.h1(this.c);
      boolean bool;
      if ((!paramRefreshState2.isDragging) && (!paramRefreshState2.isReleaseToOpening) && (!paramRefreshState2.isOpening) && (!paramRefreshState2.isHeader) && (!paramRefreshState2.isFooter) && (!paramRefreshState2.isFinishing)) {
        bool = false;
      } else {
        bool = true;
      }
      paramf.b0(bool);
    }
    
    public void l(d paramd, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void m(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "refreshLayout");
      SummaryHistoryActivity.i1(this.c, false);
    }
    
    public void o(d paramd, boolean paramBoolean) {}
    
    public void p(com.scwang.smart.refresh.layout.a.c paramc, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void q(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "refreshLayout");
      SummaryHistoryActivity.i1(this.c, true);
    }
    
    public void r(com.scwang.smart.refresh.layout.a.c paramc, int paramInt1, int paramInt2) {}
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.p1(true);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.p1(false);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (Integer)SummaryHistoryActivity.h1(this.c).V().getValue();
      if (paramView != null)
      {
        SummaryHistoryActivity localSummaryHistoryActivity = this.c;
        j.d(paramView, "it");
        SummaryHistoryActivity.f1(localSummaryHistoryActivity, paramView.intValue());
      }
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryHistoryActivity.e1(this.c);
    }
  }
  
  static final class i<T>
    implements Observer<Boolean>
  {
    i(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      TPSmartRefreshLayout localTPSmartRefreshLayout = SummaryHistoryActivity.g1(this.a);
      if (localTPSmartRefreshLayout.z()) {
        localTPSmartRefreshLayout.q();
      }
      if (localTPSmartRefreshLayout.y()) {
        localTPSmartRefreshLayout.l();
      }
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        s0.l(this.a);
      } else if (s0.j()) {
        s0.g();
      }
    }
  }
  
  static final class j<T>
    implements Observer<Boolean>
  {
    j(SummaryHistoryViewModel paramSummaryHistoryViewModel, SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (s0.j()) {
        s0.g();
      }
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        if (j.a((Boolean)this.a.P().getValue(), Boolean.FALSE)) {
          SummaryHistoryActivity.g1(jdField_this).E(j.a((Boolean)this.a.n().getValue(), Boolean.TRUE));
        }
      }
      else
      {
        paramBoolean = jdField_this;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class k<T>
    implements Observer<Boolean>
  {
    k(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class l<T>
    implements Observer<Boolean>
  {
    l(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        String str = paramBoolean.getString(2131952479);
        j.d(str, "getString(R.string.daily…create_successfully_hint)");
        a.c(paramBoolean, str, true);
      }
      else
      {
        paramBoolean = this.a;
        s0.p(paramBoolean, paramBoolean.getString(2131952834));
      }
    }
  }
  
  static final class m<T>
    implements Observer<Boolean>
  {
    m(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      TPSmartRefreshLayout localTPSmartRefreshLayout = SummaryHistoryActivity.g1(this.a);
      if (localTPSmartRefreshLayout.z()) {
        localTPSmartRefreshLayout.q();
      }
      if (localTPSmartRefreshLayout.y()) {
        localTPSmartRefreshLayout.l();
      }
      localTPSmartRefreshLayout.G(paramBoolean.booleanValue() ^ true);
      localTPSmartRefreshLayout.E(paramBoolean.booleanValue() ^ true);
    }
  }
  
  static final class n<T>
    implements Observer<Boolean>
  {
    n(SummaryHistoryActivity paramSummaryHistoryActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue()) {
        this.a.finish();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\SummaryHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */