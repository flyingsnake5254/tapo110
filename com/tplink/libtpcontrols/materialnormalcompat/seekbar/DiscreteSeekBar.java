package com.tplink.libtpcontrols.materialnormalcompat.seekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b.b;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.d;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.f;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.g;
import com.tplink.libtpcontrols.o0;
import com.tplink.libtpcontrols.w0;
import com.tplink.libtpcontrols.x0;
import java.util.Formatter;
import java.util.Locale;

public class DiscreteSeekBar
  extends View
{
  private static final boolean c;
  private int H3 = 1;
  private boolean I3 = false;
  private boolean J3 = true;
  Formatter K3;
  private String L3;
  private c M3;
  private StringBuilder N3;
  private d O3;
  private com.tplink.libtpcontrols.z0.e P3;
  private boolean Q3;
  private int R3;
  private Rect S3 = new Rect();
  private Rect T3 = new Rect();
  private com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.a U3;
  private com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a V3;
  private float W3;
  private int X3;
  private float Y3;
  private float Z3;
  private int a4;
  private boolean b4;
  private Runnable c4 = new a(this);
  private d d;
  private b.b d4 = new a();
  private Drawable f;
  private int p0;
  private int p1;
  private int p2;
  private int p3;
  private Drawable q;
  private Drawable x;
  private int y;
  private int z;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
  }
  
  public DiscreteSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DiscreteSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, w0.DefaultSeekBar);
  }
  
  public DiscreteSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setWillNotDraw(false);
    this.Z3 = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    int i = (int)(4.0F * f1);
    this.y = i;
    this.z = i;
    int j = (int)(22.0F * f1);
    this.p0 = (((int)(f1 * 32.0F) - j) / 2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, x0.DiscreteSeekBar, o0.discreteSeekBarStyle, paramInt);
    this.I3 = localTypedArray.getBoolean(x0.DiscreteSeekBar_dsb_mirrorForRtl, this.I3);
    this.J3 = localTypedArray.getBoolean(x0.DiscreteSeekBar_dsb_allowTrackClickToDrag, this.J3);
    int k = x0.DiscreteSeekBar_dsb_max;
    int m = x0.DiscreteSeekBar_dsb_min;
    int n = x0.DiscreteSeekBar_dsb_value;
    Object localObject1 = new TypedValue();
    boolean bool = localTypedArray.getValue(k, (TypedValue)localObject1);
    i = 100;
    if (bool) {
      if (((TypedValue)localObject1).type == 5) {
        i = localTypedArray.getDimensionPixelSize(k, 100);
      } else {
        i = localTypedArray.getInteger(k, 100);
      }
    }
    if (localTypedArray.getValue(m, (TypedValue)localObject1))
    {
      if (((TypedValue)localObject1).type == 5) {
        m = localTypedArray.getDimensionPixelSize(m, 0);
      } else {
        m = localTypedArray.getInteger(m, 0);
      }
    }
    else {
      m = 0;
    }
    if (localTypedArray.getValue(n, (TypedValue)localObject1))
    {
      if (((TypedValue)localObject1).type == 5) {
        n = localTypedArray.getDimensionPixelSize(n, 0);
      } else {
        n = localTypedArray.getInteger(n, 0);
      }
    }
    else {
      n = 0;
    }
    this.p2 = m;
    this.p1 = Math.max(m + 1, i);
    this.p3 = Math.max(m, Math.min(i, n));
    x();
    this.L3 = localTypedArray.getString(x0.DiscreteSeekBar_dsb_indicatorFormatter);
    localObject1 = localTypedArray.getColorStateList(x0.DiscreteSeekBar_dsb_trackColor);
    ColorStateList localColorStateList = localTypedArray.getColorStateList(x0.DiscreteSeekBar_dsb_progressColor);
    Object localObject2 = localTypedArray.getColorStateList(x0.DiscreteSeekBar_dsb_rippleColor);
    bool = isInEditMode();
    Object localObject3 = localObject2;
    if (bool)
    {
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new ColorStateList(new int[][] { new int[0] }, new int[] { -12303292 });
      }
    }
    localObject2 = localObject1;
    if (bool)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ColorStateList(new int[][] { new int[0] }, new int[] { -7829368 });
      }
    }
    localObject1 = localColorStateList;
    if (bool)
    {
      localObject1 = localColorStateList;
      if (localColorStateList == null) {
        localObject1 = new ColorStateList(new int[][] { new int[0] }, new int[] { -16738680 });
      }
    }
    localObject3 = com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.a((ColorStateList)localObject3);
    this.x = ((Drawable)localObject3);
    if (c) {
      com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.d(this, (Drawable)localObject3);
    } else {
      ((Drawable)localObject3).setCallback(this);
    }
    i = localTypedArray.getInteger(x0.DiscreteSeekBar_dsb_progressStyle, 0);
    this.a4 = i;
    if (i == 0)
    {
      localObject3 = new f((ColorStateList)localObject2);
      this.f = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
      localObject3 = new f((ColorStateList)localObject1);
      this.q = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
    }
    else if (i == 1)
    {
      localObject3 = new com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.e((ColorStateList)localObject2);
      this.f = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
      localObject3 = new com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.e((ColorStateList)localObject1);
      this.q = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
    }
    else
    {
      localObject3 = new g((ColorStateList)localObject2);
      this.f = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
      localObject3 = new g((ColorStateList)localObject1);
      this.q = ((Drawable)localObject3);
      ((Drawable)localObject3).setCallback(this);
    }
    localObject1 = new d((ColorStateList)localObject1, j);
    this.d = ((d)localObject1);
    ((Drawable)localObject1).setCallback(this);
    localObject1 = this.d;
    ((Drawable)localObject1).setBounds(0, 0, ((d)localObject1).getIntrinsicWidth(), this.d.getIntrinsicHeight());
    if (!bool)
    {
      paramContext = new com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.a(paramContext, paramAttributeSet, paramInt, d(this.p1));
      this.U3 = paramContext;
      paramContext.k(this.d4);
    }
    this.b4 = localTypedArray.getBoolean(x0.DiscreteSeekBar_dsb_ignoreScrollContainer, false);
    localTypedArray.recycle();
    setNumericTransformer(new b(null));
  }
  
  private void A(int paramInt)
  {
    int i = this.d.getIntrinsicWidth();
    int j = i / 2;
    int k;
    if (i())
    {
      k = getWidth() - getPaddingRight() - this.p0;
      paramInt = k - paramInt - i;
    }
    else
    {
      k = getPaddingLeft() + this.p0;
      paramInt += k;
    }
    this.d.copyBounds(this.S3);
    Object localObject = this.d;
    Rect localRect = this.S3;
    ((Drawable)localObject).setBounds(paramInt, localRect.top, i + paramInt, localRect.bottom);
    if (i())
    {
      this.q.getBounds().right = (k - j);
      this.q.getBounds().left = (paramInt + j);
    }
    else
    {
      this.q.getBounds().left = (k + j);
      this.q.getBounds().right = (paramInt + j);
    }
    localObject = this.T3;
    this.d.copyBounds((Rect)localObject);
    if (!isInEditMode()) {
      this.U3.i(((Rect)localObject).centerX());
    }
    localRect = this.S3;
    paramInt = this.p0;
    localRect.inset(-paramInt, -paramInt);
    paramInt = this.p0;
    ((Rect)localObject).inset(-paramInt, -paramInt);
    this.S3.union((Rect)localObject);
    com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.e(this.x, ((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
    invalidate(this.S3);
  }
  
  private void B()
  {
    int i = this.d.getIntrinsicWidth();
    int j = this.p0;
    i /= 2;
    int k = this.p3;
    int m = this.p2;
    float f1 = (k - m) / (this.p1 - m);
    m = getPaddingLeft();
    A((int)(f1 * (getWidth() - (getPaddingRight() + i + j) - (m + i + j)) + 0.5F));
  }
  
  private void c()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private String d(int paramInt)
  {
    String str = this.L3;
    if (str == null) {
      str = "%d";
    }
    Object localObject = this.K3;
    if ((localObject != null) && (((Formatter)localObject).locale().equals(Locale.getDefault())))
    {
      this.N3.setLength(0);
    }
    else
    {
      int i = str.length() + String.valueOf(this.p1).length();
      localObject = this.N3;
      if (localObject == null) {
        this.N3 = new StringBuilder(i);
      } else {
        ((StringBuilder)localObject).ensureCapacity(i);
      }
      this.K3 = new Formatter(this.N3, Locale.getDefault());
    }
    return this.K3.format(str, new Object[] { Integer.valueOf(paramInt) }).toString();
  }
  
  private void e()
  {
    removeCallbacks(this.c4);
    if (!isInEditMode())
    {
      this.U3.d();
      k(false);
    }
  }
  
  private boolean g()
  {
    return this.Q3;
  }
  
  private int getAnimatedProgress()
  {
    int i;
    if (f()) {
      i = getAnimationTarget();
    } else {
      i = this.p3;
    }
    return i;
  }
  
  private int getAnimationTarget()
  {
    return this.X3;
  }
  
  private boolean h()
  {
    return com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.c.c(getParent());
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean) {
      n();
    } else {
      m();
    }
  }
  
  private void l(int paramInt, boolean paramBoolean)
  {
    d locald = this.O3;
    if (locald != null) {
      locald.b(this, paramInt, paramBoolean);
    }
    o(paramInt);
  }
  
  private void p(float paramFloat1, float paramFloat2)
  {
    DrawableCompat.setHotspot(this.x, paramFloat1, paramFloat2);
  }
  
  private void q(int paramInt, boolean paramBoolean)
  {
    paramInt = Math.max(this.p2, Math.min(this.p1, paramInt));
    if (f()) {
      this.V3.a();
    }
    if (this.p3 != paramInt)
    {
      this.p3 = paramInt;
      l(paramInt, paramBoolean);
      z(paramInt);
      B();
    }
  }
  
  private void s()
  {
    if (!isInEditMode())
    {
      this.d.h();
      this.U3.m(this, this.d.getBounds());
      k(true);
    }
  }
  
  private boolean t(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    Rect localRect = this.T3;
    this.d.copyBounds(localRect);
    int i = this.p0;
    localRect.inset(-i, -i);
    boolean bool = localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    this.Q3 = bool;
    if ((!bool) && (this.J3) && (!paramBoolean))
    {
      this.Q3 = true;
      this.R3 = (localRect.width() / 2 - this.p0);
      v(paramMotionEvent);
      this.d.copyBounds(localRect);
      i = this.p0;
      localRect.inset(-i, -i);
    }
    if (this.Q3)
    {
      setPressed(true);
      c();
      p(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.R3 = ((int)(paramMotionEvent.getX() - localRect.left - this.p0));
      paramMotionEvent = this.O3;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this);
      }
    }
    return this.Q3;
  }
  
  private void u()
  {
    d locald = this.O3;
    if (locald != null) {
      locald.c(this);
    }
    this.Q3 = false;
    setPressed(false);
  }
  
  private void v(MotionEvent paramMotionEvent)
  {
    p(paramMotionEvent.getX(), paramMotionEvent.getY());
    int i = (int)paramMotionEvent.getX();
    int j = this.d.getBounds().width() / 2;
    int k = this.p0;
    int m = i - this.R3 + j;
    i = getPaddingLeft() + j + k;
    k = getWidth() - (getPaddingRight() + j + k);
    if (m < i)
    {
      j = i;
    }
    else
    {
      j = m;
      if (m > k) {
        j = k;
      }
    }
    float f1 = (j - i) / (k - i);
    float f2 = f1;
    if (i()) {
      f2 = 1.0F - f1;
    }
    i = this.p1;
    j = this.p2;
    q(Math.round(f2 * (i - j) + j), true);
  }
  
  private void w()
  {
    int[] arrayOfInt = getDrawableState();
    int i = arrayOfInt.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      int n = arrayOfInt[j];
      int i1;
      if (n == 16842908)
      {
        i1 = 1;
      }
      else
      {
        i1 = k;
        if (n == 16842919)
        {
          m = 1;
          i1 = k;
        }
      }
      j++;
      k = i1;
    }
    if ((isEnabled()) && ((k != 0) || (m != 0)))
    {
      removeCallbacks(this.c4);
      postDelayed(this.c4, 150L);
    }
    else
    {
      e();
    }
    this.d.setState(arrayOfInt);
    this.f.setState(arrayOfInt);
    this.q.setState(arrayOfInt);
    this.x.setState(arrayOfInt);
  }
  
  private void x()
  {
    int i = this.p1 - this.p2;
    int j = this.H3;
    if ((j == 0) || (i / j > 20)) {
      this.H3 = Math.max(1, Math.round(i / 20.0F));
    }
  }
  
  private void y(float paramFloat)
  {
    int i = this.d.getBounds().width() / 2;
    int j = this.p0;
    int k = getPaddingLeft();
    int m = getWidth();
    int n = getPaddingRight();
    int i1 = this.p1;
    int i2 = this.p2;
    i2 = Math.round((i1 - i2) * paramFloat + i2);
    if (i2 != getProgress())
    {
      this.p3 = i2;
      l(i2, true);
      z(i2);
    }
    A((int)(paramFloat * (m - (n + i + j) - (k + i + j)) + 0.5F));
  }
  
  private void z(int paramInt)
  {
    if (!isInEditMode()) {
      if (this.M3.c()) {
        this.U3.l(this.M3.b(paramInt));
      } else {
        this.U3.l(d(this.M3.a(paramInt)));
      }
    }
  }
  
  void b(int paramInt)
  {
    float f1;
    if (f()) {
      f1 = getAnimationPosition();
    } else {
      f1 = getProgress();
    }
    int i = this.p2;
    if (paramInt < i) {}
    int j;
    for (paramInt = i;; paramInt = j)
    {
      i = paramInt;
      break;
      j = this.p1;
      i = paramInt;
      if (paramInt <= j) {
        break;
      }
    }
    com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a locala = this.V3;
    if (locala != null) {
      locala.a();
    }
    this.X3 = i;
    locala = com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a.b(f1, i, new b(this));
    this.V3 = locala;
    locala.d(250);
    this.V3.e();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    w();
  }
  
  boolean f()
  {
    com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b.a locala = this.V3;
    boolean bool;
    if ((locala != null) && (locala.c())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  float getAnimationPosition()
  {
    return this.W3;
  }
  
  public int getMax()
  {
    return this.p1;
  }
  
  public int getMin()
  {
    return this.p2;
  }
  
  public c getNumericTransformer()
  {
    return this.M3;
  }
  
  public int getProgress()
  {
    return this.p3;
  }
  
  public boolean i()
  {
    int i = ViewCompat.getLayoutDirection(this);
    boolean bool = true;
    if ((i != 1) || (!this.I3)) {
      bool = false;
    }
    return bool;
  }
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o(int paramInt) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.c4);
    if (!isInEditMode()) {
      this.U3.e();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (!c) {
        this.x.draw(paramCanvas);
      }
      super.onDraw(paramCanvas);
      this.f.draw(paramCanvas);
      this.q.draw(paramCanvas);
      this.d.draw(paramCanvas);
      return;
    }
    finally {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if (bool1)
    {
      i = getAnimatedProgress();
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          break label88;
        }
        if (i < this.p1) {
          b(i + this.H3);
        }
      }
      else if (i > this.p2)
      {
        b(i - this.H3);
      }
      i = 1;
      break label91;
    }
    label88:
    int i = 0;
    label91:
    if ((i != 0) || (super.onKeyDown(paramInt, paramKeyEvent))) {
      bool2 = true;
    }
    return bool2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      removeCallbacks(this.c4);
      if (!isInEditMode()) {
        this.U3.e();
      }
      w();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.d.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() + this.p0 * 2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable != null) && (paramParcelable.getClass().equals(CustomState.class)))
    {
      paramParcelable = (CustomState)paramParcelable;
      setMin(CustomState.e(paramParcelable));
      setMax(CustomState.c(paramParcelable));
      q(CustomState.a(paramParcelable), false);
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CustomState localCustomState = new CustomState(super.onSaveInstanceState());
    CustomState.b(localCustomState, getProgress());
    CustomState.d(localCustomState, this.p1);
    CustomState.f(localCustomState, this.p2);
    return localCustomState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = this.d.getIntrinsicWidth();
    int j = this.d.getIntrinsicHeight();
    paramInt3 = this.p0;
    paramInt1 = i / 2;
    int k = getPaddingLeft() + paramInt3;
    paramInt2 = getPaddingRight();
    paramInt4 = getHeight() - getPaddingBottom() - paramInt3;
    this.d.setBounds(k, paramInt4 - j, i + k, paramInt4);
    i = Math.max(this.y / 2, 1);
    Drawable localDrawable = this.f;
    k += paramInt1;
    paramInt4 -= paramInt1;
    localDrawable.setBounds(k, paramInt4 - i, getWidth() - paramInt1 - paramInt2 - paramInt3, i + paramInt4);
    paramInt1 = Math.max(this.z / 2, 2);
    this.q.setBounds(k, paramInt4 - paramInt1, k, paramInt4 + paramInt1);
    B();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label172;
          }
        }
        else
        {
          if (g()) {
            v(paramMotionEvent);
          } else if (Math.abs(paramMotionEvent.getX() - this.Y3) > this.Z3) {
            t(paramMotionEvent, false);
          }
          paramMotionEvent = this.P3;
          if (paramMotionEvent == null) {
            break label172;
          }
          paramMotionEvent.a(false);
          break label172;
        }
      }
      u();
      paramMotionEvent = this.P3;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(true);
      }
    }
    else
    {
      this.Y3 = paramMotionEvent.getX();
      boolean bool;
      if ((h()) && (!this.b4)) {
        bool = true;
      } else {
        bool = false;
      }
      t(paramMotionEvent, bool);
      paramMotionEvent = this.P3;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(false);
      }
    }
    label172:
    return true;
  }
  
  public void r(int paramInt1, int paramInt2)
  {
    this.d.c(ColorStateList.valueOf(paramInt1));
    this.U3.j(paramInt1, paramInt2);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    super.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }
  
  void setAnimationPosition(float paramFloat)
  {
    this.W3 = paramFloat;
    int i = this.p2;
    y((paramFloat - i) / (this.p1 - i));
  }
  
  public void setIndicatorFormatter(@Nullable String paramString)
  {
    this.L3 = paramString;
    z(this.p3);
  }
  
  public void setMax(int paramInt)
  {
    this.p1 = paramInt;
    if (paramInt < this.p2) {
      setMin(paramInt - 1);
    }
    x();
    int i = this.p3;
    paramInt = this.p2;
    if ((i < paramInt) || (i > this.p1)) {
      setProgress(paramInt);
    }
  }
  
  public void setMin(int paramInt)
  {
    this.p2 = paramInt;
    if (paramInt > this.p1) {
      setMax(paramInt + 1);
    }
    x();
    paramInt = this.p3;
    int i = this.p2;
    if ((paramInt < i) || (paramInt > this.p1)) {
      setProgress(i);
    }
  }
  
  public void setNumericTransformer(@Nullable c paramc)
  {
    if (paramc == null) {
      paramc = new b(null);
    }
    this.M3 = paramc;
    if (!isInEditMode()) {
      if (this.M3.c()) {
        this.U3.p(this.M3.b(this.p1));
      } else {
        this.U3.p(d(this.M3.a(this.p1)));
      }
    }
    z(this.p3);
  }
  
  public void setOnProgressChangeListener(d paramd)
  {
    this.O3 = paramd;
  }
  
  public void setOnTouchCancelListener(com.tplink.libtpcontrols.z0.e parame)
  {
    this.P3 = parame;
  }
  
  public void setProgress(int paramInt)
  {
    q(paramInt, false);
  }
  
  public void setScrubberColor(int paramInt)
  {
    this.q.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
  
  public void setTrackColor(int paramInt)
  {
    this.f.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    boolean bool;
    if ((paramDrawable != this.d) && (paramDrawable != this.f) && (paramDrawable != this.q) && (paramDrawable != this.x) && (!super.verifyDrawable(paramDrawable))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  static class CustomState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<CustomState> CREATOR = new a();
    private int c;
    private int d;
    private int f;
    
    public CustomState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.f = paramParcel.readInt();
    }
    
    public CustomState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.f);
    }
    
    static final class a
      implements Parcelable.Creator<DiscreteSeekBar.CustomState>
    {
      public DiscreteSeekBar.CustomState a(Parcel paramParcel)
      {
        return new DiscreteSeekBar.CustomState(paramParcel);
      }
      
      public DiscreteSeekBar.CustomState[] b(int paramInt)
      {
        return new DiscreteSeekBar.CustomState[paramInt];
      }
    }
  }
  
  class a
    implements b.b
  {
    a() {}
    
    public void a()
    {
      DiscreteSeekBar.a(DiscreteSeekBar.this).g();
    }
    
    public void b() {}
  }
  
  private static class b
    extends DiscreteSeekBar.c
  {
    public int a(int paramInt)
    {
      return paramInt;
    }
  }
  
  public static abstract class c
  {
    public abstract int a(int paramInt);
    
    public String b(int paramInt)
    {
      return String.valueOf(paramInt);
    }
    
    public boolean c()
    {
      return false;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(DiscreteSeekBar paramDiscreteSeekBar);
    
    public abstract void b(DiscreteSeekBar paramDiscreteSeekBar, int paramInt, boolean paramBoolean);
    
    public abstract void c(DiscreteSeekBar paramDiscreteSeekBar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\DiscreteSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */