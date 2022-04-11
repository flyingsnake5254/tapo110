package com.tplink.iot.devices.lightstrip.view.effects;

import android.app.Application;
import android.widget.SeekBar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.f;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.l;

public final class LightingEffectDebugViewModel
  extends AndroidViewModel
{
  public static final c b = new c(null);
  private final ObservableBoolean A;
  private final ObservableInt B;
  private final ObservableBoolean C;
  private final List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> D;
  private final ObservableBoolean E;
  private final ObservableInt F;
  private final ObservableBoolean G;
  private final ObservableInt H;
  private final ObservableInt I;
  private final ObservableBoolean J;
  private final ObservableInt K;
  private final ObservableInt L;
  private final ObservableBoolean M;
  private final ObservableInt N;
  private final ObservableInt O;
  private final ObservableBoolean P;
  private final List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> Q;
  private final ObservableBoolean R;
  private final kotlin.t.c c;
  private final kotlin.t.c d;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> e;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f;
  private LightingEffectData g;
  private final ObservableField<String> h;
  private final ObservableInt i;
  private final ObservableBoolean j;
  private final ObservableInt k;
  private final ObservableBoolean l;
  private final ObservableInt m;
  private final ObservableBoolean n;
  private final ObservableInt o;
  private final ObservableBoolean p;
  private final ObservableInt q;
  private final ObservableBoolean r;
  private final List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> s;
  private final ObservableBoolean t;
  private final ObservableInt u;
  private final ObservableBoolean v;
  private final ObservableInt w;
  private final ObservableBoolean x;
  private final ObservableInt y;
  private final ObservableInt z;
  
  public LightingEffectDebugViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.c = new b(paramThingContext);
    this.d = new a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.e = paramApplication;
    this.f = paramApplication;
    this.h = new ObservableField();
    this.i = new ObservableInt(0);
    this.j = new ObservableBoolean(true);
    this.k = new ObservableInt(1);
    this.l = new ObservableBoolean(true);
    this.m = new ObservableInt(0);
    this.n = new ObservableBoolean(true);
    this.o = new ObservableInt(1000);
    this.p = new ObservableBoolean(true);
    this.q = new ObservableInt(600);
    this.r = new ObservableBoolean(true);
    this.s = new ArrayList();
    this.t = new ObservableBoolean(true);
    this.u = new ObservableInt(2);
    this.v = new ObservableBoolean(true);
    this.w = new ObservableInt(1);
    this.x = new ObservableBoolean(true);
    this.y = new ObservableInt(1);
    this.z = new ObservableInt(1000);
    this.A = new ObservableBoolean(true);
    this.B = new ObservableInt(10);
    this.C = new ObservableBoolean(true);
    this.D = new ArrayList();
    this.E = new ObservableBoolean(true);
    this.F = new ObservableInt(24);
    this.G = new ObservableBoolean(true);
    this.H = new ObservableInt(0);
    this.I = new ObservableInt(360);
    this.J = new ObservableBoolean(true);
    this.K = new ObservableInt(0);
    this.L = new ObservableInt(100);
    this.M = new ObservableBoolean(true);
    this.N = new ObservableInt(0);
    this.O = new ObservableInt(100);
    this.P = new ObservableBoolean(true);
    this.Q = new ArrayList();
    this.R = new ObservableBoolean(true);
  }
  
  private final LightStripRepository E()
  {
    return (LightStripRepository)this.c.b(this, a[0]);
  }
  
  private final LightingEffectRepository F()
  {
    return (LightingEffectRepository)this.d.b(this, a[1]);
  }
  
  private final f h()
  {
    return new d(this);
  }
  
  public final ObservableInt A()
  {
    return this.I;
  }
  
  public final ObservableInt B()
  {
    return this.H;
  }
  
  public final ObservableBoolean C()
  {
    return this.J;
  }
  
  public final ObservableBoolean D()
  {
    return this.R;
  }
  
  public final LiveData<List<PredefinedEffect>> G()
  {
    return F().b0();
  }
  
  public final ObservableInt H()
  {
    return this.F;
  }
  
  public final ObservableBoolean I()
  {
    return this.G;
  }
  
  public final ObservableInt J()
  {
    return this.k;
  }
  
  public final ObservableBoolean K()
  {
    return this.l;
  }
  
  public final ObservableInt L()
  {
    return this.L;
  }
  
  public final ObservableInt M()
  {
    return this.K;
  }
  
  public final ObservableBoolean N()
  {
    return this.M;
  }
  
  public final ObservableBoolean O()
  {
    return this.t;
  }
  
  public final ObservableInt P()
  {
    return this.w;
  }
  
  public final ObservableBoolean Q()
  {
    return this.x;
  }
  
  public final ObservableInt R()
  {
    return this.o;
  }
  
  public final ObservableInt S()
  {
    return this.z;
  }
  
  public final ObservableInt T()
  {
    return this.y;
  }
  
  public final ObservableBoolean U()
  {
    return this.A;
  }
  
  public final ObservableBoolean V()
  {
    return this.p;
  }
  
  public final void W(SeekBar paramSeekBar)
  {
    kotlin.jvm.internal.j.e(paramSeekBar, "seekBar");
    int i1;
    switch (paramSeekBar.getId())
    {
    default: 
      break;
    case 2131364007: 
      i1 = this.z.get();
      if (this.y.get() > i1) {
        this.y.set(i1);
      }
      break;
    case 2131364006: 
      i1 = this.y.get();
      if (this.z.get() < i1) {
        this.z.set(i1);
      }
      break;
    }
  }
  
  public final void X(List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "colors");
    this.D.clear();
    this.D.addAll(paramList);
  }
  
  public final void Y(List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "colors");
    this.Q.clear();
    this.Q.addAll(paramList);
  }
  
  public final void Z(List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "colors");
    this.s.clear();
    this.s.addAll(paramList);
  }
  
  public final void a0(LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "data");
    this.g = paramLightingEffectData;
    this.h.set(paramLightingEffectData.name);
    Object localObject1 = b.a;
    Object localObject2 = paramLightingEffectData.type;
    if (localObject2 == null) {
      localObject2 = "";
    }
    int i1 = ((List)localObject1).indexOf(localObject2);
    localObject2 = this.i;
    boolean bool1 = false;
    if (i1 == -1) {
      i1 = 0;
    }
    ((ObservableInt)localObject2).set(i1);
    localObject1 = this.k;
    localObject2 = paramLightingEffectData.repeat_times;
    if (localObject2 != null) {
      i1 = ((Integer)localObject2).intValue();
    } else {
      i1 = 1;
    }
    ((ObservableInt)localObject1).set(i1);
    localObject1 = this.m;
    localObject2 = paramLightingEffectData.direction;
    if (localObject2 != null) {
      i1 = ((Integer)localObject2).intValue();
    } else {
      i1 = 1;
    }
    ((ObservableInt)localObject1).set(i1 - 1);
    localObject1 = this.o;
    localObject2 = paramLightingEffectData.transition;
    if (localObject2 != null) {
      i1 = ((Integer)localObject2).intValue();
    } else {
      i1 = 1000;
    }
    ((ObservableInt)localObject1).set(i1);
    localObject2 = this.q;
    localObject1 = paramLightingEffectData.duration;
    if (localObject1 != null) {
      i1 = ((Integer)localObject1).intValue();
    } else {
      i1 = 100;
    }
    ((ObservableInt)localObject2).set(i1);
    localObject2 = this.u;
    localObject1 = paramLightingEffectData.expansion_strategy;
    if (localObject1 != null) {
      i1 = ((Integer)localObject1).intValue();
    } else {
      i1 = 0;
    }
    ((ObservableInt)localObject2).set(i1);
    localObject1 = this.w;
    localObject2 = paramLightingEffectData.spread;
    if (localObject2 != null) {
      i1 = ((Integer)localObject2).intValue();
    } else {
      i1 = 1;
    }
    ((ObservableInt)localObject1).set(i1);
    localObject2 = paramLightingEffectData.transition_range;
    localObject1 = null;
    ObservableInt localObservableInt;
    if (localObject2 != null)
    {
      if (localObject2.length >= 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObservableInt = this.y;
        localObject3 = localObject2[0];
        kotlin.jvm.internal.j.d(localObject3, "it[0]");
        localObservableInt.set(((Integer)localObject3).intValue());
        localObject3 = this.z;
        localObject2 = localObject2[1];
        kotlin.jvm.internal.j.d(localObject2, "it[1]");
        ((ObservableInt)localObject3).set(((Integer)localObject2).intValue());
      }
    }
    localObject2 = this.B;
    Object localObject3 = paramLightingEffectData.fadeoff;
    if (localObject3 != null) {
      i1 = ((Integer)localObject3).intValue();
    } else {
      i1 = 10;
    }
    ((ObservableInt)localObject2).set(i1);
    localObject3 = this.F;
    localObject2 = paramLightingEffectData.random_seed;
    if (localObject2 != null) {
      i1 = ((Integer)localObject2).intValue();
    } else {
      i1 = 24;
    }
    ((ObservableInt)localObject3).set(i1);
    localObject2 = paramLightingEffectData.hue_range;
    if (localObject2 != null)
    {
      if (localObject2.length >= 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject3 = this.H;
        localObservableInt = localObject2[0];
        kotlin.jvm.internal.j.d(localObservableInt, "it[0]");
        ((ObservableInt)localObject3).set(localObservableInt.intValue());
        localObject3 = this.I;
        localObject2 = localObject2[1];
        kotlin.jvm.internal.j.d(localObject2, "it[1]");
        ((ObservableInt)localObject3).set(((Integer)localObject2).intValue());
      }
    }
    localObject2 = paramLightingEffectData.saturation_range;
    if (localObject2 != null)
    {
      if (localObject2.length >= 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObservableInt = this.K;
        localObject3 = localObject2[0];
        kotlin.jvm.internal.j.d(localObject3, "it[0]");
        localObservableInt.set(((Integer)localObject3).intValue());
        localObject3 = this.L;
        localObject2 = localObject2[1];
        kotlin.jvm.internal.j.d(localObject2, "it[1]");
        ((ObservableInt)localObject3).set(((Integer)localObject2).intValue());
      }
    }
    localObject3 = paramLightingEffectData.brightness_range;
    if (localObject3 != null)
    {
      if (localObject3.length >= 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject2 = localObject1;
      if (i1 != 0) {
        localObject2 = localObject3;
      }
      if (localObject2 != null)
      {
        localObject3 = this.N;
        localObject1 = localObject2[0];
        kotlin.jvm.internal.j.d(localObject1, "it[0]");
        ((ObservableInt)localObject3).set(((Integer)localObject1).intValue());
        localObject1 = this.O;
        localObject2 = localObject2[1];
        kotlin.jvm.internal.j.d(localObject2, "it[1]");
        ((ObservableInt)localObject1).set(((Integer)localObject2).intValue());
      }
    }
    localObject2 = this.j;
    if (paramLightingEffectData.type != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.l;
    if (paramLightingEffectData.repeat_times != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.n;
    if (paramLightingEffectData.direction != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.p;
    if (paramLightingEffectData.transition != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.r;
    if (paramLightingEffectData.duration != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject1 = this.t;
    localObject2 = paramLightingEffectData.sequence;
    if (localObject2 != null)
    {
      if (localObject2.length == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        i1 = 0;
        break label898;
      }
    }
    i1 = 1;
    label898:
    ((ObservableBoolean)localObject1).set(i1 ^ 0x1);
    localObject2 = this.v;
    if (paramLightingEffectData.expansion_strategy != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.x;
    if (paramLightingEffectData.spread != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.A;
    if (paramLightingEffectData.transition_range != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.C;
    if (paramLightingEffectData.fadeoff != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.E;
    localObject1 = paramLightingEffectData.backgrounds;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        i1 = 0;
        break label1059;
      }
    }
    i1 = 1;
    label1059:
    ((ObservableBoolean)localObject2).set(i1 ^ 0x1);
    localObject2 = this.G;
    if (paramLightingEffectData.random_seed != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.J;
    if (paramLightingEffectData.hue_range != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.M;
    if (paramLightingEffectData.saturation_range != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.P;
    if (paramLightingEffectData.brightness_range != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject2).set(bool2);
    localObject2 = this.R;
    boolean bool2 = bool1;
    if (paramLightingEffectData.init_states != null) {
      bool2 = true;
    }
    ((ObservableBoolean)localObject2).set(bool2);
  }
  
  public final io.reactivex.a g(LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "data");
    paramLightingEffectData = E().I5(paramLightingEffectData).f(h());
    kotlin.jvm.internal.j.d(paramLightingEffectData, "mLightStripRepository.se…EffectEventTransformer())");
    return paramLightingEffectData;
  }
  
  public final LightingEffectData i()
  {
    LightingEffectData localLightingEffectData = this.g;
    if (localLightingEffectData == null) {
      localLightingEffectData = new LightingEffectData();
    }
    localLightingEffectData.id = "01234567890123456789012345678901";
    Object localObject1 = localLightingEffectData.name;
    if (localObject1 == null) {
      localObject1 = "DebugLightingEffect";
    }
    localLightingEffectData.name = ((String)localObject1);
    localLightingEffectData.custom = Integer.valueOf(1);
    localObject1 = (String)l.z(b.a, this.i.get());
    if (localObject1 == null) {
      localObject1 = "sequence";
    }
    localLightingEffectData.type = ((String)localObject1);
    localLightingEffectData.enable = Integer.valueOf(1);
    boolean bool = this.l.get();
    Object localObject2 = null;
    if (bool) {
      localObject1 = Integer.valueOf(this.k.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.repeat_times = ((Integer)localObject1);
    if (this.n.get()) {
      localObject1 = Integer.valueOf(this.m.get() + 1);
    } else {
      localObject1 = null;
    }
    localLightingEffectData.direction = ((Integer)localObject1);
    if (this.v.get()) {
      localObject1 = Integer.valueOf(this.u.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.expansion_strategy = ((Integer)localObject1);
    if (this.p.get()) {
      localObject1 = Integer.valueOf(this.o.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.transition = ((Integer)localObject1);
    if (this.r.get()) {
      localObject1 = Integer.valueOf(this.q.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.duration = ((Integer)localObject1);
    if (this.x.get()) {
      localObject1 = Integer.valueOf(this.w.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.spread = ((Integer)localObject1);
    Object localObject3;
    Object localObject4;
    if (this.t.get())
    {
      localObject3 = this.s;
      localObject1 = new ArrayList(l.l((Iterable)localObject3, 10));
      localObject4 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)((Iterator)localObject4).next();
        ((Collection)localObject1).add(new Integer[] { Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).b()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).c()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).a()) });
      }
      localObject1 = ((Collection)localObject1).toArray(new Integer[0][]);
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.Array<T>");
      localObject1 = (Integer[][])localObject1;
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.sequence = ((Integer[][])localObject1);
    if (this.A.get())
    {
      localObject1 = new Integer[2];
      localObject1[0] = Integer.valueOf(this.y.get());
      localObject1[1] = Integer.valueOf(this.z.get());
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.transition_range = ((Integer[])localObject1);
    if (this.C.get()) {
      localObject1 = Integer.valueOf(this.B.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.fadeoff = ((Integer)localObject1);
    if (this.E.get())
    {
      localObject3 = this.D;
      localObject1 = new ArrayList(l.l((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)((Iterator)localObject3).next();
        ((Collection)localObject1).add(new Integer[] { Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject4).b()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject4).c()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject4).a()) });
      }
      localObject1 = ((Collection)localObject1).toArray(new Integer[0][]);
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.Array<T>");
      localObject1 = (Integer[][])localObject1;
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.backgrounds = ((Integer[][])localObject1);
    if (this.G.get()) {
      localObject1 = Integer.valueOf(this.F.get());
    } else {
      localObject1 = null;
    }
    localLightingEffectData.random_seed = ((Integer)localObject1);
    if (this.J.get())
    {
      localObject1 = new Integer[2];
      localObject1[0] = Integer.valueOf(this.H.get());
      localObject1[1] = Integer.valueOf(this.I.get());
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.hue_range = ((Integer[])localObject1);
    if (this.M.get())
    {
      localObject1 = new Integer[2];
      localObject1[0] = Integer.valueOf(this.K.get());
      localObject1[1] = Integer.valueOf(this.L.get());
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.saturation_range = ((Integer[])localObject1);
    if (this.P.get())
    {
      localObject1 = new Integer[2];
      localObject1[0] = Integer.valueOf(this.N.get());
      localObject1[1] = Integer.valueOf(this.O.get());
    }
    else
    {
      localObject1 = null;
    }
    localLightingEffectData.brightness_range = ((Integer[])localObject1);
    localObject1 = localObject2;
    if (this.R.get())
    {
      localObject2 = this.Q;
      localObject1 = new ArrayList(l.l((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)((Iterator)localObject2).next();
        ((Collection)localObject1).add(new Integer[] { Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).b()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).c()), Integer.valueOf(((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject3).a()) });
      }
      localObject1 = ((Collection)localObject1).toArray(new Integer[0][]);
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.Array<T>");
      localObject1 = (Integer[][])localObject1;
    }
    localLightingEffectData.init_states = ((Integer[][])localObject1);
    return localLightingEffectData;
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> j()
  {
    return this.f;
  }
  
  public final ObservableBoolean k()
  {
    return this.E;
  }
  
  public final ObservableInt l()
  {
    return this.O;
  }
  
  public final ObservableInt m()
  {
    return this.N;
  }
  
  public final ObservableBoolean n()
  {
    return this.P;
  }
  
  public final ObservableInt o()
  {
    return this.m;
  }
  
  public final ObservableBoolean p()
  {
    return this.n;
  }
  
  public final ObservableInt r()
  {
    return this.q;
  }
  
  public final ObservableBoolean s()
  {
    return this.r;
  }
  
  public final ObservableField<String> t()
  {
    return this.h;
  }
  
  public final ObservableInt u()
  {
    return this.i;
  }
  
  public final ObservableBoolean v()
  {
    return this.j;
  }
  
  public final ObservableInt w()
  {
    return this.u;
  }
  
  public final ObservableBoolean x()
  {
    return this.v;
  }
  
  public final ObservableInt y()
  {
    return this.B;
  }
  
  public final ObservableBoolean z()
  {
    return this.C;
  }
  
  public static final class a
    implements kotlin.t.c<Object, LightingEffectRepository>
  {
    private final LightingEffectRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = b.d.b.f.b.a(paramThingContext.getAccountContext(), LightingEffectRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "CloudRepositoryProviders…ontext, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightingEffectRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements kotlin.t.c<Object, LightStripRepository>
  {
    private final LightStripRepository a;
    
    public b(ThingContext paramThingContext)
    {
      paramThingContext = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, LightStripRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightStripRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class c {}
  
  static final class d
    implements f
  {
    d(LightingEffectDebugViewModel paramLightingEffectDebugViewModel) {}
    
    public final io.reactivex.e a(io.reactivex.a parama)
    {
      kotlin.jvm.internal.j.e(parama, "source");
      return parama.l(new a(this)).i(new b(this)).j(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(LightingEffectDebugViewModel.d paramd) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        LightingEffectDebugViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(100)));
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(LightingEffectDebugViewModel.d paramd) {}
      
      public final void run()
      {
        LightingEffectDebugViewModel.f(this.a.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(200)));
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(LightingEffectDebugViewModel.d paramd) {}
      
      public final void a(Throwable paramThrowable)
      {
        LightingEffectDebugViewModel.f(this.c.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(300)));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\LightingEffectDebugViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */