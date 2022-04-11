package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.g.b.b.d;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class HorizontalPredefinedEffectsAdapter
  extends LightStripEffectsBaseAdapter<d>
{
  private boolean h = true;
  
  public HorizontalPredefinedEffectsAdapter(Context paramContext, List<d> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList), paramInt);
  }
  
  public void U(GeneralAdapter.GeneralVH paramGeneralVH, final d paramd, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramd, "data");
    CircleEffectImageView localCircleEffectImageView = J(paramGeneralVH);
    if (localCircleEffectImageView != null)
    {
      localCircleEffectImageView.setEnabled(this.h);
      localCircleEffectImageView.setImageResource(paramd.d());
      if (paramd.a() != localCircleEffectImageView.isSelected()) {
        localCircleEffectImageView.j(paramd.a(), O());
      }
      localCircleEffectImageView.setOnClickListener(new a(this, paramd, paramInt));
    }
    paramGeneralVH = N(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(paramd.h());
    }
  }
  
  protected void V(d paramd, boolean paramBoolean)
  {
    j.e(paramd, "data");
    paramd.b(paramBoolean);
  }
  
  protected String W(d paramd)
  {
    j.e(paramd, "data");
    return paramd.f();
  }
  
  public GeneralAdapter.GeneralVH w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = q().inflate(2131559070, paramViewGroup, false);
    j.d(paramViewGroup, "layoutInflater.inflate(R…ts_holder, parent, false)");
    return new GeneralAdapter.GeneralVH(paramViewGroup);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(HorizontalPredefinedEffectsAdapter paramHorizontalPredefinedEffectsAdapter, d paramd, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(paramd, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\HorizontalPredefinedEffectsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */