package com.google.android.gms.internal.base;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zao
  implements zal
{
  @NonNull
  public final ExecutorService zaa(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    return Executors.newFixedThreadPool(2, paramThreadFactory);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\base\zao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */