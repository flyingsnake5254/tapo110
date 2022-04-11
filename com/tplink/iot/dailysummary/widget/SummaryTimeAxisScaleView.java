package com.tplink.iot.dailysummary.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;
import com.tplink.iot.dailysummary.model.c;
import com.tplink.iot.e.a.e;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SummaryTimeAxisScaleView
  extends View
{
  public static final a c = new a(null);
  private long H3;
  private int I3;
  private int J3;
  private int K3;
  private Paint L3;
  private Paint M3;
  private Paint N3;
  private Paint O3;
  private Paint P3;
  private Paint Q3;
  private Rect R3;
  private Rect S3;
  private Rect T3;
  private b U3;
  private LinkedList<c> V3 = new LinkedList();
  private ArrayList<Long> W3 = new ArrayList();
  private boolean X3;
  private long Y3;
  private int Z3;
  private int a4;
  private int d;
  private int f;
  private int p0;
  private int p1;
  private int p2;
  private int p3;
  private int q;
  private int x;
  private float y;
  private int z;
  
  public SummaryTimeAxisScaleView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public SummaryTimeAxisScaleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public SummaryTimeAxisScaleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, b.TimeAxisScaleView);
    j.d(localTypedArray, "context.obtainStyledAttr…leable.TimeAxisScaleView)");
    this.I3 = localTypedArray.getColor(15, ContextCompat.getColor(paramContext, 2131099688));
    this.J3 = localTypedArray.getColor(17, ContextCompat.getColor(paramContext, 2131099736));
    this.K3 = ContextCompat.getColor(paramContext, 2131100206);
    Paint localPaint = new Paint();
    localPaint.setColor(this.I3);
    paramAttributeSet = e.a;
    localPaint.setStrokeWidth(paramAttributeSet.a(1, paramContext));
    Object localObject = p.a;
    this.L3 = localPaint;
    paramInt = localTypedArray.getColor(19, ContextCompat.getColor(paramContext, 2131099729));
    this.p3 = localTypedArray.getDimensionPixelOffset(21, paramAttributeSet.a(9, paramContext));
    localObject = new Paint();
    ((Paint)localObject).setColor(paramInt);
    ((Paint)localObject).setTextSize(this.p3);
    ((Paint)localObject).setAntiAlias(true);
    this.N3 = ((Paint)localObject);
    localObject = new Paint();
    ((Paint)localObject).setColor(ContextCompat.getColor(paramContext, 2131100206));
    ((Paint)localObject).setTextSize(this.p3);
    ((Paint)localObject).setAntiAlias(true);
    this.O3 = ((Paint)localObject);
    this.p1 = localTypedArray.getDimensionPixelOffset(20, paramAttributeSet.a(2, paramContext));
    this.y = (this.N3.getFontMetrics().descent - this.N3.getFontMetrics().ascent);
    localObject = new Paint();
    ((Paint)localObject).setColor(ContextCompat.getColor(paramContext, 2131099680));
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    this.P3 = ((Paint)localObject);
    localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    this.Q3 = ((Paint)localObject);
    localObject = new Paint();
    ((Paint)localObject).setColor(ContextCompat.getColor(paramContext, 2131099808));
    ((Paint)localObject).setStrokeWidth(paramAttributeSet.a(2, paramContext));
    this.M3 = ((Paint)localObject);
    this.f = paramAttributeSet.a(50, paramContext);
    this.x = paramAttributeSet.a(20, paramContext);
    this.z = paramAttributeSet.a(12, paramContext);
    this.p0 = paramAttributeSet.a(100, paramContext);
    this.R3 = new Rect();
    this.S3 = new Rect();
    this.T3 = new Rect();
    localTypedArray.recycle();
  }
  
  private final int a(int paramInt)
  {
    if (paramInt % 5 == 0) {
      paramInt = 12;
    } else {
      paramInt = 6;
    }
    e locale = e.a;
    Context localContext = getContext();
    j.d(localContext, "context");
    return locale.a(paramInt, localContext);
  }
  
  private final boolean d(Context paramContext)
  {
    paramContext = paramContext.getResources();
    j.d(paramContext, "context.resources");
    boolean bool;
    if (paramContext.getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final long b(int paramInt)
  {
    long l = (paramInt / this.x * 'Ϩ');
    return Math.min(this.H3, Math.max(0L, l));
  }
  
  public final int c(long paramLong)
  {
    int i = (int)((float)paramLong / 'Ϩ' * this.x);
    return Math.min(this.q, Math.max(0, i));
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    if ((paramBoolean) || (this.X3))
    {
      this.X3 = paramBoolean;
      this.Y3 = paramLong;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    paramCanvas.save();
    int i = getPaddingTop();
    int j = getPaddingLeft() + this.p2;
    int k = getLeft();
    int m = this.x;
    long l1 = this.H3;
    long l2 = 'Ϩ';
    int n = k + j + m * (int)(l1 / l2);
    m = this.z + i + this.p1;
    float f1 = m;
    float f2 = this.y;
    f1 += 0.6F * f2;
    k = m + (int)f2;
    int i1 = this.d;
    m = this.p0;
    float f3 = m / (i1 - k);
    f2 = m / (i1 - i);
    m = Math.min(this.W3.size() - 1, this.V3.size() - 1);
    Object localObject1 = e.a;
    Object localObject2 = getContext();
    j.d(localObject2, "context");
    int i2 = ((e)localObject1).a(1, (Context)localObject2);
    int i3;
    float f4;
    int i4;
    if (this.V3.size() > 0)
    {
      localObject2 = ((c)this.V3.get(0)).a();
      if ((!((Bitmap)localObject2).isRecycled()) && ((((Bitmap)localObject2).getWidth() != this.Z3) || (((Bitmap)localObject2).getHeight() != this.a4)))
      {
        this.Z3 = ((Bitmap)localObject2).getWidth();
        this.a4 = ((Bitmap)localObject2).getHeight();
      }
      i3 = this.Z3;
      f4 = i3;
      i4 = this.a4;
      f4 /= i4;
      if (f2 > f4) {
        this.T3.set(0, 0, i3, (int)(i3 / f2));
      } else {
        this.T3.set(0, 0, (int)(i4 * f2), i4);
      }
      if (f3 > f4)
      {
        localObject2 = this.S3;
        i3 = this.Z3;
        ((Rect)localObject2).set(0, 0, i3, (int)(i3 / f3));
      }
      else
      {
        localObject2 = this.S3;
        i3 = this.a4;
        ((Rect)localObject2).set(0, 0, (int)(i3 * f3), i3);
      }
      localObject2 = p.a;
    }
    localObject2 = getContext();
    j.d(localObject2, "context");
    boolean bool = d((Context)localObject2);
    localObject1 = "mClipSplitPointList[index + 1]";
    localObject2 = "mClipSplitPointList[index]";
    Object localObject3;
    int i5;
    label950:
    float f6;
    if (bool)
    {
      if (m >= 0) {
        for (k = 0;; k++)
        {
          localObject1 = this.W3.get(k);
          j.d(localObject1, (String)localObject2);
          l1 = ((Number)localObject1).longValue();
          f2 = j;
          i4 = (int)(this.x * ((float)l1 / 1000.0F) + f2);
          i3 = this.p0 + i4;
          localObject1 = ((c)this.V3.get(k)).a();
          if (!((Bitmap)localObject1).isRecycled())
          {
            this.R3.set(i4, i, i3, i1);
            if (i3 > n) {
              paramCanvas.clipRect(i4, i, n, i1);
            }
            paramCanvas.drawBitmap((Bitmap)localObject1, this.T3, this.R3, this.Q3);
            if (k < this.W3.size() - 1)
            {
              l1 = this.x;
              localObject3 = this.W3.get(k + 1);
              j.d(localObject3, "mClipSplitPointList[index + 1]");
              i5 = (int)(f2 + (float)(l1 * ((Number)localObject3).longValue()) / 1000.0F);
              while (i3 < i5)
              {
                i4 = this.p0 + i3;
                this.R3.set(i3, i, i4, i1);
                if (i4 > n) {
                  paramCanvas.clipRect(i3, i, n, i1);
                }
                paramCanvas.drawBitmap((Bitmap)localObject1, this.T3, this.R3, this.Q3);
                i3 = i4;
              }
            }
          }
          l1 = l2;
          if (k == m) {
            break;
          }
        }
      }
      l1 = l2;
      paramCanvas.restore();
      f2 = i;
      f3 = getWidth();
      f4 = getHeight();
      localObject2 = this.P3;
      i3 = 0;
      paramCanvas.drawRect(0.0F, f2, f3, f4, (Paint)localObject2);
      if (this.X3)
      {
        k = this.W3.size() - 1;
        if (1 <= k) {
          for (m = 1;; m++)
          {
            if (((Number)this.W3.get(m)).longValue() > this.Y3)
            {
              f3 = j;
              k = (int)(this.x * (((Number)this.W3.get(m - 1)).floatValue() / 1000.0F) + f3);
              m = Math.min(n, (int)(f3 + this.x * (((Number)this.W3.get(m)).floatValue() / 1000.0F)));
              break label950;
            }
            if (m == k) {
              break;
            }
          }
        }
        k = 0;
        m = 0;
        f3 = k + i2;
        f4 = i1;
        paramCanvas.drawLine(f3, f2, f3, f4, this.M3);
        f3 = k;
        float f5 = i1 - i2;
        f6 = m;
        paramCanvas.drawLine(f3, f5, f6, f5, this.M3);
        f5 = m - i2;
        paramCanvas.drawLine(f5, f2, f5, f4, this.M3);
        f4 = i + i2;
        paramCanvas.drawLine(f3, f4, f6, f4, this.M3);
      }
      this.L3.setColor(this.K3);
      k = (int)(this.H3 / l1);
      if (k >= 0) {
        for (m = i3;; m++)
        {
          i1 = a(m);
          f3 = j + this.x * m;
          paramCanvas.drawLine(f3, f2, f3, f2 + i1, this.L3);
          if (m % 5 == 0)
          {
            localObject2 = e.a.b(m);
            paramCanvas.drawText((String)localObject2, f3 - this.N3.measureText((String)localObject2) / 2, f1, this.O3);
          }
          if (m == k) {
            break;
          }
        }
      }
    }
    else
    {
      localObject2 = "mClipSplitPointList[index]";
      int i6 = (int)(this.H3 / l2);
      int i7;
      if (i6 >= 0)
      {
        i7 = 0;
        for (;;)
        {
          i4 = a(i7);
          f3 = j + this.x * i7;
          i5 = i7 % 5;
          if (i5 == 0) {
            f2 = 0.0F;
          } else {
            f2 = i4 * 0.3F;
          }
          f2 = i + f2;
          localObject3 = this.L3;
          if (i5 == 0) {
            i3 = this.I3;
          } else {
            i3 = this.J3;
          }
          ((Paint)localObject3).setColor(i3);
          f4 = i4;
          localObject3 = this.L3;
          i3 = i1;
          i4 = m;
          paramCanvas.drawLine(f3, f2, f3, f2 + f4, (Paint)localObject3);
          if (i5 == 0)
          {
            localObject3 = e.a.b(i7);
            paramCanvas.drawText((String)localObject3, f3 - this.N3.measureText((String)localObject3) / 2, f1, this.N3);
          }
          localObject4 = localObject2;
          localObject3 = localObject1;
          i5 = i4;
          m = n;
          i1 = i3;
          if (i7 == i6) {
            break;
          }
          i7++;
          m = i4;
          i1 = i3;
        }
      }
      localObject3 = "mClipSplitPointList[index + 1]";
      i5 = m;
      m = n;
      Object localObject4 = localObject2;
      if (i5 >= 0) {
        for (n = 0;; n++)
        {
          localObject2 = this.W3.get(n);
          j.d(localObject2, (String)localObject4);
          l2 = ((Number)localObject2).longValue();
          f1 = j;
          i6 = (int)(this.x * ((float)l2 / 1000.0F) + f1);
          i3 = this.p0 + i6;
          localObject2 = ((c)this.V3.get(n)).a();
          if (!((Bitmap)localObject2).isRecycled())
          {
            localObject1 = this.R3;
            i4 = k;
            i = i1;
            ((Rect)localObject1).set(i6, i4, i3, i);
            i7 = m;
            if (i3 > i7) {
              paramCanvas.clipRect(i6, i4, i7, i);
            }
            paramCanvas.drawBitmap((Bitmap)localObject2, this.S3, this.R3, this.Q3);
            if (n < this.W3.size() - 1)
            {
              l2 = this.x;
              localObject1 = this.W3.get(n + 1);
              j.d(localObject1, (String)localObject3);
              int i8 = (int)(f1 + (float)(l2 * ((Number)localObject1).longValue()) / 1000.0F);
              while (i3 < i8)
              {
                i6 = this.p0 + i3;
                this.R3.set(i3, i4, i6, i);
                if (i6 > i7) {
                  paramCanvas.clipRect(i3, i4, i7, i);
                }
                paramCanvas.drawBitmap((Bitmap)localObject2, this.S3, this.R3, this.Q3);
                i3 = i6;
              }
            }
          }
          i = m;
          i4 = k;
          i3 = i1;
          if (n == i5) {
            break;
          }
        }
      }
      i3 = i1;
      i4 = k;
      i = m;
      paramCanvas.restore();
      if (this.X3)
      {
        k = this.W3.size();
        m = 1;
        k--;
        if (1 <= k) {
          for (;;)
          {
            if (((Number)this.W3.get(m)).longValue() > this.Y3)
            {
              f1 = j;
              k = (int)(this.x * (((Number)this.W3.get(m - 1)).floatValue() / 1000.0F) + f1);
              i1 = Math.min(i, (int)(f1 + this.x * (((Number)this.W3.get(m)).floatValue() / 1000.0F)));
              m = k;
              k = i1;
              break label1933;
            }
            if (m == k) {
              break;
            }
            m++;
          }
        }
        m = 0;
        k = 0;
        label1933:
        f1 = m + i2;
        f4 = i4;
        f3 = i3;
        paramCanvas.drawLine(f1, f4, f1, f3, this.M3);
        f2 = m;
        f6 = i3 - i2;
        f1 = k;
        paramCanvas.drawLine(f2, f6, f1, f6, this.M3);
        f6 = k - i2;
        paramCanvas.drawLine(f6, f4, f6, f3, this.M3);
        f3 = i4 + i2;
        paramCanvas.drawLine(f2, f3, f1, f3, this.M3);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = this.U3;
    if (localb != null) {
      localb.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
      paramInt1 = this.f;
    } else {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
    }
    this.d = paramInt1;
    setMeasuredDimension((int)(this.H3 / 'Ϩ') * this.x + this.p2 * 2, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.q = (paramInt1 - this.p2 * 2);
  }
  
  public final void setBlankWidth(int paramInt)
  {
    this.p2 = paramInt;
  }
  
  public final void setClipSplitPointList(ArrayList<Long> paramArrayList)
  {
    j.e(paramArrayList, "splitPointList");
    this.W3 = paramArrayList;
  }
  
  public final void setScaleViewListener(b paramb)
  {
    this.U3 = paramb;
  }
  
  public final void setSummaryDuration(long paramLong)
  {
    this.H3 = paramLong;
    requestLayout();
  }
  
  public final void setThumbnailList(LinkedList<c> paramLinkedList)
  {
    j.e(paramLinkedList, "thumbnailList");
    if ((paramLinkedList.size() == 0) || (!((c)paramLinkedList.get(0)).a().isRecycled()))
    {
      this.V3 = paramLinkedList;
      invalidate();
    }
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\widget\SummaryTimeAxisScaleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */