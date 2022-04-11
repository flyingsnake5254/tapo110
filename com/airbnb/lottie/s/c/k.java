package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.c;
import com.airbnb.lottie.w.d;
import java.util.List;

public class k
  extends f<d>
{
  private final d i = new d();
  
  public k(List<com.airbnb.lottie.w.a<d>> paramList)
  {
    super(paramList);
  }
  
  public d o(com.airbnb.lottie.w.a<d> parama, float paramFloat)
  {
    Object localObject1 = parama.b;
    if (localObject1 != null)
    {
      Object localObject2 = parama.c;
      if (localObject2 != null)
      {
        localObject1 = (d)localObject1;
        localObject2 = (d)localObject2;
        c localc = this.e;
        if (localc != null)
        {
          parama = (d)localc.b(parama.e, parama.f.floatValue(), localObject1, localObject2, paramFloat, e(), f());
          if (parama != null) {
            return parama;
          }
        }
        this.i.d(g.j(((d)localObject1).b(), ((d)localObject2).b(), paramFloat), g.j(((d)localObject1).c(), ((d)localObject2).c(), paramFloat));
        return this.i;
      }
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */