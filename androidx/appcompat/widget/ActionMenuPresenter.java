package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.layout;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.ActionProvider.SubUiVisibilityListener;
import java.util.ArrayList;

class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  OverflowMenuButton mOverflowButton;
  OverflowPopup mOverflowPopup;
  private Drawable mPendingOverflowIcon;
  private boolean mPendingOverflowIconSet;
  private ActionMenuPopupCallback mPopupCallback;
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
  OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup == null) {
      return null;
    }
    int i = localViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = localViewGroup.getChildAt(j);
      if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
        return localView;
      }
    }
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)this.mMenuView;
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (this.mPopupCallback == null) {
      this.mPopupCallback = new ActionMenuPopupCallback();
    }
    paramItemView.setPopupCallback(this.mPopupCallback);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    Object localObject1 = this;
    Object localObject2 = ((BaseMenuPresenter)localObject1).mMenu;
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((MenuBuilder)localObject2).getVisibleItems();
      i = ((ArrayList)localObject2).size();
    }
    else
    {
      localObject2 = null;
      i = 0;
    }
    int j = ((ActionMenuPresenter)localObject1).mMaxItems;
    int k = ((ActionMenuPresenter)localObject1).mActionItemWidthLimit;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)((BaseMenuPresenter)localObject1).mMenuView;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4;
    while (n < i)
    {
      localObject3 = (MenuItemImpl)((ArrayList)localObject2).get(n);
      if (((MenuItemImpl)localObject3).requiresActionButton()) {
        i2++;
      } else if (((MenuItemImpl)localObject3).requestsActionButton()) {
        i3++;
      } else {
        i1 = 1;
      }
      i4 = j;
      if (((ActionMenuPresenter)localObject1).mExpandedActionViewsExclusive)
      {
        i4 = j;
        if (((MenuItemImpl)localObject3).isActionViewExpanded()) {
          i4 = 0;
        }
      }
      n++;
      j = i4;
    }
    n = j;
    if (((ActionMenuPresenter)localObject1).mReserveOverflow) {
      if (i1 == 0)
      {
        n = j;
        if (i3 + i2 <= j) {}
      }
      else
      {
        n = j - 1;
      }
    }
    j = n - i2;
    Object localObject3 = ((ActionMenuPresenter)localObject1).mActionButtonGroups;
    ((SparseBooleanArray)localObject3).clear();
    int i5;
    if (((ActionMenuPresenter)localObject1).mStrictWidthLimit)
    {
      n = ((ActionMenuPresenter)localObject1).mMinCellSize;
      i3 = k / n;
      i5 = n + k % n / i3;
    }
    else
    {
      i5 = 0;
      i3 = 0;
    }
    int i6 = 0;
    n = 0;
    i1 = k;
    k = i;
    for (;;)
    {
      localObject1 = this;
      if (i6 >= k) {
        break;
      }
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)((ArrayList)localObject2).get(i6);
      View localView;
      if (localMenuItemImpl.requiresActionButton())
      {
        localView = ((ActionMenuPresenter)localObject1).getItemView(localMenuItemImpl, null, localViewGroup);
        if (((ActionMenuPresenter)localObject1).mStrictWidthLimit) {
          i3 -= ActionMenuView.measureChildForCells(localView, i5, i3, m, 0);
        } else {
          localView.measure(m, m);
        }
        i2 = localView.getMeasuredWidth();
        i4 = i1 - i2;
        i = n;
        if (n == 0) {
          i = i2;
        }
        n = localMenuItemImpl.getGroupId();
        if (n != 0) {
          ((SparseBooleanArray)localObject3).put(n, true);
        }
        localMenuItemImpl.setIsActionButton(true);
      }
      for (;;)
      {
        i1 = i4;
        n = i;
        break label758;
        if (!localMenuItemImpl.requestsActionButton()) {
          break;
        }
        int i7 = localMenuItemImpl.getGroupId();
        boolean bool1 = ((SparseBooleanArray)localObject3).get(i7);
        int i8;
        if (((j > 0) || (bool1)) && (i1 > 0) && ((!((ActionMenuPresenter)localObject1).mStrictWidthLimit) || (i3 > 0))) {
          i8 = 1;
        } else {
          i8 = 0;
        }
        int i9 = i8;
        boolean bool2 = i8;
        i4 = i1;
        i2 = i3;
        i = n;
        if (i8 != 0)
        {
          localView = ((ActionMenuPresenter)localObject1).getItemView(localMenuItemImpl, null, localViewGroup);
          if (((ActionMenuPresenter)localObject1).mStrictWidthLimit)
          {
            i2 = ActionMenuView.measureChildForCells(localView, i5, i3, m, 0);
            i = i3 - i2;
            i3 = i;
            if (i2 == 0)
            {
              i9 = 0;
              i3 = i;
            }
          }
          else
          {
            localView.measure(m, m);
          }
          i2 = localView.getMeasuredWidth();
          i4 = i1 - i2;
          i = n;
          if (n == 0) {
            i = i2;
          }
          if (((ActionMenuPresenter)localObject1).mStrictWidthLimit ? i4 >= 0 : i4 + i > 0) {
            n = 1;
          } else {
            n = 0;
          }
          bool2 = i9 & n;
          i2 = i3;
        }
        if ((bool2) && (i7 != 0))
        {
          ((SparseBooleanArray)localObject3).put(i7, true);
          n = j;
        }
        else
        {
          n = j;
          if (bool1)
          {
            ((SparseBooleanArray)localObject3).put(i7, false);
            i3 = 0;
            for (;;)
            {
              n = j;
              if (i3 >= i6) {
                break;
              }
              localObject1 = (MenuItemImpl)((ArrayList)localObject2).get(i3);
              n = j;
              if (((MenuItemImpl)localObject1).getGroupId() == i7)
              {
                n = j;
                if (((MenuItemImpl)localObject1).isActionButton()) {
                  n = j + 1;
                }
                ((MenuItemImpl)localObject1).setIsActionButton(false);
              }
              i3++;
              j = n;
            }
          }
        }
        j = n;
        if (bool2) {
          j = n - 1;
        }
        localMenuItemImpl.setIsActionButton(bool2);
        i3 = i2;
      }
      localMenuItemImpl.setIsActionButton(false);
      label758:
      i6++;
    }
    return true;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    int i;
    if (paramMenuItemImpl.isActionViewExpanded()) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramView = (ActionMenuView)paramViewGroup;
    paramMenuItemImpl = localView.getLayoutParams();
    if (!paramView.checkLayoutParams(paramMenuItemImpl)) {
      localView.setLayoutParams(paramView.generateLayoutParams(paramMenuItemImpl));
    }
    return localView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = this.mMenuView;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localMenuView != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    OverflowMenuButton localOverflowMenuButton = this.mOverflowButton;
    if (localOverflowMenuButton != null) {
      return localOverflowMenuButton.getDrawable();
    }
    if (this.mPendingOverflowIconSet) {
      return this.mPendingOverflowIcon;
    }
    return null;
  }
  
  public boolean hideOverflowMenu()
  {
    OpenOverflowRunnable localOpenOverflowRunnable = this.mPostedOpenRunnable;
    if (localOpenOverflowRunnable != null)
    {
      localObject = this.mMenuView;
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(localOpenOverflowRunnable);
        this.mPostedOpenRunnable = null;
        return true;
      }
    }
    Object localObject = this.mOverflowPopup;
    if (localObject != null)
    {
      ((MenuPopupHelper)localObject).dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    ActionButtonSubmenu localActionButtonSubmenu = this.mActionButtonPopup;
    if (localActionButtonSubmenu != null)
    {
      localActionButtonSubmenu.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    paramMenuBuilder = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = paramContext.showsOverflowMenuButton();
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = paramContext.getMaxActionButtons();
    }
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        paramContext = new OverflowMenuButton(this.mSystemContext);
        this.mOverflowButton = paramContext;
        if (this.mPendingOverflowIconSet)
        {
          paramContext.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    else
    {
      this.mOverflowButton = null;
    }
    this.mActionItemWidthLimit = i;
    this.mMinCellSize = ((int)(paramMenuBuilder.getDisplayMetrics().density * 56.0F));
  }
  
  public boolean isOverflowMenuShowPending()
  {
    boolean bool;
    if ((this.mPostedOpenRunnable == null) && (!isOverflowMenuShowing())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isOverflowMenuShowing()
  {
    OverflowPopup localOverflowPopup = this.mOverflowPopup;
    boolean bool;
    if ((localOverflowPopup != null) && (localOverflowPopup.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet) {
      this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    }
    paramConfiguration = this.mMenu;
    if (paramConfiguration != null) {
      paramConfiguration.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      return;
    }
    int i = ((SavedState)paramParcelable).openSubMenuId;
    if (i > 0)
    {
      paramParcelable = this.mMenu.findItem(i);
      if (paramParcelable != null) {
        onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool1 = paramSubMenuBuilder.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != this.mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
    localObject = findViewForItem(((SubMenuBuilder)localObject).getItem());
    if (localObject == null) {
      return false;
    }
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    int i = paramSubMenuBuilder.size();
    for (int j = 0;; j++)
    {
      bool1 = bool2;
      if (j >= i) {
        break;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(j);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
    }
    localObject = new ActionButtonSubmenu(this.mContext, paramSubMenuBuilder, (View)localObject);
    this.mActionButtonPopup = ((ActionButtonSubmenu)localObject);
    ((MenuPopupHelper)localObject).setForceShowIcon(bool1);
    this.mActionButtonPopup.show();
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
    }
    else
    {
      MenuBuilder localMenuBuilder = this.mMenu;
      if (localMenuBuilder != null) {
        localMenuBuilder.close(false);
      }
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    OverflowMenuButton localOverflowMenuButton = this.mOverflowButton;
    if (localOverflowMenuButton != null)
    {
      localOverflowMenuButton.setImageDrawable(paramDrawable);
    }
    else
    {
      this.mPendingOverflowIconSet = true;
      this.mPendingOverflowIcon = paramDrawable;
    }
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()))
    {
      Object localObject = this.mMenu;
      if ((localObject != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null) && (!((MenuBuilder)localObject).getNonActionItems().isEmpty()))
      {
        localObject = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = ((OpenOverflowRunnable)localObject);
        ((View)this.mMenuView).post((Runnable)localObject);
        return true;
      }
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    Object localObject1 = this.mMenu;
    int i = 0;
    Object localObject2;
    int j;
    if (localObject1 != null)
    {
      localObject2 = ((MenuBuilder)localObject1).getActionItems();
      j = ((ArrayList)localObject2).size();
      for (k = 0; k < j; k++)
      {
        localObject1 = ((MenuItemImpl)((ArrayList)localObject2).get(k)).getSupportActionProvider();
        if (localObject1 != null) {
          ((ActionProvider)localObject1).setSubUiVisibilityListener(this);
        }
      }
    }
    localObject1 = this.mMenu;
    if (localObject1 != null) {
      localObject1 = ((MenuBuilder)localObject1).getNonActionItems();
    } else {
      localObject1 = null;
    }
    int k = i;
    boolean bool;
    if (this.mReserveOverflow)
    {
      k = i;
      if (localObject1 != null)
      {
        j = ((ArrayList)localObject1).size();
        if (j == 1)
        {
          bool = ((MenuItemImpl)((ArrayList)localObject1).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = i;
          if (j > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
      }
      localObject1 = (ViewGroup)this.mOverflowButton.getParent();
      if (localObject1 != this.mMenuView)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(this.mOverflowButton);
        }
        localObject1 = (ActionMenuView)this.mMenuView;
        ((ViewGroup)localObject1).addView(this.mOverflowButton, ((ActionMenuView)localObject1).generateOverflowButtonLayoutParams());
      }
    }
    else
    {
      localObject1 = this.mOverflowButton;
      if (localObject1 != null)
      {
        localObject1 = ((ImageView)localObject1).getParent();
        localObject2 = this.mMenuView;
        if (localObject1 == localObject2) {
          ((ViewGroup)localObject2).removeView(this.mOverflowButton);
        }
      }
    }
    ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
  }
  
  private class ActionButtonSubmenu
    extends MenuPopupHelper
  {
    public ActionButtonSubmenu(Context paramContext, SubMenuBuilder paramSubMenuBuilder, View paramView)
    {
      super(paramSubMenuBuilder, paramView, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
      {
        paramSubMenuBuilder = ActionMenuPresenter.this.mOverflowButton;
        paramContext = paramSubMenuBuilder;
        if (paramSubMenuBuilder == null) {
          paramContext = (View)ActionMenuPresenter.access$200(ActionMenuPresenter.this);
        }
        setAnchorView(paramContext);
      }
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss()
    {
      ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
      localActionMenuPresenter.mActionButtonPopup = null;
      localActionMenuPresenter.mOpenSubMenuId = 0;
      super.onDismiss();
    }
  }
  
  private class ActionMenuPopupCallback
    extends ActionMenuItemView.PopupCallback
  {
    ActionMenuPopupCallback() {}
    
    public ShowableListMenu getPopup()
    {
      Object localObject = ActionMenuPresenter.this.mActionButtonPopup;
      if (localObject != null) {
        localObject = ((MenuPopupHelper)localObject).getPopup();
      } else {
        localObject = null;
      }
      return (ShowableListMenu)localObject;
    }
  }
  
  private class OpenOverflowRunnable
    implements Runnable
  {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup paramOverflowPopup)
    {
      this.mPopup = paramOverflowPopup;
    }
    
    public void run()
    {
      if (ActionMenuPresenter.access$400(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.access$500(ActionMenuPresenter.this).changeMenuMode();
      }
      View localView = (View)ActionMenuPresenter.access$600(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow())) {
        ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
      }
      ActionMenuPresenter.this.mPostedOpenRunnable = null;
    }
  }
  
  private class OverflowMenuButton
    extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView
  {
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TooltipCompat.setTooltipText(this, getContentDescription());
      setOnTouchListener(new ForwardingListener(this)
      {
        public ShowableListMenu getPopup()
        {
          ActionMenuPresenter.OverflowPopup localOverflowPopup = ActionMenuPresenter.this.mOverflowPopup;
          if (localOverflowPopup == null) {
            return null;
          }
          return localOverflowPopup.getPopup();
        }
        
        public boolean onForwardingStarted()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public boolean onForwardingStopped()
        {
          ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
          if (localActionMenuPresenter.mPostedOpenRunnable != null) {
            return false;
          }
          localActionMenuPresenter.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt3 = getHeight();
        paramInt1 = Math.max(i, paramInt3) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt2 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        j = (i + (j - k)) / 2;
        paramInt2 = (paramInt3 + (paramInt2 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, j - paramInt1, paramInt2 - paramInt1, j + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private class OverflowPopup
    extends MenuPopupHelper
  {
    public OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
    {
      super(paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss()
    {
      if (ActionMenuPresenter.access$000(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.access$100(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.this.mOverflowPopup = null;
      super.onDismiss();
    }
  }
  
  private class PopupPresenterCallback
    implements MenuPresenter.Callback
  {
    PopupPresenterCallback() {}
    
    public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if ((paramMenuBuilder instanceof SubMenuBuilder)) {
        paramMenuBuilder.getRootMenu().close(false);
      }
      MenuPresenter.Callback localCallback = ActionMenuPresenter.this.getCallback();
      if (localCallback != null) {
        localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
    {
      Object localObject = ActionMenuPresenter.access$300(ActionMenuPresenter.this);
      boolean bool = false;
      if (paramMenuBuilder == localObject) {
        return false;
      }
      ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
      localObject = ActionMenuPresenter.this.getCallback();
      if (localObject != null) {
        bool = ((MenuPresenter.Callback)localObject).onOpenSubMenu(paramMenuBuilder);
      }
      return bool;
    }
  }
  
  @SuppressLint({"BanParcelableUsage"})
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }
      
      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.openSubMenuId);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */