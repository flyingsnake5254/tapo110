package com.tplink.iot.devices.lightstrip.view.effects;

import android.widget.SeekBar;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentColorTemperatureSettingBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.BrightnessSeekBar.b;
import com.tplink.iot.widget.colorbulb.ColorTempWrapView;
import com.tplink.iot.widget.colorbulb.c.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class ColorTemperatureSettingFragment
  extends IoTMVVMBaseFragment<FragmentColorTemperatureSettingBinding>
{
  public static final a p1 = new a(null);
  private final f H3 = h.b(new e(this));
  private b I3;
  private com.tplink.iot.g.b.a.c J3;
  private int K3;
  private io.reactivex.e0.c L3;
  private HashMap M3;
  private final List<Runnable> p2 = new ArrayList();
  private final f p3 = h.b(new f(this));
  
  private final void d1()
  {
    com.tplink.iot.g.b.a.c localc = this.J3;
    if (localc != null) {
      localc.V(0, 0, g1(), h1());
    }
  }
  
  private final void f1()
  {
    b.d.w.c.a.n("ColorTempSettingF", "executeViewRunQueue");
    if ((this.p2.isEmpty() ^ true))
    {
      Iterator localIterator = this.p2.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.p2.clear();
  }
  
  private final BrightnessSeekBar j1()
  {
    return (BrightnessSeekBar)this.H3.getValue();
  }
  
  private final ColorTempWrapView k1()
  {
    return (ColorTempWrapView)this.p3.getValue();
  }
  
  private final void n1(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      k1().setColorTemp(paramLightStateBean.getColorTemp());
      j1().e(paramLightStateBean.getBrightness());
    }
  }
  
  private final void q1()
  {
    this.K3 = g1();
    this.L3 = q.a0(500L, 500L, TimeUnit.MILLISECONDS).l0(io.reactivex.d0.b.a.a()).E(new j(this)).F0();
  }
  
  private final void r1()
  {
    io.reactivex.e0.c localc = this.L3;
    if ((localc != null) && (!localc.isDisposed()))
    {
      localc = this.L3;
      if (localc != null) {
        localc.dispose();
      }
      this.L3 = null;
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.M3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558914;
  }
  
  public void N0()
  {
    k1().setOnSampleLightStateCallback(new c(this));
    j1().setProgress(100);
    j1().setOnSeekbarChangeListener(new d(this));
    f1();
  }
  
  public final void e1()
  {
    if (V0(this))
    {
      b.d.w.c.a.n("ColorTempSettingF", "executeOrPostViewRunnable directly");
      U0(this).setSelectedStatus(false);
    }
    else
    {
      X0(this).add(new b(this));
    }
  }
  
  public final int g1()
  {
    int i;
    if (V0(this)) {
      i = j1().getProgress();
    } else {
      i = 100;
    }
    return i;
  }
  
  public final int h1()
  {
    int i;
    if (V0(this)) {
      i = k1().getColorTemp();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final LightStateBean i1()
  {
    LightStateBean localLightStateBean;
    if (V0(this)) {
      localLightStateBean = new LightStateBean(0, 0, k1().getColorTemp(), j1().getProgress());
    } else {
      localLightStateBean = new LightStateBean(0, 0, 0, 100);
    }
    return localLightStateBean;
  }
  
  public final void l1(final int paramInt1, final int paramInt2)
  {
    if (V0(this))
    {
      b.d.w.c.a.n("ColorTempSettingF", "executeOrPostViewRunnable directly");
      U0(this).d(paramInt1, paramInt2);
    }
    else
    {
      X0(this).add(new g(this, paramInt1, paramInt2));
    }
  }
  
  public final void m1(final LightStateBean paramLightStateBean)
  {
    if (V0(this))
    {
      b.d.w.c.a.n("ColorTempSettingF", "executeOrPostViewRunnable directly");
      Z0(this, paramLightStateBean);
    }
    else
    {
      X0(this).add(new h(this, paramLightStateBean));
    }
  }
  
  public final void o1(final b paramb)
  {
    j.e(paramb, "listener");
    this.I3 = paramb;
    if (V0(this))
    {
      b.d.w.c.a.n("ColorTempSettingF", "executeOrPostViewRunnable directly");
      U0(this).setOnLightTypeSelectListener(paramb);
    }
    else
    {
      X0(this).add(new i(this, paramb));
    }
  }
  
  public void onStop()
  {
    super.onStop();
    r1();
  }
  
  public final void p1(com.tplink.iot.g.b.a.c paramc)
  {
    j.e(paramc, "listener");
    this.J3 = paramc;
  }
  
  public static final class a {}
  
  public static final class b
    implements Runnable
  {
    public b(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment) {}
    
    public final void run()
    {
      ColorTemperatureSettingFragment.U0(this.c).setSelectedStatus(false);
    }
  }
  
  static final class c
    implements com.tplink.iot.widget.colorbulb.c.c
  {
    c(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment) {}
    
    public final void b(int paramInt1, int paramInt2, int paramInt3)
    {
      com.tplink.iot.g.b.a.c localc = ColorTemperatureSettingFragment.Y0(this.c);
      if (localc != null) {
        localc.V(paramInt2, paramInt3, this.c.g1(), paramInt1);
      }
    }
  }
  
  public static final class d
    implements BrightnessSeekBar.b
  {
    d(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment) {}
    
    public void a(boolean paramBoolean) {}
    
    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      ColorTemperatureSettingFragment.b1(this.a);
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      ColorTemperatureSettingFragment.c1(this.a);
      ColorTemperatureSettingFragment.S0(this.a);
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<BrightnessSeekBar>
  {
    e(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment)
    {
      super();
    }
    
    public final BrightnessSeekBar a()
    {
      BrightnessSeekBar localBrightnessSeekBar = ColorTemperatureSettingFragment.T0(this.c).c;
      j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
      return localBrightnessSeekBar;
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<ColorTempWrapView>
  {
    f(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment)
    {
      super();
    }
    
    public final ColorTempWrapView a()
    {
      ColorTempWrapView localColorTempWrapView = ColorTemperatureSettingFragment.T0(this.c).d;
      j.d(localColorTempWrapView, "mBinding.colorTemperatureWrapView");
      return localColorTempWrapView;
    }
  }
  
  public static final class g
    implements Runnable
  {
    public g(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      ColorTemperatureSettingFragment.U0(this.c).d(paramInt1, paramInt2);
    }
  }
  
  public static final class h
    implements Runnable
  {
    public h(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment, LightStateBean paramLightStateBean) {}
    
    public final void run()
    {
      ColorTemperatureSettingFragment.Z0(this.c, paramLightStateBean);
    }
  }
  
  public static final class i
    implements Runnable
  {
    public i(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment, b paramb) {}
    
    public final void run()
    {
      ColorTemperatureSettingFragment.U0(this.c).setOnLightTypeSelectListener(paramb);
    }
  }
  
  static final class j<T>
    implements g<Long>
  {
    j(ColorTemperatureSettingFragment paramColorTemperatureSettingFragment) {}
    
    public final void a(Long paramLong)
    {
      int i = this.c.g1();
      if (ColorTemperatureSettingFragment.W0(this.c) != i)
      {
        ColorTemperatureSettingFragment.a1(this.c, i);
        ColorTemperatureSettingFragment.S0(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\ColorTemperatureSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */