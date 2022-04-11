package com.google.android.gms.internal.firebase_messaging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzab
  implements ObjectEncoderContext
{
  private static final Charset zza = Charset.forName("UTF-8");
  private static final FieldDescriptor zzg;
  private static final FieldDescriptor zzh;
  private static final ObjectEncoder<Map.Entry<Object, Object>> zzi = zzaa.zza;
  private OutputStream zzb;
  private final Map<Class<?>, ObjectEncoder<?>> zzc;
  private final Map<Class<?>, ValueEncoder<?>> zzd;
  private final ObjectEncoder<Object> zze;
  private final zzaf zzf = new zzaf(this);
  
  static
  {
    Object localObject1 = FieldDescriptor.builder("key");
    Object localObject2 = new zzv();
    ((zzv)localObject2).zza(1);
    zzg = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject2 = FieldDescriptor.builder("value");
    localObject1 = new zzv();
    ((zzv)localObject1).zza(2);
    zzh = ((FieldDescriptor.Builder)localObject2).withProperty(((zzv)localObject1).zzb()).build();
  }
  
  zzab(OutputStream paramOutputStream, Map<Class<?>, ObjectEncoder<?>> paramMap, Map<Class<?>, ValueEncoder<?>> paramMap1, ObjectEncoder<Object> paramObjectEncoder)
  {
    this.zzb = paramOutputStream;
    this.zzc = paramMap;
    this.zzd = paramMap1;
    this.zze = paramObjectEncoder;
  }
  
  private final <T> zzab zzh(ObjectEncoder<T> paramObjectEncoder, FieldDescriptor paramFieldDescriptor, T paramT, boolean paramBoolean)
    throws IOException
  {
    long l = zzi(paramObjectEncoder, paramT);
    if ((paramBoolean) && (l == 0L)) {
      return this;
    }
    zzn(zzl(paramFieldDescriptor) << 3 | 0x2);
    zzo(l);
    paramObjectEncoder.encode(paramT, this);
    return this;
  }
  
  /* Error */
  private final <T> long zzi(ObjectEncoder<T> paramObjectEncoder, T paramT)
    throws IOException
  {
    // Byte code:
    //   0: new 140	com/google/android/gms/internal/firebase_messaging/zzw
    //   3: dup
    //   4: invokespecial 141	com/google/android/gms/internal/firebase_messaging/zzw:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 90	com/google/android/gms/internal/firebase_messaging/zzab:zzb	Ljava/io/OutputStream;
    //   12: astore 4
    //   14: aload_0
    //   15: aload_3
    //   16: putfield 90	com/google/android/gms/internal/firebase_messaging/zzab:zzb	Ljava/io/OutputStream;
    //   19: aload_1
    //   20: aload_2
    //   21: aload_0
    //   22: invokeinterface 137 3 0
    //   27: aload_0
    //   28: aload 4
    //   30: putfield 90	com/google/android/gms/internal/firebase_messaging/zzab:zzb	Ljava/io/OutputStream;
    //   33: aload_3
    //   34: invokevirtual 144	com/google/android/gms/internal/firebase_messaging/zzw:zza	()J
    //   37: lstore 5
    //   39: aload_3
    //   40: invokevirtual 149	java/io/OutputStream:close	()V
    //   43: lload 5
    //   45: lreturn
    //   46: astore_1
    //   47: aload_0
    //   48: aload 4
    //   50: putfield 90	com/google/android/gms/internal/firebase_messaging/zzab:zzb	Ljava/io/OutputStream;
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_3
    //   57: invokevirtual 149	java/io/OutputStream:close	()V
    //   60: goto +9 -> 69
    //   63: astore_2
    //   64: aload_1
    //   65: aload_2
    //   66: invokestatic 154	com/google/android/gms/internal/firebase_messaging/zzt:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	zzab
    //   0	71	1	paramObjectEncoder	ObjectEncoder<T>
    //   0	71	2	paramT	T
    //   7	50	3	localzzw	zzw
    //   12	37	4	localOutputStream	OutputStream
    //   37	7	5	l	long
    // Exception table:
    //   from	to	target	type
    //   19	27	46	finally
    //   8	19	55	finally
    //   27	39	55	finally
    //   47	55	55	finally
    //   56	60	63	finally
  }
  
  private final <T> zzab zzj(ValueEncoder<T> paramValueEncoder, FieldDescriptor paramFieldDescriptor, T paramT, boolean paramBoolean)
    throws IOException
  {
    this.zzf.zza(paramFieldDescriptor, paramBoolean);
    paramValueEncoder.encode(paramT, this.zzf);
    return this;
  }
  
  private static ByteBuffer zzk(int paramInt)
  {
    return ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private static int zzl(FieldDescriptor paramFieldDescriptor)
  {
    paramFieldDescriptor = (zzz)paramFieldDescriptor.getProperty(zzz.class);
    if (paramFieldDescriptor != null) {
      return paramFieldDescriptor.zza();
    }
    throw new EncodingException("Field has no @Protobuf config");
  }
  
  private static zzz zzm(FieldDescriptor paramFieldDescriptor)
  {
    paramFieldDescriptor = (zzz)paramFieldDescriptor.getProperty(zzz.class);
    if (paramFieldDescriptor != null) {
      return paramFieldDescriptor;
    }
    throw new EncodingException("Field has no @Protobuf config");
  }
  
  private final void zzn(int paramInt)
    throws IOException
  {
    while ((paramInt & 0xFFFFFF80) != 0L)
    {
      this.zzb.write(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
    this.zzb.write(paramInt & 0x7F);
  }
  
  private final void zzo(long paramLong)
    throws IOException
  {
    while ((0xFFFFFFFFFFFFFF80 & paramLong) != 0L)
    {
      this.zzb.write((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
    this.zzb.write((int)paramLong & 0x7F);
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, double paramDouble)
    throws IOException
  {
    zzb(paramFieldDescriptor, paramDouble, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, float paramFloat)
    throws IOException
  {
    zzc(paramFieldDescriptor, paramFloat, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, @Nullable Object paramObject)
    throws IOException
  {
    zza(paramFieldDescriptor, paramObject, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull String paramString, double paramDouble)
    throws IOException
  {
    zzb(FieldDescriptor.of(paramString), paramDouble, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull String paramString, int paramInt)
    throws IOException
  {
    zzd(FieldDescriptor.of(paramString), paramInt, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull String paramString, long paramLong)
    throws IOException
  {
    zze(FieldDescriptor.of(paramString), paramLong, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull String paramString, @Nullable Object paramObject)
    throws IOException
  {
    zza(FieldDescriptor.of(paramString), paramObject, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext add(@NonNull String paramString, boolean paramBoolean)
    throws IOException
  {
    zzd(FieldDescriptor.of(paramString), paramBoolean, true);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext inline(@Nullable Object paramObject)
    throws IOException
  {
    zzf(paramObject);
    return this;
  }
  
  @NonNull
  public final ObjectEncoderContext nested(@NonNull FieldDescriptor paramFieldDescriptor)
    throws IOException
  {
    throw new EncodingException("nested() is not implemented for protobuf encoding.");
  }
  
  @NonNull
  public final ObjectEncoderContext nested(@NonNull String paramString)
    throws IOException
  {
    return nested(FieldDescriptor.of(paramString));
  }
  
  final ObjectEncoderContext zza(@NonNull FieldDescriptor paramFieldDescriptor, @Nullable Object paramObject, boolean paramBoolean)
    throws IOException
  {
    if (paramObject == null) {
      return this;
    }
    if ((paramObject instanceof CharSequence))
    {
      paramObject = (CharSequence)paramObject;
      if ((paramBoolean) && (((CharSequence)paramObject).length() == 0)) {
        return this;
      }
      zzn(zzl(paramFieldDescriptor) << 3 | 0x2);
      paramFieldDescriptor = ((CharSequence)paramObject).toString().getBytes(zza);
      zzn(paramFieldDescriptor.length);
      this.zzb.write(paramFieldDescriptor);
      return this;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        zza(paramFieldDescriptor, ((Iterator)paramObject).next(), false);
      }
      return this;
    }
    if ((paramObject instanceof Map))
    {
      localObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramObject = (Map.Entry)((Iterator)localObject).next();
        zzh(zzi, paramFieldDescriptor, paramObject, false);
      }
      return this;
    }
    if ((paramObject instanceof Double))
    {
      zzb(paramFieldDescriptor, ((Double)paramObject).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Float))
    {
      zzc(paramFieldDescriptor, ((Float)paramObject).floatValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Number))
    {
      zze(paramFieldDescriptor, ((Number)paramObject).longValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      zzd(paramFieldDescriptor, ((Boolean)paramObject).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      if ((paramBoolean) && (paramObject.length == 0)) {
        return this;
      }
      zzn(zzl(paramFieldDescriptor) << 3 | 0x2);
      zzn(paramObject.length);
      this.zzb.write((byte[])paramObject);
      return this;
    }
    Object localObject = (ObjectEncoder)this.zzc.get(paramObject.getClass());
    if (localObject != null)
    {
      zzh((ObjectEncoder)localObject, paramFieldDescriptor, paramObject, paramBoolean);
      return this;
    }
    localObject = (ValueEncoder)this.zzd.get(paramObject.getClass());
    if (localObject != null)
    {
      zzj((ValueEncoder)localObject, paramFieldDescriptor, paramObject, paramBoolean);
      return this;
    }
    if ((paramObject instanceof zzx))
    {
      zzd(paramFieldDescriptor, ((zzx)paramObject).getNumber(), true);
      return this;
    }
    if ((paramObject instanceof Enum))
    {
      zzd(paramFieldDescriptor, ((Enum)paramObject).ordinal(), true);
      return this;
    }
    zzh(this.zze, paramFieldDescriptor, paramObject, paramBoolean);
    return this;
  }
  
  final ObjectEncoderContext zzb(@NonNull FieldDescriptor paramFieldDescriptor, double paramDouble, boolean paramBoolean)
    throws IOException
  {
    if ((paramBoolean) && (paramDouble == 0.0D)) {
      return this;
    }
    zzn(zzl(paramFieldDescriptor) << 3 | 0x1);
    this.zzb.write(zzk(8).putDouble(paramDouble).array());
    return this;
  }
  
  final ObjectEncoderContext zzc(@NonNull FieldDescriptor paramFieldDescriptor, float paramFloat, boolean paramBoolean)
    throws IOException
  {
    if ((paramBoolean) && (paramFloat == 0.0F)) {
      return this;
    }
    zzn(zzl(paramFieldDescriptor) << 3 | 0x5);
    this.zzb.write(zzk(4).putFloat(paramFloat).array());
    return this;
  }
  
  final zzab zzd(@NonNull FieldDescriptor paramFieldDescriptor, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if ((paramBoolean) && (paramInt == 0)) {
      return this;
    }
    paramFieldDescriptor = zzm(paramFieldDescriptor);
    zzy localzzy = zzy.zza;
    int i = paramFieldDescriptor.zzb().ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          zzn(paramFieldDescriptor.zza() << 3 | 0x5);
          this.zzb.write(zzk(4).putInt(paramInt).array());
        }
      }
      else
      {
        zzn(paramFieldDescriptor.zza() << 3);
        zzn(paramInt + paramInt ^ paramInt >> 31);
      }
    }
    else
    {
      zzn(paramFieldDescriptor.zza() << 3);
      zzn(paramInt);
    }
    return this;
  }
  
  final zzab zze(@NonNull FieldDescriptor paramFieldDescriptor, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if ((paramBoolean) && (paramLong == 0L)) {
      return this;
    }
    paramFieldDescriptor = zzm(paramFieldDescriptor);
    zzy localzzy = zzy.zza;
    int i = paramFieldDescriptor.zzb().ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          zzn(paramFieldDescriptor.zza() << 3 | 0x1);
          this.zzb.write(zzk(8).putLong(paramLong).array());
        }
      }
      else
      {
        zzn(paramFieldDescriptor.zza() << 3);
        zzo(paramLong >> 63 ^ paramLong + paramLong);
      }
    }
    else
    {
      zzn(paramFieldDescriptor.zza() << 3);
      zzo(paramLong);
    }
    return this;
  }
  
  final zzab zzf(@Nullable Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      return this;
    }
    Object localObject = (ObjectEncoder)this.zzc.get(paramObject.getClass());
    if (localObject != null)
    {
      ((ObjectEncoder)localObject).encode(paramObject, this);
      return this;
    }
    localObject = String.valueOf(paramObject.getClass());
    paramObject = new StringBuilder(((String)localObject).length() + 15);
    ((StringBuilder)paramObject).append("No encoder for ");
    ((StringBuilder)paramObject).append((String)localObject);
    throw new EncodingException(((StringBuilder)paramObject).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */