package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;
import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

@AutoValue
public abstract class l
{
  @NonNull
  public static a a()
  {
    return new g.b();
  }
  
  @Nullable
  public abstract ClientInfo b();
  
  @Encodable.Field(name="logEvent")
  @Nullable
  public abstract List<k> c();
  
  @Nullable
  public abstract Integer d();
  
  @Nullable
  public abstract String e();
  
  @Nullable
  public abstract QosTier f();
  
  public abstract long g();
  
  public abstract long h();
  
  @AutoValue.Builder
  public static abstract class a
  {
    @NonNull
    public abstract l a();
    
    @NonNull
    public abstract a b(@Nullable ClientInfo paramClientInfo);
    
    @NonNull
    public abstract a c(@Nullable List<k> paramList);
    
    @NonNull
    abstract a d(@Nullable Integer paramInteger);
    
    @NonNull
    abstract a e(@Nullable String paramString);
    
    @NonNull
    public abstract a f(@Nullable QosTier paramQosTier);
    
    @NonNull
    public abstract a g(long paramLong);
    
    @NonNull
    public abstract a h(long paramLong);
    
    @NonNull
    public a i(int paramInt)
    {
      return d(Integer.valueOf(paramInt));
    }
    
    @NonNull
    public a j(@NonNull String paramString)
    {
      return e(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */