package com.tplink.iot.view.ipcamera.widget.progressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import com.tplink.iot.b;

public class MultiColorSeekBar
  extends View
{
  float H3;
  float I3;
  private Paint J3;
  private Paint K3;
  private int L3 = 60;
  private float M3 = 0.6F;
  float N3;
  float O3;
  int P3;
  float Q3;
  private Paint R3;
  int S3 = -1;
  boolean T3 = true;
  private Paint U3;
  int V3;
  int W3;
  int X3;
  int Y3;
  int Z3;
  float a4;
  RectF b4 = new RectF();
  private int c;
  Paint c4 = new Paint();
  private int d;
  private a d4;
  private int f = 0;
  int p0;
  int p1;
  int p2;
  float p3;
  private float q = 0.0F;
  private int x = 100;
  private int y = 0;
  int z;
  
  public MultiColorSeekBar(Context paramContext)
  {
    super(paramContext);
    c(null);
  }
  
  public MultiColorSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramAttributeSet);
  }
  
  public MultiColorSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramAttributeSet);
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void b(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    paramFloat3 -= paramFloat4 / 2.0F;
    RectF localRectF = this.b4;
    localRectF.top = (paramFloat2 - paramFloat3);
    localRectF.bottom = (paramFloat2 + paramFloat3);
    localRectF.left = (paramFloat1 - paramFloat3);
    localRectF.right = (paramFloat1 + paramFloat3);
    this.c4.setStrokeWidth(paramFloat4);
    this.c4.setColor(paramInt);
    paramCanvas.drawArc(this.b4, 0.0F, 360.0F, false, this.c4);
  }
  
  private void c(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.MultiColorSeekBar);
      this.X3 = ((int)paramAttributeSet.getDimension(4, a(getContext(), 9.0F)));
      int i = (int)paramAttributeSet.getDimension(3, a(getContext(), 4.0F));
      this.Z3 = i;
      this.Y3 = (this.X3 - i);
      this.V3 = paramAttributeSet.getColor(2, -1);
      this.z = ((int)paramAttributeSet.getDimension(9, a(getContext(), 4.0F)));
      this.p0 = paramAttributeSet.getColor(7, -1);
      this.p1 = paramAttributeSet.getColor(8, -1618884);
      this.p2 = paramAttributeSet.getColor(6, 1738119577);
      this.x = paramAttributeSet.getInt(5, 100);
      this.O3 = a(getContext(), 2.0F);
      this.P3 = ((int)paramAttributeSet.getDimension(0, a(getContext(), 0.5F)));
      i = paramAttributeSet.getInt(1, 60);
      this.L3 = i;
      this.M3 = (i / this.x);
      paramAttributeSet.recycle();
    }
    paramAttributeSet = new Paint();
    this.J3 = paramAttributeSet;
    paramAttributeSet.setStyle(Paint.Style.FILL);
    this.J3.setAntiAlias(true);
    this.J3.setStrokeWidth(this.z);
    this.J3.setStrokeCap(Paint.Cap.ROUND);
    paramAttributeSet = new Paint();
    this.K3 = paramAttributeSet;
    paramAttributeSet.setStyle(Paint.Style.FILL);
    this.K3.setAntiAlias(true);
    this.K3.setStrokeWidth(this.z);
    this.K3.setStrokeCap(Paint.Cap.BUTT);
    this.K3.setColor(this.p1);
    paramAttributeSet = new Paint();
    this.R3 = paramAttributeSet;
    paramAttributeSet.setStyle(Paint.Style.FILL);
    this.R3.setAntiAlias(true);
    this.R3.setStrokeCap(Paint.Cap.BUTT);
    this.R3.setColor(this.S3);
    paramAttributeSet = new Paint();
    this.U3 = paramAttributeSet;
    paramAttributeSet.setAntiAlias(true);
    this.U3.setColor(this.V3);
    this.c4.setStyle(Paint.Style.STROKE);
    this.c4.setAntiAlias(true);
  }
  
  public boolean d()
  {
    return this.T3;
  }
  
  public int getProgress()
  {
    return this.y;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.q;
    this.a4 = f1;
    float f2 = this.H3;
    if (f1 < f2)
    {
      this.a4 = f2;
    }
    else
    {
      int i = this.c;
      j = this.X3;
      if (f1 > i - j) {
        this.a4 = (i - j);
      }
    }
    int j = (int)((this.a4 - f2) * this.x / (this.c - this.X3 - f2));
    this.y = j;
    a locala = this.d4;
    if (locala != null) {
      locala.b(j);
    }
    this.J3.setColor(this.p2);
    f1 = this.H3;
    f2 = this.p3;
    paramCanvas.drawLine(f1, f2, this.I3, f2, this.J3);
    this.J3.setColor(this.p0);
    f1 = this.a4;
    f2 = this.N3;
    float f3;
    if (f1 > f2)
    {
      f1 = this.H3;
      f3 = this.p3;
      paramCanvas.drawLine(f1, f3, f2, f3, this.J3);
      f2 = this.N3;
      f1 = this.p3;
      paramCanvas.drawLine(f2, f1, this.a4, f1, this.K3);
    }
    else
    {
      f2 = this.H3;
      f3 = this.p3;
      paramCanvas.drawLine(f2, f3, f1, f3, this.J3);
    }
    if (this.y >= 60)
    {
      if (!this.T3)
      {
        this.T3 = true;
        this.d4.a(true);
      }
      this.R3.setStrokeWidth(this.O3);
      f2 = this.N3;
      f3 = this.P3;
      f1 = this.Q3;
      paramCanvas.drawLine(f2 - f3, f1, f2, f1, this.R3);
      this.R3.setStrokeWidth(this.z);
      f2 = this.N3;
      f1 = this.P3;
      f3 = this.p3;
      paramCanvas.drawLine(f2 - f1, f3, f2, f3, this.R3);
    }
    else if (this.T3)
    {
      this.T3 = false;
      this.d4.a(false);
    }
    j = this.V3;
    this.W3 = (((int)((0xFF000000 & j) * 0.4D) << 24) + (0xFFFFFF & j));
    this.U3.setColor(j);
    paramCanvas.drawCircle(this.a4, this.p3, this.Y3, this.U3);
    b(paramCanvas, this.a4, this.p3, this.X3, this.Z3, this.W3);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = this.f;
      paramInt2 = this.X3;
      float f1 = paramInt1 + paramInt2;
      this.p3 = f1;
      this.H3 = paramInt2;
      float f2 = this.c - paramInt2;
      this.I3 = f2;
      this.N3 = (f2 * this.M3 + paramInt2 / 2.0F);
      float f3 = this.z / 2.0F;
      f2 = this.O3;
      this.Q3 = (f1 - f3 - f2 / 2.0F);
      this.R3.setStrokeWidth(f2);
      paramInt3 = this.y;
      paramInt1 = this.c;
      paramInt2 = this.X3;
      this.q = ((float)(paramInt3 * (paramInt1 - paramInt2 * 2) * 1.0D / this.x) + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = View.MeasureSpec.getSize(paramInt1);
    this.d = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = this.d;
    int j = this.X3;
    int k = this.f;
    if (paramInt2 < j * 2 + k) {
      this.d = (j * 2 + k);
    }
    if (paramInt1 == Integer.MIN_VALUE) {
      this.c = a(getContext(), 200.0F);
    }
    if (i == Integer.MIN_VALUE) {
      this.d = (this.X3 * 2 + this.f);
    }
    setMeasuredDimension(this.c, this.d);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.q = paramMotionEvent.getX();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3) {
            break label62;
          }
        }
      }
      else
      {
        setPressed(false);
        break label62;
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      setPressed(true);
    }
    invalidate();
    label62:
    return true;
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.x = paramInt;
    this.L3 = ((int)(paramInt * this.M3));
  }
  
  public void setProgress(int paramInt)
  {
    if ((!isPressed()) && (this.y != paramInt))
    {
      this.y = paramInt;
      int i = this.c;
      int j = this.X3;
      this.q = ((float)(paramInt * (i - j * 2) * 1.0D / this.x) + j);
      invalidate();
    }
  }
  
  public void setSeekbarAttrsChangedListener(a parama)
  {
    this.d4 = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\progressbar\MultiColorSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */