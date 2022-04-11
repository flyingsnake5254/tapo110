package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgx<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
  extends zzey<MessageType, BuilderType>
{
  private static Map<Object, zzgx<?, ?>> zzwu = new ConcurrentHashMap();
  protected zzjr zzws = zzjr.zzih();
  private int zzwt = -1;
  
  private static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzgj<MessageType, T> paramzzgj)
  {
    return (zzg)paramzzgj;
  }
  
  public static <ContainingType extends zzih, Type> zzg<ContainingType, Type> zza(ContainingType paramContainingType, zzih paramzzih, zzha<?> paramzzha, int paramInt, zzkf paramzzkf, boolean paramBoolean, Class paramClass)
  {
    return new zzg(paramContainingType, Collections.emptyList(), paramzzih, new zzd(null, 202056002, paramzzkf, true, false), paramClass);
  }
  
  protected static <T extends zzgx<T, ?>> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzhh
  {
    return zzb(zza(paramT, paramArrayOfByte, 0, paramArrayOfByte.length, zzgi.zzfm()));
  }
  
  private static <T extends zzgx<T, ?>> T zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgi paramzzgi)
    throws zzhh
  {
    paramT = (zzgx)paramT.zza(zzf.zzxd, null, null);
    try
    {
      zziw localzziw = zzis.zzhp().zzv(paramT);
      zzfg localzzfg = new com/google/android/gms/internal/vision/zzfg;
      localzzfg.<init>(paramzzgi);
      localzziw.zza(paramT, paramArrayOfByte, 0, paramInt2, localzzfg);
      localzziw.zzh(paramT);
      if (paramT.zzrx == 0) {
        return paramT;
      }
      paramArrayOfByte = new java/lang/RuntimeException;
      paramArrayOfByte.<init>();
      throw paramArrayOfByte;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw zzhh.zzgn().zzg(paramT);
    }
    catch (IOException paramArrayOfByte)
    {
      if ((paramArrayOfByte.getCause() instanceof zzhh)) {
        throw ((zzhh)paramArrayOfByte.getCause());
      }
      throw new zzhh(paramArrayOfByte.getMessage()).zzg(paramT);
    }
  }
  
  protected static <T extends zzgx<T, ?>> T zza(T paramT, byte[] paramArrayOfByte, zzgi paramzzgi)
    throws zzhh
  {
    return zzb(zza(paramT, paramArrayOfByte, 0, paramArrayOfByte.length, paramzzgi));
  }
  
  protected static <E> zzhe<E> zza(zzhe<E> paramzzhe)
  {
    int i = paramzzhe.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    }
    return paramzzhe.zzah(i);
  }
  
  protected static Object zza(zzih paramzzih, String paramString, Object[] paramArrayOfObject)
  {
    return new zziu(paramzzih, paramString, paramArrayOfObject);
  }
  
  static Object zza(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static <T extends zzgx<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzwu.put(paramClass, paramT);
  }
  
  protected static final <T extends zzgx<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zzf.zzxa, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzis.zzhp().zzv(paramT).zzu(paramT);
    if (paramBoolean)
    {
      i = zzf.zzxb;
      T ?;
      if (bool) {
        ? = paramT;
      } else {
        ? = null;
      }
      paramT.zza(i, ?, null);
    }
    return bool;
  }
  
  private static <T extends zzgx<T, ?>> T zzb(T paramT)
    throws zzhh
  {
    if ((paramT != null) && (!paramT.isInitialized())) {
      throw new zzhh(new zzjp(paramT).getMessage()).zzg(paramT);
    }
    return paramT;
  }
  
  static <T extends zzgx<?, ?>> T zzd(Class<T> paramClass)
  {
    Object localObject1 = (zzgx)zzwu.get(paramClass);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localObject2 = (zzgx)zzwu.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (zzgx)((zzgx)zzju.zzh(paramClass)).zza(zzf.zzxf, null, null);
      if (localObject1 != null) {
        zzwu.put(paramClass, localObject1);
      } else {
        throw new IllegalStateException();
      }
    }
    return (T)localObject1;
  }
  
  protected static zzhc zzgh()
  {
    return zzgz.zzgm();
  }
  
  protected static <E> zzhe<E> zzgi()
  {
    return zziv.zzhs();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    return zzis.zzhp().zzv(this).equals(this, (zzgx)paramObject);
  }
  
  public int hashCode()
  {
    int i = this.zzrx;
    if (i != 0) {
      return i;
    }
    i = zzis.zzhp().zzv(this).hashCode(this);
    this.zzrx = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return zza(this, true);
  }
  
  public String toString()
  {
    return zzii.zza(this, super.toString());
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  final void zzae(int paramInt)
  {
    this.zzwt = paramInt;
  }
  
  public final void zzb(zzgf paramzzgf)
    throws IOException
  {
    zzis.zzhp().zzv(this).zza(this, zzgh.zza(paramzzgf));
  }
  
  final int zzdm()
  {
    return this.zzwt;
  }
  
  protected final <MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzgf()
  {
    return (zza)zza(zzf.zzxe, null, null);
  }
  
  public final int zzgg()
  {
    if (this.zzwt == -1) {
      this.zzwt = zzis.zzhp().zzv(this).zzs(this);
    }
    return this.zzwt;
  }
  
  public static class zza<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
    extends zzfb<MessageType, BuilderType>
  {
    private final MessageType zzwp;
    protected MessageType zzwq;
    protected boolean zzwr;
    
    protected zza(MessageType paramMessageType)
    {
      this.zzwp = paramMessageType;
      this.zzwq = ((zzgx)paramMessageType.zza(zzgx.zzf.zzxd, null, null));
      this.zzwr = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzis.zzhp().zzv(paramMessageType1).zzd(paramMessageType1, paramMessageType2);
    }
    
    private final BuilderType zzb(zzfy paramzzfy, zzgi paramzzgi)
      throws IOException
    {
      if (this.zzwr)
      {
        zzfz();
        this.zzwr = false;
      }
      try
      {
        zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, zzgd.zza(paramzzfy), paramzzgi);
        return this;
      }
      catch (RuntimeException paramzzfy)
      {
        if ((paramzzfy.getCause() instanceof IOException)) {
          throw ((IOException)paramzzfy.getCause());
        }
        throw paramzzfy;
      }
    }
    
    private final BuilderType zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgi paramzzgi)
      throws zzhh
    {
      if (this.zzwr)
      {
        zzfz();
        this.zzwr = false;
      }
      try
      {
        zziw localzziw = zzis.zzhp().zzv(this.zzwq);
        zzgx localzzgx = this.zzwq;
        zzfg localzzfg = new com/google/android/gms/internal/vision/zzfg;
        localzzfg.<init>(paramzzgi);
        localzziw.zza(localzzgx, paramArrayOfByte, 0, paramInt2 + 0, localzzfg);
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading from byte array should not throw IOException.", paramArrayOfByte);
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw zzhh.zzgn();
      }
      catch (zzhh paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
    
    public final boolean isInitialized()
    {
      return zzgx.zza(this.zzwq, false);
    }
    
    public final BuilderType zza(MessageType paramMessageType)
    {
      if (this.zzwr)
      {
        zzfz();
        this.zzwr = false;
      }
      zza(this.zzwq, paramMessageType);
      return this;
    }
    
    protected void zzfz()
    {
      zzgx localzzgx = (zzgx)this.zzwq.zza(zzgx.zzf.zzxd, null, null);
      zza(localzzgx, this.zzwq);
      this.zzwq = localzzgx;
    }
    
    public MessageType zzga()
    {
      if (this.zzwr) {
        return this.zzwq;
      }
      zzgx localzzgx = this.zzwq;
      zzis.zzhp().zzv(localzzgx).zzh(localzzgx);
      this.zzwr = true;
      return this.zzwq;
    }
    
    public final MessageType zzgb()
    {
      zzgx localzzgx = (zzgx)zzgc();
      if (localzzgx.isInitialized()) {
        return localzzgx;
      }
      throw new zzjp(localzzgx);
    }
  }
  
  public static class zzb<MessageType extends zzgx.zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
    extends zzgx.zza<MessageType, BuilderType>
    implements zzij
  {
    protected zzb(MessageType paramMessageType)
    {
      super();
    }
    
    protected void zzfz()
    {
      super.zzfz();
      zzgx localzzgx = this.zzwq;
      ((zzgx.zze)localzzgx).zzwz = ((zzgn)((zzgx.zze)localzzgx).zzwz.clone());
    }
  }
  
  public static final class zzc<T extends zzgx<T, ?>>
    extends zzfd<T>
  {
    private final T zzwp;
    
    public zzc(T paramT)
    {
      this.zzwp = paramT;
    }
  }
  
  static final class zzd
    implements zzgp<zzd>
  {
    final int number = 202056002;
    final zzha<?> zzwv = null;
    final zzkf zzww;
    final boolean zzwx;
    final boolean zzwy;
    
    zzd(zzha<?> paramzzha, int paramInt, zzkf paramzzkf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.zzww = paramzzkf;
      this.zzwx = true;
      this.zzwy = false;
    }
    
    public final zzig zza(zzig paramzzig, zzih paramzzih)
    {
      return ((zzgx.zza)paramzzig).zza((zzgx)paramzzih);
    }
    
    public final zzim zza(zzim paramzzim1, zzim paramzzim2)
    {
      throw new UnsupportedOperationException();
    }
    
    public final int zzah()
    {
      return this.number;
    }
    
    public final zzkf zzft()
    {
      return this.zzww;
    }
    
    public final zzki zzfu()
    {
      return this.zzww.zziq();
    }
    
    public final boolean zzfv()
    {
      return this.zzwx;
    }
    
    public final boolean zzfw()
    {
      return this.zzwy;
    }
  }
  
  public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzgx.zzb<MessageType, BuilderType>>
    extends zzgx<MessageType, BuilderType>
    implements zzij
  {
    protected zzgn<zzgx.zzd> zzwz = zzgn.zzfo();
    
    public final <Type> Type zzc(zzgj<MessageType, Type> paramzzgj)
    {
      paramzzgj = zzgx.zzb(paramzzgj);
      if (paramzzgj.zzxo == (zzgx)zzge())
      {
        Object localObject1 = this.zzwz.zza(paramzzgj.zzxq);
        if (localObject1 == null) {
          return (Type)paramzzgj.zzgl;
        }
        Object localObject2 = paramzzgj.zzxq;
        if (((zzgx.zzd)localObject2).zzwx)
        {
          if (((zzgx.zzd)localObject2).zzww.zziq() == zzki.zzadd)
          {
            localObject2 = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((List)localObject2).add(paramzzgj.zzj(((Iterator)localObject1).next()));
            }
            return (Type)localObject2;
          }
          return (Type)localObject1;
        }
        return (Type)paramzzgj.zzj(localObject1);
      }
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
    
    final zzgn<zzgx.zzd> zzgl()
    {
      if (this.zzwz.isImmutable()) {
        this.zzwz = ((zzgn)this.zzwz.clone());
      }
      return this.zzwz;
    }
  }
  
  public static enum zzf
  {
    public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0()
    {
      return (int[])zzxh.clone();
    }
  }
  
  public static final class zzg<ContainingType extends zzih, Type>
    extends zzgj<ContainingType, Type>
  {
    final Type zzgl;
    final ContainingType zzxo;
    final zzih zzxp;
    final zzgx.zzd zzxq;
    
    zzg(ContainingType paramContainingType, Type paramType, zzih paramzzih, zzgx.zzd paramzzd, Class paramClass)
    {
      if (paramContainingType != null)
      {
        if ((paramzzd.zzww == zzkf.zzacl) && (paramzzih == null)) {
          throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.zzxo = paramContainingType;
        this.zzgl = paramType;
        this.zzxp = paramzzih;
        this.zzxq = paramzzd;
        return;
      }
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
    
    final Object zzj(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.zzxq.zzww.zziq() == zzki.zzadd) {
        localObject = this.zzxq.zzwv.zzh(((Integer)paramObject).intValue());
      }
      return localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */