package com.tplink.iot.devicecommon.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Collection;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public abstract class GeneralAdapter<T>
  extends RecyclerView.Adapter<GeneralVH>
{
  private final LayoutInflater a;
  private final Context b;
  private final List<T> c;
  
  public GeneralAdapter(Context paramContext, List<T> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
    paramContext = LayoutInflater.from(paramContext);
    j.d(paramContext, "LayoutInflater.from(mContext)");
    this.a = paramContext;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public abstract void m(GeneralVH paramGeneralVH, T paramT, int paramInt);
  
  public void n(GeneralVH paramGeneralVH, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
  }
  
  public final T o(int paramInt)
  {
    return (T)l.z(this.c, paramInt);
  }
  
  public abstract int p(int paramInt);
  
  protected final LayoutInflater q()
  {
    return this.a;
  }
  
  protected final Context r()
  {
    return this.b;
  }
  
  protected final List<T> s()
  {
    return this.c;
  }
  
  public void t(T paramT, int paramInt)
  {
    if (paramInt == -1)
    {
      this.c.add(paramT);
      notifyItemInserted(this.c.size() - 1);
    }
    else
    {
      int i = this.c.size();
      if ((paramInt >= 0) && (i >= paramInt))
      {
        this.c.add(paramInt, paramT);
        notifyItemInserted(paramInt);
      }
    }
  }
  
  public void v(GeneralVH paramGeneralVH, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    int i = this.c.size();
    if ((paramInt >= 0) && (i > paramInt)) {
      m(paramGeneralVH, this.c.get(paramInt), paramInt);
    } else {
      n(paramGeneralVH, paramInt);
    }
  }
  
  public GeneralVH w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = this.a.inflate(p(paramInt), paramViewGroup, false);
    j.d(paramViewGroup, "layoutInflater.inflate(g…viewType), parent, false)");
    return new GeneralVH(paramViewGroup);
  }
  
  public final void x(List<? extends T> paramList)
  {
    j.e(paramList, "newData");
    int i = this.c.size();
    int j = paramList.size();
    this.c.clear();
    if (j < i) {
      notifyItemRangeRemoved(j, i - j);
    }
    this.c.addAll(paramList);
    notifyItemRangeChanged(0, this.c.size());
  }
  
  public final void y(List<? extends T> paramList)
  {
    j.e(paramList, "newData");
    this.c.clear();
    this.c.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public final void z(int paramInt, T paramT)
  {
    int i = this.c.size();
    if ((paramInt >= 0) && (i > paramInt))
    {
      this.c.set(paramInt, paramT);
      notifyItemChanged(paramInt);
    }
  }
  
  public static final class GeneralVH
    extends RecyclerView.ViewHolder
  {
    private final SparseArray<View> a = new SparseArray();
    
    public GeneralVH(View paramView)
    {
      super();
    }
    
    public final <T extends View> T c(int paramInt)
    {
      View localView = (View)this.a.get(paramInt);
      if (localView == null)
      {
        localView = this.itemView.findViewById(paramInt);
        if (localView != null) {
          this.a.put(paramInt, localView);
        } else {
          localView = null;
        }
      }
      return localView;
    }
    
    public final void d(int paramInt, String paramString)
    {
      TextView localTextView = (TextView)c(paramInt);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\adapter\GeneralAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */