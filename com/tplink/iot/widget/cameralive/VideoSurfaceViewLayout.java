package com.tplink.iot.widget.cameralive;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.libmediaapi.common.apicallback.SimpleStreamNotificationCallback;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LensMaskRepository;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.util.concurrent.TimeUnit;

public class VideoSurfaceViewLayout
  extends FrameLayout
  implements StreamDisplayCommonCallback, LifecycleObserver
{
  private final ObservableBoolean H3 = new ObservableBoolean();
  private final ObservableBoolean I3 = new ObservableBoolean(false);
  private final ObservableBoolean J3 = new ObservableBoolean(false);
  private final ObservableBoolean K3 = new ObservableBoolean(false);
  private final ObservableBoolean L3 = new ObservableBoolean(false);
  private final ObservableBoolean M3 = new ObservableBoolean(false);
  private final ObservableField<String> N3 = new ObservableField("");
  private final ObservableBoolean O3 = new ObservableBoolean(false);
  private final ObservableField<String> P3 = new ObservableField("");
  private io.reactivex.m0.d<Integer> Q3;
  private Observable.OnPropertyChangedCallback R3 = new a();
  LensMaskRepository S3;
  MediatorLiveData<Boolean> T3 = new MediatorLiveData();
  CommonCameraRepository U3;
  private long V3 = 0L;
  private long W3 = 0L;
  private int X3 = -1;
  private boolean Y3 = true;
  private boolean Z3 = false;
  private GLSurfaceViewGPU a4;
  private String b4;
  private String c;
  public ALCameraDevice d;
  boolean f = false;
  private ViewVideoSurfaceLayoutBinding p0;
  private LifecycleOwner p1;
  public final ObservableBoolean p2 = new ObservableBoolean(false);
  public final ObservableBoolean p3 = new ObservableBoolean(false);
  boolean q = false;
  boolean x = false;
  private io.reactivex.e0.b y = new io.reactivex.e0.b();
  private int z;
  
  public VideoSurfaceViewLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoSurfaceViewLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h(paramContext);
    f0(paramContext);
  }
  
  public VideoSurfaceViewLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h(paramContext);
    f0(paramContext);
  }
  
  private void Z()
  {
    if (this.V3 == 0L) {
      return;
    }
    b.d.d.e.a.a(this.c, new r(this));
  }
  
  private void d()
  {
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (ALCameraDevice)TPIoTClientManager.K1((String)localObject).getCameraDevice();
    }
    this.d = ((ALCameraDevice)localObject);
    e();
    f();
  }
  
  private void d0(@StringRes int paramInt)
  {
    TSnackbar.x((Activity)getContext(), paramInt, -1).N();
  }
  
  private void f()
  {
    ALCameraDevice localALCameraDevice = this.d;
    if (localALCameraDevice != null) {
      this.O3.set(localALCameraDevice.isCameraLocked());
    }
  }
  
  private void f0(Context paramContext)
  {
    if (!(paramContext instanceof LifecycleOwner)) {
      return;
    }
    paramContext = (LifecycleOwner)paramContext;
    this.p1 = paramContext;
    paramContext.getLifecycle().addObserver(this);
    this.T3.observe(this.p1, new v(this));
  }
  
  private void g()
  {
    Object localObject = this.Q3;
    if (localObject != null)
    {
      localObject = ((io.reactivex.q)localObject).l0(io.reactivex.d0.b.a.a()).H0(new q(this), o.c);
      this.y.b((io.reactivex.e0.c)localObject);
    }
  }
  
  private void g0()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("switchCameraLockedErrorStatus");
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    long l;
    if (this.p2.get()) {
      l = 1L;
    } else {
      l = 0L;
    }
    localObject = io.reactivex.q.W0(l, TimeUnit.SECONDS).G0(new d(this));
    this.y.b((io.reactivex.e0.c)localObject);
    this.W3 = System.currentTimeMillis();
    Z();
  }
  
  private String getLogPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ItemPosition: ");
    localStringBuilder.append(this.z);
    localStringBuilder.append(",DeviceIdMD5: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  private void h0(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("switchErrorStatus: ");
    ((StringBuilder)localObject).append(paramBoolean);
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      long l;
      if (this.p2.get()) {
        l = 1L;
      } else {
        l = 0L;
      }
      localObject = io.reactivex.q.W0(l, TimeUnit.SECONDS).G0(new m(this));
      this.y.b((io.reactivex.e0.c)localObject);
      b.d.w.c.a.e("VideoSurfaceViewLayout", Log.getStackTraceString(new RuntimeException("switchErrorStatus")));
      this.W3 = System.currentTimeMillis();
      Z();
    }
    else
    {
      this.p2.set(true);
      this.p3.set(false);
      b0();
    }
  }
  
  private boolean i()
  {
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (ALCameraDevice)TPIoTClientManager.K1((String)localObject).getCameraDevice();
    }
    boolean bool;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void i0(boolean paramBoolean)
  {
    if (this.I3.get() == paramBoolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("switchLensMaskStatus: ");
    ((StringBuilder)localObject).append(paramBoolean);
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    this.I3.set(paramBoolean);
    if (paramBoolean)
    {
      a0();
    }
    else
    {
      this.p2.set(true);
      this.p3.set(false);
      b0();
    }
    if (this.S3 == null)
    {
      e();
      if (this.S3 == null) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android.resource://");
    ((StringBuilder)localObject).append(com.tplink.iot.core.n.a().a());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(2131690312);
    localObject = Uri.parse(((StringBuilder)localObject).toString()).toString();
    b.d.q.b.l.e(this.c, new l(this));
    if (paramBoolean) {
      b.d.q.b.l.r(this.c, new e((String)localObject));
    } else if (((String)localObject).equals(this.b4)) {
      b.d.q.b.l.r(this.c, w.a);
    }
    if (!com.tplink.libtpnetwork.Utils.j.b(this.S3.x(), Boolean.valueOf(paramBoolean))) {
      this.S3.x().postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  private void j0(boolean paramBoolean)
  {
    if ((!this.p3.get()) && (this.p2.get() == paramBoolean)) {
      return;
    }
    this.p3.set(false);
    this.p2.set(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("switchLoadingStatus: ");
    localStringBuilder.append(paramBoolean);
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    if (!paramBoolean)
    {
      if (this.p1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
        LiveMediaAPI.muteVolume(this.c, this.q ^ true);
      }
      LiveMediaAPI.stopKeepDoubleTalk(this.c);
      this.p0.executePendingBindings();
      this.V3 = System.currentTimeMillis();
      this.X3 = LiveMediaAPI.getConnectType(this.c);
    }
  }
  
  public void a0()
  {
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    LiveMediaAPI.stopRecord(this.c);
    LiveMediaAPI.removeSteamDisplayCommonCallback(this.c, this);
    Object localObject = LiveMediaAPI.getRecordDuration(this.c);
    if (localObject != null) {
      ((BaseObservable)localObject).removeOnPropertyChangedCallback(this.R3);
    }
    this.p0.r(null);
    this.f = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("pause play");
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    LiveMediaAPI.stopNetworkStatics(this.c);
    LiveMediaAPI.stopDisplay(this.c);
    this.W3 = System.currentTimeMillis();
    Z();
  }
  
  public void b0()
  {
    if ((!this.f) && (!TextUtils.isEmpty(this.c)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getLogPrefix());
      ((StringBuilder)localObject).append("play");
      b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
      this.f = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getLogPrefix());
      ((StringBuilder)localObject).append("registerStreamDisplayCallback");
      b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
      LiveMediaAPI.addSteamDisplayCommonCallback(this.c, 0, this);
      localObject = LiveMediaAPI.getRecordDuration(this.c);
      if (localObject != null) {
        ((BaseObservable)localObject).addOnPropertyChangedCallback(this.R3);
      }
      this.p0.r(LiveMediaAPI.isRecordingObservable(this.c));
      LiveMediaAPI.setStreamControlNotificationCallback(this.c, new b());
      b.d.d.e.a.a(this.c, new c(this));
    }
  }
  
  public void c()
  {
    io.reactivex.e0.c localc = this.U3.K0().N(new p(this)).l0(io.reactivex.d0.b.a.a()).H0(new s(this), new n(this));
    this.y.b(localc);
  }
  
  public void c0()
  {
    this.L3.set(true);
  }
  
  public void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt) {}
  
  public void displayDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("displayDestroy");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    this.f = false;
  }
  
  public void displayNetworkSpeed(float paramFloat) {}
  
  public void e()
  {
    if (this.c == null) {
      return;
    }
    Object localObject = this.S3;
    if (localObject != null) {
      this.T3.removeSource(((LensMaskRepository)localObject).x());
    }
    localObject = (LensMaskRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.K1(this.c), LensMaskRepository.class);
    this.S3 = ((LensMaskRepository)localObject);
    if (com.tplink.libtpnetwork.Utils.j.h(((LensMaskRepository)localObject).x())) {
      this.S3.x().setValue(null);
    }
    MediatorLiveData localMediatorLiveData1 = this.T3;
    localObject = this.S3.x();
    MediatorLiveData localMediatorLiveData2 = this.T3;
    localMediatorLiveData2.getClass();
    localMediatorLiveData1.addSource((LiveData)localObject, new x(localMediatorLiveData2));
    this.U3 = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.K1(this.c), CommonCameraRepository.class));
  }
  
  public void e0()
  {
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    a0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("stop play");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    LiveMediaAPI.stopDisplay(this.c);
  }
  
  public void framePerSecond(String paramString, int paramInt) {}
  
  void h(Context paramContext)
  {
    Object localObject = (ViewVideoSurfaceLayoutBinding)DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559451, this, true);
    this.p0 = ((ViewVideoSurfaceLayoutBinding)localObject);
    ((ViewVideoSurfaceLayoutBinding)localObject).p(this.H3);
    this.p0.o(this.I3);
    this.p0.m(this.p2);
    this.p0.n(this.p3);
    this.p0.h(this.K3);
    this.p0.q(this.L3);
    this.p0.s(this.J3);
    this.p0.u(this.N3);
    this.p0.l(this.M3);
    this.p0.t(Boolean.valueOf(com.tplink.libtpnetwork.Utils.o.h0().c("LIVE_ICON_VISIBLE", false)));
    this.p0.i(this.O3);
    this.p0.executePendingBindings();
    i locali = new i(this);
    localObject = new h(this);
    this.p0.z.setOnLongClickListener(locali);
    this.p0.z.setOnClickListener((View.OnClickListener)localObject);
    this.p0.p3.setOnClickListener(new f(this));
    this.p0.H3.setOnClickListener(new a(this));
    this.p0.f.setOnClickListener(new g(this));
    this.p0.f.setOnLongClickListener(locali);
    localObject = new j(this, paramContext);
    paramContext = new t(this, paramContext);
    this.p0.p1.setOnClickListener((View.OnClickListener)localObject);
    this.p0.p2.setOnClickListener((View.OnClickListener)localObject);
    this.p0.x.setOnClickListener(paramContext);
  }
  
  public void hideLoadingView()
  {
    j0(false);
  }
  
  public void k0(boolean paramBoolean)
  {
    this.K3.set(paramBoolean);
    if (!paramBoolean) {
      this.L3.set(false);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onActivityResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("onActivityResume");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    if (this.I3.get())
    {
      i0(false);
    }
    else
    {
      j0(true);
      b0();
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("onActivityPause");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    a0();
  }
  
  protected void onAttachedToWindow()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("onAttachedToWindow");
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    super.onAttachedToWindow();
    localObject = this.p1;
    if (localObject != null) {
      ((LifecycleOwner)localObject).getLifecycle().addObserver(this);
    }
    this.I3.set(false);
    this.p3.set(false);
    d();
    g();
    localObject = this.c;
    if (localObject != null) {
      if (this.Y3) {
        this.Y3 = false;
      } else {
        com.tplink.iot.Utils.x0.e.d((String)localObject);
      }
    }
    b0();
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append("onDetachedFromWindow");
    b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
    localObject = this.p1;
    if (localObject != null) {
      ((LifecycleOwner)localObject).getLifecycle().removeObserver(this);
    }
    this.y.d();
    e0();
    if (this.a4 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getLogPrefix());
      ((StringBuilder)localObject).append("surfaceViewGPU.release");
      b.d.w.c.a.c("VideoSurfaceViewLayout", ((StringBuilder)localObject).toString());
      this.a4.a(this.p0.q);
    }
    localObject = this.S3;
    if (localObject != null) {
      this.T3.removeSource(((LensMaskRepository)localObject).x());
    }
    super.onDetachedFromWindow();
  }
  
  public void onRenderProgramAdd(String paramString, GLSurfaceViewGPU paramGLSurfaceViewGPU)
  {
    if (paramGLSurfaceViewGPU == null) {
      return;
    }
    if ((paramGLSurfaceViewGPU.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramGLSurfaceViewGPU.getParent()).removeView(paramGLSurfaceViewGPU);
    }
    this.p0.q.removeAllViews();
    this.p0.q.addView(paramGLSurfaceViewGPU, 0);
    this.a4 = paramGLSurfaceViewGPU;
    paramString = new u(this);
    paramGLSurfaceViewGPU.setOnClickListener(new k(this));
    this.a4.setOnLongClickListener(paramString);
  }
  
  public void onSnapshotComplete(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("onSnapshotComplete");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    if ((this.f) && (b.d.q.b.p.b.e(paramString)))
    {
      d0(2131954392);
      long l = System.currentTimeMillis();
      b.d.q.b.p.b.u(this.d, String.valueOf(l), paramString, -1);
    }
  }
  
  public void onStreamFinish()
  {
    a0();
  }
  
  public void playFatalException(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("playFatalException:");
    localStringBuilder.append(Log.getStackTraceString(paramException));
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    if (((paramException instanceof CameraException)) && (((CameraException)paramException).getErrorCode() == -52405))
    {
      this.p0.H3.setText(getContext().getString(2131952061));
      if (!this.Z3)
      {
        com.tplink.iot.Utils.x0.e.B(this.c);
        this.Z3 = true;
      }
    }
    else
    {
      this.p0.H3.setText(getContext().getString(2131952985));
    }
    if (this.O3.get()) {
      g0();
    } else {
      h0(true);
    }
  }
  
  public void recordFailed(int paramInt) {}
  
  public void recordProgress(long paramLong) {}
  
  public void recordStart()
  {
    this.N3.set(b.d.q.b.m.a(0L));
    d0(2131954412);
  }
  
  public void recordStop() {}
  
  public void recordSuccess(int paramInt, String paramString)
  {
    if ((paramInt > 0) && (b.d.q.b.p.b.e(paramString))) {
      d0(2131954432);
    } else {
      d0(2131953647);
    }
  }
  
  public void relayPreviewTimeLimit(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("relayPreviewTimeLimit");
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    a0();
    h0(true);
    this.Q3.onNext(Integer.valueOf(paramInt));
  }
  
  public void retryResolutions(BitStreamType paramBitStreamType) {}
  
  public void setDeviceIdMD5(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.M3.set(paramBoolean);
  }
  
  public void setIsFocused(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      if (this.c == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getLogPrefix());
      String str;
      if (paramBoolean) {
        str = "get";
      } else {
        str = "lose";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" focus");
      b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
      if (!paramBoolean)
      {
        LiveMediaAPI.destroyDoubleTalkClient(this.c);
        LiveMediaAPI.stopRecord(this.c);
      }
      if (LiveMediaAPI.isPlayingProperly(this.c)) {
        LiveMediaAPI.muteVolume(this.c, paramBoolean ^ true);
      }
    }
  }
  
  public void setIsHQ(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setItemPosition(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLogPrefix());
    localStringBuilder.append("new position:");
    localStringBuilder.append(paramInt);
    b.d.w.c.a.c("VideoSurfaceViewLayout", localStringBuilder.toString());
    this.z = paramInt;
  }
  
  public void setMultiScreen(boolean paramBoolean)
  {
    this.H3.set(paramBoolean);
  }
  
  public void setRelayEventSubject(io.reactivex.m0.d<Integer> paramd)
  {
    this.Q3 = paramd;
  }
  
  public void setVideoResolution(String paramString)
  {
    this.P3.set(paramString);
  }
  
  public void showLoadingView()
  {
    j0(true);
  }
  
  public void startHoldToTalk() {}
  
  public void stopHoldToTalk() {}
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      long l = ((ObservableLong)paramObservable).get();
      VideoSurfaceViewLayout.a(VideoSurfaceViewLayout.this).set(b.d.q.b.m.a(l));
    }
  }
  
  class b
    extends SimpleStreamNotificationCallback
  {
    b() {}
    
    public void onReceiveDeviceLockedInfo(String paramString, DeviceLockedInfo paramDeviceLockedInfo)
    {
      VideoSurfaceViewLayout.this.a0();
      if ((VideoSurfaceViewLayout.this.getContext() instanceof Activity)) {
        com.tplink.iot.viewmodel.home.u.g((Activity)VideoSurfaceViewLayout.this.getContext(), paramDeviceLockedInfo.getEventMessage(), new b(this));
      }
    }
    
    public void onReceiveLensMaskInfo(String paramString, boolean paramBoolean)
    {
      VideoSurfaceViewLayout.b(VideoSurfaceViewLayout.this, paramBoolean);
      if (!com.tplink.libtpnetwork.Utils.j.b(VideoSurfaceViewLayout.this.S3.x(), Boolean.valueOf(paramBoolean))) {
        VideoSurfaceViewLayout.this.S3.x().postValue(Boolean.valueOf(paramBoolean));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\cameralive\VideoSurfaceViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */