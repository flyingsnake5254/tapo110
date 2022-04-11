package com.google.android.gms.internal.vision;

import android.util.Log;

final class zzbl
  extends zzbj<Long>
{
  zzbl(zzbp paramzzbp, String paramString, Long paramLong, boolean paramBoolean)
  {
    super(paramzzbp, paramString, paramLong, paramBoolean, null);
  }
  
  private final Long zzb(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return (Long)paramObject;
    }
    if ((paramObject instanceof String)) {}
    try
    {
      long l = Long.parseLong((String)paramObject);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    str = super.zzad();
    paramObject = String.valueOf(paramObject);
    localStringBuilder = new StringBuilder(String.valueOf(str).length() + 25 + ((String)paramObject).length());
    localStringBuilder.append("Invalid long value for ");
    localStringBuilder.append(str);
    localStringBuilder.append(": ");
    localStringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", localStringBuilder.toString());
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */