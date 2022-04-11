package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R.styleable;

public class ShapeAppearanceModel
{
  public static final CornerSize PILL = new RelativeCornerSize(0.5F);
  EdgeTreatment bottomEdge;
  CornerTreatment bottomLeftCorner;
  CornerSize bottomLeftCornerSize;
  CornerTreatment bottomRightCorner;
  CornerSize bottomRightCornerSize;
  EdgeTreatment leftEdge;
  EdgeTreatment rightEdge;
  EdgeTreatment topEdge;
  CornerTreatment topLeftCorner;
  CornerSize topLeftCornerSize;
  CornerTreatment topRightCorner;
  CornerSize topRightCornerSize;
  
  public ShapeAppearanceModel()
  {
    this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    this.topLeftCornerSize = new AbsoluteCornerSize(0.0F);
    this.topRightCornerSize = new AbsoluteCornerSize(0.0F);
    this.bottomRightCornerSize = new AbsoluteCornerSize(0.0F);
    this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0F);
    this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
  }
  
  private ShapeAppearanceModel(@NonNull Builder paramBuilder)
  {
    this.topLeftCorner = paramBuilder.topLeftCorner;
    this.topRightCorner = paramBuilder.topRightCorner;
    this.bottomRightCorner = paramBuilder.bottomRightCorner;
    this.bottomLeftCorner = paramBuilder.bottomLeftCorner;
    this.topLeftCornerSize = paramBuilder.topLeftCornerSize;
    this.topRightCornerSize = paramBuilder.topRightCornerSize;
    this.bottomRightCornerSize = paramBuilder.bottomRightCornerSize;
    this.bottomLeftCornerSize = paramBuilder.bottomLeftCornerSize;
    this.topEdge = paramBuilder.topEdge;
    this.rightEdge = paramBuilder.rightEdge;
    this.bottomEdge = paramBuilder.bottomEdge;
    this.leftEdge = paramBuilder.leftEdge;
  }
  
  @NonNull
  public static Builder builder()
  {
    return new Builder();
  }
  
  @NonNull
  public static Builder builder(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2)
  {
    return builder(paramContext, paramInt1, paramInt2, 0);
  }
  
  @NonNull
  private static Builder builder(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2, int paramInt3)
  {
    return builder(paramContext, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  @NonNull
  private static Builder builder(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2, @NonNull CornerSize paramCornerSize)
  {
    Object localObject1 = paramContext;
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      localObject1 = new ContextThemeWrapper(paramContext, paramInt1);
      i = paramInt2;
    }
    paramContext = ((Context)localObject1).obtainStyledAttributes(i, R.styleable.ShapeAppearance);
    try
    {
      int j = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
      paramInt2 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, j);
      paramInt1 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, j);
      i = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, j);
      j = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, j);
      Object localObject2 = getCornerSize(paramContext, R.styleable.ShapeAppearance_cornerSize, paramCornerSize);
      paramCornerSize = getCornerSize(paramContext, R.styleable.ShapeAppearance_cornerSizeTopLeft, (CornerSize)localObject2);
      localObject1 = getCornerSize(paramContext, R.styleable.ShapeAppearance_cornerSizeTopRight, (CornerSize)localObject2);
      CornerSize localCornerSize1 = getCornerSize(paramContext, R.styleable.ShapeAppearance_cornerSizeBottomRight, (CornerSize)localObject2);
      CornerSize localCornerSize2 = getCornerSize(paramContext, R.styleable.ShapeAppearance_cornerSizeBottomLeft, (CornerSize)localObject2);
      localObject2 = new com/google/android/material/shape/ShapeAppearanceModel$Builder;
      ((Builder)localObject2).<init>();
      paramCornerSize = ((Builder)localObject2).setTopLeftCorner(paramInt2, paramCornerSize).setTopRightCorner(paramInt1, (CornerSize)localObject1).setBottomRightCorner(i, localCornerSize1).setBottomLeftCorner(j, localCornerSize2);
      return paramCornerSize;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  @NonNull
  public static Builder builder(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    return builder(paramContext, paramAttributeSet, paramInt1, paramInt2, 0);
  }
  
  @NonNull
  public static Builder builder(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2, int paramInt3)
  {
    return builder(paramContext, paramAttributeSet, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  @NonNull
  public static Builder builder(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2, @NonNull CornerSize paramCornerSize)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialShape, paramInt1, paramInt2);
    paramInt2 = paramAttributeSet.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
    paramAttributeSet.recycle();
    return builder(paramContext, paramInt2, paramInt1, paramCornerSize);
  }
  
  @NonNull
  private static CornerSize getCornerSize(TypedArray paramTypedArray, int paramInt, @NonNull CornerSize paramCornerSize)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
    if (localTypedValue == null) {
      return paramCornerSize;
    }
    paramInt = localTypedValue.type;
    if (paramInt == 5) {
      return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramTypedArray.getResources().getDisplayMetrics()));
    }
    if (paramInt == 6) {
      return new RelativeCornerSize(localTypedValue.getFraction(1.0F, 1.0F));
    }
    return paramCornerSize;
  }
  
  @NonNull
  public EdgeTreatment getBottomEdge()
  {
    return this.bottomEdge;
  }
  
  @NonNull
  public CornerTreatment getBottomLeftCorner()
  {
    return this.bottomLeftCorner;
  }
  
  @NonNull
  public CornerSize getBottomLeftCornerSize()
  {
    return this.bottomLeftCornerSize;
  }
  
  @NonNull
  public CornerTreatment getBottomRightCorner()
  {
    return this.bottomRightCorner;
  }
  
  @NonNull
  public CornerSize getBottomRightCornerSize()
  {
    return this.bottomRightCornerSize;
  }
  
  @NonNull
  public EdgeTreatment getLeftEdge()
  {
    return this.leftEdge;
  }
  
  @NonNull
  public EdgeTreatment getRightEdge()
  {
    return this.rightEdge;
  }
  
  @NonNull
  public EdgeTreatment getTopEdge()
  {
    return this.topEdge;
  }
  
  @NonNull
  public CornerTreatment getTopLeftCorner()
  {
    return this.topLeftCorner;
  }
  
  @NonNull
  public CornerSize getTopLeftCornerSize()
  {
    return this.topLeftCornerSize;
  }
  
  @NonNull
  public CornerTreatment getTopRightCorner()
  {
    return this.topRightCorner;
  }
  
  @NonNull
  public CornerSize getTopRightCornerSize()
  {
    return this.topRightCornerSize;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isRoundRect(@NonNull RectF paramRectF)
  {
    boolean bool1 = this.leftEdge.getClass().equals(EdgeTreatment.class);
    boolean bool2 = true;
    int i;
    if ((bool1) && (this.rightEdge.getClass().equals(EdgeTreatment.class)) && (this.topEdge.getClass().equals(EdgeTreatment.class)) && (this.bottomEdge.getClass().equals(EdgeTreatment.class))) {
      i = 1;
    } else {
      i = 0;
    }
    float f = this.topLeftCornerSize.getCornerSize(paramRectF);
    int j;
    if ((this.topRightCornerSize.getCornerSize(paramRectF) == f) && (this.bottomLeftCornerSize.getCornerSize(paramRectF) == f) && (this.bottomRightCornerSize.getCornerSize(paramRectF) == f)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (((this.topRightCorner instanceof RoundedCornerTreatment)) && ((this.topLeftCorner instanceof RoundedCornerTreatment)) && ((this.bottomRightCorner instanceof RoundedCornerTreatment)) && ((this.bottomLeftCorner instanceof RoundedCornerTreatment))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((i == 0) || (j == 0) || (k == 0)) {
      bool2 = false;
    }
    return bool2;
  }
  
  @NonNull
  public Builder toBuilder()
  {
    return new Builder(this);
  }
  
  @NonNull
  public ShapeAppearanceModel withCornerSize(float paramFloat)
  {
    return toBuilder().setAllCornerSizes(paramFloat).build();
  }
  
  @NonNull
  public ShapeAppearanceModel withCornerSize(@NonNull CornerSize paramCornerSize)
  {
    return toBuilder().setAllCornerSizes(paramCornerSize).build();
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator paramCornerSizeUnaryOperator)
  {
    return toBuilder().setTopLeftCornerSize(paramCornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(paramCornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(paramCornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(paramCornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
  }
  
  public static final class Builder
  {
    @NonNull
    private EdgeTreatment bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    @NonNull
    private CornerTreatment bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    @NonNull
    private CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0F);
    @NonNull
    private CornerTreatment bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    @NonNull
    private CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0F);
    @NonNull
    private EdgeTreatment leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    @NonNull
    private EdgeTreatment rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    @NonNull
    private EdgeTreatment topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    @NonNull
    private CornerTreatment topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    @NonNull
    private CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0F);
    @NonNull
    private CornerTreatment topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
    @NonNull
    private CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0F);
    
    public Builder() {}
    
    public Builder(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
    {
      this.topLeftCorner = paramShapeAppearanceModel.topLeftCorner;
      this.topRightCorner = paramShapeAppearanceModel.topRightCorner;
      this.bottomRightCorner = paramShapeAppearanceModel.bottomRightCorner;
      this.bottomLeftCorner = paramShapeAppearanceModel.bottomLeftCorner;
      this.topLeftCornerSize = paramShapeAppearanceModel.topLeftCornerSize;
      this.topRightCornerSize = paramShapeAppearanceModel.topRightCornerSize;
      this.bottomRightCornerSize = paramShapeAppearanceModel.bottomRightCornerSize;
      this.bottomLeftCornerSize = paramShapeAppearanceModel.bottomLeftCornerSize;
      this.topEdge = paramShapeAppearanceModel.topEdge;
      this.rightEdge = paramShapeAppearanceModel.rightEdge;
      this.bottomEdge = paramShapeAppearanceModel.bottomEdge;
      this.leftEdge = paramShapeAppearanceModel.leftEdge;
    }
    
    private static float compatCornerTreatmentSize(CornerTreatment paramCornerTreatment)
    {
      if ((paramCornerTreatment instanceof RoundedCornerTreatment)) {
        return ((RoundedCornerTreatment)paramCornerTreatment).radius;
      }
      if ((paramCornerTreatment instanceof CutCornerTreatment)) {
        return ((CutCornerTreatment)paramCornerTreatment).size;
      }
      return -1.0F;
    }
    
    @NonNull
    public ShapeAppearanceModel build()
    {
      return new ShapeAppearanceModel(this, null);
    }
    
    @NonNull
    public Builder setAllCornerSizes(@Dimension float paramFloat)
    {
      return setTopLeftCornerSize(paramFloat).setTopRightCornerSize(paramFloat).setBottomRightCornerSize(paramFloat).setBottomLeftCornerSize(paramFloat);
    }
    
    @NonNull
    public Builder setAllCornerSizes(@NonNull CornerSize paramCornerSize)
    {
      return setTopLeftCornerSize(paramCornerSize).setTopRightCornerSize(paramCornerSize).setBottomRightCornerSize(paramCornerSize).setBottomLeftCornerSize(paramCornerSize);
    }
    
    @NonNull
    public Builder setAllCorners(int paramInt, @Dimension float paramFloat)
    {
      return setAllCorners(MaterialShapeUtils.createCornerTreatment(paramInt)).setAllCornerSizes(paramFloat);
    }
    
    @NonNull
    public Builder setAllCorners(@NonNull CornerTreatment paramCornerTreatment)
    {
      return setTopLeftCorner(paramCornerTreatment).setTopRightCorner(paramCornerTreatment).setBottomRightCorner(paramCornerTreatment).setBottomLeftCorner(paramCornerTreatment);
    }
    
    @NonNull
    public Builder setAllEdges(@NonNull EdgeTreatment paramEdgeTreatment)
    {
      return setLeftEdge(paramEdgeTreatment).setTopEdge(paramEdgeTreatment).setRightEdge(paramEdgeTreatment).setBottomEdge(paramEdgeTreatment);
    }
    
    @NonNull
    public Builder setBottomEdge(@NonNull EdgeTreatment paramEdgeTreatment)
    {
      this.bottomEdge = paramEdgeTreatment;
      return this;
    }
    
    @NonNull
    public Builder setBottomLeftCorner(int paramInt, @Dimension float paramFloat)
    {
      return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setBottomLeftCornerSize(paramFloat);
    }
    
    @NonNull
    public Builder setBottomLeftCorner(int paramInt, @NonNull CornerSize paramCornerSize)
    {
      return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setBottomLeftCornerSize(paramCornerSize);
    }
    
    @NonNull
    public Builder setBottomLeftCorner(@NonNull CornerTreatment paramCornerTreatment)
    {
      this.bottomLeftCorner = paramCornerTreatment;
      float f = compatCornerTreatmentSize(paramCornerTreatment);
      if (f != -1.0F) {
        setBottomLeftCornerSize(f);
      }
      return this;
    }
    
    @NonNull
    public Builder setBottomLeftCornerSize(@Dimension float paramFloat)
    {
      this.bottomLeftCornerSize = new AbsoluteCornerSize(paramFloat);
      return this;
    }
    
    @NonNull
    public Builder setBottomLeftCornerSize(@NonNull CornerSize paramCornerSize)
    {
      this.bottomLeftCornerSize = paramCornerSize;
      return this;
    }
    
    @NonNull
    public Builder setBottomRightCorner(int paramInt, @Dimension float paramFloat)
    {
      return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setBottomRightCornerSize(paramFloat);
    }
    
    @NonNull
    public Builder setBottomRightCorner(int paramInt, @NonNull CornerSize paramCornerSize)
    {
      return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setBottomRightCornerSize(paramCornerSize);
    }
    
    @NonNull
    public Builder setBottomRightCorner(@NonNull CornerTreatment paramCornerTreatment)
    {
      this.bottomRightCorner = paramCornerTreatment;
      float f = compatCornerTreatmentSize(paramCornerTreatment);
      if (f != -1.0F) {
        setBottomRightCornerSize(f);
      }
      return this;
    }
    
    @NonNull
    public Builder setBottomRightCornerSize(@Dimension float paramFloat)
    {
      this.bottomRightCornerSize = new AbsoluteCornerSize(paramFloat);
      return this;
    }
    
    @NonNull
    public Builder setBottomRightCornerSize(@NonNull CornerSize paramCornerSize)
    {
      this.bottomRightCornerSize = paramCornerSize;
      return this;
    }
    
    @NonNull
    public Builder setLeftEdge(@NonNull EdgeTreatment paramEdgeTreatment)
    {
      this.leftEdge = paramEdgeTreatment;
      return this;
    }
    
    @NonNull
    public Builder setRightEdge(@NonNull EdgeTreatment paramEdgeTreatment)
    {
      this.rightEdge = paramEdgeTreatment;
      return this;
    }
    
    @NonNull
    public Builder setTopEdge(@NonNull EdgeTreatment paramEdgeTreatment)
    {
      this.topEdge = paramEdgeTreatment;
      return this;
    }
    
    @NonNull
    public Builder setTopLeftCorner(int paramInt, @Dimension float paramFloat)
    {
      return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setTopLeftCornerSize(paramFloat);
    }
    
    @NonNull
    public Builder setTopLeftCorner(int paramInt, @NonNull CornerSize paramCornerSize)
    {
      return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setTopLeftCornerSize(paramCornerSize);
    }
    
    @NonNull
    public Builder setTopLeftCorner(@NonNull CornerTreatment paramCornerTreatment)
    {
      this.topLeftCorner = paramCornerTreatment;
      float f = compatCornerTreatmentSize(paramCornerTreatment);
      if (f != -1.0F) {
        setTopLeftCornerSize(f);
      }
      return this;
    }
    
    @NonNull
    public Builder setTopLeftCornerSize(@Dimension float paramFloat)
    {
      this.topLeftCornerSize = new AbsoluteCornerSize(paramFloat);
      return this;
    }
    
    @NonNull
    public Builder setTopLeftCornerSize(@NonNull CornerSize paramCornerSize)
    {
      this.topLeftCornerSize = paramCornerSize;
      return this;
    }
    
    @NonNull
    public Builder setTopRightCorner(int paramInt, @Dimension float paramFloat)
    {
      return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setTopRightCornerSize(paramFloat);
    }
    
    @NonNull
    public Builder setTopRightCorner(int paramInt, @NonNull CornerSize paramCornerSize)
    {
      return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(paramInt)).setTopRightCornerSize(paramCornerSize);
    }
    
    @NonNull
    public Builder setTopRightCorner(@NonNull CornerTreatment paramCornerTreatment)
    {
      this.topRightCorner = paramCornerTreatment;
      float f = compatCornerTreatmentSize(paramCornerTreatment);
      if (f != -1.0F) {
        setTopRightCornerSize(f);
      }
      return this;
    }
    
    @NonNull
    public Builder setTopRightCornerSize(@Dimension float paramFloat)
    {
      this.topRightCornerSize = new AbsoluteCornerSize(paramFloat);
      return this;
    }
    
    @NonNull
    public Builder setTopRightCornerSize(@NonNull CornerSize paramCornerSize)
    {
      this.topRightCornerSize = paramCornerSize;
      return this;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static abstract interface CornerSizeUnaryOperator
  {
    @NonNull
    public abstract CornerSize apply(@NonNull CornerSize paramCornerSize);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\ShapeAppearanceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */