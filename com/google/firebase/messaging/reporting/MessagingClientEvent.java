package com.google.firebase.messaging.reporting;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase_messaging.zzx;
import com.google.android.gms.internal.firebase_messaging.zzz;

public final class MessagingClientEvent
{
  private static final MessagingClientEvent DEFAULT_INSTANCE = new Builder().build();
  private final String analytics_label_;
  private final long bulk_id_;
  private final long campaign_id_;
  private final String collapse_key_;
  private final String composer_label_;
  private final Event event_;
  private final String instance_id_;
  private final String message_id_;
  private final MessageType message_type_;
  private final String package_name_;
  private final int priority_;
  private final long project_number_;
  private final SDKPlatform sdk_platform_;
  private final String topic_;
  private final int ttl_;
  
  MessagingClientEvent(long paramLong1, String paramString1, String paramString2, MessageType paramMessageType, SDKPlatform paramSDKPlatform, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, long paramLong2, Event paramEvent, String paramString6, long paramLong3, String paramString7)
  {
    this.project_number_ = paramLong1;
    this.message_id_ = paramString1;
    this.instance_id_ = paramString2;
    this.message_type_ = paramMessageType;
    this.sdk_platform_ = paramSDKPlatform;
    this.package_name_ = paramString3;
    this.collapse_key_ = paramString4;
    this.priority_ = paramInt1;
    this.ttl_ = paramInt2;
    this.topic_ = paramString5;
    this.bulk_id_ = paramLong2;
    this.event_ = paramEvent;
    this.analytics_label_ = paramString6;
    this.campaign_id_ = paramLong3;
    this.composer_label_ = paramString7;
  }
  
  @NonNull
  public static MessagingClientEvent getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  @NonNull
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  @NonNull
  @zzz(zza=13)
  public String getAnalyticsLabel()
  {
    return this.analytics_label_;
  }
  
  @zzz(zza=11)
  public long getBulkId()
  {
    return this.bulk_id_;
  }
  
  @zzz(zza=14)
  public long getCampaignId()
  {
    return this.campaign_id_;
  }
  
  @NonNull
  @zzz(zza=7)
  public String getCollapseKey()
  {
    return this.collapse_key_;
  }
  
  @NonNull
  @zzz(zza=15)
  public String getComposerLabel()
  {
    return this.composer_label_;
  }
  
  @NonNull
  @zzz(zza=12)
  public Event getEvent()
  {
    return this.event_;
  }
  
  @NonNull
  @zzz(zza=3)
  public String getInstanceId()
  {
    return this.instance_id_;
  }
  
  @NonNull
  @zzz(zza=2)
  public String getMessageId()
  {
    return this.message_id_;
  }
  
  @NonNull
  @zzz(zza=4)
  public MessageType getMessageType()
  {
    return this.message_type_;
  }
  
  @NonNull
  @zzz(zza=6)
  public String getPackageName()
  {
    return this.package_name_;
  }
  
  @zzz(zza=8)
  public int getPriority()
  {
    return this.priority_;
  }
  
  @zzz(zza=1)
  public long getProjectNumber()
  {
    return this.project_number_;
  }
  
  @NonNull
  @zzz(zza=5)
  public SDKPlatform getSdkPlatform()
  {
    return this.sdk_platform_;
  }
  
  @NonNull
  @zzz(zza=10)
  public String getTopic()
  {
    return this.topic_;
  }
  
  @zzz(zza=9)
  public int getTtl()
  {
    return this.ttl_;
  }
  
  public static final class Builder
  {
    private String analytics_label_ = "";
    private long bulk_id_ = 0L;
    private long campaign_id_ = 0L;
    private String collapse_key_ = "";
    private String composer_label_ = "";
    private MessagingClientEvent.Event event_ = MessagingClientEvent.Event.UNKNOWN_EVENT;
    private String instance_id_ = "";
    private String message_id_ = "";
    private MessagingClientEvent.MessageType message_type_ = MessagingClientEvent.MessageType.UNKNOWN;
    private String package_name_ = "";
    private int priority_ = 0;
    private long project_number_ = 0L;
    private MessagingClientEvent.SDKPlatform sdk_platform_ = MessagingClientEvent.SDKPlatform.UNKNOWN_OS;
    private String topic_ = "";
    private int ttl_ = 0;
    
    @NonNull
    public MessagingClientEvent build()
    {
      return new MessagingClientEvent(this.project_number_, this.message_id_, this.instance_id_, this.message_type_, this.sdk_platform_, this.package_name_, this.collapse_key_, this.priority_, this.ttl_, this.topic_, this.bulk_id_, this.event_, this.analytics_label_, this.campaign_id_, this.composer_label_);
    }
    
    @NonNull
    public Builder setAnalyticsLabel(@NonNull String paramString)
    {
      this.analytics_label_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setBulkId(long paramLong)
    {
      this.bulk_id_ = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setCampaignId(long paramLong)
    {
      this.campaign_id_ = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setCollapseKey(@NonNull String paramString)
    {
      this.collapse_key_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setComposerLabel(@NonNull String paramString)
    {
      this.composer_label_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setEvent(@NonNull MessagingClientEvent.Event paramEvent)
    {
      this.event_ = paramEvent;
      return this;
    }
    
    @NonNull
    public Builder setInstanceId(@NonNull String paramString)
    {
      this.instance_id_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setMessageId(@NonNull String paramString)
    {
      this.message_id_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setMessageType(@NonNull MessagingClientEvent.MessageType paramMessageType)
    {
      this.message_type_ = paramMessageType;
      return this;
    }
    
    @NonNull
    public Builder setPackageName(@NonNull String paramString)
    {
      this.package_name_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setPriority(int paramInt)
    {
      this.priority_ = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setProjectNumber(long paramLong)
    {
      this.project_number_ = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setSdkPlatform(@NonNull MessagingClientEvent.SDKPlatform paramSDKPlatform)
    {
      this.sdk_platform_ = paramSDKPlatform;
      return this;
    }
    
    @NonNull
    public Builder setTopic(@NonNull String paramString)
    {
      this.topic_ = paramString;
      return this;
    }
    
    @NonNull
    public Builder setTtl(int paramInt)
    {
      this.ttl_ = paramInt;
      return this;
    }
  }
  
  public static enum Event
    implements zzx
  {
    private final int number_;
    
    static
    {
      MESSAGE_DELIVERED = new Event("MESSAGE_DELIVERED", 1, 1);
      MESSAGE_OPEN = new Event("MESSAGE_OPEN", 2, 2);
    }
    
    private Event(int paramInt)
    {
      this.number_ = paramInt;
    }
    
    public int getNumber()
    {
      return this.number_;
    }
  }
  
  public static enum MessageType
    implements zzx
  {
    private final int number_;
    
    static
    {
      DATA_MESSAGE = new MessageType("DATA_MESSAGE", 1, 1);
      TOPIC = new MessageType("TOPIC", 2, 2);
      DISPLAY_NOTIFICATION = new MessageType("DISPLAY_NOTIFICATION", 3, 3);
    }
    
    private MessageType(int paramInt)
    {
      this.number_ = paramInt;
    }
    
    public int getNumber()
    {
      return this.number_;
    }
  }
  
  public static enum SDKPlatform
    implements zzx
  {
    private final int number_;
    
    static
    {
      ANDROID = new SDKPlatform("ANDROID", 1, 1);
      IOS = new SDKPlatform("IOS", 2, 2);
      WEB = new SDKPlatform("WEB", 3, 3);
    }
    
    private SDKPlatform(int paramInt)
    {
      this.number_ = paramInt;
    }
    
    public int getNumber()
    {
      return this.number_;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\reporting\MessagingClientEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */