package com.google.firebase.messaging;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

class GmsRpc
{
  private final FirebaseApp app;
  private final FirebaseInstallationsApi firebaseInstallations;
  private final Provider<HeartBeatInfo> heartbeatInfo;
  private final Metadata metadata;
  private final Rpc rpc;
  private final Provider<UserAgentPublisher> userAgentPublisher;
  
  @VisibleForTesting
  GmsRpc(FirebaseApp paramFirebaseApp, Metadata paramMetadata, Rpc paramRpc, Provider<UserAgentPublisher> paramProvider, Provider<HeartBeatInfo> paramProvider1, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    this.app = paramFirebaseApp;
    this.metadata = paramMetadata;
    this.rpc = paramRpc;
    this.userAgentPublisher = paramProvider;
    this.heartbeatInfo = paramProvider1;
    this.firebaseInstallations = paramFirebaseInstallationsApi;
  }
  
  GmsRpc(FirebaseApp paramFirebaseApp, Metadata paramMetadata, Provider<UserAgentPublisher> paramProvider, Provider<HeartBeatInfo> paramProvider1, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    this(paramFirebaseApp, paramMetadata, new Rpc(paramFirebaseApp.getApplicationContext()), paramProvider, paramProvider1, paramFirebaseInstallationsApi);
  }
  
  private static String base64UrlSafe(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  private Task<String> extractResponseWhenComplete(Task<Bundle> paramTask)
  {
    return paramTask.continueWith(GmsRpc..Lambda.0.$instance, new GmsRpc..Lambda.1(this));
  }
  
  private String getHashedFirebaseAppName()
  {
    String str = this.app.getName();
    try
    {
      str = base64UrlSafe(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return "[HASH-ERROR]";
  }
  
  @AnyThread
  private String handleResponse(Bundle paramBundle)
    throws IOException
  {
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("registration_id");
      if (localObject != null) {
        return (String)localObject;
      }
      localObject = paramBundle.getString("unregistered");
      if (localObject != null) {
        return (String)localObject;
      }
      localObject = paramBundle.getString("error");
      if (!"RST".equals(localObject))
      {
        if (localObject != null) {
          throw new IOException((String)localObject);
        }
        paramBundle = String.valueOf(paramBundle);
        localObject = new StringBuilder(paramBundle.length() + 21);
        ((StringBuilder)localObject).append("Unexpected response: ");
        ((StringBuilder)localObject).append(paramBundle);
        Log.w("FirebaseMessaging", ((StringBuilder)localObject).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
      throw new IOException("INSTANCE_ID_RESET");
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  static boolean isErrorMessageForRetryableError(String paramString)
  {
    return ("SERVICE_NOT_AVAILABLE".equals(paramString)) || ("INTERNAL_SERVER_ERROR".equals(paramString)) || ("InternalServerError".equals(paramString));
  }
  
  private Bundle setDefaultAttributesToBundle(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle.putString("scope", paramString3);
    paramBundle.putString("sender", paramString2);
    paramBundle.putString("subtype", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("gmp_app_id", this.app.getOptions().getApplicationId());
    paramBundle.putString("gmsv", Integer.toString(this.metadata.getGmsVersionCode()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.metadata.getAppVersionCode());
    paramBundle.putString("app_ver_name", this.metadata.getAppVersionName());
    paramBundle.putString("firebase-app-name-hash", getHashedFirebaseAppName());
    try
    {
      paramString1 = ((InstallationTokenResult)Tasks.await(this.firebaseInstallations.getToken(false))).getToken();
      if (!TextUtils.isEmpty(paramString1)) {
        paramBundle.putString("Goog-Firebase-Installations-Auth", paramString1);
      } else {
        Log.w("FirebaseMessaging", "FIS auth token is empty");
      }
    }
    catch (InterruptedException paramString1) {}catch (ExecutionException paramString1) {}
    Log.e("FirebaseMessaging", "Failed to get FIS auth token", paramString1);
    paramBundle.putString("cliv", "fcm-22.0.0");
    paramString2 = (HeartBeatInfo)this.heartbeatInfo.get();
    paramString1 = (UserAgentPublisher)this.userAgentPublisher.get();
    if ((paramString2 != null) && (paramString1 != null))
    {
      paramString2 = paramString2.getHeartBeatCode("fire-iid");
      if (paramString2 != HeartBeatInfo.HeartBeat.NONE)
      {
        paramBundle.putString("Firebase-Client-Log-Type", Integer.toString(paramString2.getCode()));
        paramBundle.putString("Firebase-Client", paramString1.getUserAgent());
      }
    }
    return paramBundle;
  }
  
  private Task<Bundle> startRpc(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    setDefaultAttributesToBundle(paramString1, paramString2, paramString3, paramBundle);
    return this.rpc.send(paramBundle);
  }
  
  Task<?> deleteToken(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("delete", "1");
    return extractResponseWhenComplete(startRpc(paramString, Metadata.getDefaultSenderId(this.app), "*", localBundle));
  }
  
  Task<String> getToken(String paramString)
  {
    return extractResponseWhenComplete(startRpc(paramString, Metadata.getDefaultSenderId(this.app), "*", new Bundle()));
  }
  
  Task<?> subscribeToTopic(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    }
    localBundle.putString("gcm.topic", str);
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    }
    return extractResponseWhenComplete(startRpc(paramString1, paramString2, paramString3, localBundle));
  }
  
  Task<?> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    }
    localBundle.putString("gcm.topic", str);
    localBundle.putString("delete", "1");
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    }
    return extractResponseWhenComplete(startRpc(paramString1, paramString2, paramString3, localBundle));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\GmsRpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */