package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider
{
  static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = Integer.MIN_VALUE;
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final AnchorInfo mAnchorInfo = new AnchorInfo();
  private int mInitialPrefetchItemCount = 2;
  private boolean mLastStackFromEnd;
  private final LayoutChunkResult mLayoutChunkResult = new LayoutChunkResult();
  private LayoutState mLayoutState;
  int mOrientation = 1;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private boolean mRecycleChildrenOnDetach;
  private int[] mReusableIntPair = new int[2];
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.LayoutManager.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setReverseLayout(paramContext.reverseLayout);
    setStackFromEnd(paramContext.stackFromEnd);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollExtent(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollOffset(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollRange(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private View findFirstPartiallyOrCompletelyInvisibleChild()
  {
    return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
  }
  
  private View findLastPartiallyOrCompletelyInvisibleChild()
  {
    return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToEnd()
  {
    View localView;
    if (this.mShouldReverseLayout) {
      localView = findFirstPartiallyOrCompletelyInvisibleChild();
    } else {
      localView = findLastPartiallyOrCompletelyInvisibleChild();
    }
    return localView;
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToStart()
  {
    View localView;
    if (this.mShouldReverseLayout) {
      localView = findLastPartiallyOrCompletelyInvisibleChild();
    } else {
      localView = findFirstPartiallyOrCompletelyInvisibleChild();
    }
    return localView;
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      i = -scrollBy(-i, paramRecycler, paramState);
      if (paramBoolean)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + i);
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(paramInt);
          return paramInt + i;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      int j = -scrollBy(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.mOrientationHelper.getStartAfterPadding();
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View getChildClosestToEnd()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  private View getChildClosestToStart()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((paramState.willRunPredictiveAnimations()) && (getChildCount() != 0) && (!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
    {
      Object localObject = paramRecycler.getScrapList();
      int i = ((List)localObject).size();
      int j = getPosition(getChildAt(0));
      int k = 0;
      int m = 0;
      int n = 0;
      while (k < i)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((List)localObject).get(k);
        if (!localViewHolder.isRemoved())
        {
          int i1 = localViewHolder.getLayoutPosition();
          int i2 = 1;
          int i3;
          if (i1 < j) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != this.mShouldReverseLayout) {
            i2 = -1;
          }
          if (i2 == -1) {
            m += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          } else {
            n += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          }
        }
        k++;
      }
      this.mLayoutState.mScrapList = ((List)localObject);
      if (m > 0)
      {
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mExtraFillSpace = m;
        ((LayoutState)localObject).mAvailable = 0;
        ((LayoutState)localObject).assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      if (n > 0)
      {
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mExtraFillSpace = n;
        ((LayoutState)localObject).mAvailable = 0;
        ((LayoutState)localObject).assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      this.mLayoutState.mScrapList = null;
    }
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item ");
      localStringBuilder.append(getPosition(localView));
      localStringBuilder.append(", coord:");
      localStringBuilder.append(this.mOrientationHelper.getDecoratedStart(localView));
      Log.d("LinearLayoutManager", localStringBuilder.toString());
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if ((paramLayoutState.mRecycle) && (!paramLayoutState.mInfinite))
    {
      int i = paramLayoutState.mScrollingOffset;
      int j = paramLayoutState.mNoRecycleSpace;
      if (paramLayoutState.mLayoutDirection == -1) {
        recycleViewsFromEnd(paramRecycler, i, j);
      } else {
        recycleViewsFromStart(paramRecycler, i, j);
      }
    }
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2--;
      while (paramInt2 >= paramInt1)
      {
        removeAndRecycleViewAt(paramInt2, paramRecycler);
        paramInt2--;
      }
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramRecycler);
      i--;
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (paramInt1 < 0) {
      return;
    }
    int j = this.mOrientationHelper.getEnd() - paramInt1 + paramInt2;
    View localView;
    if (this.mShouldReverseLayout)
    {
      for (paramInt1 = 0;; paramInt1++)
      {
        if (paramInt1 >= i) {
          return;
        }
        localView = getChildAt(paramInt1);
        if ((this.mOrientationHelper.getDecoratedStart(localView) < j) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView) < j)) {
          break;
        }
      }
      recycleChildren(paramRecycler, 0, paramInt1);
      return;
    }
    paramInt2 = i - 1;
    paramInt1 = paramInt2;
    while (paramInt1 >= 0)
    {
      localView = getChildAt(paramInt1);
      if ((this.mOrientationHelper.getDecoratedStart(localView) >= j) && (this.mOrientationHelper.getTransformedStartWithDecoration(localView) >= j)) {
        paramInt1--;
      } else {
        recycleChildren(paramRecycler, paramInt2, paramInt1);
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    int i = paramInt1 - paramInt2;
    paramInt2 = getChildCount();
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt2--;
      for (paramInt1 = paramInt2;; paramInt1--)
      {
        if (paramInt1 < 0) {
          return;
        }
        localView = getChildAt(paramInt1);
        if ((this.mOrientationHelper.getDecoratedEnd(localView) > i) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView) > i)) {
          break;
        }
      }
      recycleChildren(paramRecycler, paramInt2, paramInt1);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localView = getChildAt(paramInt1);
      if ((this.mOrientationHelper.getDecoratedEnd(localView) <= i) && (this.mOrientationHelper.getTransformedEndWithDecoration(localView) <= i)) {
        paramInt1++;
      } else {
        recycleChildren(paramRecycler, 0, paramInt1);
      }
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
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    int i = getChildCount();
    int j = 0;
    if (i == 0) {
      return false;
    }
    View localView = getFocusedChild();
    if ((localView != null) && (paramAnchorInfo.isViewValidAsAnchor(localView, paramState)))
    {
      paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView, getPosition(localView));
      return true;
    }
    boolean bool1 = this.mLastStackFromEnd;
    boolean bool2 = this.mStackFromEnd;
    if (bool1 != bool2) {
      return false;
    }
    paramRecycler = findReferenceChild(paramRecycler, paramState, paramAnchorInfo.mLayoutFromEnd, bool2);
    if (paramRecycler != null)
    {
      paramAnchorInfo.assignFromView(paramRecycler, getPosition(paramRecycler));
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        int k = this.mOrientationHelper.getDecoratedStart(paramRecycler);
        int m = this.mOrientationHelper.getDecoratedEnd(paramRecycler);
        int n = this.mOrientationHelper.getStartAfterPadding();
        int i1 = this.mOrientationHelper.getEndAfterPadding();
        if ((m <= n) && (k < n)) {
          i = 1;
        } else {
          i = 0;
        }
        int i2 = j;
        if (k >= i1)
        {
          i2 = j;
          if (m > i1) {
            i2 = 1;
          }
        }
        if ((i != 0) || (i2 != 0))
        {
          i = n;
          if (paramAnchorInfo.mLayoutFromEnd) {
            i = i1;
          }
          paramAnchorInfo.mCoordinate = i;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
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
          paramAnchorInfo.mPosition = this.mPendingScrollPosition;
          paramState = this.mPendingSavedState;
          if ((paramState != null) && (paramState.hasValidAnchor()))
          {
            bool1 = this.mPendingSavedState.mAnchorLayoutFromEnd;
            paramAnchorInfo.mLayoutFromEnd = bool1;
            if (bool1) {
              paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
            } else {
              paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
            }
            return true;
          }
          if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE)
          {
            paramState = findViewByPosition(this.mPendingScrollPosition);
            if (paramState != null)
            {
              if (this.mOrientationHelper.getDecoratedMeasurement(paramState) > this.mOrientationHelper.getTotalSpace())
              {
                paramAnchorInfo.assignCoordinateFromPadding();
                return true;
              }
              if (this.mOrientationHelper.getDecoratedStart(paramState) - this.mOrientationHelper.getStartAfterPadding() < 0)
              {
                paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                paramAnchorInfo.mLayoutFromEnd = false;
                return true;
              }
              if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramState) < 0)
              {
                paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                paramAnchorInfo.mLayoutFromEnd = true;
                return true;
              }
              if (paramAnchorInfo.mLayoutFromEnd) {
                i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();
              } else {
                i = this.mOrientationHelper.getDecoratedStart(paramState);
              }
              paramAnchorInfo.mCoordinate = i;
            }
            else
            {
              if (getChildCount() > 0)
              {
                i = getPosition(getChildAt(0));
                if (this.mPendingScrollPosition < i) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                if (bool1 == this.mShouldReverseLayout) {
                  bool2 = true;
                }
                paramAnchorInfo.mLayoutFromEnd = bool2;
              }
              paramAnchorInfo.assignCoordinateFromPadding();
            }
            return true;
          }
          bool1 = this.mShouldReverseLayout;
          paramAnchorInfo.mLayoutFromEnd = bool1;
          if (bool1) {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
          } else {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
          }
          return true;
        }
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      }
    }
    return false;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    int i;
    if (this.mStackFromEnd) {
      i = paramState.getItemCount() - 1;
    } else {
      i = 0;
    }
    paramAnchorInfo.mPosition = i;
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mLayoutDirection = paramInt1;
    Object localObject = this.mReusableIntPair;
    int i = 0;
    localObject[0] = 0;
    int j = 1;
    int k = 1;
    localObject[1] = 0;
    calculateExtraLayoutSpace(paramState, (int[])localObject);
    int m = Math.max(0, this.mReusableIntPair[0]);
    int n = Math.max(0, this.mReusableIntPair[1]);
    if (paramInt1 == 1) {
      i = 1;
    }
    paramState = this.mLayoutState;
    if (i != 0) {
      paramInt1 = n;
    } else {
      paramInt1 = m;
    }
    paramState.mExtraFillSpace = paramInt1;
    if (i != 0) {
      n = m;
    }
    paramState.mNoRecycleSpace = n;
    LayoutState localLayoutState;
    if (i != 0)
    {
      paramState.mExtraFillSpace = (paramInt1 + this.mOrientationHelper.getEndPadding());
      paramState = getChildClosestToEnd();
      localLayoutState = this.mLayoutState;
      paramInt1 = k;
      if (this.mShouldReverseLayout) {
        paramInt1 = -1;
      }
      localLayoutState.mItemDirection = paramInt1;
      paramInt1 = getPosition(paramState);
      localObject = this.mLayoutState;
      localLayoutState.mCurrentPosition = (paramInt1 + ((LayoutState)localObject).mItemDirection);
      ((LayoutState)localObject).mOffset = this.mOrientationHelper.getDecoratedEnd(paramState);
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(paramState) - this.mOrientationHelper.getEndAfterPadding();
    }
    else
    {
      paramState = getChildClosestToStart();
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
      localLayoutState = this.mLayoutState;
      if (this.mShouldReverseLayout) {
        paramInt1 = j;
      } else {
        paramInt1 = -1;
      }
      localLayoutState.mItemDirection = paramInt1;
      paramInt1 = getPosition(paramState);
      localObject = this.mLayoutState;
      localLayoutState.mCurrentPosition = (paramInt1 + ((LayoutState)localObject).mItemDirection);
      ((LayoutState)localObject).mOffset = this.mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(paramState) + this.mOrientationHelper.getStartAfterPadding();
    }
    paramState = this.mLayoutState;
    paramState.mAvailable = paramInt2;
    if (paramBoolean) {
      paramState.mAvailable = (paramInt2 - paramInt1);
    }
    paramState.mScrollingOffset = paramInt1;
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LayoutState localLayoutState = this.mLayoutState;
    int i;
    if (this.mShouldReverseLayout) {
      i = -1;
    } else {
      i = 1;
    }
    localLayoutState.mItemDirection = i;
    localLayoutState.mCurrentPosition = paramInt1;
    localLayoutState.mLayoutDirection = 1;
    localLayoutState.mOffset = paramInt2;
    localLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mCurrentPosition = paramInt1;
    if (this.mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    localLayoutState.mItemDirection = paramInt1;
    localLayoutState.mLayoutDirection = -1;
    localLayoutState.mOffset = paramInt2;
    localLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State paramState, @NonNull int[] paramArrayOfInt)
  {
    int i = getExtraLayoutSpace(paramState);
    int j;
    if (this.mLayoutState.mLayoutDirection == -1)
    {
      j = 0;
    }
    else
    {
      j = i;
      i = 0;
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = j;
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
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation != 0) {
      paramInt1 = paramInt2;
    }
    if ((getChildCount() != 0) && (paramInt1 != 0))
    {
      ensureLayoutState();
      if (paramInt1 > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = -1;
      }
      updateLayoutState(paramInt2, Math.abs(paramInt1), true, paramState);
      collectPrefetchPositionsForLayoutState(paramState, this.mLayoutState, paramLayoutPrefetchRegistry);
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    SavedState localSavedState = this.mPendingSavedState;
    int i = -1;
    boolean bool1;
    int j;
    if ((localSavedState != null) && (localSavedState.hasValidAnchor()))
    {
      localSavedState = this.mPendingSavedState;
      bool1 = localSavedState.mAnchorLayoutFromEnd;
      j = localSavedState.mAnchorPosition;
    }
    else
    {
      resolveShouldLayoutReverse();
      boolean bool2 = this.mShouldReverseLayout;
      k = this.mPendingScrollPosition;
      j = k;
      bool1 = bool2;
      if (k == -1) {
        if (bool2)
        {
          j = paramInt - 1;
          bool1 = bool2;
        }
        else
        {
          j = 0;
          bool1 = bool2;
        }
      }
    }
    if (!bool1) {
      i = 1;
    }
    for (int k = 0; (k < this.mInitialPrefetchItemCount) && (j >= 0) && (j < paramInt); k++)
    {
      paramLayoutPrefetchRegistry.addPosition(j, 0);
      j += i;
    }
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = paramLayoutState.mCurrentPosition;
    if ((i >= 0) && (i < paramState.getItemCount())) {
      paramLayoutPrefetchRegistry.addPosition(i, Math.max(0, paramLayoutState.mScrollingOffset));
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
    if (getChildCount() == 0) {
      return null;
    }
    int i = 0;
    int j = getPosition(getChildAt(0));
    int k = 1;
    if (paramInt < j) {
      i = 1;
    }
    paramInt = k;
    if (i != this.mShouldReverseLayout) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
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
  
  int convertFocusDirectionToLayoutDirection(int paramInt)
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
  
  LayoutState createLayoutState()
  {
    return new LayoutState();
  }
  
  void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = createLayoutState();
    }
  }
  
  int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramLayoutState.mAvailable;
    int j = paramLayoutState.mScrollingOffset;
    if (j != Integer.MIN_VALUE)
    {
      if (i < 0) {
        paramLayoutState.mScrollingOffset = (j + i);
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int k = paramLayoutState.mAvailable + paramLayoutState.mExtraFillSpace;
    LayoutChunkResult localLayoutChunkResult = this.mLayoutChunkResult;
    do
    {
      do
      {
        if (((!paramLayoutState.mInfinite) && (k <= 0)) || (!paramLayoutState.hasMore(paramState))) {
          break;
        }
        localLayoutChunkResult.resetInternal();
        layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
        if (localLayoutChunkResult.mFinished) {
          break;
        }
        paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
        int m;
        if ((localLayoutChunkResult.mIgnoreConsumed) && (paramLayoutState.mScrapList == null))
        {
          j = k;
          if (paramState.isPreLayout()) {}
        }
        else
        {
          m = paramLayoutState.mAvailable;
          j = localLayoutChunkResult.mConsumed;
          paramLayoutState.mAvailable = (m - j);
          j = k - j;
        }
        k = paramLayoutState.mScrollingOffset;
        if (k != Integer.MIN_VALUE)
        {
          m = k + localLayoutChunkResult.mConsumed;
          paramLayoutState.mScrollingOffset = m;
          k = paramLayoutState.mAvailable;
          if (k < 0) {
            paramLayoutState.mScrollingOffset = (m + k);
          }
          recycleByLayoutState(paramRecycler, paramLayoutState);
        }
        k = j;
      } while (!paramBoolean);
      k = j;
    } while (!localLayoutChunkResult.mFocusable);
    return i - paramLayoutState.mAvailable;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    int i;
    if (localView == null) {
      i = -1;
    } else {
      i = getPosition(localView);
    }
    return i;
  }
  
  View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    int i;
    if (localView == null) {
      i = -1;
    } else {
      i = getPosition(localView);
    }
    return i;
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    int i = getChildCount();
    int j = -1;
    View localView = findOneVisibleChild(i - 1, -1, true, false);
    if (localView != null) {
      j = getPosition(localView);
    }
    return j;
  }
  
  public int findLastVisibleItemPosition()
  {
    int i = getChildCount();
    int j = -1;
    View localView = findOneVisibleChild(i - 1, -1, false, true);
    if (localView != null) {
      j = getPosition(localView);
    }
    return j;
  }
  
  View findOnePartiallyOrCompletelyInvisibleChild(int paramInt1, int paramInt2)
  {
    ensureLayoutState();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else if (paramInt2 < paramInt1) {
      i = -1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return getChildAt(paramInt1);
    }
    int j;
    if (this.mOrientationHelper.getDecoratedStart(getChildAt(paramInt1)) < this.mOrientationHelper.getStartAfterPadding())
    {
      j = 16644;
      i = 16388;
    }
    else
    {
      j = 4161;
      i = 4097;
    }
    View localView;
    if (this.mOrientation == 0) {
      localView = this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
    } else {
      localView = this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
    }
    return localView;
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int i = 320;
    int j;
    if (paramBoolean1) {
      j = 24579;
    } else {
      j = 320;
    }
    if (!paramBoolean2) {
      i = 0;
    }
    View localView;
    if (this.mOrientation == 0) {
      localView = this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
    } else {
      localView = this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
    }
    return localView;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int i = getChildCount();
    int j = -1;
    int k;
    if (paramBoolean2)
    {
      i = getChildCount() - 1;
      k = -1;
    }
    else
    {
      j = i;
      i = 0;
      k = 1;
    }
    int m = paramState.getItemCount();
    int n = this.mOrientationHelper.getStartAfterPadding();
    int i1 = this.mOrientationHelper.getEndAfterPadding();
    Object localObject1 = null;
    paramState = null;
    Object localObject4;
    for (paramRecycler = paramState; i != j; paramRecycler = (RecyclerView.Recycler)localObject4)
    {
      View localView = getChildAt(i);
      int i2 = getPosition(localView);
      int i3 = this.mOrientationHelper.getDecoratedStart(localView);
      int i4 = this.mOrientationHelper.getDecoratedEnd(localView);
      Object localObject2 = localObject1;
      Object localObject3 = paramState;
      localObject4 = paramRecycler;
      if (i2 >= 0)
      {
        localObject2 = localObject1;
        localObject3 = paramState;
        localObject4 = paramRecycler;
        if (i2 < m) {
          if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject2 = localObject1;
            localObject3 = paramState;
            localObject4 = paramRecycler;
            if (paramRecycler == null)
            {
              localObject2 = localObject1;
              localObject3 = paramState;
              localObject4 = localView;
            }
          }
          else
          {
            if ((i4 <= n) && (i3 < n)) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if ((i3 >= i1) && (i4 > i1)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            if ((i2 == 0) && (i4 == 0)) {
              return localView;
            }
            if (paramBoolean1)
            {
              if (i4 == 0)
              {
                localObject2 = localObject1;
                localObject3 = paramState;
                localObject4 = paramRecycler;
                if (localObject1 != null) {
                  break label328;
                }
                break label318;
              }
            }
            else {
              if (i2 == 0) {
                break label303;
              }
            }
            localObject2 = localObject1;
            localObject3 = localView;
            localObject4 = paramRecycler;
            break label328;
            label303:
            localObject2 = localObject1;
            localObject3 = paramState;
            localObject4 = paramRecycler;
            if (localObject1 == null)
            {
              label318:
              localObject4 = paramRecycler;
              localObject3 = paramState;
              localObject2 = localView;
            }
          }
        }
      }
      label328:
      i += k;
      localObject1 = localObject2;
      paramState = (RecyclerView.State)localObject3;
    }
    if (localObject1 == null) {
      if (paramState != null) {
        localObject1 = paramState;
      } else {
        localObject1 = paramRecycler;
      }
    }
    return (View)localObject1;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      View localView = getChildAt(j);
      if (getPosition(localView) == paramInt) {
        return localView;
      }
    }
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  @Deprecated
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getInitialPrefetchItemCount()
  {
    return this.mInitialPrefetchItemCount;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  protected boolean isLayoutRTL()
  {
    int i = getLayoutDirection();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult)
  {
    paramState = paramLayoutState.next(paramRecycler);
    if (paramState == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    paramRecycler = (RecyclerView.LayoutParams)paramState.getLayoutParams();
    boolean bool1;
    boolean bool2;
    if (paramLayoutState.mScrapList == null)
    {
      bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool1 == bool2) {
        addView(paramState);
      } else {
        addView(paramState, 0);
      }
    }
    else
    {
      bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool1 == bool2) {
        addDisappearingView(paramState);
      } else {
        addDisappearingView(paramState, 0);
      }
    }
    measureChildWithMargins(paramState, 0, 0);
    paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramState);
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (this.mOrientation == 1)
    {
      if (isLayoutRTL())
      {
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramState);
      }
      else
      {
        j = getPaddingLeft();
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramState) + j;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        m = paramLayoutChunkResult.mConsumed;
        n = k;
        i1 = i;
        i = k - m;
        k = j;
        j = i1;
      }
      else
      {
        k = paramLayoutState.mOffset;
        m = paramLayoutChunkResult.mConsumed;
        n = k;
        i1 = i;
        m += k;
        k = j;
        i = n;
        j = i1;
        n = m;
      }
    }
    else
    {
      k = getPaddingTop();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramState) + k;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        m = paramLayoutState.mOffset;
        int i2 = paramLayoutChunkResult.mConsumed;
        j = m;
        i1 = k;
        n = i;
        k = m - i2;
        i = i1;
      }
      else
      {
        i1 = paramLayoutState.mOffset;
        j = paramLayoutChunkResult.mConsumed;
        j += i1;
        n = i;
        i = k;
        k = i1;
      }
    }
    layoutDecoratedWithMargins(paramState, k, i, j, n);
    if ((paramRecycler.isItemRemoved()) || (paramRecycler.isItemChanged())) {
      paramLayoutChunkResult.mIgnoreConsumed = true;
    }
    paramLayoutChunkResult.mFocusable = paramState.hasFocusable();
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {
      return null;
    }
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == Integer.MIN_VALUE) {
      return null;
    }
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(this.mOrientationHelper.getTotalSpace() * 0.33333334F), false, paramState);
    paramView = this.mLayoutState;
    paramView.mScrollingOffset = Integer.MIN_VALUE;
    paramView.mRecycle = false;
    fill(paramRecycler, paramView, paramState, true);
    if (paramInt == -1) {
      paramView = findPartiallyOrCompletelyInvisibleChildClosestToStart();
    } else {
      paramView = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
    }
    if (paramInt == -1) {
      paramRecycler = getChildClosestToStart();
    } else {
      paramRecycler = getChildClosestToEnd();
    }
    if (paramRecycler.hasFocusable())
    {
      if (paramView == null) {
        return null;
      }
      return paramRecycler;
    }
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Object localObject = this.mPendingSavedState;
    int i = -1;
    if (((localObject != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    localObject = this.mPendingSavedState;
    if ((localObject != null) && (((SavedState)localObject).hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    localObject = getFocusedChild();
    AnchorInfo localAnchorInfo = this.mAnchorInfo;
    if ((localAnchorInfo.mValid) && (this.mPendingScrollPosition == -1) && (this.mPendingSavedState == null))
    {
      if ((localObject != null) && ((this.mOrientationHelper.getDecoratedStart((View)localObject) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd((View)localObject) <= this.mOrientationHelper.getStartAfterPadding()))) {
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect((View)localObject, getPosition((View)localObject));
      }
    }
    else
    {
      localAnchorInfo.reset();
      localObject = this.mAnchorInfo;
      ((AnchorInfo)localObject).mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
      updateAnchorInfoForLayout(paramRecycler, paramState, (AnchorInfo)localObject);
      this.mAnchorInfo.mValid = true;
    }
    localObject = this.mLayoutState;
    if (((LayoutState)localObject).mLastScrollDelta >= 0) {
      j = 1;
    } else {
      j = -1;
    }
    ((LayoutState)localObject).mLayoutDirection = j;
    localObject = this.mReusableIntPair;
    localObject[0] = 0;
    localObject[1] = 0;
    calculateExtraLayoutSpace(paramState, (int[])localObject);
    int k = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
    int m = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
    int n = k;
    int j = m;
    int i1;
    if (paramState.isPreLayout())
    {
      i1 = this.mPendingScrollPosition;
      n = k;
      j = m;
      if (i1 != -1)
      {
        n = k;
        j = m;
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE)
        {
          localObject = findViewByPosition(i1);
          n = k;
          j = m;
          if (localObject != null)
          {
            if (this.mShouldReverseLayout)
            {
              n = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject);
              j = this.mPendingScrollPositionOffset;
            }
            else
            {
              j = this.mOrientationHelper.getDecoratedStart((View)localObject) - this.mOrientationHelper.getStartAfterPadding();
              n = this.mPendingScrollPositionOffset;
            }
            j = n - j;
            if (j > 0)
            {
              n = k + j;
              j = m;
            }
            else
            {
              j = m - j;
              n = k;
            }
          }
        }
      }
    }
    localObject = this.mAnchorInfo;
    if (((AnchorInfo)localObject).mLayoutFromEnd)
    {
      if (!this.mShouldReverseLayout) {}
    }
    else {
      while (!this.mShouldReverseLayout)
      {
        i = 1;
        break;
      }
    }
    onAnchorReady(paramRecycler, paramState, (AnchorInfo)localObject, i);
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
    this.mLayoutState.mNoRecycleSpace = 0;
    localObject = this.mAnchorInfo;
    if (((AnchorInfo)localObject).mLayoutFromEnd)
    {
      updateLayoutStateToFillStart((AnchorInfo)localObject);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mExtraFillSpace = n;
      fill(paramRecycler, (LayoutState)localObject, paramState, false);
      localObject = this.mLayoutState;
      i = ((LayoutState)localObject).mOffset;
      m = ((LayoutState)localObject).mCurrentPosition;
      k = ((LayoutState)localObject).mAvailable;
      n = j;
      if (k > 0) {
        n = j + k;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mExtraFillSpace = n;
      ((LayoutState)localObject).mCurrentPosition += ((LayoutState)localObject).mItemDirection;
      fill(paramRecycler, (LayoutState)localObject, paramState, false);
      localObject = this.mLayoutState;
      k = ((LayoutState)localObject).mOffset;
      i1 = ((LayoutState)localObject).mAvailable;
      n = i;
      j = k;
      if (i1 > 0)
      {
        updateLayoutStateToFillStart(m, i);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mExtraFillSpace = i1;
        fill(paramRecycler, (LayoutState)localObject, paramState, false);
        n = this.mLayoutState.mOffset;
        j = k;
      }
    }
    else
    {
      updateLayoutStateToFillEnd((AnchorInfo)localObject);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mExtraFillSpace = j;
      fill(paramRecycler, (LayoutState)localObject, paramState, false);
      localObject = this.mLayoutState;
      i = ((LayoutState)localObject).mOffset;
      m = ((LayoutState)localObject).mCurrentPosition;
      k = ((LayoutState)localObject).mAvailable;
      j = n;
      if (k > 0) {
        j = n + k;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mExtraFillSpace = j;
      ((LayoutState)localObject).mCurrentPosition += ((LayoutState)localObject).mItemDirection;
      fill(paramRecycler, (LayoutState)localObject, paramState, false);
      localObject = this.mLayoutState;
      k = ((LayoutState)localObject).mOffset;
      i1 = ((LayoutState)localObject).mAvailable;
      n = k;
      j = i;
      if (i1 > 0)
      {
        updateLayoutStateToFillEnd(m, i);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mExtraFillSpace = i1;
        fill(paramRecycler, (LayoutState)localObject, paramState, false);
        j = this.mLayoutState.mOffset;
        n = k;
      }
    }
    k = n;
    i = j;
    if (getChildCount() > 0)
    {
      if ((this.mShouldReverseLayout ^ this.mStackFromEnd))
      {
        k = fixLayoutEndGap(j, paramRecycler, paramState, true);
        i = n + k;
        j += k;
        n = fixLayoutStartGap(i, paramRecycler, paramState, false);
      }
      else
      {
        k = fixLayoutStartGap(n, paramRecycler, paramState, true);
        i = n + k;
        j += k;
        n = fixLayoutEndGap(j, paramRecycler, paramState, false);
      }
      k = i + n;
      i = j + n;
    }
    layoutForPredictiveAnimations(paramRecycler, paramState, k, i);
    if (!paramState.isPreLayout()) {
      this.mOrientationHelper.onLayoutComplete();
    } else {
      this.mAnchorInfo.reset();
    }
    this.mLastStackFromEnd = this.mStackFromEnd;
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    this.mAnchorInfo.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      this.mPendingSavedState = paramParcelable;
      if (this.mPendingScrollPosition != -1) {
        paramParcelable.invalidateAnchor();
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
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      View localView;
      if (bool)
      {
        localView = getChildClosestToEnd();
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView));
        localSavedState.mAnchorPosition = getPosition(localView);
      }
      else
      {
        localView = getChildClosestToStart();
        localSavedState.mAnchorPosition = getPosition(localView);
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
      }
    }
    else
    {
      localSavedState.invalidateAnchor();
    }
    return localSavedState;
  }
  
  public void prepareForDrop(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    if (this.mShouldReverseLayout)
    {
      if (paramInt1 == 1) {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1)));
      } else {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
      }
    }
    else if (paramInt1 == -1) {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedStart(paramView2));
    } else {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
    }
  }
  
  boolean resolveIsInfinite()
  {
    boolean bool;
    if ((this.mOrientationHelper.getMode() == 0) && (this.mOrientationHelper.getEnd() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() != 0) && (paramInt != 0))
    {
      ensureLayoutState();
      this.mLayoutState.mRecycle = true;
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      LayoutState localLayoutState = this.mLayoutState;
      int k = localLayoutState.mScrollingOffset + fill(paramRecycler, localLayoutState, paramState, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
      this.mLayoutState.mLastScrollDelta = paramInt;
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setInitialPrefetchItemCount(int paramInt)
  {
    this.mInitialPrefetchItemCount = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    Object localObject;
    if ((paramInt != 0) && (paramInt != 1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid orientation:");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.mOrientationHelper == null))
    {
      localObject = OrientationHelper.createOrientationHelper(this, paramInt);
      this.mOrientationHelper = ((OrientationHelper)localObject);
      this.mAnchorInfo.mOrientationHelper = ((OrientationHelper)localObject);
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout) {
      return;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean) {
      return;
    }
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice()
  {
    boolean bool;
    if ((getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
    if ((this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void validateChildOrder()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("validating child count ");
    ((StringBuilder)localObject).append(getChildCount());
    Log.d("LinearLayoutManager", ((StringBuilder)localObject).toString());
    int i = getChildCount();
    boolean bool1 = true;
    boolean bool2 = true;
    if (i < 1) {
      return;
    }
    int j = getPosition(getChildAt(0));
    int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
    int m;
    int n;
    if (this.mShouldReverseLayout)
    {
      for (i = 1;; i++)
      {
        if (i >= getChildCount()) {
          return;
        }
        localObject = getChildAt(i);
        m = getPosition((View)localObject);
        n = this.mOrientationHelper.getDecoratedStart((View)localObject);
        if (m < j)
        {
          logChildren();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
          if (n >= k) {
            bool2 = false;
          }
          ((StringBuilder)localObject).append(bool2);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
        if (n > k) {
          break;
        }
      }
      logChildren();
      throw new RuntimeException("detected invalid location");
    }
    i = 1;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      m = getPosition((View)localObject);
      n = this.mOrientationHelper.getDecoratedStart((View)localObject);
      if (m < j)
      {
        logChildren();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
        if (n < k) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        ((StringBuilder)localObject).append(bool2);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      if (n >= k)
      {
        i++;
      }
      else
      {
        logChildren();
        throw new RuntimeException("detected invalid location");
      }
    }
  }
  
  static class AnchorInfo
  {
    int mCoordinate;
    boolean mLayoutFromEnd;
    OrientationHelper mOrientationHelper;
    int mPosition;
    boolean mValid;
    
    AnchorInfo()
    {
      reset();
    }
    
    void assignCoordinateFromPadding()
    {
      int i;
      if (this.mLayoutFromEnd) {
        i = this.mOrientationHelper.getEndAfterPadding();
      } else {
        i = this.mOrientationHelper.getStartAfterPadding();
      }
      this.mCoordinate = i;
    }
    
    public void assignFromView(View paramView, int paramInt)
    {
      if (this.mLayoutFromEnd) {
        this.mCoordinate = (this.mOrientationHelper.getDecoratedEnd(paramView) + this.mOrientationHelper.getTotalSpaceChange());
      } else {
        this.mCoordinate = this.mOrientationHelper.getDecoratedStart(paramView);
      }
      this.mPosition = paramInt;
    }
    
    public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
    {
      int i = this.mOrientationHelper.getTotalSpaceChange();
      if (i >= 0)
      {
        assignFromView(paramView, paramInt);
        return;
      }
      this.mPosition = paramInt;
      int j;
      int k;
      if (this.mLayoutFromEnd)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
        this.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - paramInt);
        if (paramInt > 0)
        {
          i = this.mOrientationHelper.getDecoratedMeasurement(paramView);
          j = this.mCoordinate;
          k = this.mOrientationHelper.getStartAfterPadding();
          i = j - i - (k + Math.min(this.mOrientationHelper.getDecoratedStart(paramView) - k, 0));
          if (i < 0) {
            this.mCoordinate += Math.min(paramInt, -i);
          }
        }
      }
      else
      {
        int m = this.mOrientationHelper.getDecoratedStart(paramView);
        paramInt = m - this.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = m;
        if (paramInt > 0)
        {
          k = this.mOrientationHelper.getDecoratedMeasurement(paramView);
          j = this.mOrientationHelper.getEndAfterPadding();
          int n = this.mOrientationHelper.getDecoratedEnd(paramView);
          i = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, j - i - n) - (m + k);
          if (i < 0) {
            this.mCoordinate -= Math.min(paramInt, -i);
          }
        }
      }
    }
    
    boolean isViewValidAsAnchor(View paramView, RecyclerView.State paramState)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      boolean bool;
      if ((!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramState.getItemCount())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void reset()
    {
      this.mPosition = -1;
      this.mCoordinate = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mValid = false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(this.mPosition);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(this.mCoordinate);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(this.mLayoutFromEnd);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(this.mValid);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  protected static class LayoutChunkResult
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
    
    void resetInternal()
    {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }
  
  static class LayoutState
  {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    static final String TAG = "LLM#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtraFillSpace = 0;
    boolean mInfinite;
    boolean mIsPreLayout = false;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mNoRecycleSpace = 0;
    int mOffset;
    boolean mRecycle = true;
    List<RecyclerView.ViewHolder> mScrapList = null;
    int mScrollingOffset;
    
    private View nextViewFromScrapList()
    {
      int i = this.mScrapList.size();
      for (int j = 0; j < i; j++)
      {
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(j)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.isItemRemoved()) && (this.mCurrentPosition == localLayoutParams.getViewLayoutPosition()))
        {
          assignPositionFromScrapList(localView);
          return localView;
        }
      }
      return null;
    }
    
    public void assignPositionFromScrapList()
    {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View paramView)
    {
      paramView = nextViewInLimitedList(paramView);
      if (paramView == null) {
        this.mCurrentPosition = -1;
      } else {
        this.mCurrentPosition = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
      }
    }
    
    boolean hasMore(RecyclerView.State paramState)
    {
      int i = this.mCurrentPosition;
      boolean bool;
      if ((i >= 0) && (i < paramState.getItemCount())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void log()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avail:");
      localStringBuilder.append(this.mAvailable);
      localStringBuilder.append(", ind:");
      localStringBuilder.append(this.mCurrentPosition);
      localStringBuilder.append(", dir:");
      localStringBuilder.append(this.mItemDirection);
      localStringBuilder.append(", offset:");
      localStringBuilder.append(this.mOffset);
      localStringBuilder.append(", layoutDir:");
      localStringBuilder.append(this.mLayoutDirection);
      Log.d("LLM#LayoutState", localStringBuilder.toString());
    }
    
    View next(RecyclerView.Recycler paramRecycler)
    {
      if (this.mScrapList != null) {
        return nextViewFromScrapList();
      }
      paramRecycler = paramRecycler.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
      return paramRecycler;
    }
    
    public View nextViewInLimitedList(View paramView)
    {
      int i = this.mScrapList.size();
      Object localObject1 = null;
      int j = Integer.MAX_VALUE;
      int k = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (k >= i) {
          break;
        }
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(k)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        localObject2 = localObject1;
        int m = j;
        if (localView != paramView) {
          if (localLayoutParams.isItemRemoved())
          {
            localObject2 = localObject1;
            m = j;
          }
          else
          {
            int n = (localLayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (n < 0)
            {
              localObject2 = localObject1;
              m = j;
            }
            else
            {
              localObject2 = localObject1;
              m = j;
              if (n < j)
              {
                localObject1 = localView;
                if (n == 0)
                {
                  localObject2 = localObject1;
                  break;
                }
                m = n;
                localObject2 = localObject1;
              }
            }
          }
        }
        k++;
        localObject1 = localObject2;
        j = m;
      }
      return (View)localObject2;
    }
  }
  
  @SuppressLint({"BanParcelableUsage"})
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public LinearLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LinearLayoutManager.SavedState(paramAnonymousParcel);
      }
      
      public LinearLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LinearLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mAnchorOffset = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.mAnchorLayoutFromEnd = bool;
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mAnchorOffset = paramSavedState.mAnchorOffset;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    boolean hasValidAnchor()
    {
      boolean bool;
      if (this.mAnchorPosition >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void invalidateAnchor()
    {
      this.mAnchorPosition = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mAnchorOffset);
      paramParcel.writeInt(this.mAnchorLayoutFromEnd);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */