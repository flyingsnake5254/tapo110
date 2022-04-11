package com.google.android.gms.internal.vision;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.vision.L;

public final class zzw
{
  @Nullable
  public static DynamiteModule zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = String.format("%s.%s", new Object[] { "com.google.android.gms.vision", paramString });
    if (!paramBoolean) {
      paramString = "com.google.android.gms.vision.dynamite";
    }
    Object localObject = null;
    try
    {
      L.d("Loading module %s", new Object[] { paramString });
      DynamiteModule.VersionPolicy localVersionPolicy;
      if (paramBoolean) {
        localVersionPolicy = DynamiteModule.PREFER_REMOTE;
      } else {
        localVersionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
      }
      paramContext = DynamiteModule.load(paramContext, localVersionPolicy, paramString);
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      L.e(paramContext, "Error loading module %s optional module %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      paramContext = (Context)localObject;
    }
    return paramContext;
  }
  
  public static boolean zza(Context paramContext, String paramString)
  {
    return DynamiteModule.getLocalVersion(paramContext, paramString) > DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.vision.dynamite");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */