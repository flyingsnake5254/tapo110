package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzga<MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
  extends zzer<MessageType, BuilderType>
{
  private static Map<Object, zzga<?, ?>> zzd = new ConcurrentHashMap();
  protected zzis zzb = zzis.zza();
  private int zzc = -1;
  
  static <T extends zzga<?, ?>> T zza(Class<T> paramClass)
  {
    Object localObject1 = (zzga)zzd.get(paramClass);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localObject2 = (zzga)zzd.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (zzga)((zzga)zziz.zza(paramClass)).zza(zze.zzf, null, null);
      if (localObject1 != null) {
        zzd.put(paramClass, localObject1);
      } else {
        throw new IllegalStateException();
      }
    }
    return (T)localObject1;
  }
  
  protected static zzgj zza(zzgj paramzzgj)
  {
    int i = paramzzgj.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    }
    return paramzzgj.zzb(i);
  }
  
  protected static Object zza(zzhk paramzzhk, String paramString, Object[] paramArrayOfObject)
  {
    return new zzhy(paramzzhk, paramString, paramArrayOfObject);
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
  
  protected static <T extends zzga<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzd.put(paramClass, paramT);
  }
  
  protected static final <T extends zzga<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zze.zza, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzhw.zza().zza(paramT).zzd(paramT);
    if (paramBoolean)
    {
      i = zze.zzb;
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
  
  protected static zzgj zzk()
  {
    return zzgd.zzd();
  }
  
  protected static zzgg zzl()
  {
    return zzfy.zzd();
  }
  
  protected static <E> zzgl<E> zzm()
  {
    return zzhz.zzd();
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
    return zzhw.zza().zza(this).zza(this, (zzga)paramObject);
  }
  
  public int hashCode()
  {
    int i = this.zza;
    if (i != 0) {
      return i;
    }
    i = zzhw.zza().zza(this).zza(this);
    this.zza = i;
    return i;
  }
  
  public String toString()
  {
    return zzhp.zza(this, super.toString());
  }
  
  protected final <MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zza(MessageType paramMessageType)
  {
    return zzh().zza(paramMessageType);
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  final void zza(int paramInt)
  {
    this.zzc = paramInt;
  }
  
  public final void zza(zzfn paramzzfn)
    throws IOException
  {
    zzhw.zza().zza(this).zza(this, zzfp.zza(paramzzfn));
  }
  
  final int zzg()
  {
    return this.zzc;
  }
  
  protected final <MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzh()
  {
    return (zzb)zza(zze.zze, null, null);
  }
  
  public final boolean zzi()
  {
    return zza(this, true);
  }
  
  public final int zzj()
  {
    if (this.zzc == -1) {
      this.zzc = zzhw.zza().zza(this).zzb(this);
    }
    return this.zzc;
  }
  
  public static final class zza<T extends zzga<T, ?>>
    extends zzes<T>
  {
    private final T zza;
    
    public zza(T paramT)
    {
      this.zza = paramT;
    }
  }
  
  public static class zzb<MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
    extends zzeq<MessageType, BuilderType>
  {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;
    
    protected zzb(MessageType paramMessageType)
    {
      this.zzc = paramMessageType;
      this.zza = ((zzga)paramMessageType.zza(zzga.zze.zzd, null, null));
      this.zzb = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzhw.zza().zza(paramMessageType1).zzb(paramMessageType1, paramMessageType2);
    }
    
    public final BuilderType zza(MessageType paramMessageType)
    {
      if (this.zzb)
      {
        zzc();
        this.zzb = false;
      }
      zza(this.zza, paramMessageType);
      return this;
    }
    
    protected void zzc()
    {
      zzga localzzga = (zzga)this.zza.zza(zzga.zze.zzd, null, null);
      zza(localzzga, this.zza);
      this.zza = localzzga;
    }
    
    public MessageType zzd()
    {
      if (this.zzb) {
        return this.zza;
      }
      zzga localzzga = this.zza;
      zzhw.zza().zza(localzzga).zzc(localzzga);
      this.zzb = true;
      return this.zza;
    }
    
    public final MessageType zze()
    {
      zzga localzzga = (zzga)zzf();
      if (localzzga.zzi()) {
        return localzzga;
      }
      throw new zziq(localzzga);
    }
    
    public final boolean zzi()
    {
      return zzga.zza(this.zza, false);
    }
  }
  
  public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzga.zzd<MessageType, BuilderType>>
    extends zzga<MessageType, BuilderType>
    implements zzhm
  {
    protected zzfs<zzga.zzf> zzc = zzfs.zza();
  }
  
  public static class zzd<MessageType extends zzga.zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>>
    extends zzga.zzb<MessageType, BuilderType>
    implements zzhm
  {
    protected zzd(MessageType paramMessageType)
    {
      super();
    }
    
    protected void zzc()
    {
      super.zzc();
      zzga localzzga = this.zza;
      ((zzga.zzc)localzzga).zzc = ((zzfs)((zzga.zzc)localzzga).zzc.clone());
    }
  }
  
  public static enum zze
  {
    public static int[] zza()
    {
      return (int[])zzl.clone();
    }
  }
  
  static final class zzf
    implements zzfu<zzf>
  {
    public final int zza()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzhn zza(zzhn paramzzhn, zzhk paramzzhk)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzhq zza(zzhq paramzzhq1, zzhq paramzzhq2)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzjh zzb()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzjk zzc()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zzd()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zze()
    {
      throw new NoSuchMethodError();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */