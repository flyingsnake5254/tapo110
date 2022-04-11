package com.tplink.iot.devices.lightstrip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ColorPaintingSegmentView
  extends View
{
  private float H3;
  private final List<a> I3 = new ArrayList();
  private final List<Integer> J3;
  private kotlin.jvm.b.p<? super Integer, ? super Integer, kotlin.p> K3;
  private final int L3;
  private final Paint M3;
  private final Path N3;
  private final float O3;
  private final Paint P3;
  @ColorInt
  private int c = -1;
  private final float d = e(300);
  private float f;
  private int p0 = 1;
  private float p1;
  private float p2;
  private float p3;
  private float q;
  private float x;
  private float y;
  private int z = 10;
  
  public ColorPaintingSegmentView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public ColorPaintingSegmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public ColorPaintingSegmentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ArrayList localArrayList = new ArrayList();
    this.J3 = localArrayList;
    this.L3 = -1;
    this.M3 = new Paint(1);
    this.N3 = new Path();
    float f1 = e(2);
    this.O3 = f1;
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(f1);
    localPaint.setColor(1721342361);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint.setStrokeJoin(Paint.Join.ROUND);
    localPaint.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[] { 6.0F, 10.0F }, 0.0F), new CornerPathEffect(e(12))));
    kotlin.p localp = kotlin.p.a;
    this.P3 = localPaint;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ColorPaintingSegmentView);
    this.z = Math.max(1, paramContext.getInt(1, 10));
    this.p0 = Math.max(1, paramContext.getInt(4, 1));
    f1 = e(30);
    paramInt = 0;
    this.y = paramContext.getDimension(0, f1);
    this.p1 = paramContext.getDimension(2, e(2));
    this.p2 = paramContext.getDimension(3, e(28));
    boolean bool = paramContext.hasValue(4);
    paramContext.recycle();
    if (bool)
    {
      int i = this.p0 * this.z;
      paramContext = new ArrayList(i);
      while (paramInt < i)
      {
        paramContext.add(Integer.valueOf(this.L3));
        paramInt++;
      }
      localArrayList.addAll(paramContext);
      h();
    }
  }
  
  private final RectF b(int paramInt1, int paramInt2)
  {
    float f1 = (this.x + this.p1) * paramInt2 + this.p3;
    float f2 = (this.y + this.p2) * paramInt1 + this.H3;
    return new RectF(f1, f2, this.x + f1, this.y + f2);
  }
  
  private final int c(int paramInt1, int paramInt2)
  {
    return paramInt1 * this.z + paramInt2;
  }
  
  private final float e(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final int f(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 1073741824) {
        paramInt1 = paramInt2;
      }
    }
    else {
      paramInt1 = Math.max(paramInt2, paramInt1);
    }
    return paramInt1;
  }
  
  private final void g(int paramInt1, int paramInt2)
  {
    int i = this.J3.size();
    if ((paramInt1 >= 0) && (i > paramInt1)) {
      this.J3.set(paramInt1, Integer.valueOf(paramInt2));
    }
    i = this.I3.size();
    if ((paramInt1 >= 0) && (i > paramInt1)) {
      ((a)this.I3.get(paramInt1)).c(paramInt2);
    }
    Object localObject = this.K3;
    if (localObject != null) {
      localObject = (kotlin.p)((kotlin.jvm.b.p)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
  }
  
  private final void h()
  {
    this.I3.clear();
    Iterator localIterator = this.J3.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        l.k();
      }
      int j = ((Number)localObject).intValue();
      int k = this.z;
      int m = i / k;
      this.I3.add(new a(m, i % k, j));
    }
  }
  
  public final void d(int paramInt)
  {
    this.z = paramInt;
    i(this.J3);
  }
  
  public final List<Integer> getColorList()
  {
    return this.J3;
  }
  
  public final int getPaintingColor()
  {
    return this.c;
  }
  
  public final void i(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    if (paramList.isEmpty()) {
      return;
    }
    this.J3.clear();
    this.J3.addAll(paramList);
    this.p0 = ((int)(float)Math.ceil(this.J3.size() / this.z));
    h();
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    Log.e("TAG", "onDraw: ");
    Object localObject = this.I3.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      this.M3.setColor(locala.a());
      paramCanvas.drawRect(locala.b(), this.M3);
    }
    int i = this.p0;
    if (i > 1)
    {
      int k;
      for (int j = 0; j < i - 1; j = k)
      {
        float f1 = this.f;
        float f2 = this.p3;
        float f3 = this.O3 / 2.0F;
        float f4 = this.y;
        k = j + 1;
        float f5 = k;
        float f6 = this.p2;
        float f7 = j;
        float f8 = this.H3;
        localObject = this.N3;
        ((Path)localObject).reset();
        ((Path)localObject).moveTo(f1 + f2 - f3, f4 * f5 + f6 * f7 + f8);
        ((Path)localObject).rLineTo(0.0F, this.p2 / 2.0F);
        ((Path)localObject).rLineTo(-this.f + this.O3, 0.0F);
        ((Path)localObject).rLineTo(0.0F, this.p2 / 2.0F);
        paramCanvas.drawPath(this.N3, this.P3);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (getWidth() - getPaddingLeft() - getPaddingRight());
    this.q = (getHeight() - getPaddingTop() - getPaddingBottom());
    this.p3 = getPaddingLeft();
    this.H3 = getPaddingTop();
    float f1 = this.f;
    float f2 = this.p1;
    paramInt1 = this.z;
    this.x = ((f1 - f2 * (paramInt1 - 1)) / paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = f((int)this.d, paramInt1);
    float f1 = this.p2;
    paramInt1 = this.p0;
    setMeasuredDimension(paramInt2, (int)(f1 * (paramInt1 - 1) + this.y * paramInt1 + getPaddingTop() + getPaddingBottom()));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    j.e(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = this.p3;
    float f3 = paramMotionEvent.getY();
    float f4 = this.H3;
    int i = (int)(float)Math.floor((f1 - f2) / (this.x + this.p1));
    int j = (int)(float)Math.floor((f3 - f4) / (this.y + this.p2));
    int k = this.z;
    if ((i >= 0) && (k > i) && (b(j, i).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      k = c(j, i);
      j = this.J3.size();
      if ((k >= 0) && (j > k))
      {
        i = ((Number)this.J3.get(k)).intValue();
        j = this.c;
        if (i != j)
        {
          g(k, j);
          invalidate();
        }
      }
    }
    return true;
  }
  
  public final void setOnColorUpdateListener(kotlin.jvm.b.p<? super Integer, ? super Integer, kotlin.p> paramp)
  {
    j.e(paramp, "listener");
    this.K3 = paramp;
  }
  
  public final void setPaintingColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  private final class a
  {
    private RectF a;
    private int b;
    private int c;
    private int d;
    
    public a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      int i;
      this.d = i;
    }
    
    public final int a()
    {
      return this.d;
    }
    
    public final RectF b()
    {
      RectF localRectF = this.a;
      if (localRectF == null)
      {
        localRectF = ColorPaintingSegmentView.a(ColorPaintingSegmentView.this, this.b, this.c);
        this.a = localRectF;
      }
      return localRectF;
    }
    
    public final void c(int paramInt)
    {
      this.d = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\ColorPaintingSegmentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */