package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class k
{
  private static a a()
  {
    return new f.b();
  }
  
  @NonNull
  public static a i(@NonNull String paramString)
  {
    return a().g(paramString);
  }
  
  @NonNull
  public static a j(@NonNull byte[] paramArrayOfByte)
  {
    return a().f(paramArrayOfByte);
  }
  
  @Nullable
  public abstract Integer b();
  
  public abstract long c();
  
  public abstract long d();
  
  @Nullable
  public abstract NetworkConnectionInfo e();
  
  @Nullable
  public abstract byte[] f();
  
  @Nullable
  public abstract String g();
  
  public abstract long h();
  
  @AutoValue.Builder
  public static abstract class a
  {
    @NonNull
    public abstract k a();
    
    @NonNull
    public abstract a b(@Nullable Integer paramInteger);
    
    @NonNull
    public abstract a c(long paramLong);
    
    @NonNull
    public abstract a d(long paramLong);
    
    @NonNull
    public abstract a e(@Nullable NetworkConnectionInfo paramNetworkConnectionInfo);
    
    @NonNull
    abstract a f(@Nullable byte[] paramArrayOfByte);
    
    @NonNull
    abstract a g(@Nullable String paramString);
    
    @NonNull
    public abstract a h(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */