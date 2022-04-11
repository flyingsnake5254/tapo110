package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class j
  implements e
{
  private final a a;
  private final h b;
  private final Map<String, l> c = new HashMap();
  
  j(Context paramContext, h paramh)
  {
    this(new a(paramContext), paramh);
  }
  
  j(a parama, h paramh)
  {
    this.a = parama;
    this.b = paramh;
  }
  
  @Nullable
  public l get(String paramString)
  {
    try
    {
      if (this.c.containsKey(paramString))
      {
        paramString = (l)this.c.get(paramString);
        return paramString;
      }
      Object localObject = this.a.b(paramString);
      if (localObject == null) {
        return null;
      }
      localObject = ((d)localObject).create(this.b.a(paramString));
      this.c.put(paramString, localObject);
      return (l)localObject;
    }
    finally {}
  }
  
  static class a
  {
    private final Context a;
    private Map<String, String> b = null;
    
    a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private Map<String, String> a(Context paramContext)
    {
      Bundle localBundle = d(paramContext);
      if (localBundle == null)
      {
        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
        return Collections.emptyMap();
      }
      paramContext = new HashMap();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = localBundle.get(str);
        if (((localObject instanceof String)) && (str.startsWith("backend:")))
        {
          String[] arrayOfString = ((String)localObject).split(",", -1);
          int i = arrayOfString.length;
          for (int j = 0; j < i; j++)
          {
            localObject = arrayOfString[j].trim();
            if (!((String)localObject).isEmpty()) {
              paramContext.put(localObject, str.substring(8));
            }
          }
        }
      }
      return paramContext;
    }
    
    private Map<String, String> c()
    {
      if (this.b == null) {
        this.b = a(this.a);
      }
      return this.b;
    }
    
    private static Bundle d(Context paramContext)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
        {
          Log.w("BackendRegistry", "Context has no PackageManager.");
          return null;
        }
        ComponentName localComponentName = new android/content/ComponentName;
        localComponentName.<init>(paramContext, TransportBackendDiscovery.class);
        paramContext = localPackageManager.getServiceInfo(localComponentName, 128);
        if (paramContext == null)
        {
          Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
          return null;
        }
        paramContext = paramContext.metaData;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("BackendRegistry", "Application info not found.");
      }
      return null;
    }
    
    @Nullable
    d b(String paramString)
    {
      paramString = (String)c().get(paramString);
      if (paramString == null) {
        return null;
      }
      try
      {
        d locald = (d)Class.forName(paramString).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return locald;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localInvocationTargetException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localNoSuchMethodException);
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localIllegalAccessException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[] { paramString }), localClassNotFoundException);
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */