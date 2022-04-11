package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

public class g
  extends c
{
  private RectF x = new RectF();
  
  public g(@NonNull ColorStateList paramColorStateList)
  {
    super(paramColorStateList);
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    this.x.set(getBounds());
    RectF localRectF = this.x;
    paramCanvas.drawRoundRect(localRectF, localRectF.height() / 2.0F, this.x.height() / 2.0F, paramPaint);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */