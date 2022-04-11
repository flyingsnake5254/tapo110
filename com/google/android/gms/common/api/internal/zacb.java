package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacb
  extends UnregisterListenerMethod<A, L>
{
  zacb(RegistrationMethods.Builder paramBuilder, ListenerHolder.ListenerKey paramListenerKey)
  {
    super(paramListenerKey);
  }
  
  protected final void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource)
    throws RemoteException
  {
    RegistrationMethods.Builder.zab(this.zakh).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zacb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */