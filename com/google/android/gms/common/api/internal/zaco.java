package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zap;

final class zaco
  extends zap
{
  public zaco(zacm paramzacm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        paramMessage = new StringBuilder(70);
        paramMessage.append("TransformationResultHandler received unknown message type: ");
        paramMessage.append(i);
        Log.e("TransformedResultImpl", paramMessage.toString());
        return;
      }
      localObject1 = (RuntimeException)paramMessage.obj;
      paramMessage = String.valueOf(((RuntimeException)localObject1).getMessage());
      if (paramMessage.length() != 0) {
        paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);
      } else {
        paramMessage = new String("Runtime exception on the transformation worker thread: ");
      }
      Log.e("TransformedResultImpl", paramMessage);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = (PendingResult)paramMessage.obj;
    paramMessage = zacm.zaf(this.zakw);
    if (localObject1 == null) {}
    try
    {
      zacm localzacm = zacm.zag(this.zakw);
      localObject1 = new com/google/android/gms/common/api/Status;
      ((Status)localObject1).<init>(13, "Transform returned null");
      zacm.zaa(localzacm, (Status)localObject1);
      break label190;
      if ((localObject1 instanceof zacd)) {
        zacm.zaa(zacm.zag(this.zakw), ((zacd)localObject1).getStatus());
      } else {
        zacm.zag(this.zakw).zaa((PendingResult)localObject1);
      }
      label190:
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */