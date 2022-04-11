package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.widget.ScrollerCompat;
import com.tplink.iot.b;
import java.util.Objects;

public class NumberPickerView
  extends View
{
  private Handler A4;
  private f B4;
  private d C4;
  private c D4;
  private e E4;
  private int F4 = 0;
  private int G4;
  private int H3 = 0;
  private int H4;
  private int I3 = 16777215;
  private int I4;
  private int J3 = 2;
  private int J4;
  private int K3 = 0;
  private float K4 = 0.0F;
  private int L3 = 0;
  private float L4 = 0.0F;
  private int M3 = 3;
  private float M4 = 0.0F;
  private int N3 = 0;
  private boolean N4 = false;
  private int O3 = 0;
  private int O4;
  private int P3 = -1;
  private int P4;
  private int Q3 = -1;
  private int Q4;
  private int R3 = 0;
  private float R4;
  private int S3 = 0;
  private float S4;
  private int T3 = 0;
  private float T4;
  private int U3 = 0;
  private int U4 = 0;
  private int V3 = 0;
  private int V4 = 0;
  private int W3 = 0;
  private int W4 = 0;
  private int X3 = 0;
  private int X4 = 0;
  private int Y3 = 150;
  private int Y4 = 0;
  private int Z3 = 8;
  private String a4;
  private String b4;
  private int c = -1717986919;
  private String c4;
  private int d = -14891265;
  private String d4;
  private float e4 = 1.0F;
  private int f = -14891265;
  private float f4 = 0.0F;
  private float g4 = 0.0F;
  private float h4 = 0.0F;
  private boolean i4 = true;
  private boolean j4 = true;
  private boolean k4 = false;
  private boolean l4 = false;
  private boolean m4 = true;
  private boolean n4 = false;
  private boolean o4 = false;
  private int p0 = 0;
  private int p1 = 0;
  private int p2 = 0;
  private int p3 = 0;
  private boolean p4 = true;
  private int q = 0;
  private ScrollerCompat q4;
  private VelocityTracker r4;
  private Paint s4 = new Paint();
  private TextPaint t4 = new TextPaint();
  private Paint u4 = new Paint();
  private String[] v4;
  private CharSequence[] w4;
  private int x = 0;
  private CharSequence[] x4;
  private int y = 0;
  private HandlerThread y4;
  private int z = 0;
  private Handler z4;
  
  public NumberPickerView(Context paramContext)
  {
    super(paramContext);
    I(paramContext);
  }
  
  public NumberPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    J(paramContext, paramAttributeSet);
    I(paramContext);
  }
  
  public NumberPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    J(paramContext, paramAttributeSet);
    I(paramContext);
  }
  
  private int A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 <= 0) {
      return 0;
    }
    int i = paramInt1;
    if (paramBoolean)
    {
      paramInt1 %= paramInt2;
      i = paramInt1;
      if (paramInt1 < 0) {
        i = paramInt1 + paramInt2;
      }
    }
    return i;
  }
  
  private int B(CharSequence[] paramArrayOfCharSequence, Paint paramPaint)
  {
    int i = 0;
    if (paramArrayOfCharSequence == null) {
      return 0;
    }
    int j = paramArrayOfCharSequence.length;
    int m;
    for (int k = 0; i < j; k = m)
    {
      CharSequence localCharSequence = paramArrayOfCharSequence[i];
      m = k;
      if (localCharSequence != null) {
        m = Math.max(F(localCharSequence, paramPaint), k);
      }
      i++;
    }
    return k;
  }
  
  private Message C(int paramInt)
  {
    return D(paramInt, 0, 0, null);
  }
  
  private Message D(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  private float E(Paint.FontMetrics paramFontMetrics)
  {
    if (paramFontMetrics == null) {
      return 0.0F;
    }
    return Math.abs(paramFontMetrics.top + paramFontMetrics.bottom) / 2.0F;
  }
  
  private int F(CharSequence paramCharSequence, Paint paramPaint)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      return (int)(paramPaint.measureText(paramCharSequence.toString()) + 0.5F);
    }
    return 0;
  }
  
  private int G(int paramInt)
  {
    int i = this.Q4;
    boolean bool1 = false;
    if (i == 0) {
      return 0;
    }
    i = paramInt / i;
    int j = this.M3 / 2;
    paramInt = getOneRecycleSize();
    boolean bool2 = bool1;
    if (this.j4)
    {
      bool2 = bool1;
      if (this.m4) {
        bool2 = true;
      }
    }
    paramInt = A(i + j, paramInt, bool2);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize())) {
      return paramInt + this.P3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getWillPickIndexByGlobalY illegal index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" getOneRecycleSize() : ");
    localStringBuilder.append(getOneRecycleSize());
    localStringBuilder.append(" mWrapSelectorWheel : ");
    localStringBuilder.append(this.j4);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void H()
  {
    if (this.v4 == null)
    {
      String[] arrayOfString = new String[1];
      this.v4 = arrayOfString;
      arrayOfString[0] = "0";
    }
  }
  
  private void I(Context paramContext)
  {
    this.q4 = ScrollerCompat.create(paramContext);
    this.Y3 = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.Z3 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.q == 0) {
      this.q = c0(paramContext, 20.0F);
    }
    if (this.x == 0) {
      this.x = c0(paramContext, 22.0F);
    }
    if (this.y == 0) {
      this.y = c0(paramContext, 14.0F);
    }
    if (this.p1 == 0) {
      this.p1 = s(paramContext, 8.0F);
    }
    if (this.p2 == 0) {
      this.p2 = s(paramContext, 8.0F);
    }
    this.s4.setColor(this.I3);
    this.s4.setAntiAlias(true);
    this.s4.setStyle(Paint.Style.STROKE);
    this.s4.setStrokeWidth(this.J3);
    this.t4.setColor(this.c);
    this.t4.setAntiAlias(true);
    this.t4.setTextAlign(Paint.Align.CENTER);
    this.u4.setColor(this.f);
    this.u4.setAntiAlias(true);
    this.u4.setTextAlign(Paint.Align.CENTER);
    this.u4.setTextSize(this.y);
    int i = this.M3;
    if (i % 2 == 0) {
      this.M3 = (i + 1);
    }
    if ((this.P3 == -1) || (this.Q3 == -1)) {
      m0();
    }
    K();
  }
  
  private void J(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.NumberPickerView);
    int i = paramAttributeSet.getIndexCount();
    for (int j = 0; j < i; j++)
    {
      int k = paramAttributeSet.getIndex(j);
      if (k == 17) {
        this.M3 = paramAttributeSet.getInt(k, 3);
      } else if (k == 3) {
        this.I3 = paramAttributeSet.getColor(k, 16777215);
      } else if (k == 4) {
        this.J3 = paramAttributeSet.getDimensionPixelSize(k, 2);
      } else if (k == 5) {
        this.K3 = paramAttributeSet.getDimensionPixelSize(k, 0);
      } else if (k == 6) {
        this.L3 = paramAttributeSet.getDimensionPixelSize(k, 0);
      } else if (k == 19) {
        this.v4 = q(paramAttributeSet.getTextArray(k));
      } else if (k == 21) {
        this.c = paramAttributeSet.getColor(k, -1717986919);
      } else if (k == 22) {
        this.d = paramAttributeSet.getColor(k, -14891265);
      } else if (k == 20) {
        this.f = paramAttributeSet.getColor(k, -14891265);
      } else if (k == 25) {
        this.q = paramAttributeSet.getDimensionPixelSize(k, c0(paramContext, 20.0F));
      } else if (k == 26) {
        this.x = paramAttributeSet.getDimensionPixelSize(k, c0(paramContext, 22.0F));
      } else if (k == 24) {
        this.y = paramAttributeSet.getDimensionPixelSize(k, c0(paramContext, 14.0F));
      } else if (k == 14) {
        this.P3 = paramAttributeSet.getInteger(k, 0);
      } else if (k == 13) {
        this.Q3 = paramAttributeSet.getInteger(k, 0);
      } else if (k == 27) {
        this.j4 = paramAttributeSet.getBoolean(k, true);
      } else if (k == 18) {
        this.i4 = paramAttributeSet.getBoolean(k, true);
      } else if (k == 8) {
        this.a4 = paramAttributeSet.getString(k);
      } else if (k == 0) {
        this.d4 = paramAttributeSet.getString(k);
      } else if (k == 7) {
        this.c4 = paramAttributeSet.getString(k);
      } else if (k == 12) {
        this.p1 = paramAttributeSet.getDimensionPixelSize(k, s(paramContext, 8.0F));
      } else if (k == 11) {
        this.p2 = paramAttributeSet.getDimensionPixelSize(k, s(paramContext, 8.0F));
      } else if (k == 10) {
        this.p3 = paramAttributeSet.getDimensionPixelSize(k, s(paramContext, 2.0F));
      } else if (k == 9) {
        this.H3 = paramAttributeSet.getDimensionPixelSize(k, s(paramContext, 5.0F));
      } else if (k == 1) {
        this.w4 = paramAttributeSet.getTextArray(k);
      } else if (k == 2) {
        this.x4 = paramAttributeSet.getTextArray(k);
      } else if (k == 16) {
        this.o4 = paramAttributeSet.getBoolean(k, false);
      } else if (k == 15) {
        this.p4 = paramAttributeSet.getBoolean(k, true);
      } else if (k == 23) {
        this.b4 = paramAttributeSet.getString(k);
      }
    }
    paramAttributeSet.recycle();
  }
  
  private void K()
  {
    HandlerThread localHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
    this.y4 = localHandlerThread;
    localHandlerThread.start();
    this.z4 = new a(this.y4.getLooper());
    this.A4 = new b();
  }
  
  private void L()
  {
    r(getPickedIndexRelativeToRaw() - this.P3, false);
    this.j4 = false;
    postInvalidate();
  }
  
  private boolean M(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private int N(int paramInt)
  {
    if ((this.j4) && (this.m4)) {
      return paramInt;
    }
    int i = this.J4;
    if (paramInt < i) {}
    int j;
    for (paramInt = i;; paramInt = j)
    {
      i = paramInt;
      break;
      j = this.I4;
      i = paramInt;
      if (paramInt <= j) {
        break;
      }
    }
    return i;
  }
  
  private int O(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    this.Y4 = i;
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824)
    {
      int j = this.M3;
      int k = this.U3;
      int m = this.p3;
      m = getPaddingTop() + getPaddingBottom() + j * (k + m * 2);
      if (i == Integer.MIN_VALUE) {
        paramInt = Math.min(m, paramInt);
      } else {
        paramInt = m;
      }
    }
    return paramInt;
  }
  
  private int P(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    this.X4 = i;
    int j = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824)
    {
      paramInt = j;
    }
    else
    {
      paramInt = Math.max(this.z, this.p0);
      int k = 0;
      if (paramInt == 0) {
        paramInt = 0;
      } else {
        paramInt = this.p2;
      }
      if (Math.max(this.z, this.p0) != 0) {
        k = this.p1;
      }
      paramInt = Math.max(this.V3, Math.max(this.T3, this.W3) + (k + Math.max(this.z, this.p0) + paramInt + this.H3 * 2) * 2);
      paramInt = getPaddingLeft() + getPaddingRight() + paramInt;
      if (i == Integer.MIN_VALUE) {
        paramInt = Math.min(paramInt, j);
      }
    }
    return paramInt;
  }
  
  private void Q(int paramInt)
  {
    if (this.F4 == paramInt) {
      return;
    }
    this.F4 = paramInt;
    c localc = this.D4;
    if (localc != null) {
      localc.a(this, paramInt);
    }
  }
  
  private int R(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i;
      if (paramInt1 > paramInt3)
      {
        i = (paramInt1 - paramInt3) % getOneRecycleSize() + paramInt2 - 1;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 < paramInt2) {
          i = (paramInt1 - paramInt2) % getOneRecycleSize() + paramInt3 + 1;
        }
      }
      return i;
    }
    if (paramInt1 <= paramInt3)
    {
      paramInt3 = paramInt1;
      if (paramInt1 < paramInt2) {
        paramInt3 = paramInt2;
      }
    }
    return paramInt3;
  }
  
  private void T()
  {
    VelocityTracker localVelocityTracker = this.r4;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.r4.recycle();
      this.r4 = null;
    }
  }
  
  private void U(int paramInt1, int paramInt2, Object paramObject)
  {
    Q(0);
    if ((paramInt1 != paramInt2) && ((paramObject == null) || (!(paramObject instanceof Boolean)) || (((Boolean)paramObject).booleanValue())))
    {
      paramObject = this.C4;
      if (paramObject != null)
      {
        int i = this.R3;
        ((d)paramObject).a(this, paramInt1 + i, i + paramInt2);
      }
      paramObject = this.B4;
      if (paramObject != null) {
        ((f)paramObject).a(this, paramInt1, paramInt2, this.v4);
      }
    }
    this.X3 = paramInt2;
    if (this.n4)
    {
      this.n4 = false;
      L();
    }
  }
  
  private void V(int paramInt1, int paramInt2)
  {
    this.E4.a(this, paramInt1, paramInt2);
  }
  
  private void W(int paramInt)
  {
    X(paramInt, true);
  }
  
  private void X(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.j4)
    {
      i = paramInt;
      if (this.m4) {}
    }
    else
    {
      j = getPickedIndexRelativeToRaw();
      k = j + paramInt;
      m = this.Q3;
      if (k > m) {}
      for (paramInt = m;; paramInt = m)
      {
        i = paramInt - j;
        break;
        m = this.P3;
        i = paramInt;
        if (k >= m) {
          break;
        }
      }
    }
    int j = this.V4;
    int k = this.Q4;
    if (j < -k / 2)
    {
      paramInt = (int)((j + k) * 300.0F / k);
      if (i < 0) {
        paramInt = -paramInt - i * 300;
      } else {
        paramInt += i * 300;
      }
      j = k + j;
    }
    else
    {
      paramInt = (int)(-j * 300.0F / k);
      if (i < 0) {
        paramInt -= i * 300;
      } else {
        paramInt += i * 300;
      }
    }
    int m = paramInt;
    if (paramInt < 300) {
      m = 300;
    }
    paramInt = m;
    if (m > 600) {
      paramInt = 600;
    }
    this.q4.startScroll(0, this.W4, 0, j + i * k, paramInt);
    if (paramBoolean) {
      this.z4.sendMessageDelayed(C(1), paramInt / 4);
    } else {
      this.z4.sendMessageDelayed(D(1, 0, 0, new Boolean(paramBoolean)), paramInt / 4);
    }
    postInvalidate();
  }
  
  private int c0(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  private void d0()
  {
    Handler localHandler = this.z4;
    if (localHandler != null) {
      localHandler.removeMessages(1);
    }
  }
  
  private void f0(String[] paramArrayOfString)
  {
    this.v4 = paramArrayOfString;
    n0();
  }
  
  private void g0()
  {
    int i = this.M3;
    int j = i / 2;
    this.N3 = j;
    int k = j + 1;
    this.O3 = k;
    int m = this.P4;
    this.R4 = (j * m / i);
    this.S4 = (k * m / i);
    if (this.K3 < 0) {
      this.K3 = 0;
    }
    if (this.L3 < 0) {
      this.L3 = 0;
    }
    if (this.K3 + this.L3 == 0) {
      return;
    }
    if (getPaddingLeft() + this.K3 >= this.O4 - getPaddingRight() - this.L3)
    {
      m = getPaddingLeft();
      int n = this.K3;
      k = getPaddingRight();
      i = this.L3;
      int i1 = this.O4;
      j = this.K3;
      float f1 = j;
      float f2 = m + n + k + i - i1;
      k = (int)(f1 - j * f2 / (j + i));
      this.K3 = k;
      this.L3 = ((int)(i - f2 * i / (k + i)));
    }
  }
  
  private TextUtils.TruncateAt getEllipsizeType()
  {
    String str = this.b4;
    str.hashCode();
    int i = str.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 109757538: 
      if (str.equals("start")) {
        j = 2;
      }
      break;
    case 100571: 
      if (str.equals("end")) {
        j = 1;
      }
      break;
    case -1074341483: 
      if (str.equals("middle")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      throw new IllegalArgumentException("Illegal text ellipsize type.");
    case 2: 
      return TextUtils.TruncateAt.START;
    case 1: 
      return TextUtils.TruncateAt.END;
    }
    return TextUtils.TruncateAt.MIDDLE;
  }
  
  private void h0()
  {
    int i = this.q;
    int j = this.Q4;
    if (i > j) {
      this.q = j;
    }
    if (this.x > j) {
      this.x = j;
    }
    Object localObject = this.u4;
    if (localObject != null)
    {
      ((Paint)localObject).setTextSize(this.y);
      this.h4 = E(this.u4.getFontMetrics());
      this.z = F(this.a4, this.u4);
      localObject = this.t4;
      if (localObject != null)
      {
        ((TextPaint)localObject).setTextSize(this.x);
        this.g4 = E(this.t4.getFontMetrics());
        this.t4.setTextSize(this.q);
        this.f4 = E(this.t4.getFontMetrics());
        return;
      }
      throw new IllegalArgumentException("mPaintText should not be null.");
    }
    throw new IllegalArgumentException("mPaintHint should not be null.");
  }
  
  private void i0()
  {
    float f1 = this.t4.getTextSize();
    this.t4.setTextSize(this.x);
    this.U3 = ((int)(this.t4.getFontMetrics().bottom - this.t4.getFontMetrics().top + 0.5D));
    this.t4.setTextSize(f1);
  }
  
  private void j0(boolean paramBoolean)
  {
    k0();
    i0();
    if ((paramBoolean) && ((this.X4 == Integer.MIN_VALUE) || (this.Y4 == Integer.MIN_VALUE))) {
      this.A4.sendEmptyMessage(3);
    }
  }
  
  private void k0()
  {
    float f1 = this.t4.getTextSize();
    this.t4.setTextSize(this.x);
    this.T3 = B(this.v4, this.t4);
    this.V3 = B(this.w4, this.t4);
    this.W3 = B(this.x4, this.t4);
    this.t4.setTextSize(this.y);
    this.p0 = F(this.d4, this.t4);
    this.t4.setTextSize(f1);
  }
  
  private void l0()
  {
    this.I4 = 0;
    this.J4 = (-this.M3 * this.Q4);
    if (this.v4 != null)
    {
      int i = getOneRecycleSize();
      int j = this.M3;
      int k = j / 2;
      int m = this.Q4;
      this.I4 = ((i - k - 1) * m);
      this.J4 = (-(j / 2) * m);
    }
  }
  
  private void m0()
  {
    H();
    n0();
    if (this.P3 == -1) {
      this.P3 = 0;
    }
    if (this.Q3 == -1) {
      this.Q3 = (this.v4.length - 1);
    }
    Z(this.P3, this.Q3, false);
  }
  
  private void n()
  {
    int i = (int)Math.floor(this.W4 / this.Q4);
    this.U4 = i;
    int j = this.W4;
    int k = this.Q4;
    j = -(j - i * k);
    this.V4 = j;
    if (this.E4 != null)
    {
      if (-j > k / 2) {
        this.H4 = (i + 1 + this.M3 / 2);
      } else {
        this.H4 = (i + this.M3 / 2);
      }
      i = this.H4 % getOneRecycleSize();
      this.H4 = i;
      if (i < 0) {
        this.H4 = (i + getOneRecycleSize());
      }
      k = this.G4;
      i = this.H4;
      if (k != i) {
        V(k, i);
      }
      this.G4 = this.H4;
    }
  }
  
  private void n0()
  {
    boolean bool;
    if (this.v4.length <= this.M3) {
      bool = false;
    } else {
      bool = true;
    }
    this.m4 = bool;
  }
  
  private void o(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    for (int i = 0; i < this.M3; i++)
    {
      int j = this.Q4;
      if ((j * i <= f1) && (f1 < j * (i + 1)))
      {
        p(i);
        break;
      }
    }
  }
  
  private void p(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.M3;
      if (paramInt < i) {
        W(paramInt - i / 2);
      }
    }
  }
  
  private String[] q(CharSequence[] paramArrayOfCharSequence)
  {
    if (paramArrayOfCharSequence == null) {
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfCharSequence.length];
    for (int i = 0; i < paramArrayOfCharSequence.length; i++) {
      arrayOfString[i] = paramArrayOfCharSequence[i].toString();
    }
    return arrayOfString;
  }
  
  private void r(int paramInt, boolean paramBoolean)
  {
    paramInt -= (this.M3 - 1) / 2;
    this.U4 = paramInt;
    paramInt = A(paramInt, getOneRecycleSize(), paramBoolean);
    this.U4 = paramInt;
    int i = this.Q4;
    if (i == 0)
    {
      this.k4 = true;
    }
    else
    {
      this.W4 = (i * paramInt);
      paramInt += this.M3 / 2;
      this.G4 = paramInt;
      paramInt %= getOneRecycleSize();
      this.G4 = paramInt;
      if (paramInt < 0) {
        this.G4 = (paramInt + getOneRecycleSize());
      }
      this.H4 = this.G4;
      n();
    }
  }
  
  private int s(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void t(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    for (int i = 0; i < this.M3 + 1; i++)
    {
      float f2 = this.V4 + this.Q4 * i;
      int j = this.U4;
      int k = getOneRecycleSize();
      boolean bool;
      if ((this.j4) && (this.m4)) {
        bool = true;
      } else {
        bool = false;
      }
      k = A(j + i, k, bool);
      j = this.M3;
      float f3;
      float f5;
      if (i == j / 2)
      {
        j = this.Q4;
        f1 = (this.V4 + j) / j;
        j = w(f1, this.c, this.d);
        f3 = z(f1, this.q, this.x);
        f5 = z(f1, this.f4, this.g4);
      }
      else if (i == j / 2 + 1)
      {
        f5 = 1.0F - f1;
        j = w(f5, this.c, this.d);
        f3 = z(f5, this.q, this.x);
        f5 = z(f5, this.f4, this.g4);
      }
      else
      {
        int m = Math.abs(i - j / 2);
        j = x(3.0F, m, this.c);
        f3 = y(0.08F, m, this.q);
        f5 = this.f4;
      }
      this.t4.setColor(j);
      this.t4.setTextSize(f3);
      if ((k >= 0) && (k < getOneRecycleSize()))
      {
        String str = this.v4[(k + this.P3)];
        Object localObject = str;
        if (this.b4 != null) {
          localObject = TextUtils.ellipsize(str, this.t4, getWidth() - this.H3 * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.T4, f2 + this.Q4 / 2 + f5, this.t4);
      }
      else if (!TextUtils.isEmpty(this.c4))
      {
        paramCanvas.drawText(this.c4, this.T4, f2 + this.Q4 / 2 + f5, this.t4);
      }
    }
  }
  
  private void u(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.a4)) {
      return;
    }
    paramCanvas.drawText(this.a4, this.T4 + (this.T3 + this.z) / 2 + this.p1, (this.R4 + this.S4) / 2.0F + this.h4, this.u4);
  }
  
  private void v(Canvas paramCanvas)
  {
    if (this.i4)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.K3, this.R4, this.O4 - getPaddingRight() - this.L3, this.R4, this.s4);
      paramCanvas.drawLine(getPaddingLeft() + this.K3, this.S4, this.O4 - getPaddingRight() - this.L3, this.S4, this.s4);
    }
  }
  
  private int w(float paramFloat, int paramInt1, int paramInt2)
  {
    int i = (paramInt1 & 0xFF000000) >>> 24;
    int j = (paramInt1 & 0xFF0000) >>> 16;
    int k = (paramInt1 & 0xFF00) >>> 8;
    paramInt1 = (paramInt1 & 0xFF) >>> 0;
    i = (int)(i + (((0xFF000000 & paramInt2) >>> 24) - i) * paramFloat);
    j = (int)(j + (((0xFF0000 & paramInt2) >>> 16) - j) * paramFloat);
    k = (int)(k + (((0xFF00 & paramInt2) >>> 8) - k) * paramFloat);
    return (int)(paramInt1 + (((paramInt2 & 0xFF) >>> 0) - paramInt1) * paramFloat) | i << 24 | j << 16 | k << 8;
  }
  
  private int x(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return paramInt2;
    }
    int i = (int)(((0xFF0000 & paramInt2) >> 16) * paramFloat);
    int j = (int)(((0xFF00 & paramInt2) >> 8) * paramFloat);
    int k = (int)((paramInt2 & 0xFF) * paramFloat);
    paramInt1 = i;
    if (i >= 255) {
      paramInt1 = 204;
    }
    i = j;
    if (j >= 255) {
      i = 204;
    }
    j = k;
    if (k >= 255) {
      j = 204;
    }
    return j | (0xFF000000 & paramInt2) >> 24 << 24 | paramInt1 << 16 | i << 8;
  }
  
  private float y(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return paramInt2;
    }
    return (1.0F - paramFloat * paramInt1) * paramInt2;
  }
  
  private float z(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 + (paramFloat3 - paramFloat2) * paramFloat1;
  }
  
  public void S(String[] paramArrayOfString)
  {
    int i = getMinValue();
    int j = getMaxValue();
    int k = paramArrayOfString.length - 1;
    if (k - i + 1 > j - i + 1)
    {
      setDisplayedValues(paramArrayOfString);
      setMaxValue(k);
    }
    else
    {
      setMaxValue(k);
      setDisplayedValues(paramArrayOfString);
    }
  }
  
  public void Y(int paramInt1, int paramInt2)
  {
    Z(paramInt1, paramInt2, true);
  }
  
  public void Z(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 <= paramInt2)
    {
      localObject = this.v4;
      if (localObject != null)
      {
        if (paramInt1 >= 0)
        {
          int i = localObject.length;
          boolean bool = true;
          if (paramInt1 <= i - 1)
          {
            if (paramInt2 >= 0)
            {
              if (paramInt2 <= localObject.length - 1)
              {
                this.P3 = paramInt1;
                this.Q3 = paramInt2;
                if (paramBoolean)
                {
                  this.X3 = (paramInt1 + 0);
                  if ((this.j4) && (this.m4)) {
                    paramBoolean = bool;
                  } else {
                    paramBoolean = false;
                  }
                  r(0, paramBoolean);
                  postInvalidate();
                }
                return;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is ");
              ((StringBuilder)localObject).append(this.v4.length - 1);
              ((StringBuilder)localObject).append(" maxShowIndex is ");
              ((StringBuilder)localObject).append(paramInt2);
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("maxShowIndex should not be less than 0, now maxShowIndex is ");
            ((StringBuilder)localObject).append(paramInt2);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is ");
          ((StringBuilder)localObject).append(this.v4.length - 1);
          ((StringBuilder)localObject).append(" minShowIndex is ");
          ((StringBuilder)localObject).append(paramInt1);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("minShowIndex should not be less than 0, now minShowIndex is ");
        ((StringBuilder)localObject).append(paramInt1);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("minShowIndex should be less than maxShowIndex, minShowIndex is ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", maxShowIndex is ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a0(int paramInt)
  {
    b0(getValue(), paramInt, true);
  }
  
  public void b0(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.R3;
    int j = this.S3;
    boolean bool1 = this.j4;
    boolean bool2 = true;
    if ((bool1) && (this.m4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    i = R(paramInt1, i, j, bool1);
    paramInt1 = this.R3;
    j = this.S3;
    if ((this.j4) && (this.m4)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    j = R(paramInt2, paramInt1, j, bool1);
    if ((this.j4) && (this.m4))
    {
      paramInt2 = j - i;
      int k = getOneRecycleSize() / 2;
      if (paramInt2 >= -k)
      {
        paramInt1 = paramInt2;
        if (k >= paramInt2) {}
      }
      else
      {
        paramInt1 = getOneRecycleSize();
        if (paramInt2 > 0) {
          paramInt1 = paramInt2 - paramInt1;
        } else {
          paramInt1 = paramInt2 + paramInt1;
        }
      }
    }
    else
    {
      paramInt1 = j - i;
    }
    setValue(i);
    if (i == j) {
      return;
    }
    X(paramInt1, paramBoolean);
  }
  
  public void computeScroll()
  {
    if (this.Q4 == 0) {
      return;
    }
    if (this.q4.computeScrollOffset())
    {
      this.W4 = this.q4.getCurrY();
      n();
      postInvalidate();
    }
  }
  
  public void e0()
  {
    ScrollerCompat localScrollerCompat = this.q4;
    if ((localScrollerCompat != null) && (!localScrollerCompat.isFinished()))
    {
      localScrollerCompat = this.q4;
      localScrollerCompat.startScroll(0, localScrollerCompat.getCurrY(), 0, 0, 1);
      this.q4.abortAnimation();
      postInvalidate();
    }
  }
  
  public String getContentByCurrValue()
  {
    return this.v4[(getValue() - this.R3)];
  }
  
  public String[] getDisplayedValues()
  {
    return this.v4;
  }
  
  public int getMaxValue()
  {
    return this.S3;
  }
  
  public int getMinValue()
  {
    return this.R3;
  }
  
  public int getOneRecycleSize()
  {
    return this.Q3 - this.P3 + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    int i = this.V4;
    int j;
    if (i != 0)
    {
      j = this.Q4;
      if (i < -j / 2) {
        j = G(this.W4 + j + i);
      } else {
        j = G(this.W4 + i);
      }
    }
    else
    {
      j = G(this.W4);
    }
    return j;
  }
  
  public int getRawContentSize()
  {
    String[] arrayOfString = this.v4;
    if (arrayOfString != null) {
      return arrayOfString.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    return getPickedIndexRelativeToRaw() + this.R3;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.j4;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    boolean bool;
    if ((this.j4) && (this.m4)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    HandlerThread localHandlerThread = this.y4;
    if ((localHandlerThread == null) || (!localHandlerThread.isAlive())) {
      K();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.y4.quit();
    if (this.Q4 == 0) {
      return;
    }
    if (!this.q4.isFinished())
    {
      this.q4.abortAnimation();
      this.W4 = this.q4.getCurrY();
      n();
      i = this.V4;
      if (i != 0)
      {
        j = this.Q4;
        if (i < -j / 2) {
          this.W4 = (this.W4 + j + i);
        } else {
          this.W4 += i;
        }
        n();
      }
      Q(0);
    }
    int i = G(this.W4);
    int j = this.X3;
    if ((i != j) && (this.o4)) {
      try
      {
        Object localObject = this.C4;
        if (localObject != null)
        {
          int k = this.R3;
          ((d)localObject).a(this, j + k, k + i);
        }
        localObject = this.B4;
        if (localObject != null) {
          ((f)localObject).a(this, this.X3, i, this.v4);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.X3 = i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    t(paramCanvas);
    v(paramCanvas);
    u(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    j0(false);
    setMeasuredDimension(P(paramInt1), O(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.O4 = paramInt1;
    this.P4 = paramInt2;
    this.Q4 = (paramInt2 / this.M3);
    this.T4 = ((paramInt1 + getPaddingLeft() - getPaddingRight()) / 2.0F);
    paramInt1 = getOneRecycleSize();
    boolean bool1 = false;
    if (paramInt1 > 1)
    {
      if (this.l4)
      {
        paramInt1 = getValue() - this.R3;
        break label106;
      }
      if (this.k4)
      {
        paramInt1 = this.U4 + (this.M3 - 1) / 2;
        break label106;
      }
    }
    paramInt1 = 0;
    label106:
    boolean bool2 = bool1;
    if (this.j4)
    {
      bool2 = bool1;
      if (this.m4) {
        bool2 = true;
      }
    }
    r(paramInt1, bool2);
    h0();
    l0();
    g0();
    this.l4 = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.Q4 == 0) {
      return true;
    }
    if (this.r4 == null) {
      this.r4 = VelocityTracker.obtain();
    }
    this.r4.addMovement(paramMotionEvent);
    this.M4 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            this.K4 = this.W4;
            e0();
            this.z4.sendMessageDelayed(C(1), 0L);
          }
        }
        else
        {
          float f1 = this.L4 - this.M4;
          if (this.N4)
          {
            i = this.Z3;
            if ((-i < f1) && (f1 < i)) {}
          }
          else
          {
            this.N4 = false;
            this.W4 = N((int)(this.K4 + f1));
            n();
            invalidate();
          }
          Q(1);
        }
      }
      else if (this.N4)
      {
        o(paramMotionEvent);
      }
      else
      {
        paramMotionEvent = this.r4;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)(paramMotionEvent.getYVelocity() * this.e4);
        if (Math.abs(i) > this.Y3)
        {
          this.q4.fling(0, this.W4, 0, -i, Integer.MIN_VALUE, Integer.MAX_VALUE, N(Integer.MIN_VALUE), N(Integer.MAX_VALUE));
          invalidate();
          Q(2);
        }
        this.z4.sendMessageDelayed(C(1), 0L);
        T();
      }
    }
    else
    {
      this.N4 = true;
      this.z4.removeMessages(1);
      e0();
      this.L4 = this.M4;
      this.K4 = this.W4;
      Q(0);
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return true;
  }
  
  public void setContentTextTypeface(Typeface paramTypeface)
  {
    this.t4.setTypeface(paramTypeface);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    d0();
    e0();
    if (paramArrayOfString != null)
    {
      int i = this.S3;
      int j = this.R3;
      boolean bool = true;
      if (i - j + 1 <= paramArrayOfString.length)
      {
        f0(paramArrayOfString);
        j0(true);
        this.X3 = (this.P3 + 0);
        if ((!this.j4) || (!this.m4)) {
          bool = false;
        }
        r(0, bool);
        postInvalidate();
        this.A4.sendEmptyMessage(3);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is ");
      localStringBuilder.append(this.S3 - this.R3 + 1);
      localStringBuilder.append(" newDisplayedValues.length is ");
      localStringBuilder.append(paramArrayOfString.length);
      localStringBuilder.append(", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("newDisplayedValues should not be null.");
  }
  
  public void setDividerColor(int paramInt)
  {
    if (this.I3 == paramInt) {
      return;
    }
    this.I3 = paramInt;
    this.s4.setColor(paramInt);
    postInvalidate();
  }
  
  public void setFriction(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      ViewConfiguration.get(getContext());
      this.e4 = (ViewConfiguration.getScrollFriction() / paramFloat);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("you should set a a positive float friction, now friction is ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setHintText(String paramString)
  {
    if (M(this.a4, paramString)) {
      return;
    }
    this.a4 = paramString;
    this.h4 = E(this.u4.getFontMetrics());
    this.z = F(this.a4, this.u4);
    this.A4.sendEmptyMessage(3);
  }
  
  public void setHintTextColor(int paramInt)
  {
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    this.u4.setColor(paramInt);
    postInvalidate();
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    this.u4.setTypeface(paramTypeface);
  }
  
  public void setMaxValue(int paramInt)
  {
    Object localObject = this.v4;
    Objects.requireNonNull(localObject, "mDisplayedValues should not be null");
    int i = this.R3;
    if (paramInt - i + 1 <= localObject.length)
    {
      this.S3 = paramInt;
      int j = this.P3;
      paramInt = paramInt - i + j;
      this.Q3 = paramInt;
      Y(j, paramInt);
      l0();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is ");
    ((StringBuilder)localObject).append(paramInt - this.R3 + 1);
    ((StringBuilder)localObject).append(" and mDisplayedValues.length is ");
    ((StringBuilder)localObject).append(this.v4.length);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setMinValue(int paramInt)
  {
    this.R3 = paramInt;
    this.P3 = 0;
    l0();
  }
  
  public void setNormalTextColor(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    postInvalidate();
  }
  
  public void setOnScrollListener(c paramc)
  {
    this.D4 = paramc;
  }
  
  public void setOnValueChangeListenerInScrolling(e parame)
  {
    this.E4 = parame;
  }
  
  public void setOnValueChangedListener(d paramd)
  {
    this.C4 = paramd;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(f paramf)
  {
    this.B4 = paramf;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.X3 = (this.P3 + paramInt);
      boolean bool;
      if ((this.j4) && (this.m4)) {
        bool = true;
      } else {
        bool = false;
      }
      r(paramInt, bool);
      postInvalidate();
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    int i = this.P3;
    if ((i > -1) && (i <= paramInt) && (paramInt <= this.Q3))
    {
      this.X3 = paramInt;
      boolean bool;
      if ((this.j4) && (this.m4)) {
        bool = true;
      } else {
        bool = false;
      }
      r(paramInt - i, bool);
      postInvalidate();
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    this.d = paramInt;
    postInvalidate();
  }
  
  public void setValue(int paramInt)
  {
    int i = this.R3;
    if (paramInt >= i)
    {
      if (paramInt <= this.S3)
      {
        setPickedIndexRelativeToRaw(paramInt - i);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("should not set a value greater than mMaxValue, value is ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("should not set a value less than mMinValue, value is ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    if (this.j4 != paramBoolean) {
      if (!paramBoolean)
      {
        if (this.F4 == 0) {
          L();
        } else {
          this.n4 = true;
        }
      }
      else
      {
        this.j4 = paramBoolean;
        n0();
        postInvalidate();
      }
    }
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i == 2) {
          NumberPickerView.e(NumberPickerView.this, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        }
      }
      else
      {
        boolean bool = NumberPickerView.a(NumberPickerView.this).isFinished();
        int j = 0;
        if (!bool)
        {
          if (NumberPickerView.b(NumberPickerView.this) == 0) {
            NumberPickerView.f(NumberPickerView.this, 1);
          }
          NumberPickerView.h(NumberPickerView.this).sendMessageDelayed(NumberPickerView.g(NumberPickerView.this, 1, 0, 0, paramMessage.obj), 32L);
        }
        else
        {
          if (NumberPickerView.i(NumberPickerView.this) != 0)
          {
            if (NumberPickerView.b(NumberPickerView.this) == 0) {
              NumberPickerView.f(NumberPickerView.this, 1);
            }
            if (NumberPickerView.i(NumberPickerView.this) < -NumberPickerView.j(NumberPickerView.this) / 2)
            {
              j = (int)((NumberPickerView.j(NumberPickerView.this) + NumberPickerView.i(NumberPickerView.this)) * 300.0F / NumberPickerView.j(NumberPickerView.this));
              localObject = NumberPickerView.a(NumberPickerView.this);
              i = NumberPickerView.k(NumberPickerView.this);
              int k = NumberPickerView.j(NumberPickerView.this);
              ((ScrollerCompat)localObject).startScroll(0, i, 0, NumberPickerView.i(NumberPickerView.this) + k, j * 3);
              localObject = NumberPickerView.this;
              i = NumberPickerView.l((NumberPickerView)localObject, NumberPickerView.k((NumberPickerView)localObject) + NumberPickerView.j(NumberPickerView.this) + NumberPickerView.i(NumberPickerView.this));
            }
            else
            {
              j = (int)(-NumberPickerView.i(NumberPickerView.this) * 300.0F / NumberPickerView.j(NumberPickerView.this));
              NumberPickerView.a(NumberPickerView.this).startScroll(0, NumberPickerView.k(NumberPickerView.this), 0, NumberPickerView.i(NumberPickerView.this), j * 3);
              localObject = NumberPickerView.this;
              i = NumberPickerView.l((NumberPickerView)localObject, NumberPickerView.k((NumberPickerView)localObject) + NumberPickerView.i(NumberPickerView.this));
            }
            NumberPickerView.this.postInvalidate();
          }
          else
          {
            NumberPickerView.f(NumberPickerView.this, 0);
            localObject = NumberPickerView.this;
            i = NumberPickerView.l((NumberPickerView)localObject, NumberPickerView.k((NumberPickerView)localObject));
          }
          Object localObject = NumberPickerView.this;
          paramMessage = NumberPickerView.g((NumberPickerView)localObject, 2, NumberPickerView.m((NumberPickerView)localObject), i, paramMessage.obj);
          if (NumberPickerView.c(NumberPickerView.this)) {
            NumberPickerView.d(NumberPickerView.this).sendMessageDelayed(paramMessage, j * 2);
          } else {
            NumberPickerView.h(NumberPickerView.this).sendMessageDelayed(paramMessage, j * 2);
          }
        }
      }
    }
  }
  
  class b
    extends Handler
  {
    b() {}
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      int i = paramMessage.what;
      if (i != 2)
      {
        if (i == 3) {
          NumberPickerView.this.requestLayout();
        }
      }
      else {
        NumberPickerView.e(NumberPickerView.this, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(NumberPickerView paramNumberPickerView, int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface e
  {
    public abstract void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2, String[] paramArrayOfString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\NumberPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */