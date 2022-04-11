package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SafeParcelable.Class(creator="RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage
  extends AbstractSafeParcelable
{
  @NonNull
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  @SafeParcelable.Field(id=2)
  Bundle bundle;
  private Map<String, String> data;
  private Notification notification;
  
  @SafeParcelable.Constructor
  public RemoteMessage(@NonNull @SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.bundle = paramBundle;
  }
  
  private int getMessagePriority(String paramString)
  {
    if ("high".equals(paramString)) {
      return 1;
    }
    if ("normal".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  @Nullable
  public String getCollapseKey()
  {
    return this.bundle.getString("collapse_key");
  }
  
  @NonNull
  public Map<String, String> getData()
  {
    if (this.data == null) {
      this.data = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.bundle);
    }
    return this.data;
  }
  
  @Nullable
  public String getFrom()
  {
    return this.bundle.getString("from");
  }
  
  @Nullable
  public String getMessageId()
  {
    String str1 = this.bundle.getString("google.message_id");
    String str2 = str1;
    if (str1 == null) {
      str2 = this.bundle.getString("message_id");
    }
    return str2;
  }
  
  @Nullable
  public String getMessageType()
  {
    return this.bundle.getString("message_type");
  }
  
  @Nullable
  public Notification getNotification()
  {
    if ((this.notification == null) && (NotificationParams.isNotification(this.bundle))) {
      this.notification = new Notification(new NotificationParams(this.bundle), null);
    }
    return this.notification;
  }
  
  public int getOriginalPriority()
  {
    String str1 = this.bundle.getString("google.original_priority");
    String str2 = str1;
    if (str1 == null) {
      str2 = this.bundle.getString("google.priority");
    }
    return getMessagePriority(str2);
  }
  
  public int getPriority()
  {
    String str1 = this.bundle.getString("google.delivered_priority");
    String str2 = str1;
    if (str1 == null)
    {
      if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
        return 2;
      }
      str2 = this.bundle.getString("google.priority");
    }
    return getMessagePriority(str2);
  }
  
  @Nullable
  @ShowFirstParty
  public byte[] getRawData()
  {
    return this.bundle.getByteArray("rawData");
  }
  
  @Nullable
  public String getSenderId()
  {
    return this.bundle.getString("google.c.sender.id");
  }
  
  public long getSentTime()
  {
    Object localObject = this.bundle.get("google.sent_time");
    if ((localObject instanceof Long)) {
      return ((Long)localObject).longValue();
    }
    if ((localObject instanceof String)) {
      try
      {
        long l = Long.parseLong((String)localObject);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str = String.valueOf(localObject);
        localObject = new StringBuilder(str.length() + 19);
        ((StringBuilder)localObject).append("Invalid sent time: ");
        ((StringBuilder)localObject).append(str);
        Log.w("FirebaseMessaging", ((StringBuilder)localObject).toString());
      }
    }
    return 0L;
  }
  
  @Nullable
  public String getTo()
  {
    return this.bundle.getString("google.to");
  }
  
  public int getTtl()
  {
    Object localObject = this.bundle.get("google.ttl");
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof String)) {
      try
      {
        int i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject = String.valueOf(localObject);
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 13);
        localStringBuilder.append("Invalid TTL: ");
        localStringBuilder.append((String)localObject);
        Log.w("FirebaseMessaging", localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  void populateSendMessageIntent(Intent paramIntent)
  {
    paramIntent.putExtras(this.bundle);
  }
  
  @NonNull
  @KeepForSdk
  public Intent toIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.bundle);
    return localIntent;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    RemoteMessageCreator.writeToParcel(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final Bundle bundle;
    private final Map<String, String> data;
    
    public Builder(@NonNull String paramString)
    {
      Bundle localBundle = new Bundle();
      this.bundle = localBundle;
      this.data = new ArrayMap();
      if (TextUtils.isEmpty(paramString))
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Invalid to: ".concat(paramString);
        } else {
          paramString = new String("Invalid to: ");
        }
        throw new IllegalArgumentException(paramString);
      }
      localBundle.putString("google.to", paramString);
    }
    
    @NonNull
    public Builder addData(@NonNull String paramString1, @Nullable String paramString2)
    {
      this.data.put(paramString1, paramString2);
      return this;
    }
    
    @NonNull
    public RemoteMessage build()
    {
      Bundle localBundle = new Bundle();
      Iterator localIterator = this.data.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localBundle.putAll(this.bundle);
      this.bundle.remove("from");
      return new RemoteMessage(localBundle);
    }
    
    @NonNull
    public Builder clearData()
    {
      this.data.clear();
      return this;
    }
    
    @NonNull
    public Builder setCollapseKey(@Nullable String paramString)
    {
      this.bundle.putString("collapse_key", paramString);
      return this;
    }
    
    @NonNull
    public Builder setData(@NonNull Map<String, String> paramMap)
    {
      this.data.clear();
      this.data.putAll(paramMap);
      return this;
    }
    
    @NonNull
    public Builder setMessageId(@NonNull String paramString)
    {
      this.bundle.putString("google.message_id", paramString);
      return this;
    }
    
    @NonNull
    public Builder setMessageType(@Nullable String paramString)
    {
      this.bundle.putString("message_type", paramString);
      return this;
    }
    
    @NonNull
    @ShowFirstParty
    public Builder setRawData(@NonNull byte[] paramArrayOfByte)
    {
      this.bundle.putByteArray("rawData", paramArrayOfByte);
      return this;
    }
    
    @NonNull
    public Builder setTtl(@IntRange(from=0L, to=86400L) int paramInt)
    {
      this.bundle.putString("google.ttl", String.valueOf(paramInt));
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessagePriority {}
  
  public static class Notification
  {
    private final String body;
    private final String[] bodyLocArgs;
    private final String bodyLocKey;
    private final String channelId;
    private final String clickAction;
    private final String color;
    private final boolean defaultLightSettings;
    private final boolean defaultSound;
    private final boolean defaultVibrateTimings;
    private final Long eventTime;
    private final String icon;
    private final String imageUrl;
    private final int[] lightSettings;
    private final Uri link;
    private final boolean localOnly;
    private final Integer notificationCount;
    private final Integer notificationPriority;
    private final String sound;
    private final boolean sticky;
    private final String tag;
    private final String ticker;
    private final String title;
    private final String[] titleLocArgs;
    private final String titleLocKey;
    private final long[] vibrateTimings;
    private final Integer visibility;
    
    private Notification(NotificationParams paramNotificationParams)
    {
      this.title = paramNotificationParams.getString("gcm.n.title");
      this.titleLocKey = paramNotificationParams.getLocalizationResourceForKey("gcm.n.title");
      this.titleLocArgs = getLocalizationArgs(paramNotificationParams, "gcm.n.title");
      this.body = paramNotificationParams.getString("gcm.n.body");
      this.bodyLocKey = paramNotificationParams.getLocalizationResourceForKey("gcm.n.body");
      this.bodyLocArgs = getLocalizationArgs(paramNotificationParams, "gcm.n.body");
      this.icon = paramNotificationParams.getString("gcm.n.icon");
      this.sound = paramNotificationParams.getSoundResourceName();
      this.tag = paramNotificationParams.getString("gcm.n.tag");
      this.color = paramNotificationParams.getString("gcm.n.color");
      this.clickAction = paramNotificationParams.getString("gcm.n.click_action");
      this.channelId = paramNotificationParams.getString("gcm.n.android_channel_id");
      this.link = paramNotificationParams.getLink();
      this.imageUrl = paramNotificationParams.getString("gcm.n.image");
      this.ticker = paramNotificationParams.getString("gcm.n.ticker");
      this.notificationPriority = paramNotificationParams.getInteger("gcm.n.notification_priority");
      this.visibility = paramNotificationParams.getInteger("gcm.n.visibility");
      this.notificationCount = paramNotificationParams.getInteger("gcm.n.notification_count");
      this.sticky = paramNotificationParams.getBoolean("gcm.n.sticky");
      this.localOnly = paramNotificationParams.getBoolean("gcm.n.local_only");
      this.defaultSound = paramNotificationParams.getBoolean("gcm.n.default_sound");
      this.defaultVibrateTimings = paramNotificationParams.getBoolean("gcm.n.default_vibrate_timings");
      this.defaultLightSettings = paramNotificationParams.getBoolean("gcm.n.default_light_settings");
      this.eventTime = paramNotificationParams.getLong("gcm.n.event_time");
      this.lightSettings = paramNotificationParams.getLightSettings();
      this.vibrateTimings = paramNotificationParams.getVibrateTimings();
    }
    
    private static String[] getLocalizationArgs(NotificationParams paramNotificationParams, String paramString)
    {
      paramNotificationParams = paramNotificationParams.getLocalizationArgsForKey(paramString);
      if (paramNotificationParams == null) {
        return null;
      }
      paramString = new String[paramNotificationParams.length];
      for (int i = 0; i < paramNotificationParams.length; i++) {
        paramString[i] = String.valueOf(paramNotificationParams[i]);
      }
      return paramString;
    }
    
    @Nullable
    public String getBody()
    {
      return this.body;
    }
    
    @Nullable
    public String[] getBodyLocalizationArgs()
    {
      return this.bodyLocArgs;
    }
    
    @Nullable
    public String getBodyLocalizationKey()
    {
      return this.bodyLocKey;
    }
    
    @Nullable
    public String getChannelId()
    {
      return this.channelId;
    }
    
    @Nullable
    public String getClickAction()
    {
      return this.clickAction;
    }
    
    @Nullable
    public String getColor()
    {
      return this.color;
    }
    
    public boolean getDefaultLightSettings()
    {
      return this.defaultLightSettings;
    }
    
    public boolean getDefaultSound()
    {
      return this.defaultSound;
    }
    
    public boolean getDefaultVibrateSettings()
    {
      return this.defaultVibrateTimings;
    }
    
    @Nullable
    public Long getEventTime()
    {
      return this.eventTime;
    }
    
    @Nullable
    public String getIcon()
    {
      return this.icon;
    }
    
    @Nullable
    public Uri getImageUrl()
    {
      String str = this.imageUrl;
      if (str != null) {
        return Uri.parse(str);
      }
      return null;
    }
    
    @Nullable
    public int[] getLightSettings()
    {
      return this.lightSettings;
    }
    
    @Nullable
    public Uri getLink()
    {
      return this.link;
    }
    
    public boolean getLocalOnly()
    {
      return this.localOnly;
    }
    
    @Nullable
    public Integer getNotificationCount()
    {
      return this.notificationCount;
    }
    
    @Nullable
    public Integer getNotificationPriority()
    {
      return this.notificationPriority;
    }
    
    @Nullable
    public String getSound()
    {
      return this.sound;
    }
    
    public boolean getSticky()
    {
      return this.sticky;
    }
    
    @Nullable
    public String getTag()
    {
      return this.tag;
    }
    
    @Nullable
    public String getTicker()
    {
      return this.ticker;
    }
    
    @Nullable
    public String getTitle()
    {
      return this.title;
    }
    
    @Nullable
    public String[] getTitleLocalizationArgs()
    {
      return this.titleLocArgs;
    }
    
    @Nullable
    public String getTitleLocalizationKey()
    {
      return this.titleLocKey;
    }
    
    @Nullable
    public long[] getVibrateTimings()
    {
      return this.vibrateTimings;
    }
    
    @Nullable
    public Integer getVisibility()
    {
      return this.visibility;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\RemoteMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */