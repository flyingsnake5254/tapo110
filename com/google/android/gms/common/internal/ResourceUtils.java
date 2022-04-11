package com.google.android.gms.common.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ResourceUtils
{
  private static final Uri zzet = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ResourceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */