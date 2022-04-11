package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.LayoutLightingEffectPresetBinding;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.lightstrip.adapter.LightingEffectPresetAdapter;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.g.b.a.a.a;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightingEffectPresetLayout
  extends FrameLayout
  implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.e.a>
{
  private final LayoutLightingEffectPresetBinding c;
  private LightingEffectPresetAdapter d;
  private b f;
  private boolean q;
  private boolean x;
  
  public LightingEffectPresetLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightingEffectPresetLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightingEffectPresetLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559177, this, true);
    j.d(paramContext, "DataBindingUtil.inflate(…ffect_preset, this, true)");
    paramContext = (LayoutLightingEffectPresetBinding)paramContext;
    this.c = paramContext;
    this.q = true;
    paramContext.c.setOnClickListener(new a(this));
    paramContext = paramContext.f;
    j.d(paramContext, "mBinding.rvPresets");
    paramContext.setNestedScrollingEnabled(false);
  }
  
  private final void f()
  {
    AutoLightFeaturePointView localAutoLightFeaturePointView = this.c.c;
    j.d(localAutoLightFeaturePointView, "mBinding.autoView");
    localAutoLightFeaturePointView.setSelected(false);
  }
  
  private final void m()
  {
    AutoLightFeaturePointView localAutoLightFeaturePointView = this.c.c;
    j.d(localAutoLightFeaturePointView, "mBinding.autoView");
    localAutoLightFeaturePointView.setSelected(true);
  }
  
  private final void n(List<? extends com.tplink.iot.g.b.b.e.a> paramList)
  {
    Object localObject = this.c.d;
    j.d(localObject, "mBinding.rlContent");
    int i;
    if ((paramList.isEmpty() ^ true)) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    if (paramList.isEmpty()) {
      return;
    }
    localObject = this.d;
    if (localObject == null)
    {
      localObject = getContext();
      j.d(localObject, "context");
      paramList = new LightingEffectPresetAdapter((Context)localObject, paramList);
      paramList.S(this);
      paramList.Y(this.q);
      localObject = p.a;
      this.d = paramList;
      localObject = this.c.f;
      ((RecyclerView)localObject).setAdapter(paramList);
      i.g((RecyclerView)localObject);
    }
    else if (localObject != null)
    {
      ((LightStripEffectsBaseAdapter)localObject).T(paramList);
    }
  }
  
  public void b()
  {
    a.a.a(this);
  }
  
  public final void e(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (com.tplink.iot.g.b.b.e.a)((GeneralAdapter)localObject).o(paramInt);
      if (localObject != null)
      {
        b localb = this.f;
        if (localb != null) {
          localb.l0((com.tplink.iot.g.b.b.e.a)localObject, paramInt);
        }
      }
    }
  }
  
  public final void g()
  {
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    if (localLightingEffectPresetAdapter != null) {
      localLightingEffectPresetAdapter.C();
    }
    f();
  }
  
  public final int getSelectedPresetEffectPos()
  {
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    int i;
    if (localLightingEffectPresetAdapter != null) {
      i = localLightingEffectPresetAdapter.M();
    } else {
      i = -1;
    }
    return i;
  }
  
  public final com.tplink.iot.g.b.b.e.a h(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null) {
      localObject = (com.tplink.iot.g.b.b.e.a)((GeneralAdapter)localObject).o(paramInt);
    } else {
      localObject = null;
    }
    return (com.tplink.iot.g.b.b.e.a)localObject;
  }
  
  public void i(com.tplink.iot.g.b.b.e.a parama, int paramInt)
  {
    j.e(parama, "data");
    b localb = this.f;
    if (localb != null) {
      localb.l0(parama, paramInt);
    }
  }
  
  public final void j()
  {
    m();
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    if (localLightingEffectPresetAdapter != null) {
      localLightingEffectPresetAdapter.C();
    }
  }
  
  public final void k(int paramInt)
  {
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    if (localLightingEffectPresetAdapter != null) {
      localLightingEffectPresetAdapter.Q(paramInt);
    }
    f();
  }
  
  public final void l(String paramString)
  {
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    if (localLightingEffectPresetAdapter != null) {
      localLightingEffectPresetAdapter.R(paramString);
    }
    f();
  }
  
  public final void o(List<? extends com.tplink.iot.g.b.b.e.a> paramList)
  {
    j.e(paramList, "data");
    n(paramList);
  }
  
  public final void setAutoLightViewVisible(boolean paramBoolean)
  {
    this.x = paramBoolean;
    AutoLightFeaturePointView localAutoLightFeaturePointView = this.c.c;
    j.d(localAutoLightFeaturePointView, "mBinding.autoView");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localAutoLightFeaturePointView.setVisibility(i);
  }
  
  public final void setPresetCallback(b paramb)
  {
    j.e(paramb, "callback");
    this.f = paramb;
  }
  
  public final void setShowItemCenterEditIcon(boolean paramBoolean)
  {
    this.q = paramBoolean;
    LightingEffectPresetAdapter localLightingEffectPresetAdapter = this.d;
    if (localLightingEffectPresetAdapter != null) {
      localLightingEffectPresetAdapter.Y(paramBoolean);
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(LightingEffectPresetLayout paramLightingEffectPresetLayout) {}
    
    public final void onClick(View paramView)
    {
      paramView = LightingEffectPresetLayout.c(this.c).c;
      j.d(paramView, "mBinding.autoView");
      if (paramView.isSelected())
      {
        paramView = LightingEffectPresetLayout.d(this.c);
        if (paramView != null) {
          paramView.V();
        }
      }
      else
      {
        paramView = LightingEffectPresetLayout.d(this.c);
        if (paramView != null) {
          paramView.q();
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void V();
    
    public abstract void l0(com.tplink.iot.g.b.b.e.a parama, int paramInt);
    
    public abstract void q();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightingEffectPresetLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */