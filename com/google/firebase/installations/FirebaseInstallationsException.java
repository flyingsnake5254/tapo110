package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException
  extends FirebaseException
{
  @NonNull
  private final Status status;
  
  public FirebaseInstallationsException(@NonNull Status paramStatus)
  {
    this.status = paramStatus;
  }
  
  public FirebaseInstallationsException(@NonNull String paramString, @NonNull Status paramStatus)
  {
    super(paramString);
    this.status = paramStatus;
  }
  
  public FirebaseInstallationsException(@NonNull String paramString, @NonNull Status paramStatus, @NonNull Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.status = paramStatus;
  }
  
  @NonNull
  public Status getStatus()
  {
    return this.status;
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("BAD_CONFIG", 0);
      BAD_CONFIG = localStatus1;
      Status localStatus2 = new Status("UNAVAILABLE", 1);
      UNAVAILABLE = localStatus2;
      Status localStatus3 = new Status("TOO_MANY_REQUESTS", 2);
      TOO_MANY_REQUESTS = localStatus3;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\FirebaseInstallationsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */