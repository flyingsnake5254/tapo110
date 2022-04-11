package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class RoundedBitmapDrawable
  extends Drawable
{
  private static final int DEFAULT_PAINT_FLAGS = 3;
  private boolean mApplyGravity = true;
  final Bitmap mBitmap;
  private int mBitmapHeight;
  private final BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private float mCornerRadius;
  final Rect mDstRect = new Rect();
  private final RectF mDstRectF = new RectF();
  private int mGravity = 119;
  private boolean mIsCircular;
  private final Paint mPaint = new Paint(3);
  private final Matrix mShaderMatrix = new Matrix();
  private int mTargetDensity = 160;
  
  RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      computeBitmapSize();
      paramResources = Shader.TileMode.CLAMP;
      this.mBitmapShader = new BitmapShader(paramBitmap, paramResources, paramResources);
    }
    else
    {
      this.mBitmapHeight = -1;
      this.mBitmapWidth = -1;
      this.mBitmapShader = null;
    }
  }
  
  private void computeBitmapSize()
  {
    this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  private static boolean isGreaterThanZero(float paramFloat)
  {
    boolean bool;
    if (paramFloat > 0.05F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void updateCircularCornerRadius()
  {
    this.mCornerRadius = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = this.mBitmap;
    if (localObject == null) {
      return;
    }
    updateDstRect();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.mDstRect, this.mPaint);
    }
    else
    {
      localObject = this.mDstRectF;
      float f = this.mCornerRadius;
      paramCanvas.drawRoundRect((RectF)localObject, f, f, this.mPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  @Nullable
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public float getCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    int i = this.mGravity;
    int j = -3;
    int k = j;
    if (i == 119) {
      if (this.mIsCircular)
      {
        k = j;
      }
      else
      {
        Bitmap localBitmap = this.mBitmap;
        k = j;
        if (localBitmap != null)
        {
          k = j;
          if (!localBitmap.hasAlpha())
          {
            k = j;
            if (this.mPaint.getAlpha() >= 255) {
              if (isGreaterThanZero(this.mCornerRadius)) {
                k = j;
              } else {
                k = -1;
              }
            }
          }
        }
      }
    }
    return k;
  }
  
  @NonNull
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasAntiAlias()
  {
    return this.mPaint.isAntiAlias();
  }
  
  public boolean hasMipMap()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isCircular()
  {
    return this.mIsCircular;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.mIsCircular) {
      updateCircularCornerRadius();
    }
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setCircular(boolean paramBoolean)
  {
    this.mIsCircular = paramBoolean;
    this.mApplyGravity = true;
    if (paramBoolean)
    {
      updateCircularCornerRadius();
      this.mPaint.setShader(this.mBitmapShader);
      invalidateSelf();
    }
    else
    {
      setCornerRadius(0.0F);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setCornerRadius(float paramFloat)
  {
    if (this.mCornerRadius == paramFloat) {
      return;
    }
    this.mIsCircular = false;
    if (isGreaterThanZero(paramFloat)) {
      this.mPaint.setShader(this.mBitmapShader);
    } else {
      this.mPaint.setShader(null);
    }
    this.mCornerRadius = paramFloat;
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      this.mApplyGravity = true;
      invalidateSelf();
    }
  }
  
  public void setMipMap(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.mTargetDensity != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      if (this.mBitmap != null) {
        computeBitmapSize();
      }
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(@NonNull Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(@NonNull DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
  
  void updateDstRect()
  {
    if (this.mApplyGravity)
    {
      if (this.mIsCircular)
      {
        int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, i, i, getBounds(), this.mDstRect);
        int j = Math.min(this.mDstRect.width(), this.mDstRect.height());
        int k = Math.max(0, (this.mDstRect.width() - j) / 2);
        i = Math.max(0, (this.mDstRect.height() - j) / 2);
        this.mDstRect.inset(k, i);
        this.mCornerRadius = (j * 0.5F);
      }
      else
      {
        gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
      }
      this.mDstRectF.set(this.mDstRect);
      if (this.mBitmapShader != null)
      {
        Matrix localMatrix = this.mShaderMatrix;
        RectF localRectF = this.mDstRectF;
        localMatrix.setTranslate(localRectF.left, localRectF.top);
        this.mShaderMatrix.preScale(this.mDstRectF.width() / this.mBitmap.getWidth(), this.mDstRectF.height() / this.mBitmap.getHeight());
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mPaint.setShader(this.mBitmapShader);
      }
      this.mApplyGravity = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\RoundedBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */