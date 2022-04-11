package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
public class StringResourceValueReader
{
  private final Resources zzeu;
  private final String zzev;
  
  public StringResourceValueReader(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getResources();
    this.zzeu = paramContext;
    this.zzev = paramContext.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  @Nullable
  @KeepForSdk
  public String getString(String paramString)
  {
    int i = this.zzeu.getIdentifier(paramString, "string", this.zzev);
    if (i == 0) {
      return null;
    }
    return this.zzeu.getString(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\StringResourceValueReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */