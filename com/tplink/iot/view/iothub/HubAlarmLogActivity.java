package com.tplink.iot.view.iothub;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.iothub.HubAlarmLogAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityHubAlarmLogBinding;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.viewmodel.iothub.HubAlarmLogViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import io.reactivex.e0.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class HubAlarmLogActivity
  extends IoTMVVMBaseActivity<ActivityHubAlarmLogBinding>
{
  private HubAlarmLogAdapter p0;
  private final kotlin.f p1 = h.b(new f(this));
  private boolean p2;
  private MenuItem p3;
  
  private final void v1()
  {
    y1().h().r(io.reactivex.d0.b.a.a()).l(new a(this)).i(b.a).j(new c(this)).y();
  }
  
  private final void w1()
  {
    ((ActivityHubAlarmLogBinding)f1()).d.q();
    ((ActivityHubAlarmLogBinding)f1()).d.l();
    s0.n(this, 2131952444);
  }
  
  private final void x1()
  {
    ((ActivityHubAlarmLogBinding)f1()).d.q();
    ((ActivityHubAlarmLogBinding)f1()).d.l();
  }
  
  private final HubAlarmLogViewModel y1()
  {
    return (HubAlarmLogViewModel)this.p1.getValue();
  }
  
  private final void z1()
  {
    com.tplink.iot.Utils.extension.e.r(this, new g(this));
  }
  
  public int e1()
  {
    return 2131558539;
  }
  
  public void j1()
  {
    b1(2131951795);
    this.p0 = new HubAlarmLogAdapter(this, new ArrayList());
    Object localObject = ((ActivityHubAlarmLogBinding)f1()).c;
    j.d(localObject, "mBinding.alarmLogList");
    ((RecyclerView)localObject).setAdapter(this.p0);
    localObject = ((ActivityHubAlarmLogBinding)f1()).c;
    j.d(localObject, "mBinding.alarmLogList");
    localObject = ((RecyclerView)localObject).getItemAnimator();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
    ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    localObject = ((ActivityHubAlarmLogBinding)f1()).d;
    ((SmartRefreshLayout)localObject).Q(new SmartRefreshHeader(this));
    ((SmartRefreshLayout)localObject).O(new SmartRefreshFooter(this));
    ((SmartRefreshLayout)localObject).G(true);
    ((SmartRefreshLayout)localObject).E(true);
    ((SmartRefreshLayout)localObject).F(false);
    ((SmartRefreshLayout)localObject).N(new d(this));
    ((SmartRefreshLayout)localObject).L(new e(this));
  }
  
  public void l1() {}
  
  public void m1()
  {
    y1().i().observe(this, new h(this));
    y1().k().observe(this, new i(this));
    y1().m().observe(this, new j(this));
    y1().o();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623950, paramMenu);
    MenuItem localMenuItem;
    if (paramMenu != null) {
      localMenuItem = paramMenu.findItem(2131361884);
    } else {
      localMenuItem = null;
    }
    this.p3 = localMenuItem;
    if (localMenuItem != null)
    {
      HubAlarmLogAdapter localHubAlarmLogAdapter = this.p0;
      boolean bool = false;
      int i;
      if (localHubAlarmLogAdapter != null) {
        i = localHubAlarmLogAdapter.getItemCount();
      } else {
        i = 0;
      }
      if (i != 0) {
        bool = true;
      }
      localMenuItem.setVisible(bool);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361884) {
      z1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.p2)
    {
      this.p2 = true;
      ((ActivityHubAlarmLogBinding)f1()).d.j();
    }
  }
  
  static final class a<T>
    implements io.reactivex.g0.g<c>
  {
    a(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void a(c paramc)
    {
      s0.l(this.c);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    public static final b a = new b();
    
    public final void run() {}
  }
  
  static final class c<T>
    implements io.reactivex.g0.g<Throwable>
  {
    c(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      s0.n(this.c, 2131952444);
    }
  }
  
  static final class d
    implements com.scwang.smart.refresh.layout.c.g
  {
    d(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void m(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "it");
      HubAlarmLogActivity.u1(this.c).s();
    }
  }
  
  static final class e
    implements com.scwang.smart.refresh.layout.c.e
  {
    e(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void q(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "it");
      HubAlarmLogActivity.u1(this.c).p();
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<HubAlarmLogViewModel>
  {
    f(HubAlarmLogActivity paramHubAlarmLogActivity)
    {
      super();
    }
    
    public final HubAlarmLogViewModel a()
    {
      HubAlarmLogActivity localHubAlarmLogActivity = this.c;
      return (HubAlarmLogViewModel)new ViewModelProvider(localHubAlarmLogActivity, new IoTViewModelFactory(localHubAlarmLogActivity, HubAlarmLogActivity.t1(localHubAlarmLogActivity))).get(HubAlarmLogViewModel.class);
    }
  }
  
  static final class g
    extends Lambda
    implements l<com.tplink.iot.Utils.extension.f, p>
  {
    g(HubAlarmLogActivity paramHubAlarmLogActivity)
    {
      super();
    }
    
    public final void a(com.tplink.iot.Utils.extension.f paramf)
    {
      j.e(paramf, "$receiver");
      paramf.h(2131953654);
      com.tplink.iot.Utils.extension.f.e(paramf, 2131952391, 2131099804, null, 4, null);
      paramf.f(2131952395, 2131099812, new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.a<p>
    {
      a(HubAlarmLogActivity.g paramg)
      {
        super();
      }
      
      public final void a()
      {
        HubAlarmLogActivity.n1(this.c.c);
      }
    }
  }
  
  static final class h<T>
    implements Observer<List<com.tplink.iot.adapter.iothub.a>>
  {
    h(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void a(List<com.tplink.iot.adapter.iothub.a> paramList)
    {
      Object localObject = HubAlarmLogActivity.s1(this.a);
      int i = 0;
      int j;
      if (localObject != null)
      {
        if ((paramList != null) && (!paramList.isEmpty())) {
          j = 0;
        } else {
          j = 1;
        }
        ((MenuItem)localObject).setVisible(0x1 ^ j);
      }
      if (paramList != null)
      {
        localObject = HubAlarmLogActivity.q1(this.a);
        if (localObject != null) {
          ((GeneralAdapter)localObject).x(paramList);
        }
        localObject = HubAlarmLogActivity.r1(this.a).f;
        j.d(localObject, "mBinding.tvEmptyActions");
        if (paramList.isEmpty()) {
          j = i;
        } else {
          j = 8;
        }
        ((TextView)localObject).setVisibility(j);
      }
    }
  }
  
  static final class i<T>
    implements Observer<Boolean>
  {
    i(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      TPSmartRefreshLayout localTPSmartRefreshLayout = HubAlarmLogActivity.r1(this.a).d;
      boolean bool;
      if (paramBoolean != null) {
        bool = paramBoolean.booleanValue();
      } else {
        bool = false;
      }
      localTPSmartRefreshLayout.E(bool);
    }
  }
  
  static final class j<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    j(HubAlarmLogActivity paramHubAlarmLogActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if (parama != null)
        {
          j.d(parama, "success");
          if (parama.booleanValue()) {
            HubAlarmLogActivity.p1(this.a);
          } else {
            HubAlarmLogActivity.o1(this.a);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\HubAlarmLogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */