package com.tplink.iot.base;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T>
  extends RecyclerView.Adapter<VH>
{
  private List<T> a;
  
  public BaseAdapter(List<T> paramList)
  {
    this.a = paramList;
  }
  
  public T getItem(int paramInt)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    return (T)this.a.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void m(List<T> paramList)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    int i = this.a.size();
    this.a.addAll(paramList);
    notifyItemRangeInserted(i, paramList.size());
  }
  
  public abstract void n(VH paramVH, T paramT, int paramInt);
  
  public abstract int o(int paramInt);
  
  public void p(VH paramVH, int paramInt)
  {
    n(paramVH, this.a.get(paramInt), paramInt);
  }
  
  public VH q(ViewGroup paramViewGroup, int paramInt)
  {
    return VH.c(paramViewGroup, o(paramInt));
  }
  
  public static class VH
    extends RecyclerView.ViewHolder
  {
    private SparseArray<View> a;
    private View b;
    
    private VH(View paramView)
    {
      super();
      this.b = paramView;
      this.a = new SparseArray();
    }
    
    public static VH c(ViewGroup paramViewGroup, int paramInt)
    {
      return new VH(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
    }
    
    public <T extends View> T d(int paramInt, BaseAdapter.a parama)
    {
      View localView1 = (View)this.a.get(paramInt);
      View localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = this.b.findViewById(paramInt);
        if (parama != null) {
          localView2.setOnClickListener(new a(this, parama));
        }
        this.a.put(paramInt, localView2);
      }
      return localView2;
    }
  }
  
  public static abstract interface a
  {
    public abstract <T> void A0(int paramInt, View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\BaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */