package com.airbnb.lottie.s.c;

import androidx.annotation.Nullable;
import com.airbnb.lottie.w.b;
import com.airbnb.lottie.w.c;
import java.util.Collections;

public class p<K, A>
  extends a<K, A>
{
  private final b<A> i = new b();
  private final A j;
  
  public p(c<A> paramc)
  {
    this(paramc, null);
  }
  
  public p(c<A> paramc, @Nullable A paramA)
  {
    super(Collections.emptyList());
    m(paramc);
    this.j = paramA;
  }
  
  float c()
  {
    return 1.0F;
  }
  
  public A h()
  {
    c localc = this.e;
    Object localObject = this.j;
    return (A)localc.b(0.0F, 0.0F, localObject, localObject, f(), f(), f());
  }
  
  A i(com.airbnb.lottie.w.a<K> parama, float paramFloat)
  {
    return (A)h();
  }
  
  public void j()
  {
    if (this.e != null) {
      super.j();
    }
  }
  
  public void l(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */