package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import sun.misc.Unsafe;

final class zzmr
{
  static final long zza;
  static final boolean zzb;
  private static final Unsafe zzc;
  private static final Class<?> zzd;
  private static final boolean zze;
  private static final boolean zzf;
  private static final zzmq zzg;
  private static final boolean zzh;
  private static final boolean zzi;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: invokestatic 25	com/google/android/gms/internal/measurement/zzmr:zzq	()Lsun/misc/Unsafe;
    //   3: astore_0
    //   4: aload_0
    //   5: putstatic 27	com/google/android/gms/internal/measurement/zzmr:zzc	Lsun/misc/Unsafe;
    //   8: invokestatic 32	com/google/android/gms/internal/measurement/zziq:zza	()Ljava/lang/Class;
    //   11: putstatic 34	com/google/android/gms/internal/measurement/zzmr:zzd	Ljava/lang/Class;
    //   14: getstatic 39	java/lang/Long:TYPE	Ljava/lang/Class;
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 43	com/google/android/gms/internal/measurement/zzmr:zzr	(Ljava/lang/Class;)Z
    //   22: istore_2
    //   23: iload_2
    //   24: putstatic 45	com/google/android/gms/internal/measurement/zzmr:zze	Z
    //   27: getstatic 48	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   30: invokestatic 43	com/google/android/gms/internal/measurement/zzmr:zzr	(Ljava/lang/Class;)Z
    //   33: istore_3
    //   34: iload_3
    //   35: putstatic 50	com/google/android/gms/internal/measurement/zzmr:zzf	Z
    //   38: aconst_null
    //   39: astore 4
    //   41: aload_0
    //   42: ifnonnull +6 -> 48
    //   45: goto +34 -> 79
    //   48: iload_2
    //   49: ifeq +16 -> 65
    //   52: new 52	com/google/android/gms/internal/measurement/zzmp
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 56	com/google/android/gms/internal/measurement/zzmp:<init>	(Lsun/misc/Unsafe;)V
    //   60: astore 4
    //   62: goto +17 -> 79
    //   65: iload_3
    //   66: ifeq +13 -> 79
    //   69: new 58	com/google/android/gms/internal/measurement/zzmo
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 59	com/google/android/gms/internal/measurement/zzmo:<init>	(Lsun/misc/Unsafe;)V
    //   77: astore 4
    //   79: aload 4
    //   81: putstatic 61	com/google/android/gms/internal/measurement/zzmr:zzg	Lcom/google/android/gms/internal/measurement/zzmq;
    //   84: iconst_1
    //   85: istore_2
    //   86: aload 4
    //   88: ifnonnull +8 -> 96
    //   91: iconst_0
    //   92: istore_3
    //   93: goto +91 -> 184
    //   96: aload 4
    //   98: getfield 65	com/google/android/gms/internal/measurement/zzmq:zza	Lsun/misc/Unsafe;
    //   101: astore 4
    //   103: aload 4
    //   105: ifnonnull +6 -> 111
    //   108: goto -17 -> 91
    //   111: aload 4
    //   113: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   116: astore 4
    //   118: aload 4
    //   120: ldc 70
    //   122: iconst_1
    //   123: anewarray 72	java/lang/Class
    //   126: dup
    //   127: iconst_0
    //   128: ldc 74
    //   130: aastore
    //   131: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   134: pop
    //   135: aload 4
    //   137: ldc 80
    //   139: iconst_2
    //   140: anewarray 72	java/lang/Class
    //   143: dup
    //   144: iconst_0
    //   145: ldc 4
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_1
    //   151: aastore
    //   152: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   155: pop
    //   156: invokestatic 84	com/google/android/gms/internal/measurement/zzmr:zzB	()Ljava/lang/reflect/Field;
    //   159: astore 4
    //   161: aload 4
    //   163: ifnonnull +6 -> 169
    //   166: goto -75 -> 91
    //   169: iconst_1
    //   170: istore_3
    //   171: goto +13 -> 184
    //   174: astore 4
    //   176: aload 4
    //   178: invokestatic 88	com/google/android/gms/internal/measurement/zzmr:zzs	(Ljava/lang/Throwable;)V
    //   181: goto -90 -> 91
    //   184: iload_3
    //   185: putstatic 90	com/google/android/gms/internal/measurement/zzmr:zzh	Z
    //   188: getstatic 61	com/google/android/gms/internal/measurement/zzmr:zzg	Lcom/google/android/gms/internal/measurement/zzmq;
    //   191: astore 4
    //   193: aload 4
    //   195: ifnonnull +8 -> 203
    //   198: iconst_0
    //   199: istore_3
    //   200: goto +234 -> 434
    //   203: aload 4
    //   205: getfield 65	com/google/android/gms/internal/measurement/zzmq:zza	Lsun/misc/Unsafe;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnonnull +6 -> 218
    //   215: goto -17 -> 198
    //   218: aload 4
    //   220: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   223: astore_1
    //   224: aload_1
    //   225: ldc 70
    //   227: iconst_1
    //   228: anewarray 72	java/lang/Class
    //   231: dup
    //   232: iconst_0
    //   233: ldc 74
    //   235: aastore
    //   236: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   239: pop
    //   240: aload_1
    //   241: ldc 92
    //   243: iconst_1
    //   244: anewarray 72	java/lang/Class
    //   247: dup
    //   248: iconst_0
    //   249: ldc 72
    //   251: aastore
    //   252: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: pop
    //   256: aload_1
    //   257: ldc 94
    //   259: iconst_1
    //   260: anewarray 72	java/lang/Class
    //   263: dup
    //   264: iconst_0
    //   265: ldc 72
    //   267: aastore
    //   268: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   271: pop
    //   272: getstatic 39	java/lang/Long:TYPE	Ljava/lang/Class;
    //   275: astore 4
    //   277: aload_1
    //   278: ldc 96
    //   280: iconst_2
    //   281: anewarray 72	java/lang/Class
    //   284: dup
    //   285: iconst_0
    //   286: ldc 4
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: aload 4
    //   293: aastore
    //   294: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   297: pop
    //   298: aload_1
    //   299: ldc 98
    //   301: iconst_3
    //   302: anewarray 72	java/lang/Class
    //   305: dup
    //   306: iconst_0
    //   307: ldc 4
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: aload 4
    //   314: aastore
    //   315: dup
    //   316: iconst_2
    //   317: getstatic 48	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   320: aastore
    //   321: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   324: pop
    //   325: aload_1
    //   326: ldc 80
    //   328: iconst_2
    //   329: anewarray 72	java/lang/Class
    //   332: dup
    //   333: iconst_0
    //   334: ldc 4
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: aload 4
    //   341: aastore
    //   342: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   345: pop
    //   346: aload_1
    //   347: ldc 100
    //   349: iconst_3
    //   350: anewarray 72	java/lang/Class
    //   353: dup
    //   354: iconst_0
    //   355: ldc 4
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload 4
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: aload 4
    //   367: aastore
    //   368: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   371: pop
    //   372: aload_1
    //   373: ldc 102
    //   375: iconst_2
    //   376: anewarray 72	java/lang/Class
    //   379: dup
    //   380: iconst_0
    //   381: ldc 4
    //   383: aastore
    //   384: dup
    //   385: iconst_1
    //   386: aload 4
    //   388: aastore
    //   389: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   392: pop
    //   393: aload_1
    //   394: ldc 104
    //   396: iconst_3
    //   397: anewarray 72	java/lang/Class
    //   400: dup
    //   401: iconst_0
    //   402: ldc 4
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: aload 4
    //   409: aastore
    //   410: dup
    //   411: iconst_2
    //   412: ldc 4
    //   414: aastore
    //   415: invokevirtual 78	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   418: pop
    //   419: iconst_1
    //   420: istore_3
    //   421: goto +13 -> 434
    //   424: astore 4
    //   426: aload 4
    //   428: invokestatic 88	com/google/android/gms/internal/measurement/zzmr:zzs	(Ljava/lang/Throwable;)V
    //   431: goto -233 -> 198
    //   434: iload_3
    //   435: putstatic 106	com/google/android/gms/internal/measurement/zzmr:zzi	Z
    //   438: ldc 108
    //   440: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   443: i2l
    //   444: putstatic 114	com/google/android/gms/internal/measurement/zzmr:zza	J
    //   447: ldc 116
    //   449: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   452: pop
    //   453: ldc 116
    //   455: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   458: pop
    //   459: ldc 121
    //   461: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   464: pop
    //   465: ldc 121
    //   467: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   470: pop
    //   471: ldc 123
    //   473: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   476: pop
    //   477: ldc 123
    //   479: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   482: pop
    //   483: ldc 125
    //   485: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   488: pop
    //   489: ldc 125
    //   491: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   494: pop
    //   495: ldc 127
    //   497: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   500: pop
    //   501: ldc 127
    //   503: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   506: pop
    //   507: ldc -127
    //   509: invokestatic 112	com/google/android/gms/internal/measurement/zzmr:zzz	(Ljava/lang/Class;)I
    //   512: pop
    //   513: ldc -127
    //   515: invokestatic 119	com/google/android/gms/internal/measurement/zzmr:zzA	(Ljava/lang/Class;)I
    //   518: pop
    //   519: invokestatic 84	com/google/android/gms/internal/measurement/zzmr:zzB	()Ljava/lang/reflect/Field;
    //   522: astore_1
    //   523: aload_1
    //   524: ifnull +20 -> 544
    //   527: getstatic 61	com/google/android/gms/internal/measurement/zzmr:zzg	Lcom/google/android/gms/internal/measurement/zzmq;
    //   530: astore 4
    //   532: aload 4
    //   534: ifnull +10 -> 544
    //   537: aload 4
    //   539: aload_1
    //   540: invokevirtual 132	com/google/android/gms/internal/measurement/zzmq:zzh	(Ljava/lang/reflect/Field;)J
    //   543: pop2
    //   544: invokestatic 138	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   547: getstatic 142	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   550: if_acmpne +8 -> 558
    //   553: iload_2
    //   554: istore_3
    //   555: goto +5 -> 560
    //   558: iconst_0
    //   559: istore_3
    //   560: iload_3
    //   561: putstatic 144	com/google/android/gms/internal/measurement/zzmr:zzb	Z
    //   564: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	71	0	localUnsafe	Unsafe
    //   17	523	1	localObject1	Object
    //   22	532	2	bool1	boolean
    //   33	528	3	bool2	boolean
    //   39	123	4	localObject2	Object
    //   174	3	4	localThrowable1	Throwable
    //   191	217	4	localObject3	Object
    //   424	3	4	localThrowable2	Throwable
    //   530	8	4	localzzmq	zzmq
    // Exception table:
    //   from	to	target	type
    //   111	161	174	finally
    //   218	419	424	finally
  }
  
  private static int zzA(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zzj(paramClass);
    }
    return -1;
  }
  
  private static Field zzB()
  {
    int i = zziq.zza;
    Field localField1 = zzC(Buffer.class, "effectiveDirectAddress");
    Field localField2 = localField1;
    if (localField1 == null)
    {
      localField2 = zzC(Buffer.class, "address");
      if ((localField2 != null) && (localField2.getType() == Long.TYPE)) {
        return localField2;
      }
      localField2 = null;
    }
    return localField2;
  }
  
  /* Error */
  private static Field zzC(Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 172	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   5: astore_0
    //   6: goto +6 -> 12
    //   9: astore_0
    //   10: aconst_null
    //   11: astore_0
    //   12: aload_0
    //   13: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	14	0	paramClass	Class<?>
    //   0	14	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
  
  private static void zzD(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    zzmq localzzmq = zzg;
    int i = localzzmq.zzk(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    localzzmq.zzl(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  private static void zzE(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    zzmq localzzmq = zzg;
    int i = localzzmq.zzk(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    localzzmq.zzl(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static boolean zza()
  {
    return zzi;
  }
  
  static boolean zzb()
  {
    return zzh;
  }
  
  static <T> T zzc(Class<T> paramClass)
  {
    try
    {
      paramClass = zzc.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  static int zzd(Object paramObject, long paramLong)
  {
    return zzg.zzk(paramObject, paramLong);
  }
  
  static void zze(Object paramObject, long paramLong, int paramInt)
  {
    zzg.zzl(paramObject, paramLong, paramInt);
  }
  
  static long zzf(Object paramObject, long paramLong)
  {
    return zzg.zzm(paramObject, paramLong);
  }
  
  static void zzg(Object paramObject, long paramLong1, long paramLong2)
  {
    zzg.zzn(paramObject, paramLong1, paramLong2);
  }
  
  static boolean zzh(Object paramObject, long paramLong)
  {
    return zzg.zzb(paramObject, paramLong);
  }
  
  static void zzi(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzg.zzc(paramObject, paramLong, paramBoolean);
  }
  
  static float zzj(Object paramObject, long paramLong)
  {
    return zzg.zzd(paramObject, paramLong);
  }
  
  static void zzk(Object paramObject, long paramLong, float paramFloat)
  {
    zzg.zze(paramObject, paramLong, paramFloat);
  }
  
  static double zzl(Object paramObject, long paramLong)
  {
    return zzg.zzf(paramObject, paramLong);
  }
  
  static void zzm(Object paramObject, long paramLong, double paramDouble)
  {
    zzg.zzg(paramObject, paramLong, paramDouble);
  }
  
  static Object zzn(Object paramObject, long paramLong)
  {
    return zzg.zzo(paramObject, paramLong);
  }
  
  static void zzo(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzg.zzp(paramObject1, paramLong, paramObject2);
  }
  
  static void zzp(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzg.zza(paramArrayOfByte, zza + paramLong, paramByte);
  }
  
  /* Error */
  static Unsafe zzq()
  {
    // Byte code:
    //   0: new 239	com/google/android/gms/internal/measurement/zzmn
    //   3: astore_0
    //   4: aload_0
    //   5: invokespecial 240	com/google/android/gms/internal/measurement/zzmn:<init>	()V
    //   8: aload_0
    //   9: invokestatic 246	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   12: checkcast 192	sun/misc/Unsafe
    //   15: astore_0
    //   16: goto +6 -> 22
    //   19: astore_0
    //   20: aconst_null
    //   21: astore_0
    //   22: aload_0
    //   23: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	13	0	localObject1	Object
    //   19	1	0	localObject2	Object
    //   21	2	0	localUnsafe	Unsafe
    // Exception table:
    //   from	to	target	type
    //   0	16	19	finally
  }
  
  static boolean zzr(Class<?> paramClass)
  {
    int i = zziq.zza;
    try
    {
      Class localClass1 = zzd;
      Class localClass2 = Boolean.TYPE;
      localClass1.getMethod("peekLong", new Class[] { paramClass, localClass2 });
      localClass1.getMethod("pokeLong", new Class[] { paramClass, Long.TYPE, localClass2 });
      Class localClass3 = Integer.TYPE;
      localClass1.getMethod("pokeInt", new Class[] { paramClass, localClass3, localClass2 });
      localClass1.getMethod("peekInt", new Class[] { paramClass, localClass2 });
      localClass1.getMethod("pokeByte", new Class[] { paramClass, Byte.TYPE });
      localClass1.getMethod("peekByte", new Class[] { paramClass });
      localClass1.getMethod("pokeByteArray", new Class[] { paramClass, byte[].class, localClass3, localClass3 });
      localClass1.getMethod("peekByteArray", new Class[] { paramClass, byte[].class, localClass3, localClass3 });
      return true;
    }
    finally {}
    return false;
  }
  
  private static int zzz(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zzi(paramClass);
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */