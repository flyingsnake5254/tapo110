package com.google.android.gms.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zza
{
  private static final ConcurrentHashMap<Uri, zza> zzg = new ConcurrentHashMap();
  private static final String[] zzl = { "key", "value" };
  private final Uri uri;
  private final ContentResolver zzh;
  private final ContentObserver zzi;
  private final Object zzj = new Object();
  private volatile Map<String, String> zzk;
  
  private zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.zzh = paramContentResolver;
    this.uri = paramUri;
    this.zzi = new zzb(this, null);
  }
  
  public static zza zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    ConcurrentHashMap localConcurrentHashMap = zzg;
    zza localzza = (zza)localConcurrentHashMap.get(paramUri);
    Object localObject = localzza;
    if (localzza == null)
    {
      localObject = new zza(paramContentResolver, paramUri);
      paramContentResolver = (zza)localConcurrentHashMap.putIfAbsent(paramUri, localObject);
      if (paramContentResolver == null) {
        ((zza)localObject).zzh.registerContentObserver(((zza)localObject).uri, false, ((zza)localObject).zzi);
      } else {
        localObject = paramContentResolver;
      }
    }
    return (zza)localObject;
  }
  
  private final Map<String, String> zzc()
  {
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.zzh.query(this.uri, zzl, null, null, null);
    if (localCursor != null) {
      try
      {
        while (localCursor.moveToNext()) {
          localHashMap.put(localCursor.getString(0), localCursor.getString(1));
        }
        localCursor.close();
      }
      finally
      {
        localCursor.close();
      }
    }
    return localMap;
  }
  
  public final Map<String, String> zza()
  {
    Object localObject1;
    if (PhenotypeFlag.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false)) {
      localObject1 = zzc();
    } else {
      localObject1 = this.zzk;
    }
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      synchronized (this.zzj)
      {
        localObject3 = this.zzk;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = zzc();
          this.zzk = ((Map)localObject1);
        }
        localObject3 = localObject1;
      }
    }
    return (Map<String, String>)localObject3;
  }
  
  public final void zzb()
  {
    synchronized (this.zzj)
    {
      this.zzk = null;
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */