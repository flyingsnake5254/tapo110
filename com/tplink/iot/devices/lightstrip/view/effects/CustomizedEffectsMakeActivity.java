package com.tplink.iot.devices.lightstrip.view.effects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityCustomizedEffectsMakeBinding;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.adapter.HorizontalPredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter.a;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.b;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.b.a;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor.Companion;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LightingEffectTemplateProcessor;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.PredefinedEffectsTemplateInput;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.Speed;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorPaletteView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorSpectrumPickerView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorSpectrumPickerView.a;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c.a;
import com.tplink.iot.g.b.a.a.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.BrightnessSeekBar.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta.LightingEffectMetaBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectsConstants;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.Utils.y;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

public final class CustomizedEffectsMakeActivity
  extends IoTMVVMBaseActivity<ActivityCustomizedEffectsMakeBinding>
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public static final a p0 = new a(null);
  private String H3;
  private String I3;
  private Integer J3 = LightingEffectsConstants.DEFAULT_VERSION;
  private final f K3 = h.b(n.c);
  private HorizontalPredefinedEffectsAdapter L3;
  private boolean M3;
  private int p1;
  private MenuItem p2;
  private final f p3 = h.b(new o(this));
  
  private final void B1()
  {
    HorizontalPredefinedEffectsAdapter localHorizontalPredefinedEffectsAdapter = this.L3;
    if (localHorizontalPredefinedEffectsAdapter != null) {
      localHorizontalPredefinedEffectsAdapter.C();
    }
  }
  
  private final void C1()
  {
    String str1 = this.I3;
    if (str1 != null)
    {
      final String str2 = J1().m();
      final PredefinedEffectsTemplateInput localPredefinedEffectsTemplateInput = F1();
      J1().t(str1).N(new b(this, localPredefinedEffectsTemplateInput, str2)).i(G1()).F0();
    }
  }
  
  private final void D1()
  {
    String str = this.H3;
    if (str != null) {
      J1().i(str);
    }
  }
  
  private final int E1(List<LEColor> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = localIterator.next();
        Object localObject = (LEColor)paramList;
        if (((LEColor)localObject).getB() != null)
        {
          localObject = ((LEColor)localObject).getB();
          if ((localObject == null) || (((Integer)localObject).intValue() != 0))
          {
            i = 1;
            break label67;
          }
        }
        i = 0;
        label67:
        if (i != 0) {
          break label77;
        }
      }
      paramList = null;
      label77:
      paramList = (LEColor)paramList;
      if (paramList != null)
      {
        paramList = paramList.getB();
        if (paramList != null)
        {
          i = paramList.intValue();
          break label108;
        }
      }
    }
    int i = 100;
    label108:
    return i;
  }
  
  private final PredefinedEffectsTemplateInput F1()
  {
    int i = P1();
    Object localObject1 = ((ActivityCustomizedEffectsMakeBinding)f1()).c;
    kotlin.jvm.internal.j.d(localObject1, "mBinding.brightnessSeekBar");
    int j = ((BrightnessSeekBar)localObject1).getProgress();
    Object localObject2 = ((ActivityCustomizedEffectsMakeBinding)f1()).y.getHSBColors();
    localObject1 = new ArrayList(kotlin.collections.l.l((Iterable)localObject2, 10));
    Iterator localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localIterator.next();
      ((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject2).e(j);
      ((Collection)localObject1).add(LEColor.Companion.fromHSB((com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c)localObject2));
    }
    return new PredefinedEffectsTemplateInput((List)localObject1, new Speed(Integer.valueOf(i)), 0, 4, null);
  }
  
  private final <T> u<T, T> G1()
  {
    return new c(this);
  }
  
  private final boolean H1()
  {
    int i = this.p1;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private final LightingEffectTemplateProcessor I1()
  {
    return (LightingEffectTemplateProcessor)this.K3.getValue();
  }
  
  private final CustomizedEffectsMakeViewModel J1()
  {
    return (CustomizedEffectsMakeViewModel)this.p3.getValue();
  }
  
  private final void K1()
  {
    startActivityForResult(EditEffectNameActivity.p0.a(this, J1().m()), 1);
  }
  
  private final void L1()
  {
    if (H1())
    {
      String str = this.H3;
      if (str != null) {
        J1().j(str).F(new h(this)).l0(io.reactivex.d0.b.a.a()).E(new i(this)).C(new j(this)).F0();
      }
    }
  }
  
  private final void M1(CustomizedEffect paramCustomizedEffect)
  {
    this.I3 = paramCustomizedEffect.getPredefinedEffectId();
    S1(paramCustomizedEffect.getVersion());
    Object localObject1 = paramCustomizedEffect.getMeta();
    if (localObject1 != null)
    {
      localObject1 = ((LightingEffectMeta)localObject1).getAlias();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    PredefinedEffectsTemplateInput localPredefinedEffectsTemplateInput = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.w(paramCustomizedEffect);
    if (localPredefinedEffectsTemplateInput != null)
    {
      paramCustomizedEffect = localPredefinedEffectsTemplateInput.getSpeed();
      if (paramCustomizedEffect != null)
      {
        paramCustomizedEffect = paramCustomizedEffect.getValue();
        if (paramCustomizedEffect != null)
        {
          i = paramCustomizedEffect.intValue();
          break label80;
        }
      }
    }
    int i = 0;
    label80:
    Object localObject2;
    if (localPredefinedEffectsTemplateInput != null)
    {
      paramCustomizedEffect = localPredefinedEffectsTemplateInput.getColors();
      if (paramCustomizedEffect != null)
      {
        localObject2 = new ArrayList(kotlin.collections.l.l(paramCustomizedEffect, 10));
        Iterator localIterator = paramCustomizedEffect.iterator();
        for (;;)
        {
          paramCustomizedEffect = (CustomizedEffect)localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          ((Collection)localObject2).add(((LEColor)localIterator.next()).toHSB());
        }
      }
    }
    paramCustomizedEffect = com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c.b;
    paramCustomizedEffect = kotlin.collections.l.g(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c[] { paramCustomizedEffect.a(), paramCustomizedEffect.a() });
    if (localPredefinedEffectsTemplateInput != null) {
      localObject2 = localPredefinedEffectsTemplateInput.getColors();
    } else {
      localObject2 = null;
    }
    Z1((String)localObject1, i, paramCustomizedEffect, E1((List)localObject2));
  }
  
  private final void N1()
  {
    if ((!H1()) && (!this.M3))
    {
      Object localObject = this.L3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).Q(0);
      }
      localObject = this.L3;
      if (localObject != null)
      {
        localObject = (com.tplink.iot.g.b.b.d)((GeneralAdapter)localObject).o(0);
        if (localObject != null)
        {
          this.M3 = true;
          O1((com.tplink.iot.g.b.b.d)localObject);
        }
      }
    }
  }
  
  private final void O1(final com.tplink.iot.g.b.b.d paramd)
  {
    final String str = paramd.f();
    if (str != null)
    {
      this.I3 = str;
      J1().r(str).F(new k(this)).l0(io.reactivex.d0.b.a.a()).E(new l(this, paramd, str)).C(new m(this)).F0();
    }
  }
  
  private final int P1()
  {
    SeekBar localSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p0;
    kotlin.jvm.internal.j.d(localSeekBar, "mBinding.seekBarAnimSpeed");
    int i = localSeekBar.getMax();
    localSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p0;
    kotlin.jvm.internal.j.d(localSeekBar, "mBinding.seekBarAnimSpeed");
    return i - localSeekBar.getProgress();
  }
  
  private final void Q1()
  {
    Object localObject = ((ActivityCustomizedEffectsMakeBinding)f1()).p1;
    kotlin.jvm.internal.j.d(localObject, "mBinding.seekBarColors");
    int i = ((SeekBar)localObject).getProgress() + 1;
    localObject = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      ((ArrayList)localObject).add(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c.b.a());
    }
    ((ActivityCustomizedEffectsMakeBinding)f1()).y.setHSBColors((List)localObject);
    B1();
  }
  
  private final void R1()
  {
    if (H1()) {
      W1();
    } else {
      C1();
    }
  }
  
  private final void S1(Integer paramInteger)
  {
    if (paramInteger == null) {
      paramInteger = LightingEffectsConstants.DEFAULT_VERSION;
    }
    this.J3 = paramInteger;
  }
  
  private final void T1(CustomizedEffect paramCustomizedEffect, String paramString, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput)
  {
    paramCustomizedEffect.setMeta(LightingEffectMeta.builder().alias(paramString).build());
    paramString = com.tplink.libtpnetwork.Utils.i.i(paramPredefinedEffectsTemplateInput);
    kotlin.jvm.internal.j.d(paramString, "GsonUtils.toJsonTree(inputData)");
    paramCustomizedEffect.setTemplateInput(paramString.c());
  }
  
  private final void U1(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 100)
    {
      if (paramInt != 200)
      {
        if (paramInt == 300) {
          e.e(this, null, 1, null);
        }
      }
      else
      {
        e.a();
        if (paramBoolean) {
          finish();
        }
      }
    }
    else {
      e.m(this, null, 1, null);
    }
  }
  
  private final int V1(int paramInt)
  {
    SeekBar localSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p0;
    kotlin.jvm.internal.j.d(localSeekBar, "mBinding.seekBarAnimSpeed");
    return localSeekBar.getMax() - paramInt;
  }
  
  private final void W1()
  {
    final String str1 = this.H3;
    Object localObject1 = "";
    if (str1 == null) {
      str1 = "";
    }
    final Object localObject2 = this.I3;
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    final String str2 = J1().m();
    localObject2 = F1();
    J1().t((String)localObject1).N(new s(this, (PredefinedEffectsTemplateInput)localObject2, str2, str1)).i(G1()).F0();
  }
  
  private final void X1(String paramString)
  {
    J1().x(paramString);
  }
  
  private final void Y1(List<? extends PredefinedEffect> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PredefinedEffect localPredefinedEffect = (PredefinedEffect)paramList.next();
      Object localObject = localPredefinedEffect.getMeta();
      if (localObject != null)
      {
        localObject = ((LightingEffectMeta)localObject).getAlias();
        if (localObject != null)
        {
          boolean bool = J1().u();
          if ((localPredefinedEffect.getType() != Type.PULSE) || (bool))
          {
            localObject = PredefinedEffectsAdapter.h.b((String)localObject);
            if (localObject != null)
            {
              ((com.tplink.iot.g.b.b.d)localObject).l(localPredefinedEffect);
              localArrayList.add(localObject);
            }
          }
        }
      }
    }
    paramList = this.L3;
    if (paramList != null) {
      paramList.T(localArrayList);
    }
    N1();
  }
  
  private final void Z1(String paramString, int paramInt1, List<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c> paramList, int paramInt2)
  {
    J1().x(paramString);
    paramString = ((ActivityCustomizedEffectsMakeBinding)f1()).p0;
    kotlin.jvm.internal.j.d(paramString, "mBinding.seekBarAnimSpeed");
    paramString.setProgress(V1(paramInt1));
    paramString = ((ActivityCustomizedEffectsMakeBinding)f1()).p1;
    kotlin.jvm.internal.j.d(paramString, "mBinding.seekBarColors");
    paramString.setProgress(paramList.size() - 1);
    ((ActivityCustomizedEffectsMakeBinding)f1()).y.setOriginHSBColors(paramList);
    ((ActivityCustomizedEffectsMakeBinding)f1()).c.e(paramInt2);
  }
  
  public int e1()
  {
    return 2131558492;
  }
  
  public void h1()
  {
    super.h1();
    Object localObject = getIntent();
    int i = 0;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("ModeExtra", 0);
    }
    this.p1 = i;
    localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("EffectIdExtra");
    } else {
      localObject = null;
    }
    this.H3 = ((String)localObject);
  }
  
  public void j1()
  {
    if (H1()) {
      b1(2131952927);
    } else {
      b1(2131952922);
    }
    Object localObject1 = ((ActivityCustomizedEffectsMakeBinding)f1()).f;
    kotlin.jvm.internal.j.d(localObject1, "mBinding.btnSave");
    boolean bool = H1();
    int i = 8;
    if ((bool ^ true)) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = ((ActivityCustomizedEffectsMakeBinding)f1()).d;
    kotlin.jvm.internal.j.d(localObject1, "mBinding.btnDelete");
    int j = i;
    if (H1()) {
      j = 0;
    }
    ((View)localObject1).setVisibility(j);
    ((ActivityCustomizedEffectsMakeBinding)f1()).c.e(100);
    ((ActivityCustomizedEffectsMakeBinding)f1()).c.setOnSeekbarChangeListener(new e(this));
    Object localObject2 = new HorizontalPredefinedEffectsAdapter(this, kotlin.collections.l.d(), 0, 4, null);
    ((LightStripEffectsBaseAdapter)localObject2).S(new d((HorizontalPredefinedEffectsAdapter)localObject2, this));
    localObject1 = p.a;
    this.L3 = ((HorizontalPredefinedEffectsAdapter)localObject2);
    localObject1 = ((ActivityCustomizedEffectsMakeBinding)f1()).z;
    ((RecyclerView)localObject1).setAdapter(this.L3);
    com.tplink.iot.Utils.extension.i.g((RecyclerView)localObject1);
    localObject2 = ((ActivityCustomizedEffectsMakeBinding)f1()).q;
    ((DiscreteSeekBarTextView)localObject2).setValueFormatter(f.c);
    localObject1 = ((ActivityCustomizedEffectsMakeBinding)f1()).p1;
    kotlin.jvm.internal.j.d(localObject1, "mBinding.seekBarColors");
    DiscreteSeekBarTextView.f((DiscreteSeekBarTextView)localObject2, (SeekBar)localObject1, false, 2, null);
    ((DiscreteSeekBarTextView)localObject2).setOnSeekBarChangeListener(this);
    ((ActivityCustomizedEffectsMakeBinding)f1()).p0.setOnSeekBarChangeListener(this);
    ((ActivityCustomizedEffectsMakeBinding)f1()).y.setSpectrumSelectionListener(new g(this));
  }
  
  public void k1()
  {
    J1().v();
    L1();
  }
  
  public void l1()
  {
    ((ActivityCustomizedEffectsMakeBinding)f1()).h(this);
    ((ActivityCustomizedEffectsMakeBinding)f1()).i(J1());
  }
  
  public void m1()
  {
    J1().s().observe(this, new p(this));
    J1().o().observe(this, new q(this));
    J1().l().observe(this, new r(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("EffectName");
      if (paramIntent != null) {
        X1(paramIntent);
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
      K1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362102)) {
      R1();
    } else if ((paramView != null) && (paramView.intValue() == 2131362046)) {
      D1();
    } else if ((paramView != null) && (paramView.intValue() == 2131364587)) {
      Q1();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (H1())
    {
      getMenuInflater().inflate(2131623941, paramMenu);
      if (paramMenu != null) {
        paramMenu = paramMenu.findItem(2131362300);
      } else {
        paramMenu = null;
      }
      this.p2 = paramMenu;
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    kotlin.jvm.internal.j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      R1();
      return true;
    }
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramSeekBar != null)
    {
      paramInt = paramSeekBar.getId();
      SeekBar localSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p1;
      kotlin.jvm.internal.j.d(localSeekBar, "mBinding.seekBarColors");
      if ((paramInt == localSeekBar.getId()) && (paramBoolean))
      {
        paramSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).y;
        kotlin.jvm.internal.j.d(paramSeekBar, "mBinding.multiColorPicker");
        paramInt = paramSeekBar.getNumCursors();
        paramSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p1;
        kotlin.jvm.internal.j.d(paramSeekBar, "mBinding.seekBarColors");
        paramInt = paramSeekBar.getProgress() + 1 - paramInt;
        if (paramInt > 0)
        {
          ((ActivityCustomizedEffectsMakeBinding)f1()).y.J(paramInt);
        }
        else if (paramInt < 0)
        {
          int i = Math.abs(paramInt);
          for (paramInt = 0; paramInt < i; paramInt++) {
            ((ActivityCustomizedEffectsMakeBinding)f1()).y.L();
          }
        }
        B1();
        return;
      }
    }
    if (paramSeekBar != null)
    {
      paramInt = paramSeekBar.getId();
      paramSeekBar = ((ActivityCustomizedEffectsMakeBinding)f1()).p0;
      kotlin.jvm.internal.j.d(paramSeekBar, "mBinding.seekBarAnimSpeed");
      if ((paramInt == paramSeekBar.getId()) && (paramBoolean)) {
        B1();
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public static final class a
  {
    public final Intent a(Context paramContext, String paramString1, int paramInt, String paramString2)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString1, "deviceIdMD5");
      paramContext = new Intent(paramContext, CustomizedEffectsMakeActivity.class);
      paramContext.putExtra("device_id_md5", paramString1);
      paramContext.putExtra("ModeExtra", paramInt);
      paramContext.putExtra("EffectIdExtra", paramString2);
      return paramContext;
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<PredefinedEffectTemplate, t<? extends CustomizedEffect>>
  {
    b(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput, String paramString) {}
    
    public final t<? extends CustomizedEffect> a(PredefinedEffectTemplate paramPredefinedEffectTemplate)
    {
      kotlin.jvm.internal.j.e(paramPredefinedEffectTemplate, "temp");
      CustomizedEffect localCustomizedEffect = CustomizedEffectsMakeActivity.s1(this.c).compileEffect(paramPredefinedEffectTemplate, localPredefinedEffectsTemplateInput);
      if (localCustomizedEffect != null)
      {
        CustomizedEffectsMakeActivity.x1(this.c, localCustomizedEffect, str2, localPredefinedEffectsTemplateInput);
        localCustomizedEffect.setPredefinedEffectId(paramPredefinedEffectTemplate.getPredefinedEffectId());
        com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.E(localCustomizedEffect, true);
        localCustomizedEffect.setVersion(CustomizedEffectsMakeActivity.r1(this.c));
        paramPredefinedEffectTemplate = new StringBuilder();
        paramPredefinedEffectTemplate.append("创建自定义Effect：");
        paramPredefinedEffectTemplate.append(com.tplink.libtpnetwork.Utils.i.j(localCustomizedEffect));
        b.d.w.c.a.n("LightStrip", paramPredefinedEffectTemplate.toString());
        paramPredefinedEffectTemplate = CustomizedEffectsMakeActivity.t1(this.c).h(localCustomizedEffect);
        if (paramPredefinedEffectTemplate != null) {}
      }
      else
      {
        paramPredefinedEffectTemplate = q.J(new Throwable("Customized Effect is Null"));
      }
      return paramPredefinedEffectTemplate;
    }
  }
  
  static final class c<Upstream, Downstream>
    implements u<T, T>
  {
    c(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final t<T> a(q<T> paramq)
    {
      kotlin.jvm.internal.j.e(paramq, "source");
      return paramq.l0(io.reactivex.d0.b.a.a()).F(new a(this)).z(new b(this)).C(new c(this));
    }
    
    static final class a<T>
      implements g<io.reactivex.e0.c>
    {
      a(CustomizedEffectsMakeActivity.c paramc) {}
      
      public final void a(io.reactivex.e0.c paramc)
      {
        e.m(this.c.a, null, 1, null);
      }
    }
    
    static final class b
      implements io.reactivex.g0.a
    {
      b(CustomizedEffectsMakeActivity.c paramc) {}
      
      public final void run()
      {
        e.a();
        this.a.a.finish();
      }
    }
    
    static final class c<T>
      implements g<Throwable>
    {
      c(CustomizedEffectsMakeActivity.c paramc) {}
      
      public final void a(Throwable paramThrowable)
      {
        int i = y.a(paramThrowable);
        if (i != 15019)
        {
          if (i != 15020)
          {
            e.e(this.c.a, null, 1, null);
          }
          else
          {
            paramThrowable = this.c.a;
            e.k(paramThrowable, paramThrowable.getString(2131953943, new Object[] { Integer.valueOf(16) }), null, 2, null);
          }
        }
        else {
          e.j(this.c.a, 2131953674, null, 2, null);
        }
      }
    }
  }
  
  public static final class d
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.d>
  {
    d(HorizontalPredefinedEffectsAdapter paramHorizontalPredefinedEffectsAdapter, CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public void b()
    {
      a.a.a(this);
    }
    
    public void c(com.tplink.iot.g.b.b.d paramd, int paramInt)
    {
      kotlin.jvm.internal.j.e(paramd, "data");
      this.c.Q(paramInt);
      CustomizedEffectsMakeActivity.v1(jdField_this, paramd);
    }
  }
  
  public static final class e
    implements BrightnessSeekBar.b
  {
    e(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        CustomizedEffectsMakeActivity.n1(this.a);
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.l<Integer, String>
  {
    public static final f c = new f();
    
    f()
    {
      super();
    }
    
    public final String a(int paramInt)
    {
      return String.valueOf(paramInt + 1);
    }
  }
  
  static final class g
    implements MultiColorSpectrumPickerView.a
  {
    g(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(float[] paramArrayOfFloat, boolean paramBoolean, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.a parama)
    {
      if (paramBoolean) {
        CustomizedEffectsMakeActivity.n1(this.a);
      }
    }
  }
  
  static final class h<T>
    implements g<io.reactivex.e0.c>
  {
    h(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class i<T>
    implements g<CustomizedEffect>
  {
    i(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(CustomizedEffect paramCustomizedEffect)
    {
      
      if (paramCustomizedEffect != null) {
        CustomizedEffectsMakeActivity.u1(this.c, paramCustomizedEffect);
      }
    }
  }
  
  static final class j<T>
    implements g<Throwable>
  {
    j(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class k<T>
    implements g<io.reactivex.e0.c>
  {
    k(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class l<T>
    implements g<PredefinedEffect>
  {
    l(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity, com.tplink.iot.g.b.b.d paramd, String paramString) {}
    
    public final void a(PredefinedEffect paramPredefinedEffect)
    {
      
      if (paramPredefinedEffect != null)
      {
        Object localObject1 = CustomizedEffectsMakeActivity.t1(this.c).m();
        if (!CustomizedEffectsMakeActivity.q1(this.c))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramd.h());
          ((StringBuilder)localObject1).append(' ');
          ((StringBuilder)localObject1).append(CustomizedEffectsMakeActivity.t1(this.c).w(str));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        PredefinedEffectsTemplateInput localPredefinedEffectsTemplateInput = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.w(paramPredefinedEffect);
        if (localPredefinedEffectsTemplateInput != null)
        {
          localObject2 = localPredefinedEffectsTemplateInput.getSpeed();
          if (localObject2 != null)
          {
            localObject2 = ((Speed)localObject2).getValue();
            if (localObject2 != null)
            {
              i = ((Integer)localObject2).intValue();
              break label124;
            }
          }
        }
        int i = 0;
        label124:
        Object localObject3;
        if (localPredefinedEffectsTemplateInput != null)
        {
          localObject2 = localPredefinedEffectsTemplateInput.getColors();
          if (localObject2 != null)
          {
            localObject3 = new ArrayList(kotlin.collections.l.l((Iterable)localObject2, 10));
            localObject4 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              localObject2 = localObject3;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(((LEColor)((Iterator)localObject4).next()).toHSB());
            }
          }
        }
        Object localObject2 = com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c.b;
        localObject2 = kotlin.collections.l.g(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c[] { ((c.a)localObject2).a(), ((c.a)localObject2).a() });
        Object localObject4 = this.c;
        if (localPredefinedEffectsTemplateInput != null) {
          localObject3 = localPredefinedEffectsTemplateInput.getColors();
        } else {
          localObject3 = null;
        }
        int j = CustomizedEffectsMakeActivity.o1((CustomizedEffectsMakeActivity)localObject4, (List)localObject3);
        CustomizedEffectsMakeActivity.w1(this.c, paramPredefinedEffect.getVersion());
        CustomizedEffectsMakeActivity.A1(this.c, (String)localObject1, i, (List)localObject2, j);
      }
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class n
    extends Lambda
    implements kotlin.jvm.b.a<LightingEffectTemplateProcessor>
  {
    public static final n c = new n();
    
    n()
    {
      super();
    }
    
    public final LightingEffectTemplateProcessor a()
    {
      return new LightingEffectTemplateProcessor(b.a.a());
    }
  }
  
  static final class o
    extends Lambda
    implements kotlin.jvm.b.a<CustomizedEffectsMakeViewModel>
  {
    o(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity)
    {
      super();
    }
    
    public final CustomizedEffectsMakeViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, CustomizedEffectsMakeActivity.p1((CustomizedEffectsMakeActivity)localObject))).get(CustomizedEffectsMakeViewModel.class);
      kotlin.jvm.internal.j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (CustomizedEffectsMakeViewModel)localObject;
    }
  }
  
  static final class p<T>
    implements Observer<List<? extends PredefinedEffect>>
  {
    p(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(List<? extends PredefinedEffect> paramList)
    {
      if (paramList != null) {
        CustomizedEffectsMakeActivity.z1(this.a, paramList);
      }
    }
  }
  
  static final class q<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    q(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null)
      {
        Integer localInteger = (Integer)parama.a();
        if ((localInteger != null) && (!CustomizedEffectsMakeActivity.q1(this.a)))
        {
          parama = this.a;
          kotlin.jvm.internal.j.d(localInteger, "code");
          CustomizedEffectsMakeActivity.y1(parama, localInteger.intValue(), false);
        }
      }
    }
  }
  
  static final class r<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    r(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null)
      {
        Integer localInteger = (Integer)parama.a();
        if (localInteger != null)
        {
          parama = this.a;
          kotlin.jvm.internal.j.d(localInteger, "code");
          CustomizedEffectsMakeActivity.y1(parama, localInteger.intValue(), true);
        }
      }
    }
  }
  
  static final class s<T, R>
    implements io.reactivex.g0.j<PredefinedEffectTemplate, t<? extends CustomizedEffect>>
  {
    s(CustomizedEffectsMakeActivity paramCustomizedEffectsMakeActivity, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput, String paramString1, String paramString2) {}
    
    public final t<? extends CustomizedEffect> a(PredefinedEffectTemplate paramPredefinedEffectTemplate)
    {
      kotlin.jvm.internal.j.e(paramPredefinedEffectTemplate, "temp");
      CustomizedEffect localCustomizedEffect = CustomizedEffectsMakeActivity.s1(this.c).compileEffect(paramPredefinedEffectTemplate, localObject2);
      if (localCustomizedEffect != null)
      {
        CustomizedEffectsMakeActivity.x1(this.c, localCustomizedEffect, str2, localObject2);
        localCustomizedEffect.setId(str1);
        localCustomizedEffect.setPredefinedEffectId(paramPredefinedEffectTemplate.getPredefinedEffectId());
        localCustomizedEffect.setVersion(CustomizedEffectsMakeActivity.r1(this.c));
        com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.E(localCustomizedEffect, false);
        paramPredefinedEffectTemplate = new StringBuilder();
        paramPredefinedEffectTemplate.append("更新自定义Effect：");
        paramPredefinedEffectTemplate.append(com.tplink.libtpnetwork.Utils.i.j(localCustomizedEffect));
        b.d.w.c.a.n("LightStrip", paramPredefinedEffectTemplate.toString());
        paramPredefinedEffectTemplate = CustomizedEffectsMakeActivity.t1(this.c).y(localCustomizedEffect);
        if (paramPredefinedEffectTemplate != null) {}
      }
      else
      {
        paramPredefinedEffectTemplate = q.J(new Throwable("Customized Effect is Null"));
      }
      return paramPredefinedEffectTemplate;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\CustomizedEffectsMakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */