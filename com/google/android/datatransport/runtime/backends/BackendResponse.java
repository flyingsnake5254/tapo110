package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendResponse
{
  public static BackendResponse a()
  {
    return new b(Status.FATAL_ERROR, -1L);
  }
  
  public static BackendResponse d(long paramLong)
  {
    return new b(Status.OK, paramLong);
  }
  
  public static BackendResponse e()
  {
    return new b(Status.TRANSIENT_ERROR, -1L);
  }
  
  public abstract long b();
  
  public abstract Status c();
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("OK", 0);
      OK = localStatus1;
      Status localStatus2 = new Status("TRANSIENT_ERROR", 1);
      TRANSIENT_ERROR = localStatus2;
      Status localStatus3 = new Status("FATAL_ERROR", 2);
      FATAL_ERROR = localStatus3;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\BackendResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */