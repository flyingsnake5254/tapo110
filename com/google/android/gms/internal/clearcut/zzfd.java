package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfd
{
  private static final Logger logger = Logger.getLogger(zzfd.class.getName());
  private static final Class<?> zzfb;
  private static final boolean zzfy;
  private static final Unsafe zzmh;
  private static final boolean zzpg;
  private static final boolean zzph;
  private static final zzd zzpi;
  private static final boolean zzpj;
  private static final long zzpk;
  private static final long zzpl;
  private static final long zzpm;
  private static final long zzpn;
  private static final long zzpo;
  private static final long zzpp;
  private static final long zzpq;
  private static final long zzpr;
  private static final long zzps;
  private static final long zzpt;
  private static final long zzpu;
  private static final long zzpv;
  private static final long zzpw;
  private static final long zzpx;
  private static final long zzpy;
  private static final boolean zzpz;
  
  static
  {
    Object localObject1 = zzef();
    zzmh = (Unsafe)localObject1;
    zzfb = zzaw.zzy();
    boolean bool1 = zzi(Long.TYPE);
    zzpg = bool1;
    boolean bool2 = zzi(Integer.TYPE);
    zzph = bool2;
    Object localObject2 = null;
    if (localObject1 == null) {}
    do
    {
      localObject1 = null;
      break label105;
      if (!zzaw.zzx()) {
        break;
      }
      if (bool1)
      {
        localObject1 = new zzb((Unsafe)localObject1);
        break label105;
      }
    } while (!bool2);
    localObject1 = new zza((Unsafe)localObject1);
    break label105;
    localObject1 = new zzc((Unsafe)localObject1);
    label105:
    zzpi = (zzd)localObject1;
    zzpj = zzeh();
    zzfy = zzeg();
    zzpk = zzg(byte[].class);
    zzpl = zzg(boolean[].class);
    zzpm = zzh(boolean[].class);
    zzpn = zzg(int[].class);
    zzpo = zzh(int[].class);
    zzpp = zzg(long[].class);
    zzpq = zzh(long[].class);
    zzpr = zzg(float[].class);
    zzps = zzh(float[].class);
    zzpt = zzg(double[].class);
    zzpu = zzh(double[].class);
    zzpv = zzg(Object[].class);
    zzpw = zzh(Object[].class);
    zzpx = zzb(zzei());
    Field localField = zzb(String.class, "value");
    localObject1 = localObject2;
    if (localField != null)
    {
      localObject1 = localObject2;
      if (localField.getType() == char[].class) {
        localObject1 = localField;
      }
    }
    zzpy = zzb((Field)localObject1);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    zzpz = bool2;
  }
  
  static byte zza(byte[] paramArrayOfByte, long paramLong)
  {
    return zzpi.zzx(paramArrayOfByte, zzpk + paramLong);
  }
  
  static long zza(Field paramField)
  {
    return zzpi.zza(paramField);
  }
  
  static void zza(long paramLong, byte paramByte)
  {
    zzpi.zza(paramLong, paramByte);
  }
  
  private static void zza(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zzj(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zza(Object paramObject, long paramLong, double paramDouble)
  {
    zzpi.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat)
  {
    zzpi.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong, int paramInt)
  {
    zzpi.zza(paramObject, paramLong, paramInt);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2)
  {
    zzpi.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzpi.zzqa.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzpi.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzpi.zze(paramArrayOfByte, zzpk + paramLong, paramByte);
  }
  
  static void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
  {
    zzpi.zza(paramArrayOfByte, paramLong1, paramLong2, paramLong3);
  }
  
  private static long zzb(Field paramField)
  {
    if (paramField != null)
    {
      zzd localzzd = zzpi;
      if (localzzd != null) {
        return localzzd.zza(paramField);
      }
    }
    return -1L;
  }
  
  static long zzb(ByteBuffer paramByteBuffer)
  {
    return zzpi.zzk(paramByteBuffer, zzpx);
  }
  
  /* Error */
  private static Field zzb(Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 262	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   5: astore_0
    //   6: aload_0
    //   7: iconst_1
    //   8: invokevirtual 266	java/lang/reflect/Field:setAccessible	(Z)V
    //   11: goto +6 -> 17
    //   14: astore_0
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	19	0	paramClass	Class<?>
    //   0	19	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	11	14	finally
  }
  
  private static void zzb(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zzj(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  private static void zzb(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zza(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static void zzc(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzb(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static boolean zzed()
  {
    return zzfy;
  }
  
  static boolean zzee()
  {
    return zzpj;
  }
  
  /* Error */
  static Unsafe zzef()
  {
    // Byte code:
    //   0: new 280	com/google/android/gms/internal/clearcut/zzfe
    //   3: astore_0
    //   4: aload_0
    //   5: invokespecial 281	com/google/android/gms/internal/clearcut/zzfe:<init>	()V
    //   8: aload_0
    //   9: invokestatic 287	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   12: checkcast 237	sun/misc/Unsafe
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
  
  private static boolean zzeg()
  {
    Object localObject1 = zzmh;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject1).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject1).getMethod("arrayIndexScale", new Class[] { Class.class });
      localObject2 = Long.TYPE;
      ((Class)localObject1).getMethod("getInt", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putInt", new Class[] { Object.class, localObject2, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putLong", new Class[] { Object.class, localObject2, localObject2 });
      ((Class)localObject1).getMethod("getObject", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putObject", new Class[] { Object.class, localObject2, Object.class });
      if (zzaw.zzx()) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putByte", new Class[] { Object.class, localObject2, Byte.TYPE });
      ((Class)localObject1).getMethod("getBoolean", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putBoolean", new Class[] { Object.class, localObject2, Boolean.TYPE });
      ((Class)localObject1).getMethod("getFloat", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putFloat", new Class[] { Object.class, localObject2, Float.TYPE });
      ((Class)localObject1).getMethod("getDouble", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putDouble", new Class[] { Object.class, localObject2, Double.TYPE });
      return true;
    }
    finally
    {
      Object localObject2 = logger;
      localObject1 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject2).logp((Level)localObject1, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean zzeh()
  {
    Object localObject1 = zzmh;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      localObject2 = Long.TYPE;
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localObject2 });
      if (zzei() == null) {
        return false;
      }
      if (zzaw.zzx()) {
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
      Object localObject2 = logger;
      localObject1 = Level.WARNING;
      String str = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject2).logp((Level)localObject1, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static Field zzei()
  {
    if (zzaw.zzx())
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
  
  private static int zzg(Class<?> paramClass)
  {
    if (zzfy) {
      return zzpi.zzqa.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  private static int zzh(Class<?> paramClass)
  {
    if (zzfy) {
      return zzpi.zzqa.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  private static boolean zzi(Class<?> paramClass)
  {
    if (!zzaw.zzx()) {
      return false;
    }
    try
    {
      Class localClass1 = zzfb;
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
  
  static int zzj(Object paramObject, long paramLong)
  {
    return zzpi.zzj(paramObject, paramLong);
  }
  
  static long zzk(Object paramObject, long paramLong)
  {
    return zzpi.zzk(paramObject, paramLong);
  }
  
  static boolean zzl(Object paramObject, long paramLong)
  {
    return zzpi.zzl(paramObject, paramLong);
  }
  
  static float zzm(Object paramObject, long paramLong)
  {
    return zzpi.zzm(paramObject, paramLong);
  }
  
  static double zzn(Object paramObject, long paramLong)
  {
    return zzpi.zzn(paramObject, paramLong);
  }
  
  static Object zzo(Object paramObject, long paramLong)
  {
    return zzpi.zzqa.getObject(paramObject, paramLong);
  }
  
  private static byte zzp(Object paramObject, long paramLong)
  {
    return (byte)(zzj(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)(((paramLong ^ 0xFFFFFFFFFFFFFFFF) & 0x3) << 3));
  }
  
  private static byte zzq(Object paramObject, long paramLong)
  {
    return (byte)(zzj(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  private static boolean zzr(Object paramObject, long paramLong)
  {
    return zzp(paramObject, paramLong) != 0;
  }
  
  private static boolean zzs(Object paramObject, long paramLong)
  {
    return zzq(paramObject, paramLong) != 0;
  }
  
  static final class zza
    extends zzfd.zzd
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(long paramLong, byte paramByte)
    {
      Memory.pokeByte((int)(paramLong & 0xFFFFFFFFFFFFFFFF), paramByte);
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
      if (zzfd.zzah())
      {
        zzfd.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzfd.zze(paramObject, paramLong, paramBoolean);
    }
    
    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      Memory.pokeByteArray((int)(paramLong2 & 0xFFFFFFFFFFFFFFFF), paramArrayOfByte, (int)paramLong1, (int)paramLong3);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzfd.zzah())
      {
        zzfd.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzfd.zzd(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzl(Object paramObject, long paramLong)
    {
      if (zzfd.zzah()) {
        return zzfd.zzv(paramObject, paramLong);
      }
      return zzfd.zzw(paramObject, paramLong);
    }
    
    public final float zzm(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzj(paramObject, paramLong));
    }
    
    public final double zzn(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzk(paramObject, paramLong));
    }
    
    public final byte zzx(Object paramObject, long paramLong)
    {
      if (zzfd.zzah()) {
        return zzfd.zzt(paramObject, paramLong);
      }
      return zzfd.zzu(paramObject, paramLong);
    }
  }
  
  static final class zzb
    extends zzfd.zzd
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(long paramLong, byte paramByte)
    {
      Memory.pokeByte(paramLong, paramByte);
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
      if (zzfd.zzah())
      {
        zzfd.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzfd.zze(paramObject, paramLong, paramBoolean);
    }
    
    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      Memory.pokeByteArray(paramLong2, paramArrayOfByte, (int)paramLong1, (int)paramLong3);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzfd.zzah())
      {
        zzfd.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzfd.zzd(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzl(Object paramObject, long paramLong)
    {
      if (zzfd.zzah()) {
        return zzfd.zzv(paramObject, paramLong);
      }
      return zzfd.zzw(paramObject, paramLong);
    }
    
    public final float zzm(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzj(paramObject, paramLong));
    }
    
    public final double zzn(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzk(paramObject, paramLong));
    }
    
    public final byte zzx(Object paramObject, long paramLong)
    {
      if (zzfd.zzah()) {
        return zzfd.zzt(paramObject, paramLong);
      }
      return zzfd.zzu(paramObject, paramLong);
    }
  }
  
  static final class zzc
    extends zzfd.zzd
  {
    zzc(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void zza(long paramLong, byte paramByte)
    {
      this.zzqa.putByte(paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      this.zzqa.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      this.zzqa.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.zzqa.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      this.zzqa.copyMemory(paramArrayOfByte, zzfd.zzej() + paramLong1, null, paramLong2, paramLong3);
    }
    
    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      this.zzqa.putByte(paramObject, paramLong, paramByte);
    }
    
    public final boolean zzl(Object paramObject, long paramLong)
    {
      return this.zzqa.getBoolean(paramObject, paramLong);
    }
    
    public final float zzm(Object paramObject, long paramLong)
    {
      return this.zzqa.getFloat(paramObject, paramLong);
    }
    
    public final double zzn(Object paramObject, long paramLong)
    {
      return this.zzqa.getDouble(paramObject, paramLong);
    }
    
    public final byte zzx(Object paramObject, long paramLong)
    {
      return this.zzqa.getByte(paramObject, paramLong);
    }
  }
  
  static abstract class zzd
  {
    Unsafe zzqa;
    
    zzd(Unsafe paramUnsafe)
    {
      this.zzqa = paramUnsafe;
    }
    
    public final long zza(Field paramField)
    {
      return this.zzqa.objectFieldOffset(paramField);
    }
    
    public abstract void zza(long paramLong, byte paramByte);
    
    public abstract void zza(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void zza(Object paramObject, long paramLong, float paramFloat);
    
    public final void zza(Object paramObject, long paramLong, int paramInt)
    {
      this.zzqa.putInt(paramObject, paramLong, paramInt);
    }
    
    public final void zza(Object paramObject, long paramLong1, long paramLong2)
    {
      this.zzqa.putLong(paramObject, paramLong1, paramLong2);
    }
    
    public abstract void zza(Object paramObject, long paramLong, boolean paramBoolean);
    
    public abstract void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void zze(Object paramObject, long paramLong, byte paramByte);
    
    public final int zzj(Object paramObject, long paramLong)
    {
      return this.zzqa.getInt(paramObject, paramLong);
    }
    
    public final long zzk(Object paramObject, long paramLong)
    {
      return this.zzqa.getLong(paramObject, paramLong);
    }
    
    public abstract boolean zzl(Object paramObject, long paramLong);
    
    public abstract float zzm(Object paramObject, long paramLong);
    
    public abstract double zzn(Object paramObject, long paramLong);
    
    public abstract byte zzx(Object paramObject, long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */