package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class TPRoundRectImageView
  extends AppCompatImageView
{
  private static final Xfermode c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private Paint d = null;
  
  public TPRoundRectImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPRoundRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPRoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a()
  {
    Object localObject = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas(localBitmap);
    localObject = new Paint(1);
    ((Paint)localObject).setColor(getResources().getColor(p0.white));
    localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), 21.0F, 21.0F, (Paint)localObject);
    return localBitmap;
  }
  
  private Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 > f2) {
      localMatrix.setScale(f1, f1);
    } else {
      localMatrix.setScale(f2, f2);
    }
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, paramBoolean);
  }
  
  private Bitmap c(Drawable paramDrawable)
  {
    return b(((BitmapDrawable)paramDrawable).getBitmap(), getWidth(), getHeight(), true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d == null) {
      this.d = new Paint();
    }
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.drawBitmap(c(getDrawable()), 0.0F, 0.0F, this.d);
    this.d.setXfermode(c);
    paramCanvas.drawBitmap(a(), 0.0F, 0.0F, this.d);
    this.d.setXfermode(null);
    paramCanvas.restore();
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.rgb(11, 150, 240));
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), 10.0F, 10.0F, localPaint);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPRoundRectImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */