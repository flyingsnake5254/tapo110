package com.tplink.iot.devices.lightstrip.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy;
import com.tplink.iot.databinding.FragmentLightStripLightSettingsDialogBinding;
import com.tplink.iot.devicecommon.view.bottomsheet.IoTMVVMBottomSheetFragment;
import com.tplink.iot.devices.lightstrip.view.effects.ColorLightSettingFragment;
import com.tplink.iot.devices.lightstrip.view.effects.ColorTemperatureSettingFragment;
import com.tplink.iot.devices.lightstrip.view.effects.LightStripLightingEffectFragment;
import com.tplink.iot.devices.lightstrip.view.effects.LightStripLightingEffectFragment.a;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripLightSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import io.reactivex.e;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

public final class LightStripLightSettingsFragment
  extends IoTMVVMBottomSheetFragment<FragmentLightStripLightSettingsDialogBinding>
  implements com.tplink.iot.g.b.a.b, com.tplink.iot.widget.colorbulb.c.b, com.tplink.iot.g.b.a.c
{
  public static final a q = new a(null);
  private int H3 = -1;
  private int I3 = -1;
  private int J3 = -1;
  private LightStateBean K3;
  private b L3;
  private final f M3 = h.b(new i(this));
  private HashMap N3;
  private ColorLightSettingFragment p0;
  private LightStripLightingEffectFragment p1;
  private Fragment[] p2;
  private int p3 = -1;
  private int x = 2;
  private boolean y = true;
  private ColorTemperatureSettingFragment z;
  
  private final void T0(String paramString)
  {
    X0().g(paramString).R(new d(this)).y();
  }
  
  private final void U0(String paramString)
  {
    X0().j(paramString).R(new e(this)).y();
  }
  
  private final boolean W0()
  {
    int i = this.x;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private final LightStripLightSettingsViewModel X0()
  {
    return (LightStripLightSettingsViewModel)this.M3.getValue();
  }
  
  private final void Y0()
  {
    dismissAllowingStateLoss();
  }
  
  private final void Z0()
  {
    b localb = this.L3;
    if (localb != null) {
      localb.I(V0());
    }
    dismissAllowingStateLoss();
  }
  
  private final void a1()
  {
    boolean bool = com.tplink.iot.g.b.c.c.l(X0().f(), X0().m());
    LightStateBean localLightStateBean = this.K3;
    if (localLightStateBean != null) {
      if (localLightStateBean.getLightingEffectData() == null)
      {
        if (localLightStateBean.getColorTemp() == 0) {
          c1(1, localLightStateBean);
        } else if (bool) {
          c1(2, localLightStateBean);
        } else {
          c1(0, localLightStateBean);
        }
      }
      else {
        c1(2, localLightStateBean);
      }
    }
  }
  
  private final void b1(int paramInt)
  {
    if (paramInt != -1) {
      ((FragmentLightStripLightSettingsDialogBinding)H0()).d.setCurrentItem(paramInt, false);
    }
  }
  
  private final void c1(int paramInt, LightStateBean paramLightStateBean)
  {
    this.J3 = paramInt;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          b1(this.I3);
          localObject = this.p1;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mLightStripLightingEffectFragment");
          }
          ((LightStripLightingEffectFragment)localObject).t1(paramLightStateBean);
        }
      }
      else
      {
        b1(this.H3);
        localObject = this.p0;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mColorLightSettingFragment");
        }
        ((ColorLightSettingFragment)localObject).m1(paramLightStateBean);
      }
    }
    else
    {
      b1(this.p3);
      localObject = this.z;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mColorTempSettingFragment");
      }
      ((ColorTemperatureSettingFragment)localObject).m1(paramLightStateBean);
    }
  }
  
  private final void h1()
  {
    Object localObject1 = new ColorTemperatureSettingFragment();
    ((ColorTemperatureSettingFragment)localObject1).p1(this);
    ((ColorTemperatureSettingFragment)localObject1).o1(this);
    Object localObject2 = p.a;
    this.z = ((ColorTemperatureSettingFragment)localObject1);
    localObject1 = new ColorLightSettingFragment();
    ((ColorLightSettingFragment)localObject1).p1(this);
    ((ColorLightSettingFragment)localObject1).o1(this);
    this.p0 = ((ColorLightSettingFragment)localObject1);
    localObject1 = LightStripLightingEffectFragment.p1.a(I0(), 1);
    ((LightStripLightingEffectFragment)localObject1).v1(this);
    ((LightStripLightingEffectFragment)localObject1).u1(this);
    this.p1 = ((LightStripLightingEffectFragment)localObject1);
    localObject1 = new ArrayList();
    int i;
    if (com.tplink.iot.g.b.c.c.k(X0().f(), X0().m()))
    {
      localObject2 = this.z;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mColorTempSettingFragment");
      }
      ((List)localObject1).add(localObject2);
      this.p3 = 0;
      localObject2 = com.tplink.iot.g.b.c.c.n(X0().f());
      ColorTemperatureSettingFragment localColorTemperatureSettingFragment = this.z;
      if (localColorTemperatureSettingFragment == null) {
        kotlin.jvm.internal.j.t("mColorTempSettingFragment");
      }
      localColorTemperatureSettingFragment.l1(localObject2[0], localObject2[1]);
      i = 0;
    }
    else
    {
      i = -1;
    }
    int j = i;
    if (X0().l())
    {
      localObject2 = this.p0;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mColorLightSettingFragment");
      }
      ((List)localObject1).add(localObject2);
      j = i + 1;
      this.H3 = j;
    }
    if (X0().n())
    {
      localObject2 = this.p1;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mLightStripLightingEffectFragment");
      }
      ((List)localObject1).add(localObject2);
      this.I3 = (j + 1);
    }
    localObject1 = ((Collection)localObject1).toArray(new Fragment[0]);
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.Array<T>");
    this.p2 = ((Fragment[])localObject1);
  }
  
  public void A0()
  {
    HashMap localHashMap = this.N3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void C(com.tplink.iot.g.b.b.a parama)
  {
    kotlin.jvm.internal.j.e(parama, "data");
    String str = parama.e();
    if (str != null)
    {
      if (this.y) {
        T0(str);
      }
      parama = this.L3;
      if (parama != null) {
        parama.B0(str);
      }
    }
  }
  
  public void C0(FrameLayout paramFrameLayout)
  {
    kotlin.jvm.internal.j.e(paramFrameLayout, "bottomSheet");
    Object localObject = paramFrameLayout.getLayoutParams();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).height = -1;
    paramFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public int G0()
  {
    return 2131558933;
  }
  
  public void J0()
  {
    h1();
    FragmentLightStripLightSettingsDialogBinding localFragmentLightStripLightSettingsDialogBinding = (FragmentLightStripLightSettingsDialogBinding)H0();
    boolean bool = W0();
    int i = 0;
    if (!bool)
    {
      localObject = localFragmentLightStripLightSettingsDialogBinding.f;
      kotlin.jvm.internal.j.d(localObject, "flRoot");
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    }
    Object localObject = localFragmentLightStripLightSettingsDialogBinding.y;
    kotlin.jvm.internal.j.d(localObject, "llToolbar");
    if (!W0()) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = localFragmentLightStripLightSettingsDialogBinding.d;
    kotlin.jvm.internal.j.d(localObject, "effectsViewPager");
    ((ViewPager2)localObject).setAdapter(new c());
    localObject = localFragmentLightStripLightSettingsDialogBinding.d;
    kotlin.jvm.internal.j.d(localObject, "effectsViewPager");
    ((ViewPager2)localObject).setOffscreenPageLimit(2);
    new TabLayoutMediator(localFragmentLightStripLightSettingsDialogBinding.c, localFragmentLightStripLightSettingsDialogBinding.d, new f(this)).attach();
    localFragmentLightStripLightSettingsDialogBinding.q.setOnClickListener(new g(this));
    localFragmentLightStripLightSettingsDialogBinding.x.setOnClickListener(new h(this));
    a1();
  }
  
  public void S(int paramInt, boolean paramBoolean)
  {
    this.J3 = paramInt;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localObject = this.z;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mColorTempSettingFragment");
          }
          ((ColorTemperatureSettingFragment)localObject).e1();
          localObject = this.p0;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mColorLightSettingFragment");
          }
          ((ColorLightSettingFragment)localObject).e1();
        }
      }
      else
      {
        localObject = this.z;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mColorTempSettingFragment");
        }
        ((ColorTemperatureSettingFragment)localObject).e1();
        localObject = this.p1;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mLightStripLightingEffectFragment");
        }
        ((LightStripLightingEffectFragment)localObject).g1();
      }
    }
    else
    {
      localObject = this.p1;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mLightStripLightingEffectFragment");
      }
      ((LightStripLightingEffectFragment)localObject).g1();
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mColorLightSettingFragment");
      }
      ((ColorLightSettingFragment)localObject).e1();
    }
  }
  
  public void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LightStateBean localLightStateBean = new LightStateBean(paramInt1, paramInt2, paramInt4, paramInt3);
    if (this.y) {
      X0().p(localLightStateBean);
    }
    b localb = this.L3;
    if (localb != null) {
      localb.A(localLightStateBean);
    }
  }
  
  public final LightStateBean V0()
  {
    int i = this.J3;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localObject = null;
        }
        else
        {
          localObject = this.p1;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mLightStripLightingEffectFragment");
          }
          localObject = ((LightStripLightingEffectFragment)localObject).k1();
        }
      }
      else
      {
        localObject = this.p0;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mColorLightSettingFragment");
        }
        localObject = ((ColorLightSettingFragment)localObject).i1();
      }
    }
    else
    {
      localObject = this.z;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mColorTempSettingFragment");
      }
      localObject = ((ColorTemperatureSettingFragment)localObject).i1();
    }
    return (LightStateBean)localObject;
  }
  
  public final void d1(LightStateBean paramLightStateBean)
  {
    if (this.K3 == null)
    {
      this.K3 = paramLightStateBean;
      a1();
    }
  }
  
  public final void e1(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public final void f1(l<? super LightStateBean, p> paraml)
  {
    kotlin.jvm.internal.j.e(paraml, "callback");
    this.L3 = new j(paraml);
  }
  
  public final void g1(b paramb)
  {
    kotlin.jvm.internal.j.e(paramb, "listener");
    this.L3 = paramb;
  }
  
  public void m0(com.tplink.iot.g.b.b.c paramc)
  {
    kotlin.jvm.internal.j.e(paramc, "data");
    if (this.y) {
      X0().p(paramc.e());
    }
    b localb = this.L3;
    if (localb != null) {
      localb.k0(paramc.e());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("ModeExtra");
    } else {
      i = 2;
    }
    this.x = i;
    paramBundle = getArguments();
    Object localObject = null;
    if (paramBundle != null) {
      paramBundle = paramBundle.getSerializable("LightStateExtra");
    } else {
      paramBundle = null;
    }
    if (!(paramBundle instanceof LightStateBean)) {
      paramBundle = (Bundle)localObject;
    }
    this.K3 = ((LightStateBean)paramBundle);
    if (W0()) {
      setStyle(0, 2132017411);
    }
  }
  
  public void p0(com.tplink.iot.g.b.b.d paramd)
  {
    kotlin.jvm.internal.j.e(paramd, "data");
    if (this.y)
    {
      Object localObject;
      if (paramd.i())
      {
        localObject = paramd.c();
        if (localObject != null)
        {
          X0().p((LightStateBean)localObject);
          paramd = this.L3;
          if (paramd != null) {
            paramd.k0((LightStateBean)localObject);
          }
        }
      }
      else
      {
        paramd = paramd.f();
        if (paramd != null)
        {
          U0(paramd);
          localObject = this.L3;
          if (localObject != null) {
            ((b)localObject).c0(paramd);
          }
        }
      }
    }
  }
  
  public void t0(com.tplink.iot.g.b.b.b paramb)
  {
    kotlin.jvm.internal.j.e(paramb, "data");
    String str = paramb.e();
    if (str != null)
    {
      if (this.y) {
        T0(str);
      }
      paramb = this.L3;
      if (paramb != null) {
        paramb.B0(str);
      }
    }
  }
  
  public static final class a
  {
    public final LightStripLightSettingsFragment a(String paramString, int paramInt, LightStateBean paramLightStateBean)
    {
      kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
      LightStripLightSettingsFragment localLightStripLightSettingsFragment = new LightStripLightSettingsFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("ModeExtra", paramInt);
      localBundle.putSerializable("LightStateExtra", paramLightStateBean);
      localBundle.putString("device_id_md5", paramString);
      paramString = p.a;
      localLightStripLightSettingsFragment.setArguments(localBundle);
      return localLightStripLightSettingsFragment;
    }
  }
  
  public static abstract interface b
  {
    public abstract void A(LightStateBean paramLightStateBean);
    
    public abstract void B0(String paramString);
    
    public abstract void I(LightStateBean paramLightStateBean);
    
    public abstract void c0(String paramString);
    
    public abstract void k0(LightStateBean paramLightStateBean);
    
    public static final class a
    {
      public static void a(LightStripLightSettingsFragment.b paramb, LightStateBean paramLightStateBean)
      {
        kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
      }
      
      public static void b(LightStripLightSettingsFragment.b paramb, String paramString)
      {
        kotlin.jvm.internal.j.e(paramString, "effectId");
      }
      
      public static void c(LightStripLightSettingsFragment.b paramb, String paramString)
      {
        kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
      }
      
      public static void d(LightStripLightSettingsFragment.b paramb, LightStateBean paramLightStateBean)
      {
        kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
      }
    }
  }
  
  private final class c
    extends FragmentStateAdapter
  {
    public c()
    {
      super();
    }
    
    public Fragment createFragment(int paramInt)
    {
      return LightStripLightSettingsFragment.P0(LightStripLightSettingsFragment.this)[paramInt];
    }
    
    public int getItemCount()
    {
      return LightStripLightSettingsFragment.P0(LightStripLightSettingsFragment.this).length;
    }
  }
  
  static final class d<T, R>
    implements io.reactivex.g0.j<CustomizedEffect, e>
  {
    d(LightStripLightSettingsFragment paramLightStripLightSettingsFragment) {}
    
    public final e a(CustomizedEffect paramCustomizedEffect)
    {
      kotlin.jvm.internal.j.e(paramCustomizedEffect, "it");
      paramCustomizedEffect = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.b(paramCustomizedEffect, LightStripLightSettingsFragment.Q0(this.c).o(), new a(LightStripLightSettingsFragment.Q0(this.c))));
      return LightStripLightSettingsFragment.Q0(this.c).r(paramCustomizedEffect);
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<PredefinedEffect, e>
  {
    e(LightStripLightSettingsFragment paramLightStripLightSettingsFragment) {}
    
    public final e a(PredefinedEffect paramPredefinedEffect)
    {
      kotlin.jvm.internal.j.e(paramPredefinedEffect, "it");
      paramPredefinedEffect = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.c(paramPredefinedEffect, LightStripLightSettingsFragment.Q0(this.c).o()));
      return LightStripLightSettingsFragment.Q0(this.c).r(paramPredefinedEffect);
    }
  }
  
  static final class f
    implements TabLayoutMediator.TabConfigurationStrategy
  {
    f(LightStripLightSettingsFragment paramLightStripLightSettingsFragment) {}
    
    public final void onConfigureTab(TabLayout.Tab paramTab, int paramInt)
    {
      kotlin.jvm.internal.j.e(paramTab, "tab");
      if (paramInt == LightStripLightSettingsFragment.L0(this.a)) {
        paramTab.setText(2131954468);
      } else if (paramInt == LightStripLightSettingsFragment.K0(this.a)) {
        paramTab.setText(2131952376);
      } else if (paramInt == LightStripLightSettingsFragment.O0(this.a)) {
        paramTab.setText(2131952944);
      }
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(LightStripLightSettingsFragment paramLightStripLightSettingsFragment) {}
    
    public final void onClick(View paramView)
    {
      LightStripLightSettingsFragment.R0(this.c);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(LightStripLightSettingsFragment paramLightStripLightSettingsFragment) {}
    
    public final void onClick(View paramView)
    {
      LightStripLightSettingsFragment.S0(this.c);
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.a<LightStripLightSettingsViewModel>
  {
    i(LightStripLightSettingsFragment paramLightStripLightSettingsFragment)
    {
      super();
    }
    
    public final LightStripLightSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((Fragment)localObject, LightStripLightSettingsFragment.N0((LightStripLightSettingsFragment)localObject))).get(LightStripLightSettingsViewModel.class);
      kotlin.jvm.internal.j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightStripLightSettingsViewModel)localObject;
    }
  }
  
  public static final class j
    implements LightStripLightSettingsFragment.b
  {
    j(l paraml) {}
    
    public void A(LightStateBean paramLightStateBean)
    {
      kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
      LightStripLightSettingsFragment.b.a.a(this, paramLightStateBean);
    }
    
    public void B0(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "effectId");
      LightStripLightSettingsFragment.b.a.b(this, paramString);
    }
    
    public void I(LightStateBean paramLightStateBean)
    {
      this.c.invoke(paramLightStateBean);
    }
    
    public void c0(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "predefinedEffectId");
      LightStripLightSettingsFragment.b.a.c(this, paramString);
    }
    
    public void k0(LightStateBean paramLightStateBean)
    {
      kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
      LightStripLightSettingsFragment.b.a.d(this, paramLightStateBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripLightSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */