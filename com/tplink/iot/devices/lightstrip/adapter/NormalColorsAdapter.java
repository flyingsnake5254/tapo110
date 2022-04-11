package com.tplink.iot.devices.lightstrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.adapter.base.LightStripEffectsBaseAdapter;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.b.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class NormalColorsAdapter
  extends LightStripEffectsBaseAdapter<c>
{
  private static final Pair<LightStateBean, Integer>[] h = { new Pair(new LightStateBean(5, 80, 0, 100), Integer.valueOf((int)4294524722L)), new Pair(new LightStateBean(348, 50, 0, 100), Integer.valueOf((int)4294934425L)), new Pair(new LightStateBean(39, 100, 0, 100), Integer.valueOf((int)4294944000L)), new Pair(new LightStateBean(53, 65, 0, 100), Integer.valueOf((int)4294435927L)), new Pair(new LightStateBean(90, 68, 0, 100), Integer.valueOf((int)4289000526L)), new Pair(new LightStateBean(331, 92, 0, 100), Integer.valueOf((int)4294907269L)), new Pair(new LightStateBean(277, 86, 0, 100), Integer.valueOf((int)4289406207L)), new Pair(new LightStateBean(238, 68, 0, 100), Integer.valueOf((int)4283455743L)), new Pair(new LightStateBean(194, 50, 0, 100), Integer.valueOf((int)4286505470L)), new Pair(new LightStateBean(134, 67, 0, 100), Integer.valueOf((int)4283760508L)) };
  private static final Pair<LightStateBean, Integer>[] i = { new Pair(new LightStateBean(0, 0, 2500, 100), Integer.valueOf((int)4294891683L)), new Pair(new LightStateBean(0, 0, 3000, 100), Integer.valueOf((int)4294959543L)), new Pair(new LightStateBean(0, 0, 4000, 100), Integer.valueOf((int)4294898396L)), new Pair(new LightStateBean(0, 0, 5000, 100), Integer.valueOf((int)4294900981L)), new Pair(new LightStateBean(0, 0, 5500, 100), Integer.valueOf((int)4294835964L)) };
  private static final Pair<LightStateBean, Integer> j = new Pair(new LightStateBean(0, 0, 0, 100), Integer.valueOf((int)4294967295L));
  public static final a k = new a(null);
  private boolean l = true;
  
  public NormalColorsAdapter(Context paramContext, List<c> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList), paramInt);
  }
  
  public void X(GeneralAdapter.GeneralVH paramGeneralVH, final c paramc, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramc, "data");
    paramGeneralVH = H(paramGeneralVH);
    if (paramGeneralVH != null)
    {
      paramGeneralVH.setEnabled(this.l);
      paramGeneralVH.setColor(paramc.d());
      if (paramc.a() != paramGeneralVH.isSelected()) {
        paramGeneralVH.j(paramc.a(), O());
      }
      paramGeneralVH.j(paramc.a(), true);
      paramGeneralVH.setOnClickListener(new b(this, paramc, paramInt));
    }
  }
  
  protected void Y(c paramc, boolean paramBoolean)
  {
    j.e(paramc, "data");
    paramc.b(paramBoolean);
  }
  
  protected String Z(c paramc)
  {
    j.e(paramc, "data");
    return null;
  }
  
  public final void a0(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      D();
      this.l = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public GeneralAdapter.GeneralVH w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = super.w(paramViewGroup, paramInt);
    Object localObject = H(paramViewGroup);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, true);
    }
    localObject = N(paramViewGroup);
    if (localObject != null) {
      ViewKt.setVisible((View)localObject, false);
    }
    return paramViewGroup;
  }
  
  public static final class a
  {
    public final Pair<LightStateBean, Integer>[] a()
    {
      return NormalColorsAdapter.U();
    }
    
    public final Pair<LightStateBean, Integer>[] b()
    {
      return NormalColorsAdapter.V();
    }
    
    public final Pair<LightStateBean, Integer> c()
    {
      return NormalColorsAdapter.W();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(NormalColorsAdapter paramNormalColorsAdapter, c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.E();
      if (paramView != null) {
        paramView.a(paramc, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\NormalColorsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */