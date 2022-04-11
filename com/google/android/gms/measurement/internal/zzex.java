package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzex
{
  private final String zzb;
  private final Bundle zzc;
  private Bundle zzd;
  
  public zzex(zzfb paramzzfb, String paramString, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty("default_event_parameters");
    this.zzb = "default_event_parameters";
    this.zzc = new Bundle();
  }
  
  @WorkerThread
  public final Bundle zza()
  {
    if (this.zzd == null)
    {
      Object localObject = this.zza.zzd().getString(this.zzb, null);
      if (localObject != null) {
        try
        {
          Bundle localBundle = new android/os/Bundle;
          localBundle.<init>();
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>((String)localObject);
          for (int i = 0;; i++)
          {
            int j = localJSONArray.length();
            if (i >= j) {
              break;
            }
            try
            {
              localObject = localJSONArray.getJSONObject(i);
              String str1 = ((JSONObject)localObject).getString("n");
              String str2 = ((JSONObject)localObject).getString("t");
              j = str2.hashCode();
              if (j != 100)
              {
                if (j != 108)
                {
                  if ((j == 115) && (str2.equals("s")))
                  {
                    j = 0;
                    break label170;
                  }
                }
                else if (str2.equals("l"))
                {
                  j = 2;
                  break label170;
                }
              }
              else if (str2.equals("d"))
              {
                j = 1;
                break label170;
              }
              j = -1;
              label170:
              if (j != 0)
              {
                if (j != 1)
                {
                  if (j != 2) {
                    this.zza.zzs.zzau().zzb().zzb("Unrecognized persisted bundle type. Type", str2);
                  } else {
                    localBundle.putLong(str1, Long.parseLong(((JSONObject)localObject).getString("v")));
                  }
                }
                else {
                  localBundle.putDouble(str1, Double.parseDouble(((JSONObject)localObject).getString("v")));
                }
              }
              else {
                localBundle.putString(str1, ((JSONObject)localObject).getString("v"));
              }
            }
            catch (JSONException|NumberFormatException localJSONException1)
            {
              this.zza.zzs.zzau().zzb().zza("Error reading value from SharedPreferences. Value dropped");
            }
          }
          this.zzd = localBundle;
        }
        catch (JSONException localJSONException2)
        {
          this.zza.zzs.zzau().zzb().zza("Error loading bundle from SharedPreferences. Values will be lost");
        }
      }
      if (this.zzd == null) {
        this.zzd = this.zzc;
      }
    }
    return this.zzd;
  }
  
  @WorkerThread
  public final void zzb(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    SharedPreferences.Editor localEditor = this.zza.zzd().edit();
    if (localBundle.size() == 0)
    {
      localEditor.remove(this.zzb);
    }
    else
    {
      String str1 = this.zzb;
      JSONArray localJSONArray = new JSONArray();
      paramBundle = localBundle.keySet().iterator();
      while (paramBundle.hasNext())
      {
        String str2 = (String)paramBundle.next();
        Object localObject = localBundle.get(str2);
        if (localObject != null) {
          try
          {
            JSONObject localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>();
            localJSONObject.put("n", str2);
            localJSONObject.put("v", String.valueOf(localObject));
            boolean bool = localObject instanceof String;
            if (bool)
            {
              localJSONObject.put("t", "s");
            }
            else if ((localObject instanceof Long))
            {
              localJSONObject.put("t", "l");
            }
            else
            {
              if (!(localObject instanceof Double)) {
                break label214;
              }
              localJSONObject.put("t", "d");
            }
            localJSONArray.put(localJSONObject);
            continue;
            label214:
            this.zza.zzs.zzau().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", localObject.getClass());
          }
          catch (JSONException localJSONException)
          {
            this.zza.zzs.zzau().zzb().zzb("Cannot serialize bundle value to SharedPreferences", localJSONException);
          }
        }
      }
      localEditor.putString(str1, localJSONArray.toString());
    }
    localEditor.apply();
    this.zzd = localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */