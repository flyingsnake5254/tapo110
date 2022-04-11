package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter
  extends BaseAdapter
{
  MenuBuilder mAdapterMenu;
  private int mExpandedIndex = -1;
  private boolean mForceShowIcon;
  private final LayoutInflater mInflater;
  private final int mItemLayoutRes;
  private final boolean mOverflowOnly;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.mOverflowOnly = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mAdapterMenu = paramMenuBuilder;
    this.mItemLayoutRes = paramInt;
    findExpandedIndex();
  }
  
  void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this.mAdapterMenu.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.mAdapterMenu.getNonActionItems();
      int i = localArrayList.size();
      for (int j = 0; j < i; j++) {
        if ((MenuItemImpl)localArrayList.get(j) == localMenuItemImpl)
        {
          this.mExpandedIndex = j;
          return;
        }
      }
    }
    this.mExpandedIndex = -1;
  }
  
  public MenuBuilder getAdapterMenu()
  {
    return this.mAdapterMenu;
  }
  
  public int getCount()
  {
    ArrayList localArrayList;
    if (this.mOverflowOnly) {
      localArrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = this.mAdapterMenu.getVisibleItems();
    }
    if (this.mExpandedIndex < 0) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public boolean getForceShowIcon()
  {
    return this.mForceShowIcon;
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList;
    if (this.mOverflowOnly) {
      localArrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = this.mAdapterMenu.getVisibleItems();
    }
    int i = this.mExpandedIndex;
    int j = paramInt;
    if (i >= 0)
    {
      j = paramInt;
      if (paramInt >= i) {
        j = paramInt + 1;
      }
    }
    return (MenuItemImpl)localArrayList.get(j);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.mInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
    }
    int i = getItem(paramInt).getGroupId();
    int j = paramInt - 1;
    if (j >= 0) {
      j = getItem(j).getGroupId();
    } else {
      j = i;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((this.mAdapterMenu.isGroupDividerEnabled()) && (i != j)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (MenuView.ItemView)localView;
    if (this.mForceShowIcon) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.initialize(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\menu\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */