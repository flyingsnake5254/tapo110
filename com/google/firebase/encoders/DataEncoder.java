package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.Writer;

public abstract interface DataEncoder
{
  @NonNull
  public abstract String encode(@NonNull Object paramObject);
  
  public abstract void encode(@NonNull Object paramObject, @NonNull Writer paramWriter)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\DataEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */