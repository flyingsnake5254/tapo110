package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class zzhk
{
  @GuardedBy("PhenotypeConstants.class")
  private static final ArrayMap<String, Uri> zza = new ArrayMap();
  
  public static Uri zza(String paramString)
  {
    try
    {
      ArrayMap localArrayMap = zza;
      Uri localUri = (Uri)localArrayMap.get("com.google.android.gms.measurement");
      paramString = localUri;
      if (localUri == null)
      {
        paramString = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        if (paramString.length() != 0) {
          paramString = "content://com.google.android.gms.phenotype/".concat(paramString);
        } else {
          paramString = new String("content://com.google.android.gms.phenotype/");
        }
        paramString = Uri.parse(paramString);
        localArrayMap.put("com.google.android.gms.measurement", paramString);
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */