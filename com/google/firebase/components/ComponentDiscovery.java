package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ComponentDiscovery<T>
{
  private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
  private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
  static final String TAG = "ComponentDiscovery";
  private final T context;
  private final RegistrarNameRetriever<T> retriever;
  
  @VisibleForTesting
  ComponentDiscovery(T paramT, RegistrarNameRetriever<T> paramRegistrarNameRetriever)
  {
    this.context = paramT;
    this.retriever = paramRegistrarNameRetriever;
  }
  
  public static ComponentDiscovery<Context> forContext(Context paramContext, Class<? extends Service> paramClass)
  {
    return new ComponentDiscovery(paramContext, new MetadataRegistrarNameRetriever(paramClass, null));
  }
  
  @Nullable
  private static ComponentRegistrar instantiate(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString);
      if (ComponentRegistrar.class.isAssignableFrom((Class)localObject)) {
        return (ComponentRegistrar)((Class)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      }
      localObject = new com/google/firebase/components/InvalidRegistrarException;
      ((InvalidRegistrarException)localObject).<init>(String.format("Class %s is not an instance of %s", new Object[] { paramString, "com.google.firebase.components.ComponentRegistrar" }));
      throw ((Throwable)localObject);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[] { paramString }), localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[] { paramString }), localNoSuchMethodException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[] { paramString }), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[] { paramString }), localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[] { paramString }));
    }
    return null;
  }
  
  @Deprecated
  public List<ComponentRegistrar> discover()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.retriever.retrieve(this.context).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      try
      {
        localObject = instantiate((String)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      catch (InvalidRegistrarException localInvalidRegistrarException)
      {
        Log.w("ComponentDiscovery", "Invalid component registrar.", localInvalidRegistrarException);
      }
    }
    return localArrayList;
  }
  
  public List<Provider<ComponentRegistrar>> discoverLazy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.retriever.retrieve(this.context).iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new d((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  private static class MetadataRegistrarNameRetriever
    implements ComponentDiscovery.RegistrarNameRetriever<Context>
  {
    private final Class<? extends Service> discoveryService;
    
    private MetadataRegistrarNameRetriever(Class<? extends Service> paramClass)
    {
      this.discoveryService = paramClass;
    }
    
    private Bundle getMetadata(Context paramContext)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
        {
          Log.w("ComponentDiscovery", "Context has no PackageManager.");
          return null;
        }
        ComponentName localComponentName = new android/content/ComponentName;
        localComponentName.<init>(paramContext, this.discoveryService);
        paramContext = localPackageManager.getServiceInfo(localComponentName, 128);
        if (paramContext == null)
        {
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          paramContext.append(this.discoveryService);
          paramContext.append(" has no service info.");
          Log.w("ComponentDiscovery", paramContext.toString());
          return null;
        }
        paramContext = paramContext.metaData;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("ComponentDiscovery", "Application info not found.");
      }
      return null;
    }
    
    public List<String> retrieve(Context paramContext)
    {
      Bundle localBundle = getMetadata(paramContext);
      if (localBundle == null)
      {
        Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      paramContext = localBundle.keySet().iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        if (("com.google.firebase.components.ComponentRegistrar".equals(localBundle.get(str))) && (str.startsWith("com.google.firebase.components:"))) {
          localArrayList.add(str.substring(31));
        }
      }
      return localArrayList;
    }
  }
  
  @VisibleForTesting
  static abstract interface RegistrarNameRetriever<T>
  {
    public abstract List<String> retrieve(T paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\ComponentDiscovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */