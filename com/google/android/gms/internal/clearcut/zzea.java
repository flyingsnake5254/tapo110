package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzea
{
  private static final zzea zznc = new zzea();
  private final zzeg zznd;
  private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();
  
  private zzea()
  {
    Object localObject1 = null;
    int i = 0;
    while (i <= 0)
    {
      localObject2 = zzk(new String[] { "com.google.protobuf.AndroidProto3SchemaFactory" }[0]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      i++;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new zzdd();
    }
    this.zznd = ((zzeg)localObject2);
  }
  
  public static zzea zzcm()
  {
    return zznc;
  }
  
  private static zzeg zzk(String paramString)
  {
    try
    {
      paramString = (zzeg)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramString;
    }
    finally {}
    return null;
  }
  
  public final <T> zzef<T> zze(Class<T> paramClass)
  {
    zzci.zza(paramClass, "messageType");
    zzef localzzef = (zzef)this.zzne.get(paramClass);
    Object localObject = localzzef;
    if (localzzef == null)
    {
      localObject = this.zznd.zzd(paramClass);
      zzci.zza(paramClass, "messageType");
      zzci.zza(localObject, "schema");
      paramClass = (zzef)this.zzne.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zzef<T>)localObject;
  }
  
  public final <T> zzef<T> zzp(T paramT)
  {
    return zze(paramT.getClass());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */