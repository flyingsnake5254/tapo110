package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import kotlin.jvm.internal.j;

public final class RectKt
{
  @SuppressLint({"CheckResult"})
  public static final Rect and(Rect paramRect1, Rect paramRect2)
  {
    j.f(paramRect1, "$this$and");
    j.f(paramRect2, "r");
    paramRect1 = new Rect(paramRect1);
    paramRect1.intersect(paramRect2);
    return paramRect1;
  }
  
  @SuppressLint({"CheckResult"})
  public static final RectF and(RectF paramRectF1, RectF paramRectF2)
  {
    j.f(paramRectF1, "$this$and");
    j.f(paramRectF2, "r");
    paramRectF1 = new RectF(paramRectF1);
    paramRectF1.intersect(paramRectF2);
    return paramRectF1;
  }
  
  public static final float component1(RectF paramRectF)
  {
    j.f(paramRectF, "$this$component1");
    return paramRectF.left;
  }
  
  public static final int component1(Rect paramRect)
  {
    j.f(paramRect, "$this$component1");
    return paramRect.left;
  }
  
  public static final float component2(RectF paramRectF)
  {
    j.f(paramRectF, "$this$component2");
    return paramRectF.top;
  }
  
  public static final int component2(Rect paramRect)
  {
    j.f(paramRect, "$this$component2");
    return paramRect.top;
  }
  
  public static final float component3(RectF paramRectF)
  {
    j.f(paramRectF, "$this$component3");
    return paramRectF.right;
  }
  
  public static final int component3(Rect paramRect)
  {
    j.f(paramRect, "$this$component3");
    return paramRect.right;
  }
  
  public static final float component4(RectF paramRectF)
  {
    j.f(paramRectF, "$this$component4");
    return paramRectF.bottom;
  }
  
  public static final int component4(Rect paramRect)
  {
    j.f(paramRect, "$this$component4");
    return paramRect.bottom;
  }
  
  public static final boolean contains(Rect paramRect, Point paramPoint)
  {
    j.f(paramRect, "$this$contains");
    j.f(paramPoint, "p");
    return paramRect.contains(paramPoint.x, paramPoint.y);
  }
  
  public static final boolean contains(RectF paramRectF, PointF paramPointF)
  {
    j.f(paramRectF, "$this$contains");
    j.f(paramPointF, "p");
    return paramRectF.contains(paramPointF.x, paramPointF.y);
  }
  
  public static final Rect minus(Rect paramRect, int paramInt)
  {
    j.f(paramRect, "$this$minus");
    paramRect = new Rect(paramRect);
    paramInt = -paramInt;
    paramRect.offset(paramInt, paramInt);
    return paramRect;
  }
  
  public static final Rect minus(Rect paramRect, Point paramPoint)
  {
    j.f(paramRect, "$this$minus");
    j.f(paramPoint, "xy");
    paramRect = new Rect(paramRect);
    paramRect.offset(-paramPoint.x, -paramPoint.y);
    return paramRect;
  }
  
  public static final RectF minus(RectF paramRectF, float paramFloat)
  {
    j.f(paramRectF, "$this$minus");
    paramRectF = new RectF(paramRectF);
    paramFloat = -paramFloat;
    paramRectF.offset(paramFloat, paramFloat);
    return paramRectF;
  }
  
  public static final RectF minus(RectF paramRectF, PointF paramPointF)
  {
    j.f(paramRectF, "$this$minus");
    j.f(paramPointF, "xy");
    paramRectF = new RectF(paramRectF);
    paramRectF.offset(-paramPointF.x, -paramPointF.y);
    return paramRectF;
  }
  
  public static final Region minus(Rect paramRect1, Rect paramRect2)
  {
    j.f(paramRect1, "$this$minus");
    j.f(paramRect2, "r");
    paramRect1 = new Region(paramRect1);
    paramRect1.op(paramRect2, Region.Op.DIFFERENCE);
    return paramRect1;
  }
  
  public static final Region minus(RectF paramRectF1, RectF paramRectF2)
  {
    j.f(paramRectF1, "$this$minus");
    j.f(paramRectF2, "r");
    Object localObject = new Rect();
    paramRectF1.roundOut((Rect)localObject);
    localObject = new Region((Rect)localObject);
    paramRectF1 = new Rect();
    paramRectF2.roundOut(paramRectF1);
    ((Region)localObject).op(paramRectF1, Region.Op.DIFFERENCE);
    return (Region)localObject;
  }
  
  public static final Rect or(Rect paramRect1, Rect paramRect2)
  {
    j.f(paramRect1, "$this$or");
    j.f(paramRect2, "r");
    paramRect1 = new Rect(paramRect1);
    paramRect1.union(paramRect2);
    return paramRect1;
  }
  
  public static final RectF or(RectF paramRectF1, RectF paramRectF2)
  {
    j.f(paramRectF1, "$this$or");
    j.f(paramRectF2, "r");
    paramRectF1 = new RectF(paramRectF1);
    paramRectF1.union(paramRectF2);
    return paramRectF1;
  }
  
  public static final Rect plus(Rect paramRect, int paramInt)
  {
    j.f(paramRect, "$this$plus");
    paramRect = new Rect(paramRect);
    paramRect.offset(paramInt, paramInt);
    return paramRect;
  }
  
  public static final Rect plus(Rect paramRect, Point paramPoint)
  {
    j.f(paramRect, "$this$plus");
    j.f(paramPoint, "xy");
    paramRect = new Rect(paramRect);
    paramRect.offset(paramPoint.x, paramPoint.y);
    return paramRect;
  }
  
  public static final Rect plus(Rect paramRect1, Rect paramRect2)
  {
    j.f(paramRect1, "$this$plus");
    j.f(paramRect2, "r");
    paramRect1 = new Rect(paramRect1);
    paramRect1.union(paramRect2);
    return paramRect1;
  }
  
  public static final RectF plus(RectF paramRectF, float paramFloat)
  {
    j.f(paramRectF, "$this$plus");
    paramRectF = new RectF(paramRectF);
    paramRectF.offset(paramFloat, paramFloat);
    return paramRectF;
  }
  
  public static final RectF plus(RectF paramRectF, PointF paramPointF)
  {
    j.f(paramRectF, "$this$plus");
    j.f(paramPointF, "xy");
    paramRectF = new RectF(paramRectF);
    paramRectF.offset(paramPointF.x, paramPointF.y);
    return paramRectF;
  }
  
  public static final RectF plus(RectF paramRectF1, RectF paramRectF2)
  {
    j.f(paramRectF1, "$this$plus");
    j.f(paramRectF2, "r");
    paramRectF1 = new RectF(paramRectF1);
    paramRectF1.union(paramRectF2);
    return paramRectF1;
  }
  
  public static final Rect times(Rect paramRect, int paramInt)
  {
    j.f(paramRect, "$this$times");
    paramRect = new Rect(paramRect);
    paramRect.top *= paramInt;
    paramRect.left *= paramInt;
    paramRect.right *= paramInt;
    paramRect.bottom *= paramInt;
    return paramRect;
  }
  
  public static final RectF times(RectF paramRectF, float paramFloat)
  {
    j.f(paramRectF, "$this$times");
    paramRectF = new RectF(paramRectF);
    paramRectF.top *= paramFloat;
    paramRectF.left *= paramFloat;
    paramRectF.right *= paramFloat;
    paramRectF.bottom *= paramFloat;
    return paramRectF;
  }
  
  public static final RectF times(RectF paramRectF, int paramInt)
  {
    j.f(paramRectF, "$this$times");
    float f = paramInt;
    paramRectF = new RectF(paramRectF);
    paramRectF.top *= f;
    paramRectF.left *= f;
    paramRectF.right *= f;
    paramRectF.bottom *= f;
    return paramRectF;
  }
  
  public static final Rect toRect(RectF paramRectF)
  {
    j.f(paramRectF, "$this$toRect");
    Rect localRect = new Rect();
    paramRectF.roundOut(localRect);
    return localRect;
  }
  
  public static final RectF toRectF(Rect paramRect)
  {
    j.f(paramRect, "$this$toRectF");
    return new RectF(paramRect);
  }
  
  public static final Region toRegion(Rect paramRect)
  {
    j.f(paramRect, "$this$toRegion");
    return new Region(paramRect);
  }
  
  public static final Region toRegion(RectF paramRectF)
  {
    j.f(paramRectF, "$this$toRegion");
    Rect localRect = new Rect();
    paramRectF.roundOut(localRect);
    return new Region(localRect);
  }
  
  public static final RectF transform(RectF paramRectF, Matrix paramMatrix)
  {
    j.f(paramRectF, "$this$transform");
    j.f(paramMatrix, "m");
    paramMatrix.mapRect(paramRectF);
    return paramRectF;
  }
  
  public static final Region xor(Rect paramRect1, Rect paramRect2)
  {
    j.f(paramRect1, "$this$xor");
    j.f(paramRect2, "r");
    paramRect1 = new Region(paramRect1);
    paramRect1.op(paramRect2, Region.Op.XOR);
    return paramRect1;
  }
  
  public static final Region xor(RectF paramRectF1, RectF paramRectF2)
  {
    j.f(paramRectF1, "$this$xor");
    j.f(paramRectF2, "r");
    Rect localRect = new Rect();
    paramRectF1.roundOut(localRect);
    paramRectF1 = new Region(localRect);
    localRect = new Rect();
    paramRectF2.roundOut(localRect);
    paramRectF1.op(localRect, Region.Op.XOR);
    return paramRectF1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\RectKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */