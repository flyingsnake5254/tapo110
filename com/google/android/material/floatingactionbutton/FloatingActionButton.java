package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior
{
  private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
  private static final int DEF_STYLE_RES = R.style.Widget_Design_FloatingActionButton;
  private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
  private static final String LOG_TAG = "FloatingActionButton";
  public static final int NO_CUSTOM_SIZE = 0;
  public static final int SIZE_AUTO = -1;
  public static final int SIZE_MINI = 1;
  public static final int SIZE_NORMAL = 0;
  @Nullable
  private ColorStateList backgroundTint;
  @Nullable
  private PorterDuff.Mode backgroundTintMode;
  private int borderWidth;
  boolean compatPadding;
  private int customSize;
  @NonNull
  private final ExpandableWidgetHelper expandableWidgetHelper;
  @NonNull
  private final AppCompatImageHelper imageHelper;
  @Nullable
  private PorterDuff.Mode imageMode;
  private int imagePadding;
  @Nullable
  private ColorStateList imageTint;
  private FloatingActionButtonImpl impl;
  private int maxImageSize;
  @Nullable
  private ColorStateList rippleColor;
  final Rect shadowPadding = new Rect();
  private int size;
  private final Rect touchArea = new Rect();
  
  public FloatingActionButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.floatingActionButtonStyle);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    Object localObject1 = getContext();
    Object localObject2 = ThemeEnforcement.obtainStyledAttributes((Context)localObject1, paramAttributeSet, R.styleable.FloatingActionButton, paramInt, i, new int[0]);
    this.backgroundTint = MaterialResources.getColorStateList((Context)localObject1, (TypedArray)localObject2, R.styleable.FloatingActionButton_backgroundTint);
    this.backgroundTintMode = ViewUtils.parseTintMode(((TypedArray)localObject2).getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    this.rippleColor = MaterialResources.getColorStateList((Context)localObject1, (TypedArray)localObject2, R.styleable.FloatingActionButton_rippleColor);
    this.size = ((TypedArray)localObject2).getInt(R.styleable.FloatingActionButton_fabSize, -1);
    this.customSize = ((TypedArray)localObject2).getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
    this.borderWidth = ((TypedArray)localObject2).getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = ((TypedArray)localObject2).getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = ((TypedArray)localObject2).getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = ((TypedArray)localObject2).getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.compatPadding = ((TypedArray)localObject2).getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    int j = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
    this.maxImageSize = ((TypedArray)localObject2).getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
    MotionSpec localMotionSpec = MotionSpec.createFromAttribute((Context)localObject1, (TypedArray)localObject2, R.styleable.FloatingActionButton_showMotionSpec);
    paramContext = MotionSpec.createFromAttribute((Context)localObject1, (TypedArray)localObject2, R.styleable.FloatingActionButton_hideMotionSpec);
    localObject1 = ShapeAppearanceModel.builder((Context)localObject1, paramAttributeSet, paramInt, i, ShapeAppearanceModel.PILL).build();
    boolean bool = ((TypedArray)localObject2).getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
    setEnabled(((TypedArray)localObject2).getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
    ((TypedArray)localObject2).recycle();
    localObject2 = new AppCompatImageHelper(this);
    this.imageHelper = ((AppCompatImageHelper)localObject2);
    ((AppCompatImageHelper)localObject2).loadFromAttributes(paramAttributeSet, paramInt);
    this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
    getImpl().setShapeAppearance((ShapeAppearanceModel)localObject1);
    getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
    getImpl().setMinTouchTargetSize(j);
    getImpl().setElevation(f1);
    getImpl().setHoveredFocusedTranslationZ(f2);
    getImpl().setPressedTranslationZ(f3);
    getImpl().setMaxImageSize(this.maxImageSize);
    getImpl().setShowMotionSpec(localMotionSpec);
    getImpl().setHideMotionSpec(paramContext);
    getImpl().setEnsureMinTouchTargetSize(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  @NonNull
  private FloatingActionButtonImpl createImpl()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    }
    return new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
  }
  
  private FloatingActionButtonImpl getImpl()
  {
    if (this.impl == null) {
      this.impl = createImpl();
    }
    return this.impl;
  }
  
  private int getSizeDimension(int paramInt)
  {
    int i = this.customSize;
    if (i != 0) {
      return i;
    }
    Resources localResources = getResources();
    if (paramInt != -1)
    {
      if (paramInt != 1) {
        return localResources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
      }
      return localResources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
    }
    if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
      paramInt = getSizeDimension(1);
    } else {
      paramInt = getSizeDimension(0);
    }
    return paramInt;
  }
  
  private void offsetRectWithShadow(@NonNull Rect paramRect)
  {
    int i = paramRect.left;
    Rect localRect = this.shadowPadding;
    paramRect.left = (i + localRect.left);
    paramRect.top += localRect.top;
    paramRect.right -= localRect.right;
    paramRect.bottom -= localRect.bottom;
  }
  
  private void onApplySupportImageTint()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = this.imageTint;
    if (localObject == null)
    {
      DrawableCompat.clearColorFilter(localDrawable);
      return;
    }
    int i = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.imageMode;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, (PorterDuff.Mode)localObject));
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0) {
        if (i == 1073741824) {
          paramInt1 = paramInt2;
        } else {
          throw new IllegalArgumentException();
        }
      }
    }
    else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  @Nullable
  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return null;
    }
    new FloatingActionButtonImpl.InternalVisibilityChangedListener()
    {
      public void onHidden()
      {
        paramOnVisibilityChangedListener.onHidden(FloatingActionButton.this);
      }
      
      public void onShown()
      {
        paramOnVisibilityChangedListener.onShown(FloatingActionButton.this);
      }
    };
  }
  
  public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().addOnHideAnimationListener(paramAnimatorListener);
  }
  
  public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().addOnShowAnimationListener(paramAnimatorListener);
  }
  
  public void addTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> paramTransformationCallback)
  {
    getImpl().addTransformationCallback(new TransformationCallbackWrapper(paramTransformationCallback));
  }
  
  public void clearCustomSize()
  {
    setCustomSize(0);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().onDrawableStateChanged(getDrawableState());
  }
  
  @Nullable
  public ColorStateList getBackgroundTintList()
  {
    return this.backgroundTint;
  }
  
  @Nullable
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.backgroundTintMode;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior()
  {
    return new Behavior();
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().getHoveredFocusedTranslationZ();
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().getPressedTranslationZ();
  }
  
  @Nullable
  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }
  
  @Deprecated
  public boolean getContentRect(@NonNull Rect paramRect)
  {
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      offsetRectWithShadow(paramRect);
      return true;
    }
    return false;
  }
  
  @Px
  public int getCustomSize()
  {
    return this.customSize;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.expandableWidgetHelper.getExpandedComponentIdHint();
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    return getImpl().getHideMotionSpec();
  }
  
  public void getMeasuredContentRect(@NonNull Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    offsetRectWithShadow(paramRect);
  }
  
  @Deprecated
  @ColorInt
  public int getRippleColor()
  {
    ColorStateList localColorStateList = this.rippleColor;
    int i;
    if (localColorStateList != null) {
      i = localColorStateList.getDefaultColor();
    } else {
      i = 0;
    }
    return i;
  }
  
  @Nullable
  public ColorStateList getRippleColorStateList()
  {
    return this.rippleColor;
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return (ShapeAppearanceModel)Preconditions.checkNotNull(getImpl().getShapeAppearance());
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    return getImpl().getShowMotionSpec();
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  int getSizeDimension()
  {
    return getSizeDimension(this.size);
  }
  
  @Nullable
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  @Nullable
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  @Nullable
  public ColorStateList getSupportImageTintList()
  {
    return this.imageTint;
  }
  
  @Nullable
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.imageMode;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.compatPadding;
  }
  
  public void hide()
  {
    hide(null);
  }
  
  public void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    hide(paramOnVisibilityChangedListener, true);
  }
  
  void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().hide(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean isExpanded()
  {
    return this.expandableWidgetHelper.isExpanded();
  }
  
  public boolean isOrWillBeHidden()
  {
    return getImpl().isOrWillBeHidden();
  }
  
  public boolean isOrWillBeShown()
  {
    return getImpl().isOrWillBeShown();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.imagePadding = ((i - this.maxImageSize) / 2);
    getImpl().updatePadding();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    Rect localRect = this.shadowPadding;
    setMeasuredDimension(localRect.left + paramInt1 + localRect.right, paramInt1 + localRect.top + localRect.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.expandableWidgetHelper.onRestoreInstanceState((Bundle)Preconditions.checkNotNull(paramParcelable.extendableStates.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Object localObject = localParcelable;
    if (localParcelable == null) {
      localObject = new Bundle();
    }
    localObject = new ExtendableSavedState((Parcelable)localObject);
    ((ExtendableSavedState)localObject).extendableStates.put("expandableWidgetHelper", this.expandableWidgetHelper.onSaveInstanceState());
    return (Parcelable)localObject;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getContentRect(this.touchArea)) && (!this.touchArea.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().removeOnHideAnimationListener(paramAnimatorListener);
  }
  
  public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().removeOnShowAnimationListener(paramAnimatorListener);
  }
  
  public void removeTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> paramTransformationCallback)
  {
    getImpl().removeTransformationCallback(new TransformationCallbackWrapper(paramTransformationCallback));
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.backgroundTint != paramColorStateList)
    {
      this.backgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.backgroundTintMode != paramMode)
    {
      this.backgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setCompatElevationResource(@DimenRes int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().setHoveredFocusedTranslationZ(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().setPressedTranslationZ(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(@Px int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt != this.customSize)
      {
        this.customSize = paramInt;
        requestLayout();
      }
      return;
    }
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    getImpl().updateShapeElevation(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    if (paramBoolean != getImpl().getEnsureMinTouchTargetSize())
    {
      getImpl().setEnsureMinTouchTargetSize(paramBoolean);
      requestLayout();
    }
  }
  
  public boolean setExpanded(boolean paramBoolean)
  {
    return this.expandableWidgetHelper.setExpanded(paramBoolean);
  }
  
  public void setExpandedComponentIdHint(@IdRes int paramInt)
  {
    this.expandableWidgetHelper.setExpandedComponentIdHint(paramInt);
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    getImpl().setHideMotionSpec(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    setHideMotionSpec(MotionSpec.createFromResource(getContext(), paramInt));
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if (getDrawable() != paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      getImpl().updateImageMatrixScale();
      if (this.imageTint != null) {
        onApplySupportImageTint();
      }
    }
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    this.imageHelper.setImageResource(paramInt);
    onApplySupportImageTint();
  }
  
  public void setRippleColor(@ColorInt int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.rippleColor != paramColorStateList)
    {
      this.rippleColor = paramColorStateList;
      getImpl().setRippleColor(this.rippleColor);
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    getImpl().onScaleChanged();
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    getImpl().onScaleChanged();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public void setShadowPaddingEnabled(boolean paramBoolean)
  {
    getImpl().setShadowPaddingEnabled(paramBoolean);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    getImpl().setShapeAppearance(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    getImpl().setShowMotionSpec(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShowMotionSpec(MotionSpec.createFromResource(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.customSize = 0;
    if (paramInt != this.size)
    {
      this.size = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.imageTint != paramColorStateList)
    {
      this.imageTint = paramColorStateList;
      onApplySupportImageTint();
    }
  }
  
  public void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.imageMode != paramMode)
    {
      this.imageMode = paramMode;
      onApplySupportImageTint();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    getImpl().onTranslationChanged();
  }
  
  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
    getImpl().onTranslationChanged();
  }
  
  public void setTranslationZ(float paramFloat)
  {
    super.setTranslationZ(paramFloat);
    getImpl().onTranslationChanged();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.compatPadding != paramBoolean)
    {
      this.compatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public boolean shouldEnsureMinTouchTargetSize()
  {
    return getImpl().getEnsureMinTouchTargetSize();
  }
  
  public void show()
  {
    show(null);
  }
  
  public void show(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    show(paramOnVisibilityChangedListener, true);
  }
  
  void show(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean autoHideEnabled;
    private FloatingActionButton.OnVisibilityChangedListener internalAutoHideListener;
    private Rect tmpRect;
    
    public BaseBehavior()
    {
      this.autoHideEnabled = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      this.autoHideEnabled = paramContext.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
    }
    
    private static boolean isBottomSheet(@NonNull View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.LayoutParams)) {
        return ((CoordinatorLayout.LayoutParams)paramView).getBehavior() instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    private void offsetIfNeeded(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = paramFloatingActionButton.shadowPadding;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        int i = paramFloatingActionButton.getRight();
        int j = paramCoordinatorLayout.getWidth();
        int k = localLayoutParams.rightMargin;
        int m = 0;
        if (i >= j - k) {
          j = localRect.right;
        } else if (paramFloatingActionButton.getLeft() <= localLayoutParams.leftMargin) {
          j = -localRect.left;
        } else {
          j = 0;
        }
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - localLayoutParams.bottomMargin) {
          m = localRect.bottom;
        } else if (paramFloatingActionButton.getTop() <= localLayoutParams.topMargin) {
          m = -localRect.top;
        }
        if (m != 0) {
          ViewCompat.offsetTopAndBottom(paramFloatingActionButton, m);
        }
        if (j != 0) {
          ViewCompat.offsetLeftAndRight(paramFloatingActionButton, j);
        }
      }
    }
    
    private boolean shouldUpdateVisibility(@NonNull View paramView, @NonNull FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (!this.autoHideEnabled) {
        return false;
      }
      if (localLayoutParams.getAnchorId() != paramView.getId()) {
        return false;
      }
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }
    
    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout paramCoordinatorLayout, @NonNull AppBarLayout paramAppBarLayout, @NonNull FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.tmpRect == null) {
        this.tmpRect = new Rect();
      }
      Rect localRect = this.tmpRect;
      DescendantOffsetUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.hide(this.internalAutoHideListener, false);
      } else {
        paramFloatingActionButton.show(this.internalAutoHideListener, false);
      }
      return true;
    }
    
    private boolean updateFabVisibilityForBottomSheet(@NonNull View paramView, @NonNull FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + localLayoutParams.topMargin) {
        paramFloatingActionButton.hide(this.internalAutoHideListener, false);
      } else {
        paramFloatingActionButton.show(this.internalAutoHideListener, false);
      }
      return true;
    }
    
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, @NonNull Rect paramRect)
    {
      paramCoordinatorLayout = paramFloatingActionButton.shadowPadding;
      paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
      return true;
    }
    
    public boolean isAutoHideEnabled()
    {
      return this.autoHideEnabled;
    }
    
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams.dodgeInsetEdges == 0) {
        paramLayoutParams.dodgeInsetEdges = 80;
      }
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      } else if (isBottomSheet(paramView)) {
        updateFabVisibilityForBottomSheet(paramView, paramFloatingActionButton);
      }
      return false;
    }
    
    public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)localList.get(j);
        if ((localView instanceof AppBarLayout) ? !updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton) : (isBottomSheet(localView)) && (updateFabVisibilityForBottomSheet(localView, paramFloatingActionButton))) {
          break;
        }
      }
      paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
      offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
      return true;
    }
    
    public void setAutoHideEnabled(boolean paramBoolean)
    {
      this.autoHideEnabled = paramBoolean;
    }
    
    @VisibleForTesting
    public void setInternalAutoHideListener(FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
    {
      this.internalAutoHideListener = paramOnVisibilityChangedListener;
    }
  }
  
  public static class Behavior
    extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static abstract class OnVisibilityChangedListener
  {
    public void onHidden(FloatingActionButton paramFloatingActionButton) {}
    
    public void onShown(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class ShadowDelegateImpl
    implements ShadowViewDelegate
  {
    ShadowDelegateImpl() {}
    
    public float getRadius()
    {
      return FloatingActionButton.this.getSizeDimension() / 2.0F;
    }
    
    public boolean isCompatPaddingEnabled()
    {
      return FloatingActionButton.this.compatPadding;
    }
    
    public void setBackgroundDrawable(@Nullable Drawable paramDrawable)
    {
      if (paramDrawable != null) {
        FloatingActionButton.this.setBackgroundDrawable(paramDrawable);
      }
    }
    
    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.shadowPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(paramInt1 + localFloatingActionButton.imagePadding, paramInt2 + FloatingActionButton.this.imagePadding, paramInt3 + FloatingActionButton.this.imagePadding, paramInt4 + FloatingActionButton.this.imagePadding);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Size {}
  
  class TransformationCallbackWrapper<T extends FloatingActionButton>
    implements FloatingActionButtonImpl.InternalTransformationCallback
  {
    @NonNull
    private final TransformationCallback<T> listener;
    
    TransformationCallbackWrapper()
    {
      TransformationCallback localTransformationCallback;
      this.listener = localTransformationCallback;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof TransformationCallbackWrapper)) && (((TransformationCallbackWrapper)paramObject).listener.equals(this.listener))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return this.listener.hashCode();
    }
    
    public void onScaleChanged()
    {
      this.listener.onScaleChanged(FloatingActionButton.this);
    }
    
    public void onTranslationChanged()
    {
      this.listener.onTranslationChanged(FloatingActionButton.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\floatingactionbutton\FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */