package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources
  extends Resources
{
  public static final int MAX_SDK_WHERE_REQUIRED = 20;
  private static boolean sCompatVectorFromResourcesEnabled = false;
  private final WeakReference<Context> mContextRef;
  
  public VectorEnabledTintResources(@NonNull Context paramContext, @NonNull Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mContextRef = new WeakReference(paramContext);
  }
  
  public static boolean isCompatVectorFromResourcesEnabled()
  {
    return sCompatVectorFromResourcesEnabled;
  }
  
  public static void setCompatVectorFromResourcesEnabled(boolean paramBoolean)
  {
    sCompatVectorFromResourcesEnabled = paramBoolean;
  }
  
  public static boolean shouldBeUsed()
  {
    boolean bool;
    if ((isCompatVectorFromResourcesEnabled()) && (Build.VERSION.SDK_INT <= 20)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)this.mContextRef.get();
    if (localContext != null) {
      return ResourceManagerInternal.get().onDrawableLoadedFromResources(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
  
  final Drawable superGetDrawable(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\VectorEnabledTintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */