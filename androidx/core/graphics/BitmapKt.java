package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class BitmapKt
{
  public static final Bitmap applyCanvas(Bitmap paramBitmap, l<? super Canvas, p> paraml)
  {
    j.f(paramBitmap, "$this$applyCanvas");
    j.f(paraml, "block");
    paraml.invoke(new Canvas(paramBitmap));
    return paramBitmap;
  }
  
  public static final boolean contains(Bitmap paramBitmap, Point paramPoint)
  {
    j.f(paramBitmap, "$this$contains");
    j.f(paramPoint, "p");
    int i = paramPoint.x;
    if ((i >= 0) && (i < paramBitmap.getWidth()))
    {
      i = paramPoint.y;
      if ((i >= 0) && (i < paramBitmap.getHeight())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static final boolean contains(Bitmap paramBitmap, PointF paramPointF)
  {
    j.f(paramBitmap, "$this$contains");
    j.f(paramPointF, "p");
    float f1 = paramPointF.x;
    boolean bool1 = false;
    float f2 = 0;
    boolean bool2 = bool1;
    if (f1 >= f2)
    {
      bool2 = bool1;
      if (f1 < paramBitmap.getWidth())
      {
        f1 = paramPointF.y;
        bool2 = bool1;
        if (f1 >= f2)
        {
          bool2 = bool1;
          if (f1 < paramBitmap.getHeight()) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static final Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    j.f(paramConfig, "config");
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    j.b(paramConfig, "Bitmap.createBitmap(width, height, config)");
    return paramConfig;
  }
  
  @RequiresApi(26)
  public static final Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean, ColorSpace paramColorSpace)
  {
    j.f(paramConfig, "config");
    j.f(paramColorSpace, "colorSpace");
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig, paramBoolean, paramColorSpace);
    j.b(paramConfig, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
    return paramConfig;
  }
  
  public static final int get(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    j.f(paramBitmap, "$this$get");
    return paramBitmap.getPixel(paramInt1, paramInt2);
  }
  
  public static final Bitmap scale(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    j.f(paramBitmap, "$this$scale");
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, paramBoolean);
    j.b(paramBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
    return paramBitmap;
  }
  
  public static final void set(Bitmap paramBitmap, int paramInt1, int paramInt2, @ColorInt int paramInt3)
  {
    j.f(paramBitmap, "$this$set");
    paramBitmap.setPixel(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\BitmapKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */