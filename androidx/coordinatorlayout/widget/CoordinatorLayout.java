package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R.attr;
import androidx.coordinatorlayout.R.style;
import androidx.coordinatorlayout.R.styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements NestedScrollingParent2, NestedScrollingParent3
{
  static final Class<?>[] CONSTRUCTOR_PARAMS = { Context.class, AttributeSet.class };
  static final int EVENT_NESTED_SCROLL = 1;
  static final int EVENT_PRE_DRAW = 0;
  static final int EVENT_VIEW_REMOVED = 2;
  static final String TAG = "CoordinatorLayout";
  static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
  private static final int TYPE_ON_INTERCEPT = 0;
  private static final int TYPE_ON_TOUCH = 1;
  static final String WIDGET_PACKAGE_NAME;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal();
  private static final Pools.Pool<Rect> sRectPool = new Pools.SynchronizedPool(12);
  private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
  private final int[] mBehaviorConsumed = new int[2];
  private View mBehaviorTouchView;
  private final DirectedAcyclicGraph<View> mChildDag = new DirectedAcyclicGraph();
  private final List<View> mDependencySortedChildren = new ArrayList();
  private boolean mDisallowInterceptReset;
  private boolean mDrawStatusBarBackground;
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private WindowInsetsCompat mLastInsets;
  private boolean mNeedsPreDrawListener;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private View mNestedScrollingTarget;
  private final int[] mNestedScrollingV2ConsumedCompat = new int[2];
  ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
  private OnPreDrawListener mOnPreDrawListener;
  private Paint mScrimPaint;
  private Drawable mStatusBarBackground;
  private final List<View> mTempDependenciesList = new ArrayList();
  private final List<View> mTempList1 = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    WIDGET_PACKAGE_NAME = (String)localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
    } else {
      TOP_SORTED_CHILDREN_COMPARATOR = null;
    }
  }
  
  public CoordinatorLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = 0;
    TypedArray localTypedArray;
    if (paramInt == 0) {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    } else {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, 0);
    }
    if (Build.VERSION.SDK_INT >= 29) {
      if (paramInt == 0) {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, localTypedArray, 0, R.style.Widget_Support_CoordinatorLayout);
      } else {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, localTypedArray, paramInt, 0);
      }
    }
    paramInt = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      this.mKeylines = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.mKeylines.length;
      for (paramInt = i; paramInt < j; paramInt++)
      {
        paramContext = this.mKeylines;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
      }
    }
    this.mStatusBarBackground = localTypedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    localTypedArray.recycle();
    setupForInsets();
    super.setOnHierarchyChangeListener(new HierarchyChangeListener());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  @NonNull
  private static Rect acquireTempRect()
  {
    Rect localRect1 = (Rect)sRectPool.acquire();
    Rect localRect2 = localRect1;
    if (localRect1 == null) {
      localRect2 = new Rect();
    }
    return localRect2;
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private void constrainChildRect(LayoutParams paramLayoutParams, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getWidth();
    int j = getHeight();
    i = Math.max(getPaddingLeft() + paramLayoutParams.leftMargin, Math.min(paramRect.left, i - getPaddingRight() - paramInt1 - paramLayoutParams.rightMargin));
    j = Math.max(getPaddingTop() + paramLayoutParams.topMargin, Math.min(paramRect.top, j - getPaddingBottom() - paramInt2 - paramLayoutParams.bottomMargin));
    paramRect.set(i, j, paramInt1 + i, paramInt2 + j);
  }
  
  private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat.isConsumed()) {
      return paramWindowInsetsCompat;
    }
    int i = 0;
    int j = getChildCount();
    WindowInsetsCompat localWindowInsetsCompat;
    for (;;)
    {
      localWindowInsetsCompat = paramWindowInsetsCompat;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      localWindowInsetsCompat = paramWindowInsetsCompat;
      if (ViewCompat.getFitsSystemWindows(localView))
      {
        Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
        localWindowInsetsCompat = paramWindowInsetsCompat;
        if (localBehavior != null)
        {
          paramWindowInsetsCompat = localBehavior.onApplyWindowInsets(this, localView, paramWindowInsetsCompat);
          localWindowInsetsCompat = paramWindowInsetsCompat;
          if (paramWindowInsetsCompat.isConsumed())
          {
            localWindowInsetsCompat = paramWindowInsetsCompat;
            break;
          }
        }
      }
      i++;
      paramWindowInsetsCompat = localWindowInsetsCompat;
    }
    return localWindowInsetsCompat;
  }
  
  private void getDesiredAnchoredChildRectWithoutConstraints(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, LayoutParams paramLayoutParams, int paramInt2, int paramInt3)
  {
    int i = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(paramLayoutParams.gravity), paramInt1);
    int j = GravityCompat.getAbsoluteGravity(resolveGravity(paramLayoutParams.anchorGravity), paramInt1);
    int k = i & 0x7;
    int m = i & 0x70;
    paramInt1 = j & 0x7;
    j &= 0x70;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 5) {
        paramInt1 = paramRect1.left;
      } else {
        paramInt1 = paramRect1.right;
      }
    }
    else {
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    }
    if (j != 16)
    {
      if (j != 80) {
        j = paramRect1.top;
      } else {
        j = paramRect1.bottom;
      }
    }
    else {
      j = paramRect1.top + paramRect1.height() / 2;
    }
    if (k != 1)
    {
      i = paramInt1;
      if (k != 5) {
        i = paramInt1 - paramInt2;
      }
    }
    else
    {
      i = paramInt1 - paramInt2 / 2;
    }
    if (m != 16)
    {
      paramInt1 = j;
      if (m != 80) {
        paramInt1 = j - paramInt3;
      }
    }
    else
    {
      paramInt1 = j - paramInt3 / 2;
    }
    paramRect2.set(i, paramInt1, paramInt2 + i, paramInt3 + paramInt1);
  }
  
  private int getKeyline(int paramInt)
  {
    Object localObject = this.mKeylines;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      return localObject[paramInt];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Keyline index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of range for ");
    ((StringBuilder)localObject).append(this);
    Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  private void getTopSortedChildren(List<View> paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int i = getChildCount();
    for (int j = i - 1; j >= 0; j--)
    {
      int k;
      if (bool) {
        k = getChildDrawingOrder(i, j);
      } else {
        k = j;
      }
      paramList.add(getChildAt(k));
    }
    Comparator localComparator = TOP_SORTED_CHILDREN_COMPARATOR;
    if (localComparator != null) {
      Collections.sort(paramList, localComparator);
    }
  }
  
  private boolean hasDependencies(View paramView)
  {
    return this.mChildDag.hasOutgoingEdges(paramView);
  }
  
  private void layoutChild(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect1 = acquireTempRect();
    localRect1.set(getPaddingLeft() + localLayoutParams.leftMargin, getPaddingTop() + localLayoutParams.topMargin, getWidth() - getPaddingRight() - localLayoutParams.rightMargin, getHeight() - getPaddingBottom() - localLayoutParams.bottomMargin);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)) && (!ViewCompat.getFitsSystemWindows(paramView)))
    {
      localRect1.left += this.mLastInsets.getSystemWindowInsetLeft();
      localRect1.top += this.mLastInsets.getSystemWindowInsetTop();
      localRect1.right -= this.mLastInsets.getSystemWindowInsetRight();
      localRect1.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
    }
    Rect localRect2 = acquireTempRect();
    GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
  }
  
  private void layoutChildWithAnchor(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    try
    {
      getDescendantRect(paramView2, localRect1);
      getDesiredAnchoredChildRect(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      releaseTempRect(localRect1);
      releaseTempRect(localRect2);
    }
  }
  
  private void layoutChildWithKeyline(View paramView, int paramInt1, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), paramInt2);
    int j = i & 0x7;
    int k = i & 0x70;
    int m = getWidth();
    int n = getHeight();
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    i = paramInt1;
    if (paramInt2 == 1) {
      i = m - paramInt1;
    }
    paramInt1 = getKeyline(i) - i1;
    paramInt2 = 0;
    if (j != 1)
    {
      if (j == 5) {
        paramInt1 += i1;
      }
    }
    else {
      paramInt1 += i1 / 2;
    }
    if (k != 16)
    {
      if (k == 80) {
        paramInt2 = i2 + 0;
      }
    }
    else {
      paramInt2 = 0 + i2 / 2;
    }
    paramInt1 = Math.max(getPaddingLeft() + localLayoutParams.leftMargin, Math.min(paramInt1, m - getPaddingRight() - i1 - localLayoutParams.rightMargin));
    paramInt2 = Math.max(getPaddingTop() + localLayoutParams.topMargin, Math.min(paramInt2, n - getPaddingBottom() - i2 - localLayoutParams.bottomMargin));
    paramView.layout(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
  }
  
  private void offsetChildByInset(View paramView, Rect paramRect, int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView)) {
      return;
    }
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      Behavior localBehavior = localLayoutParams.getBehavior();
      Rect localRect1 = acquireTempRect();
      Rect localRect2 = acquireTempRect();
      localRect2.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      if ((localBehavior != null) && (localBehavior.getInsetDodgeRect(this, paramView, localRect1)))
      {
        if (!localRect2.contains(localRect1))
        {
          paramView = new StringBuilder();
          paramView.append("Rect should be within the child's bounds. Rect:");
          paramView.append(localRect1.toShortString());
          paramView.append(" | Bounds:");
          paramView.append(localRect2.toShortString());
          throw new IllegalArgumentException(paramView.toString());
        }
      }
      else {
        localRect1.set(localRect2);
      }
      releaseTempRect(localRect2);
      if (localRect1.isEmpty())
      {
        releaseTempRect(localRect1);
        return;
      }
      int i = GravityCompat.getAbsoluteGravity(localLayoutParams.dodgeInsetEdges, paramInt);
      int j = 1;
      if ((i & 0x30) == 48)
      {
        k = localRect1.top - localLayoutParams.topMargin - localLayoutParams.mInsetOffsetY;
        paramInt = paramRect.top;
        if (k < paramInt)
        {
          setInsetOffsetY(paramView, paramInt - k);
          paramInt = 1;
          break label254;
        }
      }
      paramInt = 0;
      label254:
      int k = paramInt;
      if ((i & 0x50) == 80)
      {
        int m = getHeight() - localRect1.bottom - localLayoutParams.bottomMargin + localLayoutParams.mInsetOffsetY;
        int n = paramRect.bottom;
        k = paramInt;
        if (m < n)
        {
          setInsetOffsetY(paramView, m - n);
          k = 1;
        }
      }
      if (k == 0) {
        setInsetOffsetY(paramView, 0);
      }
      if ((i & 0x3) == 3)
      {
        k = localRect1.left - localLayoutParams.leftMargin - localLayoutParams.mInsetOffsetX;
        paramInt = paramRect.left;
        if (k < paramInt)
        {
          setInsetOffsetX(paramView, paramInt - k);
          paramInt = 1;
          break label385;
        }
      }
      paramInt = 0;
      label385:
      if ((i & 0x5) == 5)
      {
        i = getWidth() - localRect1.right - localLayoutParams.rightMargin + localLayoutParams.mInsetOffsetX;
        k = paramRect.right;
        if (i < k)
        {
          setInsetOffsetX(paramView, i - k);
          paramInt = j;
        }
      }
      if (paramInt == 0) {
        setInsetOffsetX(paramView, 0);
      }
      releaseTempRect(localRect1);
    }
  }
  
  static Behavior parseBehavior(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (paramString.startsWith("."))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramString.indexOf('.') >= 0)
    {
      localObject1 = paramString;
    }
    else
    {
      localObject2 = WIDGET_PACKAGE_NAME;
      localObject1 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    try
    {
      Object localObject3 = sConstructors;
      localObject2 = (Map)((ThreadLocal)localObject3).get();
      paramString = (String)localObject2;
      if (localObject2 == null)
      {
        paramString = new java/util/HashMap;
        paramString.<init>();
        ((ThreadLocal)localObject3).set(paramString);
      }
      localObject3 = (Constructor)paramString.get(localObject1);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = Class.forName((String)localObject1, false, paramContext.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
        ((Constructor)localObject2).setAccessible(true);
        paramString.put(localObject1, localObject2);
      }
      paramContext = (Behavior)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append("Could not inflate Behavior subclass ");
      paramAttributeSet.append((String)localObject1);
      throw new RuntimeException(paramAttributeSet.toString(), paramContext);
    }
  }
  
  private boolean performIntercept(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    List localList = this.mTempList1;
    getTopSortedChildren(localList);
    int j = localList.size();
    Object localObject1 = null;
    int k = 0;
    boolean bool1 = false;
    boolean bool2;
    int n;
    for (int m = 0;; m = n)
    {
      bool2 = bool1;
      if (k >= j) {
        break;
      }
      View localView = (View)localList.get(k);
      Object localObject2 = (LayoutParams)localView.getLayoutParams();
      Behavior localBehavior = ((LayoutParams)localObject2).getBehavior();
      boolean bool3;
      if (((bool1) || (m != 0)) && (i != 0))
      {
        localObject2 = localObject1;
        bool3 = bool1;
        n = m;
        if (localBehavior != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          }
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              bool3 = bool1;
              n = m;
            }
            else
            {
              localBehavior.onTouchEvent(this, localView, (MotionEvent)localObject2);
              bool3 = bool1;
              n = m;
            }
          }
          else
          {
            localBehavior.onInterceptTouchEvent(this, localView, (MotionEvent)localObject2);
            bool3 = bool1;
            n = m;
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localBehavior != null)
          {
            if (paramInt != 0)
            {
              if (paramInt == 1) {
                bool1 = localBehavior.onTouchEvent(this, localView, paramMotionEvent);
              }
            }
            else {
              bool1 = localBehavior.onInterceptTouchEvent(this, localView, paramMotionEvent);
            }
            bool2 = bool1;
            if (bool1)
            {
              this.mBehaviorTouchView = localView;
              bool2 = bool1;
            }
          }
        }
        bool3 = ((LayoutParams)localObject2).didBlockInteraction();
        bool1 = ((LayoutParams)localObject2).isBlockingInteractionBelow(this, localView);
        if ((bool1) && (!bool3)) {
          m = 1;
        } else {
          m = 0;
        }
        localObject2 = localObject1;
        bool3 = bool2;
        n = m;
        if (bool1)
        {
          localObject2 = localObject1;
          bool3 = bool2;
          n = m;
          if (m == 0) {
            break;
          }
        }
      }
      k++;
      localObject1 = localObject2;
      bool1 = bool3;
    }
    localList.clear();
    return bool2;
  }
  
  private void prepareChildren()
  {
    this.mDependencySortedChildren.clear();
    this.mChildDag.clear();
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView1 = getChildAt(j);
      LayoutParams localLayoutParams = getResolvedLayoutParams(localView1);
      localLayoutParams.findAnchorView(this, localView1);
      this.mChildDag.addNode(localView1);
      for (int k = 0; k < i; k++) {
        if (k != j)
        {
          View localView2 = getChildAt(k);
          if (localLayoutParams.dependsOn(this, localView1, localView2))
          {
            if (!this.mChildDag.contains(localView2)) {
              this.mChildDag.addNode(localView2);
            }
            this.mChildDag.addEdge(localView2, localView1);
          }
        }
      }
    }
    this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
    Collections.reverse(this.mDependencySortedChildren);
  }
  
  private static void releaseTempRect(@NonNull Rect paramRect)
  {
    paramRect.setEmpty();
    sRectPool.release(paramRect);
  }
  
  private void resetTouchBehaviors(boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          localBehavior.onInterceptTouchEvent(this, localView, localMotionEvent);
        } else {
          localBehavior.onTouchEvent(this, localView, localMotionEvent);
        }
        localMotionEvent.recycle();
      }
    }
    for (j = 0; j < i; j++) {
      ((LayoutParams)getChildAt(j).getLayoutParams()).resetTouchBehaviorTracking();
    }
    this.mBehaviorTouchView = null;
    this.mDisallowInterceptReset = false;
  }
  
  private static int resolveAnchoredChildGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 17;
    }
    return i;
  }
  
  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x7) == 0) {
      i = paramInt | 0x800003;
    }
    paramInt = i;
    if ((i & 0x70) == 0) {
      paramInt = i | 0x30;
    }
    return paramInt;
  }
  
  private static int resolveKeylineGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private void setInsetOffsetX(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.mInsetOffsetX;
    if (i != paramInt)
    {
      ViewCompat.offsetLeftAndRight(paramView, paramInt - i);
      localLayoutParams.mInsetOffsetX = paramInt;
    }
  }
  
  private void setInsetOffsetY(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.mInsetOffsetY;
    if (i != paramInt)
    {
      ViewCompat.offsetTopAndBottom(paramView, paramInt - i);
      localLayoutParams.mInsetOffsetY = paramInt;
    }
  }
  
  private void setupForInsets()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (this.mApplyWindowInsetsListener == null) {
        this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener()
        {
          public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
          {
            return CoordinatorLayout.this.setWindowInsets(paramAnonymousWindowInsetsCompat);
          }
        };
      }
      ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
      setSystemUiVisibility(1280);
    }
    else
    {
      ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }
  }
  
  void addPreDrawListener()
  {
    if (this.mIsAttachedToWindow)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new OnPreDrawListener();
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void dispatchDependentViewsChanged(@NonNull View paramView)
  {
    List localList = this.mChildDag.getIncomingEdges(paramView);
    if ((localList != null) && (!localList.isEmpty())) {
      for (int i = 0; i < localList.size(); i++)
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, localView, paramView);
        }
      }
    }
  }
  
  public boolean doViewsOverlap(@NonNull View paramView1, @NonNull View paramView2)
  {
    int i = paramView1.getVisibility();
    boolean bool1 = false;
    if ((i == 0) && (paramView2.getVisibility() == 0))
    {
      Rect localRect = acquireTempRect();
      if (paramView1.getParent() != this) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      getChildRect(paramView1, bool2, localRect);
      paramView1 = acquireTempRect();
      if (paramView2.getParent() != this) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      getChildRect(paramView2, bool2, paramView1);
      boolean bool2 = bool1;
      try
      {
        if (localRect.left <= paramView1.right)
        {
          bool2 = bool1;
          if (localRect.top <= paramView1.bottom)
          {
            bool2 = bool1;
            if (localRect.right >= paramView1.left)
            {
              i = localRect.bottom;
              int j = paramView1.top;
              bool2 = bool1;
              if (i >= j) {
                bool2 = true;
              }
            }
          }
        }
        return bool2;
      }
      finally
      {
        releaseTempRect(localRect);
        releaseTempRect(paramView1);
      }
    }
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Behavior localBehavior = localLayoutParams.mBehavior;
    if (localBehavior != null)
    {
      float f = localBehavior.getScrimOpacity(this, paramView);
      if (f > 0.0F)
      {
        if (this.mScrimPaint == null) {
          this.mScrimPaint = new Paint();
        }
        this.mScrimPaint.setColor(localLayoutParams.mBehavior.getScrimColor(this, paramView));
        this.mScrimPaint.setAlpha(clamp(Math.round(f * 255.0F), 0, 255));
        int i = paramCanvas.save();
        if (paramView.isOpaque()) {
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
        }
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        paramCanvas.restoreToCount(i);
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.mStatusBarBackground;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  void ensurePreDrawListener()
  {
    int i = getChildCount();
    int j = 0;
    int m;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= i) {
        break;
      }
      if (hasDependencies(getChildAt(k)))
      {
        m = 1;
        break;
      }
    }
    if (m != this.mNeedsPreDrawListener) {
      if (m != 0) {
        addPreDrawListener();
      } else {
        removePreDrawListener();
      }
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
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  void getChildRect(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean) {
        getDescendantRect(paramView, paramRect);
      } else {
        paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      }
      return;
    }
    paramRect.setEmpty();
  }
  
  @NonNull
  public List<View> getDependencies(@NonNull View paramView)
  {
    paramView = this.mChildDag.getOutgoingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  @VisibleForTesting
  final List<View> getDependencySortedChildren()
  {
    prepareChildren();
    return Collections.unmodifiableList(this.mDependencySortedChildren);
  }
  
  @NonNull
  public List<View> getDependents(@NonNull View paramView)
  {
    paramView = this.mChildDag.getIncomingEdges(paramView);
    this.mTempDependenciesList.clear();
    if (paramView != null) {
      this.mTempDependenciesList.addAll(paramView);
    }
    return this.mTempDependenciesList;
  }
  
  void getDescendantRect(View paramView, Rect paramRect)
  {
    ViewGroupUtils.getDescendantRect(this, paramView, paramRect);
  }
  
  void getDesiredAnchoredChildRect(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, paramRect1, paramRect2, localLayoutParams, i, j);
    constrainChildRect(localLayoutParams, paramRect2, i, j);
  }
  
  void getLastChildRect(View paramView, Rect paramRect)
  {
    paramRect.set(((LayoutParams)paramView.getLayoutParams()).getLastChildRect());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final WindowInsetsCompat getLastWindowInsets()
  {
    return this.mLastInsets;
  }
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  LayoutParams getResolvedLayoutParams(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mBehaviorResolved) {
      if ((paramView instanceof AttachedBehavior))
      {
        paramView = ((AttachedBehavior)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localLayoutParams.setBehavior(paramView);
        localLayoutParams.mBehaviorResolved = true;
      }
      else
      {
        Object localObject = paramView.getClass();
        DefaultBehavior localDefaultBehavior;
        for (paramView = null; localObject != null; paramView = localDefaultBehavior)
        {
          localDefaultBehavior = (DefaultBehavior)((Class)localObject).getAnnotation(DefaultBehavior.class);
          paramView = localDefaultBehavior;
          if (localDefaultBehavior != null) {
            break;
          }
          localObject = ((Class)localObject).getSuperclass();
        }
        if (paramView != null) {
          try
          {
            localLayoutParams.setBehavior((Behavior)paramView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
          }
          catch (Exception localException)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Default behavior class ");
            ((StringBuilder)localObject).append(paramView.value().getName());
            ((StringBuilder)localObject).append(" could not be instantiated. Did you forget a default constructor?");
            Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString(), localException);
          }
        }
        localLayoutParams.mBehaviorResolved = true;
      }
    }
    return localLayoutParams;
  }
  
  @Nullable
  public Drawable getStatusBarBackground()
  {
    return this.mStatusBarBackground;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public boolean isPointInChildBounds(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = acquireTempRect();
    getDescendantRect(paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      releaseTempRect(localRect);
    }
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.mAnchorView != null)
    {
      Rect localRect1 = acquireTempRect();
      Rect localRect2 = acquireTempRect();
      Rect localRect3 = acquireTempRect();
      getDescendantRect(localLayoutParams.mAnchorView, localRect1);
      int i = 0;
      getChildRect(paramView, false, localRect2);
      int j = paramView.getMeasuredWidth();
      int k = paramView.getMeasuredHeight();
      getDesiredAnchoredChildRectWithoutConstraints(paramView, paramInt, localRect1, localRect3, localLayoutParams, j, k);
      if (localRect3.left == localRect2.left)
      {
        paramInt = i;
        if (localRect3.top == localRect2.top) {}
      }
      else
      {
        paramInt = 1;
      }
      constrainChildRect(localLayoutParams, localRect3, j, k);
      i = localRect3.left - localRect2.left;
      k = localRect3.top - localRect2.top;
      if (i != 0) {
        ViewCompat.offsetLeftAndRight(paramView, i);
      }
      if (k != 0) {
        ViewCompat.offsetTopAndBottom(paramView, k);
      }
      if (paramInt != 0)
      {
        Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, paramView, localLayoutParams.mAnchorView);
        }
      }
      releaseTempRect(localRect1);
      releaseTempRect(localRect2);
      releaseTempRect(localRect3);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    resetTouchBehaviors(false);
    if (this.mNeedsPreDrawListener)
    {
      if (this.mOnPreDrawListener == null) {
        this.mOnPreDrawListener = new OnPreDrawListener();
      }
      getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }
    if ((this.mLastInsets == null) && (ViewCompat.getFitsSystemWindows(this))) {
      ViewCompat.requestApplyInsets(this);
    }
    this.mIsAttachedToWindow = true;
  }
  
  final void onChildViewsChanged(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = this.mDependencySortedChildren.size();
    Rect localRect1 = acquireTempRect();
    Rect localRect2 = acquireTempRect();
    Rect localRect3 = acquireTempRect();
    for (int k = 0; k < j; k++)
    {
      View localView1 = (View)this.mDependencySortedChildren.get(k);
      LayoutParams localLayoutParams = (LayoutParams)localView1.getLayoutParams();
      if ((paramInt != 0) || (localView1.getVisibility() != 8))
      {
        Object localObject;
        for (int m = 0; m < k; m++)
        {
          localObject = (View)this.mDependencySortedChildren.get(m);
          if (localLayoutParams.mAnchorDirectChild == localObject) {
            offsetChildToAnchor(localView1, i);
          }
        }
        getChildRect(localView1, true, localRect2);
        if ((localLayoutParams.insetEdge != 0) && (!localRect2.isEmpty()))
        {
          m = GravityCompat.getAbsoluteGravity(localLayoutParams.insetEdge, i);
          int n = m & 0x70;
          if (n != 48)
          {
            if (n == 80) {
              localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
            }
          }
          else {
            localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          }
          m &= 0x7;
          if (m != 3)
          {
            if (m == 5) {
              localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
            }
          }
          else {
            localRect1.left = Math.max(localRect1.left, localRect2.right);
          }
        }
        if ((localLayoutParams.dodgeInsetEdges != 0) && (localView1.getVisibility() == 0)) {
          offsetChildByInset(localView1, localRect1, i);
        }
        if (paramInt != 2)
        {
          getLastChildRect(localView1, localRect3);
          if (!localRect3.equals(localRect2)) {
            recordLastChildRect(localView1, localRect2);
          }
        }
        else
        {
          for (m = k + 1; m < j; m++)
          {
            View localView2 = (View)this.mDependencySortedChildren.get(m);
            localLayoutParams = (LayoutParams)localView2.getLayoutParams();
            localObject = localLayoutParams.getBehavior();
            if ((localObject != null) && (((Behavior)localObject).layoutDependsOn(this, localView2, localView1))) {
              if ((paramInt == 0) && (localLayoutParams.getChangedAfterNestedScroll()))
              {
                localLayoutParams.resetChangedAfterNestedScroll();
              }
              else
              {
                boolean bool;
                if (paramInt != 2)
                {
                  bool = ((Behavior)localObject).onDependentViewChanged(this, localView2, localView1);
                }
                else
                {
                  ((Behavior)localObject).onDependentViewRemoved(this, localView2, localView1);
                  bool = true;
                }
                if (paramInt == 1) {
                  localLayoutParams.setChangedAfterNestedScroll(bool);
                }
              }
            }
          }
        }
      }
    }
    releaseTempRect(localRect1);
    releaseTempRect(localRect2);
    releaseTempRect(localRect3);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    resetTouchBehaviors(false);
    if ((this.mNeedsPreDrawListener) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    View localView = this.mNestedScrollingTarget;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    this.mIsAttachedToWindow = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      WindowInsetsCompat localWindowInsetsCompat = this.mLastInsets;
      int i;
      if (localWindowInsetsCompat != null) {
        i = localWindowInsetsCompat.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      resetTouchBehaviors(true);
    }
    boolean bool = performIntercept(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewCompat.getLayoutDirection(this);
    paramInt3 = this.mDependencySortedChildren.size();
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
    {
      View localView = (View)this.mDependencySortedChildren.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
        if ((localBehavior == null) || (!localBehavior.onLayoutChild(this, localView, paramInt2))) {
          onLayoutChild(localView, paramInt2);
        }
      }
    }
  }
  
  public void onLayoutChild(@NonNull View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.checkAnchorChanged())
    {
      View localView = localLayoutParams.mAnchorView;
      if (localView != null)
      {
        layoutChildWithAnchor(paramView, localView, paramInt);
      }
      else
      {
        int i = localLayoutParams.keyline;
        if (i >= 0) {
          layoutChildWithKeyline(paramView, i, paramInt);
        } else {
          layoutChild(paramView, paramInt);
        }
      }
      return;
    }
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    prepareChildren();
    ensurePreDrawListener();
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    int m = getPaddingBottom();
    int n = ViewCompat.getLayoutDirection(this);
    int i1;
    if (n == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i6 = getSuggestedMinimumWidth();
    int i7 = getSuggestedMinimumHeight();
    int i8;
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      i8 = 1;
    } else {
      i8 = 0;
    }
    int i9 = this.mDependencySortedChildren.size();
    int i10 = 0;
    int i11 = 0;
    int i13;
    for (int i12 = i;; i12 = i13)
    {
      i13 = i12;
      if (i11 >= i9) {
        break;
      }
      View localView = (View)this.mDependencySortedChildren.get(i11);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i12 = localLayoutParams.keyline;
        int i14;
        if ((i12 >= 0) && (i2 != 0))
        {
          i14 = getKeyline(i12);
          i12 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(localLayoutParams.gravity), n) & 0x7;
          if (((i12 == 3) && (i1 == 0)) || ((i12 == 5) && (i1 != 0)))
          {
            i12 = Math.max(0, i3 - k - i14);
            break label302;
          }
          if (((i12 == 5) && (i1 == 0)) || ((i12 == 3) && (i1 != 0)))
          {
            i12 = Math.max(0, i14 - i13);
            break label302;
          }
        }
        i12 = 0;
        label302:
        int i15 = i10;
        if ((i8 != 0) && (!ViewCompat.getFitsSystemWindows(localView)))
        {
          i10 = this.mLastInsets.getSystemWindowInsetLeft();
          int i16 = this.mLastInsets.getSystemWindowInsetRight();
          i14 = this.mLastInsets.getSystemWindowInsetTop();
          int i17 = this.mLastInsets.getSystemWindowInsetBottom();
          i10 = View.MeasureSpec.makeMeasureSpec(i3 - (i10 + i16), i2);
          i14 = View.MeasureSpec.makeMeasureSpec(i5 - (i14 + i17), i4);
        }
        else
        {
          i10 = paramInt1;
          i14 = paramInt2;
        }
        Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          if (localBehavior.onMeasureChild(this, localView, i10, i12, i14, 0)) {
            break label440;
          }
        }
        onMeasureChild(localView, i10, i12, i14, 0);
        label440:
        i6 = Math.max(i6, i + k + localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
        i7 = Math.max(i7, j + m + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        i10 = View.combineMeasuredStates(i15, localView.getMeasuredState());
      }
      i11++;
    }
    setMeasuredDimension(View.resolveSizeAndState(i6, paramInt1, 0xFF000000 & i10), View.resolveSizeAndState(i7, paramInt2, i10 << 16));
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool2;
    for (boolean bool1 = false; j < i; bool1 = bool2)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (LayoutParams)localView.getLayoutParams();
        if (!((LayoutParams)localObject).isNestedScrollAccepted(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((LayoutParams)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((Behavior)localObject).onNestedFling(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean);
          }
        }
      }
      j++;
    }
    if (bool1) {
      onChildViewsChanged(1);
    }
    return bool1;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool2;
    for (boolean bool1 = false; j < i; bool1 = bool2)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (LayoutParams)localView.getLayoutParams();
        if (!((LayoutParams)localObject).isNestedScrollAccepted(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((LayoutParams)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((Behavior)localObject).onNestedPreFling(this, localView, paramView, paramFloat1, paramFloat2);
          }
        }
      }
      j++;
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    int i2;
    for (int n = 0; k < i; n = i2)
    {
      Object localObject1 = getChildAt(k);
      int i1;
      if (((View)localObject1).getVisibility() == 8)
      {
        i1 = m;
        i2 = n;
      }
      else
      {
        Object localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if (!((LayoutParams)localObject2).isNestedScrollAccepted(paramInt3))
        {
          i1 = m;
          i2 = n;
        }
        else
        {
          localObject2 = ((LayoutParams)localObject2).getBehavior();
          i1 = m;
          i2 = n;
          if (localObject2 != null)
          {
            int[] arrayOfInt = this.mBehaviorConsumed;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).onNestedPreScroll(this, (View)localObject1, paramView, paramInt1, paramInt2, arrayOfInt, paramInt3);
            localObject1 = this.mBehaviorConsumed;
            if (paramInt1 > 0) {
              i2 = Math.max(m, localObject1[0]);
            } else {
              i2 = Math.min(m, localObject1[0]);
            }
            i1 = i2;
            localObject1 = this.mBehaviorConsumed;
            if (paramInt2 > 0) {
              i2 = Math.max(n, localObject1[1]);
            } else {
              i2 = Math.min(n, localObject1[1]);
            }
            j = 1;
          }
        }
      }
      k++;
      m = i1;
    }
    paramArrayOfInt[0] = m;
    paramArrayOfInt[1] = n;
    if (j != 0) {
      onChildViewsChanged(1);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, this.mNestedScrollingV2ConsumedCompat);
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    int i2;
    for (int n = 0; k < i; n = i2)
    {
      Object localObject1 = getChildAt(k);
      int i1;
      if (((View)localObject1).getVisibility() == 8)
      {
        i1 = m;
        i2 = n;
      }
      else
      {
        Object localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if (!((LayoutParams)localObject2).isNestedScrollAccepted(paramInt5))
        {
          i1 = m;
          i2 = n;
        }
        else
        {
          localObject2 = ((LayoutParams)localObject2).getBehavior();
          i1 = m;
          i2 = n;
          if (localObject2 != null)
          {
            int[] arrayOfInt = this.mBehaviorConsumed;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).onNestedScroll(this, (View)localObject1, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, arrayOfInt);
            localObject1 = this.mBehaviorConsumed;
            if (paramInt3 > 0) {
              i2 = Math.max(m, localObject1[0]);
            } else {
              i2 = Math.min(m, localObject1[0]);
            }
            i1 = i2;
            if (paramInt4 > 0) {
              i2 = Math.max(n, this.mBehaviorConsumed[1]);
            } else {
              i2 = Math.min(n, this.mBehaviorConsumed[1]);
            }
            j = 1;
          }
        }
      }
      k++;
      m = i1;
    }
    paramArrayOfInt[0] += m;
    paramArrayOfInt[1] += n;
    if (j != 0) {
      onChildViewsChanged(1);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    this.mNestedScrollingTarget = paramView2;
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      if (((LayoutParams)localObject).isNestedScrollAccepted(paramInt2))
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        if (localObject != null) {
          ((Behavior)localObject).onNestedScrollAccepted(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    paramParcelable = paramParcelable.behaviorStates;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      Behavior localBehavior = getResolvedLayoutParams(localView).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
        if (localParcelable != null) {
          localBehavior.onRestoreInstanceState(this, localView, localParcelable);
        }
      }
      i++;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      int k = localView.getId();
      Object localObject = ((LayoutParams)localView.getLayoutParams()).getBehavior();
      if ((k != -1) && (localObject != null))
      {
        localObject = ((Behavior)localObject).onSaveInstanceState(this, localView);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
    }
    localSavedState.behaviorStates = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool1 = false;
    while (j < i)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.onStartNestedScroll(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          localLayoutParams.setNestedScrollAccepted(paramInt2, bool2);
        }
        else
        {
          localLayoutParams.setNestedScrollAccepted(paramInt2, false);
        }
      }
      j++;
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt)
  {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView, paramInt);
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isNestedScrollAccepted(paramInt))
      {
        Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onStopNestedScroll(this, localView, paramView, paramInt);
        }
        localLayoutParams.resetNestedScroll(paramInt);
        localLayoutParams.resetChangedAfterNestedScroll();
      }
    }
    this.mNestedScrollingTarget = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1;
    if (this.mBehaviorTouchView == null)
    {
      bool1 = performIntercept(paramMotionEvent, 1);
      bool2 = bool1;
      if (!bool1) {
        break label76;
      }
    }
    else
    {
      bool1 = false;
    }
    Behavior localBehavior = ((LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
    boolean bool2 = bool1;
    boolean bool3;
    if (localBehavior != null)
    {
      bool3 = localBehavior.onTouchEvent(this, this.mBehaviorTouchView, paramMotionEvent);
      bool2 = bool1;
      bool1 = bool3;
    }
    else
    {
      label76:
      bool1 = false;
    }
    View localView = this.mBehaviorTouchView;
    localBehavior = null;
    if (localView == null)
    {
      bool3 = bool1 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = localBehavior;
    }
    else
    {
      bool3 = bool1;
      paramMotionEvent = localBehavior;
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        super.onTouchEvent(paramMotionEvent);
        bool3 = bool1;
      }
    }
    if (paramMotionEvent != null) {
      paramMotionEvent.recycle();
    }
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors(false);
    }
    return bool3;
  }
  
  void recordLastChildRect(View paramView, Rect paramRect)
  {
    ((LayoutParams)paramView.getLayoutParams()).setLastChildRect(paramRect);
  }
  
  void removePreDrawListener()
  {
    if ((this.mIsAttachedToWindow) && (this.mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    }
    this.mNeedsPreDrawListener = false;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    Behavior localBehavior = ((LayoutParams)paramView.getLayoutParams()).getBehavior();
    if ((localBehavior != null) && (localBehavior.onRequestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.mDisallowInterceptReset))
    {
      resetTouchBehaviors(false);
      this.mDisallowInterceptReset = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    setupForInsets();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable1 = this.mStatusBarBackground;
    if (localDrawable1 != paramDrawable)
    {
      Drawable localDrawable2 = null;
      if (localDrawable1 != null) {
        localDrawable1.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable2 = paramDrawable.mutate();
      }
      this.mStatusBarBackground = localDrawable2;
      if (localDrawable2 != null)
      {
        if (localDrawable2.isStateful()) {
          this.mStatusBarBackground.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.mStatusBarBackground;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.mStatusBarBackground.setCallback(this);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
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
    Drawable localDrawable = this.mStatusBarBackground;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.mStatusBarBackground.setVisible(bool, false);
    }
  }
  
  final WindowInsetsCompat setWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (!ObjectsCompat.equals(this.mLastInsets, paramWindowInsetsCompat))
    {
      this.mLastInsets = paramWindowInsetsCompat;
      boolean bool1 = true;
      boolean bool2;
      if ((paramWindowInsetsCompat != null) && (paramWindowInsetsCompat.getSystemWindowInsetTop() > 0)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.mDrawStatusBarBackground = bool2;
      if ((!bool2) && (getBackground() == null)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      setWillNotDraw(bool2);
      localWindowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(paramWindowInsetsCompat);
      requestLayout();
    }
    return localWindowInsetsCompat;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != this.mStatusBarBackground)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static abstract interface AttachedBehavior
  {
    @NonNull
    public abstract CoordinatorLayout.Behavior getBehavior();
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    @Nullable
    public static Object getTag(@NonNull View paramView)
    {
      return ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).mBehaviorTag;
    }
    
    public static void setTag(@NonNull View paramView, @Nullable Object paramObject)
    {
      ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).mBehaviorTag = paramObject;
    }
    
    public boolean blocksInteractionBelow(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
    {
      boolean bool;
      if (getScrimOpacity(paramCoordinatorLayout, paramV) > 0.0F) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull Rect paramRect)
    {
      return false;
    }
    
    @ColorInt
    public int getScrimColor(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
    {
      return -16777216;
    }
    
    @FloatRange(from=0.0D, to=1.0D)
    public float getScrimOpacity(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
    {
      return 0.0F;
    }
    
    public boolean layoutDependsOn(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView)
    {
      return false;
    }
    
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams) {}
    
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView)
    {
      return false;
    }
    
    public void onDependentViewRemoved(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView) {}
    
    public void onDetachedFromLayoutParams() {}
    
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
    {
      return false;
    }
    
    public boolean onMeasureChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean onNestedFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean onNestedPreFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    @Deprecated
    public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt) {}
    
    public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt3 == 0) {
        onNestedPreScroll(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    
    @Deprecated
    public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @Deprecated
    public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt5 == 0) {
        onNestedScroll(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
    {
      paramArrayOfInt[0] += paramInt3;
      paramArrayOfInt[1] += paramInt4;
      onNestedScroll(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    @Deprecated
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt) {}
    
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        onNestedScrollAccepted(paramCoordinatorLayout, paramV, paramView1, paramView2, paramInt1);
      }
    }
    
    public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull Rect paramRect, boolean paramBoolean)
    {
      return false;
    }
    
    public void onRestoreInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull Parcelable paramParcelable) {}
    
    @Nullable
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    @Deprecated
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt)
    {
      return false;
    }
    
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return onStartNestedScroll(paramCoordinatorLayout, paramV, paramView1, paramView2, paramInt1);
      }
      return false;
    }
    
    @Deprecated
    public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView) {}
    
    public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt)
    {
      if (paramInt == 0) {
        onStopNestedScroll(paramCoordinatorLayout, paramV, paramView);
      }
    }
    
    public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface DefaultBehavior
  {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface DispatchChangeEvent {}
  
  private class HierarchyChangeListener
    implements ViewGroup.OnHierarchyChangeListener
  {
    HierarchyChangeListener() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout.this.onChildViewsChanged(2);
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int anchorGravity = 0;
    public int dodgeInsetEdges = 0;
    public int gravity = 0;
    public int insetEdge = 0;
    public int keyline = -1;
    View mAnchorDirectChild;
    int mAnchorId = -1;
    View mAnchorView;
    CoordinatorLayout.Behavior mBehavior;
    boolean mBehaviorResolved = false;
    Object mBehaviorTag;
    private boolean mDidAcceptNestedScrollNonTouch;
    private boolean mDidAcceptNestedScrollTouch;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    int mInsetOffsetX;
    int mInsetOffsetY;
    final Rect mLastChildRect = new Rect();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
      this.gravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.mAnchorId = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
      this.anchorGravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.keyline = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
      this.insetEdge = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.dodgeInsetEdges = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      int i = R.styleable.CoordinatorLayout_Layout_layout_behavior;
      boolean bool = localTypedArray.hasValue(i);
      this.mBehaviorResolved = bool;
      if (bool) {
        this.mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(i));
      }
      localTypedArray.recycle();
      paramContext = this.mBehavior;
      if (paramContext != null) {
        paramContext.onAttachedToLayoutParams(this);
      }
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      View localView = paramCoordinatorLayout.findViewById(this.mAnchorId);
      this.mAnchorView = localView;
      if (localView != null)
      {
        if (localView == paramCoordinatorLayout)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
          }
          throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        }
        for (localObject = localView.getParent(); (localObject != paramCoordinatorLayout) && (localObject != null); localObject = ((ViewParent)localObject).getParent())
        {
          if (localObject == paramView)
          {
            if (paramCoordinatorLayout.isInEditMode())
            {
              this.mAnchorDirectChild = null;
              this.mAnchorView = null;
              return;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localObject instanceof View)) {
            localView = (View)localObject;
          }
        }
        this.mAnchorDirectChild = localView;
        return;
      }
      if (paramCoordinatorLayout.isInEditMode())
      {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find CoordinatorLayout descendant view with id ");
      ((StringBuilder)localObject).append(paramCoordinatorLayout.getResources().getResourceName(this.mAnchorId));
      ((StringBuilder)localObject).append(" to anchor view ");
      ((StringBuilder)localObject).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    private boolean shouldDodge(View paramView, int paramInt)
    {
      int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).insetEdge, paramInt);
      boolean bool;
      if ((i != 0) && ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, paramInt) & i) == i)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      if (this.mAnchorView.getId() != this.mAnchorId) {
        return false;
      }
      View localView = this.mAnchorView;
      ViewParent localViewParent = localView.getParent();
      while (localViewParent != paramCoordinatorLayout) {
        if ((localViewParent != null) && (localViewParent != paramView))
        {
          if ((localViewParent instanceof View)) {
            localView = (View)localViewParent;
          }
          localViewParent = localViewParent.getParent();
        }
        else
        {
          this.mAnchorDirectChild = null;
          this.mAnchorView = null;
          return false;
        }
      }
      this.mAnchorDirectChild = localView;
      return true;
    }
    
    boolean checkAnchorChanged()
    {
      boolean bool;
      if ((this.mAnchorView == null) && (this.mAnchorId != -1)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      if ((paramView2 != this.mAnchorDirectChild) && (!shouldDodge(paramView2, ViewCompat.getLayoutDirection(paramCoordinatorLayout))))
      {
        CoordinatorLayout.Behavior localBehavior = this.mBehavior;
        if ((localBehavior == null) || (!localBehavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2)))
        {
          bool = false;
          break label54;
        }
      }
      boolean bool = true;
      label54:
      return bool;
    }
    
    boolean didBlockInteraction()
    {
      if (this.mBehavior == null) {
        this.mDidBlockInteraction = false;
      }
      return this.mDidBlockInteraction;
    }
    
    View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      if (this.mAnchorId == -1)
      {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return null;
      }
      if ((this.mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
        resolveAnchorView(paramView, paramCoordinatorLayout);
      }
      return this.mAnchorView;
    }
    
    @IdRes
    public int getAnchorId()
    {
      return this.mAnchorId;
    }
    
    @Nullable
    public CoordinatorLayout.Behavior getBehavior()
    {
      return this.mBehavior;
    }
    
    boolean getChangedAfterNestedScroll()
    {
      return this.mDidChangeAfterNestedScroll;
    }
    
    Rect getLastChildRect()
    {
      return this.mLastChildRect;
    }
    
    void invalidateAnchor()
    {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
    }
    
    boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      boolean bool1 = this.mDidBlockInteraction;
      if (bool1) {
        return true;
      }
      CoordinatorLayout.Behavior localBehavior = this.mBehavior;
      boolean bool2;
      if (localBehavior != null) {
        bool2 = localBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);
      } else {
        bool2 = false;
      }
      bool2 |= bool1;
      this.mDidBlockInteraction = bool2;
      return bool2;
    }
    
    boolean isNestedScrollAccepted(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return false;
        }
        return this.mDidAcceptNestedScrollNonTouch;
      }
      return this.mDidAcceptNestedScrollTouch;
    }
    
    void resetChangedAfterNestedScroll()
    {
      this.mDidChangeAfterNestedScroll = false;
    }
    
    void resetNestedScroll(int paramInt)
    {
      setNestedScrollAccepted(paramInt, false);
    }
    
    void resetTouchBehaviorTracking()
    {
      this.mDidBlockInteraction = false;
    }
    
    public void setAnchorId(@IdRes int paramInt)
    {
      invalidateAnchor();
      this.mAnchorId = paramInt;
    }
    
    public void setBehavior(@Nullable CoordinatorLayout.Behavior paramBehavior)
    {
      CoordinatorLayout.Behavior localBehavior = this.mBehavior;
      if (localBehavior != paramBehavior)
      {
        if (localBehavior != null) {
          localBehavior.onDetachedFromLayoutParams();
        }
        this.mBehavior = paramBehavior;
        this.mBehaviorTag = null;
        this.mBehaviorResolved = true;
        if (paramBehavior != null) {
          paramBehavior.onAttachedToLayoutParams(this);
        }
      }
    }
    
    void setChangedAfterNestedScroll(boolean paramBoolean)
    {
      this.mDidChangeAfterNestedScroll = paramBoolean;
    }
    
    void setLastChildRect(Rect paramRect)
    {
      this.mLastChildRect.set(paramRect);
    }
    
    void setNestedScrollAccepted(int paramInt, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.mDidAcceptNestedScrollNonTouch = paramBoolean;
        }
      }
      else {
        this.mDidAcceptNestedScrollTouch = paramBoolean;
      }
    }
  }
  
  class OnPreDrawListener
    implements ViewTreeObserver.OnPreDrawListener
  {
    OnPreDrawListener() {}
    
    public boolean onPreDraw()
    {
      CoordinatorLayout.this.onChildViewsChanged(0);
      return true;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public CoordinatorLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new CoordinatorLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public CoordinatorLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new CoordinatorLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public CoordinatorLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new CoordinatorLayout.SavedState[paramAnonymousInt];
      }
    };
    SparseArray<Parcelable> behaviorStates;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int i = paramParcel.readInt();
      int[] arrayOfInt = new int[i];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.behaviorStates = new SparseArray(i);
      for (int j = 0; j < i; j++) {
        this.behaviorStates.append(arrayOfInt[j], paramParcel[j]);
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.behaviorStates;
      int i = 0;
      int j;
      if (localObject != null) {
        j = ((SparseArray)localObject).size();
      } else {
        j = 0;
      }
      paramParcel.writeInt(j);
      localObject = new int[j];
      Parcelable[] arrayOfParcelable = new Parcelable[j];
      while (i < j)
      {
        localObject[i] = this.behaviorStates.keyAt(i);
        arrayOfParcelable[i] = ((Parcelable)this.behaviorStates.valueAt(i));
        i++;
      }
      paramParcel.writeIntArray((int[])localObject);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
  }
  
  static class ViewElevationComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      float f1 = ViewCompat.getZ(paramView1);
      float f2 = ViewCompat.getZ(paramView2);
      if (f1 > f2) {
        return -1;
      }
      if (f1 < f2) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\coordinatorlayout\widget\CoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */