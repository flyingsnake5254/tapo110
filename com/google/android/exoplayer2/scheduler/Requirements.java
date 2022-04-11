package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class Requirements
  implements Parcelable
{
  public static final Parcelable.Creator<Requirements> CREATOR = new a();
  private final int c;
  
  public Requirements(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x2) != 0) {
      i = paramInt | 0x1;
    }
    this.c = i;
  }
  
  private int a(Context paramContext)
  {
    if (!l()) {
      return 0;
    }
    paramContext = (ConnectivityManager)g.e(paramContext.getSystemService("connectivity"));
    NetworkInfo localNetworkInfo = paramContext.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (i(paramContext)))
    {
      if ((o()) && (paramContext.isActiveNetworkMetered())) {
        return 2;
      }
      return 0;
    }
    return this.c & 0x3;
  }
  
  private boolean e(Context paramContext)
  {
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    int i = paramContext.getIntExtra("status", -1);
    if ((i == 2) || (i == 5)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean f(Context paramContext)
  {
    paramContext = (PowerManager)g.e(paramContext.getSystemService("power"));
    int i = o0.a;
    boolean bool = true;
    if (i >= 23) {
      bool = paramContext.isDeviceIdleMode();
    } else if (i >= 20 ? paramContext.isInteractive() : paramContext.isScreenOn()) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean i(ConnectivityManager paramConnectivityManager)
  {
    int i = o0.a;
    boolean bool = true;
    if (i < 24) {
      return true;
    }
    Network localNetwork = paramConnectivityManager.getActiveNetwork();
    if (localNetwork == null) {
      return false;
    }
    paramConnectivityManager = paramConnectivityManager.getNetworkCapabilities(localNetwork);
    if ((paramConnectivityManager == null) || (!paramConnectivityManager.hasCapability(16))) {
      bool = false;
    }
    return bool;
  }
  
  private boolean m(Context paramContext)
  {
    boolean bool;
    if (paramContext.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int b(Context paramContext)
  {
    int i = a(paramContext);
    int j = i;
    if (d())
    {
      j = i;
      if (!e(paramContext)) {
        j = i | 0x8;
      }
    }
    i = j;
    if (h())
    {
      i = j;
      if (!f(paramContext)) {
        i = j | 0x4;
      }
    }
    j = i;
    if (n())
    {
      j = i;
      if (!m(paramContext)) {
        j = i | 0x10;
      }
    }
    return j;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    boolean bool;
    if ((this.c & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Requirements.class == paramObject.getClass()))
    {
      if (this.c != ((Requirements)paramObject).c) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public boolean h()
  {
    boolean bool;
    if ((this.c & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.c;
  }
  
  public boolean l()
  {
    int i = this.c;
    boolean bool = true;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean n()
  {
    boolean bool;
    if ((this.c & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean o()
  {
    boolean bool;
    if ((this.c & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
  }
  
  class a
    implements Parcelable.Creator<Requirements>
  {
    public Requirements a(Parcel paramParcel)
    {
      return new Requirements(paramParcel.readInt());
    }
    
    public Requirements[] b(int paramInt)
    {
      return new Requirements[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\scheduler\Requirements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */