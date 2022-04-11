package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import b.d.d.m.f;
import com.tplink.iot.core.p;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.m0.d;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class h
  implements StreamDisplayCommonCallback
{
  private final String c = "StreamDisplayEngine";
  private final d<e> d;
  private c f;
  private GLSurfaceViewGPU p0;
  private MutableLiveData<f<String>> p1;
  private e q;
  public String x;
  private final boolean y;
  private ViewGroup z;
  
  public h()
  {
    d locald = d.n1();
    j.d(locald, "PublishSubject.create<DisplayViewState>()");
    this.d = locald;
    this.q = e.a.e();
    this.y = (o.h0().c("SPEED_ICON_VISIBLE", true) ^ true);
    this.p1 = new MutableLiveData();
  }
  
  public final void c()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    this.f = null;
    ViewGroup localViewGroup = this.z;
    if (localViewGroup != null)
    {
      localObject = this.p0;
      if (localObject != null) {
        ((GLSurfaceViewGPU)localObject).a(localViewGroup);
      }
    }
  }
  
  public void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt)
  {
    j.e(paramString, "deviceIdMD5");
    j.e(paramBitStreamType, "bitStreamType");
  }
  
  public final MutableLiveData<f<String>> d()
  {
    return this.p1;
  }
  
  public void displayDestroy()
  {
    this.d.onNext(e.a.a().B("Display destroy"));
  }
  
  public void displayNetworkSpeed(float paramFloat)
  {
    if (!this.y)
    {
      d locald = this.d;
      e.a locala = e.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFloat);
      localStringBuilder.append("/kbs");
      locald.onNext(locala.m(localStringBuilder.toString()));
    }
  }
  
  public final q<e> e(final String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    paramString = q.f0(e.a.h().B("pausePlay")).o(600L, TimeUnit.MILLISECONDS).F(new a(this, paramString)).L0(io.reactivex.l0.a.c()).E(new b(paramString));
    j.d(paramString, "Observable\n            .…iceContext)\n            }");
    return paramString;
  }
  
  public final q<e> f(String paramString, ViewGroup paramViewGroup, Context paramContext)
  {
    j.e(paramString, "deviceIdMD5");
    j.e(paramViewGroup, "viewGroup");
    j.e(paramContext, "context");
    if (this.f == null) {
      this.f = this.d.G0(new c(this));
    }
    this.z = paramViewGroup;
    LiveMediaAPI.addSteamDisplayCommonCallback(paramString, this);
    LiveMediaAPI.startLiveStreamDisplay(paramString, paramContext, b.d.d.e.a.b(paramString));
    return this.d;
  }
  
  public void framePerSecond(String paramString, int paramInt)
  {
    j.e(paramString, "deviceIdMD5");
  }
  
  public final void g(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.x = paramString;
  }
  
  public void hideLoadingView()
  {
    this.d.onNext(e.a.i().B("hideLoadingView"));
  }
  
  public void onRenderProgramAdd(String paramString, GLSurfaceViewGPU paramGLSurfaceViewGPU)
  {
    paramString = this.z;
    if (paramString != null) {
      paramString.removeAllViews();
    }
    paramString = this.z;
    if (paramString != null) {
      paramString.addView(paramGLSurfaceViewGPU, 0);
    }
    this.p0 = paramGLSurfaceViewGPU;
  }
  
  public void onSnapshotComplete(String paramString)
  {
    j.e(paramString, "uri");
  }
  
  public void onStreamFinish()
  {
    String str = this.x;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    e(str);
  }
  
  public void playFatalException(final Exception paramException)
  {
    j.e(paramException, "e");
    if (j.a(this.q.u(), Boolean.TRUE)) {
      q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).G0(new d(this, paramException));
    } else {
      this.d.onNext(e.a.b(paramException).B("playFatalException2"));
    }
    String str = this.x;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    e(str);
    if (((paramException instanceof CameraException)) && (((CameraException)paramException).getErrorCode() == -52405))
    {
      paramException = this.x;
      if (paramException == null) {
        j.t("deviceIdMD5");
      }
      b.d.d.e.a.c(paramException, BitStreamType.MINOR_VGA);
    }
  }
  
  public void recordFailed(int paramInt) {}
  
  public void recordProgress(long paramLong) {}
  
  public void recordStart() {}
  
  public void recordStop() {}
  
  public void recordSuccess(int paramInt, String paramString)
  {
    j.e(paramString, "filePath");
  }
  
  public void relayPreviewTimeLimit(int paramInt)
  {
    this.d.onNext(e.a.h().B("RelayPreview Timeout"));
    String str = this.x;
    if (str == null) {
      j.t("deviceIdMD5");
    }
    LiveMediaAPI.releaseStream(str);
  }
  
  public void retryResolutions(BitStreamType paramBitStreamType) {}
  
  public void showLoadingView()
  {
    if ((j.a(this.q.u(), Boolean.TRUE) ^ true)) {
      this.d.onNext(e.a.f().B("showLoadingView"));
    }
  }
  
  public void startHoldToTalk() {}
  
  public void stopHoldToTalk() {}
  
  static final class a<T>
    implements g<c>
  {
    a(h paramh, String paramString) {}
    
    public final void a(c paramc)
    {
      LiveMediaAPI.previewCapture(paramString, this.c.d());
      LiveMediaAPI.removeSteamDisplayCommonCallback(paramString, this.c);
    }
  }
  
  static final class b<T>
    implements g<e>
  {
    b(String paramString) {}
    
    public final void a(e parame)
    {
      if ((!(p.c() instanceof VideoPlayActivity)) && (LiveMediaAPI.isPlayingProperly(this.c))) {
        LiveMediaAPI.releaseStream(this.c);
      }
      parame = TPIoTClientManager.K1(this.c);
      j.d(parame, "TPIoTClientManager.getCameraContext(deviceIdMD5)");
      parame = (ALCameraDevice)parame.getCameraDevice();
    }
  }
  
  static final class c<T>
    implements g<e>
  {
    c(h paramh) {}
    
    public final void a(e parame)
    {
      h localh = this.c;
      j.d(parame, "state");
      h.b(localh, parame);
    }
  }
  
  static final class d<T>
    implements g<Long>
  {
    d(h paramh, Exception paramException) {}
    
    public final void a(Long paramLong)
    {
      h.a(this.c).onNext(e.a.b(paramException).B("playFatalException1"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */