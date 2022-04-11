package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

final class zaar
  extends zac
{
  private final WeakReference<zaak> zagk;
  
  zaar(zaak paramzaak)
  {
    this.zagk = new WeakReference(paramzaak);
  }
  
  @BinderThread
  public final void zab(zaj paramzaj)
  {
    zaak localzaak = (zaak)this.zagk.get();
    if (localzaak == null) {
      return;
    }
    zaak.zad(localzaak).zaa(new zaas(this, localzaak, localzaak, paramzaj));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */