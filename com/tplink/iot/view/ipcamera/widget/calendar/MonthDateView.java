package com.tplink.iot.view.ipcamera.widget.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class MonthDateView
  extends View
{
  private int H3;
  private int I3;
  private int J3 = 0;
  private int K3;
  private int L3;
  private int M3;
  private List<Integer> N3;
  private DisplayMetrics O3;
  private int P3;
  private int Q3;
  private int R3;
  private int S3;
  private int T3;
  private boolean U3;
  private boolean V3;
  private int W3;
  private int X3;
  private int Y3;
  private int Z3;
  private Calendar a4;
  private boolean b4;
  private final String c = "MonthDateView";
  private b c4;
  private final int d = 7;
  private GestureDetector d4;
  private a e4;
  private final int f = 6;
  private boolean f4 = false;
  private boolean g4 = true;
  private int p0;
  private int p1;
  private int p2;
  private int p3;
  private Paint q;
  private int x;
  private int y;
  private int z;
  
  public MonthDateView(Context paramContext)
  {
    super(paramContext);
    f(paramContext, null);
  }
  
  public MonthDateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f(paramContext, paramAttributeSet);
  }
  
  public MonthDateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f(paramContext, paramAttributeSet);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i = d(this.K3, this.L3);
    int j = c(this.K3, this.L3, 1);
    int k = j;
    if (j == 7) {
      k = 0;
    }
    paramInt1 = paramInt1 * 7 + paramInt2 - k + 1;
    if ((paramInt1 > 0) && (paramInt1 < i + 1)) {
      return paramInt1;
    }
    return -1;
  }
  
  public static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, paramInt3);
    paramInt1 = localCalendar.get(7);
    if (paramInt1 == 1) {
      return 7;
    }
    return paramInt1 - 1;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, 1);
    localCalendar.roll(5, -1);
    return localCalendar.getActualMaximum(5);
  }
  
  private boolean e(int paramInt)
  {
    if (this.b4)
    {
      List localList = this.N3;
      return (localList != null) && (localList.contains(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  private void f(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.q = new Paint();
    this.O3 = getResources().getDisplayMetrics();
    g(paramContext, paramAttributeSet);
    l();
    h();
    j();
    i();
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.MonthDateView);
      this.x = paramAttributeSet.getColor(0, ContextCompat.getColor(paramContext, 2131100106));
      this.z = paramAttributeSet.getColor(2, ContextCompat.getColor(paramContext, 2131100107));
      this.b4 = paramAttributeSet.getBoolean(3, false);
      this.f4 = paramAttributeSet.getBoolean(1, false);
      paramAttributeSet.recycle();
    }
    else
    {
      this.x = ContextCompat.getColor(paramContext, 2131100106);
      this.z = ContextCompat.getColor(paramContext, 2131100107);
      this.b4 = false;
    }
  }
  
  private void h()
  {
    Calendar localCalendar = this.a4;
    if (localCalendar != null)
    {
      this.X3 = localCalendar.get(1);
      this.Y3 = this.a4.get(2);
      this.Z3 = this.a4.get(5);
    }
    else
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(System.currentTimeMillis());
      this.X3 = localCalendar.get(1);
      this.Y3 = localCalendar.get(2);
      this.Z3 = localCalendar.get(5);
    }
  }
  
  private void i()
  {
    this.d4 = new GestureDetector(getContext(), new a());
  }
  
  private void j()
  {
    this.p0 = getResources().getColor(2131100140);
    this.p1 = getResources().getColor(2131100108);
    this.p2 = getResources().getColor(2131100108);
    this.y = getResources().getColor(2131100108);
    this.P3 = 16;
    this.Q3 = 1;
    this.R3 = 1;
    this.S3 = -1;
    this.T3 = -1;
    this.M3 = 0;
    this.N3 = new ArrayList();
    this.U3 = false;
    this.V3 = false;
    this.W3 = 0;
    this.p3 = 10;
    this.H3 = 40;
    this.I3 = 40;
  }
  
  private void k(int paramInt1, int paramInt2, int paramInt3, List<Integer> paramList, Paint paramPaint, Canvas paramCanvas, boolean paramBoolean, int paramInt4)
  {
    int i = d(paramInt1, paramInt2);
    int j = c(paramInt1, paramInt2, 1);
    if (j == 7) {
      j = 0;
    }
    Object localObject1 = new Paint();
    ((Paint)localObject1).setStyle(Paint.Style.FILL_AND_STROKE);
    ((Paint)localObject1).setAntiAlias(true);
    int m;
    int n;
    int i1;
    for (int k = 0;; k = n)
    {
      Object localObject2 = paramList;
      m = paramInt3;
      if (k >= i) {
        break;
      }
      Object localObject3 = new StringBuilder();
      n = k + 1;
      ((StringBuilder)localObject3).append(n);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      k += j;
      i1 = k / 7;
      int i2 = k % 7;
      int i3 = (int)paramPaint.measureText((String)localObject3);
      int i4 = this.H3;
      k = this.Q3;
      i3 = (k - i3) / 2 + (i4 + k * i2);
      i4 = (int)(this.R3 / 2 - (paramPaint.ascent() + paramPaint.descent()) / 2.0F);
      k = this.R3 * i1 + i4;
      if (p(paramInt1, paramInt2, n)) {
        paramPaint.setColor(this.x);
      } else {
        paramPaint.setColor(this.z);
      }
      int i5;
      int i6;
      int i7;
      int i8;
      int i9;
      if ((localObject2 != null) && (((List)localObject2).contains(Integer.valueOf(n))) && (m != n))
      {
        paramPaint.setColor(this.y);
        if (this.V3)
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setStyle(Paint.Style.FILL_AND_STROKE);
          ((Paint)localObject2).setAntiAlias(true);
          ((Paint)localObject2).setColor(this.p2);
          i5 = this.H3;
          i6 = this.Q3;
          i7 = i6 / 2;
          i8 = this.R3;
          i9 = (i8 - i4) / 2;
          paramCanvas.drawCircle(i5 + i6 * i2 + i7, i8 * i1 + i4 + i9, this.p3, (Paint)localObject2);
        }
      }
      if (m == n)
      {
        ((Paint)localObject1).setColor(this.p1);
        if (paramInt4 == 1)
        {
          i4 = this.H3;
          m = this.Q3;
          i4 += i2 * m;
          i2 = this.R3;
          i1 *= i2;
          paramCanvas.drawRect(i4, i1, i4 + m, i1 + i2, (Paint)localObject1);
        }
        else if (paramInt4 == 0)
        {
          m = Math.min(this.Q3, this.R3) / 2;
          i7 = this.R3;
          i6 = (i7 - i4) / 2;
          int i10 = this.p3;
          i5 = this.H3;
          i8 = this.Q3;
          i9 = i8 / 2;
          i4 = i7 / 2;
          paramCanvas.drawCircle(i5 + i2 * i8 + i9, i1 * i7 + i4, m - i6 + i10, (Paint)localObject1);
        }
        localObject2 = localObject1;
        ((Paint)localObject2).setStyle(Paint.Style.FILL);
        ((Paint)localObject2).setTextSize(this.O3.scaledDensity * this.P3);
        ((Paint)localObject2).setColor(this.p0);
        paramCanvas.drawText((String)localObject3, i3, k, (Paint)localObject2);
      }
      else
      {
        paramCanvas.drawText((String)localObject3, i3, k, paramPaint);
      }
    }
    paramList = new Paint();
    paramList.setStyle(Paint.Style.FILL);
    paramList.setTextSize(this.O3.scaledDensity * this.P3);
    paramList.setColor(-7829368);
    if (paramBoolean)
    {
      if (paramInt2 == 1) {
        paramInt1 = 31;
      } else {
        paramInt1 = d(paramInt1, paramInt2 - 1);
      }
      for (paramInt2 = 0; paramInt2 < j; paramInt2++)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt2 + paramInt1 - j + 1);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        k = (int)paramList.measureText((String)localObject1);
        paramInt3 = this.H3;
        paramInt4 = this.Q3;
        n = (paramInt4 - k) / 2;
        k = (int)(this.R3 / 2 - (paramPaint.ascent() + paramPaint.descent()) / 2.0F);
        paramCanvas.drawText((String)localObject1, paramInt3 + paramInt4 * paramInt2 + n, k, paramList);
      }
      for (paramInt1 = 0; paramInt1 < 42 - i - j; paramInt1 = paramInt2)
      {
        localObject1 = new StringBuilder();
        paramInt2 = paramInt1 + 1;
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        paramInt3 = paramInt1 + j + i;
        paramInt1 = paramInt3 / 7;
        n = (int)paramPaint.measureText((String)localObject1);
        k = this.H3;
        paramInt4 = this.Q3;
        n = (paramInt4 - n) / 2;
        m = this.R3;
        i1 = (int)(m / 2 - (paramPaint.ascent() + paramPaint.descent()) / 2.0F);
        paramCanvas.drawText((String)localObject1, k + paramInt3 % 7 * paramInt4 + n, paramInt1 * m + i1, paramList);
      }
    }
  }
  
  private void l()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.K3 = localCalendar.get(1);
    this.L3 = (localCalendar.get(2) + 1);
  }
  
  private boolean p(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = this.g4;
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(paramInt1, paramInt2 - 1, paramInt3);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(this.X3, this.Y3, this.Z3);
    if (localCalendar1.getTimeInMillis() > localCalendar2.getTimeInMillis()) {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.f4) {
      for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof ViewPager)) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getMonth()
  {
    return this.L3;
  }
  
  public int getYear()
  {
    return this.K3;
  }
  
  public void m()
  {
    this.M3 = 0;
    invalidate();
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    this.K3 = paramInt1;
    this.L3 = paramInt2;
    this.M3 = 0;
    invalidate();
  }
  
  public void o(Calendar paramCalendar)
  {
    this.X3 = paramCalendar.get(1);
    this.Y3 = paramCalendar.get(2);
    this.Z3 = paramCalendar.get(5);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getHeight();
    this.Q3 = ((getWidth() - this.H3 - this.I3) / 7);
    this.R3 = (i / 6);
    this.q.setStyle(Paint.Style.FILL);
    this.q.setAntiAlias(true);
    this.q.setTextSize(this.O3.scaledDensity * this.P3);
    this.q.setColor(this.x);
    if (this.W3 == 0) {
      k(this.K3, this.L3, this.M3, this.N3, this.q, paramCanvas, this.U3, this.J3);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    View.MeasureSpec.getSize(paramInt2);
    double d1;
    double d2;
    if (i == Integer.MIN_VALUE)
    {
      d1 = paramInt1 / 7 * 6;
      d2 = 0.8D;
    }
    else
    {
      d1 = paramInt1 / 7 * 6;
      d2 = 0.75D;
    }
    setMeasuredDimension(paramInt1, (int)(d1 * d2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.d4.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY() / this.R3;
      this.S3 = j;
      i /= this.Q3;
      this.T3 = i;
      if (i == 7) {
        this.T3 = 6;
      }
      this.W3 = 0;
      j = b(j, this.T3);
      if (j == -1) {
        return true;
      }
      if (!e(j)) {
        return true;
      }
      if (p(this.K3, this.L3, j))
      {
        this.M3 = j;
        invalidate();
        paramMotionEvent = this.c4;
        if (paramMotionEvent != null) {
          paramMotionEvent.g0(this.K3, this.L3 - 1, this.M3);
        }
      }
    }
    return true;
  }
  
  public void setDayColor(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setIgnoreLastDay(boolean paramBoolean)
  {
    this.g4 = paramBoolean;
  }
  
  public void setInterceptTouch(boolean paramBoolean)
  {
    this.f4 = paramBoolean;
  }
  
  public void setLastDay(Calendar paramCalendar)
  {
    this.a4 = paramCalendar;
    h();
  }
  
  public void setMarkedDays(List<Integer> paramList)
  {
    this.N3 = paramList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b.d.w.c.a.e("MonthDateView MONTH_DAY", String.valueOf((Integer)paramList.next()));
      }
    }
    invalidate();
  }
  
  public void setMonthDataFlingListener(a parama)
  {
    this.e4 = parama;
  }
  
  public void setMonthDateClickListener(b paramb)
  {
    this.c4 = paramb;
  }
  
  public void setOnlyMarkClick(boolean paramBoolean)
  {
    this.b4 = paramBoolean;
  }
  
  public void setOutOfDateTextColor(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void setSelectedDayInfo(d paramd)
  {
    this.K3 = paramd.a;
    this.L3 = paramd.b;
    this.M3 = paramd.c;
    invalidate();
  }
  
  class a
    implements GestureDetector.OnGestureListener
  {
    a() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 50.0F)
      {
        b.d.w.c.a.i("MonthDateView", "left...");
        if (MonthDateView.a(MonthDateView.this) != null) {
          MonthDateView.a(MonthDateView.this).a();
        }
        return true;
      }
      if (paramMotionEvent2.getX() - paramMotionEvent1.getX() > 50.0F)
      {
        b.d.w.c.a.i("MonthDateView", "right...");
        if (MonthDateView.a(MonthDateView.this) != null) {
          MonthDateView.a(MonthDateView.this).b();
        }
      }
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\MonthDateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */