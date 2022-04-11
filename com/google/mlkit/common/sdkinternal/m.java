package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.a.a;
import java.util.UUID;

@KeepForSdk
public class m
{
  @KeepForSdk
  public static final Component<?> a = Component.builder(m.class).add(Dependency.required(j.class)).add(Dependency.required(Context.class)).factory(a0.a).build();
  private final Context b;
  
  private m(@NonNull Context paramContext)
  {
    this.b = paramContext;
  }
  
  private final SharedPreferences e()
  {
    return this.b.getSharedPreferences("com.google.mlkit.internal", 0);
  }
  
  @KeepForSdk
  public String a()
  {
    try
    {
      String str = e().getString("ml_sdk_instance_id", null);
      if (str != null) {
        return str;
      }
      str = UUID.randomUUID().toString();
      e().edit().putString("ml_sdk_instance_id", str).apply();
      return str;
    }
    finally {}
  }
  
  @KeepForSdk
  public long b(@NonNull a parama)
  {
    try
    {
      long l = e().getLong(String.format("downloading_begin_time_%s", new Object[] { parama.c() }), 0L);
      return l;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  @KeepForSdk
  public long c(@NonNull a parama)
  {
    try
    {
      long l = e().getLong(String.format("model_first_use_time_%s", new Object[] { parama.c() }), 0L);
      return l;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  @KeepForSdk
  public void d(@NonNull a parama, long paramLong)
  {
    try
    {
      e().edit().putLong(String.format("model_first_use_time_%s", new Object[] { parama.c() }), paramLong).apply();
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */