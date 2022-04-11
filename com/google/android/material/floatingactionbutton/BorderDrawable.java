package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class BorderDrawable
  extends Drawable
{
  private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333F;
  @Nullable
  private ColorStateList borderTint;
  @Dimension
  float borderWidth;
  @ColorInt
  private int bottomInnerStrokeColor;
  @ColorInt
  private int bottomOuterStrokeColor;
  private final RectF boundsRectF = new RectF();
  @ColorInt
  private int currentBorderTintColor;
  private boolean invalidateShader = true;
  @NonNull
  private final Paint paint;
  private final ShapeAppearancePathProvider pathProvider = new ShapeAppearancePathProvider();
  private final Rect rect = new Rect();
  private final RectF rectF = new RectF();
  private ShapeAppearanceModel shapeAppearanceModel;
  private final Path shapePath = new Path();
  private final BorderState state = new BorderState(null);
  @ColorInt
  private int topInnerStrokeColor;
  @ColorInt
  private int topOuterStrokeColor;
  
  BorderDrawable(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.shapeAppearanceModel = paramShapeAppearanceModel;
    paramShapeAppearanceModel = new Paint(1);
    this.paint = paramShapeAppearanceModel;
    paramShapeAppearanceModel.setStyle(Paint.Style.STROKE);
  }
  
  @NonNull
  private Shader createGradientShader()
  {
    Object localObject = this.rect;
    copyBounds((Rect)localObject);
    float f1 = this.borderWidth / ((Rect)localObject).height();
    int i = ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor);
    int j = ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor);
    int k = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor);
    int m = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor);
    int n = ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor);
    int i1 = ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor);
    float f2 = ((Rect)localObject).top;
    float f3 = ((Rect)localObject).bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.invalidateShader)
    {
      this.paint.setShader(createGradientShader());
      this.invalidateShader = false;
    }
    float f1 = this.paint.getStrokeWidth() / 2.0F;
    copyBounds(this.rect);
    this.rectF.set(this.rect);
    float f2 = Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()), this.rectF.width() / 2.0F);
    if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()))
    {
      this.rectF.inset(f1, f1);
      paramCanvas.drawRoundRect(this.rectF, f2, f2, this.paint);
    }
  }
  
  @NonNull
  protected RectF getBoundsAsRectF()
  {
    this.boundsRectF.set(getBounds());
    return this.boundsRectF;
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.state;
  }
  
  public int getOpacity()
  {
    int i;
    if (this.borderWidth > 0.0F) {
      i = -3;
    } else {
      i = -2;
    }
    return i;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()))
    {
      float f = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
      paramOutline.setRoundRect(getBounds(), f);
      return;
    }
    copyBounds(this.rect);
    this.rectF.set(this.rect);
    this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0F, this.rectF, this.shapePath);
    if (this.shapePath.isConvex()) {
      paramOutline.setConvexPath(this.shapePath);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()))
    {
      int i = Math.round(this.borderWidth);
      paramRect.set(i, i, i, i);
    }
    return true;
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.shapeAppearanceModel;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.borderTint;
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
    this.invalidateShader = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.borderTint;
    if (localColorStateList != null)
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, this.currentBorderTintColor);
      if (i != this.currentBorderTintColor)
      {
        this.invalidateShader = true;
        this.currentBorderTintColor = i;
      }
    }
    if (this.invalidateShader) {
      invalidateSelf();
    }
    return this.invalidateShader;
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.paint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  void setBorderTint(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.currentBorderTintColor = paramColorStateList.getColorForState(getState(), this.currentBorderTintColor);
    }
    this.borderTint = paramColorStateList;
    this.invalidateShader = true;
    invalidateSelf();
  }
  
  public void setBorderWidth(@Dimension float paramFloat)
  {
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(paramFloat * 1.3333F);
      this.invalidateShader = true;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  void setGradientColors(@ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, @ColorInt int paramInt4)
  {
    this.topOuterStrokeColor = paramInt1;
    this.topInnerStrokeColor = paramInt2;
    this.bottomOuterStrokeColor = paramInt3;
    this.bottomInnerStrokeColor = paramInt4;
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.shapeAppearanceModel = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  private class BorderState
    extends Drawable.ConstantState
  {
    private BorderState() {}
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return BorderDrawable.this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\floatingactionbutton\BorderDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */