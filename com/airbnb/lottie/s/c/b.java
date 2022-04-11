package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import com.airbnb.lottie.w.c;
import java.util.List;

public class b
  extends f<Integer>
{
  public b(List<com.airbnb.lottie.w.a<Integer>> paramList)
  {
    super(paramList);
  }
  
  public int o()
  {
    return p(b(), d());
  }
  
  public int p(com.airbnb.lottie.w.a<Integer> parama, float paramFloat)
  {
    Object localObject = parama.b;
    if ((localObject != null) && (parama.c != null))
    {
      int i = ((Integer)localObject).intValue();
      int j = ((Integer)parama.c).intValue();
      localObject = this.e;
      if (localObject != null)
      {
        parama = (Integer)((c)localObject).b(parama.e, parama.f.floatValue(), Integer.valueOf(i), Integer.valueOf(j), paramFloat, e(), f());
        if (parama != null) {
          return parama.intValue();
        }
      }
      return com.airbnb.lottie.v.b.c(g.b(paramFloat, 0.0F, 1.0F), i, j);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Integer q(com.airbnb.lottie.w.a<Integer> parama, float paramFloat)
  {
    return Integer.valueOf(p(parama, paramFloat));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */