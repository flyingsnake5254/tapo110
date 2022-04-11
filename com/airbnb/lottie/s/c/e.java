package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.c;
import java.util.List;

public class e
  extends f<Integer>
{
  public e(List<com.airbnb.lottie.w.a<Integer>> paramList)
  {
    super(paramList);
  }
  
  public int o()
  {
    return p(b(), d());
  }
  
  int p(com.airbnb.lottie.w.a<Integer> parama, float paramFloat)
  {
    if ((parama.b != null) && (parama.c != null))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        localObject = (Integer)((c)localObject).b(parama.e, parama.f.floatValue(), parama.b, parama.c, paramFloat, e(), f());
        if (localObject != null) {
          return ((Integer)localObject).intValue();
        }
      }
      return g.k(parama.g(), parama.d(), paramFloat);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Integer q(com.airbnb.lottie.w.a<Integer> parama, float paramFloat)
  {
    return Integer.valueOf(p(parama, paramFloat));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */