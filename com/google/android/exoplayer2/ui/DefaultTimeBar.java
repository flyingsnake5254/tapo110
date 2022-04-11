package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar
  extends View
  implements y0
{
  private final int H3;
  private final int I3;
  private final int J3;
  private final int K3;
  private final int L3;
  private final int M3;
  private final int N3;
  private final int O3;
  private final int P3;
  private final StringBuilder Q3;
  private final Formatter R3;
  private final Runnable S3;
  private final CopyOnWriteArraySet<y0.a> T3;
  private final Point U3;
  private final float V3;
  private int W3;
  private long X3;
  private int Y3;
  private Rect Z3;
  private ValueAnimator a4;
  private float b4;
  private final Rect c = new Rect();
  private boolean c4;
  private final Rect d = new Rect();
  private boolean d4;
  private long e4;
  private final Rect f = new Rect();
  private long f4;
  private long g4;
  private long h4;
  private int i4;
  @Nullable
  private long[] j4;
  @Nullable
  private boolean[] k4;
  private final Paint p0;
  private final Paint p1;
  private final Paint p2;
  @Nullable
  private final Drawable p3;
  private final Rect q = new Rect();
  private final Paint x;
  private final Paint y;
  private final Paint z;
  
  public DefaultTimeBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefaultTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DefaultTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, paramAttributeSet);
  }
  
  public DefaultTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet1, int paramInt, @Nullable AttributeSet paramAttributeSet2)
  {
    this(paramContext, paramAttributeSet1, paramInt, paramAttributeSet2, 0);
  }
  
  public DefaultTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet1, int paramInt1, @Nullable AttributeSet paramAttributeSet2, int paramInt2)
  {
    super(paramContext, paramAttributeSet1, paramInt1);
    Paint localPaint1 = new Paint();
    this.x = localPaint1;
    paramAttributeSet1 = new Paint();
    this.y = paramAttributeSet1;
    Paint localPaint2 = new Paint();
    this.z = localPaint2;
    Paint localPaint3 = new Paint();
    this.p0 = localPaint3;
    Paint localPaint4 = new Paint();
    this.p1 = localPaint4;
    Paint localPaint5 = new Paint();
    this.p2 = localPaint5;
    localPaint5.setAntiAlias(true);
    this.T3 = new CopyOnWriteArraySet();
    this.U3 = new Point();
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.V3 = f1;
    this.P3 = c(f1, -50);
    int i = c(f1, 4);
    int j = c(f1, 26);
    int k = c(f1, 4);
    int m = c(f1, 12);
    int n = c(f1, 0);
    int i1 = c(f1, 16);
    if (paramAttributeSet2 != null)
    {
      paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet2, t0.DefaultTimeBar, paramInt1, paramInt2);
      try
      {
        paramAttributeSet2 = paramContext.getDrawable(t0.DefaultTimeBar_scrubber_drawable);
        this.p3 = paramAttributeSet2;
        paramInt1 = j;
        if (paramAttributeSet2 != null)
        {
          q(paramAttributeSet2);
          paramInt1 = Math.max(paramAttributeSet2.getMinimumHeight(), j);
        }
        this.H3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_bar_height, i);
        this.I3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_touch_target_height, paramInt1);
        this.J3 = paramContext.getInt(t0.DefaultTimeBar_bar_gravity, 0);
        this.K3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_ad_marker_width, k);
        this.L3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_enabled_size, m);
        this.M3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_disabled_size, n);
        this.N3 = paramContext.getDimensionPixelSize(t0.DefaultTimeBar_scrubber_dragged_size, i1);
        paramInt1 = paramContext.getInt(t0.DefaultTimeBar_played_color, -1);
        j = paramContext.getInt(t0.DefaultTimeBar_scrubber_color, -1);
        m = paramContext.getInt(t0.DefaultTimeBar_buffered_color, -855638017);
        n = paramContext.getInt(t0.DefaultTimeBar_unplayed_color, 872415231);
        paramInt2 = paramContext.getInt(t0.DefaultTimeBar_ad_marker_color, -1291845888);
        i = paramContext.getInt(t0.DefaultTimeBar_played_ad_marker_color, 872414976);
        localPaint1.setColor(paramInt1);
        localPaint5.setColor(j);
        paramAttributeSet1.setColor(m);
        localPaint2.setColor(n);
        localPaint3.setColor(paramInt2);
        localPaint4.setColor(i);
      }
      finally
      {
        paramContext.recycle();
      }
    }
    this.H3 = i;
    this.I3 = j;
    this.J3 = 0;
    this.K3 = k;
    this.L3 = m;
    this.M3 = n;
    this.N3 = i1;
    localPaint1.setColor(-1);
    localPaint5.setColor(-1);
    paramAttributeSet1.setColor(-855638017);
    localPaint2.setColor(872415231);
    localPaint3.setColor(-1291845888);
    localPaint4.setColor(872414976);
    this.p3 = null;
    paramContext = new StringBuilder();
    this.Q3 = paramContext;
    this.R3 = new Formatter(paramContext, Locale.getDefault());
    this.S3 = new b(this);
    paramContext = this.p3;
    if (paramContext != null) {
      this.O3 = ((paramContext.getMinimumWidth() + 1) / 2);
    } else {
      this.O3 = ((Math.max(this.M3, Math.max(this.L3, this.N3)) + 1) / 2);
    }
    this.b4 = 1.0F;
    paramContext = new ValueAnimator();
    this.a4 = paramContext;
    paramContext.addUpdateListener(new c(this));
    this.f4 = -9223372036854775807L;
    this.X3 = -9223372036854775807L;
    this.W3 = 20;
    setFocusable(true);
    if (getImportantForAccessibility() == 0) {
      setImportantForAccessibility(1);
    }
  }
  
  private static int c(float paramFloat, int paramInt)
  {
    return (int)(paramInt * paramFloat + 0.5F);
  }
  
  private void d(Canvas paramCanvas)
  {
    if (this.f4 <= 0L) {
      return;
    }
    Object localObject = this.q;
    int i = o0.p(((Rect)localObject).right, ((Rect)localObject).left, this.d.right);
    int j = this.q.centerY();
    localObject = this.p3;
    int k;
    if (localObject == null)
    {
      if ((!this.d4) && (!isFocused()))
      {
        if (isEnabled()) {
          k = this.L3;
        } else {
          k = this.M3;
        }
      }
      else {
        k = this.N3;
      }
      k = (int)(k * this.b4 / 2.0F);
      paramCanvas.drawCircle(i, j, k, this.p2);
    }
    else
    {
      int m = (int)(((Drawable)localObject).getIntrinsicWidth() * this.b4);
      k = (int)(this.p3.getIntrinsicHeight() * this.b4);
      localObject = this.p3;
      m /= 2;
      k /= 2;
      ((Drawable)localObject).setBounds(i - m, j - k, i + m, j + k);
      this.p3.draw(paramCanvas);
    }
  }
  
  private void e(Canvas paramCanvas)
  {
    int i = this.d.height();
    int j = this.d.centerY() - i / 2;
    int k = i + j;
    if (this.f4 <= 0L)
    {
      localObject = this.d;
      paramCanvas.drawRect(((Rect)localObject).left, j, ((Rect)localObject).right, k, this.z);
      return;
    }
    Object localObject = this.f;
    int m = ((Rect)localObject).left;
    i = ((Rect)localObject).right;
    int n = Math.max(Math.max(this.d.left, i), this.q.right);
    int i1 = this.d.right;
    if (n < i1) {
      paramCanvas.drawRect(n, j, i1, k, this.z);
    }
    i1 = Math.max(m, this.q.right);
    if (i > i1) {
      paramCanvas.drawRect(i1, j, i, k, this.y);
    }
    if (this.q.width() > 0)
    {
      localObject = this.q;
      paramCanvas.drawRect(((Rect)localObject).left, j, ((Rect)localObject).right, k, this.x);
    }
    if (this.i4 == 0) {
      return;
    }
    long[] arrayOfLong = (long[])g.e(this.j4);
    boolean[] arrayOfBoolean = (boolean[])g.e(this.k4);
    i1 = this.K3 / 2;
    for (i = 0; i < this.i4; i++)
    {
      long l = o0.q(arrayOfLong[i], 0L, this.f4);
      n = (int)(this.d.width() * l / this.f4);
      localObject = this.d;
      n = ((Rect)localObject).left + Math.min(((Rect)localObject).width() - this.K3, Math.max(0, n - i1));
      if (arrayOfBoolean[i] != 0) {
        localObject = this.p1;
      } else {
        localObject = this.p0;
      }
      paramCanvas.drawRect(n, j, n + this.K3, k, (Paint)localObject);
    }
  }
  
  private long getPositionIncrement()
  {
    long l1 = this.X3;
    long l2 = l1;
    if (l1 == -9223372036854775807L)
    {
      l2 = this.f4;
      if (l2 == -9223372036854775807L) {
        l2 = 0L;
      } else {
        l2 /= this.W3;
      }
    }
    return l2;
  }
  
  private String getProgressText()
  {
    return o0.Z(this.Q3, this.R3, this.g4);
  }
  
  private long getScrubberPosition()
  {
    if ((this.d.width() > 0) && (this.f4 != -9223372036854775807L)) {
      return this.q.width() * this.f4 / this.d.width();
    }
    return 0L;
  }
  
  private boolean h(float paramFloat1, float paramFloat2)
  {
    return this.c.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private void m(float paramFloat)
  {
    Rect localRect1 = this.q;
    int i = (int)paramFloat;
    Rect localRect2 = this.d;
    localRect1.right = o0.p(i, localRect2.left, localRect2.right);
  }
  
  private static int n(float paramFloat, int paramInt)
  {
    return (int)(paramInt / paramFloat);
  }
  
  private Point o(MotionEvent paramMotionEvent)
  {
    this.U3.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    return this.U3;
  }
  
  private boolean p(long paramLong)
  {
    long l1 = this.f4;
    if (l1 <= 0L) {
      return false;
    }
    long l2;
    if (this.d4) {
      l2 = this.e4;
    } else {
      l2 = this.g4;
    }
    paramLong = o0.q(l2 + paramLong, 0L, l1);
    if (paramLong == l2) {
      return false;
    }
    if (!this.d4) {
      v(paramLong);
    } else {
      z(paramLong);
    }
    x();
    return true;
  }
  
  private boolean q(Drawable paramDrawable)
  {
    boolean bool;
    if ((o0.a >= 23) && (r(paramDrawable, getLayoutDirection()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean r(Drawable paramDrawable, int paramInt)
  {
    boolean bool;
    if ((o0.a >= 23) && (paramDrawable.setLayoutDirection(paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(29)
  private void s(int paramInt1, int paramInt2)
  {
    Rect localRect = this.Z3;
    if ((localRect != null) && (localRect.width() == paramInt1) && (this.Z3.height() == paramInt2)) {
      return;
    }
    localRect = new Rect(0, 0, paramInt1, paramInt2);
    this.Z3 = localRect;
    setSystemGestureExclusionRects(Collections.singletonList(localRect));
  }
  
  private void v(long paramLong)
  {
    this.e4 = paramLong;
    this.d4 = true;
    setPressed(true);
    Object localObject = getParent();
    if (localObject != null) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
    }
    localObject = this.T3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((y0.a)((Iterator)localObject).next()).i(this, paramLong);
    }
  }
  
  private void w(boolean paramBoolean)
  {
    removeCallbacks(this.S3);
    this.d4 = false;
    setPressed(false);
    Object localObject = getParent();
    if (localObject != null) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
    }
    invalidate();
    localObject = this.T3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((y0.a)((Iterator)localObject).next()).h(this, this.e4, paramBoolean);
    }
  }
  
  private void x()
  {
    this.f.set(this.d);
    this.q.set(this.d);
    long l;
    if (this.d4) {
      l = this.e4;
    } else {
      l = this.g4;
    }
    int i;
    Rect localRect1;
    if (this.f4 > 0L)
    {
      i = (int)(this.d.width() * this.h4 / this.f4);
      localRect1 = this.f;
      Rect localRect2 = this.d;
      localRect1.right = Math.min(localRect2.left + i, localRect2.right);
      i = (int)(this.d.width() * l / this.f4);
      localRect2 = this.q;
      localRect1 = this.d;
      localRect2.right = Math.min(localRect1.left + i, localRect1.right);
    }
    else
    {
      localRect1 = this.f;
      i = this.d.left;
      localRect1.right = i;
      this.q.right = i;
    }
    invalidate(this.c);
  }
  
  private void y()
  {
    Drawable localDrawable = this.p3;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (this.p3.setState(getDrawableState()))) {
      invalidate();
    }
  }
  
  private void z(long paramLong)
  {
    if (this.e4 == paramLong) {
      return;
    }
    this.e4 = paramLong;
    Iterator localIterator = this.T3.iterator();
    while (localIterator.hasNext()) {
      ((y0.a)localIterator.next()).b(this, paramLong);
    }
  }
  
  public void a(y0.a parama)
  {
    g.e(parama);
    this.T3.add(parama);
  }
  
  public void b(@Nullable long[] paramArrayOfLong, @Nullable boolean[] paramArrayOfBoolean, int paramInt)
  {
    boolean bool;
    if ((paramInt != 0) && ((paramArrayOfLong == null) || (paramArrayOfBoolean == null))) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    this.i4 = paramInt;
    this.j4 = paramArrayOfLong;
    this.k4 = paramArrayOfBoolean;
    x();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    y();
  }
  
  public void f(long paramLong)
  {
    if (this.a4.isStarted()) {
      this.a4.cancel();
    }
    this.a4.setFloatValues(new float[] { this.b4, 0.0F });
    this.a4.setDuration(paramLong);
    this.a4.start();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.a4.isStarted()) {
      this.a4.cancel();
    }
    this.c4 = paramBoolean;
    this.b4 = 0.0F;
    invalidate(this.c);
  }
  
  public long getPreferredUpdateDelay()
  {
    int i = n(this.V3, this.d.width());
    if (i != 0)
    {
      l = this.f4;
      if ((l != 0L) && (l != -9223372036854775807L))
      {
        l /= i;
        return l;
      }
    }
    long l = Long.MAX_VALUE;
    return l;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.p3;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    e(paramCanvas);
    d(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((this.d4) && (!paramBoolean)) {
      w(false);
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 4) {
      paramAccessibilityEvent.getText().add(getProgressText());
    }
    paramAccessibilityEvent.setClassName("android.widget.SeekBar");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
    paramAccessibilityNodeInfo.setContentDescription(getProgressText());
    if (this.f4 <= 0L) {
      return;
    }
    if (o0.a >= 21)
    {
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    }
    else
    {
      paramAccessibilityNodeInfo.addAction(4096);
      paramAccessibilityNodeInfo.addAction(8192);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (isEnabled())
    {
      long l1 = getPositionIncrement();
      if (paramInt != 66)
      {
        long l2 = l1;
        switch (paramInt)
        {
        default: 
          break;
        case 21: 
          l2 = -l1;
        case 22: 
          if (!p(l2)) {
            break;
          }
          removeCallbacks(this.S3);
          postDelayed(this.S3, 1000L);
          return true;
        }
      }
      else if (this.d4)
      {
        w(false);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    paramInt4 = getPaddingLeft();
    int k = getPaddingRight();
    if (this.c4) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.O3;
    }
    if (this.J3 == 1)
    {
      paramInt2 = j - getPaddingBottom() - this.I3;
      paramInt3 = getPaddingBottom();
      int m = this.H3;
      paramInt3 = j - paramInt3 - m - Math.max(paramInt1 - m / 2, 0);
    }
    else
    {
      paramInt2 = (j - this.I3) / 2;
      paramInt3 = (j - this.H3) / 2;
    }
    this.c.set(paramInt4, paramInt2, i - k, this.I3 + paramInt2);
    Rect localRect1 = this.d;
    Rect localRect2 = this.c;
    localRect1.set(localRect2.left + paramInt1, paramInt3, localRect2.right - paramInt1, this.H3 + paramInt3);
    if (o0.a >= 29) {
      s(i, j);
    }
    x();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i == 0) {
      paramInt2 = this.I3;
    } else if (i != 1073741824) {
      paramInt2 = Math.min(this.I3, paramInt2);
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
    y();
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable = this.p3;
    if ((localDrawable != null) && (r(localDrawable, paramInt))) {
      invalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if ((bool1) && (this.f4 > 0L))
    {
      Point localPoint = o(paramMotionEvent);
      int i = localPoint.x;
      int j = localPoint.y;
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k != 1) {
          if (k != 2)
          {
            if (k != 3) {
              break label212;
            }
          }
          else
          {
            if (!this.d4) {
              break label212;
            }
            if (j < this.P3)
            {
              j = this.Y3;
              m(j + (i - j) / 3);
            }
            else
            {
              this.Y3 = i;
              m(i);
            }
            z(getScrubberPosition());
            x();
            invalidate();
            return true;
          }
        }
        if (this.d4)
        {
          if (paramMotionEvent.getAction() == 3) {
            bool2 = true;
          }
          w(bool2);
          return true;
        }
      }
      else
      {
        float f1 = i;
        if (h(f1, j))
        {
          m(f1);
          v(getScrubberPosition());
          x();
          invalidate();
          return true;
        }
      }
    }
    label212:
    return false;
  }
  
  public boolean performAccessibilityAction(int paramInt, @Nullable Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    if (this.f4 <= 0L) {
      return false;
    }
    if (paramInt == 8192)
    {
      if (p(-getPositionIncrement())) {
        w(false);
      }
    }
    else
    {
      if (paramInt != 4096) {
        break label79;
      }
      if (p(getPositionIncrement())) {
        w(false);
      }
    }
    sendAccessibilityEvent(4);
    return true;
    label79:
    return false;
  }
  
  public void setAdMarkerColor(@ColorInt int paramInt)
  {
    this.p0.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void setBufferedColor(@ColorInt int paramInt)
  {
    this.y.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void setBufferedPosition(long paramLong)
  {
    this.h4 = paramLong;
    x();
  }
  
  public void setDuration(long paramLong)
  {
    this.f4 = paramLong;
    if ((this.d4) && (paramLong == -9223372036854775807L)) {
      w(true);
    }
    x();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if ((this.d4) && (!paramBoolean)) {
      w(true);
    }
  }
  
  public void setKeyCountIncrement(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.W3 = paramInt;
    this.X3 = -9223372036854775807L;
  }
  
  public void setKeyTimeIncrement(long paramLong)
  {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.W3 = -1;
    this.X3 = paramLong;
  }
  
  public void setPlayedAdMarkerColor(@ColorInt int paramInt)
  {
    this.p1.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void setPlayedColor(@ColorInt int paramInt)
  {
    this.x.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void setPosition(long paramLong)
  {
    this.g4 = paramLong;
    setContentDescription(getProgressText());
    x();
  }
  
  public void setScrubberColor(@ColorInt int paramInt)
  {
    this.p2.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void setUnplayedColor(@ColorInt int paramInt)
  {
    this.z.setColor(paramInt);
    invalidate(this.c);
  }
  
  public void t()
  {
    if (this.a4.isStarted()) {
      this.a4.cancel();
    }
    this.c4 = false;
    this.b4 = 1.0F;
    invalidate(this.c);
  }
  
  public void u(long paramLong)
  {
    if (this.a4.isStarted()) {
      this.a4.cancel();
    }
    this.c4 = false;
    this.a4.setFloatValues(new float[] { this.b4, 1.0F });
    this.a4.setDuration(paramLong);
    this.a4.start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\DefaultTimeBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */