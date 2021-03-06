package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

@VisibleForTesting
class FastScroller
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnItemTouchListener
{
  private static final int ANIMATION_STATE_FADING_IN = 1;
  private static final int ANIMATION_STATE_FADING_OUT = 3;
  private static final int ANIMATION_STATE_IN = 2;
  private static final int ANIMATION_STATE_OUT = 0;
  private static final int DRAG_NONE = 0;
  private static final int DRAG_X = 1;
  private static final int DRAG_Y = 2;
  private static final int[] EMPTY_STATE_SET = new int[0];
  private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
  private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
  private static final int HIDE_DURATION_MS = 500;
  private static final int[] PRESSED_STATE_SET = { 16842919 };
  private static final int SCROLLBAR_FULL_OPAQUE = 255;
  private static final int SHOW_DURATION_MS = 500;
  private static final int STATE_DRAGGING = 2;
  private static final int STATE_HIDDEN = 0;
  private static final int STATE_VISIBLE = 1;
  int mAnimationState;
  private int mDragState = 0;
  private final Runnable mHideRunnable;
  @VisibleForTesting
  float mHorizontalDragX;
  private final int[] mHorizontalRange = new int[2];
  @VisibleForTesting
  int mHorizontalThumbCenterX;
  private final StateListDrawable mHorizontalThumbDrawable;
  private final int mHorizontalThumbHeight;
  @VisibleForTesting
  int mHorizontalThumbWidth;
  private final Drawable mHorizontalTrackDrawable;
  private final int mHorizontalTrackHeight;
  private final int mMargin;
  private boolean mNeedHorizontalScrollbar = false;
  private boolean mNeedVerticalScrollbar = false;
  private final RecyclerView.OnScrollListener mOnScrollListener;
  private RecyclerView mRecyclerView;
  private int mRecyclerViewHeight = 0;
  private int mRecyclerViewWidth = 0;
  private final int mScrollbarMinimumRange;
  final ValueAnimator mShowHideAnimator;
  private int mState = 0;
  @VisibleForTesting
  float mVerticalDragY;
  private final int[] mVerticalRange = new int[2];
  @VisibleForTesting
  int mVerticalThumbCenterY;
  final StateListDrawable mVerticalThumbDrawable;
  @VisibleForTesting
  int mVerticalThumbHeight;
  private final int mVerticalThumbWidth;
  final Drawable mVerticalTrackDrawable;
  private final int mVerticalTrackWidth;
  
  FastScroller(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mShowHideAnimator = localValueAnimator;
    this.mAnimationState = 0;
    this.mHideRunnable = new Runnable()
    {
      public void run()
      {
        FastScroller.this.hide(500);
      }
    };
    this.mOnScrollListener = new RecyclerView.OnScrollListener()
    {
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        FastScroller.this.updateScrollPosition(paramAnonymousRecyclerView.computeHorizontalScrollOffset(), paramAnonymousRecyclerView.computeVerticalScrollOffset());
      }
    };
    this.mVerticalThumbDrawable = paramStateListDrawable1;
    this.mVerticalTrackDrawable = paramDrawable1;
    this.mHorizontalThumbDrawable = paramStateListDrawable2;
    this.mHorizontalTrackDrawable = paramDrawable2;
    this.mVerticalThumbWidth = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.mVerticalTrackWidth = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.mHorizontalThumbHeight = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.mHorizontalTrackHeight = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.mScrollbarMinimumRange = paramInt2;
    this.mMargin = paramInt3;
    paramStateListDrawable1.setAlpha(255);
    paramDrawable1.setAlpha(255);
    localValueAnimator.addListener(new AnimatorListener());
    localValueAnimator.addUpdateListener(new AnimatorUpdater());
    attachToRecyclerView(paramRecyclerView);
  }
  
  private void cancelHide()
  {
    this.mRecyclerView.removeCallbacks(this.mHideRunnable);
  }
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeItemDecoration(this);
    this.mRecyclerView.removeOnItemTouchListener(this);
    this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
    cancelHide();
  }
  
  private void drawHorizontalScrollbar(Canvas paramCanvas)
  {
    int i = this.mRecyclerViewHeight;
    int j = this.mHorizontalThumbHeight;
    int k = i - j;
    int m = this.mHorizontalThumbCenterX;
    i = this.mHorizontalThumbWidth;
    m -= i / 2;
    this.mHorizontalThumbDrawable.setBounds(0, 0, i, j);
    this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
    paramCanvas.translate(0.0F, k);
    this.mHorizontalTrackDrawable.draw(paramCanvas);
    paramCanvas.translate(m, 0.0F);
    this.mHorizontalThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(-m, -k);
  }
  
  private void drawVerticalScrollbar(Canvas paramCanvas)
  {
    int i = this.mRecyclerViewWidth;
    int j = this.mVerticalThumbWidth;
    i -= j;
    int k = this.mVerticalThumbCenterY;
    int m = this.mVerticalThumbHeight;
    k -= m / 2;
    this.mVerticalThumbDrawable.setBounds(0, 0, j, m);
    this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
    if (isLayoutRTL())
    {
      this.mVerticalTrackDrawable.draw(paramCanvas);
      paramCanvas.translate(this.mVerticalThumbWidth, k);
      paramCanvas.scale(-1.0F, 1.0F);
      this.mVerticalThumbDrawable.draw(paramCanvas);
      paramCanvas.scale(-1.0F, 1.0F);
      paramCanvas.translate(-this.mVerticalThumbWidth, -k);
    }
    else
    {
      paramCanvas.translate(i, 0.0F);
      this.mVerticalTrackDrawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, k);
      this.mVerticalThumbDrawable.draw(paramCanvas);
      paramCanvas.translate(-i, -k);
    }
  }
  
  private int[] getHorizontalRange()
  {
    int[] arrayOfInt = this.mHorizontalRange;
    int i = this.mMargin;
    arrayOfInt[0] = i;
    arrayOfInt[1] = (this.mRecyclerViewWidth - i);
    return arrayOfInt;
  }
  
  private int[] getVerticalRange()
  {
    int[] arrayOfInt = this.mVerticalRange;
    int i = this.mMargin;
    arrayOfInt[0] = i;
    arrayOfInt[1] = (this.mRecyclerViewHeight - i);
    return arrayOfInt;
  }
  
  private void horizontalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getHorizontalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.mHorizontalThumbCenterX - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(this.mHorizontalDragX, paramFloat, arrayOfInt, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
    if (i != 0) {
      this.mRecyclerView.scrollBy(i, 0);
    }
    this.mHorizontalDragX = paramFloat;
  }
  
  private boolean isLayoutRTL()
  {
    int i = ViewCompat.getLayoutDirection(this.mRecyclerView);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private void resetHideDelay(int paramInt)
  {
    cancelHide();
    this.mRecyclerView.postDelayed(this.mHideRunnable, paramInt);
  }
  
  private int scrollTo(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i == 0) {
      return 0;
    }
    paramFloat1 = (paramFloat2 - paramFloat1) / i;
    paramInt3 = paramInt1 - paramInt3;
    paramInt1 = (int)(paramFloat1 * paramInt3);
    paramInt2 += paramInt1;
    if ((paramInt2 < paramInt3) && (paramInt2 >= 0)) {
      return paramInt1;
    }
    return 0;
  }
  
  private void setupCallbacks()
  {
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this);
    this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
  }
  
  private void verticalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getVerticalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.mVerticalThumbCenterY - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(this.mVerticalDragY, paramFloat, arrayOfInt, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
    if (i != 0) {
      this.mRecyclerView.scrollBy(0, i);
    }
    this.mVerticalDragY = paramFloat;
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
    if (paramRecyclerView != null) {
      setupCallbacks();
    }
  }
  
  @VisibleForTesting
  Drawable getHorizontalThumbDrawable()
  {
    return this.mHorizontalThumbDrawable;
  }
  
  @VisibleForTesting
  Drawable getHorizontalTrackDrawable()
  {
    return this.mHorizontalTrackDrawable;
  }
  
  @VisibleForTesting
  Drawable getVerticalThumbDrawable()
  {
    return this.mVerticalThumbDrawable;
  }
  
  @VisibleForTesting
  Drawable getVerticalTrackDrawable()
  {
    return this.mVerticalTrackDrawable;
  }
  
  @VisibleForTesting
  void hide(int paramInt)
  {
    int i = this.mAnimationState;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
    }
    else {
      this.mShowHideAnimator.cancel();
    }
    this.mAnimationState = 3;
    ValueAnimator localValueAnimator = this.mShowHideAnimator;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    this.mShowHideAnimator.setDuration(paramInt);
    this.mShowHideAnimator.start();
  }
  
  public boolean isDragging()
  {
    boolean bool;
    if (this.mState == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @VisibleForTesting
  boolean isPointInsideHorizontalThumb(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight)
    {
      int i = this.mHorizontalThumbCenterX;
      int j = this.mHorizontalThumbWidth;
      if ((paramFloat1 >= i - j / 2) && (paramFloat1 <= i + j / 2))
      {
        bool = true;
        break label59;
      }
    }
    boolean bool = false;
    label59:
    return bool;
  }
  
  @VisibleForTesting
  boolean isPointInsideVerticalThumb(float paramFloat1, float paramFloat2)
  {
    if (isLayoutRTL() ? paramFloat1 <= this.mVerticalThumbWidth : paramFloat1 >= this.mRecyclerViewWidth - this.mVerticalThumbWidth)
    {
      int i = this.mVerticalThumbCenterY;
      int j = this.mVerticalThumbHeight;
      if ((paramFloat2 >= i - j / 2) && (paramFloat2 <= i + j / 2))
      {
        bool = true;
        break label79;
      }
    }
    boolean bool = false;
    label79:
    return bool;
  }
  
  @VisibleForTesting
  boolean isVisible()
  {
    int i = this.mState;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((this.mRecyclerViewWidth == this.mRecyclerView.getWidth()) && (this.mRecyclerViewHeight == this.mRecyclerView.getHeight()))
    {
      if (this.mAnimationState != 0)
      {
        if (this.mNeedVerticalScrollbar) {
          drawVerticalScrollbar(paramCanvas);
        }
        if (this.mNeedHorizontalScrollbar) {
          drawHorizontalScrollbar(paramCanvas);
        }
      }
      return;
    }
    this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
    this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
    setState(0);
  }
  
  public boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
  {
    int i = this.mState;
    boolean bool1 = false;
    if (i == 1)
    {
      boolean bool2 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool3 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool4 = bool1;
      if (paramMotionEvent.getAction() != 0) {
        break label129;
      }
      if (!bool2)
      {
        bool4 = bool1;
        if (!bool3) {
          break label129;
        }
      }
      if (bool3)
      {
        this.mDragState = 1;
        this.mHorizontalDragX = ((int)paramMotionEvent.getX());
      }
      else if (bool2)
      {
        this.mDragState = 2;
        this.mVerticalDragY = ((int)paramMotionEvent.getY());
      }
      setState(2);
    }
    else
    {
      bool4 = bool1;
      if (i != 2) {
        break label129;
      }
    }
    boolean bool4 = true;
    label129:
    return bool4;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.mState == 0) {
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (bool2)
        {
          this.mDragState = 1;
          this.mHorizontalDragX = ((int)paramMotionEvent.getX());
        }
        else if (bool1)
        {
          this.mDragState = 2;
          this.mVerticalDragY = ((int)paramMotionEvent.getY());
        }
        setState(2);
      }
    }
    else if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
    {
      this.mVerticalDragY = 0.0F;
      this.mHorizontalDragX = 0.0F;
      setState(1);
      this.mDragState = 0;
    }
    else if ((paramMotionEvent.getAction() == 2) && (this.mState == 2))
    {
      show();
      if (this.mDragState == 1) {
        horizontalScrollTo(paramMotionEvent.getX());
      }
      if (this.mDragState == 2) {
        verticalScrollTo(paramMotionEvent.getY());
      }
    }
  }
  
  void requestRedraw()
  {
    this.mRecyclerView.invalidate();
  }
  
  void setState(int paramInt)
  {
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
      cancelHide();
    }
    if (paramInt == 0) {
      requestRedraw();
    } else {
      show();
    }
    if ((this.mState == 2) && (paramInt != 2))
    {
      this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
      resetHideDelay(1200);
    }
    else if (paramInt == 1)
    {
      resetHideDelay(1500);
    }
    this.mState = paramInt;
  }
  
  public void show()
  {
    int i = this.mAnimationState;
    if (i != 0)
    {
      if (i == 3) {
        this.mShowHideAnimator.cancel();
      }
    }
    else
    {
      this.mAnimationState = 1;
      ValueAnimator localValueAnimator = this.mShowHideAnimator;
      localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
      this.mShowHideAnimator.setDuration(500L);
      this.mShowHideAnimator.setStartDelay(0L);
      this.mShowHideAnimator.start();
    }
  }
  
  void updateScrollPosition(int paramInt1, int paramInt2)
  {
    int i = this.mRecyclerView.computeVerticalScrollRange();
    int j = this.mRecyclerViewHeight;
    boolean bool1;
    if ((i - j > 0) && (j >= this.mScrollbarMinimumRange)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mNeedVerticalScrollbar = bool1;
    int k = this.mRecyclerView.computeHorizontalScrollRange();
    int m = this.mRecyclerViewWidth;
    if ((k - m > 0) && (m >= this.mScrollbarMinimumRange)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mNeedHorizontalScrollbar = bool1;
    boolean bool2 = this.mNeedVerticalScrollbar;
    if ((!bool2) && (!bool1))
    {
      if (this.mState != 0) {
        setState(0);
      }
      return;
    }
    float f1;
    float f2;
    if (bool2)
    {
      f1 = paramInt2;
      f2 = j;
      this.mVerticalThumbCenterY = ((int)(f2 * (f1 + f2 / 2.0F) / i));
      this.mVerticalThumbHeight = Math.min(j, j * j / i);
    }
    if (this.mNeedHorizontalScrollbar)
    {
      f1 = paramInt1;
      f2 = m;
      this.mHorizontalThumbCenterX = ((int)(f2 * (f1 + f2 / 2.0F) / k));
      this.mHorizontalThumbWidth = Math.min(m, m * m / k);
    }
    paramInt1 = this.mState;
    if ((paramInt1 == 0) || (paramInt1 == 1)) {
      setState(1);
    }
  }
  
  private class AnimatorListener
    extends AnimatorListenerAdapter
  {
    private boolean mCanceled = false;
    
    AnimatorListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mCanceled)
      {
        this.mCanceled = false;
        return;
      }
      if (((Float)FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0F)
      {
        paramAnimator = FastScroller.this;
        paramAnimator.mAnimationState = 0;
        paramAnimator.setState(0);
      }
      else
      {
        paramAnimator = FastScroller.this;
        paramAnimator.mAnimationState = 2;
        paramAnimator.requestRedraw();
      }
    }
  }
  
  private class AnimatorUpdater
    implements ValueAnimator.AnimatorUpdateListener
  {
    AnimatorUpdater() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      FastScroller.this.mVerticalThumbDrawable.setAlpha(i);
      FastScroller.this.mVerticalTrackDrawable.setAlpha(i);
      FastScroller.this.requestRedraw();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\FastScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */