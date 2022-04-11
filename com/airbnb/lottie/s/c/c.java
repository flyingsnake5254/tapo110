package com.airbnb.lottie.s.c;

import com.airbnb.lottie.v.g;
import java.util.List;

public class c
  extends f<Float>
{
  public c(List<com.airbnb.lottie.w.a<Float>> paramList)
  {
    super(paramList);
  }
  
  public float o()
  {
    return p(b(), d());
  }
  
  float p(com.airbnb.lottie.w.a<Float> parama, float paramFloat)
  {
    if ((parama.b != null) && (parama.c != null))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        localObject = (Float)((com.airbnb.lottie.w.c)localObject).b(parama.e, parama.f.floatValue(), parama.b, parama.c, paramFloat, e(), f());
        if (localObject != null) {
          return ((Float)localObject).floatValue();
        }
      }
      return g.j(parama.f(), parama.c(), paramFloat);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Float q(com.airbnb.lottie.w.a<Float> parama, float paramFloat)
  {
    return Float.valueOf(p(parama, paramFloat));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */