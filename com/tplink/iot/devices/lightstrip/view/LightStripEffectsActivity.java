package com.tplink.iot.devices.lightstrip.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripEffectsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.view.effects.LightStripLightingEffectFragment;
import com.tplink.iot.devices.lightstrip.view.effects.LightStripLightingEffectFragment.a;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripEffectsViewModel;
import com.tplink.iot.g.b.b.c;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import io.reactivex.q;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;

public final class LightStripEffectsActivity
  extends IoTMVVMBaseActivity<ActivityLightStripEffectsBinding>
  implements com.tplink.iot.g.b.a.b
{
  private final f p0 = h.b(new c(this));
  private final f p1 = h.b(new d(this));
  private MenuItem p2;
  
  private final void q1(String paramString)
  {
    t1().i(paramString).R(new a(this)).y();
  }
  
  private final void r1(String paramString)
  {
    t1().l(paramString).R(new b(this)).y();
  }
  
  private final LightStripLightingEffectFragment s1()
  {
    return (LightStripLightingEffectFragment)this.p0.getValue();
  }
  
  private final LightStripEffectsViewModel t1()
  {
    return (LightStripEffectsViewModel)this.p1.getValue();
  }
  
  private final void u1(int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 200)
      {
        if (paramInt == 300) {
          com.tplink.iot.Utils.extension.e.e(this, null, 1, null);
        }
      }
      else {
        com.tplink.iot.Utils.extension.e.g(this, null, 1, null);
      }
    }
    else {
      com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
    }
  }
  
  public void C(com.tplink.iot.g.b.b.a parama)
  {
    kotlin.jvm.internal.j.e(parama, "data");
    parama = parama.e();
    if (parama != null) {
      q1(parama);
    }
  }
  
  public int e1()
  {
    return 2131558563;
  }
  
  public void j1()
  {
    b1(2131952944);
    getSupportFragmentManager().beginTransaction().add(2131362690, s1(), null).commit();
    s1().v1(this);
  }
  
  public void m0(c paramc)
  {
    kotlin.jvm.internal.j.e(paramc, "data");
    t1().o(paramc.e());
  }
  
  public void m1()
  {
    t1().h().observe(this, new e(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623959, paramMenu);
    if (paramMenu != null) {
      paramMenu = paramMenu.findItem(2131361893);
    } else {
      paramMenu = null;
    }
    this.p2 = paramMenu;
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    kotlin.jvm.internal.j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361893)
    {
      boolean bool = s1().j1() ^ true;
      paramMenuItem = this.p2;
      if (paramMenuItem != null)
      {
        int i;
        if (bool) {
          i = 2131952405;
        } else {
          i = 2131952406;
        }
        paramMenuItem.setTitle(i);
      }
      s1().s1(bool);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void p0(com.tplink.iot.g.b.b.d paramd)
  {
    kotlin.jvm.internal.j.e(paramd, "data");
    if (paramd.i())
    {
      paramd = paramd.c();
      if (paramd != null) {
        t1().o(paramd);
      }
    }
    else
    {
      paramd = paramd.f();
      if (paramd != null) {
        r1(paramd);
      }
    }
  }
  
  public void t0(com.tplink.iot.g.b.b.b paramb)
  {
    kotlin.jvm.internal.j.e(paramb, "data");
    paramb = paramb.e();
    if (paramb != null) {
      q1(paramb);
    }
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<CustomizedEffect, io.reactivex.e>
  {
    a(LightStripEffectsActivity paramLightStripEffectsActivity) {}
    
    public final io.reactivex.e a(CustomizedEffect paramCustomizedEffect)
    {
      kotlin.jvm.internal.j.e(paramCustomizedEffect, "it");
      paramCustomizedEffect = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.b(paramCustomizedEffect, LightStripEffectsActivity.o1(this.c).n(), new a(LightStripEffectsActivity.o1(this.c))));
      return LightStripEffectsActivity.o1(this.c).p(paramCustomizedEffect);
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<PredefinedEffect, io.reactivex.e>
  {
    b(LightStripEffectsActivity paramLightStripEffectsActivity) {}
    
    public final io.reactivex.e a(PredefinedEffect paramPredefinedEffect)
    {
      kotlin.jvm.internal.j.e(paramPredefinedEffect, "it");
      paramPredefinedEffect = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.c(paramPredefinedEffect, LightStripEffectsActivity.o1(this.c).n()));
      return LightStripEffectsActivity.o1(this.c).p(paramPredefinedEffect);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<LightStripLightingEffectFragment>
  {
    c(LightStripEffectsActivity paramLightStripEffectsActivity)
    {
      super();
    }
    
    public final LightStripLightingEffectFragment a()
    {
      return LightStripLightingEffectFragment.p1.a(LightStripEffectsActivity.n1(this.c), 0);
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<LightStripEffectsViewModel>
  {
    d(LightStripEffectsActivity paramLightStripEffectsActivity)
    {
      super();
    }
    
    public final LightStripEffectsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, LightStripEffectsActivity.n1((LightStripEffectsActivity)localObject))).get(LightStripEffectsViewModel.class);
      kotlin.jvm.internal.j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightStripEffectsViewModel)localObject;
    }
  }
  
  static final class e<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    e(LightStripEffectsActivity paramLightStripEffectsActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null)
      {
        parama = (Integer)parama.a();
        if (parama != null) {
          LightStripEffectsActivity.p1(this.a, parama.intValue());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripEffectsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */