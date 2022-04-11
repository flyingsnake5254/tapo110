package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer
{
  private static final int COLOR_ALPHA_END = 0;
  private static final int COLOR_ALPHA_MIDDLE = 20;
  private static final int COLOR_ALPHA_START = 68;
  private static final int[] cornerColors = new int[4];
  private static final float[] cornerPositions = { 0.0F, 0.0F, 0.5F, 1.0F };
  private static final int[] edgeColors = new int[3];
  private static final float[] edgePositions = { 0.0F, 0.5F, 1.0F };
  @NonNull
  private final Paint cornerShadowPaint;
  @NonNull
  private final Paint edgeShadowPaint;
  private final Path scratch = new Path();
  private int shadowEndColor;
  private int shadowMiddleColor;
  @NonNull
  private final Paint shadowPaint = new Paint();
  private int shadowStartColor;
  private Paint transparentPaint = new Paint();
  
  public ShadowRenderer()
  {
    this(-16777216);
  }
  
  public ShadowRenderer(int paramInt)
  {
    setShadowColor(paramInt);
    this.transparentPaint.setColor(0);
    Paint localPaint = new Paint(4);
    this.cornerShadowPaint = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.edgeShadowPaint = new Paint(localPaint);
  }
  
  public void drawCornerShadow(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i;
    if (paramFloat2 < 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    Path localPath = this.scratch;
    if (i != 0)
    {
      localObject = cornerColors;
      localObject[0] = 0;
      localObject[1] = this.shadowEndColor;
      localObject[2] = this.shadowMiddleColor;
      localObject[3] = this.shadowStartColor;
    }
    else
    {
      localPath.rewind();
      localPath.moveTo(paramRectF.centerX(), paramRectF.centerY());
      localPath.arcTo(paramRectF, paramFloat1, paramFloat2);
      localPath.close();
      f1 = -paramInt;
      paramRectF.inset(f1, f1);
      localObject = cornerColors;
      localObject[0] = 0;
      localObject[1] = this.shadowStartColor;
      localObject[2] = this.shadowMiddleColor;
      localObject[3] = this.shadowEndColor;
    }
    float f1 = paramRectF.width() / 2.0F;
    if (f1 <= 0.0F) {
      return;
    }
    float f2 = 1.0F - paramInt / f1;
    float f3 = (1.0F - f2) / 2.0F;
    Object localObject = cornerPositions;
    localObject[1] = f2;
    localObject[2] = (f3 + f2);
    this.cornerShadowPaint.setShader(new RadialGradient(paramRectF.centerX(), paramRectF.centerY(), f1, cornerColors, (float[])localObject, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    if (i == 0)
    {
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath, this.transparentPaint);
    }
    paramCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, true, this.cornerShadowPaint);
    paramCanvas.restore();
  }
  
  public void drawEdgeShadow(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt)
  {
    paramRectF.bottom += paramInt;
    paramRectF.offset(0.0F, -paramInt);
    int[] arrayOfInt = edgeColors;
    arrayOfInt[0] = this.shadowEndColor;
    arrayOfInt[1] = this.shadowMiddleColor;
    arrayOfInt[2] = this.shadowStartColor;
    Paint localPaint = this.edgeShadowPaint;
    float f = paramRectF.left;
    localPaint.setShader(new LinearGradient(f, paramRectF.top, f, paramRectF.bottom, arrayOfInt, edgePositions, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.drawRect(paramRectF, this.edgeShadowPaint);
    paramCanvas.restore();
  }
  
  @NonNull
  public Paint getShadowPaint()
  {
    return this.shadowPaint;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.shadowStartColor = ColorUtils.setAlphaComponent(paramInt, 68);
    this.shadowMiddleColor = ColorUtils.setAlphaComponent(paramInt, 20);
    this.shadowEndColor = ColorUtils.setAlphaComponent(paramInt, 0);
    this.shadowPaint.setColor(this.shadowStartColor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shadow\ShadowRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */