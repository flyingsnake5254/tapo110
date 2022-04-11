package com.tplink.iot.view.quicksetup.ble;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.common.PlugAPListActivity;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.tpble.z;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BleConnectPlugActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView H3;
  private ImageView I3;
  private ImageView J3;
  private TPRippleBackground K3;
  private TPRippleBackground L3;
  private TextView M3;
  private ValueAnimator N3;
  private ValueAnimator O3;
  private ValueAnimator P3;
  private ValueAnimator Q3;
  private boolean R3;
  private boolean S3;
  private ValueAnimator T3;
  private Bitmap U3;
  private Handler V3;
  private boolean W3;
  private int X3 = 48;
  private QuickSetupViewModel Y3;
  private io.reactivex.e0.c Z3;
  private QuickSetupInfoBean a4;
  private String b4;
  private List<WirelessScanInfoBean> c4 = new ArrayList();
  private int d4;
  private int e4;
  private boolean f4;
  private Integer g4;
  private Integer h4;
  private io.reactivex.e0.c i4;
  private long j4;
  private ImageView p0;
  private ImageView p1;
  private ImageView p2;
  private ImageView p3;
  private int y = 0;
  private boolean z;
  
  private void A2()
  {
    this.Z3 = this.Y3.D0().G0(new l());
  }
  
  private void R1()
  {
    Object localObject = this.N3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.N3.cancel();
      this.N3 = null;
    }
    localObject = this.O3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.O3.cancel();
      this.O3 = null;
    }
    localObject = this.P3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.P3.cancel();
      this.P3 = null;
    }
    localObject = this.L3;
    if (localObject != null) {
      ((TPRippleBackground)localObject).f();
    }
    localObject = this.K3;
    if (localObject != null) {
      ((TPRippleBackground)localObject).f();
    }
  }
  
  private void S1()
  {
    ValueAnimator localValueAnimator = this.Q3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.Q3.cancel();
      this.Q3 = null;
    }
  }
  
  private void T1()
  {
    ValueAnimator localValueAnimator = this.T3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.T3.cancel();
      this.T3 = null;
    }
  }
  
  private void U1()
  {
    d2();
  }
  
  private void V1()
  {
    final ImageView localImageView = (ImageView)findViewById(2131363736);
    final TPHookView localTPHookView = (TPHookView)findViewById(2131362781);
    this.p0.setVisibility(4);
    this.p0.setVisibility(0);
    this.p2.setVisibility(4);
    this.K3.setTranslationY(0.0F);
    ValueAnimator localValueAnimator = this.P3;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.K3.f();
    this.L3.f();
    this.I3.setVisibility(4);
    this.J3.setVisibility(4);
    this.z = false;
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 400.0F }).setDuration(4000L);
    this.O3 = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.O3.addUpdateListener(new h(localImageView, localTPHookView));
    this.O3.start();
  }
  
  private boolean W1()
  {
    if ((this.X3 == 49) && (!this.W3))
    {
      this.W3 = true;
      j2();
      return true;
    }
    return false;
  }
  
  private void X1()
  {
    S1();
    l2();
    this.Y3.X();
  }
  
  private String Y1()
  {
    String str1 = EnumDeviceType.PLUG.getDeviceType();
    QuickSetupInfoBean localQuickSetupInfoBean = this.a4;
    String str2 = str1;
    if (localQuickSetupInfoBean != null)
    {
      str2 = str1;
      if (localQuickSetupInfoBean.getComponentResult() != null)
      {
        str2 = str1;
        if (this.a4.getComponentResult().getExtraInfo() != null) {
          str2 = this.a4.getComponentResult().getExtraInfo().getDeviceType();
        }
      }
    }
    return str2;
  }
  
  private void Z1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.b4 = ((Bundle)localObject).getString("device_model");
        this.j4 = ((Bundle)localObject).getLong("onboarding_start_time", 0L);
      }
    }
  }
  
  private void a2()
  {
    this.Y3.j0();
  }
  
  private int b2()
  {
    return com.tplink.iot.view.quicksetup.base.c.d(this.b4);
  }
  
  private void c2()
  {
    if (this.a4 != null)
    {
      localObject = this.h4;
      if ((localObject != null) && (this.g4 != null))
      {
        int i = ((Integer)localObject).intValue();
        int j = this.g4.intValue();
        this.a4.setLatitude(Integer.valueOf(i));
        this.a4.setLongitude(Integer.valueOf(j));
      }
    }
    Intent localIntent = new Intent(this, PlugAPListActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("device_info_bean", this.a4);
    if (!this.c4.isEmpty()) {
      ((Bundle)localObject).putSerializable("ap_ssid_list", (Serializable)this.c4);
    }
    localIntent.putExtras((Bundle)localObject);
    startActivityForResult(localIntent, 102);
    o2();
  }
  
  private void d2()
  {
    int i = this.X3;
    if (i != 49)
    {
      if (i == 51)
      {
        this.M3.setText(getString(2131953617));
        a2();
      }
    }
    else
    {
      this.X3 = 50;
      this.M3.setText(getString(2131953582));
      V1();
      m2();
    }
  }
  
  private void e2()
  {
    if (W1()) {
      this.V3.postDelayed(new m(), 2000L);
    } else {
      X1();
    }
  }
  
  private void f2(String paramString)
  {
    y2(paramString);
  }
  
  private void g2()
  {
    this.V3 = new Handler();
    this.p2 = ((ImageView)findViewById(2131361979));
    this.p0 = ((ImageView)findViewById(2131363730));
    this.d4 = com.tplink.iot.view.quicksetup.base.c.j(this.b4);
    this.e4 = com.tplink.iot.view.quicksetup.base.c.f(this.b4);
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    this.p3 = ((ImageView)findViewById(2131363734));
    this.H3 = ((ImageView)findViewById(2131363735));
    this.I3 = ((ImageView)findViewById(2131362814));
    this.J3 = ((ImageView)findViewById(2131362815));
    this.M3 = ((TextView)findViewById(2131363739));
    this.p1 = ((ImageView)findViewById(2131363729));
    this.L3 = ((TPRippleBackground)findViewById(2131363733));
    this.K3 = ((TPRippleBackground)findViewById(2131363732));
    s2();
    x2();
    w2();
  }
  
  private void h2()
  {
    this.J3.setTranslationY(0.0F);
    this.I3.setTranslationY(0.0F);
    this.J3.setVisibility(0);
    this.I3.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.P3 = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.P3.addUpdateListener(new i());
    this.P3.setRepeatMode(1);
    this.P3.setRepeatCount(-1);
    this.P3.start();
  }
  
  private void i2()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
    this.Q3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new b());
    this.Q3.addListener(new c());
    this.Q3.setRepeatCount(-1);
    this.Q3.setRepeatMode(2);
    this.Q3.start();
  }
  
  private void j2()
  {
    final Object localObject = this.p2;
    if (localObject != null)
    {
      final int i = ((ImageView)localObject).getHeight();
      this.p2.setImageResource(2131100200);
      this.p2.setVisibility(0);
      this.U3 = Bitmap.createBitmap(this.p2.getWidth(), i, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(this.U3);
      final Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setColor(ContextCompat.getColor(this, 2131099862));
      final RectF localRectF = new RectF();
      localRectF.left = 0.0F;
      localRectF.right = this.p2.getWidth();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(80L);
      this.N3 = localValueAnimator;
      localValueAnimator.setStartDelay(200L);
      this.N3.addUpdateListener(new f(localRectF, i, (Canvas)localObject, localPaint));
      this.N3.addListener(new g());
      this.N3.setRepeatMode(1);
      this.N3.setRepeatCount(8);
      this.N3.start();
    }
  }
  
  private void k2()
  {
    this.i4 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new k()).F0();
  }
  
  private void l2()
  {
    this.p1.setImageResource(this.d4);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.T3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new d());
    this.T3.setRepeatCount(-1);
    this.T3.setRepeatMode(2);
    this.T3.start();
  }
  
  private void m2()
  {
    String str1 = Y1();
    String str2 = this.b4;
    Object localObject = this.a4;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((QuickSetupInfoBean)localObject).getDeviceIdMD5();
    }
    r.b(str1, str2, (String)localObject);
  }
  
  private void n2()
  {
    String str1 = Y1();
    String str2 = this.b4;
    Object localObject = this.a4;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((QuickSetupInfoBean)localObject).getDeviceIdMD5();
    }
    r.o(str1, str2, (String)localObject);
  }
  
  private void o2()
  {
    String str1 = Y1();
    String str2 = this.b4;
    Object localObject = this.a4;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((QuickSetupInfoBean)localObject).getDeviceIdMD5();
    }
    r.p(str1, str2, (String)localObject, false);
  }
  
  public static void p2(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, BleConnectPlugActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localBundle.putLong("onboarding_start_time", paramLong);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void q2(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    if (com.tplink.iot.view.quicksetup.base.d.x(paramQuickSetupComponentResult) <= 0)
    {
      u2("parse component fail");
      return;
    }
    QuickSetupInfoBean localQuickSetupInfoBean = this.a4;
    if (localQuickSetupInfoBean != null) {
      localQuickSetupInfoBean.setComponentResult(paramQuickSetupComponentResult);
    }
    U1();
  }
  
  private void r2(List<WirelessScanInfoBean> paramList)
  {
    if (paramList == null)
    {
      u2("parse wireless list fail");
      return;
    }
    if (!paramList.isEmpty()) {
      this.c4.addAll(paramList);
    }
    c2();
  }
  
  private void s2()
  {
    this.W3 = false;
    this.I3.setVisibility(4);
    this.I3.setTranslationY(0.0F);
    this.J3.setVisibility(4);
    this.J3.setTranslationY(0.0F);
    this.p2.setImageResource(2131100200);
    this.p2.setVisibility(0);
    this.p2.setTranslationY(0.0F);
    this.p2.setAlpha(1.0F);
    this.K3.setVisibility(0);
    this.K3.setTranslationY(0.0F);
    this.p0.setImageResource(b2());
  }
  
  private void t2()
  {
    Bitmap localBitmap = this.U3;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.U3.recycle();
      this.U3 = null;
    }
  }
  
  private void u2(String paramString)
  {
    int i = this.X3;
    if ((i == 49) || (i == 51)) {
      if (z.b(this))
      {
        if (this.Y3.l0())
        {
          this.Y3.close();
          y2(paramString);
        }
        else
        {
          y2(paramString);
        }
      }
      else {
        y2(paramString);
      }
    }
  }
  
  private void v2()
  {
    if (com.tplink.iot.view.quicksetup.base.ble.d.b(this))
    {
      k2();
      A2();
    }
    else
    {
      this.V3.postDelayed(new j(), 5000L);
    }
  }
  
  private void w2()
  {
    this.X3 = 49;
    this.K3.e();
    this.L3.e();
    i2();
    v2();
  }
  
  private void y2(String paramString)
  {
    BleNoFindActivity.l1(this, this.b4, 100);
    r.c();
    v.a(BleConnectPlugActivity.class, BleNoFindActivity.class, paramString);
  }
  
  private void z2()
  {
    com.tplink.iot.view.quicksetup.base.d.e0(this, new e());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 != 100)
    {
      if (paramInt1 == 102)
      {
        this.c4.clear();
        a2();
      }
    }
    else {
      v2();
    }
  }
  
  public void onBackPressed()
  {
    z2();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831) {
      z2();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558621);
    com.tplink.iot.view.quicksetup.base.d.b0(this, 2131100143);
    Z1();
    this.Y3 = ((QuickSetupViewModel)ViewModelProviders.of(this).get(QuickSetupViewModel.class));
    g2();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.V3;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.i4;
    if (localObject != null)
    {
      ((io.reactivex.e0.c)localObject).dispose();
      this.i4 = null;
    }
    if (this.f4)
    {
      localObject = this.Y3;
      if (localObject != null) {
        com.tplink.iot.view.quicksetup.base.d.h(((QuickSetupViewModel)localObject).e0(this.a4));
      }
    }
    t2();
    R1();
    localObject = this.Z3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    S1();
    T1();
  }
  
  public void x2()
  {
    this.Y3.W().observe(this, new n());
    this.Y3.i0().observe(this, new a());
  }
  
  class a
    implements Observer<i<List<WirelessScanInfoBean>>>
  {
    a() {}
    
    public void a(@Nullable i<List<WirelessScanInfoBean>> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        BleConnectPlugActivity.y1(BleConnectPlugActivity.this, (List)parami.a());
      }
      else
      {
        BleConnectPlugActivity.x1(BleConnectPlugActivity.this, "get wireless list fail");
        BleConnectPlugActivity.z1(BleConnectPlugActivity.this);
      }
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BleConnectPlugActivity.A1(BleConnectPlugActivity.this).setAlpha(f);
    }
  }
  
  class c
    implements Animator.AnimatorListener
  {
    c() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (BleConnectPlugActivity.D1(BleConnectPlugActivity.this))
      {
        paramAnimator = BleConnectPlugActivity.this;
        BleConnectPlugActivity.C1(paramAnimator, BleConnectPlugActivity.B1(paramAnimator) ^ true);
      }
      paramAnimator = BleConnectPlugActivity.A1(BleConnectPlugActivity.this);
      int i;
      if (BleConnectPlugActivity.B1(BleConnectPlugActivity.this)) {
        i = BleConnectPlugActivity.H1(BleConnectPlugActivity.this);
      } else {
        i = BleConnectPlugActivity.G1(BleConnectPlugActivity.this);
      }
      paramAnimator.setImageResource(i);
      paramAnimator = BleConnectPlugActivity.this;
      BleConnectPlugActivity.E1(paramAnimator, BleConnectPlugActivity.D1(paramAnimator) ^ true);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BleConnectPlugActivity.C1(BleConnectPlugActivity.this, false);
      BleConnectPlugActivity.E1(BleConnectPlugActivity.this, false);
      BleConnectPlugActivity.A1(BleConnectPlugActivity.this).setImageResource(BleConnectPlugActivity.G1(BleConnectPlugActivity.this));
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BleConnectPlugActivity.A1(BleConnectPlugActivity.this).setAlpha(f);
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e() {}
    
    public void onClick(View paramView)
    {
      BleConnectPlugActivity.I1(BleConnectPlugActivity.this, true);
      r.g(com.tplink.iot.view.quicksetup.base.d.t(BleConnectPlugActivity.J1(BleConnectPlugActivity.this)), BleConnectPlugActivity.J1(BleConnectPlugActivity.this), "SearchDevicePage");
    }
  }
  
  class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(RectF paramRectF, int paramInt, Canvas paramCanvas, Paint paramPaint) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramValueAnimator = localRectF;
      int i = i;
      int j = i / 12;
      int k = BleConnectPlugActivity.e1(BleConnectPlugActivity.this);
      int m = i;
      paramValueAnimator.top = (i - j - k * m / 8 - 3);
      localRectF.bottom = (m - BleConnectPlugActivity.e1(BleConnectPlugActivity.this) * i / 8 - 3);
      localObject.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint);
      BleConnectPlugActivity.s1(BleConnectPlugActivity.this).setImageBitmap(BleConnectPlugActivity.h1(BleConnectPlugActivity.this));
    }
  }
  
  class g
    implements Animator.AnimatorListener
  {
    g() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BleConnectPlugActivity.f1(BleConnectPlugActivity.this, 0);
      BleConnectPlugActivity.F1(BleConnectPlugActivity.this);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      BleConnectPlugActivity.g1(BleConnectPlugActivity.this);
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(ImageView paramImageView, TPHookView paramTPHookView) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      if (localImageView == null) {
        return;
      }
      if (localTPHookView == null) {
        return;
      }
      if (f1 < 60.0F) {
        BleConnectPlugActivity.L1(BleConnectPlugActivity.this).setTranslationY(f1 / 60.0F * (BleConnectPlugActivity.s1(BleConnectPlugActivity.this).getHeight() + BleConnectPlugActivity.K1(BleConnectPlugActivity.this).getHeight()));
      }
      if ((f1 > 45.0F) && (f1 <= 100.0F))
      {
        BleConnectPlugActivity.M1(BleConnectPlugActivity.this).setVisibility(4);
        BleConnectPlugActivity.N1(BleConnectPlugActivity.this).setVisibility(4);
        localImageView.setVisibility(0);
      }
      float f2;
      if ((f1 > 40.0F) && (f1 <= 100.0F))
      {
        localImageView.setTranslationY((40.0F - f1) / 100.0F * BleConnectPlugActivity.s1(BleConnectPlugActivity.this).getHeight());
        paramValueAnimator = localImageView;
        f2 = (f1 - 40.0F) / 100.0F + 1.0F;
        paramValueAnimator.setScaleX(f2);
        localImageView.setScaleY(f2);
      }
      if ((f1 >= 100.0F) && (f1 <= 200.0F))
      {
        paramValueAnimator = localTPHookView;
        f2 = (f1 - 100.0F) / 100.0F;
        paramValueAnimator.setScaleX(f2);
        localTPHookView.setScaleY(f2);
        localTPHookView.setVisibility(0);
      }
      if ((f1 >= 200.0F) && (f1 <= 300.0F) && (!BleConnectPlugActivity.O1(BleConnectPlugActivity.this)))
      {
        localTPHookView.h();
        BleConnectPlugActivity.P1(BleConnectPlugActivity.this, true);
      }
      if (f1 > 300.0F)
      {
        paramValueAnimator = localTPHookView;
        f2 = 400.0F - f1;
        float f3 = f2 / 110.0F;
        paramValueAnimator.setScaleX(f3);
        localTPHookView.setScaleY(f3);
        BleConnectPlugActivity.Q1(BleConnectPlugActivity.this).setAlpha(f2 * 1.0F / 100.0F);
        paramValueAnimator = localImageView;
        f2 = (f1 - 300.0F) * 8.0F / 100.0F + 1.6F;
        paramValueAnimator.setScaleX(f2);
        localImageView.setScaleY(f2);
      }
      if (f1 >= 400.0F)
      {
        localTPHookView.setVisibility(4);
        localImageView.setVisibility(4);
        BleConnectPlugActivity.i1(BleConnectPlugActivity.this).cancel();
        BleConnectPlugActivity.P1(BleConnectPlugActivity.this, false);
        BleConnectPlugActivity.L1(BleConnectPlugActivity.this).e();
        BleConnectPlugActivity.j1(BleConnectPlugActivity.this, 51);
        BleConnectPlugActivity.Q1(BleConnectPlugActivity.this).setAlpha(1.0F);
        BleConnectPlugActivity.Q1(BleConnectPlugActivity.this).setText(BleConnectPlugActivity.this.getString(2131953617));
        BleConnectPlugActivity.k1(BleConnectPlugActivity.this);
      }
    }
  }
  
  class i
    implements ValueAnimator.AnimatorUpdateListener
  {
    i() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BleConnectPlugActivity.l1(BleConnectPlugActivity.this).setTranslationY(f / 200.0F * BleConnectPlugActivity.s1(BleConnectPlugActivity.this).getHeight() + 8.0F);
      BleConnectPlugActivity.m1(BleConnectPlugActivity.this).setTranslationY(-f / 200.0F * BleConnectPlugActivity.s1(BleConnectPlugActivity.this).getHeight() - 8.0F);
    }
  }
  
  class j
    implements Runnable
  {
    j() {}
    
    public void run()
    {
      if (BleConnectPlugActivity.this.isDestroyed()) {
        return;
      }
      BleConnectPlugActivity.n1(BleConnectPlugActivity.this, "ble disable");
    }
  }
  
  class k
    implements g<DeviceLocationInfo>
  {
    k() {}
    
    public void a(DeviceLocationInfo paramDeviceLocationInfo)
      throws Exception
    {
      if ((paramDeviceLocationInfo != null) && (paramDeviceLocationInfo.getLatitude() != null) && (paramDeviceLocationInfo.getLongitude() != null))
      {
        BleConnectPlugActivity.o1(BleConnectPlugActivity.this, paramDeviceLocationInfo.getLatitude());
        BleConnectPlugActivity.p1(BleConnectPlugActivity.this, paramDeviceLocationInfo.getLongitude());
      }
    }
  }
  
  class l
    implements g<u>
  {
    l() {}
    
    public void a(u paramu)
      throws Exception
    {
      if (paramu.b() == 0)
      {
        BleConnectPlugActivity.q1(BleConnectPlugActivity.this, new QuickSetupInfoBean(paramu.a(), BleConnectPlugActivity.r1(BleConnectPlugActivity.this)));
        r.d();
        BleConnectPlugActivity.t1(BleConnectPlugActivity.this);
      }
      else if (paramu.b() == 64036)
      {
        BleConnectPlugActivity.n1(BleConnectPlugActivity.this, "ble scan, no find device");
      }
      else
      {
        BleConnectPlugActivity.u1(BleConnectPlugActivity.this, "ble connect device fail");
      }
    }
  }
  
  class m
    implements Runnable
  {
    m() {}
    
    public void run()
    {
      if (BleConnectPlugActivity.this.isDestroyed()) {
        return;
      }
      BleConnectPlugActivity.v1(BleConnectPlugActivity.this);
    }
  }
  
  class n
    implements Observer<i<QuickSetupComponentResult>>
  {
    n() {}
    
    public void a(@Nullable i<QuickSetupComponentResult> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        BleConnectPlugActivity.w1(BleConnectPlugActivity.this, (QuickSetupComponentResult)parami.a());
      } else {
        BleConnectPlugActivity.x1(BleConnectPlugActivity.this, "get component fail");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BleConnectPlugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */