package com.tplink.iot.devicecommon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Collection;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.p;

public abstract class SingleCheckMarkAdapter<T>
  extends RecyclerView.Adapter<SingleCheckMarkViewHolder>
{
  private final LayoutInflater a;
  private int b;
  private boolean c;
  private q<? super T, ? super Integer, ? super Boolean, p> d;
  private final Context e;
  private final List<T> f;
  
  public SingleCheckMarkAdapter(Context paramContext, List<? extends T> paramList, int paramInt)
  {
    this.e = paramContext;
    this.f = paramList;
    this.a = LayoutInflater.from(paramContext);
    int i = paramList.size();
    if ((paramInt < 0) || (i <= paramInt)) {
      paramInt = 0;
    }
    this.b = paramInt;
  }
  
  private final void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.c) || (paramInt1 != paramInt2))
    {
      int i = this.f.size();
      if ((paramInt2 >= 0) && (i > paramInt2))
      {
        this.b = paramInt2;
        notifyItemChanged(paramInt1);
        notifyItemChanged(paramInt2);
        Object localObject = this.d;
        if (localObject != null) {
          localObject = (p)((q)localObject).invoke(this.f.get(this.b), Integer.valueOf(this.b), Boolean.valueOf(paramBoolean));
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.f.size();
  }
  
  public abstract void n(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, T paramT, int paramInt);
  
  protected final Context p()
  {
    return this.e;
  }
  
  protected final List<T> q()
  {
    return this.f;
  }
  
  protected final LayoutInflater r()
  {
    return this.a;
  }
  
  protected final int s()
  {
    return this.b;
  }
  
  public final T t()
  {
    return (T)this.f.get(this.b);
  }
  
  public final T u()
  {
    return (T)l.z(this.f, this.b);
  }
  
  public void v(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, final int paramInt)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    n(paramSingleCheckMarkViewHolder, this.f.get(paramInt), paramInt);
    ImageView localImageView = paramSingleCheckMarkViewHolder.c();
    int i;
    if (paramInt == this.b) {
      i = 0;
    } else {
      i = 4;
    }
    localImageView.setVisibility(i);
    paramSingleCheckMarkViewHolder.itemView.setOnClickListener(new a(this, paramInt));
  }
  
  public SingleCheckMarkViewHolder w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = this.a.inflate(2131559082, paramViewGroup, false);
    j.d(paramViewGroup, "mInflater.inflate(R.layo…heck_mark, parent, false)");
    return new SingleCheckMarkViewHolder(paramViewGroup);
  }
  
  public final void x(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void y(q<? super T, ? super Integer, ? super Boolean, p> paramq)
  {
    j.e(paramq, "action");
    this.d = paramq;
  }
  
  public final void z(int paramInt)
  {
    o(this.b, paramInt, false);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(SingleCheckMarkAdapter paramSingleCheckMarkAdapter, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      SingleCheckMarkAdapter.m(paramView, paramView.s(), paramInt, true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\adapter\SingleCheckMarkAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */