package com.google.android.gms.internal.vision;

final class zzdf
{
  static void zza(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null) {
        return;
      }
      paramObject2 = String.valueOf(paramObject1);
      paramObject1 = new StringBuilder(((String)paramObject2).length() + 26);
      ((StringBuilder)paramObject1).append("null value in entry: ");
      ((StringBuilder)paramObject1).append((String)paramObject2);
      ((StringBuilder)paramObject1).append("=null");
      throw new NullPointerException(((StringBuilder)paramObject1).toString());
    }
    paramObject2 = String.valueOf(paramObject2);
    paramObject1 = new StringBuilder(((String)paramObject2).length() + 24);
    ((StringBuilder)paramObject1).append("null key in entry: null=");
    ((StringBuilder)paramObject1).append((String)paramObject2);
    throw new NullPointerException(((StringBuilder)paramObject1).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */