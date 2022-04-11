package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class CanvasKt
{
  public static final void withClip(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withClip");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.clipRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withClip(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withClip");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.clipRect(paramInt1, paramInt2, paramInt3, paramInt4);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withClip(Canvas paramCanvas, Path paramPath, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withClip");
    j.f(paramPath, "clipPath");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.clipPath(paramPath);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withClip(Canvas paramCanvas, Rect paramRect, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withClip");
    j.f(paramRect, "clipRect");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withClip(Canvas paramCanvas, RectF paramRectF, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withClip");
    j.f(paramRectF, "clipRect");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.clipRect(paramRectF);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withMatrix(Canvas paramCanvas, Matrix paramMatrix, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withMatrix");
    j.f(paramMatrix, "matrix");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withRotation(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withRotation");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.rotate(paramFloat1, paramFloat2, paramFloat3);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withSave(Canvas paramCanvas, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withSave");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withScale(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withScale");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.scale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withSkew(Canvas paramCanvas, float paramFloat1, float paramFloat2, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withSkew");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.skew(paramFloat1, paramFloat2);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
  
  public static final void withTranslation(Canvas paramCanvas, float paramFloat1, float paramFloat2, l<? super Canvas, p> paraml)
  {
    j.f(paramCanvas, "$this$withTranslation");
    j.f(paraml, "block");
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    try
    {
      paraml.invoke(paramCanvas);
      return;
    }
    finally
    {
      i.b(1);
      paramCanvas.restoreToCount(i);
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\CanvasKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */