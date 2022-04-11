package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@ShowFirstParty
public abstract class zac
{
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static final Map<Object, zac> zack = new WeakHashMap();
  
  public abstract void remove(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */