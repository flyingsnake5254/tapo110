package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzgy
  extends zzfu<zzgy>
  implements Cloneable
{
  private String[] zzbiw;
  private String[] zzbix;
  private int[] zzbiy;
  private long[] zzbiz;
  private long[] zzbja;
  
  public zzgy()
  {
    Object localObject = zzgb.zzsc;
    this.zzbiw = ((String[])localObject);
    this.zzbix = ((String[])localObject);
    this.zzbiy = zzgb.zzrx;
    localObject = zzgb.zzry;
    this.zzbiz = ((long[])localObject);
    this.zzbja = ((long[])localObject);
    this.zzrj = null;
    this.zzrs = -1;
  }
  
  private final zzgy zzgb()
  {
    try
    {
      zzgy localzzgy = (zzgy)super.zzeo();
      Object localObject = this.zzbiw;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzgy.zzbiw = ((String[])((String[])localObject).clone());
      }
      localObject = this.zzbix;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzgy.zzbix = ((String[])((String[])localObject).clone());
      }
      localObject = this.zzbiy;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzgy.zzbiy = ((int[])((int[])localObject).clone());
      }
      localObject = this.zzbiz;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzgy.zzbiz = ((long[])((long[])localObject).clone());
      }
      localObject = this.zzbja;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzgy.zzbja = ((long[])((long[])localObject).clone());
      }
      return localzzgy;
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
    if (!(paramObject instanceof zzgy)) {
      return false;
    }
    zzgy localzzgy = (zzgy)paramObject;
    if (!zzfy.equals(this.zzbiw, localzzgy.zzbiw)) {
      return false;
    }
    if (!zzfy.equals(this.zzbix, localzzgy.zzbix)) {
      return false;
    }
    if (!zzfy.equals(this.zzbiy, localzzgy.zzbiy)) {
      return false;
    }
    if (!zzfy.equals(this.zzbiz, localzzgy.zzbiz)) {
      return false;
    }
    if (!zzfy.equals(this.zzbja, localzzgy.zzbja)) {
      return false;
    }
    paramObject = this.zzrj;
    if ((paramObject != null) && (!((zzfw)paramObject).isEmpty())) {
      return this.zzrj.equals(localzzgy.zzrj);
    }
    paramObject = localzzgy.zzrj;
    return (paramObject == null) || (((zzfw)paramObject).isEmpty());
  }
  
  public final int hashCode()
  {
    int i = zzgy.class.getName().hashCode();
    int j = zzfy.hashCode(this.zzbiw);
    int k = zzfy.hashCode(this.zzbix);
    int m = zzfy.hashCode(this.zzbiy);
    int n = zzfy.hashCode(this.zzbiz);
    int i1 = zzfy.hashCode(this.zzbja);
    zzfw localzzfw = this.zzrj;
    int i2;
    if ((localzzfw != null) && (!localzzfw.isEmpty())) {
      i2 = this.zzrj.hashCode();
    } else {
      i2 = 0;
    }
    return ((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final void zza(zzfs paramzzfs)
    throws IOException
  {
    Object localObject = this.zzbiw;
    int i = 0;
    int j;
    if ((localObject != null) && (localObject.length > 0)) {
      for (j = 0;; j++)
      {
        localObject = this.zzbiw;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if (localObject != null) {
          paramzzfs.zza(1, (String)localObject);
        }
      }
    }
    localObject = this.zzbix;
    if ((localObject != null) && (localObject.length > 0)) {
      for (j = 0;; j++)
      {
        localObject = this.zzbix;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if (localObject != null) {
          paramzzfs.zza(2, (String)localObject);
        }
      }
    }
    localObject = this.zzbiy;
    if ((localObject != null) && (localObject.length > 0)) {
      for (j = 0;; j++)
      {
        localObject = this.zzbiy;
        if (j >= localObject.length) {
          break;
        }
        paramzzfs.zzc(3, localObject[j]);
      }
    }
    localObject = this.zzbiz;
    if ((localObject != null) && (localObject.length > 0)) {
      for (j = 0;; j++)
      {
        localObject = this.zzbiz;
        if (j >= localObject.length) {
          break;
        }
        paramzzfs.zzi(4, localObject[j]);
      }
    }
    localObject = this.zzbja;
    if ((localObject != null) && (localObject.length > 0)) {
      for (j = i;; j++)
      {
        localObject = this.zzbja;
        if (j >= localObject.length) {
          break;
        }
        paramzzfs.zzi(5, localObject[j]);
      }
    }
    super.zza(paramzzfs);
  }
  
  protected final int zzen()
  {
    int i = super.zzen();
    Object localObject = this.zzbiw;
    int j = 0;
    int k = i;
    int m;
    int i1;
    int i2;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        m = 0;
        k = 0;
        for (n = 0;; n = i2)
        {
          localObject = this.zzbiw;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          i1 = k;
          i2 = n;
          if (localObject != null)
          {
            i2 = n + 1;
            i1 = k + zzfs.zzh((String)localObject);
          }
          m++;
          k = i1;
        }
        k = i + k + n * 1;
      }
    }
    localObject = this.zzbix;
    int n = k;
    if (localObject != null)
    {
      n = k;
      if (localObject.length > 0)
      {
        i1 = 0;
        m = 0;
        for (n = 0;; n = i2)
        {
          localObject = this.zzbix;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i = m;
          i2 = n;
          if (localObject != null)
          {
            i2 = n + 1;
            i = m + zzfs.zzh((String)localObject);
          }
          i1++;
          m = i;
        }
        n = k + m + n * 1;
      }
    }
    localObject = this.zzbiy;
    k = n;
    if (localObject != null)
    {
      k = n;
      if (localObject.length > 0)
      {
        m = 0;
        k = 0;
        for (;;)
        {
          localObject = this.zzbiy;
          if (m >= localObject.length) {
            break;
          }
          k += zzfs.zzs(localObject[m]);
          m++;
        }
        k = n + k + localObject.length * 1;
      }
    }
    localObject = this.zzbiz;
    n = k;
    if (localObject != null)
    {
      n = k;
      if (localObject.length > 0)
      {
        n = 0;
        m = 0;
        for (;;)
        {
          localObject = this.zzbiz;
          if (n >= localObject.length) {
            break;
          }
          m += zzfs.zzo(localObject[n]);
          n++;
        }
        n = k + m + localObject.length * 1;
      }
    }
    localObject = this.zzbja;
    k = n;
    if (localObject != null)
    {
      k = n;
      if (localObject.length > 0)
      {
        m = 0;
        for (k = j;; k++)
        {
          localObject = this.zzbja;
          if (k >= localObject.length) {
            break;
          }
          m += zzfs.zzo(localObject[k]);
        }
        k = n + m + localObject.length * 1;
      }
    }
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */