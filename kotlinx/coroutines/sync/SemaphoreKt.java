package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlin.k;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.u;

public final class SemaphoreKt
{
  private static final t a = new t("RESUMED");
  private static final t b = new t("CANCELLED");
  private static final int c = u.f("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
  
  public static final <T> Object a(c paramc, kotlin.jvm.b.a<? extends T> parama, kotlin.coroutines.c<? super T> paramc1)
  {
    if ((paramc1 instanceof withPermit.1))
    {
      local1 = (withPermit.1)paramc1;
      i = local1.label;
      if ((i & 0x80000000) != 0)
      {
        local1.label = (i + Integer.MIN_VALUE);
        break label47;
      }
    }
    ContinuationImpl local1 = new ContinuationImpl(paramc1)
    {
      Object L$0;
      Object L$1;
      int label;
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        this.result = paramAnonymousObject;
        this.label |= 0x80000000;
        return SemaphoreKt.a(null, null, this);
      }
    };
    label47:
    Object localObject1 = local1.result;
    Object localObject2 = kotlin.coroutines.intrinsics.a.d();
    int i = local1.label;
    if (i != 0)
    {
      if (i == 1)
      {
        parama = (kotlin.jvm.b.a)local1.L$1;
        paramc1 = (c)local1.L$0;
        k.b(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      k.b(localObject1);
      local1.L$0 = paramc;
      local1.L$1 = parama;
      local1.label = 1;
      paramc1 = paramc;
      if (paramc.a(local1) == localObject2) {
        return localObject2;
      }
    }
    try
    {
      paramc = parama.invoke();
      return paramc;
    }
    finally
    {
      i.b(1);
      paramc1.release();
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\sync\SemaphoreKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */