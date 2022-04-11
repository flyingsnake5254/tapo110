package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int THUMB_ANIMATION_DURATION = 250;
  private static final Property<SwitchCompat, Float> THUMB_POS = new Property(Float.class, "thumbPos")
  {
    public Float get(SwitchCompat paramAnonymousSwitchCompat)
    {
      return Float.valueOf(paramAnonymousSwitchCompat.mThumbPosition);
    }
    
    public void set(SwitchCompat paramAnonymousSwitchCompat, Float paramAnonymousFloat)
    {
      paramAnonymousSwitchCompat.setThumbPosition(paramAnonymousFloat.floatValue());
    }
  };
  private static final int TOUCH_MODE_DOWN = 1;
  private static final int TOUCH_MODE_DRAGGING = 2;
  private static final int TOUCH_MODE_IDLE = 0;
  private boolean mHasThumbTint = false;
  private boolean mHasThumbTintMode = false;
  private boolean mHasTrackTint = false;
  private boolean mHasTrackTintMode = false;
  private int mMinFlingVelocity;
  private Layout mOffLayout;
  private Layout mOnLayout;
  ObjectAnimator mPositionAnimator;
  private boolean mShowText;
  private boolean mSplitTrack;
  private int mSwitchBottom;
  private int mSwitchHeight;
  private int mSwitchLeft;
  private int mSwitchMinWidth;
  private int mSwitchPadding;
  private int mSwitchRight;
  private int mSwitchTop;
  private TransformationMethod mSwitchTransformationMethod;
  private int mSwitchWidth;
  private final Rect mTempRect = new Rect();
  private ColorStateList mTextColors;
  private final AppCompatTextHelper mTextHelper;
  private CharSequence mTextOff;
  private CharSequence mTextOn;
  private final TextPaint mTextPaint;
  private Drawable mThumbDrawable;
  float mThumbPosition;
  private int mThumbTextPadding;
  private ColorStateList mThumbTintList = null;
  private PorterDuff.Mode mThumbTintMode = null;
  private int mThumbWidth;
  private int mTouchMode;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private Drawable mTrackDrawable;
  private ColorStateList mTrackTintList = null;
  private PorterDuff.Mode mTrackTintMode = null;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    Object localObject1 = new TextPaint(1);
    this.mTextPaint = ((TextPaint)localObject1);
    ((TextPaint)localObject1).density = getResources().getDisplayMetrics().density;
    Object localObject2 = R.styleable.SwitchCompat;
    localObject1 = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, (int[])localObject2, paramInt, 0);
    ViewCompat.saveAttributeDataForStyleable(this, paramContext, (int[])localObject2, paramAttributeSet, ((TintTypedArray)localObject1).getWrappedTypeArray(), paramInt, 0);
    localObject2 = ((TintTypedArray)localObject1).getDrawable(R.styleable.SwitchCompat_android_thumb);
    this.mThumbDrawable = ((Drawable)localObject2);
    if (localObject2 != null) {
      ((Drawable)localObject2).setCallback(this);
    }
    localObject2 = ((TintTypedArray)localObject1).getDrawable(R.styleable.SwitchCompat_track);
    this.mTrackDrawable = ((Drawable)localObject2);
    if (localObject2 != null) {
      ((Drawable)localObject2).setCallback(this);
    }
    this.mTextOn = ((TintTypedArray)localObject1).getText(R.styleable.SwitchCompat_android_textOn);
    this.mTextOff = ((TintTypedArray)localObject1).getText(R.styleable.SwitchCompat_android_textOff);
    this.mShowText = ((TintTypedArray)localObject1).getBoolean(R.styleable.SwitchCompat_showText, true);
    this.mThumbTextPadding = ((TintTypedArray)localObject1).getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.mSwitchMinWidth = ((TintTypedArray)localObject1).getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.mSwitchPadding = ((TintTypedArray)localObject1).getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    this.mSplitTrack = ((TintTypedArray)localObject1).getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    localObject2 = ((TintTypedArray)localObject1).getColorStateList(R.styleable.SwitchCompat_thumbTint);
    if (localObject2 != null)
    {
      this.mThumbTintList = ((ColorStateList)localObject2);
      this.mHasThumbTint = true;
    }
    localObject2 = DrawableUtils.parseTintMode(((TintTypedArray)localObject1).getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (this.mThumbTintMode != localObject2)
    {
      this.mThumbTintMode = ((PorterDuff.Mode)localObject2);
      this.mHasThumbTintMode = true;
    }
    if ((this.mHasThumbTint) || (this.mHasThumbTintMode)) {
      applyThumbTint();
    }
    localObject2 = ((TintTypedArray)localObject1).getColorStateList(R.styleable.SwitchCompat_trackTint);
    if (localObject2 != null)
    {
      this.mTrackTintList = ((ColorStateList)localObject2);
      this.mHasTrackTint = true;
    }
    localObject2 = DrawableUtils.parseTintMode(((TintTypedArray)localObject1).getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (this.mTrackTintMode != localObject2)
    {
      this.mTrackTintMode = ((PorterDuff.Mode)localObject2);
      this.mHasTrackTintMode = true;
    }
    if ((this.mHasTrackTint) || (this.mHasTrackTintMode)) {
      applyTrackTint();
    }
    int i = ((TintTypedArray)localObject1).getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (i != 0) {
      setSwitchTextAppearance(paramContext, i);
    }
    localObject2 = new AppCompatTextHelper(this);
    this.mTextHelper = ((AppCompatTextHelper)localObject2);
    ((AppCompatTextHelper)localObject2).loadFromAttributes(paramAttributeSet, paramInt);
    ((TintTypedArray)localObject1).recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private void animateThumbToCheckedState(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, THUMB_POS, new float[] { f });
    this.mPositionAnimator = localObjectAnimator;
    localObjectAnimator.setDuration(250L);
    if (Build.VERSION.SDK_INT >= 18) {
      this.mPositionAnimator.setAutoCancel(true);
    }
    this.mPositionAnimator.start();
  }
  
  private void applyThumbTint()
  {
    Drawable localDrawable = this.mThumbDrawable;
    if ((localDrawable != null) && ((this.mHasThumbTint) || (this.mHasThumbTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      this.mThumbDrawable = localDrawable;
      if (this.mHasThumbTint) {
        DrawableCompat.setTintList(localDrawable, this.mThumbTintList);
      }
      if (this.mHasThumbTintMode) {
        DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
      }
      if (this.mThumbDrawable.isStateful()) {
        this.mThumbDrawable.setState(getDrawableState());
      }
    }
  }
  
  private void applyTrackTint()
  {
    Drawable localDrawable = this.mTrackDrawable;
    if ((localDrawable != null) && ((this.mHasTrackTint) || (this.mHasTrackTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      this.mTrackDrawable = localDrawable;
      if (this.mHasTrackTint) {
        DrawableCompat.setTintList(localDrawable, this.mTrackTintList);
      }
      if (this.mHasTrackTintMode) {
        DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
      }
      if (this.mTrackDrawable.isStateful()) {
        this.mTrackDrawable.setState(getDrawableState());
      }
    }
  }
  
  private void cancelPositionAnimator()
  {
    ObjectAnimator localObjectAnimator = this.mPositionAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  private void cancelSuperTouch(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2)
    {
      paramFloat2 = paramFloat1;
      if (paramFloat1 > paramFloat3) {
        paramFloat2 = paramFloat3;
      }
    }
    return paramFloat2;
  }
  
  private boolean getTargetCheckedState()
  {
    boolean bool;
    if (this.mThumbPosition > 0.5F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private int getThumbOffset()
  {
    float f;
    if (ViewUtils.isLayoutRtl(this)) {
      f = 1.0F - this.mThumbPosition;
    } else {
      f = this.mThumbPosition;
    }
    return (int)(f * getThumbScrollRange() + 0.5F);
  }
  
  private int getThumbScrollRange()
  {
    Object localObject = this.mTrackDrawable;
    if (localObject != null)
    {
      Rect localRect = this.mTempRect;
      ((Drawable)localObject).getPadding(localRect);
      localObject = this.mThumbDrawable;
      if (localObject != null) {
        localObject = DrawableUtils.getOpticalBounds((Drawable)localObject);
      } else {
        localObject = DrawableUtils.INSETS_NONE;
      }
      return this.mSwitchWidth - this.mThumbWidth - localRect.left - localRect.right - ((Rect)localObject).left - ((Rect)localObject).right;
    }
    return 0;
  }
  
  private boolean hitThumb(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.mThumbDrawable;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    int i = getThumbOffset();
    this.mThumbDrawable.getPadding(this.mTempRect);
    int j = this.mSwitchTop;
    int k = this.mTouchSlop;
    int m = this.mSwitchLeft + i - k;
    int n = this.mThumbWidth;
    localObject = this.mTempRect;
    int i1 = ((Rect)localObject).left;
    i = ((Rect)localObject).right;
    int i2 = this.mSwitchBottom;
    boolean bool2 = bool1;
    if (paramFloat1 > m)
    {
      bool2 = bool1;
      if (paramFloat1 < n + m + i1 + i + k)
      {
        bool2 = bool1;
        if (paramFloat2 > j - k)
        {
          bool2 = bool1;
          if (paramFloat2 < i2 + k) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private Layout makeLayout(CharSequence paramCharSequence)
  {
    TransformationMethod localTransformationMethod = this.mSwitchTransformationMethod;
    CharSequence localCharSequence = paramCharSequence;
    if (localTransformationMethod != null) {
      localCharSequence = localTransformationMethod.getTransformation(paramCharSequence, this);
    }
    paramCharSequence = this.mTextPaint;
    int i;
    if (localCharSequence != null) {
      i = (int)Math.ceil(Layout.getDesiredWidth(localCharSequence, paramCharSequence));
    } else {
      i = 0;
    }
    return new StaticLayout(localCharSequence, paramCharSequence, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void setSwitchTypefaceByIndex(int paramInt1, int paramInt2)
  {
    Typeface localTypeface;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          localTypeface = null;
        } else {
          localTypeface = Typeface.MONOSPACE;
        }
      }
      else {
        localTypeface = Typeface.SERIF;
      }
    }
    else {
      localTypeface = Typeface.SANS_SERIF;
    }
    setSwitchTypeface(localTypeface, paramInt2);
  }
  
  private void stopDrag(MotionEvent paramMotionEvent)
  {
    this.mTouchMode = 0;
    int i = paramMotionEvent.getAction();
    boolean bool1 = true;
    if ((i == 1) && (isEnabled())) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2 = isChecked();
    if (i != 0)
    {
      this.mVelocityTracker.computeCurrentVelocity(1000);
      float f = this.mVelocityTracker.getXVelocity();
      if (Math.abs(f) > this.mMinFlingVelocity)
      {
        if (ViewUtils.isLayoutRtl(this) ? f >= 0.0F : f <= 0.0F) {
          bool1 = false;
        }
      }
      else {
        bool1 = getTargetCheckedState();
      }
    }
    else
    {
      bool1 = bool2;
    }
    if (bool1 != bool2) {
      playSoundEffect(0);
    }
    setChecked(bool1);
    cancelSuperTouch(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int i = this.mSwitchLeft;
    int j = this.mSwitchTop;
    int k = this.mSwitchRight;
    int m = this.mSwitchBottom;
    int n = getThumbOffset() + i;
    Object localObject = this.mThumbDrawable;
    if (localObject != null) {
      localObject = DrawableUtils.getOpticalBounds((Drawable)localObject);
    } else {
      localObject = DrawableUtils.INSETS_NONE;
    }
    Drawable localDrawable = this.mTrackDrawable;
    int i1 = n;
    if (localDrawable != null)
    {
      localDrawable.getPadding(localRect);
      int i2 = localRect.left;
      int i3 = n + i2;
      int i4;
      if (localObject != null)
      {
        n = ((Rect)localObject).left;
        i1 = i;
        if (n > i2) {
          i1 = i + (n - i2);
        }
        i2 = ((Rect)localObject).top;
        n = localRect.top;
        if (i2 > n) {
          n = i2 - n + j;
        } else {
          n = j;
        }
        i4 = ((Rect)localObject).right;
        i = localRect.right;
        i2 = k;
        if (i4 > i) {
          i2 = k - (i4 - i);
        }
        int i5 = ((Rect)localObject).bottom;
        int i6 = localRect.bottom;
        i = i1;
        k = i2;
        i4 = n;
        if (i5 > i6)
        {
          k = m - (i5 - i6);
          i = i1;
          i1 = k;
          break label263;
        }
      }
      else
      {
        i4 = j;
      }
      i1 = m;
      n = i4;
      i2 = k;
      label263:
      this.mTrackDrawable.setBounds(i, n, i2, i1);
      i1 = i3;
    }
    localObject = this.mThumbDrawable;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(localRect);
      n = i1 - localRect.left;
      i1 = i1 + this.mThumbWidth + localRect.right;
      this.mThumbDrawable.setBounds(n, j, i1, m);
      localObject = getBackground();
      if (localObject != null) {
        DrawableCompat.setHotspotBounds((Drawable)localObject, n, j, i1, m);
      }
    }
    super.draw(paramCanvas);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    Drawable localDrawable = this.mThumbDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
    localDrawable = this.mTrackDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.mThumbDrawable;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = false | localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = this.mTrackDrawable;
    bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = bool2 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    if (!ViewUtils.isLayoutRtl(this)) {
      return super.getCompoundPaddingLeft();
    }
    int i = super.getCompoundPaddingLeft() + this.mSwitchWidth;
    int j = i;
    if (!TextUtils.isEmpty(getText())) {
      j = i + this.mSwitchPadding;
    }
    return j;
  }
  
  public int getCompoundPaddingRight()
  {
    if (ViewUtils.isLayoutRtl(this)) {
      return super.getCompoundPaddingRight();
    }
    int i = super.getCompoundPaddingRight() + this.mSwitchWidth;
    int j = i;
    if (!TextUtils.isEmpty(getText())) {
      j = i + this.mSwitchPadding;
    }
    return j;
  }
  
  public boolean getShowText()
  {
    return this.mShowText;
  }
  
  public boolean getSplitTrack()
  {
    return this.mSplitTrack;
  }
  
  public int getSwitchMinWidth()
  {
    return this.mSwitchMinWidth;
  }
  
  public int getSwitchPadding()
  {
    return this.mSwitchPadding;
  }
  
  public CharSequence getTextOff()
  {
    return this.mTextOff;
  }
  
  public CharSequence getTextOn()
  {
    return this.mTextOn;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.mThumbDrawable;
  }
  
  public int getThumbTextPadding()
  {
    return this.mThumbTextPadding;
  }
  
  @Nullable
  public ColorStateList getThumbTintList()
  {
    return this.mThumbTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.mThumbTintMode;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.mTrackDrawable;
  }
  
  @Nullable
  public ColorStateList getTrackTintList()
  {
    return this.mTrackTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.mTrackTintMode;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Object localObject = this.mThumbDrawable;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.mTrackDrawable;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.mPositionAnimator;
    if ((localObject != null) && (((ObjectAnimator)localObject).isStarted()))
    {
      this.mPositionAnimator.end();
      this.mPositionAnimator = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      CompoundButton.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject2 = this.mTrackDrawable;
    if (localObject2 != null) {
      ((Drawable)localObject2).getPadding((Rect)localObject1);
    } else {
      ((Rect)localObject1).setEmpty();
    }
    int i = this.mSwitchTop;
    int j = this.mSwitchBottom;
    int k = ((Rect)localObject1).top;
    int m = ((Rect)localObject1).bottom;
    Object localObject3 = this.mThumbDrawable;
    Object localObject4;
    int n;
    if (localObject2 != null) {
      if ((this.mSplitTrack) && (localObject3 != null))
      {
        localObject4 = DrawableUtils.getOpticalBounds((Drawable)localObject3);
        ((Drawable)localObject3).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += ((Rect)localObject4).left;
        ((Rect)localObject1).right -= ((Rect)localObject4).right;
        n = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.restoreToCount(n);
      }
      else
      {
        ((Drawable)localObject2).draw(paramCanvas);
      }
    }
    int i1 = paramCanvas.save();
    if (localObject3 != null) {
      ((Drawable)localObject3).draw(paramCanvas);
    }
    if (getTargetCheckedState()) {
      localObject1 = this.mOnLayout;
    } else {
      localObject1 = this.mOffLayout;
    }
    if (localObject1 != null)
    {
      localObject2 = getDrawableState();
      localObject4 = this.mTextColors;
      if (localObject4 != null) {
        this.mTextPaint.setColor(((ColorStateList)localObject4).getColorForState((int[])localObject2, 0));
      }
      this.mTextPaint.drawableState = ((int[])localObject2);
      if (localObject3 != null)
      {
        localObject3 = ((Drawable)localObject3).getBounds();
        n = ((Rect)localObject3).left + ((Rect)localObject3).right;
      }
      else
      {
        n = getWidth();
      }
      int i2 = n / 2;
      n = ((Layout)localObject1).getWidth() / 2;
      i = (i + k + (j - m)) / 2;
      k = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i2 - n, i - k);
      ((Layout)localObject1).draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i1);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    CharSequence localCharSequence1;
    if (isChecked()) {
      localCharSequence1 = this.mTextOn;
    } else {
      localCharSequence1 = this.mTextOff;
    }
    if (!TextUtils.isEmpty(localCharSequence1))
    {
      CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
      if (TextUtils.isEmpty(localCharSequence2))
      {
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCharSequence2);
        localStringBuilder.append(' ');
        localStringBuilder.append(localCharSequence1);
        paramAccessibilityNodeInfo.setText(localStringBuilder);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.mThumbDrawable;
    paramInt2 = 0;
    if (localObject1 != null)
    {
      localObject1 = this.mTempRect;
      Object localObject2 = this.mTrackDrawable;
      if (localObject2 != null) {
        ((Drawable)localObject2).getPadding((Rect)localObject1);
      } else {
        ((Rect)localObject1).setEmpty();
      }
      localObject2 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
      paramInt1 = Math.max(0, ((Rect)localObject2).left - ((Rect)localObject1).left);
      paramInt2 = Math.max(0, ((Rect)localObject2).right - ((Rect)localObject1).right);
    }
    else
    {
      paramInt1 = 0;
    }
    if (ViewUtils.isLayoutRtl(this))
    {
      paramInt3 = getPaddingLeft() + paramInt1;
      paramInt1 = this.mSwitchWidth + paramInt3 - paramInt1 - paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = paramInt1;
    }
    else
    {
      paramInt3 = getWidth() - getPaddingRight() - paramInt2;
      paramInt2 = paramInt3 - this.mSwitchWidth + paramInt1 + paramInt2;
    }
    paramInt1 = getGravity() & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80)
      {
        paramInt1 = getPaddingTop();
        paramInt4 = this.mSwitchHeight;
      }
      else
      {
        paramInt4 = getHeight() - getPaddingBottom();
        paramInt1 = paramInt4 - this.mSwitchHeight;
        break label256;
      }
    }
    else
    {
      paramInt1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2;
      paramInt4 = this.mSwitchHeight;
      paramInt1 -= paramInt4 / 2;
    }
    paramInt4 += paramInt1;
    label256:
    this.mSwitchLeft = paramInt2;
    this.mSwitchTop = paramInt1;
    this.mSwitchBottom = paramInt4;
    this.mSwitchRight = paramInt3;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mShowText)
    {
      if (this.mOnLayout == null) {
        this.mOnLayout = makeLayout(this.mTextOn);
      }
      if (this.mOffLayout == null) {
        this.mOffLayout = makeLayout(this.mTextOff);
      }
    }
    Object localObject = this.mTempRect;
    Drawable localDrawable = this.mThumbDrawable;
    int i = 0;
    int j;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      j = this.mThumbDrawable.getIntrinsicWidth() - ((Rect)localObject).left - ((Rect)localObject).right;
      k = this.mThumbDrawable.getIntrinsicHeight();
    }
    else
    {
      j = 0;
      k = 0;
    }
    if (this.mShowText) {
      m = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + this.mThumbTextPadding * 2;
    } else {
      m = 0;
    }
    this.mThumbWidth = Math.max(m, j);
    localDrawable = this.mTrackDrawable;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      j = this.mTrackDrawable.getIntrinsicHeight();
    }
    else
    {
      ((Rect)localObject).setEmpty();
      j = i;
    }
    int n = ((Rect)localObject).left;
    int i1 = ((Rect)localObject).right;
    localObject = this.mThumbDrawable;
    i = i1;
    int m = n;
    if (localObject != null)
    {
      localObject = DrawableUtils.getOpticalBounds((Drawable)localObject);
      m = Math.max(n, ((Rect)localObject).left);
      i = Math.max(i1, ((Rect)localObject).right);
    }
    m = Math.max(this.mSwitchMinWidth, this.mThumbWidth * 2 + m + i);
    int k = Math.max(j, k);
    this.mSwitchWidth = m;
    this.mSwitchHeight = k;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < k) {
      setMeasuredDimension(getMeasuredWidthAndState(), k);
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence;
    if (isChecked()) {
      localCharSequence = this.mTextOn;
    } else {
      localCharSequence = this.mTextOff;
    }
    if (localCharSequence != null) {
      paramAccessibilityEvent.getText().add(localCharSequence);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    float f2;
    float f3;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label318;
          }
        }
        else
        {
          i = this.mTouchMode;
          if (i != 1)
          {
            if (i != 2) {
              break label318;
            }
            float f1 = paramMotionEvent.getX();
            i = getThumbScrollRange();
            f2 = f1 - this.mTouchX;
            if (i != 0) {
              f2 /= i;
            } else if (f2 > 0.0F) {
              f2 = 1.0F;
            } else {
              f2 = -1.0F;
            }
            f3 = f2;
            if (ViewUtils.isLayoutRtl(this)) {
              f3 = -f2;
            }
            f2 = constrain(this.mThumbPosition + f3, 0.0F, 1.0F);
            if (f2 != this.mThumbPosition)
            {
              this.mTouchX = f1;
              setThumbPosition(f2);
            }
            return true;
          }
          f2 = paramMotionEvent.getX();
          f3 = paramMotionEvent.getY();
          if ((Math.abs(f2 - this.mTouchX) <= this.mTouchSlop) && (Math.abs(f3 - this.mTouchY) <= this.mTouchSlop)) {
            break label318;
          }
          this.mTouchMode = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.mTouchX = f2;
          this.mTouchY = f3;
          return true;
        }
      }
      if (this.mTouchMode == 2)
      {
        stopDrag(paramMotionEvent);
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      this.mTouchMode = 0;
      this.mVelocityTracker.clear();
    }
    else
    {
      f2 = paramMotionEvent.getX();
      f3 = paramMotionEvent.getY();
      if ((isEnabled()) && (hitThumb(f2, f3)))
      {
        this.mTouchMode = 1;
        this.mTouchX = f2;
        this.mTouchY = f3;
      }
    }
    label318:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)))
    {
      animateThumbToCheckedState(paramBoolean);
    }
    else
    {
      cancelPositionAnimator();
      float f;
      if (paramBoolean) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      setThumbPosition(f);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, paramCallback));
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.mShowText != paramBoolean)
    {
      this.mShowText = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.mSplitTrack = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    paramContext = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (paramContext != null) {
      this.mTextColors = paramContext;
    } else {
      this.mTextColors = getTextColors();
    }
    paramInt = localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
    if (paramInt != 0)
    {
      float f = paramInt;
      if (f != this.mTextPaint.getTextSize())
      {
        this.mTextPaint.setTextSize(f);
        requestLayout();
      }
    }
    setSwitchTypefaceByIndex(localTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, -1), localTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, -1));
    if (localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
      this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
    } else {
      this.mSwitchTransformationMethod = null;
    }
    localTintTypedArray.recycle();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.mTextPaint.getTypeface() != null) && (!this.mTextPaint.getTypeface().equals(paramTypeface))) || ((this.mTextPaint.getTypeface() == null) && (paramTypeface != null)))
    {
      this.mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    float f = 0.0F;
    boolean bool = false;
    if (paramInt > 0)
    {
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      }
      setSwitchTypeface(paramTypeface);
      int i;
      if (paramTypeface != null) {
        i = paramTypeface.getStyle();
      } else {
        i = 0;
      }
      paramInt = (i ^ 0xFFFFFFFF) & paramInt;
      paramTypeface = this.mTextPaint;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramTypeface.setFakeBoldText(bool);
      paramTypeface = this.mTextPaint;
      if ((paramInt & 0x2) != 0) {
        f = -0.25F;
      }
      paramTypeface.setTextSkewX(f);
    }
    else
    {
      this.mTextPaint.setFakeBoldText(false);
      this.mTextPaint.setTextSkewX(0.0F);
      setSwitchTypeface(paramTypeface);
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mThumbDrawable;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.mThumbDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.mThumbPosition = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.mThumbTintList = paramColorStateList;
    this.mHasThumbTint = true;
    applyThumbTint();
  }
  
  public void setThumbTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mThumbTintMode = paramMode;
    this.mHasThumbTintMode = true;
    applyThumbTint();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mTrackDrawable;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.mTrackDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setTrackTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.mTrackTintList = paramColorStateList;
    this.mHasTrackTint = true;
    applyTrackTint();
  }
  
  public void setTrackTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mTrackTintMode = paramMode;
    this.mHasTrackTintMode = true;
    applyTrackTint();
  }
  
  public void toggle()
  {
    setChecked(isChecked() ^ true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != this.mThumbDrawable) && (paramDrawable != this.mTrackDrawable)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\SwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */