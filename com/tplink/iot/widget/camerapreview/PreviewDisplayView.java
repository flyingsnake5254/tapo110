package com.tplink.iot.widget.camerapreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.d.m.f;
import b.d.q.b.l;
import com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout;
import com.tplink.iot.Utils.m;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.ViewPreviewDisplayBinding;
import com.tplink.iot.view.ipcamera.play.CameraUpdatingDialogFragment;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog;
import com.tplink.iot.view.ipcamera.play.ForcedUpdateFwDialog.a;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.q;
import java.io.PrintStream;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class PreviewDisplayView
  extends MviFrameLayout<d, b>
  implements LifecycleObserver, d
{
  private e H3;
  private final MutableLiveData<String> I3;
  private final MutableLiveData<Boolean> J3;
  private final io.reactivex.m0.d<Boolean> K3;
  private final io.reactivex.m0.d<Boolean> L3;
  private ForcedUpdateFwDialog M3;
  private MutableLiveData<Boolean> N3;
  private boolean O3;
  private long P3;
  private long Q3;
  private int R3;
  private String f;
  private final b p0;
  private final LifecycleOwner p1;
  private final ViewPreviewDisplayBinding p2;
  private final MutableLiveData<e> p3;
  private final FirmwareManager q;
  private String x;
  private CameraPreviewInfo y;
  private final io.reactivex.m0.b<CameraPreviewInfo> z;
  
  public PreviewDisplayView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = io.reactivex.m0.b.n1();
    j.d(paramAttributeSet, "BehaviorSubject.create()");
    this.z = paramAttributeSet;
    paramAttributeSet = new b();
    this.p0 = paramAttributeSet;
    MutableLiveData localMutableLiveData1 = new MutableLiveData();
    this.p3 = localMutableLiveData1;
    this.H3 = e.a.e();
    MutableLiveData localMutableLiveData2 = new MutableLiveData();
    this.I3 = localMutableLiveData2;
    MutableLiveData localMutableLiveData3 = new MutableLiveData();
    this.J3 = localMutableLiveData3;
    Object localObject1 = io.reactivex.m0.d.n1();
    j.d(localObject1, "PublishSubject.create()");
    this.K3 = ((io.reactivex.m0.d)localObject1);
    localObject1 = io.reactivex.m0.d.n1();
    j.d(localObject1, "PublishSubject.create()");
    this.L3 = ((io.reactivex.m0.d)localObject1);
    this.N3 = new MutableLiveData(Boolean.FALSE);
    this.R3 = -1;
    localObject1 = b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class);
    j.d(localObject1, "CloudRepositoryProviders…mwareManager::class.java)");
    this.q = ((FirmwareManager)localObject1);
    localObject1 = (LifecycleOwner)paramContext;
    this.p1 = ((LifecycleOwner)localObject1);
    ((LifecycleOwner)localObject1).getLifecycle().addObserver(this);
    Object localObject2 = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559436, this, true);
    j.d(localObject2, "DataBindingUtil.inflate(…view_display, this, true)");
    localObject2 = (ViewPreviewDisplayBinding)localObject2;
    this.p2 = ((ViewPreviewDisplayBinding)localObject2);
    ((ViewDataBinding)localObject2).setLifecycleOwner((LifecycleOwner)localObject1);
    ((ViewPreviewDisplayBinding)localObject2).n(localMutableLiveData1);
    ((ViewPreviewDisplayBinding)localObject2).i(localMutableLiveData2);
    ((ViewPreviewDisplayBinding)localObject2).l(localMutableLiveData3);
    ((ViewPreviewDisplayBinding)localObject2).h(Boolean.valueOf(o.h0().c("LIVE_ICON_VISIBLE", false)));
    ((ViewPreviewDisplayBinding)localObject2).m(Boolean.valueOf(o.h0().c("SPEED_ICON_VISIBLE", false)));
    ((ViewPreviewDisplayBinding)localObject2).f.setOnClickListener(new a((ViewPreviewDisplayBinding)localObject2, this, paramContext));
    ((ViewPreviewDisplayBinding)localObject2).p3.setOnClickListener(new b(this, paramContext));
    ((ViewPreviewDisplayBinding)localObject2).p1.setOnClickListener(new c(this, paramContext));
    ((ViewPreviewDisplayBinding)localObject2).H3.setOnClickListener(new d((ViewPreviewDisplayBinding)localObject2, this, paramContext));
    ((ViewPreviewDisplayBinding)localObject2).x.setOnClickListener(new e(this, paramContext));
    localMutableLiveData1.observe((LifecycleOwner)localObject1, new f(this));
    paramAttributeSet.p().observe((LifecycleOwner)localObject1, new g(this));
  }
  
  private final String getLogPrefix()
  {
    return "";
  }
  
  private final void t()
  {
    com.tplink.iot.Utils.x0.e.n(this.x);
  }
  
  private final void u()
  {
    com.tplink.iot.Utils.x0.e.p(this.x);
  }
  
  private final void v()
  {
    long l = this.P3;
    if (l == 0L) {
      return;
    }
    double d = (this.Q3 - l) / 1000.0D;
    int i = LiveMediaAPI.getConnectType(this.x);
    int j = i;
    if (i == -1) {
      j = this.R3;
    }
    com.tplink.iot.Utils.x0.e.s(this.x, d, m.a(j));
    this.P3 = 0L;
  }
  
  private final void w(String paramString, boolean paramBoolean)
  {
    Context localContext = getContext();
    Objects.requireNonNull(localContext, "null cannot be cast to non-null type android.app.Activity");
    FirmwareUpdateNewIpcActivity.g1((Activity)localContext, paramString, paramBoolean);
    LiveMediaAPI.destroyAllDisplayAndStream();
  }
  
  private final void x(final String paramString)
  {
    if (this.M3 == null) {
      this.M3 = new ForcedUpdateFwDialog();
    }
    Object localObject = this.M3;
    if ((localObject != null) && (((Fragment)localObject).isAdded() == true)) {
      return;
    }
    localObject = this.q.g(paramString);
    ForcedUpdateFwDialog localForcedUpdateFwDialog = this.M3;
    j.c(localForcedUpdateFwDialog);
    if (localObject != null) {
      localObject = ((com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u)localObject).a();
    } else {
      localObject = "";
    }
    localForcedUpdateFwDialog.A0((String)localObject);
    localObject = this.M3;
    j.c(localObject);
    ((ForcedUpdateFwDialog)localObject).B0(new i(this, paramString));
    paramString = this.M3;
    j.c(paramString);
    localObject = getContext();
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    paramString.show(((FragmentActivity)localObject).getSupportFragmentManager(), "");
  }
  
  private final void y()
  {
    Object localObject1 = this.x;
    int i = 0;
    if (localObject1 != null)
    {
      localObject1 = TPIoTClientManager.K1((String)localObject1);
      j.d(localObject1, "TPIoTClientManager.getCameraContext(it)");
      localALCameraDevice = (ALCameraDevice)((TPBaseDeviceContext)localObject1).getCameraDevice();
      localObject1 = this.N3;
      boolean bool;
      if ((localALCameraDevice != null) && (localALCameraDevice.isCameraLocked())) {
        bool = true;
      } else {
        bool = false;
      }
      ((MutableLiveData)localObject1).setValue(Boolean.valueOf(bool));
      if (localALCameraDevice != null) {
        this.f = localALCameraDevice.getLockMessage();
      }
    }
    localObject1 = (e)this.p3.getValue();
    ALCameraDevice localALCameraDevice = null;
    if (localObject1 != null) {
      localObject1 = ((e)localObject1).q();
    } else {
      localObject1 = null;
    }
    Boolean localBoolean = Boolean.TRUE;
    if (j.a(localObject1, localBoolean))
    {
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).r();
      } else {
        localObject1 = null;
      }
      if ((localObject1 instanceof CameraException))
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).r();
        } else {
          localObject1 = null;
        }
        Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.tplink.libtpnetwork.cameranetwork.net.CameraException");
        if (((CameraException)localObject1).getErrorCode() == -52405)
        {
          localObject1 = this.p2.I3;
          j.d(localObject1, "binding.tvTooManyUser");
          ((TextView)localObject1).setVisibility(0);
          localObject1 = this.p2.z;
          j.d(localObject1, "binding.ivTooManyUserMask");
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = this.x;
          if ((localObject1 == null) || (this.O3)) {
            break label306;
          }
          com.tplink.iot.Utils.x0.e.B((String)localObject1);
          this.O3 = true;
          break label306;
        }
      }
    }
    localObject1 = this.p2.I3;
    j.d(localObject1, "binding.tvTooManyUser");
    ((TextView)localObject1).setVisibility(8);
    localObject1 = this.p2.z;
    j.d(localObject1, "binding.ivTooManyUserMask");
    ((ImageView)localObject1).setVisibility(8);
    label306:
    Object localObject2 = this.p2.f;
    if (j.a((Boolean)this.N3.getValue(), localBoolean))
    {
      j = 2131690172;
    }
    else
    {
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).x();
      } else {
        localObject1 = null;
      }
      if (j.a(localObject1, localBoolean)) {
        j = 2131231241;
      } else {
        j = 2131231242;
      }
    }
    if (!j.a((Boolean)this.N3.getValue(), localBoolean))
    {
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).w();
      } else {
        localObject1 = null;
      }
      if (!j.a(localObject1, localBoolean))
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).t();
        } else {
          localObject1 = null;
        }
        if (!j.a(localObject1, localBoolean)) {}
      }
      else
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).u();
        } else {
          localObject1 = null;
        }
        if ((j.a(localObject1, localBoolean) ^ true))
        {
          localObject1 = (e)this.p3.getValue();
          if (localObject1 != null) {
            localObject1 = ((e)localObject1).x();
          } else {
            localObject1 = null;
          }
          if ((j.a(localObject1, localBoolean) ^ true)) {
            break label590;
          }
          localObject1 = (e)this.p3.getValue();
          if (localObject1 != null) {
            localObject1 = ((e)localObject1).s();
          } else {
            localObject1 = null;
          }
          if (j.a(localObject1, localBoolean)) {
            break label590;
          }
        }
      }
      k = 8;
      break label593;
    }
    label590:
    int k = 0;
    label593:
    ((ImageView)localObject2).setVisibility(k);
    ((ImageView)localObject2).setImageResource(j);
    if (j.a((Boolean)this.N3.getValue(), localBoolean)) {}
    do
    {
      do
      {
        do
        {
          j = 8;
          break label809;
          localObject1 = (e)this.p3.getValue();
          if (localObject1 != null) {
            localObject1 = ((e)localObject1).w();
          } else {
            localObject1 = null;
          }
          if (j.a(localObject1, localBoolean)) {
            break;
          }
          localObject1 = (e)this.p3.getValue();
          if (localObject1 != null) {
            localObject1 = ((e)localObject1).t();
          } else {
            localObject1 = null;
          }
        } while (!j.a(localObject1, localBoolean));
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).u();
        } else {
          localObject1 = null;
        }
      } while (!(j.a(localObject1, localBoolean) ^ true));
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).x();
      } else {
        localObject1 = null;
      }
      if ((j.a(localObject1, localBoolean) ^ true)) {
        break;
      }
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).s();
      } else {
        localObject1 = null;
      }
    } while (!j.a(localObject1, localBoolean));
    int j = 0;
    label809:
    localObject1 = this.p2.H3;
    j.d(localObject1, "binding.soundStatus");
    ((ImageView)localObject1).setVisibility(j);
    localObject1 = this.p2.p1;
    j.d(localObject1, "binding.manageBtn");
    ((TextView)localObject1).setVisibility(j);
    localObject2 = this.p2.x;
    if (!j.a((Boolean)this.N3.getValue(), localBoolean))
    {
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).w();
      } else {
        localObject1 = null;
      }
      if (!j.a(localObject1, localBoolean))
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).t();
        } else {
          localObject1 = null;
        }
        if (!j.a(localObject1, localBoolean)) {}
      }
      else
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).x();
        } else {
          localObject1 = null;
        }
        if ((j.a(localObject1, localBoolean) ^ true)) {
          break label1060;
        }
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).s();
        } else {
          localObject1 = null;
        }
        if (j.a(localObject1, localBoolean)) {
          break label1060;
        }
      }
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).z();
      } else {
        localObject1 = null;
      }
      if (!j.a(localObject1, localBoolean))
      {
        j = 8;
        break label1063;
      }
    }
    label1060:
    j = 0;
    label1063:
    ((TextView)localObject2).setVisibility(j);
    if (j.a((Boolean)this.N3.getValue(), localBoolean))
    {
      localObject1 = ((TextView)localObject2).getContext();
      j.d(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getString(2131951751);
    }
    else
    {
      localObject1 = (e)this.p3.getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).z();
      } else {
        localObject1 = null;
      }
      if (j.a(localObject1, localBoolean))
      {
        localObject1 = ((TextView)localObject2).getContext();
        j.d(localObject1, "context");
        localObject1 = ((Context)localObject1).getResources().getString(2131952986);
      }
      else
      {
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).o();
        } else {
          localObject1 = null;
        }
      }
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    if (j.a((Boolean)this.N3.getValue(), localBoolean)) {}
    do
    {
      do
      {
        j = 8;
        break;
        localObject1 = (e)this.p3.getValue();
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).w();
        } else {
          localObject1 = null;
        }
      } while (!(j.a(localObject1, localBoolean) ^ true));
      localObject2 = (e)this.p3.getValue();
      localObject1 = localALCameraDevice;
      if (localObject2 != null) {
        localObject1 = ((e)localObject2).t();
      }
    } while (!(j.a(localObject1, localBoolean) ^ true));
    j = i;
    localObject1 = this.p2.p2;
    j.d(localObject1, "binding.offlineTag");
    ((TextView)localObject1).setVisibility(j);
    localObject1 = this.p2.d;
    j.d(localObject1, "binding.cameraOfflineMask");
    ((ImageView)localObject1).setVisibility(j);
  }
  
  public q<CameraPreviewInfo> K()
  {
    return this.z;
  }
  
  public q<Boolean> P()
  {
    return this.L3;
  }
  
  public final int getConnectType()
  {
    return this.R3;
  }
  
  public Context getContextForView()
  {
    Context localContext = getContext();
    j.d(localContext, "context");
    return localContext;
  }
  
  public final String getDeviceIdMD5()
  {
    return this.x;
  }
  
  public q<Boolean> getFirmwareIntent()
  {
    q localq = q.f0(Boolean.TRUE);
    j.d(localq, "Observable.just(true)");
    return localq;
  }
  
  public final FirmwareManager getFirmwareManager()
  {
    return this.q;
  }
  
  public ViewGroup getParentView()
  {
    FrameLayout localFrameLayout = this.p2.p0;
    j.d(localFrameLayout, "binding.liveSurfaceView");
    return localFrameLayout;
  }
  
  public final long getPlayEndTimestamp()
  {
    return this.Q3;
  }
  
  public final long getPlayStartTimestamp()
  {
    return this.P3;
  }
  
  public final CameraPreviewInfo getPreviewInfo()
  {
    return this.y;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onActivityResume()
  {
    String str = this.x;
    if (str != null) {
      l.e(str, new h(this));
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public final void onActivityStop()
  {
    this.K3.onNext(Boolean.FALSE);
    this.J3.setValue(Boolean.TRUE);
    this.Q3 = System.currentTimeMillis();
    v();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.K3.onNext(Boolean.FALSE);
    Object localObject = this.p2.p0;
    j.d(localObject, "binding.liveSurfaceView");
    ((FrameLayout)localObject).setVisibility(4);
    LiveMediaAPI.stopDisplay(this.x);
    localObject = this.x;
    if (localObject != null)
    {
      j.c(localObject);
      localObject = TPIoTClientManager.K1((String)localObject);
      j.d(localObject, "TPIoTClientManager.getCameraContext(deviceIdMD5!!)");
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
    }
  }
  
  public b s()
  {
    return this.p0;
  }
  
  public void s0(e parame)
  {
    j.e(parame, "viewState");
    Object localObject = (e)this.p3.getValue();
    boolean bool1 = false;
    if (localObject != null)
    {
      localObject = ((e)localObject).x();
      if (localObject != null)
      {
        bool2 = ((Boolean)localObject).booleanValue();
        break label45;
      }
    }
    boolean bool2 = false;
    label45:
    localObject = parame.x();
    if (localObject != null) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    if (bool2 != bool1)
    {
      localObject = (e)this.p3.getValue();
      if (localObject != null) {
        localObject = ((e)localObject).x();
      } else {
        localObject = null;
      }
      if (j.a(localObject, Boolean.TRUE))
      {
        this.P3 = System.currentTimeMillis();
        this.R3 = LiveMediaAPI.getConnectType(this.x);
      }
      else
      {
        this.Q3 = System.currentTimeMillis();
        v();
      }
    }
    this.p3.setValue(parame);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getLogPrefix());
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(parame);
    parame = ((StringBuilder)localObject).toString();
    System.out.println(parame);
  }
  
  public final void setConnectType(int paramInt)
  {
    this.R3 = paramInt;
  }
  
  public final void setDeviceIdMD5(String paramString)
  {
    if (j.a(this.x, paramString)) {
      return;
    }
    this.x = paramString;
    this.p0.q(paramString);
    y();
  }
  
  public final void setPlayEndTimestamp(long paramLong)
  {
    this.Q3 = paramLong;
  }
  
  public final void setPlayStartTimestamp(long paramLong)
  {
    this.P3 = paramLong;
  }
  
  public final void setPreviewInfo(CameraPreviewInfo paramCameraPreviewInfo)
  {
    if (j.a(this.y, paramCameraPreviewInfo)) {
      return;
    }
    this.y = paramCameraPreviewInfo;
    if (paramCameraPreviewInfo != null)
    {
      if (!paramCameraPreviewInfo.m()) {
        this.K3.onNext(Boolean.FALSE);
      }
      this.z.onNext(paramCameraPreviewInfo);
    }
  }
  
  public q<Boolean> x0()
  {
    return this.K3;
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(ViewPreviewDisplayBinding paramViewPreviewDisplayBinding, PreviewDisplayView paramPreviewDisplayView, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      paramView = (Boolean)PreviewDisplayView.b(jdField_this).getValue();
      Boolean localBoolean = Boolean.TRUE;
      if (j.a(paramView, localBoolean))
      {
        paramView = paramContext;
        Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.app.Activity");
        com.tplink.iot.viewmodel.home.u.f((Activity)paramView, PreviewDisplayView.d(jdField_this));
      }
      else
      {
        paramView = (e)PreviewDisplayView.j(jdField_this).getValue();
        Object localObject = null;
        if (paramView != null) {
          paramView = paramView.t();
        } else {
          paramView = null;
        }
        if (j.a(paramView, localBoolean))
        {
          paramView = paramContext;
          Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.app.Activity");
          s0.s((Activity)paramView, 2131954295);
        }
        else
        {
          paramView = (e)PreviewDisplayView.j(jdField_this).getValue();
          if (paramView != null) {
            paramView = paramView.v();
          } else {
            paramView = null;
          }
          if (j.a(paramView, localBoolean))
          {
            paramView = jdField_this;
            PreviewDisplayView.o(paramView, paramView.getDeviceIdMD5());
          }
          else
          {
            paramView = new StringBuilder();
            paramView.append(PreviewDisplayView.e(jdField_this));
            paramView.append("->cameraPlayBtn clicked");
            paramView = paramView.toString();
            System.out.println(paramView);
            e locale = (e)PreviewDisplayView.j(jdField_this).getValue();
            paramView = (View)localObject;
            if (locale != null) {
              paramView = locale.x();
            }
            boolean bool = j.a(paramView, localBoolean) ^ true;
            PreviewDisplayView.f(jdField_this).onNext(Boolean.valueOf(bool));
            paramView = this.c.H3;
            j.d(paramView, "soundStatus");
            if (paramView.getTag() == null)
            {
              LiveMediaAPI.muteAudio(jdField_this.getDeviceIdMD5(), true);
              paramView = this.c.H3;
              j.d(paramView, "soundStatus");
              paramView.setTag(Boolean.FALSE);
            }
            else
            {
              paramView = this.c.H3;
              j.d(paramView, "soundStatus");
              if ((paramView.getTag() instanceof Boolean))
              {
                paramView = jdField_this.getDeviceIdMD5();
                localObject = this.c.H3;
                j.d(localObject, "soundStatus");
                localObject = ((ImageView)localObject).getTag();
                Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Boolean");
                LiveMediaAPI.muteAudio(paramView, true ^ ((Boolean)localObject).booleanValue());
              }
            }
            if (bool) {
              PreviewDisplayView.l(jdField_this);
            }
          }
        }
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(PreviewDisplayView paramPreviewDisplayView, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      paramView = (e)PreviewDisplayView.j(this.c).getValue();
      io.reactivex.m0.d locald = null;
      if (paramView != null) {
        paramView = paramView.z();
      } else {
        paramView = null;
      }
      Boolean localBoolean = Boolean.TRUE;
      if (j.a(paramView, localBoolean))
      {
        paramView = paramContext;
        Objects.requireNonNull(paramView, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        paramView = (FragmentActivity)paramView;
        new CameraUpdatingDialogFragment().show(paramView.getSupportFragmentManager(), "UpdatingDialog");
      }
      else
      {
        e locale = (e)PreviewDisplayView.j(this.c).getValue();
        paramView = locald;
        if (locale != null) {
          paramView = locale.x();
        }
        if (j.a(paramView, localBoolean))
        {
          paramView = new StringBuilder();
          paramView.append(PreviewDisplayView.e(this.c));
          paramView.append("->previewCover clicked");
          paramView = paramView.toString();
          System.out.println(paramView);
          locald = PreviewDisplayView.c(this.c);
          paramView = PreviewDisplayView.a(this.c).f;
          j.d(paramView, "binding.cameraPlayBtn");
          boolean bool;
          if (paramView.getVisibility() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          locald.onNext(Boolean.valueOf(bool));
        }
      }
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(PreviewDisplayView paramPreviewDisplayView, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      PreviewDisplayView.k(this.c);
      paramView = (e)PreviewDisplayView.j(this.c).getValue();
      Object localObject = null;
      if (paramView != null) {
        paramView = paramView.t();
      } else {
        paramView = null;
      }
      Boolean localBoolean = Boolean.TRUE;
      if (j.a(paramView, localBoolean))
      {
        paramView = paramContext;
        Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.app.Activity");
        s0.s((Activity)paramView, 2131954295);
      }
      else
      {
        e locale = (e)PreviewDisplayView.j(this.c).getValue();
        paramView = (View)localObject;
        if (locale != null) {
          paramView = locale.v();
        }
        if (j.a(paramView, localBoolean))
        {
          paramView = this.c;
          PreviewDisplayView.o(paramView, paramView.getDeviceIdMD5());
        }
        else
        {
          LiveMediaAPI.allDisplayScreenshotPreview();
          LiveMediaAPI.destroyAllDisplayAndStream();
          paramContext.startActivity(new Intent(paramContext, VideoPlayActivity.class).putExtra("device_id_md5", this.c.getDeviceIdMD5()));
        }
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(ViewPreviewDisplayBinding paramViewPreviewDisplayBinding, PreviewDisplayView paramPreviewDisplayView, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.H3;
      j.d(paramView, "soundStatus");
      paramView = paramView.getTag();
      int i = 2131231625;
      boolean bool = true;
      if (paramView == null)
      {
        LiveMediaAPI.muteAudio(jdField_this.getDeviceIdMD5(), false);
        paramView = this.c.H3;
        j.d(paramView, "soundStatus");
        paramView.setTag(Boolean.TRUE);
        this.c.H3.setImageResource(2131231625);
        com.tplink.iot.Utils.x0.e.y(jdField_this.getDeviceIdMD5(), true);
      }
      else
      {
        paramView = this.c.H3;
        j.d(paramView, "soundStatus");
        if ((paramView.getTag() instanceof Boolean))
        {
          paramView = this.c.H3;
          j.d(paramView, "soundStatus");
          paramView = paramView.getTag();
          Objects.requireNonNull(paramView, "null cannot be cast to non-null type kotlin.Boolean");
          if (!((Boolean)paramView).booleanValue()) {}
        }
        else
        {
          bool = false;
        }
        paramView = this.c.H3;
        j.d(paramView, "soundStatus");
        paramView.setTag(Boolean.valueOf(bool));
        LiveMediaAPI.muteAudio(jdField_this.getDeviceIdMD5(), bool ^ true);
        paramView = this.c.H3;
        if (!bool) {
          i = 2131231626;
        }
        paramView.setImageResource(i);
        com.tplink.iot.Utils.x0.e.y(jdField_this.getDeviceIdMD5(), bool);
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(PreviewDisplayView paramPreviewDisplayView, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      if (j.a((Boolean)PreviewDisplayView.b(this.c).getValue(), Boolean.TRUE))
      {
        paramView = paramContext;
        Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.app.Activity");
        com.tplink.iot.viewmodel.home.u.f((Activity)paramView, PreviewDisplayView.d(this.c));
      }
    }
  }
  
  static final class f<T>
    implements Observer<e>
  {
    f(PreviewDisplayView paramPreviewDisplayView) {}
    
    public final void a(e parame)
    {
      if (parame == null) {
        return;
      }
      Object localObject1 = (e)PreviewDisplayView.j(this.a).getValue();
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).x();
      } else {
        localObject1 = null;
      }
      Boolean localBoolean1 = Boolean.TRUE;
      if ((j.a(localObject1, localBoolean1)) && ((j.a(PreviewDisplayView.i(this.a).x(), localBoolean1) ^ true)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(PreviewDisplayView.e(this.a));
        ((StringBuilder)localObject1).append("->hide func btn when play");
        localObject1 = ((StringBuilder)localObject1).toString();
        System.out.println(localObject1);
        localObject1 = PreviewDisplayView.c(this.a);
        Boolean localBoolean2 = Boolean.FALSE;
        ((io.reactivex.m0.d)localObject1).onNext(localBoolean2);
        PreviewDisplayView.h(this.a).setValue(localBoolean2);
      }
      localObject1 = (e)PreviewDisplayView.j(this.a).getValue();
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).q();
      } else {
        localObject1 = null;
      }
      if (j.a(localObject1, localBoolean1)) {
        PreviewDisplayView.h(this.a).setValue(localBoolean1);
      }
      PreviewDisplayView.n(this.a, parame);
      localObject1 = (e)PreviewDisplayView.j(this.a).getValue();
      parame = (e)localObject2;
      if (localObject1 != null) {
        parame = ((e)localObject1).v();
      }
      if ((j.a(parame, localBoolean1)) && ((j.a(PreviewDisplayView.i(this.a).v(), localBoolean1) ^ true)))
      {
        PreviewDisplayView.f(this.a).onNext(Boolean.FALSE);
        PreviewDisplayView.h(this.a).setValue(localBoolean1);
      }
      PreviewDisplayView.p(this.a);
    }
  }
  
  static final class g<T>
    implements Observer<f<String>>
  {
    g(PreviewDisplayView paramPreviewDisplayView) {}
    
    public final void a(f<String> paramf)
    {
      j.d(paramf, "event");
      paramf = (String)paramf.a();
      if (paramf != null) {
        l.e(paramf, new a(this));
      }
    }
    
    static final class a<T>
      implements com.tplink.libtpnetwork.Utils.f0.b<c>
    {
      a(PreviewDisplayView.g paramg) {}
      
      public final void b(c paramc)
      {
        MutableLiveData localMutableLiveData = PreviewDisplayView.g(this.a.a);
        j.d(paramc, "deviceInfo");
        localMutableLiveData.setValue(paramc.i());
      }
    }
  }
  
  static final class h<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<c>
  {
    h(PreviewDisplayView paramPreviewDisplayView) {}
    
    public final void b(c paramc)
    {
      MutableLiveData localMutableLiveData = PreviewDisplayView.g(this.a);
      j.d(paramc, "deviceInfo");
      localMutableLiveData.setValue(paramc.i());
    }
  }
  
  public static final class i
    implements ForcedUpdateFwDialog.a
  {
    i(String paramString) {}
    
    public void a() {}
    
    public void b()
    {
      PreviewDisplayView.m(this.a, paramString, false);
    }
    
    public void c()
    {
      PreviewDisplayView.m(this.a, paramString, true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\PreviewDisplayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */