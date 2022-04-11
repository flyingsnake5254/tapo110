package com.tplink.iot.devices.lightstrip.view.effects;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.FragmentLightStripLightEffectsBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.lightstrip.adapter.ColorPaintingAdapter;
import com.tplink.iot.devices.lightstrip.adapter.CustomizedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.NormalColorsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.NormalColorsAdapter.a;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter.a;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.LightStripLightingEffectViewModel;
import com.tplink.iot.g.b.a.a.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightStripLightingEffectFragment
  extends IoTMVVMBaseFragment<FragmentLightStripLightEffectsBinding>
{
  public static final a p1 = new a(null);
  private ColorPaintingAdapter H3;
  private CustomizedEffectsAdapter I3;
  private PredefinedEffectsAdapter J3;
  private List<com.tplink.iot.g.b.b.d> K3 = new ArrayList();
  private int L3;
  private boolean M3;
  private com.tplink.iot.g.b.a.b N3;
  private com.tplink.iot.widget.colorbulb.c.b O3;
  private com.tplink.iot.g.b.b.e.a P3;
  private final f Q3 = h.b(new c(this));
  private LightStateBean R3;
  private boolean S3;
  private boolean T3;
  private boolean U3;
  private HashMap V3;
  private final List<Runnable> p2 = new ArrayList();
  private NormalColorsAdapter p3;
  
  private final void A1(List<? extends CustomizedEffect> paramList)
  {
    this.S3 = true;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    boolean bool = l1().k();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CustomizedEffect localCustomizedEffect = (CustomizedEffect)paramList.next();
      List localList = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.o(localCustomizedEffect);
      if ((localCustomizedEffect.getType() != Type.PULSE) || (bool)) {
        if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.q(localCustomizedEffect))
        {
          Object localObject = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.g(localList);
          localList = (List)((Pair)localObject).component1();
          localObject = (List)((Pair)localObject).component2();
          localArrayList1.add(new com.tplink.iot.g.b.b.a(p1(localCustomizedEffect), l.U(localList), l.U((Collection)localObject), localCustomizedEffect));
        }
        else
        {
          localArrayList2.add(new com.tplink.iot.g.b.b.b(p1(localCustomizedEffect), l.U(localList), localCustomizedEffect));
        }
      }
    }
    paramList = this.H3;
    if (paramList != null) {
      paramList.T(localArrayList1);
    }
    paramList = this.I3;
    if (paramList != null) {
      paramList.T(localArrayList2);
    }
    d1();
    q1();
  }
  
  private final void B1(List<? extends PredefinedEffect> paramList)
  {
    this.T3 = true;
    ArrayList localArrayList = new ArrayList();
    boolean bool = l1().k();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (PredefinedEffect)localIterator.next();
      Object localObject = paramList.getMeta();
      if (localObject != null)
      {
        localObject = ((LightingEffectMeta)localObject).getAlias();
        if ((localObject != null) && ((paramList.getType() != Type.PULSE) || (bool)))
        {
          localObject = PredefinedEffectsAdapter.h.b((String)localObject);
          if (localObject != null)
          {
            ((com.tplink.iot.g.b.b.d)localObject).l(paramList);
            localArrayList.add(localObject);
          }
        }
      }
    }
    localArrayList.addAll(0, this.K3);
    paramList = this.J3;
    if (paramList != null) {
      paramList.T(localArrayList);
    }
    d1();
    q1();
  }
  
  private final void d1()
  {
    if (o1())
    {
      localObject = this.p3;
      if (localObject != null)
      {
        localObject = (com.tplink.iot.g.b.b.c)((LightStripEffectsBaseAdapter)localObject).L();
        if (localObject != null) {
          this.P3 = ((com.tplink.iot.g.b.b.e.a)localObject);
        }
      }
    }
    Object localObject = this.H3;
    if (localObject != null)
    {
      localObject = (com.tplink.iot.g.b.b.a)((LightStripEffectsBaseAdapter)localObject).L();
      if (localObject != null) {
        this.P3 = ((com.tplink.iot.g.b.b.e.a)localObject);
      }
    }
    localObject = this.I3;
    if (localObject != null)
    {
      localObject = (com.tplink.iot.g.b.b.b)((LightStripEffectsBaseAdapter)localObject).L();
      if (localObject != null) {
        this.P3 = ((com.tplink.iot.g.b.b.e.a)localObject);
      }
    }
    localObject = this.J3;
    if (localObject != null)
    {
      localObject = (com.tplink.iot.g.b.b.d)((LightStripEffectsBaseAdapter)localObject).L();
      if (localObject != null) {
        this.P3 = ((com.tplink.iot.g.b.b.e.a)localObject);
      }
    }
  }
  
  private final void e1(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.p3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).C();
      }
    }
    if (paramBoolean2)
    {
      localObject = this.H3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).C();
      }
    }
    if (paramBoolean3)
    {
      localObject = this.I3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).C();
      }
    }
    if (paramBoolean4)
    {
      localObject = this.J3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).C();
      }
    }
  }
  
  private final void h1(com.tplink.iot.g.b.b.e.a parama)
  {
    Object localObject = this.O3;
    if (localObject != null) {
      ((com.tplink.iot.widget.colorbulb.c.b)localObject).S(2, true);
    }
    this.P3 = parama;
    if ((parama instanceof com.tplink.iot.g.b.b.c))
    {
      localObject = this.N3;
      if (localObject != null) {
        ((com.tplink.iot.g.b.a.b)localObject).m0((com.tplink.iot.g.b.b.c)parama);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      localObject = this.N3;
      if (localObject != null) {
        ((com.tplink.iot.g.b.a.b)localObject).C((com.tplink.iot.g.b.b.a)parama);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      localObject = this.N3;
      if (localObject != null) {
        ((com.tplink.iot.g.b.a.b)localObject).t0((com.tplink.iot.g.b.b.b)parama);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.d))
    {
      localObject = this.N3;
      if (localObject != null) {
        ((com.tplink.iot.g.b.a.b)localObject).p0((com.tplink.iot.g.b.b.d)parama);
      }
    }
  }
  
  private final void i1()
  {
    b.d.w.c.a.n("LightingEffectF", "executeViewRunQueue");
    if ((this.p2.isEmpty() ^ true))
    {
      Iterator localIterator = this.p2.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.p2.clear();
  }
  
  private final LightStripLightingEffectViewModel l1()
  {
    return (LightStripLightingEffectViewModel)this.Q3.getValue();
  }
  
  private final void m1(com.tplink.iot.g.b.b.a parama, boolean paramBoolean)
  {
    ColorPaintingMakeActivity.a locala = ColorPaintingMakeActivity.p3;
    Context localContext = requireContext();
    j.d(localContext, "requireContext()");
    String str = K0();
    if (parama != null) {
      parama = parama.e();
    } else {
      parama = null;
    }
    startActivity(locala.a(localContext, str, paramBoolean ^ true, parama));
  }
  
  private final void n1(com.tplink.iot.g.b.b.b paramb, boolean paramBoolean)
  {
    CustomizedEffectsMakeActivity.a locala = CustomizedEffectsMakeActivity.p0;
    Context localContext = requireContext();
    j.d(localContext, "requireContext()");
    String str = K0();
    if (paramb != null) {
      paramb = paramb.e();
    } else {
      paramb = null;
    }
    startActivity(locala.a(localContext, str, paramBoolean ^ true, paramb));
  }
  
  private final boolean o1()
  {
    boolean bool;
    if (this.L3 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final String p1(CustomizedEffect paramCustomizedEffect)
  {
    paramCustomizedEffect = paramCustomizedEffect.getMeta();
    if (paramCustomizedEffect != null)
    {
      paramCustomizedEffect = paramCustomizedEffect.getAlias();
      if (paramCustomizedEffect != null) {}
    }
    else
    {
      paramCustomizedEffect = "";
    }
    return paramCustomizedEffect;
  }
  
  private final void q1()
  {
    if ((this.S3) && (this.T3)) {
      r1(this.R3);
    }
  }
  
  private final void r1(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      Object localObject = paramLightStateBean.getLightingEffectData();
      if (localObject != null)
      {
        paramLightStateBean = ((LightingEffectData)localObject).id;
        localObject = this.H3;
        if (localObject != null) {
          ((LightStripEffectsBaseAdapter)localObject).R(paramLightStateBean);
        }
        localObject = this.I3;
        if (localObject != null) {
          ((LightStripEffectsBaseAdapter)localObject).R(paramLightStateBean);
        }
        localObject = this.J3;
        if (localObject != null) {
          ((LightStripEffectsBaseAdapter)localObject).R(paramLightStateBean);
        }
      }
      else if ((this.U3) && (paramLightStateBean.getColorTemp() != 0))
      {
        paramLightStateBean = this.J3;
        if (paramLightStateBean != null) {
          paramLightStateBean.R("PredefinedEffect_Daylight");
        }
      }
      d1();
    }
  }
  
  private final void w1()
  {
    Object localObject = requireContext();
    j.d(localObject, "requireContext()");
    localObject = new ColorPaintingAdapter((Context)localObject, l.d(), 0, 4, null);
    ((LightStripEffectsBaseAdapter)localObject).S(new e((ColorPaintingAdapter)localObject, this));
    p localp = p.a;
    this.H3 = ((ColorPaintingAdapter)localObject);
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).c;
    ((RecyclerView)localObject).setAdapter(this.H3);
    i.g((RecyclerView)localObject);
  }
  
  private final void x1()
  {
    Object localObject = requireContext();
    j.d(localObject, "requireContext()");
    CustomizedEffectsAdapter localCustomizedEffectsAdapter = new CustomizedEffectsAdapter((Context)localObject, l.d(), 0, 4, null);
    localCustomizedEffectsAdapter.S(new f(localCustomizedEffectsAdapter, this));
    localObject = p.a;
    this.I3 = localCustomizedEffectsAdapter;
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).f;
    ((RecyclerView)localObject).setAdapter(this.I3);
    i.g((RecyclerView)localObject);
  }
  
  private final void y1()
  {
    Object localObject = com.tplink.iot.g.b.c.c.n(l1().f());
    boolean bool = com.tplink.iot.g.b.c.c.l(l1().f(), l1().j());
    this.U3 = bool;
    if (bool) {
      this.K3.add(PredefinedEffectsAdapter.h.a(localObject[0]));
    }
    localObject = requireContext();
    j.d(localObject, "requireContext()");
    PredefinedEffectsAdapter localPredefinedEffectsAdapter = new PredefinedEffectsAdapter((Context)localObject, this.K3, 0, 4, null);
    localPredefinedEffectsAdapter.S(new g(localPredefinedEffectsAdapter, this));
    localObject = p.a;
    this.J3 = localPredefinedEffectsAdapter;
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).q;
    ((RecyclerView)localObject).setAdapter(this.J3);
    i.g((RecyclerView)localObject);
  }
  
  private final void z1()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = NormalColorsAdapter.k.a();
    int i = localObject2.length;
    int j = 0;
    Pair[] arrayOfPair;
    for (int k = 0; k < i; k++)
    {
      arrayOfPair = localObject2[k];
      ((List)localObject1).add(new com.tplink.iot.g.b.b.c(((Number)arrayOfPair.getSecond()).intValue(), (LightStateBean)arrayOfPair.getFirst()));
    }
    if (l1().j())
    {
      if (com.tplink.iot.g.b.c.c.k(l1().f(), l1().j()))
      {
        arrayOfPair = NormalColorsAdapter.k.b();
        i = arrayOfPair.length;
        for (k = j; k < i; k++)
        {
          localObject2 = arrayOfPair[k];
          ((List)localObject1).add(new com.tplink.iot.g.b.b.c(((Number)((Pair)localObject2).getSecond()).intValue(), (LightStateBean)((Pair)localObject2).getFirst()));
        }
      }
      localObject2 = NormalColorsAdapter.k.c();
      ((List)localObject1).add(new com.tplink.iot.g.b.b.c(((Number)((Pair)localObject2).getSecond()).intValue(), (LightStateBean)((Pair)localObject2).getFirst()));
    }
    localObject2 = requireContext();
    j.d(localObject2, "requireContext()");
    localObject2 = new NormalColorsAdapter((Context)localObject2, (List)localObject1, 0, 4, null);
    ((LightStripEffectsBaseAdapter)localObject2).S(new h((NormalColorsAdapter)localObject2, this));
    localObject1 = p.a;
    this.p3 = ((NormalColorsAdapter)localObject2);
    localObject1 = ((FragmentLightStripLightEffectsBinding)J0()).d;
    ((RecyclerView)localObject1).setAdapter(this.p3);
    i.g((RecyclerView)localObject1);
  }
  
  public void H0()
  {
    HashMap localHashMap = this.V3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @LayoutRes
  public int I0()
  {
    return 2131558931;
  }
  
  public void N0()
  {
    super.N0();
    Object localObject = ((FragmentLightStripLightEffectsBinding)J0()).y;
    j.d(localObject, "mBinding.tvColors");
    boolean bool = o1();
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).d;
    j.d(localObject, "mBinding.rvColorPresets");
    if (o1()) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).x;
    j.d(localObject, "mBinding.tvColorPainting");
    if (l1().l()) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    localObject = ((FragmentLightStripLightEffectsBinding)J0()).c;
    j.d(localObject, "mBinding.rvColorPainting");
    if (l1().l()) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    if (o1()) {
      z1();
    }
    if (l1().l()) {
      w1();
    }
    x1();
    y1();
    i1();
  }
  
  public void O0()
  {
    l1().m();
    l1().n();
  }
  
  public void R0()
  {
    l1().g().observe(getViewLifecycleOwner(), new i(this));
    l1().i().observe(getViewLifecycleOwner(), new j(this));
  }
  
  public final void g1()
  {
    if (V0(this))
    {
      b.d.w.c.a.n("LightingEffectF", "executeOrPostViewRunnable directly");
      f1(this, false, false, false, false, 15, null);
      a1(this, null);
    }
    else
    {
      W0(this).add(new b(this));
    }
  }
  
  public final boolean j1()
  {
    return this.M3;
  }
  
  public final LightStateBean k1()
  {
    Object localObject = this.P3;
    if (localObject != null) {
      localObject = com.tplink.iot.g.b.b.e.b.b((com.tplink.iot.g.b.b.e.a)localObject, l1().l());
    } else {
      localObject = null;
    }
    return (LightStateBean)localObject;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("ArgPage", 0);
    }
    this.L3 = i;
  }
  
  public final void s1(boolean paramBoolean)
  {
    if (this.M3 != paramBoolean)
    {
      this.M3 = paramBoolean;
      Object localObject = this.p3;
      if (localObject != null) {
        ((NormalColorsAdapter)localObject).a0(paramBoolean ^ true);
      }
      localObject = this.H3;
      if (localObject != null) {
        ((ColorPaintingAdapter)localObject).X(this.M3);
      }
      localObject = this.I3;
      if (localObject != null) {
        ((CustomizedEffectsAdapter)localObject).X(this.M3);
      }
      localObject = this.J3;
      if (localObject != null) {
        ((PredefinedEffectsAdapter)localObject).X(this.M3 ^ true);
      }
    }
  }
  
  public final void t1(final LightStateBean paramLightStateBean)
  {
    this.R3 = paramLightStateBean;
    if (V0(this))
    {
      b.d.w.c.a.n("LightingEffectF", "executeOrPostViewRunnable directly");
      Z0(this, paramLightStateBean);
    }
    else
    {
      W0(this).add(new d(this, paramLightStateBean));
    }
  }
  
  public final void u1(com.tplink.iot.widget.colorbulb.c.b paramb)
  {
    j.e(paramb, "listener");
    this.O3 = paramb;
  }
  
  public final void v1(com.tplink.iot.g.b.a.b paramb)
  {
    j.e(paramb, "listener");
    this.N3 = paramb;
  }
  
  public static final class a
  {
    public final LightStripLightingEffectFragment a(String paramString, int paramInt)
    {
      j.e(paramString, "deviceIdMD5");
      LightStripLightingEffectFragment localLightStripLightingEffectFragment = new LightStripLightingEffectFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("ArgPage", paramInt);
      localBundle.putString("device_id_md5", paramString);
      paramString = p.a;
      localLightStripLightingEffectFragment.setArguments(localBundle);
      return localLightStripLightingEffectFragment;
    }
  }
  
  public static final class b
    implements Runnable
  {
    public b(LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public final void run()
    {
      LightStripLightingEffectFragment.f1(this.c, false, false, false, false, 15, null);
      LightStripLightingEffectFragment.a1(this.c, null);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<LightStripLightingEffectViewModel>
  {
    c(LightStripLightingEffectFragment paramLightStripLightingEffectFragment)
    {
      super();
    }
    
    public final LightStripLightingEffectViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((Fragment)localObject, LightStripLightingEffectFragment.T0((LightStripLightingEffectFragment)localObject))).get(LightStripLightingEffectViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightStripLightingEffectViewModel)localObject;
    }
  }
  
  public static final class d
    implements Runnable
  {
    public d(LightStripLightingEffectFragment paramLightStripLightingEffectFragment, LightStateBean paramLightStateBean) {}
    
    public final void run()
    {
      LightStripLightingEffectFragment.Z0(this.c, paramLightStateBean);
    }
  }
  
  public static final class e
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.a>
  {
    e(ColorPaintingAdapter paramColorPaintingAdapter, LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public void b()
    {
      LightStripLightingEffectFragment.X0(jdField_this, null, true);
    }
    
    public void c(com.tplink.iot.g.b.b.a parama, int paramInt)
    {
      j.e(parama, "data");
      if (LightStripLightingEffectFragment.U0(jdField_this))
      {
        LightStripLightingEffectFragment.X0(jdField_this, parama, false);
      }
      else
      {
        LightStripLightingEffectFragment.f1(jdField_this, false, false, false, false, 13, null);
        LightStripLightingEffectFragment.S0(jdField_this, parama);
        this.c.Q(paramInt);
      }
    }
  }
  
  public static final class f
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.b>
  {
    f(CustomizedEffectsAdapter paramCustomizedEffectsAdapter, LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public void b()
    {
      LightStripLightingEffectFragment.Y0(jdField_this, null, true);
    }
    
    public void c(com.tplink.iot.g.b.b.b paramb, int paramInt)
    {
      j.e(paramb, "data");
      if (LightStripLightingEffectFragment.U0(jdField_this))
      {
        LightStripLightingEffectFragment.Y0(jdField_this, paramb, false);
      }
      else
      {
        LightStripLightingEffectFragment.f1(jdField_this, false, false, false, false, 11, null);
        LightStripLightingEffectFragment.S0(jdField_this, paramb);
        this.c.Q(paramInt);
      }
    }
  }
  
  public static final class g
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.d>
  {
    g(PredefinedEffectsAdapter paramPredefinedEffectsAdapter, LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public void b()
    {
      a.a.a(this);
    }
    
    public void c(com.tplink.iot.g.b.b.d paramd, int paramInt)
    {
      j.e(paramd, "data");
      LightStripLightingEffectFragment.f1(jdField_this, false, false, false, false, 7, null);
      LightStripLightingEffectFragment.S0(jdField_this, paramd);
      this.c.Q(paramInt);
    }
  }
  
  public static final class h
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.c>
  {
    h(NormalColorsAdapter paramNormalColorsAdapter, LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public void b()
    {
      a.a.a(this);
    }
    
    public void c(com.tplink.iot.g.b.b.c paramc, int paramInt)
    {
      j.e(paramc, "data");
      LightStripLightingEffectFragment.f1(jdField_this, false, false, false, false, 14, null);
      LightStripLightingEffectFragment.S0(jdField_this, paramc);
      this.c.Q(paramInt);
    }
  }
  
  static final class i<T>
    implements Observer<List<? extends CustomizedEffect>>
  {
    i(LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public final void a(List<? extends CustomizedEffect> paramList)
    {
      if (paramList != null) {
        LightStripLightingEffectFragment.b1(this.a, paramList);
      }
    }
  }
  
  static final class j<T>
    implements Observer<List<? extends PredefinedEffect>>
  {
    j(LightStripLightingEffectFragment paramLightStripLightingEffectFragment) {}
    
    public final void a(List<? extends PredefinedEffect> paramList)
    {
      if (paramList != null) {
        LightStripLightingEffectFragment.c1(this.a, paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\LightStripLightingEffectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */