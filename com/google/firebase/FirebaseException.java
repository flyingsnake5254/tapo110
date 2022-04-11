package com.google.firebase;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException
  extends Exception
{
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(@NonNull String paramString)
  {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"));
  }
  
  public FirebaseException(@NonNull String paramString, Throwable paramThrowable)
  {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"), paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */