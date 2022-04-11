package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode c = Shader.TileMode.CLAMP;
  private static final ImageView.ScaleType[] d = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  private boolean H3;
  private int I3;
  private int J3;
  private ImageView.ScaleType K3;
  private Shader.TileMode L3;
  private Shader.TileMode M3;
  private final float[] f;
  private boolean p0;
  private Drawable p1;
  private boolean p2;
  private boolean p3;
  private Drawable q;
  private ColorStateList x;
  private float y;
  private ColorFilter z;
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
    this.f = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
    this.x = ColorStateList.valueOf(-16777216);
    this.y = 0.0F;
    this.z = null;
    this.p0 = false;
    this.p2 = false;
    this.p3 = false;
    this.H3 = false;
    paramContext = c;
    this.L3 = paramContext;
    this.M3 = paramContext;
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float[] arrayOfFloat = new float[4];
    float[] tmp14_12 = arrayOfFloat;
    tmp14_12[0] = 0.0F;
    float[] tmp18_14 = tmp14_12;
    tmp18_14[1] = 0.0F;
    float[] tmp22_18 = tmp18_14;
    tmp22_18[2] = 0.0F;
    float[] tmp26_22 = tmp22_18;
    tmp26_22[3] = 0.0F;
    tmp26_22;
    this.f = arrayOfFloat;
    this.x = ColorStateList.valueOf(-16777216);
    this.y = 0.0F;
    this.z = null;
    this.p0 = false;
    this.p2 = false;
    this.p3 = false;
    this.H3 = false;
    Shader.TileMode localTileMode = c;
    this.L3 = localTileMode;
    this.M3 = localTileMode;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(a.RoundedImageView_android_scaleType, -1);
    if (paramInt >= 0) {
      setScaleType(d[paramInt]);
    } else {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    float f1 = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius, -1);
    arrayOfFloat[0] = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_top_left, -1);
    arrayOfFloat[1] = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_top_right, -1);
    arrayOfFloat[2] = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_bottom_right, -1);
    arrayOfFloat[3] = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_corner_radius_bottom_left, -1);
    int i = arrayOfFloat.length;
    paramInt = 0;
    int j = 0;
    while (paramInt < i)
    {
      paramAttributeSet = this.f;
      if (paramAttributeSet[paramInt] < 0.0F) {
        paramAttributeSet[paramInt] = 0.0F;
      } else {
        j = 1;
      }
      paramInt++;
    }
    if (j == 0)
    {
      f2 = f1;
      if (f1 < 0.0F) {
        f2 = 0.0F;
      }
      j = this.f.length;
      for (paramInt = 0; paramInt < j; paramInt++) {
        this.f[paramInt] = f2;
      }
    }
    float f2 = paramContext.getDimensionPixelSize(a.RoundedImageView_riv_border_width, -1);
    this.y = f2;
    if (f2 < 0.0F) {
      this.y = 0.0F;
    }
    paramAttributeSet = paramContext.getColorStateList(a.RoundedImageView_riv_border_color);
    this.x = paramAttributeSet;
    if (paramAttributeSet == null) {
      this.x = ColorStateList.valueOf(-16777216);
    }
    this.H3 = paramContext.getBoolean(a.RoundedImageView_riv_mutate_background, false);
    this.p3 = paramContext.getBoolean(a.RoundedImageView_riv_oval, false);
    paramInt = paramContext.getInt(a.RoundedImageView_riv_tile_mode, -2);
    if (paramInt != -2)
    {
      setTileModeX(b(paramInt));
      setTileModeY(b(paramInt));
    }
    paramInt = paramContext.getInt(a.RoundedImageView_riv_tile_mode_x, -2);
    if (paramInt != -2) {
      setTileModeX(b(paramInt));
    }
    paramInt = paramContext.getInt(a.RoundedImageView_riv_tile_mode_y, -2);
    if (paramInt != -2) {
      setTileModeY(b(paramInt));
    }
    h();
    g(true);
    if (this.H3) {
      super.setBackgroundDrawable(this.q);
    }
    paramContext.recycle();
  }
  
  private void a()
  {
    Drawable localDrawable = this.p1;
    if ((localDrawable != null) && (this.p0))
    {
      localDrawable = localDrawable.mutate();
      this.p1 = localDrawable;
      if (this.p2) {
        localDrawable.setColorFilter(this.z);
      }
    }
  }
  
  private static Shader.TileMode b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return Shader.TileMode.MIRROR;
      }
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.CLAMP;
  }
  
  private Drawable c()
  {
    Object localObject1 = getResources();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int i = this.J3;
    Object localObject3 = localObject2;
    Object localObject4;
    if (i != 0) {
      try
      {
        localObject3 = ((Resources)localObject1).getDrawable(i);
      }
      catch (Exception localException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to find resource: ");
        ((StringBuilder)localObject1).append(this.J3);
        Log.w("RoundedImageView", ((StringBuilder)localObject1).toString(), localException);
        this.J3 = 0;
        localObject4 = localObject2;
      }
    }
    return b.e((Drawable)localObject4);
  }
  
  private Drawable d()
  {
    Object localObject1 = getResources();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int i = this.I3;
    Object localObject3 = localObject2;
    Object localObject4;
    if (i != 0) {
      try
      {
        localObject3 = ((Resources)localObject1).getDrawable(i);
      }
      catch (Exception localException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to find resource: ");
        ((StringBuilder)localObject1).append(this.I3);
        Log.w("RoundedImageView", ((StringBuilder)localObject1).toString(), localException);
        this.I3 = 0;
        localObject4 = localObject2;
      }
    }
    return b.e((Drawable)localObject4);
  }
  
  private void f(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramDrawable == null) {
      return;
    }
    boolean bool = paramDrawable instanceof b;
    int i = 0;
    if (bool)
    {
      paramDrawable = (b)paramDrawable;
      paramDrawable.l(paramScaleType).i(this.y).h(this.x).k(this.p3).m(this.L3).n(this.M3);
      paramScaleType = this.f;
      if (paramScaleType != null) {
        paramDrawable.j(paramScaleType[0], paramScaleType[1], paramScaleType[2], paramScaleType[3]);
      }
      a();
    }
    else if ((paramDrawable instanceof LayerDrawable))
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfLayers();
      while (i < j)
      {
        f(paramDrawable.getDrawable(i), paramScaleType);
        i++;
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.H3)
    {
      if (paramBoolean) {
        this.q = b.e(this.q);
      }
      f(this.q, ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void h()
  {
    f(this.p1, this.K3);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.f;
    if ((arrayOfFloat[0] == paramFloat1) && (arrayOfFloat[1] == paramFloat2) && (arrayOfFloat[2] == paramFloat4) && (arrayOfFloat[3] == paramFloat3)) {
      return;
    }
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[3] = paramFloat3;
    arrayOfFloat[2] = paramFloat4;
    h();
    g(false);
    invalidate();
  }
  
  @ColorInt
  public int getBorderColor()
  {
    return this.x.getDefaultColor();
  }
  
  public ColorStateList getBorderColors()
  {
    return this.x;
  }
  
  public float getBorderWidth()
  {
    return this.y;
  }
  
  public float getCornerRadius()
  {
    return getMaxCornerRadius();
  }
  
  public float getMaxCornerRadius()
  {
    float[] arrayOfFloat = this.f;
    int i = arrayOfFloat.length;
    float f1 = 0.0F;
    for (int j = 0; j < i; j++) {
      f1 = Math.max(arrayOfFloat[j], f1);
    }
    return f1;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.K3;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.L3;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.M3;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt);
    this.q = localColorDrawable;
    setBackgroundDrawable(localColorDrawable);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.q = paramDrawable;
    g(true);
    super.setBackgroundDrawable(this.q);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    if (this.J3 != paramInt)
    {
      this.J3 = paramInt;
      Drawable localDrawable = c();
      this.q = localDrawable;
      setBackgroundDrawable(localDrawable);
    }
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (this.x.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
    this.x = paramColorStateList;
    h();
    g(false);
    if (this.y > 0.0F) {
      invalidate();
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (this.y == paramFloat) {
      return;
    }
    this.y = paramFloat;
    h();
    g(false);
    invalidate();
  }
  
  public void setBorderWidth(@DimenRes int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.z != paramColorFilter)
    {
      this.z = paramColorFilter;
      this.p2 = true;
      this.p0 = true;
      a();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    e(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadiusDimen(@DimenRes int paramInt)
  {
    float f1 = getResources().getDimension(paramInt);
    e(f1, f1, f1, f1);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.I3 = 0;
    this.p1 = b.d(paramBitmap);
    h();
    super.setImageDrawable(this.p1);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.I3 = 0;
    this.p1 = b.e(paramDrawable);
    h();
    super.setImageDrawable(this.p1);
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    if (this.I3 != paramInt)
    {
      this.I3 = paramInt;
      this.p1 = d();
      h();
      super.setImageDrawable(this.p1);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    h();
    g(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.K3 != paramScaleType)
    {
      this.K3 = paramScaleType;
      switch (a.a[paramScaleType.ordinal()])
      {
      default: 
        super.setScaleType(paramScaleType);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        super.setScaleType(ImageView.ScaleType.FIT_XY);
      }
      h();
      g(false);
      invalidate();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (this.L3 == paramTileMode) {
      return;
    }
    this.L3 = paramTileMode;
    h();
    g(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (this.M3 == paramTileMode) {
      return;
    }
    this.M3 = paramTileMode;
    h();
    g(false);
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\makeramen\roundedimageview\RoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */