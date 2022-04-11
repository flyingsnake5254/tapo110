package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MultiInstanceInvalidationClient
{
  final Context mAppContext;
  final IMultiInstanceInvalidationCallback mCallback = new IMultiInstanceInvalidationCallback.Stub()
  {
    public void onInvalidation(final String[] paramAnonymousArrayOfString)
    {
      MultiInstanceInvalidationClient.this.mExecutor.execute(new Runnable()
      {
        public void run()
        {
          MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(paramAnonymousArrayOfString);
        }
      });
    }
  };
  int mClientId;
  final Executor mExecutor;
  final InvalidationTracker mInvalidationTracker;
  final String mName;
  final InvalidationTracker.Observer mObserver;
  final Runnable mRemoveObserverRunnable;
  @Nullable
  IMultiInstanceInvalidationService mService;
  final ServiceConnection mServiceConnection;
  final Runnable mSetUpRunnable;
  final AtomicBoolean mStopped = new AtomicBoolean(false);
  private final Runnable mTearDownRunnable;
  
  MultiInstanceInvalidationClient(Context paramContext, String paramString, InvalidationTracker paramInvalidationTracker, Executor paramExecutor)
  {
    ServiceConnection local2 = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        MultiInstanceInvalidationClient.this.mService = IMultiInstanceInvalidationService.Stub.asInterface(paramAnonymousIBinder);
        paramAnonymousComponentName = MultiInstanceInvalidationClient.this;
        paramAnonymousComponentName.mExecutor.execute(paramAnonymousComponentName.mSetUpRunnable);
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        paramAnonymousComponentName = MultiInstanceInvalidationClient.this;
        paramAnonymousComponentName.mExecutor.execute(paramAnonymousComponentName.mRemoveObserverRunnable);
        MultiInstanceInvalidationClient.this.mService = null;
      }
    };
    this.mServiceConnection = local2;
    this.mSetUpRunnable = new Runnable()
    {
      public void run()
      {
        try
        {
          MultiInstanceInvalidationClient localMultiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
          Object localObject = localMultiInstanceInvalidationClient.mService;
          if (localObject != null)
          {
            localMultiInstanceInvalidationClient.mClientId = ((IMultiInstanceInvalidationService)localObject).registerCallback(localMultiInstanceInvalidationClient.mCallback, localMultiInstanceInvalidationClient.mName);
            localObject = MultiInstanceInvalidationClient.this;
            ((MultiInstanceInvalidationClient)localObject).mInvalidationTracker.addObserver(((MultiInstanceInvalidationClient)localObject).mObserver);
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("ROOM", "Cannot register multi-instance invalidation callback", localRemoteException);
        }
      }
    };
    this.mRemoveObserverRunnable = new Runnable()
    {
      public void run()
      {
        MultiInstanceInvalidationClient localMultiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
        localMultiInstanceInvalidationClient.mInvalidationTracker.removeObserver(localMultiInstanceInvalidationClient.mObserver);
      }
    };
    this.mTearDownRunnable = new Runnable()
    {
      public void run()
      {
        Object localObject = MultiInstanceInvalidationClient.this;
        ((MultiInstanceInvalidationClient)localObject).mInvalidationTracker.removeObserver(((MultiInstanceInvalidationClient)localObject).mObserver);
        try
        {
          MultiInstanceInvalidationClient localMultiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
          localObject = localMultiInstanceInvalidationClient2.mService;
          if (localObject != null) {
            ((IMultiInstanceInvalidationService)localObject).unregisterCallback(localMultiInstanceInvalidationClient2.mCallback, localMultiInstanceInvalidationClient2.mClientId);
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", localRemoteException);
        }
        MultiInstanceInvalidationClient localMultiInstanceInvalidationClient1 = MultiInstanceInvalidationClient.this;
        localMultiInstanceInvalidationClient1.mAppContext.unbindService(localMultiInstanceInvalidationClient1.mServiceConnection);
      }
    };
    paramContext = paramContext.getApplicationContext();
    this.mAppContext = paramContext;
    this.mName = paramString;
    this.mInvalidationTracker = paramInvalidationTracker;
    this.mExecutor = paramExecutor;
    this.mObserver = new InvalidationTracker.Observer((String[])paramInvalidationTracker.mTableIdLookup.keySet().toArray(new String[0]))
    {
      boolean isRemote()
      {
        return true;
      }
      
      public void onInvalidated(@NonNull Set<String> paramAnonymousSet)
      {
        if (MultiInstanceInvalidationClient.this.mStopped.get()) {
          return;
        }
        try
        {
          MultiInstanceInvalidationClient localMultiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
          IMultiInstanceInvalidationService localIMultiInstanceInvalidationService = localMultiInstanceInvalidationClient.mService;
          if (localIMultiInstanceInvalidationService != null) {
            localIMultiInstanceInvalidationService.broadcastInvalidation(localMultiInstanceInvalidationClient.mClientId, (String[])paramAnonymousSet.toArray(new String[0]));
          }
        }
        catch (RemoteException paramAnonymousSet)
        {
          Log.w("ROOM", "Cannot broadcast invalidation", paramAnonymousSet);
        }
      }
    };
    paramContext.bindService(new Intent(paramContext, MultiInstanceInvalidationService.class), local2, 1);
  }
  
  void stop()
  {
    if (this.mStopped.compareAndSet(false, true)) {
      this.mExecutor.execute(this.mTearDownRunnable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\MultiInstanceInvalidationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */