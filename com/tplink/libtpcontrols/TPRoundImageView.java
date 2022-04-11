package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class TPRoundImageView
  extends AppCompatImageView
{
  private int c;
  private int d;
  private Paint f;
  private RectF p0;
  private int q;
  private Matrix x = new Matrix();
  private BitmapShader y;
  private int z;
  
  public TPRoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Paint localPaint = new Paint();
    this.f = localPaint;
    localPaint.setAntiAlias(true);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.RoundImageView);
    this.d = paramContext.getDimensionPixelSize(x0.RoundImageView_borderRadius, (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.c = paramContext.getInt(x0.RoundImageView_type, 0);
    paramContext.recycle();
  }
  
  private Bitmap b(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void c()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    Bitmap localBitmap = b((Drawable)localObject);
    localObject = Shader.TileMode.CLAMP;
    this.y = new BitmapShader(localBitmap, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
    int i = this.c;
    float f1 = 1.0F;
    float f2;
    if (i == 0)
    {
      i = Math.min(localBitmap.getWidth(), localBitmap.getHeight());
      f2 = this.z * 1.0F / i;
    }
    else
    {
      f2 = f1;
      if (i == 1) {
        if (localBitmap.getWidth() == getWidth())
        {
          f2 = f1;
          if (localBitmap.getHeight() == getHeight()) {}
        }
        else
        {
          f2 = Math.max(getWidth() * 1.0F / localBitmap.getWidth(), getHeight() * 1.0F / localBitmap.getHeight());
        }
      }
    }
    this.x.setScale(f2, f2);
    this.y.setLocalMatrix(this.x);
    this.f.setShader(this.y);
  }
  
  public int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    c();
    int i;
    if (this.c == 1)
    {
      RectF localRectF = this.p0;
      i = this.d;
      paramCanvas.drawRoundRect(localRectF, i, i, this.f);
    }
    else
    {
      i = this.q;
      paramCanvas.drawCircle(i, i, i, this.f);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c == 0)
    {
      paramInt1 = Math.min(getMeasuredWidth(), getMeasuredHeight());
      this.z = paramInt1;
      this.q = (paramInt1 / 2);
      setMeasuredDimension(paramInt1, paramInt1);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getParcelable("state_instance"));
      this.c = paramParcelable.getInt("state_type");
      this.d = paramParcelable.getInt("state_border_radius");
    }
    else
    {
      super.onRestoreInstanceState(paramParcelable);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("state_instance", super.onSaveInstanceState());
    localBundle.putInt("state_type", this.c);
    localBundle.putInt("state_border_radius", this.d);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c == 1) {
      this.p0 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    }
  }
  
  public void setBorderRadius(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.d != paramInt)
    {
      this.d = paramInt;
      invalidate();
    }
  }
  
  public void setType(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      if ((paramInt != 1) && (paramInt != 0)) {
        this.c = 0;
      }
      requestLayout();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPRoundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */