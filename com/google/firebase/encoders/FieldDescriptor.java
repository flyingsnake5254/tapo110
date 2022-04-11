package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor
{
  private final String name;
  private final Map<Class<?>, Object> properties;
  
  private FieldDescriptor(String paramString, Map<Class<?>, Object> paramMap)
  {
    this.name = paramString;
    this.properties = paramMap;
  }
  
  @NonNull
  public static Builder builder(@NonNull String paramString)
  {
    return new Builder(paramString);
  }
  
  @NonNull
  public static FieldDescriptor of(@NonNull String paramString)
  {
    return new FieldDescriptor(paramString, Collections.emptyMap());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FieldDescriptor)) {
      return false;
    }
    paramObject = (FieldDescriptor)paramObject;
    if ((!this.name.equals(((FieldDescriptor)paramObject).name)) || (!this.properties.equals(((FieldDescriptor)paramObject).properties))) {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  public String getName()
  {
    return this.name;
  }
  
  @Nullable
  public <T extends Annotation> T getProperty(@NonNull Class<T> paramClass)
  {
    return (Annotation)this.properties.get(paramClass);
  }
  
  public int hashCode()
  {
    return this.name.hashCode() * 31 + this.properties.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FieldDescriptor{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(this.properties.values());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private final String name;
    private Map<Class<?>, Object> properties = null;
    
    Builder(String paramString)
    {
      this.name = paramString;
    }
    
    @NonNull
    public FieldDescriptor build()
    {
      String str = this.name;
      Map localMap;
      if (this.properties == null) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(new HashMap(this.properties));
      }
      return new FieldDescriptor(str, localMap, null);
    }
    
    @NonNull
    public <T extends Annotation> Builder withProperty(@NonNull T paramT)
    {
      if (this.properties == null) {
        this.properties = new HashMap();
      }
      this.properties.put(paramT.annotationType(), paramT);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\FieldDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */