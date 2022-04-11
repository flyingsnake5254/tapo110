package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable
  extends MaterialShapeDrawable
{
  @NonNull
  private final RectF cutoutBounds;
  @NonNull
  private final Paint cutoutPaint = new Paint(1);
  private int savedLayer;
  
  CutoutDrawable()
  {
    this(null);
  }
  
  CutoutDrawable(@Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    super(paramShapeAppearanceModel);
    setPaintStyles();
    this.cutoutBounds = new RectF();
  }
  
  private void postDraw(@NonNull Canvas paramCanvas)
  {
    if (!useHardwareLayer(getCallback())) {
      paramCanvas.restoreToCount(this.savedLayer);
    }
  }
  
  private void preDraw(@NonNull Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if (useHardwareLayer(localCallback))
    {
      paramCanvas = (View)localCallback;
      if (paramCanvas.getLayerType() != 2) {
        paramCanvas.setLayerType(2, null);
      }
    }
    else
    {
      saveCanvasLayer(paramCanvas);
    }
  }
  
  private void saveCanvasLayer(@NonNull Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
    } else {
      this.savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    }
  }
  
  private void setPaintStyles()
  {
    this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.cutoutPaint.setColor(-1);
    this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private boolean useHardwareLayer(Drawable.Callback paramCallback)
  {
    return paramCallback instanceof View;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    preDraw(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.cutoutBounds, this.cutoutPaint);
    postDraw(paramCanvas);
  }
  
  boolean hasCutout()
  {
    return this.cutoutBounds.isEmpty() ^ true;
  }
  
  void removeCutout()
  {
    setCutout(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void setCutout(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = this.cutoutBounds;
    if ((paramFloat1 != localRectF.left) || (paramFloat2 != localRectF.top) || (paramFloat3 != localRectF.right) || (paramFloat4 != localRectF.bottom))
    {
      localRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  void setCutout(@NonNull RectF paramRectF)
  {
    setCutout(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\CutoutDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */