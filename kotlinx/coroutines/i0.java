package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class i0
  extends r0
  implements Runnable
{
  private static volatile Thread _thread;
  private static volatile int debugStatus;
  private static final long y;
  public static final i0 z;
  
  static
  {
    Object localObject = new i0();
    z = (i0)localObject;
    q0.z((q0)localObject, false, 1, null);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    Long localLong;
    try
    {
      localObject = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
    }
    catch (SecurityException localSecurityException)
    {
      localLong = Long.valueOf(1000L);
    }
    j.b(localLong, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
    y = localTimeUnit.toNanos(localLong.longValue());
  }
  
  private final void S()
  {
    try
    {
      boolean bool = U();
      if (!bool) {
        return;
      }
      debugStatus = 3;
      O();
      notifyAll();
      return;
    }
    finally {}
  }
  
  private final Thread T()
  {
    try
    {
      Thread localThread = _thread;
      if (localThread == null)
      {
        localThread = new java/lang/Thread;
        localThread.<init>(this, "kotlinx.coroutines.DefaultExecutor");
        _thread = localThread;
        localThread.setDaemon(true);
        localThread.start();
      }
      return localThread;
    }
    finally {}
  }
  
  private final boolean U()
  {
    int i = debugStatus;
    boolean bool;
    if ((i != 2) && (i != 3)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private final boolean V()
  {
    try
    {
      boolean bool = U();
      if (bool) {
        return false;
      }
      debugStatus = 1;
      notifyAll();
      return true;
    }
    finally {}
  }
  
  protected Thread D()
  {
    Thread localThread = _thread;
    if (localThread == null) {
      localThread = T();
    }
    return localThread;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 111	kotlinx/coroutines/x1:b	Lkotlinx/coroutines/x1;
    //   3: aload_0
    //   4: invokevirtual 115	kotlinx/coroutines/x1:c	(Lkotlinx/coroutines/q0;)V
    //   7: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +9 -> 21
    //   15: aload_1
    //   16: invokeinterface 126 1 0
    //   21: aload_0
    //   22: invokespecial 128	kotlinx/coroutines/i0:V	()Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifne +38 -> 65
    //   30: aconst_null
    //   31: putstatic 87	kotlinx/coroutines/i0:_thread	Ljava/lang/Thread;
    //   34: aload_0
    //   35: invokespecial 130	kotlinx/coroutines/i0:S	()V
    //   38: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +9 -> 52
    //   46: aload_1
    //   47: invokeinterface 133 1 0
    //   52: aload_0
    //   53: invokevirtual 136	kotlinx/coroutines/r0:L	()Z
    //   56: ifne +8 -> 64
    //   59: aload_0
    //   60: invokevirtual 138	kotlinx/coroutines/i0:D	()Ljava/lang/Thread;
    //   63: pop
    //   64: return
    //   65: ldc2_w 139
    //   68: lstore_3
    //   69: invokestatic 143	java/lang/Thread:interrupted	()Z
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 146	kotlinx/coroutines/r0:M	()J
    //   77: lstore 5
    //   79: lload_3
    //   80: lstore 7
    //   82: lload 5
    //   84: lstore 9
    //   86: lload 5
    //   88: ldc2_w 139
    //   91: lcmp
    //   92: ifne +129 -> 221
    //   95: lload_3
    //   96: ldc2_w 139
    //   99: lcmp
    //   100: istore 11
    //   102: iload 11
    //   104: ifne +104 -> 208
    //   107: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +14 -> 126
    //   115: aload_1
    //   116: invokeinterface 149 1 0
    //   121: lstore 9
    //   123: goto +8 -> 131
    //   126: invokestatic 152	java/lang/System:nanoTime	()J
    //   129: lstore 9
    //   131: iload 11
    //   133: ifne +12 -> 145
    //   136: getstatic 66	kotlinx/coroutines/i0:y	J
    //   139: lstore_3
    //   140: lload_3
    //   141: lload 9
    //   143: ladd
    //   144: lstore_3
    //   145: lload_3
    //   146: lload 9
    //   148: lsub
    //   149: lstore 9
    //   151: lload 9
    //   153: lconst_0
    //   154: lcmp
    //   155: ifgt +38 -> 193
    //   158: aconst_null
    //   159: putstatic 87	kotlinx/coroutines/i0:_thread	Ljava/lang/Thread;
    //   162: aload_0
    //   163: invokespecial 130	kotlinx/coroutines/i0:S	()V
    //   166: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +9 -> 180
    //   174: aload_1
    //   175: invokeinterface 133 1 0
    //   180: aload_0
    //   181: invokevirtual 136	kotlinx/coroutines/r0:L	()Z
    //   184: ifne +8 -> 192
    //   187: aload_0
    //   188: invokevirtual 138	kotlinx/coroutines/i0:D	()Ljava/lang/Thread;
    //   191: pop
    //   192: return
    //   193: lload 5
    //   195: lload 9
    //   197: invokestatic 158	kotlin/v/e:e	(JJ)J
    //   200: lstore 9
    //   202: lload_3
    //   203: lstore 7
    //   205: goto +16 -> 221
    //   208: lload 5
    //   210: getstatic 66	kotlinx/coroutines/i0:y	J
    //   213: invokestatic 158	kotlin/v/e:e	(JJ)J
    //   216: lstore 9
    //   218: lload_3
    //   219: lstore 7
    //   221: lload 7
    //   223: lstore_3
    //   224: lload 9
    //   226: lconst_0
    //   227: lcmp
    //   228: ifle -159 -> 69
    //   231: aload_0
    //   232: invokespecial 73	kotlinx/coroutines/i0:U	()Z
    //   235: istore_2
    //   236: iload_2
    //   237: ifeq +38 -> 275
    //   240: aconst_null
    //   241: putstatic 87	kotlinx/coroutines/i0:_thread	Ljava/lang/Thread;
    //   244: aload_0
    //   245: invokespecial 130	kotlinx/coroutines/i0:S	()V
    //   248: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +9 -> 262
    //   256: aload_1
    //   257: invokeinterface 133 1 0
    //   262: aload_0
    //   263: invokevirtual 136	kotlinx/coroutines/r0:L	()Z
    //   266: ifne +8 -> 274
    //   269: aload_0
    //   270: invokevirtual 138	kotlinx/coroutines/i0:D	()Ljava/lang/Thread;
    //   273: pop
    //   274: return
    //   275: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   278: astore_1
    //   279: aload_1
    //   280: ifnull +18 -> 298
    //   283: aload_1
    //   284: aload_0
    //   285: lload 9
    //   287: invokeinterface 161 4 0
    //   292: lload 7
    //   294: lstore_3
    //   295: goto -226 -> 69
    //   298: aload_0
    //   299: lload 9
    //   301: invokestatic 166	java/util/concurrent/locks/LockSupport:parkNanos	(Ljava/lang/Object;J)V
    //   304: lload 7
    //   306: lstore_3
    //   307: goto -238 -> 69
    //   310: astore 12
    //   312: aconst_null
    //   313: putstatic 87	kotlinx/coroutines/i0:_thread	Ljava/lang/Thread;
    //   316: aload_0
    //   317: invokespecial 130	kotlinx/coroutines/i0:S	()V
    //   320: invokestatic 121	kotlinx/coroutines/z1:a	()Lkotlinx/coroutines/y1;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull +9 -> 334
    //   328: aload_1
    //   329: invokeinterface 133 1 0
    //   334: aload_0
    //   335: invokevirtual 136	kotlinx/coroutines/r0:L	()Z
    //   338: ifne +8 -> 346
    //   341: aload_0
    //   342: invokevirtual 138	kotlinx/coroutines/i0:D	()Ljava/lang/Thread;
    //   345: pop
    //   346: aload 12
    //   348: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	i0
    //   10	319	1	localy1	y1
    //   25	212	2	bool1	boolean
    //   68	239	3	l1	long
    //   77	132	5	l2	long
    //   80	225	7	l3	long
    //   84	216	9	l4	long
    //   100	32	11	bool2	boolean
    //   310	37	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	310	finally
    //   69	79	310	finally
    //   107	111	310	finally
    //   115	123	310	finally
    //   126	131	310	finally
    //   136	140	310	finally
    //   193	202	310	finally
    //   208	218	310	finally
    //   231	236	310	finally
    //   275	279	310	finally
    //   283	292	310	finally
    //   298	304	310	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */