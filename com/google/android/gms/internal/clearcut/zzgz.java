package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzgz
  extends zzfu<zzgz>
  implements Cloneable
{
  private byte[] zzbjb = zzgb.zzse;
  private String zzbjc = "";
  private byte[][] zzbjd = zzgb.zzsd;
  private boolean zzbje = false;
  
  public zzgz()
  {
    this.zzrj = null;
    this.zzrs = -1;
  }
  
  private final zzgz zzgc()
  {
    try
    {
      zzgz localzzgz = (zzgz)super.zzeo();
      byte[][] arrayOfByte = this.zzbjd;
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        localzzgz.zzbjd = ((byte[][])arrayOfByte.clone());
      }
      return localzzgz;
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
    if (!(paramObject instanceof zzgz)) {
      return false;
    }
    paramObject = (zzgz)paramObject;
    if (!Arrays.equals(this.zzbjb, ((zzgz)paramObject).zzbjb)) {
      return false;
    }
    Object localObject = this.zzbjc;
    if (localObject == null)
    {
      if (((zzgz)paramObject).zzbjc != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzgz)paramObject).zzbjc)) {
      return false;
    }
    if (!zzfy.zza(this.zzbjd, ((zzgz)paramObject).zzbjd)) {
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
    int i = zzgz.class.getName().hashCode();
    int j = Arrays.hashCode(this.zzbjb);
    Object localObject = this.zzbjc;
    int k = 0;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    int n = zzfy.zza(this.zzbjd);
    localObject = this.zzrj;
    int i1 = k;
    if (localObject != null) {
      if (((zzfw)localObject).isEmpty()) {
        i1 = k;
      } else {
        i1 = this.zzrj.hashCode();
      }
    }
    return (((((i + 527) * 31 + j) * 31 + m) * 31 + n) * 31 + 1237) * 31 + i1;
  }
  
  public final void zza(zzfs paramzzfs)
    throws IOException
  {
    if (!Arrays.equals(this.zzbjb, zzgb.zzse)) {
      paramzzfs.zza(1, this.zzbjb);
    }
    Object localObject = this.zzbjd;
    if ((localObject != null) && (localObject.length > 0)) {
      for (int i = 0;; i++)
      {
        localObject = this.zzbjd;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramzzfs.zza(2, (byte[])localObject);
        }
      }
    }
    localObject = this.zzbjc;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramzzfs.zza(4, this.zzbjc);
    }
    super.zza(paramzzfs);
  }
  
  protected final int zzen()
  {
    int i = super.zzen();
    int j = i;
    if (!Arrays.equals(this.zzbjb, zzgb.zzse)) {
      j = i + zzfs.zzb(1, this.zzbjb);
    }
    Object localObject = this.zzbjd;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        int k = 0;
        i = 0;
        int i1;
        for (int m = 0;; m = i1)
        {
          localObject = this.zzbjd;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          int n = i;
          i1 = m;
          if (localObject != null)
          {
            i1 = m + 1;
            n = i + zzfs.zzh((byte[])localObject);
          }
          k++;
          i = n;
        }
        i = j + i + m * 1;
      }
    }
    localObject = this.zzbjc;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzfs.zzb(4, this.zzbjc);
      }
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */