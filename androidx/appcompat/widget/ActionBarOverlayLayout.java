package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat.Builder;

@SuppressLint({"UnknownNullness"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout
  extends ViewGroup
  implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3
{
  private static final int ACTION_BAR_ANIMATE_DELAY = 600;
  static final int[] ATTRS = { R.attr.actionBarSize, 16842841 };
  private static final String TAG = "ActionBarOverlayLayout";
  private int mActionBarHeight;
  ActionBarContainer mActionBarTop;
  private ActionBarVisibilityCallback mActionBarVisibilityCallback;
  private final Runnable mAddActionBarHideOffset;
  boolean mAnimatingForFling;
  private final Rect mBaseContentInsets = new Rect();
  @NonNull
  private WindowInsetsCompat mBaseInnerInsets;
  private final Rect mBaseInnerInsetsRect = new Rect();
  private ContentFrameLayout mContent;
  private final Rect mContentInsets = new Rect();
  ViewPropertyAnimator mCurrentActionBarTopAnimator;
  private DecorToolbar mDecorToolbar;
  private OverScroller mFlingEstimator;
  private boolean mHasNonEmbeddedTabs;
  private boolean mHideOnContentScroll;
  private int mHideOnContentScrollReference;
  private boolean mIgnoreWindowContentOverlay;
  @NonNull
  private WindowInsetsCompat mInnerInsets;
  private final Rect mInnerInsetsRect = new Rect();
  private final Rect mLastBaseContentInsets = new Rect();
  @NonNull
  private WindowInsetsCompat mLastBaseInnerInsets;
  private final Rect mLastBaseInnerInsetsRect = new Rect();
  @NonNull
  private WindowInsetsCompat mLastInnerInsets;
  private final Rect mLastInnerInsetsRect = new Rect();
  private int mLastSystemUiVisibility;
  private boolean mOverlayMode;
  private final NestedScrollingParentHelper mParentHelper;
  private final Runnable mRemoveActionBarHideOffset;
  final AnimatorListenerAdapter mTopAnimatorListener;
  private Drawable mWindowContentOverlay;
  private int mWindowVisibility = 0;
  
  public ActionBarOverlayLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = WindowInsetsCompat.CONSUMED;
    this.mBaseInnerInsets = paramAttributeSet;
    this.mLastBaseInnerInsets = paramAttributeSet;
    this.mInnerInsets = paramAttributeSet;
    this.mLastInnerInsets = paramAttributeSet;
    this.mTopAnimatorListener = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = ActionBarOverlayLayout.this;
        paramAnonymousAnimator.mCurrentActionBarTopAnimator = null;
        paramAnonymousAnimator.mAnimatingForFling = false;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = ActionBarOverlayLayout.this;
        paramAnonymousAnimator.mCurrentActionBarTopAnimator = null;
        paramAnonymousAnimator.mAnimatingForFling = false;
      }
    };
    this.mRemoveActionBarHideOffset = new Runnable()
    {
      public void run()
      {
        ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
        localActionBarOverlayLayout.mCurrentActionBarTopAnimator = localActionBarOverlayLayout.mActionBarTop.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
      }
    };
    this.mAddActionBarHideOffset = new Runnable()
    {
      public void run()
      {
        ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
        localActionBarOverlayLayout.mCurrentActionBarTopAnimator = localActionBarOverlayLayout.mActionBarTop.animate().translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
      }
    };
    init(paramContext);
    this.mParentHelper = new NestedScrollingParentHelper(this);
  }
  
  private void addActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mAddActionBarHideOffset.run();
  }
  
  private boolean applyInsets(@NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = true;
    int i;
    int j;
    if (paramBoolean1)
    {
      i = paramView.leftMargin;
      j = paramRect.left;
      if (i != j)
      {
        paramView.leftMargin = j;
        bool2 = true;
        break label49;
      }
    }
    boolean bool2 = false;
    label49:
    paramBoolean1 = bool2;
    if (paramBoolean2)
    {
      j = paramView.topMargin;
      i = paramRect.top;
      paramBoolean1 = bool2;
      if (j != i)
      {
        paramView.topMargin = i;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      j = paramView.rightMargin;
      i = paramRect.right;
      paramBoolean2 = paramBoolean1;
      if (j != i)
      {
        paramView.rightMargin = i;
        paramBoolean2 = true;
      }
    }
    if (paramBoolean3)
    {
      j = paramView.bottomMargin;
      i = paramRect.bottom;
      if (j != i)
      {
        paramView.bottomMargin = i;
        paramBoolean2 = bool1;
      }
    }
    return paramBoolean2;
  }
  
  private DecorToolbar getDecorToolbar(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void init(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    boolean bool1 = false;
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    Drawable localDrawable = localTypedArray.getDrawable(1);
    this.mWindowContentOverlay = localDrawable;
    if (localDrawable == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    localTypedArray.recycle();
    boolean bool2 = bool1;
    if (paramContext.getApplicationInfo().targetSdkVersion < 19) {
      bool2 = true;
    }
    this.mIgnoreWindowContentOverlay = bool2;
    this.mFlingEstimator = new OverScroller(paramContext);
  }
  
  private void postAddActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mAddActionBarHideOffset, 600L);
  }
  
  private void postRemoveActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mRemoveActionBarHideOffset, 600L);
  }
  
  private void removeActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mRemoveActionBarHideOffset.run();
  }
  
  private boolean shouldHideActionBarOnFling(float paramFloat)
  {
    this.mFlingEstimator.fling(0, 0, 0, (int)paramFloat, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    boolean bool;
    if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean canShowOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopups()
  {
    pullChildren();
    this.mDecorToolbar.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.mWindowContentOverlay != null) && (!this.mIgnoreWindowContentOverlay))
    {
      int i;
      if (this.mActionBarTop.getVisibility() == 0) {
        i = (int)(this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5F);
      } else {
        i = 0;
      }
      this.mWindowContentOverlay.setBounds(0, i, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + i);
      this.mWindowContentOverlay.draw(paramCanvas);
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return super.fitSystemWindows(paramRect);
    }
    pullChildren();
    boolean bool = applyInsets(this.mActionBarTop, paramRect, true, true, false, true);
    this.mBaseInnerInsetsRect.set(paramRect);
    ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsetsRect, this.mBaseContentInsets);
    if (!this.mLastBaseInnerInsetsRect.equals(this.mBaseInnerInsetsRect))
    {
      this.mLastBaseInnerInsetsRect.set(this.mBaseInnerInsetsRect);
      bool = true;
    }
    if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets))
    {
      this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = this.mActionBarTop;
    int i;
    if (localActionBarContainer != null) {
      i = -(int)localActionBarContainer.getTranslationY();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mParentHelper.getNestedScrollAxes();
  }
  
  public CharSequence getTitle()
  {
    pullChildren();
    return this.mDecorToolbar.getTitle();
  }
  
  void haltActionBarHideOffsetAnimations()
  {
    removeCallbacks(this.mRemoveActionBarHideOffset);
    removeCallbacks(this.mAddActionBarHideOffset);
    ViewPropertyAnimator localViewPropertyAnimator = this.mCurrentActionBarTopAnimator;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public boolean hasIcon()
  {
    pullChildren();
    return this.mDecorToolbar.hasIcon();
  }
  
  public boolean hasLogo()
  {
    pullChildren();
    return this.mDecorToolbar.hasLogo();
  }
  
  public boolean hideOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.hideOverflowMenu();
  }
  
  public void initFeature(int paramInt)
  {
    pullChildren();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt == 109) {
          setOverlayMode(true);
        }
      }
      else {
        this.mDecorToolbar.initIndeterminateProgress();
      }
    }
    else {
      this.mDecorToolbar.initProgress();
    }
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.mHideOnContentScroll;
  }
  
  public boolean isInOverlayMode()
  {
    return this.mOverlayMode;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowing();
  }
  
  @RequiresApi(21)
  public WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    pullChildren();
    paramWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(paramWindowInsets);
    Object localObject = new Rect(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    boolean bool1 = applyInsets(this.mActionBarTop, (Rect)localObject, true, true, false, true);
    ViewCompat.computeSystemWindowInsets(this, paramWindowInsets, this.mBaseContentInsets);
    localObject = this.mBaseContentInsets;
    localObject = paramWindowInsets.inset(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
    this.mBaseInnerInsets = ((WindowInsetsCompat)localObject);
    boolean bool2 = this.mLastBaseInnerInsets.equals(localObject);
    boolean bool3 = true;
    if (!bool2)
    {
      this.mLastBaseInnerInsets = this.mBaseInnerInsets;
      bool1 = true;
    }
    if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets))
    {
      this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      bool1 = bool3;
    }
    if (bool1) {
      requestLayout();
    }
    return paramWindowInsets.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt4 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = localLayoutParams.leftMargin + paramInt4;
        int m = localLayoutParams.topMargin + paramInt3;
        localView.layout(k, m, i + k, j + m);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    pullChildren();
    measureChildWithMargins(this.mActionBarTop, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.mActionBarTop.getLayoutParams();
    int i = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
    int j = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    int k = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
    if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      n = this.mActionBarHeight;
      i1 = n;
      if (this.mHasNonEmbeddedTabs)
      {
        i1 = n;
        if (this.mActionBarTop.getTabContainer() != null) {
          i1 = n + this.mActionBarHeight;
        }
      }
    }
    else if (this.mActionBarTop.getVisibility() != 8)
    {
      i1 = this.mActionBarTop.getMeasuredHeight();
    }
    else
    {
      i1 = 0;
    }
    this.mContentInsets.set(this.mBaseContentInsets);
    int n = Build.VERSION.SDK_INT;
    if (n >= 21) {
      this.mInnerInsets = this.mBaseInnerInsets;
    } else {
      this.mInnerInsetsRect.set(this.mBaseInnerInsetsRect);
    }
    if ((!this.mOverlayMode) && (m == 0))
    {
      localObject = this.mContentInsets;
      ((Rect)localObject).top += i1;
      ((Rect)localObject).bottom += 0;
      if (n >= 21) {
        this.mInnerInsets = this.mInnerInsets.inset(0, i1, 0, 0);
      }
    }
    else if (n >= 21)
    {
      localObject = Insets.of(this.mInnerInsets.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + i1, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0);
      this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets((Insets)localObject).build();
    }
    else
    {
      localObject = this.mInnerInsetsRect;
      ((Rect)localObject).top += i1;
      ((Rect)localObject).bottom += 0;
    }
    applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
    if ((n >= 21) && (!this.mLastInnerInsets.equals(this.mInnerInsets)))
    {
      localObject = this.mInnerInsets;
      this.mLastInnerInsets = ((WindowInsetsCompat)localObject);
      ViewCompat.dispatchApplyWindowInsets(this.mContent, (WindowInsetsCompat)localObject);
    }
    else if ((n < 21) && (!this.mLastInnerInsetsRect.equals(this.mInnerInsetsRect)))
    {
      this.mLastInnerInsetsRect.set(this.mInnerInsetsRect);
      this.mContent.dispatchFitSystemWindows(this.mInnerInsetsRect);
    }
    measureChildWithMargins(this.mContent, paramInt1, 0, paramInt2, 0);
    localObject = (LayoutParams)this.mContent.getLayoutParams();
    int i1 = Math.max(i, this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
    n = Math.max(j, this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    k = View.combineMeasuredStates(k, this.mContent.getMeasuredState());
    int m = getPaddingLeft();
    j = getPaddingRight();
    n = Math.max(n + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (m + j), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(n, paramInt2, k << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((this.mHideOnContentScroll) && (paramBoolean))
    {
      if (shouldHideActionBarOnFling(paramFloat2)) {
        addActionBarHideOffset();
      } else {
        removeActionBarHideOffset();
      }
      this.mAnimatingForFling = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 0) {
      onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.mHideOnContentScrollReference + paramInt2;
    this.mHideOnContentScrollReference = paramInt1;
    setActionBarHideOffset(paramInt1);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.mParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.mHideOnContentScrollReference = getActionBarHideOffset();
    haltActionBarHideOffsetAnimations();
    paramView1 = this.mActionBarVisibilityCallback;
    if (paramView1 != null) {
      paramView1.onContentScrollStarted();
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramView1, paramView2, paramInt1);
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (this.mActionBarTop.getVisibility() == 0)) {
      return this.mHideOnContentScroll;
    }
    return false;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt2 == 0) && (onStartNestedScroll(paramView1, paramView2, paramInt1))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.mHideOnContentScroll) && (!this.mAnimatingForFling)) {
      if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
        postRemoveActionBarHideOffset();
      } else {
        postAddActionBarHideOffset();
      }
    }
    paramView = this.mActionBarVisibilityCallback;
    if (paramView != null) {
      paramView.onContentScrollStopped();
    }
  }
  
  public void onStopNestedScroll(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramView);
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    pullChildren();
    int i = this.mLastSystemUiVisibility;
    this.mLastSystemUiVisibility = paramInt;
    int j = 0;
    int k;
    if ((paramInt & 0x4) == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramInt & 0x100) != 0) {
      j = 1;
    }
    ActionBarVisibilityCallback localActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
    if (localActionBarVisibilityCallback != null)
    {
      localActionBarVisibilityCallback.enableContentAnimations(j ^ 0x1);
      if ((k == 0) && (j != 0)) {
        this.mActionBarVisibilityCallback.hideForSystem();
      } else {
        this.mActionBarVisibilityCallback.showForSystem();
      }
    }
    if ((((i ^ paramInt) & 0x100) != 0) && (this.mActionBarVisibilityCallback != null)) {
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.mWindowVisibility = paramInt;
    ActionBarVisibilityCallback localActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
    if (localActionBarVisibilityCallback != null) {
      localActionBarVisibilityCallback.onWindowVisibilityChanged(paramInt);
    }
  }
  
  void pullChildren()
  {
    if (this.mContent == null)
    {
      this.mContent = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.mActionBarTop = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
    }
  }
  
  public void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.saveHierarchyState(paramSparseArray);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    haltActionBarHideOffsetAnimations();
    paramInt = Math.max(0, Math.min(paramInt, this.mActionBarTop.getHeight()));
    this.mActionBarTop.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    this.mActionBarVisibilityCallback = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
      int i = this.mLastSystemUiVisibility;
      if (i != 0)
      {
        onWindowSystemUiVisibilityChanged(i);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.mHasNonEmbeddedTabs = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mHideOnContentScroll)
    {
      this.mHideOnContentScroll = paramBoolean;
      if (!paramBoolean)
      {
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    pullChildren();
    this.mDecorToolbar.setMenu(paramMenu, paramCallback);
  }
  
  public void setMenuPrepared()
  {
    pullChildren();
    this.mDecorToolbar.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.mOverlayMode = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.mIgnoreWindowContentOverlay = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    pullChildren();
    this.mDecorToolbar.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    pullChildren();
    this.mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.showOverflowMenu();
  }
  
  public static abstract interface ActionBarVisibilityCallback
  {
    public abstract void enableContentAnimations(boolean paramBoolean);
    
    public abstract void hideForSystem();
    
    public abstract void onContentScrollStarted();
    
    public abstract void onContentScrollStopped();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void showForSystem();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
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
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */