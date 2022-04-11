package com.tplink.iot.view.quicksetup.ble;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.a;
import com.tplink.iot.view.quicksetup.base.c;

public class BleAddPlugActivity
  extends BaseActivity
  implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback
{
  private boolean H3 = true;
  private ValueAnimator I3;
  private boolean J3;
  private boolean K3;
  private ValueAnimator L3;
  private boolean M3;
  private boolean N3;
  private TPMaterialDialogV2 O3;
  private long P3;
  private View p0;
  private ImageView p1;
  private ImageView p2;
  private String p3;
  private TPMaterialDialogV2 y;
  private View z;
  
  private void A1()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
    this.I3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new c());
    this.I3.addListener(new d());
    this.I3.setRepeatCount(-1);
    this.I3.setRepeatMode(2);
    this.I3.start();
  }
  
  private void B1()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
    this.L3 = localValueAnimator;
    localValueAnimator.addUpdateListener(new e());
    this.L3.addListener(new f());
    this.L3.setRepeatCount(-1);
    this.L3.setRepeatMode(2);
    this.L3.start();
  }
  
  public static void C1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, BleAddPlugActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void D1()
  {
    com.tplink.iot.view.quicksetup.base.ble.d.g(this);
  }
  
  private void F1()
  {
    this.H3 = true;
    this.z.setVisibility(0);
    this.p0.setVisibility(8);
    A1();
    v1();
  }
  
  private void G1()
  {
    this.H3 = false;
    this.z.setVisibility(8);
    this.p0.setVisibility(0);
    B1();
    u1();
  }
  
  private void H1()
  {
    if (this.y == null)
    {
      TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
      localBuilder.j(getString(2131953615));
      localBuilder.o(2131952441, 2131099808, null);
      localBuilder.c(false);
      localBuilder.b(false);
      localBuilder.g(8, 8);
      this.y = localBuilder.a();
    }
    this.y.show();
  }
  
  private void t1()
  {
    if (this.H3) {
      finish();
    } else {
      F1();
    }
  }
  
  private void u1()
  {
    ValueAnimator localValueAnimator = this.I3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.I3.cancel();
      this.I3 = null;
    }
  }
  
  private void v1()
  {
    ValueAnimator localValueAnimator = this.L3;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.L3.cancel();
      this.L3 = null;
    }
  }
  
  private void w1()
  {
    if (!com.tplink.iot.view.quicksetup.base.ble.d.d(this))
    {
      E1();
      return;
    }
    if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
      y1();
    } else {
      startActivityForResult(new Intent(this, LocationAllowActivity.class), 500);
    }
  }
  
  private void x1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p3 = ((Bundle)localObject).getString("device_model");
      }
    }
  }
  
  private void y1()
  {
    BleConnectPlugActivity.p2(this, this.p3, this.P3);
    finish();
  }
  
  private void z1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    this.z = findViewById(2131363175);
    this.p0 = findViewById(2131363195);
    ((Button)findViewById(2131362037)).setOnClickListener(new a());
    ((ImageView)findViewById(2131362836)).setImageResource(c.F(this.p3));
    ((ImageView)findViewById(2131362847)).setImageResource(c.Q(this.p3));
    this.p1 = ((ImageView)findViewById(2131362839));
    this.p2 = ((ImageView)findViewById(2131362840));
    d0.h((TextView)findViewById(2131364354), getString(2131953570), ContextCompat.getColor(this, 2131099811), new b());
    F1();
    if (com.tplink.iot.view.quicksetup.base.d.U(this)) {
      H1();
    }
  }
  
  void E1()
  {
    Object localObject = this.O3;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this).inflate(2131559102, null, false);
    localView.findViewById(2131364572).setOnClickListener(new g());
    localView.findViewById(2131364571).setOnClickListener(new h());
    localObject = new TPMaterialDialogV2.Builder(this);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.O3 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 500) && (paramInt2 == -1))
    {
      y1();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    t1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      t1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558436);
    x1();
    z1();
    this.P3 = System.currentTimeMillis();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (o.a() == 0) {
      return;
    }
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.y;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.y = null;
    }
    localTPMaterialDialogV2 = this.O3;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.O3 = null;
    }
    u1();
    v1();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  class a
    extends a
  {
    a() {}
    
    public void a(View paramView)
    {
      BleAddPlugActivity.e1(BleAddPlugActivity.this);
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      BleAddPlugActivity.f1(BleAddPlugActivity.this);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BleAddPlugActivity.h1(BleAddPlugActivity.this).setAlpha(f);
    }
  }
  
  class d
    implements Animator.AnimatorListener
  {
    d() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (BleAddPlugActivity.k1(BleAddPlugActivity.this))
      {
        paramAnimator = BleAddPlugActivity.this;
        BleAddPlugActivity.j1(paramAnimator, BleAddPlugActivity.i1(paramAnimator) ^ true);
      }
      paramAnimator = BleAddPlugActivity.h1(BleAddPlugActivity.this);
      int i;
      if (BleAddPlugActivity.i1(BleAddPlugActivity.this)) {
        i = c.B(BleAddPlugActivity.m1(BleAddPlugActivity.this));
      } else {
        i = c.I(BleAddPlugActivity.m1(BleAddPlugActivity.this));
      }
      paramAnimator.setImageResource(i);
      paramAnimator = BleAddPlugActivity.this;
      BleAddPlugActivity.l1(paramAnimator, BleAddPlugActivity.k1(paramAnimator) ^ true);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BleAddPlugActivity.j1(BleAddPlugActivity.this, false);
      BleAddPlugActivity.l1(BleAddPlugActivity.this, false);
      BleAddPlugActivity.h1(BleAddPlugActivity.this).setImageResource(c.I(BleAddPlugActivity.m1(BleAddPlugActivity.this)));
    }
  }
  
  class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BleAddPlugActivity.n1(BleAddPlugActivity.this).setAlpha(f);
    }
  }
  
  class f
    implements Animator.AnimatorListener
  {
    f() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (BleAddPlugActivity.q1(BleAddPlugActivity.this))
      {
        paramAnimator = BleAddPlugActivity.this;
        BleAddPlugActivity.p1(paramAnimator, BleAddPlugActivity.o1(paramAnimator) ^ true);
      }
      paramAnimator = BleAddPlugActivity.n1(BleAddPlugActivity.this);
      int i;
      if (BleAddPlugActivity.o1(BleAddPlugActivity.this)) {
        i = c.P(BleAddPlugActivity.m1(BleAddPlugActivity.this));
      } else {
        i = c.R(BleAddPlugActivity.m1(BleAddPlugActivity.this));
      }
      paramAnimator.setImageResource(i);
      paramAnimator = BleAddPlugActivity.this;
      BleAddPlugActivity.r1(paramAnimator, BleAddPlugActivity.q1(paramAnimator) ^ true);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BleAddPlugActivity.p1(BleAddPlugActivity.this, false);
      BleAddPlugActivity.r1(BleAddPlugActivity.this, false);
      BleAddPlugActivity.n1(BleAddPlugActivity.this).setImageResource(c.R(BleAddPlugActivity.m1(BleAddPlugActivity.this)));
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      if (BleAddPlugActivity.s1(BleAddPlugActivity.this) != null) {
        BleAddPlugActivity.s1(BleAddPlugActivity.this).dismiss();
      }
    }
  }
  
  class h
    implements View.OnClickListener
  {
    h() {}
    
    public void onClick(View paramView)
    {
      if (BleAddPlugActivity.s1(BleAddPlugActivity.this) != null) {
        BleAddPlugActivity.s1(BleAddPlugActivity.this).dismiss();
      }
      BleAddPlugActivity.g1(BleAddPlugActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BleAddPlugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */