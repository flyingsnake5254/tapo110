package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zacc
{
  private static final ExecutorService zahw = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NumberedThreadFactory("GAC_Transform"));
  
  public static ExecutorService zabb()
  {
    return zahw;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zacc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */