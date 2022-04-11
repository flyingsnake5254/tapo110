package com.google.android.gms.internal.clearcut;

public class zzcv
{
  private static final zzbt zzez = ;
  private zzbb zzln;
  private volatile zzdo zzlo;
  private volatile zzbb zzlp;
  
  private final zzdo zzh(zzdo paramzzdo)
  {
    if (this.zzlo == null) {
      try
      {
        if (this.zzlo != null) {}
        for (;;)
        {
          break;
          try
          {
            this.zzlo = paramzzdo;
            this.zzlp = zzbb.zzfi;
          }
          catch (zzco localzzco)
          {
            this.zzlo = paramzzdo;
            this.zzlp = zzbb.zzfi;
          }
        }
        return this.zzlo;
      }
      finally {}
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzcv)) {
      return false;
    }
    zzcv localzzcv = (zzcv)paramObject;
    paramObject = this.zzlo;
    zzdo localzzdo = localzzcv.zzlo;
    if ((paramObject == null) && (localzzdo == null)) {
      return zzr().equals(localzzcv.zzr());
    }
    if ((paramObject != null) && (localzzdo != null)) {
      return paramObject.equals(localzzdo);
    }
    if (paramObject != null) {
      return paramObject.equals(localzzcv.zzh(((zzdq)paramObject).zzbe()));
    }
    return zzh(localzzdo.zzbe()).equals(localzzdo);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int zzas()
  {
    if (this.zzlp != null) {
      return this.zzlp.size();
    }
    if (this.zzlo != null) {
      return this.zzlo.zzas();
    }
    return 0;
  }
  
  public final zzdo zzi(zzdo paramzzdo)
  {
    zzdo localzzdo = this.zzlo;
    this.zzln = null;
    this.zzlp = null;
    this.zzlo = paramzzdo;
    return localzzdo;
  }
  
  public final zzbb zzr()
  {
    if (this.zzlp != null) {
      return this.zzlp;
    }
    try
    {
      if (this.zzlp != null)
      {
        localzzbb = this.zzlp;
        return localzzbb;
      }
      if (this.zzlo == null) {}
      for (zzbb localzzbb = zzbb.zzfi;; localzzbb = this.zzlo.zzr())
      {
        this.zzlp = localzzbb;
        break;
      }
      localzzbb = this.zzlp;
      return localzzbb;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */