package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private static final String TAG = "Toolbar";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  int mButtonGravity;
  ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private int mContentInsetEndWithActions;
  private int mContentInsetStartWithNavigation;
  private RtlSpacingHelper mContentInsets;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  View mExpandedActionView;
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private final ArrayList<View> mHiddenViews = new ArrayList();
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private ActionMenuView mMenuView;
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      Toolbar.OnMenuItemClickListener localOnMenuItemClickListener = Toolbar.this.mOnMenuItemClickListener;
      if (localOnMenuItemClickListener != null) {
        return localOnMenuItemClickListener.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ImageButton mNavButtonView;
  OnMenuItemClickListener mOnMenuItemClickListener;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new Runnable()
  {
    public void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private ColorStateList mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<View> mTempViews = new ArrayList();
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private ColorStateList mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;
  
  public Toolbar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getContext();
    int[] arrayOfInt = R.styleable.Toolbar;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    ViewCompat.saveAttributeDataForStyleable(this, paramContext, arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getWrappedTypeArray(), paramInt, 0);
    this.mTitleTextAppearance = ((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = ((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = ((TintTypedArray)localObject).getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = ((TintTypedArray)localObject).getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    int j = R.styleable.Toolbar_titleMargins;
    paramInt = i;
    if (((TintTypedArray)localObject).hasValue(j)) {
      paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(j, i);
    }
    this.mTitleMarginBottom = paramInt;
    this.mTitleMarginTop = paramInt;
    this.mTitleMarginEnd = paramInt;
    this.mTitleMarginStart = paramInt;
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.mTitleMarginStart = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.mTitleMarginEnd = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.mTitleMarginTop = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.mTitleMarginBottom = paramInt;
    }
    this.mMaxButtonHeight = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    int k = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    i = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    j = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    ensureContentInsets();
    this.mContentInsets.setAbsolute(i, j);
    if ((k != Integer.MIN_VALUE) || (paramInt != Integer.MIN_VALUE)) {
      this.mContentInsets.setRelative(k, paramInt);
    }
    this.mContentInsetStartWithNavigation = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
    this.mContentInsetEndWithActions = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
    this.mCollapseIcon = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_collapseContentDescription);
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramContext)) {
      setTitle(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramContext)) {
      setSubtitle(paramContext);
    }
    this.mPopupContext = getContext();
    setPopupTheme(((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_popupTheme, 0));
    paramContext = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_navigationIcon);
    if (paramContext != null) {
      setNavigationIcon(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramContext)) {
      setNavigationContentDescription(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_logo);
    if (paramContext != null) {
      setLogo(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramContext)) {
      setLogoDescription(paramContext);
    }
    paramInt = R.styleable.Toolbar_titleTextColor;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      setTitleTextColor(((TintTypedArray)localObject).getColorStateList(paramInt));
    }
    paramInt = R.styleable.Toolbar_subtitleTextColor;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      setSubtitleTextColor(((TintTypedArray)localObject).getColorStateList(paramInt));
    }
    paramInt = R.styleable.Toolbar_menu;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      inflateMenu(((TintTypedArray)localObject).getResourceId(paramInt, 0));
    }
    ((TintTypedArray)localObject).recycle();
  }
  
  private void addCustomViewsWithGravity(List<View> paramList, int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int k = getChildCount();
    int m = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    paramList.clear();
    paramInt = j;
    Object localObject1;
    Object localObject2;
    if (i != 0) {
      for (paramInt = k - 1; paramInt >= 0; paramInt--)
      {
        localObject1 = getChildAt(paramInt);
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if ((((LayoutParams)localObject2).mViewType == 0) && (shouldLayout((View)localObject1)) && (getChildHorizontalGravity(((ActionBar.LayoutParams)localObject2).gravity) == m)) {
          paramList.add(localObject1);
        }
      }
    }
    while (paramInt < k)
    {
      localObject2 = getChildAt(paramInt);
      localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
      if ((((LayoutParams)localObject1).mViewType == 0) && (shouldLayout((View)localObject2)) && (getChildHorizontalGravity(((ActionBar.LayoutParams)localObject1).gravity) == m)) {
        paramList.add(localObject2);
      }
      paramInt++;
    }
  }
  
  private void addSystemView(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateDefaultLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = generateLayoutParams((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (LayoutParams)localObject;
    }
    ((LayoutParams)localObject).mViewType = 1;
    if ((paramBoolean) && (this.mExpandedActionView != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mHiddenViews.add(paramView);
    }
    else
    {
      addView(paramView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void ensureContentInsets()
  {
    if (this.mContentInsets == null) {
      this.mContentInsets = new RtlSpacingHelper();
    }
  }
  
  private void ensureLogoView()
  {
    if (this.mLogoView == null) {
      this.mLogoView = new AppCompatImageView(getContext());
    }
  }
  
  private void ensureMenu()
  {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null)
    {
      MenuBuilder localMenuBuilder = (MenuBuilder)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null) {
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
      }
      this.mMenuView.setExpandedActionViewsExclusive(true);
      localMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
  }
  
  private void ensureMenuView()
  {
    if (this.mMenuView == null)
    {
      Object localObject = new ActionMenuView(getContext());
      this.mMenuView = ((ActionMenuView)localObject);
      ((ActionMenuView)localObject).setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      localObject = generateDefaultLayoutParams();
      ((ActionBar.LayoutParams)localObject).gravity = (0x800005 | this.mButtonGravity & 0x70);
      this.mMenuView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addSystemView(this.mMenuView, false);
    }
  }
  
  private void ensureNavButtonView()
  {
    if (this.mNavButtonView == null)
    {
      this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | this.mButtonGravity & 0x70);
      this.mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int getChildHorizontalGravity(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = GravityCompat.getAbsoluteGravity(paramInt, i) & 0x7;
    if (j != 1)
    {
      paramInt = 3;
      if ((j != 3) && (j != 5))
      {
        if (i == 1) {
          paramInt = 5;
        }
        return paramInt;
      }
    }
    return j;
  }
  
  private int getChildTop(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (i - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int j = getChildVerticalGravity(localLayoutParams.gravity);
    if (j != 48)
    {
      if (j != 80)
      {
        int k = getPaddingTop();
        int m = getPaddingBottom();
        int n = getHeight();
        j = (n - k - m - i) / 2;
        paramInt = localLayoutParams.topMargin;
        if (j >= paramInt)
        {
          i = n - m - i - j - k;
          m = localLayoutParams.bottomMargin;
          paramInt = j;
          if (i < m) {
            paramInt = Math.max(0, j - (m - i));
          }
        }
        return k + paramInt;
      }
      return getHeight() - getPaddingBottom() - i - localLayoutParams.bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    if (i != 16)
    {
      paramInt = i;
      if (i != 48)
      {
        paramInt = i;
        if (i != 80) {
          paramInt = this.mGravity & 0x70;
        }
      }
    }
    return paramInt;
  }
  
  private int getHorizontalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(paramView) + MarginLayoutParamsCompat.getMarginEnd(paramView);
  }
  
  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }
  
  private int getVerticalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return paramView.topMargin + paramView.bottomMargin;
  }
  
  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramList.size();
    int m = 0;
    int n = 0;
    while (m < k)
    {
      View localView = (View)paramList.get(m);
      paramArrayOfInt = (LayoutParams)localView.getLayoutParams();
      i = paramArrayOfInt.leftMargin - i;
      j = paramArrayOfInt.rightMargin - j;
      int i1 = Math.max(0, i);
      int i2 = Math.max(0, j);
      i = Math.max(0, -i);
      j = Math.max(0, -j);
      n += i1 + localView.getMeasuredWidth() + i2;
      m++;
    }
    return n;
  }
  
  private boolean isChildOrHidden(View paramView)
  {
    boolean bool;
    if ((paramView.getParent() != this) && (!this.mHiddenViews.contains(paramView))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + (i + localLayoutParams.rightMargin);
  }
  
  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    i = getChildTop(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - paramInt2, i, paramInt1, paramView.getMeasuredHeight() + i);
    return paramInt1 - (paramInt2 + localLayoutParams.leftMargin);
  }
  
  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, localMarginLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  private void postShowOverflowMenu()
  {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }
  
  private boolean shouldCollapse()
  {
    if (!this.mCollapsible) {
      return false;
    }
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean shouldLayout(View paramView)
  {
    boolean bool;
    if ((paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void addChildrenForExpandedActionView()
  {
    for (int i = this.mHiddenViews.size() - 1; i >= 0; i--) {
      addView((View)this.mHiddenViews.get(i));
    }
    this.mHiddenViews.clear();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean canShowOverflowMenu()
  {
    if (getVisibility() == 0)
    {
      ActionMenuView localActionMenuView = this.mMenuView;
      if ((localActionMenuView != null) && (localActionMenuView.isOverflowReserved())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void collapseActionView()
  {
    Object localObject = this.mExpandedMenuPresenter;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ExpandedActionViewMenuPresenter)localObject).mCurrentExpandedItem;
    }
    if (localObject != null) {
      ((MenuItemImpl)localObject).collapseActionView();
    }
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.dismissPopupMenus();
    }
  }
  
  void ensureCollapseButtonView()
  {
    if (this.mCollapseButtonView == null)
    {
      Object localObject = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.mCollapseButtonView = ((ImageButton)localObject);
      ((ImageButton)localObject).setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      localObject = generateDefaultLayoutParams();
      ((ActionBar.LayoutParams)localObject).gravity = (0x800003 | this.mButtonGravity & 0x70);
      ((LayoutParams)localObject).mViewType = 2;
      this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mCollapseButtonView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  @Nullable
  public CharSequence getCollapseContentDescription()
  {
    Object localObject = this.mCollapseButtonView;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  @Nullable
  public Drawable getCollapseIcon()
  {
    Object localObject = this.mCollapseButtonView;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public int getContentInsetEnd()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    int i;
    if (localRtlSpacingHelper != null) {
      i = localRtlSpacingHelper.getEnd();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i = this.mContentInsetEndWithActions;
    if (i == Integer.MIN_VALUE) {
      i = getContentInsetEnd();
    }
    return i;
  }
  
  public int getContentInsetLeft()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    int i;
    if (localRtlSpacingHelper != null) {
      i = localRtlSpacingHelper.getLeft();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetRight()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    int i;
    if (localRtlSpacingHelper != null) {
      i = localRtlSpacingHelper.getRight();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetStart()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    int i;
    if (localRtlSpacingHelper != null) {
      i = localRtlSpacingHelper.getStart();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i = this.mContentInsetStartWithNavigation;
    if (i == Integer.MIN_VALUE) {
      i = getContentInsetStart();
    }
    return i;
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = this.mMenuView;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).peekMenu();
      if ((localObject != null) && (((MenuBuilder)localObject).hasVisibleItems()))
      {
        i = 1;
        break label32;
      }
    }
    int i = 0;
    label32:
    if (i != 0) {
      i = Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    } else {
      i = getContentInsetEnd();
    }
    return i;
  }
  
  public int getCurrentContentInsetLeft()
  {
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = getCurrentContentInsetEnd();
    } else {
      i = getCurrentContentInsetStart();
    }
    return i;
  }
  
  public int getCurrentContentInsetRight()
  {
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = getCurrentContentInsetStart();
    } else {
      i = getCurrentContentInsetEnd();
    }
    return i;
  }
  
  public int getCurrentContentInsetStart()
  {
    int i;
    if (getNavigationIcon() != null) {
      i = Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    } else {
      i = getContentInsetStart();
    }
    return i;
  }
  
  public Drawable getLogo()
  {
    Object localObject = this.mLogoView;
    if (localObject != null) {
      localObject = ((ImageView)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public CharSequence getLogoDescription()
  {
    Object localObject = this.mLogoView;
    if (localObject != null) {
      localObject = ((ImageView)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  public Menu getMenu()
  {
    ensureMenu();
    return this.mMenuView.getMenu();
  }
  
  @Nullable
  public CharSequence getNavigationContentDescription()
  {
    Object localObject = this.mNavButtonView;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  @Nullable
  public Drawable getNavigationIcon()
  {
    Object localObject = this.mNavButtonView;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.mOuterActionMenuPresenter;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    ensureMenu();
    return this.mMenuView.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.mPopupContext;
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitleText;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  final TextView getSubtitleTextView()
  {
    return this.mSubtitleTextView;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitleText;
  }
  
  public int getTitleMarginBottom()
  {
    return this.mTitleMarginBottom;
  }
  
  public int getTitleMarginEnd()
  {
    return this.mTitleMarginEnd;
  }
  
  public int getTitleMarginStart()
  {
    return this.mTitleMarginStart;
  }
  
  public int getTitleMarginTop()
  {
    return this.mTitleMarginTop;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  final TextView getTitleTextView()
  {
    return this.mTitleTextView;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public DecorToolbar getWrapper()
  {
    if (this.mWrapper == null) {
      this.mWrapper = new ToolbarWidgetWrapper(this, true);
    }
    return this.mWrapper;
  }
  
  public boolean hasExpandedActionView()
  {
    ExpandedActionViewMenuPresenter localExpandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
    boolean bool;
    if ((localExpandedActionViewMenuPresenter != null) && (localExpandedActionViewMenuPresenter.mCurrentExpandedItem != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    boolean bool;
    if ((localActionMenuView != null) && (localActionMenuView.hideOverflowMenu())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void inflateMenu(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    boolean bool;
    if ((localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowPending())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    boolean bool;
    if ((localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isTitleTruncated()
  {
    Object localObject = this.mTitleTextView;
    if (localObject == null) {
      return false;
    }
    localObject = ((TextView)localObject).getLayout();
    if (localObject == null) {
      return false;
    }
    int i = ((Layout)localObject).getLineCount();
    for (int j = 0; j < i; j++) {
      if (((Layout)localObject).getEllipsisCount(j) > 0) {
        return true;
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.mEatingHover = false;
    }
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.mEatingHover = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getWidth();
    int k = getHeight();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = j - n;
    int[] arrayOfInt = this.mTempMargins;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ViewCompat.getMinimumHeight(this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    }
    if (shouldLayout(this.mNavButtonView))
    {
      if (i != 0)
      {
        paramInt3 = layoutChildRight(this.mNavButtonView, i3, arrayOfInt, paramInt4);
        i4 = m;
        break label167;
      }
      i4 = layoutChildLeft(this.mNavButtonView, m, arrayOfInt, paramInt4);
    }
    else
    {
      i4 = m;
    }
    paramInt3 = i3;
    label167:
    paramInt2 = i4;
    paramInt1 = paramInt3;
    if (shouldLayout(this.mCollapseButtonView)) {
      if (i != 0)
      {
        paramInt1 = layoutChildRight(this.mCollapseButtonView, paramInt3, arrayOfInt, paramInt4);
        paramInt2 = i4;
      }
      else
      {
        paramInt2 = layoutChildLeft(this.mCollapseButtonView, i4, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      }
    }
    int i4 = paramInt2;
    paramInt3 = paramInt1;
    if (shouldLayout(this.mMenuView)) {
      if (i != 0)
      {
        i4 = layoutChildLeft(this.mMenuView, paramInt2, arrayOfInt, paramInt4);
        paramInt3 = paramInt1;
      }
      else
      {
        paramInt3 = layoutChildRight(this.mMenuView, paramInt1, arrayOfInt, paramInt4);
        i4 = paramInt2;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - i4);
    arrayOfInt[1] = Math.max(0, paramInt1 - (i3 - paramInt3));
    paramInt2 = Math.max(i4, paramInt2);
    paramInt3 = Math.min(paramInt3, i3 - paramInt1);
    i4 = paramInt2;
    paramInt1 = paramInt3;
    if (shouldLayout(this.mExpandedActionView)) {
      if (i != 0)
      {
        paramInt1 = layoutChildRight(this.mExpandedActionView, paramInt3, arrayOfInt, paramInt4);
        i4 = paramInt2;
      }
      else
      {
        i4 = layoutChildLeft(this.mExpandedActionView, paramInt2, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      }
    }
    paramInt3 = i4;
    paramInt2 = paramInt1;
    if (shouldLayout(this.mLogoView)) {
      if (i != 0)
      {
        paramInt2 = layoutChildRight(this.mLogoView, paramInt1, arrayOfInt, paramInt4);
        paramInt3 = i4;
      }
      else
      {
        paramInt3 = layoutChildLeft(this.mLogoView, i4, arrayOfInt, paramInt4);
        paramInt2 = paramInt1;
      }
    }
    paramBoolean = shouldLayout(this.mTitleTextView);
    boolean bool = shouldLayout(this.mSubtitleTextView);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
      paramInt1 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (bool)
    {
      localObject1 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
      paramInt1 += ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
    }
    if ((!paramBoolean) && (!bool)) {}
    for (paramInt1 = paramInt3;; paramInt1 = paramInt3)
    {
      paramInt3 = paramInt2;
      break label1310;
      if (paramBoolean) {
        localObject1 = this.mTitleTextView;
      } else {
        localObject1 = this.mSubtitleTextView;
      }
      if (bool) {
        localObject2 = this.mSubtitleTextView;
      } else {
        localObject2 = this.mTitleTextView;
      }
      localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
      Object localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
      if (((paramBoolean) && (this.mTitleTextView.getMeasuredWidth() > 0)) || ((bool) && (this.mSubtitleTextView.getMeasuredWidth() > 0))) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      i3 = this.mGravity & 0x70;
      if (i3 != 48)
      {
        if (i3 != 80)
        {
          i3 = (k - i1 - i2 - paramInt1) / 2;
          int i5 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          int i6 = this.mTitleMarginTop;
          if (i3 < i5 + i6)
          {
            paramInt1 = i5 + i6;
          }
          else
          {
            i5 = k - i2 - paramInt1 - i3 - i1;
            k = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
            i2 = this.mTitleMarginBottom;
            paramInt1 = i3;
            if (i5 < k + i2) {
              paramInt1 = Math.max(0, i3 - (((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + i2 - i5));
            }
          }
          paramInt1 = i1 + paramInt1;
        }
        else
        {
          paramInt1 = k - i2 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - this.mTitleMarginBottom - paramInt1;
        }
      }
      else {
        paramInt1 = getPaddingTop() + ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.mTitleMarginTop;
      }
      if (i == 0) {
        break;
      }
      if (i4 != 0) {
        i = this.mTitleMarginStart;
      } else {
        i = 0;
      }
      i -= arrayOfInt[1];
      paramInt2 -= Math.max(0, i);
      arrayOfInt[1] = Math.max(0, -i);
      if (paramBoolean)
      {
        localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
        i3 = paramInt2 - this.mTitleTextView.getMeasuredWidth();
        i = this.mTitleTextView.getMeasuredHeight() + paramInt1;
        this.mTitleTextView.layout(i3, paramInt1, paramInt2, i);
        paramInt1 = i3 - this.mTitleMarginEnd;
        i += ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
      }
      else
      {
        i3 = paramInt2;
        i = paramInt1;
        paramInt1 = i3;
      }
      if (bool)
      {
        i1 = i + ((LayoutParams)this.mSubtitleTextView.getLayoutParams()).topMargin;
        i = this.mSubtitleTextView.getMeasuredWidth();
        i3 = this.mSubtitleTextView.getMeasuredHeight();
        this.mSubtitleTextView.layout(paramInt2 - i, i1, paramInt2, i3 + i1);
        i = paramInt2 - this.mTitleMarginEnd;
      }
      else
      {
        i = paramInt2;
      }
      if (i4 != 0) {
        paramInt2 = Math.min(paramInt1, i);
      }
    }
    if (i4 != 0) {
      i = this.mTitleMarginStart;
    } else {
      i = 0;
    }
    i -= arrayOfInt[0];
    paramInt3 += Math.max(0, i);
    arrayOfInt[0] = Math.max(0, -i);
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
      i = this.mTitleTextView.getMeasuredWidth() + paramInt3;
      i3 = this.mTitleTextView.getMeasuredHeight() + paramInt1;
      this.mTitleTextView.layout(paramInt3, paramInt1, i, i3);
      i += this.mTitleMarginEnd;
      paramInt1 = i3 + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
    }
    else
    {
      i = paramInt3;
    }
    if (bool)
    {
      i1 = paramInt1 + ((LayoutParams)this.mSubtitleTextView.getLayoutParams()).topMargin;
      i3 = this.mSubtitleTextView.getMeasuredWidth() + paramInt3;
      paramInt1 = this.mSubtitleTextView.getMeasuredHeight();
      this.mSubtitleTextView.layout(paramInt3, i1, i3, paramInt1 + i1);
      i3 += this.mTitleMarginEnd;
    }
    else
    {
      i3 = paramInt3;
    }
    paramInt1 = paramInt3;
    paramInt3 = paramInt2;
    if (i4 != 0)
    {
      paramInt1 = Math.max(i, i3);
      paramInt3 = paramInt2;
    }
    label1310:
    i4 = m;
    m = 0;
    addCustomViewsWithGravity(this.mTempViews, 3);
    int i = this.mTempViews.size();
    for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
      paramInt1 = layoutChildLeft((View)this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, paramInt4);
    }
    addCustomViewsWithGravity(this.mTempViews, 5);
    i = this.mTempViews.size();
    for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
      paramInt3 = layoutChildRight((View)this.mTempViews.get(paramInt2), paramInt3, arrayOfInt, paramInt4);
    }
    addCustomViewsWithGravity(this.mTempViews, 1);
    i = getViewListMeasuredWidth(this.mTempViews, arrayOfInt);
    paramInt2 = i4 + (j - i4 - n) / 2 - i / 2;
    i4 = i + paramInt2;
    if (paramInt2 >= paramInt1) {
      if (i4 > paramInt3) {
        paramInt1 = paramInt2 - (i4 - paramInt3);
      } else {
        paramInt1 = paramInt2;
      }
    }
    paramInt3 = this.mTempViews.size();
    paramInt2 = paramInt1;
    for (paramInt1 = m; paramInt1 < paramInt3; paramInt1++) {
      paramInt2 = layoutChildLeft((View)this.mTempViews.get(paramInt1), paramInt2, arrayOfInt, paramInt4);
    }
    this.mTempViews.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mTempMargins;
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i = 0;
    if (bool)
    {
      j = 1;
      k = 0;
    }
    else
    {
      j = 0;
      k = 1;
    }
    if (shouldLayout(this.mNavButtonView))
    {
      measureChildConstrained(this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      m = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
      n = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
      i1 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    }
    else
    {
      m = 0;
      n = 0;
      i1 = 0;
    }
    int i2 = m;
    int i3 = n;
    int m = i1;
    if (shouldLayout(this.mCollapseButtonView))
    {
      measureChildConstrained(this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      i2 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
      i3 = Math.max(n, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
      m = View.combineMeasuredStates(i1, this.mCollapseButtonView.getMeasuredState());
    }
    int i1 = getCurrentContentInsetStart();
    int n = 0 + Math.max(i1, i2);
    arrayOfInt[j] = Math.max(0, i1 - i2);
    if (shouldLayout(this.mMenuView))
    {
      measureChildConstrained(this.mMenuView, paramInt1, n, paramInt2, 0, this.mMaxButtonHeight);
      i1 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
      i3 = Math.max(i3, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
      m = View.combineMeasuredStates(m, this.mMenuView.getMeasuredState());
    }
    else
    {
      i1 = 0;
    }
    i2 = getCurrentContentInsetEnd();
    int j = n + Math.max(i2, i1);
    arrayOfInt[k] = Math.max(0, i2 - i1);
    int k = i3;
    i1 = m;
    n = j;
    if (shouldLayout(this.mExpandedActionView))
    {
      n = j + measureChildCollapseMargins(this.mExpandedActionView, paramInt1, j, paramInt2, 0, arrayOfInt);
      k = Math.max(i3, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
      i1 = View.combineMeasuredStates(m, this.mExpandedActionView.getMeasuredState());
    }
    i3 = k;
    m = i1;
    j = n;
    if (shouldLayout(this.mLogoView))
    {
      j = n + measureChildCollapseMargins(this.mLogoView, paramInt1, n, paramInt2, 0, arrayOfInt);
      i3 = Math.max(k, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
      m = View.combineMeasuredStates(i1, this.mLogoView.getMeasuredState());
    }
    int i4 = getChildCount();
    i1 = 0;
    n = i3;
    i3 = i1;
    while (i3 < i4)
    {
      View localView = getChildAt(i3);
      i2 = n;
      k = m;
      i1 = j;
      if (((LayoutParams)localView.getLayoutParams()).mViewType == 0) {
        if (!shouldLayout(localView))
        {
          i2 = n;
          k = m;
          i1 = j;
        }
        else
        {
          i1 = j + measureChildCollapseMargins(localView, paramInt1, j, paramInt2, 0, arrayOfInt);
          i2 = Math.max(n, localView.getMeasuredHeight() + getVerticalMargins(localView));
          k = View.combineMeasuredStates(m, localView.getMeasuredState());
        }
      }
      i3++;
      n = i2;
      m = k;
      j = i1;
    }
    k = this.mTitleMarginTop + this.mTitleMarginBottom;
    i2 = this.mTitleMarginStart + this.mTitleMarginEnd;
    if (shouldLayout(this.mTitleTextView))
    {
      measureChildCollapseMargins(this.mTitleTextView, paramInt1, j + i2, paramInt2, k, arrayOfInt);
      i4 = this.mTitleTextView.getMeasuredWidth();
      i3 = getHorizontalMargins(this.mTitleTextView);
      int i5 = this.mTitleTextView.getMeasuredHeight();
      i1 = getVerticalMargins(this.mTitleTextView);
      m = View.combineMeasuredStates(m, this.mTitleTextView.getMeasuredState());
      i1 = i5 + i1;
      i3 = i4 + i3;
    }
    else
    {
      i3 = 0;
      i1 = 0;
    }
    if (shouldLayout(this.mSubtitleTextView))
    {
      i3 = Math.max(i3, measureChildCollapseMargins(this.mSubtitleTextView, paramInt1, j + i2, paramInt2, i1 + k, arrayOfInt));
      i1 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
      m = View.combineMeasuredStates(m, this.mSubtitleTextView.getMeasuredState());
    }
    n = Math.max(n, i1);
    i2 = getPaddingLeft();
    i4 = getPaddingRight();
    i1 = getPaddingTop();
    k = getPaddingBottom();
    i3 = View.resolveSizeAndState(Math.max(j + i3 + (i2 + i4), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & m);
    paramInt1 = View.resolveSizeAndState(Math.max(n + (i1 + k), getSuggestedMinimumHeight()), paramInt2, m << 16);
    if (shouldCollapse()) {
      paramInt1 = i;
    }
    setMeasuredDimension(i3, paramInt1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    paramParcelable = this.mMenuView;
    if (paramParcelable != null) {
      paramParcelable = paramParcelable.peekMenu();
    } else {
      paramParcelable = null;
    }
    int i = localSavedState.expandedMenuItemId;
    if ((i != 0) && (this.mExpandedMenuPresenter != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(i);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (localSavedState.isOverflowOpen) {
      postShowOverflowMenu();
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    ensureContentInsets();
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localRtlSpacingHelper.setDirection(bool);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = this.mExpandedMenuPresenter;
    if (localObject != null)
    {
      localObject = ((ExpandedActionViewMenuPresenter)localObject).mCurrentExpandedItem;
      if (localObject != null) {
        localSavedState.expandedMenuItemId = ((MenuItemImpl)localObject).getItemId();
      }
    }
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.mEatingTouch = false;
    }
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.mEatingTouch = false;
    }
    return true;
  }
  
  void removeChildrenForExpandedActionView()
  {
    for (int i = getChildCount() - 1; i >= 0; i--)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).mViewType != 2) && (localView != this.mMenuView))
      {
        removeViewAt(i);
        this.mHiddenViews.add(localView);
      }
    }
  }
  
  public void setCollapseContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setCollapseContentDescription(localCharSequence);
  }
  
  public void setCollapseContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureCollapseButtonView();
    }
    ImageButton localImageButton = this.mCollapseButtonView;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setCollapseIcon(@DrawableRes int paramInt)
  {
    setCollapseIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCollapseIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureCollapseButtonView();
      this.mCollapseButtonView.setImageDrawable(paramDrawable);
    }
    else
    {
      paramDrawable = this.mCollapseButtonView;
      if (paramDrawable != null) {
        paramDrawable.setImageDrawable(this.mCollapseIcon);
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setCollapsible(boolean paramBoolean)
  {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != this.mContentInsetEndWithActions)
    {
      this.mContentInsetEndWithActions = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != this.mContentInsetStartWithNavigation)
    {
      this.mContentInsetStartWithNavigation = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setAbsolute(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(@DrawableRes int paramInt)
  {
    setLogo(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (!isChildOrHidden(this.mLogoView)) {
        addSystemView(this.mLogoView, true);
      }
    }
    else
    {
      localImageView = this.mLogoView;
      if ((localImageView != null) && (isChildOrHidden(localImageView)))
      {
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
      }
    }
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(@StringRes int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureLogoView();
    }
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setMenu(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramMenuBuilder == null) && (this.mMenuView == null)) {
      return;
    }
    ensureMenuView();
    MenuBuilder localMenuBuilder = this.mMenuView.peekMenu();
    if (localMenuBuilder == paramMenuBuilder) {
      return;
    }
    if (localMenuBuilder != null)
    {
      localMenuBuilder.removeMenuPresenter(this.mOuterActionMenuPresenter);
      localMenuBuilder.removeMenuPresenter(this.mExpandedMenuPresenter);
    }
    if (this.mExpandedMenuPresenter == null) {
      this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
    }
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.addMenuPresenter(paramActionMenuPresenter, this.mPopupContext);
      paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
    else
    {
      paramActionMenuPresenter.initForMenu(this.mPopupContext, null);
      this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
    }
    this.mMenuView.setPopupTheme(this.mPopupTheme);
    this.mMenuView.setPresenter(paramActionMenuPresenter);
    this.mOuterActionMenuPresenter = paramActionMenuPresenter;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
    ActionMenuView localActionMenuView = this.mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.setMenuCallbacks(paramCallback, paramCallback1);
    }
  }
  
  public void setNavigationContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureNavButtonView();
    }
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(@DrawableRes int paramInt)
  {
    setNavigationIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (!isChildOrHidden(this.mNavButtonView)) {
        addSystemView(this.mNavButtonView, true);
      }
    }
    else
    {
      localImageButton = this.mNavButtonView;
      if ((localImageButton != null) && (isChildOrHidden(localImageButton)))
      {
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
      }
    }
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    ensureMenu();
    this.mMenuView.setOverflowIcon(paramDrawable);
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
  
  public void setSubtitle(@StringRes int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mSubtitleTextView == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        this.mSubtitleTextView = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.mSubtitleTextAppearance;
        if (i != 0) {
          this.mSubtitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = this.mSubtitleTextColor;
        if (localObject != null) {
          this.mSubtitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(this.mSubtitleTextView)) {
        addSystemView(this.mSubtitleTextView, true);
      }
    }
    else
    {
      localObject = this.mSubtitleTextView;
      if ((localObject != null) && (isChildOrHidden((View)localObject)))
      {
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
      }
    }
    Object localObject = this.mSubtitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.mSubtitleText = paramCharSequence;
  }
  
  public void setSubtitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mSubtitleTextAppearance = paramInt;
    TextView localTextView = this.mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setSubtitleTextColor(@ColorInt int paramInt)
  {
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.mSubtitleTextColor = paramColorStateList;
    TextView localTextView = this.mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(@StringRes int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mTitleTextView == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        this.mTitleTextView = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.mTitleTextAppearance;
        if (i != 0) {
          this.mTitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = this.mTitleTextColor;
        if (localObject != null) {
          this.mTitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(this.mTitleTextView)) {
        addSystemView(this.mTitleTextView, true);
      }
    }
    else
    {
      localObject = this.mTitleTextView;
      if ((localObject != null) && (isChildOrHidden((View)localObject)))
      {
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
      }
    }
    Object localObject = this.mTitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.mTitleText = paramCharSequence;
  }
  
  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTitleMarginStart = paramInt1;
    this.mTitleMarginTop = paramInt2;
    this.mTitleMarginEnd = paramInt3;
    this.mTitleMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.mTitleMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.mTitleMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.mTitleMarginStart = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.mTitleMarginTop = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mTitleTextAppearance = paramInt;
    TextView localTextView = this.mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTitleTextColor(@ColorInt int paramInt)
  {
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.mTitleTextColor = paramColorStateList;
    TextView localTextView = this.mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    boolean bool;
    if ((localActionMenuView != null) && (localActionMenuView.showOverflowMenu())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private class ExpandedActionViewMenuPresenter
    implements MenuPresenter
  {
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    
    ExpandedActionViewMenuPresenter() {}
    
    public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      paramMenuBuilder = Toolbar.this.mExpandedActionView;
      if ((paramMenuBuilder instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)paramMenuBuilder).onActionViewCollapsed();
      }
      paramMenuBuilder = Toolbar.this;
      paramMenuBuilder.removeView(paramMenuBuilder.mExpandedActionView);
      paramMenuBuilder = Toolbar.this;
      paramMenuBuilder.removeView(paramMenuBuilder.mCollapseButtonView);
      paramMenuBuilder = Toolbar.this;
      paramMenuBuilder.mExpandedActionView = null;
      paramMenuBuilder.addChildrenForExpandedActionView();
      this.mCurrentExpandedItem = null;
      Toolbar.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(false);
      return true;
    }
    
    public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      Toolbar.this.ensureCollapseButtonView();
      Object localObject = Toolbar.this.mCollapseButtonView.getParent();
      paramMenuBuilder = Toolbar.this;
      if (localObject != paramMenuBuilder)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(paramMenuBuilder.mCollapseButtonView);
        }
        paramMenuBuilder = Toolbar.this;
        paramMenuBuilder.addView(paramMenuBuilder.mCollapseButtonView);
      }
      Toolbar.this.mExpandedActionView = paramMenuItemImpl.getActionView();
      this.mCurrentExpandedItem = paramMenuItemImpl;
      paramMenuBuilder = Toolbar.this.mExpandedActionView.getParent();
      localObject = Toolbar.this;
      if (paramMenuBuilder != localObject)
      {
        if ((paramMenuBuilder instanceof ViewGroup)) {
          ((ViewGroup)paramMenuBuilder).removeView(((Toolbar)localObject).mExpandedActionView);
        }
        paramMenuBuilder = Toolbar.this.generateDefaultLayoutParams();
        localObject = Toolbar.this;
        paramMenuBuilder.gravity = (0x800003 | ((Toolbar)localObject).mButtonGravity & 0x70);
        paramMenuBuilder.mViewType = 2;
        ((Toolbar)localObject).mExpandedActionView.setLayoutParams(paramMenuBuilder);
        paramMenuBuilder = Toolbar.this;
        paramMenuBuilder.addView(paramMenuBuilder.mExpandedActionView);
      }
      Toolbar.this.removeChildrenForExpandedActionView();
      Toolbar.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(true);
      paramMenuBuilder = Toolbar.this.mExpandedActionView;
      if ((paramMenuBuilder instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)paramMenuBuilder).onActionViewExpanded();
      }
      return true;
    }
    
    public boolean flagActionItems()
    {
      return false;
    }
    
    public int getId()
    {
      return 0;
    }
    
    public MenuView getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
    {
      paramContext = this.mMenu;
      if (paramContext != null)
      {
        MenuItemImpl localMenuItemImpl = this.mCurrentExpandedItem;
        if (localMenuItemImpl != null) {
          paramContext.collapseItemActionView(localMenuItemImpl);
        }
      }
      this.mMenu = paramMenuBuilder;
    }
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
    {
      return false;
    }
    
    public void setCallback(MenuPresenter.Callback paramCallback) {}
    
    public void updateMenuView(boolean paramBoolean)
    {
      if (this.mCurrentExpandedItem != null)
      {
        MenuBuilder localMenuBuilder = this.mMenu;
        int i = 0;
        int j = i;
        if (localMenuBuilder != null)
        {
          int k = localMenuBuilder.size();
          for (int m = 0;; m++)
          {
            j = i;
            if (m >= k) {
              break;
            }
            if (this.mMenu.getItem(m) == this.mCurrentExpandedItem)
            {
              j = 1;
              break;
            }
          }
        }
        if (j == 0) {
          collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
      }
    }
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    static final int CUSTOM = 0;
    static final int EXPANDED = 2;
    static final int SYSTEM = 1;
    int mViewType = 0;
    
    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }
    
    public LayoutParams(@NonNull Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      copyMarginsFromCompat(paramMarginLayoutParams);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.mViewType = paramLayoutParams.mViewType;
    }
    
    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, null);
      }
      
      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public Toolbar.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Toolbar.SavedState[paramAnonymousInt];
      }
    };
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    public SavedState(Parcel paramParcel)
    {
      this(paramParcel, null);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.expandedMenuItemId = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isOverflowOpen = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.expandedMenuItemId);
      paramParcel.writeInt(this.isOverflowOpen);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */