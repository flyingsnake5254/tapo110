package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UserMetadata
{
  static final int MAX_ATTRIBUTES = 64;
  static final int MAX_ATTRIBUTE_SIZE = 1024;
  private final Map<String, String> attributes = new HashMap();
  private String userId = null;
  
  private static String sanitizeAttribute(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
    }
    return str;
  }
  
  private static String sanitizeKey(String paramString)
  {
    if (paramString != null) {
      return sanitizeAttribute(paramString);
    }
    throw new IllegalArgumentException("Custom attribute key must not be null.");
  }
  
  private void setSyncCustomKeys(Map<String, String> paramMap)
  {
    try
    {
      HashMap localHashMap1 = new java/util/HashMap;
      localHashMap1.<init>();
      HashMap localHashMap2 = new java/util/HashMap;
      localHashMap2.<init>();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str = sanitizeKey((String)paramMap.getKey());
        if (paramMap.getValue() == null) {
          paramMap = "";
        } else {
          paramMap = sanitizeAttribute((String)paramMap.getValue());
        }
        if (this.attributes.containsKey(str)) {
          localHashMap1.put(str, paramMap);
        } else {
          localHashMap2.put(str, paramMap);
        }
      }
      this.attributes.putAll(localHashMap1);
      if (this.attributes.size() + localHashMap2.size() > 64)
      {
        int i = this.attributes.size();
        Logger.getLogger().v("Exceeded maximum number of custom attributes (64).");
        paramMap = new java/util/ArrayList;
        paramMap.<init>(localHashMap2.keySet());
        localHashMap2.keySet().retainAll(paramMap.subList(0, 64 - i));
      }
      this.attributes.putAll(localHashMap2);
      return;
    }
    finally {}
  }
  
  @NonNull
  public Map<String, String> getCustomKeys()
  {
    return Collections.unmodifiableMap(this.attributes);
  }
  
  @Nullable
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setCustomKey(final String paramString1, final String paramString2)
  {
    setSyncCustomKeys(new HashMap() {});
  }
  
  public void setCustomKeys(Map<String, String> paramMap)
  {
    setSyncCustomKeys(paramMap);
  }
  
  public void setUserId(String paramString)
  {
    this.userId = sanitizeAttribute(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\UserMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */