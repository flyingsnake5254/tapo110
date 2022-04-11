package com.tplink.libtpcontrols.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import com.tplink.libtpcontrols.z0.e;

public class TPCircleColorView
  extends View
{
  private int H3;
  private int I3;
  private int J3;
  private float[] K3 = { 0.0F, 0.0F, 1.0F };
  private boolean L3 = false;
  private boolean M3 = false;
  private final Paint c;
  private final Paint d;
  private final Paint f;
  private a p0 = null;
  private e p1;
  private int p2;
  private int p3;
  private final Path q;
  private final Path x;
  private final PointF y = new PointF();
  private Bitmap z;
  
  public TPCircleColorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPCircleColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.H3 = b(paramContext, 200.0F);
    this.J3 = b(paramContext, 6.0F);
    this.I3 = b(paramContext, 3.0F);
    paramAttributeSet = new Paint();
    this.c = paramAttributeSet;
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet = new Paint();
    this.d = paramAttributeSet;
    paramAttributeSet.setColor(-1);
    paramAttributeSet.setStrokeWidth(this.I3);
    paramAttributeSet.setStyle(Paint.Style.STROKE);
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet = new Paint();
    this.f = paramAttributeSet;
    paramAttributeSet.setColor(-1);
    paramAttributeSet.setStrokeWidth(b(paramContext, 3.0F));
    paramAttributeSet.setStyle(Paint.Style.STROKE);
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet = new Path();
    this.q = paramAttributeSet;
    paramAttributeSet.addCircle(0.0F, 0.0F, b(paramContext, 16.0F), Path.Direction.CW);
    this.x = new Path();
  }
  
  private boolean a(PointF paramPointF, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    paramFloat1 = Math.min(paramFloat1, this.p2);
    paramFloat2 = Math.min(paramFloat2, this.p3);
    float f1 = this.p2 / 2.0F - paramFloat1;
    float f2 = this.p3 / 2.0F - paramFloat2;
    float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    int i = this.p2;
    int j;
    if (f3 > i / 2.0F) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j == 0) || (!paramBoolean))
    {
      if (j != 0)
      {
        paramFloat1 = i / 2.0F - f1 * (i / 2.0F) / f3;
        paramFloat2 = i / 2.0F - f2 * (i / 2.0F) / f3;
      }
      paramPointF.set(paramFloat1, paramFloat2);
    }
    return j ^ 0x1;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private Bitmap c(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    int[] arrayOfInt = new int[13];
    Object localObject = new float[3];
    Object tmp22_20 = localObject;
    tmp22_20[0] = 0.0F;
    Object tmp26_22 = tmp22_20;
    tmp26_22[1] = 1.0F;
    Object tmp30_26 = tmp26_22;
    tmp30_26[2] = 1.0F;
    tmp30_26;
    for (int i = 0; i < 13; i++)
    {
      localObject[0] = (i * 30 % 360);
      arrayOfInt[i] = Color.HSVToColor((float[])localObject);
    }
    arrayOfInt[12] = arrayOfInt[0];
    float f1 = paramInt1 / 2.0F;
    float f2 = paramInt2 / 2.0F;
    localObject = new ComposeShader(new SweepGradient(f1, f2, arrayOfInt, null), new RadialGradient(f1, f2, f1, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER);
    this.c.setShader((Shader)localObject);
    new Canvas(localBitmap).drawCircle(f1, f2, f1, this.c);
    return localBitmap;
  }
  
  private float d(float paramFloat1, float paramFloat2)
  {
    double d1 = this.p2 / 2.0F;
    double d2 = (d1 - paramFloat1) / d1;
    return (float)(Math.atan2((d1 - paramFloat2) / d1, d2) * 360.0D / 6.283185307179586D + 180.0D);
  }
  
  private float e(float paramFloat1, float paramFloat2)
  {
    double d1 = this.p2 / 2.0F;
    double d2 = (d1 - paramFloat1) / d1;
    d1 = (d1 - paramFloat2) / d1;
    return (float)Math.sqrt(d2 * d2 + d1 * d1);
  }
  
  private void f(float paramFloat1, float paramFloat2)
  {
    double d1 = this.p2 / 2.0F;
    double d2 = paramFloat2 * d1;
    double d3 = (paramFloat1 - 180.0D) / 360.0D * 3.141592653589793D * 2.0D;
    double d4 = Math.cos(d3);
    d3 = Math.sin(d3);
    this.y.set((float)(d1 - d4 * d2), (float)(d1 - d2 * d3));
  }
  
  private void g()
  {
    Object localObject1 = this.K3;
    Object localObject2 = this.y;
    localObject1[0] = d(((PointF)localObject2).x, ((PointF)localObject2).y);
    localObject2 = this.K3;
    localObject1 = this.y;
    localObject2[1] = e(((PointF)localObject1).x, ((PointF)localObject1).y);
    localObject1 = this.K3;
    localObject1[2] = 1.0F;
    h(Color.HSVToColor((float[])localObject1));
  }
  
  private void h(int paramInt)
  {
    this.d.setColor(paramInt);
    a locala = this.p0;
    if (locala != null) {
      locala.g(paramInt & 0xFFFFFF, this.L3);
    }
    this.M3 = true;
    this.L3 = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.z;
    int i = this.I3;
    int j = this.J3;
    paramCanvas.drawBitmap((Bitmap)localObject, i + j, i + j, null);
    paramCanvas.drawPath(this.x, this.d);
    paramCanvas.save();
    if (Build.VERSION.SDK_INT >= 18) {
      paramCanvas.clipPath(this.x);
    }
    localObject = this.y;
    paramCanvas.translate(((PointF)localObject).x, ((PointF)localObject).y);
    paramCanvas.drawPath(this.q, this.f);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if (paramInt1 == 0) {
      paramInt1 = j;
    } else if (paramInt2 == 0) {
      paramInt1 = i;
    } else {
      paramInt1 = Math.min(i, j);
    }
    paramInt1 = Math.max(paramInt1, this.H3);
    setMeasuredDimension(paramInt1, paramInt1);
    this.p2 = paramInt1;
    this.p3 = paramInt1;
    this.x.reset();
    Object localObject = this.x;
    paramInt1 = this.p2;
    ((Path)localObject).addCircle(paramInt1 / 2.0F, this.p3 / 2.0F, paramInt1 / 2.0F - this.I3, Path.Direction.CW);
    if (this.z == null)
    {
      i = this.p2;
      paramInt2 = this.I3;
      paramInt1 = this.J3;
      this.z = c(i - (paramInt2 + paramInt1) * 2, i - (paramInt2 + paramInt1) * 2);
    }
    localObject = this.K3;
    f(localObject[0], localObject[1]);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label103;
          }
        }
        else
        {
          this.L3 = true;
          this.M3 = false;
          a(this.y, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
          g();
          getParent().requestDisallowInterceptTouchEvent(true);
          paramMotionEvent = this.p1;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(false);
          }
          return true;
        }
      }
      e locale = this.p1;
      if (locale != null) {
        locale.a(true);
      }
      label103:
      this.M3 = false;
      return super.onTouchEvent(paramMotionEvent);
    }
    this.L3 = true;
    this.M3 = false;
    boolean bool = a(this.y, paramMotionEvent.getX(), paramMotionEvent.getY(), true);
    if (bool)
    {
      g();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramMotionEvent = this.p1;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(false);
    }
    return bool;
  }
  
  public void setColor(int paramInt)
  {
    int i;
    if (paramInt > 16777215)
    {
      i = 16777215;
    }
    else
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    Color.colorToHSV(i | 0xFF000000, this.K3);
    float[] arrayOfFloat = this.K3;
    arrayOfFloat[2] = 1.0F;
    f(arrayOfFloat[0], arrayOfFloat[1]);
    h(Color.HSVToColor(this.K3));
    if (!this.M3) {
      this.L3 = false;
    }
  }
  
  public void setOnColorListener(a parama)
  {
    this.p0 = parama;
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.p1 = parame;
  }
  
  public static abstract interface a
  {
    public abstract void g(int paramInt, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\colorpicker\TPCircleColorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */