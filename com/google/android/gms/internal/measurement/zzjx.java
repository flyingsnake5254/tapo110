package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzjx<T extends zzjp>
{
  private static final Logger zza = Logger.getLogger(zzjk.class.getName());
  private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
  
  static <T extends zzjp> T zzb(Class<T> paramClass)
  {
    ClassLoader localClassLoader = zzjx.class.getClassLoader();
    Object localObject1;
    if (paramClass.equals(zzjp.class))
    {
      localObject1 = zzb;
    }
    else
    {
      if (!paramClass.getPackage().equals(zzjx.class.getPackage())) {
        break label353;
      }
      localObject1 = String.format("%s.BlazeGenerated%sLoader", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() });
    }
    try
    {
      localObject1 = Class.forName((String)localObject1, true, localClassLoader);
      Object localObject2;
      try
      {
        localObject1 = (zzjx)((Class)localObject1).getConstructor(new Class[0]).newInstance(new Object[0]);
        return (zzjp)paramClass.cast(((zzjx)localObject1).zza());
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localObject1 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject1).<init>(localInvocationTargetException);
        throw ((Throwable)localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localObject1 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject1).<init>(localIllegalAccessException);
        throw ((Throwable)localObject1);
      }
      catch (InstantiationException localInstantiationException)
      {
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>(localInstantiationException);
        throw ((Throwable)localObject2);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>(localNoSuchMethodException);
        throw ((Throwable)localObject2);
      }
      Iterator localIterator;
      Logger localLogger;
      Level localLevel;
      String str;
      throw new IllegalArgumentException(paramClass.getName());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localIterator = ServiceLoader.load(zzjx.class, localClassLoader).iterator();
      localObject2 = new ArrayList();
      while (localIterator.hasNext()) {
        try
        {
          ((ArrayList)localObject2).add(paramClass.cast(((zzjx)localIterator.next()).zza()));
        }
        catch (ServiceConfigurationError localServiceConfigurationError)
        {
          localLogger = zza;
          localLevel = Level.SEVERE;
          str = paramClass.getSimpleName();
          if (str.length() != 0) {
            str = "Unable to load ".concat(str);
          } else {
            str = new String("Unable to load ");
          }
          localLogger.logp(localLevel, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", str, localServiceConfigurationError);
        }
      }
      if (((ArrayList)localObject2).size() == 1) {
        return (zzjp)((ArrayList)localObject2).get(0);
      }
      if (((ArrayList)localObject2).size() == 0) {
        return null;
      }
      try
      {
        paramClass = (zzjp)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { localObject2 });
        return paramClass;
      }
      catch (InvocationTargetException paramClass)
      {
        throw new IllegalStateException(paramClass);
      }
      catch (IllegalAccessException paramClass)
      {
        throw new IllegalStateException(paramClass);
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new IllegalStateException(paramClass);
      }
    }
  }
  
  protected abstract T zza();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */