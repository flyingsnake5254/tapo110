package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.view.iotplug.update.AutoUpdateActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTFirmwareUpdateViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ProgressBarButton;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.RealTimeBatteryInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;

public class IoTFirmwareUpdateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static String y = "FromSubGSetupExtra";
  private TextView H3;
  private Button I3;
  private TextView J3;
  private TPCircleProgressBar K3;
  private ProgressBarButton L3;
  private TextView M3;
  private TextView N3;
  private View O3;
  private View P3;
  private TextView Q3;
  private View R3;
  private int S3 = 1;
  private IoTFirmwareUpdateViewModel T3;
  private String U3;
  private boolean V3 = false;
  private ViewGroup p0;
  private View p1;
  private TextView p2;
  private ImageView p3;
  private ViewGroup z;
  
  private void A1()
  {
    this.T3.T();
    x1(3);
    this.L3.f(0, String.format(getString(2131952730), new Object[] { "0%" }));
    m.e();
  }
  
  private void B1()
  {
    this.T3.y().observe(this, new a());
    this.T3.E().observe(this, new b());
    this.T3.v().observe(this, new c());
    this.T3.z().observe(this, new d());
    this.T3.o().observe(this, new e());
    this.T3.D().observe(this, new c(this));
    this.T3.B().observe(this, new e(this));
  }
  
  private void C1(FirmwareDownloadState paramFirmwareDownloadState)
  {
    if (paramFirmwareDownloadState != null)
    {
      int i = paramFirmwareDownloadState.getStatus();
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i == 3)
          {
            this.L3.d(2, getString(2131952733));
            i = paramFirmwareDownloadState.getUpgradeTime();
            int j = paramFirmwareDownloadState.getRebootTime();
            x1(5);
            this.c.postDelayed(new g(), (i + j) * 1000);
          }
        }
        else
        {
          ProgressBarButton localProgressBarButton = this.L3;
          i = paramFirmwareDownloadState.getDownloadProgress();
          String str = getString(2131952730);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFirmwareDownloadState.getDownloadProgress());
          localStringBuilder.append("%");
          localProgressBarButton.f(i, String.format(str, new Object[] { localStringBuilder.toString() }));
          this.c.postDelayed(new f(), 1000L);
        }
      }
      else if (this.S3 == 3) {
        x1(4);
      }
    }
  }
  
  private void D1(ThingFirmware paramThingFirmware)
  {
    if (paramThingFirmware != null)
    {
      this.M3.setText(paramThingFirmware.getFwVer());
      this.p2.setText(paramThingFirmware.getReleaseNote());
    }
  }
  
  private void E1(boolean paramBoolean)
  {
    View localView = this.R3;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void k1()
  {
    s0.l(this);
    this.T3.k();
  }
  
  private void l1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
  {
    
    if (parama == null) {
      return;
    }
    parama = (Integer)parama.a();
    if (parama == null) {
      return;
    }
    if (parama.intValue() == 2)
    {
      s0.n(this, 2131952444);
    }
    else if (parama.intValue() == 0)
    {
      parama = this.T3;
      if (parama.j) {
        parama.l();
      } else {
        A1();
      }
    }
    else if (parama.intValue() == 1)
    {
      z1();
    }
  }
  
  private void m1(com.tplink.iot.viewmodel.quicksetup.i<RealTimeBatteryInfoResult> parami)
  {
    b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult");
    if (parami == null) {
      return;
    }
    int i = parami.b();
    if (i == 10)
    {
      b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult detecting");
      s0.l(this);
    }
    else if (i == 20)
    {
      if (parami.a() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleRealTimeBatteryInfoResult finish rtBatteryInfo: ");
        localStringBuilder.append(com.tplink.libtpnetwork.Utils.i.j(parami.a()));
        b.d.w.c.a.n("FirmwareUpdate", localStringBuilder.toString());
        s0.g();
        if (((RealTimeBatteryInfoResult)parami.a()).getAllowUpgrade())
        {
          b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult startDownload");
          A1();
        }
        else
        {
          y1();
        }
      }
      else
      {
        b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult null result");
        s0.n(this, 2131952444);
      }
    }
    else if (i == 30)
    {
      b.d.w.c.a.n("FirmwareUpdate", "handleRealTimeBatteryInfoResult fail");
      s0.n(this, 2131952444);
    }
  }
  
  private void n1()
  {
    b1(2131953610);
    this.z = ((ViewGroup)findViewById(2131363360));
    this.p0 = ((ViewGroup)findViewById(2131363361));
    this.p1 = findViewById(2131363358);
    this.p2 = ((TextView)findViewById(2131364726));
    this.R3 = findViewById(2131363341);
    this.p3 = ((ImageView)findViewById(2131363082));
    this.H3 = ((TextView)findViewById(2131364534));
    Object localObject = (TextView)findViewById(2131364580);
    TextView localTextView = (TextView)findViewById(2131364515);
    this.M3 = ((TextView)findViewById(2131364499));
    this.N3 = ((TextView)findViewById(2131364554));
    TPCircleProgressBar localTPCircleProgressBar = (TPCircleProgressBar)findViewById(2131362244);
    this.K3 = localTPCircleProgressBar;
    localTPCircleProgressBar.setProgressBarColor(ContextCompat.getColor(this, 2131099806));
    this.I3 = ((Button)findViewById(2131362077));
    this.L3 = ((ProgressBarButton)findViewById(2131363713));
    this.J3 = ((TextView)findViewById(2131364652));
    this.I3.setOnClickListener(this);
    ((TextView)localObject).setText(this.T3.t(this));
    boolean bool = TextUtils.isEmpty(this.T3.C(this));
    int i = 0;
    if (!bool)
    {
      findViewById(2131363306).setVisibility(0);
      localTextView.setText(this.T3.C(this));
    }
    else
    {
      findViewById(2131363306).setVisibility(8);
    }
    this.O3 = findViewById(2131363260);
    this.Q3 = ((TextView)findViewById(2131361992));
    this.P3 = findViewById(2131362887);
    findViewById(2131362887).setOnClickListener(this);
    localObject = this.O3;
    if (!this.T3.g.get()) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    E1(this.V3);
  }
  
  public static void s1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, IoTFirmwareUpdateActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void t1(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, IoTFirmwareUpdateActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra(y, paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void u1()
  {
    if (this.T3.i) {
      k1();
    } else {
      A1();
    }
  }
  
  private void v1(int paramInt)
  {
    boolean bool;
    if ((paramInt != 3) && (paramInt != 5)) {
      bool = true;
    } else {
      bool = false;
    }
    this.P3.setEnabled(bool);
    View localView = this.P3;
    float f;
    if (bool) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    localView.setAlpha(f);
  }
  
  private void w1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.T3.p();
    if (localBaseALIoTDevice == null)
    {
      s0.n(this, 2131952465);
      return;
    }
    if (localBaseALIoTDevice.isSwitch()) {
      com.tplink.iot.g.c.a.b.e(getSupportFragmentManager(), localBaseALIoTDevice);
    } else if (localBaseALIoTDevice.isSensor()) {
      r.n(getSupportFragmentManager(), localBaseALIoTDevice);
    } else if (com.tplink.iot.g.d.a.b.k(localBaseALIoTDevice)) {
      com.tplink.iot.g.d.a.b.o(getSupportFragmentManager(), localBaseALIoTDevice);
    }
  }
  
  private void x1(int paramInt)
  {
    this.z.setVisibility(8);
    this.p0.setVisibility(8);
    this.p3.setImageResource(2131689927);
    this.K3.i();
    this.p1.setVisibility(8);
    this.I3.setVisibility(8);
    this.J3.setVisibility(8);
    this.L3.setVisibility(8);
    this.S3 = paramInt;
    switch (paramInt)
    {
    default: 
      break;
    case 4: 
      this.p0.setVisibility(0);
      this.p3.setImageResource(2131689925);
      this.H3.setText(2131952591);
      this.I3.setVisibility(0);
      this.I3.setText(2131952879);
      s0.n(this, 2131952729);
      break;
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      this.p0.setVisibility(0);
      this.p1.setVisibility(0);
      this.p3.setImageResource(2131689927);
      this.H3.setText(2131952727);
      if (2 == paramInt)
      {
        this.I3.setVisibility(0);
        this.I3.setText(2131952738);
      }
      else if (6 == paramInt)
      {
        this.H3.setText(2131952731);
        this.I3.setVisibility(0);
        this.I3.setText(2131952879);
        s0.n(this, 2131951723);
        m.f(this.U3, false);
      }
      else if (7 == paramInt)
      {
        this.N3.setVisibility(4);
        this.T3.x();
        this.T3.u();
        this.p3.setImageResource(2131689926);
        this.H3.setText(2131952732);
        this.p1.setVisibility(8);
        E1(false);
        m.f(this.U3, true);
      }
      else if (8 == paramInt)
      {
        this.J3.setVisibility(0);
        this.J3.setText(2131952709);
      }
      else if (9 == paramInt)
      {
        this.J3.setVisibility(0);
        this.J3.setText(2131952709);
      }
      else
      {
        this.L3.setVisibility(0);
        if (5 == paramInt)
        {
          this.T3.S();
          this.L3.d(2, getResources().getString(2131952733));
        }
      }
      break;
    case 1: 
      this.z.setVisibility(0);
      this.K3.g();
      this.T3.m();
    }
    v1(paramInt);
  }
  
  private void y1()
  {
    new TPMaterialDialogV3.Builder(this).d(2131952726).h(2131952441, 2131099804, null).k(2131954328, new h()).t();
  }
  
  private void z1()
  {
    new TPMaterialDialogV2.Builder(this).h(2131953785).l(2131952391, 2131099804, null).o(2131953754, 2131099808, new d(this)).b(false).c(false).y();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362077)
    {
      if (i == 2131362887) {
        X0(AutoUpdateActivity.class, this.U3);
      }
    }
    else {
      u1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558549);
    this.U3 = getIntent().getStringExtra("device_id_md5");
    this.V3 = getIntent().getBooleanExtra(y, false);
    this.T3 = ((IoTFirmwareUpdateViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.U3)).get(IoTFirmwareUpdateViewModel.class));
    n1();
    B1();
    x1(1);
    m.d();
  }
  
  protected void onDestroy()
  {
    com.tplink.iot.base.b localb = this.c;
    if (localb != null) {
      localb.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  class a
    implements Observer<ThingFirmware>
  {
    a() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      if (paramThingFirmware != null) {
        IoTFirmwareUpdateActivity.e1(IoTFirmwareUpdateActivity.this, paramThingFirmware);
      }
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean != null) {
        if (paramBoolean.booleanValue()) {
          IoTFirmwareUpdateActivity.f1(IoTFirmwareUpdateActivity.this).w();
        } else {
          IoTFirmwareUpdateActivity.g1(IoTFirmwareUpdateActivity.this, 4);
        }
      }
    }
  }
  
  class c
    implements Observer<FirmwareDownloadState>
  {
    c() {}
    
    public void a(@Nullable FirmwareDownloadState paramFirmwareDownloadState)
    {
      IoTFirmwareUpdateActivity.h1(IoTFirmwareUpdateActivity.this, paramFirmwareDownloadState);
    }
  }
  
  class d
    implements Observer<Integer>
  {
    d() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      if (paramInteger != null) {
        IoTFirmwareUpdateActivity.g1(IoTFirmwareUpdateActivity.this, paramInteger.intValue());
      }
    }
  }
  
  class e
    implements Observer<Boolean>
  {
    e() {}
    
    public void a(Boolean paramBoolean)
    {
      if (paramBoolean != null)
      {
        TextView localTextView = IoTFirmwareUpdateActivity.i1(IoTFirmwareUpdateActivity.this);
        int i;
        if (paramBoolean.booleanValue()) {
          i = 2131952442;
        } else {
          i = 2131952440;
        }
        localTextView.setText(i);
      }
    }
  }
  
  class f
    implements Runnable
  {
    f() {}
    
    public void run()
    {
      IoTFirmwareUpdateActivity.f1(IoTFirmwareUpdateActivity.this).w();
    }
  }
  
  class g
    implements Runnable
  {
    g() {}
    
    public void run()
    {
      IoTFirmwareUpdateActivity.g1(IoTFirmwareUpdateActivity.this, 7);
    }
  }
  
  class h
    implements TPMaterialDialogV3.d
  {
    h() {}
    
    public void onClick(View paramView)
    {
      IoTFirmwareUpdateActivity.j1(IoTFirmwareUpdateActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTFirmwareUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */