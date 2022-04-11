package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R.dimen;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.ArrayList;
import java.util.HashSet;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private static final int ITEM_POOL_SIZE = 5;
  private final int activeItemMaxWidth;
  private final int activeItemMinWidth;
  @NonNull
  private SparseArray<BadgeDrawable> badgeDrawables = new SparseArray(5);
  @Nullable
  private BottomNavigationItemView[] buttons;
  private final int inactiveItemMaxWidth;
  private final int inactiveItemMinWidth;
  private Drawable itemBackground;
  private int itemBackgroundRes;
  private final int itemHeight;
  private boolean itemHorizontalTranslationEnabled;
  @Dimension
  private int itemIconSize;
  private ColorStateList itemIconTint;
  private final Pools.Pool<BottomNavigationItemView> itemPool = new Pools.SynchronizedPool(5);
  @StyleRes
  private int itemTextAppearanceActive;
  @StyleRes
  private int itemTextAppearanceInactive;
  @Nullable
  private final ColorStateList itemTextColorDefault;
  private ColorStateList itemTextColorFromUser;
  private int labelVisibilityMode;
  private MenuBuilder menu;
  @NonNull
  private final View.OnClickListener onClickListener;
  private BottomNavigationPresenter presenter;
  private int selectedItemId = 0;
  private int selectedItemPosition = 0;
  @NonNull
  private final TransitionSet set;
  private int[] tempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.inactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.inactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.activeItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.activeItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.itemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.itemTextColorDefault = createDefaultColorStateList(16842808);
    paramContext = new AutoTransition();
    this.set = paramContext;
    paramContext.setOrdering(0);
    paramContext.setDuration(115L);
    paramContext.setInterpolator(new FastOutSlowInInterpolator());
    paramContext.addTransition(new TextScale());
    this.onClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.this.menu.performItemAction(paramAnonymousView, BottomNavigationMenuView.this.presenter, 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.tempChildWidths = new int[5];
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView1 = (BottomNavigationItemView)this.itemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView2 = localBottomNavigationItemView1;
    if (localBottomNavigationItemView1 == null) {
      localBottomNavigationItemView2 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView2;
  }
  
  private boolean isShifting(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 == -1 ? paramInt2 <= 3 : paramInt1 != 0) {
      bool = false;
    }
    return bool;
  }
  
  private boolean isValidId(int paramInt)
  {
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void removeUnusedBadges()
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= this.menu.size()) {
        break;
      }
      localHashSet.add(Integer.valueOf(this.menu.getItem(j).getItemId()));
    }
    while (k < this.badgeDrawables.size())
    {
      j = this.badgeDrawables.keyAt(k);
      if (!localHashSet.contains(Integer.valueOf(j))) {
        this.badgeDrawables.delete(j);
      }
      k++;
    }
  }
  
  private void setBadgeIfNeeded(@NonNull BottomNavigationItemView paramBottomNavigationItemView)
  {
    int i = paramBottomNavigationItemView.getId();
    if (!isValidId(i)) {
      return;
    }
    BadgeDrawable localBadgeDrawable = (BadgeDrawable)this.badgeDrawables.get(i);
    if (localBadgeDrawable != null) {
      paramBottomNavigationItemView.setBadge(localBadgeDrawable);
    }
  }
  
  private void validateMenuItemId(int paramInt)
  {
    if (isValidId(paramInt)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is not a valid view id");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void buildMenuView()
  {
    removeAllViews();
    Object localObject1 = this.buttons;
    Object localObject2;
    if (localObject1 != null)
    {
      int i = localObject1.length;
      for (j = 0; j < i; j++)
      {
        localObject2 = localObject1[j];
        if (localObject2 != null)
        {
          this.itemPool.release(localObject2);
          ((BottomNavigationItemView)localObject2).removeBadge();
        }
      }
    }
    if (this.menu.size() == 0)
    {
      this.selectedItemId = 0;
      this.selectedItemPosition = 0;
      this.buttons = null;
      return;
    }
    removeUnusedBadges();
    this.buttons = new BottomNavigationItemView[this.menu.size()];
    boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
    for (int j = 0; j < this.menu.size(); j++)
    {
      this.presenter.setUpdateSuspended(true);
      this.menu.getItem(j).setCheckable(true);
      this.presenter.setUpdateSuspended(false);
      localObject1 = getNewItem();
      this.buttons[j] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.itemIconTint);
      ((BottomNavigationItemView)localObject1).setIconSize(this.itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorDefault);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorFromUser);
      localObject2 = this.itemBackground;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.itemBackgroundRes);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.labelVisibilityMode);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)this.menu.getItem(j), 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(j);
      ((FrameLayout)localObject1).setOnClickListener(this.onClickListener);
      if ((this.selectedItemId != 0) && (this.menu.getItem(j).getItemId() == this.selectedItemId)) {
        this.selectedItemPosition = j;
      }
      setBadgeIfNeeded((BottomNavigationItemView)localObject1);
      addView((View)localObject1);
    }
    j = Math.min(this.menu.size() - 1, this.selectedItemPosition);
    this.selectedItemPosition = j;
    this.menu.getItem(j).setChecked(true);
  }
  
  @Nullable
  public ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = ViewGroup.EMPTY_STATE_SET;
    paramInt = localColorStateList.getColorForState((int[])localObject, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { paramInt, i, j });
  }
  
  @Nullable
  @VisibleForTesting
  BottomNavigationItemView findItemView(int paramInt)
  {
    validateMenuItemId(paramInt);
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[j];
        if (localBottomNavigationItemView.getId() == paramInt) {
          return localBottomNavigationItemView;
        }
      }
    }
    return null;
  }
  
  @Nullable
  BadgeDrawable getBadge(int paramInt)
  {
    return (BadgeDrawable)this.badgeDrawables.get(paramInt);
  }
  
  SparseArray<BadgeDrawable> getBadgeDrawables()
  {
    return this.badgeDrawables;
  }
  
  @Nullable
  public ColorStateList getIconTintList()
  {
    return this.itemIconTint;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return this.itemBackground;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.itemBackgroundRes;
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.itemIconSize;
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.itemTextAppearanceActive;
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.itemTextAppearanceInactive;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.itemTextColorFromUser;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.labelVisibilityMode;
  }
  
  BadgeDrawable getOrCreateBadge(int paramInt)
  {
    validateMenuItemId(paramInt);
    Object localObject1 = (BadgeDrawable)this.badgeDrawables.get(paramInt);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = BadgeDrawable.create(getContext());
      this.badgeDrawables.put(paramInt, localObject2);
    }
    localObject1 = findItemView(paramInt);
    if (localObject1 != null) {
      ((BottomNavigationItemView)localObject1).setBadge((BadgeDrawable)localObject2);
    }
    return (BadgeDrawable)localObject2;
  }
  
  public int getSelectedItemId()
  {
    return this.selectedItemId;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.menu = paramMenuBuilder;
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.itemHorizontalTranslationEnabled;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2++;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = this.menu.getVisibleItems().size();
    int k = getChildCount();
    int m = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
    Object localObject;
    int n;
    if ((isShifting(this.labelVisibilityMode, j)) && (this.itemHorizontalTranslationEnabled))
    {
      localObject = getChildAt(this.selectedItemPosition);
      paramInt2 = this.activeItemMinWidth;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), m);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = j - paramInt2;
      n = Math.min(i - this.inactiveItemMinWidth * paramInt2, Math.min(paramInt1, this.activeItemMaxWidth));
      j = i - n;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      i = Math.min(j / paramInt1, this.inactiveItemMaxWidth);
      paramInt2 = j - paramInt2 * i;
      paramInt1 = 0;
    }
    while (paramInt1 < k)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.tempChildWidths;
        if (paramInt1 == this.selectedItemPosition) {
          j = n;
        } else {
          j = i;
        }
        localObject[paramInt1] = j;
        j = paramInt2;
        if (paramInt2 > 0)
        {
          localObject[paramInt1] += 1;
          j = paramInt2 - 1;
        }
      }
      else
      {
        this.tempChildWidths[paramInt1] = 0;
        j = paramInt2;
      }
      paramInt1++;
      paramInt2 = j;
      continue;
      if (j == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = j;
      }
      n = Math.min(i / paramInt1, this.activeItemMaxWidth);
      paramInt2 = i - j * n;
      paramInt1 = 0;
      while (paramInt1 < k)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = this.tempChildWidths;
          localObject[paramInt1] = n;
          j = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            j = paramInt2 - 1;
          }
        }
        else
        {
          this.tempChildWidths[paramInt1] = 0;
          j = paramInt2;
        }
        paramInt1++;
        paramInt2 = j;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < k)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[paramInt1], 1073741824), m);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1++;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, m, 0));
  }
  
  void removeBadge(int paramInt)
  {
    validateMenuItemId(paramInt);
    BadgeDrawable localBadgeDrawable = (BadgeDrawable)this.badgeDrawables.get(paramInt);
    BottomNavigationItemView localBottomNavigationItemView = findItemView(paramInt);
    if (localBottomNavigationItemView != null) {
      localBottomNavigationItemView.removeBadge();
    }
    if (localBadgeDrawable != null) {
      this.badgeDrawables.remove(paramInt);
    }
  }
  
  void setBadgeDrawables(SparseArray<BadgeDrawable> paramSparseArray)
  {
    this.badgeDrawables = paramSparseArray;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[j];
        localBottomNavigationItemView.setBadge((BadgeDrawable)paramSparseArray.get(localBottomNavigationItemView.getId()));
      }
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.itemIconTint = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++) {
        arrayOfBottomNavigationItemView[j].setIconTintList(paramColorStateList);
      }
    }
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++) {
        arrayOfBottomNavigationItemView[j].setItemBackground(paramDrawable);
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.itemBackgroundRes = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++) {
        arrayOfBottomNavigationItemView[j].setItemBackground(paramInt);
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.itemHorizontalTranslationEnabled = paramBoolean;
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.itemIconSize = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++) {
        arrayOfBottomNavigationItemView[j].setIconSize(paramInt);
      }
    }
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.itemTextAppearanceActive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[j];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = this.itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
      }
    }
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.itemTextAppearanceInactive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[j];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = this.itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.itemTextColorFromUser = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < i; j++) {
        arrayOfBottomNavigationItemView[j].setTextColor(paramColorStateList);
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.presenter = paramBottomNavigationPresenter;
  }
  
  void tryRestoreSelectedItemId(int paramInt)
  {
    int i = this.menu.size();
    for (int j = 0; j < i; j++)
    {
      MenuItem localMenuItem = this.menu.getItem(j);
      if (paramInt == localMenuItem.getItemId())
      {
        this.selectedItemId = paramInt;
        this.selectedItemPosition = j;
        localMenuItem.setChecked(true);
        break;
      }
    }
  }
  
  public void updateMenuView()
  {
    Object localObject = this.menu;
    if ((localObject != null) && (this.buttons != null))
    {
      int i = ((MenuBuilder)localObject).size();
      if (i != this.buttons.length)
      {
        buildMenuView();
        return;
      }
      int j = this.selectedItemId;
      for (int k = 0; k < i; k++)
      {
        localObject = this.menu.getItem(k);
        if (((MenuItem)localObject).isChecked())
        {
          this.selectedItemId = ((MenuItem)localObject).getItemId();
          this.selectedItemPosition = k;
        }
      }
      if (j != this.selectedItemId) {
        TransitionManager.beginDelayedTransition(this, this.set);
      }
      boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
      for (k = 0; k < i; k++)
      {
        this.presenter.setUpdateSuspended(true);
        this.buttons[k].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[k].setShifting(bool);
        this.buttons[k].initialize((MenuItemImpl)this.menu.getItem(k), 0);
        this.presenter.setUpdateSuspended(false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomnavigation\BottomNavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */