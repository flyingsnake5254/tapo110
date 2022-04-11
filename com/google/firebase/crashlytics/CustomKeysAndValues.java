package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class CustomKeysAndValues
{
  final Map<String, String> keysAndValues;
  
  CustomKeysAndValues(@NonNull Builder paramBuilder)
  {
    this.keysAndValues = paramBuilder.keysAndValues;
  }
  
  public static class Builder
  {
    private Map<String, String> keysAndValues = new HashMap();
    
    @NonNull
    public CustomKeysAndValues build()
    {
      return new CustomKeysAndValues(this);
    }
    
    @NonNull
    public Builder putBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      this.keysAndValues.put(paramString, Boolean.toString(paramBoolean));
      return this;
    }
    
    @NonNull
    public Builder putDouble(@NonNull String paramString, double paramDouble)
    {
      this.keysAndValues.put(paramString, Double.toString(paramDouble));
      return this;
    }
    
    @NonNull
    public Builder putFloat(@NonNull String paramString, float paramFloat)
    {
      this.keysAndValues.put(paramString, Float.toString(paramFloat));
      return this;
    }
    
    @NonNull
    public Builder putInt(@NonNull String paramString, int paramInt)
    {
      this.keysAndValues.put(paramString, Integer.toString(paramInt));
      return this;
    }
    
    @NonNull
    public Builder putLong(@NonNull String paramString, long paramLong)
    {
      this.keysAndValues.put(paramString, Long.toString(paramLong));
      return this;
    }
    
    @NonNull
    public Builder putString(@NonNull String paramString1, @NonNull String paramString2)
    {
      this.keysAndValues.put(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\CustomKeysAndValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */