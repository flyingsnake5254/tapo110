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
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.g.b.b.b;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class CustomizedEffectsAdapter
  extends LightStripEffectsBaseAdapter<b>
{
  private boolean h;
  
  public CustomizedEffectsAdapter(Context paramContext, List<b> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList), paramInt);
  }
  
  public void U(GeneralAdapter.GeneralVH paramGeneralVH, final b paramb, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramb, "data");
    Object localObject = F(paramGeneralVH);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    localObject = G(paramGeneralVH);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((LightingEffectBaseView)localObject).i(this.h, false);
      ((ColorEffectPlateView)localObject).k(paramb.c());
      if (paramb.a() != ((ImageView)localObject).isSelected()) {
        ((LightingEffectBaseView)localObject).j(paramb.a(), O());
      }
      ((ImageView)localObject).setOnClickListener(new a(this, paramb, paramInt));
    }
    paramGeneralVH = N(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(paramb.g());
    }
  }
  
  protected void V(b paramb, boolean paramBoolean)
  {
    j.e(paramb, "data");
    paramb.b(paramBoolean);
  }
  
  protected String W(b paramb)
  {
    j.e(paramb, "data");
    return paramb.e();
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
    Object localObject = G(paramGeneralVH);
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
    a(CustomizedEffectsAdapter paramCustomizedEffectsAdapter, b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(paramb, paramInt);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(CustomizedEffectsAdapter paramCustomizedEffectsAdapter) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.b();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\CustomizedEffectsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */