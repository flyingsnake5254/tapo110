package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import java.util.Locale;

final class ScrollEventAdapter
  extends RecyclerView.OnScrollListener
{
  private static final int NO_POSITION = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
  private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
  private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
  private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
  private int mAdapterState;
  private ViewPager2.OnPageChangeCallback mCallback;
  private boolean mDataSetChangeHappened;
  private boolean mDispatchSelected;
  private int mDragStartPosition;
  private boolean mFakeDragging;
  @NonNull
  private final LinearLayoutManager mLayoutManager;
  @NonNull
  private final RecyclerView mRecyclerView;
  private boolean mScrollHappened;
  private int mScrollState;
  private ScrollEventValues mScrollValues;
  private int mTarget;
  @NonNull
  private final ViewPager2 mViewPager;
  
  ScrollEventAdapter(@NonNull ViewPager2 paramViewPager2)
  {
    this.mViewPager = paramViewPager2;
    paramViewPager2 = paramViewPager2.mRecyclerView;
    this.mRecyclerView = paramViewPager2;
    this.mLayoutManager = ((LinearLayoutManager)paramViewPager2.getLayoutManager());
    this.mScrollValues = new ScrollEventValues();
    resetState();
  }
  
  private void dispatchScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchSelected(int paramInt)
  {
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageSelected(paramInt);
    }
  }
  
  private void dispatchStateChanged(int paramInt)
  {
    if ((this.mAdapterState == 3) && (this.mScrollState == 0)) {
      return;
    }
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    ViewPager2.OnPageChangeCallback localOnPageChangeCallback = this.mCallback;
    if (localOnPageChangeCallback != null) {
      localOnPageChangeCallback.onPageScrollStateChanged(paramInt);
    }
  }
  
  private int getPosition()
  {
    return this.mLayoutManager.findFirstVisibleItemPosition();
  }
  
  private boolean isInAnyDraggingState()
  {
    int i = this.mAdapterState;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != 1) {
      if (i == 4) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private void resetState()
  {
    this.mAdapterState = 0;
    this.mScrollState = 0;
    this.mScrollValues.reset();
    this.mDragStartPosition = -1;
    this.mTarget = -1;
    this.mDispatchSelected = false;
    this.mScrollHappened = false;
    this.mFakeDragging = false;
    this.mDataSetChangeHappened = false;
  }
  
  private void startDrag(boolean paramBoolean)
  {
    this.mFakeDragging = paramBoolean;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 1;
    }
    this.mAdapterState = i;
    int i = this.mTarget;
    if (i != -1)
    {
      this.mDragStartPosition = i;
      this.mTarget = -1;
    }
    else if (this.mDragStartPosition == -1)
    {
      this.mDragStartPosition = getPosition();
    }
    dispatchStateChanged(1);
  }
  
  private void updateScrollEventValues()
  {
    ScrollEventValues localScrollEventValues = this.mScrollValues;
    int i = this.mLayoutManager.findFirstVisibleItemPosition();
    localScrollEventValues.mPosition = i;
    if (i == -1)
    {
      localScrollEventValues.reset();
      return;
    }
    View localView = this.mLayoutManager.findViewByPosition(i);
    if (localView == null)
    {
      localScrollEventValues.reset();
      return;
    }
    int j = this.mLayoutManager.getLeftDecorationWidth(localView);
    int k = this.mLayoutManager.getRightDecorationWidth(localView);
    int m = this.mLayoutManager.getTopDecorationHeight(localView);
    int n = this.mLayoutManager.getBottomDecorationHeight(localView);
    Object localObject = localView.getLayoutParams();
    int i1 = j;
    int i2 = k;
    i = m;
    int i3 = n;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i1 = j + ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      i2 = k + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      i = m + ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      i3 = n + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    n = localView.getHeight() + i + i3;
    m = localView.getWidth();
    if (this.mLayoutManager.getOrientation() == 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (i3 != 0)
    {
      i3 = localView.getLeft() - i1 - this.mRecyclerView.getPaddingLeft();
      i = i3;
      if (this.mViewPager.isRtl()) {
        i = -i3;
      }
      i1 = m + i1 + i2;
      i2 = i;
      i = i1;
    }
    else
    {
      i2 = localView.getTop() - i - this.mRecyclerView.getPaddingTop();
      i = n;
    }
    i2 = -i2;
    localScrollEventValues.mOffsetPx = i2;
    if (i2 < 0)
    {
      if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
      }
      throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[] { Integer.valueOf(localScrollEventValues.mOffsetPx) }));
    }
    float f;
    if (i == 0) {
      f = 0.0F;
    } else {
      f = i2 / i;
    }
    localScrollEventValues.mOffset = f;
  }
  
  double getRelativeScrollPosition()
  {
    updateScrollEventValues();
    ScrollEventValues localScrollEventValues = this.mScrollValues;
    return localScrollEventValues.mPosition + localScrollEventValues.mOffset;
  }
  
  int getScrollState()
  {
    return this.mScrollState;
  }
  
  boolean isDragging()
  {
    int i = this.mScrollState;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  boolean isIdle()
  {
    boolean bool;
    if (this.mScrollState == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void notifyBeginFakeDrag()
  {
    this.mAdapterState = 4;
    startDrag(true);
  }
  
  void notifyDataSetChangeHappened()
  {
    this.mDataSetChangeHappened = true;
  }
  
  void notifyEndFakeDrag()
  {
    if ((isDragging()) && (!this.mFakeDragging)) {
      return;
    }
    this.mFakeDragging = false;
    updateScrollEventValues();
    ScrollEventValues localScrollEventValues = this.mScrollValues;
    if (localScrollEventValues.mOffsetPx == 0)
    {
      int i = localScrollEventValues.mPosition;
      if (i != this.mDragStartPosition) {
        dispatchSelected(i);
      }
      dispatchStateChanged(0);
      resetState();
    }
    else
    {
      dispatchStateChanged(2);
    }
  }
  
  void notifyProgrammaticScroll(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    this.mAdapterState = i;
    int i = 0;
    this.mFakeDragging = false;
    if (this.mTarget != paramInt) {
      i = 1;
    }
    this.mTarget = paramInt;
    dispatchStateChanged(2);
    if (i != 0) {
      dispatchSelected(paramInt);
    }
  }
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.mAdapterState;
    int j = 1;
    if (((i != 1) || (this.mScrollState != 1)) && (paramInt == 1))
    {
      startDrag(false);
      return;
    }
    if ((isInAnyDraggingState()) && (paramInt == 2))
    {
      if (this.mScrollHappened)
      {
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
      }
      return;
    }
    if ((isInAnyDraggingState()) && (paramInt == 0))
    {
      updateScrollEventValues();
      int k;
      if (!this.mScrollHappened)
      {
        k = this.mScrollValues.mPosition;
        i = j;
        if (k != -1)
        {
          dispatchScrolled(k, 0.0F, 0);
          i = j;
        }
      }
      else
      {
        paramRecyclerView = this.mScrollValues;
        if (paramRecyclerView.mOffsetPx == 0)
        {
          k = this.mDragStartPosition;
          int m = paramRecyclerView.mPosition;
          i = j;
          if (k != m)
          {
            dispatchSelected(m);
            i = j;
          }
        }
        else
        {
          i = 0;
        }
      }
      if (i != 0)
      {
        dispatchStateChanged(0);
        resetState();
      }
    }
    if ((this.mAdapterState == 2) && (paramInt == 0) && (this.mDataSetChangeHappened))
    {
      updateScrollEventValues();
      paramRecyclerView = this.mScrollValues;
      if (paramRecyclerView.mOffsetPx == 0)
      {
        paramInt = this.mTarget;
        i = paramRecyclerView.mPosition;
        if (paramInt != i)
        {
          paramInt = i;
          if (i == -1) {
            paramInt = 0;
          }
          dispatchSelected(paramInt);
        }
        dispatchStateChanged(0);
        resetState();
      }
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mScrollHappened = true;
    updateScrollEventValues();
    if (this.mDispatchSelected)
    {
      this.mDispatchSelected = false;
      if (paramInt2 <= 0) {
        if (paramInt2 == 0)
        {
          int i;
          if (paramInt1 < 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == this.mViewPager.isRtl()) {}
        }
        else
        {
          paramInt1 = 0;
          break label64;
        }
      }
      paramInt1 = 1;
      label64:
      if (paramInt1 != 0)
      {
        paramRecyclerView = this.mScrollValues;
        if (paramRecyclerView.mOffsetPx != 0)
        {
          paramInt1 = paramRecyclerView.mPosition + 1;
          break label98;
        }
      }
      paramInt1 = this.mScrollValues.mPosition;
      label98:
      this.mTarget = paramInt1;
      if (this.mDragStartPosition != paramInt1) {
        dispatchSelected(paramInt1);
      }
    }
    else if (this.mAdapterState == 0)
    {
      paramInt2 = this.mScrollValues.mPosition;
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = 0;
      }
      dispatchSelected(paramInt1);
    }
    paramRecyclerView = this.mScrollValues;
    paramInt2 = paramRecyclerView.mPosition;
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 0;
    }
    dispatchScrolled(paramInt1, paramRecyclerView.mOffset, paramRecyclerView.mOffsetPx);
    paramRecyclerView = this.mScrollValues;
    paramInt2 = paramRecyclerView.mPosition;
    paramInt1 = this.mTarget;
    if (((paramInt2 == paramInt1) || (paramInt1 == -1)) && (paramRecyclerView.mOffsetPx == 0) && (this.mScrollState != 1))
    {
      dispatchStateChanged(0);
      resetState();
    }
  }
  
  void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mCallback = paramOnPageChangeCallback;
  }
  
  private static final class ScrollEventValues
  {
    float mOffset;
    int mOffsetPx;
    int mPosition;
    
    void reset()
    {
      this.mPosition = -1;
      this.mOffset = 0.0F;
      this.mOffsetPx = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager2\widget\ScrollEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */