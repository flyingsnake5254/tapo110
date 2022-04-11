package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public abstract interface ValueEncoderContext
{
  @NonNull
  public abstract ValueEncoderContext add(double paramDouble)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(float paramFloat)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(int paramInt)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(long paramLong)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(@Nullable String paramString)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(boolean paramBoolean)
    throws IOException;
  
  @NonNull
  public abstract ValueEncoderContext add(@NonNull byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\ValueEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */