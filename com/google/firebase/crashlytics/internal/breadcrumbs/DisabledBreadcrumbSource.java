package com.google.firebase.crashlytics.internal.breadcrumbs;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;

public class DisabledBreadcrumbSource
  implements BreadcrumbSource
{
  public void registerBreadcrumbHandler(@Nullable BreadcrumbHandler paramBreadcrumbHandler)
  {
    Logger.getLogger().d("Could not register handler for breadcrumbs events.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\breadcrumbs\DisabledBreadcrumbSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */