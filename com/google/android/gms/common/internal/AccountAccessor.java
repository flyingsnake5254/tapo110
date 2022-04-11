package com.google.android.gms.common.internal;

import android.accounts.Account;

public class AccountAccessor
  extends IAccountAccessor.Stub
{
  /* Error */
  @com.google.android.gms.common.annotation.KeepForSdk
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +47 -> 48
    //   4: invokestatic 15	android/os/Binder:clearCallingIdentity	()J
    //   7: lstore_1
    //   8: aload_0
    //   9: invokeinterface 21 1 0
    //   14: astore_0
    //   15: lload_1
    //   16: invokestatic 25	android/os/Binder:restoreCallingIdentity	(J)V
    //   19: goto +31 -> 50
    //   22: astore_0
    //   23: goto +19 -> 42
    //   26: astore_0
    //   27: ldc 27
    //   29: ldc 29
    //   31: invokestatic 35	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: lload_1
    //   36: invokestatic 25	android/os/Binder:restoreCallingIdentity	(J)V
    //   39: goto +9 -> 48
    //   42: lload_1
    //   43: invokestatic 25	android/os/Binder:restoreCallingIdentity	(J)V
    //   46: aload_0
    //   47: athrow
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramIAccountAccessor	IAccountAccessor
    //   7	36	1	l	long
    // Exception table:
    //   from	to	target	type
    //   8	15	22	finally
    //   27	35	22	finally
    //   8	15	26	android/os/RemoteException
  }
  
  public boolean equals(Object paramObject)
  {
    throw new NoSuchMethodError();
  }
  
  public final Account getAccount()
  {
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\AccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */