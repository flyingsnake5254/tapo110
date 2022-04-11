package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.tplink.iot.b;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightingEffectPointView
  extends AppCompatImageView
{
  public static final a c = new a(null);
  private final int d = (int)f(24);
  private final float f;
  private int p0;
  private boolean p1;
  private int p2;
  private final Paint q;
  private float x;
  private int y;
  private final Paint z;
  
  public LightingEffectPointView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightingEffectPointView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightingEffectPointView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = f(2);
    this.f = f1;
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(f1);
    localPaint.setColor(-1);
    p localp = p.a;
    this.q = localPaint;
    this.y = -1;
    this.z = new Paint(3);
    this.p2 = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.LightingEffectPointView);
    this.x = paramContext.getDimension(0, 0.0F);
    paramContext.recycle();
  }
  
  private final void a(Canvas paramCanvas)
  {
    Object localObject1 = getDrawable();
    Object localObject2 = getImageMatrix();
    if (localObject1 == null) {
      return;
    }
    if ((((Drawable)localObject1).getIntrinsicWidth() != 0) && (((Drawable)localObject1).getIntrinsicHeight() != 0)) {
      if ((localObject2 == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
      {
        ((Drawable)localObject1).draw(paramCanvas);
      }
      else
      {
        int i = paramCanvas.getSaveCount();
        paramCanvas.save();
        if (getCropToPadding())
        {
          int j = getScrollX();
          int k = getScrollY();
          paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
        }
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        if (!this.p1)
        {
          Bitmap localBitmap = e((Drawable)localObject1);
          localObject1 = this.z;
          localObject2 = Shader.TileMode.CLAMP;
          ((Paint)localObject1).setShader(new BitmapShader(localBitmap, (Shader.TileMode)localObject2, (Shader.TileMode)localObject2));
          this.p1 = true;
        }
        paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2.0F, this.z);
        paramCanvas.restoreToCount(i);
      }
    }
  }
  
  private final void b(Canvas paramCanvas)
  {
    this.z.setShader(null);
    this.z.setColor(this.y);
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2.0F - this.x, this.z);
  }
  
  private final void c(Canvas paramCanvas)
  {
    if ((this.z.getShader() == null) || (!this.p1))
    {
      this.p1 = false;
      int i = this.p2;
      if (i == -1) {
        i = 2131689895;
      }
      setImageResource(i);
    }
    a(paramCanvas);
  }
  
  private final void d(Canvas paramCanvas)
  {
    float f1 = (getWidth() - this.f) / 2.0F;
    float f2 = this.x;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1 - f2, this.q);
  }
  
  private final Bitmap e(Drawable paramDrawable)
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    if (paramDrawable == null)
    {
      j.d(localBitmap, "bitmap");
      return localBitmap;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Matrix localMatrix = getImageMatrix();
    if (localMatrix != null) {
      localCanvas.concat(localMatrix);
    }
    paramDrawable.draw(localCanvas);
    j.d(localBitmap, "bitmap");
    return localBitmap;
  }
  
  private final float f(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(1, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  private final int g(int paramInt)
  {
    int i = this.d;
    int j = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0)
      {
        if (j != 1073741824) {
          paramInt = i;
        }
      }
      else {
        paramInt = this.d;
      }
    }
    else {
      paramInt = Math.min(this.d, paramInt);
    }
    return paramInt;
  }
  
  public final void h(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 0)
    {
      i = paramInt;
      if (paramInt != 1) {
        i = -1;
      }
    }
    this.p0 = i;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    int i = this.p0;
    if (i != 0)
    {
      if (i == 1) {
        c(paramCanvas);
      }
    }
    else
    {
      b(paramCanvas);
      d(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(g(paramInt1), g(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public final void setColor(@ColorInt int paramInt)
  {
    this.y = paramInt;
    invalidate();
  }
  
  public final void setColorAndUpdateContent(@ColorInt int paramInt)
  {
    this.y = paramInt;
    this.p0 = 0;
    invalidate();
  }
  
  public final void setEffectImageId(@DrawableRes int paramInt)
  {
    this.p1 = false;
    this.p2 = paramInt;
  }
  
  public final void setOutlineColor(@ColorInt int paramInt)
  {
    this.q.setColor(paramInt);
    invalidate();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightingEffectPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */