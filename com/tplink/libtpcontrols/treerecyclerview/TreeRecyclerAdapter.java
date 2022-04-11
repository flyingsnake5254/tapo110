package com.tplink.libtpcontrols.treerecyclerview;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public abstract class TreeRecyclerAdapter
  extends RecyclerView.Adapter<TreeViewHolder>
  implements b
{
  public int getItemCount()
  {
    throw null;
  }
  
  public int getItemViewType(int paramInt)
  {
    throw null;
  }
  
  public void m(@NonNull TreeViewHolder paramTreeViewHolder, int paramInt)
  {
    throw null;
  }
  
  @NonNull
  public TreeViewHolder n(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return o(paramViewGroup, paramInt, this);
  }
  
  public abstract TreeViewHolder o(ViewGroup paramViewGroup, int paramInt, b paramb);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\treerecyclerview\TreeRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */