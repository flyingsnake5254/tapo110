package com.andexert.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import androidx.annotation.ColorRes;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.x0;

public class RippleView
  extends RelativeLayout
{
  private float H3 = -1.0F;
  private float I3 = -1.0F;
  private int J3;
  private float K3;
  private ScaleAnimation L3;
  private Boolean M3;
  private Boolean N3;
  private Integer O3;
  private Paint P3;
  private Bitmap Q3;
  private int R3;
  private int S3;
  private GestureDetector T3;
  private final Runnable U3 = new a(this);
  private b V3;
  private int c;
  private int d;
  private int f = 10;
  private boolean p0 = false;
  private int p1 = 0;
  private int p2 = 0;
  private int p3 = -1;
  private int q = 400;
  private int x = 90;
  private Handler y;
  private float z = 0.0F;
  
  public RippleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RippleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramContext, paramAttributeSet);
  }
  
  public RippleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    if ((isEnabled()) && (!this.p0))
    {
      if (this.M3.booleanValue()) {
        startAnimation(this.L3);
      }
      this.z = Math.max(this.c, this.d);
      if (this.O3.intValue() != 2) {
        this.z /= 2.0F;
      }
      this.z -= this.S3;
      if ((!this.N3.booleanValue()) && (this.O3.intValue() != 1))
      {
        this.H3 = paramFloat1;
        this.I3 = paramFloat2;
      }
      else
      {
        this.H3 = (getMeasuredWidth() / 2.0F);
        this.I3 = (getMeasuredHeight() / 2.0F);
      }
      this.p0 = true;
      if ((this.O3.intValue() == 1) && (this.Q3 == null)) {
        this.Q3 = getDrawingCache(true);
      }
      invalidate();
    }
  }
  
  private Bitmap d(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.Q3.getWidth(), this.Q3.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    float f1 = this.H3;
    float f2 = paramInt;
    paramInt = (int)(f1 - f2);
    float f3 = this.I3;
    Rect localRect = new Rect(paramInt, (int)(f3 - f2), (int)(f1 + f2), (int)(f3 + f2));
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localCanvas.drawCircle(this.H3, this.I3, f2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(this.Q3, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (isInEditMode()) {
      return;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.RippleView);
    this.R3 = paramAttributeSet.getColor(x0.RippleView_rv_color, getResources().getColor(p0.rippelColor));
    this.O3 = Integer.valueOf(paramAttributeSet.getInt(x0.RippleView_rv_type, 0));
    this.M3 = Boolean.valueOf(paramAttributeSet.getBoolean(x0.RippleView_rv_zoom, false));
    this.N3 = Boolean.valueOf(paramAttributeSet.getBoolean(x0.RippleView_rv_centered, false));
    this.q = paramAttributeSet.getInteger(x0.RippleView_rv_rippleDuration, this.q);
    this.f = paramAttributeSet.getInteger(x0.RippleView_rv_framerate, this.f);
    this.x = paramAttributeSet.getInteger(x0.RippleView_rv_alpha, this.x);
    this.S3 = paramAttributeSet.getDimensionPixelSize(x0.RippleView_rv_ripplePadding, 0);
    this.y = new Handler();
    this.K3 = paramAttributeSet.getFloat(x0.RippleView_rv_zoomScale, 1.03F);
    this.J3 = paramAttributeSet.getInt(x0.RippleView_rv_zoomDuration, 200);
    paramAttributeSet.recycle();
    paramAttributeSet = new Paint();
    this.P3 = paramAttributeSet;
    paramAttributeSet.setAntiAlias(true);
    this.P3.setStyle(Paint.Style.FILL);
    this.P3.setColor(this.R3);
    this.P3.setAlpha(this.x);
    setWillNotDraw(false);
    this.T3 = new GestureDetector(paramContext, new a());
    setDrawingCacheEnabled(true);
    setClickable(true);
  }
  
  private void f(Boolean paramBoolean)
  {
    if ((getParent() instanceof AdapterView))
    {
      AdapterView localAdapterView = (AdapterView)getParent();
      int i = localAdapterView.getPositionForView(this);
      long l = localAdapterView.getItemIdAtPosition(i);
      if (paramBoolean.booleanValue())
      {
        if (localAdapterView.getOnItemLongClickListener() != null) {
          localAdapterView.getOnItemLongClickListener().onItemLongClick(localAdapterView, this, i, l);
        }
      }
      else if (localAdapterView.getOnItemClickListener() != null) {
        localAdapterView.getOnItemClickListener().onItemClick(localAdapterView, this, i, l);
      }
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    c(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.p0)
    {
      paramCanvas.save();
      int i = this.q;
      int j = this.p1;
      int k = this.f;
      if (i <= j * k)
      {
        this.p0 = false;
        this.p1 = 0;
        this.p3 = -1;
        this.p2 = 0;
        if (Build.VERSION.SDK_INT != 23) {
          paramCanvas.restore();
        }
        invalidate();
        paramCanvas = this.V3;
        if (paramCanvas != null) {
          paramCanvas.j0(this);
        }
        return;
      }
      this.y.postDelayed(this.U3, k);
      if (this.p1 == 0) {
        paramCanvas.save();
      }
      paramCanvas.drawCircle(this.H3, this.I3, this.z * (this.p1 * this.f / this.q), this.P3);
      this.P3.setColor(Color.parseColor("#ffff4444"));
      float f1;
      if ((this.O3.intValue() == 1) && (this.Q3 != null))
      {
        j = this.p1;
        f1 = j;
        k = this.f;
        float f2 = k;
        i = this.q;
        if (f1 * f2 / i > 0.4F)
        {
          if (this.p3 == -1) {
            this.p3 = (i - j * k);
          }
          i = this.p2 + 1;
          this.p2 = i;
          Bitmap localBitmap = d((int)(this.z * (i * k / this.p3)));
          paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.P3);
          localBitmap.recycle();
        }
      }
      this.P3.setColor(this.R3);
      if (this.O3.intValue() == 1)
      {
        f1 = this.p1;
        k = this.f;
        if (f1 * k / this.q > 0.6F)
        {
          paramCanvas = this.P3;
          i = this.x;
          paramCanvas.setAlpha((int)(i - i * (this.p2 * k / this.p3)));
        }
        else
        {
          this.P3.setAlpha(this.x);
        }
      }
      else
      {
        paramCanvas = this.P3;
        k = this.x;
        paramCanvas.setAlpha((int)(k - k * (this.p1 * this.f / this.q)));
      }
      this.p1 += 1;
    }
  }
  
  public int getFrameRate()
  {
    return this.f;
  }
  
  public int getRippleAlpha()
  {
    return this.x;
  }
  
  public int getRippleColor()
  {
    return this.R3;
  }
  
  public int getRippleDuration()
  {
    return this.q;
  }
  
  public int getRipplePadding()
  {
    return this.S3;
  }
  
  public RippleType getRippleType()
  {
    return RippleType.values()[this.O3.intValue()];
  }
  
  public int getZoomDuration()
  {
    return this.J3;
  }
  
  public float getZoomScale()
  {
    return this.K3;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    onTouchEvent(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt1;
    this.d = paramInt2;
    float f1 = this.K3;
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, f1, 1.0F, f1, paramInt1 / 2.0F, paramInt2 / 2.0F);
    this.L3 = localScaleAnimation;
    localScaleAnimation.setDuration(this.J3);
    this.L3.setRepeatMode(2);
    this.L3.setRepeatCount(1);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.T3.onTouchEvent(paramMotionEvent))
    {
      b(paramMotionEvent);
      f(Boolean.FALSE);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCentered(Boolean paramBoolean)
  {
    this.N3 = paramBoolean;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnRippleCompleteListener(b paramb)
  {
    this.V3 = paramb;
  }
  
  public void setRippleAlpha(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setRippleColor(@ColorRes int paramInt)
  {
    this.R3 = getResources().getColor(paramInt);
  }
  
  public void setRippleDuration(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setRipplePadding(int paramInt)
  {
    this.S3 = paramInt;
  }
  
  public void setRippleType(RippleType paramRippleType)
  {
    this.O3 = Integer.valueOf(paramRippleType.ordinal());
  }
  
  public void setZoomDuration(int paramInt)
  {
    this.J3 = paramInt;
  }
  
  public void setZoomScale(float paramFloat)
  {
    this.K3 = paramFloat;
  }
  
  public void setZooming(Boolean paramBoolean)
  {
    this.M3 = paramBoolean;
  }
  
  public static enum RippleType
  {
    int type;
    
    static
    {
      RippleType localRippleType1 = new RippleType("SIMPLE", 0, 0);
      SIMPLE = localRippleType1;
      RippleType localRippleType2 = new RippleType("DOUBLE", 1, 1);
      DOUBLE = localRippleType2;
      RippleType localRippleType3 = new RippleType("RECTANGLE", 2, 2);
      RECTANGLE = localRippleType3;
      $VALUES = new RippleType[] { localRippleType1, localRippleType2, localRippleType3 };
    }
    
    private RippleType(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    a() {}
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
      RippleView.this.b(paramMotionEvent);
      RippleView.a(RippleView.this, Boolean.TRUE);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void j0(RippleView paramRippleView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\andexert\library\RippleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */