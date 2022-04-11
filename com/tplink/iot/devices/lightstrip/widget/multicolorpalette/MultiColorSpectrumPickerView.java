package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MotionEventCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class MultiColorSpectrumPickerView
  extends View
{
  private static final String c = MultiColorSpectrumPickerView.class.getSimpleName();
  private Drawable H3;
  private Drawable I3;
  private int J3;
  private int K3;
  private int L3;
  private int M3;
  private float N3;
  private int O3;
  private a P3;
  private TreeMap<Float, b> Q3;
  private boolean R3;
  private int[] S3;
  private float[] T3;
  private Canvas U3;
  private int V3;
  private boolean W3;
  private float[] X3 = { 0.0F, 0.0F, 1.0F };
  private final int d = 90;
  private int f = Integer.MIN_VALUE;
  private Paint p0;
  private Bitmap p1;
  private float p2;
  private Paint p3;
  private int q;
  private RectF x = new RectF();
  private a y = new a();
  private List<a> z = new ArrayList();
  
  public MultiColorSpectrumPickerView(Context paramContext)
  {
    super(paramContext);
    u(null);
  }
  
  public MultiColorSpectrumPickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    u(paramAttributeSet);
  }
  
  public MultiColorSpectrumPickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    u(paramAttributeSet);
  }
  
  private boolean A(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (Math.pow(s(paramFloat1, paramFloat2), 2.0D) < Math.pow(this.p2 - this.N3 + this.J3, 2.0D)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void D()
  {
    int i;
    int j;
    int k;
    if (this.H3 != null)
    {
      i = (int)this.x.height();
      j = this.H3.getIntrinsicHeight();
      k = this.H3.getIntrinsicWidth();
      this.K3 = j;
      this.J3 = k;
      if (i < j)
      {
        this.K3 = i;
        this.J3 = ((int)(k * (i / j)));
      }
      this.H3.setBounds(0, 0, this.J3, this.K3);
    }
    if (this.I3 != null)
    {
      i = (int)this.x.height();
      j = this.I3.getIntrinsicHeight();
      k = this.I3.getIntrinsicWidth();
      this.L3 = j;
      this.M3 = k;
      if (i < j)
      {
        this.M3 = i;
        this.L3 = ((int)(k * (i / j)));
      }
      this.I3.setBounds(0, 0, this.L3, this.M3);
    }
  }
  
  private void F(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private boolean G(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = this.J3;
    int j = this.K3;
    boolean bool1 = true;
    float f1 = paramInt1 - (i >> 1);
    float f2 = paramInt2 - (j >> 1);
    Object localObject = this.x;
    f1 = Math.max(((RectF)localObject).left, Math.min(f1, ((RectF)localObject).right - i));
    localObject = this.x;
    f2 = Math.max(((RectF)localObject).top, Math.min(f2, ((RectF)localObject).bottom - this.K3));
    float f3 = paramInt1;
    float f4 = paramInt2;
    if (y(f3, f4))
    {
      paramInt2 = (int)f1;
      i = this.J3;
      j = (int)f2;
      int k = this.K3;
      paramInt1 = paramInt2;
      i += paramInt2;
      paramInt2 = j;
      k += j;
      j = paramInt2;
      paramInt2 = k;
    }
    else
    {
      localObject = r(f3, f4);
      paramInt1 = (int)((int)localObject[0] + this.N3 * 2.0F);
      f1 = localObject[0];
      paramInt2 = this.J3;
      i = (int)(f1 + paramInt2);
      j = (int)(localObject[1] - paramInt2 / 2);
      paramInt2 = (int)(localObject[1] + paramInt2 / 2);
    }
    boolean bool2 = bool1;
    if (paramInt2 == paramRect.bottom) {
      if (i != paramRect.right) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    if (bool2) {
      F(paramRect, paramInt1, j, i, paramInt2);
    }
    return bool2;
  }
  
  private float[] b(@ColorInt int paramInt)
  {
    return d.a(paramInt).c().h();
  }
  
  private float c(float paramFloat)
  {
    ArrayList localArrayList = new ArrayList(this.Q3.values());
    if ((!localArrayList.isEmpty()) && (localArrayList.size() > 1))
    {
      float f1 = 360.0F / localArrayList.size() / 360.0F;
      int i;
      if (((b)localArrayList.get(0)).b() == 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      int k;
      for (int j = 0; j < localArrayList.size(); j = k)
      {
        b localb1 = (b)localArrayList.get(j);
        k = j + 1;
        int m;
        if (k >= localArrayList.size()) {
          m = 0;
        } else {
          m = k;
        }
        b localb2 = (b)localArrayList.get(m);
        if (j == localArrayList.size() - 1) {
          m = 1;
        } else {
          m = 0;
        }
        if (((localb1.a() <= paramFloat) && (paramFloat <= localb2.a())) || (m != 0))
        {
          f1 = paramFloat / f1;
          float f2 = j;
          if ((i != 0) && (m != 0)) {
            paramFloat = 1.0F;
          } else {
            paramFloat = localb2.b();
          }
          return (f1 - f2) * (paramFloat - localb1.b()) + localb1.b();
        }
      }
      return 0.0F;
    }
    return paramFloat;
  }
  
  private float[] d(Rect paramRect)
  {
    float f1 = paramRect.exactCenterX();
    float f2 = paramRect.exactCenterY();
    double d1 = getWidth() >> 1;
    double d2 = getHeight() >> 1;
    d1 = f1 - d1;
    d2 = f2 - d2;
    double d3 = Math.sqrt(d1 * d1 + d2 * d2);
    paramRect = Double.valueOf(Math.toDegrees(Double.valueOf(Math.atan2(d2, d1)).doubleValue()));
    paramRect.doubleValue();
    paramRect.doubleValue();
    paramRect = Double.valueOf(paramRect.doubleValue() + 90.0D);
    double d4 = paramRect.doubleValue();
    d2 = paramRect.doubleValue();
    d1 = d2;
    if (d4 < 0.0D) {
      d1 = d2 + 360.0D;
    }
    this.X3[0] = (Double.valueOf(d1).floatValue() / 360.0F);
    f1 = (float)(d3 / (this.p2 - this.N3));
    this.X3[1] = Math.max(0.0F, Math.min(1.0F, f1));
    paramRect = this.X3;
    paramRect[2] = 1.0F;
    return paramRect;
  }
  
  private int e(Rect paramRect)
  {
    float f1 = paramRect.exactCenterX();
    float f2 = paramRect.exactCenterY();
    int i = Math.round(Math.abs(f1 - this.J3 / 2.0F - this.N3));
    int j = Math.round(f2);
    return this.p1.getPixel(i, j);
  }
  
  private Bitmap f(int paramInt1, int paramInt2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    float f1 = paramInt1 / 2.0F;
    float f2 = paramInt2 / 2.0F;
    paramArrayOfInt = new SweepGradient(f1, f2, paramArrayOfInt, paramArrayOfFloat);
    paramArrayOfFloat = new Matrix();
    paramArrayOfFloat.postRotate(-90.0F, f1, f2);
    paramArrayOfInt.setLocalMatrix(paramArrayOfFloat);
    paramArrayOfInt = new ComposeShader(paramArrayOfInt, new RadialGradient(f1, f2, this.p2, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER);
    this.p0.setShader(paramArrayOfInt);
    this.U3.setBitmap(localBitmap);
    this.U3.drawCircle(f1, f2, this.p2, this.p0);
    g(this.U3, paramInt1, paramInt2);
    return localBitmap;
  }
  
  private void g(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.drawCircle(paramInt1 / 2.0F, paramInt2 / 2.0F, this.p2, this.p3);
  }
  
  private a getSelectedCursor()
  {
    return this.y;
  }
  
  private int h(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private void i(Rect paramRect, Canvas paramCanvas)
  {
    int i = this.J3;
    int j = 1;
    int k = this.K3;
    float f1 = paramRect.exactCenterX();
    float f2 = paramRect.exactCenterY();
    float f3 = i >> 1;
    int m = (int)(f1 - f3);
    i = (int)(f1 + f3);
    if (m < 0)
    {
      i = this.J3;
      m = 1;
    }
    else
    {
      f3 = i;
      f1 = this.x.right;
      if (f3 > f1)
      {
        i = (int)f1;
        m = i - this.J3;
      }
    }
    f1 = k >> 1;
    int n = (int)(f2 - f1);
    k = (int)(f2 + f1);
    if (n < 0)
    {
      k = this.K3;
    }
    else
    {
      f1 = k;
      f2 = this.x.bottom;
      if (f1 > f2)
      {
        k = (int)f2;
        j = k - this.K3;
      }
      else
      {
        j = n;
      }
    }
    setCircularDrawableColor(paramRect);
    this.H3.setBounds(m, j, i, k);
    this.H3.draw(paramCanvas);
  }
  
  private void j(List<a> paramList, Canvas paramCanvas)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!locala.a().equals(this.y.a())) {
          i(locala.a(), paramCanvas);
        }
      }
      if (this.W3) {
        l(this.y.a(), paramCanvas);
      } else {
        i(this.y.a(), paramCanvas);
      }
    }
  }
  
  private void k(Canvas paramCanvas)
  {
    float f1 = this.J3 / 2.0F;
    paramCanvas.drawBitmap(this.p1, f1, 0.0F, null);
  }
  
  private void l(Rect paramRect, Canvas paramCanvas)
  {
    int i = this.L3;
    int j = 1;
    int k = this.M3;
    float f1 = paramRect.exactCenterX();
    float f2 = paramRect.exactCenterY();
    float f3 = i >> 1;
    int m = (int)(f1 - f3);
    i = (int)(f1 + f3);
    if (m < 0)
    {
      i = this.L3;
      m = 1;
    }
    else
    {
      f1 = i;
      f3 = this.x.right;
      if (f1 > f3)
      {
        i = (int)f3;
        m = i - this.L3;
      }
    }
    f1 = k >> 1;
    int n = (int)(f2 - f1);
    k = (int)(f2 + f1);
    if (n < 0)
    {
      k = this.M3;
    }
    else
    {
      f2 = k;
      f1 = this.x.bottom;
      if (f2 > f1)
      {
        k = (int)f1;
        j = k - this.M3;
      }
      else
      {
        j = n;
      }
    }
    setSelectedCircularDrawableColor(paramRect);
    this.I3.setBounds(m, j, i, k);
    this.I3.draw(paramCanvas);
  }
  
  private int[] m()
  {
    return o();
  }
  
  @NonNull
  private TreeMap<Float, b> n(int[] paramArrayOfInt)
  {
    TreeMap localTreeMap = new TreeMap();
    float f1 = 360.0F / paramArrayOfInt.length / 360.0F;
    int i = paramArrayOfInt.length;
    float f2 = 0.0F;
    for (int j = 0; j < i; j++)
    {
      float f3 = b(paramArrayOfInt[j])[0];
      localTreeMap.put(Float.valueOf(f3), new b(f3, f2));
      f2 += f1;
    }
    return localTreeMap;
  }
  
  private int[] o()
  {
    int[] arrayOfInt = new int[13];
    float[] arrayOfFloat = new float[3];
    float[] tmp10_9 = arrayOfFloat;
    tmp10_9[0] = 0.0F;
    float[] tmp14_10 = tmp10_9;
    tmp14_10[1] = 1.0F;
    float[] tmp18_14 = tmp14_10;
    tmp18_14[2] = 1.0F;
    tmp18_14;
    for (int i = 0; i < 13; i++)
    {
      arrayOfFloat[0] = (i * 30 % 360);
      arrayOfInt[i] = Color.HSVToColor(arrayOfFloat);
    }
    arrayOfInt[12] = arrayOfInt[0];
    return arrayOfInt;
  }
  
  private float[] p(int paramInt)
  {
    int i = paramInt - 1;
    float f1 = 1.0F / i;
    float[] arrayOfFloat = new float[paramInt];
    float f2 = 0.0F;
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      arrayOfFloat[paramInt] = f2;
      f2 += f1;
    }
    arrayOfFloat[i] = 1.0F;
    return arrayOfFloat;
  }
  
  @Nullable
  private float[] q(float[] paramArrayOfFloat)
  {
    float f1 = this.p2;
    if (f1 > 0.0F)
    {
      float f2 = this.N3;
      if (f2 > 0.0F)
      {
        f2 = f1 - f2;
        float f3 = getWidth() >> 1;
        f1 = getHeight() >> 1;
        double d1 = Math.min(paramArrayOfFloat[1] * f2, f2);
        double d2 = 180.0F - paramArrayOfFloat[0] * 360.0F;
        double d3 = Math.sin(Math.toRadians(d2));
        d2 = Math.cos(Math.toRadians(d2));
        return new float[] { (float)(f3 + d3 * d1), (float)(f1 + d1 * d2) };
      }
    }
    return null;
  }
  
  private float[] r(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    float f1 = this.p2 - this.N3;
    float f2 = this.p1.getWidth() / 2.0F;
    double d1 = getWidth() >> 1;
    double d2 = getHeight() >> 1;
    double d3 = s(paramFloat1, paramFloat2);
    d1 = paramFloat1 - d1;
    double d4 = Math.abs(d1);
    double d5 = paramFloat2 - d2;
    double d6 = Math.abs(d5);
    Double localDouble = Double.valueOf(Double.valueOf(Math.toDegrees(Double.valueOf(Math.atan2(d5, d1)).doubleValue())).doubleValue() + 90.0D);
    double d7 = localDouble.doubleValue();
    d5 = localDouble.doubleValue();
    d1 = d5;
    if (d7 < 0.0D) {
      d1 = d5 + 360.0D;
    }
    localDouble = Double.valueOf(d1);
    if ((localDouble.doubleValue() >= 0.0D) && (localDouble.doubleValue() <= 90.0D))
    {
      d5 = f2;
      d1 = f1;
      arrayOfFloat[0] = ((float)(d5 + d4 * d1 / d3));
      arrayOfFloat[1] = ((float)Math.abs(d6 * d1 / d3 - d2));
    }
    else if ((localDouble.doubleValue() > 90.0D) && (localDouble.doubleValue() <= 180.0D))
    {
      d1 = f2;
      d5 = f1;
      arrayOfFloat[0] = ((float)(d1 + d4 * d5 / d3));
      arrayOfFloat[1] = ((float)(d6 * d5 / d3 + d2));
    }
    else if ((localDouble.doubleValue() > 180.0D) && (localDouble.doubleValue() <= 270.0D))
    {
      d1 = f2;
      d5 = f1;
      arrayOfFloat[0] = ((float)Math.abs(d1 - d4 * d5 / d3));
      arrayOfFloat[1] = ((float)(d6 * d5 / d3 + d2));
    }
    else
    {
      d1 = f2;
      d5 = f1;
      arrayOfFloat[0] = ((float)Math.abs(d1 - d4 * d5 / d3));
      arrayOfFloat[1] = ((float)Math.abs(d6 * d5 / d3 - d2));
    }
    return arrayOfFloat;
  }
  
  private double s(float paramFloat1, float paramFloat2)
  {
    double d1 = getWidth() >> 1;
    double d2 = getHeight() >> 1;
    d1 = paramFloat1 - d1;
    d2 = paramFloat2 - d2;
    return Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  private void setCircularDrawableColor(Rect paramRect)
  {
    if (paramRect != null)
    {
      Object localObject = (LayerDrawable)this.H3;
      try
      {
        localObject = (GradientDrawable)((LayerDrawable)localObject).findDrawableByLayerId(2131362636);
        ((GradientDrawable)localObject).mutate();
        int i = e(paramRect);
        paramRect = (GradientDrawable)((GradientDrawable)localObject).getCurrent();
        paramRect.mutate();
        paramRect.setColor(i);
      }
      catch (ClassCastException|IllegalArgumentException paramRect)
      {
        Log.d(c, "setCircularDrawableColor: throws exception.");
      }
    }
  }
  
  private void setSelectedCircularDrawableColor(Rect paramRect)
  {
    if (paramRect != null)
    {
      Object localObject = (LayerDrawable)this.I3;
      try
      {
        localObject = (GradientDrawable)((LayerDrawable)localObject).findDrawableByLayerId(2131362340);
        ((GradientDrawable)localObject).mutate();
        int i = e(paramRect);
        paramRect = (GradientDrawable)((GradientDrawable)localObject).getCurrent();
        paramRect.mutate();
        paramRect.setStroke(this.V3, i);
      }
      catch (ClassCastException|IllegalArgumentException paramRect)
      {
        Log.d(c, "setCircularDrawableColor: throws exception.");
      }
    }
  }
  
  private void setSelectedCursor(a parama)
  {
    this.y = parama;
  }
  
  @Nullable
  private a t(MotionEvent paramMotionEvent)
  {
    for (int i = this.z.size() - 1; i >= 0; i--)
    {
      a locala = (a)this.z.get(i);
      if (z(paramMotionEvent.getX(), paramMotionEvent.getY(), locala.a())) {
        return locala;
      }
    }
    return null;
  }
  
  private void u(@Nullable AttributeSet paramAttributeSet)
  {
    v(paramAttributeSet);
    setActivated(true);
    this.H3.mutate();
    this.I3.mutate();
    this.U3 = new Canvas();
    paramAttributeSet = m();
    this.S3 = paramAttributeSet;
    this.Q3 = n(Arrays.copyOf(paramAttributeSet, paramAttributeSet.length - 1));
    this.T3 = p(this.S3.length);
    this.V3 = h(20);
    paramAttributeSet = new Paint();
    this.p0 = paramAttributeSet;
    paramAttributeSet.setAntiAlias(true);
    this.p0.setDither(true);
    paramAttributeSet = new Paint();
    this.p3 = paramAttributeSet;
    paramAttributeSet.setAntiAlias(true);
    this.p3.setDither(true);
    this.p3.setStrokeWidth(this.N3);
    this.p3.setStyle(Paint.Style.STROKE);
    this.p3.setColor(this.O3);
    if (isInEditMode()) {
      paramAttributeSet = null;
    } else {
      paramAttributeSet = this.p0;
    }
    setLayerType(1, paramAttributeSet);
  }
  
  /* Error */
  private void v(@Nullable AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: invokevirtual 379	android/view/View:getContext	()Landroid/content/Context;
    //   5: ldc_w 612
    //   8: invokestatic 618	androidx/core/content/ContextCompat:getDrawable	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   11: putfield 146	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:I3	Landroid/graphics/drawable/Drawable;
    //   14: aload_0
    //   15: invokevirtual 379	android/view/View:getContext	()Landroid/content/Context;
    //   18: aload_1
    //   19: getstatic 623	com/tplink/iot/b:MultiColorSpectrumPickerView	[I
    //   22: invokevirtual 627	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +79 -> 106
    //   30: aload_0
    //   31: aload_2
    //   32: iconst_1
    //   33: aload_0
    //   34: iconst_1
    //   35: invokespecial 578	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:h	(I)I
    //   38: invokevirtual 632	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   41: i2f
    //   42: putfield 120	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:N3	F
    //   45: aload_0
    //   46: aload_2
    //   47: iconst_0
    //   48: aload_0
    //   49: invokevirtual 379	android/view/View:getContext	()Landroid/content/Context;
    //   52: ldc_w 633
    //   55: invokestatic 637	androidx/core/content/ContextCompat:getColor	(Landroid/content/Context;I)I
    //   58: invokevirtual 639	android/content/res/TypedArray:getColor	(II)I
    //   61: putfield 601	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:O3	I
    //   64: aload_0
    //   65: aload_2
    //   66: iconst_3
    //   67: iconst_1
    //   68: invokevirtual 643	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   71: putfield 645	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:R3	Z
    //   74: aload_2
    //   75: iconst_2
    //   76: invokevirtual 647	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   79: astore_1
    //   80: aload_0
    //   81: aload_1
    //   82: putfield 125	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:H3	Landroid/graphics/drawable/Drawable;
    //   85: aload_1
    //   86: ifnonnull +82 -> 168
    //   89: aload_0
    //   90: aload_0
    //   91: invokevirtual 379	android/view/View:getContext	()Landroid/content/Context;
    //   94: ldc_w 648
    //   97: invokestatic 618	androidx/core/content/ContextCompat:getDrawable	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   100: putfield 125	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:H3	Landroid/graphics/drawable/Drawable;
    //   103: goto +65 -> 168
    //   106: aload_0
    //   107: aload_0
    //   108: iconst_1
    //   109: invokespecial 578	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:h	(I)I
    //   112: i2f
    //   113: putfield 120	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:N3	F
    //   116: aload_0
    //   117: aload_0
    //   118: invokevirtual 649	android/view/View:getResources	()Landroid/content/res/Resources;
    //   121: ldc_w 633
    //   124: invokevirtual 651	android/content/res/Resources:getColor	(I)I
    //   127: putfield 601	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:O3	I
    //   130: aload_0
    //   131: iconst_1
    //   132: putfield 645	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:R3	Z
    //   135: aload_0
    //   136: aload_0
    //   137: invokevirtual 379	android/view/View:getContext	()Landroid/content/Context;
    //   140: ldc_w 648
    //   143: invokestatic 618	androidx/core/content/ContextCompat:getDrawable	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   146: putfield 125	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:H3	Landroid/graphics/drawable/Drawable;
    //   149: goto +19 -> 168
    //   152: astore_1
    //   153: goto +20 -> 173
    //   156: astore_1
    //   157: getstatic 62	com/tplink/iot/devices/lightstrip/widget/multicolorpalette/MultiColorSpectrumPickerView:c	Ljava/lang/String;
    //   160: aload_1
    //   161: invokestatic 655	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: invokestatic 657	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aload_2
    //   169: invokevirtual 660	android/content/res/TypedArray:recycle	()V
    //   172: return
    //   173: aload_2
    //   174: invokevirtual 660	android/content/res/TypedArray:recycle	()V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	MultiColorSpectrumPickerView
    //   0	179	1	paramAttributeSet	AttributeSet
    //   25	149	2	localTypedArray	android.content.res.TypedArray
    // Exception table:
    //   from	to	target	type
    //   30	85	152	finally
    //   89	103	152	finally
    //   106	149	152	finally
    //   157	168	152	finally
    //   30	85	156	java/lang/Exception
    //   89	103	156	java/lang/Exception
    //   106	149	156	java/lang/Exception
  }
  
  private boolean w(Rect paramRect)
  {
    boolean bool = true;
    if (paramRect == null) {
      return true;
    }
    if ((paramRect.left != 0) || (paramRect.right != 0) || (paramRect.top != 0) || (paramRect.bottom != 0)) {
      bool = false;
    }
    return bool;
  }
  
  private boolean x(List<a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (w(((a)paramList.next()).a())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean y(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (Math.pow(s(paramFloat1, paramFloat2), 2.0D) < Math.pow(this.p2 - this.N3, 2.0D)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean z(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    return paramRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  protected void B(a parama, boolean paramBoolean)
  {
    if (this.P3 != null)
    {
      float[] arrayOfFloat = d(parama.a());
      float f1 = arrayOfFloat[0];
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifySelectionChanged rawHue = ");
      localStringBuilder.append(360.0F * f1);
      Log.d(str, localStringBuilder.toString());
      arrayOfFloat[0] = c(f1);
      try
      {
        this.P3.a(arrayOfFloat, paramBoolean, parama);
      }
      catch (IllegalArgumentException parama)
      {
        Log.d(c, Log.getStackTraceString(parama));
      }
    }
  }
  
  public void C()
  {
    if (this.z.isEmpty()) {
      return;
    }
    List localList = this.z;
    localList.remove(localList.size() - 1);
    if (this.z.isEmpty()) {
      return;
    }
    localList = this.z;
    setSelectedCursor((a)localList.get(localList.size() - 1));
  }
  
  public void E(int paramInt, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = q(paramArrayOfFloat);
    if (arrayOfFloat == null) {
      return;
    }
    Object localObject = null;
    try
    {
      a locala = (a)this.z.get(paramInt);
      paramArrayOfFloat = (float[])localObject;
      if (locala != null) {
        paramArrayOfFloat = locala.a();
      }
    }
    catch (IndexOutOfBoundsException paramArrayOfFloat)
    {
      paramArrayOfFloat.printStackTrace();
      paramArrayOfFloat = (float[])localObject;
    }
    if (paramArrayOfFloat == null) {
      return;
    }
    G(paramArrayOfFloat, Math.round(arrayOfFloat[0]), Math.round(arrayOfFloat[1]));
    invalidate();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    int i = this.J3 / 2;
    int j = (int)this.x.centerX();
    int k = (int)this.x.centerY();
    Rect localRect = new Rect(j - i, k - i, j + i, k + i);
    paramArrayOfFloat = q(paramArrayOfFloat);
    if (paramArrayOfFloat != null) {
      G(localRect, Math.round(paramArrayOfFloat[0]), Math.round(paramArrayOfFloat[1]));
    }
    paramArrayOfFloat = new a(this.z.size(), localRect);
    setSelectedCursor(paramArrayOfFloat);
    this.z.add(paramArrayOfFloat);
  }
  
  @VisibleForTesting
  public float getColorWheelRadius()
  {
    return this.p2;
  }
  
  public int getNumCursors()
  {
    return this.z.size();
  }
  
  public float[] getSelectedValue()
  {
    return d(this.y.a());
  }
  
  public List<float[]> getSelectedValues()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(d(((a)localIterator.next()).a()).clone());
    }
    return localArrayList;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    k(paramCanvas);
    if ((!x(this.z)) && (isActivated())) {
      j(this.z, paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    RectF localRectF = this.x;
    paramInt1 = paramInt3 - paramInt1;
    float f1 = paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    localRectF.set(0.0F, 0.0F, f1, paramInt2);
    D();
    paramInt1 -= this.J3;
    this.p2 = (paramInt1 / 2.0F - this.N3);
    if (paramBoolean) {
      this.p1 = f(paramInt1, paramInt2, this.S3, this.T3);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isActivated())
    {
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      boolean bool = this.R3;
      Object localObject;
      if (((bool) || (i != 2)) && (i != 3) && (i != 1))
      {
        if (bool)
        {
          localObject = (a)this.z.get(0);
        }
        else
        {
          a locala = t(paramMotionEvent);
          localObject = locala;
          if (locala == null)
          {
            this.W3 = false;
            return false;
          }
        }
        setSelectedCursor((a)localObject);
      }
      else
      {
        localObject = getSelectedCursor();
      }
      if (A(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        this.f = ((int)paramMotionEvent.getX());
        this.q = ((int)paramMotionEvent.getY());
        bool = G(((a)localObject).a(), this.f, this.q);
        if (bool) {
          invalidate();
        }
        i = paramMotionEvent.getAction();
        if (i != 0) {
          if (i != 1)
          {
            if (i != 2) {
              break label262;
            }
          }
          else
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            B((a)localObject, true);
            this.W3 = false;
            invalidate();
            return true;
          }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (bool) {
          B((a)localObject, false);
        }
        this.W3 = true;
        return true;
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        B((a)localObject, true);
        this.W3 = false;
        invalidate();
        return true;
      }
    }
    label262:
    this.W3 = false;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCursors(List<c> paramList)
  {
    if (!paramList.isEmpty()) {
      this.z.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      a(new float[] { localc.b() / 360.0F, localc.c() / 100.0F, 1.0F });
    }
  }
  
  public void setSelectedCursor(float[] paramArrayOfFloat)
  {
    a locala = getSelectedCursor();
    int i;
    if (locala != null) {
      i = locala.b();
    } else {
      i = 0;
    }
    E(i, paramArrayOfFloat);
  }
  
  public void setSpectrumSelectionListener(a parama)
  {
    this.P3 = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(float[] paramArrayOfFloat, boolean paramBoolean, a parama);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\MultiColorSpectrumPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */