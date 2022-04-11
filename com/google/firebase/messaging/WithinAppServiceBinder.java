package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;

class WithinAppServiceBinder
  extends Binder
{
  private final IntentHandler intentHandler;
  
  WithinAppServiceBinder(IntentHandler paramIntentHandler)
  {
    this.intentHandler = paramIntentHandler;
  }
  
  void send(WithinAppServiceConnection.BindRequest paramBindRequest)
  {
    if (Binder.getCallingUid() == Process.myUid())
    {
      if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "service received new intent via bind strategy");
      }
      this.intentHandler.handle(paramBindRequest.intent).addOnCompleteListener(WithinAppServiceBinder..Lambda.0.$instance, new WithinAppServiceBinder..Lambda.1(paramBindRequest));
      return;
    }
    throw new SecurityException("Binding only allowed within app");
  }
  
  static abstract interface IntentHandler
  {
    public abstract Task<Void> handle(Intent paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\WithinAppServiceBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */