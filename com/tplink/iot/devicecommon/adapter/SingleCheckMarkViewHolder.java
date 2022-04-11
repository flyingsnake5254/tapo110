package com.tplink.iot.devicecommon.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.j;

public final class SingleCheckMarkViewHolder
  extends RecyclerView.ViewHolder
{
  private final TextView a;
  private final ImageView b;
  private final SparseArray<View> c;
  
  public SingleCheckMarkViewHolder(View paramView)
  {
    super(paramView);
    paramView = this.itemView.findViewById(2131364688);
    j.d(paramView, "itemView.findViewById(R.id.tv_title)");
    this.a = ((TextView)paramView);
    paramView = this.itemView.findViewById(2131363011);
    j.d(paramView, "itemView.findViewById(R.id.iv_check)");
    this.b = ((ImageView)paramView);
    this.c = new SparseArray();
  }
  
  public final ImageView c()
  {
    return this.b;
  }
  
  public final TextView d()
  {
    return this.a;
  }
  
  public final <T extends View> T e(int paramInt)
  {
    Object localObject1 = (View)this.c.get(paramInt);
    Object localObject2 = null;
    if (localObject1 == null)
    {
      localObject1 = this.itemView.findViewById(paramInt);
      if (localObject1 != null) {
        this.c.put(paramInt, localObject1);
      } else {
        localObject1 = null;
      }
    }
    if (!(localObject1 instanceof View)) {
      localObject1 = localObject2;
    }
    return (T)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\adapter\SingleCheckMarkViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */