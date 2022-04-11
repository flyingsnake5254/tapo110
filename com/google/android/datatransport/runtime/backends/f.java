package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.h.i;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class f
{
  public static a a()
  {
    return new a.b();
  }
  
  public abstract Iterable<i> b();
  
  @Nullable
  public abstract byte[] c();
  
  @AutoValue.Builder
  public static abstract class a
  {
    public abstract f a();
    
    public abstract a b(Iterable<i> paramIterable);
    
    public abstract a c(@Nullable byte[] paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */