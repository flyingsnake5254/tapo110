package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.h.y.a;
import java.util.Objects;

final class c
  extends g
{
  private final Context a;
  private final a b;
  private final a c;
  private final String d;
  
  c(Context paramContext, a parama1, a parama2, String paramString)
  {
    Objects.requireNonNull(paramContext, "Null applicationContext");
    this.a = paramContext;
    Objects.requireNonNull(parama1, "Null wallClock");
    this.b = parama1;
    Objects.requireNonNull(parama2, "Null monotonicClock");
    this.c = parama2;
    Objects.requireNonNull(paramString, "Null backendName");
    this.d = paramString;
  }
  
  public Context b()
  {
    return this.a;
  }
  
  @NonNull
  public String c()
  {
    return this.d;
  }
  
  public a d()
  {
    return this.c;
  }
  
  public a e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((!this.a.equals(((g)paramObject).b())) || (!this.b.equals(((g)paramObject).e())) || (!this.c.equals(((g)paramObject).d())) || (!this.d.equals(((g)paramObject).c()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreationContext{applicationContext=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", wallClock=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", monotonicClock=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", backendName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */