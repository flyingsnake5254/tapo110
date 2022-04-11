package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>>
  extends View
{
  private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
  private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
  private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
  private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
  private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
  private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
  private static final int HALO_ALPHA = 63;
  private static final String TAG = BaseSlider.class.getSimpleName();
  private static final double THRESHOLD = 1.0E-4D;
  private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
  private static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
  private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
  @NonNull
  private final AccessibilityHelper accessibilityHelper;
  private final AccessibilityManager accessibilityManager;
  private int activeThumbIdx = -1;
  @NonNull
  private final Paint activeTicksPaint;
  @NonNull
  private final Paint activeTrackPaint;
  @NonNull
  private final List<L> changeListeners = new ArrayList();
  private boolean dirtyConfig;
  private int focusedThumbIdx = -1;
  private boolean forceDrawCompatHalo;
  private LabelFormatter formatter;
  @NonNull
  private ColorStateList haloColor;
  @NonNull
  private final Paint haloPaint;
  private int haloRadius;
  @NonNull
  private final Paint inactiveTicksPaint;
  @NonNull
  private final Paint inactiveTrackPaint;
  private boolean isLongPress = false;
  private int labelBehavior;
  @NonNull
  private final TooltipDrawableFactory labelMaker;
  private int labelPadding;
  @NonNull
  private final List<TooltipDrawable> labels = new ArrayList();
  private MotionEvent lastEvent;
  private final int scaledTouchSlop;
  private float stepSize = 0.0F;
  @NonNull
  private final MaterialShapeDrawable thumbDrawable;
  private boolean thumbIsPressed = false;
  @NonNull
  private final Paint thumbPaint;
  private int thumbRadius;
  @NonNull
  private ColorStateList tickColorActive;
  @NonNull
  private ColorStateList tickColorInactive;
  private float[] ticksCoordinates;
  private float touchDownX;
  @NonNull
  private final List<T> touchListeners = new ArrayList();
  private float touchPosition;
  @NonNull
  private ColorStateList trackColorActive;
  @NonNull
  private ColorStateList trackColorInactive;
  private int trackHeight;
  private int trackSidePadding;
  private int trackTop;
  private int trackWidth;
  private float valueFrom;
  private float valueTo;
  private ArrayList<Float> values = new ArrayList();
  private int widgetHeight;
  
  public BaseSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable final AttributeSet paramAttributeSet, final int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, DEF_STYLE_RES), paramAttributeSet, paramInt);
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    this.thumbDrawable = localMaterialShapeDrawable;
    paramContext = getContext();
    Paint localPaint = new Paint();
    this.inactiveTrackPaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint();
    this.activeTrackPaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint(1);
    this.thumbPaint = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    localPaint = new Paint(1);
    this.haloPaint = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.inactiveTicksPaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint();
    this.activeTicksPaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    loadResources(paramContext.getResources());
    this.labelMaker = new TooltipDrawableFactory()
    {
      public TooltipDrawable createTooltipDrawable()
      {
        TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), paramAttributeSet, R.styleable.Slider, paramInt, BaseSlider.DEF_STYLE_RES, new int[0]);
        TooltipDrawable localTooltipDrawable = BaseSlider.parseLabelDrawable(BaseSlider.this.getContext(), localTypedArray);
        localTypedArray.recycle();
        return localTooltipDrawable;
      }
    };
    processAttributes(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setClickable(true);
    localMaterialShapeDrawable.setShadowCompatibilityMode(2);
    this.scaledTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = new AccessibilityHelper(this);
    this.accessibilityHelper = paramContext;
    ViewCompat.setAccessibilityDelegate(this, paramContext);
    this.accessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
  }
  
  private void attachLabelToContentView(TooltipDrawable paramTooltipDrawable)
  {
    paramTooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
  }
  
  private Float calculateIncrementForKey(int paramInt)
  {
    float f1;
    if (this.isLongPress) {
      f1 = calculateStepIncrement(20);
    } else {
      f1 = calculateStepIncrement();
    }
    if (paramInt != 21)
    {
      if (paramInt != 22)
      {
        if (paramInt != 69)
        {
          if ((paramInt != 70) && (paramInt != 81)) {
            return null;
          }
          return Float.valueOf(f1);
        }
        return Float.valueOf(-f1);
      }
      float f2 = f1;
      if (isRtl()) {
        f2 = -f1;
      }
      return Float.valueOf(f2);
    }
    if (!isRtl()) {
      f1 = -f1;
    }
    return Float.valueOf(f1);
  }
  
  private float calculateStepIncrement()
  {
    float f1 = this.stepSize;
    float f2 = f1;
    if (f1 == 0.0F) {
      f2 = 1.0F;
    }
    return f2;
  }
  
  private float calculateStepIncrement(int paramInt)
  {
    float f1 = calculateStepIncrement();
    float f2 = (this.valueTo - this.valueFrom) / f1;
    float f3 = paramInt;
    if (f2 <= f3) {
      return f1;
    }
    return Math.round(f2 / f3) * f1;
  }
  
  private void calculateTicksCoordinates()
  {
    validateConfigurationIfDirty();
    int i = Math.min((int)((this.valueTo - this.valueFrom) / this.stepSize + 1.0F), this.trackWidth / (this.trackHeight * 2) + 1);
    float[] arrayOfFloat = this.ticksCoordinates;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != i * 2)) {
      this.ticksCoordinates = new float[i * 2];
    }
    float f = this.trackWidth / (i - 1);
    for (int j = 0; j < i * 2; j += 2)
    {
      arrayOfFloat = this.ticksCoordinates;
      arrayOfFloat[j] = (this.trackSidePadding + j / 2 * f);
      arrayOfFloat[(j + 1)] = calculateTop();
    }
  }
  
  private int calculateTop()
  {
    int i = this.trackTop;
    int j = this.labelBehavior;
    int k = 0;
    if (j == 1) {
      k = ((TooltipDrawable)this.labels.get(0)).getIntrinsicHeight();
    }
    return i + k;
  }
  
  private void createLabelPool()
  {
    if (this.labels.size() > this.values.size())
    {
      localObject = this.labels.subList(this.values.size(), this.labels.size());
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
        if (ViewCompat.isAttachedToWindow(this)) {
          detachLabelFromContentView(localTooltipDrawable);
        }
      }
      ((List)localObject).clear();
    }
    while (this.labels.size() < this.values.size())
    {
      localObject = this.labelMaker.createTooltipDrawable();
      this.labels.add(localObject);
      if (ViewCompat.isAttachedToWindow(this)) {
        attachLabelToContentView((TooltipDrawable)localObject);
      }
    }
    int i = this.labels.size();
    int j = 1;
    if (i == 1) {
      j = 0;
    }
    Object localObject = this.labels.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TooltipDrawable)((Iterator)localObject).next()).setStrokeWidth(j);
    }
  }
  
  private void detachLabelFromContentView(TooltipDrawable paramTooltipDrawable)
  {
    ViewOverlayImpl localViewOverlayImpl = ViewUtils.getContentViewOverlay(this);
    if (localViewOverlayImpl != null)
    {
      localViewOverlayImpl.remove(paramTooltipDrawable);
      paramTooltipDrawable.detachView(ViewUtils.getContentView(this));
    }
  }
  
  private void dispatchOnChangedFromUser(int paramInt)
  {
    Object localObject = this.changeListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseOnChangeListener)((Iterator)localObject).next()).onValueChange(this, ((Float)this.values.get(paramInt)).floatValue(), true);
    }
    localObject = this.accessibilityManager;
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled())) {
      scheduleAccessibilityEventSender(paramInt);
    }
  }
  
  private void dispatchOnChangedProgramatically()
  {
    Iterator localIterator1 = this.changeListeners.iterator();
    while (localIterator1.hasNext())
    {
      BaseOnChangeListener localBaseOnChangeListener = (BaseOnChangeListener)localIterator1.next();
      Iterator localIterator2 = this.values.iterator();
      while (localIterator2.hasNext()) {
        localBaseOnChangeListener.onValueChange(this, ((Float)localIterator2.next()).floatValue(), false);
      }
    }
  }
  
  private void drawActiveTrack(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i = this.trackSidePadding;
    float f1 = i;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    float f4 = i;
    float f5 = arrayOfFloat[0];
    float f6 = paramInt2;
    paramCanvas.drawLine(f4 + f5 * f3, f6, f1 + f2 * f3, f6, this.activeTrackPaint);
  }
  
  private void drawInactiveTrack(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i = this.trackSidePadding;
    float f1 = i;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    f2 = f1 + f2 * f3;
    if (f2 < i + paramInt1)
    {
      f1 = paramInt2;
      paramCanvas.drawLine(f2, f1, i + paramInt1, f1, this.inactiveTrackPaint);
    }
    paramInt1 = this.trackSidePadding;
    f2 = paramInt1 + arrayOfFloat[0] * f3;
    if (f2 > paramInt1)
    {
      f1 = paramInt1;
      f3 = paramInt2;
      paramCanvas.drawLine(f1, f3, f2, f3, this.inactiveTrackPaint);
    }
  }
  
  private void drawThumbs(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Float localFloat;
    if (!isEnabled())
    {
      localIterator = this.values.iterator();
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        paramCanvas.drawCircle(this.trackSidePadding + normalizeValue(localFloat.floatValue()) * paramInt1, paramInt2, this.thumbRadius, this.thumbPaint);
      }
    }
    Iterator localIterator = this.values.iterator();
    while (localIterator.hasNext())
    {
      localFloat = (Float)localIterator.next();
      paramCanvas.save();
      int i = this.trackSidePadding;
      int j = (int)(normalizeValue(localFloat.floatValue()) * paramInt1);
      int k = this.thumbRadius;
      paramCanvas.translate(i + j - k, paramInt2 - k);
      this.thumbDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private void drawTicks(@NonNull Canvas paramCanvas)
  {
    float[] arrayOfFloat = getActiveRange();
    int i = pivotIndex(this.ticksCoordinates, arrayOfFloat[0]);
    int j = pivotIndex(this.ticksCoordinates, arrayOfFloat[1]);
    arrayOfFloat = this.ticksCoordinates;
    i *= 2;
    paramCanvas.drawPoints(arrayOfFloat, 0, i, this.inactiveTicksPaint);
    arrayOfFloat = this.ticksCoordinates;
    j *= 2;
    paramCanvas.drawPoints(arrayOfFloat, i, j - i, this.activeTicksPaint);
    arrayOfFloat = this.ticksCoordinates;
    paramCanvas.drawPoints(arrayOfFloat, j, arrayOfFloat.length - j, this.inactiveTicksPaint);
  }
  
  private void ensureLabels()
  {
    if (this.labelBehavior == 2) {
      return;
    }
    Iterator localIterator = this.labels.iterator();
    for (int i = 0; (i < this.values.size()) && (localIterator.hasNext()); i++) {
      if (i != this.focusedThumbIdx) {
        setValueForLabel((TooltipDrawable)localIterator.next(), ((Float)this.values.get(i)).floatValue());
      }
    }
    if (localIterator.hasNext())
    {
      setValueForLabel((TooltipDrawable)localIterator.next(), ((Float)this.values.get(this.focusedThumbIdx)).floatValue());
      return;
    }
    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[] { Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size()) }));
  }
  
  private void focusThumbOnFocusGained(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt == 66) {
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
          }
        }
        else {
          moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        }
      }
      else {
        moveFocus(Integer.MIN_VALUE);
      }
    }
    else {
      moveFocus(Integer.MAX_VALUE);
    }
  }
  
  private String formatValue(float paramFloat)
  {
    if (hasLabelFormatter()) {
      return this.formatter.getFormattedValue(paramFloat);
    }
    String str;
    if ((int)paramFloat == paramFloat) {
      str = "%.0f";
    } else {
      str = "%.2f";
    }
    return String.format(str, new Object[] { Float.valueOf(paramFloat) });
  }
  
  private float[] getActiveRange()
  {
    float f1 = ((Float)Collections.max(getValues())).floatValue();
    float f2 = ((Float)Collections.min(getValues())).floatValue();
    if (this.values.size() == 1) {
      f2 = this.valueFrom;
    }
    f2 = normalizeValue(f2);
    f1 = normalizeValue(f1);
    float[] arrayOfFloat;
    if (isRtl())
    {
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
    }
    else
    {
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f1;
    }
    return arrayOfFloat;
  }
  
  private float getClampedValue(int paramInt, float paramFloat)
  {
    int i = paramInt + 1;
    float f1;
    if (i >= this.values.size()) {
      f1 = this.valueTo;
    } else {
      f1 = ((Float)this.values.get(i)).floatValue();
    }
    paramInt--;
    float f2;
    if (paramInt < 0) {
      f2 = this.valueFrom;
    } else {
      f2 = ((Float)this.values.get(paramInt)).floatValue();
    }
    return MathUtils.clamp(paramFloat, f2, f1);
  }
  
  @ColorInt
  private int getColorForState(@NonNull ColorStateList paramColorStateList)
  {
    return paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
  }
  
  private float getValueOfTouchPosition()
  {
    double d1 = snapPosition(this.touchPosition);
    double d2 = d1;
    if (isRtl()) {
      d2 = 1.0D - d1;
    }
    float f1 = this.valueTo;
    float f2 = this.valueFrom;
    return (float)(d2 * (f1 - f2) + f2);
  }
  
  private float getValueOfTouchPositionAbsolute()
  {
    float f1 = this.touchPosition;
    float f2 = f1;
    if (isRtl()) {
      f2 = 1.0F - f1;
    }
    f1 = this.valueTo;
    float f3 = this.valueFrom;
    return f2 * (f1 - f3) + f3;
  }
  
  private void invalidateTrack()
  {
    this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
    this.activeTrackPaint.setStrokeWidth(this.trackHeight);
    this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0F);
    this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0F);
  }
  
  private boolean isInScrollingContainer()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof ViewGroup); localViewParent = localViewParent.getParent()) {
      if (((ViewGroup)localViewParent).shouldDelayChildPressedState()) {
        return true;
      }
    }
    return false;
  }
  
  private void loadResources(@NonNull Resources paramResources)
  {
    this.widgetHeight = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
    this.trackSidePadding = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
    this.trackTop = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
    this.labelPadding = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
  }
  
  private void maybeDrawHalo(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (shouldDrawCompatHalo())
    {
      int i = (int)(this.trackSidePadding + normalizeValue(((Float)this.values.get(this.focusedThumbIdx)).floatValue()) * paramInt1);
      if (Build.VERSION.SDK_INT < 28)
      {
        paramInt1 = this.haloRadius;
        paramCanvas.clipRect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2, Region.Op.UNION);
      }
      paramCanvas.drawCircle(i, paramInt2, this.haloRadius, this.haloPaint);
    }
  }
  
  private boolean moveFocus(int paramInt)
  {
    int i = this.focusedThumbIdx;
    paramInt = (int)MathUtils.clamp(i + paramInt, 0L, this.values.size() - 1);
    this.focusedThumbIdx = paramInt;
    if (paramInt == i) {
      return false;
    }
    if (this.activeThumbIdx != -1) {
      this.activeThumbIdx = paramInt;
    }
    updateHaloHotspot();
    postInvalidate();
    return true;
  }
  
  private boolean moveFocusInAbsoluteDirection(int paramInt)
  {
    int i = paramInt;
    if (isRtl()) {
      if (paramInt == Integer.MIN_VALUE) {
        i = Integer.MAX_VALUE;
      } else {
        i = -paramInt;
      }
    }
    return moveFocus(i);
  }
  
  private float normalizeValue(float paramFloat)
  {
    float f = this.valueFrom;
    paramFloat = (paramFloat - f) / (this.valueTo - f);
    if (isRtl()) {
      return 1.0F - paramFloat;
    }
    return paramFloat;
  }
  
  private Boolean onKeyDownNoActiveThumb(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (paramInt != 61)
    {
      if (paramInt != 66)
      {
        if (paramInt != 81) {
          if (paramInt != 69) {
            if (paramInt == 70) {
              break label88;
            }
          }
        }
        switch (paramInt)
        {
        default: 
          return null;
        case 22: 
          moveFocusInAbsoluteDirection(1);
          return Boolean.TRUE;
        case 21: 
          moveFocusInAbsoluteDirection(-1);
          return Boolean.TRUE;
          moveFocus(-1);
          return Boolean.TRUE;
          label88:
          moveFocus(1);
          return Boolean.TRUE;
        }
      }
      this.activeThumbIdx = this.focusedThumbIdx;
      postInvalidate();
      return Boolean.TRUE;
    }
    if (paramKeyEvent.hasNoModifiers()) {
      return Boolean.valueOf(moveFocus(1));
    }
    if (paramKeyEvent.isShiftPressed()) {
      return Boolean.valueOf(moveFocus(-1));
    }
    return Boolean.FALSE;
  }
  
  private void onStartTrackingTouch()
  {
    Iterator localIterator = this.touchListeners.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).onStartTrackingTouch(this);
    }
  }
  
  private void onStopTrackingTouch()
  {
    Iterator localIterator = this.touchListeners.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).onStopTrackingTouch(this);
    }
  }
  
  @NonNull
  private static TooltipDrawable parseLabelDrawable(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    return TooltipDrawable.createFromAttributes(paramContext, null, 0, paramTypedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
  }
  
  private static int pivotIndex(float[] paramArrayOfFloat, float paramFloat)
  {
    return Math.round(paramFloat * (paramArrayOfFloat.length / 2 - 1));
  }
  
  private void processAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.Slider, paramInt, DEF_STYLE_RES, new int[0]);
    this.valueFrom = localTypedArray.getFloat(R.styleable.Slider_android_valueFrom, 0.0F);
    this.valueTo = localTypedArray.getFloat(R.styleable.Slider_android_valueTo, 1.0F);
    setValues(new Float[] { Float.valueOf(this.valueFrom) });
    this.stepSize = localTypedArray.getFloat(R.styleable.Slider_android_stepSize, 0.0F);
    paramInt = R.styleable.Slider_trackColor;
    boolean bool = localTypedArray.hasValue(paramInt);
    int i;
    if (bool) {
      i = paramInt;
    } else {
      i = R.styleable.Slider_trackColorInactive;
    }
    if (!bool) {
      paramInt = R.styleable.Slider_trackColorActive;
    }
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, i);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_inactive_track_color);
    }
    setTrackInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_active_track_color);
    }
    setTrackActiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.Slider_thumbColor);
    this.thumbDrawable.setFillColor(paramAttributeSet);
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.Slider_haloColor);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_halo_color);
    }
    setHaloTintList(paramAttributeSet);
    paramInt = R.styleable.Slider_tickColor;
    bool = localTypedArray.hasValue(paramInt);
    if (bool) {
      i = paramInt;
    } else {
      i = R.styleable.Slider_tickColorInactive;
    }
    if (!bool) {
      paramInt = R.styleable.Slider_tickColorActive;
    }
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, i);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_inactive_tick_marks_color);
    }
    setTickInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.getColorStateList(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet;
    } else {
      paramContext = AppCompatResources.getColorStateList(paramContext, R.color.material_slider_active_tick_marks_color);
    }
    setTickActiveTintList(paramContext);
    setThumbRadius(localTypedArray.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
    setHaloRadius(localTypedArray.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
    setThumbElevation(localTypedArray.getDimension(R.styleable.Slider_thumbElevation, 0.0F));
    setTrackHeight(localTypedArray.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
    this.labelBehavior = localTypedArray.getInt(R.styleable.Slider_labelBehavior, 0);
    if (!localTypedArray.getBoolean(R.styleable.Slider_android_enabled, true)) {
      setEnabled(false);
    }
    localTypedArray.recycle();
  }
  
  private void scheduleAccessibilityEventSender(int paramInt)
  {
    AccessibilityEventSender localAccessibilityEventSender = this.accessibilityEventSender;
    if (localAccessibilityEventSender == null) {
      this.accessibilityEventSender = new AccessibilityEventSender(null);
    } else {
      removeCallbacks(localAccessibilityEventSender);
    }
    this.accessibilityEventSender.setVirtualViewId(paramInt);
    postDelayed(this.accessibilityEventSender, 200L);
  }
  
  private void setValueForLabel(TooltipDrawable paramTooltipDrawable, float paramFloat)
  {
    paramTooltipDrawable.setText(formatValue(paramFloat));
    int i = this.trackSidePadding + (int)(normalizeValue(paramFloat) * this.trackWidth) - paramTooltipDrawable.getIntrinsicWidth() / 2;
    int j = calculateTop() - (this.labelPadding + this.thumbRadius);
    paramTooltipDrawable.setBounds(i, j - paramTooltipDrawable.getIntrinsicHeight(), paramTooltipDrawable.getIntrinsicWidth() + i, j);
    Rect localRect = new Rect(paramTooltipDrawable.getBounds());
    DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, localRect);
    paramTooltipDrawable.setBounds(localRect);
    ViewUtils.getContentViewOverlay(this).add(paramTooltipDrawable);
  }
  
  private void setValuesInternal(@NonNull ArrayList<Float> paramArrayList)
  {
    if (!paramArrayList.isEmpty())
    {
      Collections.sort(paramArrayList);
      if ((this.values.size() == paramArrayList.size()) && (this.values.equals(paramArrayList))) {
        return;
      }
      this.values = paramArrayList;
      this.dirtyConfig = true;
      this.focusedThumbIdx = 0;
      updateHaloHotspot();
      createLabelPool();
      dispatchOnChangedProgramatically();
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("At least one value must be set");
  }
  
  private boolean shouldDrawCompatHalo()
  {
    boolean bool;
    if ((!this.forceDrawCompatHalo) && (Build.VERSION.SDK_INT >= 21) && ((getBackground() instanceof RippleDrawable))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean snapActiveThumbToValue(float paramFloat)
  {
    return snapThumbToValue(this.activeThumbIdx, paramFloat);
  }
  
  private double snapPosition(float paramFloat)
  {
    float f = this.stepSize;
    if (f > 0.0F)
    {
      int i = (int)((this.valueTo - this.valueFrom) / f);
      return Math.round(paramFloat * i) / i;
    }
    return paramFloat;
  }
  
  private boolean snapThumbToValue(int paramInt, float paramFloat)
  {
    if (Math.abs(paramFloat - ((Float)this.values.get(paramInt)).floatValue()) < 1.0E-4D) {
      return false;
    }
    paramFloat = getClampedValue(paramInt, paramFloat);
    this.values.set(paramInt, Float.valueOf(paramFloat));
    this.focusedThumbIdx = paramInt;
    dispatchOnChangedFromUser(paramInt);
    return true;
  }
  
  private boolean snapTouchPosition()
  {
    return snapActiveThumbToValue(getValueOfTouchPosition());
  }
  
  private void updateHaloHotspot()
  {
    if ((!shouldDrawCompatHalo()) && (getMeasuredWidth() > 0))
    {
      Drawable localDrawable = getBackground();
      if ((localDrawable instanceof RippleDrawable))
      {
        int i = (int)(normalizeValue(((Float)this.values.get(this.focusedThumbIdx)).floatValue()) * this.trackWidth + this.trackSidePadding);
        int j = calculateTop();
        int k = this.haloRadius;
        DrawableCompat.setHotspotBounds(localDrawable, i - k, j - k, i + k, j + k);
      }
    }
  }
  
  private void validateConfigurationIfDirty()
  {
    if (this.dirtyConfig)
    {
      validateValueFrom();
      validateValueTo();
      validateStepSize();
      validateValues();
      warnAboutFloatingPointError();
      this.dirtyConfig = false;
    }
  }
  
  private void validateStepSize()
  {
    if ((this.stepSize > 0.0F) && (!valueLandsOnTick(this.valueTo))) {
      throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo) }));
    }
  }
  
  private void validateValueFrom()
  {
    if (this.valueFrom < this.valueTo) {
      return;
    }
    throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[] { Float.toString(this.valueFrom), Float.toString(this.valueTo) }));
  }
  
  private void validateValueTo()
  {
    if (this.valueTo > this.valueFrom) {
      return;
    }
    throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[] { Float.toString(this.valueTo), Float.toString(this.valueFrom) }));
  }
  
  private void validateValues()
  {
    Iterator localIterator = this.values.iterator();
    while (localIterator.hasNext())
    {
      Float localFloat = (Float)localIterator.next();
      if ((localFloat.floatValue() >= this.valueFrom) && (localFloat.floatValue() <= this.valueTo))
      {
        if ((this.stepSize > 0.0F) && (!valueLandsOnTick(localFloat.floatValue()))) {
          throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize) }));
        }
      }
      else {
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo) }));
      }
    }
  }
  
  private boolean valueLandsOnTick(float paramFloat)
  {
    double d = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
    boolean bool;
    if (Math.abs(Math.round(d) - d) < 1.0E-4D) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private float valueToX(float paramFloat)
  {
    return normalizeValue(paramFloat) * this.trackWidth + this.trackSidePadding;
  }
  
  private void warnAboutFloatingPointError()
  {
    float f = this.stepSize;
    if (f == 0.0F) {
      return;
    }
    if ((int)f != f) {
      Log.w(TAG, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "stepSize", Float.valueOf(f) }));
    }
    f = this.valueFrom;
    if ((int)f != f) {
      Log.w(TAG, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueFrom", Float.valueOf(f) }));
    }
    f = this.valueTo;
    if ((int)f != f) {
      Log.w(TAG, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueTo", Float.valueOf(f) }));
    }
  }
  
  public void addOnChangeListener(@Nullable L paramL)
  {
    this.changeListeners.add(paramL);
  }
  
  public void addOnSliderTouchListener(@NonNull T paramT)
  {
    this.touchListeners.add(paramT);
  }
  
  public void clearOnChangeListeners()
  {
    this.changeListeners.clear();
  }
  
  public void clearOnSliderTouchListeners()
  {
    this.touchListeners.clear();
  }
  
  public boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!this.accessibilityHelper.dispatchHoverEvent(paramMotionEvent)) && (!super.dispatchHoverEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
    this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
    this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
    this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
    Iterator localIterator = this.labels.iterator();
    while (localIterator.hasNext())
    {
      TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
      if (localTooltipDrawable.isStateful()) {
        localTooltipDrawable.setState(getDrawableState());
      }
    }
    if (this.thumbDrawable.isStateful()) {
      this.thumbDrawable.setState(getDrawableState());
    }
    this.haloPaint.setColor(getColorForState(this.haloColor));
    this.haloPaint.setAlpha(63);
  }
  
  @VisibleForTesting
  void forceDrawCompatHalo(boolean paramBoolean)
  {
    this.forceDrawCompatHalo = paramBoolean;
  }
  
  @NonNull
  public CharSequence getAccessibilityClassName()
  {
    return SeekBar.class.getName();
  }
  
  @VisibleForTesting
  final int getAccessibilityFocusedVirtualViewId()
  {
    return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
  }
  
  public int getActiveThumbIndex()
  {
    return this.activeThumbIdx;
  }
  
  public int getFocusedThumbIndex()
  {
    return this.focusedThumbIdx;
  }
  
  @Dimension
  public int getHaloRadius()
  {
    return this.haloRadius;
  }
  
  @NonNull
  public ColorStateList getHaloTintList()
  {
    return this.haloColor;
  }
  
  public int getLabelBehavior()
  {
    return this.labelBehavior;
  }
  
  public float getStepSize()
  {
    return this.stepSize;
  }
  
  public float getThumbElevation()
  {
    return this.thumbDrawable.getElevation();
  }
  
  @Dimension
  public int getThumbRadius()
  {
    return this.thumbRadius;
  }
  
  @NonNull
  public ColorStateList getThumbTintList()
  {
    return this.thumbDrawable.getFillColor();
  }
  
  @NonNull
  public ColorStateList getTickActiveTintList()
  {
    return this.tickColorActive;
  }
  
  @NonNull
  public ColorStateList getTickInactiveTintList()
  {
    return this.tickColorInactive;
  }
  
  @NonNull
  public ColorStateList getTickTintList()
  {
    if (this.tickColorInactive.equals(this.tickColorActive)) {
      return this.tickColorActive;
    }
    throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
  }
  
  @NonNull
  public ColorStateList getTrackActiveTintList()
  {
    return this.trackColorActive;
  }
  
  @Dimension
  public int getTrackHeight()
  {
    return this.trackHeight;
  }
  
  @NonNull
  public ColorStateList getTrackInactiveTintList()
  {
    return this.trackColorInactive;
  }
  
  @Dimension
  public int getTrackSidePadding()
  {
    return this.trackSidePadding;
  }
  
  @NonNull
  public ColorStateList getTrackTintList()
  {
    if (this.trackColorInactive.equals(this.trackColorActive)) {
      return this.trackColorActive;
    }
    throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
  }
  
  @Dimension
  public int getTrackWidth()
  {
    return this.trackWidth;
  }
  
  public float getValueFrom()
  {
    return this.valueFrom;
  }
  
  public float getValueTo()
  {
    return this.valueTo;
  }
  
  @NonNull
  List<Float> getValues()
  {
    return new ArrayList(this.values);
  }
  
  public boolean hasLabelFormatter()
  {
    boolean bool;
    if (this.formatter != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  final boolean isRtl()
  {
    int i = ViewCompat.getLayoutDirection(this);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = this.labels.iterator();
    while (localIterator.hasNext()) {
      attachLabelToContentView((TooltipDrawable)localIterator.next());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.accessibilityEventSender;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
    localObject = this.labels.iterator();
    while (((Iterator)localObject).hasNext()) {
      detachLabelFromContentView((TooltipDrawable)((Iterator)localObject).next());
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    if (this.dirtyConfig)
    {
      validateConfigurationIfDirty();
      if (this.stepSize > 0.0F) {
        calculateTicksCoordinates();
      }
    }
    super.onDraw(paramCanvas);
    int i = calculateTop();
    drawInactiveTrack(paramCanvas, this.trackWidth, i);
    if (((Float)Collections.max(getValues())).floatValue() > this.valueFrom) {
      drawActiveTrack(paramCanvas, this.trackWidth, i);
    }
    if (this.stepSize > 0.0F) {
      drawTicks(paramCanvas);
    }
    if (((this.thumbIsPressed) || (isFocused())) && (isEnabled()))
    {
      maybeDrawHalo(paramCanvas, this.trackWidth, i);
      if (this.activeThumbIdx != -1) {
        ensureLabels();
      }
    }
    drawThumbs(paramCanvas, this.trackWidth, i);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      this.activeThumbIdx = -1;
      Iterator localIterator = this.labels.iterator();
      while (localIterator.hasNext())
      {
        paramRect = (TooltipDrawable)localIterator.next();
        ViewUtils.getContentViewOverlay(this).remove(paramRect);
      }
      this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }
    else
    {
      focusThumbOnFocusGained(paramInt);
      this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isEnabled()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.values.size() == 1) {
      this.activeThumbIdx = 0;
    }
    if (this.activeThumbIdx == -1)
    {
      localObject = onKeyDownNoActiveThumb(paramInt, paramKeyEvent);
      boolean bool;
      if (localObject != null) {
        bool = ((Boolean)localObject).booleanValue();
      } else {
        bool = super.onKeyDown(paramInt, paramKeyEvent);
      }
      return bool;
    }
    this.isLongPress |= paramKeyEvent.isLongPress();
    Object localObject = calculateIncrementForKey(paramInt);
    if (localObject != null)
    {
      if (snapActiveThumbToValue(((Float)this.values.get(this.activeThumbIdx)).floatValue() + ((Float)localObject).floatValue()))
      {
        updateHaloHotspot();
        postInvalidate();
      }
      return true;
    }
    if (paramInt != 23) {
      if (paramInt != 61)
      {
        if (paramInt != 66) {
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return moveFocus(1);
        }
        if (paramKeyEvent.isShiftPressed()) {
          return moveFocus(-1);
        }
        return false;
      }
    }
    this.activeThumbIdx = -1;
    localObject = this.labels.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramKeyEvent = (TooltipDrawable)((Iterator)localObject).next();
      ViewUtils.getContentViewOverlay(this).remove(paramKeyEvent);
    }
    postInvalidate();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    this.isLongPress = false;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.widgetHeight;
    int j = this.labelBehavior;
    paramInt2 = 0;
    if (j == 1) {
      paramInt2 = ((TooltipDrawable)this.labels.get(0)).getIntrinsicHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i + paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.valueFrom = paramParcelable.valueFrom;
    this.valueTo = paramParcelable.valueTo;
    setValuesInternal(paramParcelable.values);
    this.stepSize = paramParcelable.stepSize;
    if (paramParcelable.hasFocus) {
      requestFocus();
    }
    dispatchOnChangedProgramatically();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SliderState localSliderState = new SliderState(super.onSaveInstanceState());
    localSliderState.valueFrom = this.valueFrom;
    localSliderState.valueTo = this.valueTo;
    localSliderState.values = new ArrayList(this.values);
    localSliderState.stepSize = this.stepSize;
    localSliderState.hasFocus = hasFocus();
    return localSliderState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.trackWidth = Math.max(paramInt1 - this.trackSidePadding * 2, 0);
    if (this.stepSize > 0.0F) {
      calculateTicksCoordinates();
    }
    updateHaloHotspot();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = (f1 - this.trackSidePadding) / this.trackWidth;
    this.touchPosition = f2;
    f2 = Math.max(0.0F, f2);
    this.touchPosition = f2;
    this.touchPosition = Math.min(1.0F, f2);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          if (!this.thumbIsPressed)
          {
            if (Math.abs(f1 - this.touchDownX) < this.scaledTouchSlop) {
              return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            onStartTrackingTouch();
          }
          if (pickActiveThumb())
          {
            this.thumbIsPressed = true;
            snapTouchPosition();
            updateHaloHotspot();
            invalidate();
          }
        }
      }
      else
      {
        this.thumbIsPressed = false;
        Object localObject = this.lastEvent;
        if ((localObject != null) && (((MotionEvent)localObject).getActionMasked() == 0) && (Math.abs(this.lastEvent.getX() - paramMotionEvent.getX()) <= this.scaledTouchSlop) && (Math.abs(this.lastEvent.getY() - paramMotionEvent.getY()) <= this.scaledTouchSlop)) {
          pickActiveThumb();
        }
        if (this.activeThumbIdx != -1)
        {
          snapTouchPosition();
          this.activeThumbIdx = -1;
        }
        localObject = this.labels.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TooltipDrawable localTooltipDrawable = (TooltipDrawable)((Iterator)localObject).next();
          ViewUtils.getContentViewOverlay(this).remove(localTooltipDrawable);
        }
        onStopTrackingTouch();
        invalidate();
      }
    }
    else
    {
      this.touchDownX = f1;
      if (!isInScrollingContainer())
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (pickActiveThumb())
        {
          requestFocus();
          this.thumbIsPressed = true;
          snapTouchPosition();
          updateHaloHotspot();
          invalidate();
          onStartTrackingTouch();
        }
      }
    }
    setPressed(this.thumbIsPressed);
    this.lastEvent = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  protected boolean pickActiveThumb()
  {
    int i = this.activeThumbIdx;
    boolean bool = true;
    if (i != -1) {
      return true;
    }
    float f1 = getValueOfTouchPositionAbsolute();
    float f2 = valueToX(f1);
    this.activeThumbIdx = 0;
    float f3 = Math.abs(((Float)this.values.get(0)).floatValue() - f1);
    i = 1;
    while (i < this.values.size())
    {
      float f4 = Math.abs(((Float)this.values.get(i)).floatValue() - f1);
      float f5 = valueToX(((Float)this.values.get(i)).floatValue());
      if (Float.compare(f4, f3) > 1) {
        break;
      }
      int j;
      if (isRtl() ? f5 - f2 > 0.0F : f5 - f2 < 0.0F) {
        j = 1;
      } else {
        j = 0;
      }
      if (Float.compare(f4, f3) < 0)
      {
        this.activeThumbIdx = i;
      }
      else
      {
        f6 = f3;
        if (Float.compare(f4, f3) != 0) {
          break label233;
        }
        if (Math.abs(f5 - f2) < this.scaledTouchSlop)
        {
          this.activeThumbIdx = -1;
          return false;
        }
        f6 = f3;
        if (j == 0) {
          break label233;
        }
        this.activeThumbIdx = i;
      }
      float f6 = f4;
      label233:
      i++;
      f3 = f6;
    }
    if (this.activeThumbIdx == -1) {
      bool = false;
    }
    return bool;
  }
  
  public void removeOnChangeListener(@NonNull L paramL)
  {
    this.changeListeners.remove(paramL);
  }
  
  public void removeOnSliderTouchListener(@NonNull T paramT)
  {
    this.touchListeners.remove(paramT);
  }
  
  protected void setActiveThumbIndex(int paramInt)
  {
    this.activeThumbIdx = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 2;
    }
    setLayerType(i, null);
  }
  
  public void setFocusedThumbIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.values.size()))
    {
      this.focusedThumbIdx = paramInt;
      this.accessibilityHelper.requestKeyboardFocusForVirtualView(paramInt);
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("index out of range");
  }
  
  public void setHaloRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.haloRadius) {
      return;
    }
    this.haloRadius = paramInt;
    Drawable localDrawable = getBackground();
    if ((!shouldDrawCompatHalo()) && ((localDrawable instanceof RippleDrawable)))
    {
      DrawableUtils.setRippleDrawableRadius((RippleDrawable)localDrawable, this.haloRadius);
      return;
    }
    postInvalidate();
  }
  
  public void setHaloRadiusResource(@DimenRes int paramInt)
  {
    setHaloRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setHaloTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.haloColor)) {
      return;
    }
    this.haloColor = paramColorStateList;
    Drawable localDrawable = getBackground();
    if ((!shouldDrawCompatHalo()) && ((localDrawable instanceof RippleDrawable)))
    {
      ((RippleDrawable)localDrawable).setColor(paramColorStateList);
      return;
    }
    this.haloPaint.setColor(getColorForState(paramColorStateList));
    this.haloPaint.setAlpha(63);
    invalidate();
  }
  
  public void setLabelBehavior(int paramInt)
  {
    if (this.labelBehavior != paramInt)
    {
      this.labelBehavior = paramInt;
      requestLayout();
    }
  }
  
  public void setLabelFormatter(@Nullable LabelFormatter paramLabelFormatter)
  {
    this.formatter = paramLabelFormatter;
  }
  
  public void setStepSize(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (this.stepSize != paramFloat)
      {
        this.stepSize = paramFloat;
        this.dirtyConfig = true;
        postInvalidate();
      }
      return;
    }
    throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(paramFloat), Float.toString(this.valueFrom), Float.toString(this.valueTo) }));
  }
  
  public void setThumbElevation(float paramFloat)
  {
    this.thumbDrawable.setElevation(paramFloat);
  }
  
  public void setThumbElevationResource(@DimenRes int paramInt)
  {
    setThumbElevation(getResources().getDimension(paramInt));
  }
  
  public void setThumbRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.thumbRadius) {
      return;
    }
    this.thumbRadius = paramInt;
    this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
    MaterialShapeDrawable localMaterialShapeDrawable = this.thumbDrawable;
    paramInt = this.thumbRadius;
    localMaterialShapeDrawable.setBounds(0, 0, paramInt * 2, paramInt * 2);
    postInvalidate();
  }
  
  public void setThumbRadiusResource(@DimenRes int paramInt)
  {
    setThumbRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setThumbTintList(@NonNull ColorStateList paramColorStateList)
  {
    this.thumbDrawable.setFillColor(paramColorStateList);
  }
  
  public void setTickActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.tickColorActive)) {
      return;
    }
    this.tickColorActive = paramColorStateList;
    this.activeTicksPaint.setColor(getColorForState(paramColorStateList));
    invalidate();
  }
  
  public void setTickInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.tickColorInactive)) {
      return;
    }
    this.tickColorInactive = paramColorStateList;
    this.inactiveTicksPaint.setColor(getColorForState(paramColorStateList));
    invalidate();
  }
  
  public void setTickTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTickInactiveTintList(paramColorStateList);
    setTickActiveTintList(paramColorStateList);
  }
  
  public void setTrackActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.trackColorActive)) {
      return;
    }
    this.trackColorActive = paramColorStateList;
    this.activeTrackPaint.setColor(getColorForState(paramColorStateList));
    invalidate();
  }
  
  public void setTrackHeight(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (this.trackHeight != paramInt)
    {
      this.trackHeight = paramInt;
      invalidateTrack();
      postInvalidate();
    }
  }
  
  public void setTrackInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.trackColorInactive)) {
      return;
    }
    this.trackColorInactive = paramColorStateList;
    this.inactiveTrackPaint.setColor(getColorForState(paramColorStateList));
    invalidate();
  }
  
  public void setTrackTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTrackInactiveTintList(paramColorStateList);
    setTrackActiveTintList(paramColorStateList);
  }
  
  public void setValueFrom(float paramFloat)
  {
    this.valueFrom = paramFloat;
    this.dirtyConfig = true;
    postInvalidate();
  }
  
  public void setValueTo(float paramFloat)
  {
    this.valueTo = paramFloat;
    this.dirtyConfig = true;
    postInvalidate();
  }
  
  void setValues(@NonNull List<Float> paramList)
  {
    setValuesInternal(new ArrayList(paramList));
  }
  
  void setValues(@NonNull Float... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramVarArgs);
    setValuesInternal(localArrayList);
  }
  
  void updateBoundsForVirturalViewId(int paramInt, Rect paramRect)
  {
    int i = this.trackSidePadding + (int)(normalizeValue(((Float)getValues().get(paramInt)).floatValue()) * this.trackWidth);
    paramInt = calculateTop();
    int j = this.thumbRadius;
    paramRect.set(i - j, paramInt - j, i + j, paramInt + j);
  }
  
  private class AccessibilityEventSender
    implements Runnable
  {
    int virtualViewId = -1;
    
    private AccessibilityEventSender() {}
    
    public void run()
    {
      BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
    }
    
    void setVirtualViewId(int paramInt)
    {
      this.virtualViewId = paramInt;
    }
  }
  
  private static class AccessibilityHelper
    extends ExploreByTouchHelper
  {
    private final BaseSlider<?, ?, ?> slider;
    Rect virtualViewBounds = new Rect();
    
    AccessibilityHelper(BaseSlider<?, ?, ?> paramBaseSlider)
    {
      super();
      this.slider = paramBaseSlider;
    }
    
    @NonNull
    private String startOrEndDescription(int paramInt)
    {
      if (paramInt == this.slider.getValues().size() - 1) {
        return this.slider.getContext().getString(R.string.material_slider_range_end);
      }
      if (paramInt == 0) {
        return this.slider.getContext().getString(R.string.material_slider_range_start);
      }
      return "";
    }
    
    protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      for (int i = 0; i < this.slider.getValues().size(); i++)
      {
        this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
        if (this.virtualViewBounds.contains((int)paramFloat1, (int)paramFloat2)) {
          return i;
        }
      }
      return -1;
    }
    
    protected void getVisibleVirtualViews(List<Integer> paramList)
    {
      for (int i = 0; i < this.slider.getValues().size(); i++) {
        paramList.add(Integer.valueOf(i));
      }
    }
    
    protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (!this.slider.isEnabled()) {
        return false;
      }
      if ((paramInt2 != 4096) && (paramInt2 != 8192))
      {
        if (paramInt2 != 16908349) {
          return false;
        }
        if ((paramBundle != null) && (paramBundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")))
        {
          f1 = paramBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
          if (this.slider.snapThumbToValue(paramInt1, f1))
          {
            this.slider.updateHaloHotspot();
            this.slider.postInvalidate();
            invalidateVirtualView(paramInt1);
            return true;
          }
        }
        return false;
      }
      float f2 = this.slider.calculateStepIncrement(20);
      float f1 = f2;
      if (paramInt2 == 8192) {
        f1 = -f2;
      }
      f2 = f1;
      if (this.slider.isRtl()) {
        f2 = -f1;
      }
      f1 = MathUtils.clamp(((Float)this.slider.getValues().get(paramInt1)).floatValue() + f2, this.slider.getValueFrom(), this.slider.getValueTo());
      if (this.slider.snapThumbToValue(paramInt1, f1))
      {
        this.slider.updateHaloHotspot();
        this.slider.postInvalidate();
        invalidateVirtualView(paramInt1);
        return true;
      }
      return false;
    }
    
    protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
      List localList = this.slider.getValues();
      float f1 = ((Float)localList.get(paramInt)).floatValue();
      float f2 = this.slider.getValueFrom();
      float f3 = this.slider.getValueTo();
      if (this.slider.isEnabled())
      {
        if (f1 > f2) {
          paramAccessibilityNodeInfoCompat.addAction(8192);
        }
        if (f1 < f3) {
          paramAccessibilityNodeInfoCompat.addAction(4096);
        }
      }
      paramAccessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, f2, f3, f1));
      paramAccessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.slider.getContentDescription() != null)
      {
        localStringBuilder.append(this.slider.getContentDescription());
        localStringBuilder.append(",");
      }
      if (localList.size() > 1)
      {
        localStringBuilder.append(startOrEndDescription(paramInt));
        localStringBuilder.append(this.slider.formatValue(f1));
      }
      paramAccessibilityNodeInfoCompat.setContentDescription(localStringBuilder.toString());
      this.slider.updateBoundsForVirturalViewId(paramInt, this.virtualViewBounds);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
    }
  }
  
  static class SliderState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator()
    {
      @NonNull
      public BaseSlider.SliderState createFromParcel(@NonNull Parcel paramAnonymousParcel)
      {
        return new BaseSlider.SliderState(paramAnonymousParcel, null);
      }
      
      @NonNull
      public BaseSlider.SliderState[] newArray(int paramAnonymousInt)
      {
        return new BaseSlider.SliderState[paramAnonymousInt];
      }
    };
    boolean hasFocus;
    float stepSize;
    float valueFrom;
    float valueTo;
    ArrayList<Float> values;
    
    private SliderState(@NonNull Parcel paramParcel)
    {
      super();
      this.valueFrom = paramParcel.readFloat();
      this.valueTo = paramParcel.readFloat();
      ArrayList localArrayList = new ArrayList();
      this.values = localArrayList;
      paramParcel.readList(localArrayList, Float.class.getClassLoader());
      this.stepSize = paramParcel.readFloat();
      this.hasFocus = paramParcel.createBooleanArray()[0];
    }
    
    SliderState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.valueFrom);
      paramParcel.writeFloat(this.valueTo);
      paramParcel.writeList(this.values);
      paramParcel.writeFloat(this.stepSize);
      paramParcel.writeBooleanArray(new boolean[] { this.hasFocus });
    }
  }
  
  private static abstract interface TooltipDrawableFactory
  {
    public abstract TooltipDrawable createTooltipDrawable();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\BaseSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */