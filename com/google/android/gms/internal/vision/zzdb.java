package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdb<T>
  implements zzcz<T>, Serializable
{
  @NullableDecl
  private transient T value;
  private final zzcz<T> zzlv;
  private volatile transient boolean zzlw;
  
  zzdb(zzcz<T> paramzzcz)
  {
    this.zzlv = ((zzcz)zzcy.checkNotNull(paramzzcz));
  }
  
  public final T get()
  {
    if (!this.zzlw) {
      try
      {
        if (!this.zzlw)
        {
          Object localObject1 = this.zzlv.get();
          this.value = localObject1;
          this.zzlw = true;
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.value;
  }
  
  public final String toString()
  {
    if (this.zzlw)
    {
      str = String.valueOf(this.value);
      localObject = new StringBuilder(str.length() + 25);
      ((StringBuilder)localObject).append("<supplier that returned ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(">");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.zzlv;
    }
    String str = String.valueOf(localObject);
    Object localObject = new StringBuilder(str.length() + 19);
    ((StringBuilder)localObject).append("Suppliers.memoize(");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(")");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */