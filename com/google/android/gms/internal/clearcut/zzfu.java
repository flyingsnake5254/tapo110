package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class zzfu<M extends zzfu<M>>
  extends zzfz
{
  protected zzfw zzrj;
  
  public void zza(zzfs paramzzfs)
    throws IOException
  {
    if (this.zzrj == null) {
      return;
    }
    for (int i = 0; i < this.zzrj.size(); i++) {
      this.zzrj.zzaq(i).zza(paramzzfs);
    }
  }
  
  protected int zzen()
  {
    if (this.zzrj != null) {
      for (int i = 0; i < this.zzrj.size(); i++) {
        this.zzrj.zzaq(i).zzen();
      }
    }
    return 0;
  }
  
  public M zzeo()
    throws CloneNotSupportedException
  {
    zzfu localzzfu = (zzfu)super.zzep();
    zzfy.zza(this, localzzfu);
    return localzzfu;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */