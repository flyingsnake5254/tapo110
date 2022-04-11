package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
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
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class CircleEffectImageView
  extends LightingEffectBaseView
{
  private final float M3;
  private final Paint N3;
  private final Paint O3;
  private boolean P3;
  
  public CircleEffectImageView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public CircleEffectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public CircleEffectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = e(2);
    this.M3 = f;
    this.N3 = new Paint(1);
    paramContext = new Paint(1);
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setStrokeWidth(f);
    paramContext.setColor(536870912);
    paramAttributeSet = p.a;
    this.O3 = paramContext;
  }
  
  private final Bitmap k(Drawable paramDrawable)
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
  
  public void c(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
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
        if (!this.P3)
        {
          Bitmap localBitmap = k((Drawable)localObject1);
          localObject1 = this.N3;
          localObject2 = Shader.TileMode.CLAMP;
          ((Paint)localObject1).setShader(new BitmapShader(localBitmap, (Shader.TileMode)localObject2, (Shader.TileMode)localObject2));
          this.P3 = true;
        }
        paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2.0F - getMHaloWidth() - getMGapWidth(), this.N3);
        float f1 = (getWidth() - this.M3) / 2.0F;
        float f2 = getMHaloWidth();
        float f3 = getMGapWidth();
        paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1 - f2 - f3, this.O3);
        paramCanvas.restoreToCount(i);
      }
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.P3 = false;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.P3 = false;
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.P3 = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\CircleEffectImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */