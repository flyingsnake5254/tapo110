package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;

public class TimeAxisScaleView
  extends View
{
  private Paint A4;
  private Paint B4;
  private Paint C4;
  private Paint D4;
  private boolean E4;
  private boolean F4;
  private boolean G4 = false;
  private String[] H3;
  private int H4 = 0;
  private int[] I3;
  private int I4 = 0;
  private int[] J3;
  private int[] K3;
  private int L3;
  private int M3;
  private int N3;
  private int O3;
  private int P3;
  private a Q3 = null;
  private float R3;
  private int S3;
  private long T3;
  private boolean U3;
  private int V3;
  private int W3;
  private Paint X3;
  private Paint Y3;
  private Paint Z3;
  private SimpleDateFormat a4;
  private Date b4;
  private final String c = TimeAxisScaleView.class.getSimpleName();
  private int c4;
  private final int d = 1;
  private float d4;
  private int e4;
  private final int f = a.a(4, getContext());
  private float f4;
  private int g4;
  private ArrayList<String> h4;
  private Paint i4;
  private Paint j4;
  private Paint k4;
  private Paint l4;
  private Paint m4;
  private Paint n4;
  private Paint o4;
  private int[] p0;
  private int[] p1;
  private int[] p2;
  private int p3;
  private int p4;
  private final int q = a.b(getContext())[0] - a.a(48, getContext());
  private ArrayList<int[]> q4;
  private ArrayList<int[]> r4;
  private ArrayList<int[]> s4;
  private ArrayList<int[]> t4;
  private ArrayList<int[]> u4;
  private ArrayList<int[]> v4;
  private ArrayList<int[]> w4;
  private final int x = 14;
  private ArrayList<int[]> x4;
  private int[] y;
  private int y4;
  private int[] z;
  private int z4;
  
  public TimeAxisScaleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g(paramContext, paramAttributeSet);
  }
  
  public TimeAxisScaleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g(paramContext, paramAttributeSet);
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, b.TimeAxisScaleView);
    this.y = paramContext.getResources().getIntArray(2130903054);
    this.z = paramContext.getResources().getIntArray(2130903054);
    this.p0 = paramContext.getResources().getIntArray(2130903055);
    this.p1 = paramContext.getResources().getIntArray(2130903056);
    if (a.c(paramContext))
    {
      paramAttributeSet = paramContext.getResources();
      i = 2130903059;
    }
    else
    {
      paramAttributeSet = paramContext.getResources();
      i = 2130903060;
    }
    this.p2 = paramAttributeSet.getIntArray(i);
    if (a.c(paramContext)) {
      i = a.a(4, paramContext);
    } else {
      i = a.a(12, paramContext);
    }
    this.p3 = localTypedArray.getDimensionPixelOffset(7, i);
    this.H3 = paramContext.getResources().getStringArray(2130903053);
    this.I3 = paramContext.getResources().getIntArray(2130903057);
    this.J3 = paramContext.getResources().getIntArray(2130903057);
    this.K3 = paramContext.getResources().getIntArray(2130903058);
    this.R3 = 4.0F;
    this.X3 = new Paint();
    this.V3 = localTypedArray.getColor(15, ContextCompat.getColor(paramContext, 2131099729));
    this.W3 = localTypedArray.getColor(17, ContextCompat.getColor(paramContext, 2131099736));
    this.X3.setColor(this.V3);
    int i = localTypedArray.getDimensionPixelOffset(18, a.a(1, paramContext));
    this.X3.setStrokeWidth(i);
    this.Y3 = new Paint();
    i = localTypedArray.getColor(19, ContextCompat.getColor(paramContext, 2131099729));
    this.Y3.setColor(i);
    i = localTypedArray.getDimensionPixelOffset(21, a.a(9, paramContext));
    this.e4 = i;
    this.Y3.setTextSize(i);
    this.Y3.setAntiAlias(true);
    this.f4 = (this.Y3.getFontMetrics().descent - this.Y3.getFontMetrics().ascent);
    this.a4 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    this.b4 = new Date();
    this.Z3 = new Paint();
    i = localTypedArray.getColor(3, ContextCompat.getColor(paramContext, 2131099729));
    this.Z3.setColor(i);
    i = localTypedArray.getDimensionPixelOffset(4, a.a(14, paramContext));
    this.c4 = i;
    this.Z3.setTextSize(i);
    this.Z3.setAntiAlias(true);
    this.d4 = (this.Z3.getFontMetrics().descent - this.Z3.getFontMetrics().ascent);
    this.y4 = localTypedArray.getDimensionPixelOffset(13, 0);
    this.z4 = localTypedArray.getDimensionPixelOffset(12, 0);
    this.i4 = new Paint();
    i = localTypedArray.getColor(10, ContextCompat.getColor(paramContext, 2131100119));
    this.i4.setColor(i);
    this.j4 = new Paint();
    i = localTypedArray.getColor(8, ContextCompat.getColor(paramContext, 2131100115));
    this.j4.setColor(i);
    this.k4 = new Paint();
    i = localTypedArray.getColor(1, ContextCompat.getColor(paramContext, 2131100111));
    this.k4.setColor(i);
    this.l4 = new Paint();
    i = localTypedArray.getColor(9, ContextCompat.getColor(paramContext, 2131100118));
    this.l4.setColor(i);
    this.m4 = new Paint();
    i = localTypedArray.getColor(0, ContextCompat.getColor(paramContext, 2131100110));
    this.m4.setColor(i);
    this.n4 = new Paint();
    i = localTypedArray.getColor(6, ContextCompat.getColor(paramContext, 2131100116));
    this.n4.setColor(i);
    this.o4 = new Paint();
    i = localTypedArray.getColor(2, ContextCompat.getColor(paramContext, 2131100114));
    this.o4.setColor(i);
    this.g4 = localTypedArray.getDimensionPixelOffset(20, a.a(2, paramContext));
    this.p4 = localTypedArray.getDimensionPixelOffset(11, a.d(56, paramContext));
    i = localTypedArray.getInt(14, 1);
    this.S3 = i;
    if (i > 1) {
      this.N3 = (this.q * i);
    } else {
      this.N3 = a.a(600, paramContext);
    }
    paramAttributeSet = new Paint();
    this.A4 = paramAttributeSet;
    paramAttributeSet.setColor(ContextCompat.getColor(paramContext, 2131100140));
    this.A4.setShadowLayer(a.a(3, paramContext), 0.0F, 0.0F, ContextCompat.getColor(paramContext, 2131100139));
    paramAttributeSet = new Paint();
    this.B4 = paramAttributeSet;
    paramAttributeSet.setColor(ContextCompat.getColor(paramContext, 2131100140));
    this.B4.setShadowLayer(a.a(3, paramContext), 0.0F, 0.0F, ContextCompat.getColor(paramContext, 2131100139));
    paramAttributeSet = new Paint();
    this.C4 = paramAttributeSet;
    paramAttributeSet.setColor(ContextCompat.getColor(paramContext, 2131100140));
    this.C4.setStyle(Paint.Style.FILL);
    paramAttributeSet = new Paint();
    this.D4 = paramAttributeSet;
    paramAttributeSet.setColor(ContextCompat.getColor(paramContext, 2131100112));
    this.D4.setStyle(Paint.Style.FILL);
    this.E4 = true;
    this.F4 = true;
    this.h4 = new ArrayList();
    this.q4 = new ArrayList();
    this.r4 = new ArrayList();
    this.s4 = new ArrayList();
    this.t4 = new ArrayList();
    this.u4 = new ArrayList();
    this.v4 = new ArrayList();
    this.w4 = new ArrayList();
    this.x4 = new ArrayList();
    setZoomRatio(this.R3);
    localTypedArray.recycle();
  }
  
  private int getSuggestedHeight()
  {
    float f1;
    if (this.S3 > 1) {
      f1 = this.Z3.getTextSize() + this.f;
    } else {
      f1 = 0.0F;
    }
    return Math.min(getMinimumHeight(), (int)(this.p4 + this.Y3.getTextSize() + f1 + 0.5D));
  }
  
  private int j(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (i != 0)
    {
      paramInt = j;
      if (i == 1073741824) {
        return paramInt;
      }
    }
    else
    {
      b.d.w.c.a.e(this.c, "UNSPECIFIED! please check axis view height mode!");
    }
    paramInt = Math.min(j, getSuggestedHeight());
    return paramInt;
  }
  
  private int k(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (i != 0)
    {
      paramInt = j;
      if (i != 1073741824) {
        paramInt = Math.min(j, this.N3);
      }
    }
    else
    {
      b.d.w.c.a.e(this.c, "UNSPECIFIED! please check axis view width mode!");
      paramInt = this.N3;
    }
    return (int)(this.R3 * paramInt + 0.5D + this.O3 * 2);
  }
  
  private void m()
  {
    this.h4.clear();
    int i = e(this.R3);
    if (this.G4) {
      j = 25;
    } else {
      j = 24;
    }
    int k = this.S3;
    int m = i - 1;
    int n = j * 60 * k / m;
    int i1 = 0;
    i = 0;
    int j = 0;
    int i3;
    for (int i2 = 0; i1 < m; i2 = i3)
    {
      Formatter localFormatter = new Formatter();
      if (i >= 0) {
        localFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      } else {
        localFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(0), Integer.valueOf(j) });
      }
      this.h4.add(localFormatter.toString());
      localFormatter.close();
      float f1 = i;
      float f2 = n;
      k = (int)(f1 + f2 / 60.0F);
      i3 = (int)(j + f2 % 60.0F);
      i = k;
      j = i3;
      if (i3 >= 60)
      {
        i = k + 1;
        j = i3 - 60;
      }
      k = i;
      i3 = i2;
      if (this.G4)
      {
        k = i;
        i3 = i2;
        if (i2 == 0)
        {
          k = i;
          i3 = i2;
          if (i == this.H4 + 1)
          {
            k = i;
            i3 = i2;
            if (j == this.I4)
            {
              k = i - 1;
              i3 = 1;
            }
          }
        }
      }
      i = k;
      if (this.S3 > 1)
      {
        i = k;
        if (k >= 24) {
          i = 0;
        }
      }
      i1++;
    }
    this.h4.add("24:00");
  }
  
  public void a()
  {
    this.q4.clear();
    this.r4.clear();
    this.x4.clear();
    this.s4.clear();
    this.t4.clear();
    this.u4.clear();
    this.v4.clear();
    this.w4.clear();
    invalidate();
  }
  
  public int b(float paramFloat, int paramInt)
  {
    int[] arrayOfInt = this.p1;
    if (paramFloat < arrayOfInt[2])
    {
      if (paramInt % 4 == 0) {
        paramInt = this.p2[0];
      } else if (paramInt % 2 == 0) {
        paramInt = this.p2[1];
      } else {
        paramInt = this.p2[2];
      }
    }
    else if (paramFloat < arrayOfInt[3])
    {
      if (paramInt % 12 == 0) {
        paramInt = this.p2[0];
      } else if (paramInt % 6 == 0) {
        paramInt = this.p2[1];
      } else {
        paramInt = this.p2[2];
      }
    }
    else if (paramFloat < arrayOfInt[4])
    {
      if (paramInt % 12 == 0) {
        paramInt = this.p2[0];
      } else if (paramInt % 6 == 0) {
        paramInt = this.p2[1];
      } else {
        paramInt = this.p2[2];
      }
    }
    else if (paramFloat < arrayOfInt[5])
    {
      if (paramInt % 12 == 0) {
        paramInt = this.p2[0];
      } else if (paramInt % 6 == 0) {
        paramInt = this.p2[1];
      } else if (paramInt % 3 == 0) {
        paramInt = this.p2[2];
      } else {
        paramInt = this.p2[3];
      }
    }
    else if (paramInt % 60 == 0) {
      paramInt = this.p2[0];
    } else if (paramInt % 30 == 0) {
      paramInt = this.p2[0];
    } else if (paramInt % 15 == 0) {
      paramInt = this.p2[1];
    } else if (paramInt % 5 == 0) {
      paramInt = this.p2[1];
    } else {
      paramInt = this.p2[2];
    }
    return a.a(paramInt, getContext());
  }
  
  public int c(float paramFloat)
  {
    for (int i = 1;; i++)
    {
      int[] arrayOfInt = this.p1;
      if ((i >= arrayOfInt.length) || (paramFloat < arrayOfInt[i])) {
        break;
      }
    }
    return this.y[(i - 1)] * this.S3;
  }
  
  public int d(int paramInt)
  {
    int i;
    if (this.G4) {
      i = 90000;
    } else {
      i = 86400;
    }
    long l1 = paramInt;
    long l2 = i;
    int j = this.S3;
    int k = (int)(l1 * l2 * j / this.P3);
    paramInt = k;
    if (k < 0) {
      paramInt = 0;
    }
    k = paramInt;
    if (paramInt > i * j) {
      k = i * j;
    }
    return k;
  }
  
  public int e(float paramFloat)
  {
    for (int i = 1;; i++)
    {
      int[] arrayOfInt = this.p1;
      if ((i >= arrayOfInt.length) || (paramFloat < arrayOfInt[i])) {
        break;
      }
    }
    return (this.I3[(i - 1)] - 1) * this.S3 + 1;
  }
  
  public int f(int paramInt)
  {
    if (this.G4) {
      i = 90000;
    } else {
      i = 86400;
    }
    long l = paramInt;
    int j = this.P3;
    int i = (int)(l * j / i / this.S3);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    if (paramInt > j) {
      paramInt = j;
    }
    return paramInt;
  }
  
  public ArrayList<int[]> getAreaIntrusionDetectTimes()
  {
    return this.u4;
  }
  
  public ArrayList<int[]> getBabyCryDetectTimes()
  {
    return this.s4;
  }
  
  public ArrayList<int[]> getCameraTamperDetectTimes()
  {
    return this.w4;
  }
  
  public ArrayList<int[]> getLineCrossingDetectTimes()
  {
    return this.v4;
  }
  
  public ArrayList<int[]> getMotionDetectTimes()
  {
    return this.r4;
  }
  
  public ArrayList<int[]> getMotionDetectTimesV2()
  {
    return this.x4;
  }
  
  public ArrayList<int[]> getPersonDetectTimes()
  {
    return this.t4;
  }
  
  public int getRecordAreaBottom()
  {
    return this.L3 - getPaddingBottom() - this.z4;
  }
  
  public int getRecordAreaTop()
  {
    return getPaddingTop() + this.y4;
  }
  
  public ArrayList<int[]> getRecordTimes()
  {
    return this.q4;
  }
  
  public long getReferenceDayInSeconds()
  {
    return this.T3;
  }
  
  public int getValidLength()
  {
    return this.P3;
  }
  
  public float getZoomRatio()
  {
    return this.R3;
  }
  
  public boolean h(Context paramContext)
  {
    boolean bool;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean i()
  {
    return this.U3;
  }
  
  public void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.G4 = paramBoolean;
    this.H4 = paramInt1;
    this.I4 = paramInt2;
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = this.p0;
    } else {
      arrayOfInt = this.z;
    }
    this.y = arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = this.K3;
    } else {
      arrayOfInt = this.J3;
    }
    this.I3 = arrayOfInt;
    m();
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getPaddingLeft();
    int m = c(this.R3);
    int n = e(this.R3);
    boolean bool = h(getContext());
    float f1 = 0.0F;
    float f2 = 0.0F;
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    if (bool)
    {
      f3 = k;
      f1 = i;
      paramCanvas.drawRect(f3, f1, this.M3 + k, this.L3 - j, this.D4);
      if (this.E4)
      {
        localObject1 = this.q4.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (int[])((Iterator)localObject1).next();
          paramCanvas.drawRect(this.O3 + f(localObject2[0]) + k, f1, this.O3 + k + f(localObject2[1]), this.L3 - j, this.i4);
        }
      }
      if (this.F4)
      {
        localObject2 = this.r4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.j4);
        }
        localObject2 = this.x4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.j4);
        }
        localObject1 = this.s4.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (int[])((Iterator)localObject1).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject2[0]), f1, this.O3 + k + f(localObject2[1]), this.L3 - j, this.k4);
        }
        localObject2 = this.t4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.l4);
        }
        localObject2 = this.u4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.m4);
        }
        localObject2 = this.v4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.n4);
        }
        localObject2 = this.w4.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (int[])((Iterator)localObject2).next();
          paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), f1, this.O3 + k + f(localObject1[1]), this.L3 - j, this.o4);
        }
      }
      if (this.S3 > 1) {
        f2 = this.Z3.getTextSize();
      }
      for (j = 0; j <= m; j++)
      {
        i1 = b(this.R3, j);
        i2 = this.O3 + k + this.P3 * j / m;
        f3 = i2;
        paramCanvas.drawLine(f3, f1 + f2, f3, i1 + i + f2, this.X3);
        i1 = m / (n - 1);
        if (j % i1 == 0)
        {
          localObject2 = (String)this.h4.get(j / i1);
          paramCanvas.drawText((String)localObject2, f3 - this.Y3.measureText((String)localObject2) / 2.0F, f1 + this.f4 + f2 + this.p3, this.Y3);
          if ((this.S3 > 1) && (((String)localObject2).equals("00:00")))
          {
            this.b4.setTime((this.T3 + d(i2)) * 1000L);
            paramCanvas.drawText(this.a4.format(this.b4), f3, f1 + this.d4 / 2.0F, this.Z3);
          }
        }
      }
    }
    f2 = k;
    paramCanvas.drawRect(f2, this.y4 + i, this.M3 + k, this.L3 - j - this.z4, this.D4);
    if (this.E4)
    {
      localObject1 = this.q4.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (int[])((Iterator)localObject1).next();
        paramCanvas.drawRect(this.O3 + f(localObject2[0]) + k, this.y4 + i, this.O3 + k + f(localObject2[1]), this.L3 - j - this.z4, this.i4);
      }
    }
    if (this.F4)
    {
      localObject1 = this.r4.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (int[])((Iterator)localObject1).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject2[0]), this.y4 + i, this.O3 + k + f(localObject2[1]), this.L3 - j - this.z4, this.j4);
      }
      localObject1 = this.x4.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (int[])((Iterator)localObject1).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject2[0]), this.y4 + i, this.O3 + k + f(localObject2[1]), this.L3 - j - this.z4, this.j4);
      }
      localObject1 = this.s4.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (int[])((Iterator)localObject1).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject2[0]), this.y4 + i, this.O3 + k + f(localObject2[1]), this.L3 - j - this.z4, this.k4);
      }
      localObject2 = this.t4.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (int[])((Iterator)localObject2).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), this.y4 + i, this.O3 + k + f(localObject1[1]), this.L3 - j - this.z4, this.l4);
      }
      localObject2 = this.u4.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (int[])((Iterator)localObject2).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), this.y4 + i, this.O3 + k + f(localObject1[1]), this.L3 - j - this.z4, this.m4);
      }
      localObject2 = this.v4.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (int[])((Iterator)localObject2).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject1[0]), this.y4 + i, this.O3 + k + f(localObject1[1]), this.L3 - j - this.z4, this.n4);
      }
      localObject1 = this.w4.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (int[])((Iterator)localObject1).next();
        paramCanvas.drawRect(this.O3 + k + f(localObject2[0]), this.y4 + i, this.O3 + k + f(localObject2[1]), this.L3 - j - this.z4, this.o4);
      }
    }
    paramCanvas.drawLine(f2, this.y4 + i, getWidth() + k, this.y4 + i, this.A4);
    paramCanvas.drawLine(f2, this.L3 - j - this.z4, getWidth() + k, this.L3 - j - this.z4, this.B4);
    float f3 = i;
    paramCanvas.drawRect(f2, f3, this.M3 + k, this.y4 + i, this.C4);
    f2 = f1;
    if (this.S3 > 1) {
      f2 = this.Z3.getTextSize();
    }
    for (j = 0; j <= m; j++)
    {
      i1 = b(this.R3, j);
      i = this.O3 + k + this.P3 * j / m;
      if (this.p3 > i1) {
        this.X3.setColor(this.W3);
      } else {
        this.X3.setColor(this.V3);
      }
      f1 = f3 + f2 + this.f4 + this.g4;
      float f5 = i;
      i2 = this.p3;
      paramCanvas.drawLine(f5, i2 + f1 - i1, f5, i2 + f1, this.X3);
      i2 = m / (n - 1);
      if (j % i2 == 0)
      {
        localObject2 = (String)this.h4.get(j / i2);
        paramCanvas.drawText((String)localObject2, f5 - this.Y3.measureText((String)localObject2) / 2.0F, this.f4 + f3 + f2, this.Y3);
        if ((this.S3 > 1) && (((String)localObject2).equals("00:00")))
        {
          this.b4.setTime((this.T3 + d(i)) * 1000L);
          paramCanvas.drawText(this.a4.format(this.b4), f5, this.d4 / 2.0F + f3, this.Z3);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a locala = this.Q3;
    if (locala != null) {
      locala.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(k(paramInt1), j(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.M3 = paramInt1;
    this.L3 = paramInt2;
    this.P3 = (paramInt1 - this.O3 * 2);
  }
  
  public void setAreaIntrusionDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.u4.clear();
    if (paramArrayList != null) {
      this.u4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setBabyCryDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.s4.clear();
    if (paramArrayList != null) {
      this.s4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setBlankWidth(int paramInt)
  {
    this.O3 = paramInt;
  }
  
  public void setCameraTamperDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.w4.clear();
    if (paramArrayList != null) {
      this.w4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setLineCrossingDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.v4.clear();
    if (paramArrayList != null) {
      this.v4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setMotionDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.r4.clear();
    if (paramArrayList != null) {
      this.r4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setMotionDetectTimesV2(ArrayList<int[]> paramArrayList)
  {
    this.x4.clear();
    if (paramArrayList != null) {
      this.x4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setPersonDetectTimes(ArrayList<int[]> paramArrayList)
  {
    this.t4.clear();
    if (paramArrayList != null) {
      this.t4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setRecordDays(int paramInt)
  {
    if (this.S3 == paramInt) {
      return;
    }
    this.S3 = paramInt;
    if (paramInt > 1) {
      this.N3 = (this.q * paramInt);
    } else {
      this.N3 = a.a(600, getContext());
    }
    m();
    requestLayout();
  }
  
  public void setRecordTimes(ArrayList<int[]> paramArrayList)
  {
    this.q4.clear();
    if (paramArrayList != null) {
      this.q4 = paramArrayList;
    }
    invalidate();
  }
  
  public void setReferenceDayInSeconds(long paramLong)
  {
    this.T3 = paramLong;
  }
  
  public void setScaleViewListener(a parama)
  {
    this.Q3 = parama;
  }
  
  public void setShowTimeAxis(boolean paramBoolean)
  {
    if (this.U3 != paramBoolean)
    {
      this.U3 = paramBoolean;
      invalidate();
    }
  }
  
  public void setZoomRatio(float paramFloat)
  {
    paramFloat = Math.max(4.0F, paramFloat);
    this.R3 = paramFloat;
    this.R3 = Math.min(64.0F, paramFloat);
    m();
    requestLayout();
  }
  
  public void setZoomScale(float paramFloat)
  {
    setZoomRatio(this.R3 * paramFloat);
  }
  
  protected static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\timeaxis\TimeAxisScaleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */