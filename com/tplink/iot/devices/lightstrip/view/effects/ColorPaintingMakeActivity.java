package com.tplink.iot.devices.lightstrip.view.effects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityColorPaintingMakeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.lightingeffect.ColorPaintingSegment;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState.b;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.b;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.ColorPaintingMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingSegmentView;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class ColorPaintingMakeActivity
  extends IoTMVVMBaseActivity<ActivityColorPaintingMakeBinding>
  implements View.OnClickListener, ColorPickerDialogFragment.b
{
  private static final int p0;
  private static final KasaLightState p1;
  private static final KasaLightState p2;
  public static final a p3 = new a(null);
  private int H3;
  private MenuItem I3;
  private final List<ColorPaintingSegment> J3 = new ArrayList();
  private KasaLightState K3;
  private final f L3;
  private String M3;
  private final f N3;
  
  static
  {
    Object localObject = Integer.valueOf(100);
    p0 = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(40, 100, 100).f();
    p1 = KasaLightState.builder().q(Integer.valueOf(40)).s((Integer)localObject).n((Integer)localObject).r(Integer.valueOf(1)).o();
    localObject = KasaLightState.builder();
    Integer localInteger = Integer.valueOf(0);
    p2 = ((KasaLightState.b)localObject).q(localInteger).s(localInteger).n(localInteger).o();
  }
  
  public ColorPaintingMakeActivity()
  {
    KasaLightState localKasaLightState = p1;
    j.d(localKasaLightState, "DEFAULT_VALUE");
    this.K3 = localKasaLightState;
    this.L3 = h.b(new k(this));
    this.N3 = h.b(j.c);
  }
  
  private final List<KasaLightState> A1(int paramInt, LightStripLightingEffect paramLightStripLightingEffect)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLightStripLightingEffect != null)
    {
      if (paramInt > paramLightStripLightingEffect.getSegments().size()) {
        y1(paramInt, paramLightStripLightingEffect);
      }
      paramLightStripLightingEffect = B1().t(paramLightStripLightingEffect);
      j.d(paramLightStripLightingEffect, "lightStateGroup");
      paramLightStripLightingEffect = paramLightStripLightingEffect.b();
      j.d(paramLightStripLightingEffect, "lightStateGroup.lightStates");
      return paramLightStripLightingEffect;
    }
    for (int i = 0; i < paramInt; i++)
    {
      paramLightStripLightingEffect = KasaLightState.builder().q(Integer.valueOf(40)).s(Integer.valueOf(100)).n(Integer.valueOf(100)).r(Integer.valueOf(1)).o();
      j.d(paramLightStripLightingEffect, "ls");
      localArrayList.add(paramLightStripLightingEffect);
    }
    return localArrayList;
  }
  
  private final com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e B1()
  {
    return (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e)this.N3.getValue();
  }
  
  private final boolean C1()
  {
    int i = this.H3;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private final ColorPaintingMakeViewModel D1()
  {
    return (ColorPaintingMakeViewModel)this.L3.getValue();
  }
  
  private final void E1()
  {
    startActivityForResult(EditEffectNameActivity.p0.a(this, D1().m()), 1);
  }
  
  private final void F1()
  {
    if (C1())
    {
      String str = this.M3;
      if (str != null) {
        q.f1(D1().o(), D1().k(str), c.c).F(new d(this)).l0(io.reactivex.d0.b.a.a()).E(new e(this)).C(new f(this)).F0();
      }
    }
    else
    {
      D1().o().F(new g(this)).l0(io.reactivex.d0.b.a.a()).E(new h(this)).C(new i(this)).F0();
    }
  }
  
  private final void G1(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadEffectForCreation stripLen: ");
    ((StringBuilder)localObject).append(paramInt);
    b.d.w.c.a.n("LightStrip", ((StringBuilder)localObject).toString());
    localObject = w1(this, paramInt, null, 2, null);
    this.J3.clear();
    this.J3.addAll((Collection)localObject);
    ColorPaintingMakeViewModel localColorPaintingMakeViewModel = D1();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131952917));
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(D1().t());
    localColorPaintingMakeViewModel.u(((StringBuilder)localObject).toString());
    P1(p0);
    N1(paramInt);
  }
  
  private final void H1(int paramInt, AbstractLightingEffect paramAbstractLightingEffect)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadEffectForEdit stripLen: ");
    ((StringBuilder)localObject).append(paramInt);
    b.d.w.c.a.n("LightStrip", ((StringBuilder)localObject).toString());
    localObject = u1(paramInt, d.y(paramAbstractLightingEffect));
    int i = z1((List)localObject, this.K3);
    paramAbstractLightingEffect = paramAbstractLightingEffect.getMeta();
    if (paramAbstractLightingEffect != null)
    {
      paramAbstractLightingEffect = paramAbstractLightingEffect.getAlias();
      if (paramAbstractLightingEffect != null) {}
    }
    else
    {
      paramAbstractLightingEffect = "";
    }
    this.J3.clear();
    this.J3.addAll((Collection)localObject);
    D1().u(paramAbstractLightingEffect);
    P1(p0);
    ((ActivityColorPaintingMakeBinding)f1()).c.e(i);
    N1(paramInt);
  }
  
  private final void I1()
  {
    if (C1()) {
      L1();
    } else {
      s1();
    }
  }
  
  private final void J1(int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 200)
      {
        if (paramInt != 300)
        {
          if (paramInt != 400)
          {
            if (paramInt == 500) {
              com.tplink.iot.Utils.extension.e.k(this, getString(2131953943, new Object[] { Integer.valueOf(16) }), null, 2, null);
            }
          }
          else {
            com.tplink.iot.Utils.extension.e.j(this, 2131953674, null, 2, null);
          }
        }
        else {
          com.tplink.iot.Utils.extension.e.e(this, null, 1, null);
        }
      }
      else
      {
        com.tplink.iot.Utils.extension.e.a();
        finish();
      }
    }
    else {
      com.tplink.iot.Utils.extension.e.m(this, null, 1, null);
    }
  }
  
  private final void K1()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag("ColorPickerFragment");
    Object localObject = localFragment;
    if (!(localFragment instanceof ColorPickerDialogFragment)) {
      localObject = null;
    }
    localObject = (ColorPickerDialogFragment)localObject;
    if (localObject == null)
    {
      localObject = ColorPickerDialogFragment.p1.a(D1().r());
      ((ColorPickerDialogFragment)localObject).i1(this);
    }
    ((DialogFragment)localObject).show(getSupportFragmentManager(), "ColorPickerFragment");
  }
  
  private final void L1()
  {
    String str = this.M3;
    if (str != null)
    {
      Object localObject = this.J3.iterator();
      while (((Iterator)localObject).hasNext())
      {
        KasaLightState localKasaLightState = ((ColorPaintingSegment)((Iterator)localObject).next()).e();
        BrightnessSeekBar localBrightnessSeekBar = ((ActivityColorPaintingMakeBinding)f1()).c;
        j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
        localKasaLightState.setBrightness(Integer.valueOf(localBrightnessSeekBar.getProgress()));
      }
      localObject = D1().w(str);
      if (localObject != null)
      {
        localObject = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.i(D1().m(), (CustomizedEffect)localObject, this.J3);
        D1().x((CustomizedEffect)localObject);
      }
    }
  }
  
  private final void M1(int paramInt1, int paramInt2)
  {
    paramInt2 = this.J3.size();
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      ColorPaintingSegment localColorPaintingSegment = ColorPaintingSegment.b((ColorPaintingSegment)this.J3.get(paramInt1), null, 0, false, 7, null);
      KasaLightState localKasaLightState = KasaLightState.builder().o();
      localKasaLightState.merge(this.K3);
      if (!b.a(localColorPaintingSegment.e(), localKasaLightState)) {
        return;
      }
      ((ColorPaintingSegment)this.J3.get(paramInt1)).e().merge(localKasaLightState);
    }
  }
  
  private final void N1(int paramInt)
  {
    Object localObject = this.J3;
    ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      KasaLightState localKasaLightState = ((ColorPaintingSegment)((Iterator)localObject).next()).e();
      Integer localInteger = localKasaLightState.getHue();
      int i;
      if (localInteger != null) {
        i = localInteger.intValue();
      } else {
        i = 40;
      }
      localInteger = localKasaLightState.getSaturation();
      int j;
      if (localInteger != null) {
        j = localInteger.intValue();
      } else {
        j = 100;
      }
      localArrayList.add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(i, j, 100).f()));
    }
    if (paramInt <= 10) {
      ((ActivityColorPaintingMakeBinding)f1()).q.d(paramInt);
    }
    ((ActivityColorPaintingMakeBinding)f1()).q.i(localArrayList);
  }
  
  private final void O1(String paramString)
  {
    D1().u(paramString);
  }
  
  private final void P1(int paramInt)
  {
    D1().v(paramInt);
    ((ActivityColorPaintingMakeBinding)f1()).q.setPaintingColor(paramInt);
  }
  
  private final void s1()
  {
    Iterator localIterator = this.J3.iterator();
    while (localIterator.hasNext())
    {
      KasaLightState localKasaLightState = ((ColorPaintingSegment)localIterator.next()).e();
      localObject = ((ActivityColorPaintingMakeBinding)f1()).c;
      j.d(localObject, "mBinding.brightnessSeekBar");
      localKasaLightState.setBrightness(Integer.valueOf(((BrightnessSeekBar)localObject).getProgress()));
    }
    Object localObject = com.tplink.iot.devices.lightstrip.lightingeffect.a.b.d(D1().m(), this.J3);
    D1().g((CustomizedEffect)localObject);
  }
  
  private final List<ColorPaintingSegment> t1(int paramInt1, int paramInt2, List<? extends KasaLightState> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 < paramInt2)
    {
      KasaLightState localKasaLightState = (KasaLightState)paramList.get(paramInt1);
      localKasaLightState.setStartIndex(Integer.valueOf(paramInt1));
      localKasaLightState.setEndIndex(Integer.valueOf(paramInt1));
      localArrayList.add(new ColorPaintingSegment(localKasaLightState, paramInt1, paramBoolean));
      paramInt1++;
    }
    return localArrayList;
  }
  
  private final List<ColorPaintingSegment> u1(int paramInt, LightStripLightingEffect paramLightStripLightingEffect)
  {
    if (paramLightStripLightingEffect != null)
    {
      localList = paramLightStripLightingEffect.getSegments();
      if (localList != null)
      {
        i = localList.size();
        break label27;
      }
    }
    int i = 0;
    label27:
    List localList = A1(Math.max(paramInt, i), paramLightStripLightingEffect);
    paramLightStripLightingEffect = new ArrayList();
    paramLightStripLightingEffect.addAll(v1(this, 0, paramInt, localList, false, 8, null));
    if (paramInt < i) {
      paramLightStripLightingEffect.addAll(t1(paramInt, i, localList, false));
    }
    return paramLightStripLightingEffect;
  }
  
  private final void x1()
  {
    String str = this.M3;
    if (str != null) {
      D1().h(str);
    }
  }
  
  private final LightStripLightingEffect y1(int paramInt, LightStripLightingEffect paramLightStripLightingEffect)
  {
    return d.y(d.h(paramLightStripLightingEffect, paramInt, ExpansionStrategy.REPEAT));
  }
  
  private final int z1(List<ColorPaintingSegment> paramList, KasaLightState paramKasaLightState)
  {
    Object localObject1 = paramList.iterator();
    Object localObject2;
    do
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      paramList = ((Iterator)localObject1).next();
    } while (!(((ColorPaintingSegment)paramList).f() ^ true));
    break label47;
    paramList = null;
    label47:
    localObject1 = (ColorPaintingSegment)paramList;
    paramList = (List<ColorPaintingSegment>)localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ColorPaintingSegment)localObject1).e();
      paramList = (List<ColorPaintingSegment>)localObject2;
      if (localObject1 != null) {
        paramList = ((KasaLightState)localObject1).getBrightness();
      }
    }
    int i;
    if (paramList != null)
    {
      i = paramList.intValue();
    }
    else
    {
      paramList = paramKasaLightState.getBrightness();
      j.d(paramList, "paintToolValue.brightness");
      i = paramList.intValue();
    }
    return i;
  }
  
  public void Q(@ColorInt int paramInt1, int paramInt2, int paramInt3)
  {
    P1(paramInt1);
    KasaLightState localKasaLightState = KasaLightState.builder().q(Integer.valueOf(paramInt2)).s(Integer.valueOf(paramInt3)).o();
    this.K3.merge(localKasaLightState);
  }
  
  public int e1()
  {
    return 2131558488;
  }
  
  public void h1()
  {
    super.h1();
    Object localObject = getIntent();
    int i = 0;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ModeExtra", 0);
    }
    this.H3 = i;
    localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("EffectIdExtra");
    } else {
      localObject = null;
    }
    this.M3 = ((String)localObject);
  }
  
  public void j1()
  {
    if (C1()) {
      b1(2131952927);
    } else {
      b1(2131952922);
    }
    Button localButton = ((ActivityColorPaintingMakeBinding)f1()).f;
    j.d(localButton, "mBinding.btnSave");
    boolean bool = C1();
    int i = 0;
    int j;
    if ((bool ^ true)) {
      j = 0;
    } else {
      j = 8;
    }
    localButton.setVisibility(j);
    localButton = ((ActivityColorPaintingMakeBinding)f1()).d;
    j.d(localButton, "mBinding.btnDelete");
    if (C1()) {
      j = i;
    } else {
      j = 8;
    }
    localButton.setVisibility(j);
    ((ActivityColorPaintingMakeBinding)f1()).q.setPaintingColor(D1().r());
    ((ActivityColorPaintingMakeBinding)f1()).q.setOnColorUpdateListener(new b(this));
    ((ActivityColorPaintingMakeBinding)f1()).c.e(100);
    F1();
  }
  
  public void l1()
  {
    ((ActivityColorPaintingMakeBinding)f1()).h(this);
    ((ActivityColorPaintingMakeBinding)f1()).i(D1());
  }
  
  public void m1()
  {
    D1().j().observe(this, new l(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("EffectName");
      if (paramIntent != null) {
        O1(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362912)) {
      E1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362348)) {
      K1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362102)) {
      I1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362046)) {
      x1();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (C1())
    {
      getMenuInflater().inflate(2131623941, paramMenu);
      if (paramMenu != null) {
        paramMenu = paramMenu.findItem(2131362300);
      } else {
        paramMenu = null;
      }
      this.I3 = paramMenu;
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      I1();
      return true;
    }
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
  {
    public final Intent a(Context paramContext, String paramString1, int paramInt, String paramString2)
    {
      j.e(paramContext, "context");
      j.e(paramString1, "deviceIdMD5");
      paramContext = new Intent(paramContext, ColorPaintingMakeActivity.class);
      paramContext.putExtra("device_id_md5", paramString1);
      paramContext.putExtra("ModeExtra", paramInt);
      paramContext.putExtra("EffectIdExtra", paramString2);
      return paramContext;
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<Integer, Integer, kotlin.p>
  {
    b(ColorPaintingMakeActivity paramColorPaintingMakeActivity)
    {
      super();
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      ColorPaintingMakeActivity.r1(this.c, paramInt1, paramInt2);
    }
  }
  
  static final class c<T1, T2, R>
    implements io.reactivex.g0.c<Integer, CustomizedEffect, Pair<? extends Integer, ? extends CustomizedEffect>>
  {
    public static final c c = new c();
    
    public final Pair<Integer, CustomizedEffect> a(Integer paramInteger, CustomizedEffect paramCustomizedEffect)
    {
      j.e(paramInteger, "len");
      j.e(paramCustomizedEffect, "effect");
      return new Pair(paramInteger, paramCustomizedEffect);
    }
  }
  
  static final class d<T>
    implements g<io.reactivex.e0.c>
  {
    d(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      com.tplink.iot.Utils.extension.e.m(this.c, null, 1, null);
    }
  }
  
  static final class e<T>
    implements g<Pair<? extends Integer, ? extends CustomizedEffect>>
  {
    e(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(Pair<Integer, ? extends CustomizedEffect> paramPair)
    {
      int i = ((Number)paramPair.component1()).intValue();
      paramPair = (CustomizedEffect)paramPair.component2();
      com.tplink.iot.Utils.extension.e.a();
      ColorPaintingMakeActivity.p1(this.c, i, d.x(paramPair));
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      com.tplink.iot.Utils.extension.e.e(this.c, null, 1, null);
    }
  }
  
  static final class g<T>
    implements g<io.reactivex.e0.c>
  {
    g(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      com.tplink.iot.Utils.extension.e.m(this.c, null, 1, null);
    }
  }
  
  static final class h<T>
    implements g<Integer>
  {
    h(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(Integer paramInteger)
    {
      com.tplink.iot.Utils.extension.e.a();
      ColorPaintingMakeActivity localColorPaintingMakeActivity = this.c;
      j.d(paramInteger, "it");
      ColorPaintingMakeActivity.o1(localColorPaintingMakeActivity, paramInteger.intValue());
    }
  }
  
  static final class i<T>
    implements g<Throwable>
  {
    i(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      com.tplink.iot.Utils.extension.e.e(this.c, null, 1, null);
    }
  }
  
  static final class j
    extends Lambda
    implements kotlin.jvm.b.a<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e>
  {
    public static final j c = new j();
    
    j()
    {
      super();
    }
    
    public final com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e a()
    {
      return new com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e();
    }
  }
  
  static final class k
    extends Lambda
    implements kotlin.jvm.b.a<ColorPaintingMakeViewModel>
  {
    k(ColorPaintingMakeActivity paramColorPaintingMakeActivity)
    {
      super();
    }
    
    public final ColorPaintingMakeViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, ColorPaintingMakeActivity.n1((ColorPaintingMakeActivity)localObject))).get(ColorPaintingMakeViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (ColorPaintingMakeViewModel)localObject;
    }
  }
  
  static final class l<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    l(ColorPaintingMakeActivity paramColorPaintingMakeActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null)
      {
        Integer localInteger = (Integer)parama.a();
        if (localInteger != null)
        {
          parama = this.a;
          j.d(localInteger, "code");
          ColorPaintingMakeActivity.q1(parama, localInteger.intValue());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\ColorPaintingMakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */