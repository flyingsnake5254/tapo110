package kotlinx.coroutines.sync;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlin.k;
import kotlinx.coroutines.internal.t;

public final class MutexKt
{
  private static final t a = new t("LOCK_FAIL");
  private static final t b = new t("ENQUEUE_FAIL");
  private static final t c = new t("UNLOCK_FAIL");
  private static final t d = new t("SELECT_SUCCESS");
  private static final t e;
  private static final t f;
  private static final a g;
  private static final a h;
  
  static
  {
    t localt1 = new t("LOCKED");
    e = localt1;
    t localt2 = new t("UNLOCKED");
    f = localt2;
    g = new a(localt1);
    h = new a(localt2);
  }
  
  public static final <T> Object a(b paramb, Object paramObject, kotlin.jvm.b.a<? extends T> parama, c<? super T> paramc)
  {
    if ((paramc instanceof withLock.1))
    {
      local1 = (withLock.1)paramc;
      i = local1.label;
      if ((i & 0x80000000) != 0)
      {
        local1.label = (i + Integer.MIN_VALUE);
        break label51;
      }
    }
    ContinuationImpl local1 = new ContinuationImpl(paramc)
    {
      Object L$0;
      Object L$1;
      Object L$2;
      int label;
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        this.result = paramAnonymousObject;
        this.label |= 0x80000000;
        return MutexKt.a(null, null, null, this);
      }
    };
    label51:
    Object localObject1 = local1.result;
    Object localObject2 = kotlin.coroutines.intrinsics.a.d();
    int i = local1.label;
    Object localObject3;
    if (i != 0)
    {
      if (i == 1)
      {
        parama = (kotlin.jvm.b.a)local1.L$2;
        localObject3 = local1.L$1;
        paramc = (b)local1.L$0;
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
      local1.L$0 = paramb;
      local1.L$1 = paramObject;
      local1.L$2 = parama;
      local1.label = 1;
      paramc = paramb;
      localObject3 = paramObject;
      if (paramb.a(paramObject, local1) == localObject2) {
        return localObject2;
      }
    }
    try
    {
      paramb = parama.invoke();
      return paramb;
    }
    finally
    {
      i.b(1);
      paramc.b(localObject3);
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\sync\MutexKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */