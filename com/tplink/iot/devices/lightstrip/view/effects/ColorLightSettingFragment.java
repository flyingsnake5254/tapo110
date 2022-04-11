package com.tplink.iot.devices.lightstrip.view.effects;

import android.widget.SeekBar;
import androidx.annotation.LayoutRes;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentColorLightSettingBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.BrightnessSeekBar.b;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;
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

public final class ColorLightSettingFragment
  extends IoTMVVMBaseFragment<FragmentColorLightSettingBinding>
{
  public static final a p1 = new a(null);
  private final f H3 = h.b(new e(this));
  private com.tplink.iot.g.b.a.c I3;
  private b J3;
  private int K3;
  private io.reactivex.e0.c L3;
  private HashMap M3;
  private final List<Runnable> p2 = new ArrayList();
  private final f p3 = h.b(new f(this));
  
  private final void d1()
  {
    com.tplink.iot.g.b.a.c localc = this.I3;
    if (localc != null) {
      localc.V(h1(), l1(), g1(), 0);
    }
  }
  
  private final void f1()
  {
    b.d.w.c.a.n("ColorLightSettingF", "executeViewRunQueue");
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
  
  private final ColorPlateWrapView k1()
  {
    return (ColorPlateWrapView)this.p3.getValue();
  }
  
  private final void n1(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      int i = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramLightStateBean.getHue(), paramLightStateBean.getSaturation(), 100).g();
      k1().b(i, paramLightStateBean.getHue(), paramLightStateBean.getSaturation());
      j1().e(paramLightStateBean.getBrightness());
    }
  }
  
  private final void q1()
  {
    this.K3 = g1();
    this.L3 = q.a0(500L, 500L, TimeUnit.MILLISECONDS).l0(io.reactivex.d0.b.a.a()).E(new i(this)).F0();
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
  
  @LayoutRes
  public int I0()
  {
    return 2131558912;
  }
  
  public void N0()
  {
    super.N0();
    k1().setOnSampleLightStateCallback(new c(this));
    j1().setProgress(100);
    j1().setOnSeekbarChangeListener(new d(this));
    f1();
  }
  
  public final void e1()
  {
    if (W0(this))
    {
      b.d.w.c.a.n("ColorLightSettingF", "executeOrPostViewRunnable directly");
      V0(this).setSelectedStatus(false);
    }
    else
    {
      Y0(this).add(new b(this));
    }
  }
  
  public final int g1()
  {
    int i;
    if (W0(this)) {
      i = j1().getProgress();
    } else {
      i = 100;
    }
    return i;
  }
  
  public final int h1()
  {
    int i;
    if (W0(this)) {
      i = k1().getHue();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final LightStateBean i1()
  {
    LightStateBean localLightStateBean;
    if (W0(this)) {
      localLightStateBean = new LightStateBean(k1().getHue(), k1().getSat(), 0, j1().getProgress());
    } else {
      localLightStateBean = new LightStateBean(0, 0, 0, 100);
    }
    return localLightStateBean;
  }
  
  public final int l1()
  {
    int i;
    if (W0(this)) {
      i = k1().getSat();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void m1(final LightStateBean paramLightStateBean)
  {
    if (W0(this))
    {
      b.d.w.c.a.n("ColorLightSettingF", "executeOrPostViewRunnable directly");
      Z0(this, paramLightStateBean);
    }
    else
    {
      Y0(this).add(new g(this, paramLightStateBean));
    }
  }
  
  public final void o1(final b paramb)
  {
    j.e(paramb, "listener");
    this.J3 = paramb;
    if (W0(this))
    {
      b.d.w.c.a.n("ColorLightSettingF", "executeOrPostViewRunnable directly");
      V0(this).setOnLightTypeSelectListener(paramb);
    }
    else
    {
      Y0(this).add(new h(this, paramb));
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
    this.I3 = paramc;
  }
  
  public static final class a {}
  
  public static final class b
    implements Runnable
  {
    public b(ColorLightSettingFragment paramColorLightSettingFragment) {}
    
    public final void run()
    {
      ColorLightSettingFragment.V0(this.c).setSelectedStatus(false);
    }
  }
  
  static final class c
    implements com.tplink.iot.widget.colorbulb.c.c
  {
    c(ColorLightSettingFragment paramColorLightSettingFragment) {}
    
    public final void b(int paramInt1, int paramInt2, int paramInt3)
    {
      com.tplink.iot.g.b.a.c localc = ColorLightSettingFragment.U0(this.c);
      if (localc != null) {
        localc.V(paramInt2, paramInt3, this.c.g1(), 0);
      }
    }
  }
  
  public static final class d
    implements BrightnessSeekBar.b
  {
    d(ColorLightSettingFragment paramColorLightSettingFragment) {}
    
    public void a(boolean paramBoolean) {}
    
    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      ColorLightSettingFragment.b1(this.a);
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      ColorLightSettingFragment.c1(this.a);
      ColorLightSettingFragment.S0(this.a);
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<BrightnessSeekBar>
  {
    e(ColorLightSettingFragment paramColorLightSettingFragment)
    {
      super();
    }
    
    public final BrightnessSeekBar a()
    {
      BrightnessSeekBar localBrightnessSeekBar = ColorLightSettingFragment.T0(this.c).c;
      j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
      return localBrightnessSeekBar;
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<ColorPlateWrapView>
  {
    f(ColorLightSettingFragment paramColorLightSettingFragment)
    {
      super();
    }
    
    public final ColorPlateWrapView a()
    {
      ColorPlateWrapView localColorPlateWrapView = ColorLightSettingFragment.T0(this.c).d;
      j.d(localColorPlateWrapView, "mBinding.colorPlateWrapView");
      return localColorPlateWrapView;
    }
  }
  
  public static final class g
    implements Runnable
  {
    public g(ColorLightSettingFragment paramColorLightSettingFragment, LightStateBean paramLightStateBean) {}
    
    public final void run()
    {
      ColorLightSettingFragment.Z0(this.c, paramLightStateBean);
    }
  }
  
  public static final class h
    implements Runnable
  {
    public h(ColorLightSettingFragment paramColorLightSettingFragment, b paramb) {}
    
    public final void run()
    {
      ColorLightSettingFragment.V0(this.c).setOnLightTypeSelectListener(paramb);
    }
  }
  
  static final class i<T>
    implements g<Long>
  {
    i(ColorLightSettingFragment paramColorLightSettingFragment) {}
    
    public final void a(Long paramLong)
    {
      int i = this.c.g1();
      if (ColorLightSettingFragment.X0(this.c) != i)
      {
        ColorLightSettingFragment.a1(this.c, i);
        ColorLightSettingFragment.S0(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\ColorLightSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */