package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.jvm.internal.j;

public final class PointKt
{
  public static final float component1(PointF paramPointF)
  {
    j.f(paramPointF, "$this$component1");
    return paramPointF.x;
  }
  
  public static final int component1(Point paramPoint)
  {
    j.f(paramPoint, "$this$component1");
    return paramPoint.x;
  }
  
  public static final float component2(PointF paramPointF)
  {
    j.f(paramPointF, "$this$component2");
    return paramPointF.y;
  }
  
  public static final int component2(Point paramPoint)
  {
    j.f(paramPoint, "$this$component2");
    return paramPoint.y;
  }
  
  public static final Point minus(Point paramPoint, int paramInt)
  {
    j.f(paramPoint, "$this$minus");
    paramPoint = new Point(paramPoint.x, paramPoint.y);
    paramInt = -paramInt;
    paramPoint.offset(paramInt, paramInt);
    return paramPoint;
  }
  
  public static final Point minus(Point paramPoint1, Point paramPoint2)
  {
    j.f(paramPoint1, "$this$minus");
    j.f(paramPoint2, "p");
    paramPoint1 = new Point(paramPoint1.x, paramPoint1.y);
    paramPoint1.offset(-paramPoint2.x, -paramPoint2.y);
    return paramPoint1;
  }
  
  public static final PointF minus(PointF paramPointF, float paramFloat)
  {
    j.f(paramPointF, "$this$minus");
    paramPointF = new PointF(paramPointF.x, paramPointF.y);
    paramFloat = -paramFloat;
    paramPointF.offset(paramFloat, paramFloat);
    return paramPointF;
  }
  
  public static final PointF minus(PointF paramPointF1, PointF paramPointF2)
  {
    j.f(paramPointF1, "$this$minus");
    j.f(paramPointF2, "p");
    paramPointF1 = new PointF(paramPointF1.x, paramPointF1.y);
    paramPointF1.offset(-paramPointF2.x, -paramPointF2.y);
    return paramPointF1;
  }
  
  public static final Point plus(Point paramPoint, int paramInt)
  {
    j.f(paramPoint, "$this$plus");
    paramPoint = new Point(paramPoint.x, paramPoint.y);
    paramPoint.offset(paramInt, paramInt);
    return paramPoint;
  }
  
  public static final Point plus(Point paramPoint1, Point paramPoint2)
  {
    j.f(paramPoint1, "$this$plus");
    j.f(paramPoint2, "p");
    paramPoint1 = new Point(paramPoint1.x, paramPoint1.y);
    paramPoint1.offset(paramPoint2.x, paramPoint2.y);
    return paramPoint1;
  }
  
  public static final PointF plus(PointF paramPointF, float paramFloat)
  {
    j.f(paramPointF, "$this$plus");
    paramPointF = new PointF(paramPointF.x, paramPointF.y);
    paramPointF.offset(paramFloat, paramFloat);
    return paramPointF;
  }
  
  public static final PointF plus(PointF paramPointF1, PointF paramPointF2)
  {
    j.f(paramPointF1, "$this$plus");
    j.f(paramPointF2, "p");
    paramPointF1 = new PointF(paramPointF1.x, paramPointF1.y);
    paramPointF1.offset(paramPointF2.x, paramPointF2.y);
    return paramPointF1;
  }
  
  public static final Point toPoint(PointF paramPointF)
  {
    j.f(paramPointF, "$this$toPoint");
    return new Point((int)paramPointF.x, (int)paramPointF.y);
  }
  
  public static final PointF toPointF(Point paramPoint)
  {
    j.f(paramPoint, "$this$toPointF");
    return new PointF(paramPoint);
  }
  
  public static final Point unaryMinus(Point paramPoint)
  {
    j.f(paramPoint, "$this$unaryMinus");
    return new Point(-paramPoint.x, -paramPoint.y);
  }
  
  public static final PointF unaryMinus(PointF paramPointF)
  {
    j.f(paramPointF, "$this$unaryMinus");
    return new PointF(-paramPointF.x, -paramPointF.y);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PointKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */