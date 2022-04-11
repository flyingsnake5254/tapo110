package com.tplink.iot.devices.lightstrip.adapter.base;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.DashCircleAddView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.g.b.a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public abstract class LightStripEffectsBaseAdapter<T>
  extends GeneralAdapter<T>
{
  private a<T> d;
  private int e;
  private String f;
  private int g;
  
  public LightStripEffectsBaseAdapter(Context paramContext, List<? extends T> paramList, int paramInt)
  {
    super(paramContext, l.U(paramList));
    int i = s().size();
    if ((paramInt < 0) || (i <= paramInt)) {
      paramInt = -1;
    }
    this.e = paramInt;
  }
  
  private final void B(int paramInt, boolean paramBoolean)
  {
    P();
    A(s().get(paramInt), paramBoolean);
    notifyItemChanged(paramInt);
  }
  
  protected abstract void A(T paramT, boolean paramBoolean);
  
  public final void C()
  {
    int i = s().size();
    int j = this.e;
    if ((j >= 0) && (i > j))
    {
      B(j, false);
      this.e = -1;
      this.f = null;
    }
  }
  
  protected final void D()
  {
    this.g = 0;
  }
  
  public final a<T> E()
  {
    return this.d;
  }
  
  protected final DashCircleAddView F(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$addView");
    return (DashCircleAddView)paramGeneralVH.c(2131362357);
  }
  
  protected final ColorEffectPlateView G(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$colorPlate");
    return (ColorEffectPlateView)paramGeneralVH.c(2131362283);
  }
  
  protected final SelectableColorPointView H(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$colorPoint");
    return (SelectableColorPointView)paramGeneralVH.c(2131364014);
  }
  
  protected final ColorPaintingRingView I(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$colorRing");
    return (ColorPaintingRingView)paramGeneralVH.c(2131362285);
  }
  
  protected final CircleEffectImageView J(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$effectImage");
    return (CircleEffectImageView)paramGeneralVH.c(2131362243);
  }
  
  protected abstract String K(T paramT);
  
  public final T L()
  {
    int i = s().size();
    int j = this.e;
    Object localObject;
    if ((j >= 0) && (i > j)) {
      localObject = s().get(this.e);
    } else {
      localObject = null;
    }
    return (T)localObject;
  }
  
  public final int M()
  {
    return this.e;
  }
  
  protected final TextView N(GeneralAdapter.GeneralVH paramGeneralVH)
  {
    j.e(paramGeneralVH, "$this$tvTitle");
    return (TextView)paramGeneralVH.c(2131364688);
  }
  
  protected final boolean O()
  {
    return false;
  }
  
  protected final void P()
  {
    this.g += 1;
  }
  
  public final void Q(int paramInt)
  {
    if (paramInt != this.e)
    {
      int i = s().size();
      if ((paramInt >= 0) && (i > paramInt))
      {
        C();
        B(paramInt, true);
        this.e = paramInt;
        this.f = K(s().get(paramInt));
      }
    }
  }
  
  public final void R(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = s();
      int i = 0;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (j.a(K(((Iterator)localObject).next()), paramString)) {
          break label55;
        }
        i++;
      }
      i = -1;
      label55:
      Q(i);
    }
  }
  
  public final void S(a<T> parama)
  {
    this.d = parama;
  }
  
  public final void T(List<? extends T> paramList)
  {
    j.e(paramList, "newData");
    super.y(paramList);
    int i = this.e;
    int j = -1;
    if ((i != -1) && (this.f != null))
    {
      i = 0;
      paramList = paramList.iterator();
      int k;
      for (;;)
      {
        k = j;
        if (!paramList.hasNext()) {
          break;
        }
        if (j.a(K(paramList.next()), this.f))
        {
          k = i;
          break;
        }
        i++;
      }
      C();
      Q(k);
    }
  }
  
  public int p(int paramInt)
  {
    return 2131559051;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\adapter\base\LightStripEffectsBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */