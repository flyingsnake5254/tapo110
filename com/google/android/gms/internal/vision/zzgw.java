package com.google.android.gms.internal.vision;

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

abstract class zzgw<T extends zzgi>
{
  private static final Logger logger = Logger.getLogger(zzgf.class.getName());
  private static String zzwo = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
  
  static <T extends zzgi> T zzc(Class<T> paramClass)
  {
    Object localObject1 = zzgw.class.getClassLoader();
    Object localObject2;
    if (paramClass.equals(zzgi.class))
    {
      localObject2 = zzwo;
    }
    else
    {
      if (!paramClass.getPackage().equals(zzgw.class.getPackage())) {
        break label352;
      }
      localObject2 = String.format("%s.BlazeGenerated%sLoader", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() });
    }
    try
    {
      localObject2 = Class.forName((String)localObject2, true, (ClassLoader)localObject1);
      try
      {
        localObject2 = (zzgw)((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]);
        return (zzgi)paramClass.cast(((zzgw)localObject2).zzfy());
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localIllegalStateException2 = new java/lang/IllegalStateException;
        localIllegalStateException2.<init>(localInvocationTargetException);
        throw localIllegalStateException2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        IllegalStateException localIllegalStateException2 = new java/lang/IllegalStateException;
        localIllegalStateException2.<init>(localIllegalAccessException);
        throw localIllegalStateException2;
      }
      catch (InstantiationException localInstantiationException)
      {
        localIllegalStateException1 = new java/lang/IllegalStateException;
        localIllegalStateException1.<init>(localInstantiationException);
        throw localIllegalStateException1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        IllegalStateException localIllegalStateException1 = new java/lang/IllegalStateException;
        localIllegalStateException1.<init>(localNoSuchMethodException);
        throw localIllegalStateException1;
      }
      Iterator localIterator;
      Logger localLogger;
      Level localLevel;
      String str;
      throw new IllegalArgumentException(paramClass.getName());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localIterator = ServiceLoader.load(zzgw.class, (ClassLoader)localObject1).iterator();
      localObject1 = new ArrayList();
      while (localIterator.hasNext()) {
        try
        {
          ((ArrayList)localObject1).add(paramClass.cast(((zzgw)localIterator.next()).zzfy()));
        }
        catch (ServiceConfigurationError localServiceConfigurationError)
        {
          localLogger = logger;
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
      if (((ArrayList)localObject1).size() == 1) {
        return (zzgi)((ArrayList)localObject1).get(0);
      }
      if (((ArrayList)localObject1).size() == 0) {
        return null;
      }
      try
      {
        paramClass = (zzgi)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { localObject1 });
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
  
  protected abstract T zzfy();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */