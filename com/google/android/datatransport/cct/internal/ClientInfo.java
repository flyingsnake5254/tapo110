package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class ClientInfo
{
  @NonNull
  public static a a()
  {
    return new e.b();
  }
  
  @Nullable
  public abstract a b();
  
  @Nullable
  public abstract ClientType c();
  
  public static enum ClientType
  {
    private final int value;
    
    static
    {
      ClientType localClientType1 = new ClientType("UNKNOWN", 0, 0);
      UNKNOWN = localClientType1;
      ClientType localClientType2 = new ClientType("ANDROID_FIREBASE", 1, 23);
      ANDROID_FIREBASE = localClientType2;
      $VALUES = new ClientType[] { localClientType1, localClientType2 };
    }
    
    private ClientType(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @AutoValue.Builder
  public static abstract class a
  {
    @NonNull
    public abstract ClientInfo a();
    
    @NonNull
    public abstract a b(@Nullable a parama);
    
    @NonNull
    public abstract a c(@Nullable ClientInfo.ClientType paramClientType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\ClientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */