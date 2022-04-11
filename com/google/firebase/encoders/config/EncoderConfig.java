package com.google.firebase.encoders.config;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;

public abstract interface EncoderConfig<T extends EncoderConfig<T>>
{
  @NonNull
  public abstract <U> T registerEncoder(@NonNull Class<U> paramClass, @NonNull ObjectEncoder<? super U> paramObjectEncoder);
  
  @NonNull
  public abstract <U> T registerEncoder(@NonNull Class<U> paramClass, @NonNull ValueEncoder<? super U> paramValueEncoder);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\config\EncoderConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */