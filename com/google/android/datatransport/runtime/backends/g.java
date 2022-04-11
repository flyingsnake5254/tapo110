package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.h.y.a;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class g
{
  public static g a(Context paramContext, a parama1, a parama2, String paramString)
  {
    return new c(paramContext, parama1, parama2, paramString);
  }
  
  public abstract Context b();
  
  @NonNull
  public abstract String c();
  
  public abstract a d();
  
  public abstract a e();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */