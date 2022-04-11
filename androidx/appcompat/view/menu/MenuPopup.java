package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract class MenuPopup
  implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener
{
  private Rect mEpicenterBounds;
  
  protected static int measureIndividualMenuWidth(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i = 0;
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = paramListAdapter.getCount();
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    Object localObject2 = paramViewGroup;
    paramViewGroup = (ViewGroup)localObject1;
    while (i < m)
    {
      int i2 = paramListAdapter.getItemViewType(i);
      int i3 = i1;
      if (i2 != i1)
      {
        paramViewGroup = null;
        i3 = i2;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new FrameLayout(paramContext);
      }
      paramViewGroup = paramListAdapter.getView(i, paramViewGroup, (ViewGroup)localObject1);
      paramViewGroup.measure(j, k);
      i2 = paramViewGroup.getMeasuredWidth();
      if (i2 >= paramInt) {
        return paramInt;
      }
      i1 = n;
      if (i2 > n) {
        i1 = i2;
      }
      i++;
      n = i1;
      i1 = i3;
      localObject2 = localObject1;
    }
    return n;
  }
  
  protected static boolean shouldPreserveIconSpacing(MenuBuilder paramMenuBuilder)
  {
    int i = paramMenuBuilder.size();
    boolean bool1 = false;
    boolean bool2;
    for (int j = 0;; j++)
    {
      bool2 = bool1;
      if (j >= i) {
        break;
      }
      MenuItem localMenuItem = paramMenuBuilder.getItem(j);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool2 = true;
        break;
      }
    }
    return bool2;
  }
  
  protected static MenuAdapter toMenuAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (MenuAdapter)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (MenuAdapter)paramListAdapter;
  }
  
  public abstract void addMenu(MenuBuilder paramMenuBuilder);
  
  protected boolean closeMenuOnSubMenuOpened()
  {
    return true;
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public Rect getEpicenterBounds()
  {
    return this.mEpicenterBounds;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    throw new UnsupportedOperationException("MenuPopups manage their own views");
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = toMenuAdapter(paramView).mAdapterMenu;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (closeMenuOnSubMenuOpened()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramAdapterView.performItemAction(paramView, this, paramInt);
  }
  
  public abstract void setAnchorView(View paramView);
  
  public void setEpicenterBounds(Rect paramRect)
  {
    this.mEpicenterBounds = paramRect;
  }
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
  
  public abstract void setVerticalOffset(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\menu\MenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */