package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzhb
  extends zzfu<zzhb>
  implements Cloneable
{
  private static volatile zzhb[] zzbkd;
  private String value = "";
  private String zzbke = "";
  
  public zzhb()
  {
    this.zzrj = null;
    this.zzrs = -1;
  }
  
  public static zzhb[] zzge()
  {
    if (zzbkd == null) {
      synchronized (zzfy.zzrr)
      {
        if (zzbkd == null) {
          zzbkd = new zzhb[0];
        }
      }
    }
    return zzbkd;
  }
  
  private final zzhb zzgf()
  {
    try
    {
      zzhb localzzhb = (zzhb)super.zzeo();
      return localzzhb;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzhb)) {
      return false;
    }
    paramObject = (zzhb)paramObject;
    Object localObject = this.zzbke;
    if (localObject == null)
    {
      if (((zzhb)paramObject).zzbke != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzhb)paramObject).zzbke)) {
      return false;
    }
    localObject = this.value;
    if (localObject == null)
    {
      if (((zzhb)paramObject).value != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzhb)paramObject).value)) {
      return false;
    }
    localObject = this.zzrj;
    if ((localObject != null) && (!((zzfw)localObject).isEmpty())) {
      return this.zzrj.equals(((zzfu)paramObject).zzrj);
    }
    paramObject = ((zzfu)paramObject).zzrj;
    return (paramObject == null) || (((zzfw)paramObject).isEmpty());
  }
  
  public final int hashCode()
  {
    int i = zzhb.class.getName().hashCode();
    Object localObject = this.zzbke;
    int j = 0;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = this.value;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = this.zzrj;
    int n = j;
    if (localObject != null) {
      if (((zzfw)localObject).isEmpty()) {
        n = j;
      } else {
        n = this.zzrj.hashCode();
      }
    }
    return (((i + 527) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void zza(zzfs paramzzfs)
    throws IOException
  {
    String str = this.zzbke;
    if ((str != null) && (!str.equals(""))) {
      paramzzfs.zza(1, this.zzbke);
    }
    str = this.value;
    if ((str != null) && (!str.equals(""))) {
      paramzzfs.zza(2, this.value);
    }
    super.zza(paramzzfs);
  }
  
  protected final int zzen()
  {
    int i = super.zzen();
    String str = this.zzbke;
    int j = i;
    if (str != null)
    {
      j = i;
      if (!str.equals("")) {
        j = i + zzfs.zzb(1, this.zzbke);
      }
    }
    str = this.value;
    i = j;
    if (str != null)
    {
      i = j;
      if (!str.equals("")) {
        i = j + zzfs.zzb(2, this.value);
      }
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */