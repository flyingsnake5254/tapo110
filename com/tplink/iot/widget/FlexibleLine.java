package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tplink.libtpnetwork.cameranetwork.util.e;

public class FlexibleLine
  extends View
{
  private a H3;
  private int I3;
  private int J3;
  private int K3;
  private int L3;
  private int M3;
  private int N3;
  private int O3;
  private int P3;
  private int Q3;
  private double R3;
  private int S3;
  private Bitmap T3;
  private Bitmap U3;
  private Bitmap V3;
  private Paint W3;
  private Paint X3;
  private Paint Y3;
  private int c;
  private int d;
  private int f;
  private boolean p0;
  private Point p1;
  private Point p2;
  private Context p3;
  private int q;
  private int x;
  private int y;
  private boolean z;
  
  public FlexibleLine(Context paramContext)
  {
    super(paramContext);
    this.p3 = paramContext;
    j();
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX() - this.c;
    int j = (int)paramMotionEvent.getRawY() - this.d;
    int k = this.I3;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k == 3)
        {
          g(i, j);
          l(this.p1, paramMotionEvent);
        }
      }
      else {
        h(this, i, j);
      }
    }
    else
    {
      f(i, j);
      l(this.p2, paramMotionEvent);
    }
    this.c = ((int)paramMotionEvent.getRawX());
    this.d = ((int)paramMotionEvent.getRawY());
    invalidate();
  }
  
  private double b(Point paramPoint1, Point paramPoint2)
  {
    return Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
  }
  
  private double d(Point paramPoint1, Point paramPoint2)
  {
    return Math.atan2(paramPoint2.y - paramPoint1.y, paramPoint2.x - paramPoint1.x) * 180.0D / 3.141592653589793D;
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    Point localPoint = this.p1;
    int j;
    if (b(new Point(localPoint.x + paramInt1, localPoint.y), this.p2) >= this.K3)
    {
      i = this.f;
      j = this.p1.x;
      int k = ((ViewGroup)getParent()).getWidth();
      m = this.S3;
      if (i + j + paramInt1 > k - m)
      {
        this.p1.x = (((ViewGroup)getParent()).getWidth() - this.S3 - paramInt1 - this.f);
      }
      else
      {
        j = this.f;
        localPoint = this.p1;
        i = localPoint.x;
        if (j + i + paramInt1 < m) {
          localPoint.x = (m - paramInt1 - j);
        } else {
          localPoint.x = (i + paramInt1);
        }
      }
    }
    localPoint = this.p1;
    if (b(new Point(localPoint.x, localPoint.y + paramInt2), this.p2) >= this.K3)
    {
      i = this.x;
      j = this.p1.y;
      m = ((ViewGroup)getParent()).getHeight();
      paramInt1 = this.S3;
      if (i + j + paramInt2 > m - paramInt1)
      {
        this.p1.y = (((ViewGroup)getParent()).getHeight() - this.S3 - paramInt2 - this.x);
      }
      else
      {
        m = this.x;
        localPoint = this.p1;
        i = localPoint.y;
        if (m + i + paramInt2 < paramInt1) {
          localPoint.y = (paramInt1 - paramInt2 - m);
        } else {
          localPoint.y = (i + paramInt2);
        }
      }
    }
    int m = this.f;
    localPoint = this.p1;
    int i = localPoint.x;
    paramInt2 = this.x;
    paramInt1 = localPoint.y;
    localPoint = this.p2;
    m(i + m, paramInt1 + paramInt2, m + localPoint.x, paramInt2 + localPoint.y);
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    Point localPoint1 = this.p1;
    Point localPoint2 = this.p2;
    int k;
    if (b(localPoint1, new Point(localPoint2.x + paramInt1, localPoint2.y)) >= this.K3)
    {
      i = this.f;
      int j = this.p2.x;
      k = ((ViewGroup)getParent()).getWidth();
      m = this.S3;
      if (i + j + paramInt1 > k - m)
      {
        this.p2.x = (((ViewGroup)getParent()).getWidth() - this.S3 - paramInt1 - this.f);
      }
      else
      {
        i = this.f;
        localPoint2 = this.p2;
        k = localPoint2.x;
        if (i + k + paramInt1 < m) {
          localPoint2.x = (m - paramInt1 - i);
        } else {
          localPoint2.x = (k + paramInt1);
        }
      }
    }
    localPoint1 = this.p1;
    localPoint2 = this.p2;
    if (b(localPoint1, new Point(localPoint2.x, localPoint2.y + paramInt2)) >= this.K3)
    {
      i = this.x;
      m = this.p2.y;
      k = ((ViewGroup)getParent()).getHeight();
      paramInt1 = this.S3;
      if (i + m + paramInt2 > k - paramInt1)
      {
        this.p2.y = (((ViewGroup)getParent()).getHeight() - this.S3 - paramInt2 - this.x);
      }
      else
      {
        i = this.x;
        localPoint2 = this.p2;
        m = localPoint2.y;
        if (i + m + paramInt2 < paramInt1) {
          localPoint2.y = (paramInt1 - paramInt2 - i);
        } else {
          localPoint2.y = (m + paramInt2);
        }
      }
    }
    paramInt2 = this.f;
    localPoint2 = this.p1;
    int m = localPoint2.x;
    int i = this.x;
    paramInt1 = localPoint2.y;
    localPoint2 = this.p2;
    m(m + paramInt2, paramInt1 + i, paramInt2 + localPoint2.x, i + localPoint2.y);
  }
  
  private void h(View paramView, int paramInt1, int paramInt2)
  {
    this.f = (paramView.getLeft() + paramInt1);
    this.x = (paramView.getTop() + paramInt2);
    this.q = (paramView.getRight() + paramInt1);
    this.y = (paramView.getBottom() + paramInt2);
    if (this.f < 0)
    {
      this.f = 0;
      this.q = (paramView.getWidth() + 0);
    }
    if (this.q > ((ViewGroup)getParent()).getWidth())
    {
      paramInt1 = ((ViewGroup)getParent()).getWidth();
      this.q = paramInt1;
      this.f = (paramInt1 - paramView.getWidth());
    }
    if (this.x < 0)
    {
      this.x = 0;
      this.y = (0 + paramView.getHeight());
    }
    if (this.y > ((ViewGroup)getParent()).getHeight())
    {
      paramInt1 = ((ViewGroup)getParent()).getHeight();
      this.y = paramInt1;
      this.x = (paramInt1 - paramView.getHeight());
    }
    paramView.layout(this.f, this.x, this.q, this.y);
    invalidate();
  }
  
  private int i(View paramView, int paramInt1, int paramInt2)
  {
    if ((Math.abs(paramInt1 - this.p1.x) <= this.S3) && (Math.abs(paramInt2 - this.p1.y) <= this.S3)) {
      return 1;
    }
    if ((Math.abs(paramInt1 - this.p2.x) <= this.S3) && (Math.abs(paramInt2 - this.p2.y) <= this.S3)) {
      return 3;
    }
    if (c(this.p1, this.p2, paramInt1, paramInt2) <= this.V3.getHeight() / 2) {
      return 2;
    }
    return 0;
  }
  
  private void j()
  {
    setWillNotDraw(false);
    setClickable(true);
    setBackgroundColor(getResources().getColor(2131100200));
    int i = e.a(2, getContext());
    setLayerType(1, null);
    this.T3 = BitmapFactory.decodeResource(getResources(), 2131690246);
    this.U3 = BitmapFactory.decodeResource(getResources(), 2131690247);
    this.S3 = (this.T3.getWidth() / 2);
    this.J3 = 2;
    this.I3 = 0;
    setArrowBitmap(2);
    Paint localPaint = new Paint(4);
    this.W3 = localPaint;
    localPaint.setAntiAlias(true);
    localPaint = new Paint(4);
    this.X3 = localPaint;
    localPaint.setAntiAlias(true);
    localPaint = new Paint(4);
    this.Y3 = localPaint;
    localPaint.setShadowLayer(i, 0.0F, 0.0F, getResources().getColor(2131099688));
    this.Y3.setColor(getResources().getColor(2131100206));
    this.Y3.setStrokeWidth(e.a(2, this.p3));
    this.Y3.setAntiAlias(true);
    i = this.T3.getWidth() + this.V3.getWidth();
    this.K3 = i;
    this.L3 = (i + this.S3 * 2);
    setWidth(e.a(97, this.p3));
    this.O3 = Math.max(this.V3.getHeight(), this.T3.getHeight());
    this.P3 = e.a(4, getContext());
    this.Q3 = e.a(8, getContext());
    this.p1 = new Point();
    this.p2 = new Point();
    this.p1.set(this.S3, this.O3 / 2);
    this.p2.set(this.N3 - this.S3, this.O3 / 2);
    int j = e.c(getContext())[0];
    i = e.c(getContext())[1];
    m(j / 4, i / 3, j * 3 / 4, i * 2 / 3);
    this.z = false;
    this.p0 = false;
  }
  
  private void l(Point paramPoint, MotionEvent paramMotionEvent)
  {
    if (b(paramPoint, new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) > this.K3) {
      k(false);
    } else {
      k(true);
    }
  }
  
  protected double c(Point paramPoint1, Point paramPoint2, int paramInt1, int paramInt2)
  {
    int i = paramPoint2.x;
    int j = paramPoint1.x;
    if (i != j)
    {
      int k = paramPoint2.y;
      int m = paramPoint1.y;
      double d1 = (k - m) / (i - j);
      double d2 = m;
      double d3 = j;
      return Math.abs(paramInt1 * d1 + (d2 - d3 * d1) - paramInt2) / Math.sqrt(Math.pow(d1, 2.0D) + 1.0D);
    }
    return Math.abs(paramInt1 - j);
  }
  
  protected int e(float paramFloat, int paramInt)
  {
    int i = this.S3;
    return Math.min(paramInt - i, Math.max(i, (int)paramFloat));
  }
  
  public int getAnchorRadius()
  {
    return this.S3;
  }
  
  public int getArrowDirection()
  {
    return this.J3;
  }
  
  public int getLastBottom()
  {
    return this.y;
  }
  
  public int getLastLeft()
  {
    return this.f;
  }
  
  public int getLastRight()
  {
    return this.q;
  }
  
  public int getLastTop()
  {
    return this.x;
  }
  
  public int getX1ForDevice()
  {
    return (int)((this.f + this.p1.x) * 10000.0F / ((ViewGroup)getParent()).getWidth());
  }
  
  public int getX2ForDevice()
  {
    return (int)((this.f + this.p2.x) * 10000.0F / ((ViewGroup)getParent()).getWidth());
  }
  
  public int getY1ForDevice()
  {
    return (int)((this.x + this.p1.y) * 10000.0F / ((ViewGroup)getParent()).getHeight());
  }
  
  public int getY2ForDevice()
  {
    return (int)((this.x + this.p2.y) * 10000.0F / ((ViewGroup)getParent()).getHeight());
  }
  
  public void k(boolean paramBoolean)
  {
    a locala = this.H3;
    if (locala != null) {
      locala.b0(paramBoolean);
    }
  }
  
  public void m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.S3;
    this.f = Math.min(paramInt1 - i, paramInt3 - i);
    i = this.S3;
    this.x = Math.min(paramInt2 - i, paramInt4 - i);
    i = this.S3;
    this.q = Math.max(paramInt1 + i, i + paramInt3);
    i = this.S3;
    this.y = Math.max(paramInt2 + i, i + paramInt4);
    this.p1.set(paramInt1 - this.f, paramInt2 - this.x);
    this.p2.set(paramInt3 - this.f, paramInt4 - this.x);
    setWidth(this.q - this.f);
    setHeight(this.y - this.x);
    layout(this.f, this.x, this.q, this.y);
    o();
  }
  
  public void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt6 / 3;
    this.K3 = i;
    this.L3 = (i + this.S3 * 2);
    float f1 = paramInt1 / 10000.0F;
    float f2 = paramInt5;
    paramInt1 = e(f1 * f2, paramInt5);
    float f3 = paramInt2 / 10000.0F;
    f1 = paramInt6;
    m(paramInt1, e(f3 * f1, paramInt6), e(paramInt3 / 10000.0F * f2, paramInt5), e(paramInt4 / 10000.0F * f1, paramInt6));
  }
  
  public void o()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i = this.f;
    localLayoutParams.leftMargin = i;
    int j = this.x;
    localLayoutParams.topMargin = j;
    localLayoutParams.width = (this.q - i);
    localLayoutParams.height = (this.y - j);
    setLayoutParams(localLayoutParams);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.M3 = ((int)b(this.p1, this.p2));
    double d1 = (float)d(this.p1, this.p2);
    this.R3 = d1;
    float f1 = (float)d1;
    Object localObject = this.p1;
    paramCanvas.rotate(f1, ((Point)localObject).x, ((Point)localObject).y);
    int k;
    if (this.p0)
    {
      i = this.p1.x;
      f1 = this.S3 + i;
      float f2 = i + this.M3 / 2 - this.V3.getWidth() / 2 - this.P3;
      float f3;
      while (f1 <= f2)
      {
        i = this.P3;
        if ((i + f1 <= f2) && (this.Q3 + f1 + i >= f2))
        {
          f3 = i;
          i = this.p1.y;
          paramCanvas.drawLine(f1 + f3, i, f2, i, this.Y3);
          break;
        }
        int j = this.Q3;
        if (j + f1 + i >= f2) {
          break;
        }
        f3 = i;
        k = this.p1.y;
        paramCanvas.drawLine(f1 + f3, k, j + f1 + i, k, this.Y3);
        f1 = f1 + this.Q3 + this.P3;
      }
      i = this.p1.x;
      k = this.M3;
      f1 = i + k - this.S3;
      f2 = i + k / 2 + this.V3.getWidth() / 2 + this.P3;
      while (f1 >= f2)
      {
        i = this.P3;
        if ((f1 - i >= f2) && (f1 - (this.Q3 + i) <= f2))
        {
          k = this.p1.y;
          paramCanvas.drawLine(f2, k, f1 - i, k, this.Y3);
          break;
        }
        k = this.Q3;
        if (f1 - (k + i) <= f2) {
          break;
        }
        f3 = k + i;
        k = this.p1.y;
        paramCanvas.drawLine(f1 - f3, k, f1 - i, k, this.Y3);
        f1 -= this.Q3 + this.P3;
      }
    }
    localObject = this.p1;
    int i = ((Point)localObject).x;
    paramCanvas.drawLine(i, ((Point)localObject).y, i + this.M3 / 2 - this.V3.getWidth() / 2 - this.P3, this.p1.y, this.Y3);
    f1 = this.p1.x + this.M3 / 2 + this.V3.getWidth() / 2 + this.P3;
    localObject = this.p1;
    i = ((Point)localObject).y;
    paramCanvas.drawLine(f1, i, ((Point)localObject).x + this.M3, i, this.Y3);
    localObject = this.V3;
    paramCanvas.drawBitmap((Bitmap)localObject, this.p1.x + (this.M3 - ((Bitmap)localObject).getWidth()) / 2, this.p1.y - this.V3.getHeight() / 2, this.X3);
    boolean bool = this.p0;
    if (bool) {
      localObject = this.T3;
    } else {
      localObject = this.U3;
    }
    if (bool)
    {
      i = this.p1.x;
      k = this.S3;
    }
    else
    {
      i = this.p1.x;
      k = this.U3.getWidth() / 2;
    }
    f1 = i - k;
    if (this.p0)
    {
      k = this.p1.y;
      i = this.S3;
    }
    else
    {
      k = this.p1.y;
      i = this.U3.getWidth() / 2;
    }
    paramCanvas.drawBitmap((Bitmap)localObject, f1, k - i, this.W3);
    bool = this.p0;
    if (bool) {
      localObject = this.T3;
    } else {
      localObject = this.U3;
    }
    if (bool)
    {
      k = this.p1.x + this.M3;
      i = this.S3;
    }
    else
    {
      k = this.p1.x + this.M3;
      i = this.U3.getWidth() / 2;
    }
    f1 = k - i;
    if (this.p0)
    {
      i = this.p1.y;
      k = this.S3;
    }
    else
    {
      i = this.p1.y;
      k = this.U3.getWidth() / 2;
    }
    paramCanvas.drawBitmap((Bitmap)localObject, f1, i - k, this.W3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.N3, this.O3);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.z) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          a(this, paramMotionEvent);
        }
      }
      else {
        this.I3 = 0;
      }
    }
    else
    {
      this.p0 = true;
      a locala = this.H3;
      if (locala != null) {
        locala.F(this);
      }
      this.c = ((int)paramMotionEvent.getRawX());
      this.d = ((int)paramMotionEvent.getRawY());
      this.I3 = i(this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    this.R3 = d(this.p1, this.p2);
    if (this.I3 == 0) {
      return false;
    }
    invalidate();
    o();
    return true;
  }
  
  public void setActive(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
    invalidate();
  }
  
  protected void setArrowBitmap(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.V3 = BitmapFactory.decodeResource(getResources(), 2131690164);
        }
      }
      else {
        this.V3 = BitmapFactory.decodeResource(getResources(), 2131690162);
      }
    }
    else {
      this.V3 = BitmapFactory.decodeResource(getResources(), 2131690163);
    }
  }
  
  public void setArrowDirection(int paramInt)
  {
    if (paramInt != this.J3)
    {
      this.J3 = paramInt;
      setArrowBitmap(paramInt);
      invalidate();
    }
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.z = paramBoolean;
    invalidate();
  }
  
  public void setHeight(int paramInt)
  {
    this.O3 = paramInt;
  }
  
  public void setOnLineSelectListener(a parama)
  {
    a locala = this.H3;
    if ((locala == null) || (locala != parama)) {
      this.H3 = parama;
    }
  }
  
  public void setWidth(int paramInt)
  {
    this.N3 = Math.max(paramInt, this.L3);
  }
  
  public static abstract interface a
  {
    public abstract void F(FlexibleLine paramFlexibleLine);
    
    public abstract void b0(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\FlexibleLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */