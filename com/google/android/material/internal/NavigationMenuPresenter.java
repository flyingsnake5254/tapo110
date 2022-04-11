package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter
  implements MenuPresenter
{
  private static final String STATE_ADAPTER = "android:menu:adapter";
  private static final String STATE_HEADER = "android:menu:header";
  private static final String STATE_HIERARCHY = "android:menu:list";
  NavigationMenuAdapter adapter;
  private MenuPresenter.Callback callback;
  boolean hasCustomItemIconSize;
  LinearLayout headerLayout;
  ColorStateList iconTintList;
  private int id;
  boolean isBehindStatusBar = true;
  Drawable itemBackground;
  int itemHorizontalPadding;
  int itemIconPadding;
  int itemIconSize;
  private int itemMaxLines;
  LayoutInflater layoutInflater;
  MenuBuilder menu;
  private NavigationMenuView menuView;
  final View.OnClickListener onClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      NavigationMenuPresenter localNavigationMenuPresenter = NavigationMenuPresenter.this;
      int i = 1;
      localNavigationMenuPresenter.setUpdateSuspended(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      localNavigationMenuPresenter = NavigationMenuPresenter.this;
      boolean bool = localNavigationMenuPresenter.menu.performItemAction(paramAnonymousView, localNavigationMenuPresenter, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        NavigationMenuPresenter.this.adapter.setCheckedItem(paramAnonymousView);
      } else {
        i = 0;
      }
      NavigationMenuPresenter.this.setUpdateSuspended(false);
      if (i != 0) {
        NavigationMenuPresenter.this.updateMenuView(false);
      }
    }
  };
  private int overScrollMode = -1;
  int paddingSeparator;
  private int paddingTopDefault;
  int textAppearance;
  boolean textAppearanceSet;
  ColorStateList textColor;
  
  private void updateTopPadding()
  {
    int i;
    if ((this.headerLayout.getChildCount() == 0) && (this.isBehindStatusBar)) {
      i = this.paddingTopDefault;
    } else {
      i = 0;
    }
    NavigationMenuView localNavigationMenuView = this.menuView;
    localNavigationMenuView.setPadding(0, i, 0, localNavigationMenuView.getPaddingBottom());
  }
  
  public void addHeaderView(@NonNull View paramView)
  {
    this.headerLayout.addView(paramView);
    paramView = this.menuView;
    paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.paddingTopDefault != i)
    {
      this.paddingTopDefault = i;
      updateTopPadding();
    }
    NavigationMenuView localNavigationMenuView = this.menuView;
    localNavigationMenuView.setPadding(0, localNavigationMenuView.getPaddingTop(), 0, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    ViewCompat.dispatchApplyWindowInsets(this.headerLayout, paramWindowInsetsCompat);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  @Nullable
  public MenuItemImpl getCheckedItem()
  {
    return this.adapter.getCheckedItem();
  }
  
  public int getHeaderCount()
  {
    return this.headerLayout.getChildCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return this.headerLayout.getChildAt(paramInt);
  }
  
  public int getId()
  {
    return this.id;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.itemBackground;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.itemHorizontalPadding;
  }
  
  public int getItemIconPadding()
  {
    return this.itemIconPadding;
  }
  
  public int getItemMaxLines()
  {
    return this.itemMaxLines;
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.textColor;
  }
  
  @Nullable
  public ColorStateList getItemTintList()
  {
    return this.iconTintList;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.menuView == null)
    {
      paramViewGroup = (NavigationMenuView)this.layoutInflater.inflate(R.layout.design_navigation_menu, paramViewGroup, false);
      this.menuView = paramViewGroup;
      paramViewGroup.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.menuView));
      if (this.adapter == null) {
        this.adapter = new NavigationMenuAdapter();
      }
      int i = this.overScrollMode;
      if (i != -1) {
        this.menuView.setOverScrollMode(i);
      }
      this.headerLayout = ((LinearLayout)this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false));
      this.menuView.setAdapter(this.adapter);
    }
    return this.menuView;
  }
  
  public View inflateHeaderView(@LayoutRes int paramInt)
  {
    View localView = this.layoutInflater.inflate(paramInt, this.headerLayout, false);
    addHeaderView(localView);
    return localView;
  }
  
  public void initForMenu(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder)
  {
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.menu = paramMenuBuilder;
    this.paddingSeparator = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public boolean isBehindStatusBar()
  {
    return this.isBehindStatusBar;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.callback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        this.menuView.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.adapter.restoreInstanceState((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.headerLayout.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.menuView != null)
    {
      localObject = new SparseArray();
      this.menuView.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:list", (SparseArray)localObject);
    }
    Object localObject = this.adapter;
    if (localObject != null) {
      localBundle.putBundle("android:menu:adapter", ((NavigationMenuAdapter)localObject).createInstanceState());
    }
    if (this.headerLayout != null)
    {
      localObject = new SparseArray();
      this.headerLayout.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:header", (SparseArray)localObject);
    }
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void removeHeaderView(@NonNull View paramView)
  {
    this.headerLayout.removeView(paramView);
    if (this.headerLayout.getChildCount() == 0)
    {
      paramView = this.menuView;
      paramView.setPadding(0, this.paddingTopDefault, 0, paramView.getPaddingBottom());
    }
  }
  
  public void setBehindStatusBar(boolean paramBoolean)
  {
    if (this.isBehindStatusBar != paramBoolean)
    {
      this.isBehindStatusBar = paramBoolean;
      updateTopPadding();
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public void setCheckedItem(@NonNull MenuItemImpl paramMenuItemImpl)
  {
    this.adapter.setCheckedItem(paramMenuItemImpl);
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    updateMenuView(false);
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.itemHorizontalPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.itemIconPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    if (this.itemIconSize != paramInt)
    {
      this.itemIconSize = paramInt;
      this.hasCustomItemIconSize = true;
      updateMenuView(false);
    }
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.iconTintList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setItemMaxLines(int paramInt)
  {
    this.itemMaxLines = paramInt;
    updateMenuView(false);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.textAppearance = paramInt;
    this.textAppearanceSet = true;
    updateMenuView(false);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.textColor = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    this.overScrollMode = paramInt;
    NavigationMenuView localNavigationMenuView = this.menuView;
    if (localNavigationMenuView != null) {
      localNavigationMenuView.setOverScrollMode(paramInt);
    }
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    NavigationMenuAdapter localNavigationMenuAdapter = this.adapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.setUpdateSuspended(paramBoolean);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    NavigationMenuAdapter localNavigationMenuAdapter = this.adapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.update();
    }
  }
  
  private static class HeaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public HeaderViewHolder(View paramView)
    {
      super();
    }
  }
  
  private class NavigationMenuAdapter
    extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
  {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl checkedItem;
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> items = new ArrayList();
    private boolean updateSuspended;
    
    NavigationMenuAdapter()
    {
      prepareMenuItems();
    }
    
    private void appendTransparentIconIfMissing(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt1)).needsEmptyIcon = true;
        paramInt1++;
      }
    }
    
    private void prepareMenuItems()
    {
      if (this.updateSuspended) {
        return;
      }
      this.updateSuspended = true;
      this.items.clear();
      this.items.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
      int i = -1;
      int j = NavigationMenuPresenter.this.menu.getVisibleItems().size();
      int k = 0;
      boolean bool1 = false;
      int i1;
      for (int m = 0; k < j; m = i1)
      {
        Object localObject1 = (MenuItemImpl)NavigationMenuPresenter.this.menu.getVisibleItems().get(k);
        if (((MenuItemImpl)localObject1).isChecked()) {
          setCheckedItem((MenuItemImpl)localObject1);
        }
        if (((MenuItemImpl)localObject1).isCheckable()) {
          ((MenuItemImpl)localObject1).setExclusiveCheckable(false);
        }
        int n;
        boolean bool2;
        int i4;
        Object localObject2;
        if (((MenuItemImpl)localObject1).hasSubMenu())
        {
          SubMenu localSubMenu = ((MenuItemImpl)localObject1).getSubMenu();
          n = i;
          bool2 = bool1;
          i1 = m;
          if (localSubMenu.hasVisibleItems())
          {
            if (k != 0) {
              this.items.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
            }
            this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject1));
            int i2 = this.items.size();
            int i3 = localSubMenu.size();
            n = 0;
            for (i4 = 0; n < i3; i4 = i1)
            {
              localObject2 = (MenuItemImpl)localSubMenu.getItem(n);
              i1 = i4;
              if (((MenuItemImpl)localObject2).isVisible())
              {
                i1 = i4;
                if (i4 == 0)
                {
                  i1 = i4;
                  if (((MenuItemImpl)localObject2).getIcon() != null) {
                    i1 = 1;
                  }
                }
                if (((MenuItemImpl)localObject2).isCheckable()) {
                  ((MenuItemImpl)localObject2).setExclusiveCheckable(false);
                }
                if (((MenuItemImpl)localObject1).isChecked()) {
                  setCheckedItem((MenuItemImpl)localObject1);
                }
                this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject2));
              }
              n++;
            }
            n = i;
            bool2 = bool1;
            i1 = m;
            if (i4 != 0)
            {
              appendTransparentIconIfMissing(i2, this.items.size());
              n = i;
              bool2 = bool1;
              i1 = m;
            }
          }
        }
        else
        {
          n = ((MenuItemImpl)localObject1).getGroupId();
          if (n != i)
          {
            m = this.items.size();
            if (((MenuItemImpl)localObject1).getIcon() != null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            bool2 = bool1;
            i4 = m;
            if (k != 0)
            {
              i4 = m + 1;
              localObject2 = this.items;
              m = NavigationMenuPresenter.this.paddingSeparator;
              ((ArrayList)localObject2).add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(m, m));
              bool2 = bool1;
            }
          }
          else
          {
            bool2 = bool1;
            i4 = m;
            if (!bool1)
            {
              bool2 = bool1;
              i4 = m;
              if (((MenuItemImpl)localObject1).getIcon() != null)
              {
                appendTransparentIconIfMissing(m, this.items.size());
                bool2 = true;
                i4 = m;
              }
            }
          }
          localObject1 = new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject1);
          ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).needsEmptyIcon = bool2;
          this.items.add(localObject1);
          i1 = i4;
        }
        k++;
        i = n;
        bool1 = bool2;
      }
      this.updateSuspended = false;
    }
    
    @NonNull
    public Bundle createInstanceState()
    {
      Bundle localBundle = new Bundle();
      Object localObject = this.checkedItem;
      if (localObject != null) {
        localBundle.putInt("android:menu:checked", ((MenuItemImpl)localObject).getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      int j = this.items.size();
      while (i < j)
      {
        localObject = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
        if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).getMenuItem();
          if (localMenuItemImpl != null) {
            localObject = localMenuItemImpl.getActionView();
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
          }
        }
        i++;
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public MenuItemImpl getCheckedItem()
    {
      return this.checkedItem;
    }
    
    public int getItemCount()
    {
      return this.items.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(paramInt);
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
        return 2;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
        return 3;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        if (((NavigationMenuPresenter.NavigationMenuTextItem)localNavigationMenuItem).getMenuItem().hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    int getRowCount()
    {
      int i = NavigationMenuPresenter.this.headerLayout.getChildCount();
      int j = 0;
      if (i == 0) {
        i = 0;
      }
      int k;
      for (i = 1; j < NavigationMenuPresenter.this.adapter.getItemCount(); i = k)
      {
        k = i;
        if (NavigationMenuPresenter.this.adapter.getItemViewType(j) == 0) {
          k = i + 1;
        }
        j++;
      }
      return i;
    }
    
    public void onBindViewHolder(@NonNull NavigationMenuPresenter.ViewHolder paramViewHolder, int paramInt)
    {
      int i = getItemViewType(paramInt);
      Object localObject;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            localObject = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.items.get(paramInt);
            paramViewHolder.itemView.setPadding(0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingTop(), 0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingBottom());
          }
        }
        else {
          ((TextView)paramViewHolder.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt)).getMenuItem().getTitle());
        }
      }
      else
      {
        localObject = (NavigationMenuItemView)paramViewHolder.itemView;
        ((NavigationMenuItemView)localObject).setIconTintList(NavigationMenuPresenter.this.iconTintList);
        paramViewHolder = NavigationMenuPresenter.this;
        if (paramViewHolder.textAppearanceSet) {
          ((NavigationMenuItemView)localObject).setTextAppearance(paramViewHolder.textAppearance);
        }
        paramViewHolder = NavigationMenuPresenter.this.textColor;
        if (paramViewHolder != null) {
          ((NavigationMenuItemView)localObject).setTextColor(paramViewHolder);
        }
        paramViewHolder = NavigationMenuPresenter.this.itemBackground;
        if (paramViewHolder != null) {
          paramViewHolder = paramViewHolder.getConstantState().newDrawable();
        } else {
          paramViewHolder = null;
        }
        ViewCompat.setBackground((View)localObject, paramViewHolder);
        NavigationMenuPresenter.NavigationMenuTextItem localNavigationMenuTextItem = (NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt);
        ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(localNavigationMenuTextItem.needsEmptyIcon);
        ((NavigationMenuItemView)localObject).setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
        ((NavigationMenuItemView)localObject).setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
        paramViewHolder = NavigationMenuPresenter.this;
        if (paramViewHolder.hasCustomItemIconSize) {
          ((NavigationMenuItemView)localObject).setIconSize(paramViewHolder.itemIconSize);
        }
        ((NavigationMenuItemView)localObject).setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
        ((NavigationMenuItemView)localObject).initialize(localNavigationMenuTextItem.getMenuItem(), 0);
      }
    }
    
    @Nullable
    public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return null;
            }
            return new NavigationMenuPresenter.HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
          }
          return new NavigationMenuPresenter.SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
        }
        return new NavigationMenuPresenter.SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
      }
      NavigationMenuPresenter localNavigationMenuPresenter = NavigationMenuPresenter.this;
      return new NavigationMenuPresenter.NormalViewHolder(localNavigationMenuPresenter.layoutInflater, paramViewGroup, localNavigationMenuPresenter.onClickListener);
    }
    
    public void onViewRecycled(NavigationMenuPresenter.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) {
        ((NavigationMenuItemView)paramViewHolder.itemView).recycle();
      }
    }
    
    public void restoreInstanceState(@NonNull Bundle paramBundle)
    {
      int i = 0;
      int j = paramBundle.getInt("android:menu:checked", 0);
      int k;
      int m;
      Object localObject1;
      if (j != 0)
      {
        this.updateSuspended = true;
        k = this.items.size();
        for (m = 0; m < k; m++)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(m);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            localObject1 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if ((localObject1 != null) && (((MenuItemImpl)localObject1).getItemId() == j))
            {
              setCheckedItem((MenuItemImpl)localObject1);
              break;
            }
          }
        }
        this.updateSuspended = false;
        prepareMenuItems();
      }
      paramBundle = paramBundle.getSparseParcelableArray("android:menu:action_views");
      if (paramBundle != null)
      {
        k = this.items.size();
        for (m = i; m < k; m++)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(m);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            Object localObject2 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if (localObject2 != null)
            {
              localObject1 = ((MenuItemImpl)localObject2).getActionView();
              if (localObject1 != null)
              {
                localObject2 = (ParcelableSparseArray)paramBundle.get(((MenuItemImpl)localObject2).getItemId());
                if (localObject2 != null) {
                  ((View)localObject1).restoreHierarchyState((SparseArray)localObject2);
                }
              }
            }
          }
        }
      }
    }
    
    public void setCheckedItem(@NonNull MenuItemImpl paramMenuItemImpl)
    {
      if ((this.checkedItem != paramMenuItemImpl) && (paramMenuItemImpl.isCheckable()))
      {
        MenuItemImpl localMenuItemImpl = this.checkedItem;
        if (localMenuItemImpl != null) {
          localMenuItemImpl.setChecked(false);
        }
        this.checkedItem = paramMenuItemImpl;
        paramMenuItemImpl.setChecked(true);
      }
    }
    
    public void setUpdateSuspended(boolean paramBoolean)
    {
      this.updateSuspended = paramBoolean;
    }
    
    public void update()
    {
      prepareMenuItems();
      notifyDataSetChanged();
    }
  }
  
  private static class NavigationMenuHeaderItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {}
  
  private static abstract interface NavigationMenuItem {}
  
  private static class NavigationMenuSeparatorItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final int paddingBottom;
    private final int paddingTop;
    
    public NavigationMenuSeparatorItem(int paramInt1, int paramInt2)
    {
      this.paddingTop = paramInt1;
      this.paddingBottom = paramInt2;
    }
    
    public int getPaddingBottom()
    {
      return this.paddingBottom;
    }
    
    public int getPaddingTop()
    {
      return this.paddingTop;
    }
  }
  
  private static class NavigationMenuTextItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final MenuItemImpl menuItem;
    boolean needsEmptyIcon;
    
    NavigationMenuTextItem(MenuItemImpl paramMenuItemImpl)
    {
      this.menuItem = paramMenuItemImpl;
    }
    
    public MenuItemImpl getMenuItem()
    {
      return this.menuItem;
    }
  }
  
  private class NavigationMenuViewAccessibilityDelegate
    extends RecyclerViewAccessibilityDelegate
  {
    NavigationMenuViewAccessibilityDelegate(RecyclerView paramRecyclerView)
    {
      super();
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(NavigationMenuPresenter.this.adapter.getRowCount(), 0, false));
    }
  }
  
  private static class NormalViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public NormalViewHolder(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.itemView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static class SeparatorViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SeparatorViewHolder(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static class SubheaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SubheaderViewHolder(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public ViewHolder(View paramView)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\NavigationMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */