package com.tplink.iot.musicphonerhythm.activitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.k.c.b.p;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmCardListViewAdapter;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmCardListViewAdapter.ViewHolder;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmCryptoResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmLightFlowModeParams;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeConfigParams;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmPowerModeParams;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmSupportModeResult;
import com.tplink.iot.musicphonerhythm.enumerate.Sensitivity;
import com.tplink.iot.musicphonerhythm.enumerate.SpeedGap;
import com.tplink.iot.musicphonerhythm.viewmodel.MusciRhythmViewModel;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeColorSettingDialog;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeColorSettingDialog.b;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeFlowingBeamSettingDialog;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeFlowingBeamSettingDialog.b;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeLightStrengthSettingDialog;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeLightStrengthSettingDialog.a;
import com.tplink.iot.musicphonerhythm.views.MusicRhymePowerModeSettingDialog;
import com.tplink.iot.musicphonerhythm.views.MusicRhymePowerModeSettingDialog.c;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.AppSettingsDialog.b;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

public class MusicPhoneRhythmFragment
  extends BaseFragment
  implements EasyPermissions.PermissionCallbacks, com.tplink.iot.k.c.d, MusicRhymeColorSettingDialog.b, MusicRhymeLightStrengthSettingDialog.a, MusicRhymePowerModeSettingDialog.c, MusicRhymeFlowingBeamSettingDialog.b
{
  private ImageView H3;
  private ImageView I3;
  private ImageView J3;
  private ImageView K3;
  private TextView L3;
  private LinearLayout M3;
  private Context N3;
  private MusicPhoneRhythmActivity O3;
  private boolean P3 = true;
  private volatile boolean Q3 = false;
  private int R3 = 0;
  private int S3 = 2;
  private int T3 = 2;
  private Sensitivity U3 = Sensitivity.NORMAL_SENSITIVE;
  private SpeedGap V3 = SpeedGap.NORMAL_SPEED;
  private MusicRhythmGlobalConfigBean W3 = com.tplink.iot.k.c.b.b();
  private MusicRhythmSupportModeResult X3;
  private MusicRhythmModeResult Y3;
  private MusicRhythmModeConfigParams Z3;
  private MusicRhythmPowerModeParams a4;
  private MusicRhythmLightFlowModeParams b4;
  private h c4;
  int d4 = 0;
  ArrayList<String> e4 = new ArrayList();
  RecyclerView f4;
  MusicRhythmCardListViewAdapter g4;
  private ExecutorService h4;
  private IoTLightStripDevice i4 = new IoTLightStripDevice();
  private NetWorkStateReceiver j4;
  private String k4 = null;
  private b.a.a.a.a.a.a l4;
  private MusciRhythmViewModel p0;
  private boolean p1 = false;
  private View p2;
  private ImageView p3;
  private final String q = MusicPhoneRhythmFragment.class.getName();
  private String x;
  private String y;
  private com.tplink.iot.k.a.a z;
  
  private boolean Y0()
  {
    return EasyPermissions.a(this.N3, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  private String Z0(int paramInt)
  {
    return (String)this.e4.get(paramInt);
  }
  
  private String a1(int paramInt)
  {
    String str = (String)this.e4.get(paramInt);
    str.hashCode();
    int i = str.hashCode();
    paramInt = -1;
    switch (i)
    {
    default: 
      break;
    case 440747165: 
      if (str.equals("power_mode")) {
        paramInt = 2;
      }
      break;
    case -208977225: 
      if (str.equals("light_flow")) {
        paramInt = 1;
      }
      break;
    case -1731972241: 
      if (str.equals("single_lamp")) {
        paramInt = 0;
      }
      break;
    }
    switch (paramInt)
    {
    default: 
      return getResources().getString(2131952834);
    case 2: 
      return getString(2131953189);
    case 1: 
      return getString(2131953178);
    }
    return getString(2131953170);
  }
  
  private void b1()
  {
    this.p2.findViewById(2131363510).setOnClickListener(new com.tplink.iot.k.c.c(this));
    ImageView localImageView = (ImageView)this.p2.findViewById(2131363512);
    this.p3 = localImageView;
    localImageView.setOnClickListener(new com.tplink.iot.k.c.c(this));
    this.p2.findViewById(2131364046).setOnClickListener(new com.tplink.iot.k.c.c(this));
    localImageView = (ImageView)this.p2.findViewById(2131363648);
    this.H3 = localImageView;
    localImageView.setOnClickListener(new com.tplink.iot.k.c.c(this));
    localImageView = (ImageView)this.p2.findViewById(2131363516);
    this.I3 = localImageView;
    localImageView.setOnClickListener(new com.tplink.iot.k.c.c(this));
    localImageView = (ImageView)this.p2.findViewById(2131363520);
    this.J3 = localImageView;
    localImageView.setOnClickListener(new com.tplink.iot.k.c.c(this));
    localImageView = (ImageView)this.p2.findViewById(2131363467);
    this.K3 = localImageView;
    localImageView.setOnClickListener(new com.tplink.iot.k.c.c(this));
    this.L3 = ((TextView)this.p2.findViewById(2131364531));
    this.M3 = ((LinearLayout)this.p2.findViewById(2131364013));
  }
  
  @SuppressLint({"CheckResult"})
  private void c1()
  {
    if (getActivity() == null) {
      return;
    }
    b.a.a.a.a.a.d.a(AppContext.c).L0(io.reactivex.l0.a.c()).L(b.a.a.a.a.a.b.b(new NetworkInfo.State[] { NetworkInfo.State.CONNECTED })).L(b.a.a.a.a.a.b.c(new int[] { 0, 1 })).l0(io.reactivex.d0.b.a.a()).G0(new g());
  }
  
  private void d1()
  {
    this.p0.x().observe(this, new c(this));
    this.p0.r().observe(this, new b(this));
    this.p0.v().observe(this, new e(this));
    this.p0.w().observe(this, new a(this));
    this.p0.u().observe(this, new d(this));
    this.p0.n().observe(this, new a());
  }
  
  private void e1()
  {
    this.g4 = new MusicRhythmCardListViewAdapter(this.N3, com.tplink.iot.k.c.b.a());
    this.f4 = ((RecyclerView)this.p2.findViewById(2131363519));
    Object localObject = new PagerSnapHelper();
    this.f4.setOnFlingListener(null);
    ((SnapHelper)localObject).attachToRecyclerView(this.f4);
    this.f4.setAdapter(this.g4);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.f4.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.L3.setText(getString(2131953170));
  }
  
  private void f1(ArrayList<String> paramArrayList)
  {
    for (int i = 0; i < paramArrayList.size(); i++) {
      if (com.tplink.iot.k.c.b.a().contains(paramArrayList.get(i)))
      {
        this.e4.add(paramArrayList.get(i));
        ImageView localImageView = new ImageView(this.N3);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (i == 0) {
          localLayoutParams.setMargins(0, 0, 8, 0);
        } else {
          localLayoutParams.setMargins(8, 0, 8, 0);
        }
        this.M3.addView(localImageView, localLayoutParams);
      }
    }
    this.g4.o(this.e4);
    this.p0.t();
    this.p0.s();
    this.f4.clearOnScrollListeners();
    this.f4.addOnScrollListener(new b());
  }
  
  private void q1()
  {
    EasyPermissions.h(this, getString(2131953352), 0, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  @SuppressLint({"CheckResult"})
  private void s1()
  {
    s0.m(getActivity(), getString(2131952466));
    this.p0.E();
  }
  
  private void t1(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.f4;
    if ((localObject != null) && (((RecyclerView)localObject).getLayoutManager() != null))
    {
      localObject = this.f4.getLayoutManager().findViewByPosition(paramInt);
      if ((localObject != null) && (this.f4.getChildViewHolder((View)localObject) != null)) {
        if (paramBoolean) {
          ((MusicRhythmCardListViewAdapter.ViewHolder)this.f4.getChildViewHolder((View)localObject)).a.o();
        } else {
          ((MusicRhythmCardListViewAdapter.ViewHolder)this.f4.getChildViewHolder((View)localObject)).a.n();
        }
      }
    }
  }
  
  private void u1()
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2131689899);
      u0.a(this.N3, 300L);
    }
    if (TextUtils.isEmpty(this.i4.getIp())) {
      localObject = this.y;
    } else {
      localObject = this.i4.getIp();
    }
    com.tplink.iot.k.a.a locala = this.z;
    if (locala != null) {
      locala.i();
    }
    this.z = new com.tplink.iot.k.a.a(this.p0.p().getKey(), this.p0.p().getIv(), (String)localObject, this.p0.p().getPort(), this, this.W3, this.i4.getComponentVersion(EnumIoTComponent.MUSIC_RHYTHM), 10);
    this.Q3 = true;
    this.h4.execute(this.z);
    t1(this.d4, true);
  }
  
  @SuppressLint({"CheckResult"})
  private void v1(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.p3;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2131689910);
    }
    if (paramBoolean1) {
      u0.a(this.N3, 300L);
    } else {
      this.h4.shutdownNow();
    }
    localObject = this.z;
    if (localObject != null) {
      ((com.tplink.iot.k.a.a)localObject).i();
    }
    this.Q3 = false;
    t1(this.d4, false);
    if (paramBoolean2)
    {
      s0.m(getActivity(), getString(2131952466));
      this.p0.G().H0(new d(), new e());
    }
    else
    {
      this.p0.G().F0();
    }
  }
  
  public void E0(int paramInt, List<String> paramList)
  {
    if (paramInt == 0) {
      s1();
    }
  }
  
  public void M(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt1);
    b.d.w.c.a.c("onSavePowerMode=", ((StringBuilder)localObject).toString());
    this.S3 = paramInt2;
    this.U3 = com.tplink.iot.k.c.b.f(paramInt2);
    localObject = this.c4;
    if (localObject != null) {
      ((h)localObject).b(paramInt2);
    }
    this.a4.setStartPoint(paramInt1);
    this.a4.setSensitivity(this.U3.getValue()[0]);
    this.Z3.setMode("power_mode");
    this.Z3.setConfig(this.a4);
    this.p0.D(this.Z3);
  }
  
  public void N(int paramInt)
  {
    Object localObject1 = this.q;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("saveColor=");
    ((StringBuilder)localObject2).append(paramInt);
    b.d.w.c.a.c((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramInt == 0)
    {
      this.W3.setSingleColorEnable(false);
      localObject2 = this.c4;
      if (localObject2 != null) {
        ((h)localObject2).a(0);
      }
    }
    else
    {
      this.W3.setSingleColorEnable(true);
      localObject2 = this.c4;
      if (localObject2 != null) {
        ((h)localObject2).a(paramInt);
      }
      localObject2 = new float[3];
      Color.colorToHSV(paramInt, (float[])localObject2);
      int i = (int)localObject2[0];
      int j = (int)(localObject2[1] * 100.0F);
      localObject2 = this.q;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sampleColor color=");
      ((StringBuilder)localObject1).append(paramInt);
      b.d.w.c.a.c((String)localObject2, ((StringBuilder)localObject1).toString());
      localObject1 = this.q;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("hue=");
      ((StringBuilder)localObject2).append(i);
      b.d.w.c.a.c((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = this.q;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sat=");
      ((StringBuilder)localObject1).append(j);
      b.d.w.c.a.c((String)localObject2, ((StringBuilder)localObject1).toString());
      this.W3.setHue(i);
      this.W3.setSaturation(j);
    }
    this.p0.B(this.W3);
  }
  
  public void U(int paramInt)
  {
    this.T3 = paramInt;
    this.V3 = com.tplink.iot.k.c.b.g(paramInt);
    this.b4.setStartPoint(1);
    this.b4.setInterval(this.V3.getValue()[0]);
    this.b4.setOffTime(this.V3.getValue()[1]);
    this.Z3.setMode("light_flow");
    this.Z3.setConfig(this.b4);
    this.p0.D(this.Z3);
  }
  
  public boolean d()
  {
    if (this.Q3) {
      com.tplink.iot.k.c.b.i(this.O3, new c());
    } else {
      this.O3.finish();
    }
    return true;
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.O3 = ((MusicPhoneRhythmActivity)paramContext);
    this.N3 = paramContext;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364046: 
      paramView = MusicRhymeColorSettingDialog.L0(this.W3);
      paramView.show(getChildFragmentManager(), MusicRhymeColorSettingDialog.c);
      paramView.N0(this);
      break;
    case 2131363648: 
      paramView = MusicRhymeLightStrengthSettingDialog.G0(this.W3.getBaseBrightness());
      paramView.show(getChildFragmentManager(), MusicRhymeLightStrengthSettingDialog.c);
      paramView.H0(this);
      break;
    case 2131363512: 
      if (this.Q3)
      {
        v1(true, false);
      }
      else
      {
        paramView = this.i4;
        if ((paramView != null) && (paramView.getComponentVersion(EnumIoTComponent.MUSIC_RHYTHM) == 1))
        {
          if (!Y0()) {
            q1();
          } else {
            s1();
          }
        }
        else
        {
          paramView = this.i4;
          if ((paramView != null) && (paramView.getComponentVersion(EnumIoTComponent.MUSIC_RHYTHM) == 2)) {
            if (this.i4.isMusicRhythmEnable().booleanValue()) {
              com.tplink.iot.k.c.b.m(getActivity());
            } else if (!Y0()) {
              q1();
            } else {
              s1();
            }
          }
        }
      }
      break;
    case 2131363510: 
      if (this.Q3) {
        com.tplink.iot.k.c.b.i(this.O3, new f());
      } else {
        this.O3.finish();
      }
      break;
    case 2131363467: 
      if (this.P3)
      {
        paramView = MusicRhymeFlowingBeamSettingDialog.H0(this.T3);
        paramView.show(getChildFragmentManager(), MusicRhymeFlowingBeamSettingDialog.c);
        paramView.I0(this);
      }
      else
      {
        paramView = MusicRhymePowerModeSettingDialog.I0(this.R3, this.S3);
        paramView.show(getChildFragmentManager(), MusicRhymePowerModeSettingDialog.c);
        paramView.J0(this);
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.p2 = paramLayoutInflater.inflate(2131559094, paramViewGroup, false);
    com.tplink.iot.view.quicksetup.base.d.J(getActivity(), this.p2.findViewById(2131363522));
    return this.p2;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.p1 = false;
  }
  
  public void onPause()
  {
    super.onPause();
    this.O3.unregisterReceiver(this.j4);
    this.p0.H();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    EasyPermissions.d(paramInt, paramArrayOfString, paramArrayOfInt, new Object[] { this });
  }
  
  public void onResume()
  {
    super.onResume();
    if (o.h0().N())
    {
      com.tplink.iot.k.c.b.j(getChildFragmentManager());
      o.h0().T0(false);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("idMd5= ");
    ((StringBuilder)localObject).append(this.x);
    b.d.w.c.a.c("onResume=", ((StringBuilder)localObject).toString());
    if (this.j4 == null) {
      this.j4 = new NetWorkStateReceiver();
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((IntentFilter)localObject).addAction("android.net.wifi.STATE_CHANGE");
    this.O3.registerReceiver(this.j4, (IntentFilter)localObject);
    this.p0.F();
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.p1)
    {
      s0.m(getActivity(), getString(2131952466));
      this.p0.y();
      this.p0.o();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b1();
    paramView = getArguments();
    if (paramView != null)
    {
      this.x = paramView.getString("device_id_md5");
      paramView = paramView.getString("USER_DEVICE_IP");
      this.y = paramView;
      b.d.w.c.a.c("MusicUserIp=", paramView);
      if (this.x == null)
      {
        this.O3.finish();
        return;
      }
    }
    this.p0 = ((MusciRhythmViewModel)new ViewModelProvider(this, new IoTViewModelFactory(this, this.x)).get(MusciRhythmViewModel.class));
    this.h4 = Executors.newSingleThreadExecutor();
    d1();
    c1();
    e1();
  }
  
  public void r1(h paramh)
  {
    this.c4 = paramh;
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
  
  public void y(int paramInt)
  {
    this.W3.setBaseBrightness(paramInt);
    h localh = this.c4;
    if (localh != null)
    {
      localh.c(paramInt);
      this.c4.b(paramInt / 10);
    }
    this.p0.B(this.W3);
  }
  
  public class NetWorkStateReceiver
    extends BroadcastReceiver
  {
    public NetWorkStateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE"))
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        paramContext = ((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getState();
        b.d.w.c.a.b("NetWorkStateReceiver=", paramContext);
        if (paramContext == NetworkInfo.State.CONNECTED)
        {
          paramContext = com.tplink.iot.view.quicksetup.base.d.p();
          b.d.w.c.a.c("NetWorkStateReceiver connectingToSsid=", paramContext);
          if (MusicPhoneRhythmFragment.L0(MusicPhoneRhythmFragment.this) == null)
          {
            MusicPhoneRhythmFragment.N0(MusicPhoneRhythmFragment.this, paramContext);
          }
          else if (!MusicPhoneRhythmFragment.L0(MusicPhoneRhythmFragment.this).equals(paramContext))
          {
            MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, false);
            com.tplink.iot.k.c.b.l(MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this));
          }
        }
        else if (paramContext == NetworkInfo.State.DISCONNECTED)
        {
          MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, false);
          com.tplink.iot.k.c.b.l(MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this));
        }
      }
    }
  }
  
  class a
    implements Observer<IoTLightStripDevice>
  {
    a() {}
    
    public void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      if (paramIoTLightStripDevice != null)
      {
        MusicPhoneRhythmFragment.H0(MusicPhoneRhythmFragment.this, paramIoTLightStripDevice);
        EnumIoTComponent localEnumIoTComponent = EnumIoTComponent.MUSIC_RHYTHM;
        if ((paramIoTLightStripDevice.getComponentVersion(localEnumIoTComponent) != 1) && (paramIoTLightStripDevice.getComponentVersion(localEnumIoTComponent) == 2) && (paramIoTLightStripDevice.isMusicRhythmEnable() != null) && (!paramIoTLightStripDevice.isMusicRhythmEnable().booleanValue()) && (MusicPhoneRhythmFragment.I0(MusicPhoneRhythmFragment.this)))
        {
          MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, false);
          com.tplink.iot.k.c.b.k(MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this));
        }
      }
    }
  }
  
  class b
    extends RecyclerView.OnScrollListener
  {
    b() {}
    
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramRecyclerView.getChildCount() > 0) {
        try
        {
          paramInt = ((RecyclerView.LayoutParams)paramRecyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
          paramRecyclerView = new java/lang/StringBuilder;
          paramRecyclerView.<init>();
          paramRecyclerView.append("===");
          paramRecyclerView.append(paramInt);
          Log.e("=====currentPosition", paramRecyclerView.toString());
          paramRecyclerView = MusicPhoneRhythmFragment.this;
          if (paramRecyclerView.d4 != paramInt)
          {
            MusicPhoneRhythmFragment.Q0(paramRecyclerView, false, false);
            MusicPhoneRhythmFragment.T0(MusicPhoneRhythmFragment.this).setText(MusicPhoneRhythmFragment.S0(MusicPhoneRhythmFragment.this, paramInt));
            if (MusicPhoneRhythmFragment.U0(MusicPhoneRhythmFragment.this, paramInt).equals(com.tplink.iot.k.c.b.a().get(0)))
            {
              MusicPhoneRhythmFragment.V0(MusicPhoneRhythmFragment.this).setVisibility(8);
            }
            else if (MusicPhoneRhythmFragment.U0(MusicPhoneRhythmFragment.this, paramInt).equals(com.tplink.iot.k.c.b.a().get(1)))
            {
              MusicPhoneRhythmFragment.V0(MusicPhoneRhythmFragment.this).setVisibility(0);
              MusicPhoneRhythmFragment.W0(MusicPhoneRhythmFragment.this, true);
            }
            else if (MusicPhoneRhythmFragment.U0(MusicPhoneRhythmFragment.this, paramInt).equals(com.tplink.iot.k.c.b.a().get(2)))
            {
              MusicPhoneRhythmFragment.V0(MusicPhoneRhythmFragment.this).setVisibility(0);
              MusicPhoneRhythmFragment.W0(MusicPhoneRhythmFragment.this, false);
            }
            paramRecyclerView = MusicPhoneRhythmFragment.this;
            paramRecyclerView.d4 = paramInt;
            MusicPhoneRhythmFragment.X0(paramRecyclerView).setMode((String)MusicPhoneRhythmFragment.this.e4.get(paramInt));
            MusicPhoneRhythmFragment.J0(MusicPhoneRhythmFragment.this).C(MusicPhoneRhythmFragment.X0(MusicPhoneRhythmFragment.this));
          }
        }
        catch (Exception paramRecyclerView)
        {
          b.d.w.c.a.e(MusicPhoneRhythmFragment.K0(MusicPhoneRhythmFragment.this), paramRecyclerView.getLocalizedMessage());
        }
      }
    }
  }
  
  class c
    implements b.p
  {
    c() {}
    
    public void a()
    {
      MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, true);
    }
  }
  
  class d
    implements g<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      s0.g();
      MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this).finish();
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      s0.g();
      MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this).finish();
    }
  }
  
  class f
    implements b.p
  {
    f() {}
    
    public void a()
    {
      MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, true);
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
      b.d.w.c.a.c("ReactiveNetwork=", "connectivity!!!");
      if ((MusicPhoneRhythmFragment.O0(MusicPhoneRhythmFragment.this) != null) && ((MusicPhoneRhythmFragment.O0(MusicPhoneRhythmFragment.this).i() != 0) || (parama.i() != 0)))
      {
        MusicPhoneRhythmFragment.P0(MusicPhoneRhythmFragment.this, parama);
        b.d.w.c.a.c("ReactiveNetwork=", "change!!!");
        MusicPhoneRhythmFragment.Q0(MusicPhoneRhythmFragment.this, false, false);
        com.tplink.iot.k.c.b.l(MusicPhoneRhythmFragment.R0(MusicPhoneRhythmFragment.this));
      }
      else
      {
        MusicPhoneRhythmFragment.P0(MusicPhoneRhythmFragment.this, parama);
      }
    }
  }
  
  public static abstract interface h
  {
    public abstract void a(int paramInt);
    
    public abstract void b(int paramInt);
    
    public abstract void c(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\activitys\MusicPhoneRhythmFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */