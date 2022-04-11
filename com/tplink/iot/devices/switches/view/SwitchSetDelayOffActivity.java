package com.tplink.iot.devices.switches.view;

import android.app.Activity;
import android.view.MenuItem;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySwitchSetDelayOffBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.switches.adapter.SwitchDelayOffTimeAdapter;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionStateBean;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SwitchSetDelayOffActivity
  extends IoTMVVMBaseActivity<ActivitySwitchSetDelayOffBinding>
{
  private final f p0 = h.b(new c(this));
  private final f p1 = h.b(new b(this));
  private DelayActionInfoBean p2;
  private boolean p3;
  
  private final DelayActionInfoBean t1()
  {
    boolean bool = v1().j().get();
    int i;
    if (bool) {
      i = ((Number)u1().t()).intValue();
    } else {
      i = 0;
    }
    return new DelayActionInfoBean(new DelayActionStateBean(false), bool, i);
  }
  
  private final SwitchDelayOffTimeAdapter u1()
  {
    return (SwitchDelayOffTimeAdapter)this.p1.getValue();
  }
  
  private final SwitchSetDelayOffViewModel v1()
  {
    return (SwitchSetDelayOffViewModel)this.p0.getValue();
  }
  
  private final void w1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
  {
    
    if (parama != null)
    {
      parama = (Boolean)parama.a();
      if (parama != null)
      {
        j.d(parama, "success");
        if (parama.booleanValue()) {
          finish();
        } else {
          e.d(this, new a(this));
        }
      }
    }
  }
  
  private final boolean x1(DelayActionInfoBean paramDelayActionInfoBean)
  {
    DelayActionInfoBean localDelayActionInfoBean = this.p2;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localDelayActionInfoBean != null) {
      if ((localDelayActionInfoBean.getEnabled()) || (paramDelayActionInfoBean.getEnabled()))
      {
        bool2 = bool1;
        if (localDelayActionInfoBean.getEnabled() == paramDelayActionInfoBean.getEnabled())
        {
          bool2 = bool1;
          if (localDelayActionInfoBean.getTime() != paramDelayActionInfoBean.getTime()) {}
        }
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private final void y1()
  {
    DelayActionInfoBean localDelayActionInfoBean = t1();
    if (x1(localDelayActionInfoBean)) {
      localDelayActionInfoBean = null;
    }
    if (localDelayActionInfoBean != null)
    {
      e.m(this, null, 1, null);
      v1().k(localDelayActionInfoBean);
    }
    else
    {
      finish();
    }
  }
  
  private final void z1(DelayActionInfoBean paramDelayActionInfoBean)
  {
    v1().j().set(paramDelayActionInfoBean.getEnabled());
    if (paramDelayActionInfoBean.getEnabled()) {
      u1().B(paramDelayActionInfoBean.getTime());
    }
  }
  
  public int e1()
  {
    return 2131558686;
  }
  
  public void j1()
  {
    b1(2131954176);
    RecyclerView localRecyclerView = ((ActivitySwitchSetDelayOffBinding)f1()).d;
    j.d(localRecyclerView, "mBinding.rvDelayTime");
    localRecyclerView.setAdapter(u1());
  }
  
  public void l1()
  {
    ((ActivitySwitchSetDelayOffBinding)f1()).h(v1());
  }
  
  public void m1()
  {
    v1().g().observe(this, new d(this));
    v1().h().observe(this, new e(this));
  }
  
  public void onBackPressed()
  {
    y1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    boolean bool;
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      bool = true;
    }
    else
    {
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    return bool;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<p>
  {
    a(SwitchSetDelayOffActivity paramSwitchSetDelayOffActivity)
    {
      super();
    }
    
    public final void a()
    {
      this.c.finish();
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<SwitchDelayOffTimeAdapter>
  {
    b(SwitchSetDelayOffActivity paramSwitchSetDelayOffActivity)
    {
      super();
    }
    
    public final SwitchDelayOffTimeAdapter a()
    {
      return new SwitchDelayOffTimeAdapter(this.c);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<SwitchSetDelayOffViewModel>
  {
    c(SwitchSetDelayOffActivity paramSwitchSetDelayOffActivity)
    {
      super();
    }
    
    public final SwitchSetDelayOffViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, SwitchSetDelayOffActivity.n1((SwitchSetDelayOffActivity)localObject))).get(SwitchSetDelayOffViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (SwitchSetDelayOffViewModel)localObject;
    }
  }
  
  static final class d<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    d(SwitchSetDelayOffActivity paramSwitchSetDelayOffActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      SwitchSetDelayOffActivity.p1(this.a, parama);
    }
  }
  
  static final class e<T>
    implements Observer<DelayActionInfoBean>
  {
    e(SwitchSetDelayOffActivity paramSwitchSetDelayOffActivity) {}
    
    public final void a(DelayActionInfoBean paramDelayActionInfoBean)
    {
      if (!SwitchSetDelayOffActivity.o1(this.a))
      {
        SwitchSetDelayOffActivity.q1(this.a, true);
        SwitchSetDelayOffActivity.r1(this.a, paramDelayActionInfoBean);
        if (paramDelayActionInfoBean != null) {
          SwitchSetDelayOffActivity.s1(this.a, paramDelayActionInfoBean);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\view\SwitchSetDelayOffActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */