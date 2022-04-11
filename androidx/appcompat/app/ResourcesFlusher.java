package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher
{
  private static final String TAG = "ResourcesFlusher";
  private static Field sDrawableCacheField;
  private static boolean sDrawableCacheFieldFetched;
  private static Field sResourcesImplField;
  private static boolean sResourcesImplFieldFetched;
  private static Class<?> sThemedResourceCacheClazz;
  private static boolean sThemedResourceCacheClazzFetched;
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static void flush(@NonNull Resources paramResources)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return;
    }
    if (i >= 24) {
      flushNougats(paramResources);
    } else if (i >= 23) {
      flushMarshmallows(paramResources);
    } else if (i >= 21) {
      flushLollipops(paramResources);
    }
  }
  
  @RequiresApi(21)
  private static void flushLollipops(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        Field localField1 = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField2 = sDrawableCacheField;
    if (localField2 != null)
    {
      Object localObject = null;
      try
      {
        paramResources = (Map)localField2.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        paramResources = (Resources)localObject;
      }
      if (paramResources != null) {
        paramResources.clear();
      }
    }
  }
  
  @RequiresApi(23)
  private static void flushMarshmallows(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        Field localField1 = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Object localObject2 = null;
    Field localField2 = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField2 != null) {
      try
      {
        localObject1 = localField2.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      return;
    }
    flushThemedResourcesCache(localObject1);
  }
  
  @RequiresApi(24)
  private static void flushNougats(@NonNull Resources paramResources)
  {
    if (!sResourcesImplFieldFetched)
    {
      try
      {
        Field localField1 = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
      }
      sResourcesImplFieldFetched = true;
    }
    Field localField2 = sResourcesImplField;
    if (localField2 == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      paramResources = localField2.get(paramResources);
    }
    catch (IllegalAccessException paramResources)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
      paramResources = null;
    }
    if (paramResources == null) {
      return;
    }
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        localField2 = paramResources.getClass().getDeclaredField("mDrawableCache");
        sDrawableCacheField = localField2;
        localField2.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField3 = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField3 != null) {
      try
      {
        localObject1 = localField3.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      flushThemedResourcesCache(localObject1);
    }
  }
  
  @RequiresApi(16)
  private static void flushThemedResourcesCache(@NonNull Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched)
    {
      try
      {
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      sThemedResourceCacheClazzFetched = true;
    }
    Object localObject1 = sThemedResourceCacheClazz;
    if (localObject1 == null) {
      return;
    }
    if (!sThemedResourceCache_mUnthemedEntriesFieldFetched)
    {
      try
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mUnthemedEntries");
        sThemedResourceCache_mUnthemedEntriesField = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
      }
      sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    }
    Field localField = sThemedResourceCache_mUnthemedEntriesField;
    if (localField == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      paramObject = (LongSparseArray)localField.get(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)paramObject);
      paramObject = localObject2;
    }
    if (paramObject != null) {
      ((LongSparseArray)paramObject).clear();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\app\ResourcesFlusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */