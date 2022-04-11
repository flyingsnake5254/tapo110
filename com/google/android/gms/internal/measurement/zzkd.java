package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkd<MessageType extends zzkd<MessageType, BuilderType>, BuilderType extends zzjz<MessageType, BuilderType>>
  extends zzio<MessageType, BuilderType>
{
  private static final Map<Object, zzkd<?, ?>> zza = new ConcurrentHashMap();
  protected zzmi zzc = zzmi.zza();
  protected int zzd = -1;
  
  static Object zzbA(Method paramMethod, Object paramObject, Object... paramVarArgs)
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
  
  protected static zzki zzbB()
  {
    return zzke.zzd();
  }
  
  protected static zzkj zzbC()
  {
    return zzkx.zzf();
  }
  
  protected static zzkj zzbD(zzkj paramzzkj)
  {
    int i = paramzzkj.size();
    if (i == 0) {
      i = 10;
    } else {
      i += i;
    }
    return paramzzkj.zzd(i);
  }
  
  protected static <E> zzkk<E> zzbE()
  {
    return zzlr.zzd();
  }
  
  protected static <E> zzkk<E> zzbF(zzkk<E> paramzzkk)
  {
    int i = paramzzkk.size();
    if (i == 0) {
      i = 10;
    } else {
      i += i;
    }
    return paramzzkk.zze(i);
  }
  
  static <T extends zzkd> T zzbx(Class<T> paramClass)
  {
    Map localMap = zza;
    Object localObject1 = (zzkd)localMap.get(paramClass);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localObject2 = (zzkd)localMap.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (zzkd)((zzkd)zzmr.zzc(paramClass)).zzl(6, null, null);
      if (localObject1 != null) {
        localMap.put(paramClass, localObject1);
      } else {
        throw new IllegalStateException();
      }
    }
    return (T)localObject1;
  }
  
  protected static <T extends zzkd> void zzby(Class<T> paramClass, T paramT)
  {
    zza.put(paramClass, paramT);
  }
  
  protected static Object zzbz(zzli paramzzli, String paramString, Object[] paramArrayOfObject)
  {
    return new zzls(paramzzli, paramString, paramArrayOfObject);
  }
  
  public final boolean equals(Object paramObject)
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
    return zzlq.zza().zzb(getClass()).zzb(this, (zzkd)paramObject);
  }
  
  public final int hashCode()
  {
    int i = this.zzb;
    if (i != 0) {
      return i;
    }
    i = zzlq.zza().zzb(getClass()).zzc(this);
    this.zzb = i;
    return i;
  }
  
  public final String toString()
  {
    return zzlk.zza(this, super.toString());
  }
  
  final int zzbq()
  {
    return this.zzd;
  }
  
  final void zzbr(int paramInt)
  {
    this.zzd = paramInt;
  }
  
  protected final <MessageType extends zzkd<MessageType, BuilderType>, BuilderType extends zzjz<MessageType, BuilderType>> BuilderType zzbt()
  {
    return (zzjz)zzl(5, null, null);
  }
  
  public final BuilderType zzbu()
  {
    zzjz localzzjz = (zzjz)zzl(5, null, null);
    localzzjz.zzaB(this);
    return localzzjz;
  }
  
  public final void zzbv(zzjk paramzzjk)
    throws IOException
  {
    zzlq.zza().zzb(getClass()).zzm(this, zzjl.zza(paramzzjk));
  }
  
  public final int zzbw()
  {
    int i = this.zzd;
    int j = i;
    if (i == -1)
    {
      j = zzlq.zza().zzb(getClass()).zze(this);
      this.zzd = j;
    }
    return j;
  }
  
  protected abstract Object zzl(int paramInt, Object paramObject1, Object paramObject2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */