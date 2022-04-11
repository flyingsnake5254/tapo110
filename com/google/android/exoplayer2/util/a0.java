package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a0
{
  @Nullable
  private static a0 a;
  private final Handler b = new Handler(Looper.getMainLooper());
  private final CopyOnWriteArrayList<WeakReference<c>> c = new CopyOnWriteArrayList();
  private final Object d = new Object();
  @GuardedBy("networkTypeLock")
  private int e = 0;
  
  private a0(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(new d(null), localIntentFilter);
  }
  
  public static a0 c(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a0 locala0 = new com/google/android/exoplayer2/util/a0;
        locala0.<init>(paramContext);
        a = locala0;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static int d(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getSubtype())
    {
    case 16: 
    case 19: 
    default: 
      return 6;
    case 20: 
      int i;
      if (o0.a >= 29) {
        i = 9;
      } else {
        i = 0;
      }
      return i;
    case 18: 
      return 2;
    case 13: 
      return 5;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return 4;
    }
    return 3;
  }
  
  private static int f(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i = 0;
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      int j = 1;
      i = j;
      if (paramContext != null) {
        if (!paramContext.isConnected())
        {
          i = j;
        }
        else
        {
          i = paramContext.getType();
          if (i != 0) {
            if (i != 1)
            {
              if ((i != 4) && (i != 5))
              {
                if (i != 6)
                {
                  if (i != 9) {
                    return 8;
                  }
                  return 7;
                }
                return 5;
              }
            }
            else {
              return 2;
            }
          }
          return d(paramContext);
        }
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;) {}
    }
    return i;
  }
  
  private void j()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == null) {
        this.c.remove(localWeakReference);
      }
    }
  }
  
  private void k(int paramInt)
  {
    synchronized (this.d)
    {
      if (this.e == paramInt) {
        return;
      }
      this.e = paramInt;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ??? = (WeakReference)localIterator.next();
        c localc = (c)((WeakReference)???).get();
        if (localc != null) {
          localc.a(paramInt);
        } else {
          this.c.remove(???);
        }
      }
      return;
    }
  }
  
  public int e()
  {
    synchronized (this.d)
    {
      int i = this.e;
      return i;
    }
  }
  
  public void i(c paramc)
  {
    j();
    this.c.add(new WeakReference(paramc));
    this.b.post(new c(this, paramc));
  }
  
  public static final class b
  {
    private static volatile boolean a;
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
  
  private final class d
    extends BroadcastReceiver
  {
    private d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = a0.a(paramContext);
      int j = o0.a;
      if ((j >= 29) && (!a0.b.a()) && (i == 5)) {}
      try
      {
        paramIntent = (TelephonyManager)g.e((TelephonyManager)paramContext.getSystemService("phone"));
        paramContext = new com/google/android/exoplayer2/util/a0$e;
        paramContext.<init>(a0.this, null);
        if (j < 31) {
          paramIntent.listen(paramContext, 1);
        } else {
          paramIntent.listen(paramContext, 1048576);
        }
        paramIntent.listen(paramContext, 0);
        return;
      }
      catch (RuntimeException paramContext)
      {
        for (;;) {}
      }
      a0.b(a0.this, i);
    }
  }
  
  private class e
    extends PhoneStateListener
  {
    private e() {}
    
    @RequiresApi(31)
    public void onDisplayInfoChanged(TelephonyDisplayInfo paramTelephonyDisplayInfo)
    {
      int i = paramTelephonyDisplayInfo.getOverrideNetworkType();
      if ((i != 3) && (i != 4)) {
        i = 0;
      } else {
        i = 1;
      }
      paramTelephonyDisplayInfo = a0.this;
      if (i != 0) {
        i = 10;
      } else {
        i = 5;
      }
      a0.b(paramTelephonyDisplayInfo, i);
    }
    
    public void onServiceStateChanged(@Nullable ServiceState paramServiceState)
    {
      if (paramServiceState == null) {
        paramServiceState = "";
      } else {
        paramServiceState = paramServiceState.toString();
      }
      int i;
      if ((!paramServiceState.contains("nrState=CONNECTED")) && (!paramServiceState.contains("nrState=NOT_RESTRICTED"))) {
        i = 0;
      } else {
        i = 1;
      }
      paramServiceState = a0.this;
      if (i != 0) {
        i = 10;
      } else {
        i = 5;
      }
      a0.b(paramServiceState, i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */