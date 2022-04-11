package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuBuilder.ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  public ActionMenuView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(f * 4.0F));
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.hasText())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, Integer.MIN_VALUE), i);
      int j = paramView.getMeasuredWidth();
      int k = j / paramInt1;
      paramInt2 = k;
      if (j % paramInt1 != 0) {
        paramInt2 = k + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((localLayoutParams.isOverflowButton) || (paramInt3 == 0)) {
      bool = false;
    }
    localLayoutParams.expandable = bool;
    localLayoutParams.cellsUsed = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), i);
    return paramInt2;
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int n = getPaddingTop() + getPaddingBottom();
    int i1 = ViewGroup.getChildMeasureSpec(paramInt2, n, -2);
    int i2 = paramInt1 - (k + m);
    paramInt2 = this.mMinCellSize;
    paramInt1 = i2 / paramInt2;
    if (paramInt1 == 0)
    {
      setMeasuredDimension(i2, 0);
      return;
    }
    int i3 = paramInt2 + i2 % paramInt2 / paramInt1;
    int i4 = getChildCount();
    k = 0;
    int i5 = 0;
    m = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    long l1 = 0L;
    Object localObject1;
    Object localObject2;
    while (i5 < i4)
    {
      localObject1 = getChildAt(i5);
      if (((View)localObject1).getVisibility() == 8)
      {
        paramInt2 = i8;
      }
      else
      {
        boolean bool = localObject1 instanceof ActionMenuItemView;
        i6++;
        if (bool)
        {
          paramInt2 = this.mGeneratedItemPadding;
          ((View)localObject1).setPadding(paramInt2, 0, paramInt2, 0);
        }
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        ((LayoutParams)localObject2).expanded = false;
        ((LayoutParams)localObject2).extraPixels = 0;
        ((LayoutParams)localObject2).cellsUsed = 0;
        ((LayoutParams)localObject2).expandable = false;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
        if ((bool) && (((ActionMenuItemView)localObject1).hasText())) {
          bool = true;
        } else {
          bool = false;
        }
        ((LayoutParams)localObject2).preventEdgeOffset = bool;
        if (((LayoutParams)localObject2).isOverflowButton) {
          paramInt2 = 1;
        } else {
          paramInt2 = paramInt1;
        }
        i9 = measureChildForCells((View)localObject1, i3, paramInt2, i1, n);
        i7 = Math.max(i7, i9);
        paramInt2 = i8;
        if (((LayoutParams)localObject2).expandable) {
          paramInt2 = i8 + 1;
        }
        if (((LayoutParams)localObject2).isOverflowButton) {
          m = 1;
        }
        paramInt1 -= i9;
        k = Math.max(k, ((View)localObject1).getMeasuredHeight());
        if (i9 == 1) {
          l1 |= 1 << i5;
        }
      }
      i5++;
      i8 = paramInt2;
    }
    if ((m != 0) && (i6 == 2)) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    paramInt2 = 0;
    n = paramInt1;
    int i9 = i5;
    i5 = i2;
    while ((i8 > 0) && (n > 0))
    {
      int i10 = 0;
      int i11 = 0;
      i2 = Integer.MAX_VALUE;
      long l3;
      for (long l2 = 0L; i11 < i4; l2 = l3)
      {
        localObject2 = (LayoutParams)getChildAt(i11).getLayoutParams();
        int i12;
        if (!((LayoutParams)localObject2).expandable)
        {
          paramInt1 = i10;
          i12 = i2;
          l3 = l2;
        }
        else
        {
          int i13 = ((LayoutParams)localObject2).cellsUsed;
          if (i13 < i2)
          {
            l3 = 1L << i11;
            i12 = i13;
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = i10;
            i12 = i2;
            l3 = l2;
            if (i13 == i2)
            {
              paramInt1 = i10 + 1;
              l3 = l2 | 1L << i11;
              i12 = i2;
            }
          }
        }
        i11++;
        i10 = paramInt1;
        i2 = i12;
      }
      paramInt1 = paramInt2;
      paramInt2 = k;
      l1 |= l2;
      if (i10 > n) {
        break label724;
      }
      for (paramInt1 = 0; paramInt1 < i4; paramInt1++)
      {
        localObject2 = getChildAt(paramInt1);
        localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
        long l4 = 1 << paramInt1;
        if ((l2 & l4) == 0L)
        {
          l3 = l1;
          if (((LayoutParams)localObject1).cellsUsed == i2 + 1) {
            l3 = l1 | l4;
          }
          l1 = l3;
        }
        else
        {
          if ((i9 != 0) && (((LayoutParams)localObject1).preventEdgeOffset) && (n == 1))
          {
            k = this.mGeneratedItemPadding;
            ((View)localObject2).setPadding(k + i3, 0, k, 0);
          }
          ((LayoutParams)localObject1).cellsUsed += 1;
          ((LayoutParams)localObject1).expanded = true;
          n--;
        }
      }
      k = paramInt2;
      paramInt2 = 1;
    }
    paramInt1 = paramInt2;
    paramInt2 = k;
    label724:
    if ((m == 0) && (i6 == 1)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((n > 0) && (l1 != 0L) && ((n < i6 - 1) || (k != 0) || (i7 > 1)))
    {
      float f1 = Long.bitCount(l1);
      if (k == 0)
      {
        float f2 = f1;
        if ((l1 & 1L) != 0L)
        {
          f2 = f1;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
            f2 = f1 - 0.5F;
          }
        }
        k = i4 - 1;
        f1 = f2;
        if ((l1 & 1 << k) != 0L)
        {
          f1 = f2;
          if (!((LayoutParams)getChildAt(k).getLayoutParams()).preventEdgeOffset) {
            f1 = f2 - 0.5F;
          }
        }
      }
      if (f1 > 0.0F) {
        k = (int)(n * i3 / f1);
      } else {
        k = 0;
      }
      m = 0;
      for (;;)
      {
        i8 = paramInt1;
        if (m >= i4) {
          break;
        }
        if ((l1 & 1 << m) == 0L)
        {
          i8 = paramInt1;
        }
        else
        {
          localObject1 = getChildAt(m);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if ((localObject1 instanceof ActionMenuItemView))
          {
            ((LayoutParams)localObject2).extraPixels = k;
            ((LayoutParams)localObject2).expanded = true;
            if ((m == 0) && (!((LayoutParams)localObject2).preventEdgeOffset)) {
              ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (-k / 2);
            }
          }
          else
          {
            if (!((LayoutParams)localObject2).isOverflowButton) {
              break label1047;
            }
            ((LayoutParams)localObject2).extraPixels = k;
            ((LayoutParams)localObject2).expanded = true;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = (-k / 2);
          }
          i8 = 1;
          break label1085;
          label1047:
          if (m != 0) {
            ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (k / 2);
          }
          i8 = paramInt1;
          if (m != i4 - 1)
          {
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = (k / 2);
            i8 = paramInt1;
          }
        }
        label1085:
        m++;
        paramInt1 = i8;
      }
    }
    i8 = paramInt1;
    if (i8 != 0) {
      for (paramInt1 = 0; paramInt1 < i4; paramInt1++)
      {
        localObject1 = getChildAt(paramInt1);
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if (((LayoutParams)localObject2).expanded) {
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(((LayoutParams)localObject2).cellsUsed * i3 + ((LayoutParams)localObject2).extraPixels, 1073741824), i1);
        }
      }
    }
    if (i == 1073741824) {
      paramInt2 = j;
    }
    setMeasuredDimension(i5, paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    if (localActionMenuPresenter != null) {
      localActionMenuPresenter.dismissPopupMenus();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {
        paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public Menu getMenu()
  {
    if (this.mMenu == null)
    {
      Object localObject1 = getContext();
      Object localObject2 = new MenuBuilder((Context)localObject1);
      this.mMenu = ((MenuBuilder)localObject2);
      ((MenuBuilder)localObject2).setCallback(new MenuBuilderCallback());
      localObject2 = new ActionMenuPresenter((Context)localObject1);
      this.mPresenter = ((ActionMenuPresenter)localObject2);
      ((ActionMenuPresenter)localObject2).setReserveOverflow(true);
      localObject1 = this.mPresenter;
      localObject2 = this.mActionMenuPresenterCallback;
      if (localObject2 == null) {
        localObject2 = new ActionMenuPresenterCallback();
      }
      ((BaseMenuPresenter)localObject1).setCallback((MenuPresenter.Callback)localObject2);
      this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
    }
    return this.mMenu;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    getMenu();
    return this.mPresenter.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getWindowAnimations()
  {
    return 0;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    boolean bool1 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool2 = bool1;
    if (paramInt < getChildCount())
    {
      bool2 = bool1;
      if ((localView1 instanceof ActionMenuChildView)) {
        bool2 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if ((localView2 instanceof ActionMenuChildView)) {
        bool1 = bool2 | ((ActionMenuChildView)localView2).needsDividerBefore();
      }
    }
    return bool1;
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    boolean bool;
    if ((localActionMenuPresenter != null) && (localActionMenuPresenter.hideOverflowMenu())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    boolean bool;
    if ((localActionMenuPresenter != null) && (localActionMenuPresenter.isOverflowMenuShowPending())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    boolean bool;
    if ((localActionMenuPresenter != null) && (localActionMenuPresenter.isOverflowMenuShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.mPresenter;
    if (paramConfiguration != null)
    {
      paramConfiguration.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing())
      {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i = getChildCount();
    int j = (paramInt4 - paramInt2) / 2;
    int k = getDividerWidth();
    int m = paramInt3 - paramInt1;
    paramInt1 = m - getPaddingRight() - getPaddingLeft();
    paramBoolean = ViewUtils.isLayoutRtl(this);
    paramInt3 = 0;
    paramInt4 = 0;
    paramInt2 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    int i2;
    while (paramInt3 < i)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isOverflowButton)
        {
          n = localView.getMeasuredWidth();
          paramInt4 = n;
          if (hasSupportDividerBeforeChildAt(paramInt3)) {
            paramInt4 = n + k;
          }
          int i1 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            n = getPaddingLeft() + localLayoutParams.leftMargin;
            i2 = n + paramInt4;
          }
          else
          {
            i2 = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            n = i2 - paramInt4;
          }
          int i3 = j - i1 / 2;
          localView.layout(n, i3, i2, i1 + i3);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        }
        else
        {
          paramInt1 -= localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          hasSupportDividerBeforeChildAt(paramInt3);
          paramInt2++;
        }
      }
      paramInt3++;
    }
    if ((i == 1) && (paramInt4 == 0))
    {
      localView = getChildAt(0);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = m / 2 - paramInt1 / 2;
      paramInt4 = j - paramInt2 / 2;
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    paramInt2 -= (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt3 = getWidth() - getPaddingRight();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt2 = paramInt3;
        if (localView.getVisibility() != 8) {
          if (localLayoutParams.isOverflowButton)
          {
            paramInt2 = paramInt3;
          }
          else
          {
            n = paramInt3 - localLayoutParams.rightMargin;
            paramInt3 = localView.getMeasuredWidth();
            paramInt2 = localView.getMeasuredHeight();
            i2 = j - paramInt2 / 2;
            localView.layout(n - paramInt3, i2, n, paramInt2 + i2);
            paramInt2 = n - (paramInt3 + localLayoutParams.leftMargin + paramInt4);
          }
        }
        paramInt1++;
        paramInt3 = paramInt2;
      }
    }
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localView = getChildAt(paramInt1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8) {
        if (localLayoutParams.isOverflowButton)
        {
          paramInt3 = paramInt2;
        }
        else
        {
          paramInt2 += localLayoutParams.leftMargin;
          i2 = localView.getMeasuredWidth();
          n = localView.getMeasuredHeight();
          paramInt3 = j - n / 2;
          localView.layout(paramInt2, paramInt3, paramInt2 + i2, n + paramInt3);
          paramInt3 = paramInt2 + (i2 + localLayoutParams.rightMargin + paramInt4);
        }
      }
      paramInt1++;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.mFormatItems;
    boolean bool2;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.mFormatItems = bool2;
    if (bool1 != bool2) {
      this.mFormatItemsWidth = 0;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    Object localObject;
    if (this.mFormatItems)
    {
      localObject = this.mMenu;
      if ((localObject != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        ((MenuBuilder)localObject).onItemsChanged(true);
      }
    }
    int j = getChildCount();
    if ((this.mFormatItems) && (j > 0))
    {
      onMeasureExactFormat(paramInt1, paramInt2);
    }
    else
    {
      for (i = 0; i < j; i++)
      {
        localObject = (LayoutParams)getChildAt(i).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      }
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public MenuBuilder peekMenu()
  {
    return this.mMenu;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    getMenu();
    this.mPresenter.setOverflowIcon(paramDrawable);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(@StyleRes int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0) {
        this.mPopupContext = getContext();
      } else {
        this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
    paramActionMenuPresenter.setMenuView(this);
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    boolean bool;
    if ((localActionMenuPresenter != null) && (localActionMenuPresenter.showOverflowMenu())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  private static class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
    {
      return false;
    }
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }
    
    LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }
  }
  
  private class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    MenuBuilderCallback() {}
    
    public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
    {
      paramMenuBuilder = ActionMenuView.this.mOnMenuItemClickListener;
      boolean bool;
      if ((paramMenuBuilder != null) && (paramMenuBuilder.onMenuItemClick(paramMenuItem))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
    {
      MenuBuilder.Callback localCallback = ActionMenuView.this.mMenuBuilderCallback;
      if (localCallback != null) {
        localCallback.onMenuModeChange(paramMenuBuilder);
      }
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */