package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;

public final class PausingDispatcherKt
{
  public static final <T> Object whenCreated(Lifecycle paramLifecycle, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    return whenStateAtLeast(paramLifecycle, Lifecycle.State.CREATED, paramp, paramc);
  }
  
  public static final <T> Object whenCreated(LifecycleOwner paramLifecycleOwner, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    j.b(paramLifecycleOwner, "lifecycle");
    return whenCreated(paramLifecycleOwner, paramp, paramc);
  }
  
  public static final <T> Object whenResumed(Lifecycle paramLifecycle, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    return whenStateAtLeast(paramLifecycle, Lifecycle.State.RESUMED, paramp, paramc);
  }
  
  public static final <T> Object whenResumed(LifecycleOwner paramLifecycleOwner, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    j.b(paramLifecycleOwner, "lifecycle");
    return whenResumed(paramLifecycleOwner, paramp, paramc);
  }
  
  public static final <T> Object whenStarted(Lifecycle paramLifecycle, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    return whenStateAtLeast(paramLifecycle, Lifecycle.State.STARTED, paramp, paramc);
  }
  
  public static final <T> Object whenStarted(LifecycleOwner paramLifecycleOwner, kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    j.b(paramLifecycleOwner, "lifecycle");
    return whenStarted(paramLifecycleOwner, paramp, paramc);
  }
  
  public static final <T> Object whenStateAtLeast(Lifecycle paramLifecycle, final Lifecycle.State paramState, final kotlin.jvm.b.p<? super d0, ? super c<? super T>, ? extends Object> paramp, c<? super T> paramc)
  {
    kotlinx.coroutines.d.c(n0.b().u(), new SuspendLambda(paramLifecycle, paramState)
    {
      Object L$0;
      Object L$1;
      Object L$2;
      Object L$3;
      int label;
      private d0 p$;
      
      public final c<kotlin.p> create(Object paramAnonymousObject, c<?> paramAnonymousc)
      {
        j.f(paramAnonymousc, "completion");
        paramAnonymousc = new 2(this.$this_whenStateAtLeast, paramState, paramp, paramAnonymousc);
        paramAnonymousc.p$ = ((d0)paramAnonymousObject);
        return paramAnonymousc;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((2)create(paramAnonymousObject1, (c)paramAnonymousObject2)).invokeSuspend(kotlin.p.a);
      }
      
      /* Error */
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        // Byte code:
        //   0: invokestatic 86	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
        //   3: astore_2
        //   4: aload_0
        //   5: getfield 88	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:label	I
        //   8: istore_3
        //   9: iload_3
        //   10: ifeq +70 -> 80
        //   13: iload_3
        //   14: iconst_1
        //   15: if_icmpne +55 -> 70
        //   18: aload_0
        //   19: getfield 90	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$3	Ljava/lang/Object;
        //   22: checkcast 92	androidx/lifecycle/LifecycleController
        //   25: astore_2
        //   26: aload_0
        //   27: getfield 94	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$2	Ljava/lang/Object;
        //   30: checkcast 96	androidx/lifecycle/PausingDispatcher
        //   33: astore 4
        //   35: aload_0
        //   36: getfield 98	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$1	Ljava/lang/Object;
        //   39: checkcast 100	kotlinx/coroutines/d1
        //   42: astore 4
        //   44: aload_0
        //   45: getfield 102	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$0	Ljava/lang/Object;
        //   48: checkcast 61	kotlinx/coroutines/d0
        //   51: astore 4
        //   53: aload_1
        //   54: invokestatic 108	kotlin/k:b	(Ljava/lang/Object;)V
        //   57: aload_1
        //   58: astore 4
        //   60: goto +141 -> 201
        //   63: astore_1
        //   64: aload_1
        //   65: astore 4
        //   67: goto +145 -> 212
        //   70: new 110	java/lang/IllegalStateException
        //   73: dup
        //   74: ldc 112
        //   76: invokespecial 115	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   79: athrow
        //   80: aload_1
        //   81: invokestatic 108	kotlin/k:b	(Ljava/lang/Object;)V
        //   84: aload_0
        //   85: getfield 63	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:p$	Lkotlinx/coroutines/d0;
        //   88: astore 5
        //   90: aload 5
        //   92: invokeinterface 119 1 0
        //   97: getstatic 123	kotlinx/coroutines/d1:h	Lkotlinx/coroutines/d1$b;
        //   100: invokeinterface 129 2 0
        //   105: checkcast 100	kotlinx/coroutines/d1
        //   108: astore 6
        //   110: aload 6
        //   112: ifnull +107 -> 219
        //   115: new 96	androidx/lifecycle/PausingDispatcher
        //   118: dup
        //   119: invokespecial 132	androidx/lifecycle/PausingDispatcher:<init>	()V
        //   122: astore 7
        //   124: new 92	androidx/lifecycle/LifecycleController
        //   127: dup
        //   128: aload_0
        //   129: getfield 40	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:$this_whenStateAtLeast	Landroidx/lifecycle/Lifecycle;
        //   132: aload_0
        //   133: getfield 42	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:$minState	Landroidx/lifecycle/Lifecycle$State;
        //   136: aload 7
        //   138: getfield 136	androidx/lifecycle/PausingDispatcher:dispatchQueue	Landroidx/lifecycle/DispatchQueue;
        //   141: aload 6
        //   143: invokespecial 139	androidx/lifecycle/LifecycleController:<init>	(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/d1;)V
        //   146: astore_1
        //   147: aload_0
        //   148: getfield 44	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:$block	Lkotlin/jvm/b/p;
        //   151: astore 4
        //   153: aload_0
        //   154: aload 5
        //   156: putfield 102	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$0	Ljava/lang/Object;
        //   159: aload_0
        //   160: aload 6
        //   162: putfield 98	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$1	Ljava/lang/Object;
        //   165: aload_0
        //   166: aload 7
        //   168: putfield 94	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$2	Ljava/lang/Object;
        //   171: aload_0
        //   172: aload_1
        //   173: putfield 90	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:L$3	Ljava/lang/Object;
        //   176: aload_0
        //   177: iconst_1
        //   178: putfield 88	androidx/lifecycle/PausingDispatcherKt$whenStateAtLeast$2:label	I
        //   181: aload 7
        //   183: aload 4
        //   185: aload_0
        //   186: invokestatic 144	kotlinx/coroutines/d:c	(Lkotlin/coroutines/f;Lkotlin/jvm/b/p;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //   189: astore 4
        //   191: aload 4
        //   193: aload_2
        //   194: if_acmpne +5 -> 199
        //   197: aload_2
        //   198: areturn
        //   199: aload_1
        //   200: astore_2
        //   201: aload_2
        //   202: invokevirtual 147	androidx/lifecycle/LifecycleController:finish	()V
        //   205: aload 4
        //   207: areturn
        //   208: astore 4
        //   210: aload_1
        //   211: astore_2
        //   212: aload_2
        //   213: invokevirtual 147	androidx/lifecycle/LifecycleController:finish	()V
        //   216: aload 4
        //   218: athrow
        //   219: new 110	java/lang/IllegalStateException
        //   222: dup
        //   223: ldc -107
        //   225: invokevirtual 155	java/lang/Object:toString	()Ljava/lang/String;
        //   228: invokespecial 115	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   231: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	232	0	this	2
        //   0	232	1	paramAnonymousObject	Object
        //   3	210	2	localObject1	Object
        //   8	8	3	i	int
        //   33	173	4	localObject2	Object
        //   208	9	4	localObject3	Object
        //   88	67	5	locald0	d0
        //   108	53	6	locald1	kotlinx.coroutines.d1
        //   122	60	7	localPausingDispatcher	PausingDispatcher
        // Exception table:
        //   from	to	target	type
        //   53	57	63	finally
        //   147	191	208	finally
      }
    }, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\PausingDispatcherKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */