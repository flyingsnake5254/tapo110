package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.integer;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout
  extends LinearLayout
  implements CoordinatorLayout.AttachedBehavior
{
  private static final int DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
  private static final int INVALID_SCROLL_RANGE = -1;
  static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
  static final int PENDING_ACTION_COLLAPSED = 2;
  static final int PENDING_ACTION_EXPANDED = 1;
  static final int PENDING_ACTION_FORCE = 8;
  static final int PENDING_ACTION_NONE = 0;
  private int currentOffset;
  private int downPreScrollRange = -1;
  private int downScrollRange = -1;
  @Nullable
  private ValueAnimator elevationOverlayAnimator;
  private boolean haveChildWithInterpolator;
  @Nullable
  private WindowInsetsCompat lastInsets;
  private boolean liftOnScroll;
  @Nullable
  private WeakReference<View> liftOnScrollTargetView;
  @IdRes
  private int liftOnScrollTargetViewId;
  private boolean liftable;
  private boolean liftableOverride;
  private boolean lifted;
  private List<BaseOnOffsetChangedListener> listeners;
  private int pendingAction = 0;
  @Nullable
  private Drawable statusBarForeground;
  private int[] tmpStatesArray;
  private int totalScrollRange = -1;
  
  public AppBarLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.appBarLayoutStyle);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    int j = Build.VERSION.SDK_INT;
    if (j >= 21)
    {
      ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
      ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, paramAttributeSet, paramInt, i);
    }
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.AppBarLayout, paramInt, i, new int[0]);
    ViewCompat.setBackground(this, localTypedArray.getDrawable(R.styleable.AppBarLayout_android_background));
    if ((getBackground() instanceof ColorDrawable))
    {
      ColorDrawable localColorDrawable = (ColorDrawable)getBackground();
      paramAttributeSet = new MaterialShapeDrawable();
      paramAttributeSet.setFillColor(ColorStateList.valueOf(localColorDrawable.getColor()));
      paramAttributeSet.initializeElevationOverlay(paramContext);
      ViewCompat.setBackground(this, paramAttributeSet);
    }
    paramInt = R.styleable.AppBarLayout_expanded;
    if (localTypedArray.hasValue(paramInt)) {
      setExpanded(localTypedArray.getBoolean(paramInt, false), false, false);
    }
    if (j >= 21)
    {
      paramInt = R.styleable.AppBarLayout_elevation;
      if (localTypedArray.hasValue(paramInt)) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, localTypedArray.getDimensionPixelSize(paramInt, 0));
      }
    }
    if (j >= 26)
    {
      paramInt = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
      if (localTypedArray.hasValue(paramInt)) {
        setKeyboardNavigationCluster(localTypedArray.getBoolean(paramInt, false));
      }
      paramInt = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
      if (localTypedArray.hasValue(paramInt)) {
        setTouchscreenBlocksFocus(localTypedArray.getBoolean(paramInt, false));
      }
    }
    this.liftOnScroll = localTypedArray.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
    this.liftOnScrollTargetViewId = localTypedArray.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
    setStatusBarForeground(localTypedArray.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
    localTypedArray.recycle();
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return AppBarLayout.this.onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }
  
  private void clearLiftOnScrollTargetView()
  {
    WeakReference localWeakReference = this.liftOnScrollTargetView;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.liftOnScrollTargetView = null;
  }
  
  @Nullable
  private View findLiftOnScrollTargetView(@Nullable View paramView)
  {
    Object localObject1 = this.liftOnScrollTargetView;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      int i = this.liftOnScrollTargetViewId;
      if (i != -1)
      {
        if (paramView != null) {
          paramView = paramView.findViewById(i);
        } else {
          paramView = null;
        }
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((getParent() instanceof ViewGroup)) {
            localObject1 = ((ViewGroup)getParent()).findViewById(this.liftOnScrollTargetViewId);
          }
        }
        if (localObject1 != null) {
          this.liftOnScrollTargetView = new WeakReference(localObject1);
        }
      }
    }
    localObject1 = this.liftOnScrollTargetView;
    paramView = (View)localObject2;
    if (localObject1 != null) {
      paramView = (View)((WeakReference)localObject1).get();
    }
    return paramView;
  }
  
  private boolean hasCollapsibleChild()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++) {
      if (((LayoutParams)getChildAt(j).getLayoutParams()).isCollapsible()) {
        return true;
      }
    }
    return false;
  }
  
  private void invalidateScrollRanges()
  {
    this.totalScrollRange = -1;
    this.downPreScrollRange = -1;
    this.downScrollRange = -1;
  }
  
  private void setExpanded(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    int j = 0;
    int k;
    if (paramBoolean2) {
      k = 4;
    } else {
      k = 0;
    }
    if (paramBoolean3) {
      j = 8;
    }
    this.pendingAction = (i | k | j);
    requestLayout();
  }
  
  private boolean setLiftableState(boolean paramBoolean)
  {
    if (this.liftable != paramBoolean)
    {
      this.liftable = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  private boolean shouldDrawStatusBarForeground()
  {
    boolean bool;
    if ((this.statusBarForeground != null) && (getTopInset() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean shouldOffsetFirstChild()
  {
    int i = getChildCount();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i > 0)
    {
      View localView = getChildAt(0);
      bool2 = bool1;
      if (localView.getVisibility() != 8)
      {
        bool2 = bool1;
        if (!ViewCompat.getFitsSystemWindows(localView)) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private void startLiftOnScrollElevationOverlayAnimation(@NonNull final MaterialShapeDrawable paramMaterialShapeDrawable, boolean paramBoolean)
  {
    float f1 = getResources().getDimension(R.dimen.design_appbar_elevation);
    float f2;
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = this.elevationOverlayAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.elevationOverlayAnimator = localValueAnimator;
    localValueAnimator.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
    this.elevationOverlayAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
    this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
      {
        paramMaterialShapeDrawable.setElevation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    this.elevationOverlayAnimator.start();
  }
  
  private void updateWillNotDraw()
  {
    setWillNotDraw(shouldDrawStatusBarForeground() ^ true);
  }
  
  public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    if ((paramBaseOnOffsetChangedListener != null) && (!this.listeners.contains(paramBaseOnOffsetChangedListener))) {
      this.listeners.add(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void addOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    addOnOffsetChangedListener(paramOnOffsetChangedListener);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (shouldDrawStatusBarForeground())
    {
      int i = paramCanvas.save();
      paramCanvas.translate(0.0F, -this.currentOffset);
      this.statusBarForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.statusBarForeground;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidateDrawable(localDrawable);
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<AppBarLayout> getBehavior()
  {
    return new Behavior();
  }
  
  int getDownNestedPreScrollRange()
  {
    int i = this.downPreScrollRange;
    if (i != -1) {
      return i;
    }
    int j = getChildCount() - 1;
    for (int k = 0; j >= 0; k = i)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int m = localView.getMeasuredHeight();
      i = localLayoutParams.scrollFlags;
      if ((i & 0x5) == 5)
      {
        int n = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((i & 0x8) != 0) {}
        for (i = ViewCompat.getMinimumHeight(localView);; i = m - ViewCompat.getMinimumHeight(localView))
        {
          i = n + i;
          break label120;
          if ((i & 0x2) == 0) {
            break;
          }
        }
        i = n + m;
        label120:
        n = i;
        if (j == 0)
        {
          n = i;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            n = Math.min(i, m - getTopInset());
          }
        }
        i = k + n;
      }
      else
      {
        i = k;
        if (k > 0) {
          break;
        }
      }
      j--;
    }
    i = Math.max(0, k);
    this.downPreScrollRange = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    int i = this.downScrollRange;
    if (i != -1) {
      return i;
    }
    int j = getChildCount();
    int k = 0;
    i = 0;
    int m;
    for (;;)
    {
      m = i;
      if (k >= j) {
        break;
      }
      View localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = localLayoutParams.topMargin;
      int i2 = localLayoutParams.bottomMargin;
      int i3 = localLayoutParams.scrollFlags;
      m = i;
      if ((i3 & 0x1) == 0) {
        break;
      }
      i += n + (i1 + i2);
      if ((i3 & 0x2) != 0)
      {
        m = i - ViewCompat.getMinimumHeight(localView);
        break;
      }
      k++;
    }
    i = Math.max(0, m);
    this.downScrollRange = i;
    return i;
  }
  
  @IdRes
  public int getLiftOnScrollTargetViewId()
  {
    return this.liftOnScrollTargetViewId;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i = getTopInset();
    int j = ViewCompat.getMinimumHeight(this);
    if (j != 0) {}
    do
    {
      return j * 2 + i;
      j = getChildCount();
      if (j >= 1) {
        j = ViewCompat.getMinimumHeight(getChildAt(j - 1));
      } else {
        j = 0;
      }
    } while (j != 0);
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.pendingAction;
  }
  
  @Nullable
  public Drawable getStatusBarForeground()
  {
    return this.statusBarForeground;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  @VisibleForTesting
  final int getTopInset()
  {
    WindowInsetsCompat localWindowInsetsCompat = this.lastInsets;
    int i;
    if (localWindowInsetsCompat != null) {
      i = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final int getTotalScrollRange()
  {
    int i = this.totalScrollRange;
    if (i != -1) {
      return i;
    }
    int j = getChildCount();
    int k = 0;
    i = 0;
    int m;
    for (;;)
    {
      m = i;
      if (k >= j) {
        break;
      }
      View localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = localLayoutParams.scrollFlags;
      m = i;
      if ((i1 & 0x1) == 0) {
        break;
      }
      m = i + (n + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      i = m;
      if (k == 0)
      {
        i = m;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          i = m - getTopInset();
        }
      }
      if ((i1 & 0x2) != 0)
      {
        m = i - ViewCompat.getMinimumHeight(localView);
        break;
      }
      k++;
    }
    i = Math.max(0, m);
    this.totalScrollRange = i;
    return i;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  boolean hasChildWithInterpolator()
  {
    return this.haveChildWithInterpolator;
  }
  
  boolean hasScrollableChildren()
  {
    boolean bool;
    if (getTotalScrollRange() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLiftOnScroll()
  {
    return this.liftOnScroll;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.setParentAbsoluteElevation(this);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.tmpStatesArray == null) {
      this.tmpStatesArray = new int[4];
    }
    int[] arrayOfInt1 = this.tmpStatesArray;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    boolean bool = this.liftable;
    paramInt = R.attr.state_liftable;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[0] = paramInt;
    if ((bool) && (this.lifted)) {
      paramInt = R.attr.state_lifted;
    } else {
      paramInt = -R.attr.state_lifted;
    }
    arrayOfInt1[1] = paramInt;
    paramInt = R.attr.state_collapsible;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[2] = paramInt;
    if ((bool) && (this.lifted)) {
      paramInt = R.attr.state_collapsed;
    } else {
      paramInt = -R.attr.state_collapsed;
    }
    arrayOfInt1[3] = paramInt;
    return LinearLayout.mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearLiftOnScrollTargetView();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramBoolean = ViewCompat.getFitsSystemWindows(this);
    boolean bool = true;
    if ((paramBoolean) && (shouldOffsetFirstChild()))
    {
      paramInt2 = getTopInset();
      for (paramInt1 = getChildCount() - 1; paramInt1 >= 0; paramInt1--) {
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2);
      }
    }
    invalidateScrollRanges();
    this.haveChildWithInterpolator = false;
    paramInt2 = getChildCount();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).getScrollInterpolator() != null)
      {
        this.haveChildWithInterpolator = true;
        break;
      }
    }
    Drawable localDrawable = this.statusBarForeground;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, getWidth(), getTopInset());
    }
    if (!this.liftableOverride)
    {
      paramBoolean = bool;
      if (!this.liftOnScroll) {
        if (hasCollapsibleChild()) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      setLiftableState(paramBoolean);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if ((i != 1073741824) && (ViewCompat.getFitsSystemWindows(this)) && (shouldOffsetFirstChild()))
    {
      paramInt1 = getMeasuredHeight();
      if (i != Integer.MIN_VALUE)
      {
        if (i == 0) {
          paramInt1 += getTopInset();
        }
      }
      else {
        paramInt1 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    invalidateScrollRanges();
  }
  
  void onOffsetChanged(int paramInt)
  {
    this.currentOffset = paramInt;
    if (!willNotDraw()) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
    Object localObject = this.listeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (BaseOnOffsetChangedListener)this.listeners.get(i);
        if (localObject != null) {
          ((BaseOnOffsetChangedListener)localObject).onOffsetChanged(this, paramInt);
        }
        i++;
      }
    }
  }
  
  WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!ObjectsCompat.equals(this.lastInsets, localWindowInsetsCompat))
    {
      this.lastInsets = localWindowInsetsCompat;
      updateWillNotDraw();
      requestLayout();
    }
    return paramWindowInsetsCompat;
  }
  
  public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    List localList = this.listeners;
    if ((localList != null) && (paramBaseOnOffsetChangedListener != null)) {
      localList.remove(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void removeOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    removeOnOffsetChangedListener(paramOnOffsetChangedListener);
  }
  
  void resetPendingAction()
  {
    this.pendingAction = 0;
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.setElevation(this, paramFloat);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    setExpanded(paramBoolean, ViewCompat.isLaidOut(this));
  }
  
  public void setExpanded(boolean paramBoolean1, boolean paramBoolean2)
  {
    setExpanded(paramBoolean1, paramBoolean2, true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.liftOnScroll = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(@IdRes int paramInt)
  {
    this.liftOnScrollTargetViewId = paramInt;
    clearLiftOnScrollTargetView();
  }
  
  public boolean setLiftable(boolean paramBoolean)
  {
    this.liftableOverride = true;
    return setLiftableState(paramBoolean);
  }
  
  public boolean setLifted(boolean paramBoolean)
  {
    return setLiftedState(paramBoolean);
  }
  
  boolean setLiftedState(boolean paramBoolean)
  {
    if (this.lifted != paramBoolean)
    {
      this.lifted = paramBoolean;
      refreshDrawableState();
      if ((this.liftOnScroll) && ((getBackground() instanceof MaterialShapeDrawable))) {
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable)getBackground(), paramBoolean);
      }
      return true;
    }
    return false;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  public void setStatusBarForeground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable1 = this.statusBarForeground;
    if (localDrawable1 != paramDrawable)
    {
      Drawable localDrawable2 = null;
      if (localDrawable1 != null) {
        localDrawable1.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable2 = paramDrawable.mutate();
      }
      this.statusBarForeground = localDrawable2;
      if (localDrawable2 != null)
      {
        if (localDrawable2.isStateful()) {
          this.statusBarForeground.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.statusBarForeground;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.statusBarForeground.setCallback(this);
      }
      updateWillNotDraw();
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarForegroundColor(@ColorInt int paramInt)
  {
    setStatusBarForeground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarForegroundResource(@DrawableRes int paramInt)
  {
    setStatusBarForeground(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, paramFloat);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.statusBarForeground;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  boolean shouldLift(@Nullable View paramView)
  {
    View localView = findLiftOnScrollTargetView(paramView);
    if (localView != null) {
      paramView = localView;
    }
    boolean bool;
    if ((paramView != null) && ((paramView.canScrollVertically(-1)) || (paramView.getScrollY() > 0))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != this.statusBarForeground)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    @Nullable
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout = -1;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private BaseDragCallback onDragCallback;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private void addAccessibilityScrollActions(final CoordinatorLayout paramCoordinatorLayout, @NonNull final T paramT, @NonNull final View paramView)
    {
      if ((getTopBottomOffsetForScrollingSibling() != -paramT.getTotalScrollRange()) && (paramView.canScrollVertically(1))) {
        addActionToExpand(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
      }
      if (getTopBottomOffsetForScrollingSibling() != 0) {
        if (paramView.canScrollVertically(-1))
        {
          final int i = -paramT.getDownNestedPreScrollRange();
          if (i != 0) {
            ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand()
            {
              public boolean perform(@NonNull View paramAnonymousView, @Nullable AccessibilityViewCommand.CommandArguments paramAnonymousCommandArguments)
              {
                AppBarLayout.BaseBehavior.this.onNestedPreScroll(paramCoordinatorLayout, paramT, paramView, 0, i, new int[] { 0, 0 }, 1);
                return true;
              }
            });
          }
        }
        else
        {
          addActionToExpand(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        }
      }
    }
    
    private void addActionToExpand(CoordinatorLayout paramCoordinatorLayout, @NonNull final T paramT, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, final boolean paramBoolean)
    {
      ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, paramAccessibilityActionCompat, null, new AccessibilityViewCommand()
      {
        public boolean perform(@NonNull View paramAnonymousView, @Nullable AccessibilityViewCommand.CommandArguments paramAnonymousCommandArguments)
        {
          paramT.setExpanded(paramBoolean);
          return true;
        }
      });
    }
    
    private void animateOffsetTo(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt, float paramFloat)
    {
      int i = Math.abs(getTopBottomOffsetForScrollingSibling() - paramInt);
      paramFloat = Math.abs(paramFloat);
      if (paramFloat > 0.0F) {
        i = Math.round(i / paramFloat * 1000.0F) * 3;
      } else {
        i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F);
      }
      animateOffsetWithDuration(paramCoordinatorLayout, paramT, paramInt, i);
    }
    
    private void animateOffsetWithDuration(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt1, int paramInt2)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if (i == paramInt1)
      {
        paramCoordinatorLayout = this.offsetAnimator;
        if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
          this.offsetAnimator.cancel();
        }
        return;
      }
      ValueAnimator localValueAnimator = this.offsetAnimator;
      if (localValueAnimator == null)
      {
        localValueAnimator = new ValueAnimator();
        this.offsetAnimator = localValueAnimator;
        localValueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
          {
            AppBarLayout.BaseBehavior.this.setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
      else
      {
        localValueAnimator.cancel();
      }
      this.offsetAnimator.setDuration(Math.min(paramInt2, 600));
      this.offsetAnimator.setIntValues(new int[] { i, paramInt1 });
      this.offsetAnimator.start();
    }
    
    private boolean canScrollChildren(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
    {
      boolean bool;
      if ((paramT.hasScrollableChildren()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private static boolean checkFlag(int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((paramInt1 & paramInt2) == paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @Nullable
    private View findFirstScrollingChild(@NonNull CoordinatorLayout paramCoordinatorLayout)
    {
      int i = paramCoordinatorLayout.getChildCount();
      int j = 0;
      while (j < i)
      {
        View localView = paramCoordinatorLayout.getChildAt(j);
        if ((!(localView instanceof NestedScrollingChild)) && (!(localView instanceof ListView)) && (!(localView instanceof ScrollView))) {
          j++;
        } else {
          return localView;
        }
      }
      return null;
    }
    
    @Nullable
    private static View getAppBarChildOnOffset(@NonNull AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      for (paramInt = 0; paramInt < j; paramInt++)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
          return localView;
        }
      }
      return null;
    }
    
    private int getChildIndexOnOffset(@NonNull T paramT, int paramInt)
    {
      int i = paramT.getChildCount();
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramT.getChildAt(j);
        int k = ((View)localObject).getTop();
        int m = ((View)localObject).getBottom();
        localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
        int n = k;
        int i1 = m;
        if (checkFlag(((AppBarLayout.LayoutParams)localObject).getScrollFlags(), 32))
        {
          n = k - ((LinearLayout.LayoutParams)localObject).topMargin;
          i1 = m + ((LinearLayout.LayoutParams)localObject).bottomMargin;
        }
        m = -paramInt;
        if ((n <= m) && (i1 >= m)) {
          return j;
        }
      }
      return -1;
    }
    
    private int interpolateOffset(@NonNull T paramT, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramT.getChildCount();
      int k = 0;
      for (int m = 0; m < j; m++)
      {
        View localView = paramT.getChildAt(m);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        Interpolator localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((i >= localView.getTop()) && (i <= localView.getBottom()))
        {
          if (localInterpolator == null) {
            break;
          }
          j = localLayoutParams.getScrollFlags();
          m = k;
          if ((j & 0x1) != 0)
          {
            k = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
            m = k;
            if ((j & 0x2) != 0) {
              m = k - ViewCompat.getMinimumHeight(localView);
            }
          }
          k = m;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            k = m - paramT.getTopInset();
          }
          if (k <= 0) {
            break;
          }
          m = localView.getTop();
          float f = k;
          m = Math.round(f * localInterpolator.getInterpolation((i - m) / f));
          return Integer.signum(paramInt) * (localView.getTop() + m);
        }
      }
      return paramInt;
    }
    
    private boolean shouldJumpElevationState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
    {
      paramCoordinatorLayout = paramCoordinatorLayout.getDependents(paramT);
      int i = paramCoordinatorLayout.size();
      boolean bool = false;
      for (int j = 0; j < i; j++)
      {
        paramT = ((CoordinatorLayout.LayoutParams)((View)paramCoordinatorLayout.get(j)).getLayoutParams()).getBehavior();
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramT).getOverlayTop() != 0) {
            bool = true;
          }
          return bool;
        }
      }
      return false;
    }
    
    private void snapToChildIfNeeded(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      int j = getChildIndexOnOffset(paramT, i);
      if (j >= 0)
      {
        View localView = paramT.getChildAt(j);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        int k = localLayoutParams.getScrollFlags();
        if ((k & 0x11) == 17)
        {
          int m = -localView.getTop();
          int n = -localView.getBottom();
          int i1 = n;
          if (j == paramT.getChildCount() - 1) {
            i1 = n + paramT.getTopInset();
          }
          if (checkFlag(k, 2))
          {
            n = i1 + ViewCompat.getMinimumHeight(localView);
            j = m;
          }
          else
          {
            j = m;
            n = i1;
            if (checkFlag(k, 5))
            {
              n = ViewCompat.getMinimumHeight(localView) + i1;
              if (i < n)
              {
                j = n;
                n = i1;
              }
              else
              {
                j = m;
              }
            }
          }
          m = j;
          i1 = n;
          if (checkFlag(k, 32))
          {
            m = j + localLayoutParams.topMargin;
            i1 = n - localLayoutParams.bottomMargin;
          }
          n = m;
          if (i < (i1 + m) / 2) {
            n = i1;
          }
          animateOffsetTo(paramCoordinatorLayout, paramT, MathUtils.clamp(n, -paramT.getTotalScrollRange(), 0), 0.0F);
        }
      }
    }
    
    private void updateAccessibilityActions(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
    {
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
      View localView = findFirstScrollingChild(paramCoordinatorLayout);
      if ((localView != null) && (paramT.getTotalScrollRange() != 0))
      {
        if (!(((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior)) {
          return;
        }
        addAccessibilityScrollActions(paramCoordinatorLayout, paramT, localView);
      }
    }
    
    private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      View localView = getAppBarChildOnOffset(paramT, paramInt1);
      if (localView != null)
      {
        int i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).getScrollFlags();
        boolean bool1 = false;
        boolean bool2 = bool1;
        if ((i & 0x1) != 0)
        {
          int j = ViewCompat.getMinimumHeight(localView);
          if ((paramInt2 > 0) && ((i & 0xC) != 0))
          {
            bool2 = bool1;
            if (-paramInt1 < localView.getBottom() - j - paramT.getTopInset()) {}
          }
          else
          {
            do
            {
              bool2 = true;
              break;
              bool2 = bool1;
              if ((i & 0x2) == 0) {
                break;
              }
              bool2 = bool1;
            } while (-paramInt1 >= localView.getBottom() - j - paramT.getTopInset());
          }
        }
        if (paramT.isLiftOnScroll()) {
          bool2 = paramT.shouldLift(findFirstScrollingChild(paramCoordinatorLayout));
        }
        bool2 = paramT.setLiftedState(bool2);
        if ((paramBoolean) || ((bool2) && (shouldJumpElevationState(paramCoordinatorLayout, paramT)))) {
          paramT.jumpDrawablesToCurrentState();
        }
      }
    }
    
    boolean canDragView(T paramT)
    {
      BaseDragCallback localBaseDragCallback = this.onDragCallback;
      if (localBaseDragCallback != null) {
        return localBaseDragCallback.canDrag(paramT);
      }
      paramT = this.lastNestedScrollingChildRef;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramT != null)
      {
        paramT = (View)paramT.get();
        if ((paramT != null) && (paramT.isShown()) && (!paramT.canScrollVertically(-1))) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      return bool2;
    }
    
    int getMaxDragOffset(@NonNull T paramT)
    {
      return -paramT.getDownNestedScrollRange();
    }
    
    int getScrollRangeForDragFling(@NonNull T paramT)
    {
      return paramT.getTotalScrollRange();
    }
    
    int getTopBottomOffsetForScrollingSibling()
    {
      return getTopAndBottomOffset() + this.offsetDelta;
    }
    
    @VisibleForTesting
    boolean isOffsetAnimatorRunning()
    {
      ValueAnimator localValueAnimator = this.offsetAnimator;
      boolean bool;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void onFlingFinished(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
    {
      snapToChildIfNeeded(paramCoordinatorLayout, paramT);
      if (paramT.isLiftOnScroll()) {
        paramT.setLiftedState(paramT.shouldLift(findFirstScrollingChild(paramCoordinatorLayout)));
      }
    }
    
    public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt)
    {
      boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      paramInt = this.offsetToChildIndexOnLayout;
      if ((paramInt >= 0) && ((i & 0x8) == 0))
      {
        View localView = paramT.getChildAt(paramInt);
        i = -localView.getBottom();
        if (this.offsetToChildIndexOnLayoutIsMinHeight) {
          paramInt = ViewCompat.getMinimumHeight(localView) + paramT.getTopInset();
        } else {
          paramInt = Math.round(localView.getHeight() * this.offsetToChildIndexOnLayoutPerc);
        }
        setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, i + paramInt);
      }
      else if (i != 0)
      {
        if ((i & 0x4) != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((i & 0x2) != 0)
        {
          i = -paramT.getUpNestedPreScrollRange();
          if (paramInt != 0) {
            animateOffsetTo(paramCoordinatorLayout, paramT, i, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, i);
          }
        }
        else if ((i & 0x1) != 0)
        {
          if (paramInt != 0) {
            animateOffsetTo(paramCoordinatorLayout, paramT, 0, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, 0);
          }
        }
      }
      paramT.resetPendingAction();
      this.offsetToChildIndexOnLayout = -1;
      setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -paramT.getTotalScrollRange(), 0));
      updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, getTopAndBottomOffset(), 0, true);
      paramT.onOffsetChanged(getTopAndBottomOffset());
      updateAccessibilityActions(paramCoordinatorLayout, paramT);
      return bool;
    }
    
    public boolean onMeasureChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.LayoutParams)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.onMeasureChild(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.onMeasureChild(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 < 0)
        {
          paramInt3 = -paramT.getTotalScrollRange();
          int i = paramT.getDownNestedPreScrollRange();
          paramInt1 = paramInt3;
          paramInt3 = i + paramInt3;
        }
        else
        {
          paramInt1 = -paramT.getUpNestedPreScrollRange();
          paramInt3 = 0;
        }
        if (paramInt1 != paramInt3) {
          paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramT, paramInt2, paramInt1, paramInt3);
        }
      }
      if (paramT.isLiftOnScroll()) {
        paramT.setLiftedState(paramT.shouldLift(paramView));
      }
    }
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      if (paramInt4 < 0) {
        paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
      }
      if (paramInt4 == 0) {
        updateAccessibilityActions(paramCoordinatorLayout, paramT);
      }
    }
    
    public void onRestoreInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable.getSuperState());
        this.offsetToChildIndexOnLayout = paramParcelable.firstVisibleChildIndex;
        this.offsetToChildIndexOnLayoutPerc = paramParcelable.firstVisibleChildPercentageShown;
        this.offsetToChildIndexOnLayoutIsMinHeight = paramParcelable.firstVisibleChildAtMinimumHeight;
      }
      else
      {
        super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable);
        this.offsetToChildIndexOnLayout = -1;
      }
    }
    
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
    {
      Object localObject = super.onSaveInstanceState(paramCoordinatorLayout, paramT);
      int i = getTopAndBottomOffset();
      int j = paramT.getChildCount();
      boolean bool = false;
      for (int k = 0; k < j; k++)
      {
        paramCoordinatorLayout = paramT.getChildAt(k);
        int m = paramCoordinatorLayout.getBottom() + i;
        if ((paramCoordinatorLayout.getTop() + i <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          ((SavedState)localObject).firstVisibleChildIndex = k;
          if (m == ViewCompat.getMinimumHeight(paramCoordinatorLayout) + paramT.getTopInset()) {
            bool = true;
          }
          ((SavedState)localObject).firstVisibleChildAtMinimumHeight = bool;
          ((SavedState)localObject).firstVisibleChildPercentageShown = (m / paramCoordinatorLayout.getHeight());
          return (Parcelable)localObject;
        }
      }
      return (Parcelable)localObject;
    }
    
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool;
      if (((paramInt1 & 0x2) != 0) && ((paramT.isLiftOnScroll()) || (canScrollChildren(paramCoordinatorLayout, paramT, paramView1)))) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        paramCoordinatorLayout = this.offsetAnimator;
        if (paramCoordinatorLayout != null) {
          paramCoordinatorLayout.cancel();
        }
      }
      this.lastNestedScrollingChildRef = null;
      this.lastStartedType = paramInt2;
      return bool;
    }
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt)
    {
      if ((this.lastStartedType == 0) || (paramInt == 1))
      {
        snapToChildIfNeeded(paramCoordinatorLayout, paramT);
        if (paramT.isLiftOnScroll()) {
          paramT.setLiftedState(paramT.shouldLift(paramView));
        }
      }
      this.lastNestedScrollingChildRef = new WeakReference(paramView);
    }
    
    public void setDragCallback(@Nullable BaseDragCallback paramBaseDragCallback)
    {
      this.onDragCallback = paramBaseDragCallback;
    }
    
    int setHeaderTopBottomOffset(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      int j = 0;
      if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
      {
        paramInt2 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
        paramInt1 = j;
        if (i != paramInt2)
        {
          if (paramT.hasChildWithInterpolator()) {
            paramInt1 = interpolateOffset(paramT, paramInt2);
          } else {
            paramInt1 = paramInt2;
          }
          boolean bool = setTopAndBottomOffset(paramInt1);
          paramInt3 = i - paramInt2;
          this.offsetDelta = (paramInt2 - paramInt1);
          if ((!bool) && (paramT.hasChildWithInterpolator())) {
            paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
          }
          paramT.onOffsetChanged(getTopAndBottomOffset());
          if (paramInt2 < i) {
            paramInt1 = -1;
          } else {
            paramInt1 = 1;
          }
          updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, paramInt2, paramInt1, false);
          paramInt1 = paramInt3;
        }
      }
      else
      {
        this.offsetDelta = 0;
        paramInt1 = j;
      }
      updateAccessibilityActions(paramCoordinatorLayout, paramT);
      return paramInt1;
    }
    
    public static abstract class BaseDragCallback<T extends AppBarLayout>
    {
      public abstract boolean canDrag(@NonNull T paramT);
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        @Nullable
        public AppBarLayout.BaseBehavior.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, null);
        }
        
        @NonNull
        public AppBarLayout.BaseBehavior.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        @NonNull
        public AppBarLayout.BaseBehavior.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppBarLayout.BaseBehavior.SavedState[paramAnonymousInt];
        }
      };
      boolean firstVisibleChildAtMinimumHeight;
      int firstVisibleChildIndex;
      float firstVisibleChildPercentageShown;
      
      public SavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        this.firstVisibleChildIndex = paramParcel.readInt();
        this.firstVisibleChildPercentageShown = paramParcel.readFloat();
        boolean bool;
        if (paramParcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.firstVisibleChildAtMinimumHeight = bool;
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.firstVisibleChildIndex);
        paramParcel.writeFloat(this.firstVisibleChildPercentageShown);
        paramParcel.writeByte((byte)this.firstVisibleChildAtMinimumHeight);
      }
    }
  }
  
  public static abstract interface BaseOnOffsetChangedListener<T extends AppBarLayout>
  {
    public abstract void onOffsetChanged(T paramT, int paramInt);
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public static abstract class DragCallback
      extends AppBarLayout.BaseBehavior.BaseDragCallback<AppBarLayout>
    {}
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    static final int COLLAPSIBLE_FLAGS = 10;
    static final int FLAG_QUICK_RETURN = 5;
    static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_NO_SCROLL = 0;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    int scrollFlags = 1;
    Interpolator scrollInterpolator;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2, paramFloat);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_Layout);
      this.scrollFlags = paramAttributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      int i = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
      if (paramAttributeSet.hasValue(i)) {
        this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(i, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    @RequiresApi(19)
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    @RequiresApi(19)
    public LayoutParams(@NonNull LayoutParams paramLayoutParams)
    {
      super();
      this.scrollFlags = paramLayoutParams.scrollFlags;
      this.scrollInterpolator = paramLayoutParams.scrollInterpolator;
    }
    
    public int getScrollFlags()
    {
      return this.scrollFlags;
    }
    
    public Interpolator getScrollInterpolator()
    {
      return this.scrollInterpolator;
    }
    
    boolean isCollapsible()
    {
      int i = this.scrollFlags;
      boolean bool = true;
      if (((i & 0x1) != 1) || ((i & 0xA) == 0)) {
        bool = false;
      }
      return bool;
    }
    
    public void setScrollFlags(int paramInt)
    {
      this.scrollFlags = paramInt;
    }
    
    public void setScrollInterpolator(Interpolator paramInterpolator)
    {
      this.scrollInterpolator = paramInterpolator;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static @interface ScrollFlags {}
  }
  
  public static abstract interface OnOffsetChangedListener
    extends AppBarLayout.BaseOnOffsetChangedListener<AppBarLayout>
  {
    public abstract void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt);
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      setOverlayTop(paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      paramContext.recycle();
    }
    
    private static int getAppBarLayoutOffset(@NonNull AppBarLayout paramAppBarLayout)
    {
      paramAppBarLayout = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
      if ((paramAppBarLayout instanceof AppBarLayout.BaseBehavior)) {
        return ((AppBarLayout.BaseBehavior)paramAppBarLayout).getTopBottomOffsetForScrollingSibling();
      }
      return 0;
    }
    
    private void offsetChildAsNeeded(@NonNull View paramView1, @NonNull View paramView2)
    {
      Object localObject = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
      if ((localObject instanceof AppBarLayout.BaseBehavior))
      {
        localObject = (AppBarLayout.BaseBehavior)localObject;
        ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + ((AppBarLayout.BaseBehavior)localObject).offsetDelta + getVerticalLayoutGap() - getOverlapPixelsForOffset(paramView2));
      }
    }
    
    private void updateLiftedStateIfNeeded(View paramView1, View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        paramView2 = (AppBarLayout)paramView2;
        if (paramView2.isLiftOnScroll()) {
          paramView2.setLiftedState(paramView2.shouldLift(paramView1));
        }
      }
    }
    
    @Nullable
    AppBarLayout findFirstDependency(@NonNull List<View> paramList)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)paramList.get(j);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
      }
      return null;
    }
    
    float getOverlapRatioForOffset(View paramView)
    {
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int i = paramView.getTotalScrollRange();
        int j = paramView.getDownNestedPreScrollRange();
        int k = getAppBarLayoutOffset(paramView);
        if ((j != 0) && (i + k <= j)) {
          return 0.0F;
        }
        i -= j;
        if (i != 0) {
          return k / i + 1.0F;
        }
      }
      return 0.0F;
    }
    
    int getScrollRange(View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.getScrollRange(paramView);
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
    {
      offsetChildAsNeeded(paramView1, paramView2);
      updateLiftedStateIfNeeded(paramView1, paramView2);
      return false;
    }
    
    public void onDependentViewRemoved(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
      }
    }
    
    public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.tempRect1;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          localAppBarLayout.setExpanded(false, paramBoolean ^ true);
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\appbar\AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */