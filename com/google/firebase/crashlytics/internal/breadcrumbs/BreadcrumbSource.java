package com.google.firebase.crashlytics.internal.breadcrumbs;

import androidx.annotation.Nullable;

public abstract interface BreadcrumbSource
{
  public abstract void registerBreadcrumbHandler(@Nullable BreadcrumbHandler paramBreadcrumbHandler);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\breadcrumbs\BreadcrumbSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */