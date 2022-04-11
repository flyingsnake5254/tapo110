package com.tplink.libmediaapi.live.repo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libmediaapi.common.apicallback.OnConnectionTypeChangeListener;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpmediamanager.ConnectionTypeManager;
import com.tplink.libtpmediamanager.live.LiveMediaBaseRepository;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class LiveMediaRepository
  extends LiveMediaBaseRepository
{
  private final b.d.z.a.a commonCallback = new b.d.z.a.a()
  {
    public void changeVideoBitStreamType(String paramAnonymousString, BitStreamType paramAnonymousBitStreamType, boolean paramAnonymousBoolean, int paramAnonymousInt)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new b(paramAnonymousString, paramAnonymousBitStreamType, paramAnonymousBoolean, paramAnonymousInt));
    }
    
    public void displayDestroy()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, g.a);
    }
    
    public void displayNetworkSpeed(float paramAnonymousFloat)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new h(paramAnonymousFloat));
    }
    
    public void framePerSecond(String paramAnonymousString, int paramAnonymousInt)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new d(paramAnonymousString, paramAnonymousInt));
    }
    
    public void hideLoadingView()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, e.a);
    }
    
    public void onRenderProgramAdd(String paramAnonymousString, GLSurfaceViewGPU paramAnonymousGLSurfaceViewGPU)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new q(paramAnonymousString, paramAnonymousGLSurfaceViewGPU));
    }
    
    public void onSnapshotComplete(String paramAnonymousString)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new j(paramAnonymousString));
    }
    
    public void onStreamFinish()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, l.a);
    }
    
    public void playFatalException(Exception paramAnonymousException)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new p(paramAnonymousException));
    }
    
    public void recordFailed(int paramAnonymousInt)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new c(paramAnonymousInt));
    }
    
    public void recordProgress(long paramAnonymousLong)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new k(paramAnonymousLong));
    }
    
    public void recordStart()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, f.a);
    }
    
    public void recordStop()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, s.a);
    }
    
    public void recordSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new i(paramAnonymousInt, paramAnonymousString));
    }
    
    public void relayPreviewTimeLimit(int paramAnonymousInt)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new m(paramAnonymousInt));
    }
    
    public void retryResolutions(BitStreamType paramAnonymousBitStreamType)
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, new n(paramAnonymousBitStreamType));
    }
    
    public void showLoadingView()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, r.a);
    }
    
    public void startHoldToTalk()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, t.a);
    }
    
    public void stopHoldToTalk()
    {
      LiveMediaRepository localLiveMediaRepository = LiveMediaRepository.this;
      localLiveMediaRepository.iterate(localLiveMediaRepository.streamDisplayCommonCallbacks, o.a);
    }
  };
  private final ArrayList<WeakReference<StreamDisplayCommonCallback>> streamDisplayCommonCallbacks = new ArrayList();
  private com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback streamNotificationCallback;
  
  public LiveMediaRepository(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    super(paramTPMediaDeviceContext);
  }
  
  private void iterate(ArrayList<WeakReference<StreamDisplayCommonCallback>> paramArrayList, b.d.p.e.b<StreamDisplayCommonCallback> paramb)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        WeakReference localWeakReference = (WeakReference)paramArrayList.get(i);
        if (localWeakReference.get() != null)
        {
          paramb.a((StreamDisplayCommonCallback)localWeakReference.get());
          i++;
        }
        else
        {
          paramArrayList.remove(i);
        }
      }
    }
  }
  
  public void addSteamDisplayCommonCallback(int paramInt, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (paramStreamDisplayCommonCallback != null)
    {
      for (int i = this.streamDisplayCommonCallbacks.size() - 1; i >= 0; i--)
      {
        StreamDisplayCommonCallback localStreamDisplayCommonCallback = (StreamDisplayCommonCallback)((WeakReference)this.streamDisplayCommonCallbacks.get(i)).get();
        if ((localStreamDisplayCommonCallback != null) && (localStreamDisplayCommonCallback.equals(paramStreamDisplayCommonCallback))) {
          return;
        }
      }
      this.streamDisplayCommonCallbacks.add(paramInt, new WeakReference(paramStreamDisplayCommonCallback));
    }
    if (getClient() != null) {
      getClient().u(paramInt, this.commonCallback);
    }
  }
  
  public void addSteamDisplayCommonCallback(StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (paramStreamDisplayCommonCallback != null)
    {
      for (int i = this.streamDisplayCommonCallbacks.size() - 1; i >= 0; i--)
      {
        StreamDisplayCommonCallback localStreamDisplayCommonCallback = (StreamDisplayCommonCallback)((WeakReference)this.streamDisplayCommonCallbacks.get(i)).get();
        if ((localStreamDisplayCommonCallback != null) && (localStreamDisplayCommonCallback.equals(paramStreamDisplayCommonCallback))) {
          return;
        }
      }
      this.streamDisplayCommonCallbacks.add(new WeakReference(paramStreamDisplayCommonCallback));
    }
    if (getClient() != null) {
      getClient().v(this.commonCallback);
    }
  }
  
  public void allDisplayScreenshotPreview()
  {
    com.tplink.libtpmediamanager.f.j().g();
  }
  
  public void changePreviewResolutions(String paramString1, BitStreamType paramBitStreamType, String paramString2)
  {
    com.tplink.libtpmediamanager.f.j().h(paramString1, paramBitStreamType, null);
  }
  
  public void clearCommonCallback()
  {
    this.streamDisplayCommonCallbacks.clear();
  }
  
  public int getConnectType()
  {
    if (getClient() == null) {
      return -1;
    }
    return getClient().D();
  }
  
  public int getConnectionType(String paramString)
  {
    return ConnectionTypeManager.INSTANCE.get(paramString);
  }
  
  public List<String> getPlayingDevices()
  {
    return com.tplink.libtpmediamanager.f.j().k();
  }
  
  public ObservableLong getRecordDuration()
  {
    if (getClient() == null) {
      return new ObservableLong();
    }
    return getClient().F();
  }
  
  public boolean isPlayingProperly()
  {
    boolean bool;
    if ((getClient() != null) && (getClient().J().get())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRecording()
  {
    boolean bool;
    if ((getClient() != null) && (getClient().K().get())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ObservableBoolean isRecordingObservable()
  {
    ObservableBoolean localObservableBoolean;
    if (getClient() == null) {
      localObservableBoolean = null;
    } else {
      localObservableBoolean = getClient().K();
    }
    return localObservableBoolean;
  }
  
  public void keepDoubleTalk(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().c0(paramString);
  }
  
  public void loadCacheData() {}
  
  public boolean lockLiveStreamAudio()
  {
    return com.tplink.libtpmediamanager.f.j().n();
  }
  
  public void muteAudio(String paramString, boolean paramBoolean)
  {
    com.tplink.libtpmediamanager.f.j().o(paramString, paramBoolean);
  }
  
  public void muteVolume(String paramString, boolean paramBoolean)
  {
    com.tplink.libtpmediamanager.f.j().p(paramString, paramBoolean);
  }
  
  public void pause()
  {
    if (getClient() != null) {
      getClient().T();
    }
  }
  
  public void previewCapture(MutableLiveData<b.d.d.m.f<String>> paramMutableLiveData)
  {
    if (getClient() != null) {
      getClient().W(paramMutableLiveData);
    }
  }
  
  public void previewScreenShot()
  {
    if (getClient() != null) {
      getClient().X();
    }
  }
  
  public void releaseStream(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().x0(paramString);
  }
  
  public void removeSteamDisplayCommonCallback(StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    int i = 1;
    if (paramStreamDisplayCommonCallback != null) {
      for (j = this.streamDisplayCommonCallbacks.size() - 1; j >= 0; j--) {
        if (paramStreamDisplayCommonCallback.equals((StreamDisplayCommonCallback)((WeakReference)this.streamDisplayCommonCallbacks.get(j)).get()))
        {
          this.streamDisplayCommonCallbacks.set(j, new WeakReference(null));
          break;
        }
      }
    }
    int k;
    for (int j = this.streamDisplayCommonCallbacks.size() - 1;; j--)
    {
      k = i;
      if (j < 0) {
        break;
      }
      if ((StreamDisplayCommonCallback)((WeakReference)this.streamDisplayCommonCallbacks.get(j)).get() != null)
      {
        k = 0;
        break;
      }
    }
    if ((k != 0) && (getClient() != null)) {
      getClient().Z(this.commonCallback);
    }
  }
  
  public void resume()
  {
    if (getClient() != null) {
      getClient().a0();
    }
  }
  
  public void setConnectionTypeListener(OnConnectionTypeChangeListener paramOnConnectionTypeChangeListener)
  {
    if (paramOnConnectionTypeChangeListener != null) {
      ConnectionTypeManager.INSTANCE.setListener(new v(paramOnConnectionTypeChangeListener));
    } else {
      ConnectionTypeManager.INSTANCE.setListener(null);
    }
  }
  
  public void setConnectionTypeListenerEnable(boolean paramBoolean)
  {
    ConnectionTypeManager.INSTANCE.setEnabled(paramBoolean);
  }
  
  public void setStreamControlNotificationCallback(String paramString, com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback paramStreamNotificationCallback)
  {
    this.streamNotificationCallback = paramStreamNotificationCallback;
    com.tplink.libtpmediamanager.f.j().q(paramString, new com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback()
    {
      public void onReceiveDeviceLockedInfo(String paramAnonymousString, DeviceLockedInfo paramAnonymousDeviceLockedInfo)
      {
        if (LiveMediaRepository.this.streamNotificationCallback != null) {
          LiveMediaRepository.this.streamNotificationCallback.onReceiveDeviceLockedInfo(paramAnonymousString, paramAnonymousDeviceLockedInfo);
        }
      }
      
      public void onReceiveLensMaskInfo(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if (LiveMediaRepository.this.streamNotificationCallback != null) {
          LiveMediaRepository.this.streamNotificationCallback.onReceiveLensMaskInfo(paramAnonymousString, paramAnonymousBoolean);
        }
      }
      
      public void onReceiveMotorStatus(String paramAnonymousString, MotorStatus paramAnonymousMotorStatus)
      {
        if (LiveMediaRepository.this.streamNotificationCallback != null) {
          LiveMediaRepository.this.streamNotificationCallback.onReceiveMotorStatus(paramAnonymousString, paramAnonymousMotorStatus);
        }
      }
      
      public void onReceiveStreamFinish(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (LiveMediaRepository.this.streamNotificationCallback != null) {
          LiveMediaRepository.this.streamNotificationCallback.onReceiveStreamFinish(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public void onReceiveStreamStatus(String paramAnonymousString, StreamStatus paramAnonymousStreamStatus)
      {
        if (LiveMediaRepository.this.streamNotificationCallback != null) {
          LiveMediaRepository.this.streamNotificationCallback.onReceiveStreamStatus(paramAnonymousString, paramAnonymousStreamStatus);
        }
      }
    });
  }
  
  public void snapshot()
  {
    if (getClient() != null) {
      getClient().j0();
    }
  }
  
  public void snapshot(MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> paramMutableLiveData)
  {
    if (getClient() != null) {
      getClient().k0(paramMutableLiveData);
    }
  }
  
  public void startHoldToTalk()
  {
    if (getClient() != null) {
      b.d.z.c.a.a(getClient().G(), a.a);
    }
  }
  
  public void startLiveStreamDisplay(String paramString, Context paramContext, BitStreamType paramBitStreamType)
  {
    com.tplink.libtpmediamanager.f.j().s(paramString, paramContext, paramBitStreamType);
  }
  
  public void startRecord()
  {
    if (getClient() != null) {
      getClient().m0();
    }
  }
  
  public void stopDisplay(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().x0(paramString);
    com.tplink.libtpstreamclientmanager.m.V().u0(paramString);
    com.tplink.libtpmediamanager.f.j().t(paramString);
  }
  
  public void stopHoldToTalk()
  {
    if (getClient() != null) {
      b.d.z.c.a.a(getClient().G(), u.a);
    }
  }
  
  public void stopKeepDoubleTalk(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().I0(paramString);
  }
  
  public void stopNetworkStatics()
  {
    if (getClient() != null) {
      getClient().n0();
    }
  }
  
  public void stopRecord()
  {
    if (getClient() != null) {
      getClient().o0();
    }
  }
  
  public boolean unlockLiveStreamAudio()
  {
    return com.tplink.libtpmediamanager.f.j().u();
  }
  
  public void updateAudioVolume(float paramFloat1, float paramFloat2)
  {
    if (getClient() != null) {
      getClient().q0(paramFloat1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\live\repo\LiveMediaRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */