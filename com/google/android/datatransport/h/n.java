package com.google.android.datatransport.h;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class n
{
  public static a a()
  {
    return new d.b().d(Priority.DEFAULT);
  }
  
  public abstract String b();
  
  @Nullable
  public abstract byte[] c();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public abstract Priority d();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public n e(Priority paramPriority)
  {
    return a().b(b()).d(paramPriority).c(c()).a();
  }
  
  public final String toString()
  {
    String str1 = b();
    Priority localPriority = d();
    String str2;
    if (c() == null) {
      str2 = "";
    } else {
      str2 = Base64.encodeToString(c(), 2);
    }
    return String.format("TransportContext(%s, %s, %s)", new Object[] { str1, localPriority, str2 });
  }
  
  @AutoValue.Builder
  public static abstract class a
  {
    public abstract n a();
    
    public abstract a b(String paramString);
    
    public abstract a c(@Nullable byte[] paramArrayOfByte);
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public abstract a d(Priority paramPriority);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */