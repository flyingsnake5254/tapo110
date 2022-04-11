package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzek<MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
  extends zzda<MessageType, BuilderType>
{
  private static Map<Object, zzek<?, ?>> zzd = new ConcurrentHashMap();
  protected zzhd zzb = zzhd.zza();
  private int zzc = -1;
  
  static <T extends zzek<?, ?>> T zza(Class<T> paramClass)
  {
    Object localObject1 = (zzek)zzd.get(paramClass);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localObject2 = (zzek)zzd.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (zzek)((zzek)zzhg.zza(paramClass)).zza(zze.zzf, null, null);
      if (localObject1 != null) {
        zzd.put(paramClass, localObject1);
      } else {
        throw new IllegalStateException();
      }
    }
    return (T)localObject1;
  }
  
  protected static Object zza(zzfv paramzzfv, String paramString, Object[] paramArrayOfObject)
  {
    return new zzgj(paramzzfv, paramString, paramArrayOfObject);
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
  
  protected static <T extends zzek<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzd.put(paramClass, paramT);
  }
  
  protected static final <T extends zzek<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zze.zza, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzgh.zza().zza(paramT).zzc(paramT);
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
  
  protected static zzeq zzk()
  {
    return zzen.zzd();
  }
  
  protected static <E> zzes<E> zzl()
  {
    return zzgg.zzd();
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
    return zzgh.zza().zza(this).zza(this, (zzek)paramObject);
  }
  
  public int hashCode()
  {
    int i = this.zza;
    if (i != 0) {
      return i;
    }
    i = zzgh.zza().zza(this).zza(this);
    this.zza = i;
    return i;
  }
  
  public String toString()
  {
    return zzfw.zza(this, super.toString());
  }
  
  protected final <MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zza(MessageType paramMessageType)
  {
    return zzh().zza(paramMessageType);
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  final void zza(int paramInt)
  {
    this.zzc = paramInt;
  }
  
  public final void zza(zzdw paramzzdw)
    throws IOException
  {
    zzgh.zza().zza(this).zza(this, zzdz.zza(paramzzdw));
  }
  
  final int zzg()
  {
    return this.zzc;
  }
  
  protected final <MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzh()
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
      this.zzc = zzgh.zza().zza(this).zzd(this);
    }
    return this.zzc;
  }
  
  public static final class zza<T extends zzek<T, ?>>
    extends zzdf<T>
  {
    private final T zza;
    
    public zza(T paramT)
    {
      this.zza = paramT;
    }
  }
  
  public static class zzb<MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
    extends zzdd<MessageType, BuilderType>
  {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;
    
    protected zzb(MessageType paramMessageType)
    {
      this.zzc = paramMessageType;
      this.zza = ((zzek)paramMessageType.zza(zzek.zze.zzd, null, null));
      this.zzb = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzgh.zza().zza(paramMessageType1).zzb(paramMessageType1, paramMessageType2);
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
      zzek localzzek = (zzek)this.zza.zza(zzek.zze.zzd, null, null);
      zza(localzzek, this.zza);
      this.zza = localzzek;
    }
    
    public MessageType zzd()
    {
      if (this.zzb) {
        return this.zza;
      }
      zzek localzzek = this.zza;
      zzgh.zza().zza(localzzek).zzb(localzzek);
      this.zzb = true;
      return this.zza;
    }
    
    public final MessageType zze()
    {
      zzek localzzek = (zzek)zzf();
      if (localzzek.zzi()) {
        return localzzek;
      }
      throw new zzhb(localzzek);
    }
    
    public final boolean zzi()
    {
      return zzek.zza(this.zza, false);
    }
  }
  
  public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzek.zzd<MessageType, BuilderType>>
    extends zzek<MessageType, BuilderType>
    implements zzfx
  {
    protected zzef<zzek.zzf> zzc = zzef.zza();
  }
  
  public static class zzd<MessageType extends zzek.zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>>
    extends zzek.zzb<MessageType, BuilderType>
    implements zzfx
  {
    protected zzd(MessageType paramMessageType)
    {
      super();
    }
    
    protected void zzc()
    {
      super.zzc();
      zzek localzzek = this.zza;
      ((zzek.zzc)localzzek).zzc = ((zzef)((zzek.zzc)localzzek).zzc.clone());
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
    implements zzeh<zzf>
  {
    public final int zza()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzfu zza(zzfu paramzzfu, zzfv paramzzfv)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzgb zza(zzgb paramzzgb1, zzgb paramzzgb2)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzho zzb()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzhv zzc()
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */