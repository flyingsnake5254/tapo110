package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R.color;
import androidx.cardview.R.dimen;

class RoundRectDrawableWithShadow
  extends Drawable
{
  private static final double COS_45 = Math.cos(Math.toRadians(45.0D));
  private static final float SHADOW_MULTIPLIER = 1.5F;
  static RoundRectHelper sRoundRectHelper;
  private boolean mAddPaddingForCorners = true;
  private ColorStateList mBackground;
  private final RectF mCardBounds;
  private float mCornerRadius;
  private Paint mCornerShadowPaint;
  private Path mCornerShadowPath;
  private boolean mDirty = true;
  private Paint mEdgeShadowPaint;
  private final int mInsetShadow;
  private Paint mPaint;
  private boolean mPrintedShadowClipWarning = false;
  private float mRawMaxShadowSize;
  private float mRawShadowSize;
  private final int mShadowEndColor;
  private float mShadowSize;
  private final int mShadowStartColor;
  
  RoundRectDrawableWithShadow(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mShadowStartColor = paramResources.getColor(R.color.cardview_shadow_start_color);
    this.mShadowEndColor = paramResources.getColor(R.color.cardview_shadow_end_color);
    this.mInsetShadow = paramResources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
    this.mPaint = new Paint(5);
    setBackground(paramColorStateList);
    paramResources = new Paint(5);
    this.mCornerShadowPaint = paramResources;
    paramResources.setStyle(Paint.Style.FILL);
    this.mCornerRadius = ((int)(paramFloat1 + 0.5F));
    this.mCardBounds = new RectF();
    paramResources = new Paint(this.mCornerShadowPaint);
    this.mEdgeShadowPaint = paramResources;
    paramResources.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }
  
  private void buildComponents(Rect paramRect)
  {
    float f1 = this.mRawMaxShadowSize;
    float f2 = 1.5F * f1;
    this.mCardBounds.set(paramRect.left + f1, paramRect.top + f2, paramRect.right - f1, paramRect.bottom - f2);
    buildShadowCorners();
  }
  
  private void buildShadowCorners()
  {
    float f1 = this.mCornerRadius;
    RectF localRectF = new RectF(-f1, -f1, f1, f1);
    Object localObject1 = new RectF(localRectF);
    f1 = this.mShadowSize;
    ((RectF)localObject1).inset(-f1, -f1);
    Object localObject2 = this.mCornerShadowPath;
    if (localObject2 == null) {
      this.mCornerShadowPath = new Path();
    } else {
      ((Path)localObject2).reset();
    }
    this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
    this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0F);
    this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0F);
    this.mCornerShadowPath.arcTo((RectF)localObject1, 180.0F, 90.0F, false);
    this.mCornerShadowPath.arcTo(localRectF, 270.0F, -90.0F, false);
    this.mCornerShadowPath.close();
    f1 = this.mCornerRadius;
    float f2 = f1 / (this.mShadowSize + f1);
    localObject1 = this.mCornerShadowPaint;
    f1 = this.mCornerRadius;
    float f3 = this.mShadowSize;
    int i = this.mShadowStartColor;
    int j = this.mShadowEndColor;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f1 + f3, new int[] { i, i, j }, new float[] { 0.0F, f2, 1.0F }, (Shader.TileMode)localObject2));
    localObject2 = this.mEdgeShadowPaint;
    f3 = this.mCornerRadius;
    f1 = -f3;
    f2 = this.mShadowSize;
    f3 = -f3;
    j = this.mShadowStartColor;
    i = this.mShadowEndColor;
    localObject1 = Shader.TileMode.CLAMP;
    ((Paint)localObject2).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f2, new int[] { j, j, i }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject1));
    this.mEdgeShadowPaint.setAntiAlias(false);
  }
  
  static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - COS_45) * paramFloat2);
    }
    return f;
  }
  
  static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(paramFloat1 * 1.5F + (1.0D - COS_45) * paramFloat2);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    float f1 = this.mCornerRadius;
    float f2 = -f1 - this.mShadowSize;
    float f3 = f1 + this.mInsetShadow + this.mRawShadowSize / 2.0F;
    f1 = this.mCardBounds.width();
    float f4 = f3 * 2.0F;
    if (f1 - f4 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mCardBounds.height() - f4 > 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    int k = paramCanvas.save();
    RectF localRectF = this.mCardBounds;
    paramCanvas.translate(localRectF.left + f3, localRectF.top + f3);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f2, this.mCardBounds.width() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    k = paramCanvas.save();
    localRectF = this.mCardBounds;
    paramCanvas.translate(localRectF.right - f3, localRectF.bottom - f3);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f2, this.mCardBounds.width() - f4, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    int i = paramCanvas.save();
    localRectF = this.mCardBounds;
    paramCanvas.translate(localRectF.left + f3, localRectF.bottom - f3);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f2, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    localRectF = this.mCardBounds;
    paramCanvas.translate(localRectF.right - f3, localRectF.top + f3);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f2, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
  }
  
  private void setBackground(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.mBackground = localColorStateList;
    this.mPaint.setColor(localColorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
  }
  
  private void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat2 >= 0.0F)
      {
        float f = toEven(paramFloat1);
        paramFloat2 = toEven(paramFloat2);
        paramFloat1 = f;
        if (f > paramFloat2)
        {
          if (!this.mPrintedShadowClipWarning) {
            this.mPrintedShadowClipWarning = true;
          }
          paramFloat1 = paramFloat2;
        }
        if ((this.mRawShadowSize == paramFloat1) && (this.mRawMaxShadowSize == paramFloat2)) {
          return;
        }
        this.mRawShadowSize = paramFloat1;
        this.mRawMaxShadowSize = paramFloat2;
        this.mShadowSize = ((int)(paramFloat1 * 1.5F + this.mInsetShadow + 0.5F));
        this.mDirty = true;
        invalidateSelf();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid max shadow size ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(". Must be >= 0");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid shadow size ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private int toEven(float paramFloat)
  {
    int i = (int)(paramFloat + 0.5F);
    int j = i;
    if (i % 2 == 1) {
      j = i - 1;
    }
    return j;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mDirty)
    {
      buildComponents(getBounds());
      this.mDirty = false;
    }
    paramCanvas.translate(0.0F, this.mRawShadowSize / 2.0F);
    drawShadow(paramCanvas);
    paramCanvas.translate(0.0F, -this.mRawShadowSize / 2.0F);
    sRoundRectHelper.drawRoundRect(paramCanvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
  }
  
  ColorStateList getColor()
  {
    return this.mBackground;
  }
  
  float getCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  void getMaxShadowAndCornerPadding(Rect paramRect)
  {
    getPadding(paramRect);
  }
  
  float getMaxShadowSize()
  {
    return this.mRawMaxShadowSize;
  }
  
  float getMinHeight()
  {
    float f = this.mRawMaxShadowSize;
    return Math.max(f, this.mCornerRadius + this.mInsetShadow + f * 1.5F / 2.0F) * 2.0F + (this.mRawMaxShadowSize * 1.5F + this.mInsetShadow) * 2.0F;
  }
  
  float getMinWidth()
  {
    float f = this.mRawMaxShadowSize;
    return Math.max(f, this.mCornerRadius + this.mInsetShadow + f / 2.0F) * 2.0F + (this.mRawMaxShadowSize + this.mInsetShadow) * 2.0F;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  float getShadowSize()
  {
    return this.mRawShadowSize;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.mBackground;
    boolean bool;
    if (((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mDirty = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.mBackground;
    int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.mDirty = true;
    invalidateSelf();
    return true;
  }
  
  void setAddPaddingForCorners(boolean paramBoolean)
  {
    this.mAddPaddingForCorners = paramBoolean;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.mCornerShadowPaint.setAlpha(paramInt);
    this.mEdgeShadowPaint.setAlpha(paramInt);
  }
  
  void setColor(@Nullable ColorStateList paramColorStateList)
  {
    setBackground(paramColorStateList);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  void setCornerRadius(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      paramFloat = (int)(paramFloat + 0.5F);
      if (this.mCornerRadius == paramFloat) {
        return;
      }
      this.mCornerRadius = paramFloat;
      this.mDirty = true;
      invalidateSelf();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid radius ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(this.mRawShadowSize, paramFloat);
  }
  
  void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, this.mRawMaxShadowSize);
  }
  
  static abstract interface RoundRectHelper
  {
    public abstract void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\cardview\widget\RoundRectDrawableWithShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */