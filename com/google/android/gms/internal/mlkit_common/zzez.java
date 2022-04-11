package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzez<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
  extends zzdq<MessageType, BuilderType>
{
  private static Map<Object, zzez<?, ?>> zzd = new ConcurrentHashMap();
  protected zzhp zzb = zzhp.zza();
  private int zzc = -1;
  
  static <T extends zzez<?, ?>> T zza(Class<T> paramClass)
  {
    Object localObject1 = (zzez)zzd.get(paramClass);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localObject2 = (zzez)zzd.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (zzez)((zzez)zzhw.zza(paramClass)).zza(zzf.zzf, null, null);
      if (localObject1 != null) {
        zzd.put(paramClass, localObject1);
      } else {
        throw new IllegalStateException();
      }
    }
    return (T)localObject1;
  }
  
  protected static Object zza(zzgh paramzzgh, String paramString, Object[] paramArrayOfObject)
  {
    return new zzgv(paramzzgh, paramString, paramArrayOfObject);
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
  
  protected static <T extends zzez<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzd.put(paramClass, paramT);
  }
  
  protected static final <T extends zzez<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zzf.zza, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzgt.zza().zza(paramT).zzd(paramT);
    if (paramBoolean)
    {
      i = zzf.zzb;
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
  
  protected static zzfg zzk()
  {
    return zzfa.zzd();
  }
  
  protected static <E> zzfi<E> zzl()
  {
    return zzgw.zzd();
  }
  
  public final boolean a_()
  {
    return zza(this, true);
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
    return zzgt.zza().zza(this).zza(this, (zzez)paramObject);
  }
  
  public int hashCode()
  {
    int i = this.zza;
    if (i != 0) {
      return i;
    }
    i = zzgt.zza().zza(this).zza(this);
    this.zza = i;
    return i;
  }
  
  public String toString()
  {
    return zzgm.zza(this, super.toString());
  }
  
  protected final <MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType paramMessageType)
  {
    return zzh().zza(paramMessageType);
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  final void zza(int paramInt)
  {
    this.zzc = paramInt;
  }
  
  public final void zza(zzem paramzzem)
    throws IOException
  {
    zzgt.zza().zza(this).zza(this, zzeo.zza(paramzzem));
  }
  
  final int zzg()
  {
    return this.zzc;
  }
  
  protected final <MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzh()
  {
    return (zza)zza(zzf.zze, null, null);
  }
  
  public final int zzj()
  {
    if (this.zzc == -1) {
      this.zzc = zzgt.zza().zza(this).zzb(this);
    }
    return this.zzc;
  }
  
  public static class zza<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
    extends zzdp<MessageType, BuilderType>
  {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;
    
    protected zza(MessageType paramMessageType)
    {
      this.zzc = paramMessageType;
      this.zza = ((zzez)paramMessageType.zza(zzez.zzf.zzd, null, null));
      this.zzb = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzgt.zza().zza(paramMessageType1).zzb(paramMessageType1, paramMessageType2);
    }
    
    public final boolean a_()
    {
      return zzez.zza(this.zza, false);
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
      zzez localzzez = (zzez)this.zza.zza(zzez.zzf.zzd, null, null);
      zza(localzzez, this.zza);
      this.zza = localzzez;
    }
    
    public MessageType zze()
    {
      if (this.zzb) {
        return this.zza;
      }
      zzez localzzez = this.zza;
      zzgt.zza().zza(localzzez).zzc(localzzez);
      this.zzb = true;
      return this.zza;
    }
    
    public final MessageType zzf()
    {
      zzez localzzez = (zzez)zzg();
      if (localzzez.a_()) {
        return localzzez;
      }
      throw new zzhn(localzzez);
    }
  }
  
  public static class zzb<MessageType extends zzez.zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
    extends zzez.zza<MessageType, BuilderType>
    implements zzgj
  {
    protected zzb(MessageType paramMessageType)
    {
      super();
    }
    
    protected void zzc()
    {
      super.zzc();
      zzez localzzez = this.zza;
      ((zzez.zze)localzzez).zzc = ((zzer)((zzez.zze)localzzez).zzc.clone());
    }
  }
  
  public static final class zzc<T extends zzez<T, ?>>
    extends zzdr<T>
  {
    private final T zza;
    
    public zzc(T paramT)
    {
      this.zza = paramT;
    }
  }
  
  static final class zzd
    implements zzet<zzd>
  {
    public final int zza()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzgk zza(zzgk paramzzgk, zzgh paramzzgh)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzgn zza(zzgn paramzzgn1, zzgn paramzzgn2)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzie zzb()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzih zzc()
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
  
  public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzez.zzb<MessageType, BuilderType>>
    extends zzez<MessageType, BuilderType>
    implements zzgj
  {
    protected zzer<zzez.zzd> zzc = zzer.zza();
  }
  
  public static enum zzf
  {
    public static int[] zza()
    {
      return (int[])zzl.clone();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */