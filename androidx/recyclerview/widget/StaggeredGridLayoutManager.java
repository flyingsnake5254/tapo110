package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.SmoothScroller.ScrollVectorProvider
{
  static final boolean DEBUG = false;
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  public static final int GAP_HANDLING_NONE = 0;
  public static final int HORIZONTAL = 0;
  static final int INVALID_OFFSET = Integer.MIN_VALUE;
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  private static final String TAG = "StaggeredGridLManager";
  public static final int VERTICAL = 1;
  private final AnchorInfo mAnchorInfo = new AnchorInfo();
  private final Runnable mCheckForGapsRunnable = new Runnable()
  {
    public void run()
    {
      StaggeredGridLayoutManager.this.checkForGaps();
    }
  };
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  @NonNull
  private final LayoutState mLayoutState;
  LazySpanLookup mLazySpanLookup = new LazySpanLookup();
  private int mOrientation;
  private SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private int[] mPrefetchDistances;
  @NonNull
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  boolean mReverseLayout = false;
  @NonNull
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  private int mSpanCount = -1;
  Span[] mSpans;
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.mOrientation = paramInt2;
    setSpanCount(paramInt1);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.LayoutManager.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setSpanCount(paramContext.spanCount);
    setReverseLayout(paramContext.reverseLayout);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  private void appendViewToAllSpans(View paramView)
  {
    for (int i = this.mSpanCount - 1; i >= 0; i--) {
      this.mSpans[i].appendToSpan(paramView);
    }
  }
  
  private void applyPendingSavedState(AnchorInfo paramAnchorInfo)
  {
    SavedState localSavedState = this.mPendingSavedState;
    int i = localSavedState.mSpanOffsetsSize;
    if (i > 0)
    {
      if (i == this.mSpanCount) {
        for (i = 0; i < this.mSpanCount; i++)
        {
          this.mSpans[i].clear();
          localSavedState = this.mPendingSavedState;
          int j = localSavedState.mSpanOffsets[i];
          int k = j;
          if (j != Integer.MIN_VALUE)
          {
            if (localSavedState.mAnchorLayoutFromEnd) {
              k = this.mPrimaryOrientation.getEndAfterPadding();
            } else {
              k = this.mPrimaryOrientation.getStartAfterPadding();
            }
            k = j + k;
          }
          this.mSpans[i].setLine(k);
        }
      }
      localSavedState.invalidateSpanInfo();
      localSavedState = this.mPendingSavedState;
      localSavedState.mAnchorPosition = localSavedState.mVisibleAnchorPosition;
    }
    localSavedState = this.mPendingSavedState;
    this.mLastLayoutRTL = localSavedState.mLastLayoutRTL;
    setReverseLayout(localSavedState.mReverseLayout);
    resolveShouldLayoutReverse();
    localSavedState = this.mPendingSavedState;
    i = localSavedState.mAnchorPosition;
    if (i != -1)
    {
      this.mPendingScrollPosition = i;
      paramAnchorInfo.mLayoutFromEnd = localSavedState.mAnchorLayoutFromEnd;
    }
    else
    {
      paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    }
    if (localSavedState.mSpanLookupSize > 1)
    {
      paramAnchorInfo = this.mLazySpanLookup;
      paramAnchorInfo.mData = localSavedState.mSpanLookup;
      paramAnchorInfo.mFullSpanItems = localSavedState.mFullSpanItems;
    }
  }
  
  private void attachViewToSpans(View paramView, LayoutParams paramLayoutParams, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mLayoutDirection == 1)
    {
      if (paramLayoutParams.mFullSpan) {
        appendViewToAllSpans(paramView);
      } else {
        paramLayoutParams.mSpan.appendToSpan(paramView);
      }
    }
    else if (paramLayoutParams.mFullSpan) {
      prependViewToAllSpans(paramView);
    } else {
      paramLayoutParams.mSpan.prependToSpan(paramView);
    }
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    int i = getChildCount();
    int j = -1;
    if (i == 0)
    {
      if (this.mShouldReverseLayout) {
        j = 1;
      }
      return j;
    }
    int k;
    if (paramInt < getFirstChildPosition()) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == this.mShouldReverseLayout) {
      j = 1;
    }
    return j;
  }
  
  private boolean checkSpanForGap(Span paramSpan)
  {
    if (this.mShouldReverseLayout)
    {
      if (paramSpan.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding())
      {
        ArrayList localArrayList = paramSpan.mViews;
        return paramSpan.getLayoutParams((View)localArrayList.get(localArrayList.size() - 1)).mFullSpan ^ true;
      }
    }
    else if (paramSpan.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
      return paramSpan.getLayoutParams((View)paramSpan.mViews.get(0)).mFullSpan ^ true;
    }
    return false;
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollExtent(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollOffset(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollRange(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int i = -1;
    int j = 1;
    int k = 1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 33)
          {
            if (paramInt != 66)
            {
              if (paramInt != 130) {
                return Integer.MIN_VALUE;
              }
              if (this.mOrientation == 1) {
                paramInt = k;
              } else {
                paramInt = Integer.MIN_VALUE;
              }
              return paramInt;
            }
            if (this.mOrientation == 0) {
              paramInt = j;
            } else {
              paramInt = Integer.MIN_VALUE;
            }
            return paramInt;
          }
          if (this.mOrientation != 1) {
            i = Integer.MIN_VALUE;
          }
          return i;
        }
        if (this.mOrientation != 0) {
          i = Integer.MIN_VALUE;
        }
        return i;
      }
      if (this.mOrientation == 1) {
        return 1;
      }
      if (isLayoutRTL()) {
        return -1;
      }
      return 1;
    }
    if (this.mOrientation == 1) {
      return -1;
    }
    if (isLayoutRTL()) {
      return 1;
    }
    return -1;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (int i = 0; i < this.mSpanCount; i++) {
      localFullSpanItem.mGapPerSpan[i] = (paramInt - this.mSpans[i].getEndLine(paramInt));
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (int i = 0; i < this.mSpanCount; i++) {
      localFullSpanItem.mGapPerSpan[i] = (this.mSpans[i].getStartLine(paramInt) - paramInt);
    }
    return localFullSpanItem;
  }
  
  private void createOrientationHelpers()
  {
    this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState)
  {
    this.mRemainingSpans.set(0, this.mSpanCount, true);
    int i;
    if (this.mLayoutState.mInfinite)
    {
      if (paramLayoutState.mLayoutDirection == 1) {
        i = Integer.MAX_VALUE;
      } else {
        i = Integer.MIN_VALUE;
      }
    }
    else if (paramLayoutState.mLayoutDirection == 1) {
      i = paramLayoutState.mEndLine + paramLayoutState.mAvailable;
    } else {
      i = paramLayoutState.mStartLine - paramLayoutState.mAvailable;
    }
    updateAllRemainingSpans(paramLayoutState.mLayoutDirection, i);
    int j;
    if (this.mShouldReverseLayout) {
      j = this.mPrimaryOrientation.getEndAfterPadding();
    } else {
      j = this.mPrimaryOrientation.getStartAfterPadding();
    }
    for (int k = 0; (paramLayoutState.hasMore(paramState)) && ((this.mLayoutState.mInfinite) || (!this.mRemainingSpans.isEmpty())); k = 1)
    {
      View localView = paramLayoutState.next(paramRecycler);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int m = localLayoutParams.getViewLayoutPosition();
      k = this.mLazySpanLookup.getSpan(m);
      int n;
      if (k == -1) {
        n = 1;
      } else {
        n = 0;
      }
      Span localSpan;
      if (n != 0)
      {
        if (localLayoutParams.mFullSpan) {
          localSpan = this.mSpans[0];
        } else {
          localSpan = getNextSpan(paramLayoutState);
        }
        this.mLazySpanLookup.setSpan(m, localSpan);
      }
      else
      {
        localSpan = this.mSpans[k];
      }
      localLayoutParams.mSpan = localSpan;
      if (paramLayoutState.mLayoutDirection == 1) {
        addView(localView);
      } else {
        addView(localView, 0);
      }
      measureChildWithDecorationsAndMargin(localView, localLayoutParams, false);
      int i1;
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
      int i2;
      if (paramLayoutState.mLayoutDirection == 1)
      {
        if (localLayoutParams.mFullSpan) {
          k = getMaxEnd(j);
        } else {
          k = localSpan.getEndLine(j);
        }
        i1 = this.mPrimaryOrientation.getDecoratedMeasurement(localView);
        if ((n != 0) && (localLayoutParams.mFullSpan))
        {
          localFullSpanItem = createFullSpanItemFromEnd(k);
          localFullSpanItem.mGapDir = -1;
          localFullSpanItem.mPosition = m;
          this.mLazySpanLookup.addFullSpanItem(localFullSpanItem);
        }
        i2 = i1 + k;
        i1 = k;
      }
      else
      {
        if (localLayoutParams.mFullSpan) {
          k = getMinStart(j);
        } else {
          k = localSpan.getStartLine(j);
        }
        i1 = k - this.mPrimaryOrientation.getDecoratedMeasurement(localView);
        if ((n != 0) && (localLayoutParams.mFullSpan))
        {
          localFullSpanItem = createFullSpanItemFromStart(k);
          localFullSpanItem.mGapDir = 1;
          localFullSpanItem.mPosition = m;
          this.mLazySpanLookup.addFullSpanItem(localFullSpanItem);
        }
        i2 = k;
      }
      if ((localLayoutParams.mFullSpan) && (paramLayoutState.mItemDirection == -1)) {
        if (n != 0)
        {
          this.mLaidOutInvalidFullSpan = true;
        }
        else
        {
          boolean bool;
          if (paramLayoutState.mLayoutDirection == 1) {
            bool = areAllEndsEqual();
          } else {
            bool = areAllStartsEqual();
          }
          if ((bool ^ true))
          {
            localFullSpanItem = this.mLazySpanLookup.getFullSpanItem(m);
            if (localFullSpanItem != null) {
              localFullSpanItem.mHasUnwantedGapAfter = true;
            }
            this.mLaidOutInvalidFullSpan = true;
          }
        }
      }
      attachViewToSpans(localView, localLayoutParams, paramLayoutState);
      if ((isLayoutRTL()) && (this.mOrientation == 1))
      {
        if (localLayoutParams.mFullSpan) {
          k = this.mSecondaryOrientation.getEndAfterPadding();
        } else {
          k = this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - localSpan.mIndex) * this.mSizePerSpan;
        }
        m = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        n = k;
        m = k - m;
        k = n;
      }
      else
      {
        if (localLayoutParams.mFullSpan) {
          k = this.mSecondaryOrientation.getStartAfterPadding();
        } else {
          k = localSpan.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
        }
        m = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        n = k;
        k = m + k;
        m = n;
      }
      if (this.mOrientation == 1) {
        layoutDecoratedWithMargins(localView, m, i1, k, i2);
      } else {
        layoutDecoratedWithMargins(localView, i1, m, i2, k);
      }
      if (localLayoutParams.mFullSpan) {
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
      } else {
        updateRemainingSpans(localSpan, this.mLayoutState.mLayoutDirection, i);
      }
      recycle(paramRecycler, this.mLayoutState);
      if ((this.mLayoutState.mStopInFocusable) && (localView.hasFocusable())) {
        if (localLayoutParams.mFullSpan) {
          this.mRemainingSpans.clear();
        } else {
          this.mRemainingSpans.set(localSpan.mIndex, false);
        }
      }
    }
    if (k == 0) {
      recycle(paramRecycler, this.mLayoutState);
    }
    if (this.mLayoutState.mLayoutDirection == -1)
    {
      i = getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
      i = this.mPrimaryOrientation.getStartAfterPadding() - i;
    }
    else
    {
      i = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
    }
    if (i > 0) {
      i = Math.min(paramLayoutState.mAvailable, i);
    } else {
      i = 0;
    }
    return i;
  }
  
  private int findFirstReferenceChildPosition(int paramInt)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      int k = getPosition(getChildAt(j));
      if ((k >= 0) && (k < paramInt)) {
        return k;
      }
    }
    return 0;
  }
  
  private int findLastReferenceChildPosition(int paramInt)
  {
    for (int i = getChildCount() - 1; i >= 0; i--)
    {
      int j = getPosition(getChildAt(i));
      if ((j >= 0) && (j < paramInt)) {
        return j;
      }
    }
    return 0;
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMaxEnd(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {
      return;
    }
    i = this.mPrimaryOrientation.getEndAfterPadding() - i;
    if (i > 0)
    {
      i -= -scrollBy(-i, paramRecycler, paramState);
      if ((paramBoolean) && (i > 0)) {
        this.mPrimaryOrientation.offsetChildren(i);
      }
    }
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMinStart(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {
      return;
    }
    i -= this.mPrimaryOrientation.getStartAfterPadding();
    if (i > 0)
    {
      i -= scrollBy(i, paramRecycler, paramState);
      if ((paramBoolean) && (i > 0)) {
        this.mPrimaryOrientation.offsetChildren(-i);
      }
    }
  }
  
  private int getMaxEnd(int paramInt)
  {
    int i = this.mSpans[0].getEndLine(paramInt);
    int j = 1;
    while (j < this.mSpanCount)
    {
      int k = this.mSpans[j].getEndLine(paramInt);
      int m = i;
      if (k > i) {
        m = k;
      }
      j++;
      i = m;
    }
    return i;
  }
  
  private int getMaxStart(int paramInt)
  {
    int i = this.mSpans[0].getStartLine(paramInt);
    int j = 1;
    while (j < this.mSpanCount)
    {
      int k = this.mSpans[j].getStartLine(paramInt);
      int m = i;
      if (k > i) {
        m = k;
      }
      j++;
      i = m;
    }
    return i;
  }
  
  private int getMinEnd(int paramInt)
  {
    int i = this.mSpans[0].getEndLine(paramInt);
    int j = 1;
    while (j < this.mSpanCount)
    {
      int k = this.mSpans[j].getEndLine(paramInt);
      int m = i;
      if (k < i) {
        m = k;
      }
      j++;
      i = m;
    }
    return i;
  }
  
  private int getMinStart(int paramInt)
  {
    int i = this.mSpans[0].getStartLine(paramInt);
    int j = 1;
    while (j < this.mSpanCount)
    {
      int k = this.mSpans[j].getStartLine(paramInt);
      int m = i;
      if (k < i) {
        m = k;
      }
      j++;
      i = m;
    }
    return i;
  }
  
  private Span getNextSpan(LayoutState paramLayoutState)
  {
    boolean bool = preferLastSpan(paramLayoutState.mLayoutDirection);
    int i = -1;
    int j;
    int k;
    if (bool)
    {
      j = this.mSpanCount - 1;
      k = -1;
    }
    else
    {
      j = 0;
      i = this.mSpanCount;
      k = 1;
    }
    int m = paramLayoutState.mLayoutDirection;
    Span localSpan = null;
    paramLayoutState = null;
    int i1;
    if (m == 1)
    {
      m = Integer.MAX_VALUE;
      n = this.mPrimaryOrientation.getStartAfterPadding();
      while (j != i)
      {
        localSpan = this.mSpans[j];
        i1 = localSpan.getEndLine(n);
        i2 = m;
        if (i1 < m)
        {
          paramLayoutState = localSpan;
          i2 = i1;
        }
        j += k;
        m = i2;
      }
      return paramLayoutState;
    }
    m = Integer.MIN_VALUE;
    int n = this.mPrimaryOrientation.getEndAfterPadding();
    paramLayoutState = localSpan;
    int i2 = j;
    while (i2 != i)
    {
      localSpan = this.mSpans[i2];
      i1 = localSpan.getStartLine(n);
      j = m;
      if (i1 > m)
      {
        paramLayoutState = localSpan;
        j = i1;
      }
      i2 += k;
      m = j;
    }
    return paramLayoutState;
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getLastChildPosition();
    } else {
      i = getFirstChildPosition();
    }
    int j;
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        j = paramInt2 + 1;
      }
      else
      {
        j = paramInt1 + 1;
        k = paramInt2;
        break label60;
      }
    }
    else {
      j = paramInt1 + paramInt2;
    }
    int k = paramInt1;
    label60:
    this.mLazySpanLookup.invalidateAfter(k);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          this.mLazySpanLookup.offsetForRemoval(paramInt1, 1);
          this.mLazySpanLookup.offsetForAddition(paramInt2, 1);
        }
      }
      else {
        this.mLazySpanLookup.offsetForRemoval(paramInt1, paramInt2);
      }
    }
    else {
      this.mLazySpanLookup.offsetForAddition(paramInt1, paramInt2);
    }
    if (j <= i) {
      return;
    }
    if (this.mShouldReverseLayout) {
      paramInt1 = getFirstChildPosition();
    } else {
      paramInt1 = getLastChildPosition();
    }
    if (k <= paramInt1) {
      requestLayout();
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    calculateItemDecorationsForChild(paramView, this.mTmpRect);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin;
    Rect localRect = this.mTmpRect;
    paramInt1 = updateSpecWithExtra(paramInt1, i + localRect.left, localLayoutParams.rightMargin + localRect.right);
    i = localLayoutParams.topMargin;
    localRect = this.mTmpRect;
    paramInt2 = updateSpecWithExtra(paramInt2, i + localRect.top, localLayoutParams.bottomMargin + localRect.bottom);
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams.mFullSpan)
    {
      if (this.mOrientation == 1) {
        measureChildWithDecorationsAndMargin(paramView, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
      } else {
        measureChildWithDecorationsAndMargin(paramView, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.mFullSizeSpec, paramBoolean);
      }
    }
    else if (this.mOrientation == 1) {
      measureChildWithDecorationsAndMargin(paramView, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, paramLayoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
    } else {
      measureChildWithDecorationsAndMargin(paramView, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
    }
  }
  
  private void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    AnchorInfo localAnchorInfo = this.mAnchorInfo;
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      localAnchorInfo.reset();
      return;
    }
    boolean bool = localAnchorInfo.mValid;
    int i = 1;
    if ((bool) && (this.mPendingScrollPosition == -1) && (this.mPendingSavedState == null)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      localAnchorInfo.reset();
      if (this.mPendingSavedState != null)
      {
        applyPendingSavedState(localAnchorInfo);
      }
      else
      {
        resolveShouldLayoutReverse();
        localAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
      }
      updateAnchorInfoForLayout(paramState, localAnchorInfo);
      localAnchorInfo.mValid = true;
    }
    if ((this.mPendingSavedState == null) && (this.mPendingScrollPosition == -1) && ((localAnchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd) || (isLayoutRTL() != this.mLastLayoutRTL)))
    {
      this.mLazySpanLookup.clear();
      localAnchorInfo.mInvalidateOffsets = true;
    }
    Object localObject;
    if (getChildCount() > 0)
    {
      localObject = this.mPendingSavedState;
      if ((localObject == null) || (((SavedState)localObject).mSpanOffsetsSize < 1))
      {
        if (localAnchorInfo.mInvalidateOffsets) {
          for (j = 0; j < this.mSpanCount; j++)
          {
            this.mSpans[j].clear();
            int k = localAnchorInfo.mOffset;
            if (k != Integer.MIN_VALUE) {
              this.mSpans[j].setLine(k);
            }
          }
        }
        if ((j == 0) && (this.mAnchorInfo.mSpanReferenceLines != null)) {
          j = 0;
        }
        while (j < this.mSpanCount)
        {
          localObject = this.mSpans[j];
          ((Span)localObject).clear();
          ((Span)localObject).setLine(this.mAnchorInfo.mSpanReferenceLines[j]);
          j++;
          continue;
          for (j = 0; j < this.mSpanCount; j++) {
            this.mSpans[j].cacheReferenceLineAndClear(this.mShouldReverseLayout, localAnchorInfo.mOffset);
          }
          this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        }
      }
    }
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.mRecycle = false;
    this.mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
    updateLayoutState(localAnchorInfo.mPosition, paramState);
    if (localAnchorInfo.mLayoutFromEnd)
    {
      setLayoutStateDirection(-1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(1);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mCurrentPosition = (localAnchorInfo.mPosition + ((LayoutState)localObject).mItemDirection);
      fill(paramRecycler, (LayoutState)localObject, paramState);
    }
    else
    {
      setLayoutStateDirection(1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(-1);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mCurrentPosition = (localAnchorInfo.mPosition + ((LayoutState)localObject).mItemDirection);
      fill(paramRecycler, (LayoutState)localObject, paramState);
    }
    repositionToWrapContentIfNecessary();
    if (getChildCount() > 0) {
      if (this.mShouldReverseLayout)
      {
        fixEndGap(paramRecycler, paramState, true);
        fixStartGap(paramRecycler, paramState, false);
      }
      else
      {
        fixStartGap(paramRecycler, paramState, true);
        fixEndGap(paramRecycler, paramState, false);
      }
    }
    if ((paramBoolean) && (!paramState.isPreLayout()))
    {
      if ((this.mGapStrategy != 0) && (getChildCount() > 0) && ((this.mLaidOutInvalidFullSpan) || (hasGapsToFix() != null))) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps())
        {
          j = i;
          break label668;
        }
      }
    }
    int j = 0;
    label668:
    if (paramState.isPreLayout()) {
      this.mAnchorInfo.reset();
    }
    this.mLastLayoutFromEnd = localAnchorInfo.mLayoutFromEnd;
    this.mLastLayoutRTL = isLayoutRTL();
    if (j != 0)
    {
      this.mAnchorInfo.reset();
      onLayoutChildren(paramRecycler, paramState, false);
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    int i = this.mOrientation;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3;
    if (i == 0)
    {
      if (paramInt == -1) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if (bool3 != this.mShouldReverseLayout) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    if (paramInt == -1) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (bool3 == this.mShouldReverseLayout) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (bool3 == isLayoutRTL()) {
      bool3 = bool1;
    } else {
      bool3 = false;
    }
    return bool3;
  }
  
  private void prependViewToAllSpans(View paramView)
  {
    for (int i = this.mSpanCount - 1; i >= 0; i--) {
      this.mSpans[i].prependToSpan(paramView);
    }
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if ((paramLayoutState.mRecycle) && (!paramLayoutState.mInfinite)) {
      if (paramLayoutState.mAvailable == 0)
      {
        if (paramLayoutState.mLayoutDirection == -1) {
          recycleFromEnd(paramRecycler, paramLayoutState.mEndLine);
        } else {
          recycleFromStart(paramRecycler, paramLayoutState.mStartLine);
        }
      }
      else
      {
        int i;
        if (paramLayoutState.mLayoutDirection == -1)
        {
          i = paramLayoutState.mStartLine;
          i -= getMaxStart(i);
          if (i < 0) {
            i = paramLayoutState.mEndLine;
          } else {
            i = paramLayoutState.mEndLine - Math.min(i, paramLayoutState.mAvailable);
          }
          recycleFromEnd(paramRecycler, i);
        }
        else
        {
          i = getMinEnd(paramLayoutState.mEndLine) - paramLayoutState.mEndLine;
          if (i < 0)
          {
            i = paramLayoutState.mStartLine;
          }
          else
          {
            int j = paramLayoutState.mStartLine;
            i = Math.min(i, paramLayoutState.mAvailable) + j;
          }
          recycleFromStart(paramRecycler, i);
        }
      }
    }
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    for (int i = getChildCount() - 1; i >= 0; i--)
    {
      View localView = getChildAt(i);
      if ((this.mPrimaryOrientation.getDecoratedStart(localView) < paramInt) || (this.mPrimaryOrientation.getTransformedStartWithDecoration(localView) < paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan)
      {
        int j = 0;
        int m;
        for (int k = 0;; k++)
        {
          m = j;
          if (k >= this.mSpanCount) {
            break;
          }
          if (this.mSpans[k].mViews.size() == 1) {
            return;
          }
        }
        while (m < this.mSpanCount)
        {
          this.mSpans[m].popEnd();
          m++;
        }
      }
      if (localLayoutParams.mSpan.mViews.size() == 1) {
        return;
      }
      localLayoutParams.mSpan.popEnd();
      removeAndRecycleView(localView, paramRecycler);
    }
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    while (getChildCount() > 0)
    {
      int i = 0;
      View localView = getChildAt(0);
      if ((this.mPrimaryOrientation.getDecoratedEnd(localView) > paramInt) || (this.mPrimaryOrientation.getTransformedEndWithDecoration(localView) > paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan)
      {
        int k;
        for (int j = 0;; j++)
        {
          k = i;
          if (j >= this.mSpanCount) {
            break;
          }
          if (this.mSpans[j].mViews.size() == 1) {
            return;
          }
        }
        while (k < this.mSpanCount)
        {
          this.mSpans[k].popStart();
          k++;
        }
      }
      if (localLayoutParams.mSpan.mViews.size() == 1) {
        return;
      }
      localLayoutParams.mSpan.popStart();
      removeAndRecycleView(localView, paramRecycler);
    }
  }
  
  private void repositionToWrapContentIfNecessary()
  {
    if (this.mSecondaryOrientation.getMode() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int i = getChildCount();
    int j = 0;
    View localView;
    for (int k = 0; k < i; k++)
    {
      localView = getChildAt(k);
      float f2 = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
      if (f2 >= f1)
      {
        float f3 = f2;
        if (((LayoutParams)localView.getLayoutParams()).isFullSpan()) {
          f3 = f2 * 1.0F / this.mSpanCount;
        }
        f1 = Math.max(f1, f3);
      }
    }
    int m = this.mSizePerSpan;
    int n = Math.round(f1 * this.mSpanCount);
    k = n;
    if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
      k = Math.min(n, this.mSecondaryOrientation.getTotalSpace());
    }
    updateMeasureSpecs(k);
    k = j;
    if (this.mSizePerSpan == m) {
      return;
    }
    while (k < i)
    {
      localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.mFullSpan) {
        if ((isLayoutRTL()) && (this.mOrientation == 1))
        {
          n = this.mSpanCount;
          j = localLayoutParams.mSpan.mIndex;
          localView.offsetLeftAndRight(-(n - 1 - j) * this.mSizePerSpan - -(n - 1 - j) * m);
        }
        else
        {
          n = localLayoutParams.mSpan.mIndex;
          j = this.mSizePerSpan * n;
          n *= m;
          if (this.mOrientation == 1) {
            localView.offsetLeftAndRight(j - n);
          } else {
            localView.offsetTopAndBottom(j - n);
          }
        }
      }
      k++;
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    if ((this.mOrientation != 1) && (isLayoutRTL())) {
      this.mShouldReverseLayout = (this.mReverseLayout ^ true);
    } else {
      this.mShouldReverseLayout = this.mReverseLayout;
    }
  }
  
  private void setLayoutStateDirection(int paramInt)
  {
    LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mLayoutDirection = paramInt;
    boolean bool1 = this.mShouldReverseLayout;
    int i = 1;
    boolean bool2;
    if (paramInt == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (bool1 == bool2) {
      paramInt = i;
    } else {
      paramInt = -1;
    }
    localLayoutState.mItemDirection = paramInt;
  }
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    for (int i = 0; i < this.mSpanCount; i++) {
      if (!this.mSpans[i].mViews.isEmpty()) {
        updateRemainingSpans(this.mSpans[i], paramInt1, paramInt2);
      }
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    int i;
    if (this.mLastLayoutFromEnd) {
      i = findLastReferenceChildPosition(paramState.getItemCount());
    } else {
      i = findFirstReferenceChildPosition(paramState.getItemCount());
    }
    paramAnchorInfo.mPosition = i;
    paramAnchorInfo.mOffset = Integer.MIN_VALUE;
    return true;
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.State paramState)
  {
    LayoutState localLayoutState = this.mLayoutState;
    boolean bool1 = false;
    localLayoutState.mAvailable = 0;
    localLayoutState.mCurrentPosition = paramInt;
    if (isSmoothScrolling())
    {
      i = paramState.getTargetScrollPosition();
      if (i != -1)
      {
        boolean bool2 = this.mShouldReverseLayout;
        if (i < paramInt) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        if (bool2 == bool3)
        {
          paramInt = this.mPrimaryOrientation.getTotalSpace();
          break label92;
        }
        i = this.mPrimaryOrientation.getTotalSpace();
        paramInt = 0;
        break label95;
      }
    }
    paramInt = 0;
    label92:
    int i = 0;
    label95:
    if (getClipToPadding())
    {
      this.mLayoutState.mStartLine = (this.mPrimaryOrientation.getStartAfterPadding() - i);
      this.mLayoutState.mEndLine = (this.mPrimaryOrientation.getEndAfterPadding() + paramInt);
    }
    else
    {
      this.mLayoutState.mEndLine = (this.mPrimaryOrientation.getEnd() + paramInt);
      this.mLayoutState.mStartLine = (-i);
    }
    paramState = this.mLayoutState;
    paramState.mStopInFocusable = false;
    paramState.mRecycle = true;
    boolean bool3 = bool1;
    if (this.mPrimaryOrientation.getMode() == 0)
    {
      bool3 = bool1;
      if (this.mPrimaryOrientation.getEnd() == 0) {
        bool3 = true;
      }
    }
    paramState.mInfinite = bool3;
  }
  
  private void updateRemainingSpans(Span paramSpan, int paramInt1, int paramInt2)
  {
    int i = paramSpan.getDeletedSize();
    if (paramInt1 == -1)
    {
      if (paramSpan.getStartLine() + i <= paramInt2) {
        this.mRemainingSpans.set(paramSpan.mIndex, false);
      }
    }
    else if (paramSpan.getEndLine() - i >= paramInt2) {
      this.mRemainingSpans.set(paramSpan.mIndex, false);
    }
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i != Integer.MIN_VALUE) && (i != 1073741824)) {
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  boolean areAllEndsEqual()
  {
    int i = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
    for (int j = 1; j < this.mSpanCount; j++) {
      if (this.mSpans[j].getEndLine(Integer.MIN_VALUE) != i) {
        return false;
      }
    }
    return true;
  }
  
  boolean areAllStartsEqual()
  {
    int i = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
    for (int j = 1; j < this.mSpanCount; j++) {
      if (this.mSpans[j].getStartLine(Integer.MIN_VALUE) != i) {
        return false;
      }
    }
    return true;
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    boolean bool;
    if (this.mOrientation == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean canScrollVertically()
  {
    int i = this.mOrientation;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  boolean checkForGaps()
  {
    if ((getChildCount() != 0) && (this.mGapStrategy != 0) && (isAttachedToWindow()))
    {
      int i;
      int j;
      if (this.mShouldReverseLayout)
      {
        i = getLastChildPosition();
        j = getFirstChildPosition();
      }
      else
      {
        i = getFirstChildPosition();
        j = getLastChildPosition();
      }
      if ((i == 0) && (hasGapsToFix() != null))
      {
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
      }
      if (!this.mLaidOutInvalidFullSpan) {
        return false;
      }
      int k;
      if (this.mShouldReverseLayout) {
        k = -1;
      } else {
        k = 1;
      }
      Object localObject = this.mLazySpanLookup;
      j++;
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = ((LazySpanLookup)localObject).getFirstFullSpanItemInRange(i, j, k, true);
      if (localFullSpanItem == null)
      {
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(j);
        return false;
      }
      localObject = this.mLazySpanLookup.getFirstFullSpanItemInRange(i, localFullSpanItem.mPosition, k * -1, true);
      if (localObject == null) {
        this.mLazySpanLookup.forceInvalidateAfter(localFullSpanItem.mPosition);
      } else {
        this.mLazySpanLookup.forceInvalidateAfter(((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition + 1);
      }
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
    }
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation != 0) {
      paramInt1 = paramInt2;
    }
    if ((getChildCount() != 0) && (paramInt1 != 0))
    {
      prepareLayoutStateForDelta(paramInt1, paramState);
      Object localObject = this.mPrefetchDistances;
      if ((localObject == null) || (localObject.length < this.mSpanCount)) {
        this.mPrefetchDistances = new int[this.mSpanCount];
      }
      int i = 0;
      paramInt2 = 0;
      int k;
      for (paramInt1 = 0; paramInt2 < this.mSpanCount; paramInt1 = k)
      {
        localObject = this.mLayoutState;
        int j;
        if (((LayoutState)localObject).mItemDirection == -1)
        {
          j = ((LayoutState)localObject).mStartLine;
          k = this.mSpans[paramInt2].getStartLine(j);
        }
        else
        {
          j = this.mSpans[paramInt2].getEndLine(((LayoutState)localObject).mEndLine);
          k = this.mLayoutState.mEndLine;
        }
        j -= k;
        k = paramInt1;
        if (j >= 0)
        {
          this.mPrefetchDistances[paramInt1] = j;
          k = paramInt1 + 1;
        }
        paramInt2++;
      }
      Arrays.sort(this.mPrefetchDistances, 0, paramInt1);
      for (paramInt2 = i; (paramInt2 < paramInt1) && (this.mLayoutState.hasMore(paramState)); paramInt2++)
      {
        paramLayoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[paramInt2]);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mCurrentPosition += ((LayoutState)localObject).mItemDirection;
      }
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    paramInt = calculateScrollDirectionForPosition(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.mOrientation == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
    }
    else
    {
      localPointF.x = 0.0F;
      localPointF.y = paramInt;
    }
    return localPointF;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label53;
      }
    }
    for (int i = 0; i < this.mSpanCount; i++) {
      paramArrayOfInt[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
    }
    return paramArrayOfInt;
    label53:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean)
  {
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = getChildCount() - 1;
    Object localObject2;
    for (Object localObject1 = null; k >= 0; localObject1 = localObject2)
    {
      View localView = getChildAt(k);
      int m = this.mPrimaryOrientation.getDecoratedStart(localView);
      int n = this.mPrimaryOrientation.getDecoratedEnd(localView);
      localObject2 = localObject1;
      if (n > i) {
        if (m >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n > j) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      k--;
    }
    return (View)localObject1;
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean)
  {
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = getChildCount();
    Object localObject1 = null;
    int m = 0;
    while (m < k)
    {
      View localView = getChildAt(m);
      int n = this.mPrimaryOrientation.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (this.mPrimaryOrientation.getDecoratedEnd(localView) > i) {
        if (n >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n < i) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      m++;
      localObject1 = localObject2;
    }
    return (View)localObject1;
  }
  
  int findFirstVisibleItemPositionInt()
  {
    View localView;
    if (this.mShouldReverseLayout) {
      localView = findFirstVisibleItemClosestToEnd(true);
    } else {
      localView = findFirstVisibleItemClosestToStart(true);
    }
    int i;
    if (localView == null) {
      i = -1;
    } else {
      i = getPosition(localView);
    }
    return i;
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label53;
      }
    }
    for (int i = 0; i < this.mSpanCount; i++) {
      paramArrayOfInt[i] = this.mSpans[i].findFirstVisibleItemPosition();
    }
    return paramArrayOfInt;
    label53:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label53;
      }
    }
    for (int i = 0; i < this.mSpanCount; i++) {
      paramArrayOfInt[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
    }
    return paramArrayOfInt;
    label53:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label53;
      }
    }
    for (int i = 0; i < this.mSpanCount; i++) {
      paramArrayOfInt[i] = this.mSpans[i].findLastVisibleItemPosition();
    }
    return paramArrayOfInt;
    label53:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  int getFirstChildPosition()
  {
    int i = getChildCount();
    int j = 0;
    if (i != 0) {
      j = getPosition(getChildAt(0));
    }
    return j;
  }
  
  public int getGapStrategy()
  {
    return this.mGapStrategy;
  }
  
  int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {
      i = 0;
    } else {
      i = getPosition(getChildAt(i - 1));
    }
    return i;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  View hasGapsToFix()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.mSpanCount);
    localBitSet.set(0, this.mSpanCount, true);
    int j = this.mOrientation;
    int k = -1;
    if ((j == 1) && (isLayoutRTL())) {
      j = 1;
    } else {
      j = -1;
    }
    int m;
    if (this.mShouldReverseLayout)
    {
      m = -1;
    }
    else
    {
      m = i + 1;
      i = 0;
    }
    int n = i;
    if (i < m)
    {
      k = 1;
      n = i;
    }
    while (n != m)
    {
      View localView = getChildAt(n);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localBitSet.get(localLayoutParams.mSpan.mIndex))
      {
        if (checkSpanForGap(localLayoutParams.mSpan)) {
          return localView;
        }
        localBitSet.clear(localLayoutParams.mSpan.mIndex);
      }
      if (!localLayoutParams.mFullSpan)
      {
        i = n + k;
        if (i != m)
        {
          Object localObject = getChildAt(i);
          int i1;
          if (this.mShouldReverseLayout)
          {
            i = this.mPrimaryOrientation.getDecoratedEnd(localView);
            i1 = this.mPrimaryOrientation.getDecoratedEnd((View)localObject);
            if (i < i1) {
              return localView;
            }
            if (i != i1) {
              break label275;
            }
          }
          else
          {
            i = this.mPrimaryOrientation.getDecoratedStart(localView);
            i1 = this.mPrimaryOrientation.getDecoratedStart((View)localObject);
            if (i > i1) {
              return localView;
            }
            if (i != i1) {
              break label275;
            }
          }
          i = 1;
          break label277;
          label275:
          i = 0;
          label277:
          if (i != 0)
          {
            localObject = (LayoutParams)((View)localObject).getLayoutParams();
            if (localLayoutParams.mSpan.mIndex - ((LayoutParams)localObject).mSpan.mIndex < 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i != i1) {
              return localView;
            }
          }
        }
      }
      n += k;
    }
    return null;
  }
  
  public void invalidateSpanAssignments()
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public boolean isAutoMeasureEnabled()
  {
    boolean bool;
    if (this.mGapStrategy != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isLayoutRTL()
  {
    int i = getLayoutDirection();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].onOffset(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].onOffset(paramInt);
    }
  }
  
  public void onAdapterChanged(@Nullable RecyclerView.Adapter paramAdapter1, @Nullable RecyclerView.Adapter paramAdapter2)
  {
    this.mLazySpanLookup.clear();
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].clear();
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    removeCallbacks(this.mCheckForGapsRunnable);
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].clear();
    }
    paramRecyclerView.requestLayout();
  }
  
  @Nullable
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    resolveShouldLayoutReverse();
    int i = convertFocusDirectionToLayoutDirection(paramInt);
    if (i == Integer.MIN_VALUE) {
      return null;
    }
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = ((LayoutParams)localObject).mFullSpan;
    localObject = ((LayoutParams)localObject).mSpan;
    if (i == 1) {
      paramInt = getLastChildPosition();
    } else {
      paramInt = getFirstChildPosition();
    }
    updateLayoutState(paramInt, paramState);
    setLayoutStateDirection(i);
    LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mCurrentPosition = (localLayoutState.mItemDirection + paramInt);
    localLayoutState.mAvailable = ((int)(this.mPrimaryOrientation.getTotalSpace() * 0.33333334F));
    localLayoutState = this.mLayoutState;
    localLayoutState.mStopInFocusable = true;
    int j = 0;
    localLayoutState.mRecycle = false;
    fill(paramRecycler, localLayoutState, paramState);
    this.mLastLayoutFromEnd = this.mShouldReverseLayout;
    if (!bool1)
    {
      paramRecycler = ((Span)localObject).getFocusableViewAfter(paramInt, i);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
    }
    if (preferLastSpan(i)) {
      for (k = this.mSpanCount - 1; k >= 0; k--)
      {
        paramRecycler = this.mSpans[k].getFocusableViewAfter(paramInt, i);
        if ((paramRecycler != null) && (paramRecycler != paramView)) {
          return paramRecycler;
        }
      }
    }
    for (int k = 0; k < this.mSpanCount; k++)
    {
      paramRecycler = this.mSpans[k].getFocusableViewAfter(paramInt, i);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
    }
    boolean bool2 = this.mReverseLayout;
    if (i == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((bool2 ^ true) == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (!bool1)
    {
      if (paramInt != 0) {
        k = ((Span)localObject).findFirstPartiallyVisibleItemPosition();
      } else {
        k = ((Span)localObject).findLastPartiallyVisibleItemPosition();
      }
      paramRecycler = findViewByPosition(k);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
    }
    k = j;
    if (preferLastSpan(i)) {
      for (k = this.mSpanCount - 1; k >= 0; k--) {
        if (k != ((Span)localObject).mIndex)
        {
          if (paramInt != 0) {
            j = this.mSpans[k].findFirstPartiallyVisibleItemPosition();
          } else {
            j = this.mSpans[k].findLastPartiallyVisibleItemPosition();
          }
          paramRecycler = findViewByPosition(j);
          if ((paramRecycler != null) && (paramRecycler != paramView)) {
            return paramRecycler;
          }
        }
      }
    }
    while (k < this.mSpanCount)
    {
      if (paramInt != 0) {
        j = this.mSpans[k].findFirstPartiallyVisibleItemPosition();
      } else {
        j = this.mSpans[k].findLastPartiallyVisibleItemPosition();
      }
      paramRecycler = findViewByPosition(j);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
      k++;
    }
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      View localView1 = findFirstVisibleItemClosestToStart(false);
      View localView2 = findFirstVisibleItemClosestToEnd(false);
      if ((localView1 != null) && (localView2 != null))
      {
        int i = getPosition(localView1);
        int j = getPosition(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
        }
        else
        {
          paramAccessibilityEvent.setFromIndex(j);
          paramAccessibilityEvent.setToIndex(i);
        }
      }
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    onLayoutChildren(paramRecycler, paramState, true);
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    this.mPendingSavedState = null;
    this.mAnchorInfo.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      this.mPendingSavedState = paramParcelable;
      if (this.mPendingScrollPosition != -1)
      {
        paramParcelable.invalidateAnchorPositionInfo();
        this.mPendingSavedState.invalidateSpanInfo();
      }
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null) {
      return new SavedState(this.mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.mReverseLayout = this.mReverseLayout;
    localSavedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
    localSavedState.mLastLayoutRTL = this.mLastLayoutRTL;
    LazySpanLookup localLazySpanLookup = this.mLazySpanLookup;
    int i = 0;
    if (localLazySpanLookup != null)
    {
      int[] arrayOfInt = localLazySpanLookup.mData;
      if (arrayOfInt != null)
      {
        localSavedState.mSpanLookup = arrayOfInt;
        localSavedState.mSpanLookupSize = arrayOfInt.length;
        localSavedState.mFullSpanItems = localLazySpanLookup.mFullSpanItems;
        break label102;
      }
    }
    localSavedState.mSpanLookupSize = 0;
    label102:
    if (getChildCount() > 0)
    {
      if (this.mLastLayoutFromEnd) {
        j = getLastChildPosition();
      } else {
        j = getFirstChildPosition();
      }
      localSavedState.mAnchorPosition = j;
      localSavedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
      int j = this.mSpanCount;
      localSavedState.mSpanOffsetsSize = j;
      localSavedState.mSpanOffsets = new int[j];
      while (i < this.mSpanCount)
      {
        int k;
        if (this.mLastLayoutFromEnd)
        {
          k = this.mSpans[i].getEndLine(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label256;
          }
          j = this.mPrimaryOrientation.getEndAfterPadding();
        }
        else
        {
          k = this.mSpans[i].getStartLine(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label256;
          }
          j = this.mPrimaryOrientation.getStartAfterPadding();
        }
        j = k - j;
        label256:
        localSavedState.mSpanOffsets[i] = j;
        i++;
      }
    }
    localSavedState.mAnchorPosition = -1;
    localSavedState.mVisibleAnchorPosition = -1;
    localSavedState.mSpanOffsetsSize = 0;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  void prepareLayoutStateForDelta(int paramInt, RecyclerView.State paramState)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = getLastChildPosition();
      j = 1;
    }
    else
    {
      i = getFirstChildPosition();
      j = -1;
    }
    this.mLayoutState.mRecycle = true;
    updateLayoutState(i, paramState);
    setLayoutStateDirection(j);
    paramState = this.mLayoutState;
    paramState.mCurrentPosition = (i + paramState.mItemDirection);
    paramState.mAvailable = Math.abs(paramInt);
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() != 0) && (paramInt != 0))
    {
      prepareLayoutStateForDelta(paramInt, paramState);
      int i = fill(paramRecycler, this.mLayoutState, paramState);
      if (this.mLayoutState.mAvailable >= i) {
        if (paramInt < 0) {
          paramInt = -i;
        } else {
          paramInt = i;
        }
      }
      this.mPrimaryOrientation.offsetChildren(-paramInt);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      paramState = this.mLayoutState;
      paramState.mAvailable = 0;
      recycle(paramRecycler, paramState);
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mAnchorPosition != paramInt)) {
      localSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mGapStrategy) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 2)) {
      throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }
    this.mGapStrategy = paramInt;
    requestLayout();
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      paramInt2 = RecyclerView.LayoutManager.chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      i = RecyclerView.LayoutManager.chooseSize(paramInt1, this.mSizePerSpan * this.mSpanCount + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = RecyclerView.LayoutManager.chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      i = RecyclerView.LayoutManager.chooseSize(paramInt2, this.mSizePerSpan * this.mSpanCount + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    this.mPrimaryOrientation = this.mSecondaryOrientation;
    this.mSecondaryOrientation = localOrientationHelper;
    requestLayout();
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mReverseLayout != paramBoolean)) {
      localSavedState.mReverseLayout = paramBoolean;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.mSpanCount)
    {
      invalidateSpanAssignments();
      this.mSpanCount = paramInt;
      this.mRemainingSpans = new BitSet(this.mSpanCount);
      this.mSpans = new Span[this.mSpanCount];
      for (paramInt = 0; paramInt < this.mSpanCount; paramInt++) {
        this.mSpans[paramInt] = new Span(paramInt);
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    boolean bool;
    if (this.mPendingSavedState == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    boolean bool1 = paramState.isPreLayout();
    boolean bool2 = false;
    if (!bool1)
    {
      int i = this.mPendingScrollPosition;
      if (i != -1)
      {
        if ((i >= 0) && (i < paramState.getItemCount()))
        {
          paramState = this.mPendingSavedState;
          if ((paramState != null) && (paramState.mAnchorPosition != -1) && (paramState.mSpanOffsetsSize >= 1))
          {
            paramAnchorInfo.mOffset = Integer.MIN_VALUE;
            paramAnchorInfo.mPosition = this.mPendingScrollPosition;
          }
          else
          {
            paramState = findViewByPosition(this.mPendingScrollPosition);
            if (paramState != null)
            {
              if (this.mShouldReverseLayout) {
                i = getLastChildPosition();
              } else {
                i = getFirstChildPosition();
              }
              paramAnchorInfo.mPosition = i;
              if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE)
              {
                if (paramAnchorInfo.mLayoutFromEnd) {
                  paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(paramState));
                } else {
                  paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(paramState));
                }
                return true;
              }
              if (this.mPrimaryOrientation.getDecoratedMeasurement(paramState) > this.mPrimaryOrientation.getTotalSpace())
              {
                if (paramAnchorInfo.mLayoutFromEnd) {
                  i = this.mPrimaryOrientation.getEndAfterPadding();
                } else {
                  i = this.mPrimaryOrientation.getStartAfterPadding();
                }
                paramAnchorInfo.mOffset = i;
                return true;
              }
              i = this.mPrimaryOrientation.getDecoratedStart(paramState) - this.mPrimaryOrientation.getStartAfterPadding();
              if (i < 0)
              {
                paramAnchorInfo.mOffset = (-i);
                return true;
              }
              i = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(paramState);
              if (i < 0)
              {
                paramAnchorInfo.mOffset = i;
                return true;
              }
              paramAnchorInfo.mOffset = Integer.MIN_VALUE;
            }
            else
            {
              int j = this.mPendingScrollPosition;
              paramAnchorInfo.mPosition = j;
              i = this.mPendingScrollPositionOffset;
              if (i == Integer.MIN_VALUE)
              {
                if (calculateScrollDirectionForPosition(j) == 1) {
                  bool2 = true;
                }
                paramAnchorInfo.mLayoutFromEnd = bool2;
                paramAnchorInfo.assignCoordinateFromPadding();
              }
              else
              {
                paramAnchorInfo.assignCoordinateFromPadding(i);
              }
              paramAnchorInfo.mInvalidateOffsets = true;
            }
          }
          return true;
        }
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      }
    }
    return false;
  }
  
  void updateAnchorInfoForLayout(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (updateAnchorFromChildren(paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    paramAnchorInfo.mPosition = 0;
  }
  
  void updateMeasureSpecs(int paramInt)
  {
    this.mSizePerSpan = (paramInt / this.mSpanCount);
    this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, this.mSecondaryOrientation.getMode());
  }
  
  class AnchorInfo
  {
    boolean mInvalidateOffsets;
    boolean mLayoutFromEnd;
    int mOffset;
    int mPosition;
    int[] mSpanReferenceLines;
    boolean mValid;
    
    AnchorInfo()
    {
      reset();
    }
    
    void assignCoordinateFromPadding()
    {
      int i;
      if (this.mLayoutFromEnd) {
        i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
      } else {
        i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
      }
      this.mOffset = i;
    }
    
    void assignCoordinateFromPadding(int paramInt)
    {
      if (this.mLayoutFromEnd) {
        this.mOffset = (StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - paramInt);
      } else {
        this.mOffset = (StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + paramInt);
      }
    }
    
    void reset()
    {
      this.mPosition = -1;
      this.mOffset = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mInvalidateOffsets = false;
      this.mValid = false;
      int[] arrayOfInt = this.mSpanReferenceLines;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
    }
    
    void saveSpanReferenceLines(StaggeredGridLayoutManager.Span[] paramArrayOfSpan)
    {
      int i = paramArrayOfSpan.length;
      int[] arrayOfInt = this.mSpanReferenceLines;
      if ((arrayOfInt == null) || (arrayOfInt.length < i)) {
        this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
      }
      for (int j = 0; j < i; j++) {
        this.mSpanReferenceLines[j] = paramArrayOfSpan[j].getStartLine(Integer.MIN_VALUE);
      }
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    boolean mFullSpan;
    StaggeredGridLayoutManager.Span mSpan;
    
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
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public final int getSpanIndex()
    {
      StaggeredGridLayoutManager.Span localSpan = this.mSpan;
      if (localSpan == null) {
        return -1;
      }
      return localSpan.mIndex;
    }
    
    public boolean isFullSpan()
    {
      return this.mFullSpan;
    }
    
    public void setFullSpan(boolean paramBoolean)
    {
      this.mFullSpan = paramBoolean;
    }
  }
  
  static class LazySpanLookup
  {
    private static final int MIN_SIZE = 10;
    int[] mData;
    List<FullSpanItem> mFullSpanItems;
    
    private int invalidateFullSpansAfter(int paramInt)
    {
      if (this.mFullSpanItems == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = getFullSpanItem(paramInt);
      if (localFullSpanItem != null) {
        this.mFullSpanItems.remove(localFullSpanItem);
      }
      int i = this.mFullSpanItems.size();
      for (int j = 0; j < i; j++) {
        if (((FullSpanItem)this.mFullSpanItems.get(j)).mPosition >= paramInt) {
          break label82;
        }
      }
      j = -1;
      label82:
      if (j != -1)
      {
        localFullSpanItem = (FullSpanItem)this.mFullSpanItems.get(j);
        this.mFullSpanItems.remove(j);
        return localFullSpanItem.mPosition;
      }
      return -1;
    }
    
    private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
    {
      Object localObject = this.mFullSpanItems;
      if (localObject == null) {
        return;
      }
      for (int i = ((List)localObject).size() - 1; i >= 0; i--)
      {
        localObject = (FullSpanItem)this.mFullSpanItems.get(i);
        int j = ((FullSpanItem)localObject).mPosition;
        if (j >= paramInt1) {
          ((FullSpanItem)localObject).mPosition = (j + paramInt2);
        }
      }
    }
    
    private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
    {
      Object localObject = this.mFullSpanItems;
      if (localObject == null) {
        return;
      }
      for (int i = ((List)localObject).size() - 1; i >= 0; i--)
      {
        localObject = (FullSpanItem)this.mFullSpanItems.get(i);
        int j = ((FullSpanItem)localObject).mPosition;
        if (j >= paramInt1) {
          if (j < paramInt1 + paramInt2) {
            this.mFullSpanItems.remove(i);
          } else {
            ((FullSpanItem)localObject).mPosition = (j - paramInt2);
          }
        }
      }
    }
    
    public void addFullSpanItem(FullSpanItem paramFullSpanItem)
    {
      if (this.mFullSpanItems == null) {
        this.mFullSpanItems = new ArrayList();
      }
      int i = this.mFullSpanItems.size();
      for (int j = 0; j < i; j++)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.mFullSpanItems.get(j);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.mFullSpanItems.remove(j);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.mFullSpanItems.add(j, paramFullSpanItem);
          return;
        }
      }
      this.mFullSpanItems.add(paramFullSpanItem);
    }
    
    void clear()
    {
      int[] arrayOfInt = this.mData;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      this.mFullSpanItems = null;
    }
    
    void ensureSize(int paramInt)
    {
      int[] arrayOfInt1 = this.mData;
      if (arrayOfInt1 == null)
      {
        arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
        this.mData = arrayOfInt1;
        Arrays.fill(arrayOfInt1, -1);
      }
      else if (paramInt >= arrayOfInt1.length)
      {
        int[] arrayOfInt2 = new int[sizeForPosition(paramInt)];
        this.mData = arrayOfInt2;
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        arrayOfInt2 = this.mData;
        Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
      }
    }
    
    int forceInvalidateAfter(int paramInt)
    {
      List localList = this.mFullSpanItems;
      if (localList != null) {
        for (int i = localList.size() - 1; i >= 0; i--) {
          if (((FullSpanItem)this.mFullSpanItems.get(i)).mPosition >= paramInt) {
            this.mFullSpanItems.remove(i);
          }
        }
      }
      return invalidateAfter(paramInt);
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject = this.mFullSpanItems;
      if (localObject == null) {
        return null;
      }
      int i = ((List)localObject).size();
      for (int j = 0; j < i; j++)
      {
        localObject = (FullSpanItem)this.mFullSpanItems.get(j);
        int k = ((FullSpanItem)localObject).mPosition;
        if (k >= paramInt2) {
          return null;
        }
        if ((k >= paramInt1) && ((paramInt3 == 0) || (((FullSpanItem)localObject).mGapDir == paramInt3) || ((paramBoolean) && (((FullSpanItem)localObject).mHasUnwantedGapAfter)))) {
          return (FullSpanItem)localObject;
        }
      }
      return null;
    }
    
    public FullSpanItem getFullSpanItem(int paramInt)
    {
      Object localObject = this.mFullSpanItems;
      if (localObject == null) {
        return null;
      }
      for (int i = ((List)localObject).size() - 1; i >= 0; i--)
      {
        localObject = (FullSpanItem)this.mFullSpanItems.get(i);
        if (((FullSpanItem)localObject).mPosition == paramInt) {
          return (FullSpanItem)localObject;
        }
      }
      return null;
    }
    
    int getSpan(int paramInt)
    {
      int[] arrayOfInt = this.mData;
      if ((arrayOfInt != null) && (paramInt < arrayOfInt.length)) {
        return arrayOfInt[paramInt];
      }
      return -1;
    }
    
    int invalidateAfter(int paramInt)
    {
      int[] arrayOfInt = this.mData;
      if (arrayOfInt == null) {
        return -1;
      }
      if (paramInt >= arrayOfInt.length) {
        return -1;
      }
      int i = invalidateFullSpansAfter(paramInt);
      if (i == -1)
      {
        arrayOfInt = this.mData;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return this.mData.length;
      }
      i = Math.min(i + 1, this.mData.length);
      Arrays.fill(this.mData, paramInt, i, -1);
      return i;
    }
    
    void offsetForAddition(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = this.mData;
      if ((arrayOfInt != null) && (paramInt1 < arrayOfInt.length))
      {
        int i = paramInt1 + paramInt2;
        ensureSize(i);
        arrayOfInt = this.mData;
        System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, i, arrayOfInt.length - paramInt1 - paramInt2);
        Arrays.fill(this.mData, paramInt1, i, -1);
        offsetFullSpansForAddition(paramInt1, paramInt2);
      }
    }
    
    void offsetForRemoval(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = this.mData;
      if ((arrayOfInt != null) && (paramInt1 < arrayOfInt.length))
      {
        int i = paramInt1 + paramInt2;
        ensureSize(i);
        arrayOfInt = this.mData;
        System.arraycopy(arrayOfInt, i, arrayOfInt, paramInt1, arrayOfInt.length - paramInt1 - paramInt2);
        arrayOfInt = this.mData;
        Arrays.fill(arrayOfInt, arrayOfInt.length - paramInt2, arrayOfInt.length, -1);
        offsetFullSpansForRemoval(paramInt1, paramInt2);
      }
    }
    
    void setSpan(int paramInt, StaggeredGridLayoutManager.Span paramSpan)
    {
      ensureSize(paramInt);
      this.mData[paramInt] = paramSpan.mIndex;
    }
    
    int sizeForPosition(int paramInt)
    {
      int i = this.mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    @SuppressLint({"BanParcelableUsage"})
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator()
      {
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel paramAnonymousParcel)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(paramAnonymousParcel);
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int paramAnonymousInt)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[paramAnonymousInt];
        }
      };
      int mGapDir;
      int[] mGapPerSpan;
      boolean mHasUnwantedGapAfter;
      int mPosition;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.mPosition = paramParcel.readInt();
        this.mGapDir = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.mHasUnwantedGapAfter = bool;
        i = paramParcel.readInt();
        if (i > 0)
        {
          int[] arrayOfInt = new int[i];
          this.mGapPerSpan = arrayOfInt;
          paramParcel.readIntArray(arrayOfInt);
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      int getGapForSpan(int paramInt)
      {
        int[] arrayOfInt = this.mGapPerSpan;
        if (arrayOfInt == null) {
          paramInt = 0;
        } else {
          paramInt = arrayOfInt[paramInt];
        }
        return paramInt;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FullSpanItem{mPosition=");
        localStringBuilder.append(this.mPosition);
        localStringBuilder.append(", mGapDir=");
        localStringBuilder.append(this.mGapDir);
        localStringBuilder.append(", mHasUnwantedGapAfter=");
        localStringBuilder.append(this.mHasUnwantedGapAfter);
        localStringBuilder.append(", mGapPerSpan=");
        localStringBuilder.append(Arrays.toString(this.mGapPerSpan));
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mGapDir);
        paramParcel.writeInt(this.mHasUnwantedGapAfter);
        int[] arrayOfInt = this.mGapPerSpan;
        if ((arrayOfInt != null) && (arrayOfInt.length > 0))
        {
          paramParcel.writeInt(arrayOfInt.length);
          paramParcel.writeIntArray(this.mGapPerSpan);
        }
        else
        {
          paramParcel.writeInt(0);
        }
      }
    }
  }
  
  @SuppressLint({"BanParcelableUsage"})
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridLayoutManager.SavedState(paramAnonymousParcel);
      }
      
      public StaggeredGridLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new StaggeredGridLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mVisibleAnchorPosition = paramParcel.readInt();
      int i = paramParcel.readInt();
      this.mSpanOffsetsSize = i;
      int[] arrayOfInt;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        this.mSpanOffsets = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      this.mSpanLookupSize = i;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        this.mSpanLookup = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      boolean bool1 = false;
      if (i == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.mReverseLayout = bool2;
      if (paramParcel.readInt() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.mAnchorLayoutFromEnd = bool2;
      boolean bool2 = bool1;
      if (paramParcel.readInt() == 1) {
        bool2 = true;
      }
      this.mLastLayoutRTL = bool2;
      this.mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.mSpanOffsetsSize = paramSavedState.mSpanOffsetsSize;
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mVisibleAnchorPosition = paramSavedState.mVisibleAnchorPosition;
      this.mSpanOffsets = paramSavedState.mSpanOffsets;
      this.mSpanLookupSize = paramSavedState.mSpanLookupSize;
      this.mSpanLookup = paramSavedState.mSpanLookup;
      this.mReverseLayout = paramSavedState.mReverseLayout;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
      this.mLastLayoutRTL = paramSavedState.mLastLayoutRTL;
      this.mFullSpanItems = paramSavedState.mFullSpanItems;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    void invalidateAnchorPositionInfo()
    {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mAnchorPosition = -1;
      this.mVisibleAnchorPosition = -1;
    }
    
    void invalidateSpanInfo()
    {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mSpanLookupSize = 0;
      this.mSpanLookup = null;
      this.mFullSpanItems = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mVisibleAnchorPosition);
      paramParcel.writeInt(this.mSpanOffsetsSize);
      if (this.mSpanOffsetsSize > 0) {
        paramParcel.writeIntArray(this.mSpanOffsets);
      }
      paramParcel.writeInt(this.mSpanLookupSize);
      if (this.mSpanLookupSize > 0) {
        paramParcel.writeIntArray(this.mSpanLookup);
      }
      paramParcel.writeInt(this.mReverseLayout);
      paramParcel.writeInt(this.mAnchorLayoutFromEnd);
      paramParcel.writeInt(this.mLastLayoutRTL);
      paramParcel.writeList(this.mFullSpanItems);
    }
  }
  
  class Span
  {
    static final int INVALID_LINE = Integer.MIN_VALUE;
    int mCachedEnd = Integer.MIN_VALUE;
    int mCachedStart = Integer.MIN_VALUE;
    int mDeletedSize = 0;
    final int mIndex;
    ArrayList<View> mViews = new ArrayList();
    
    Span(int paramInt)
    {
      this.mIndex = paramInt;
    }
    
    void appendToSpan(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
      localLayoutParams.mSpan = this;
      this.mViews.add(paramView);
      this.mCachedEnd = Integer.MIN_VALUE;
      if (this.mViews.size() == 1) {
        this.mCachedStart = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    void cacheReferenceLineAndClear(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean) {
        i = getEndLine(Integer.MIN_VALUE);
      } else {
        i = getStartLine(Integer.MIN_VALUE);
      }
      clear();
      if (i == Integer.MIN_VALUE) {
        return;
      }
      if (((paramBoolean) && (i < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding())) || ((!paramBoolean) && (i > StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()))) {
        return;
      }
      int j = i;
      if (paramInt != Integer.MIN_VALUE) {
        j = i + paramInt;
      }
      this.mCachedEnd = j;
      this.mCachedStart = j;
    }
    
    void calculateCachedEnd()
    {
      Object localObject = this.mViews;
      localObject = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
      this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd((View)localObject);
      if (localLayoutParams.mFullSpan)
      {
        localObject = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == 1)) {
          this.mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(this.mIndex);
        }
      }
    }
    
    void calculateCachedStart()
    {
      Object localObject = (View)this.mViews.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
      this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart((View)localObject);
      if (localLayoutParams.mFullSpan)
      {
        localObject = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == -1)) {
          this.mCachedStart -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(this.mIndex);
        }
      }
    }
    
    void clear()
    {
      this.mViews.clear();
      invalidateCache();
      this.mDeletedSize = 0;
    }
    
    public int findFirstCompletelyVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, true);
      } else {
        i = findOneVisibleChild(0, this.mViews.size(), true);
      }
      return i;
    }
    
    public int findFirstPartiallyVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
      } else {
        i = findOnePartiallyVisibleChild(0, this.mViews.size(), true);
      }
      return i;
    }
    
    public int findFirstVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, false);
      } else {
        i = findOneVisibleChild(0, this.mViews.size(), false);
      }
      return i;
    }
    
    public int findLastCompletelyVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(0, this.mViews.size(), true);
      } else {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, true);
      }
      return i;
    }
    
    public int findLastPartiallyVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOnePartiallyVisibleChild(0, this.mViews.size(), true);
      } else {
        i = findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
      }
      return i;
    }
    
    public int findLastVisibleItemPosition()
    {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(0, this.mViews.size(), false);
      } else {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, false);
      }
      return i;
    }
    
    int findOnePartiallyOrCompletelyVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
      int j = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
      int k;
      if (paramInt2 > paramInt1) {
        k = 1;
      } else {
        k = -1;
      }
      while (paramInt1 != paramInt2)
      {
        View localView = (View)this.mViews.get(paramInt1);
        int m = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(localView);
        int n = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(localView);
        int i1 = 0;
        int i2;
        if (paramBoolean3 ? m <= j : m < j) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (paramBoolean3 ? n >= i : n > i) {
          i1 = 1;
        }
        if ((i2 != 0) && (i1 != 0)) {
          if ((paramBoolean1) && (paramBoolean2))
          {
            if ((m >= i) && (n <= j)) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
          }
          else
          {
            if (paramBoolean2) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
            if ((m < i) || (n > j)) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
          }
        }
        paramInt1 += k;
      }
      return -1;
    }
    
    int findOnePartiallyVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return findOnePartiallyOrCompletelyVisibleChild(paramInt1, paramInt2, false, false, paramBoolean);
    }
    
    int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return findOnePartiallyOrCompletelyVisibleChild(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    public int getDeletedSize()
    {
      return this.mDeletedSize;
    }
    
    int getEndLine()
    {
      int i = this.mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      calculateCachedEnd();
      return this.mCachedEnd;
    }
    
    int getEndLine(int paramInt)
    {
      int i = this.mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (this.mViews.size() == 0) {
        return paramInt;
      }
      calculateCachedEnd();
      return this.mCachedEnd;
    }
    
    public View getFocusableViewAfter(int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      View localView;
      StaggeredGridLayoutManager localStaggeredGridLayoutManager;
      if (paramInt2 == -1)
      {
        int i = this.mViews.size();
        paramInt2 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (paramInt2 >= i) {
            break;
          }
          localView = (View)this.mViews.get(paramInt2);
          localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
          if (localStaggeredGridLayoutManager.mReverseLayout)
          {
            localObject1 = localObject2;
            if (localStaggeredGridLayoutManager.getPosition(localView) <= paramInt1) {
              break;
            }
          }
          localObject1 = StaggeredGridLayoutManager.this;
          if ((!((StaggeredGridLayoutManager)localObject1).mReverseLayout) && (((RecyclerView.LayoutManager)localObject1).getPosition(localView) >= paramInt1))
          {
            localObject1 = localObject2;
            break;
          }
          localObject1 = localObject2;
          if (!localView.hasFocusable()) {
            break;
          }
          paramInt2++;
          localObject2 = localView;
        }
      }
      paramInt2 = this.mViews.size() - 1;
      for (localObject2 = localObject1;; localObject2 = localView)
      {
        localObject1 = localObject2;
        if (paramInt2 < 0) {
          break;
        }
        localView = (View)this.mViews.get(paramInt2);
        localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        if (localStaggeredGridLayoutManager.mReverseLayout)
        {
          localObject1 = localObject2;
          if (localStaggeredGridLayoutManager.getPosition(localView) >= paramInt1) {
            break;
          }
        }
        localObject1 = StaggeredGridLayoutManager.this;
        if ((!((StaggeredGridLayoutManager)localObject1).mReverseLayout) && (((RecyclerView.LayoutManager)localObject1).getPosition(localView) <= paramInt1))
        {
          localObject1 = localObject2;
          break;
        }
        localObject1 = localObject2;
        if (!localView.hasFocusable()) {
          break;
        }
        paramInt2--;
      }
      return (View)localObject1;
    }
    
    StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
    {
      return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    }
    
    int getStartLine()
    {
      int i = this.mCachedStart;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      calculateCachedStart();
      return this.mCachedStart;
    }
    
    int getStartLine(int paramInt)
    {
      int i = this.mCachedStart;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (this.mViews.size() == 0) {
        return paramInt;
      }
      calculateCachedStart();
      return this.mCachedStart;
    }
    
    void invalidateCache()
    {
      this.mCachedStart = Integer.MIN_VALUE;
      this.mCachedEnd = Integer.MIN_VALUE;
    }
    
    void onOffset(int paramInt)
    {
      int i = this.mCachedStart;
      if (i != Integer.MIN_VALUE) {
        this.mCachedStart = (i + paramInt);
      }
      i = this.mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        this.mCachedEnd = (i + paramInt);
      }
    }
    
    void popEnd()
    {
      int i = this.mViews.size();
      View localView = (View)this.mViews.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
      localLayoutParams.mSpan = null;
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      if (i == 1) {
        this.mCachedStart = Integer.MIN_VALUE;
      }
      this.mCachedEnd = Integer.MIN_VALUE;
    }
    
    void popStart()
    {
      View localView = (View)this.mViews.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
      localLayoutParams.mSpan = null;
      if (this.mViews.size() == 0) {
        this.mCachedEnd = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      this.mCachedStart = Integer.MIN_VALUE;
    }
    
    void prependToSpan(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
      localLayoutParams.mSpan = this;
      this.mViews.add(0, paramView);
      this.mCachedStart = Integer.MIN_VALUE;
      if (this.mViews.size() == 1) {
        this.mCachedEnd = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    void setLine(int paramInt)
    {
      this.mCachedStart = paramInt;
      this.mCachedEnd = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */