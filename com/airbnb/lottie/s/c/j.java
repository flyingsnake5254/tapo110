package com.airbnb.lottie.s.c;

import android.graphics.PointF;
import com.airbnb.lottie.w.c;
import java.util.List;

public class j
  extends f<PointF>
{
  private final PointF i = new PointF();
  
  public j(List<com.airbnb.lottie.w.a<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF o(com.airbnb.lottie.w.a<PointF> parama, float paramFloat)
  {
    Object localObject1 = parama.b;
    if (localObject1 != null)
    {
      Object localObject2 = parama.c;
      if (localObject2 != null)
      {
        localObject1 = (PointF)localObject1;
        localObject2 = (PointF)localObject2;
        c localc = this.e;
        if (localc != null)
        {
          parama = (PointF)localc.b(parama.e, parama.f.floatValue(), localObject1, localObject2, paramFloat, e(), f());
          if (parama != null) {
            return parama;
          }
        }
        parama = this.i;
        float f1 = ((PointF)localObject1).x;
        float f2 = ((PointF)localObject2).x;
        float f3 = ((PointF)localObject1).y;
        parama.set(f1 + (f2 - f1) * paramFloat, f3 + paramFloat * (((PointF)localObject2).y - f3));
        return this.i;
      }
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */