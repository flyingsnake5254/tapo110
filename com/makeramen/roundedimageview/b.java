package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
  extends Drawable
{
  private final RectF a = new RectF();
  private final RectF b = new RectF();
  private final RectF c;
  private final Bitmap d;
  private final Paint e;
  private final int f;
  private final int g;
  private final RectF h;
  private final Paint i;
  private final Matrix j;
  private final RectF k;
  private Shader.TileMode l;
  private Shader.TileMode m;
  private boolean n;
  private float o;
  private final boolean[] p;
  private boolean q;
  private float r;
  private ColorStateList s;
  private ImageView.ScaleType t;
  
  public b(Bitmap paramBitmap)
  {
    RectF localRectF = new RectF();
    this.c = localRectF;
    this.h = new RectF();
    this.j = new Matrix();
    this.k = new RectF();
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.l = localTileMode;
    this.m = localTileMode;
    this.n = true;
    this.o = 0.0F;
    this.p = new boolean[] { 1, 1, 1, 1 };
    this.q = false;
    this.r = 0.0F;
    this.s = ColorStateList.valueOf(-16777216);
    this.t = ImageView.ScaleType.FIT_CENTER;
    this.d = paramBitmap;
    int i1 = paramBitmap.getWidth();
    this.f = i1;
    int i2 = paramBitmap.getHeight();
    this.g = i2;
    localRectF.set(0.0F, 0.0F, i1, i2);
    paramBitmap = new Paint();
    this.e = paramBitmap;
    paramBitmap.setStyle(Paint.Style.FILL);
    paramBitmap.setAntiAlias(true);
    paramBitmap = new Paint();
    this.i = paramBitmap;
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setColor(this.s.getColorForState(getState(), -16777216));
    paramBitmap.setStrokeWidth(this.r);
  }
  
  private static boolean a(boolean[] paramArrayOfBoolean)
  {
    int i1 = paramArrayOfBoolean.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (paramArrayOfBoolean[i2] != 0) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean b(boolean[] paramArrayOfBoolean)
  {
    int i1 = paramArrayOfBoolean.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (paramArrayOfBoolean[i2] != 0) {
        return true;
      }
    }
    return false;
  }
  
  public static Bitmap c(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i1 = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int i2 = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new android/graphics/Canvas;
      localCanvas.<init>(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      paramDrawable = localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
      Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
      paramDrawable = null;
    }
    return paramDrawable;
  }
  
  public static b d(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new b(paramBitmap);
    }
    return null;
  }
  
  public static Drawable e(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof b)) {
        return paramDrawable;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        localObject = (LayerDrawable)paramDrawable;
        int i1 = ((LayerDrawable)localObject).getNumberOfLayers();
        for (int i2 = 0; i2 < i1; i2++)
        {
          paramDrawable = ((LayerDrawable)localObject).getDrawable(i2);
          ((LayerDrawable)localObject).setDrawableByLayerId(((LayerDrawable)localObject).getId(i2), e(paramDrawable));
        }
        return (Drawable)localObject;
      }
      Bitmap localBitmap = c(paramDrawable);
      localObject = paramDrawable;
      if (localBitmap != null) {
        localObject = new b(localBitmap);
      }
    }
    return (Drawable)localObject;
  }
  
  private void f(Canvas paramCanvas)
  {
    if (a(this.p)) {
      return;
    }
    if (this.o == 0.0F) {
      return;
    }
    RectF localRectF = this.b;
    float f1 = localRectF.left;
    float f2 = localRectF.top;
    float f3 = localRectF.width() + f1;
    float f4 = this.b.height() + f2;
    float f5 = this.o;
    if (this.p[0] == 0)
    {
      this.k.set(f1, f2, f1 + f5, f2 + f5);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[1] == 0)
    {
      this.k.set(f3 - f5, f2, f3, f5);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[2] == 0)
    {
      this.k.set(f3 - f5, f4 - f5, f3, f4);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[3] == 0)
    {
      this.k.set(f1, f4 - f5, f5 + f1, f4);
      paramCanvas.drawRect(this.k, this.e);
    }
  }
  
  private void g(Canvas paramCanvas)
  {
    if (a(this.p)) {
      return;
    }
    if (this.o == 0.0F) {
      return;
    }
    RectF localRectF = this.b;
    float f1 = localRectF.left;
    float f2 = localRectF.top;
    float f3 = localRectF.width() + f1;
    float f4 = f2 + this.b.height();
    float f5 = this.o;
    float f6 = this.r / 2.0F;
    if (this.p[0] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, this.i);
      paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, this.i);
    }
    if (this.p[1] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, this.i);
      paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, this.i);
    }
    if (this.p[2] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, this.i);
      paramCanvas.drawLine(f3, f4 - f5, f3, f4, this.i);
    }
    if (this.p[3] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, this.i);
      paramCanvas.drawLine(f1, f4 - f5, f1, f4, this.i);
    }
  }
  
  private void o()
  {
    int i1 = a.a[this.t.ordinal()];
    Object localObject;
    float f1;
    if (i1 != 1)
    {
      float f2;
      float f3;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 5)
          {
            if (i1 != 6)
            {
              if (i1 != 7)
              {
                this.h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.h);
                localObject = this.h;
                f1 = this.r;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              }
              else
              {
                this.h.set(this.a);
                localObject = this.h;
                f1 = this.r;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.j.reset();
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              }
            }
            else
            {
              this.h.set(this.c);
              this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
              this.j.mapRect(this.h);
              localObject = this.h;
              f1 = this.r;
              ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
              this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
            }
          }
          else
          {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            localObject = this.h;
            f1 = this.r;
            ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
          }
        }
        else
        {
          this.j.reset();
          if ((this.f <= this.a.width()) && (this.g <= this.a.height())) {
            f1 = 1.0F;
          } else {
            f1 = Math.min(this.a.width() / this.f, this.a.height() / this.g);
          }
          f2 = (int)((this.a.width() - this.f * f1) * 0.5F + 0.5F);
          f3 = (int)((this.a.height() - this.g * f1) * 0.5F + 0.5F);
          this.j.setScale(f1, f1);
          this.j.postTranslate(f2, f3);
          this.h.set(this.c);
          this.j.mapRect(this.h);
          localObject = this.h;
          f1 = this.r;
          ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
          this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
      }
      else
      {
        this.h.set(this.a);
        localObject = this.h;
        f1 = this.r;
        ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
        this.j.reset();
        float f4 = this.f;
        float f5 = this.h.height();
        f2 = this.h.width();
        f1 = this.g;
        f3 = 0.0F;
        if (f4 * f5 > f2 * f1)
        {
          f2 = this.h.height() / this.g;
          f3 = (this.h.width() - this.f * f2) * 0.5F;
          f1 = 0.0F;
        }
        else
        {
          f2 = this.h.width() / this.f;
          f1 = (this.h.height() - this.g * f2) * 0.5F;
        }
        this.j.setScale(f2, f2);
        localObject = this.j;
        f2 = (int)(f3 + 0.5F);
        f3 = this.r;
        ((Matrix)localObject).postTranslate(f2 + f3 / 2.0F, (int)(f1 + 0.5F) + f3 / 2.0F);
      }
    }
    else
    {
      this.h.set(this.a);
      localObject = this.h;
      f1 = this.r;
      ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
      this.j.reset();
      this.j.setTranslate((int)((this.h.width() - this.f) * 0.5F + 0.5F), (int)((this.h.height() - this.g) * 0.5F + 0.5F));
    }
    this.b.set(this.h);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.n)
    {
      BitmapShader localBitmapShader = new BitmapShader(this.d, this.l, this.m);
      Shader.TileMode localTileMode1 = this.l;
      Shader.TileMode localTileMode2 = Shader.TileMode.CLAMP;
      if ((localTileMode1 == localTileMode2) && (this.m == localTileMode2)) {
        localBitmapShader.setLocalMatrix(this.j);
      }
      this.e.setShader(localBitmapShader);
      this.n = false;
    }
    if (this.q)
    {
      if (this.r > 0.0F)
      {
        paramCanvas.drawOval(this.b, this.e);
        paramCanvas.drawOval(this.h, this.i);
      }
      else
      {
        paramCanvas.drawOval(this.b, this.e);
      }
    }
    else if (b(this.p))
    {
      float f1 = this.o;
      if (this.r > 0.0F)
      {
        paramCanvas.drawRoundRect(this.b, f1, f1, this.e);
        paramCanvas.drawRoundRect(this.h, f1, f1, this.i);
        f(paramCanvas);
        g(paramCanvas);
      }
      else
      {
        paramCanvas.drawRoundRect(this.b, f1, f1, this.e);
        f(paramCanvas);
      }
    }
    else
    {
      paramCanvas.drawRect(this.b, this.e);
      if (this.r > 0.0F) {
        paramCanvas.drawRect(this.h, this.i);
      }
    }
  }
  
  public int getAlpha()
  {
    return this.e.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.e.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.g;
  }
  
  public int getIntrinsicWidth()
  {
    return this.f;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public b h(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(0);
    }
    this.s = paramColorStateList;
    this.i.setColor(paramColorStateList.getColorForState(getState(), -16777216));
    return this;
  }
  
  public b i(float paramFloat)
  {
    this.r = paramFloat;
    this.i.setStrokeWidth(paramFloat);
    return this;
  }
  
  public boolean isStateful()
  {
    return this.s.isStateful();
  }
  
  public b j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = new HashSet(4);
    ((Set)localObject).add(Float.valueOf(paramFloat1));
    ((Set)localObject).add(Float.valueOf(paramFloat2));
    ((Set)localObject).add(Float.valueOf(paramFloat3));
    ((Set)localObject).add(Float.valueOf(paramFloat4));
    ((Set)localObject).remove(Float.valueOf(0.0F));
    int i1 = ((Set)localObject).size();
    int i2 = 1;
    if (i1 <= 1)
    {
      if (!((Set)localObject).isEmpty())
      {
        float f1 = ((Float)((Set)localObject).iterator().next()).floatValue();
        if ((!Float.isInfinite(f1)) && (!Float.isNaN(f1)) && (f1 >= 0.0F))
        {
          this.o = f1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid radius value: ");
          ((StringBuilder)localObject).append(f1);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.o = 0.0F;
      }
      localObject = this.p;
      int i3;
      if (paramFloat1 > 0.0F) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      localObject[0] = i3;
      if (paramFloat2 > 0.0F) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      localObject[1] = i3;
      if (paramFloat3 > 0.0F) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      localObject[2] = i3;
      if (paramFloat4 > 0.0F) {
        i3 = i2;
      } else {
        i3 = 0;
      }
      localObject[3] = i3;
      return this;
    }
    throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
  }
  
  public b k(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public b l(ImageView.ScaleType paramScaleType)
  {
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.FIT_CENTER;
    }
    if (this.t != localScaleType)
    {
      this.t = localScaleType;
      o();
    }
    return this;
  }
  
  public b m(Shader.TileMode paramTileMode)
  {
    if (this.l != paramTileMode)
    {
      this.l = paramTileMode;
      this.n = true;
      invalidateSelf();
    }
    return this;
  }
  
  public b n(Shader.TileMode paramTileMode)
  {
    if (this.m != paramTileMode)
    {
      this.m = paramTileMode;
      this.n = true;
      invalidateSelf();
    }
    return this;
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.set(paramRect);
    o();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i1 = this.s.getColorForState(paramArrayOfInt, 0);
    if (this.i.getColor() != i1)
    {
      this.i.setColor(i1);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.e.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.e.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\makeramen\roundedimageview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */