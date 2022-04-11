package com.tplink.iot.view.quicksetup.bulb;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
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
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.y;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpwifi.TPWifiConnectReceiver;
import com.tplink.libtpwifi.TPWifiStateReceiver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftAPConnectBulbActivity
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
  private ValueAnimator R3;
  private ValueAnimator S3;
  private ValueAnimator T3;
  private com.tplink.iot.widget.plug.b U3;
  private Bitmap V3;
  private Bitmap W3;
  private Bitmap X3;
  private Handler Y3;
  private volatile boolean Z3;
  private boolean a4;
  private int b4 = 48;
  private QuickSetupInfoBundle c4;
  private TPWifiConnectReceiver d4;
  private TPWifiStateReceiver e4;
  private boolean f4 = false;
  private BulbQuickSetupViewModel g4;
  private io.reactivex.e0.c h4;
  private io.reactivex.e0.c i4;
  private io.reactivex.e0.c j4;
  private String k4;
  private String l4;
  private String m4;
  private boolean n4;
  private List<WirelessScanInfoBean> o4 = new ArrayList();
  private ImageView p0;
  private ImageView p1;
  private ImageView p2;
  private ImageView p3;
  private boolean p4;
  private int y = 0;
  private boolean z;
  
  private void A2()
  {
    this.g4.v0().E(new c(this)).F0();
  }
  
  private void B2()
  {
    q localq;
    if ((com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) && (!TextUtils.isEmpty(this.l4)))
    {
      b.d.w.c.a.d("sendTDPBroadcast 1");
      localq = this.g4.y0(this.l4, com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.c4.getDeviceModel()));
    }
    else
    {
      b.d.w.c.a.d("sendTDPBroadcast 2");
      localq = this.g4.x0(com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.c4.getDeviceModel()));
    }
    this.h4 = localq.G0(new i());
  }
  
  private void C2(String paramString)
  {
    if (this.Z3) {
      return;
    }
    this.Z3 = true;
    Object localObject1 = this.i4;
    if (localObject1 != null) {
      ((io.reactivex.e0.c)localObject1).dispose();
    }
    localObject1 = this.j4;
    if (localObject1 != null) {
      ((io.reactivex.e0.c)localObject1).dispose();
    }
    Object localObject2 = this.Y3;
    localObject1 = null;
    if (localObject2 != null) {
      ((Handler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = this.c4;
    if (localObject2 != null) {
      localObject1 = ((QuickSetupInfoBundle)localObject2).getDeviceModel();
    }
    BulbNoFindActivity.n1(this, (String)localObject1, 103);
    v.a(SoftAPConnectBulbActivity.class, BulbNoFindActivity.class, paramString);
  }
  
  private void D2()
  {
    com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.c4.getDeviceType(), this.c4.getDeviceModel(), "SearchDevicePage");
  }
  
  private void E2(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      int i = paramArrayOfInt.length;
      int j = 0;
      if (i == 1)
      {
        this.p1.setVisibility(0);
        this.p1.setImageResource(paramArrayOfInt[0]);
        paramArrayOfInt = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramInt);
        this.T3 = paramArrayOfInt;
        paramArrayOfInt.addUpdateListener(new b(this));
        this.T3.setRepeatCount(-1);
        this.T3.setRepeatMode(2);
        this.T3.start();
      }
      else
      {
        this.p1.setVisibility(0);
        Drawable[] arrayOfDrawable = new Drawable[paramArrayOfInt.length];
        for (paramInt = j; paramInt < paramArrayOfInt.length; paramInt++) {
          arrayOfDrawable[paramInt] = getResources().getDrawable(paramArrayOfInt[paramInt]);
        }
        paramArrayOfInt = new TransitionDrawable(arrayOfDrawable);
        this.p1.setImageDrawable(paramArrayOfInt);
        paramArrayOfInt = new com.tplink.iot.widget.plug.b(paramArrayOfInt, 1000L);
        this.U3 = paramArrayOfInt;
        paramArrayOfInt.d();
      }
    }
    else
    {
      this.p1.setVisibility(8);
    }
  }
  
  private void F2()
  {
    W1();
    E2(com.tplink.iot.view.quicksetup.bulb.utils.b.p(this.c4.getDeviceModel()), com.tplink.iot.view.quicksetup.bulb.utils.b.n(this.c4.getDeviceModel()));
  }
  
  private void G2()
  {
    W1();
    E2(com.tplink.iot.view.quicksetup.bulb.utils.b.q(this.c4.getDeviceModel()), 1000);
  }
  
  private void H2()
  {
    this.j4 = q.W0(120L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).G0(new e());
  }
  
  private void I2()
  {
    this.g4.Z().observe(this, new l());
    this.g4.e0().observe(this, new m());
    this.g4.W().observe(this, new n());
  }
  
  private void J2()
  {
    y.b(this.l4, null, null);
  }
  
  private void K2()
  {
    Object localObject = this.d4;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.d4 = null;
    }
    localObject = this.e4;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.e4 = null;
    }
  }
  
  private void V1()
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
    localObject = this.Q3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.Q3.cancel();
      this.Q3 = null;
    }
    localObject = this.R3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.R3.cancel();
      this.R3 = null;
    }
    localObject = this.S3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.S3.cancel();
      this.S3 = null;
    }
    localObject = this.L3;
    if (localObject != null) {
      ((TPRippleBackground)localObject).f();
    }
    localObject = this.K3;
    if (localObject != null) {
      ((TPRippleBackground)localObject).f();
    }
    W1();
  }
  
  private void W1()
  {
    Object localObject = this.T3;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
      this.T3.cancel();
      this.T3 = null;
    }
    localObject = this.U3;
    if (localObject != null)
    {
      ((com.tplink.iot.widget.plug.b)localObject).b();
      this.U3 = null;
    }
  }
  
  private void X1()
  {
    b.d.w.c.a.d("checkSwitchWifiStateDoRetry");
    this.i4 = q.b0(5L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f());
  }
  
  private void Y1()
  {
    e2();
  }
  
  private void Z1()
  {
    final ImageView localImageView = (ImageView)findViewById(2131363736);
    final TPHookView localTPHookView = (TPHookView)findViewById(2131362781);
    this.p0.setVisibility(4);
    this.p0.setVisibility(0);
    this.p2.setVisibility(4);
    this.K3.setTranslationY(0.0F);
    ValueAnimator localValueAnimator = this.R3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.R3.cancel();
      this.R3 = null;
    }
    this.I3.setVisibility(4);
    this.J3.setVisibility(4);
    this.K3.f();
    this.L3.f();
    W1();
    this.z = false;
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 400.0F }).setDuration(4000L);
    this.Q3 = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.Q3.addUpdateListener(new c(localImageView, localTPHookView));
    this.Q3.start();
  }
  
  private boolean a2()
  {
    if ((this.b4 == 49) && (!this.a4))
    {
      this.a4 = true;
      j2();
      return true;
    }
    return false;
  }
  
  private void b2()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.l4 = ((Bundle)localObject).getString("bulb_ssid");
        this.c4 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void c2()
  {
    this.M3.setAlpha(1.0F);
    this.M3.setText(getString(2131953617));
    F2();
    this.Y3.postDelayed(new k(), 2000L);
  }
  
  private void d2()
  {
    this.Y3.postDelayed(new d(), 30000L);
  }
  
  private void e2()
  {
    int i = this.b4;
    if (i != 49)
    {
      if (i == 51) {
        c2();
      }
    }
    else
    {
      this.b4 = 50;
      this.M3.setText(getString(2131953582));
      Z1();
      r.w(this.c4.getDeviceType(), this.c4.getDeviceModel(), this.k4);
    }
  }
  
  private void f2()
  {
    if (a2()) {
      this.Y3.postDelayed(new j(), 2000L);
    } else {
      this.g4.Y();
    }
  }
  
  private void g2()
  {
    SoftAPBulbSSIDEmptyActivity.n1(this, this.c4);
    r.x();
    finish();
  }
  
  private void h2()
  {
    this.Y3 = new Handler();
    this.p2 = ((ImageView)findViewById(2131361979));
    ImageView localImageView = (ImageView)findViewById(2131363730);
    this.p0 = localImageView;
    if (localImageView != null) {
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new g());
    }
  }
  
  private void i2()
  {
    this.J3.setTranslationY(0.0F);
    this.I3.setTranslationY(0.0F);
    this.J3.setVisibility(0);
    this.I3.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(1000L);
    this.R3 = localValueAnimator;
    localValueAnimator.setStartDelay(200L);
    this.R3.addUpdateListener(new b());
    this.R3.setRepeatMode(1);
    this.R3.setRepeatCount(-1);
    this.R3.start();
  }
  
  private void j2()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      final int i = ((ImageView)localObject).getHeight();
      this.p2.setImageResource(2131100200);
      this.p2.setVisibility(0);
      this.X3 = Bitmap.createBitmap(this.p2.getWidth(), i, Bitmap.Config.ARGB_8888);
      final Canvas localCanvas = new Canvas(this.X3);
      final Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setColor(ContextCompat.getColor(this, 2131099862));
      final RectF localRectF = new RectF();
      localRectF.left = 0.0F;
      localRectF.right = this.p2.getWidth();
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F }).setDuration(80L);
      this.P3 = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setStartDelay(200L);
      this.P3.addUpdateListener(new o(localRectF, i, localCanvas, localPaint));
      this.P3.addListener(new a());
      this.P3.setRepeatMode(1);
      this.P3.setRepeatCount(8);
      this.P3.start();
    }
  }
  
  private void k2()
  {
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    this.p1 = ((ImageView)findViewById(2131363729));
    this.p3 = ((ImageView)findViewById(2131363734));
    this.H3 = ((ImageView)findViewById(2131363737));
    this.I3 = ((ImageView)findViewById(2131362814));
    this.J3 = ((ImageView)findViewById(2131362815));
    this.M3 = ((TextView)findViewById(2131363739));
    this.L3 = ((TPRippleBackground)findViewById(2131363733));
    this.K3 = ((TPRippleBackground)findViewById(2131363732));
    this.p0.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.c4.getDeviceModel()));
    I2();
    z2();
  }
  
  private void l2()
  {
    if (this.d4 == null)
    {
      TPWifiConnectReceiver localTPWifiConnectReceiver = new TPWifiConnectReceiver();
      this.d4 = localTPWifiConnectReceiver;
      localTPWifiConnectReceiver.b(new h());
      registerReceiver(this.d4, TPWifiConnectReceiver.a());
    }
  }
  
  public static void q2(Context paramContext, String paramString, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, SoftAPConnectBulbActivity.class);
    Bundle localBundle = new Bundle();
    if (paramString != null) {
      localBundle.putString("bulb_ssid", paramString);
    }
    if (paramQuickSetupInfoBundle != null) {
      localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    }
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void r2(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    if (com.tplink.iot.view.quicksetup.base.d.x(paramQuickSetupComponentResult) <= 0)
    {
      b.d.w.c.a.d("parseComponentResult fail");
      y2("parse component fail");
      return;
    }
    if (this.c4 == null) {
      this.c4 = new QuickSetupInfoBundle();
    }
    this.c4.setComponentResult(paramQuickSetupComponentResult);
    this.n4 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.c4);
    Y1();
  }
  
  private void s2()
  {
    if (this.Z3) {
      return;
    }
    Intent localIntent = new Intent(this, BulbAPListActivity.class);
    Bundle localBundle = new Bundle();
    if (this.c4 == null) {
      this.c4 = new QuickSetupInfoBundle();
    }
    this.c4.setBulbSSID(this.l4);
    this.c4.setDeviceIdMD5(this.k4);
    QuickSetupInfoBundle localQuickSetupInfoBundle = this.c4;
    localQuickSetupInfoBundle.setOnBoardingType(com.tplink.iot.view.quicksetup.bulb.utils.b.t(localQuickSetupInfoBundle.getDeviceModel()));
    this.c4.setNeedDisplayInherit(this.p4);
    localBundle.putSerializable("quick_setup_bundle", this.c4);
    if (!this.o4.isEmpty()) {
      localBundle.putSerializable("ap_ssid_list", (Serializable)this.o4);
    }
    localIntent.putExtras(localBundle);
    this.Z3 = true;
    startActivityForResult(localIntent, 102);
  }
  
  private void t2()
  {
    c2();
  }
  
  private void u2()
  {
    this.a4 = false;
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
    this.p0.setVisibility(0);
    this.p0.setAlpha(1.0F);
    this.p3.setVisibility(0);
    this.p3.setAlpha(1.0F);
    this.H3.setVisibility(0);
    this.H3.setAlpha(1.0F);
    this.M3.setText(getString(2131953578));
  }
  
  private void v2()
  {
    l2();
    if (com.tplink.libtpwifi.b.k().q(this.l4))
    {
      b.d.w.c.a.d("realSearchDeviceAfterOpenWifiWithPermission 1");
      this.f4 = true;
      this.m4 = com.tplink.libtpwifi.b.k().j();
      this.b4 = 49;
      A2();
      r.y(this.l4);
    }
    else
    {
      b.d.w.c.a.d("realSearchDeviceAfterOpenWifiWithPermission 2");
      this.f4 = false;
      this.m4 = null;
      d2();
      y.a(this.l4, null, null);
      X1();
    }
  }
  
  private void w2()
  {
    this.f4 = true;
    this.m4 = null;
    this.b4 = 49;
    A2();
  }
  
  private void x2()
  {
    Bitmap localBitmap = this.V3;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.V3.recycle();
      this.V3 = null;
    }
    localBitmap = this.W3;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.W3.recycle();
      this.W3 = null;
    }
    localBitmap = this.X3;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.X3.recycle();
      this.X3 = null;
    }
  }
  
  private void y2(String paramString)
  {
    int i = this.b4;
    if ((i == 49) || (i == 51)) {
      C2(paramString);
    }
  }
  
  private void z2()
  {
    V1();
    u2();
    this.b4 = 48;
    this.K3.e();
    this.L3.e();
    G2();
    H2();
    if ((com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) && (!TextUtils.isEmpty(this.l4)))
    {
      b.d.w.c.a.d("searchDevice 1");
      v2();
    }
    else
    {
      b.d.w.c.a.d("searchDevice 2");
      w2();
    }
  }
  
  public void finish()
  {
    this.Z3 = true;
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 != 102)
    {
      if (paramInt1 == 103) {
        z2();
      }
    }
    else
    {
      t2();
      r.n(this.c4.getDeviceType(), this.c4.getDeviceModel(), this.k4);
    }
  }
  
  public void onBackPressed()
  {
    D2();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831) {
      D2();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558678);
    com.tplink.iot.view.quicksetup.base.d.b0(this, 2131099769);
    b2();
    paramBundle = (BulbQuickSetupViewModel)ViewModelProviders.of(this).get(BulbQuickSetupViewModel.class);
    this.g4 = paramBundle;
    paramBundle.B0(this.c4.getDeviceModel());
    h2();
  }
  
  public void onDestroy()
  {
    this.Z3 = true;
    Object localObject = this.Y3;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.Y3 = null;
    }
    x2();
    V1();
    K2();
    localObject = this.h4;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.j4;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.Z3 = false;
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      SoftAPConnectBulbActivity.r1(SoftAPConnectBulbActivity.this, 0);
      SoftAPConnectBulbActivity.x1(SoftAPConnectBulbActivity.this);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      SoftAPConnectBulbActivity.s1(SoftAPConnectBulbActivity.this);
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      SoftAPConnectBulbActivity.y1(SoftAPConnectBulbActivity.this).setTranslationY(f / 200.0F * SoftAPConnectBulbActivity.w1(SoftAPConnectBulbActivity.this).getHeight() + 8.0F);
      SoftAPConnectBulbActivity.z1(SoftAPConnectBulbActivity.this).setTranslationY(-f / 200.0F * SoftAPConnectBulbActivity.w1(SoftAPConnectBulbActivity.this).getHeight() - 8.0F);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ImageView paramImageView, TPHookView paramTPHookView) {}
    
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
        SoftAPConnectBulbActivity.A1(SoftAPConnectBulbActivity.this).setTranslationY(f1 / 60.0F * (SoftAPConnectBulbActivity.w1(SoftAPConnectBulbActivity.this).getHeight() + SoftAPConnectBulbActivity.e1(SoftAPConnectBulbActivity.this).getHeight()));
      }
      if ((f1 > 45.0F) && (f1 <= 100.0F))
      {
        SoftAPConnectBulbActivity.B1(SoftAPConnectBulbActivity.this).setVisibility(4);
        SoftAPConnectBulbActivity.C1(SoftAPConnectBulbActivity.this).setVisibility(4);
        localImageView.setVisibility(0);
      }
      float f2;
      if ((f1 > 40.0F) && (f1 <= 100.0F))
      {
        localImageView.setTranslationY((40.0F - f1) / 100.0F * SoftAPConnectBulbActivity.w1(SoftAPConnectBulbActivity.this).getHeight());
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
      if ((f1 >= 200.0F) && (f1 <= 300.0F) && (!SoftAPConnectBulbActivity.D1(SoftAPConnectBulbActivity.this)))
      {
        localTPHookView.h();
        SoftAPConnectBulbActivity.F1(SoftAPConnectBulbActivity.this).setText("");
        SoftAPConnectBulbActivity.E1(SoftAPConnectBulbActivity.this, true);
      }
      if (f1 > 300.0F)
      {
        paramValueAnimator = localTPHookView;
        float f3 = 400.0F - f1;
        f2 = f3 / 110.0F;
        paramValueAnimator.setScaleX(f2);
        localTPHookView.setScaleY(f2);
        SoftAPConnectBulbActivity.F1(SoftAPConnectBulbActivity.this).setAlpha(f3 * 1.0F / 100.0F);
        paramValueAnimator = localImageView;
        f2 = (f1 - 300.0F) * 8.0F / 100.0F + 1.6F;
        paramValueAnimator.setScaleX(f2);
        localImageView.setScaleY(f2);
      }
      if (f1 >= 400.0F)
      {
        localTPHookView.setVisibility(4);
        localImageView.setVisibility(4);
        SoftAPConnectBulbActivity.H1(SoftAPConnectBulbActivity.this).cancel();
        SoftAPConnectBulbActivity.E1(SoftAPConnectBulbActivity.this, false);
        SoftAPConnectBulbActivity.A1(SoftAPConnectBulbActivity.this).e();
        SoftAPConnectBulbActivity.P1(SoftAPConnectBulbActivity.this, 51);
        SoftAPConnectBulbActivity.I1(SoftAPConnectBulbActivity.this);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      if (SoftAPConnectBulbActivity.Q1(SoftAPConnectBulbActivity.this)) {
        return;
      }
      if (!SoftAPConnectBulbActivity.t1(SoftAPConnectBulbActivity.this)) {
        SoftAPConnectBulbActivity.J1(SoftAPConnectBulbActivity.this);
      }
    }
  }
  
  class e
    implements g<Long>
  {
    e() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (SoftAPConnectBulbActivity.Q1(SoftAPConnectBulbActivity.this)) {
        return;
      }
      SoftAPConnectBulbActivity.K1(SoftAPConnectBulbActivity.this, "total timeout, exceed 2min");
    }
  }
  
  class f
    implements g<Long>
  {
    f() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (SoftAPConnectBulbActivity.Q1(SoftAPConnectBulbActivity.this))
      {
        if (SoftAPConnectBulbActivity.L1(SoftAPConnectBulbActivity.this) != null) {
          SoftAPConnectBulbActivity.L1(SoftAPConnectBulbActivity.this).dispose();
        }
        return;
      }
      if ((com.tplink.iot.view.quicksetup.base.wifi.d.a(SoftAPConnectBulbActivity.this)) && (!TextUtils.isEmpty(SoftAPConnectBulbActivity.G1(SoftAPConnectBulbActivity.this))))
      {
        paramLong = com.tplink.libtpwifi.b.k().l();
        if (!com.tplink.iot.view.quicksetup.base.d.V(SoftAPConnectBulbActivity.G1(SoftAPConnectBulbActivity.this), paramLong))
        {
          b.d.w.c.a.d("checkSwitchWifiStateDoRetry is not SSidEquals");
          SoftAPConnectBulbActivity.v1(SoftAPConnectBulbActivity.this, false);
          SoftAPConnectBulbActivity.M1(SoftAPConnectBulbActivity.this);
        }
      }
    }
  }
  
  class g
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    g() {}
    
    public void onGlobalLayout()
    {
      SoftAPConnectBulbActivity.e1(SoftAPConnectBulbActivity.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      SoftAPConnectBulbActivity.f1(SoftAPConnectBulbActivity.this);
    }
  }
  
  class h
    implements com.tplink.libtpwifi.a
  {
    h() {}
    
    public void a(String paramString)
    {
      b.d.w.c.a.d("initWifiConnectReceiver connected");
      SoftAPConnectBulbActivity.O1(SoftAPConnectBulbActivity.this, null);
      SoftAPConnectBulbActivity.v1(SoftAPConnectBulbActivity.this, false);
    }
    
    public void b(String paramString1, String paramString2)
    {
      if ((!SoftAPConnectBulbActivity.t1(SoftAPConnectBulbActivity.this)) && (!"<unknown ssid>".equals(paramString1)) && (com.tplink.iot.view.quicksetup.base.d.V(SoftAPConnectBulbActivity.G1(SoftAPConnectBulbActivity.this), paramString1)))
      {
        b.d.w.c.a.d("initWifiConnectReceiver connected");
        SoftAPConnectBulbActivity.O1(SoftAPConnectBulbActivity.this, paramString2);
        SoftAPConnectBulbActivity.v1(SoftAPConnectBulbActivity.this, true);
        SoftAPConnectBulbActivity.P1(SoftAPConnectBulbActivity.this, 49);
        SoftAPConnectBulbActivity.S1(SoftAPConnectBulbActivity.this).postDelayed(new a(), 5000L);
      }
    }
    
    public void c(String paramString)
    {
      b.d.w.c.a.d("initWifiConnectReceiver disConnected 1");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(SoftAPConnectBulbActivity.N1(SoftAPConnectBulbActivity.this))))
      {
        b.d.w.c.a.d("initWifiConnectReceiver disConnected 2");
        SoftAPConnectBulbActivity.O1(SoftAPConnectBulbActivity.this, null);
        SoftAPConnectBulbActivity.v1(SoftAPConnectBulbActivity.this, false);
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        if (SoftAPConnectBulbActivity.Q1(SoftAPConnectBulbActivity.this)) {
          return;
        }
        if (SoftAPConnectBulbActivity.t1(SoftAPConnectBulbActivity.this))
        {
          SoftAPConnectBulbActivity.R1(SoftAPConnectBulbActivity.this);
          r.y(SoftAPConnectBulbActivity.G1(SoftAPConnectBulbActivity.this));
        }
      }
    }
  }
  
  class i
    implements g<u>
  {
    i() {}
    
    public void a(u paramu)
      throws Exception
    {
      if (paramu.d())
      {
        b.d.w.c.a.d("sendTDPBroadcast 3");
        SoftAPConnectBulbActivity.U1(SoftAPConnectBulbActivity.this, paramu.a());
        SoftAPConnectBulbActivity.g1(SoftAPConnectBulbActivity.this);
      }
      else
      {
        b.d.w.c.a.d("sendTDPBroadcast 4");
        if (SoftAPConnectBulbActivity.t1(SoftAPConnectBulbActivity.this))
        {
          b.d.w.c.a.d("sendTDPBroadcast 5");
          SoftAPConnectBulbActivity.h1(SoftAPConnectBulbActivity.this, "TDP scan fail");
        }
      }
    }
  }
  
  class j
    implements Runnable
  {
    j() {}
    
    public void run()
    {
      if (SoftAPConnectBulbActivity.this.isDestroyed()) {
        return;
      }
      SoftAPConnectBulbActivity.i1(SoftAPConnectBulbActivity.this).Y();
    }
  }
  
  class k
    implements Runnable
  {
    k() {}
    
    public void run()
    {
      if (SoftAPConnectBulbActivity.Q1(SoftAPConnectBulbActivity.this)) {
        return;
      }
      SoftAPConnectBulbActivity.i1(SoftAPConnectBulbActivity.this).d0();
    }
  }
  
  class l
    implements Observer<i<QuickSetupComponentResult>>
  {
    l() {}
    
    public void a(@Nullable i<QuickSetupComponentResult> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        SoftAPConnectBulbActivity.j1(SoftAPConnectBulbActivity.this, (QuickSetupComponentResult)parami.a());
      }
      else
      {
        b.d.w.c.a.d("getQsComponentResultLiveData fail");
        SoftAPConnectBulbActivity.h1(SoftAPConnectBulbActivity.this, "get component fail");
      }
    }
  }
  
  class m
    implements Observer<i<List<WirelessScanInfoBean>>>
  {
    m() {}
    
    public void a(@Nullable i<List<WirelessScanInfoBean>> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        SoftAPConnectBulbActivity.k1(SoftAPConnectBulbActivity.this).clear();
        if (parami.a() != null) {
          SoftAPConnectBulbActivity.k1(SoftAPConnectBulbActivity.this).addAll((Collection)parami.a());
        }
        if (SoftAPConnectBulbActivity.l1(SoftAPConnectBulbActivity.this))
        {
          SoftAPConnectBulbActivity.m1(SoftAPConnectBulbActivity.this, false);
          SoftAPConnectBulbActivity.i1(SoftAPConnectBulbActivity.this).V();
        }
        else
        {
          SoftAPConnectBulbActivity.n1(SoftAPConnectBulbActivity.this);
        }
      }
      else
      {
        b.d.w.c.a.d("getWirelessScanInfoLiveData fail");
        SoftAPConnectBulbActivity.h1(SoftAPConnectBulbActivity.this, "get wireless list fail");
        r.o(SoftAPConnectBulbActivity.o1(SoftAPConnectBulbActivity.this).getDeviceType(), SoftAPConnectBulbActivity.o1(SoftAPConnectBulbActivity.this).getDeviceModel(), SoftAPConnectBulbActivity.T1(SoftAPConnectBulbActivity.this));
      }
    }
  }
  
  class n
    implements Observer<i<InheritInfoResult>>
  {
    n() {}
    
    public void a(@Nullable i<InheritInfoResult> parami)
    {
      boolean bool1 = false;
      if ((parami != null) && (parami.b() == 0))
      {
        parami = (InheritInfoResult)parami.a();
        SoftAPConnectBulbActivity localSoftAPConnectBulbActivity = SoftAPConnectBulbActivity.this;
        boolean bool2 = bool1;
        if (parami != null)
        {
          bool2 = bool1;
          if (parami.isInheritStatus()) {
            bool2 = true;
          }
        }
        SoftAPConnectBulbActivity.p1(localSoftAPConnectBulbActivity, bool2);
      }
      else
      {
        SoftAPConnectBulbActivity.p1(SoftAPConnectBulbActivity.this, false);
      }
      SoftAPConnectBulbActivity.n1(SoftAPConnectBulbActivity.this);
    }
  }
  
  class o
    implements ValueAnimator.AnimatorUpdateListener
  {
    o(RectF paramRectF, int paramInt, Canvas paramCanvas, Paint paramPaint) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramValueAnimator = localRectF;
      int i = i;
      int j = i / 12;
      int k = SoftAPConnectBulbActivity.q1(SoftAPConnectBulbActivity.this);
      int m = i;
      paramValueAnimator.top = (i - j - k * m / 8 - 3);
      localRectF.bottom = (m - SoftAPConnectBulbActivity.q1(SoftAPConnectBulbActivity.this) * i / 8 - 3);
      localCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint);
      SoftAPConnectBulbActivity.w1(SoftAPConnectBulbActivity.this).setImageBitmap(SoftAPConnectBulbActivity.u1(SoftAPConnectBulbActivity.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPConnectBulbActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */