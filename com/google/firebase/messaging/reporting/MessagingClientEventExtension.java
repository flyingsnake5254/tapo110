package com.google.firebase.messaging.reporting;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.android.gms.internal.firebase_messaging.zzz;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.io.IOException;
import java.io.OutputStream;

public final class MessagingClientEventExtension
{
  private static final MessagingClientEventExtension DEFAULT_INSTANCE = new Builder().build();
  private final MessagingClientEvent messaging_client_event_;
  
  MessagingClientEventExtension(MessagingClientEvent paramMessagingClientEvent)
  {
    this.messaging_client_event_ = paramMessagingClientEvent;
  }
  
  @NonNull
  public static MessagingClientEventExtension getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  @NonNull
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  @Encodable.Ignore
  @NonNull
  public MessagingClientEvent getMessagingClientEvent()
  {
    MessagingClientEvent localMessagingClientEvent1 = this.messaging_client_event_;
    MessagingClientEvent localMessagingClientEvent2 = localMessagingClientEvent1;
    if (localMessagingClientEvent1 == null) {
      localMessagingClientEvent2 = MessagingClientEvent.getDefaultInstance();
    }
    return localMessagingClientEvent2;
  }
  
  @Encodable.Field(name="messagingClientEvent")
  @NonNull
  @zzz(zza=1)
  public MessagingClientEvent getMessagingClientEventInternal()
  {
    return this.messaging_client_event_;
  }
  
  @NonNull
  public byte[] toByteArray()
  {
    return zze.zza(this);
  }
  
  public void writeTo(@NonNull OutputStream paramOutputStream)
    throws IOException
  {
    zze.zzb(this, paramOutputStream);
  }
  
  public static final class Builder
  {
    private MessagingClientEvent messaging_client_event_ = null;
    
    @NonNull
    public MessagingClientEventExtension build()
    {
      return new MessagingClientEventExtension(this.messaging_client_event_);
    }
    
    @NonNull
    public Builder setMessagingClientEvent(@NonNull MessagingClientEvent paramMessagingClientEvent)
    {
      this.messaging_client_event_ = paramMessagingClientEvent;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\reporting\MessagingClientEventExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */