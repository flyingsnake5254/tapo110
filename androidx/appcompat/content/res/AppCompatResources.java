package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources
{
  private static final String LOG_TAG = "AppCompatResources";
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  private static final Object sColorStateCacheLock = new Object();
  private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap(0);
  
  private static void addColorStateListToCache(@NonNull Context paramContext, @ColorRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    synchronized (sColorStateCacheLock)
    {
      WeakHashMap localWeakHashMap = sColorStateCaches;
      Object localObject2 = (SparseArray)localWeakHashMap.get(paramContext);
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new android/util/SparseArray;
        ((SparseArray)localObject3).<init>();
        localWeakHashMap.put(paramContext, localObject3);
      }
      localObject2 = new androidx/appcompat/content/res/AppCompatResources$ColorStateListCacheEntry;
      ((ColorStateListCacheEntry)localObject2).<init>(paramColorStateList, paramContext.getResources().getConfiguration());
      ((SparseArray)localObject3).append(paramInt, localObject2);
      return;
    }
  }
  
  @Nullable
  private static ColorStateList getCachedColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    synchronized (sColorStateCacheLock)
    {
      SparseArray localSparseArray = (SparseArray)sColorStateCaches.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        ColorStateListCacheEntry localColorStateListCacheEntry = (ColorStateListCacheEntry)localSparseArray.get(paramInt);
        if (localColorStateListCacheEntry != null)
        {
          if (localColorStateListCacheEntry.configuration.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = localColorStateListCacheEntry.value;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  public static ColorStateList getColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    ColorStateList localColorStateList = getCachedColorStateList(paramContext, paramInt);
    if (localColorStateList != null) {
      return localColorStateList;
    }
    localColorStateList = inflateColorStateList(paramContext, paramInt);
    if (localColorStateList != null)
    {
      addColorStateListToCache(paramContext, paramInt, localColorStateList);
      return localColorStateList;
    }
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    return ResourceManagerInternal.get().getDrawable(paramContext, paramInt);
  }
  
  @NonNull
  private static TypedValue getTypedValue()
  {
    ThreadLocal localThreadLocal = TL_TYPED_VALUE;
    TypedValue localTypedValue1 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue2 = localTypedValue1;
    if (localTypedValue1 == null)
    {
      localTypedValue2 = new TypedValue();
      localThreadLocal.set(localTypedValue2);
    }
    return localTypedValue2;
  }
  
  @Nullable
  private static ColorStateList inflateColorStateList(Context paramContext, int paramInt)
  {
    if (isColorInt(paramContext, paramInt)) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
    try
    {
      paramContext = ColorStateListInflaterCompat.createFromXml(localResources, localXmlResourceParser, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", paramContext);
    }
    return null;
  }
  
  private static boolean isColorInt(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = getTypedValue();
    boolean bool = true;
    paramContext.getValue(paramInt, localTypedValue, true);
    paramInt = localTypedValue.type;
    if ((paramInt < 28) || (paramInt > 31)) {
      bool = false;
    }
    return bool;
  }
  
  private static class ColorStateListCacheEntry
  {
    final Configuration configuration;
    final ColorStateList value;
    
    ColorStateListCacheEntry(@NonNull ColorStateList paramColorStateList, @NonNull Configuration paramConfiguration)
    {
      this.value = paramColorStateList;
      this.configuration = paramConfiguration;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\content\res\AppCompatResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */