package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class zzbg
{
  @GuardedBy("PhenotypeConstants.class")
  private static final ArrayMap<String, Uri> zzgc = new ArrayMap();
  
  public static Uri getContentProviderUri(String paramString)
  {
    try
    {
      ArrayMap localArrayMap = zzgc;
      Uri localUri = (Uri)localArrayMap.get(paramString);
      Object localObject = localUri;
      if (localUri == null)
      {
        localObject = String.valueOf(Uri.encode(paramString));
        if (((String)localObject).length() != 0) {
          localObject = "content://com.google.android.gms.phenotype/".concat((String)localObject);
        } else {
          localObject = new String("content://com.google.android.gms.phenotype/");
        }
        localObject = Uri.parse((String)localObject);
        localArrayMap.put(paramString, localObject);
      }
      return (Uri)localObject;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */