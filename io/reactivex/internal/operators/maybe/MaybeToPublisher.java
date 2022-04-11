package io.reactivex.internal.operators.maybe;

import e.b.a;
import io.reactivex.g0.j;
import io.reactivex.o;

public enum MaybeToPublisher
  implements j<o<Object>, a<Object>>
{
  static
  {
    MaybeToPublisher localMaybeToPublisher = new MaybeToPublisher("INSTANCE", 0);
    INSTANCE = localMaybeToPublisher;
    $VALUES = new MaybeToPublisher[] { localMaybeToPublisher };
  }
  
  public static <T> j<o<T>, a<T>> instance()
  {
    return INSTANCE;
  }
  
  public a<Object> apply(o<Object> paramo)
    throws Exception
  {
    return new i(paramo);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\MaybeToPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */