package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private static final boolean DEBUG = false;
  private static final boolean DEFAULT_DITHER = true;
  private static final String TAG = "DrawableContainer";
  private int mAlpha = 255;
  private Runnable mAnimationRunnable;
  private BlockInvalidateCallback mBlockInvalidateCallback;
  private int mCurIndex = -1;
  private Drawable mCurrDrawable;
  private DrawableContainerState mDrawableContainerState;
  private long mEnterAnimationEnd;
  private long mExitAnimationEnd;
  private boolean mHasAlpha;
  private Rect mHotspotBounds;
  private Drawable mLastDrawable;
  private boolean mMutated;
  
  private void initializeDrawableForDisplay(Drawable paramDrawable)
  {
    if (this.mBlockInvalidateCallback == null) {
      this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    }
    paramDrawable.setCallback(this.mBlockInvalidateCallback.wrap(paramDrawable.getCallback()));
    try
    {
      if ((this.mDrawableContainerState.mEnterFadeDuration <= 0) && (this.mHasAlpha)) {
        paramDrawable.setAlpha(this.mAlpha);
      }
      Object localObject1 = this.mDrawableContainerState;
      if (((DrawableContainerState)localObject1).mHasColorFilter)
      {
        paramDrawable.setColorFilter(((DrawableContainerState)localObject1).mColorFilter);
      }
      else
      {
        if (((DrawableContainerState)localObject1).mHasTintList) {
          DrawableCompat.setTintList(paramDrawable, ((DrawableContainerState)localObject1).mTintList);
        }
        localObject1 = this.mDrawableContainerState;
        if (((DrawableContainerState)localObject1).mHasTintMode) {
          DrawableCompat.setTintMode(paramDrawable, ((DrawableContainerState)localObject1).mTintMode);
        }
      }
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(this.mDrawableContainerState.mDither);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      int i = Build.VERSION.SDK_INT;
      if (i >= 23) {
        paramDrawable.setLayoutDirection(getLayoutDirection());
      }
      if (i >= 19) {
        paramDrawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
      }
      localObject1 = this.mHotspotBounds;
      if ((i >= 21) && (localObject1 != null)) {
        paramDrawable.setHotspotBounds(((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
      }
      return;
    }
    finally
    {
      paramDrawable.setCallback(this.mBlockInvalidateCallback.unwrap());
    }
  }
  
  private boolean needsMirroring()
  {
    boolean bool1 = isAutoMirrored();
    boolean bool2 = true;
    if ((!bool1) || (DrawableCompat.getLayoutDirection(this) != 1)) {
      bool2 = false;
    }
    return bool2;
  }
  
  static int resolveDensity(@Nullable Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    return i;
  }
  
  void animate(boolean paramBoolean)
  {
    int i = 1;
    this.mHasAlpha = true;
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable = this.mCurrDrawable;
    long l2;
    if (localDrawable != null)
    {
      l2 = this.mEnterAnimationEnd;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setAlpha(this.mAlpha);
          this.mEnterAnimationEnd = 0L;
        }
        else
        {
          localDrawable.setAlpha((255 - (int)((l2 - l1) * 255L) / this.mDrawableContainerState.mEnterFadeDuration) * this.mAlpha / 255);
          j = 1;
          break label108;
        }
      }
    }
    else
    {
      this.mEnterAnimationEnd = 0L;
    }
    int j = 0;
    label108:
    localDrawable = this.mLastDrawable;
    if (localDrawable != null)
    {
      l2 = this.mExitAnimationEnd;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setVisible(false, false);
          this.mLastDrawable = null;
          this.mExitAnimationEnd = 0L;
        }
        else
        {
          localDrawable.setAlpha((int)((l2 - l1) * 255L) / this.mDrawableContainerState.mExitFadeDuration * this.mAlpha / 255);
          j = i;
        }
      }
    }
    else
    {
      this.mExitAnimationEnd = 0L;
    }
    if ((paramBoolean) && (j != 0)) {
      scheduleSelf(this.mAnimationRunnable, l1 + 16L);
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    this.mDrawableContainerState.applyTheme(paramTheme);
  }
  
  @RequiresApi(21)
  public boolean canApplyTheme()
  {
    return this.mDrawableContainerState.canApplyTheme();
  }
  
  void clearMutated()
  {
    this.mDrawableContainerState.clearMutated();
    this.mMutated = false;
  }
  
  DrawableContainerState cloneConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mDrawableContainerState.canConstantState())
    {
      this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
      return this.mDrawableContainerState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mCurrDrawable;
  }
  
  int getCurrentIndex()
  {
    return this.mCurIndex;
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    Rect localRect = this.mHotspotBounds;
    if (localRect != null) {
      paramRect.set(localRect);
    } else {
      super.getHotspotBounds(paramRect);
    }
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantHeight();
    }
    Drawable localDrawable = this.mCurrDrawable;
    int i;
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    } else {
      i = -1;
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantWidth();
    }
    Drawable localDrawable = this.mCurrDrawable;
    int i;
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicWidth();
    } else {
      i = -1;
    }
    return i;
  }
  
  public int getMinimumHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumHeight();
    }
    Drawable localDrawable = this.mCurrDrawable;
    int i;
    if (localDrawable != null) {
      i = localDrawable.getMinimumHeight();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumWidth();
    }
    Drawable localDrawable = this.mCurrDrawable;
    int i;
    if (localDrawable != null) {
      i = localDrawable.getMinimumWidth();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.mCurrDrawable;
    int i;
    if ((localDrawable != null) && (localDrawable.isVisible())) {
      i = this.mDrawableContainerState.getOpacity();
    } else {
      i = -2;
    }
    return i;
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    Object localObject = this.mDrawableContainerState.getConstantPadding();
    int i;
    boolean bool;
    if (localObject != null)
    {
      paramRect.set((Rect)localObject);
      i = ((Rect)localObject).left;
      int j = ((Rect)localObject).top;
      int k = ((Rect)localObject).bottom;
      if ((((Rect)localObject).right | i | j | k) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        bool = ((Drawable)localObject).getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      }
    }
    if (needsMirroring())
    {
      i = paramRect.left;
      paramRect.left = paramRect.right;
      paramRect.right = i;
    }
    return bool;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    if (localDrawableContainerState != null) {
      localDrawableContainerState.invalidateCache();
    }
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawableContainerState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    return this.mDrawableContainerState.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = this.mLastDrawable;
    int i = 1;
    int j;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      this.mLastDrawable = null;
      j = 1;
    }
    else
    {
      j = 0;
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      if (this.mHasAlpha) {
        this.mCurrDrawable.setAlpha(this.mAlpha);
      }
    }
    if (this.mExitAnimationEnd != 0L)
    {
      this.mExitAnimationEnd = 0L;
      j = 1;
    }
    if (this.mEnterAnimationEnd != 0L)
    {
      this.mEnterAnimationEnd = 0L;
      j = i;
    }
    if (j != 0) {
      invalidateSelf();
    }
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      DrawableContainerState localDrawableContainerState = cloneConstantState();
      localDrawableContainerState.mutate();
      setConstantState(localDrawableContainerState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.mDrawableContainerState.setLayoutDirection(paramInt, getCurrentIndex());
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.mCurIndex) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (this.mDrawableContainerState.mExitFadeDuration > 0)
    {
      localObject = this.mLastDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      localObject = this.mCurrDrawable;
      if (localObject != null)
      {
        this.mLastDrawable = ((Drawable)localObject);
        this.mExitAnimationEnd = (this.mDrawableContainerState.mExitFadeDuration + l);
      }
      else
      {
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0L;
      }
    }
    else
    {
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    if (paramInt >= 0)
    {
      localObject = this.mDrawableContainerState;
      if (paramInt < ((DrawableContainerState)localObject).mNumChildren)
      {
        localObject = ((DrawableContainerState)localObject).getChild(paramInt);
        this.mCurrDrawable = ((Drawable)localObject);
        this.mCurIndex = paramInt;
        if (localObject == null) {
          break label191;
        }
        paramInt = this.mDrawableContainerState.mEnterFadeDuration;
        if (paramInt > 0) {
          this.mEnterAnimationEnd = (l + paramInt);
        }
        initializeDrawableForDisplay((Drawable)localObject);
        break label191;
      }
    }
    this.mCurrDrawable = null;
    this.mCurIndex = -1;
    label191:
    if ((this.mEnterAnimationEnd != 0L) || (this.mExitAnimationEnd != 0L))
    {
      localObject = this.mAnimationRunnable;
      if (localObject == null) {
        this.mAnimationRunnable = new Runnable()
        {
          public void run()
          {
            DrawableContainer.this.animate(true);
            DrawableContainer.this.invalidateSelf();
          }
        };
      } else {
        unscheduleSelf((Runnable)localObject);
      }
      animate(true);
    }
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.mHasAlpha) || (this.mAlpha != paramInt))
    {
      this.mHasAlpha = true;
      this.mAlpha = paramInt;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        if (this.mEnterAnimationEnd == 0L) {
          localDrawable.setAlpha(paramInt);
        } else {
          animate(false);
        }
      }
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Object localObject = this.mDrawableContainerState;
    if (((DrawableContainerState)localObject).mAutoMirrored != paramBoolean)
    {
      ((DrawableContainerState)localObject).mAutoMirrored = paramBoolean;
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        DrawableCompat.setAutoMirrored((Drawable)localObject, paramBoolean);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = this.mDrawableContainerState;
    ((DrawableContainerState)localObject).mHasColorFilter = true;
    if (((DrawableContainerState)localObject).mColorFilter != paramColorFilter)
    {
      ((DrawableContainerState)localObject).mColorFilter = paramColorFilter;
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
    }
  }
  
  void setConstantState(DrawableContainerState paramDrawableContainerState)
  {
    this.mDrawableContainerState = paramDrawableContainerState;
    int i = this.mCurIndex;
    if (i >= 0)
    {
      paramDrawableContainerState = paramDrawableContainerState.getChild(i);
      this.mCurrDrawable = paramDrawableContainerState;
      if (paramDrawableContainerState != null) {
        initializeDrawableForDisplay(paramDrawableContainerState);
      }
    }
    this.mLastDrawable = null;
  }
  
  void setCurrentIndex(int paramInt)
  {
    selectDrawable(paramInt);
  }
  
  public void setDither(boolean paramBoolean)
  {
    Object localObject = this.mDrawableContainerState;
    if (((DrawableContainerState)localObject).mDither != paramBoolean)
    {
      ((DrawableContainerState)localObject).mDither = paramBoolean;
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setDither(paramBoolean);
      }
    }
  }
  
  public void setEnterFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mEnterFadeDuration = paramInt;
  }
  
  public void setExitFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mExitFadeDuration = paramInt;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mHotspotBounds;
    if (localObject == null) {
      this.mHotspotBounds = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      ((Rect)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.mCurrDrawable;
    if (localObject != null) {
      DrawableCompat.setHotspotBounds((Drawable)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    localDrawableContainerState.mHasTintList = true;
    if (localDrawableContainerState.mTintList != paramColorStateList)
    {
      localDrawableContainerState.mTintList = paramColorStateList;
      DrawableCompat.setTintList(this.mCurrDrawable, paramColorStateList);
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    localDrawableContainerState.mHasTintMode = true;
    if (localDrawableContainerState.mTintMode != paramMode)
    {
      localDrawableContainerState.mTintMode = paramMode;
      DrawableCompat.setTintMode(this.mCurrDrawable, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  final void updateDensity(Resources paramResources)
  {
    this.mDrawableContainerState.updateDensity(paramResources);
  }
  
  static class BlockInvalidateCallback
    implements Drawable.Callback
  {
    private Drawable.Callback mCallback;
    
    public void invalidateDrawable(@NonNull Drawable paramDrawable) {}
    
    public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
    {
      Drawable.Callback localCallback = this.mCallback;
      if (localCallback != null) {
        localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
    {
      Drawable.Callback localCallback = this.mCallback;
      if (localCallback != null) {
        localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
    
    public Drawable.Callback unwrap()
    {
      Drawable.Callback localCallback = this.mCallback;
      this.mCallback = null;
      return localCallback;
    }
    
    public BlockInvalidateCallback wrap(Drawable.Callback paramCallback)
    {
      this.mCallback = paramCallback;
      return this;
    }
  }
  
  static abstract class DrawableContainerState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCanConstantState;
    int mChangingConfigurations;
    boolean mCheckedConstantSize;
    boolean mCheckedConstantState;
    boolean mCheckedOpacity;
    boolean mCheckedPadding;
    boolean mCheckedStateful;
    int mChildrenChangingConfigurations;
    ColorFilter mColorFilter;
    int mConstantHeight;
    int mConstantMinimumHeight;
    int mConstantMinimumWidth;
    Rect mConstantPadding;
    boolean mConstantSize;
    int mConstantWidth;
    int mDensity = 160;
    boolean mDither;
    SparseArray<Drawable.ConstantState> mDrawableFutures;
    Drawable[] mDrawables;
    int mEnterFadeDuration;
    int mExitFadeDuration;
    boolean mHasColorFilter;
    boolean mHasTintList;
    boolean mHasTintMode;
    int mLayoutDirection;
    boolean mMutated;
    int mNumChildren;
    int mOpacity;
    final DrawableContainer mOwner;
    Resources mSourceRes;
    boolean mStateful;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    boolean mVariablePadding;
    
    DrawableContainerState(DrawableContainerState paramDrawableContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      int i = 0;
      this.mVariablePadding = false;
      this.mConstantSize = false;
      this.mDither = true;
      this.mEnterFadeDuration = 0;
      this.mExitFadeDuration = 0;
      this.mOwner = paramDrawableContainer;
      if (paramResources != null) {
        paramDrawableContainer = paramResources;
      } else if (paramDrawableContainerState != null) {
        paramDrawableContainer = paramDrawableContainerState.mSourceRes;
      } else {
        paramDrawableContainer = null;
      }
      this.mSourceRes = paramDrawableContainer;
      if (paramDrawableContainerState != null) {
        j = paramDrawableContainerState.mDensity;
      } else {
        j = 0;
      }
      int j = DrawableContainer.resolveDensity(paramResources, j);
      this.mDensity = j;
      if (paramDrawableContainerState != null)
      {
        this.mChangingConfigurations = paramDrawableContainerState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = paramDrawableContainerState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = paramDrawableContainerState.mVariablePadding;
        this.mConstantSize = paramDrawableContainerState.mConstantSize;
        this.mDither = paramDrawableContainerState.mDither;
        this.mMutated = paramDrawableContainerState.mMutated;
        this.mLayoutDirection = paramDrawableContainerState.mLayoutDirection;
        this.mEnterFadeDuration = paramDrawableContainerState.mEnterFadeDuration;
        this.mExitFadeDuration = paramDrawableContainerState.mExitFadeDuration;
        this.mAutoMirrored = paramDrawableContainerState.mAutoMirrored;
        this.mColorFilter = paramDrawableContainerState.mColorFilter;
        this.mHasColorFilter = paramDrawableContainerState.mHasColorFilter;
        this.mTintList = paramDrawableContainerState.mTintList;
        this.mTintMode = paramDrawableContainerState.mTintMode;
        this.mHasTintList = paramDrawableContainerState.mHasTintList;
        this.mHasTintMode = paramDrawableContainerState.mHasTintMode;
        if (paramDrawableContainerState.mDensity == j)
        {
          if (paramDrawableContainerState.mCheckedPadding)
          {
            this.mConstantPadding = new Rect(paramDrawableContainerState.mConstantPadding);
            this.mCheckedPadding = true;
          }
          if (paramDrawableContainerState.mCheckedConstantSize)
          {
            this.mConstantWidth = paramDrawableContainerState.mConstantWidth;
            this.mConstantHeight = paramDrawableContainerState.mConstantHeight;
            this.mConstantMinimumWidth = paramDrawableContainerState.mConstantMinimumWidth;
            this.mConstantMinimumHeight = paramDrawableContainerState.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
          }
        }
        if (paramDrawableContainerState.mCheckedOpacity)
        {
          this.mOpacity = paramDrawableContainerState.mOpacity;
          this.mCheckedOpacity = true;
        }
        if (paramDrawableContainerState.mCheckedStateful)
        {
          this.mStateful = paramDrawableContainerState.mStateful;
          this.mCheckedStateful = true;
        }
        paramDrawableContainer = paramDrawableContainerState.mDrawables;
        this.mDrawables = new Drawable[paramDrawableContainer.length];
        this.mNumChildren = paramDrawableContainerState.mNumChildren;
        paramDrawableContainerState = paramDrawableContainerState.mDrawableFutures;
        if (paramDrawableContainerState != null) {
          this.mDrawableFutures = paramDrawableContainerState.clone();
        } else {
          this.mDrawableFutures = new SparseArray(this.mNumChildren);
        }
        int k = this.mNumChildren;
        for (j = i; j < k; j++) {
          if (paramDrawableContainer[j] != null)
          {
            paramDrawableContainerState = paramDrawableContainer[j].getConstantState();
            if (paramDrawableContainerState != null) {
              this.mDrawableFutures.put(j, paramDrawableContainerState);
            } else {
              this.mDrawables[j] = paramDrawableContainer[j];
            }
          }
        }
      }
      this.mDrawables = new Drawable[10];
      this.mNumChildren = 0;
    }
    
    private void createAllFutures()
    {
      Object localObject = this.mDrawableFutures;
      if (localObject != null)
      {
        int i = ((SparseArray)localObject).size();
        for (int j = 0; j < i; j++)
        {
          int k = this.mDrawableFutures.keyAt(j);
          localObject = (Drawable.ConstantState)this.mDrawableFutures.valueAt(j);
          this.mDrawables[k] = prepareDrawable(((Drawable.ConstantState)localObject).newDrawable(this.mSourceRes));
        }
        this.mDrawableFutures = null;
      }
    }
    
    private Drawable prepareDrawable(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.mOwner);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.mNumChildren;
      if (i >= this.mDrawables.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.mOwner);
      this.mDrawables[i] = paramDrawable;
      this.mNumChildren += 1;
      int j = this.mChildrenChangingConfigurations;
      this.mChildrenChangingConfigurations = (paramDrawable.getChangingConfigurations() | j);
      invalidateCache();
      this.mConstantPadding = null;
      this.mCheckedPadding = false;
      this.mCheckedConstantSize = false;
      this.mCheckedConstantState = false;
      return i;
    }
    
    @RequiresApi(21)
    final void applyTheme(Resources.Theme paramTheme)
    {
      if (paramTheme != null)
      {
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        for (int j = 0; j < i; j++) {
          if ((arrayOfDrawable[j] != null) && (arrayOfDrawable[j].canApplyTheme()))
          {
            arrayOfDrawable[j].applyTheme(paramTheme);
            this.mChildrenChangingConfigurations |= arrayOfDrawable[j].getChangingConfigurations();
          }
        }
        updateDensity(paramTheme.getResources());
      }
    }
    
    @RequiresApi(21)
    public boolean canApplyTheme()
    {
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      for (int j = 0; j < i; j++)
      {
        Object localObject = arrayOfDrawable[j];
        if (localObject != null)
        {
          if (((Drawable)localObject).canApplyTheme()) {
            return true;
          }
        }
        else
        {
          localObject = (Drawable.ConstantState)this.mDrawableFutures.get(j);
          if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean canConstantState()
    {
      try
      {
        if (this.mCheckedConstantState)
        {
          boolean bool = this.mCanConstantState;
          return bool;
        }
        createAllFutures();
        this.mCheckedConstantState = true;
        int i = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        for (int j = 0; j < i; j++) {
          if (arrayOfDrawable[j].getConstantState() == null)
          {
            this.mCanConstantState = false;
            return false;
          }
        }
        this.mCanConstantState = true;
        return true;
      }
      finally {}
    }
    
    final void clearMutated()
    {
      this.mMutated = false;
    }
    
    protected void computeConstantSize()
    {
      this.mCheckedConstantSize = true;
      createAllFutures();
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      this.mConstantHeight = -1;
      this.mConstantWidth = -1;
      int j = 0;
      this.mConstantMinimumHeight = 0;
      this.mConstantMinimumWidth = 0;
      while (j < i)
      {
        Drawable localDrawable = arrayOfDrawable[j];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.mConstantWidth) {
          this.mConstantWidth = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.mConstantHeight) {
          this.mConstantHeight = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.mConstantMinimumWidth) {
          this.mConstantMinimumWidth = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.mConstantMinimumHeight) {
          this.mConstantMinimumHeight = k;
        }
        j++;
      }
    }
    
    final int getCapacity()
    {
      return this.mDrawables.length;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.mDrawables[paramInt];
      if (localObject != null) {
        return (Drawable)localObject;
      }
      localObject = this.mDrawableFutures;
      if (localObject != null)
      {
        int i = ((SparseArray)localObject).indexOfKey(paramInt);
        if (i >= 0)
        {
          localObject = prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(i)).newDrawable(this.mSourceRes));
          this.mDrawables[paramInt] = localObject;
          this.mDrawableFutures.removeAt(i);
          if (this.mDrawableFutures.size() == 0) {
            this.mDrawableFutures = null;
          }
          return (Drawable)localObject;
        }
      }
      return null;
    }
    
    public final int getChildCount()
    {
      return this.mNumChildren;
    }
    
    public final int getConstantHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantHeight;
    }
    
    public final int getConstantMinimumHeight()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumHeight;
    }
    
    public final int getConstantMinimumWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantMinimumWidth;
    }
    
    public final Rect getConstantPadding()
    {
      boolean bool = this.mVariablePadding;
      Object localObject1 = null;
      if (bool) {
        return null;
      }
      Object localObject2 = this.mConstantPadding;
      if ((localObject2 == null) && (!this.mCheckedPadding))
      {
        createAllFutures();
        Rect localRect = new Rect();
        int i = this.mNumChildren;
        Drawable[] arrayOfDrawable = this.mDrawables;
        int j = 0;
        while (j < i)
        {
          Object localObject3 = localObject1;
          if (arrayOfDrawable[j].getPadding(localRect))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Rect(0, 0, 0, 0);
            }
            int k = localRect.left;
            if (k > ((Rect)localObject2).left) {
              ((Rect)localObject2).left = k;
            }
            k = localRect.top;
            if (k > ((Rect)localObject2).top) {
              ((Rect)localObject2).top = k;
            }
            k = localRect.right;
            if (k > ((Rect)localObject2).right) {
              ((Rect)localObject2).right = k;
            }
            k = localRect.bottom;
            localObject3 = localObject2;
            if (k > ((Rect)localObject2).bottom)
            {
              ((Rect)localObject2).bottom = k;
              localObject3 = localObject2;
            }
          }
          j++;
          localObject1 = localObject3;
        }
        this.mCheckedPadding = true;
        this.mConstantPadding = ((Rect)localObject1);
        return (Rect)localObject1;
      }
      return (Rect)localObject2;
    }
    
    public final int getConstantWidth()
    {
      if (!this.mCheckedConstantSize) {
        computeConstantSize();
      }
      return this.mConstantWidth;
    }
    
    public final int getEnterFadeDuration()
    {
      return this.mEnterFadeDuration;
    }
    
    public final int getExitFadeDuration()
    {
      return this.mExitFadeDuration;
    }
    
    public final int getOpacity()
    {
      if (this.mCheckedOpacity) {
        return this.mOpacity;
      }
      createAllFutures();
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int j;
      if (i > 0) {
        j = arrayOfDrawable[0].getOpacity();
      } else {
        j = -2;
      }
      for (int k = 1; k < i; k++) {
        j = Drawable.resolveOpacity(j, arrayOfDrawable[k].getOpacity());
      }
      this.mOpacity = j;
      this.mCheckedOpacity = true;
      return j;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.mDrawables, 0, arrayOfDrawable, 0, paramInt1);
      this.mDrawables = arrayOfDrawable;
    }
    
    void invalidateCache()
    {
      this.mCheckedOpacity = false;
      this.mCheckedStateful = false;
    }
    
    public final boolean isConstantSize()
    {
      return this.mConstantSize;
    }
    
    public final boolean isStateful()
    {
      if (this.mCheckedStateful) {
        return this.mStateful;
      }
      createAllFutures();
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      boolean bool1 = false;
      boolean bool2;
      for (int j = 0;; j++)
      {
        bool2 = bool1;
        if (j >= i) {
          break;
        }
        if (arrayOfDrawable[j].isStateful())
        {
          bool2 = true;
          break;
        }
      }
      this.mStateful = bool2;
      this.mCheckedStateful = true;
      return bool2;
    }
    
    void mutate()
    {
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      for (int j = 0; j < i; j++) {
        if (arrayOfDrawable[j] != null) {
          arrayOfDrawable[j].mutate();
        }
      }
      this.mMutated = true;
    }
    
    public final void setConstantSize(boolean paramBoolean)
    {
      this.mConstantSize = paramBoolean;
    }
    
    public final void setEnterFadeDuration(int paramInt)
    {
      this.mEnterFadeDuration = paramInt;
    }
    
    public final void setExitFadeDuration(int paramInt)
    {
      this.mExitFadeDuration = paramInt;
    }
    
    final boolean setLayoutDirection(int paramInt1, int paramInt2)
    {
      int i = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int j = 0;
      boolean bool2;
      for (boolean bool1 = false; j < i; bool1 = bool2)
      {
        bool2 = bool1;
        if (arrayOfDrawable[j] != null)
        {
          boolean bool3;
          if (Build.VERSION.SDK_INT >= 23) {
            bool3 = arrayOfDrawable[j].setLayoutDirection(paramInt1);
          } else {
            bool3 = false;
          }
          bool2 = bool1;
          if (j == paramInt2) {
            bool2 = bool3;
          }
        }
        j++;
      }
      this.mLayoutDirection = paramInt1;
      return bool1;
    }
    
    public final void setVariablePadding(boolean paramBoolean)
    {
      this.mVariablePadding = paramBoolean;
    }
    
    final void updateDensity(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.mSourceRes = paramResources;
        int i = DrawableContainer.resolveDensity(paramResources, this.mDensity);
        int j = this.mDensity;
        this.mDensity = i;
        if (j != i)
        {
          this.mCheckedConstantSize = false;
          this.mCheckedPadding = false;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\graphics\drawable\DrawableContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */