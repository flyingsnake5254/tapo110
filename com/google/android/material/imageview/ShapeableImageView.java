package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class ShapeableImageView
  extends AppCompatImageView
  implements Shapeable
{
  private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
  private final Paint borderPaint;
  private final Paint clearPaint;
  private final RectF destination;
  private Path maskPath;
  private final RectF maskRect;
  private final Path path = new Path();
  private final ShapeAppearancePathProvider pathProvider = new ShapeAppearancePathProvider();
  private final MaterialShapeDrawable shadowDrawable;
  private ShapeAppearanceModel shapeAppearanceModel;
  private ColorStateList strokeColor;
  @Dimension
  private float strokeWidth;
  
  public ShapeableImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ShapeableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShapeableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    Object localObject = new Paint();
    this.clearPaint = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.destination = new RectF();
    this.maskRect = new RectF();
    this.maskPath = new Path();
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeableImageView, paramInt, i);
    this.strokeColor = MaterialResources.getColorStateList(paramContext, (TypedArray)localObject, R.styleable.ShapeableImageView_strokeColor);
    this.strokeWidth = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
    localObject = new Paint();
    this.borderPaint = ((Paint)localObject);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setAntiAlias(true);
    this.shapeAppearanceModel = ShapeAppearanceModel.builder(paramContext, paramAttributeSet, paramInt, i).build();
    this.shadowDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new OutlineProvider());
    }
  }
  
  private void drawStroke(Canvas paramCanvas)
  {
    if (this.strokeColor == null) {
      return;
    }
    this.borderPaint.setStrokeWidth(this.strokeWidth);
    int i = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
    if ((this.strokeWidth > 0.0F) && (i != 0))
    {
      this.borderPaint.setColor(i);
      paramCanvas.drawPath(this.path, this.borderPaint);
    }
  }
  
  private void updateShapeMask(int paramInt1, int paramInt2)
  {
    this.destination.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0F, this.destination, this.path);
    this.maskPath.rewind();
    this.maskPath.addPath(this.path);
    this.maskRect.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.shapeAppearanceModel;
  }
  
  @Nullable
  public ColorStateList getStrokeColor()
  {
    return this.strokeColor;
  }
  
  @Dimension
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    setLayerType(0, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(this.maskPath, this.clearPaint);
    drawStroke(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    updateShapeMask(paramInt1, paramInt2);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.shapeAppearanceModel = paramShapeAppearanceModel;
    this.shadowDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    updateShapeMask(getWidth(), getHeight());
    invalidate();
  }
  
  public void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    this.strokeColor = paramColorStateList;
    invalidate();
  }
  
  public void setStrokeColorResource(@ColorRes int paramInt)
  {
    setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setStrokeWidth(@Dimension float paramFloat)
  {
    if (this.strokeWidth != paramFloat)
    {
      this.strokeWidth = paramFloat;
      invalidate();
    }
  }
  
  public void setStrokeWidthResource(@DimenRes int paramInt)
  {
    setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  @TargetApi(21)
  class OutlineProvider
    extends ViewOutlineProvider
  {
    private final Rect rect = new Rect();
    
    OutlineProvider() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      if (ShapeableImageView.this.shapeAppearanceModel == null) {
        return;
      }
      ShapeableImageView.this.destination.round(this.rect);
      ShapeableImageView.this.shadowDrawable.setBounds(this.rect);
      ShapeableImageView.this.shadowDrawable.getOutline(paramOutline);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\imageview\ShapeableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */