package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzab
{
  private static final ConcurrentHashMap<Uri, zzab> zzde = new ConcurrentHashMap();
  private static final String[] zzdl = { "key", "value" };
  private final Uri uri;
  private final ContentResolver zzdf;
  private final ContentObserver zzdg;
  private final Object zzdh = new Object();
  private volatile Map<String, String> zzdi;
  private final Object zzdj = new Object();
  @GuardedBy("listenersLock")
  private final List<zzad> zzdk = new ArrayList();
  
  private zzab(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.zzdf = paramContentResolver;
    this.uri = paramUri;
    this.zzdg = new zzac(this, null);
  }
  
  public static zzab zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    ConcurrentHashMap localConcurrentHashMap = zzde;
    zzab localzzab = (zzab)localConcurrentHashMap.get(paramUri);
    Object localObject = localzzab;
    if (localzzab == null)
    {
      localObject = new zzab(paramContentResolver, paramUri);
      paramContentResolver = (zzab)localConcurrentHashMap.putIfAbsent(paramUri, localObject);
      if (paramContentResolver == null) {
        ((zzab)localObject).zzdf.registerContentObserver(((zzab)localObject).uri, false, ((zzab)localObject).zzdg);
      } else {
        localObject = paramContentResolver;
      }
    }
    return (zzab)localObject;
  }
  
  private final Map<String, String> zzi()
  {
    try
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      Cursor localCursor = this.zzdf.query(this.uri, zzdl, null, null, null);
      if (localCursor != null) {}
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
      return null;
    }
    catch (SecurityException|SQLiteException localSecurityException)
    {
      Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
    }
  }
  
  private final void zzj()
  {
    synchronized (this.zzdj)
    {
      Iterator localIterator = this.zzdk.iterator();
      while (localIterator.hasNext()) {
        ((zzad)localIterator.next()).zzk();
      }
      return;
    }
  }
  
  public final Map<String, String> zzg()
  {
    Object localObject1;
    if (zzae.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false)) {
      localObject1 = zzi();
    } else {
      localObject1 = this.zzdi;
    }
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      synchronized (this.zzdh)
      {
        localObject3 = this.zzdi;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = zzi();
          this.zzdi = ((Map)localObject1);
        }
        localObject3 = localObject1;
      }
    }
    if (localObject3 != null) {
      return (Map<String, String>)localObject3;
    }
    return Collections.emptyMap();
  }
  
  public final void zzh()
  {
    synchronized (this.zzdh)
    {
      this.zzdi = null;
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */