package com.google.firebase.encoders;

import androidx.annotation.NonNull;

public final class EncodingException
  extends RuntimeException
{
  public EncodingException(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public EncodingException(@NonNull String paramString, @NonNull Exception paramException)
  {
    super(paramString, paramException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\EncodingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */