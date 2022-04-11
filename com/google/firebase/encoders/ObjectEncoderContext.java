package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public abstract interface ObjectEncoderContext
{
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, double paramDouble)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, float paramFloat)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, int paramInt)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, long paramLong)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, @Nullable Object paramObject)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, boolean paramBoolean)
    throws IOException;
  
  @Deprecated
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull String paramString, double paramDouble)
    throws IOException;
  
  @Deprecated
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull String paramString, int paramInt)
    throws IOException;
  
  @Deprecated
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull String paramString, long paramLong)
    throws IOException;
  
  @Deprecated
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull String paramString, @Nullable Object paramObject)
    throws IOException;
  
  @Deprecated
  @NonNull
  public abstract ObjectEncoderContext add(@NonNull String paramString, boolean paramBoolean)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext inline(@Nullable Object paramObject)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext nested(@NonNull FieldDescriptor paramFieldDescriptor)
    throws IOException;
  
  @NonNull
  public abstract ObjectEncoderContext nested(@NonNull String paramString)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\ObjectEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */