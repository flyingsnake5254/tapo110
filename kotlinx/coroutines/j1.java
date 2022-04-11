package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.a;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.c;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.i.b;
import kotlinx.coroutines.internal.s;

public class j1
  implements d1, o, q1
{
  private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_state");
  private volatile Object _state;
  public volatile m parentHandle;
  
  public j1(boolean paramBoolean)
  {
    p0 localp0;
    if (paramBoolean) {
      localp0 = k1.a();
    } else {
      localp0 = k1.b();
    }
    this._state = localp0;
  }
  
  /* Error */
  private final void B(y0 paramy0, Object paramObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	kotlinx/coroutines/j1:parentHandle	Lkotlinx/coroutines/m;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +17 -> 25
    //   11: aload 4
    //   13: invokeinterface 58 1 0
    //   18: aload_0
    //   19: getstatic 63	kotlinx/coroutines/o1:c	Lkotlinx/coroutines/o1;
    //   22: putfield 53	kotlinx/coroutines/j1:parentHandle	Lkotlinx/coroutines/m;
    //   25: aload_2
    //   26: instanceof 65
    //   29: istore 5
    //   31: aconst_null
    //   32: astore 6
    //   34: iload 5
    //   36: ifne +9 -> 45
    //   39: aconst_null
    //   40: astore 4
    //   42: goto +6 -> 48
    //   45: aload_2
    //   46: astore 4
    //   48: aload 4
    //   50: checkcast 65	kotlinx/coroutines/r
    //   53: astore 7
    //   55: aload 6
    //   57: astore 4
    //   59: aload 7
    //   61: ifnull +10 -> 71
    //   64: aload 7
    //   66: getfield 68	kotlinx/coroutines/r:b	Ljava/lang/Throwable;
    //   69: astore 4
    //   71: aload_1
    //   72: instanceof 70
    //   75: ifeq +77 -> 152
    //   78: aload_1
    //   79: checkcast 70	kotlinx/coroutines/i1
    //   82: aload 4
    //   84: invokevirtual 76	kotlinx/coroutines/v:L	(Ljava/lang/Throwable;)V
    //   87: goto +83 -> 170
    //   90: astore 6
    //   92: new 78	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload 4
    //   103: ldc 81
    //   105: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: aload_1
    //   112: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc 90
    //   120: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: aload_0
    //   127: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: new 92	kotlinx/coroutines/CompletionHandlerException
    //   135: dup
    //   136: aload 4
    //   138: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: aload 6
    //   143: invokespecial 99	kotlinx/coroutines/CompletionHandlerException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: invokevirtual 102	kotlinx/coroutines/j1:N	(Ljava/lang/Throwable;)V
    //   149: goto +21 -> 170
    //   152: aload_1
    //   153: invokeinterface 108 1 0
    //   158: astore_1
    //   159: aload_1
    //   160: ifnull +10 -> 170
    //   163: aload_0
    //   164: aload_1
    //   165: aload 4
    //   167: invokespecial 112	kotlinx/coroutines/j1:X	(Lkotlinx/coroutines/n1;Ljava/lang/Throwable;)V
    //   170: aload_0
    //   171: aload_2
    //   172: iload_3
    //   173: invokevirtual 116	kotlinx/coroutines/j1:u	(Ljava/lang/Object;I)V
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	j1
    //   0	177	1	paramy0	y0
    //   0	177	2	paramObject	Object
    //   0	177	3	paramInt	int
    //   4	162	4	localObject1	Object
    //   29	6	5	bool	boolean
    //   32	24	6	localObject2	Object
    //   90	52	6	localThrowable	Throwable
    //   53	12	7	localr	r
    // Exception table:
    //   from	to	target	type
    //   78	87	90	finally
  }
  
  private final void C(b paramb, n paramn, Object paramObject)
  {
    int i;
    if (L() == paramb) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramn = V(paramn);
      if ((paramn != null) && (o0(paramb, paramn, paramObject))) {
        return;
      }
      if (j0(paramb, paramObject, 0)) {}
      return;
    }
    throw new IllegalArgumentException("Failed requirement.".toString());
  }
  
  private final Throwable D(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof Throwable;
    } else {
      bool = true;
    }
    if (bool)
    {
      if (paramObject != null) {
        paramObject = (Throwable)paramObject;
      } else {
        paramObject = E();
      }
    }
    else
    {
      if (paramObject == null) {
        break label54;
      }
      paramObject = ((q1)paramObject).l();
    }
    return (Throwable)paramObject;
    label54:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
  }
  
  private final JobCancellationException E()
  {
    return new JobCancellationException("Job was cancelled", null, this);
  }
  
  private final n F(y0 paramy0)
  {
    boolean bool = paramy0 instanceof n;
    Object localObject1 = null;
    if (!bool) {
      localObject2 = null;
    } else {
      localObject2 = paramy0;
    }
    Object localObject2 = (n)localObject2;
    if (localObject2 != null)
    {
      paramy0 = (y0)localObject2;
    }
    else
    {
      localObject2 = paramy0.d();
      paramy0 = (y0)localObject1;
      if (localObject2 != null) {
        paramy0 = V((i)localObject2);
      }
    }
    return paramy0;
  }
  
  private final Throwable G(Object paramObject)
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
  
  private final Throwable H(b paramb, List<? extends Throwable> paramList)
  {
    boolean bool = paramList.isEmpty();
    Object localObject = null;
    if (bool)
    {
      if (paramb.c()) {
        return E();
      }
      return null;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      paramb = (b)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramb = localIterator.next();
    } while (!((Throwable)paramb instanceof CancellationException ^ true));
    paramb = (Throwable)paramb;
    if (paramb == null) {
      paramb = (Throwable)paramList.get(0);
    }
    return paramb;
  }
  
  private final n1 K(y0 paramy0)
  {
    Object localObject = paramy0.d();
    if (localObject != null)
    {
      paramy0 = (y0)localObject;
    }
    else if ((paramy0 instanceof p0))
    {
      paramy0 = new n1();
    }
    else
    {
      if (!(paramy0 instanceof i1)) {
        break label53;
      }
      c0((i1)paramy0);
      paramy0 = null;
    }
    return paramy0;
    label53:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("State should have list: ");
    ((StringBuilder)localObject).append(paramy0);
    throw new IllegalStateException(((StringBuilder)localObject).toString().toString());
  }
  
  private final boolean R(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    for (;;)
    {
      localObject3 = L();
      if ((localObject3 instanceof b)) {
        try
        {
          boolean bool = ((b)localObject3).e();
          if (bool) {
            return false;
          }
          bool = ((b)localObject3).c();
          if ((paramObject != null) || (!bool))
          {
            if (localObject2 == null) {
              localObject2 = D(paramObject);
            }
            ((b)localObject3).a((Throwable)localObject2);
          }
          localObject2 = ((b)localObject3).rootCause;
          paramObject = localObject1;
          if ((bool ^ true)) {
            paramObject = localObject2;
          }
          if (paramObject != null) {
            W(((b)localObject3).d(), (Throwable)paramObject);
          }
          return true;
        }
        finally {}
      }
      if (!(localObject3 instanceof y0)) {
        break label290;
      }
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = localObject2;
      } else {
        localObject4 = D(paramObject);
      }
      y0 localy0 = (y0)localObject3;
      if (localy0.isActive())
      {
        localObject2 = localObject4;
        if (l0(localy0, (Throwable)localObject4)) {
          return true;
        }
      }
      else
      {
        int i = m0(localObject3, new r((Throwable)localObject4, false, 2, null), 0);
        if (i == 0) {
          break label253;
        }
        if ((i == 1) || (i == 2)) {
          break label251;
        }
        if (i != 3) {
          break;
        }
        localObject2 = localObject4;
      }
    }
    throw new IllegalStateException("unexpected result".toString());
    label251:
    return true;
    label253:
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("Cannot happen in ");
    ((StringBuilder)paramObject).append(localObject3);
    throw new IllegalStateException(((StringBuilder)paramObject).toString().toString());
    label290:
    return false;
  }
  
  private final i1<?> T(l<? super Throwable, kotlin.p> paraml, boolean paramBoolean)
  {
    int i = 1;
    int j = 1;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBoolean)
    {
      if ((paraml instanceof e1)) {
        localObject2 = paraml;
      }
      localObject2 = (e1)localObject2;
      if (localObject2 != null)
      {
        if (((i1)localObject2).q != this) {
          j = 0;
        }
        if (j != 0) {
          paraml = (l<? super Throwable, kotlin.p>)localObject2;
        } else {
          throw new IllegalArgumentException("Failed requirement.".toString());
        }
      }
      else
      {
        paraml = new b1(this, paraml);
      }
    }
    else
    {
      if (!(paraml instanceof i1)) {
        localObject2 = localObject1;
      } else {
        localObject2 = paraml;
      }
      localObject2 = (i1)localObject2;
      if (localObject2 != null)
      {
        if ((((i1)localObject2).q == this) && (!(localObject2 instanceof e1))) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          paraml = (l<? super Throwable, kotlin.p>)localObject2;
        } else {
          throw new IllegalArgumentException("Failed requirement.".toString());
        }
      }
      else
      {
        paraml = new c1(this, paraml);
      }
    }
    return paraml;
  }
  
  private final n V(i parami)
  {
    i locali;
    for (;;)
    {
      locali = parami;
      if (!parami.G()) {
        break;
      }
      parami = parami.D();
    }
    do
    {
      for (;;)
      {
        parami = locali.B();
        if (!parami.G()) {
          break;
        }
        locali = parami;
      }
      if ((parami instanceof n)) {
        return (n)parami;
      }
      locali = parami;
    } while (!(parami instanceof n1));
    return null;
  }
  
  /* Error */
  private final void W(n1 paramn1, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 281	kotlinx/coroutines/j1:Y	(Ljava/lang/Throwable;)V
    //   5: aload_1
    //   6: invokevirtual 284	kotlinx/coroutines/internal/i:A	()Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +163 -> 174
    //   14: aload_3
    //   15: checkcast 271	kotlinx/coroutines/internal/i
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_3
    //   23: aload_1
    //   24: invokestatic 289	kotlin/jvm/internal/j:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   27: iconst_1
    //   28: ixor
    //   29: ifeq +127 -> 156
    //   32: aload 4
    //   34: astore 5
    //   36: aload_3
    //   37: instanceof 256
    //   40: ifeq +104 -> 144
    //   43: aload_3
    //   44: checkcast 70	kotlinx/coroutines/i1
    //   47: astore 5
    //   49: aload 5
    //   51: aload_2
    //   52: invokevirtual 76	kotlinx/coroutines/v:L	(Ljava/lang/Throwable;)V
    //   55: aload 4
    //   57: astore 5
    //   59: goto +85 -> 144
    //   62: astore 6
    //   64: aload 4
    //   66: ifnull +17 -> 83
    //   69: aload 4
    //   71: aload 6
    //   73: invokestatic 294	kotlin/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   76: aload 4
    //   78: astore 5
    //   80: goto +64 -> 144
    //   83: new 78	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: ldc 81
    //   96: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: aload 5
    //   104: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: ldc 90
    //   112: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload_0
    //   119: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: new 92	kotlinx/coroutines/CompletionHandlerException
    //   126: dup
    //   127: aload 4
    //   129: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aload 6
    //   134: invokespecial 99	kotlinx/coroutines/CompletionHandlerException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: astore 5
    //   139: getstatic 299	kotlin/p:a	Lkotlin/p;
    //   142: astore 4
    //   144: aload_3
    //   145: invokevirtual 278	kotlinx/coroutines/internal/i:B	()Lkotlinx/coroutines/internal/i;
    //   148: astore_3
    //   149: aload 5
    //   151: astore 4
    //   153: goto -131 -> 22
    //   156: aload 4
    //   158: ifnull +9 -> 167
    //   161: aload_0
    //   162: aload 4
    //   164: invokevirtual 102	kotlinx/coroutines/j1:N	(Ljava/lang/Throwable;)V
    //   167: aload_0
    //   168: aload_2
    //   169: invokespecial 303	kotlinx/coroutines/j1:z	(Ljava/lang/Throwable;)Z
    //   172: pop
    //   173: return
    //   174: new 155	kotlin/TypeCastException
    //   177: dup
    //   178: ldc_w 305
    //   181: invokespecial 158	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	j1
    //   0	185	1	paramn1	n1
    //   0	185	2	paramThrowable	Throwable
    //   9	140	3	localObject1	Object
    //   20	143	4	localObject2	Object
    //   34	116	5	localObject3	Object
    //   62	71	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   49	55	62	finally
  }
  
  /* Error */
  private final void X(n1 paramn1, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 284	kotlinx/coroutines/internal/i:A	()Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +157 -> 163
    //   9: aload_3
    //   10: checkcast 271	kotlinx/coroutines/internal/i
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: aload_3
    //   18: aload_1
    //   19: invokestatic 289	kotlin/jvm/internal/j:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   22: iconst_1
    //   23: ixor
    //   24: ifeq +127 -> 151
    //   27: aload 4
    //   29: astore 5
    //   31: aload_3
    //   32: instanceof 70
    //   35: ifeq +104 -> 139
    //   38: aload_3
    //   39: checkcast 70	kotlinx/coroutines/i1
    //   42: astore 5
    //   44: aload 5
    //   46: aload_2
    //   47: invokevirtual 76	kotlinx/coroutines/v:L	(Ljava/lang/Throwable;)V
    //   50: aload 4
    //   52: astore 5
    //   54: goto +85 -> 139
    //   57: astore 6
    //   59: aload 4
    //   61: ifnull +17 -> 78
    //   64: aload 4
    //   66: aload 6
    //   68: invokestatic 294	kotlin/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   71: aload 4
    //   73: astore 5
    //   75: goto +64 -> 139
    //   78: new 78	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   85: astore 4
    //   87: aload 4
    //   89: ldc 81
    //   91: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: ldc 90
    //   107: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: new 92	kotlinx/coroutines/CompletionHandlerException
    //   121: dup
    //   122: aload 4
    //   124: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload 6
    //   129: invokespecial 99	kotlinx/coroutines/CompletionHandlerException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: astore 5
    //   134: getstatic 299	kotlin/p:a	Lkotlin/p;
    //   137: astore 4
    //   139: aload_3
    //   140: invokevirtual 278	kotlinx/coroutines/internal/i:B	()Lkotlinx/coroutines/internal/i;
    //   143: astore_3
    //   144: aload 5
    //   146: astore 4
    //   148: goto -131 -> 17
    //   151: aload 4
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: aload 4
    //   159: invokevirtual 102	kotlinx/coroutines/j1:N	(Ljava/lang/Throwable;)V
    //   162: return
    //   163: new 155	kotlin/TypeCastException
    //   166: dup
    //   167: ldc_w 305
    //   170: invokespecial 158	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	j1
    //   0	174	1	paramn1	n1
    //   0	174	2	paramThrowable	Throwable
    //   4	140	3	localObject1	Object
    //   15	143	4	localObject2	Object
    //   29	116	5	localObject3	Object
    //   57	71	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	50	57	finally
  }
  
  private final void b0(p0 paramp0)
  {
    Object localObject = new n1();
    if (!paramp0.isActive()) {
      localObject = new x0((n1)localObject);
    }
    c.compareAndSet(this, paramp0, localObject);
  }
  
  private final void c0(i1<?> parami1)
  {
    parami1.v(new n1());
    i locali = parami1.B();
    c.compareAndSet(this, parami1, locali);
  }
  
  private final int e0(Object paramObject)
  {
    if ((paramObject instanceof p0))
    {
      if (((p0)paramObject).isActive()) {
        return 0;
      }
      if (!c.compareAndSet(this, paramObject, k1.a())) {
        return -1;
      }
      a0();
      return 1;
    }
    if ((paramObject instanceof x0))
    {
      if (!c.compareAndSet(this, paramObject, ((x0)paramObject).d())) {
        return -1;
      }
      a0();
      return 1;
    }
    return 0;
  }
  
  private final String f0(Object paramObject)
  {
    boolean bool = paramObject instanceof b;
    String str = "Active";
    if (bool)
    {
      b localb = (b)paramObject;
      if (localb.c())
      {
        paramObject = "Cancelling";
      }
      else
      {
        paramObject = str;
        if (localb.isCompleting) {
          paramObject = "Completing";
        }
      }
    }
    else if ((paramObject instanceof y0))
    {
      if (((y0)paramObject).isActive()) {
        paramObject = str;
      } else {
        paramObject = "New";
      }
    }
    else if ((paramObject instanceof r))
    {
      paramObject = "Cancelled";
    }
    else
    {
      paramObject = "Completed";
    }
    return (String)paramObject;
  }
  
  private final boolean j0(b paramb, Object paramObject, int paramInt)
  {
    Object localObject = L();
    int i = 0;
    int j;
    if (localObject == paramb) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if ((paramb.e() ^ true))
      {
        if (paramb.isCompleting)
        {
          if (!(paramObject instanceof r)) {
            localObject = null;
          } else {
            localObject = paramObject;
          }
          localObject = (r)localObject;
          if (localObject != null) {
            localObject = ((r)localObject).b;
          } else {
            localObject = null;
          }
          try
          {
            boolean bool = paramb.c();
            List localList = paramb.f((Throwable)localObject);
            Throwable localThrowable = H(paramb, localList);
            if (localThrowable != null) {
              r(localThrowable, localList);
            }
            if ((localThrowable != null) && (localThrowable != localObject)) {
              paramObject = new r(localThrowable, false, 2, null);
            }
            if (localThrowable != null)
            {
              if (!z(localThrowable))
              {
                j = i;
                if (!M(localThrowable)) {}
              }
              else
              {
                j = 1;
              }
              if (j != 0) {
                if (paramObject != null) {
                  ((r)paramObject).b();
                } else {
                  throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
              }
            }
            if (!bool) {
              Y(localThrowable);
            }
            Z(paramObject);
            if (c.compareAndSet(this, paramb, k1.d(paramObject)))
            {
              B(paramb, paramObject, paramInt);
              return true;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unexpected state: ");
            ((StringBuilder)localObject).append(this._state);
            ((StringBuilder)localObject).append(", expected: ");
            ((StringBuilder)localObject).append(paramb);
            ((StringBuilder)localObject).append(", update: ");
            ((StringBuilder)localObject).append(paramObject);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
          }
          finally {}
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
      }
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
    throw new IllegalArgumentException("Failed requirement.".toString());
  }
  
  private final boolean k0(y0 paramy0, Object paramObject, int paramInt)
  {
    if (g0.a())
    {
      int i;
      if ((!(paramy0 instanceof p0)) && (!(paramy0 instanceof i1))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    if ((g0.a()) && (!(paramObject instanceof r ^ true))) {
      throw new AssertionError();
    }
    if (!c.compareAndSet(this, paramy0, k1.d(paramObject))) {
      return false;
    }
    Y(null);
    Z(paramObject);
    B(paramy0, paramObject, paramInt);
    return true;
  }
  
  private final boolean l0(y0 paramy0, Throwable paramThrowable)
  {
    if ((g0.a()) && (!(paramy0 instanceof b ^ true))) {
      throw new AssertionError();
    }
    if ((g0.a()) && (!paramy0.isActive())) {
      throw new AssertionError();
    }
    n1 localn1 = K(paramy0);
    if (localn1 != null)
    {
      b localb = new b(localn1, false, paramThrowable);
      if (!c.compareAndSet(this, paramy0, localb)) {
        return false;
      }
      W(localn1, paramThrowable);
      return true;
    }
    return false;
  }
  
  private final int m0(Object paramObject1, Object paramObject2, int paramInt)
  {
    if (!(paramObject1 instanceof y0)) {
      return 0;
    }
    if ((((paramObject1 instanceof p0)) || ((paramObject1 instanceof i1))) && (!(paramObject1 instanceof n)) && (!(paramObject2 instanceof r)))
    {
      if (!k0((y0)paramObject1, paramObject2, paramInt)) {
        return 3;
      }
      return 1;
    }
    return n0((y0)paramObject1, paramObject2, paramInt);
  }
  
  private final int n0(y0 paramy0, Object paramObject, int paramInt)
  {
    n1 localn1 = K(paramy0);
    if (localn1 != null)
    {
      boolean bool = paramy0 instanceof b;
      kotlin.p localp = null;
      if (!bool) {
        ??? = null;
      } else {
        ??? = paramy0;
      }
      ??? = (b)???;
      if (??? == null) {}
      synchronized (new b(localn1, false, null))
      {
        bool = ((b)???).isCompleting;
        if (bool) {
          return 0;
        }
        ((b)???).isCompleting = true;
        if (??? != paramy0)
        {
          bool = c.compareAndSet(this, paramy0, ???);
          if (!bool) {
            return 3;
          }
        }
        if ((((b)???).e() ^ true))
        {
          bool = ((b)???).c();
          if (!(paramObject instanceof r)) {
            localObject2 = null;
          } else {
            localObject2 = paramObject;
          }
          Object localObject2 = (r)localObject2;
          if (localObject2 != null) {
            ((b)???).a(((r)localObject2).b);
          }
          Throwable localThrowable = ((b)???).rootCause;
          localObject2 = localp;
          if ((bool ^ true)) {
            localObject2 = localThrowable;
          }
          localp = kotlin.p.a;
          if (localObject2 != null) {
            W(localn1, (Throwable)localObject2);
          }
          paramy0 = F(paramy0);
          if ((paramy0 != null) && (o0((b)???, paramy0, paramObject))) {
            return 2;
          }
          if (j0((b)???, paramObject, paramInt)) {
            return 1;
          }
          return 3;
        }
        paramy0 = new java/lang/IllegalArgumentException;
        paramy0.<init>("Failed requirement.".toString());
        throw paramy0;
      }
    }
    return 3;
  }
  
  private final boolean o0(b paramb, n paramn, Object paramObject)
  {
    do
    {
      if (d1.a.d(paramn.x, false, false, new a(this, paramb, paramn, paramObject), 1, null) != o1.c) {
        return true;
      }
      paramn = V(paramn);
    } while (paramn != null);
    return false;
  }
  
  private final boolean q(final Object paramObject, n1 paramn1, i1<?> parami1)
  {
    c localc = new c(parami1, parami1, this, paramObject);
    int i;
    do
    {
      paramObject = paramn1.C();
      if (paramObject == null) {
        break label59;
      }
      i = ((i)paramObject).K(parami1, paramn1, localc);
      bool = true;
      if (i == 1) {
        break;
      }
    } while (i != 2);
    boolean bool = false;
    return bool;
    label59:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  private final void r(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    if (paramList.size() <= 1) {
      return;
    }
    Set localSet = e.a(paramList.size());
    Throwable localThrowable = s.m(paramThrowable);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = s.m((Throwable)localIterator.next());
      if ((paramList != paramThrowable) && (paramList != localThrowable) && (!(paramList instanceof CancellationException)) && (localSet.add(paramList))) {
        a.a(paramThrowable, paramList);
      }
    }
  }
  
  private final boolean y(Object paramObject)
  {
    int i;
    do
    {
      Object localObject = L();
      if ((!(localObject instanceof y0)) || (((localObject instanceof b)) && (((b)localObject).isCompleting))) {
        break label91;
      }
      i = m0(localObject, new r(D(paramObject), false, 2, null), 0);
      if (i == 0) {
        break label91;
      }
      if ((i == 1) || (i == 2)) {
        break;
      }
    } while (i == 3);
    throw new IllegalStateException("unexpected result".toString());
    return true;
    label91:
    return false;
  }
  
  private final boolean z(Throwable paramThrowable)
  {
    boolean bool1 = Q();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    boolean bool3 = paramThrowable instanceof CancellationException;
    m localm = this.parentHandle;
    if ((localm != null) && (localm != o1.c))
    {
      bool1 = bool2;
      if (!localm.c(paramThrowable)) {
        if (bool3) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    return bool3;
  }
  
  public boolean A(Throwable paramThrowable)
  {
    j.f(paramThrowable, "cause");
    boolean bool1 = paramThrowable instanceof CancellationException;
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if ((!w(paramThrowable)) || (!I())) {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean I()
  {
    return true;
  }
  
  public boolean J()
  {
    return false;
  }
  
  public final Object L()
  {
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof kotlinx.coroutines.internal.o)) {
        return localObject;
      }
      ((kotlinx.coroutines.internal.o)localObject).a(this);
    }
  }
  
  protected boolean M(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    return false;
  }
  
  public void N(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    throw paramThrowable;
  }
  
  public final void O(d1 paramd1)
  {
    if (g0.a())
    {
      int i;
      if (this.parentHandle == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    if (paramd1 == null)
    {
      this.parentHandle = o1.c;
      return;
    }
    paramd1.start();
    paramd1 = paramd1.t(this);
    this.parentHandle = paramd1;
    if (P())
    {
      paramd1.dispose();
      this.parentHandle = o1.c;
    }
  }
  
  public final boolean P()
  {
    return L() instanceof y0 ^ true;
  }
  
  protected boolean Q()
  {
    return false;
  }
  
  public final boolean S(Object paramObject, int paramInt)
  {
    int i;
    do
    {
      i = m0(L(), paramObject, paramInt);
      if (i == 0) {
        break label50;
      }
      if (i == 1) {
        break label48;
      }
      if (i == 2) {
        break;
      }
    } while (i == 3);
    throw new IllegalStateException("unexpected result".toString());
    return false;
    label48:
    return true;
    label50:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Job ");
    localStringBuilder.append(this);
    localStringBuilder.append(" is already complete or completing, ");
    localStringBuilder.append("but is being completed with ");
    localStringBuilder.append(paramObject);
    throw new IllegalStateException(localStringBuilder.toString(), G(paramObject));
  }
  
  public String U()
  {
    return h0.a(this);
  }
  
  protected void Y(Throwable paramThrowable) {}
  
  protected void Z(Object paramObject) {}
  
  public void a(CancellationException paramCancellationException)
  {
    x(paramCancellationException);
  }
  
  public void a0() {}
  
  public final void d0(i1<?> parami1)
  {
    j.f(parami1, "node");
    Object localObject;
    do
    {
      localObject = L();
      if (!(localObject instanceof i1)) {
        break;
      }
      if (localObject != parami1) {
        return;
      }
    } while (!c.compareAndSet(this, localObject, k1.a()));
    return;
    if (((localObject instanceof y0)) && (((y0)localObject).d() != null)) {
      parami1.I();
    }
  }
  
  public <R> R fold(R paramR, kotlin.jvm.b.p<? super R, ? super f.b, ? extends R> paramp)
  {
    j.f(paramp, "operation");
    return (R)d1.a.b(this, paramR, paramp);
  }
  
  public final o0 g(boolean paramBoolean1, boolean paramBoolean2, l<? super Throwable, kotlin.p> paraml)
  {
    j.f(paraml, "handler");
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    Object localObject4;
    n1 localn1;
    do
    {
      o1 localo1;
      for (;;)
      {
        localObject3 = L();
        if ((localObject3 instanceof p0))
        {
          localObject4 = (p0)localObject3;
          if (((p0)localObject4).isActive())
          {
            if (localObject2 != null) {
              localObject4 = localObject2;
            } else {
              localObject4 = T(paraml, paramBoolean1);
            }
            localObject2 = localObject4;
            if (c.compareAndSet(this, localObject3, localObject4)) {
              return (o0)localObject4;
            }
          }
          else
          {
            b0((p0)localObject4);
          }
        }
        else
        {
          if (!(localObject3 instanceof y0)) {
            break label365;
          }
          localn1 = ((y0)localObject3).d();
          if (localn1 == null)
          {
            if (localObject3 != null) {
              c0((i1)localObject3);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
            }
          }
          else
          {
            localo1 = o1.c;
            if ((paramBoolean1) && ((localObject3 instanceof b))) {
              try
              {
                Throwable localThrowable = ((b)localObject3).rootCause;
                if (localThrowable != null)
                {
                  localObject5 = localObject2;
                  localObject4 = localo1;
                  if ((paraml instanceof n))
                  {
                    localObject5 = localObject2;
                    localObject4 = localo1;
                    if (((b)localObject3).isCompleting) {}
                  }
                }
                else
                {
                  if (localObject2 == null) {
                    localObject2 = T(paraml, paramBoolean1);
                  }
                  boolean bool = q(localObject3, localn1, (i1)localObject2);
                  if (!bool) {
                    continue;
                  }
                  if (localThrowable == null) {
                    return (o0)localObject2;
                  }
                  localObject4 = localObject2;
                  localObject5 = localObject2;
                }
                localObject2 = kotlin.p.a;
                localObject2 = localObject5;
                localObject5 = localThrowable;
              }
              finally {}
            }
          }
        }
      }
      Object localObject5 = null;
      localObject4 = localo1;
      if (localObject5 != null)
      {
        if (paramBoolean2) {
          paraml.invoke(localObject5);
        }
        return (o0)localObject4;
      }
      if (localObject2 != null) {
        localObject4 = localObject2;
      } else {
        localObject4 = T(paraml, paramBoolean1);
      }
      localObject2 = localObject4;
    } while (!q(localObject3, localn1, (i1)localObject4));
    return (o0)localObject4;
    label365:
    if (paramBoolean2)
    {
      localObject2 = localObject3;
      if (!(localObject3 instanceof r)) {
        localObject2 = null;
      }
      localObject4 = (r)localObject2;
      localObject2 = localObject1;
      if (localObject4 != null) {
        localObject2 = ((r)localObject4).b;
      }
      paraml.invoke(localObject2);
    }
    return o1.c;
  }
  
  protected final CancellationException g0(Throwable paramThrowable, String paramString)
  {
    j.f(paramThrowable, "$this$toCancellationException");
    if (!(paramThrowable instanceof CancellationException)) {
      localObject = null;
    } else {
      localObject = paramThrowable;
    }
    Object localObject = (CancellationException)localObject;
    if (localObject != null)
    {
      paramThrowable = (Throwable)localObject;
    }
    else
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append(h0.a(paramThrowable));
        paramString.append(" was cancelled");
        paramString = paramString.toString();
      }
      paramThrowable = new JobCancellationException(paramString, paramThrowable, this);
    }
    return paramThrowable;
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.f(paramc, "key");
    return d1.a.c(this, paramc);
  }
  
  public final f.c<?> getKey()
  {
    return d1.h;
  }
  
  public final CancellationException i()
  {
    Object localObject = L();
    if ((localObject instanceof b))
    {
      Throwable localThrowable = ((b)localObject).rootCause;
      if (localThrowable != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(h0.a(this));
        ((StringBuilder)localObject).append(" is cancelling");
        localObject = g0(localThrowable, ((StringBuilder)localObject).toString());
        if (localObject != null) {}
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Job is still new or active: ");
        ((StringBuilder)localObject).append(this);
        throw new IllegalStateException(((StringBuilder)localObject).toString().toString());
      }
    }
    else
    {
      if ((localObject instanceof y0)) {
        break label176;
      }
      if ((localObject instanceof r))
      {
        localObject = h0(this, ((r)localObject).b, null, 1, null);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(h0.a(this));
        ((StringBuilder)localObject).append(" has completed normally");
        localObject = new JobCancellationException(((StringBuilder)localObject).toString(), null, this);
      }
    }
    return (CancellationException)localObject;
    label176:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Job is still new or active: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString().toString());
  }
  
  public final String i0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(U());
    localStringBuilder.append('{');
    localStringBuilder.append(f0(L()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean isActive()
  {
    Object localObject = L();
    boolean bool;
    if (((localObject instanceof y0)) && (((y0)localObject).isActive())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void j(q1 paramq1)
  {
    j.f(paramq1, "parentJob");
    w(paramq1);
  }
  
  public CancellationException l()
  {
    Object localObject1 = L();
    boolean bool = localObject1 instanceof b;
    Object localObject2 = null;
    if (bool)
    {
      localObject3 = ((b)localObject1).rootCause;
    }
    else if ((localObject1 instanceof r))
    {
      localObject3 = ((r)localObject1).b;
    }
    else
    {
      if ((localObject1 instanceof y0)) {
        break label131;
      }
      localObject3 = null;
    }
    if ((localObject3 instanceof CancellationException)) {
      localObject2 = localObject3;
    }
    localObject2 = (CancellationException)localObject2;
    if (localObject2 != null)
    {
      localObject3 = localObject2;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parent job is ");
      ((StringBuilder)localObject2).append(f0(localObject1));
      localObject3 = new JobCancellationException(((StringBuilder)localObject2).toString(), (Throwable)localObject3, this);
    }
    return (CancellationException)localObject3;
    label131:
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Cannot be cancelling child in this state: ");
    ((StringBuilder)localObject3).append(localObject1);
    throw new IllegalStateException(((StringBuilder)localObject3).toString().toString());
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.f(paramc, "key");
    return d1.a.e(this, paramc);
  }
  
  public f plus(f paramf)
  {
    j.f(paramf, "context");
    return d1.a.f(this, paramf);
  }
  
  public final boolean start()
  {
    int i;
    do
    {
      i = e0(L());
      if (i == 0) {
        break;
      }
    } while (i != 1);
    return true;
    return false;
  }
  
  public final m t(o paramo)
  {
    j.f(paramo, "child");
    paramo = d1.a.d(this, true, false, new n(this, paramo), 2, null);
    if (paramo != null) {
      return (m)paramo;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i0());
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    return localStringBuilder.toString();
  }
  
  protected void u(Object paramObject, int paramInt) {}
  
  public final boolean v(Throwable paramThrowable)
  {
    return w(paramThrowable);
  }
  
  public final boolean w(Object paramObject)
  {
    if ((J()) && (y(paramObject))) {
      return true;
    }
    return R(paramObject);
  }
  
  public boolean x(Throwable paramThrowable)
  {
    boolean bool;
    if ((w(paramThrowable)) && (I())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static final class a
    extends i1<d1>
  {
    private final Object p0;
    private final j1 x;
    private final j1.b y;
    private final n z;
    
    public a(j1 paramj1, j1.b paramb, n paramn, Object paramObject)
    {
      super();
      this.x = paramj1;
      this.y = paramb;
      this.z = paramn;
      this.p0 = paramObject;
    }
    
    public void L(Throwable paramThrowable)
    {
      j1.o(this.x, this.y, this.z, this.p0);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChildCompletion[");
      localStringBuilder.append(this.z);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.p0);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
  
  private static final class b
    implements y0
  {
    private volatile Object _exceptionsHolder;
    private final n1 c;
    public volatile boolean isCompleting;
    public volatile Throwable rootCause;
    
    public b(n1 paramn1, boolean paramBoolean, Throwable paramThrowable)
    {
      this.c = paramn1;
      this.isCompleting = paramBoolean;
      this.rootCause = paramThrowable;
    }
    
    private final ArrayList<Throwable> b()
    {
      return new ArrayList(4);
    }
    
    public final void a(Throwable paramThrowable)
    {
      j.f(paramThrowable, "exception");
      Object localObject = this.rootCause;
      if (localObject == null)
      {
        this.rootCause = paramThrowable;
        return;
      }
      if (paramThrowable == localObject) {
        return;
      }
      localObject = this._exceptionsHolder;
      if (localObject == null)
      {
        this._exceptionsHolder = paramThrowable;
      }
      else if ((localObject instanceof Throwable))
      {
        if (paramThrowable == localObject) {
          return;
        }
        ArrayList localArrayList = b();
        localArrayList.add(localObject);
        localArrayList.add(paramThrowable);
        this._exceptionsHolder = localArrayList;
      }
      else
      {
        if (!(localObject instanceof ArrayList)) {
          break label99;
        }
        ((ArrayList)localObject).add(paramThrowable);
      }
      return;
      label99:
      paramThrowable = new StringBuilder();
      paramThrowable.append("State is ");
      paramThrowable.append(localObject);
      throw new IllegalStateException(paramThrowable.toString().toString());
    }
    
    public final boolean c()
    {
      boolean bool;
      if (this.rootCause != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public n1 d()
    {
      return this.c;
    }
    
    public final boolean e()
    {
      boolean bool;
      if (this._exceptionsHolder == k1.c()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final List<Throwable> f(Throwable paramThrowable)
    {
      Object localObject = this._exceptionsHolder;
      ArrayList localArrayList;
      if (localObject == null)
      {
        localArrayList = b();
      }
      else if ((localObject instanceof Throwable))
      {
        localArrayList = b();
        localArrayList.add(localObject);
      }
      else
      {
        if (!(localObject instanceof ArrayList)) {
          break label94;
        }
        localArrayList = (ArrayList)localObject;
      }
      localObject = this.rootCause;
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      if ((paramThrowable != null) && ((j.a(paramThrowable, localObject) ^ true))) {
        localArrayList.add(paramThrowable);
      }
      this._exceptionsHolder = k1.c();
      return localArrayList;
      label94:
      paramThrowable = new StringBuilder();
      paramThrowable.append("State is ");
      paramThrowable.append(localObject);
      throw new IllegalStateException(paramThrowable.toString().toString());
    }
    
    public boolean isActive()
    {
      boolean bool;
      if (this.rootCause == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Finishing[cancelling=");
      localStringBuilder.append(c());
      localStringBuilder.append(", completing=");
      localStringBuilder.append(this.isCompleting);
      localStringBuilder.append(", rootCause=");
      localStringBuilder.append(this.rootCause);
      localStringBuilder.append(", exceptions=");
      localStringBuilder.append(this._exceptionsHolder);
      localStringBuilder.append(", list=");
      localStringBuilder.append(d());
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
  
  public static final class c
    extends i.b
  {
    public c(i parami1, i parami2, j1 paramj1, Object paramObject)
    {
      super();
    }
    
    public Object h(i parami)
    {
      j.f(parami, "affected");
      int i;
      if (jdField_this.L() == paramObject) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        parami = null;
      } else {
        parami = h.b();
      }
      return parami;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\j1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */