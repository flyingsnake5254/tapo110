package com.google.firebase.messaging;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class Constants
{
  @NonNull
  public static final String FCM_WAKE_LOCK = "wake:com.google.firebase.messaging";
  @NonNull
  public static final String IPC_BUNDLE_KEY_SEND_ERROR = "error";
  @NonNull
  public static final String TAG = "FirebaseMessaging";
  public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(3L);
  
  public static final class AnalyticsKeys
  {
    @NonNull
    public static final String ABT_EXPERIMENT = "google.c.a.abt";
    @NonNull
    public static final String COMPOSER_ID = "google.c.a.c_id";
    @NonNull
    public static final String COMPOSER_LABEL = "google.c.a.c_l";
    @NonNull
    public static final String ENABLED = "google.c.a.e";
    @NonNull
    public static final String MESSAGE_CHANNEL = "google.c.a.m_c";
    @NonNull
    public static final String MESSAGE_LABEL = "google.c.a.m_l";
    @NonNull
    public static final String MESSAGE_TIMESTAMP = "google.c.a.ts";
    @NonNull
    public static final String MESSAGE_USE_DEVICE_TIME = "google.c.a.udt";
    @NonNull
    public static final String PREFIX = "google.c.a.";
    @NonNull
    public static final String TRACK_CONVERSIONS = "google.c.a.tc";
  }
  
  public static final class FirelogAnalytics
  {
    @NonNull
    public static final String FCM_LOG_SOURCE = "FCM_CLIENT_EVENT_LOGGING";
  }
  
  public static final class MessageNotificationKeys
  {
    @NonNull
    public static final String ANALYTICS_DATA = "gcm.n.analytics_data";
    @NonNull
    public static final String BODY = "gcm.n.body";
    @NonNull
    public static final String CHANNEL = "gcm.n.android_channel_id";
    @NonNull
    public static final String CLICK_ACTION = "gcm.n.click_action";
    @NonNull
    public static final String COLOR = "gcm.n.color";
    @NonNull
    public static final String DEFAULT_LIGHT_SETTINGS = "gcm.n.default_light_settings";
    @NonNull
    public static final String DEFAULT_SOUND = "gcm.n.default_sound";
    @NonNull
    public static final String DEFAULT_VIBRATE_TIMINGS = "gcm.n.default_vibrate_timings";
    @NonNull
    public static final String DO_NOT_PROXY = "gcm.n.dnp";
    @NonNull
    public static final String ENABLE_NOTIFICATION = "gcm.n.e";
    @NonNull
    public static final String EVENT_TIME = "gcm.n.event_time";
    @NonNull
    public static final String ICON = "gcm.n.icon";
    @NonNull
    public static final String IMAGE_URL = "gcm.n.image";
    @NonNull
    public static final String LIGHT_SETTINGS = "gcm.n.light_settings";
    @NonNull
    public static final String LINK = "gcm.n.link";
    @NonNull
    public static final String LINK_ANDROID = "gcm.n.link_android";
    @NonNull
    public static final String LOCAL_ONLY = "gcm.n.local_only";
    @NonNull
    public static final String NOTIFICATION_COUNT = "gcm.n.notification_count";
    @NonNull
    public static final String NOTIFICATION_PREFIX = "gcm.n.";
    @NonNull
    public static final String NOTIFICATION_PREFIX_OLD = "gcm.notification.";
    @NonNull
    public static final String NOTIFICATION_PRIORITY = "gcm.n.notification_priority";
    @NonNull
    public static final String NO_UI = "gcm.n.noui";
    @NonNull
    public static final String RESERVED_PREFIX = "gcm.";
    @NonNull
    public static final String SOUND = "gcm.n.sound";
    @NonNull
    public static final String SOUND_2 = "gcm.n.sound2";
    @NonNull
    public static final String STICKY = "gcm.n.sticky";
    @NonNull
    public static final String TAG = "gcm.n.tag";
    @NonNull
    public static final String TEXT_ARGS_SUFFIX = "_loc_args";
    @NonNull
    public static final String TEXT_RESOURCE_SUFFIX = "_loc_key";
    @NonNull
    public static final String TICKER = "gcm.n.ticker";
    @NonNull
    public static final String TITLE = "gcm.n.title";
    @NonNull
    public static final String VIBRATE_TIMINGS = "gcm.n.vibrate_timings";
    @NonNull
    public static final String VISIBILITY = "gcm.n.visibility";
  }
  
  public static final class MessagePayloadKeys
  {
    @NonNull
    public static final String COLLAPSE_KEY = "collapse_key";
    @NonNull
    public static final String DELIVERED_PRIORITY = "google.delivered_priority";
    @NonNull
    public static final String FROM = "from";
    @NonNull
    public static final String MESSAGE_TYPE = "message_type";
    @NonNull
    public static final String MSGID = "google.message_id";
    @NonNull
    public static final String MSGID_SERVER = "message_id";
    @NonNull
    public static final String ORIGINAL_PRIORITY = "google.original_priority";
    @NonNull
    public static final String PRIORITY_REDUCED_V19 = "google.priority_reduced";
    @NonNull
    public static final String PRIORITY_V19 = "google.priority";
    @NonNull
    public static final String RAW_DATA = "rawData";
    @NonNull
    public static final String RESERVED_CLIENT_LIB_PREFIX = "google.c.";
    @NonNull
    public static final String RESERVED_PREFIX = "google.";
    @NonNull
    public static final String SENDER_ID = "google.c.sender.id";
    @NonNull
    public static final String SENT_TIME = "google.sent_time";
    @NonNull
    public static final String TO = "google.to";
    @NonNull
    public static final String TTL = "google.ttl";
    
    @NonNull
    public static ArrayMap<String, String> extractDeveloperDefinedPayload(@NonNull Bundle paramBundle)
    {
      ArrayMap localArrayMap = new ArrayMap();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          if ((!str.startsWith("google.")) && (!str.startsWith("gcm.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
            localArrayMap.put(str, localObject);
          }
        }
      }
      return localArrayMap;
    }
  }
  
  public static final class MessageTypes
  {
    @NonNull
    public static final String DELETED = "deleted_messages";
    @NonNull
    public static final String MESSAGE = "gcm";
    @NonNull
    public static final String SEND_ERROR = "send_error";
    @NonNull
    public static final String SEND_EVENT = "send_event";
  }
  
  public static final class ScionAnalytics
  {
    @NonNull
    public static final String EVENT_FIREBASE_CAMPAIGN = "_cmp";
    @NonNull
    public static final String EVENT_NOTIFICATION_DISMISS = "_nd";
    @NonNull
    public static final String EVENT_NOTIFICATION_FOREGROUND = "_nf";
    @NonNull
    public static final String EVENT_NOTIFICATION_OPEN = "_no";
    @NonNull
    public static final String EVENT_NOTIFICATION_RECEIVE = "_nr";
    @NonNull
    public static final String ORIGIN_FCM = "fcm";
    @NonNull
    public static final String PARAM_CAMPAIGN = "campaign";
    @NonNull
    public static final String PARAM_LABEL = "label";
    @NonNull
    public static final String PARAM_MEDIUM = "medium";
    @NonNull
    public static final String PARAM_MESSAGE_CHANNEL = "message_channel";
    @NonNull
    public static final String PARAM_MESSAGE_DEVICE_TIME = "_ndt";
    @NonNull
    public static final String PARAM_MESSAGE_NAME = "_nmn";
    @NonNull
    public static final String PARAM_MESSAGE_TIME = "_nmt";
    @NonNull
    public static final String PARAM_MESSAGE_TYPE = "_nmc";
    @NonNull
    public static final String PARAM_SOURCE = "source";
    @NonNull
    public static final String PARAM_TOPIC = "_nt";
    @NonNull
    public static final String USER_PROPERTY_FIREBASE_LAST_NOTIFICATION = "_ln";
    
    public static @interface MessageType
    {
      @NonNull
      public static final String DATA_MESSAGE = "data";
      @NonNull
      public static final String DISPLAY_NOTIFICATION = "display";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */