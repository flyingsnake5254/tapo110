package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzie<T>
  implements Serializable, zzib
{
  @NullableDecl
  final T zza;
  
  zzie(@NullableDecl T paramT)
  {
    this.zza = paramT;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof zzie))
    {
      Object localObject = (zzie)paramObject;
      paramObject = this.zza;
      localObject = ((zzie)localObject).zza;
      return (paramObject == localObject) || (paramObject.equals(localObject));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.zza });
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zza);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 22);
    localStringBuilder.append("Suppliers.ofInstance(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final T zza()
  {
    return (T)this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */