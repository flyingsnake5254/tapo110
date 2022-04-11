package com.google.firebase;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface FirebaseAppLifecycleListener
{
  public abstract void onDeleted(String paramString, FirebaseOptions paramFirebaseOptions);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseAppLifecycleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */