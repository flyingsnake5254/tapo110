package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzju
{
  private static final Logger logger = Logger.getLogger(zzju.class.getName());
  private static final boolean zzabe;
  private static final boolean zzabf;
  private static final zzd zzabg;
  private static final boolean zzabh;
  private static final long zzabi;
  private static final long zzabj;
  private static final long zzabk;
  private static final long zzabl;
  private static final long zzabm;
  private static final long zzabn;
  private static final long zzabo;
  private static final long zzabp;
  private static final long zzabq;
  private static final long zzabr;
  private static final long zzabs;
  private static final long zzabt;
  private static final long zzabu;
  private static final long zzabv;
  private static final int zzabw;
  static final boolean zzabx;
  private static final Class<?> zzsb;
  private static final boolean zztg;
  private static final Unsafe zzzi;
  
  static
  {
    Object localObject1 = zzim();
    zzzi = (Unsafe)localObject1;
    zzsb = zzff.zzdt();
    boolean bool1 = zzk(Long.TYPE);
    zzabe = bool1;
    boolean bool2 = zzk(Integer.TYPE);
    zzabf = bool2;
    Object localObject2 = null;
    if (localObject1 != null) {
      if (zzff.zzds())
      {
        if (bool1) {
          localObject2 = new zzc((Unsafe)localObject1);
        } else if (bool2) {
          localObject2 = new zza((Unsafe)localObject1);
        }
      }
      else {
        localObject2 = new zzb((Unsafe)localObject1);
      }
    }
    zzabg = (zzd)localObject2;
    zzabh = zzio();
    zztg = zzin();
    long l1 = zzi(byte[].class);
    zzabi = l1;
    zzabj = zzi(boolean[].class);
    zzabk = zzj(boolean[].class);
    zzabl = zzi(int[].class);
    zzabm = zzj(int[].class);
    zzabn = zzi(long[].class);
    zzabo = zzj(long[].class);
    zzabp = zzi(float[].class);
    zzabq = zzj(float[].class);
    zzabr = zzi(double[].class);
    zzabs = zzj(double[].class);
    zzabt = zzi(Object[].class);
    zzabu = zzj(Object[].class);
    localObject1 = zzip();
    long l2;
    if ((localObject1 != null) && (localObject2 != null)) {
      l2 = ((zzd)localObject2).zzaca.objectFieldOffset((Field)localObject1);
    } else {
      l2 = -1L;
    }
    zzabv = l2;
    zzabw = (int)(0x7 & l1);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzabx = bool1;
  }
  
  static byte zza(byte[] paramArrayOfByte, long paramLong)
  {
    return zzabg.zzy(paramArrayOfByte, zzabi + paramLong);
  }
  
  private static void zza(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zzk(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    zzb(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zza(Object paramObject, long paramLong, double paramDouble)
  {
    zzabg.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat)
  {
    zzabg.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2)
  {
    zzabg.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzabg.zzaca.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzabg.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzabg.zze(paramArrayOfByte, zzabi + paramLong, paramByte);
  }
  
  /* Error */
  private static Field zzb(Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 238	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
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
  
  private static void zzb(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zzk(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zzb(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zzb(Object paramObject, long paramLong, int paramInt)
  {
    zzabg.zzb(paramObject, paramLong, paramInt);
  }
  
  private static void zzb(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zza(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static void zzc(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzb(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static <T> T zzh(Class<T> paramClass)
  {
    try
    {
      paramClass = zzzi.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  private static int zzi(Class<?> paramClass)
  {
    if (zztg) {
      return zzabg.zzaca.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  static boolean zzik()
  {
    return zztg;
  }
  
  static boolean zzil()
  {
    return zzabh;
  }
  
  /* Error */
  static Unsafe zzim()
  {
    // Byte code:
    //   0: new 270	com/google/android/gms/internal/vision/zzjw
    //   3: astore_0
    //   4: aload_0
    //   5: invokespecial 271	com/google/android/gms/internal/vision/zzjw:<init>	()V
    //   8: aload_0
    //   9: invokestatic 277	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   12: checkcast 172	sun/misc/Unsafe
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
  
  private static boolean zzin()
  {
    Object localObject1 = zzzi;
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
      if (zzff.zzds()) {
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
      localObject1 = logger;
      Object localObject2 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp((Level)localObject2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean zzio()
  {
    Object localObject1 = zzzi;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject2 = localObject1.getClass();
      ((Class)localObject2).getMethod("objectFieldOffset", new Class[] { Field.class });
      localObject1 = Long.TYPE;
      ((Class)localObject2).getMethod("getLong", new Class[] { Object.class, localObject1 });
      if (zzip() == null) {
        return false;
      }
      if (zzff.zzds()) {
        return true;
      }
      ((Class)localObject2).getMethod("getByte", new Class[] { localObject1 });
      ((Class)localObject2).getMethod("putByte", new Class[] { localObject1, Byte.TYPE });
      ((Class)localObject2).getMethod("getInt", new Class[] { localObject1 });
      ((Class)localObject2).getMethod("putInt", new Class[] { localObject1, Integer.TYPE });
      ((Class)localObject2).getMethod("getLong", new Class[] { localObject1 });
      ((Class)localObject2).getMethod("putLong", new Class[] { localObject1, localObject1 });
      ((Class)localObject2).getMethod("copyMemory", new Class[] { localObject1, localObject1, localObject1 });
      ((Class)localObject2).getMethod("copyMemory", new Class[] { Object.class, localObject1, Object.class, localObject1, localObject1 });
      return true;
    }
    finally
    {
      localObject1 = logger;
      Object localObject2 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp((Level)localObject2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static Field zzip()
  {
    if (zzff.zzds())
    {
      localField = zzb(Buffer.class, "effectiveDirectAddress");
      if (localField != null) {
        return localField;
      }
    }
    Field localField = zzb(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  private static int zzj(Class<?> paramClass)
  {
    if (zztg) {
      return zzabg.zzaca.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  static int zzk(Object paramObject, long paramLong)
  {
    return zzabg.zzk(paramObject, paramLong);
  }
  
  private static boolean zzk(Class<?> paramClass)
  {
    if (!zzff.zzds()) {
      return false;
    }
    try
    {
      Class localClass1 = zzsb;
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
  
  static long zzl(Object paramObject, long paramLong)
  {
    return zzabg.zzl(paramObject, paramLong);
  }
  
  static boolean zzm(Object paramObject, long paramLong)
  {
    return zzabg.zzm(paramObject, paramLong);
  }
  
  static float zzn(Object paramObject, long paramLong)
  {
    return zzabg.zzn(paramObject, paramLong);
  }
  
  static double zzo(Object paramObject, long paramLong)
  {
    return zzabg.zzo(paramObject, paramLong);
  }
  
  static Object zzp(Object paramObject, long paramLong)
  {
    return zzabg.zzaca.getObject(paramObject, paramLong);
  }
  
  private static byte zzq(Object paramObject, long paramLong)
  {
    return (byte)(zzk(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)(((paramLong ^ 0xFFFFFFFFFFFFFFFF) & 0x3) << 3));
  }
  
  private static byte zzr(Object paramObject, long paramLong)
  {
    return (byte)(zzk(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  private static boolean zzs(Object paramObject, long paramLong)
  {
    return zzq(paramObject, paramLong) != 0;
  }
  
  private static boolean zzt(Object paramObject, long paramLong)
  {
    return zzr(paramObject, paramLong) != 0;
  }
  
  static final class zza
    extends zzju.zzd
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zzb(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzju.zzabx)
      {
        zzju.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzju.zze(paramObject, paramLong, paramBoolean);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzju.zzabx)
      {
        zzju.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzju.zzd(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzm(Object paramObject, long paramLong)
    {
      if (zzju.zzabx) {
        return zzju.zzw(paramObject, paramLong);
      }
      return zzju.zzx(paramObject, paramLong);
    }
    
    public final float zzn(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzk(paramObject, paramLong));
    }
    
    public final double zzo(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzl(paramObject, paramLong));
    }
    
    public final byte zzy(Object paramObject, long paramLong)
    {
      if (zzju.zzabx) {
        return zzju.zzu(paramObject, paramLong);
      }
      return zzju.zzv(paramObject, paramLong);
    }
  }
  
  static final class zzb
    extends zzju.zzd
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      this.zzaca.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      this.zzaca.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.zzaca.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      this.zzaca.putByte(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzm(Object paramObject, long paramLong)
    {
      return this.zzaca.getBoolean(paramObject, paramLong);
    }
    
    public final float zzn(Object paramObject, long paramLong)
    {
      return this.zzaca.getFloat(paramObject, paramLong);
    }
    
    public final double zzo(Object paramObject, long paramLong)
    {
      return this.zzaca.getDouble(paramObject, paramLong);
    }
    
    public final byte zzy(Object paramObject, long paramLong)
    {
      return this.zzaca.getByte(paramObject, paramLong);
    }
  }
  
  static final class zzc
    extends zzju.zzd
  {
    zzc(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zzb(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzju.zzabx)
      {
        zzju.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzju.zze(paramObject, paramLong, paramBoolean);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzju.zzabx)
      {
        zzju.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzju.zzd(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzm(Object paramObject, long paramLong)
    {
      if (zzju.zzabx) {
        return zzju.zzw(paramObject, paramLong);
      }
      return zzju.zzx(paramObject, paramLong);
    }
    
    public final float zzn(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzk(paramObject, paramLong));
    }
    
    public final double zzo(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzl(paramObject, paramLong));
    }
    
    public final byte zzy(Object paramObject, long paramLong)
    {
      if (zzju.zzabx) {
        return zzju.zzu(paramObject, paramLong);
      }
      return zzju.zzv(paramObject, paramLong);
    }
  }
  
  static abstract class zzd
  {
    Unsafe zzaca;
    
    zzd(Unsafe paramUnsafe)
    {
      this.zzaca = paramUnsafe;
    }
    
    public abstract void zza(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void zza(Object paramObject, long paramLong, float paramFloat);
    
    public final void zza(Object paramObject, long paramLong1, long paramLong2)
    {
      this.zzaca.putLong(paramObject, paramLong1, paramLong2);
    }
    
    public abstract void zza(Object paramObject, long paramLong, boolean paramBoolean);
    
    public final void zzb(Object paramObject, long paramLong, int paramInt)
    {
      this.zzaca.putInt(paramObject, paramLong, paramInt);
    }
    
    public abstract void zze(Object paramObject, long paramLong, byte paramByte);
    
    public final int zzk(Object paramObject, long paramLong)
    {
      return this.zzaca.getInt(paramObject, paramLong);
    }
    
    public final long zzl(Object paramObject, long paramLong)
    {
      return this.zzaca.getLong(paramObject, paramLong);
    }
    
    public abstract boolean zzm(Object paramObject, long paramLong);
    
    public abstract float zzn(Object paramObject, long paramLong);
    
    public abstract double zzo(Object paramObject, long paramLong);
    
    public abstract byte zzy(Object paramObject, long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */