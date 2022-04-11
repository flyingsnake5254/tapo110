package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

class RequestDeduplicator
{
  private final Executor executor;
  @GuardedBy("this")
  private final Map<String, Task<String>> getTokenRequests = new ArrayMap();
  
  RequestDeduplicator(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  Task<String> getOrStartGetTokenRequest(String paramString, GetTokenRequest paramGetTokenRequest)
  {
    try
    {
      Object localObject = (Task)this.getTokenRequests.get(paramString);
      if (localObject != null)
      {
        if (Log.isLoggable("FirebaseMessaging", 3))
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0) {
            paramString = "Joining ongoing request for: ".concat(paramString);
          } else {
            paramString = new String("Joining ongoing request for: ");
          }
          Log.d("FirebaseMessaging", paramString);
        }
        return (Task<String>)localObject;
      }
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        localObject = String.valueOf(paramString);
        if (((String)localObject).length() != 0) {
          localObject = "Making new request for: ".concat((String)localObject);
        } else {
          localObject = new String("Making new request for: ");
        }
        Log.d("FirebaseMessaging", (String)localObject);
      }
      Task localTask = paramGetTokenRequest.start();
      paramGetTokenRequest = this.executor;
      localObject = new com/google/firebase/messaging/RequestDeduplicator$$Lambda$0;
      ((RequestDeduplicator..Lambda.0)localObject).<init>(this, paramString);
      paramGetTokenRequest = localTask.continueWithTask(paramGetTokenRequest, (Continuation)localObject);
      this.getTokenRequests.put(paramString, paramGetTokenRequest);
      return paramGetTokenRequest;
    }
    finally {}
  }
  
  static abstract interface GetTokenRequest
  {
    public abstract Task<String> start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\RequestDeduplicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */