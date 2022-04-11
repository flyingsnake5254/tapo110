package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.Result.a;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;

public abstract class BaseContinuationImpl
  implements kotlin.coroutines.c<Object>, c, Serializable
{
  private final kotlin.coroutines.c<Object> completion;
  
  public BaseContinuationImpl(kotlin.coroutines.c<Object> paramc)
  {
    this.completion = paramc;
  }
  
  public kotlin.coroutines.c<p> create(Object paramObject, kotlin.coroutines.c<?> paramc)
  {
    j.e(paramc, "completion");
    throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
  }
  
  public kotlin.coroutines.c<p> create(kotlin.coroutines.c<?> paramc)
  {
    j.e(paramc, "completion");
    throw new UnsupportedOperationException("create(Continuation) has not been overridden");
  }
  
  public c getCallerFrame()
  {
    kotlin.coroutines.c localc1 = this.completion;
    kotlin.coroutines.c localc2 = localc1;
    if (!(localc1 instanceof c)) {
      localc2 = null;
    }
    return (c)localc2;
  }
  
  public final kotlin.coroutines.c<Object> getCompletion()
  {
    return this.completion;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return e.d(this);
  }
  
  protected abstract Object invokeSuspend(Object paramObject);
  
  protected void releaseIntercepted() {}
  
  public final void resumeWith(Object paramObject)
  {
    kotlin.coroutines.c localc;
    for (BaseContinuationImpl localBaseContinuationImpl = this;; localBaseContinuationImpl = (BaseContinuationImpl)localc)
    {
      f.b(localBaseContinuationImpl);
      localc = localBaseContinuationImpl.completion;
      j.c(localc);
      try
      {
        paramObject = localBaseContinuationImpl.invokeSuspend(paramObject);
        if (paramObject == a.d()) {
          return;
        }
        locala = Result.Companion;
        paramObject = Result.constructor-impl(paramObject);
      }
      finally
      {
        Result.a locala = Result.Companion;
        paramObject = Result.constructor-impl(k.a((Throwable)paramObject));
      }
      localBaseContinuationImpl.releaseIntercepted();
      if (!(localc instanceof BaseContinuationImpl)) {
        break;
      }
    }
    localc.resumeWith(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Continuation at ");
    Object localObject = getStackTraceElement();
    if (localObject == null) {
      localObject = getClass().getName();
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\BaseContinuationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */