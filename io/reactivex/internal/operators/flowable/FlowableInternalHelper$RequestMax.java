package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.g;

public enum FlowableInternalHelper$RequestMax
  implements g<c>
{
  static
  {
    RequestMax localRequestMax = new RequestMax("INSTANCE", 0);
    INSTANCE = localRequestMax;
    $VALUES = new RequestMax[] { localRequestMax };
  }
  
  public void accept(c paramc)
    throws Exception
  {
    paramc.request(Long.MAX_VALUE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\FlowableInternalHelper$RequestMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */