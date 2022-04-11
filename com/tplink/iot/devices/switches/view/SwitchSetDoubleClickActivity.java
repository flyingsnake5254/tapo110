package com.tplink.iot.devices.switches.view;

import android.app.Activity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import androidx.annotation.LayoutRes;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySwitchSetDoubleClickBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDoubleClickViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SwitchSetDoubleClickActivity
  extends IoTMVVMBaseActivity<ActivitySwitchSetDoubleClickBinding>
{
  private final kotlin.f p0 = h.b(new c(this));
  private DoubleClickInfoBean p1;
  private boolean p2;
  
  private final void A1(DoubleClickInfoBean paramDoubleClickInfoBean)
  {
    w1().k().set(paramDoubleClickInfoBean.getEnable());
    if (paramDoubleClickInfoBean.getEnable()) {
      w1().i().set(paramDoubleClickInfoBean.getInterval() - 100);
    }
  }
  
  private final DoubleClickInfoBean v1()
  {
    boolean bool = w1().k().get();
    int i;
    if (w1().k().get()) {
      i = w1().i().get() + 100;
    } else {
      i = 0;
    }
    return new DoubleClickInfoBean(bool, i);
  }
  
  private final SwitchSetDoubleClickViewModel w1()
  {
    return (SwitchSetDoubleClickViewModel)this.p0.getValue();
  }
  
  private final void x1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
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
  
  private final void y1()
  {
    DoubleClickInfoBean localDoubleClickInfoBean = v1();
    if (!(j.a(localDoubleClickInfoBean, this.p1) ^ true)) {
      localDoubleClickInfoBean = null;
    }
    if (localDoubleClickInfoBean != null)
    {
      e.m(this, null, 1, null);
      w1().l(localDoubleClickInfoBean);
    }
    else
    {
      finish();
    }
  }
  
  private final void z1()
  {
    if (!w1().k().get()) {
      e.r(this, new d(this));
    }
  }
  
  @LayoutRes
  public int e1()
  {
    return 2131558687;
  }
  
  public void j1()
  {
    b1(2131954089);
    ((ActivitySwitchSetDoubleClickBinding)f1()).d.setOnSwitchCheckedChangeListener(new b(this));
  }
  
  public void l1()
  {
    ((ActivitySwitchSetDoubleClickBinding)f1()).h(w1());
  }
  
  public void m1()
  {
    w1().g().observe(this, new e(this));
    w1().h().observe(this, new f(this));
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
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<p>
  {
    a(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity)
    {
      super();
    }
    
    public final void a()
    {
      this.c.finish();
    }
  }
  
  static final class b
    implements TPSwitchCompat.a
  {
    b(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        SwitchSetDoubleClickActivity.p1(this.a).k().set(paramBoolean1);
        SwitchSetDoubleClickActivity.t1(this.a);
      }
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<SwitchSetDoubleClickViewModel>
  {
    c(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity)
    {
      super();
    }
    
    public final SwitchSetDoubleClickViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, SwitchSetDoubleClickActivity.n1((SwitchSetDoubleClickActivity)localObject))).get(SwitchSetDoubleClickViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (SwitchSetDoubleClickViewModel)localObject;
    }
  }
  
  static final class d
    extends Lambda
    implements l<com.tplink.iot.Utils.extension.f, p>
  {
    d(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity)
    {
      super();
    }
    
    public final void a(com.tplink.iot.Utils.extension.f paramf)
    {
      j.e(paramf, "$receiver");
      paramf.h(2131954177);
      paramf.d(2131952391, paramf.a(), new a(this));
      com.tplink.iot.Utils.extension.f.g(paramf, 2131954367, paramf.c(), null, 4, null);
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.a<p>
    {
      a(SwitchSetDoubleClickActivity.d paramd)
      {
        super();
      }
      
      public final void a()
      {
        SwitchSetDoubleClickActivity.p1(this.c.c).k().set(true);
      }
    }
  }
  
  static final class e<T>
    implements Observer<DoubleClickInfoBean>
  {
    e(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity) {}
    
    public final void a(DoubleClickInfoBean paramDoubleClickInfoBean)
    {
      if (!SwitchSetDoubleClickActivity.o1(this.a))
      {
        SwitchSetDoubleClickActivity.r1(this.a, true);
        SwitchSetDoubleClickActivity.s1(this.a, paramDoubleClickInfoBean);
        if (paramDoubleClickInfoBean != null) {
          SwitchSetDoubleClickActivity.u1(this.a, paramDoubleClickInfoBean);
        }
      }
    }
  }
  
  static final class f<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    f(SwitchSetDoubleClickActivity paramSwitchSetDoubleClickActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      SwitchSetDoubleClickActivity.q1(this.a, parama);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\view\SwitchSetDoubleClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */