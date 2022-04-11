package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

abstract interface Encoder<TValue, TContext>
{
  public abstract void encode(@NonNull TValue paramTValue, @NonNull TContext paramTContext)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */