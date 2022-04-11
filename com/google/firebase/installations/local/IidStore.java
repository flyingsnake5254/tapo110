package com.google.firebase.installations.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class IidStore
{
  private static final String[] ALLOWABLE_SCOPES = { "*", "FCM", "GCM", "" };
  private static final String IID_SHARED_PREFS_NAME = "com.google.android.gms.appid";
  private static final String JSON_ENCODED_PREFIX = "{";
  private static final String JSON_TOKEN_KEY = "token";
  private static final String STORE_KEY_ID = "|S|id";
  private static final String STORE_KEY_PUB = "|S||P|";
  private static final String STORE_KEY_SEPARATOR = "|";
  private static final String STORE_KEY_TOKEN = "|T|";
  private final String defaultSenderId;
  @GuardedBy("iidPrefs")
  private final SharedPreferences iidPrefs;
  
  @VisibleForTesting
  public IidStore(@NonNull SharedPreferences paramSharedPreferences, @Nullable String paramString)
  {
    this.iidPrefs = paramSharedPreferences;
    this.defaultSenderId = paramString;
  }
  
  public IidStore(@NonNull FirebaseApp paramFirebaseApp)
  {
    this.iidPrefs = paramFirebaseApp.getApplicationContext().getSharedPreferences("com.google.android.gms.appid", 0);
    this.defaultSenderId = getDefaultSenderId(paramFirebaseApp);
  }
  
  private String createTokenKey(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|T|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String getDefaultSenderId(FirebaseApp paramFirebaseApp)
  {
    String str = paramFirebaseApp.getOptions().getGcmSenderId();
    if (str != null) {
      return str;
    }
    paramFirebaseApp = paramFirebaseApp.getOptions().getApplicationId();
    if ((!paramFirebaseApp.startsWith("1:")) && (!paramFirebaseApp.startsWith("2:"))) {
      return paramFirebaseApp;
    }
    paramFirebaseApp = paramFirebaseApp.split(":");
    if (paramFirebaseApp.length != 4) {
      return null;
    }
    paramFirebaseApp = paramFirebaseApp[1];
    if (paramFirebaseApp.isEmpty()) {
      return null;
    }
    return paramFirebaseApp;
  }
  
  @Nullable
  private static String getIdFromPublicKey(@NonNull PublicKey paramPublicKey)
  {
    paramPublicKey = paramPublicKey.getEncoded();
    try
    {
      paramPublicKey = MessageDigest.getInstance("SHA1").digest(paramPublicKey);
      paramPublicKey[0] = ((byte)(byte)((paramPublicKey[0] & 0xF) + 112 & 0xFF));
      paramPublicKey = Base64.encodeToString(paramPublicKey, 0, 8, 11);
      return paramPublicKey;
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      Log.w("ContentValues", "Unexpected error, device missing required algorithms");
    }
    return null;
  }
  
  private String parseIidTokenFromJson(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramString = localJSONObject.getString("token");
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  @Nullable
  private PublicKey parseKey(String paramString)
  {
    try
    {
      localObject = Base64.decode(paramString, 8);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      paramString = new java/security/spec/X509EncodedKeySpec;
      paramString.<init>((byte[])localObject);
      paramString = localKeyFactory.generatePublic(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}catch (InvalidKeySpecException paramString) {}catch (IllegalArgumentException paramString) {}
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid key stored ");
    ((StringBuilder)localObject).append(paramString);
    Log.w("ContentValues", ((StringBuilder)localObject).toString());
    return null;
  }
  
  @Nullable
  private String readInstanceIdFromLocalStorage()
  {
    synchronized (this.iidPrefs)
    {
      String str = this.iidPrefs.getString("|S|id", null);
      return str;
    }
  }
  
  @Nullable
  private String readPublicKeyFromLocalStorageAndCalculateInstanceId()
  {
    synchronized (this.iidPrefs)
    {
      Object localObject1 = this.iidPrefs.getString("|S||P|", null);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = parseKey((String)localObject1);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = getIdFromPublicKey((PublicKey)localObject1);
      return (String)localObject1;
    }
  }
  
  @Nullable
  public String readIid()
  {
    synchronized (this.iidPrefs)
    {
      String str = readInstanceIdFromLocalStorage();
      if (str != null) {
        return str;
      }
      str = readPublicKeyFromLocalStorageAndCalculateInstanceId();
      return str;
    }
  }
  
  @Nullable
  public String readToken()
  {
    synchronized (this.iidPrefs)
    {
      for (String str : ALLOWABLE_SCOPES)
      {
        str = createTokenKey(this.defaultSenderId, str);
        str = this.iidPrefs.getString(str, null);
        if ((str != null) && (!str.isEmpty()))
        {
          ??? = str;
          if (str.startsWith("{")) {
            ??? = parseIidTokenFromJson(str);
          }
          return (String)???;
        }
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\local\IidStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */