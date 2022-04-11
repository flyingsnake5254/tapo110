package com.tplink.iot.devices.featuredactions.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class FeaturedActionChooseAdapter
  extends GeneralAdapter<com.tplink.iot.g.a.a.a>
{
  private a d;
  
  public FeaturedActionChooseAdapter(Context paramContext, List<com.tplink.iot.g.a.a.a> paramList)
  {
    super(paramContext, l.U(paramList));
  }
  
  public void B(GeneralAdapter.GeneralVH paramGeneralVH, final com.tplink.iot.g.a.a.a parama, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(parama, "data");
    ItemInfoLayout localItemInfoLayout = (ItemInfoLayout)paramGeneralVH.c(2131362926);
    if (localItemInfoLayout != null) {
      localItemInfoLayout.setTitleText(parama.b());
    }
    paramGeneralVH.itemView.setOnClickListener(new a(this, parama));
  }
  
  public final void C(a parama)
  {
    j.e(parama, "listener");
    this.d = parama;
  }
  
  public int p(int paramInt)
  {
    return 2131559031;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(FeaturedActionChooseAdapter paramFeaturedActionChooseAdapter, com.tplink.iot.g.a.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      paramView = FeaturedActionChooseAdapter.A(this.c);
      if (paramView != null) {
        paramView.q0(parama);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\adapter\FeaturedActionChooseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */