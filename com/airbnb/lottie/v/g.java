package com.airbnb.lottie.v;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.k;
import java.util.List;

public class g
{
  private static PointF a = new PointF();
  
  public static PointF a(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt3, paramInt1));
  }
  
  public static boolean d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((paramFloat1 >= paramFloat2) && (paramFloat1 <= paramFloat3)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static int e(int paramInt1, int paramInt2)
  {
    int i = paramInt1 / paramInt2;
    int j;
    if ((paramInt1 ^ paramInt2) >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k = i;
    if (j == 0)
    {
      k = i;
      if (paramInt1 % paramInt2 != 0) {
        k = i - 1;
      }
    }
    return k;
  }
  
  static int f(float paramFloat1, float paramFloat2)
  {
    return g((int)paramFloat1, (int)paramFloat2);
  }
  
  private static int g(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2 * e(paramInt1, paramInt2);
  }
  
  public static void h(h paramh, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramh.b();
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    a.set(localPointF1.x, localPointF1.y);
    for (int i = 0; i < paramh.a().size(); i++)
    {
      Object localObject = (a)paramh.a().get(i);
      PointF localPointF2 = ((a)localObject).a();
      localPointF1 = ((a)localObject).b();
      localObject = ((a)localObject).c();
      if ((localPointF2.equals(a)) && (localPointF1.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      } else {
        paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF1.x, localPointF1.y, ((PointF)localObject).x, ((PointF)localObject).y);
      }
      a.set(((PointF)localObject).x, ((PointF)localObject).y);
    }
    if (paramh.d()) {
      paramPath.close();
    }
  }
  
  public static double i(double paramDouble1, double paramDouble2, @FloatRange(from=0.0D, to=1.0D) double paramDouble3)
  {
    return paramDouble1 + paramDouble3 * (paramDouble2 - paramDouble1);
  }
  
  public static float j(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static int k(int paramInt1, int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (int)(paramInt1 + paramFloat * (paramInt2 - paramInt1));
  }
  
  public static void l(d paramd1, int paramInt, List<d> paramList, d paramd2, k paramk)
  {
    if (paramd1.c(paramk.getName(), paramInt)) {
      paramList.add(paramd2.a(paramk.getName()).j(paramk));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\v\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */