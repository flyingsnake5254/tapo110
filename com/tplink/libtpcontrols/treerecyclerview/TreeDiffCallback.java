package com.tplink.libtpcontrols.treerecyclerview;

import androidx.recyclerview.widget.DiffUtil.Callback;
import java.util.List;

public class TreeDiffCallback
  extends DiffUtil.Callback
{
  private List<a> a;
  private List<a> b;
  
  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    return ((a)this.a.get(paramInt1)).equals(this.b.get(paramInt2));
  }
  
  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    a locala1 = (a)this.a.get(paramInt1);
    a locala2 = (a)this.b.get(paramInt2);
    if (locala1.b() == locala2.b())
    {
      if ((locala1.a() == null) && (locala2.a() == null)) {
        return false;
      }
      if ((locala1.a() != null) && (locala2.a() != null)) {
        return locala1.a().equals(locala2.a());
      }
    }
    return false;
  }
  
  public int getNewListSize()
  {
    return this.b.size();
  }
  
  public int getOldListSize()
  {
    return this.a.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\treerecyclerview\TreeDiffCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */