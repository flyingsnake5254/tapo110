package com.tplink.iot.devices.lightstrip.view.effects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.widget.DashCircleAddView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c;
import java.util.Collection;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

final class a
  extends GeneralAdapter<c>
{
  private kotlin.jvm.b.a<kotlin.p> d;
  private kotlin.jvm.b.a<kotlin.p> e;
  private kotlin.jvm.b.p<? super Integer, ? super c, kotlin.p> f;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 2, null);
  }
  
  private final DashCircleAddView F(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (DashCircleAddView)paramGeneralVH.c(2131362357);
  }
  
  private final SelectableColorPointView G(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (SelectableColorPointView)paramGeneralVH.c(2131364014);
  }
  
  private final TextView I(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    return (TextView)paramGeneralVH.c(2131364688);
  }
  
  private final void J(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    SelectableColorPointView localSelectableColorPointView = G(paramGeneralVH);
    if (localSelectableColorPointView != null) {
      ViewKt.setVisible(localSelectableColorPointView, false);
    }
    paramGeneralVH = F(paramGeneralVH);
    if (paramGeneralVH != null) {
      ViewKt.setVisible(paramGeneralVH, false);
    }
  }
  
  public final void D(c paramc)
  {
    j.e(paramc, "hsb");
    GeneralAdapter.u(this, paramc, 0, 2, null);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void E(GeneralAdapter.GeneralVH paramGeneralVH, final c paramc, final int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(paramc, "data");
    J(paramGeneralVH);
    Object localObject = G(paramGeneralVH);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((SelectableColorPointView)localObject).setColor(paramc.g());
      ((ImageView)localObject).setOnClickListener(new a(this, paramc, paramInt));
    }
    paramGeneralVH = I(paramGeneralVH);
    if (paramGeneralVH != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramc.a());
      ((StringBuilder)localObject).append('%');
      paramGeneralVH.setText(((StringBuilder)localObject).toString());
    }
  }
  
  public final List<c> H()
  {
    return s();
  }
  
  public final void K()
  {
    if ((s().isEmpty() ^ true))
    {
      int i = l.f(s());
      l.r(s());
      notifyItemRemoved(i);
    }
  }
  
  public final void L(kotlin.jvm.b.a<kotlin.p> parama1, kotlin.jvm.b.a<kotlin.p> parama2, kotlin.jvm.b.p<? super Integer, ? super c, kotlin.p> paramp)
  {
    this.d = parama1;
    this.e = parama2;
    this.f = paramp;
  }
  
  public final void M(int paramInt, c paramc)
  {
    j.e(paramc, "newHSB");
    z(paramInt, paramc);
  }
  
  public int getItemCount()
  {
    return s().size() + 1;
  }
  
  public void n(GeneralAdapter.GeneralVH paramGeneralVH, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    J(paramGeneralVH);
    DashCircleAddView localDashCircleAddView = F(paramGeneralVH);
    if (localDashCircleAddView != null)
    {
      localDashCircleAddView.getLayoutParams().height = -2;
      localDashCircleAddView.setVisibility(0);
      localDashCircleAddView.setOnClickListener(new b(this));
      localDashCircleAddView.setOnLongClickListener(new c(this));
    }
    paramGeneralVH = I(paramGeneralVH);
    if (paramGeneralVH != null) {
      paramGeneralVH.setText(2131952387);
    }
  }
  
  public int p(int paramInt)
  {
    return 2131559051;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(a parama, c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = a.C(this.c);
      if (paramView != null) {
        paramView = (kotlin.p)paramView.invoke(Integer.valueOf(paramInt), paramc);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      paramView = a.A(this.c);
      if (paramView != null) {
        paramView = (kotlin.p)paramView.invoke();
      }
    }
  }
  
  static final class c
    implements View.OnLongClickListener
  {
    c(a parama) {}
    
    public final boolean onLongClick(View paramView)
    {
      paramView = a.B(this.c);
      if (paramView != null) {
        paramView = (kotlin.p)paramView.invoke();
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */