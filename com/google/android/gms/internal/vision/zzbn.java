package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzbn
  extends zzbj<T>
{
  zzbn(zzbp paramzzbp, String paramString, Object paramObject, boolean paramBoolean, zzbm paramzzbm)
  {
    super(paramzzbp, paramString, paramObject, paramBoolean, null);
  }
  
  final T zza(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    try
    {
      localObject = this.zzgq.zzb(Base64.decode((String)paramObject, 3));
      return (T)localObject;
    }
    catch (IOException|IllegalArgumentException localIOException)
    {
      Object localObject;
      String str;
      for (;;) {}
    }
    localObject = super.zzad();
    str = String.valueOf(paramObject);
    paramObject = new StringBuilder(String.valueOf(localObject).length() + 27 + str.length());
    ((StringBuilder)paramObject).append("Invalid byte[] value for ");
    ((StringBuilder)paramObject).append((String)localObject);
    ((StringBuilder)paramObject).append(": ");
    ((StringBuilder)paramObject).append(str);
    Log.e("PhenotypeFlag", ((StringBuilder)paramObject).toString());
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */