package com.tplink.libmediaapi.vod.repo;

import android.content.Context;
import android.widget.ImageView;
import b.d.b0.a.t;
import com.bumptech.glide.load.resource.bitmap.w;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpmediamanager.vod.VodMediaBaseRepository;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VodMediaRepository
  extends VodMediaBaseRepository
{
  private final b.d.z.a.a commonCallback = new b.d.z.a.a()
  {
    public void changeVideoBitStreamType(String paramAnonymousString, BitStreamType paramAnonymousBitStreamType, boolean paramAnonymousBoolean, int paramAnonymousInt)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new e(paramAnonymousString, paramAnonymousBitStreamType, paramAnonymousBoolean, paramAnonymousInt));
    }
    
    public void displayDestroy()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, g.a);
    }
    
    public void displayNetworkSpeed(float paramAnonymousFloat)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new o(paramAnonymousFloat));
    }
    
    public void framePerSecond(String paramAnonymousString, int paramAnonymousInt)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new d(paramAnonymousString, paramAnonymousInt));
    }
    
    public void hideLoadingView()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, j.a);
    }
    
    public void onRenderProgramAdd(String paramAnonymousString, GLSurfaceViewGPU paramAnonymousGLSurfaceViewGPU)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new h(paramAnonymousString, paramAnonymousGLSurfaceViewGPU));
    }
    
    public void onSnapshotComplete(String paramAnonymousString)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new q(paramAnonymousString));
    }
    
    public void onStreamFinish()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, a.a);
    }
    
    public void playFatalException(Exception paramAnonymousException)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new l(paramAnonymousException));
    }
    
    public void recordFailed(int paramAnonymousInt)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new b(paramAnonymousInt));
    }
    
    public void recordProgress(long paramAnonymousLong)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new s(paramAnonymousLong));
    }
    
    public void recordStart()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, p.a);
    }
    
    public void recordStop()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, f.a);
    }
    
    public void recordSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new i(paramAnonymousInt, paramAnonymousString));
    }
    
    public void relayPreviewTimeLimit(int paramAnonymousInt)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new k(paramAnonymousInt));
    }
    
    public void retryResolutions(BitStreamType paramAnonymousBitStreamType)
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, new n(paramAnonymousBitStreamType));
    }
    
    public void showLoadingView()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, m.a);
    }
    
    public void startHoldToTalk()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, c.a);
    }
    
    public void stopHoldToTalk()
    {
      VodMediaRepository localVodMediaRepository = VodMediaRepository.this;
      localVodMediaRepository.iterate(localVodMediaRepository.streamDisplayCommonCallbacks, r.a);
    }
  };
  private final ArrayList<WeakReference<StreamDisplayCommonCallback>> streamDisplayCommonCallbacks = new ArrayList();
  private com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback streamNotificationCallback;
  private VodStreamDisplayCallback vodStreamDisplayCallback;
  
  public VodMediaRepository(TPMediaDeviceContext paramTPMediaDeviceContext)
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
  
  public void addSteamDisplayCommonCallback(String paramString, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (paramStreamDisplayCommonCallback != null)
    {
      for (int i = this.streamDisplayCommonCallbacks.size() - 1; i >= 0; i--)
      {
        paramString = (StreamDisplayCommonCallback)((WeakReference)this.streamDisplayCommonCallbacks.get(i)).get();
        if ((paramString != null) && (paramString.equals(paramStreamDisplayCommonCallback))) {
          return;
        }
      }
      this.streamDisplayCommonCallbacks.add(new WeakReference(paramStreamDisplayCommonCallback));
    }
    getClient().u(this.commonCallback);
  }
  
  public void changeVodPlayRate(String paramString1, String paramString2, long paramLong)
  {
    com.tplink.libtpmediamanager.e.k().i(paramString1, paramString2, paramLong);
  }
  
  public void clearPlayerCache()
  {
    if ((getClient() != null) && (getClient().D())) {
      getClient().w();
    }
  }
  
  public void downloadImageIntoView(com.tplink.libtpimagedownloadmedia.loader.g paramg, ImageView paramImageView, int paramInt)
  {
    com.bumptech.glide.request.g localg = (com.bumptech.glide.request.g)new com.bumptech.glide.request.g().V(paramInt);
    ((com.bumptech.glide.h)com.bumptech.glide.c.v(paramImageView).r(paramg).m0(localg).j0(new com.bumptech.glide.load.i[] { new com.bumptech.glide.load.resource.bitmap.i(), new w(5) })).x0(paramImageView);
  }
  
  public boolean isFlushing()
  {
    if (getClient() == null) {
      return false;
    }
    return getClient().E();
  }
  
  public boolean isStreamAlive(String paramString)
  {
    return com.tplink.libtpstreamclientmanager.m.V().b0(paramString);
  }
  
  public void loadCacheData() {}
  
  public void muteAudio(boolean paramBoolean)
  {
    if (getClient() != null) {
      getClient().Y(paramBoolean);
    }
  }
  
  public void pauseDisplay()
  {
    if (getClient() != null) {
      getClient().O();
    }
  }
  
  public void releaseStream(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().B0(paramString);
  }
  
  public void resumeDisplay()
  {
    if (getClient() != null) {
      getClient().T();
    }
  }
  
  public void seekVodStreamDisplay(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    com.tplink.libtpmediamanager.e.k().o(paramString1, paramInt, paramLong, paramString2);
  }
  
  public void setStreamControlNotificationCallback(String paramString, com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback paramStreamNotificationCallback)
  {
    this.streamNotificationCallback = paramStreamNotificationCallback;
    com.tplink.libtpmediamanager.e.k().p(paramString, new com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback()
    {
      public void onReceiveDeviceLockedInfo(String paramAnonymousString, DeviceLockedInfo paramAnonymousDeviceLockedInfo)
      {
        if (VodMediaRepository.this.streamNotificationCallback != null) {
          VodMediaRepository.this.streamNotificationCallback.onReceiveDeviceLockedInfo(paramAnonymousString, paramAnonymousDeviceLockedInfo);
        }
      }
      
      public void onReceiveLensMaskInfo(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if (VodMediaRepository.this.streamNotificationCallback != null) {
          VodMediaRepository.this.streamNotificationCallback.onReceiveLensMaskInfo(paramAnonymousString, paramAnonymousBoolean);
        }
      }
      
      public void onReceiveMotorStatus(String paramAnonymousString, MotorStatus paramAnonymousMotorStatus)
      {
        if (VodMediaRepository.this.streamNotificationCallback != null) {
          VodMediaRepository.this.streamNotificationCallback.onReceiveMotorStatus(paramAnonymousString, paramAnonymousMotorStatus);
        }
      }
      
      public void onReceiveStreamFinish(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (VodMediaRepository.this.streamNotificationCallback != null) {
          VodMediaRepository.this.streamNotificationCallback.onReceiveStreamFinish(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public void onReceiveStreamStatus(String paramAnonymousString, StreamStatus paramAnonymousStreamStatus)
      {
        if (VodMediaRepository.this.streamNotificationCallback != null) {
          VodMediaRepository.this.streamNotificationCallback.onReceiveStreamStatus(paramAnonymousString, paramAnonymousStreamStatus);
        }
      }
    });
  }
  
  public void setVodStreamDisplayCallback(VodStreamDisplayCallback paramVodStreamDisplayCallback)
  {
    this.vodStreamDisplayCallback = paramVodStreamDisplayCallback;
    getClient().b0(new b.d.d.g.b()
    {
      public void showDisplayProgress(long paramAnonymousLong)
      {
        if (VodMediaRepository.this.vodStreamDisplayCallback != null) {
          VodMediaRepository.this.vodStreamDisplayCallback.showDisplayProgress(paramAnonymousLong);
        }
      }
      
      public void vodPlayRate(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        if (VodMediaRepository.this.vodStreamDisplayCallback != null) {
          VodMediaRepository.this.vodStreamDisplayCallback.vodPlayRate(paramAnonymousBoolean, paramAnonymousFloat);
        }
      }
      
      public void vodSeekTime(boolean paramAnonymousBoolean)
      {
        if (VodMediaRepository.this.vodStreamDisplayCallback != null) {
          VodMediaRepository.this.vodStreamDisplayCallback.vodSeekTime(paramAnonymousBoolean);
        }
      }
    });
  }
  
  public void snapshot()
  {
    if (getClient() != null) {
      getClient().c0();
    }
  }
  
  public void startRecord()
  {
    if (getClient() != null) {
      getClient().e0();
    }
  }
  
  public void startVodStreamDisplay(String paramString1, Context paramContext, long paramLong, int paramInt, int[] paramArrayOfInt, String paramString2)
  {
    com.tplink.libtpmediamanager.e.k().r(paramString1, paramContext, paramLong, paramInt, paramArrayOfInt, paramString2);
  }
  
  public void stopDisplay(String paramString)
  {
    com.tplink.libtpstreamclientmanager.m.V().B0(paramString);
    com.tplink.libtpmediamanager.e.k().j(paramString);
    com.tplink.libtpmediamanager.e.k().s(paramString);
    this.streamDisplayCommonCallbacks.clear();
  }
  
  public void stopRecord()
  {
    if (getClient() != null) {
      getClient().f0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\vod\repo\VodMediaRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */