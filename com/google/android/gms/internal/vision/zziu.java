package com.google.android.gms.internal.vision;

final class zziu
  implements zzif
{
  private final int flags;
  private final String info;
  private final Object[] zzzk;
  private final zzih zzzn;
  
  zziu(zzih paramzzih, String paramString, Object[] paramArrayOfObject)
  {
    this.zzzn = paramzzih;
    this.info = paramString;
    this.zzzk = paramArrayOfObject;
    int i = paramString.charAt(0);
    if (i < 55296)
    {
      this.flags = i;
      return;
    }
    int j = i & 0x1FFF;
    int k = 13;
    int m;
    for (i = 1;; i++)
    {
      m = paramString.charAt(i);
      if (m < 55296) {
        break;
      }
      j |= (m & 0x1FFF) << k;
      k += 13;
    }
    this.flags = (j | m << k);
  }
  
  public final int zzhj()
  {
    if ((this.flags & 0x1) == 1) {
      return zzgx.zzf.zzxi;
    }
    return zzgx.zzf.zzxj;
  }
  
  public final boolean zzhk()
  {
    return (this.flags & 0x2) == 2;
  }
  
  public final zzih zzhl()
  {
    return this.zzzn;
  }
  
  final String zzhq()
  {
    return this.info;
  }
  
  final Object[] zzhr()
  {
    return this.zzzk;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */