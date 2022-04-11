package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TopicOperation
{
  private static final Pattern TOPIC_NAME_REGEXP = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
  private final String operation;
  private final String serializedString;
  private final String topic;
  
  private TopicOperation(String paramString1, String paramString2)
  {
    this.topic = normalizeTopicOrThrow(paramString2, paramString1);
    this.operation = paramString1;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append("!");
    localStringBuilder.append(paramString2);
    this.serializedString = localStringBuilder.toString();
  }
  
  @Nullable
  static TopicOperation from(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("!", -1);
    if (paramString.length != 2) {
      return null;
    }
    return new TopicOperation(paramString[0], paramString[1]);
  }
  
  @NonNull
  private static String normalizeTopicOrThrow(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.startsWith("/topics/"))
      {
        Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[] { paramString2 }));
        str = paramString1.substring(8);
      }
    }
    if ((str != null) && (TOPIC_NAME_REGEXP.matcher(str).matches())) {
      return str;
    }
    throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[] { str, "[a-zA-Z0-9-_.~%]{1,900}" }));
  }
  
  public static TopicOperation subscribe(@NonNull String paramString)
  {
    return new TopicOperation("S", paramString);
  }
  
  public static TopicOperation unsubscribe(@NonNull String paramString)
  {
    return new TopicOperation("U", paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof TopicOperation)) {
      return false;
    }
    paramObject = (TopicOperation)paramObject;
    return (this.topic.equals(((TopicOperation)paramObject).topic)) && (this.operation.equals(((TopicOperation)paramObject).operation));
  }
  
  public String getOperation()
  {
    return this.operation;
  }
  
  public String getTopic()
  {
    return this.topic;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.operation, this.topic });
  }
  
  public String serialize()
  {
    return this.serializedString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\TopicOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */