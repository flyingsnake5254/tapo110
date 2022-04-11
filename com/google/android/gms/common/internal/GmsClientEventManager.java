package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager
  implements Handler.Callback
{
  private final Handler mHandler;
  private final Object mLock = new Object();
  private final GmsClientEventState zaol;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaom = new ArrayList();
  @VisibleForTesting
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaon = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zaoo = new ArrayList();
  private volatile boolean zaop = false;
  private final AtomicInteger zaoq = new AtomicInteger(0);
  private boolean zaor = false;
  
  public GmsClientEventManager(Looper paramLooper, GmsClientEventState paramGmsClientEventState)
  {
    this.zaol = paramGmsClientEventState;
    this.mHandler = new zap(paramLooper, this);
  }
  
  public final boolean areCallbacksEnabled()
  {
    return this.zaop;
  }
  
  public final void disableCallbacks()
  {
    this.zaop = false;
    this.zaoq.incrementAndGet();
  }
  
  public final void enableCallbacks()
  {
    this.zaop = true;
  }
  
  public final boolean handleMessage(Message arg1)
  {
    int i = ???.what;
    if (i == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.mLock)
      {
        if ((this.zaop) && (this.zaol.isConnected()) && (this.zaom.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zaol.getConnectionHint());
        }
        return true;
      }
    }
    ??? = new StringBuilder(45);
    ???.append("Don't know how to handle message: ");
    ???.append(i);
    Log.wtf("GmsClientEvents", ???.toString(), new Exception());
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      boolean bool = this.zaom.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      boolean bool = this.zaoo.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  @VisibleForTesting
  public final void onConnectionFailure(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkHandlerThread(this.mHandler, "onConnectionFailure must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.zaoo);
      int i = this.zaoq.get();
      int j = localArrayList.size();
      int k = 0;
      while (k < j)
      {
        Object localObject2 = localArrayList.get(k);
        int m = k + 1;
        localObject2 = (GoogleApiClient.OnConnectionFailedListener)localObject2;
        if ((this.zaop) && (this.zaoq.get() == i))
        {
          k = m;
          if (this.zaoo.contains(localObject2))
          {
            ((GoogleApiClient.OnConnectionFailedListener)localObject2).onConnectionFailed(paramConnectionResult);
            k = m;
          }
        }
        else
        {
          return;
        }
      }
      return;
    }
  }
  
  @VisibleForTesting
  protected final void onConnectionSuccess()
  {
    synchronized (this.mLock)
    {
      onConnectionSuccess(this.zaol.getConnectionHint());
      return;
    }
  }
  
  @VisibleForTesting
  public final void onConnectionSuccess(Bundle paramBundle)
  {
    Preconditions.checkHandlerThread(this.mHandler, "onConnectionSuccess must only be called on the Handler thread");
    synchronized (this.mLock)
    {
      boolean bool1 = this.zaor;
      boolean bool2 = true;
      if (!bool1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1);
      this.mHandler.removeMessages(1);
      this.zaor = true;
      if (this.zaon.size() == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1);
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.zaom);
      int i = this.zaoq.get();
      int j = localArrayList.size();
      int k = 0;
      while (k < j)
      {
        Object localObject2 = localArrayList.get(k);
        int m = k + 1;
        localObject2 = (GoogleApiClient.ConnectionCallbacks)localObject2;
        if ((!this.zaop) || (!this.zaol.isConnected()) || (this.zaoq.get() != i)) {
          break;
        }
        k = m;
        if (!this.zaon.contains(localObject2))
        {
          ((GoogleApiClient.ConnectionCallbacks)localObject2).onConnected(paramBundle);
          k = m;
        }
      }
      this.zaon.clear();
      this.zaor = false;
      return;
    }
  }
  
  @VisibleForTesting
  public final void onUnintentionalDisconnection(int paramInt)
  {
    Preconditions.checkHandlerThread(this.mHandler, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.mLock)
    {
      this.zaor = true;
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.zaom);
      int i = this.zaoq.get();
      int j = localArrayList.size();
      int k = 0;
      while (k < j)
      {
        Object localObject3 = localArrayList.get(k);
        int m = k + 1;
        localObject3 = (GoogleApiClient.ConnectionCallbacks)localObject3;
        if ((!this.zaop) || (this.zaoq.get() != i)) {
          break;
        }
        k = m;
        if (this.zaom.contains(localObject3))
        {
          ((GoogleApiClient.ConnectionCallbacks)localObject3).onConnectionSuspended(paramInt);
          k = m;
        }
      }
      this.zaon.clear();
      this.zaor = false;
      return;
    }
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (this.zaom.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        int i = str.length();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(i + 62);
        localStringBuilder.append("registerConnectionCallbacks(): listener ");
        localStringBuilder.append(str);
        localStringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      else
      {
        this.zaom.add(paramConnectionCallbacks);
      }
      if (this.zaol.isConnected())
      {
        ??? = this.mHandler;
        ((Handler)???).sendMessage(((Handler)???).obtainMessage(1, paramConnectionCallbacks));
      }
      return;
    }
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (this.zaoo.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        int i = paramOnConnectionFailedListener.length();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(i + 67);
        localStringBuilder.append("registerConnectionFailedListener(): listener ");
        localStringBuilder.append(paramOnConnectionFailedListener);
        localStringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      else
      {
        this.zaoo.add(paramOnConnectionFailedListener);
      }
      return;
    }
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (!this.zaom.remove(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        int i = str.length();
        paramConnectionCallbacks = new java/lang/StringBuilder;
        paramConnectionCallbacks.<init>(i + 52);
        paramConnectionCallbacks.append("unregisterConnectionCallbacks(): listener ");
        paramConnectionCallbacks.append(str);
        paramConnectionCallbacks.append(" not found");
        Log.w("GmsClientEvents", paramConnectionCallbacks.toString());
      }
      else if (this.zaor)
      {
        this.zaon.add(paramConnectionCallbacks);
      }
      return;
    }
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (!this.zaoo.remove(paramOnConnectionFailedListener))
      {
        String str = String.valueOf(paramOnConnectionFailedListener);
        int i = str.length();
        paramOnConnectionFailedListener = new java/lang/StringBuilder;
        paramOnConnectionFailedListener.<init>(i + 57);
        paramOnConnectionFailedListener.append("unregisterConnectionFailedListener(): listener ");
        paramOnConnectionFailedListener.append(str);
        paramOnConnectionFailedListener.append(" not found");
        Log.w("GmsClientEvents", paramOnConnectionFailedListener.toString());
      }
      return;
    }
  }
  
  @VisibleForTesting
  public static abstract interface GmsClientEventState
  {
    public abstract Bundle getConnectionHint();
    
    public abstract boolean isConnected();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\GmsClientEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */