package kotlinx.coroutines;

import kotlin.a;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.scheduling.h;

public abstract class m0<T>
  extends h
{
  public int f;
  
  public m0(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(Object paramObject, Throwable paramThrowable)
  {
    j.f(paramThrowable, "cause");
  }
  
  public abstract c<T> d();
  
  public final Throwable e(Object paramObject)
  {
    boolean bool = paramObject instanceof r;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    r localr = (r)paramObject;
    paramObject = localObject;
    if (localr != null) {
      paramObject = localr.b;
    }
    return (Throwable)paramObject;
  }
  
  public <T> T g(Object paramObject)
  {
    return (T)paramObject;
  }
  
  public final void i(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if ((paramThrowable1 == null) && (paramThrowable2 == null)) {
      return;
    }
    if ((paramThrowable1 != null) && (paramThrowable2 != null)) {
      a.a(paramThrowable1, paramThrowable2);
    }
    if (paramThrowable1 == null) {
      paramThrowable1 = paramThrowable2;
    }
    paramThrowable2 = new StringBuilder();
    paramThrowable2.append("Fatal exception in coroutines machinery for ");
    paramThrowable2.append(this);
    paramThrowable2.append(". ");
    paramThrowable2.append("Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
    paramThrowable2 = paramThrowable2.toString();
    if (paramThrowable1 == null) {
      j.n();
    }
    paramThrowable1 = new CoroutinesInternalError(paramThrowable2, paramThrowable1);
    a0.a(d().getContext(), paramThrowable1);
  }
  
  public abstract Object j();
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	kotlinx/coroutines/scheduling/h:d	Lkotlinx/coroutines/scheduling/i;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 75	kotlinx/coroutines/m0:d	()Lkotlin/coroutines/c;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +250 -> 261
    //   14: aload_2
    //   15: checkcast 94	kotlinx/coroutines/j0
    //   18: astore_2
    //   19: aload_2
    //   20: getfield 98	kotlinx/coroutines/j0:p0	Lkotlin/coroutines/c;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 81 1 0
    //   30: astore 4
    //   32: aload_0
    //   33: invokevirtual 100	kotlinx/coroutines/m0:j	()Ljava/lang/Object;
    //   36: astore 5
    //   38: aload 4
    //   40: aload_2
    //   41: getfield 104	kotlinx/coroutines/j0:y	Ljava/lang/Object;
    //   44: invokestatic 109	kotlinx/coroutines/internal/x:c	(Lkotlin/coroutines/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: astore 6
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 111	kotlinx/coroutines/m0:e	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 14	kotlinx/coroutines/m0:f	I
    //   61: invokestatic 116	kotlinx/coroutines/s1:a	(I)Z
    //   64: ifeq +20 -> 84
    //   67: aload 4
    //   69: getstatic 122	kotlinx/coroutines/d1:h	Lkotlinx/coroutines/d1$b;
    //   72: invokeinterface 128 2 0
    //   77: checkcast 118	kotlinx/coroutines/d1
    //   80: astore_2
    //   81: goto +5 -> 86
    //   84: aconst_null
    //   85: astore_2
    //   86: aload 7
    //   88: ifnonnull +55 -> 143
    //   91: aload_2
    //   92: ifnull +51 -> 143
    //   95: aload_2
    //   96: invokeinterface 132 1 0
    //   101: ifne +42 -> 143
    //   104: aload_2
    //   105: invokeinterface 135 1 0
    //   110: astore_2
    //   111: aload_0
    //   112: aload 5
    //   114: aload_2
    //   115: invokevirtual 137	kotlinx/coroutines/m0:c	(Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   118: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   121: astore 5
    //   123: aload_3
    //   124: aload_2
    //   125: aload_3
    //   126: invokestatic 149	kotlinx/coroutines/internal/s:k	(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Throwable;
    //   129: invokestatic 154	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   132: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: invokeinterface 161 2 0
    //   140: goto +56 -> 196
    //   143: aload 7
    //   145: ifnull +28 -> 173
    //   148: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   151: astore_2
    //   152: aload_3
    //   153: aload 7
    //   155: aload_3
    //   156: invokestatic 149	kotlinx/coroutines/internal/s:k	(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Throwable;
    //   159: invokestatic 154	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   162: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: invokeinterface 161 2 0
    //   170: goto +26 -> 196
    //   173: aload_0
    //   174: aload 5
    //   176: invokevirtual 163	kotlinx/coroutines/m0:g	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore 5
    //   181: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   184: astore_2
    //   185: aload_3
    //   186: aload 5
    //   188: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: invokeinterface 161 2 0
    //   196: getstatic 168	kotlin/p:a	Lkotlin/p;
    //   199: astore_2
    //   200: aload 4
    //   202: aload 6
    //   204: invokestatic 171	kotlinx/coroutines/internal/x:a	(Lkotlin/coroutines/f;Ljava/lang/Object;)V
    //   207: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   210: astore 4
    //   212: aload_1
    //   213: invokeinterface 175 1 0
    //   218: aload_2
    //   219: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   222: astore_2
    //   223: goto +16 -> 239
    //   226: astore_1
    //   227: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   230: astore_2
    //   231: aload_1
    //   232: invokestatic 154	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   235: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: astore_2
    //   239: aload_0
    //   240: aconst_null
    //   241: aload_2
    //   242: invokestatic 178	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   245: invokevirtual 180	kotlinx/coroutines/m0:i	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   248: goto +70 -> 318
    //   251: astore_2
    //   252: aload 4
    //   254: aload 6
    //   256: invokestatic 171	kotlinx/coroutines/internal/x:a	(Lkotlin/coroutines/f;Ljava/lang/Object;)V
    //   259: aload_2
    //   260: athrow
    //   261: new 182	kotlin/TypeCastException
    //   264: astore_2
    //   265: aload_2
    //   266: ldc -72
    //   268: invokespecial 187	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   271: aload_2
    //   272: athrow
    //   273: astore 4
    //   275: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   278: astore_2
    //   279: aload_1
    //   280: invokeinterface 175 1 0
    //   285: getstatic 168	kotlin/p:a	Lkotlin/p;
    //   288: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: astore_2
    //   292: goto +16 -> 308
    //   295: astore_1
    //   296: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$a;
    //   299: astore_2
    //   300: aload_1
    //   301: invokestatic 154	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   304: invokestatic 157	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: astore_2
    //   308: aload_0
    //   309: aload 4
    //   311: aload_2
    //   312: invokestatic 178	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   315: invokevirtual 180	kotlinx/coroutines/m0:i	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   318: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	m0
    //   4	209	1	locali	kotlinx.coroutines.scheduling.i
    //   226	54	1	localThrowable1	Throwable
    //   295	6	1	localThrowable2	Throwable
    //   9	233	2	localObject1	Object
    //   251	9	2	localObject2	Object
    //   264	48	2	localObject3	Object
    //   23	163	3	localc	c
    //   30	223	4	localObject4	Object
    //   273	37	4	localThrowable3	Throwable
    //   36	151	5	localObject5	Object
    //   47	208	6	localObject6	Object
    //   55	99	7	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   207	223	226	finally
    //   49	81	251	finally
    //   95	140	251	finally
    //   148	170	251	finally
    //   173	196	251	finally
    //   196	200	251	finally
    //   5	10	273	finally
    //   14	49	273	finally
    //   200	207	273	finally
    //   252	261	273	finally
    //   261	273	273	finally
    //   275	292	295	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */