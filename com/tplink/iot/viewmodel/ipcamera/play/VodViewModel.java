package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import io.reactivex.q;

public class VodViewModel
  extends AndroidViewModel
  implements StreamDisplayCommonCallback, StreamNotificationCallback
{
  public ObservableField<Drawable> H3;
  public ObservableField<String> I3;
  public ObservableBoolean J3;
  public ObservableBoolean K3;
  public ObservableBoolean L3 = new ObservableBoolean(false);
  private io.reactivex.e0.b M3 = new io.reactivex.e0.b();
  public ObservableBoolean N3;
  public ObservableField<String> O3;
  private long P3 = 0L;
  private long Q3 = 0L;
  public final ObservableBoolean R3 = new ObservableBoolean(true);
  public final ObservableBoolean S3 = new ObservableBoolean(false);
  public final ObservableField<VodPlayRate> T3;
  public final ObservableField<String> U3;
  public final MutableLiveData<GLSurfaceViewGPU> V3;
  private boolean W3;
  private PlaybackMainViewModel c;
  private PlayBackControlViewModel d;
  private String f;
  public ObservableBoolean p0;
  public ObservableBoolean p1;
  public ObservableBoolean p2;
  public ObservableField<Drawable> p3;
  public ObservableBoolean q;
  public ObservableBoolean x;
  public ObservableBoolean y;
  public ObservableBoolean z;
  
  public VodViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = VodPlayRate.RATE_1_1;
    this.T3 = new ObservableField(paramApplication);
    this.U3 = new ObservableField(paramApplication.getDisplayValue());
    this.V3 = new MutableLiveData();
    this.W3 = false;
    h();
  }
  
  private String g(long paramLong)
  {
    int i = (int)(paramLong % 60L);
    Object localObject1;
    if (i < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = String.valueOf(i);
    }
    i = (int)(paramLong / 60L % 60L);
    Object localObject2;
    if (i < 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = String.valueOf(i);
    }
    i = (int)(paramLong / 3600L);
    Object localObject3;
    if (i < 10)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("0");
      ((StringBuilder)localObject3).append(i);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = String.valueOf(i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  private void h()
  {
    this.q = new ObservableBoolean(true);
    this.x = new ObservableBoolean(false);
    this.y = new ObservableBoolean(false);
    this.z = new ObservableBoolean(false);
    this.p0 = new ObservableBoolean(false);
    this.p1 = new ObservableBoolean(false);
    this.p2 = new ObservableBoolean(false);
    this.p3 = new ObservableField();
    this.H3 = new ObservableField();
    this.I3 = new ObservableField();
    this.J3 = new ObservableBoolean(false);
    this.K3 = new ObservableBoolean(false);
    this.N3 = new ObservableBoolean(false);
    this.O3 = new ObservableField();
    this.P3 = 0L;
    this.Q3 = 0L;
  }
  
  private void t(@Nullable ALCameraDevice paramALCameraDevice, String paramString1, String paramString2)
  {
    l.h(new r2(this, paramString1, paramString2, paramALCameraDevice));
  }
  
  private void x()
  {
    VodMediaAPI.startRecord(this.f);
  }
  
  private void y()
  {
    VodMediaAPI.stopRecord(this.f);
  }
  
  public void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt) {}
  
  public void displayDestroy() {}
  
  public void displayNetworkSpeed(float paramFloat) {}
  
  public void f()
  {
    if (this.N3.get())
    {
      this.L3.set(true);
      y();
    }
  }
  
  public void framePerSecond(String paramString, int paramInt) {}
  
  public void hideLoadingView()
  {
    this.c.g();
    this.c.m.set(false);
    this.c.l.set(false);
    this.c.m.set(false);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.M3.dispose();
  }
  
  public void onReceiveDeviceLockedInfo(String paramString, DeviceLockedInfo paramDeviceLockedInfo) {}
  
  public void onReceiveLensMaskInfo(String paramString, boolean paramBoolean) {}
  
  public void onReceiveMotorStatus(String paramString, MotorStatus paramMotorStatus) {}
  
  public void onReceiveStreamFinish(String paramString1, String paramString2)
  {
    VodMediaAPI.releaseStream(paramString1);
  }
  
  public void onReceiveStreamStatus(String paramString, StreamStatus paramStreamStatus)
  {
    if ("finished".equals(paramStreamStatus.getStatus())) {
      VodMediaAPI.releaseStream(paramString);
    }
  }
  
  public void onRenderProgramAdd(String paramString, GLSurfaceViewGPU paramGLSurfaceViewGPU)
  {
    this.V3.setValue(paramGLSurfaceViewGPU);
  }
  
  public void onSnapshotComplete(String paramString)
  {
    if (b.d.q.b.p.b.e(paramString))
    {
      this.c.y(getApplication().getString(2131954392));
      this.I3.set("");
      long l = System.currentTimeMillis();
      t(this.c.d, String.valueOf(l), paramString);
      paramString = com.tplink.iot.Utils.y0.e.b(getApplication(), paramString).N(new p2(this)).G0(new q2(this));
      this.M3.b(paramString);
    }
  }
  
  public void onStreamFinish()
  {
    VodMediaAPI.clearPlayerCache(this.f);
    this.R3.set(false);
  }
  
  public void playFatalException(Exception paramException)
  {
    this.c.n.set(false);
    if ((paramException instanceof CameraException))
    {
      paramException = (CameraException)paramException;
      if (paramException.getErrorCode() == -52409)
      {
        this.c.m(SdCardStatus.OFFLINE);
      }
      else if (paramException.getErrorCode() == -52407)
      {
        this.d.L();
        this.c.n.set(true);
        if (!this.W3)
        {
          com.tplink.iot.Utils.x0.e.C(this.f);
          this.W3 = true;
        }
      }
      else if (paramException.getErrorCode() == -52402)
      {
        return;
      }
    }
    hideLoadingView();
    VodMediaAPI.stopRecord(this.f);
    this.c.m.set(true);
  }
  
  public void recordFailed(int paramInt)
  {
    if (paramInt != -1) {
      switch (paramInt)
      {
      default: 
        this.c.y(getApplication().getString(2131953647));
        break;
      case -3200002: 
        this.c.y(getApplication().getString(2131953000));
      case -3200001: 
        this.c.y(getApplication().getString(2131953002));
        break;
      case -3200003: 
        this.c.y(getApplication().getString(2131953001));
        break;
      case -3200004: 
        this.c.y(getApplication().getString(2131953001));
        break;
      }
    } else {
      this.c.y(getApplication().getString(2131953647));
    }
  }
  
  public void recordProgress(long paramLong)
  {
    this.O3.set(g(paramLong / 1000L));
  }
  
  public void recordStart()
  {
    this.N3.set(true);
    this.c.y(getApplication().getString(2131954412));
    this.O3.set(g(0L));
  }
  
  public void recordStop()
  {
    this.N3.set(false);
    this.O3.set(null);
  }
  
  public void recordSuccess(int paramInt, String paramString)
  {
    if (this.L3.get())
    {
      this.L3.set(false);
      return;
    }
    if ((paramInt > 0) && (b.d.q.b.p.b.e(paramString)))
    {
      paramString = com.tplink.iot.Utils.y0.e.b(getApplication(), paramString).l0(io.reactivex.d0.b.a.a()).N(new t2(this, paramInt)).l0(io.reactivex.d0.b.a.a()).G0(new s2(this));
      this.M3.b(paramString);
    }
    else
    {
      this.c.y(getApplication().getString(2131953647));
    }
  }
  
  public void relayPreviewTimeLimit(int paramInt)
  {
    this.c.x.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(getApplication().getString(2131953365, new Object[] { Integer.valueOf(VodMediaAPI.getSingleDeviceTimeoutSeconds() / 60) })));
    VodMediaAPI.releaseStream(this.f);
    VodMediaAPI.clearPlayerCache(this.f);
    this.R3.set(false);
  }
  
  public void retryResolutions(BitStreamType paramBitStreamType) {}
  
  public void showLoadingView()
  {
    if (!this.c.q.get())
    {
      this.c.l.set(true);
      this.c.m.set(false);
    }
  }
  
  public void startHoldToTalk()
  {
    this.c.h.set(true);
  }
  
  public void stopHoldToTalk()
  {
    this.c.n();
  }
  
  public void u()
  {
    VodMediaAPI.snapshot(this.f);
  }
  
  public void v()
  {
    VodMediaAPI.addSteamDisplayCommonCallback(this.f, this);
    VodMediaAPI.setStreamControlNotificationCallback(this.f, this);
  }
  
  public void w(PlaybackMainViewModel paramPlaybackMainViewModel, PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.c = paramPlaybackMainViewModel;
    paramPlaybackMainViewModel.m.set(false);
    this.f = this.c.e;
    this.d = paramPlayBackControlViewModel;
  }
  
  public void z()
  {
    long l;
    if (!this.N3.get())
    {
      if (!b.d.q.b.p.b.r())
      {
        this.c.y(getApplication().getString(2131953000));
        return;
      }
      l = System.currentTimeMillis();
      this.Q3 = l;
      if (l - this.P3 < 1500L) {
        return;
      }
      x();
    }
    else
    {
      l = System.currentTimeMillis();
      this.P3 = l;
      if (l - this.Q3 < 1500L) {
        return;
      }
      y();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\VodViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */