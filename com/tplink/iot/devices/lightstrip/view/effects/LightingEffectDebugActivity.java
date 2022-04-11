package com.tplink.iot.devices.lightstrip.view.effects;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightingEffectDebugBinding;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.adapter.HorizontalPredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter.a;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.IntRangePickerDialog;
import com.tplink.iot.devices.lightstrip.widget.IntRangePickerDialog.a;
import com.tplink.iot.devices.lightstrip.widget.IntRangePickerDialog.b;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.d.a;
import com.tplink.iot.g.b.a.a.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class LightingEffectDebugActivity
  extends IoTMVVMBaseActivity<ActivityLightingEffectDebugBinding>
  implements View.OnClickListener
{
  public static final b p0 = new b(null);
  private com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c H3;
  private HorizontalPredefinedEffectsAdapter I3;
  private boolean J3;
  private final f K3 = h.b(new t(this));
  private final f p1 = h.b(new s(this));
  private final f p2 = h.b(new q(this));
  private final f p3 = h.b(new r(this));
  
  private final LightingEffectData B1()
  {
    G1().Z(F1().H());
    G1().X(D1().H());
    G1().Y(E1().H());
    return G1().i();
  }
  
  private final void C1()
  {
    String str = com.tplink.libtpnetwork.Utils.i.j(B1());
    Object localObject = getSystemService("clipboard");
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.content.ClipboardManager");
    ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("光效参数", str));
    Toast.makeText(this, "复制成功", 0).show();
  }
  
  private final a D1()
  {
    return (a)this.p2.getValue();
  }
  
  private final a E1()
  {
    return (a)this.p3.getValue();
  }
  
  private final a F1()
  {
    return (a)this.p1.getValue();
  }
  
  private final LightingEffectDebugViewModel G1()
  {
    return (LightingEffectDebugViewModel)this.K3.getValue();
  }
  
  private final void H1(final kotlin.jvm.b.l<? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> paraml)
  {
    final EditText localEditText = new EditText(this);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    localMarginLayoutParams.setMargins(32, 32, 32, 32);
    kotlin.p localp = kotlin.p.a;
    localEditText.setLayoutParams(localMarginLayoutParams);
    new MaterialAlertDialogBuilder(this, 2132017744).setTitle("输入颜色。RGB格式：#FFFFFF").setView(localEditText).setNegativeButton("取消", null).setPositiveButton("确定", new o(this, localEditText, paraml)).show();
  }
  
  private final void I1()
  {
    final EditText localEditText = new EditText(this);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    localMarginLayoutParams.setMargins(32, 32, 32, 32);
    kotlin.p localp = kotlin.p.a;
    localEditText.setLayoutParams(localMarginLayoutParams);
    localEditText.setPadding(36, localEditText.getPaddingTop(), 36, localEditText.getPaddingBottom());
    new MaterialAlertDialogBuilder(this, 2132017744).setTitle("输入光效参数（JSON格式）。").setView(localEditText).setNegativeButton("取消", null).setPositiveButton("确定", new p(this, localEditText)).show();
  }
  
  private final void J1()
  {
    if (!this.J3)
    {
      Object localObject = this.I3;
      if (localObject != null) {
        ((LightStripEffectsBaseAdapter)localObject).Q(0);
      }
      localObject = this.I3;
      if (localObject != null)
      {
        localObject = (com.tplink.iot.g.b.b.d)((GeneralAdapter)localObject).o(0);
        if (localObject != null)
        {
          this.J3 = true;
          L1((com.tplink.iot.g.b.b.d)localObject);
        }
      }
    }
  }
  
  private final void K1(LightingEffectData paramLightingEffectData)
  {
    T1(paramLightingEffectData.sequence);
    Q1(paramLightingEffectData.backgrounds);
    R1(paramLightingEffectData.init_states);
    G1().a0(paramLightingEffectData);
  }
  
  private final void L1(com.tplink.iot.g.b.b.d paramd)
  {
    String str = paramd.h();
    int i = str.hashCode();
    if (i != -1807305034 ? (i == -191907083) && (str.equals("Sunrise")) : str.equals("Sunset"))
    {
      paramd = paramd.g();
      if (paramd != null) {
        K1(paramd);
      }
    }
    else
    {
      paramd = paramd.e();
      if (paramd != null) {
        K1(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(paramd));
      }
    }
  }
  
  private final void M1(final com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc, final kotlin.jvm.b.l<? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> paraml)
  {
    ColorPickerDialogFragment localColorPickerDialogFragment = new ColorPickerDialogFragment();
    com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c localc;
    if (paramc != null) {
      localc = paramc;
    } else {
      localc = this.H3;
    }
    if (localc == null) {
      localc = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(0, 0, 100);
    }
    localColorPickerDialogFragment.h1(localc.g(), localc.b(), localc.c());
    localColorPickerDialogFragment.e1(localc.a());
    localColorPickerDialogFragment.i1(new x(localColorPickerDialogFragment, this, paramc, paraml));
    localColorPickerDialogFragment.f1(true);
    localColorPickerDialogFragment.show(getSupportFragmentManager(), null);
  }
  
  private final void O1(int paramInt1, int paramInt2, Pair<Integer, Integer> paramPair, kotlin.jvm.b.p<? super Integer, ? super Integer, kotlin.p> paramp)
  {
    IntRangePickerDialog localIntRangePickerDialog = IntRangePickerDialog.p1.a(paramInt1, paramInt2, paramPair);
    paramPair = paramp;
    if (paramp != null) {
      paramPair = new c(paramp);
    }
    localIntRangePickerDialog.i1((IntRangePickerDialog.b)paramPair);
    localIntRangePickerDialog.show(getSupportFragmentManager(), null);
  }
  
  private final void P1()
  {
    String str = com.tplink.libtpnetwork.Utils.i.j(B1());
    new MaterialAlertDialogBuilder(this, 2132017744).setTitle("光效参数").setMessage(str).setNegativeButton("取消", null).setPositiveButton("复制", new y(this)).show();
  }
  
  private final void Q1(Integer[][] paramArrayOfInteger)
  {
    if (paramArrayOfInteger != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayOfInteger.length;
      for (int j = 0;; j++)
      {
        localObject = localArrayList;
        if (j >= i) {
          break;
        }
        localObject = paramArrayOfInteger[j];
        if (localObject.length == 3) {
          localObject = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(localObject[0].intValue(), localObject[1].intValue(), localObject[2].intValue());
        } else {
          localObject = null;
        }
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    Object localObject = kotlin.collections.l.d();
    D1().y((List)localObject);
  }
  
  private final void R1(Integer[][] paramArrayOfInteger)
  {
    if (paramArrayOfInteger != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayOfInteger.length;
      for (int j = 0;; j++)
      {
        localObject = localArrayList;
        if (j >= i) {
          break;
        }
        localObject = paramArrayOfInteger[j];
        if (localObject.length == 3) {
          localObject = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(localObject[0].intValue(), localObject[1].intValue(), localObject[2].intValue());
        } else {
          localObject = null;
        }
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    Object localObject = kotlin.collections.l.d();
    E1().y((List)localObject);
  }
  
  private final void S1(List<? extends PredefinedEffect> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new com.tplink.iot.g.b.b.d("Sunrise", 2131690190, null, 4, null);
    ((com.tplink.iot.g.b.b.d)localObject1).m(b.d);
    Object localObject2 = new com.tplink.iot.g.b.b.d("Sunset", 2131690190, null, 4, null);
    ((com.tplink.iot.g.b.b.d)localObject2).m(b.e);
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (PredefinedEffect)((Iterator)localObject2).next();
      localObject1 = paramList.getMeta();
      if (localObject1 != null)
      {
        localObject1 = ((LightingEffectMeta)localObject1).getAlias();
        if (localObject1 != null)
        {
          localObject1 = PredefinedEffectsAdapter.h.b((String)localObject1);
          if (localObject1 != null)
          {
            ((com.tplink.iot.g.b.b.d)localObject1).l(paramList);
            localArrayList.add(localObject1);
          }
        }
      }
    }
    paramList = this.I3;
    if (paramList != null) {
      paramList.T(localArrayList);
    }
    J1();
  }
  
  private final void T1(Integer[][] paramArrayOfInteger)
  {
    if (paramArrayOfInteger != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayOfInteger.length;
      for (int j = 0;; j++)
      {
        localObject = localArrayList;
        if (j >= i) {
          break;
        }
        localObject = paramArrayOfInteger[j];
        if (localObject.length == 3) {
          localObject = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(localObject[0].intValue(), localObject[1].intValue(), localObject[2].intValue());
        } else {
          localObject = null;
        }
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    Object localObject = kotlin.collections.l.d();
    F1().y((List)localObject);
  }
  
  public int e1()
  {
    return 2131558569;
  }
  
  public void j1()
  {
    c1("调试光效参数");
    F1().L(new e(this), new h(this), new i(this));
    ((ActivityLightingEffectDebugBinding)f1()).p3.setAdapter(F1());
    D1().L(new j(this), new k(this), new l(this));
    Object localObject1 = ((ActivityLightingEffectDebugBinding)f1()).p0;
    j.d(localObject1, "mBinding.rvBackgroundsColors");
    ((RecyclerView)localObject1).setAdapter(D1());
    E1().L(new m(this), new n(this), new f(this));
    localObject1 = ((ActivityLightingEffectDebugBinding)f1()).p1;
    j.d(localObject1, "mBinding.rvInitStatesColors");
    ((RecyclerView)localObject1).setAdapter(E1());
    Object localObject2 = new HorizontalPredefinedEffectsAdapter(this, kotlin.collections.l.d(), 0, 4, null);
    ((LightStripEffectsBaseAdapter)localObject2).S(new d((HorizontalPredefinedEffectsAdapter)localObject2, this));
    localObject1 = kotlin.p.a;
    this.I3 = ((HorizontalPredefinedEffectsAdapter)localObject2);
    localObject1 = ((ActivityLightingEffectDebugBinding)f1()).p2;
    ((RecyclerView)localObject1).setAdapter(this.I3);
    com.tplink.iot.Utils.extension.i.g((RecyclerView)localObject1);
    localObject1 = kotlin.collections.l.g(new c[] { new c("Effect Type", G1().v()), new c("Repeat Times", G1().K()), new c("Direction", G1().p()), new c("Transition", G1().V()), new c("Duration", G1().s()), new c("Sequence colos", G1().O()), new c("Expansion strategy", G1().x()), new c("Spread number", G1().Q()), new c("Transition range", G1().U()), new c("Fade off", G1().z()), new c("Backgrounds", G1().k()), new c("Random seed", G1().I()), new c("Hue range", G1().C()), new c("Saturation range", G1().N()), new c("Brightness range", G1().n()), new c("Init states", G1().D()) }).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      Object localObject3 = getLayoutInflater().inflate(2131558735, ((ActivityLightingEffectDebugBinding)f1()).z, false);
      Objects.requireNonNull(localObject3, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
      localObject3 = (Chip)localObject3;
      ((CheckBox)localObject3).setText(((c)localObject2).a());
      ((Chip)localObject3).setChecked(true);
      ((CheckBox)localObject3).setOnCheckedChangeListener(new a((c)localObject2));
      ((c)localObject2).b().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback()
      {
        public void onPropertyChanged(Observable paramAnonymousObservable, int paramAnonymousInt)
        {
          Observable localObservable = paramAnonymousObservable;
          if (!(paramAnonymousObservable instanceof ObservableBoolean)) {
            localObservable = null;
          }
          paramAnonymousObservable = (ObservableBoolean)localObservable;
          if (paramAnonymousObservable != null) {
            this.a.setChecked(paramAnonymousObservable.get());
          }
        }
      });
      ((ActivityLightingEffectDebugBinding)f1()).z.addView((View)localObject3);
    }
    ((ActivityLightingEffectDebugBinding)f1()).R3.setOnClickListener(new g(this));
  }
  
  public void l1()
  {
    super.l1();
    ((ActivityLightingEffectDebugBinding)f1()).h(this);
    ((ActivityLightingEffectDebugBinding)f1()).i(G1());
  }
  
  public void m1()
  {
    G1().j().observe(this, new z(this));
    G1().G().observe(this, new a0(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362100)) {
      F1().K();
    } else if ((paramView != null) && (paramView.intValue() == 2131362098)) {
      D1().K();
    } else if ((paramView != null) && (paramView.intValue() == 2131362099)) {
      E1().K();
    } else if ((paramView != null) && (paramView.intValue() == 2131362069)) {
      O1(0, 360, n.a(Integer.valueOf(G1().B().get()), Integer.valueOf(G1().A().get())), new u(this));
    } else if ((paramView != null) && (paramView.intValue() == 2131362101)) {
      O1(0, 100, n.a(Integer.valueOf(G1().M().get()), Integer.valueOf(G1().L().get())), new v(this));
    } else if ((paramView != null) && (paramView.intValue() == 2131362039)) {
      O1(0, 100, n.a(Integer.valueOf(G1().m().get()), Integer.valueOf(G1().l().get())), new w(this));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623956, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    switch (paramMenuItem.getItemId())
    {
    default: 
      super.onOptionsItemSelected(paramMenuItem);
      break;
    case 2131362105: 
      P1();
      break;
    case 2131362070: 
      I1();
      break;
    case 2131362043: 
      C1();
      break;
    case 2131362036: 
      G1().g(B1()).y();
    }
    return true;
  }
  
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(LightingEffectDebugActivity.c paramc) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      this.a.b().set(paramBoolean);
    }
  }
  
  static final class a0<T>
    implements Observer<List<? extends PredefinedEffect>>
  {
    a0(LightingEffectDebugActivity paramLightingEffectDebugActivity) {}
    
    public final void a(List<? extends PredefinedEffect> paramList)
    {
      if (paramList != null) {
        LightingEffectDebugActivity.A1(this.a, paramList);
      }
    }
  }
  
  public static final class b {}
  
  public static final class c
  {
    private final String a;
    private final ObservableBoolean b;
    
    public c(String paramString, ObservableBoolean paramObservableBoolean)
    {
      this.a = paramString;
      this.b = paramObservableBoolean;
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final ObservableBoolean b()
    {
      return this.b;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((j.a(this.a, ((c)paramObject).a)) && (j.a(this.b, ((c)paramObject).b))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      Object localObject = this.a;
      int i = 0;
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.b;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j * 31 + i;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EffectParamItem(name=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", visible=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  public static final class d
    implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.d>
  {
    d(HorizontalPredefinedEffectsAdapter paramHorizontalPredefinedEffectsAdapter, LightingEffectDebugActivity paramLightingEffectDebugActivity) {}
    
    public void b()
    {
      a.a.a(this);
    }
    
    public void c(com.tplink.iot.g.b.b.d paramd, int paramInt)
    {
      j.e(paramd, "data");
      this.c.Q(paramInt);
      LightingEffectDebugActivity.x1(jdField_this, paramd);
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    e(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.N1(this.c, null, new a(this), 1, null);
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.e parame)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.t1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
  {
    f(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(final int paramInt, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
    {
      j.e(paramc, "hsb");
      LightingEffectDebugActivity.y1(this.c, paramc, new a(this, paramInt));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.f paramf, int paramInt)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.r1(this.c.c).M(paramInt, paramc);
      }
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(LightingEffectDebugActivity paramLightingEffectDebugActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = LightingEffectDebugActivity.p1(this.c).z;
      j.d(paramView, "mBinding.chipGroupParams");
      ChipGroup localChipGroup = LightingEffectDebugActivity.p1(this.c).z;
      j.d(localChipGroup, "mBinding.chipGroupParams");
      int i = localChipGroup.getVisibility();
      int j = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0) {
        i = j;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
    }
  }
  
  static final class h
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    h(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.v1(this.c, new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.h paramh)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.t1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
  {
    i(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(final int paramInt, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
    {
      j.e(paramc, "hsb");
      LightingEffectDebugActivity.y1(this.c, paramc, new a(this, paramInt));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.i parami, int paramInt)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.t1(this.c.c).M(paramInt, paramc);
      }
    }
  }
  
  static final class j
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    j(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.N1(this.c, null, new a(this), 1, null);
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.j paramj)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.o1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class k
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    k(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.v1(this.c, new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.k paramk)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.o1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class l
    extends Lambda
    implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
  {
    l(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(final int paramInt, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
    {
      j.e(paramc, "hsb");
      LightingEffectDebugActivity.y1(this.c, paramc, new a(this, paramInt));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.l paraml, int paramInt)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.o1(this.c.c).M(paramInt, paramc);
      }
    }
  }
  
  static final class m
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    m(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.N1(this.c, null, new a(this), 1, null);
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.m paramm)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.r1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class n
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    n(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a()
    {
      LightingEffectDebugActivity.v1(this.c, new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p>
    {
      a(LightingEffectDebugActivity.n paramn)
      {
        super();
      }
      
      public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc)
      {
        j.e(paramc, "it");
        LightingEffectDebugActivity.r1(this.c.c).D(paramc);
      }
    }
  }
  
  static final class o
    implements DialogInterface.OnClickListener
  {
    o(LightingEffectDebugActivity paramLightingEffectDebugActivity, EditText paramEditText, kotlin.jvm.b.l paraml) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      try
      {
        paramInt = Color.parseColor(localEditText.getText().toString());
        paraml.invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.d.a.a(paramInt).c());
      }
      catch (Exception paramDialogInterface)
      {
        Toast.makeText(this.c, "输入错误", 0).show();
      }
    }
  }
  
  static final class p
    implements DialogInterface.OnClickListener
  {
    p(LightingEffectDebugActivity paramLightingEffectDebugActivity, EditText paramEditText) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      try
      {
        paramDialogInterface = com.tplink.libtpnetwork.Utils.i.b(localEditText.getText().toString(), LightingEffectData.class);
        j.d(paramDialogInterface, "GsonUtils.fromJson(editT…ngEffectData::class.java)");
        paramDialogInterface = (LightingEffectData)paramDialogInterface;
        LightingEffectDebugActivity.w1(this.c, paramDialogInterface);
        paramDialogInterface = LightingEffectDebugActivity.s1(this.c);
        if (paramDialogInterface != null) {
          paramDialogInterface.C();
        }
      }
      catch (Exception paramDialogInterface)
      {
        Toast.makeText(this.c, "参数错误", 0).show();
      }
    }
  }
  
  static final class q
    extends Lambda
    implements kotlin.jvm.b.a<a>
  {
    q(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final a a()
    {
      return new a(this.c);
    }
  }
  
  static final class r
    extends Lambda
    implements kotlin.jvm.b.a<a>
  {
    r(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final a a()
    {
      return new a(this.c);
    }
  }
  
  static final class s
    extends Lambda
    implements kotlin.jvm.b.a<a>
  {
    s(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final a a()
    {
      return new a(this.c);
    }
  }
  
  static final class t
    extends Lambda
    implements kotlin.jvm.b.a<LightingEffectDebugViewModel>
  {
    t(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final LightingEffectDebugViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, LightingEffectDebugActivity.q1((LightingEffectDebugActivity)localObject))).get(LightingEffectDebugViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightingEffectDebugViewModel)localObject;
    }
  }
  
  static final class u
    extends Lambda
    implements kotlin.jvm.b.p<Integer, Integer, kotlin.p>
  {
    u(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      LightingEffectDebugActivity.u1(this.c).B().set(paramInt1);
      LightingEffectDebugActivity.u1(this.c).A().set(paramInt2);
    }
  }
  
  static final class v
    extends Lambda
    implements kotlin.jvm.b.p<Integer, Integer, kotlin.p>
  {
    v(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      LightingEffectDebugActivity.u1(this.c).M().set(paramInt1);
      LightingEffectDebugActivity.u1(this.c).L().set(paramInt2);
    }
  }
  
  static final class w
    extends Lambda
    implements kotlin.jvm.b.p<Integer, Integer, kotlin.p>
  {
    w(LightingEffectDebugActivity paramLightingEffectDebugActivity)
    {
      super();
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      LightingEffectDebugActivity.u1(this.c).m().set(paramInt1);
      LightingEffectDebugActivity.u1(this.c).l().set(paramInt2);
    }
  }
  
  static final class x
    implements ColorPickerDialogFragment.b
  {
    x(ColorPickerDialogFragment paramColorPickerDialogFragment, LightingEffectDebugActivity paramLightingEffectDebugActivity, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c paramc, kotlin.jvm.b.l paraml) {}
    
    public final void Q(int paramInt1, int paramInt2, int paramInt3)
    {
      com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c localc = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramInt2, paramInt3, this.c.b1());
      LightingEffectDebugActivity.z1(jdField_this, localc);
      paraml.invoke(localc);
    }
  }
  
  static final class y
    implements DialogInterface.OnClickListener
  {
    y(LightingEffectDebugActivity paramLightingEffectDebugActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      LightingEffectDebugActivity.n1(this.c);
    }
  }
  
  static final class z<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    z(LightingEffectDebugActivity paramLightingEffectDebugActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null) {
        parama = (Integer)parama.a();
      } else {
        parama = null;
      }
      if ((parama != null) && (parama.intValue() == 100)) {
        e.m(this.a, null, 1, null);
      } else if ((parama != null) && (parama.intValue() == 200)) {
        e.g(this.a, null, 1, null);
      } else if ((parama != null) && (parama.intValue() == 300)) {
        e.e(this.a, null, 1, null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\LightingEffectDebugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */