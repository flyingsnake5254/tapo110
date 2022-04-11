package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<ItemInfo> COMPARATOR = new Comparator()
  {
    public int compare(ViewPager.ItemInfo paramAnonymousItemInfo1, ViewPager.ItemInfo paramAnonymousItemInfo2)
    {
      return paramAnonymousItemInfo1.position - paramAnonymousItemInfo2.position;
    }
  };
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "ViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
  private int mActivePointerId = -1;
  PagerAdapter mAdapter;
  private List<OnAdapterChangeListener> mAdapterChangeListeners;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new Runnable()
  {
    public void run()
    {
      ViewPager.this.setScrollState(0);
      ViewPager.this.populate();
    }
  };
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.4028235E38F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsScrollStarted;
  private boolean mIsUnableToDrag;
  private final ArrayList<ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = Float.MAX_VALUE;
  private EdgeEffect mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private OnPageChangeListener mOnPageChangeListener;
  private List<OnPageChangeListener> mOnPageChangeListeners;
  private int mPageMargin;
  private PageTransformer mPageTransformer;
  private int mPageTransformerLayerType;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private EdgeEffect mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private final ItemInfo mTempItem = new ItemInfo();
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    int i = this.mAdapter.getCount();
    int j = getClientWidth();
    float f1;
    if (j > 0) {
      f1 = this.mPageMargin / j;
    } else {
      f1 = 0.0F;
    }
    float f3;
    if (paramItemInfo2 != null)
    {
      j = paramItemInfo2.position;
      k = paramItemInfo1.position;
      if (j < k)
      {
        f2 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f1;
        j++;
        k = 0;
        while ((j <= paramItemInfo1.position) && (k < this.mItems.size()))
        {
          for (paramItemInfo2 = (ItemInfo)this.mItems.get(k);; paramItemInfo2 = (ItemInfo)this.mItems.get(k))
          {
            m = j;
            f3 = f2;
            if (j <= paramItemInfo2.position) {
              break;
            }
            m = j;
            f3 = f2;
            if (k >= this.mItems.size() - 1) {
              break;
            }
            k++;
          }
          while (m < paramItemInfo2.position)
          {
            f3 += this.mAdapter.getPageWidth(m) + f1;
            m++;
          }
          paramItemInfo2.offset = f3;
          f2 = f3 + (paramItemInfo2.widthFactor + f1);
          j = m + 1;
        }
      }
      if (j > k)
      {
        k = this.mItems.size() - 1;
        f2 = paramItemInfo2.offset;
        j--;
        while ((j >= paramItemInfo1.position) && (k >= 0))
        {
          for (paramItemInfo2 = (ItemInfo)this.mItems.get(k);; paramItemInfo2 = (ItemInfo)this.mItems.get(k))
          {
            m = j;
            f3 = f2;
            if (j >= paramItemInfo2.position) {
              break;
            }
            m = j;
            f3 = f2;
            if (k <= 0) {
              break;
            }
            k--;
          }
          while (m > paramItemInfo2.position)
          {
            f3 -= this.mAdapter.getPageWidth(m) + f1;
            m--;
          }
          f2 = f3 - (paramItemInfo2.widthFactor + f1);
          paramItemInfo2.offset = f2;
          j = m - 1;
        }
      }
    }
    int m = this.mItems.size();
    float f2 = paramItemInfo1.offset;
    int k = paramItemInfo1.position;
    j = k - 1;
    if (k == 0) {
      f3 = f2;
    } else {
      f3 = -3.4028235E38F;
    }
    this.mFirstOffset = f3;
    i--;
    if (k == i) {
      f3 = paramItemInfo1.widthFactor + f2 - 1.0F;
    } else {
      f3 = Float.MAX_VALUE;
    }
    this.mLastOffset = f3;
    k = paramInt - 1;
    while (k >= 0)
    {
      paramItemInfo2 = (ItemInfo)this.mItems.get(k);
      int n;
      for (;;)
      {
        n = paramItemInfo2.position;
        if (j <= n) {
          break;
        }
        f2 -= this.mAdapter.getPageWidth(j) + f1;
        j--;
      }
      f2 -= paramItemInfo2.widthFactor + f1;
      paramItemInfo2.offset = f2;
      if (n == 0) {
        this.mFirstOffset = f2;
      }
      k--;
      j--;
    }
    f2 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f1;
    k = paramItemInfo1.position + 1;
    j = paramInt + 1;
    for (paramInt = k; j < m; paramInt++)
    {
      paramItemInfo1 = (ItemInfo)this.mItems.get(j);
      for (;;)
      {
        k = paramItemInfo1.position;
        if (paramInt >= k) {
          break;
        }
        f2 += this.mAdapter.getPageWidth(paramInt) + f1;
        paramInt++;
      }
      if (k == i) {
        this.mLastOffset = (paramItemInfo1.widthFactor + f2 - 1.0F);
      }
      paramItemInfo1.offset = f2;
      f2 += paramItemInfo1.widthFactor + f1;
      j++;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    int i;
    if (this.mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setScrollingCacheEnabled(false);
      if ((this.mScroller.isFinished() ^ true))
      {
        this.mScroller.abortAnimation();
        int j = getScrollX();
        int k = getScrollY();
        m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            pageScrolled(m);
          }
        }
      }
    }
    this.mPopulatePending = false;
    for (int m = 0; m < this.mItems.size(); m++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(m);
      if (localItemInfo.scrolling)
      {
        localItemInfo.scrolling = false;
        i = 1;
      }
    }
    if (i != 0) {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      } else {
        this.mEndScrollRunnable.run();
      }
    }
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 <= 0) {
        paramInt1++;
      }
    }
    else
    {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      }
      paramInt1 += (int)(paramFloat + f);
    }
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0)
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(0);
      Object localObject = this.mItems;
      localObject = (ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.position, Math.min(paramInt1, ((ItemInfo)localObject).position));
    }
    return paramInt2;
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i++;
      }
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageSelected(paramInt);
    }
    localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((OnPageChangeListener)localObject).onPageSelected(paramInt);
        }
        i++;
      }
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageSelected(paramInt);
    }
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
    }
    localObject = this.mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
        }
        i++;
      }
    }
    localObject = this.mInternalPageChangeListener;
    if (localObject != null) {
      ((OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      int k;
      if (paramBoolean) {
        k = this.mPageTransformerLayerType;
      } else {
        k = 0;
      }
      getChildAt(j).setLayerType(k, null);
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    int i = getClientWidth();
    float f1 = 0.0F;
    float f2;
    if (i > 0) {
      f2 = getScrollX() / i;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if (i > 0) {
      f3 = this.mPageMargin / i;
    } else {
      f3 = 0.0F;
    }
    Object localObject = null;
    float f4 = 0.0F;
    int j = -1;
    i = 0;
    int k = 1;
    while (i < this.mItems.size())
    {
      ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(i);
      int m = i;
      ItemInfo localItemInfo2 = localItemInfo1;
      if (k == 0)
      {
        int n = localItemInfo1.position;
        j++;
        m = i;
        localItemInfo2 = localItemInfo1;
        if (n != j)
        {
          localItemInfo2 = this.mTempItem;
          localItemInfo2.offset = (f1 + f4 + f3);
          localItemInfo2.position = j;
          localItemInfo2.widthFactor = this.mAdapter.getPageWidth(j);
          m = i - 1;
        }
      }
      f1 = localItemInfo2.offset;
      f4 = localItemInfo2.widthFactor;
      if ((k == 0) && (f2 < f1)) {
        return (ItemInfo)localObject;
      }
      if ((f2 >= f4 + f1 + f3) && (m != this.mItems.size() - 1))
      {
        j = localItemInfo2.position;
        f4 = localItemInfo2.widthFactor;
        i = m + 1;
        k = 0;
        localObject = localItemInfo2;
      }
      else
      {
        return localItemInfo2;
      }
    }
    return (ItemInfo)localObject;
  }
  
  private static boolean isDecorView(@NonNull View paramView)
  {
    boolean bool;
    if (paramView.getClass().getAnnotation(DecorView.class) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    if (this.mItems.size() == 0)
    {
      if (this.mFirstLayout) {
        return false;
      }
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (this.mCalledSuper) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    ItemInfo localItemInfo = infoForCurrentScrollPosition();
    int i = getClientWidth();
    int j = this.mPageMargin;
    float f1 = j;
    float f2 = i;
    f1 /= f2;
    int k = localItemInfo.position;
    f2 = (paramInt / f2 - localItemInfo.offset) / (localItemInfo.widthFactor + f1);
    paramInt = (int)((i + j) * f2);
    this.mCalledSuper = false;
    onPageScrolled(k, f2, paramInt);
    if (this.mCalledSuper) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat)
  {
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = this.mFirstOffset * f3;
    f1 = this.mLastOffset * f3;
    Object localObject1 = this.mItems;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    localObject1 = (ItemInfo)((ArrayList)localObject1).get(0);
    Object localObject2 = this.mItems;
    localObject2 = (ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((ItemInfo)localObject1).position != 0)
    {
      paramFloat = ((ItemInfo)localObject1).offset * f3;
      i = 0;
    }
    else
    {
      i = 1;
    }
    int j;
    if (((ItemInfo)localObject2).position != this.mAdapter.getCount() - 1)
    {
      f1 = ((ItemInfo)localObject2).offset * f3;
      j = 0;
    }
    else
    {
      j = 1;
    }
    if (f2 < paramFloat)
    {
      if (i != 0)
      {
        this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / f3);
        bool3 = true;
      }
    }
    else
    {
      bool3 = bool2;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool3 = bool1;
        if (j != 0)
        {
          this.mRightEdge.onPull(Math.abs(f2 - f1) / f3);
          bool3 = true;
        }
        paramFloat = f1;
      }
    }
    f1 = this.mLastMotionX;
    int i = (int)paramFloat;
    this.mLastMotionX = (f1 + (paramFloat - i));
    scrollTo(i, getScrollY());
    pageScrolled(i);
    return bool3;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      if (!this.mScroller.isFinished())
      {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
      }
      else
      {
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      }
    }
    else
    {
      ItemInfo localItemInfo = infoForPosition(this.mCurItem);
      float f;
      if (localItemInfo != null) {
        f = Math.min(localItemInfo.offset, this.mLastOffset);
      } else {
        f = 0.0F;
      }
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean resetTouch()
  {
    this.mActivePointerId = -1;
    endDrag();
    this.mLeftEdge.onRelease();
    this.mRightEdge.onRelease();
    boolean bool;
    if ((!this.mLeftEdge.isFinished()) && (!this.mRightEdge.isFinished())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    int i;
    if (localItemInfo != null) {
      i = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)));
    } else {
      i = 0;
    }
    if (paramBoolean1)
    {
      smoothScrollTo(i, 0, paramInt2);
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
    }
    else
    {
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(i, 0);
      pageScrolled(i);
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (this.mDrawingOrder != 0)
    {
      Object localObject = this.mDrawingOrderedChildren;
      if (localObject == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i = getChildCount();
      for (int j = 0; j < i; j++)
      {
        localObject = getChildAt(j);
        this.mDrawingOrderedChildren.add(localObject);
      }
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216) {
      for (int k = 0; k < getChildCount(); k++)
      {
        View localView = getChildAt(k);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
    }
    if ((j != 262144) || (i == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.mItems.size())) {
      this.mItems.add(paramInt2, localItemInfo);
    } else {
      this.mItems.add(localItemInfo);
    }
    return localItemInfo;
  }
  
  public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    if (this.mAdapterChangeListeners == null) {
      this.mAdapterChangeListeners = new ArrayList();
    }
    this.mAdapterChangeListeners.add(paramOnAdapterChangeListener);
  }
  
  public void addOnPageChangeListener(@NonNull OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    boolean bool = paramLayoutParams.isDecor | isDecorView(paramView);
    paramLayoutParams.isDecor = bool;
    if (this.mInLayout)
    {
      if (!bool)
      {
        paramLayoutParams.needsMeasure = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
      }
      else
      {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
    }
    else {
      super.addView(paramView, paramInt, localLayoutParams);
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    boolean bool = false;
    if (localView == this) {}
    Object localObject;
    int i;
    for (;;)
    {
      localObject = null;
      break;
      localObject = localView;
      if (localView == null) {
        break;
      }
      for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
        if (localObject == this)
        {
          i = 1;
          break label66;
        }
      }
      i = 0;
      label66:
      localObject = localView;
      if (i != 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localView.getClass().getSimpleName());
      for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
      {
        localStringBuilder.append(" => ");
        localStringBuilder.append(localObject.getClass().getSimpleName());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arrowScroll tried to find focus based on non-child current focused view ");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      Log.e("ViewPager", ((StringBuilder)localObject).toString());
    }
    localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    int j;
    if ((localView != null) && (localView != localObject)) {
      if (paramInt == 17)
      {
        j = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
        i = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
        if ((localObject != null) && (j >= i)) {
          bool = pageLeft();
        } else {
          bool = localView.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
        if ((localObject != null) && (i <= j))
        {
          bool = pageRight();
        }
        else
        {
          bool = localView.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = pageRight();
            }
          }
          else {
            bool = pageLeft();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean beginFakeDrag()
  {
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    Object localObject = this.mVelocityTracker;
    if (localObject == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    this.mFakeDragBeginTime = l;
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = paramView instanceof ViewGroup;
    boolean bool2 = true;
    if (bool1)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = localViewGroup.getChildCount() - 1; k >= 0; k--)
      {
        View localView = localViewGroup.getChildAt(k);
        int m = paramInt2 + i;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + j;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
      }
    }
    if ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1))) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.mFirstOffset)) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if (j < (int)(i * this.mLastOffset)) {
        bool2 = true;
      }
    }
    return bool2;
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
  
  public void clearOnPageChangeListeners()
  {
    List localList = this.mOnPageChangeListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void computeScroll()
  {
    this.mIsScrollStarted = true;
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i;
    int j;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i)) {
      j = 1;
    } else {
      j = 0;
    }
    int k = this.mCurItem;
    int m = 0;
    Object localObject;
    int i4;
    for (int n = 0; m < this.mItems.size(); n = i4)
    {
      localObject = (ItemInfo)this.mItems.get(m);
      int i1 = this.mAdapter.getItemPosition(((ItemInfo)localObject).object);
      int i2;
      int i3;
      if (i1 == -1)
      {
        i2 = k;
        i3 = m;
        i4 = n;
      }
      else
      {
        if (i1 == -2)
        {
          this.mItems.remove(m);
          i2 = m - 1;
          j = n;
          if (n == 0)
          {
            this.mAdapter.startUpdate(this);
            j = 1;
          }
          this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
          i4 = this.mCurItem;
          m = i2;
          n = j;
          if (i4 == ((ItemInfo)localObject).position)
          {
            k = Math.max(0, Math.min(i4, i - 1));
            n = j;
            m = i2;
          }
        }
        for (;;)
        {
          j = 1;
          i2 = k;
          i3 = m;
          i4 = n;
          break;
          int i5 = ((ItemInfo)localObject).position;
          i2 = k;
          i3 = m;
          i4 = n;
          if (i5 == i1) {
            break;
          }
          if (i5 == this.mCurItem) {
            k = i1;
          }
          ((ItemInfo)localObject).position = i1;
        }
      }
      m = i3 + 1;
      k = i2;
    }
    if (n != 0) {
      this.mAdapter.finishUpdate(this);
    }
    Collections.sort(this.mItems, COMPARATOR);
    if (j != 0)
    {
      m = getChildCount();
      for (n = 0; n < m; n++)
      {
        localObject = (LayoutParams)getChildAt(n).getLayoutParams();
        if (!((LayoutParams)localObject).isDecor) {
          ((LayoutParams)localObject).widthFactor = 0.0F;
        }
      }
      setCurrentItemInternal(k, false, true);
      requestLayout();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!super.dispatchKeyEvent(paramKeyEvent)) && (!executeKeyEvent(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
    }
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getOverScrollMode();
    int j = 0;
    int k = 0;
    if (i != 0) {
      if (i == 1)
      {
        PagerAdapter localPagerAdapter = this.mAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.mLeftEdge.finish();
        this.mRightEdge.finish();
        break label256;
      }
    }
    int m;
    if (!this.mLeftEdge.isFinished())
    {
      j = paramCanvas.save();
      k = getHeight() - getPaddingTop() - getPaddingBottom();
      i = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-k + getPaddingTop(), this.mFirstOffset * i);
      this.mLeftEdge.setSize(k, i);
      m = false | this.mLeftEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
    }
    j = m;
    boolean bool;
    if (!this.mRightEdge.isFinished())
    {
      i = paramCanvas.save();
      int n = getWidth();
      j = getHeight();
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * n);
      this.mRightEdge.setSize(j - i1 - i2, n);
      bool = m | this.mRightEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    label256:
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (this.mFakeDragging)
    {
      if (this.mAdapter != null)
      {
        Object localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int j = getClientWidth();
        int k = getScrollX();
        localObject = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (k / j - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
      }
      endDrag();
      this.mFakeDragging = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21)
      {
        if (i != 22)
        {
          if (i == 61)
          {
            if (paramKeyEvent.hasNoModifiers()) {
              return arrowScroll(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
              return arrowScroll(1);
            }
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2)) {
            return pageRight();
          }
          return arrowScroll(66);
        }
      }
      else
      {
        if (paramKeyEvent.hasModifiers(2)) {
          return pageLeft();
        }
        return arrowScroll(17);
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (this.mFakeDragging)
    {
      if (this.mAdapter == null) {
        return;
      }
      this.mLastMotionX += paramFloat;
      float f1 = getScrollX() - paramFloat;
      float f2 = getClientWidth();
      paramFloat = this.mFirstOffset * f2;
      float f3 = this.mLastOffset * f2;
      Object localObject1 = (ItemInfo)this.mItems.get(0);
      Object localObject2 = this.mItems;
      localObject2 = (ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((ItemInfo)localObject1).position != 0) {
        paramFloat = ((ItemInfo)localObject1).offset * f2;
      }
      if (((ItemInfo)localObject2).position != this.mAdapter.getCount() - 1) {
        f3 = ((ItemInfo)localObject2).offset * f2;
      }
      if (f1 >= paramFloat)
      {
        paramFloat = f1;
        if (f1 > f3) {
          paramFloat = f3;
        }
      }
      f3 = this.mLastMotionX;
      int i = (int)paramFloat;
      this.mLastMotionX = (f3 + (paramFloat - i));
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  @Nullable
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return infoForChild(paramView);
  }
  
  ItemInfo infoForChild(View paramView)
  {
    for (int i = 0; i < this.mItems.size(); i++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
    }
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt)
  {
    for (int i = 0; i < this.mItems.size(); i++)
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (localItemInfo.position == paramInt) {
        return localItemInfo;
      }
    }
    return null;
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffect(localContext);
    this.mRightEdge = new EdgeEffect(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(f * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      private final Rect mTempRect = new Rect();
      
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        paramAnonymousWindowInsetsCompat = ViewCompat.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsetsCompat);
        if (paramAnonymousWindowInsetsCompat.isConsumed()) {
          return paramAnonymousWindowInsetsCompat;
        }
        Rect localRect = this.mTempRect;
        localRect.left = paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft();
        localRect.top = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
        localRect.right = paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight();
        localRect.bottom = paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom();
        int i = 0;
        int j = ViewPager.this.getChildCount();
        while (i < j)
        {
          paramAnonymousView = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), paramAnonymousWindowInsetsCompat);
          localRect.left = Math.min(paramAnonymousView.getSystemWindowInsetLeft(), localRect.left);
          localRect.top = Math.min(paramAnonymousView.getSystemWindowInsetTop(), localRect.top);
          localRect.right = Math.min(paramAnonymousView.getSystemWindowInsetRight(), localRect.right);
          localRect.bottom = Math.min(paramAnonymousView.getSystemWindowInsetBottom(), localRect.bottom);
          i++;
        }
        return paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
    });
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    Scroller localScroller = this.mScroller;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      this.mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int i = getScrollX();
      int j = getWidth();
      float f1 = this.mPageMargin;
      float f2 = j;
      float f3 = f1 / f2;
      Object localObject = this.mItems;
      int k = 0;
      localObject = (ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((ItemInfo)localObject).offset;
      int m = this.mItems.size();
      int n = ((ItemInfo)localObject).position;
      int i1 = ((ItemInfo)this.mItems.get(m - 1)).position;
      while (n < i1)
      {
        int i2;
        for (;;)
        {
          i2 = ((ItemInfo)localObject).position;
          if ((n <= i2) || (k >= m)) {
            break;
          }
          localObject = this.mItems;
          k++;
          localObject = (ItemInfo)((ArrayList)localObject).get(k);
        }
        float f4;
        float f5;
        if (n == i2)
        {
          f1 = ((ItemInfo)localObject).offset;
          f4 = ((ItemInfo)localObject).widthFactor;
          f5 = (f1 + f4) * f2;
          f1 = f1 + f4 + f3;
        }
        else
        {
          f4 = this.mAdapter.getPageWidth(n);
          f5 = (f1 + f4) * f2;
          f1 += f4 + f3;
        }
        if (this.mPageMargin + f5 > i)
        {
          this.mMarginDrawable.setBounds(Math.round(f5), this.mTopPageBounds, Math.round(this.mPageMargin + f5), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f5 > i + j) {
          break;
        }
        n++;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i != 3) && (i != 1))
    {
      if (i != 0)
      {
        if (this.mIsBeingDragged) {
          return true;
        }
        if (this.mIsUnableToDrag) {
          return false;
        }
      }
      float f3;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
        else
        {
          i = this.mActivePointerId;
          if (i != -1)
          {
            i = paramMotionEvent.findPointerIndex(i);
            float f1 = paramMotionEvent.getX(i);
            float f2 = f1 - this.mLastMotionX;
            f3 = Math.abs(f2);
            float f4 = paramMotionEvent.getY(i);
            float f5 = Math.abs(f4 - this.mInitialMotionY);
            boolean bool = f2 < 0.0F;
            if ((bool) && (!isGutterDrag(this.mLastMotionX, f2)) && (canScroll(this, false, (int)f2, (int)f1, (int)f4)))
            {
              this.mLastMotionX = f1;
              this.mLastMotionY = f4;
              this.mIsUnableToDrag = true;
              return false;
            }
            i = this.mTouchSlop;
            if ((f3 > i) && (f3 * 0.5F > f5))
            {
              this.mIsBeingDragged = true;
              requestParentDisallowInterceptTouchEvent(true);
              setScrollState(1);
              f3 = this.mInitialMotionX;
              f5 = this.mTouchSlop;
              if (bool) {
                f3 += f5;
              } else {
                f3 -= f5;
              }
              this.mLastMotionX = f3;
              this.mLastMotionY = f4;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > i)
            {
              this.mIsUnableToDrag = true;
            }
            if ((this.mIsBeingDragged) && (performDrag(f1))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
          }
        }
      }
      else
      {
        f3 = paramMotionEvent.getX();
        this.mInitialMotionX = f3;
        this.mLastMotionX = f3;
        f3 = paramMotionEvent.getY();
        this.mInitialMotionY = f3;
        this.mLastMotionY = f3;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
        }
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
    }
    resetTouch();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    int k = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int m = getScrollX();
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    for (int i1 = 0; n < i; i1 = i6)
    {
      localView = getChildAt(n);
      int i2 = paramInt2;
      int i3 = paramInt1;
      int i4 = paramInt4;
      int i5 = paramInt3;
      i6 = i1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = paramInt2;
        i3 = paramInt1;
        i4 = paramInt4;
        i5 = paramInt3;
        i6 = i1;
        if (localLayoutParams.isDecor)
        {
          i5 = localLayoutParams.gravity;
          i6 = i5 & 0x7;
          i4 = i5 & 0x70;
          if (i6 != 1)
          {
            if (i6 != 3)
            {
              if (i6 != 5)
              {
                i6 = paramInt2;
                i5 = paramInt2;
                paramInt2 = i6;
                break label246;
              }
              i6 = j - paramInt4 - localView.getMeasuredWidth();
              paramInt4 += localView.getMeasuredWidth();
            }
            else
            {
              i6 = localView.getMeasuredWidth() + paramInt2;
              i5 = paramInt2;
              paramInt2 = i6;
              break label246;
            }
          }
          else {
            i6 = Math.max((j - localView.getMeasuredWidth()) / 2, paramInt2);
          }
          i5 = i6;
          label246:
          if (i4 != 16)
          {
            if (i4 != 48)
            {
              if (i4 != 80)
              {
                i4 = paramInt1;
                i6 = paramInt1;
                paramInt1 = i4;
              }
              else
              {
                i6 = k - paramInt3 - localView.getMeasuredHeight();
                paramInt3 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i4 = localView.getMeasuredHeight() + paramInt1;
              i6 = paramInt1;
              paramInt1 = i4;
            }
          }
          else {
            i6 = Math.max((k - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          i5 += m;
          localView.layout(i5, i6, localView.getMeasuredWidth() + i5, i6 + localView.getMeasuredHeight());
          i6 = i1 + 1;
          i5 = paramInt3;
          i4 = paramInt4;
          i3 = paramInt1;
          i2 = paramInt2;
        }
      }
      n++;
      paramInt2 = i2;
      paramInt1 = i3;
      paramInt4 = i4;
      paramInt3 = i5;
    }
    for (int i6 = 0; i6 < i; i6++)
    {
      localView = getChildAt(i6);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            float f = j - paramInt2 - paramInt4;
            n = (int)(localItemInfo.offset * f) + paramInt2;
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * localLayoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(k - paramInt1 - paramInt3, 1073741824));
            }
            localView.layout(n, paramInt1, localView.getMeasuredWidth() + n, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
    }
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = (k - paramInt3);
    this.mDecorChildCount = i1;
    if (this.mFirstLayout) {
      scrollToItem(this.mCurItem, false, 0, false);
    }
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    setMeasuredDimension(ViewGroup.getDefaultSize(0, paramInt1), ViewGroup.getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int j = getChildCount();
    int k = 0;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      int m = 1;
      int n = 1073741824;
      if (k >= j) {
        break;
      }
      localView = getChildAt(k);
      int i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.isDecor)
          {
            i1 = localLayoutParams.gravity;
            i2 = i1 & 0x7;
            i1 &= 0x70;
            int i3;
            if ((i1 != 48) && (i1 != 80)) {
              i3 = 0;
            } else {
              i3 = 1;
            }
            int i4 = m;
            if (i2 != 3) {
              if (i2 == 5) {
                i4 = m;
              } else {
                i4 = 0;
              }
            }
            i2 = Integer.MIN_VALUE;
            if (i3 != 0)
            {
              i1 = 1073741824;
            }
            else
            {
              i1 = i2;
              if (i4 != 0)
              {
                m = 1073741824;
                i1 = i2;
                i2 = m;
                break label267;
              }
            }
            i2 = Integer.MIN_VALUE;
            label267:
            m = localLayoutParams.width;
            int i5;
            if (m != -2)
            {
              if (m != -1) {
                i1 = m;
              } else {
                i1 = paramInt1;
              }
              m = 1073741824;
              i5 = i1;
            }
            else
            {
              i5 = paramInt1;
              m = i1;
            }
            i1 = localLayoutParams.height;
            if (i1 != -2)
            {
              if (i1 != -1) {
                i2 = i1;
              } else {
                i2 = paramInt2;
              }
            }
            else
            {
              i1 = paramInt2;
              n = i2;
              i2 = i1;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i5, m), View.MeasureSpec.makeMeasureSpec(i2, n));
            if (i3 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      k++;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    int i2 = getChildCount();
    for (paramInt2 = i; paramInt2 < i2; paramInt2++)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        }
      }
    }
  }
  
  @CallSuper
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = this.mDecorChildCount;
    int j = 0;
    View localView;
    if (i > 0)
    {
      int k = getScrollX();
      i = getPaddingLeft();
      int m = getPaddingRight();
      int n = getWidth();
      int i1 = getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
      {
        localView = getChildAt(i2);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isDecor)
        {
          int i3 = localLayoutParams.gravity & 0x7;
          if (i3 != 1)
          {
            int i4;
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i4 = i;
                i3 = i;
                i = i4;
              }
              else
              {
                i3 = n - m - localView.getMeasuredWidth();
                m += localView.getMeasuredWidth();
              }
            }
            else
            {
              i4 = localView.getWidth() + i;
              i3 = i;
              i = i4;
            }
          }
          else
          {
            i3 = Math.max((n - localView.getMeasuredWidth()) / 2, i);
          }
          i3 = i3 + k - localView.getLeft();
          if (i3 != 0) {
            localView.offsetLeftAndRight(i3);
          }
        }
      }
    }
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.mPageTransformer != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      for (paramInt1 = j; paramInt1 < i; paramInt1++)
      {
        localView = getChildAt(paramInt1);
        if (!((LayoutParams)localView.getLayoutParams()).isDecor)
        {
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.mPageTransformer.transformPage(localView, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int j = -1;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      j = i;
      i = 0;
      k = 1;
    }
    else
    {
      i--;
      k = -1;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    PagerAdapter localPagerAdapter = this.mAdapter;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
    }
    else
    {
      this.mRestoredCurItem = paramParcelable.position;
      this.mRestoredAdapterState = paramParcelable.adapterState;
      this.mRestoredClassLoader = paramParcelable.loader;
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    PagerAdapter localPagerAdapter = this.mAdapter;
    if (localPagerAdapter != null) {
      localSavedState.adapterState = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.mPageMargin;
      recomputeScrollPosition(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mFakeDragging) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.mAdapter;
    if ((localObject != null) && (((PagerAdapter)localObject).getCount() != 0))
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      i = paramMotionEvent.getAction() & 0xFF;
      float f1;
      if (i != 0)
      {
        float f3;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i == 6)
                {
                  onSecondaryPointerUp(paramMotionEvent);
                  this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
                }
              }
              else
              {
                i = paramMotionEvent.getActionIndex();
                this.mLastMotionX = paramMotionEvent.getX(i);
                this.mActivePointerId = paramMotionEvent.getPointerId(i);
              }
            }
            else if (this.mIsBeingDragged)
            {
              scrollToItem(this.mCurItem, true, 0, false);
              bool = resetTouch();
            }
          }
          else
          {
            if (!this.mIsBeingDragged)
            {
              i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
              if (i == -1)
              {
                bool = resetTouch();
                break label600;
              }
              f1 = paramMotionEvent.getX(i);
              float f2 = Math.abs(f1 - this.mLastMotionX);
              f3 = paramMotionEvent.getY(i);
              float f4 = Math.abs(f3 - this.mLastMotionY);
              if ((f2 > this.mTouchSlop) && (f2 > f4))
              {
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                f2 = this.mInitialMotionX;
                if (f1 - f2 > 0.0F) {
                  f1 = f2 + this.mTouchSlop;
                } else {
                  f1 = f2 - this.mTouchSlop;
                }
                this.mLastMotionX = f1;
                this.mLastMotionY = f3;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            if (this.mIsBeingDragged) {
              bool = false | performDrag(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
            }
          }
        }
        else if (this.mIsBeingDragged)
        {
          localObject = this.mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
          i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
          this.mPopulatePending = true;
          int j = getClientWidth();
          int k = getScrollX();
          localObject = infoForCurrentScrollPosition();
          f3 = this.mPageMargin;
          f1 = j;
          f3 /= f1;
          setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (k / f1 - ((ItemInfo)localObject).offset) / (((ItemInfo)localObject).widthFactor + f3), i, (int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, i);
          bool = resetTouch();
        }
      }
      else
      {
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
      }
      label600:
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  boolean pageLeft()
  {
    int i = this.mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    if ((localPagerAdapter != null) && (this.mCurItem < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    int i = this.mCurItem;
    if (i != paramInt)
    {
      localObject1 = infoForPosition(i);
      this.mCurItem = paramInt;
    }
    else
    {
      localObject1 = null;
    }
    if (this.mAdapter == null)
    {
      sortChildDrawingOrder();
      return;
    }
    if (this.mPopulatePending)
    {
      sortChildDrawingOrder();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.mAdapter.startUpdate(this);
    paramInt = this.mOffscreenPageLimit;
    int j = Math.max(0, this.mCurItem - paramInt);
    int k = this.mAdapter.getCount();
    int m = Math.min(k - 1, this.mCurItem + paramInt);
    Object localObject2;
    if (k == this.mExpectedAdapterCount)
    {
      int n;
      for (paramInt = 0; paramInt < this.mItems.size(); paramInt++)
      {
        localObject2 = (ItemInfo)this.mItems.get(paramInt);
        n = ((ItemInfo)localObject2).position;
        i = this.mCurItem;
        if (n >= i)
        {
          if (n != i) {
            break;
          }
          break label178;
        }
      }
      localObject2 = null;
      label178:
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = localObject2;
        if (k > 0) {
          localObject3 = addNewItem(this.mCurItem, paramInt);
        }
      }
      if (localObject3 != null)
      {
        i = paramInt - 1;
        if (i >= 0) {
          localObject2 = (ItemInfo)this.mItems.get(i);
        } else {
          localObject2 = null;
        }
        int i1 = getClientWidth();
        float f1;
        if (i1 <= 0) {
          f1 = 0.0F;
        } else {
          f1 = 2.0F - ((ItemInfo)localObject3).widthFactor + getPaddingLeft() / i1;
        }
        int i2 = this.mCurItem - 1;
        float f2 = 0.0F;
        Object localObject4 = localObject2;
        int i3;
        float f3;
        while (i2 >= 0)
        {
          if ((f2 >= f1) && (i2 < j))
          {
            if (localObject4 == null) {
              break;
            }
            i3 = paramInt;
            n = i;
            localObject2 = localObject4;
            f3 = f2;
            if (i2 != ((ItemInfo)localObject4).position) {
              break label559;
            }
            i3 = paramInt;
            n = i;
            localObject2 = localObject4;
            f3 = f2;
            if (((ItemInfo)localObject4).scrolling) {
              break label559;
            }
            this.mItems.remove(i);
            this.mAdapter.destroyItem(this, i2, ((ItemInfo)localObject4).object);
            i--;
            paramInt--;
            n = paramInt;
            i3 = i;
            f3 = f2;
            if (i >= 0)
            {
              localObject2 = (ItemInfo)this.mItems.get(i);
              f3 = f2;
              break label553;
            }
          }
          else if ((localObject4 != null) && (i2 == ((ItemInfo)localObject4).position))
          {
            f2 += ((ItemInfo)localObject4).widthFactor;
            i--;
            n = paramInt;
            i3 = i;
            f3 = f2;
            if (i >= 0)
            {
              localObject2 = (ItemInfo)this.mItems.get(i);
              f3 = f2;
              break label553;
            }
          }
          else
          {
            f2 += addNewItem(i2, i + 1).widthFactor;
            paramInt++;
            n = paramInt;
            i3 = i;
            f3 = f2;
            if (i >= 0)
            {
              localObject2 = (ItemInfo)this.mItems.get(i);
              f3 = f2;
              break label553;
            }
          }
          localObject2 = null;
          i = i3;
          paramInt = n;
          label553:
          n = i;
          i3 = paramInt;
          label559:
          i2--;
          paramInt = i3;
          i = n;
          localObject4 = localObject2;
          f2 = f3;
        }
        f2 = ((ItemInfo)localObject3).widthFactor;
        n = paramInt + 1;
        if (f2 < 2.0F)
        {
          if (n < this.mItems.size()) {
            localObject2 = (ItemInfo)this.mItems.get(n);
          } else {
            localObject2 = null;
          }
          if (i1 <= 0) {
            f1 = 0.0F;
          } else {
            f1 = getPaddingRight() / i1 + 2.0F;
          }
          i = this.mCurItem;
          localObject4 = localObject2;
          for (;;)
          {
            i3 = i + 1;
            if (i3 >= k) {
              break;
            }
            if ((f2 >= f1) && (i3 > m))
            {
              if (localObject4 == null) {
                break;
              }
              f3 = f2;
              i = n;
              localObject2 = localObject4;
              if (i3 != ((ItemInfo)localObject4).position) {
                break label946;
              }
              f3 = f2;
              i = n;
              localObject2 = localObject4;
              if (((ItemInfo)localObject4).scrolling) {
                break label946;
              }
              this.mItems.remove(n);
              this.mAdapter.destroyItem(this, i3, ((ItemInfo)localObject4).object);
              f3 = f2;
              i = n;
              if (n < this.mItems.size())
              {
                localObject2 = (ItemInfo)this.mItems.get(n);
                f3 = f2;
                i = n;
                break label946;
              }
            }
            do
            {
              do
              {
                localObject2 = null;
                break label946;
                if ((localObject4 == null) || (i3 != ((ItemInfo)localObject4).position)) {
                  break;
                }
                f2 += ((ItemInfo)localObject4).widthFactor;
                n++;
                f3 = f2;
                i = n;
              } while (n >= this.mItems.size());
              localObject2 = (ItemInfo)this.mItems.get(n);
              f3 = f2;
              i = n;
              break;
              localObject2 = addNewItem(i3, n);
              n++;
              f2 += ((ItemInfo)localObject2).widthFactor;
              f3 = f2;
              i = n;
            } while (n >= this.mItems.size());
            localObject2 = (ItemInfo)this.mItems.get(n);
            i = n;
            f3 = f2;
            label946:
            f2 = f3;
            n = i;
            localObject4 = localObject2;
            i = i3;
          }
        }
        calculatePageOffsets((ItemInfo)localObject3, paramInt, (ItemInfo)localObject1);
        this.mAdapter.setPrimaryItem(this, this.mCurItem, ((ItemInfo)localObject3).object);
      }
      this.mAdapter.finishUpdate(this);
      i = getChildCount();
      for (paramInt = 0; paramInt < i; paramInt++)
      {
        localObject1 = getChildAt(paramInt);
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        ((LayoutParams)localObject2).childIndex = paramInt;
        if ((!((LayoutParams)localObject2).isDecor) && (((LayoutParams)localObject2).widthFactor == 0.0F))
        {
          localObject1 = infoForChild((View)localObject1);
          if (localObject1 != null)
          {
            ((LayoutParams)localObject2).widthFactor = ((ItemInfo)localObject1).widthFactor;
            ((LayoutParams)localObject2).position = ((ItemInfo)localObject1).position;
          }
        }
      }
      sortChildDrawingOrder();
      if (hasFocus())
      {
        localObject2 = findFocus();
        if (localObject2 != null) {
          localObject2 = infoForAnyChild((View)localObject2);
        } else {
          localObject2 = null;
        }
        if ((localObject2 == null) || (((ItemInfo)localObject2).position != this.mCurItem)) {
          for (paramInt = 0; paramInt < getChildCount(); paramInt++)
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = infoForChild((View)localObject1);
            if ((localObject2 != null) && (((ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(2))) {
              break;
            }
          }
        }
      }
      return;
    }
    String str;
    try
    {
      localObject2 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      str = Integer.toHexString(getId());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject1).append(this.mExpectedAdapterCount);
    ((StringBuilder)localObject1).append(", found: ");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(" Pager id: ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" Pager class: ");
    ((StringBuilder)localObject1).append(getClass());
    ((StringBuilder)localObject1).append(" Problematic adapter: ");
    ((StringBuilder)localObject1).append(this.mAdapter.getClass());
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    List localList = this.mAdapterChangeListeners;
    if (localList != null) {
      localList.remove(paramOnAdapterChangeListener);
    }
  }
  
  public void removeOnPageChangeListener(@NonNull OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.mOnPageChangeListeners;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
    } else {
      super.removeView(paramView);
    }
  }
  
  public void setAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    Object localObject = this.mAdapter;
    int i = 0;
    int j;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      for (j = 0; j < this.mItems.size(); j++)
      {
        localObject = (ItemInfo)this.mItems.get(j);
        this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    PagerAdapter localPagerAdapter = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (paramPagerAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new PagerObserver();
      }
      this.mAdapter.setViewPagerObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0)
      {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      }
      else if (!bool)
      {
        populate();
      }
      else
      {
        requestLayout();
      }
    }
    localObject = this.mAdapterChangeListeners;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int k = this.mAdapterChangeListeners.size();
      for (j = i; j < k; j++) {
        ((OnAdapterChangeListener)this.mAdapterChangeListeners.get(j)).onAdapterChanged(this, localPagerAdapter, paramPagerAdapter);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, this.mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    PagerAdapter localPagerAdapter = this.mAdapter;
    boolean bool = false;
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      int i;
      if (paramInt1 < 0)
      {
        i = 0;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 >= this.mAdapter.getCount()) {
          i = this.mAdapter.getCount() - 1;
        }
      }
      int j = this.mOffscreenPageLimit;
      paramInt1 = this.mCurItem;
      if ((i > paramInt1 + j) || (i < paramInt1 - j)) {
        for (paramInt1 = 0; paramInt1 < this.mItems.size(); paramInt1++) {
          ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
        }
      }
      paramBoolean2 = bool;
      if (this.mCurItem != i) {
        paramBoolean2 = true;
      }
      if (this.mFirstLayout)
      {
        this.mCurItem = i;
        if (paramBoolean2) {
          dispatchOnPageSelected(i);
        }
        requestLayout();
      }
      else
      {
        populate(i);
        scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
      }
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("ViewPager", localStringBuilder.toString());
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(@DrawableRes int paramInt)
  {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(@Nullable Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, @Nullable PageTransformer paramPageTransformer)
  {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, @Nullable PageTransformer paramPageTransformer, int paramInt)
  {
    int i = 1;
    boolean bool1;
    if (paramPageTransformer != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.mPageTransformer != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int j;
    if (bool1 != bool2) {
      j = 1;
    } else {
      j = 0;
    }
    this.mPageTransformer = paramPageTransformer;
    setChildrenDrawingOrderEnabled(bool1);
    if (bool1)
    {
      if (paramBoolean) {
        i = 2;
      }
      this.mDrawingOrder = i;
      this.mPageTransformerLayerType = paramInt;
    }
    else
    {
      this.mDrawingOrder = 0;
    }
    if (j != 0) {
      populate();
    }
  }
  
  void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      enableLayers(bool);
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    Scroller localScroller = this.mScroller;
    int i;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.mIsScrollStarted) {
        i = this.mScroller.getCurrX();
      } else {
        i = this.mScroller.getStartX();
      }
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    else
    {
      i = getScrollX();
    }
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int m = getClientWidth();
    paramInt1 = m / 2;
    float f1 = Math.abs(k);
    float f2 = m;
    float f3 = Math.min(1.0F, f1 * 1.0F / f2);
    f1 = paramInt1;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      paramInt1 = Math.round(Math.abs((f1 + f3 * f1) / paramInt1) * 1000.0F) * 4;
    }
    else
    {
      f1 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f2 * f1 + this.mPageMargin) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    this.mIsScrollStarted = false;
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != this.mMarginDrawable)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface DecorView {}
  
  static class ItemInfo
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  class MyAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    MyAccessibilityDelegate() {}
    
    private boolean canScroll()
    {
      PagerAdapter localPagerAdapter = ViewPager.this.mAdapter;
      boolean bool = true;
      if ((localPagerAdapter == null) || (localPagerAdapter.getCount() <= 1)) {
        bool = false;
      }
      return bool;
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramAccessibilityEvent.setScrollable(canScroll());
      if (paramAccessibilityEvent.getEventType() == 4096)
      {
        paramView = ViewPager.this.mAdapter;
        if (paramView != null)
        {
          paramAccessibilityEvent.setItemCount(paramView.getCount());
          paramAccessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
          paramAccessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192) {
          return false;
        }
        if (ViewPager.this.canScrollHorizontally(-1))
        {
          paramView = ViewPager.this;
          paramView.setCurrentItem(paramView.mCurItem - 1);
          return true;
        }
        return false;
      }
      if (ViewPager.this.canScrollHorizontally(1))
      {
        paramView = ViewPager.this;
        paramView.setCurrentItem(paramView.mCurItem + 1);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface OnAdapterChangeListener
  {
    public abstract void onAdapterChanged(@NonNull ViewPager paramViewPager, @Nullable PagerAdapter paramPagerAdapter1, @Nullable PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, @Px int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface PageTransformer
  {
    public abstract void transformPage(@NonNull View paramView, float paramFloat);
  }
  
  private class PagerObserver
    extends DataSetObserver
  {
    PagerObserver() {}
    
    public void onChanged()
    {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated()
    {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public ViewPager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViewPager.SavedState(paramAnonymousParcel, null);
      }
      
      public ViewPager.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new ViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public ViewPager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ViewPager.SavedState[paramAnonymousInt];
      }
    };
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.adapterState = paramParcel.readParcelable(localClassLoader);
      this.loader = localClassLoader;
    }
    
    public SavedState(@NonNull Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentPager.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" position=");
      localStringBuilder.append(this.position);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.adapterState, paramInt);
    }
  }
  
  public static class SimpleOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  static class ViewPositionComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
      boolean bool = paramView1.isDecor;
      if (bool != paramView2.isDecor)
      {
        int i;
        if (bool) {
          i = 1;
        } else {
          i = -1;
        }
        return i;
      }
      return paramView1.position - paramView2.position;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager\widget\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */