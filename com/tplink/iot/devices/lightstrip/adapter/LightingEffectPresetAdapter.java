package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.b.c;
import com.tplink.iot.g.b.b.d;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class LightingEffectPresetAdapter
  extends LightStripEffectsBaseAdapter<com.tplink.iot.g.b.b.e.a>
{
  private boolean h = true;
  
  public LightingEffectPresetAdapter(Context paramContext, List<? extends com.tplink.iot.g.b.b.e.a> paramList)
  {
    super(paramContext, l.U(paramList), -1);
  }
  
  private final void X(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    Object localObject = H(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    localObject = I(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    localObject = G(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    paramGeneralVH = J(paramGeneralVH);
    if (paramGeneralVH != null) {
      ViewKt.setVisible(paramGeneralVH, false);
    }
  }
  
  public void U(GeneralAdapter.GeneralVH paramGeneralVH, final com.tplink.iot.g.b.b.e.a parama, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(parama, "data");
    X(paramGeneralVH);
    boolean bool1 = parama instanceof c;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    Object localObject;
    if (bool1)
    {
      localObject = H(paramGeneralVH);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((SelectableColorPointView)localObject).setColor(((c)parama).d());
        ((LightingEffectBaseView)localObject).j(parama.a(), O());
        if ((!parama.a()) || (!this.h)) {
          bool5 = false;
        }
        ((LightingEffectBaseView)localObject).d(bool5);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      ColorPaintingRingView localColorPaintingRingView = I(paramGeneralVH);
      if (localColorPaintingRingView != null)
      {
        localColorPaintingRingView.setVisibility(0);
        localObject = (com.tplink.iot.g.b.b.a)parama;
        localColorPaintingRingView.k(((com.tplink.iot.g.b.b.a)localObject).c(), ((com.tplink.iot.g.b.b.a)localObject).f());
        localColorPaintingRingView.j(parama.a(), O());
        if ((parama.a()) && (this.h)) {
          bool5 = bool2;
        } else {
          bool5 = false;
        }
        localColorPaintingRingView.d(bool5);
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      localObject = G(paramGeneralVH);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((ColorEffectPlateView)localObject).k(((com.tplink.iot.g.b.b.b)parama).c());
        ((LightingEffectBaseView)localObject).j(parama.a(), O());
        if ((parama.a()) && (this.h)) {
          bool5 = bool3;
        } else {
          bool5 = false;
        }
        ((LightingEffectBaseView)localObject).d(bool5);
      }
    }
    else if ((parama instanceof d))
    {
      localObject = J(paramGeneralVH);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((CircleEffectImageView)localObject).setImageResource(((d)parama).d());
        ((LightingEffectBaseView)localObject).j(parama.a(), O());
        if ((parama.a()) && (this.h)) {
          bool5 = bool4;
        } else {
          bool5 = false;
        }
        ((LightingEffectBaseView)localObject).d(bool5);
      }
    }
    paramGeneralVH.itemView.setOnClickListener(new a(this, parama, paramInt));
  }
  
  protected void V(com.tplink.iot.g.b.b.e.a parama, boolean paramBoolean)
  {
    j.e(parama, "data");
    parama.b(paramBoolean);
  }
  
  protected String W(com.tplink.iot.g.b.b.e.a parama)
  {
    j.e(parama, "data");
    return com.tplink.iot.g.b.b.e.b.a(parama);
  }
  
  public final void Y(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int p(int paramInt)
  {
    return 2131559050;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(LightingEffectPresetAdapter paramLightingEffectPresetAdapter, com.tplink.iot.g.b.b.e.a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(parama, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\LightingEffectPresetAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */