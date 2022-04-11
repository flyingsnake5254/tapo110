package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.Result.a;
import kotlin.TypeCastException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.q.a;

public final class ExceptionsConstuctorKt
{
  private static final int a = d(Throwable.class, -1);
  private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
  private static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> c = new WeakHashMap();
  
  private static final l<Throwable, Throwable> a(Constructor<?> paramConstructor)
  {
    Object localObject1 = paramConstructor.getParameterTypes();
    int i = localObject1.length;
    Object localObject2 = null;
    Object localObject3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localObject3 = localObject2;
        }
        else
        {
          localObject3 = localObject2;
          if (j.a(localObject1[0], String.class))
          {
            localObject3 = localObject2;
            if (j.a(localObject1[1], Throwable.class)) {
              localObject3 = new Lambda(paramConstructor)
              {
                public final Throwable invoke(Throwable paramAnonymousThrowable)
                {
                  j.f(paramAnonymousThrowable, "e");
                  try
                  {
                    Result.a locala = Result.Companion;
                    paramAnonymousThrowable = this.$constructor$inlined.newInstance(new Object[] { paramAnonymousThrowable.getMessage(), paramAnonymousThrowable });
                    if (paramAnonymousThrowable != null)
                    {
                      paramAnonymousThrowable = Result.constructor-impl((Throwable)paramAnonymousThrowable);
                    }
                    else
                    {
                      paramAnonymousThrowable = new kotlin/TypeCastException;
                      paramAnonymousThrowable.<init>("null cannot be cast to non-null type kotlin.Throwable");
                      throw paramAnonymousThrowable;
                    }
                  }
                  finally
                  {
                    paramAnonymousThrowable = Result.Companion;
                    paramAnonymousThrowable = Result.constructor-impl(k.a(localThrowable1));
                    Throwable localThrowable2 = paramAnonymousThrowable;
                    if (Result.isFailure-impl(paramAnonymousThrowable)) {
                      localThrowable2 = null;
                    }
                    return (Throwable)localThrowable2;
                  }
                }
              };
            }
          }
        }
      }
      else
      {
        localObject1 = localObject1[0];
        if (j.a(localObject1, Throwable.class))
        {
          localObject3 = new Lambda(paramConstructor)
          {
            public final Throwable invoke(Throwable paramAnonymousThrowable)
            {
              j.f(paramAnonymousThrowable, "e");
              Object localObject;
              try
              {
                localObject = Result.Companion;
                paramAnonymousThrowable = this.$constructor$inlined.newInstance(new Object[] { paramAnonymousThrowable });
                if (paramAnonymousThrowable != null)
                {
                  paramAnonymousThrowable = Result.constructor-impl((Throwable)paramAnonymousThrowable);
                }
                else
                {
                  paramAnonymousThrowable = new kotlin/TypeCastException;
                  paramAnonymousThrowable.<init>("null cannot be cast to non-null type kotlin.Throwable");
                  throw paramAnonymousThrowable;
                }
              }
              finally
              {
                localObject = Result.Companion;
                paramAnonymousThrowable = Result.constructor-impl(k.a(paramAnonymousThrowable));
                localObject = paramAnonymousThrowable;
                if (Result.isFailure-impl(paramAnonymousThrowable)) {
                  localObject = null;
                }
              }
              return (Throwable)localObject;
            }
          };
        }
        else
        {
          localObject3 = localObject2;
          if (j.a(localObject1, String.class)) {
            localObject3 = new Lambda(paramConstructor)
            {
              public final Throwable invoke(Throwable paramAnonymousThrowable)
              {
                j.f(paramAnonymousThrowable, "e");
                Object localObject;
                try
                {
                  localObject = Result.Companion;
                  localObject = this.$constructor$inlined.newInstance(new Object[] { paramAnonymousThrowable.getMessage() });
                  if (localObject != null)
                  {
                    localObject = (Throwable)localObject;
                    ((Throwable)localObject).initCause(paramAnonymousThrowable);
                    paramAnonymousThrowable = Result.constructor-impl(localObject);
                  }
                  else
                  {
                    paramAnonymousThrowable = new kotlin/TypeCastException;
                    paramAnonymousThrowable.<init>("null cannot be cast to non-null type kotlin.Throwable");
                    throw paramAnonymousThrowable;
                  }
                }
                finally
                {
                  localObject = Result.Companion;
                  paramAnonymousThrowable = Result.constructor-impl(k.a(paramAnonymousThrowable));
                  localObject = paramAnonymousThrowable;
                  if (Result.isFailure-impl(paramAnonymousThrowable)) {
                    localObject = null;
                  }
                }
                return (Throwable)localObject;
              }
            };
          }
        }
      }
    }
    else {
      localObject3 = new Lambda(paramConstructor)
      {
        public final Throwable invoke(Throwable paramAnonymousThrowable)
        {
          j.f(paramAnonymousThrowable, "e");
          Object localObject;
          try
          {
            localObject = Result.Companion;
            localObject = this.$constructor$inlined.newInstance(new Object[0]);
            if (localObject != null)
            {
              localObject = (Throwable)localObject;
              ((Throwable)localObject).initCause(paramAnonymousThrowable);
              paramAnonymousThrowable = Result.constructor-impl(localObject);
            }
            else
            {
              paramAnonymousThrowable = new kotlin/TypeCastException;
              paramAnonymousThrowable.<init>("null cannot be cast to non-null type kotlin.Throwable");
              throw paramAnonymousThrowable;
            }
          }
          finally
          {
            localObject = Result.Companion;
            paramAnonymousThrowable = Result.constructor-impl(k.a(paramAnonymousThrowable));
            localObject = paramAnonymousThrowable;
            if (Result.isFailure-impl(paramAnonymousThrowable)) {
              localObject = null;
            }
          }
          return (Throwable)localObject;
        }
      };
    }
    return (l<Throwable, Throwable>)localObject3;
  }
  
  private static final int b(Class<?> paramClass, int paramInt)
  {
    do
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      j.b(arrayOfField, "declaredFields");
      int i = arrayOfField.length;
      int j = 0;
      int m;
      for (int k = 0; j < i; k = m)
      {
        Field localField = arrayOfField[j];
        j.b(localField, "it");
        m = k;
        if ((Modifier.isStatic(localField.getModifiers()) ^ true)) {
          m = k + 1;
        }
        j++;
      }
      paramInt += k;
      paramClass = paramClass.getSuperclass();
    } while (paramClass != null);
    return paramInt;
  }
  
  /* Error */
  private static final int d(Class<?> paramClass, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 108	kotlin/jvm/a:c	(Ljava/lang/Class;)Lkotlin/reflect/c;
    //   4: pop
    //   5: getstatic 114	kotlin/Result:Companion	Lkotlin/Result$a;
    //   8: astore_2
    //   9: aload_0
    //   10: iconst_0
    //   11: iconst_1
    //   12: aconst_null
    //   13: invokestatic 116	kotlinx/coroutines/internal/ExceptionsConstuctorKt:c	(Ljava/lang/Class;IILjava/lang/Object;)I
    //   16: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: invokestatic 126	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore_0
    //   23: goto +16 -> 39
    //   26: astore_0
    //   27: getstatic 114	kotlin/Result:Companion	Lkotlin/Result$a;
    //   30: astore_2
    //   31: aload_0
    //   32: invokestatic 131	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   35: invokestatic 126	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_2
    //   41: aload_0
    //   42: invokestatic 135	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   45: ifeq +8 -> 53
    //   48: iload_1
    //   49: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: astore_2
    //   53: aload_2
    //   54: checkcast 137	java/lang/Number
    //   57: invokevirtual 140	java/lang/Number:intValue	()I
    //   60: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramClass	Class<?>
    //   0	61	1	paramInt	int
    //   8	46	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	26	finally
  }
  
  /* Error */
  public static final <E extends Throwable> E e(E paramE)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -112
    //   3: invokestatic 147	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: instanceof 149
    //   10: istore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_3
    //   15: iload_1
    //   16: ifeq +56 -> 72
    //   19: getstatic 114	kotlin/Result:Companion	Lkotlin/Result$a;
    //   22: astore 4
    //   24: aload_0
    //   25: checkcast 149	kotlinx/coroutines/w
    //   28: invokeinterface 153 1 0
    //   33: invokestatic 126	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore_0
    //   37: goto +18 -> 55
    //   40: astore 4
    //   42: getstatic 114	kotlin/Result:Companion	Lkotlin/Result$a;
    //   45: astore_0
    //   46: aload 4
    //   48: invokestatic 131	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   51: invokestatic 126	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic 135	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   59: ifeq +8 -> 67
    //   62: aload_3
    //   63: astore_0
    //   64: goto +3 -> 67
    //   67: aload_0
    //   68: checkcast 29	java/lang/Throwable
    //   71: areturn
    //   72: getstatic 42	kotlinx/coroutines/internal/ExceptionsConstuctorKt:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   75: astore_3
    //   76: aload_3
    //   77: invokevirtual 157	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   80: astore 4
    //   82: aload 4
    //   84: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   87: getstatic 47	kotlinx/coroutines/internal/ExceptionsConstuctorKt:c	Ljava/util/WeakHashMap;
    //   90: aload_0
    //   91: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   94: invokevirtual 168	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 170	kotlin/jvm/b/l
    //   100: astore 5
    //   102: aload 4
    //   104: invokevirtual 173	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   107: aload 5
    //   109: ifnull +15 -> 124
    //   112: aload 5
    //   114: aload_0
    //   115: invokeinterface 176 2 0
    //   120: checkcast 29	java/lang/Throwable
    //   123: areturn
    //   124: getstatic 35	kotlinx/coroutines/internal/ExceptionsConstuctorKt:a	I
    //   127: istore 6
    //   129: aload_0
    //   130: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   133: astore 4
    //   135: iconst_0
    //   136: istore 7
    //   138: iconst_0
    //   139: istore 8
    //   141: iconst_0
    //   142: istore 9
    //   144: iconst_0
    //   145: istore 10
    //   147: iload 6
    //   149: aload 4
    //   151: iconst_0
    //   152: invokestatic 33	kotlinx/coroutines/internal/ExceptionsConstuctorKt:d	(Ljava/lang/Class;I)I
    //   155: if_icmpeq +135 -> 290
    //   158: aload_3
    //   159: invokevirtual 157	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   162: astore 4
    //   164: aload_3
    //   165: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   168: ifne +12 -> 180
    //   171: aload_3
    //   172: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   175: istore 6
    //   177: goto +6 -> 183
    //   180: iconst_0
    //   181: istore 6
    //   183: iconst_0
    //   184: istore 11
    //   186: iload 11
    //   188: iload 6
    //   190: if_icmpge +14 -> 204
    //   193: aload 4
    //   195: invokevirtual 173	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   198: iinc 11 1
    //   201: goto -15 -> 186
    //   204: aload_3
    //   205: invokevirtual 186	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   208: astore_3
    //   209: aload_3
    //   210: invokevirtual 189	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   213: getstatic 47	kotlinx/coroutines/internal/ExceptionsConstuctorKt:c	Ljava/util/WeakHashMap;
    //   216: aload_0
    //   217: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   220: getstatic 192	kotlinx/coroutines/internal/ExceptionsConstuctorKt$b:c	Lkotlinx/coroutines/internal/ExceptionsConstuctorKt$b;
    //   223: invokeinterface 198 3 0
    //   228: pop
    //   229: getstatic 203	kotlin/p:a	Lkotlin/p;
    //   232: astore_0
    //   233: iload 10
    //   235: istore 11
    //   237: iload 11
    //   239: iload 6
    //   241: if_icmpge +14 -> 255
    //   244: aload 4
    //   246: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   249: iinc 11 1
    //   252: goto -15 -> 237
    //   255: aload_3
    //   256: invokevirtual 204	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: iload 7
    //   264: istore 11
    //   266: iload 11
    //   268: iload 6
    //   270: if_icmpge +14 -> 284
    //   273: aload 4
    //   275: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   278: iinc 11 1
    //   281: goto -15 -> 266
    //   284: aload_3
    //   285: invokevirtual 204	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   288: aload_0
    //   289: athrow
    //   290: aload_0
    //   291: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   294: invokevirtual 208	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   297: astore_3
    //   298: aload_3
    //   299: ldc -46
    //   301: invokestatic 81	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   304: aload_3
    //   305: new 6	kotlinx/coroutines/internal/ExceptionsConstuctorKt$a
    //   308: dup
    //   309: invokespecial 211	kotlinx/coroutines/internal/ExceptionsConstuctorKt$a:<init>	()V
    //   312: invokestatic 217	kotlin/collections/e:v	([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;
    //   315: invokeinterface 223 1 0
    //   320: astore 5
    //   322: aconst_null
    //   323: astore_3
    //   324: aload 5
    //   326: invokeinterface 229 1 0
    //   331: ifeq +37 -> 368
    //   334: aload 5
    //   336: invokeinterface 233 1 0
    //   341: checkcast 51	java/lang/reflect/Constructor
    //   344: astore_3
    //   345: aload_3
    //   346: ldc -21
    //   348: invokestatic 81	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   351: aload_3
    //   352: invokestatic 237	kotlinx/coroutines/internal/ExceptionsConstuctorKt:a	(Ljava/lang/reflect/Constructor;)Lkotlin/jvm/b/l;
    //   355: astore 4
    //   357: aload 4
    //   359: astore_3
    //   360: aload 4
    //   362: ifnull -38 -> 324
    //   365: aload 4
    //   367: astore_3
    //   368: getstatic 42	kotlinx/coroutines/internal/ExceptionsConstuctorKt:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   371: astore 4
    //   373: aload 4
    //   375: invokevirtual 157	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   378: astore 5
    //   380: aload 4
    //   382: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock:getWriteHoldCount	()I
    //   385: ifne +13 -> 398
    //   388: aload 4
    //   390: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock:getReadHoldCount	()I
    //   393: istore 6
    //   395: goto +6 -> 401
    //   398: iconst_0
    //   399: istore 6
    //   401: iconst_0
    //   402: istore 11
    //   404: iload 11
    //   406: iload 6
    //   408: if_icmpge +14 -> 422
    //   411: aload 5
    //   413: invokevirtual 173	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   416: iinc 11 1
    //   419: goto -15 -> 404
    //   422: aload 4
    //   424: invokevirtual 186	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   427: astore 12
    //   429: aload 12
    //   431: invokevirtual 189	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   434: getstatic 47	kotlinx/coroutines/internal/ExceptionsConstuctorKt:c	Ljava/util/WeakHashMap;
    //   437: astore 13
    //   439: aload_0
    //   440: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   443: astore 14
    //   445: aload_3
    //   446: ifnull +9 -> 455
    //   449: aload_3
    //   450: astore 4
    //   452: goto +8 -> 460
    //   455: getstatic 240	kotlinx/coroutines/internal/ExceptionsConstuctorKt$c:c	Lkotlinx/coroutines/internal/ExceptionsConstuctorKt$c;
    //   458: astore 4
    //   460: aload 13
    //   462: aload 14
    //   464: aload 4
    //   466: invokeinterface 198 3 0
    //   471: pop
    //   472: getstatic 203	kotlin/p:a	Lkotlin/p;
    //   475: astore 4
    //   477: iload 8
    //   479: istore 11
    //   481: iload 11
    //   483: iload 6
    //   485: if_icmpge +14 -> 499
    //   488: aload 5
    //   490: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   493: iinc 11 1
    //   496: goto -15 -> 481
    //   499: aload 12
    //   501: invokevirtual 204	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   504: aload_2
    //   505: astore 4
    //   507: aload_3
    //   508: ifnull +15 -> 523
    //   511: aload_3
    //   512: aload_0
    //   513: invokeinterface 176 2 0
    //   518: checkcast 29	java/lang/Throwable
    //   521: astore 4
    //   523: aload 4
    //   525: areturn
    //   526: astore_0
    //   527: iload 9
    //   529: istore 11
    //   531: iload 11
    //   533: iload 6
    //   535: if_icmpge +14 -> 549
    //   538: aload 5
    //   540: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   543: iinc 11 1
    //   546: goto -15 -> 531
    //   549: aload 12
    //   551: invokevirtual 204	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   554: aload_0
    //   555: athrow
    //   556: astore_0
    //   557: aload 4
    //   559: invokevirtual 173	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   562: aload_0
    //   563: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	paramE	E
    //   10	6	1	bool	boolean
    //   12	493	2	localObject1	Object
    //   14	498	3	localObject2	Object
    //   22	1	4	locala	Result.a
    //   40	7	4	localThrowable	Throwable
    //   80	478	4	localObject3	Object
    //   100	439	5	localObject4	Object
    //   127	409	6	i	int
    //   136	127	7	j	int
    //   139	339	8	k	int
    //   142	386	9	m	int
    //   145	89	10	n	int
    //   184	360	11	i1	int
    //   427	123	12	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   437	24	13	localWeakHashMap	WeakHashMap
    //   443	20	14	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   19	37	40	finally
    //   213	233	261	finally
    //   434	445	526	finally
    //   455	460	526	finally
    //   460	477	526	finally
    //   87	102	556	finally
  }
  
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      paramT2 = (Constructor)paramT2;
      j.b(paramT2, "it");
      int i = paramT2.getParameterTypes().length;
      paramT1 = (Constructor)paramT1;
      j.b(paramT1, "it");
      return a.a(Integer.valueOf(i), Integer.valueOf(paramT1.getParameterTypes().length));
    }
  }
  
  static final class b
    extends Lambda
    implements l
  {
    public static final b c = new b();
    
    b()
    {
      super();
    }
    
    public final Void a(Throwable paramThrowable)
    {
      j.f(paramThrowable, "it");
      return null;
    }
  }
  
  static final class c
    extends Lambda
    implements l
  {
    public static final c c = new c();
    
    c()
    {
      super();
    }
    
    public final Void a(Throwable paramThrowable)
    {
      j.f(paramThrowable, "it");
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\ExceptionsConstuctorKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */