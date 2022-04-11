package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

@KeepForSdk
public final class ListenerHolder<L>
{
  private final zaa zajj;
  private volatile L zajk;
  private final ListenerKey<L> zajl;
  
  @KeepForSdk
  ListenerHolder(@NonNull Looper paramLooper, @NonNull L paramL, @NonNull String paramString)
  {
    this.zajj = new zaa(paramLooper);
    this.zajk = Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zajl = new ListenerKey(paramL, Preconditions.checkNotEmpty(paramString));
  }
  
  @KeepForSdk
  public final void clear()
  {
    this.zajk = null;
  }
  
  @NonNull
  @KeepForSdk
  public final ListenerKey<L> getListenerKey()
  {
    return this.zajl;
  }
  
  @KeepForSdk
  public final boolean hasListener()
  {
    return this.zajk != null;
  }
  
  @KeepForSdk
  public final void notifyListener(Notifier<? super L> paramNotifier)
  {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    paramNotifier = this.zajj.obtainMessage(1, paramNotifier);
    this.zajj.sendMessage(paramNotifier);
  }
  
  @KeepForSdk
  final void notifyListenerInternal(Notifier<? super L> paramNotifier)
  {
    Object localObject = this.zajk;
    if (localObject == null)
    {
      paramNotifier.onNotifyListenerFailed();
      return;
    }
    try
    {
      paramNotifier.notifyListener(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramNotifier.onNotifyListenerFailed();
      throw localRuntimeException;
    }
  }
  
  @KeepForSdk
  public static final class ListenerKey<L>
  {
    private final L zajk;
    private final String zajn;
    
    @KeepForSdk
    ListenerKey(L paramL, String paramString)
    {
      this.zajk = paramL;
      this.zajn = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof ListenerKey)) {
        return false;
      }
      paramObject = (ListenerKey)paramObject;
      return (this.zajk == ((ListenerKey)paramObject).zajk) && (this.zajn.equals(((ListenerKey)paramObject).zajn));
    }
    
    public final int hashCode()
    {
      return System.identityHashCode(this.zajk) * 31 + this.zajn.hashCode();
    }
  }
  
  @KeepForSdk
  public static abstract interface Notifier<L>
  {
    @KeepForSdk
    public abstract void notifyListener(L paramL);
    
    @KeepForSdk
    public abstract void onNotifyListenerFailed();
  }
  
  private final class zaa
    extends zap
  {
    public zaa(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      ListenerHolder.this.notifyListenerInternal((ListenerHolder.Notifier)paramMessage.obj);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\ListenerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */