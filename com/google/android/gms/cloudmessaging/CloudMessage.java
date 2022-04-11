package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator="CloudMessageCreator")
public final class CloudMessage
  extends AbstractSafeParcelable
{
  @NonNull
  public static final Parcelable.Creator<CloudMessage> CREATOR = new zzb();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  @NonNull
  @SafeParcelable.Field(id=1)
  private Intent zza;
  @GuardedBy("this")
  private Map<String, String> zzb;
  
  @SafeParcelable.Constructor
  public CloudMessage(@NonNull @SafeParcelable.Param(id=1) Intent paramIntent)
  {
    this.zza = paramIntent;
  }
  
  private static int zza(@Nullable String paramString)
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
  public final String getCollapseKey()
  {
    return this.zza.getStringExtra("collapse_key");
  }
  
  @NonNull
  public final Map<String, String> getData()
  {
    try
    {
      if (this.zzb == null)
      {
        Bundle localBundle = this.zza.getExtras();
        localObject1 = new androidx/collection/ArrayMap;
        ((ArrayMap)localObject1).<init>();
        if (localBundle != null)
        {
          Iterator localIterator = localBundle.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject3 = localBundle.get(str);
            if ((localObject3 instanceof String))
            {
              localObject3 = (String)localObject3;
              if ((!str.startsWith("google.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
                ((SimpleArrayMap)localObject1).put(str, localObject3);
              }
            }
          }
        }
        this.zzb = ((Map)localObject1);
      }
      Object localObject1 = this.zzb;
      return (Map<String, String>)localObject1;
    }
    finally {}
  }
  
  @Nullable
  public final String getFrom()
  {
    return this.zza.getStringExtra("from");
  }
  
  @NonNull
  public final Intent getIntent()
  {
    return this.zza;
  }
  
  @Nullable
  public final String getMessageId()
  {
    String str1 = this.zza.getStringExtra("google.message_id");
    String str2 = str1;
    if (str1 == null) {
      str2 = this.zza.getStringExtra("message_id");
    }
    return str2;
  }
  
  @Nullable
  public final String getMessageType()
  {
    return this.zza.getStringExtra("message_type");
  }
  
  public final int getOriginalPriority()
  {
    String str1 = this.zza.getStringExtra("google.original_priority");
    String str2 = str1;
    if (str1 == null) {
      str2 = this.zza.getStringExtra("google.priority");
    }
    return zza(str2);
  }
  
  public final int getPriority()
  {
    String str1 = this.zza.getStringExtra("google.delivered_priority");
    String str2 = str1;
    if (str1 == null)
    {
      if ("1".equals(this.zza.getStringExtra("google.priority_reduced"))) {
        return 2;
      }
      str2 = this.zza.getStringExtra("google.priority");
    }
    return zza(str2);
  }
  
  @Nullable
  public final byte[] getRawData()
  {
    return this.zza.getByteArrayExtra("rawData");
  }
  
  @Nullable
  public final String getSenderId()
  {
    return this.zza.getStringExtra("google.c.sender.id");
  }
  
  public final long getSentTime()
  {
    Object localObject = this.zza.getExtras();
    if (localObject != null) {
      localObject = ((Bundle)localObject).get("google.sent_time");
    } else {
      localObject = null;
    }
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
        Log.w("CloudMessage", ((StringBuilder)localObject).toString());
      }
    }
    return 0L;
  }
  
  @Nullable
  public final String getTo()
  {
    return this.zza.getStringExtra("google.to");
  }
  
  public final int getTtl()
  {
    Object localObject = this.zza.getExtras();
    if (localObject != null) {
      localObject = ((Bundle)localObject).get("google.ttl");
    } else {
      localObject = null;
    }
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
        Log.w("CloudMessage", localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zza, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE_PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
  public static @interface MessagePriority {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\CloudMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */