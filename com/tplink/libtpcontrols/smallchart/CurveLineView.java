package com.tplink.libtpcontrols.smallchart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import b.d.w.f.a;
import com.tplink.libtpcontrols.r0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CurveLineView
  extends View
{
  private Paint H3 = new Paint();
  private int I3;
  private Paint J3 = new Paint();
  private final int K3 = 12;
  public boolean L3 = true;
  private boolean M3;
  private b N3;
  private b O3;
  private int P3 = a.a(getContext(), 2.0F);
  private int Q3 = a.a(getContext(), 12.0F);
  private int R3 = a.a(getContext(), 46.0F);
  private int S3 = a.a(getContext(), 55.0F);
  private final int T3 = a.a(getContext(), 2.0F);
  private final int U3 = a.a(getContext(), 5.0F);
  private final int V3 = 0;
  private final int W3 = a.a(getContext(), 2.0F);
  private final int X3 = a.a(getContext(), 5.0F);
  private final int Y3 = a.a(getContext(), 12.0F);
  private final int Z3 = 4;
  private final int a4 = 1;
  private final int b4;
  private int c;
  private final int c4;
  private boolean d = true;
  private final int d4;
  private int e4;
  private boolean f = true;
  private Boolean f4;
  private int[] g4;
  private final Point h4;
  private Drawable i4;
  private int j4;
  private int k4;
  private int l4;
  private int m4;
  private boolean n4;
  private boolean o4;
  private ArrayList<ArrayList<String>> p0;
  private ArrayList<Integer> p1 = new ArrayList();
  private ArrayList<Integer> p2 = new ArrayList();
  private ArrayList<ArrayList<b>> p3 = new ArrayList();
  private float p4;
  private int q = 10;
  private float q4;
  private float r4;
  private float s4;
  private boolean t4;
  private int u4;
  private Runnable v4;
  private int x = 0;
  private ArrayList<String> y = new ArrayList();
  private ArrayList<ArrayList<Long>> z;
  
  public CurveLineView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CurveLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = Color.parseColor("#f6f6f6");
    this.b4 = i;
    int j = Color.parseColor("#9B9A9B");
    this.c4 = j;
    int k = Color.parseColor("#4acbd6");
    this.d4 = k;
    this.e4 = 3;
    this.f4 = Boolean.FALSE;
    this.g4 = new int[] { Color.parseColor("#4acbd6") };
    this.h4 = new Point();
    this.i4 = null;
    this.j4 = Color.parseColor("#a3dde7");
    this.k4 = i;
    this.l4 = j;
    this.m4 = k;
    this.n4 = true;
    this.o4 = false;
    this.p4 = 14.0F;
    this.q4 = 14.0F;
    this.r4 = 2.0F;
    this.s4 = 2.0F;
    this.t4 = false;
    this.u4 = a.k(getContext(), 10.0F);
    this.v4 = new a();
    this.J3.setAntiAlias(true);
    this.J3.setColor(this.m4);
    this.J3.setTextSize(a.k(getContext(), this.q4));
    this.J3.setStrokeWidth(a.a(getContext(), this.r4));
    this.J3.setTextAlign(Paint.Align.CENTER);
    this.H3.setAntiAlias(true);
    this.H3.setTextSize(a.k(getContext(), this.p4));
    this.H3.setStrokeWidth(a.a(getContext(), this.s4));
    this.H3.setTextAlign(Paint.Align.CENTER);
    this.H3.setStyle(Paint.Style.FILL);
    this.H3.setColor(this.l4);
    o();
    this.i4 = getContext().getResources().getDrawable(r0.common_curve_gradient);
  }
  
  private void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(a.a(getContext(), 1.0F));
    localPaint.setColor(this.k4);
    Object localObject = new DashPathEffect(new float[] { 10.0F, 5.0F, 10.0F, 5.0F }, 1.0F);
    int i = 0;
    for (int j = 0; j < this.p1.size(); j++) {
      paramCanvas.drawLine(((Integer)this.p1.get(j)).intValue(), 0.0F, ((Integer)this.p1.get(j)).intValue(), this.c - 0 - this.u4 - this.x - this.I3, localPaint);
    }
    if (this.n4) {
      paramCanvas.drawLine(0.0F, this.c - 0 - this.u4 - this.x - this.I3, getWidth(), this.c - 0 - this.u4 - this.x - this.I3, localPaint);
    }
    if (this.o4)
    {
      localPaint.setPathEffect((PathEffect)localObject);
      localObject = new Path();
      for (j = 0; j < this.p2.size(); j++) {
        if ((this.p2.size() - 1 - j) % this.q == 0)
        {
          ((Path)localObject).moveTo(0.0F, ((Integer)this.p2.get(j)).intValue());
          ((Path)localObject).lineTo(getWidth(), ((Integer)this.p2.get(j)).intValue());
          paramCanvas.drawPath((Path)localObject, localPaint);
        }
      }
    }
    if (this.y != null)
    {
      this.H3.setColor(this.l4);
      for (j = 0; j < this.y.size(); j++) {
        paramCanvas.drawText((String)this.y.get(j), this.R3 + this.S3 * j, this.c - this.I3, this.H3);
      }
    }
    if (!this.f4.booleanValue()) {
      for (j = i; j < this.p2.size(); j++) {
        if ((this.p2.size() - 1 - j) % this.q == 0) {
          paramCanvas.drawLine(0.0F, ((Integer)this.p2.get(j)).intValue(), getWidth(), ((Integer)this.p2.get(j)).intValue(), localPaint);
        }
      }
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    Paint localPaint1 = new Paint();
    localPaint1.setAntiAlias(true);
    Paint localPaint2 = new Paint(localPaint1);
    localPaint2.setColor(Color.parseColor("#FFFFFF"));
    Object localObject = this.p3;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      for (int i = 0; i < this.p3.size(); i++)
      {
        localObject = this.g4;
        localPaint1.setColor(localObject[(i % localObject.length)]);
        Iterator localIterator = ((ArrayList)this.p3.get(i)).iterator();
        while (localIterator.hasNext())
        {
          localObject = (b)localIterator.next();
          paramCanvas.drawCircle(((b)localObject).a, ((b)localObject).b, this.X3, localPaint1);
          paramCanvas.drawCircle(((b)localObject).a, ((b)localObject).b, this.W3, localPaint2);
        }
      }
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    if (this.i4 != null)
    {
      Path localPath = new Path();
      float f1 = ((Integer)this.p2.get(0)).intValue();
      Object localObject = this.p2;
      float f2 = ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue();
      localObject = new Paint();
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(a.a(getContext(), 1.0F));
      ((Paint)localObject).setColor(this.j4);
      int k;
      for (int i = 0; i < this.p3.size(); i = k + 1)
      {
        int j = 0;
        k = i;
        for (i = j; i < ((ArrayList)this.p3.get(k)).size() - 1; i = j)
        {
          int m = ((b)((ArrayList)this.p3.get(k)).get(i)).a;
          ArrayList localArrayList = (ArrayList)this.p3.get(k);
          j = i + 1;
          float f3 = (m + ((b)localArrayList.get(j)).a) / 2.0F;
          float f5 = (((b)((ArrayList)this.p3.get(k)).get(i)).a + ((b)((ArrayList)this.p3.get(k)).get(j)).a) / 2.0F;
          float f6 = ((b)((ArrayList)this.p3.get(k)).get(i)).b;
          float f7 = ((b)((ArrayList)this.p3.get(k)).get(j)).b;
          localPath.moveTo(((b)((ArrayList)this.p3.get(k)).get(i)).a, ((b)((ArrayList)this.p3.get(k)).get(i)).b);
          localPath.cubicTo(f3, f6, f5, f7, ((b)((ArrayList)this.p3.get(k)).get(j)).a, ((b)((ArrayList)this.p3.get(k)).get(j)).b);
          localPath.lineTo(((b)((ArrayList)this.p3.get(k)).get(j)).a, f2);
          localPath.lineTo(((b)((ArrayList)this.p3.get(k)).get(i)).a, f2);
          localPath.lineTo(((b)((ArrayList)this.p3.get(k)).get(i)).a, ((b)((ArrayList)this.p3.get(k)).get(i)).b);
          localPath.close();
          paramCanvas.save();
          paramCanvas.clipPath(localPath);
          this.i4.setBounds(((b)((ArrayList)this.p3.get(k)).get(i)).a, (int)f1, ((b)((ArrayList)this.p3.get(k)).get(j)).a, (int)f2);
          this.i4.draw(paramCanvas);
          paramCanvas.restore();
          localPath.rewind();
          paramCanvas.drawLine(((b)((ArrayList)this.p3.get(k)).get(i)).a, ((b)((ArrayList)this.p3.get(k)).get(i)).b, ((b)((ArrayList)this.p3.get(k)).get(i)).a, f2, (Paint)localObject);
          paramCanvas.drawLine(((b)((ArrayList)this.p3.get(k)).get(j)).a, ((b)((ArrayList)this.p3.get(k)).get(j)).b, ((b)((ArrayList)this.p3.get(k)).get(j)).a, f2, (Paint)localObject);
        }
      }
    }
  }
  
  private void e(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(a.a(getContext(), 2.0F));
    for (int i = 0; i < this.p3.size(); i++)
    {
      Object localObject = this.g4;
      localPaint.setColor(localObject[(i % localObject.length)]);
      int m;
      for (int j = 0; j < ((ArrayList)this.p3.get(i)).size() - 1; j = m)
      {
        int k = ((b)((ArrayList)this.p3.get(i)).get(j)).a;
        localObject = (ArrayList)this.p3.get(i);
        m = j + 1;
        float f1 = (k + ((b)((ArrayList)localObject).get(m)).a) / 2.0F;
        float f2 = (((b)((ArrayList)this.p3.get(i)).get(j)).a + ((b)((ArrayList)this.p3.get(i)).get(m)).a) / 2.0F;
        float f3 = ((b)((ArrayList)this.p3.get(i)).get(j)).b;
        float f5 = ((b)((ArrayList)this.p3.get(i)).get(m)).b;
        localPath.moveTo(((b)((ArrayList)this.p3.get(i)).get(j)).a, ((b)((ArrayList)this.p3.get(i)).get(j)).b);
        localPath.cubicTo(f1, f3, f2, f5, ((b)((ArrayList)this.p3.get(i)).get(m)).a, ((b)((ArrayList)this.p3.get(i)).get(m)).b);
      }
      paramCanvas.drawPath(localPath, localPaint);
    }
  }
  
  private void f(Canvas paramCanvas, long paramLong, Point paramPoint, String paramString)
  {
    Object localObject = this.p0;
    if ((localObject == null) || (!((ArrayList)localObject).isEmpty()))
    {
      localObject = paramString;
      if (paramString != null) {}
    }
    else
    {
      if (this.M3) {
        paramString = String.valueOf(paramLong);
      } else {
        paramString = String.valueOf(Math.round((float)paramLong));
      }
      localObject = paramString;
    }
    int i = ((String)localObject).length();
    int j = 1;
    if (i != 1) {
      j = 0;
    }
    paramString = getContext();
    float f1;
    if (j != 0) {
      f1 = 8.0F;
    } else {
      f1 = 5.0F;
    }
    a.a(paramString, f1);
    i = paramPoint.x;
    j = paramPoint.y;
    int k = a.a(getContext(), 5.0F);
    paramPoint = new Rect();
    this.J3.setColor(this.m4);
    this.J3.getTextBounds((String)localObject, 0, ((String)localObject).length(), paramPoint);
    paramCanvas.drawText((String)localObject, i, j - k - 12 - this.U3, this.J3);
  }
  
  private b g(int paramInt1, int paramInt2)
  {
    if (this.p3.isEmpty()) {
      return null;
    }
    int i = this.S3 / 2;
    Region localRegion = new Region();
    Iterator localIterator1 = this.p3.iterator();
    b localb;
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      }
      localb = (b)localIterator2.next();
      int j = localb.a;
      int k = (int)localb.b;
      localRegion.set(j - i, k - i, j + i, k + i);
    } while (!localRegion.contains(paramInt1, paramInt2));
    return localb;
    return null;
  }
  
  private int getHorizontalGridNum()
  {
    int i = this.y.size();
    int j = 1;
    i--;
    if (i >= 1) {
      j = i;
    }
    return j;
  }
  
  private int getPopupHeight()
  {
    Rect localRect = new Rect();
    this.J3.getTextBounds("9", 0, 1, localRect);
    return new Rect(-localRect.width() / 2, -localRect.height() - 12 - this.T3 * 2 - this.U3, localRect.width() / 2, this.T3 - this.U3 + this.P3).height();
  }
  
  private int getVerticalGridlNum()
  {
    Object localObject = this.z;
    int i = 4;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = this.z.iterator();
        j = i;
        if (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((ArrayList)((Iterator)localObject).next()).iterator();
          j = i;
          for (;;)
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            Long localLong = (Long)localIterator.next();
            if (j < localLong.longValue() + 1L) {
              j = (int)Math.floor(localLong.longValue() + 1L);
            }
          }
        }
      }
    }
    return j;
  }
  
  private int h(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (paramInt1 == 1073741824) {
        paramInt2 = i;
      }
    }
    else {
      paramInt2 = Math.min(paramInt2, i);
    }
    return paramInt2;
  }
  
  private float i(float paramFloat, int paramInt)
  {
    int i = this.Q3;
    return i + (this.c - i - this.x - this.u4 + 0 - this.I3) * (paramInt - paramFloat) / getVerticalGridlNum();
  }
  
  private int k(int paramInt)
  {
    return h(paramInt, 0);
  }
  
  private int l(int paramInt)
  {
    int i = getHorizontalGridNum();
    return h(paramInt, this.S3 * i + this.R3 * 2);
  }
  
  private void m()
  {
    int i = getVerticalGridlNum();
    q(i);
    n(i);
  }
  
  private void n(int paramInt)
  {
    ArrayList localArrayList = this.z;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (this.p3.size() == 0) {
        for (i = 0; i < this.z.size(); i++) {
          this.p3.add(new ArrayList());
        }
      }
      for (int i = 0; i < this.z.size(); i++)
      {
        if (((ArrayList)this.p3.get(i)).isEmpty()) {
          j = 0;
        } else {
          j = ((ArrayList)this.p3.get(i)).size();
        }
        for (int k = 0; k < ((ArrayList)this.z.get(i)).size(); k++)
        {
          m = ((Integer)this.p1.get(k)).intValue();
          float f1 = i((float)((Long)((ArrayList)this.z.get(i)).get(k)).longValue(), paramInt);
          if (k > j - 1)
          {
            ((ArrayList)this.p3.get(i)).add(new b(m, 0.0F, m, f1, ((Long)((ArrayList)this.z.get(i)).get(k)).longValue(), i));
          }
          else
          {
            localArrayList = this.p0;
            if ((localArrayList != null) && (!localArrayList.isEmpty())) {
              ((ArrayList)this.p3.get(i)).set(k, ((b)((ArrayList)this.p3.get(i)).get(k)).b(m, f1, ((Long)((ArrayList)this.z.get(i)).get(k)).longValue(), i, (String)((ArrayList)this.p0.get(i)).get(k)));
            } else {
              ((ArrayList)this.p3.get(i)).set(k, ((b)((ArrayList)this.p3.get(i)).get(k)).b(m, f1, ((Long)((ArrayList)this.z.get(i)).get(k)).longValue(), i, null));
            }
          }
        }
        k = ((ArrayList)this.p3.get(i)).size();
        int m = ((ArrayList)this.z.get(i)).size();
        for (int j = 0; j < k - m; j++) {
          ((ArrayList)this.p3.get(i)).remove(((ArrayList)this.p3.get(i)).size() - 1);
        }
      }
    }
    removeCallbacks(this.v4);
    post(this.v4);
  }
  
  private void o()
  {
    this.Q3 = (getPopupHeight() + this.X3 + this.W3 + 2);
  }
  
  private void p(int paramInt)
  {
    this.p1.clear();
    for (int i = 0; i < paramInt + 1; i++) {
      this.p1.add(Integer.valueOf(this.R3 + this.S3 * i));
    }
  }
  
  private void q(int paramInt)
  {
    this.p2.clear();
    for (int i = 0; i < paramInt + 1; i++)
    {
      ArrayList localArrayList = this.p2;
      int j = this.Q3;
      localArrayList.add(Integer.valueOf(j + (this.c - j - this.x - this.u4 - 0 - this.I3) * i / paramInt));
    }
  }
  
  private void s(ArrayList<ArrayList<Integer>> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (ArrayList)paramArrayList.next();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList2.add(Long.valueOf(((Integer)((Iterator)localObject).next()).intValue()));
      }
      localArrayList1.add(localArrayList2);
    }
    this.p0 = paramArrayList1;
    t(localArrayList1, false);
  }
  
  private void setColorArray(int[] paramArrayOfInt)
  {
    this.g4 = paramArrayOfInt;
  }
  
  private void setMultiplyFloatDataList(ArrayList<ArrayList<Long>> paramArrayList)
  {
    t(paramArrayList, true);
  }
  
  private void t(ArrayList<ArrayList<Long>> paramArrayList, boolean paramBoolean)
  {
    this.O3 = null;
    this.M3 = paramBoolean;
    this.z = paramArrayList;
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ArrayList)((Iterator)localObject).next()).size() > this.y.size()) {
        throw new RuntimeException("dacer.LineView error: dataList.size() > bottomTextList.size() !!!");
      }
    }
    float f1 = 0.0F;
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      localObject = (ArrayList)paramArrayList.next();
      float f2 = f1;
      if (this.d)
      {
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          f2 = f1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Long localLong = (Long)((Iterator)localObject).next();
          if (f1 < (float)localLong.longValue()) {
            f1 = (float)localLong.longValue();
          }
        }
      }
      int i;
      for (this.q = 1;; this.q = (i * 10))
      {
        float f3 = f2 / 10.0F;
        i = this.q;
        f1 = f2;
        if (f3 <= i) {
          break;
        }
      }
    }
    m();
    this.L3 = true;
    setMinimumWidth(0);
    postInvalidate();
  }
  
  public void j()
  {
    if (!this.t4) {
      this.t4 = true;
    }
    this.J3.setAntiAlias(true);
    this.J3.setColor(this.m4);
    this.J3.setTextSize(a.k(getContext(), this.q4));
    this.J3.setStrokeWidth(a.a(getContext(), this.r4));
    this.J3.setTextAlign(Paint.Align.CENTER);
    this.H3.setAntiAlias(true);
    this.H3.setTextSize(a.k(getContext(), this.p4));
    this.H3.setStrokeWidth(a.a(getContext(), this.s4));
    this.H3.setTextAlign(Paint.Align.CENTER);
    this.H3.setStyle(Paint.Style.FILL);
    this.H3.setColor(this.l4);
    o();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b(paramCanvas);
    d(paramCanvas);
    e(paramCanvas);
    c(paramCanvas);
    b localb;
    for (int i = 0; i < this.p3.size(); i++)
    {
      float f1 = (float)((Long)Collections.max((Collection)this.z.get(i))).longValue();
      float f2 = (float)((Long)Collections.min((Collection)this.z.get(i))).longValue();
      for (int j = 0; j < ((ArrayList)this.p3.get(i)).size(); j++)
      {
        localb = (b)((ArrayList)this.p3.get(i)).get(j);
        int k = this.e4;
        if (k == 1)
        {
          f(paramCanvas, localb.c, localb.c(this.h4), localb.h);
        }
        else if (k == 2)
        {
          long l = localb.c;
          if ((float)l == f1) {
            f(paramCanvas, l, localb.c(this.h4), localb.h);
          }
          l = localb.c;
          if ((float)l == f2) {
            f(paramCanvas, l, localb.c(this.h4), localb.h);
          }
        }
      }
    }
    if (this.L3)
    {
      localb = this.O3;
      if (localb != null) {
        f(paramCanvas, localb.c, localb.c(this.h4), "");
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = l(paramInt1);
    this.c = k(paramInt2);
    m();
    setMeasuredDimension(paramInt1, this.c);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.N3 = g((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.N3;
      if (paramMotionEvent != null)
      {
        this.O3 = paramMotionEvent;
        this.N3 = null;
        postInvalidate();
      }
    }
    return true;
  }
  
  public void r(ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramArrayList1);
    paramArrayList1 = new ArrayList();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      paramArrayList1.add(paramArrayList);
    }
    s(localArrayList, paramArrayList1);
  }
  
  public void setBottomTextList(ArrayList<String> paramArrayList)
  {
    j();
    this.y = paramArrayList;
    Rect localRect = new Rect();
    this.I3 = 0;
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = "";
    int i = 0;
    int j;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.H3.getTextBounds(str, 0, str.length(), localRect);
      if (this.x < localRect.height()) {
        this.x = localRect.height();
      }
      Object localObject = paramArrayList;
      j = i;
      if (this.f)
      {
        localObject = paramArrayList;
        j = i;
        if (i < localRect.width())
        {
          j = localRect.width();
          localObject = str;
        }
      }
      paramArrayList = (ArrayList<String>)localObject;
      i = j;
      if (this.I3 < Math.abs(localRect.bottom))
      {
        this.I3 = Math.abs(localRect.bottom);
        paramArrayList = (ArrayList<String>)localObject;
        i = j;
      }
    }
    if (this.f)
    {
      if (this.S3 < i) {
        this.S3 = ((int)this.H3.measureText(paramArrayList, 0, 1) + i);
      }
      j = this.R3;
      i /= 2;
      if (j < i) {
        this.R3 = i;
      }
    }
    p(getHorizontalGridNum());
  }
  
  public void setBottomTextSize(float paramFloat)
  {
    if (!this.t4)
    {
      this.p4 = paramFloat;
      this.H3.setTextSize(a.k(getContext(), this.p4));
    }
  }
  
  public void setBottomTextWidth(float paramFloat)
  {
    if (!this.t4) {
      this.r4 = paramFloat;
    }
  }
  
  public void setCurveLineColor(int paramInt)
  {
    if (!this.t4) {
      setColorArray(new int[] { paramInt });
    }
  }
  
  public void setDrawCoordinateDotLine(boolean paramBoolean)
  {
    this.o4 = paramBoolean;
  }
  
  public void setDrawDotLine(Boolean paramBoolean)
  {
    this.f4 = paramBoolean;
  }
  
  public void setFillPathBackgroundColor(int paramInt)
  {
    if (!this.t4) {
      this.j4 = paramInt;
    }
  }
  
  public void setFillPathDrawable(Drawable paramDrawable)
  {
    if ((!this.t4) && (paramDrawable != null)) {
      this.i4 = paramDrawable;
    }
  }
  
  public void setFloatDataList(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramArrayList);
    setMultiplyFloatDataList(localArrayList);
  }
  
  public void setPopupBottomMarginTop(float paramFloat)
  {
    if (!this.t4) {
      this.u4 = a.k(getContext(), paramFloat);
    }
  }
  
  public void setPopupTextSize(float paramFloat)
  {
    if (!this.t4)
    {
      this.q4 = paramFloat;
      this.J3.setTextSize(a.k(getContext(), this.q4));
    }
  }
  
  public void setPopupTextWidth(float paramFloat)
  {
    if (!this.t4) {
      this.s4 = paramFloat;
    }
  }
  
  public void setShowPopup(int paramInt)
  {
    this.e4 = paramInt;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      Iterator localIterator1 = CurveLineView.a(CurveLineView.this).iterator();
      int i = 0;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!localIterator2.hasNext()) {
            break;
          }
          CurveLineView.b localb = (CurveLineView.b)localIterator2.next();
          localb.d();
          if (!localb.a()) {
            j = 1;
          }
        }
      }
      if (i != 0) {
        CurveLineView.this.postDelayed(this, 25L);
      }
      CurveLineView.this.invalidate();
    }
  }
  
  class b
  {
    int a;
    float b;
    long c;
    int d;
    float e;
    int f;
    int g = a.a(CurveLineView.this.getContext(), 18.0F);
    String h;
    
    b(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, long paramLong, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramFloat1;
      this.f = paramInt3;
      b(paramInt2, paramFloat2, paramLong, paramInt3, null);
    }
    
    private float e(float paramFloat1, float paramFloat2, int paramInt)
    {
      float f1;
      if (paramFloat1 < paramFloat2)
      {
        f1 = paramFloat1 + paramInt;
      }
      else
      {
        f1 = paramFloat1;
        if (paramFloat1 > paramFloat2) {
          f1 = paramFloat1 - paramInt;
        }
      }
      if (Math.abs(paramFloat2 - f1) >= paramInt) {
        paramFloat2 = f1;
      }
      return paramFloat2;
    }
    
    boolean a()
    {
      boolean bool;
      if ((this.a == this.d) && (this.b == this.e)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    b b(int paramInt1, float paramFloat, long paramLong, int paramInt2, String paramString)
    {
      this.d = paramInt1;
      this.e = paramFloat;
      this.c = paramLong;
      this.f = paramInt2;
      this.h = paramString;
      return this;
    }
    
    Point c(Point paramPoint)
    {
      paramPoint.set(this.a, (int)this.b);
      return paramPoint;
    }
    
    void d()
    {
      this.a = ((int)e(this.a, this.d, this.g));
      this.b = e(this.b, this.e, this.g);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\smallchart\CurveLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */