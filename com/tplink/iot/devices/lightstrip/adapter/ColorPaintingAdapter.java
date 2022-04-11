package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ColorPaintingAdapter
  extends LightStripEffectsBaseAdapter<com.tplink.iot.g.b.b.a>
{
  private boolean h;
  
  public ColorPaintingAdapter(Context paramContext, List<com.tplink.iot.g.b.b.a> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList), paramInt);
  }
  
  public void U(GeneralAdapter.GeneralVH paramGeneralVH, final com.tplink.iot.g.b.b.a parama, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(parama, "data");
    Object localObject = F(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    localObject = I(paramGeneralVH);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((LightingEffectBaseView)localObject).i(this.h, false);
      ((ColorPaintingRingView)localObject).k(parama.c(), parama.f());
      if (parama.a() != ((ImageView)localObject).isSelected()) {
        ((LightingEffectBaseView)localObject).j(parama.a(), O());
      }
      ((ImageView)localObject).setOnClickListener(new a(this, parama, paramInt));
    }
    paramGeneralVH = N(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(parama.h());
    }
  }
  
  protected void V(com.tplink.iot.g.b.b.a parama, boolean paramBoolean)
  {
    j.e(parama, "data");
    parama.b(paramBoolean);
  }
  
  protected String W(com.tplink.iot.g.b.b.a parama)
  {
    j.e(parama, "data");
    return parama.e();
  }
  
  public final void X(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      D();
      this.h = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    int i;
    if (s().size() >= 16) {
      i = s().size();
    } else {
      i = s().size() + 1;
    }
    return i;
  }
  
  public void n(GeneralAdapter.GeneralVH paramGeneralVH, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    Object localObject = I(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    localObject = F(paramGeneralVH);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new b(this));
    }
    paramGeneralVH = N(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(2131952472);
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(ColorPaintingAdapter paramColorPaintingAdapter, com.tplink.iot.g.b.b.a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(parama, paramInt);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(ColorPaintingAdapter paramColorPaintingAdapter) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.b();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\ColorPaintingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */