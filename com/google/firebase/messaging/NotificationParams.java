package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class NotificationParams
{
  @NonNull
  private final Bundle data;
  
  public NotificationParams(@NonNull Bundle paramBundle)
  {
    Objects.requireNonNull(paramBundle, "data");
    this.data = new Bundle(paramBundle);
  }
  
  private static int getLightColor(String paramString)
  {
    int i = Color.parseColor(paramString);
    if (i != -16777216) {
      return i;
    }
    throw new IllegalArgumentException("Transparent color is invalid");
  }
  
  private static boolean isAnalyticsKey(String paramString)
  {
    return (paramString.startsWith("google.c.a.")) || (paramString.equals("from"));
  }
  
  public static boolean isNotification(@NonNull Bundle paramBundle)
  {
    return ("1".equals(paramBundle.getString("gcm.n.e"))) || ("1".equals(paramBundle.getString(keyWithOldPrefix("gcm.n.e"))));
  }
  
  private static boolean isReservedKey(String paramString)
  {
    return (paramString.startsWith("google.c.")) || (paramString.startsWith("gcm.n.")) || (paramString.startsWith("gcm.notification."));
  }
  
  private static String keyWithOldPrefix(String paramString)
  {
    if (!paramString.startsWith("gcm.n.")) {
      return paramString;
    }
    return paramString.replace("gcm.n.", "gcm.notification.");
  }
  
  private String normalizePrefix(String paramString)
  {
    if ((!this.data.containsKey(paramString)) && (paramString.startsWith("gcm.n.")))
    {
      String str = keyWithOldPrefix(paramString);
      if (this.data.containsKey(str)) {
        return str;
      }
    }
    return paramString;
  }
  
  private static String userFriendlyKey(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("gcm.n.")) {
      str = paramString.substring(6);
    }
    return str;
  }
  
  public boolean getBoolean(@NonNull String paramString)
  {
    paramString = getString(paramString);
    return ("1".equals(paramString)) || (Boolean.parseBoolean(paramString));
  }
  
  @NonNull
  public Integer getInteger(@NonNull String paramString)
  {
    String str = getString(paramString);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        int i = Integer.parseInt(str);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = userFriendlyKey(paramString);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 38 + String.valueOf(str).length());
        localStringBuilder.append("Couldn't parse value of ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        localStringBuilder.append(str);
        localStringBuilder.append(") into an int");
        Log.w("NotificationParams", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  @Nullable
  public JSONArray getJSONArray(@NonNull String paramString)
  {
    String str = getString(paramString);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        paramString = userFriendlyKey(paramString);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 50 + String.valueOf(str).length());
        localStringBuilder.append("Malformed JSON for key ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(": ");
        localStringBuilder.append(str);
        localStringBuilder.append(", falling back to default");
        Log.w("NotificationParams", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  @Nullable
  int[] getLightSettings()
  {
    Object localObject = getJSONArray("gcm.n.light_settings");
    if (localObject == null) {
      return null;
    }
    try
    {
      if (((JSONArray)localObject).length() == 3) {
        return new int[] { getLightColor(((JSONArray)localObject).optString(0)), ((JSONArray)localObject).optInt(1), ((JSONArray)localObject).optInt(2) };
      }
      JSONException localJSONException1 = new org/json/JSONException;
      localJSONException1.<init>("lightSettings don't have all three fields");
      throw localJSONException1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject = String.valueOf(localObject);
      String str = localIllegalArgumentException.getMessage();
      StringBuilder localStringBuilder2 = new StringBuilder(((String)localObject).length() + 60 + String.valueOf(str).length());
      localStringBuilder2.append("LightSettings is invalid: ");
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append(". ");
      localStringBuilder2.append(str);
      localStringBuilder2.append(". Skipping setting LightSettings");
      Log.w("NotificationParams", localStringBuilder2.toString());
    }
    catch (JSONException localJSONException2)
    {
      localObject = String.valueOf(localObject);
      StringBuilder localStringBuilder1 = new StringBuilder(((String)localObject).length() + 58);
      localStringBuilder1.append("LightSettings is invalid: ");
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append(". Skipping setting LightSettings");
      Log.w("NotificationParams", localStringBuilder1.toString());
    }
    return null;
  }
  
  @Nullable
  public Uri getLink()
  {
    String str1 = getString("gcm.n.link_android");
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = getString("gcm.n.link");
    }
    if (!TextUtils.isEmpty(str2)) {
      return Uri.parse(str2);
    }
    return null;
  }
  
  @Nullable
  public Object[] getLocalizationArgsForKey(@NonNull String paramString)
  {
    paramString = getJSONArray(String.valueOf(paramString).concat("_loc_args"));
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString[j] = paramString.optString(j);
    }
    return arrayOfString;
  }
  
  @Nullable
  public String getLocalizationResourceForKey(@NonNull String paramString)
  {
    return getString(String.valueOf(paramString).concat("_loc_key"));
  }
  
  @Nullable
  public String getLocalizedString(@NonNull Resources paramResources, @NonNull String paramString1, @NonNull String paramString2)
  {
    String str = getLocalizationResourceForKey(paramString2);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    int i = paramResources.getIdentifier(str, "string", paramString1);
    if (i == 0)
    {
      paramString1 = userFriendlyKey(String.valueOf(paramString2).concat("_loc_key"));
      paramResources = new StringBuilder(String.valueOf(paramString1).length() + 49 + String.valueOf(paramString2).length());
      paramResources.append(paramString1);
      paramResources.append(" resource not found: ");
      paramResources.append(paramString2);
      paramResources.append(" Default value will be used.");
      Log.w("NotificationParams", paramResources.toString());
      return null;
    }
    paramString1 = getLocalizationArgsForKey(paramString2);
    if (paramString1 == null) {
      return paramResources.getString(i);
    }
    try
    {
      paramResources = paramResources.getString(i, paramString1);
      return paramResources;
    }
    catch (MissingFormatArgumentException paramResources)
    {
      paramString2 = userFriendlyKey(paramString2);
      str = Arrays.toString(paramString1);
      paramString1 = new StringBuilder(String.valueOf(paramString2).length() + 58 + String.valueOf(str).length());
      paramString1.append("Missing format argument for ");
      paramString1.append(paramString2);
      paramString1.append(": ");
      paramString1.append(str);
      paramString1.append(" Default value will be used.");
      Log.w("NotificationParams", paramString1.toString(), paramResources);
    }
    return null;
  }
  
  @NonNull
  public Long getLong(@NonNull String paramString)
  {
    String str = getString(paramString);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        long l = Long.parseLong(str);
        return Long.valueOf(l);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramString = userFriendlyKey(paramString);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 38 + String.valueOf(str).length());
        localStringBuilder.append("Couldn't parse value of ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        localStringBuilder.append(str);
        localStringBuilder.append(") into a long");
        Log.w("NotificationParams", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  @NonNull
  public String getNotificationChannelId()
  {
    return getString("gcm.n.android_channel_id");
  }
  
  @Nullable
  Integer getNotificationCount()
  {
    Object localObject = getInteger("gcm.n.notification_count");
    if (localObject == null) {
      return null;
    }
    if (((Integer)localObject).intValue() < 0)
    {
      String str = String.valueOf(localObject);
      localObject = new StringBuilder(str.length() + 67);
      ((StringBuilder)localObject).append("notificationCount is invalid: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(". Skipping setting notificationCount.");
      Log.w("FirebaseMessaging", ((StringBuilder)localObject).toString());
      return null;
    }
    return (Integer)localObject;
  }
  
  @Nullable
  Integer getNotificationPriority()
  {
    Object localObject = getInteger("gcm.n.notification_priority");
    if (localObject == null) {
      return null;
    }
    if ((((Integer)localObject).intValue() >= -2) && (((Integer)localObject).intValue() <= 2)) {
      return (Integer)localObject;
    }
    localObject = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 72);
    localStringBuilder.append("notificationPriority is invalid ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(". Skipping setting notificationPriority.");
    Log.w("FirebaseMessaging", localStringBuilder.toString());
    return null;
  }
  
  @NonNull
  public String getPossiblyLocalizedString(@NonNull Resources paramResources, @NonNull String paramString1, @NonNull String paramString2)
  {
    String str = getString(paramString2);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return getLocalizedString(paramResources, paramString1, paramString2);
  }
  
  @Nullable
  public String getSoundResourceName()
  {
    String str1 = getString("gcm.n.sound2");
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = getString("gcm.n.sound");
    }
    return str2;
  }
  
  @NonNull
  public String getString(@NonNull String paramString)
  {
    return this.data.getString(normalizePrefix(paramString));
  }
  
  @Nullable
  public long[] getVibrateTimings()
  {
    Object localObject1 = getJSONArray("gcm.n.vibrate_timings");
    if (localObject1 == null) {
      return null;
    }
    try
    {
      if (((JSONArray)localObject1).length() > 1)
      {
        int i = ((JSONArray)localObject1).length();
        localObject2 = new long[i];
        for (int j = 0; j < i; j++) {
          localObject2[j] = ((JSONArray)localObject1).optLong(j);
        }
        return (long[])localObject2;
      }
      Object localObject2 = new org/json/JSONException;
      ((JSONException)localObject2).<init>("vibrateTimings have invalid length");
      throw ((Throwable)localObject2);
    }
    catch (JSONException|NumberFormatException localJSONException)
    {
      String str = String.valueOf(localObject1);
      localObject1 = new StringBuilder(str.length() + 74);
      ((StringBuilder)localObject1).append("User defined vibrateTimings is invalid: ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(". Skipping setting vibrateTimings.");
      Log.w("NotificationParams", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  Integer getVisibility()
  {
    Object localObject = getInteger("gcm.n.visibility");
    if (localObject == null) {
      return null;
    }
    if ((((Integer)localObject).intValue() >= -1) && (((Integer)localObject).intValue() <= 1)) {
      return (Integer)localObject;
    }
    String str = String.valueOf(localObject);
    localObject = new StringBuilder(str.length() + 53);
    ((StringBuilder)localObject).append("visibility is invalid: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(". Skipping setting visibility.");
    Log.w("NotificationParams", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public boolean hasImage()
  {
    return !TextUtils.isEmpty(getString("gcm.n.image"));
  }
  
  public boolean isNotification()
  {
    return getBoolean("gcm.n.e");
  }
  
  @NonNull
  public Bundle paramsForAnalyticsIntent()
  {
    Bundle localBundle = new Bundle(this.data);
    Iterator localIterator = this.data.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!isAnalyticsKey(str)) {
        localBundle.remove(str);
      }
    }
    return localBundle;
  }
  
  @NonNull
  public Bundle paramsWithReservedKeysRemoved()
  {
    Bundle localBundle = new Bundle(this.data);
    Iterator localIterator = this.data.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isReservedKey(str)) {
        localBundle.remove(str);
      }
    }
    return localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\NotificationParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */