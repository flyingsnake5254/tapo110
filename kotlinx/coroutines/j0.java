package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlinx.coroutines.internal.x;

public final class j0<T>
  extends m0<T>
  implements kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c<T>
{
  public final kotlin.coroutines.c<T> p0;
  public Object q;
  private final kotlin.coroutines.jvm.internal.c x;
  public final Object y;
  public final y z;
  
  public j0(y paramy, kotlin.coroutines.c<? super T> paramc)
  {
    super(0);
    this.z = paramy;
    this.p0 = paramc;
    this.q = l0.a();
    paramy = paramc;
    if (!(paramc instanceof kotlin.coroutines.jvm.internal.c)) {
      paramy = null;
    }
    this.x = ((kotlin.coroutines.jvm.internal.c)paramy);
    this.y = x.b(getContext());
  }
  
  public kotlin.coroutines.c<T> d()
  {
    return this;
  }
  
  public kotlin.coroutines.jvm.internal.c getCallerFrame()
  {
    return this.x;
  }
  
  public f getContext()
  {
    return this.p0.getContext();
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public Object j()
  {
    Object localObject = this.q;
    if (g0.a())
    {
      int i;
      if (localObject != l0.a()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    this.q = l0.a();
    return localObject;
  }
  
  public final void k(T paramT)
  {
    f localf = this.p0.getContext();
    this.q = paramT;
    this.f = 1;
    this.z.dispatchYield(localf, this);
  }
  
  /* Error */
  public void resumeWith(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	kotlinx/coroutines/j0:p0	Lkotlin/coroutines/c;
    //   4: invokeinterface 69 1 0
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 101	kotlinx/coroutines/s:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 36	kotlinx/coroutines/j0:z	Lkotlinx/coroutines/y;
    //   19: aload_2
    //   20: invokevirtual 105	kotlinx/coroutines/y:isDispatchNeeded	(Lkotlin/coroutines/f;)Z
    //   23: ifeq +25 -> 48
    //   26: aload_0
    //   27: aload_3
    //   28: putfield 46	kotlinx/coroutines/j0:q	Ljava/lang/Object;
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 88	kotlinx/coroutines/m0:f	I
    //   36: aload_0
    //   37: getfield 36	kotlinx/coroutines/j0:z	Lkotlinx/coroutines/y;
    //   40: aload_2
    //   41: aload_0
    //   42: invokevirtual 108	kotlinx/coroutines/y:dispatch	(Lkotlin/coroutines/f;Ljava/lang/Runnable;)V
    //   45: goto +106 -> 151
    //   48: getstatic 113	kotlinx/coroutines/x1:b	Lkotlinx/coroutines/x1;
    //   51: invokevirtual 116	kotlinx/coroutines/x1:a	()Lkotlinx/coroutines/q0;
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 121	kotlinx/coroutines/q0:A	()Z
    //   59: ifeq +21 -> 80
    //   62: aload_0
    //   63: aload_3
    //   64: putfield 46	kotlinx/coroutines/j0:q	Ljava/lang/Object;
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 88	kotlinx/coroutines/m0:f	I
    //   72: aload_2
    //   73: aload_0
    //   74: invokevirtual 125	kotlinx/coroutines/q0:w	(Lkotlinx/coroutines/m0;)V
    //   77: goto +74 -> 151
    //   80: aload_2
    //   81: iconst_1
    //   82: invokevirtual 128	kotlinx/coroutines/q0:y	(Z)V
    //   85: aload_0
    //   86: invokevirtual 52	kotlinx/coroutines/j0:getContext	()Lkotlin/coroutines/f;
    //   89: astore_3
    //   90: aload_3
    //   91: aload_0
    //   92: getfield 60	kotlinx/coroutines/j0:y	Ljava/lang/Object;
    //   95: invokestatic 132	kotlinx/coroutines/internal/x:c	(Lkotlin/coroutines/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 38	kotlinx/coroutines/j0:p0	Lkotlin/coroutines/c;
    //   104: aload_1
    //   105: invokeinterface 134 2 0
    //   110: getstatic 139	kotlin/p:a	Lkotlin/p;
    //   113: astore_1
    //   114: aload_3
    //   115: aload 4
    //   117: invokestatic 142	kotlinx/coroutines/internal/x:a	(Lkotlin/coroutines/f;Ljava/lang/Object;)V
    //   120: aload_2
    //   121: invokevirtual 145	kotlinx/coroutines/q0:C	()Z
    //   124: ifne -4 -> 120
    //   127: goto +19 -> 146
    //   130: astore_1
    //   131: aload_3
    //   132: aload 4
    //   134: invokestatic 142	kotlinx/coroutines/internal/x:a	(Lkotlin/coroutines/f;Ljava/lang/Object;)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: aload_0
    //   141: aload_1
    //   142: aconst_null
    //   143: invokevirtual 149	kotlinx/coroutines/m0:i	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   146: aload_2
    //   147: iconst_1
    //   148: invokevirtual 152	kotlinx/coroutines/q0:u	(Z)V
    //   151: return
    //   152: astore_1
    //   153: aload_2
    //   154: iconst_1
    //   155: invokevirtual 152	kotlinx/coroutines/q0:u	(Z)V
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	j0
    //   0	160	1	paramObject	Object
    //   9	145	2	localObject1	Object
    //   14	118	3	localObject2	Object
    //   98	35	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   100	114	130	finally
    //   85	100	139	finally
    //   114	120	139	finally
    //   120	127	139	finally
    //   131	139	139	finally
    //   140	146	152	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DispatchedContinuation[");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", ");
    localStringBuilder.append(h0.c(this.p0));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */