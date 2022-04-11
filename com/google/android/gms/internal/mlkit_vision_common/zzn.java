package com.google.android.gms.internal.mlkit_vision_common;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzn
{
  private static final zzm zza;
  private static final int zzb;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: invokestatic 15	com/google/android/gms/internal/mlkit_vision_common/zzn:zza	()Ljava/lang/Integer;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull +23 -> 30
    //   10: aload_1
    //   11: invokevirtual 21	java/lang/Integer:intValue	()I
    //   14: bipush 19
    //   16: if_icmplt +14 -> 30
    //   19: new 23	com/google/android/gms/internal/mlkit_vision_common/zzs
    //   22: astore_2
    //   23: aload_2
    //   24: invokespecial 26	com/google/android/gms/internal/mlkit_vision_common/zzs:<init>	()V
    //   27: goto +119 -> 146
    //   30: ldc 28
    //   32: invokestatic 34	java/lang/Boolean:getBoolean	(Ljava/lang/String;)Z
    //   35: iconst_1
    //   36: ixor
    //   37: ifeq +14 -> 51
    //   40: new 36	com/google/android/gms/internal/mlkit_vision_common/zzq
    //   43: dup
    //   44: invokespecial 37	com/google/android/gms/internal/mlkit_vision_common/zzq:<init>	()V
    //   47: astore_2
    //   48: goto +98 -> 146
    //   51: new 6	com/google/android/gms/internal/mlkit_vision_common/zzn$zza
    //   54: dup
    //   55: invokespecial 38	com/google/android/gms/internal/mlkit_vision_common/zzn$zza:<init>	()V
    //   58: astore_2
    //   59: goto +87 -> 146
    //   62: astore_2
    //   63: goto +6 -> 69
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: getstatic 44	java/lang/System:err	Ljava/io/PrintStream;
    //   72: astore_3
    //   73: ldc 6
    //   75: invokevirtual 50	java/lang/Class:getName	()Ljava/lang/String;
    //   78: astore 4
    //   80: new 52	java/lang/StringBuilder
    //   83: dup
    //   84: aload 4
    //   86: invokevirtual 57	java/lang/String:length	()I
    //   89: sipush 133
    //   92: iadd
    //   93: invokespecial 60	java/lang/StringBuilder:<init>	(I)V
    //   96: astore 5
    //   98: aload 5
    //   100: ldc 62
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 5
    //   108: aload 4
    //   110: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 5
    //   116: ldc 68
    //   118: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_3
    //   123: aload 5
    //   125: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 77	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   131: aload_2
    //   132: getstatic 44	java/lang/System:err	Ljava/io/PrintStream;
    //   135: invokevirtual 83	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   138: new 6	com/google/android/gms/internal/mlkit_vision_common/zzn$zza
    //   141: dup
    //   142: invokespecial 38	com/google/android/gms/internal/mlkit_vision_common/zzn$zza:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: putstatic 85	com/google/android/gms/internal/mlkit_vision_common/zzn:zza	Lcom/google/android/gms/internal/mlkit_vision_common/zzm;
    //   150: aload_1
    //   151: ifnonnull +6 -> 157
    //   154: goto +8 -> 162
    //   157: aload_1
    //   158: invokevirtual 21	java/lang/Integer:intValue	()I
    //   161: istore_0
    //   162: iload_0
    //   163: putstatic 87	com/google/android/gms/internal/mlkit_vision_common/zzn:zzb	I
    //   166: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	162	0	i	int
    //   5	153	1	localInteger	Integer
    //   22	37	2	localObject1	Object
    //   62	1	2	localObject2	Object
    //   66	66	2	localObject3	Object
    //   145	2	2	localzza	zza
    //   72	51	3	localPrintStream	PrintStream
    //   78	31	4	str	String
    //   96	28	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	27	62	finally
    //   30	48	62	finally
    //   51	59	62	finally
    //   2	6	66	finally
  }
  
  private static Integer zza()
  {
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
    }
    return null;
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    zza.zza(paramThrowable1, paramThrowable2);
  }
  
  static final class zza
    extends zzm
  {
    public final void zza(Throwable paramThrowable1, Throwable paramThrowable2) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */