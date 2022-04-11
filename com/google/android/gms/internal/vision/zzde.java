package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzde<T>
  implements zzcz<T>
{
  @NullableDecl
  private T value;
  private volatile zzcz<T> zzlv;
  private volatile boolean zzlw;
  
  zzde(zzcz<T> paramzzcz)
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
          this.zzlv = null;
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.value;
  }
  
  public final String toString()
  {
    Object localObject1 = this.zzlv;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = String.valueOf(this.value);
      localObject1 = new StringBuilder(((String)localObject2).length() + 25);
      ((StringBuilder)localObject1).append("<supplier that returned ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(">");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    localObject1 = String.valueOf(localObject2);
    localObject2 = new StringBuilder(((String)localObject1).length() + 19);
    ((StringBuilder)localObject2).append("Suppliers.memoize(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */