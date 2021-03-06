package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Collection;

public class FlagRegistry
{
  private final Collection<Flag> zzg = new ArrayList();
  private final Collection<Flag.StringFlag> zzh = new ArrayList();
  private final Collection<Flag.StringFlag> zzi = new ArrayList();
  
  @KeepForSdk
  public static void initialize(Context paramContext)
  {
    Singletons.zzd().initialize(paramContext);
  }
  
  public final void zza(Flag paramFlag)
  {
    this.zzg.add(paramFlag);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\FlagRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */