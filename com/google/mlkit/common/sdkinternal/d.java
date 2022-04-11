package com.google.mlkit.common.sdkinternal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

@KeepForSdk
public class d
{
  private final Provider<? extends Executor> a;
  
  public d(Provider<? extends Executor> paramProvider)
  {
    this.a = paramProvider;
  }
  
  @KeepForSdk
  public Executor a(@Nullable Executor paramExecutor)
  {
    if (paramExecutor != null) {
      return paramExecutor;
    }
    return (Executor)this.a.get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */