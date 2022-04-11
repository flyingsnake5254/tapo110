package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class Store
{
  final Context context;
  final SharedPreferences store;
  
  public Store(Context paramContext)
  {
    this.context = paramContext;
    this.store = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    checkForRestore("com.google.android.gms.appid-no-backup");
  }
  
  private void checkForRestore(String paramString)
  {
    paramString = new File(ContextCompat.getNoBackupFilesDir(this.context), "com.google.android.gms.appid-no-backup");
    if (paramString.exists()) {
      return;
    }
    try
    {
      if ((paramString.createNewFile()) && (!isEmpty()))
      {
        Log.i("FirebaseMessaging", "App restored, clearing state");
        deleteAll();
        return;
      }
    }
    catch (IOException paramString)
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        paramString = String.valueOf(paramString.getMessage());
        if (paramString.length() != 0) {
          paramString = "Error creating file in no backup dir: ".concat(paramString);
        } else {
          paramString = new String("Error creating file in no backup dir: ");
        }
        Log.d("FirebaseMessaging", paramString);
      }
    }
  }
  
  private String createTokenKey(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 5 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|T|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|*");
    return localStringBuilder.toString();
  }
  
  public void deleteAll()
  {
    try
    {
      this.store.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void deleteToken(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = createTokenKey(paramString1, paramString2);
      paramString2 = this.store.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public Token getToken(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Token.parse(this.store.getString(createTokenKey(paramString1, paramString2), null));
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.store.getAll().isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void saveToken(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString4 = Token.encode(paramString3, paramString4, System.currentTimeMillis());
      if (paramString4 == null) {
        return;
      }
      paramString3 = this.store.edit();
      paramString3.putString(createTokenKey(paramString1, paramString2), paramString4);
      paramString3.commit();
      return;
    }
    finally {}
  }
  
  static class Token
  {
    private static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7L);
    final String appVersion;
    final long timestamp;
    final String token;
    
    private Token(String paramString1, String paramString2, long paramLong)
    {
      this.token = paramString1;
      this.appVersion = paramString2;
      this.timestamp = paramLong;
    }
    
    static String encode(String paramString1, String paramString2, long paramLong)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        localJSONObject.put("token", paramString1);
        localJSONObject.put("appVersion", paramString2);
        localJSONObject.put("timestamp", paramLong);
        paramString1 = localJSONObject.toString();
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        paramString1 = String.valueOf(paramString1);
        paramString2 = new StringBuilder(paramString1.length() + 24);
        paramString2.append("Failed to encode token: ");
        paramString2.append(paramString1);
        Log.w("FirebaseMessaging", paramString2.toString());
      }
      return null;
    }
    
    static Token parse(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramString.startsWith("{")) {
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = new Token(((JSONObject)localObject).getString("token"), ((JSONObject)localObject).getString("appVersion"), ((JSONObject)localObject).getLong("timestamp"));
          return paramString;
        }
        catch (JSONException paramString)
        {
          paramString = String.valueOf(paramString);
          Object localObject = new StringBuilder(paramString.length() + 23);
          ((StringBuilder)localObject).append("Failed to parse token: ");
          ((StringBuilder)localObject).append(paramString);
          Log.w("FirebaseMessaging", ((StringBuilder)localObject).toString());
          return null;
        }
      }
      return new Token(paramString, null, 0L);
    }
    
    boolean needsRefresh(String paramString)
    {
      return (System.currentTimeMillis() > this.timestamp + REFRESH_PERIOD_MILLIS) || (!paramString.equals(this.appVersion));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\Store.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */