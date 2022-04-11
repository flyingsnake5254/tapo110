package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.f;

public abstract class RestrictedContinuationImpl
  extends BaseContinuationImpl
{
  public RestrictedContinuationImpl(c<Object> paramc)
  {
    super(paramc);
    if (paramc != null)
    {
      int i;
      if (paramc.getContext() == EmptyCoroutineContext.INSTANCE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
      }
    }
  }
  
  public f getContext()
  {
    return EmptyCoroutineContext.INSTANCE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\RestrictedContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */