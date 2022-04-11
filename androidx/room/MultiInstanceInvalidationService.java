package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MultiInstanceInvalidationService
  extends Service
{
  private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub()
  {
    public void broadcastInvalidation(int paramAnonymousInt, String[] paramAnonymousArrayOfString)
    {
      synchronized (MultiInstanceInvalidationService.this.mCallbackList)
      {
        String str1 = (String)MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(paramAnonymousInt));
        if (str1 == null)
        {
          Log.w("ROOM", "Remote invalidation client ID not registered");
          return;
        }
        int i = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
        int j = 0;
        while (j < i) {
          try
          {
            int k = ((Integer)MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(j)).intValue();
            String str2 = (String)MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(k));
            if (paramAnonymousInt != k)
            {
              boolean bool = str1.equals(str2);
              if (bool) {
                try
                {
                  ((IMultiInstanceInvalidationCallback)MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(j)).onInvalidation(paramAnonymousArrayOfString);
                }
                catch (RemoteException localRemoteException)
                {
                  Log.w("ROOM", "Error invoking a remote callback", localRemoteException);
                }
              }
            }
            j++;
          }
          finally
          {
            MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
          }
        }
        MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
        return;
      }
    }
    
    public int registerCallback(IMultiInstanceInvalidationCallback paramAnonymousIMultiInstanceInvalidationCallback, String paramAnonymousString)
    {
      if (paramAnonymousString == null) {
        return 0;
      }
      synchronized (MultiInstanceInvalidationService.this.mCallbackList)
      {
        MultiInstanceInvalidationService localMultiInstanceInvalidationService = MultiInstanceInvalidationService.this;
        int i = localMultiInstanceInvalidationService.mMaxClientId + 1;
        localMultiInstanceInvalidationService.mMaxClientId = i;
        if (localMultiInstanceInvalidationService.mCallbackList.register(paramAnonymousIMultiInstanceInvalidationCallback, Integer.valueOf(i)))
        {
          MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i), paramAnonymousString);
          return i;
        }
        paramAnonymousIMultiInstanceInvalidationCallback = MultiInstanceInvalidationService.this;
        paramAnonymousIMultiInstanceInvalidationCallback.mMaxClientId -= 1;
        return 0;
      }
    }
    
    public void unregisterCallback(IMultiInstanceInvalidationCallback paramAnonymousIMultiInstanceInvalidationCallback, int paramAnonymousInt)
    {
      synchronized (MultiInstanceInvalidationService.this.mCallbackList)
      {
        MultiInstanceInvalidationService.this.mCallbackList.unregister(paramAnonymousIMultiInstanceInvalidationCallback);
        MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(paramAnonymousInt));
        return;
      }
    }
  };
  final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new RemoteCallbackList()
  {
    public void onCallbackDied(IMultiInstanceInvalidationCallback paramAnonymousIMultiInstanceInvalidationCallback, Object paramAnonymousObject)
    {
      MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer)paramAnonymousObject).intValue()));
    }
  };
  final HashMap<Integer, String> mClientNames = new HashMap();
  int mMaxClientId = 0;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\MultiInstanceInvalidationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */