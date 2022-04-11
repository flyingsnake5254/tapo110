package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  private static final String TAG = "GridLayoutManager";
  int[] mCachedBorders;
  final Rect mDecorInsets = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  private boolean mUsingSpansToEstimateScrollBarDimensions;
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(RecyclerView.LayoutManager.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    int j = -1;
    int k;
    int m;
    if (paramBoolean)
    {
      k = 0;
      m = 1;
      j = paramInt;
      paramInt = k;
    }
    else
    {
      paramInt--;
      m = -1;
    }
    while (paramInt != j)
    {
      View localView = this.mSet[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      k = getSpanSize(paramRecycler, paramState, getPosition(localView));
      localLayoutParams.mSpanSize = k;
      localLayoutParams.mSpanIndex = i;
      i += k;
      paramInt += m;
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(j).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      this.mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, paramInt);
  }
  
  static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int j = 0;
    arrayOfInt[0] = 0;
    int k = paramInt2 / paramInt1;
    int m = paramInt2 % paramInt1;
    int n = 0;
    paramInt2 = j;
    while (i <= paramInt1)
    {
      paramInt2 += m;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < m))
      {
        j = k + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        j = k;
      }
      n += j;
      arrayOfInt[i] = n;
      i++;
    }
    return arrayOfInt;
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }
  
  private int computeScrollOffsetWithSpanInfo(RecyclerView.State paramState)
  {
    if ((getChildCount() != 0) && (paramState.getItemCount() != 0))
    {
      ensureLayoutState();
      boolean bool = isSmoothScrollbarEnabled();
      View localView1 = findFirstVisibleChildClosestToStart(bool ^ true, true);
      View localView2 = findFirstVisibleChildClosestToEnd(bool ^ true, true);
      if ((localView1 != null) && (localView2 != null))
      {
        int i = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        int j = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        int k = Math.min(i, j);
        j = Math.max(i, j);
        i = this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount);
        if (this.mShouldReverseLayout) {
          k = Math.max(0, i + 1 - j - 1);
        } else {
          k = Math.max(0, k);
        }
        if (!bool) {
          return k;
        }
        i = Math.abs(this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getDecoratedStart(localView1));
        int m = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        j = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        float f = i / (j - m + 1);
        return Math.round(k * f + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(localView1)));
      }
    }
    return 0;
  }
  
  private int computeScrollRangeWithSpanInfo(RecyclerView.State paramState)
  {
    if ((getChildCount() != 0) && (paramState.getItemCount() != 0))
    {
      ensureLayoutState();
      View localView1 = findFirstVisibleChildClosestToStart(isSmoothScrollbarEnabled() ^ true, true);
      View localView2 = findFirstVisibleChildClosestToEnd(isSmoothScrollbarEnabled() ^ true, true);
      if ((localView1 != null) && (localView2 != null))
      {
        if (!isSmoothScrollbarEnabled()) {
          return this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount) + 1;
        }
        int i = this.mOrientationHelper.getDecoratedEnd(localView2);
        int j = this.mOrientationHelper.getDecoratedStart(localView1);
        int k = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        int m = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        int n = this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount);
        return (int)((i - j) / (m - k + 1) * (n + 1));
      }
    }
    return 0;
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    if (paramInt == 1) {
      i = 1;
    } else {
      i = 0;
    }
    paramInt = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
    if (i != 0) {
      while (paramInt > 0)
      {
        paramInt = paramAnchorInfo.mPosition;
        if (paramInt <= 0) {
          break;
        }
        paramInt--;
        paramAnchorInfo.mPosition = paramInt;
        paramInt = getSpanIndex(paramRecycler, paramState, paramInt);
      }
    }
    int j = paramState.getItemCount();
    int i = paramAnchorInfo.mPosition;
    while (i < j - 1)
    {
      int k = i + 1;
      int m = getSpanIndex(paramRecycler, paramState, k);
      if (m <= paramInt) {
        break;
      }
      i = k;
      paramInt = m;
    }
    paramAnchorInfo.mPosition = i;
  }
  
  private void ensureViewSet()
  {
    View[] arrayOfView = this.mSet;
    if ((arrayOfView == null) || (arrayOfView.length != this.mSpanCount)) {
      this.mSet = new View[this.mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getCachedSpanGroupIndex(paramInt, this.mSpanCount);
    }
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. ");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    }
    int i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getSpanSize(paramInt);
    }
    int i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 1;
    }
    return this.mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * this.mSpanCount), paramInt));
  }
  
  private void measureChild(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    int i = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int j = localRect.left + localRect.right + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int k = getSpaceForSpanRange(localLayoutParams.mSpanIndex, localLayoutParams.mSpanSize);
    if (this.mOrientation == 1)
    {
      j = RecyclerView.LayoutManager.getChildMeasureSpec(k, paramInt, j, localLayoutParams.width, false);
      paramInt = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i, localLayoutParams.height, true);
    }
    else
    {
      paramInt = RecyclerView.LayoutManager.getChildMeasureSpec(k, paramInt, i, localLayoutParams.height, false);
      j = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), j, localLayoutParams.width, true);
    }
    measureChildWithDecorationsAndMargin(paramView, j, paramInt, paramBoolean);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void updateMeasurements()
  {
    int i;
    int j;
    if (getOrientation() == 1)
    {
      i = getWidth() - getPaddingRight();
      j = getPaddingLeft();
    }
    else
    {
      i = getHeight() - getPaddingBottom();
      j = getPaddingTop();
    }
    calculateItemBorders(i - j);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = this.mSpanCount;
    for (int j = 0; (j < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0); j++)
    {
      int k = paramLayoutState.mCurrentPosition;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, paramLayoutState.mScrollingOffset));
      i -= this.mSpanSizeLookup.getSpanSize(k);
      paramLayoutState.mCurrentPosition += paramLayoutState.mItemDirection;
    }
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollOffsetWithSpanInfo(paramState);
    }
    return super.computeHorizontalScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollRangeWithSpanInfo(paramState);
    }
    return super.computeHorizontalScrollRange(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollOffsetWithSpanInfo(paramState);
    }
    return super.computeVerticalScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollRangeWithSpanInfo(paramState);
    }
    return super.computeVerticalScrollRange(paramState);
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = getChildCount();
    int j = -1;
    int k = 1;
    if (paramBoolean2)
    {
      i = getChildCount() - 1;
      k = -1;
    }
    else
    {
      j = i;
      i = 0;
    }
    int m = paramState.getItemCount();
    ensureLayoutState();
    int n = this.mOrientationHelper.getStartAfterPadding();
    int i1 = this.mOrientationHelper.getEndAfterPadding();
    Object localObject1 = null;
    Object localObject4;
    for (Object localObject2 = null; i != j; localObject2 = localObject4)
    {
      View localView = getChildAt(i);
      int i2 = getPosition(localView);
      Object localObject3 = localObject1;
      localObject4 = localObject2;
      if (i2 >= 0)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i2 < m) {
          if (getSpanIndex(paramRecycler, paramState, i2) != 0)
          {
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject1;
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              localObject4 = localView;
              localObject3 = localObject1;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) < i1) && (this.mOrientationHelper.getDecoratedEnd(localView) >= n)) {
              return localView;
            }
            localObject3 = localObject1;
            localObject4 = localObject2;
            if (localObject1 == null)
            {
              localObject3 = localView;
              localObject4 = localObject2;
            }
          }
        }
      }
      i += k;
      localObject1 = localObject3;
    }
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    return (View)localObject1;
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
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  int getSpaceForSpanRange(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (isLayoutRTL()))
    {
      arrayOfInt = this.mCachedBorders;
      int i = this.mSpanCount;
      return arrayOfInt[(i - paramInt1)] - arrayOfInt[(i - paramInt1 - paramInt2)];
    }
    int[] arrayOfInt = this.mCachedBorders;
    return arrayOfInt[(paramInt2 + paramInt1)] - arrayOfInt[paramInt1];
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  public SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  public boolean isUsingSpansToEstimateScrollbarDimensions()
  {
    return this.mUsingSpansToEstimateScrollBarDimensions;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i = this.mOrientationHelper.getModeInOther();
    int j;
    if (i != 1073741824) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (getChildCount() > 0) {
      k = this.mCachedBorders[this.mSpanCount];
    } else {
      k = 0;
    }
    if (j != 0) {
      updateMeasurements();
    }
    boolean bool;
    if (paramLayoutState.mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int m = this.mSpanCount;
    if (!bool) {
      m = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
    }
    int n = 0;
    Object localObject;
    while ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (m > 0))
    {
      i1 = paramLayoutState.mCurrentPosition;
      i2 = getSpanSize(paramRecycler, paramState, i1);
      if (i2 <= this.mSpanCount)
      {
        m -= i2;
        if (m >= 0)
        {
          localObject = paramLayoutState.next(paramRecycler);
          if (localObject != null)
          {
            this.mSet[n] = localObject;
            n++;
          }
        }
      }
      else
      {
        paramRecycler = new StringBuilder();
        paramRecycler.append("Item at position ");
        paramRecycler.append(i1);
        paramRecycler.append(" requires ");
        paramRecycler.append(i2);
        paramRecycler.append(" spans but GridLayoutManager has only ");
        paramRecycler.append(this.mSpanCount);
        paramRecycler.append(" spans.");
        throw new IllegalArgumentException(paramRecycler.toString());
      }
    }
    if (n == 0)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    float f1 = 0.0F;
    assignSpans(paramRecycler, paramState, n, bool);
    int i1 = 0;
    m = 0;
    while (i1 < n)
    {
      paramRecycler = this.mSet[i1];
      if (paramLayoutState.mScrapList == null)
      {
        if (bool) {
          addView(paramRecycler);
        } else {
          addView(paramRecycler, 0);
        }
      }
      else if (bool) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
      calculateItemDecorationsForChild(paramRecycler, this.mDecorInsets);
      measureChild(paramRecycler, i, false);
      i3 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
      i2 = m;
      if (i3 > m) {
        i2 = i3;
      }
      paramState = (LayoutParams)paramRecycler.getLayoutParams();
      float f2 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) * 1.0F / paramState.mSpanSize;
      float f3 = f1;
      if (f2 > f1) {
        f3 = f2;
      }
      i1++;
      m = i2;
      f1 = f3;
    }
    int i2 = m;
    if (j != 0)
    {
      guessMeasurement(f1, k);
      j = 0;
      for (m = 0;; m = i2)
      {
        i2 = m;
        if (j >= n) {
          break;
        }
        paramRecycler = this.mSet[j];
        measureChild(paramRecycler, 1073741824, true);
        k = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        i2 = m;
        if (k > m) {
          i2 = k;
        }
        j++;
      }
    }
    for (m = 0; m < n; m++)
    {
      paramRecycler = this.mSet[m];
      if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != i2)
      {
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        localObject = paramState.mDecorInsets;
        k = ((Rect)localObject).top + ((Rect)localObject).bottom + paramState.topMargin + paramState.bottomMargin;
        j = ((Rect)localObject).left + ((Rect)localObject).right + paramState.leftMargin + paramState.rightMargin;
        i1 = getSpaceForSpanRange(paramState.mSpanIndex, paramState.mSpanSize);
        if (this.mOrientation == 1)
        {
          j = RecyclerView.LayoutManager.getChildMeasureSpec(i1, 1073741824, j, paramState.width, false);
          k = View.MeasureSpec.makeMeasureSpec(i2 - k, 1073741824);
        }
        else
        {
          j = View.MeasureSpec.makeMeasureSpec(i2 - j, 1073741824);
          k = RecyclerView.LayoutManager.getChildMeasureSpec(i1, 1073741824, k, paramState.height, false);
        }
        measureChildWithDecorationsAndMargin(paramRecycler, j, k, true);
      }
    }
    int i3 = 0;
    paramLayoutChunkResult.mConsumed = i2;
    if (this.mOrientation == 1)
    {
      if (paramLayoutState.mLayoutDirection == -1)
      {
        m = paramLayoutState.mOffset;
        i2 = m - i2;
      }
      else
      {
        j = paramLayoutState.mOffset;
        m = j;
        j = i2 + j;
        i2 = m;
        m = j;
      }
      j = 0;
      k = 0;
    }
    else if (paramLayoutState.mLayoutDirection == -1)
    {
      j = paramLayoutState.mOffset;
      k = j - i2;
      i2 = 0;
      m = 0;
    }
    else
    {
      k = paramLayoutState.mOffset;
      j = i2 + k;
      m = 0;
      i2 = 0;
    }
    while (i3 < n)
    {
      paramState = this.mSet[i3];
      paramRecycler = (LayoutParams)paramState.getLayoutParams();
      if (this.mOrientation == 1)
      {
        if (isLayoutRTL())
        {
          j = getPaddingLeft() + this.mCachedBorders[(this.mSpanCount - paramRecycler.mSpanIndex)];
          i1 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramState);
          k = j;
          j -= i1;
        }
        else
        {
          k = getPaddingLeft() + this.mCachedBorders[paramRecycler.mSpanIndex];
          i1 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramState);
          j = k;
          k = i1 + k;
        }
        i1 = m;
        m = i2;
        i2 = j;
      }
      else
      {
        i1 = getPaddingTop() + this.mCachedBorders[paramRecycler.mSpanIndex];
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramState);
        m = i1;
        i2 = k;
        i1 = i + i1;
        k = j;
      }
      layoutDecoratedWithMargins(paramState, i2, m, k, i1);
      if ((paramRecycler.isItemRemoved()) || (paramRecycler.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable |= paramState.hasFocusable();
      i = i3 + 1;
      j = k;
      i3 = m;
      m = i1;
      k = i2;
      i2 = i3;
      i3 = i;
    }
    Arrays.fill(this.mSet, null);
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout())) {
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt);
    }
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView = findContainingItemView(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (LayoutParams)localView.getLayoutParams();
    int i = ((LayoutParams)localObject2).mSpanIndex;
    int j = ((LayoutParams)localObject2).mSpanSize + i;
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int k;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != this.mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int n;
    if (paramInt != 0)
    {
      paramInt = getChildCount() - 1;
      m = -1;
      n = -1;
    }
    else
    {
      m = getChildCount();
      paramInt = 0;
      n = 1;
    }
    int i1;
    if ((this.mOrientation == 1) && (isLayoutRTL())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = getSpanGroupIndex(paramRecycler, paramState, paramInt);
    int i3 = paramInt;
    int i4 = 0;
    int i5 = -1;
    int i6 = -1;
    paramInt = 0;
    paramView = null;
    int i7 = m;
    int m = i4;
    while (i3 != i7)
    {
      i4 = getSpanGroupIndex(paramRecycler, paramState, i3);
      localObject2 = getChildAt(i3);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (i4 != i2))
      {
        if (localObject1 != null) {
          break;
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i8 = localLayoutParams.mSpanIndex;
        int i9 = localLayoutParams.mSpanSize + i8;
        if ((((View)localObject2).hasFocusable()) && (i8 == i) && (i9 == j)) {
          return (View)localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (localObject1 == null)) || ((!((View)localObject2).hasFocusable()) && (paramView == null))) {}
        for (;;)
        {
          i4 = 1;
          break label477;
          i4 = Math.max(i8, i);
          int i10 = Math.min(i9, j) - i4;
          if (((View)localObject2).hasFocusable())
          {
            if (i10 <= m) {
              while (i10 == m)
              {
                if (i8 > i5) {
                  i4 = 1;
                } else {
                  i4 = 0;
                }
                if (i1 != i4) {
                  break;
                }
              }
            }
          }
          else
          {
            if (localObject1 != null) {
              break;
            }
            int i11 = 1;
            int i12 = 1;
            if (!isViewPartiallyVisible((View)localObject2, false, true)) {
              break;
            }
            i4 = paramInt;
            if (i10 > i4)
            {
              i4 = i11;
              break label477;
            }
            if (i10 != i4) {
              break;
            }
            if (i8 > i6) {
              i4 = i12;
            } else {
              i4 = 0;
            }
            if (i1 != i4) {
              break;
            }
          }
        }
        i4 = 0;
        label477:
        if (i4 != 0) {
          if (((View)localObject2).hasFocusable())
          {
            i5 = localLayoutParams.mSpanIndex;
            m = Math.min(i9, j);
            i4 = Math.max(i8, i);
            localObject1 = localObject2;
            m -= i4;
          }
          else
          {
            i6 = localLayoutParams.mSpanIndex;
            paramInt = Math.min(i9, j) - Math.max(i8, i);
            paramView = (View)localObject2;
          }
        }
      }
      i3 += n;
    }
    if (localObject1 == null) {
      localObject1 = paramView;
    }
    return (View)localObject1;
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, paramView.getViewLayoutPosition());
    if (this.mOrientation == 0) {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(paramView.getSpanIndex(), paramView.getSpanSize(), i, 1, false, false));
    } else {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, paramView.getSpanIndex(), paramView.getSpanSize(), false, false));
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      paramInt2 = RecyclerView.LayoutManager.chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramRect = this.mCachedBorders;
      j = RecyclerView.LayoutManager.chooseSize(paramInt1, paramRect[(paramRect.length - 1)] + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    else
    {
      paramInt1 = RecyclerView.LayoutManager.chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramRect = this.mCachedBorders;
      j = RecyclerView.LayoutManager.chooseSize(paramInt2, paramRect[(paramRect.length - 1)] + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = j;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount) {
      return;
    }
    this.mPendingSpanCountChange = true;
    if (paramInt >= 1)
    {
      this.mSpanCount = paramInt;
      this.mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Span count should be at least 1. Provided ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.setStackFromEnd(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public void setUsingSpansToEstimateScrollbarDimensions(boolean paramBoolean)
  {
    this.mUsingSpansToEstimateScrollBarDimensions = paramBoolean;
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    boolean bool;
    if ((this.mPendingSavedState == null) && (!this.mPendingSpanCountChange)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final class DefaultSpanSizeLookup
    extends GridLayoutManager.SpanSizeLookup
  {
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    int mSpanIndex = -1;
    int mSpanSize = 0;
    
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
    
    public int getSpanIndex()
    {
      return this.mSpanIndex;
    }
    
    public int getSpanSize()
    {
      return this.mSpanSize;
    }
  }
  
  public static abstract class SpanSizeLookup
  {
    private boolean mCacheSpanGroupIndices = false;
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    static int findFirstKeyLessThan(SparseIntArray paramSparseIntArray, int paramInt)
    {
      int i = paramSparseIntArray.size() - 1;
      int j = 0;
      while (j <= i)
      {
        int k = j + i >>> 1;
        if (paramSparseIntArray.keyAt(k) < paramInt) {
          j = k + 1;
        } else {
          i = k - 1;
        }
      }
      paramInt = j - 1;
      if ((paramInt >= 0) && (paramInt < paramSparseIntArray.size())) {
        return paramSparseIntArray.keyAt(paramInt);
      }
      return -1;
    }
    
    int getCachedSpanGroupIndex(int paramInt1, int paramInt2)
    {
      if (!this.mCacheSpanGroupIndices) {
        return getSpanGroupIndex(paramInt1, paramInt2);
      }
      int i = this.mSpanGroupIndexCache.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getSpanGroupIndex(paramInt1, paramInt2);
      this.mSpanGroupIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      if (!this.mCacheSpanIndices) {
        return getSpanIndex(paramInt1, paramInt2);
      }
      int i = this.mSpanIndexCache.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      this.mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int j;
      int m;
      if (this.mCacheSpanGroupIndices)
      {
        i = findFirstKeyLessThan(this.mSpanGroupIndexCache, paramInt1);
        if (i != -1)
        {
          j = this.mSpanGroupIndexCache.get(i);
          k = i + 1;
          m = getCachedSpanIndex(i, paramInt2) + getSpanSize(i);
          n = j;
          i = k;
          i1 = m;
          if (m != paramInt2) {
            break label87;
          }
          n = j + 1;
          i = k;
          break label84;
        }
      }
      int n = 0;
      int i = 0;
      label84:
      int i1 = 0;
      label87:
      int i2 = getSpanSize(paramInt1);
      int k = i;
      while (k < paramInt1)
      {
        j = getSpanSize(k);
        m = i1 + j;
        if (m == paramInt2)
        {
          i1 = n + 1;
          i = 0;
        }
        else
        {
          i1 = n;
          i = m;
          if (m > paramInt2)
          {
            i1 = n + 1;
            i = j;
          }
        }
        k++;
        n = i1;
        i1 = i;
      }
      paramInt1 = n;
      if (i1 + i2 > paramInt2) {
        paramInt1 = n + 1;
      }
      return paramInt1;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int i = getSpanSize(paramInt1);
      if (i == paramInt2) {
        return 0;
      }
      int j;
      if (this.mCacheSpanIndices)
      {
        j = findFirstKeyLessThan(this.mSpanIndexCache, paramInt1);
        if (j >= 0)
        {
          k = this.mSpanIndexCache.get(j) + getSpanSize(j);
          break label121;
        }
      }
      int m = 0;
      int k = 0;
      while (m < paramInt1)
      {
        int n = getSpanSize(m);
        int i1 = k + n;
        if (i1 == paramInt2)
        {
          k = 0;
          j = m;
        }
        else
        {
          j = m;
          k = i1;
          if (i1 > paramInt2)
          {
            k = n;
            j = m;
          }
        }
        label121:
        m = j + 1;
      }
      if (i + k <= paramInt2) {
        return k;
      }
      return 0;
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public void invalidateSpanGroupIndexCache()
    {
      this.mSpanGroupIndexCache.clear();
    }
    
    public void invalidateSpanIndexCache()
    {
      this.mSpanIndexCache.clear();
    }
    
    public boolean isSpanGroupIndexCacheEnabled()
    {
      return this.mCacheSpanGroupIndices;
    }
    
    public boolean isSpanIndexCacheEnabled()
    {
      return this.mCacheSpanIndices;
    }
    
    public void setSpanGroupIndexCacheEnabled(boolean paramBoolean)
    {
      if (!paramBoolean) {
        this.mSpanGroupIndexCache.clear();
      }
      this.mCacheSpanGroupIndices = paramBoolean;
    }
    
    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      if (!paramBoolean) {
        this.mSpanGroupIndexCache.clear();
      }
      this.mCacheSpanIndices = paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */