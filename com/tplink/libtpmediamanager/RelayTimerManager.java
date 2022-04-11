package com.tplink.libtpmediamanager;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import b.d.p.d;
import io.reactivex.q;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public enum RelayTimerManager
{
  public static final int MULTI_DEVICE_TIMEOUT_SECONDS = 120;
  public static final int SINGLE_DEVICE_TIMEOUT_SECONDS = 300;
  private final String TAG = RelayTimerManager.class.getSimpleName();
  Observable.OnPropertyChangedCallback callAndRecordCallBack = new b();
  private io.reactivex.e0.c clientDelayRelayDisposable;
  @Nullable
  private ObservableBoolean isCallingObservable;
  @Nullable
  private ObservableBoolean isRecordingObservable;
  private boolean playInPreviewPage = false;
  private Observable.OnPropertyChangedCallback playStatusChangedCallback;
  private int relayTimeoutSeconds;
  
  static
  {
    RelayTimerManager localRelayTimerManager = new RelayTimerManager("INSTANCE", 0);
    INSTANCE = localRelayTimerManager;
    $VALUES = new RelayTimerManager[] { localRelayTimerManager };
  }
  
  private Set<Map.Entry<String, com.tplink.libtplivemedia.a.t>> getClientSet()
  {
    return f.j().m();
  }
  
  private b.d.b0.a.t getPlaybackClient()
  {
    return e.k().m();
  }
  
  private boolean isCalling()
  {
    ObservableBoolean localObservableBoolean = this.isCallingObservable;
    boolean bool;
    if ((localObservableBoolean != null) && (b.d.d.m.c.a(Boolean.valueOf(localObservableBoolean.get())))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isRecording()
  {
    ObservableBoolean localObservableBoolean = this.isRecordingObservable;
    boolean bool;
    if ((localObservableBoolean != null) && (b.d.d.m.c.a(Boolean.valueOf(localObservableBoolean.get())))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void bindCallingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindCallingVariable() called with: isCalling = [");
    localStringBuilder.append(paramObservableBoolean);
    localStringBuilder.append("]");
    d.a((String)localObject, localStringBuilder.toString());
    localObject = this.isCallingObservable;
    if (localObject != null) {
      ((BaseObservable)localObject).removeOnPropertyChangedCallback(this.callAndRecordCallBack);
    }
    if (paramObservableBoolean != null) {
      paramObservableBoolean.addOnPropertyChangedCallback(this.callAndRecordCallBack);
    }
    this.isCallingObservable = paramObservableBoolean;
  }
  
  public void bindRecordingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    String str = this.TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindRecordingVariable() called with: isRecording = [");
    ((StringBuilder)localObject).append(paramObservableBoolean);
    ((StringBuilder)localObject).append("]");
    d.a(str, ((StringBuilder)localObject).toString());
    localObject = this.isRecordingObservable;
    if (localObject != null) {
      ((BaseObservable)localObject).removeOnPropertyChangedCallback(this.callAndRecordCallBack);
    }
    if (paramObservableBoolean != null) {
      paramObservableBoolean.addOnPropertyChangedCallback(this.callAndRecordCallBack);
    }
    this.isRecordingObservable = paramObservableBoolean;
  }
  
  public void disableRelayTimer()
  {
    switchRelayTimer(false);
  }
  
  public void enableRelayTimer()
  {
    refreshRelayTimer();
  }
  
  int findPlayingLiveStream()
  {
    Object localObject = getClientSet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      i += ((com.tplink.libtplivemedia.a.t)((Map.Entry)((Iterator)localObject).next()).getValue()).J().get();
    }
    localObject = getPlaybackClient();
    int j = i;
    if (localObject != null) {
      j = i + ((b.d.b0.a.t)localObject).F().get();
    }
    return j;
  }
  
  int findRelayLiveStream()
  {
    Iterator localIterator = getClientSet().iterator();
    int i = 0;
    int j = 0;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      k = 1;
      if (!bool) {
        break;
      }
      localObject = (Map.Entry)localIterator.next();
      if (((com.tplink.libtplivemedia.a.t)((Map.Entry)localObject).getValue()).J().get())
      {
        if (((com.tplink.libtplivemedia.a.t)((Map.Entry)localObject).getValue()).D() != 0) {
          k = 0;
        }
        j += k;
      }
    }
    Object localObject = getPlaybackClient();
    int k = j;
    if (localObject != null)
    {
      k = j;
      if (((b.d.b0.a.t)localObject).F().get())
      {
        k = i;
        if (((b.d.b0.a.t)localObject).B() == 0) {
          k = 1;
        }
        k = j + k;
      }
    }
    return k;
  }
  
  @Nullable
  public ObservableBoolean getCallingObservable()
  {
    return this.isCallingObservable;
  }
  
  @Nullable
  public ObservableBoolean getRecordingObservable()
  {
    return this.isRecordingObservable;
  }
  
  void refreshRelayTimer()
  {
    d.a(this.TAG, "Refresh relay timer");
    int i = findRelayLiveStream();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Relay stream count: ");
    ((StringBuilder)localObject2).append(i);
    d.a((String)localObject1, ((StringBuilder)localObject2).toString());
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = this.TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Open relay timer:");
    ((StringBuilder)localObject1).append(bool);
    d.a((String)localObject2, ((StringBuilder)localObject1).toString());
    switchRelayTimer(bool);
  }
  
  public void setPlayInPreviewPage(boolean paramBoolean)
  {
    this.playInPreviewPage = paramBoolean;
  }
  
  void stopAllRelayStream(int paramInt)
  {
    d.a(this.TAG, "stopAllRelayStream");
    Object localObject = getClientSet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tplink.libtplivemedia.a.t localt = (com.tplink.libtplivemedia.a.t)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localt.D() == 0)
      {
        localt.X();
        localt.C(paramInt);
      }
    }
    localObject = getPlaybackClient();
    if ((localObject != null) && (((b.d.b0.a.t)localObject).B() == 0)) {
      ((b.d.b0.a.t)localObject).A(paramInt);
    }
  }
  
  void stopAllStreamDueToRelay(int paramInt)
  {
    d.a(this.TAG, "stopAllStreamDueToRelay");
    Object localObject = getClientSet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tplink.libtplivemedia.a.t)((Map.Entry)((Iterator)localObject).next()).getValue()).C(paramInt);
    }
    localObject = getPlaybackClient();
    if (localObject != null) {
      ((b.d.b0.a.t)localObject).A(paramInt);
    }
  }
  
  void subscribePlayStatus(String paramString)
  {
    if (this.playStatusChangedCallback == null) {
      this.playStatusChangedCallback = new a();
    }
    paramString = f.j().l(paramString);
    if (paramString != null) {
      paramString.J().addOnPropertyChangedCallback(this.playStatusChangedCallback);
    }
    paramString = e.k().m();
    if (paramString != null) {
      paramString.F().addOnPropertyChangedCallback(this.playStatusChangedCallback);
    }
  }
  
  void switchRelayTimer(boolean paramBoolean)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if ((!isCalling()) && (!isRecording()))
      {
        int i = findPlayingLiveStream();
        if ((!this.playInPreviewPage) && (i <= 1)) {
          i = 300;
        } else {
          i = 120;
        }
        localObject = this.clientDelayRelayDisposable;
        if ((localObject != null) && (!((io.reactivex.e0.c)localObject).isDisposed())) {
          if (i != this.relayTimeoutSeconds)
          {
            this.clientDelayRelayDisposable.dispose();
            localObject = this.TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Disable relay timer for ");
            localStringBuilder.append(this.relayTimeoutSeconds);
            localStringBuilder.append(" seconds");
            d.c((String)localObject, localStringBuilder.toString());
          }
          else
          {
            d.a(this.TAG, "Retain existed relay timer");
            return;
          }
        }
        this.relayTimeoutSeconds = i;
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Activate relay timer for ");
        localStringBuilder.append(this.relayTimeoutSeconds);
        localStringBuilder.append(" seconds");
        d.c((String)localObject, localStringBuilder.toString());
        this.clientDelayRelayDisposable = q.W0(this.relayTimeoutSeconds, TimeUnit.SECONDS).G0(new a(this));
      }
      else
      {
        d.c(this.TAG, "Cannot activate relay timer due to user is recording or calling");
      }
    }
    else
    {
      localObject = this.clientDelayRelayDisposable;
      if ((localObject != null) && (!((io.reactivex.e0.c)localObject).isDisposed()))
      {
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Disable relay timer for ");
        localStringBuilder.append(this.relayTimeoutSeconds);
        localStringBuilder.append(" seconds");
        d.c((String)localObject, localStringBuilder.toString());
        this.clientDelayRelayDisposable.dispose();
      }
    }
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      boolean bool = ((ObservableBoolean)paramObservable).get();
      paramObservable = RelayTimerManager.this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Detect some devices play status changed.Playing properly:");
      localStringBuilder.append(bool);
      d.a(paramObservable, localStringBuilder.toString());
      RelayTimerManager.this.refreshRelayTimer();
    }
  }
  
  class b
    extends Observable.OnPropertyChangedCallback
  {
    b() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      d.c(RelayTimerManager.this.TAG, "录像或通话状态变化,更新Relay timer");
      paramObservable = (ObservableBoolean)paramObservable;
      RelayTimerManager.this.switchRelayTimer(paramObservable.get() ^ true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\RelayTimerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */