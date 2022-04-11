package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzhw
{
  static final boolean zza;
  private static final Logger zzb = Logger.getLogger(zzhw.class.getName());
  private static final Unsafe zzc;
  private static final Class<?> zzd;
  private static final boolean zze;
  private static final boolean zzf;
  private static final zzc zzg;
  private static final boolean zzh;
  private static final boolean zzi;
  private static final long zzj;
  private static final long zzk;
  private static final long zzl;
  private static final long zzm;
  private static final long zzn;
  private static final long zzo;
  private static final long zzp;
  private static final long zzq;
  private static final long zzr;
  private static final long zzs;
  private static final long zzt;
  private static final long zzu;
  private static final long zzv;
  private static final long zzw;
  private static final int zzx;
  
  static
  {
    Object localObject1 = zzc();
    zzc = (Unsafe)localObject1;
    zzd = zzdt.zzb();
    boolean bool1 = zzd(Long.TYPE);
    zze = bool1;
    boolean bool2 = zzd(Integer.TYPE);
    zzf = bool2;
    Object localObject2 = null;
    if (localObject1 != null) {
      if (zzdt.zza())
      {
        if (bool1) {
          localObject2 = new zza((Unsafe)localObject1);
        } else if (bool2) {
          localObject2 = new zzb((Unsafe)localObject1);
        }
      }
      else {
        localObject2 = new zzd((Unsafe)localObject1);
      }
    }
    zzg = (zzc)localObject2;
    zzh = zze();
    zzi = zzd();
    long l1 = zzb(byte[].class);
    zzj = l1;
    zzk = zzb(boolean[].class);
    zzl = zzc(boolean[].class);
    zzm = zzb(int[].class);
    zzn = zzc(int[].class);
    zzo = zzb(long[].class);
    zzp = zzc(long[].class);
    zzq = zzb(float[].class);
    zzr = zzc(float[].class);
    zzs = zzb(double[].class);
    zzt = zzc(double[].class);
    zzu = zzb(Object[].class);
    zzv = zzc(Object[].class);
    localObject1 = zzf();
    long l2;
    if ((localObject1 != null) && (localObject2 != null)) {
      l2 = ((zzc)localObject2).zza.objectFieldOffset((Field)localObject1);
    } else {
      l2 = -1L;
    }
    zzw = l2;
    zzx = (int)(0x7 & l1);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zza = bool1;
  }
  
  static byte zza(byte[] paramArrayOfByte, long paramLong)
  {
    return zzg.zza(paramArrayOfByte, zzj + paramLong);
  }
  
  static int zza(Object paramObject, long paramLong)
  {
    return zzg.zze(paramObject, paramLong);
  }
  
  static <T> T zza(Class<T> paramClass)
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
  
  /* Error */
  private static Field zza(Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 210	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
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
  
  static void zza(Object paramObject, long paramLong, double paramDouble)
  {
    zzg.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat)
  {
    zzg.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong, int paramInt)
  {
    zzg.zza(paramObject, paramLong, paramInt);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2)
  {
    zzg.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzg.zza.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzg.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzg.zza(paramArrayOfByte, zzj + paramLong, paramByte);
  }
  
  static boolean zza()
  {
    return zzi;
  }
  
  private static int zzb(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zza.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  static long zzb(Object paramObject, long paramLong)
  {
    return zzg.zzf(paramObject, paramLong);
  }
  
  static boolean zzb()
  {
    return zzh;
  }
  
  private static int zzc(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zza.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  /* Error */
  static Unsafe zzc()
  {
    // Byte code:
    //   0: new 252	com/google/android/gms/internal/mlkit_common/zzhv
    //   3: astore_0
    //   4: aload_0
    //   5: invokespecial 253	com/google/android/gms/internal/mlkit_common/zzhv:<init>	()V
    //   8: aload_0
    //   9: invokestatic 259	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   12: checkcast 158	sun/misc/Unsafe
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
  
  private static void zzc(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zza(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static boolean zzc(Object paramObject, long paramLong)
  {
    return zzg.zzb(paramObject, paramLong);
  }
  
  static float zzd(Object paramObject, long paramLong)
  {
    return zzg.zzc(paramObject, paramLong);
  }
  
  private static void zzd(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zza(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  private static void zzd(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzc(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static boolean zzd()
  {
    Object localObject1 = zzc;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject2 = localObject1.getClass();
      ((Class)localObject2).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject2).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject2).getMethod("arrayIndexScale", new Class[] { Class.class });
      localObject1 = Long.TYPE;
      ((Class)localObject2).getMethod("getInt", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putInt", new Class[] { Object.class, localObject1, Integer.TYPE });
      ((Class)localObject2).getMethod("getLong", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putLong", new Class[] { Object.class, localObject1, localObject1 });
      ((Class)localObject2).getMethod("getObject", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putObject", new Class[] { Object.class, localObject1, Object.class });
      if (zzdt.zza()) {
        return true;
      }
      ((Class)localObject2).getMethod("getByte", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putByte", new Class[] { Object.class, localObject1, Byte.TYPE });
      ((Class)localObject2).getMethod("getBoolean", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putBoolean", new Class[] { Object.class, localObject1, Boolean.TYPE });
      ((Class)localObject2).getMethod("getFloat", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putFloat", new Class[] { Object.class, localObject1, Float.TYPE });
      ((Class)localObject2).getMethod("getDouble", new Class[] { Object.class, localObject1 });
      ((Class)localObject2).getMethod("putDouble", new Class[] { Object.class, localObject1, Double.TYPE });
      return true;
    }
    finally
    {
      Object localObject2 = zzb;
      localObject1 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject2).logp((Level)localObject1, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean zzd(Class<?> paramClass)
  {
    if (!zzdt.zza()) {
      return false;
    }
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
  
  static double zze(Object paramObject, long paramLong)
  {
    return zzg.zzd(paramObject, paramLong);
  }
  
  private static void zze(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzd(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static boolean zze()
  {
    Object localObject1 = zzc;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      localObject2 = Long.TYPE;
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localObject2 });
      if (zzf() == null) {
        return false;
      }
      if (zzdt.zza()) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putByte", new Class[] { localObject2, Byte.TYPE });
      ((Class)localObject1).getMethod("getInt", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putInt", new Class[] { localObject2, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putLong", new Class[] { localObject2, localObject2 });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { localObject2, localObject2, localObject2 });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Object.class, localObject2, Object.class, localObject2, localObject2 });
      return true;
    }
    finally
    {
      Object localObject2 = zzb;
      localObject1 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject2).logp((Level)localObject1, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  static Object zzf(Object paramObject, long paramLong)
  {
    return zzg.zza.getObject(paramObject, paramLong);
  }
  
  private static Field zzf()
  {
    if (zzdt.zza())
    {
      localField = zza(Buffer.class, "effectiveDirectAddress");
      if (localField != null) {
        return localField;
      }
    }
    Field localField = zza(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  private static byte zzk(Object paramObject, long paramLong)
  {
    return (byte)(zza(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)(((paramLong ^ 0xFFFFFFFFFFFFFFFF) & 0x3) << 3));
  }
  
  private static byte zzl(Object paramObject, long paramLong)
  {
    return (byte)(zza(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  private static boolean zzm(Object paramObject, long paramLong)
  {
    return zzk(paramObject, paramLong) != 0;
  }
  
  private static boolean zzn(Object paramObject, long paramLong)
  {
    return zzl(paramObject, paramLong) != 0;
  }
  
  static final class zza
    extends zzhw.zzc
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      if (zzhw.zza) {
        return zzhw.zzg(paramObject, paramLong);
      }
      return zzhw.zzh(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzhw.zza)
      {
        zzhw.zza(paramObject, paramLong, paramByte);
        return;
      }
      zzhw.zzb(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zza(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzhw.zza)
      {
        zzhw.zzb(paramObject, paramLong, paramBoolean);
        return;
      }
      zzhw.zzc(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      if (zzhw.zza) {
        return zzhw.zzi(paramObject, paramLong);
      }
      return zzhw.zzj(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zze(paramObject, paramLong));
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzf(paramObject, paramLong));
    }
  }
  
  static final class zzb
    extends zzhw.zzc
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      if (zzhw.zza) {
        return zzhw.zzg(paramObject, paramLong);
      }
      return zzhw.zzh(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzhw.zza)
      {
        zzhw.zza(paramObject, paramLong, paramByte);
        return;
      }
      zzhw.zzb(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zza(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzhw.zza)
      {
        zzhw.zzb(paramObject, paramLong, paramBoolean);
        return;
      }
      zzhw.zzc(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      if (zzhw.zza) {
        return zzhw.zzi(paramObject, paramLong);
      }
      return zzhw.zzj(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zze(paramObject, paramLong));
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzf(paramObject, paramLong));
    }
  }
  
  static abstract class zzc
  {
    Unsafe zza;
    
    zzc(Unsafe paramUnsafe)
    {
      this.zza = paramUnsafe;
    }
    
    public abstract byte zza(Object paramObject, long paramLong);
    
    public abstract void zza(Object paramObject, long paramLong, byte paramByte);
    
    public abstract void zza(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void zza(Object paramObject, long paramLong, float paramFloat);
    
    public final void zza(Object paramObject, long paramLong, int paramInt)
    {
      this.zza.putInt(paramObject, paramLong, paramInt);
    }
    
    public final void zza(Object paramObject, long paramLong1, long paramLong2)
    {
      this.zza.putLong(paramObject, paramLong1, paramLong2);
    }
    
    public abstract void zza(Object paramObject, long paramLong, boolean paramBoolean);
    
    public abstract boolean zzb(Object paramObject, long paramLong);
    
    public abstract float zzc(Object paramObject, long paramLong);
    
    public abstract double zzd(Object paramObject, long paramLong);
    
    public final int zze(Object paramObject, long paramLong)
    {
      return this.zza.getInt(paramObject, paramLong);
    }
    
    public final long zzf(Object paramObject, long paramLong)
    {
      return this.zza.getLong(paramObject, paramLong);
    }
  }
  
  static final class zzd
    extends zzhw.zzc
  {
    zzd(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      return this.zza.getByte(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      this.zza.putByte(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      this.zza.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      this.zza.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.zza.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      return this.zza.getBoolean(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return this.zza.getFloat(paramObject, paramLong);
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return this.zza.getDouble(paramObject, paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */