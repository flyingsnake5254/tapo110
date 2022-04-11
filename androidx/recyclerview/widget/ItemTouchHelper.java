package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R.dimen;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  static final int ACTION_MODE_DRAG_MASK = 16711680;
  private static final int ACTION_MODE_IDLE_MASK = 255;
  static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  private static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  private static final boolean DEBUG = false;
  static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  private static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  private static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  private int mActionState = 0;
  int mActivePointerId = -1;
  @NonNull
  Callback mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
  private float mMaxSwipeVelocity;
  private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener()
  {
    public boolean onInterceptTouchEvent(@NonNull RecyclerView paramAnonymousRecyclerView, @NonNull MotionEvent paramAnonymousMotionEvent)
    {
      ItemTouchHelper.this.mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      boolean bool = true;
      if (i == 0)
      {
        ItemTouchHelper.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        ItemTouchHelper.this.mInitialTouchX = paramAnonymousMotionEvent.getX();
        ItemTouchHelper.this.mInitialTouchY = paramAnonymousMotionEvent.getY();
        ItemTouchHelper.this.obtainVelocityTracker();
        paramAnonymousRecyclerView = ItemTouchHelper.this;
        if (paramAnonymousRecyclerView.mSelected == null)
        {
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.findAnimation(paramAnonymousMotionEvent);
          if (paramAnonymousRecyclerView != null)
          {
            ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
            localItemTouchHelper.mInitialTouchX -= paramAnonymousRecyclerView.mX;
            localItemTouchHelper.mInitialTouchY -= paramAnonymousRecyclerView.mY;
            localItemTouchHelper.endRecoverAnimation(paramAnonymousRecyclerView.mViewHolder, true);
            if (ItemTouchHelper.this.mPendingCleanup.remove(paramAnonymousRecyclerView.mViewHolder.itemView))
            {
              localItemTouchHelper = ItemTouchHelper.this;
              localItemTouchHelper.mCallback.clearView(localItemTouchHelper.mRecyclerView, paramAnonymousRecyclerView.mViewHolder);
            }
            ItemTouchHelper.this.select(paramAnonymousRecyclerView.mViewHolder, paramAnonymousRecyclerView.mActionState);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, paramAnonymousRecyclerView.mSelectedFlags, 0);
          }
        }
      }
      else if ((i != 3) && (i != 1))
      {
        int j = ItemTouchHelper.this.mActivePointerId;
        if (j != -1)
        {
          j = paramAnonymousMotionEvent.findPointerIndex(j);
          if (j >= 0) {
            ItemTouchHelper.this.checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      else
      {
        paramAnonymousRecyclerView = ItemTouchHelper.this;
        paramAnonymousRecyclerView.mActivePointerId = -1;
        paramAnonymousRecyclerView.select(null, 0);
      }
      paramAnonymousRecyclerView = ItemTouchHelper.this.mVelocityTracker;
      if (paramAnonymousRecyclerView != null) {
        paramAnonymousRecyclerView.addMovement(paramAnonymousMotionEvent);
      }
      if (ItemTouchHelper.this.mSelected == null) {
        bool = false;
      }
      return bool;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      ItemTouchHelper.this.select(null, 0);
    }
    
    public void onTouchEvent(@NonNull RecyclerView paramAnonymousRecyclerView, @NonNull MotionEvent paramAnonymousMotionEvent)
    {
      ItemTouchHelper.this.mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      paramAnonymousRecyclerView = ItemTouchHelper.this.mVelocityTracker;
      if (paramAnonymousRecyclerView != null) {
        paramAnonymousRecyclerView.addMovement(paramAnonymousMotionEvent);
      }
      if (ItemTouchHelper.this.mActivePointerId == -1) {
        return;
      }
      int i = paramAnonymousMotionEvent.getActionMasked();
      int j = paramAnonymousMotionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
      if (j >= 0) {
        ItemTouchHelper.this.checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
      }
      paramAnonymousRecyclerView = ItemTouchHelper.this;
      RecyclerView.ViewHolder localViewHolder = paramAnonymousRecyclerView.mSelected;
      if (localViewHolder == null) {
        return;
      }
      int k = 0;
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              return;
            }
            j = paramAnonymousMotionEvent.getActionIndex();
            i = paramAnonymousMotionEvent.getPointerId(j);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            if (i != paramAnonymousRecyclerView.mActivePointerId) {
              return;
            }
            if (j == 0) {
              k = 1;
            }
            paramAnonymousRecyclerView.mActivePointerId = paramAnonymousMotionEvent.getPointerId(k);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, paramAnonymousRecyclerView.mSelectedFlags, j);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.mVelocityTracker;
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.clear();
          }
        }
        else
        {
          if (j < 0) {
            return;
          }
          paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, paramAnonymousRecyclerView.mSelectedFlags, j);
          ItemTouchHelper.this.moveIfNecessary(localViewHolder);
          paramAnonymousRecyclerView = ItemTouchHelper.this;
          paramAnonymousRecyclerView.mRecyclerView.removeCallbacks(paramAnonymousRecyclerView.mScrollRunnable);
          ItemTouchHelper.this.mScrollRunnable.run();
          ItemTouchHelper.this.mRecyclerView.invalidate();
          return;
        }
      }
      ItemTouchHelper.this.select(null, 0);
      ItemTouchHelper.this.mActivePointerId = -1;
    }
  };
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  @VisibleForTesting
  List<RecoverAnimation> mRecoverAnimations = new ArrayList();
  RecyclerView mRecyclerView;
  final Runnable mScrollRunnable = new Runnable()
  {
    public void run()
    {
      ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
      if ((localItemTouchHelper.mSelected != null) && (localItemTouchHelper.scrollIfNecessary()))
      {
        localItemTouchHelper = ItemTouchHelper.this;
        RecyclerView.ViewHolder localViewHolder = localItemTouchHelper.mSelected;
        if (localViewHolder != null) {
          localItemTouchHelper.moveIfNecessary(localViewHolder);
        }
        localItemTouchHelper = ItemTouchHelper.this;
        localItemTouchHelper.mRecyclerView.removeCallbacks(localItemTouchHelper.mScrollRunnable);
        ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
      }
    }
  };
  RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  private float mSelectedStartX;
  private float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  private float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(@NonNull Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.mChildDrawingOrderCallback == null) {
      this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback()
      {
        public int onGetChildDrawingOrder(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
          View localView = localItemTouchHelper.mOverdrawChild;
          if (localView == null) {
            return paramAnonymousInt2;
          }
          int i = localItemTouchHelper.mOverdrawChildPosition;
          int j = i;
          if (i == -1)
          {
            j = localItemTouchHelper.mRecyclerView.indexOfChild(localView);
            ItemTouchHelper.this.mOverdrawChildPosition = j;
          }
          if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
            return j;
          }
          if (paramAnonymousInt2 >= j) {
            paramAnonymousInt2++;
          }
          return paramAnonymousInt2;
        }
      };
    }
    this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = this.mDx;
      int i = 8;
      int j;
      if (f1 > 0.0F) {
        j = 8;
      } else {
        j = 4;
      }
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if ((localVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          i = 4;
        }
        f2 = Math.abs(f2);
        if (((i & paramInt) != 0) && (j == i) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return i;
        }
      }
      f1 = this.mRecyclerView.getWidth();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & j) != 0) && (Math.abs(this.mDx) > f1 * f2)) {
        return j;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = this.mDy;
      int i = 2;
      int j;
      if (f1 > 0.0F) {
        j = 2;
      } else {
        j = 1;
      }
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if ((localVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 <= 0.0F) {
          i = 1;
        }
        f2 = Math.abs(f2);
        if (((i & paramInt) != 0) && (i == j) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return i;
        }
      }
      float f2 = this.mRecyclerView.getHeight();
      f1 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & j) != 0) && (Math.abs(this.mDy) > f2 * f1)) {
        return j;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeItemDecoration(this);
    this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
    for (int i = this.mRecoverAnimations.size() - 1; i >= 0; i--)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(0);
      localRecoverAnimation.cancel();
      this.mCallback.clearView(this.mRecyclerView, localRecoverAnimation.mViewHolder);
    }
    this.mRecoverAnimations.clear();
    this.mOverdrawChild = null;
    this.mOverdrawChildPosition = -1;
    releaseVelocityTracker();
    stopGestureDetection();
  }
  
  private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject1 = paramViewHolder;
    Object localObject2 = this.mSwapTargets;
    if (localObject2 == null)
    {
      this.mSwapTargets = new ArrayList();
      this.mDistances = new ArrayList();
    }
    else
    {
      ((List)localObject2).clear();
      this.mDistances.clear();
    }
    int i = this.mCallback.getBoundingBoxMargin();
    int j = Math.round(this.mSelectedStartX + this.mDx) - i;
    int k = Math.round(this.mSelectedStartY + this.mDy) - i;
    int m = ((RecyclerView.ViewHolder)localObject1).itemView.getWidth();
    i *= 2;
    int n = m + j + i;
    int i1 = ((RecyclerView.ViewHolder)localObject1).itemView.getHeight() + k + i;
    int i2 = (j + n) / 2;
    int i3 = (k + i1) / 2;
    localObject1 = this.mRecyclerView.getLayoutManager();
    int i4 = ((RecyclerView.LayoutManager)localObject1).getChildCount();
    for (i = 0; i < i4; i++)
    {
      localObject2 = ((RecyclerView.LayoutManager)localObject1).getChildAt(i);
      if ((localObject2 != paramViewHolder.itemView) && (((View)localObject2).getBottom() >= k) && (((View)localObject2).getTop() <= i1) && (((View)localObject2).getRight() >= j) && (((View)localObject2).getLeft() <= n))
      {
        RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder((View)localObject2);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, localViewHolder))
        {
          m = Math.abs(i2 - (((View)localObject2).getLeft() + ((View)localObject2).getRight()) / 2);
          int i5 = Math.abs(i3 - (((View)localObject2).getTop() + ((View)localObject2).getBottom()) / 2);
          int i6 = m * m + i5 * i5;
          int i7 = this.mSwapTargets.size();
          i5 = 0;
          m = 0;
          while ((i5 < i7) && (i6 > ((Integer)this.mDistances.get(i5)).intValue()))
          {
            m++;
            i5++;
          }
          this.mSwapTargets.add(m, localViewHolder);
          this.mDistances.add(m, Integer.valueOf(i6));
        }
      }
    }
    return this.mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    int i = this.mActivePointerId;
    if (i == -1) {
      return null;
    }
    i = paramMotionEvent.findPointerIndex(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = this.mInitialTouchX;
    float f3 = paramMotionEvent.getY(i);
    float f4 = this.mInitialTouchY;
    f1 = Math.abs(f1 - f2);
    f4 = Math.abs(f3 - f4);
    i = this.mSlop;
    if ((f1 < i) && (f4 < i)) {
      return null;
    }
    if ((f1 > f4) && (localLayoutManager.canScrollHorizontally())) {
      return null;
    }
    if ((f4 > f1) && (localLayoutManager.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return this.mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((this.mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.mSelectedStartX + this.mDx - this.mSelected.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = this.mSelected.itemView.getTranslationX();
    }
    if ((this.mSelectedFlags & 0x3) != 0) {
      paramArrayOfFloat[1] = (this.mSelectedStartY + this.mDy - this.mSelected.itemView.getTop());
    } else {
      paramArrayOfFloat[1] = this.mSelected.itemView.getTranslationY();
    }
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boolean bool;
    if ((paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void releaseVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    startGestureDetection();
  }
  
  private void startGestureDetection()
  {
    this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
    this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
  }
  
  private void stopGestureDetection()
  {
    ItemTouchHelperGestureListener localItemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
    if (localItemTouchHelperGestureListener != null)
    {
      localItemTouchHelperGestureListener.doNotReactToLongPress();
      this.mItemTouchHelperGestureListener = null;
    }
    if (this.mGestureDetector != null) {
      this.mGestureDetector = null;
    }
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mActionState == 2) {
      return 0;
    }
    int i = this.mCallback.getMovementFlags(this.mRecyclerView, paramViewHolder);
    int j = (this.mCallback.convertToAbsoluteDirection(i, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 0xFF00) >> 8;
    if (j == 0) {
      return 0;
    }
    int k = (i & 0xFF00) >> 8;
    if (Math.abs(this.mDx) > Math.abs(this.mDy))
    {
      i = checkHorizontalSwipe(paramViewHolder, j);
      if (i > 0)
      {
        if ((k & i) == 0) {
          return Callback.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return i;
      }
      j = checkVerticalSwipe(paramViewHolder, j);
      if (j > 0) {
        return j;
      }
    }
    else
    {
      i = checkVerticalSwipe(paramViewHolder, j);
      if (i > 0) {
        return i;
      }
      i = checkHorizontalSwipe(paramViewHolder, j);
      if (i > 0)
      {
        j = i;
        if ((k & i) == 0) {
          j = Callback.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return j;
      }
    }
    return 0;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    this.mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      this.mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      setupCallbacks();
    }
  }
  
  void checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.mSelected == null) && (paramInt1 == 2) && (this.mActionState != 2) && (this.mCallback.isItemViewSwipeEnabled()))
    {
      if (this.mRecyclerView.getScrollState() == 1) {
        return;
      }
      RecyclerView.ViewHolder localViewHolder = findSwipedView(paramMotionEvent);
      if (localViewHolder == null) {
        return;
      }
      paramInt1 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, localViewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= this.mInitialTouchX;
      f2 -= this.mInitialTouchY;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = this.mSlop;
      if ((f3 < paramInt2) && (f4 < paramInt2)) {
        return;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return;
        }
        if ((f1 <= 0.0F) || ((paramInt1 & 0x8) != 0)) {}
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return;
        }
      }
      this.mDy = 0.0F;
      this.mDx = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localViewHolder, 1);
    }
  }
  
  void endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    for (int i = this.mRecoverAnimations.size() - 1; i >= 0; i--)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(i);
      if (localRecoverAnimation.mViewHolder == paramViewHolder)
      {
        localRecoverAnimation.mOverridden |= paramBoolean;
        if (!localRecoverAnimation.mEnded) {
          localRecoverAnimation.cancel();
        }
        this.mRecoverAnimations.remove(i);
        return;
      }
    }
  }
  
  RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (this.mRecoverAnimations.isEmpty()) {
      return null;
    }
    View localView = findChildView(paramMotionEvent);
    for (int i = this.mRecoverAnimations.size() - 1; i >= 0; i--)
    {
      paramMotionEvent = (RecoverAnimation)this.mRecoverAnimations.get(i);
      if (paramMotionEvent.mViewHolder.itemView == localView) {
        return paramMotionEvent;
      }
    }
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = this.mSelected;
    if (paramMotionEvent != null)
    {
      paramMotionEvent = paramMotionEvent.itemView;
      if (hitTest(paramMotionEvent, f1, f2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
        return paramMotionEvent;
      }
    }
    for (int i = this.mRecoverAnimations.size() - 1; i >= 0; i--)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(i);
      paramMotionEvent = localRecoverAnimation.mViewHolder.itemView;
      if (hitTest(paramMotionEvent, f1, f2, localRecoverAnimation.mX, localRecoverAnimation.mY)) {
        return paramMotionEvent;
      }
    }
    return this.mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  boolean hasRunningRecoverAnim()
  {
    int i = this.mRecoverAnimations.size();
    for (int j = 0; j < i; j++) {
      if (!((RecoverAnimation)this.mRecoverAnimations.get(j)).mEnded) {
        return true;
      }
    }
    return false;
  }
  
  void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mRecyclerView.isLayoutRequested()) {
      return;
    }
    if (this.mActionState != 2) {
      return;
    }
    float f = this.mCallback.getMoveThreshold(paramViewHolder);
    int i = (int)(this.mSelectedStartX + this.mDx);
    int j = (int)(this.mSelectedStartY + this.mDy);
    if ((Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f) && (Math.abs(i - paramViewHolder.itemView.getLeft()) < paramViewHolder.itemView.getWidth() * f)) {
      return;
    }
    Object localObject = findSwapTargets(paramViewHolder);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = this.mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
    if (localObject == null)
    {
      this.mSwapTargets.clear();
      this.mDistances.clear();
      return;
    }
    int k = ((RecyclerView.ViewHolder)localObject).getAbsoluteAdapterPosition();
    int m = paramViewHolder.getAbsoluteAdapterPosition();
    if (this.mCallback.onMove(this.mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject)) {
      this.mCallback.onMoved(this.mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
    }
  }
  
  void obtainVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildViewDetachedFromWindow(@NonNull View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = this.mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    RecyclerView.ViewHolder localViewHolder = this.mSelected;
    if ((localViewHolder != null) && (paramView == localViewHolder))
    {
      select(null, 0);
    }
    else
    {
      endRecoverAnimation(paramView, false);
      if (this.mPendingCleanup.remove(paramView.itemView)) {
        this.mCallback.clearView(this.mRecyclerView, paramView);
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    this.mOverdrawChildPosition = -1;
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      paramState = this.mTmpPosition;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDraw(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      paramState = this.mTmpPosition;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDrawOver(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  void postDispatchSwipe(final RecoverAnimation paramRecoverAnimation, final int paramInt)
  {
    this.mRecyclerView.post(new Runnable()
    {
      public void run()
      {
        Object localObject = ItemTouchHelper.this.mRecyclerView;
        if ((localObject != null) && (((RecyclerView)localObject).isAttachedToWindow()))
        {
          localObject = paramRecoverAnimation;
          if ((!((ItemTouchHelper.RecoverAnimation)localObject).mOverridden) && (((ItemTouchHelper.RecoverAnimation)localObject).mViewHolder.getAbsoluteAdapterPosition() != -1))
          {
            localObject = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
            if (((localObject == null) || (!((RecyclerView.ItemAnimator)localObject).isRunning(null))) && (!ItemTouchHelper.this.hasRunningRecoverAnim())) {
              ItemTouchHelper.this.mCallback.onSwiped(paramRecoverAnimation.mViewHolder, paramInt);
            } else {
              ItemTouchHelper.this.mRecyclerView.post(this);
            }
          }
        }
      }
    });
  }
  
  void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == this.mOverdrawChild)
    {
      this.mOverdrawChild = null;
      if (this.mChildDrawingOrderCallback != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  boolean scrollIfNecessary()
  {
    if (this.mSelected == null)
    {
      this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.mDragScrollStartTimeInMs;
    if (l2 == Long.MIN_VALUE) {
      l2 = 0L;
    } else {
      l2 = l1 - l2;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (this.mTmpRect == null) {
      this.mTmpRect = new Rect();
    }
    localLayoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
    float f;
    if (localLayoutManager.canScrollHorizontally())
    {
      i = (int)(this.mSelectedStartX + this.mDx);
      j = i - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
      f = this.mDx;
      if ((f < 0.0F) && (j < 0)) {
        break label203;
      }
      if (f > 0.0F)
      {
        j = i + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (j > 0) {
          break label203;
        }
      }
    }
    int j = 0;
    label203:
    if (localLayoutManager.canScrollVertically())
    {
      k = (int)(this.mSelectedStartY + this.mDy);
      i = k - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
      f = this.mDy;
      if ((f < 0.0F) && (i < 0)) {
        break label321;
      }
      if (f > 0.0F)
      {
        i = k + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (i > 0) {
          break label321;
        }
      }
    }
    int i = 0;
    label321:
    int k = j;
    if (j != 0) {
      k = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), j, this.mRecyclerView.getWidth(), l2);
    }
    if (i != 0) {
      i = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), i, this.mRecyclerView.getHeight(), l2);
    }
    if ((k == 0) && (i == 0))
    {
      this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
      this.mDragScrollStartTimeInMs = l1;
    }
    this.mRecyclerView.scrollBy(k, i);
    return true;
  }
  
  void select(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.mSelected) && (paramInt == this.mActionState)) {
      return;
    }
    this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int i = this.mActionState;
    endRecoverAnimation(paramViewHolder, true);
    this.mActionState = paramInt;
    if (paramInt == 2) {
      if (paramViewHolder != null)
      {
        this.mOverdrawChild = paramViewHolder.itemView;
        addChildDrawingOrderCallback();
      }
      else
      {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
    }
    final Object localObject = this.mSelected;
    int k;
    if (localObject != null)
    {
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() != null)
      {
        final int j;
        if (i == 2) {
          j = 0;
        } else {
          j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
        }
        releaseVelocityTracker();
        float f1;
        float f2;
        if ((j != 1) && (j != 2))
        {
          if ((j != 4) && (j != 8) && (j != 16) && (j != 32)) {
            f1 = 0.0F;
          } else {
            f1 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
          }
          f2 = 0.0F;
        }
        else
        {
          f2 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
          f1 = 0.0F;
        }
        if (i == 2) {
          k = 8;
        } else if (j > 0) {
          k = 2;
        } else {
          k = 4;
        }
        getSelectedDxDy(this.mTmpPosition);
        float[] arrayOfFloat = this.mTmpPosition;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        localObject = new RecoverAnimation((RecyclerView.ViewHolder)localObject, k, i, f3, f4, f1, f2)
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            super.onAnimationEnd(paramAnonymousAnimator);
            if (this.mOverridden) {
              return;
            }
            if (j <= 0)
            {
              paramAnonymousAnimator = ItemTouchHelper.this;
              paramAnonymousAnimator.mCallback.clearView(paramAnonymousAnimator.mRecyclerView, localObject);
            }
            else
            {
              ItemTouchHelper.this.mPendingCleanup.add(localObject.itemView);
              this.mIsPendingCleanup = true;
              int i = j;
              if (i > 0) {
                ItemTouchHelper.this.postDispatchSwipe(this, i);
              }
            }
            ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
            paramAnonymousAnimator = localItemTouchHelper.mOverdrawChild;
            View localView = localObject.itemView;
            if (paramAnonymousAnimator == localView) {
              localItemTouchHelper.removeChildDrawingOrderCallbackIfNecessary(localView);
            }
          }
        };
        ((RecoverAnimation)localObject).setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, k, f1 - f3, f2 - f4));
        this.mRecoverAnimations.add(localObject);
        ((RecoverAnimation)localObject).start();
        k = 1;
      }
      else
      {
        removeChildDrawingOrderCallbackIfNecessary(((RecyclerView.ViewHolder)localObject).itemView);
        this.mCallback.clearView(this.mRecyclerView, (RecyclerView.ViewHolder)localObject);
        k = 0;
      }
      this.mSelected = null;
    }
    else
    {
      k = 0;
    }
    if (paramViewHolder != null)
    {
      this.mSelectedFlags = ((this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.mActionState * 8);
      this.mSelectedStartX = paramViewHolder.itemView.getLeft();
      this.mSelectedStartY = paramViewHolder.itemView.getTop();
      this.mSelected = paramViewHolder;
      if (paramInt == 2) {
        paramViewHolder.itemView.performHapticFeedback(0);
      }
    }
    paramViewHolder = this.mRecyclerView.getParent();
    if (paramViewHolder != null)
    {
      boolean bool;
      if (this.mSelected != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
    }
    if (k == 0) {
      this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
    this.mRecyclerView.invalidate();
  }
  
  public void startDrag(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasDragFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 2);
  }
  
  public void startSwipe(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 1);
  }
  
  void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    f1 -= this.mInitialTouchX;
    this.mDx = f1;
    this.mDy = (f2 - this.mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      this.mDx = Math.max(0.0F, f1);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.mDx = Math.min(0.0F, this.mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.mDy = Math.max(0.0F, this.mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.mDy = Math.min(0.0F, this.mDy);
    }
  }
  
  public static abstract class Callback
  {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    static final int RELATIVE_DIR_FLAGS = 3158064;
    private static final Interpolator sDragScrollInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
      }
    };
    private int mCachedMaxScrollSpeed = -1;
    
    public static int convertToRelativeDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      int j = paramInt1 & (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0)
      {
        paramInt1 = i << 2;
        paramInt2 = j;
      }
      for (;;)
      {
        return paramInt2 | paramInt1;
        paramInt1 = i << 1;
        paramInt2 = j | 0xFFF3F3F3 & paramInt1;
        paramInt1 = (paramInt1 & 0xC0C0C) << 2;
      }
    }
    
    @NonNull
    public static ItemTouchUIUtil getDefaultUIUtil()
    {
      return ItemTouchUIUtilImpl.INSTANCE;
    }
    
    private int getMaxDragScroll(RecyclerView paramRecyclerView)
    {
      if (this.mCachedMaxScrollSpeed == -1) {
        this.mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
      }
      return this.mCachedMaxScrollSpeed;
    }
    
    public static int makeFlag(int paramInt1, int paramInt2)
    {
      return paramInt2 << paramInt1 * 8;
    }
    
    public static int makeMovementFlags(int paramInt1, int paramInt2)
    {
      int i = makeFlag(0, paramInt2 | paramInt1);
      paramInt2 = makeFlag(1, paramInt2);
      return makeFlag(2, paramInt1) | paramInt2 | i;
    }
    
    public boolean canDropOver(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2)
    {
      return true;
    }
    
    public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
    {
      int i = paramViewHolder.itemView.getWidth();
      int j = paramViewHolder.itemView.getHeight();
      int k = paramInt1 - paramViewHolder.itemView.getLeft();
      int m = paramInt2 - paramViewHolder.itemView.getTop();
      int n = paramList.size();
      Object localObject1 = null;
      int i1 = -1;
      for (int i2 = 0; i2 < n; i2++)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(i2);
        Object localObject2 = localObject1;
        int i3 = i1;
        int i4;
        if (k > 0)
        {
          i4 = localViewHolder.itemView.getRight() - (paramInt1 + i);
          localObject2 = localObject1;
          i3 = i1;
          if (i4 < 0)
          {
            localObject2 = localObject1;
            i3 = i1;
            if (localViewHolder.itemView.getRight() > paramViewHolder.itemView.getRight())
            {
              i4 = Math.abs(i4);
              localObject2 = localObject1;
              i3 = i1;
              if (i4 > i1)
              {
                localObject2 = localViewHolder;
                i3 = i4;
              }
            }
          }
        }
        localObject1 = localObject2;
        i1 = i3;
        if (k < 0)
        {
          i4 = localViewHolder.itemView.getLeft() - paramInt1;
          localObject1 = localObject2;
          i1 = i3;
          if (i4 > 0)
          {
            localObject1 = localObject2;
            i1 = i3;
            if (localViewHolder.itemView.getLeft() < paramViewHolder.itemView.getLeft())
            {
              i4 = Math.abs(i4);
              localObject1 = localObject2;
              i1 = i3;
              if (i4 > i3)
              {
                localObject1 = localViewHolder;
                i1 = i4;
              }
            }
          }
        }
        localObject2 = localObject1;
        i3 = i1;
        if (m < 0)
        {
          i4 = localViewHolder.itemView.getTop() - paramInt2;
          localObject2 = localObject1;
          i3 = i1;
          if (i4 > 0)
          {
            localObject2 = localObject1;
            i3 = i1;
            if (localViewHolder.itemView.getTop() < paramViewHolder.itemView.getTop())
            {
              i4 = Math.abs(i4);
              localObject2 = localObject1;
              i3 = i1;
              if (i4 > i1)
              {
                localObject2 = localViewHolder;
                i3 = i4;
              }
            }
          }
        }
        localObject1 = localObject2;
        i1 = i3;
        if (m > 0)
        {
          i4 = localViewHolder.itemView.getBottom() - (paramInt2 + j);
          localObject1 = localObject2;
          i1 = i3;
          if (i4 < 0)
          {
            localObject1 = localObject2;
            i1 = i3;
            if (localViewHolder.itemView.getBottom() > paramViewHolder.itemView.getBottom())
            {
              i4 = Math.abs(i4);
              localObject1 = localObject2;
              i1 = i3;
              if (i4 > i3)
              {
                i1 = i4;
                localObject1 = localViewHolder;
              }
            }
          }
        }
      }
      return (RecyclerView.ViewHolder)localObject1;
    }
    
    public void clearView(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      ItemTouchUIUtilImpl.INSTANCE.clearView(paramViewHolder.itemView);
    }
    
    public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0) {}
      for (paramInt2 = i >> 2;; paramInt2 = (paramInt2 & 0x303030) >> 2)
      {
        return paramInt1 | paramInt2;
        paramInt2 = i >> 1;
        paramInt1 |= 0xFFCFCFCF & paramInt2;
      }
    }
    
    final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
    }
    
    public long getAnimationDuration(@NonNull RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      long l;
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          l = 200L;
        } else {
          l = 250L;
        }
        return l;
      }
      if (paramInt == 8) {
        l = paramRecyclerView.getMoveDuration();
      } else {
        l = paramRecyclerView.getRemoveDuration();
      }
      return l;
    }
    
    public int getBoundingBoxMargin()
    {
      return 0;
    }
    
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder);
    
    public float getSwipeEscapeVelocity(float paramFloat)
    {
      return paramFloat;
    }
    
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float paramFloat)
    {
      return paramFloat;
    }
    
    boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool;
      if ((getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean hasSwipeFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool;
      if ((getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF00) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int interpolateOutOfBoundsScroll(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      int i = getMaxDragScroll(paramRecyclerView);
      int j = Math.abs(paramInt2);
      paramInt3 = (int)Math.signum(paramInt2);
      float f1 = j;
      float f2 = 1.0F;
      f1 = Math.min(1.0F, f1 * 1.0F / paramInt1);
      paramInt1 = (int)(paramInt3 * i * sDragViewScrollCapInterpolator.getInterpolation(f1));
      if (paramLong <= 2000L) {
        f2 = (float)paramLong / 2000.0F;
      }
      paramInt3 = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f2));
      paramInt1 = paramInt3;
      if (paramInt3 == 0) {
        if (paramInt2 > 0) {
          paramInt1 = 1;
        } else {
          paramInt1 = -1;
        }
      }
      return paramInt1;
    }
    
    public boolean isItemViewSwipeEnabled()
    {
      return true;
    }
    
    public boolean isLongPressDragEnabled()
    {
      return true;
    }
    
    public void onChildDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDraw(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onChildDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDrawOver(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(j);
        localRecoverAnimation.update();
        int k = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
        paramCanvas.restoreToCount(k);
      }
      if (paramViewHolder != null)
      {
        j = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(j);
      }
    }
    
    void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int i = paramList.size();
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(k);
        int m = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
        paramCanvas.restoreToCount(m);
      }
      if (paramViewHolder != null)
      {
        k = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(k);
      }
      paramInt = i - 1;
      k = j;
      while (paramInt >= 0)
      {
        paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
        boolean bool = paramCanvas.mEnded;
        if ((bool) && (!paramCanvas.mIsPendingCleanup)) {
          paramList.remove(paramInt);
        } else if (!bool) {
          k = 1;
        }
        paramInt--;
      }
      if (k != 0) {
        paramRecyclerView.invalidate();
      }
    }
    
    public abstract boolean onMove(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2);
    
    public void onMoved(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, int paramInt1, @NonNull RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler))
      {
        ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
        return;
      }
      if (localLayoutManager.canScrollHorizontally())
      {
        if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
      if (localLayoutManager.canScrollVertically())
      {
        if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
    }
    
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramViewHolder != null) {
        ItemTouchUIUtilImpl.INSTANCE.onSelected(paramViewHolder.itemView);
      }
    }
    
    public abstract void onSwiped(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
  
  private class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private boolean mShouldReactToLongPress = true;
    
    ItemTouchHelperGestureListener() {}
    
    void doNotReactToLongPress()
    {
      this.mShouldReactToLongPress = false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.mShouldReactToLongPress) {
        return;
      }
      Object localObject = ItemTouchHelper.this.findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = ItemTouchHelper.this.mRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null)
        {
          ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
          if (!localItemTouchHelper.mCallback.hasDragFlag(localItemTouchHelper.mRecyclerView, (RecyclerView.ViewHolder)localObject)) {
            return;
          }
          int i = paramMotionEvent.getPointerId(0);
          int j = ItemTouchHelper.this.mActivePointerId;
          if (i == j)
          {
            i = paramMotionEvent.findPointerIndex(j);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            paramMotionEvent = ItemTouchHelper.this;
            paramMotionEvent.mInitialTouchX = f1;
            paramMotionEvent.mInitialTouchY = f2;
            paramMotionEvent.mDy = 0.0F;
            paramMotionEvent.mDx = 0.0F;
            if (paramMotionEvent.mCallback.isLongPressDragEnabled()) {
              ItemTouchHelper.this.select((RecyclerView.ViewHolder)localObject, 2);
            }
          }
        }
      }
    }
  }
  
  @VisibleForTesting
  static class RecoverAnimation
    implements Animator.AnimatorListener
  {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    private float mFraction;
    boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    @VisibleForTesting
    final ValueAnimator mValueAnimator;
    final RecyclerView.ViewHolder mViewHolder;
    float mX;
    float mY;
    
    RecoverAnimation(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mActionState = paramInt2;
      this.mAnimationType = paramInt1;
      this.mViewHolder = paramViewHolder;
      this.mStartDx = paramFloat1;
      this.mStartDy = paramFloat2;
      this.mTargetX = paramFloat3;
      this.mTargetY = paramFloat4;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.mValueAnimator = localValueAnimator;
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          ItemTouchHelper.RecoverAnimation.this.setFraction(paramAnonymousValueAnimator.getAnimatedFraction());
        }
      });
      localValueAnimator.setTarget(paramViewHolder.itemView);
      localValueAnimator.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel()
    {
      this.mValueAnimator.cancel();
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.mEnded) {
        this.mViewHolder.setIsRecyclable(true);
      }
      this.mEnded = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void setDuration(long paramLong)
    {
      this.mValueAnimator.setDuration(paramLong);
    }
    
    public void setFraction(float paramFloat)
    {
      this.mFraction = paramFloat;
    }
    
    public void start()
    {
      this.mViewHolder.setIsRecyclable(false);
      this.mValueAnimator.start();
    }
    
    public void update()
    {
      float f1 = this.mStartDx;
      float f2 = this.mTargetX;
      if (f1 == f2) {
        this.mX = this.mViewHolder.itemView.getTranslationX();
      } else {
        this.mX = (f1 + this.mFraction * (f2 - f1));
      }
      f2 = this.mStartDy;
      f1 = this.mTargetY;
      if (f2 == f1) {
        this.mY = this.mViewHolder.itemView.getTranslationY();
      } else {
        this.mY = (f2 + this.mFraction * (f1 - f2));
      }
    }
  }
  
  public static abstract class SimpleCallback
    extends ItemTouchHelper.Callback
  {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;
    
    public SimpleCallback(int paramInt1, int paramInt2)
    {
      this.mDefaultSwipeDirs = paramInt2;
      this.mDefaultDragDirs = paramInt1;
    }
    
    public int getDragDirs(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return this.mDefaultDragDirs;
    }
    
    public int getMovementFlags(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return ItemTouchHelper.Callback.makeMovementFlags(getDragDirs(paramRecyclerView, paramViewHolder), getSwipeDirs(paramRecyclerView, paramViewHolder));
    }
    
    public int getSwipeDirs(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return this.mDefaultSwipeDirs;
    }
    
    public void setDefaultDragDirs(int paramInt)
    {
      this.mDefaultDragDirs = paramInt;
    }
    
    public void setDefaultSwipeDirs(int paramInt)
    {
      this.mDefaultSwipeDirs = paramInt;
    }
  }
  
  public static abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ItemTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */