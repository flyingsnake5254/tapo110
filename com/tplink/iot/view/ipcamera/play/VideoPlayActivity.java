package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.a.a.a.a.a.d;
import b.d.q.b.o;
import com.tplink.iot.Utils.ScreenOrientationListenHelper;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.l;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityVideoPlayNewIpcBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding;
import com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding;
import com.tplink.iot.databinding.LayoutCameraMenuDefinitionBinding;
import com.tplink.iot.databinding.LayoutCameraMenuInfraredBinding;
import com.tplink.iot.databinding.LayoutCameraMenuSettingsBinding;
import com.tplink.iot.view.cloudvideo.CloudStorageFragment;
import com.tplink.iot.view.ipcamera.play.functionintroduce.CameraFirstShowFunctionGuideDialog;
import com.tplink.iot.view.ipcamera.play.functionintroduce.CameraFirstShowFunctionGuideDialog.d;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoControlPanelViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.l9;
import com.tplink.iot.viewmodel.ipcamera.setting.m9;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.AppSettingsDialog.b;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

public class VideoPlayActivity
  extends BaseActivity
  implements EasyPermissions.PermissionCallbacks, View.OnClickListener
{
  private TextView H3;
  private PopupWindow I3;
  private View J3;
  private TextView K3;
  private ImageView L3;
  private PopupWindow M3;
  private View N3;
  private ImageView O3;
  private Toolbar P3;
  private MultiLiveVideoViewModel Q3;
  private TalkViewModel R3;
  private VideoControlPanelViewModel S3;
  private c T3;
  private io.reactivex.e0.b U3 = new io.reactivex.e0.b();
  private c V3;
  private ScreenOrientationListenHelper W3;
  private boolean X3 = false;
  UniversalDialog.a Y3 = new UniversalDialog.a();
  CameraFirstShowFunctionGuideDialog Z3;
  private boolean a4 = false;
  private boolean b4 = false;
  private b.a.a.a.a.a.a c4;
  private c d4;
  private ActivityVideoPlayNewIpcBinding p0;
  private VideoPlayViewModel p1;
  private ImageView p2;
  private View p3;
  private MultiLiveAdvancedFragment y;
  private Stack<com.tplink.iot.view.ipcamera.base.f> z;
  
  private void B1()
  {
    if (this.z.size() <= 1)
    {
      E1(2);
    }
    else
    {
      this.z.pop();
      com.tplink.iot.view.ipcamera.base.f localf = (com.tplink.iot.view.ipcamera.base.f)this.z.peek();
      V2(localf.b(), localf.a(), 1);
    }
  }
  
  private int C1(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
  
  private BaseFragment F1()
  {
    Object localObject1 = (OperationShellFragment)getSupportFragmentManager().findFragmentByTag("VideoPlay.CloudTerraceControlFragment");
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new OperationShellFragment();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("first_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
      ((Bundle)localObject1).putString("second_operation_fragment_tag", "VideoPlay.CloudTerracePresetFragment");
      ((Fragment)localObject2).setArguments((Bundle)localObject1);
    }
    return (BaseFragment)localObject2;
  }
  
  private int[] G1(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt == 0)
    {
      arrayOfInt[0] = 2130772052;
      arrayOfInt[1] = 2130772057;
    }
    else if (paramInt == 1)
    {
      arrayOfInt[0] = 2130772029;
      arrayOfInt[1] = 2130772030;
    }
    else if (paramInt == 2)
    {
      arrayOfInt[0] = 17432576;
      arrayOfInt[1] = 17432577;
    }
    return arrayOfInt;
  }
  
  private PlayBackControlFragment H1()
  {
    PlayBackControlFragment localPlayBackControlFragment1 = (PlayBackControlFragment)getSupportFragmentManager().findFragmentByTag("VideoPlay.PlayBackControlFragment");
    PlayBackControlFragment localPlayBackControlFragment2 = localPlayBackControlFragment1;
    if (localPlayBackControlFragment1 == null) {
      localPlayBackControlFragment2 = new PlayBackControlFragment();
    }
    return localPlayBackControlFragment2;
  }
  
  private BaseFragment I1()
  {
    Object localObject1 = (OperationShellFragment)getSupportFragmentManager().findFragmentByTag("VideoPlay.TalkFragment");
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new OperationShellFragment();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("first_operation_fragment_tag", "VideoPlay.TalkFragment");
      if (this.p1.I.get()) {
        ((Bundle)localObject1).putString("second_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
      }
      ((Fragment)localObject2).setArguments((Bundle)localObject1);
    }
    return (BaseFragment)localObject2;
  }
  
  private VideoControlPanelFragment J1()
  {
    VideoControlPanelFragment localVideoControlPanelFragment1 = (VideoControlPanelFragment)getSupportFragmentManager().findFragmentByTag("VideoPlay.VideoControlPanelFragment");
    VideoControlPanelFragment localVideoControlPanelFragment2 = localVideoControlPanelFragment1;
    if (localVideoControlPanelFragment1 == null) {
      localVideoControlPanelFragment2 = new VideoControlPanelFragment();
    }
    return localVideoControlPanelFragment2;
  }
  
  private BaseFragment K1()
  {
    Object localObject1 = (OperationShellFragment)getSupportFragmentManager().findFragmentByTag("VideoPlay.VoiceCallFragment");
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new OperationShellFragment();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("first_operation_fragment_tag", "VideoPlay.VoiceCallFragment");
      if (this.p1.I.get()) {
        ((Bundle)localObject1).putString("second_operation_fragment_tag", "VideoPlay.CloudTerraceControlFragment");
      }
      ((Fragment)localObject2).setArguments((Bundle)localObject1);
    }
    return (BaseFragment)localObject2;
  }
  
  private void L1()
  {
    this.p1 = ((VideoPlayViewModel)ViewModelProviders.of(this).get(VideoPlayViewModel.class));
    this.Q3 = ((MultiLiveVideoViewModel)ViewModelProviders.of(this).get(MultiLiveVideoViewModel.class));
    this.R3 = ((TalkViewModel)ViewModelProviders.of(this).get(TalkViewModel.class));
    this.S3 = ((VideoControlPanelViewModel)ViewModelProviders.of(this).get(VideoControlPanelViewModel.class));
    this.p1.j = getIntent().getStringExtra("device_id_md5");
    Object localObject = this.p1;
    ((VideoPlayViewModel)localObject).k.setValue(((VideoPlayViewModel)localObject).j);
    localObject = this.p1.n();
    this.z = ((Stack)localObject);
    ((Stack)localObject).clear();
    this.S3.C(this.p1);
  }
  
  @SuppressLint({"CheckResult"})
  private void M1()
  {
    c localc = this.d4;
    if (localc != null) {
      localc.dispose();
    }
    this.d4 = d.a(AppContext.c).L0(io.reactivex.l0.a.c()).L(b.a.a.a.a.a.b.b(new NetworkInfo.State[] { NetworkInfo.State.CONNECTED })).L(b.a.a.a.a.a.b.c(new int[] { 0, 1 })).l0(io.reactivex.d0.b.a.a()).G0(new g());
  }
  
  private void N1()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = new ScreenOrientationListenHelper(this);
    this.W3 = localScreenOrientationListenHelper;
    localScreenOrientationListenHelper.f(new w3(this));
  }
  
  private void O1()
  {
    Object localObject = (ActivityVideoPlayNewIpcBinding)DataBindingUtil.setContentView(this, 2131558706);
    this.p0 = ((ActivityVideoPlayNewIpcBinding)localObject);
    ((ActivityVideoPlayNewIpcBinding)localObject).h(this.p1);
    this.p0.y.setOnClickListener(new i3(this));
    T2();
    localObject = this.p1;
    if (h.B(((VideoPlayViewModel)localObject).j, ((VideoPlayViewModel)localObject).k()))
    {
      A1();
      X2();
      com.tplink.libtpnetwork.Utils.u.l(this.p1.j, false);
    }
    else
    {
      v1();
      N1();
      e0("VideoPlay.VideoControlPanelFragment", null);
      u1();
      c3();
      d3();
      M1();
      if (h.C(this.p1.j)) {
        h.E(this, this.p1.j);
      }
    }
    this.p0.f.setOnClickListener(this);
  }
  
  private boolean P1(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (com.tplink.libtpnetwork.Utils.f.f(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void R2()
  {
    this.X3 = false;
    EasyPermissions.f(this, getString(2131953352), 0, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  private void S2(String paramString)
  {
    c localc = this.T3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.T3.dispose();
    }
    if (paramString == null) {
      return;
    }
    localc = l9.a().b(paramString).i().G0(new v3(this, paramString));
    this.T3 = localc;
    this.U3.b(localc);
    l9.a().b(paramString).k().observe(this, new b());
  }
  
  private void T2()
  {
    Object localObject = (Toolbar)findViewById(2131364275);
    this.P3 = ((Toolbar)localObject);
    ((Toolbar)localObject).setContentInsetStartWithNavigation(0);
    a1(2131689849);
    setSupportActionBar(this.P3);
    this.P3.setNavigationOnClickListener(new w2(this));
    localObject = (LayoutCameraMenuSettingsBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559108, this.P3, false);
    ((LayoutCameraMenuSettingsBinding)localObject).h(this.p1.u);
    ((ViewDataBinding)localObject).executePendingBindings();
    localObject = ((LayoutCameraMenuSettingsBinding)localObject).c;
    this.p2 = ((ImageView)localObject);
    ((ImageView)localObject).setOnClickListener(new r3(this));
    localObject = (LayoutCameraMenuButtonDayNightModeBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559104, this.P3, false);
    ((LayoutCameraMenuButtonDayNightModeBinding)localObject).m(this.p1.D);
    ((LayoutCameraMenuButtonDayNightModeBinding)localObject).h(this.p1.m);
    ((LayoutCameraMenuButtonDayNightModeBinding)localObject).l(this.p1.q);
    ((LayoutCameraMenuButtonDayNightModeBinding)localObject).n(new ObservableBoolean(true));
    ((LayoutCameraMenuButtonDayNightModeBinding)localObject).i(this.p1.r);
    localObject = ((ViewDataBinding)localObject).getRoot();
    this.J3 = ((View)localObject);
    localObject = (TextView)((View)localObject).findViewById(2131364183);
    this.K3 = ((TextView)localObject);
    ((TextView)localObject).setText(2131954407);
    localObject = this.K3;
    boolean bool = this.Q3.N3.get();
    int i = 8;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject).setVisibility(j);
    localObject = (ImageView)this.J3.findViewById(2131362811);
    this.L3 = ((ImageView)localObject);
    if (this.Q3.N3.get()) {
      j = i;
    } else {
      j = 0;
    }
    ((ImageView)localObject).setVisibility(j);
    if (!this.Q3.N3.get())
    {
      localObject = this.L3;
      if (this.Q3.P3.get()) {
        j = 2131231349;
      } else {
        j = 2131231351;
      }
      ((ImageView)localObject).setImageResource(j);
    }
    localObject = new c();
    this.Q3.N3.addOnPropertyChangedCallback((Observable.OnPropertyChangedCallback)localObject);
    this.Q3.P3.addOnPropertyChangedCallback((Observable.OnPropertyChangedCallback)localObject);
    this.Q3.O3.addOnPropertyChangedCallback((Observable.OnPropertyChangedCallback)localObject);
    localObject = new s3(this);
    this.L3.setOnClickListener((View.OnClickListener)localObject);
    this.K3.setOnClickListener((View.OnClickListener)localObject);
    localObject = (LayoutCameraMenuButtonBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559103, this.P3, false);
    ((LayoutCameraMenuButtonBinding)localObject).l(this.p1.D);
    ((LayoutCameraMenuButtonBinding)localObject).i(this.p1.q);
    ((LayoutCameraMenuButtonBinding)localObject).m(this.p1.N);
    ((LayoutCameraMenuButtonBinding)localObject).h(this.p1.r);
    localObject = ((ViewDataBinding)localObject).getRoot();
    this.p3 = ((View)localObject);
    localObject = (TextView)((View)localObject).findViewById(2131364183);
    this.H3 = ((TextView)localObject);
    if (this.Q3.X3.get()) {
      j = 2131954409;
    } else {
      j = 2131954410;
    }
    ((TextView)localObject).setText(j);
    this.Q3.X3.addOnPropertyChangedCallback(new d());
    this.H3.setOnClickListener(new t3(this));
    localObject = (LayoutCameraMenuButtonWhiteLampBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559105, this.P3, false);
    ((LayoutCameraMenuButtonWhiteLampBinding)localObject).m(this.p1.D);
    ((LayoutCameraMenuButtonWhiteLampBinding)localObject).l(this.p1.q);
    ((LayoutCameraMenuButtonWhiteLampBinding)localObject).n(this.p1.O);
    ((LayoutCameraMenuButtonWhiteLampBinding)localObject).i(this.p1.r);
    ((LayoutCameraMenuButtonWhiteLampBinding)localObject).h(this.p1.m);
    localObject = ((ViewDataBinding)localObject).getRoot();
    this.N3 = ((View)localObject);
    localObject = (ImageView)((View)localObject).findViewById(2131364183);
    this.O3 = ((ImageView)localObject);
    if (this.Q3.U3.get()) {
      j = 2131690451;
    } else {
      j = 2131690450;
    }
    ((ImageView)localObject).setImageResource(j);
    localObject = new e();
    this.Q3.U3.addOnPropertyChangedCallback((Observable.OnPropertyChangedCallback)localObject);
    this.O3.setOnClickListener(new n3(this));
    float f1 = getResources().getDrawable(2131689849).getIntrinsicWidth();
    float f2 = getResources().getDrawable(2131231513).getIntrinsicWidth();
    float f3 = com.tplink.libtpnetwork.cameranetwork.util.e.b(this)[0];
    float f4 = b.d.w.f.a.a(this, 160.0F);
    Paint localPaint = new Paint();
    float f5 = this.H3.getTextSize();
    localPaint.setTextSize(f5);
    localObject = this.K3.getText().toString();
    String str = this.H3.getText().toString();
    float f6 = localPaint.measureText(str);
    for (float f7 = localPaint.measureText((String)localObject); f3 - f1 - f2 - f4 < f6 + f7; f7 = localPaint.measureText((String)localObject))
    {
      f5 -= 1.0F;
      localPaint.setTextSize(f5);
      f6 = localPaint.measureText(str);
    }
    this.H3.setTextSize(0, f5);
    this.K3.setTextSize(0, f5);
    this.p1.D.addOnPropertyChangedCallback(new f());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void U2()
  {
    if (this.I3 == null)
    {
      this.I3 = new PopupWindow();
      localObject = (LayoutCameraMenuDefinitionBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559106, this.P3, false);
      ((LayoutCameraMenuDefinitionBinding)localObject).h(this.Q3.X3);
      localObject = ((ViewDataBinding)localObject).getRoot();
      this.I3.setContentView((View)localObject);
      d3 locald3 = new d3(this);
      ((View)localObject).findViewById(2131362383).setOnClickListener(locald3);
      ((View)localObject).findViewById(2131362384).setOnClickListener(locald3);
      localObject = new Paint();
      ((Paint)localObject).setTextSize(Z2(this, 13.0F));
      float f1 = ((Paint)localObject).measureText(getResources().getString(2131954409));
      float f2 = ((Paint)localObject).measureText(getResources().getString(2131954410));
      if (f1 > f2) {
        f2 = f1;
      }
      i = (int)f2;
      this.I3.setHeight((int)(((Paint)localObject).getFontMetrics().descent - ((Paint)localObject).getFontMetrics().ascent) * 2 + C1(this, 60.0F) + 1);
      this.I3.setWidth(i + 1 + C1(this, 35.0F));
      this.I3.setOutsideTouchable(true);
      this.I3.setTouchInterceptor(new u3(this));
      this.I3.setOnDismissListener(new k3(this));
    }
    Object localObject = new int[2];
    this.H3.getLocationOnScreen((int[])localObject);
    int j = localObject[0];
    int k = (this.H3.getWidth() - this.I3.getWidth()) / 2;
    int m = this.P3.getHeight();
    int n = C1(this, 1.0F);
    localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.I3.showAtLocation(this.P3, 8388659, j + k, m - n + i);
    this.H3.setTextColor(getResources().getColor(2131099706));
    this.a4 = true;
  }
  
  private void V2(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((("VideoPlay.TalkFragment".equals(paramString)) || ("VideoPlay.VoiceCallFragment".equals(paramString))) && (!x1()))
    {
      this.z.pop();
      this.R3.Q(paramString);
      R2();
      return;
    }
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1637381171: 
      if (paramString.equals("VideoPlay.PlayBackControlFragment")) {
        i = 4;
      }
      break;
    case 723559217: 
      if (paramString.equals("VideoPlay.CloudTerraceControlFragment")) {
        i = 3;
      }
      break;
    case -662580069: 
      if (paramString.equals("VideoPlay.TalkFragment")) {
        i = 2;
      }
      break;
    case -989769983: 
      if (paramString.equals("VideoPlay.VoiceCallFragment")) {
        i = 1;
      }
      break;
    case -1425288173: 
      if (paramString.equals("VideoPlay.VideoControlPanelFragment")) {
        i = 0;
      }
      break;
    }
    Object localObject;
    switch (i)
    {
    default: 
      localObject = J1();
      break;
    case 4: 
      localObject = H1();
      break;
    case 3: 
      localObject = F1();
    }
    for (;;)
    {
      break;
      localObject = I1();
      continue;
      localObject = K1();
      continue;
      localObject = J1();
    }
    Q2((Fragment)localObject, paramString, paramBundle, paramInt, 2131362333);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void W2()
  {
    if (this.M3 == null)
    {
      this.M3 = new PopupWindow();
      localObject = (LayoutCameraMenuInfraredBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559107, this.P3, false);
      ((LayoutCameraMenuInfraredBinding)localObject).h(this.Q3.N3);
      ((LayoutCameraMenuInfraredBinding)localObject).i(this.Q3.P3);
      ((LayoutCameraMenuInfraredBinding)localObject).l(this.Q3.O3);
      localObject = ((ViewDataBinding)localObject).getRoot();
      this.M3.setContentView((View)localObject);
      y2 localy2 = new y2(this);
      ((View)localObject).findViewById(2131362858).setOnClickListener(localy2);
      ((View)localObject).findViewById(2131362859).setOnClickListener(localy2);
      ((View)localObject).findViewById(2131362860).setOnClickListener(localy2);
      localObject = new Paint();
      ((Paint)localObject).setTextSize(Z2(this, 13.0F));
      float f1 = ((Paint)localObject).measureText(getResources().getString(2131954407));
      float f2 = ((Paint)localObject).measureText(getResources().getString(2131954408));
      float f3 = ((Paint)localObject).measureText(getResources().getString(2131954411));
      i = (int)Math.max(f1, f2) + 1;
      j = i;
      if (f3 > i) {
        j = (int)f3 + 1;
      }
      i = Math.max(getResources().getDrawable(2131231351).getIntrinsicHeight(), (int)(((Paint)localObject).getFontMetrics().descent - ((Paint)localObject).getFontMetrics().ascent) + 1);
      this.M3.setHeight(i * 3 + C1(this, 95.0F) + 1);
      i = getResources().getDrawable(2131231351).getIntrinsicWidth();
      this.M3.setWidth(j + i + C1(this, 45.0F));
      this.M3.setOutsideTouchable(true);
      this.M3.setTouchInterceptor(new g3(this));
      this.M3.setOnDismissListener(new o3(this));
    }
    Object localObject = new int[2];
    this.K3.getLocationOnScreen((int[])localObject);
    int k = localObject[0];
    int m = (this.K3.getWidth() - this.M3.getWidth()) / 2;
    int n = this.P3.getHeight();
    int i = C1(this, 1.0F);
    localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    this.M3.showAtLocation(this.P3, 8388659, k + m, n - i + j);
    if (this.Q3.N3.get())
    {
      this.K3.setTextColor(getResources().getColor(2131099706));
    }
    else
    {
      localObject = this.L3;
      if (this.Q3.O3.get()) {
        j = 2131231352;
      } else {
        j = 2131231350;
      }
      ((ImageView)localObject).setImageResource(j);
    }
    this.b4 = true;
  }
  
  private void X2()
  {
    CameraFirstShowFunctionGuideDialog localCameraFirstShowFunctionGuideDialog = CameraFirstShowFunctionGuideDialog.X0(this.p1.k(), this.p1.j, new a());
    this.Z3 = localCameraFirstShowFunctionGuideDialog;
    localCameraFirstShowFunctionGuideDialog.show(getSupportFragmentManager(), CameraFirstShowFunctionGuideDialog.c);
  }
  
  private void Y2(String paramString)
  {
    new TPMaterialDialogV2.Builder(this).r(2131953736).i(2131953734, 2131099799).o(2131954500, 2131099808, new h3(this)).l(2131951761, 2131099804, null).b(false).c(false).g(8, 8).y();
  }
  
  private int Z2(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
  
  private void a3()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = this.W3;
    if (localScreenOrientationListenHelper != null) {
      localScreenOrientationListenHelper.g();
    }
  }
  
  private void b3()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = this.W3;
    if (localScreenOrientationListenHelper != null) {
      localScreenOrientationListenHelper.h();
    }
  }
  
  private void c3()
  {
    this.p1.m().observe(this, new e3(this));
    this.p1.l().observe(this, new a3(this));
    this.p1.o().observe(this, new p3(this));
    this.p1.k.observe(this, new c3(this));
    this.p1.f.observe(this, new x2(this));
    this.R3.o.observe(this, new l3(this));
  }
  
  private void d3()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject;
    if (this.p1.G.get())
    {
      getWindow().getDecorView().setSystemUiVisibility(4102);
      getWindow().setFlags(1024, 1024);
      localLayoutParams = (RelativeLayout.LayoutParams)this.p0.H3.getLayoutParams();
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      this.P3.setVisibility(8);
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).hide();
      }
    }
    else
    {
      getWindow().getDecorView().setSystemUiVisibility(0);
      localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags &= 0xFBFF;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getWindow().clearFlags(512);
      localLayoutParams = (RelativeLayout.LayoutParams)this.p0.H3.getLayoutParams();
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      localLayoutParams.width = ((DisplayMetrics)localObject).widthPixels;
      localLayoutParams.height = (h.p(this) + o.a(this, 40.0F));
      this.P3.setVisibility(0);
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).show();
      }
    }
  }
  
  private void u1()
  {
    CloudStorageFragment localCloudStorageFragment = new CloudStorageFragment();
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (!localCloudStorageFragment.isAdded()) {
      localFragmentTransaction.add(2131362658, localCloudStorageFragment, CloudStorageFragment.class.getName());
    }
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void v1()
  {
    if (this.y == null) {
      this.y = new MultiLiveAdvancedFragment();
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (!this.y.isAdded())
    {
      MultiLiveAdvancedFragment localMultiLiveAdvancedFragment = this.y;
      localFragmentTransaction.replace(2131364767, localMultiLiveAdvancedFragment, localMultiLiveAdvancedFragment.getClass().getName());
    }
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void w1(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1)
    {
      paramString = (ALCameraDevice)TPIoTClientManager.K1(paramString).getCameraDevice();
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.isCameraLocked()) {
          bool1 = true;
        }
      }
      this.p2.setEnabled(bool1 ^ true);
      this.p1.r.set(bool1);
    }
    else
    {
      this.p1.r.set(false);
    }
  }
  
  private boolean x1()
  {
    return EasyPermissions.a(this, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void A1()
  {
    setRequestedOrientation(1);
  }
  
  public void D1()
  {
    setRequestedOrientation(0);
  }
  
  public void E0(int paramInt, List<String> paramList)
  {
    if (paramInt == 0)
    {
      paramList = this.R3.o();
      if (paramList != null) {
        this.p1.y(paramList);
      }
    }
  }
  
  public void E1(int paramInt)
  {
    super.finish();
    if (paramInt != 3)
    {
      int[] arrayOfInt = G1(paramInt);
      overridePendingTransition(arrayOfInt[0], arrayOfInt[1]);
    }
  }
  
  protected void Q2(Fragment paramFragment, String paramString, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      if ((!paramFragment.isAdded()) && (!paramFragment.isVisible()) && (paramFragment.getArguments() == null))
      {
        paramFragment.setArguments(paramBundle);
      }
      else
      {
        Bundle localBundle = paramFragment.getArguments();
        if (localBundle != null)
        {
          Iterator localIterator = paramBundle.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((paramBundle.get(str) instanceof String)) {
              localBundle.putString(str, paramBundle.getString(str));
            } else if ((paramBundle.get(str) instanceof Boolean)) {
              localBundle.putBoolean(str, paramBundle.getBoolean(str));
            } else if ((paramBundle.get(str) instanceof Long)) {
              localBundle.putLong(str, paramBundle.getLong(str));
            } else if ((paramBundle.get(str) instanceof Serializable)) {
              localBundle.putSerializable(str, paramBundle.getSerializable(str));
            } else if ((paramBundle.get(str) instanceof Parcelable)) {
              localBundle.putParcelable(str, paramBundle.getParcelable(str));
            }
          }
        }
      }
    }
    if ("VideoPlay.VideoControlPanelFragment".equals(paramString))
    {
      localFragmentTransaction.setCustomAnimations(2130772029, 2130772030);
    }
    else
    {
      paramBundle = l.a(paramInt1);
      if ((paramBundle[0] != 0) && (paramBundle[1] != 0)) {
        localFragmentTransaction.setCustomAnimations(paramBundle[0], paramBundle[1]);
      }
    }
    localFragmentTransaction.replace(paramInt2, paramFragment, paramString).commitAllowingStateLoss();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        this.Q3.B();
        LiveMediaAPI.enableRelayTimer();
      }
    }
    else
    {
      LiveMediaAPI.disableRelayTimer();
      this.Q3.A();
    }
    return bool;
  }
  
  public void e0(String paramString, Bundle paramBundle)
  {
    com.tplink.iot.view.ipcamera.base.f localf = new com.tplink.iot.view.ipcamera.base.f();
    localf.d(paramString);
    localf.c(paramBundle);
    if ((this.z.size() > 0) && (TextUtils.equals(paramString, ((com.tplink.iot.view.ipcamera.base.f)this.z.peek()).b()))) {
      return;
    }
    int i = 0;
    Iterator localIterator = this.z.iterator();
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((com.tplink.iot.view.ipcamera.base.f)localIterator.next()).b().equalsIgnoreCase(paramString));
    int j = 1;
    while ((j != 0) && (!((com.tplink.iot.view.ipcamera.base.f)this.z.pop()).b().equalsIgnoreCase(paramString)) && (this.z.size() > 0)) {}
    this.z.push(localf);
    V2(paramString, paramBundle, 1);
  }
  
  public void finish()
  {
    E1(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (!this.X3))
    {
      if (EasyPermissions.a(this, new String[] { "android.permission.RECORD_AUDIO" }))
      {
        paramIntent = this.R3.o();
        if (paramIntent != null) {
          this.p1.y(paramIntent);
        }
      }
      else
      {
        this.R3.k.set(false);
        this.R3.m.set(false);
      }
    }
    else if (paramInt1 == 1345)
    {
      CloudStorageFragment localCloudStorageFragment = (CloudStorageFragment)getSupportFragmentManager().findFragmentByTag(CloudStorageFragment.class.getName());
      if (localCloudStorageFragment != null) {
        localCloudStorageFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.p1.G.get()) {
      A1();
    } else {
      B1();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363380)
    {
      paramView = this.p1.j;
      if (paramView != null)
      {
        paramView = (ALCameraDevice)TPIoTClientManager.K1(paramView).getCameraDevice();
        if (paramView != null) {
          com.tplink.iot.viewmodel.home.u.f(this, paramView.getLockMessage());
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayViewModel localVideoPlayViewModel = this.p1;
    int i = paramConfiguration.orientation;
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    localVideoPlayViewModel.z(bool);
    d3();
    this.p1.g();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    L1();
    O1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623957, paramMenu);
    this.p2.setPaddingRelative(0, 0, C1(this, 16.0F), 0);
    this.P3.getMenu().findItem(2131361913).setActionView(this.p2);
    this.P3.getMenu().findItem(2131361901).setActionView(this.N3);
    this.P3.getMenu().findItem(2131361900).setActionView(this.J3);
    this.P3.getMenu().findItem(2131361890).setActionView(this.p3);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.V3;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    y1();
    z1();
    this.U3.d();
    localObject = this.W3;
    if (localObject != null) {
      ((ScreenOrientationListenHelper)localObject).d();
    }
    localObject = this.p1.j;
    if (localObject != null)
    {
      LiveMediaAPI.stopRecord((String)localObject);
      l9.a().b(this.p1.j).d();
    }
    LiveMediaAPI.destroyAllDisplay();
    o.d("");
    localObject = this.d4;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    b3();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ImageView localImageView = this.p2;
    float f;
    if (P1(this.p1.j)) {
      f = 1.0F;
    } else {
      f = 0.4F;
    }
    localImageView.setAlpha(f);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    EasyPermissions.d(paramInt, paramArrayOfString, paramArrayOfInt, new Object[] { this });
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.S3.A();
  }
  
  protected void onResume()
  {
    super.onResume();
    a3();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.p1.g();
    this.p1.w();
    this.R3.L();
    LiveMediaAPI.setPlayInPreviewPage(false);
    LiveMediaAPI.bindCallingVariable(this.R3.k);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.U3.dispose();
    LiveMediaAPI.disableRelayTimer();
    if (LiveMediaAPI.getCallingObservable() == this.R3.k) {
      LiveMediaAPI.bindCallingVariable(null);
    }
  }
  
  public void t(int paramInt, List<String> paramList)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = -1;
    }
    new AppSettingsDialog.b(this).d(2131953354).c(2131951767).b(2131951763).e(paramInt).a().d();
  }
  
  public void y1()
  {
    PopupWindow localPopupWindow = this.I3;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.I3.dismiss();
    }
  }
  
  public void z1()
  {
    PopupWindow localPopupWindow = this.M3;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.M3.dismiss();
    }
  }
  
  class a
    implements CameraFirstShowFunctionGuideDialog.d
  {
    a() {}
    
    public void onFinish()
    {
      VideoPlayActivity.this.setRequestedOrientation(2);
      VideoPlayActivity.e1(VideoPlayActivity.this);
      VideoPlayActivity.f1(VideoPlayActivity.this);
      VideoPlayActivity.this.e0("VideoPlay.VideoControlPanelFragment", null);
      VideoPlayActivity.m1(VideoPlayActivity.this);
      VideoPlayActivity.n1(VideoPlayActivity.this);
      VideoPlayActivity.o1(VideoPlayActivity.this);
      VideoPlayActivity.p1(VideoPlayActivity.this);
      if (h.C(VideoPlayActivity.q1(VideoPlayActivity.this).j)) {
        h.E(VideoPlayActivity.this.Z3.getActivity(), VideoPlayActivity.q1(VideoPlayActivity.this).j);
      }
    }
  }
  
  class b
    implements Observer<String>
  {
    b() {}
    
    public void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        VideoPlayActivity.r1(VideoPlayActivity.this).p1.setVisibility(8);
      }
      else
      {
        VideoPlayActivity.r1(VideoPlayActivity.this).p1.setVisibility(0);
        VideoPlayActivity.r1(VideoPlayActivity.this).p1.setText(paramString);
      }
    }
  }
  
  class c
    extends Observable.OnPropertyChangedCallback
  {
    c() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      paramObservable = VideoPlayActivity.t1(VideoPlayActivity.this);
      boolean bool = VideoPlayActivity.s1(VideoPlayActivity.this).N3.get();
      int i = 0;
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      paramObservable.setVisibility(paramInt);
      paramObservable = VideoPlayActivity.g1(VideoPlayActivity.this);
      paramInt = i;
      if (VideoPlayActivity.s1(VideoPlayActivity.this).N3.get()) {
        paramInt = 8;
      }
      paramObservable.setVisibility(paramInt);
      if (!VideoPlayActivity.s1(VideoPlayActivity.this).N3.get())
      {
        paramObservable = VideoPlayActivity.g1(VideoPlayActivity.this);
        if (VideoPlayActivity.s1(VideoPlayActivity.this).P3.get())
        {
          if (VideoPlayActivity.h1(VideoPlayActivity.this)) {
            paramInt = 2131231350;
          } else {
            paramInt = 2131231349;
          }
        }
        else if (VideoPlayActivity.h1(VideoPlayActivity.this)) {
          paramInt = 2131231352;
        } else {
          paramInt = 2131231351;
        }
        paramObservable.setImageResource(paramInt);
      }
    }
  }
  
  class d
    extends Observable.OnPropertyChangedCallback
  {
    d() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      paramObservable = VideoPlayActivity.i1(VideoPlayActivity.this);
      if (VideoPlayActivity.s1(VideoPlayActivity.this).X3.get()) {
        paramInt = 2131954409;
      } else {
        paramInt = 2131954410;
      }
      paramObservable.setText(paramInt);
    }
  }
  
  class e
    extends Observable.OnPropertyChangedCallback
  {
    e() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      paramObservable = VideoPlayActivity.j1(VideoPlayActivity.this);
      if (VideoPlayActivity.s1(VideoPlayActivity.this).U3.get()) {
        paramInt = 2131690451;
      } else {
        paramInt = 2131690450;
      }
      paramObservable.setImageResource(paramInt);
    }
  }
  
  class f
    extends Observable.OnPropertyChangedCallback
  {
    f() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      if (!VideoPlayActivity.q1(VideoPlayActivity.this).D.get())
      {
        VideoPlayActivity.this.y1();
        VideoPlayActivity.this.z1();
      }
    }
  }
  
  class g
    implements g<b.a.a.a.a.a.a>
  {
    g() {}
    
    public void a(b.a.a.a.a.a.a parama)
      throws Exception
    {
      if (parama == null) {
        return;
      }
      if ((VideoPlayActivity.k1(VideoPlayActivity.this) != null) && ((VideoPlayActivity.k1(VideoPlayActivity.this).i() != 0) || (parama.i() != 0)))
      {
        if ((VideoPlayActivity.k1(VideoPlayActivity.this).i() == 1) && (parama.i() == 0))
        {
          VideoPlayActivity.l1(VideoPlayActivity.this, parama);
          if (VideoPlayActivity.q1(VideoPlayActivity.this) != null) {
            VideoPlayActivity.q1(VideoPlayActivity.this).x();
          }
          LiveMediaAPI.resetPipeErrorStatus();
        }
        else
        {
          VideoPlayActivity.l1(VideoPlayActivity.this, parama);
          if (VideoPlayActivity.q1(VideoPlayActivity.this) != null) {
            VideoPlayActivity.q1(VideoPlayActivity.this).v();
          }
          LiveMediaAPI.resetPipeErrorStatus();
        }
      }
      else {
        VideoPlayActivity.l1(VideoPlayActivity.this, parama);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\VideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */