package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzq<T>
{
  final int zza;
  final TaskCompletionSource<T> zzb = new TaskCompletionSource();
  final int zzc;
  final Bundle zzd;
  
  zzq(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.zza = paramInt1;
    this.zzc = paramInt2;
    this.zzd = paramBundle;
  }
  
  public String toString()
  {
    int i = this.zzc;
    int j = this.zza;
    boolean bool = zza();
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Request { what=");
    localStringBuilder.append(i);
    localStringBuilder.append(" id=");
    localStringBuilder.append(j);
    localStringBuilder.append(" oneWay=");
    localStringBuilder.append(bool);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  abstract void zza(Bundle paramBundle);
  
  final void zza(zzp paramzzp)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramzzp);
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 14 + str2.length());
      localStringBuilder.append("Failing ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" with ");
      localStringBuilder.append(str2);
      Log.d("MessengerIpcClient", localStringBuilder.toString());
    }
    this.zzb.setException(paramzzp);
  }
  
  final void zza(T paramT)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 16 + str2.length());
      localStringBuilder.append("Finishing ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" with ");
      localStringBuilder.append(str2);
      Log.d("MessengerIpcClient", localStringBuilder.toString());
    }
    this.zzb.setResult(paramT);
  }
  
  abstract boolean zza();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */