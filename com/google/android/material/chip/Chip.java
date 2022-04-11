package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R.attr;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip
  extends AppCompatCheckBox
  implements ChipDrawable.Delegate, Shapeable
{
  private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
  private static final int[] CHECKABLE_STATE_SET = { 16842911 };
  private static final int CHIP_BODY_VIRTUAL_ID = 0;
  private static final int CLOSE_ICON_VIRTUAL_ID = 1;
  private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
  private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Chip_Action;
  private static final Rect EMPTY_BOUNDS = new Rect();
  private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
  private static final int MIN_TOUCH_TARGET_DP = 48;
  private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
  private static final int[] SELECTED_STATE = { 16842913 };
  private static final String TAG = "Chip";
  @Nullable
  private ChipDrawable chipDrawable;
  private boolean closeIconFocused;
  private boolean closeIconHovered;
  private boolean closeIconPressed;
  private boolean deferredCheckedValue;
  private boolean ensureMinTouchTargetSize;
  private final TextAppearanceFontCallback fontCallback = new TextAppearanceFontCallback()
  {
    public void onFontRetrievalFailed(int paramAnonymousInt) {}
    
    public void onFontRetrieved(@NonNull Typeface paramAnonymousTypeface, boolean paramAnonymousBoolean)
    {
      Chip localChip = Chip.this;
      if (localChip.chipDrawable.shouldDrawText()) {
        paramAnonymousTypeface = Chip.this.chipDrawable.getText();
      } else {
        paramAnonymousTypeface = Chip.this.getText();
      }
      localChip.setText(paramAnonymousTypeface);
      Chip.this.requestLayout();
      Chip.this.invalidate();
    }
  };
  @Nullable
  private InsetDrawable insetBackgroundDrawable;
  private int lastLayoutDirection;
  @Dimension(unit=1)
  private int minTouchTargetSize;
  @Nullable
  private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
  @Nullable
  private View.OnClickListener onCloseIconClickListener;
  private final Rect rect = new Rect();
  private final RectF rectF = new RectF();
  @Nullable
  private RippleDrawable ripple;
  @NonNull
  private final ChipTouchHelper touchHelper;
  
  public Chip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    validateAttributes(paramAttributeSet);
    ChipDrawable localChipDrawable = ChipDrawable.createFromAttributes(paramContext, paramAttributeSet, paramInt, i);
    initMinTouchTarget(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(localChipDrawable);
    localChipDrawable.setElevation(ViewCompat.getElevation(this));
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.Chip, paramInt, i, new int[0]);
    if (Build.VERSION.SDK_INT < 23) {
      setTextColor(MaterialResources.getColorStateList(paramContext, paramAttributeSet, R.styleable.Chip_android_textColor));
    }
    boolean bool = paramAttributeSet.hasValue(R.styleable.Chip_shapeAppearance);
    paramAttributeSet.recycle();
    this.touchHelper = new ChipTouchHelper(this);
    updateAccessibilityDelegate();
    if (!bool) {
      initOutlineProvider();
    }
    setChecked(this.deferredCheckedValue);
    setText(localChipDrawable.getText());
    setEllipsize(localChipDrawable.getEllipsize());
    updateTextPaintDrawState();
    if (!this.chipDrawable.shouldDrawText())
    {
      setLines(1);
      setHorizontallyScrolling(true);
    }
    setGravity(8388627);
    updatePaddingInternal();
    if (shouldEnsureMinTouchTargetSize()) {
      setMinHeight(this.minTouchTargetSize);
    }
    this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
  }
  
  private void applyChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    paramChipDrawable.setDelegate(this);
  }
  
  @NonNull
  private int[] createCloseIconDrawableState()
  {
    boolean bool = isEnabled();
    int i = 0;
    if (bool) {
      j = 1;
    } else {
      j = 0;
    }
    int k = j;
    if (this.closeIconFocused) {
      k = j + 1;
    }
    int j = k;
    if (this.closeIconHovered) {
      j = k + 1;
    }
    k = j;
    if (this.closeIconPressed) {
      k = j + 1;
    }
    j = k;
    if (isChecked()) {
      j = k + 1;
    }
    int[] arrayOfInt = new int[j];
    j = i;
    if (isEnabled())
    {
      arrayOfInt[0] = 16842910;
      j = 1;
    }
    k = j;
    if (this.closeIconFocused)
    {
      arrayOfInt[j] = 16842908;
      k = j + 1;
    }
    j = k;
    if (this.closeIconHovered)
    {
      arrayOfInt[k] = 16843623;
      j = k + 1;
    }
    k = j;
    if (this.closeIconPressed)
    {
      arrayOfInt[j] = 16842919;
      k = j + 1;
    }
    if (isChecked()) {
      arrayOfInt[k] = 16842913;
    }
    return arrayOfInt;
  }
  
  private void ensureChipDrawableHasCallback()
  {
    if ((getBackgroundDrawable() == this.insetBackgroundDrawable) && (this.chipDrawable.getCallback() == null)) {
      this.chipDrawable.setCallback(this.insetBackgroundDrawable);
    }
  }
  
  @NonNull
  private RectF getCloseIconTouchBounds()
  {
    this.rectF.setEmpty();
    if (hasCloseIcon()) {
      this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    }
    return this.rectF;
  }
  
  @NonNull
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.rect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.rect;
  }
  
  @Nullable
  private TextAppearance getTextAppearance()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getTextAppearance();
    } else {
      localObject = null;
    }
    return (TextAppearance)localObject;
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean handleAccessibilityExit(@NonNull MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {
      try
      {
        paramMotionEvent = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
        paramMotionEvent.setAccessible(true);
        if (((Integer)paramMotionEvent.get(this.touchHelper)).intValue() != Integer.MIN_VALUE)
        {
          paramMotionEvent = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
          paramMotionEvent.setAccessible(true);
          paramMotionEvent.invoke(this.touchHelper, new Object[] { Integer.valueOf(Integer.MIN_VALUE) });
          return true;
        }
      }
      catch (NoSuchFieldException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
      catch (NoSuchMethodException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
    }
    return false;
  }
  
  private boolean hasCloseIcon()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.getCloseIcon() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void initMinTouchTarget(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.Chip, paramInt, DEF_STYLE_RES, new int[0]);
    this.ensureMinTouchTargetSize = paramContext.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
    float f = (float)Math.ceil(ViewUtils.dpToPx(getContext(), 48));
    this.minTouchTargetSize = ((int)Math.ceil(paramContext.getDimension(R.styleable.Chip_chipMinTouchTargetSize, f)));
    paramContext.recycle();
  }
  
  private void initOutlineProvider()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ViewOutlineProvider()
      {
        @TargetApi(21)
        public void getOutline(View paramAnonymousView, @NonNull Outline paramAnonymousOutline)
        {
          if (Chip.this.chipDrawable != null) {
            Chip.this.chipDrawable.getOutline(paramAnonymousOutline);
          } else {
            paramAnonymousOutline.setAlpha(0.0F);
          }
        }
      });
    }
  }
  
  private void insetChipBackgroundDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void removeBackgroundInset()
  {
    if (this.insetBackgroundDrawable != null)
    {
      this.insetBackgroundDrawable = null;
      setMinWidth(0);
      setMinHeight((int)getChipMinHeight());
      updateBackgroundDrawable();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.closeIconHovered != paramBoolean)
    {
      this.closeIconHovered = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.closeIconPressed != paramBoolean)
    {
      this.closeIconPressed = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void unapplyChipDrawable(@Nullable ChipDrawable paramChipDrawable)
  {
    if (paramChipDrawable != null) {
      paramChipDrawable.setDelegate(null);
    }
  }
  
  private void updateAccessibilityDelegate()
  {
    if ((hasCloseIcon()) && (isCloseIconVisible()) && (this.onCloseIconClickListener != null)) {
      ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
    } else {
      ViewCompat.setAccessibilityDelegate(this, null);
    }
  }
  
  private void updateBackgroundDrawable()
  {
    if (RippleUtils.USE_FRAMEWORK_RIPPLE)
    {
      updateFrameworkRippleBackground();
    }
    else
    {
      this.chipDrawable.setUseCompatRipple(true);
      ViewCompat.setBackground(this, getBackgroundDrawable());
      updatePaddingInternal();
      ensureChipDrawableHasCallback();
    }
  }
  
  private void updateFrameworkRippleBackground()
  {
    this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
    this.chipDrawable.setUseCompatRipple(false);
    ViewCompat.setBackground(this, this.ripple);
    updatePaddingInternal();
  }
  
  private void updatePaddingInternal()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      Object localObject = this.chipDrawable;
      if (localObject != null)
      {
        int i = (int)(((ChipDrawable)localObject).getChipEndPadding() + this.chipDrawable.getTextEndPadding() + this.chipDrawable.calculateCloseIconWidth());
        int j = (int)(this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.calculateChipIconWidth());
        int k = i;
        int m = j;
        if (this.insetBackgroundDrawable != null)
        {
          localObject = new Rect();
          this.insetBackgroundDrawable.getPadding((Rect)localObject);
          m = j + ((Rect)localObject).left;
          k = i + ((Rect)localObject).right;
        }
        ViewCompat.setPaddingRelative(this, m, getPaddingTop(), k, getPaddingBottom());
      }
    }
  }
  
  private void updateTextPaintDrawState()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localTextPaint.drawableState = ((Drawable)localObject).getState();
    }
    localObject = getTextAppearance();
    if (localObject != null) {
      ((TextAppearance)localObject).updateDrawState(getContext(), localTextPaint, this.fontCallback);
    }
  }
  
  private void validateAttributes(@Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null)
      {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null)
        {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null)
          {
            if ((paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1))
            {
              if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
              }
              return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
          }
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      }
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  protected boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!handleAccessibilityExit(paramMotionEvent)) && (!this.touchHelper.dispatchHoverEvent(paramMotionEvent)) && (!super.dispatchHoverEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.touchHelper.dispatchKeyEvent(paramKeyEvent)) && (this.touchHelper.getKeyboardFocusedVirtualViewId() != Integer.MIN_VALUE)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.isCloseIconStateful())) {
      bool = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  public boolean ensureAccessibleTouchTarget(@Dimension int paramInt)
  {
    this.minTouchTargetSize = paramInt;
    boolean bool = shouldEnsureMinTouchTargetSize();
    int i = 0;
    if (!bool)
    {
      if (this.insetBackgroundDrawable != null) {
        removeBackgroundInset();
      } else {
        updateBackgroundDrawable();
      }
      return false;
    }
    int j = Math.max(0, paramInt - this.chipDrawable.getIntrinsicHeight());
    int k = Math.max(0, paramInt - this.chipDrawable.getIntrinsicWidth());
    if ((k <= 0) && (j <= 0))
    {
      if (this.insetBackgroundDrawable != null) {
        removeBackgroundInset();
      } else {
        updateBackgroundDrawable();
      }
      return false;
    }
    if (k > 0) {
      k /= 2;
    } else {
      k = 0;
    }
    if (j > 0) {
      i = j / 2;
    }
    if (this.insetBackgroundDrawable != null)
    {
      Rect localRect = new Rect();
      this.insetBackgroundDrawable.getPadding(localRect);
      if ((localRect.top == i) && (localRect.bottom == i) && (localRect.left == k) && (localRect.right == k))
      {
        updateBackgroundDrawable();
        return true;
      }
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (getMinHeight() != paramInt) {
        setMinHeight(paramInt);
      }
      if (getMinWidth() != paramInt) {
        setMinWidth(paramInt);
      }
    }
    else
    {
      setMinHeight(paramInt);
      setMinWidth(paramInt);
    }
    insetChipBackgroundDrawable(k, i, k, i);
    updateBackgroundDrawable();
    return true;
  }
  
  @Nullable
  public Drawable getBackgroundDrawable()
  {
    InsetDrawable localInsetDrawable = this.insetBackgroundDrawable;
    Object localObject = localInsetDrawable;
    if (localInsetDrawable == null) {
      localObject = this.chipDrawable;
    }
    return (Drawable)localObject;
  }
  
  @Nullable
  public Drawable getCheckedIcon()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getCheckedIcon();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  @Nullable
  public ColorStateList getCheckedIconTint()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getCheckedIconTint();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  public ColorStateList getChipBackgroundColor()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getChipBackgroundColor();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public float getChipCornerRadius()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f = 0.0F;
    if (localChipDrawable != null) {
      f = Math.max(0.0F, localChipDrawable.getChipCornerRadius());
    }
    return f;
  }
  
  public Drawable getChipDrawable()
  {
    return this.chipDrawable;
  }
  
  public float getChipEndPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getChipEndPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Nullable
  public Drawable getChipIcon()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getChipIcon();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public float getChipIconSize()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getChipIconSize();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Nullable
  public ColorStateList getChipIconTint()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getChipIconTint();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public float getChipMinHeight()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getChipMinHeight();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public float getChipStartPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getChipStartPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Nullable
  public ColorStateList getChipStrokeColor()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getChipStrokeColor();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public float getChipStrokeWidth()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getChipStrokeWidth();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    return getText();
  }
  
  @Nullable
  public Drawable getCloseIcon()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getCloseIcon();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  @Nullable
  public CharSequence getCloseIconContentDescription()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getCloseIconContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  public float getCloseIconEndPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getCloseIconEndPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public float getCloseIconSize()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getCloseIconSize();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public float getCloseIconStartPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getCloseIconStartPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Nullable
  public ColorStateList getCloseIconTint()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getCloseIconTint();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  public TextUtils.TruncateAt getEllipsize()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getEllipsize();
    } else {
      localObject = null;
    }
    return (TextUtils.TruncateAt)localObject;
  }
  
  public void getFocusedRect(@NonNull Rect paramRect)
  {
    if ((this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) && (this.touchHelper.getAccessibilityFocusedVirtualViewId() != 1)) {
      super.getFocusedRect(paramRect);
    } else {
      paramRect.set(getCloseIconTouchBoundsInt());
    }
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getHideMotionSpec();
    } else {
      localObject = null;
    }
    return (MotionSpec)localObject;
  }
  
  public float getIconEndPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getIconEndPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public float getIconStartPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getIconStartPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  @Nullable
  public ColorStateList getRippleColor()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getRippleColor();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.chipDrawable.getShapeAppearanceModel();
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    Object localObject = this.chipDrawable;
    if (localObject != null) {
      localObject = ((ChipDrawable)localObject).getShowMotionSpec();
    } else {
      localObject = null;
    }
    return (MotionSpec)localObject;
  }
  
  public float getTextEndPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getTextEndPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public float getTextStartPadding()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    float f;
    if (localChipDrawable != null) {
      f = localChipDrawable.getTextStartPadding();
    } else {
      f = 0.0F;
    }
    return f;
  }
  
  public boolean isCheckable()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.isCheckable())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isCheckedIconEnabled()
  {
    return isCheckedIconVisible();
  }
  
  public boolean isCheckedIconVisible()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.isCheckedIconVisible())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isChipIconEnabled()
  {
    return isChipIconVisible();
  }
  
  public boolean isChipIconVisible()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.isChipIconVisible())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isCloseIconEnabled()
  {
    return isCloseIconVisible();
  }
  
  public boolean isCloseIconVisible()
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    boolean bool;
    if ((localChipDrawable != null) && (localChipDrawable.isCloseIconVisible())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
  }
  
  public void onChipDrawableSizeChange()
  {
    ensureAccessibleTouchTarget(this.minTouchTargetSize);
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked()) {
      CheckBox.mergeDrawableStates(arrayOfInt, SELECTED_STATE);
    }
    if (isCheckable()) {
      CheckBox.mergeDrawableStates(arrayOfInt, CHECKABLE_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.touchHelper.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 7)
    {
      if (i == 10) {
        setCloseIconHovered(false);
      }
    }
    else {
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject;
    if ((!isCheckable()) && (!isClickable()))
    {
      paramAccessibilityNodeInfo.setClassName("android.view.View");
    }
    else
    {
      if (isCheckable()) {
        localObject = "android.widget.CompoundButton";
      } else {
        localObject = "android.widget.Button";
      }
      paramAccessibilityNodeInfo.setClassName((CharSequence)localObject);
    }
    paramAccessibilityNodeInfo.setCheckable(isCheckable());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if ((getParent() instanceof ChipGroup))
    {
      localObject = (ChipGroup)getParent();
      paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
      int i;
      if (((ChipGroup)localObject).isSingleLine()) {
        i = ((ChipGroup)localObject).getIndexOfChip(this);
      } else {
        i = -1;
      }
      paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(((FlowLayout)localObject).getRowIndex(this), 1, i, 1, false, isChecked()));
    }
  }
  
  @TargetApi(24)
  @Nullable
  public PointerIcon onResolvePointerIcon(@NonNull MotionEvent paramMotionEvent, int paramInt)
  {
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  @TargetApi(17)
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if (this.lastLayoutDirection != paramInt)
    {
      this.lastLayoutDirection = paramInt;
      updatePaddingInternal();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    boolean bool2 = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label106;
          }
        }
        else
        {
          if (!this.closeIconPressed) {
            break label106;
          }
          if (bool1) {
            break label101;
          }
          setCloseIconPressed(false);
          break label101;
        }
      }
      else if (this.closeIconPressed)
      {
        performCloseIconClick();
        i = 1;
        break label84;
      }
      i = 0;
      label84:
      setCloseIconPressed(false);
      break label108;
    }
    else
    {
      if (!bool1) {
        break label106;
      }
      setCloseIconPressed(true);
    }
    label101:
    i = 1;
    break label108;
    label106:
    i = 0;
    label108:
    if ((i != 0) || (super.onTouchEvent(paramMotionEvent))) {
      bool2 = true;
    }
    return bool2;
  }
  
  @CallSuper
  public boolean performCloseIconClick()
  {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener localOnClickListener = this.onCloseIconClickListener;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      bool = true;
    }
    this.touchHelper.sendEventForVirtualView(1, 1);
    return bool;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.ripple)) {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    } else {
      super.setBackground(paramDrawable);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.ripple)) {
      Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
    } else {
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckable(paramBoolean);
    }
  }
  
  public void setCheckableResource(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckableResource(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.chipDrawable;
    if (localObject == null)
    {
      this.deferredCheckedValue = paramBoolean;
    }
    else if (((ChipDrawable)localObject).isCheckable())
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if (bool != paramBoolean)
      {
        localObject = this.onCheckedChangeListenerInternal;
        if (localObject != null) {
          ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
        }
      }
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(@BoolRes int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIconResource(paramInt);
    }
  }
  
  public void setCheckedIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIconTint(paramColorStateList);
    }
  }
  
  public void setCheckedIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIconTintResource(paramInt);
    }
  }
  
  public void setCheckedIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIconVisible(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCheckedIconVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipBackgroundColor(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipBackgroundColorResource(paramInt);
    }
  }
  
  @Deprecated
  public void setChipCornerRadius(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipCornerRadius(paramFloat);
    }
  }
  
  @Deprecated
  public void setChipCornerRadiusResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipCornerRadiusResource(paramInt);
    }
  }
  
  public void setChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != paramChipDrawable)
    {
      unapplyChipDrawable(localChipDrawable);
      this.chipDrawable = paramChipDrawable;
      paramChipDrawable.setShouldDrawText(false);
      applyChipDrawable(this.chipDrawable);
      ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipEndPadding(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipEndPaddingResource(paramInt);
    }
  }
  
  public void setChipIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(@BoolRes int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconResource(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconSize(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconSizeResource(paramInt);
    }
  }
  
  public void setChipIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconTint(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconTintResource(paramInt);
    }
  }
  
  public void setChipIconVisible(@BoolRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconVisible(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipIconVisible(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipMinHeight(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipMinHeightResource(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStartPadding(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStartPaddingResource(paramInt);
    }
  }
  
  public void setChipStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStrokeColor(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStrokeColorResource(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStrokeWidth(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setChipStrokeWidthResource(paramInt);
    }
  }
  
  @Deprecated
  public void setChipText(@Nullable CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(@StringRes int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(@Nullable Drawable paramDrawable)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIcon(paramDrawable);
    }
    updateAccessibilityDelegate();
  }
  
  public void setCloseIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconContentDescription(paramCharSequence);
    }
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(@BoolRes int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconEndPadding(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconEndPaddingResource(paramInt);
    }
  }
  
  public void setCloseIconResource(@DrawableRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconResource(paramInt);
    }
    updateAccessibilityDelegate();
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconSize(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconSizeResource(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconStartPadding(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconStartPaddingResource(paramInt);
    }
  }
  
  public void setCloseIconTint(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconTint(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconTintResource(paramInt);
    }
  }
  
  public void setCloseIconVisible(@BoolRes int paramInt)
  {
    setCloseIconVisible(getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setCloseIconVisible(paramBoolean);
    }
    updateAccessibilityDelegate();
  }
  
  public void setCompoundDrawables(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setElevation(paramFloat);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.chipDrawable == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      ChipDrawable localChipDrawable = this.chipDrawable;
      if (localChipDrawable != null) {
        localChipDrawable.setEllipsize(paramTruncateAt);
      }
      return;
    }
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    this.ensureMinTouchTargetSize = paramBoolean;
    ensureAccessibleTouchTarget(this.minTouchTargetSize);
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt != 8388627) {
      Log.w("Chip", "Chip text must be vertically center and start aligned");
    } else {
      super.setGravity(paramInt);
    }
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setHideMotionSpec(paramMotionSpec);
    }
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setHideMotionSpecResource(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setIconEndPadding(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setIconEndPaddingResource(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setIconStartPadding(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setIconStartPaddingResource(paramInt);
    }
  }
  
  public void setLayoutDirection(int paramInt)
  {
    if (this.chipDrawable == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      super.setLayoutDirection(paramInt);
    }
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMaxLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(@Px int paramInt)
  {
    super.setMaxWidth(paramInt);
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setMaxWidth(paramInt);
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMinLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.onCheckedChangeListenerInternal = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onCloseIconClickListener = paramOnClickListener;
    updateAccessibilityDelegate();
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setRippleColor(paramColorStateList);
    }
    if (!this.chipDrawable.getUseCompatRipple()) {
      updateFrameworkRippleBackground();
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null)
    {
      localChipDrawable.setRippleColorResource(paramInt);
      if (!this.chipDrawable.getUseCompatRipple()) {
        updateFrameworkRippleBackground();
      }
    }
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.chipDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setShowMotionSpec(paramMotionSpec);
    }
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setShowMotionSpecResource(paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localChipDrawable.shouldDrawText()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = (CharSequence)localObject;
    }
    super.setText(paramCharSequence, paramBufferType);
    paramCharSequence = this.chipDrawable;
    if (paramCharSequence != null) {
      paramCharSequence.setText((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextAppearanceResource(paramInt);
    }
    updateTextPaintDrawState();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = this.chipDrawable;
    if (paramContext != null) {
      paramContext.setTextAppearanceResource(paramInt);
    }
    updateTextPaintDrawState();
  }
  
  public void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextAppearance(paramTextAppearance);
    }
    updateTextPaintDrawState();
  }
  
  public void setTextAppearanceResource(@StyleRes int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextEndPadding(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextEndPaddingResource(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextStartPadding(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(@DimenRes int paramInt)
  {
    ChipDrawable localChipDrawable = this.chipDrawable;
    if (localChipDrawable != null) {
      localChipDrawable.setTextStartPaddingResource(paramInt);
    }
  }
  
  public boolean shouldEnsureMinTouchTargetSize()
  {
    return this.ensureMinTouchTargetSize;
  }
  
  private class ChipTouchHelper
    extends ExploreByTouchHelper
  {
    ChipTouchHelper(Chip paramChip)
    {
      super();
    }
    
    protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      int i;
      if ((Chip.this.hasCloseIcon()) && (Chip.this.getCloseIconTouchBounds().contains(paramFloat1, paramFloat2))) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    }
    
    protected void getVisibleVirtualViews(@NonNull List<Integer> paramList)
    {
      paramList.add(Integer.valueOf(0));
      if ((Chip.this.hasCloseIcon()) && (Chip.this.isCloseIconVisible()) && (Chip.this.onCloseIconClickListener != null)) {
        paramList.add(Integer.valueOf(1));
      }
    }
    
    protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (paramInt2 == 16)
      {
        if (paramInt1 == 0) {
          return Chip.this.performClick();
        }
        if (paramInt1 == 1) {
          return Chip.this.performCloseIconClick();
        }
      }
      return false;
    }
    
    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      paramAccessibilityNodeInfoCompat.setCheckable(Chip.this.isCheckable());
      paramAccessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
      if ((!Chip.this.isCheckable()) && (!Chip.this.isClickable()))
      {
        paramAccessibilityNodeInfoCompat.setClassName("android.view.View");
      }
      else
      {
        if (Chip.this.isCheckable()) {
          localObject = "android.widget.CompoundButton";
        } else {
          localObject = "android.widget.Button";
        }
        paramAccessibilityNodeInfoCompat.setClassName((CharSequence)localObject);
      }
      Object localObject = Chip.this.getText();
      if (Build.VERSION.SDK_INT >= 23) {
        paramAccessibilityNodeInfoCompat.setText((CharSequence)localObject);
      } else {
        paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
      }
    }
    
    protected void onPopulateNodeForVirtualView(int paramInt, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      Object localObject = "";
      if (paramInt == 1)
      {
        CharSequence localCharSequence = Chip.this.getCloseIconContentDescription();
        if (localCharSequence != null)
        {
          paramAccessibilityNodeInfoCompat.setContentDescription(localCharSequence);
        }
        else
        {
          localCharSequence = Chip.this.getText();
          Context localContext = Chip.this.getContext();
          paramInt = R.string.mtrl_chip_close_icon_content_description;
          if (!TextUtils.isEmpty(localCharSequence)) {
            localObject = localCharSequence;
          }
          paramAccessibilityNodeInfoCompat.setContentDescription(localContext.getString(paramInt, new Object[] { localObject }).trim());
        }
        paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
        paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        paramAccessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
      }
      else
      {
        paramAccessibilityNodeInfoCompat.setContentDescription("");
        paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.EMPTY_BOUNDS);
      }
    }
    
    protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean)
    {
      if (paramInt == 1)
      {
        Chip.access$402(Chip.this, paramBoolean);
        Chip.this.refreshDrawableState();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\chip\Chip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */