package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.ble.b;
import com.tplink.iot.view.quicksetup.base.ble.d;
import com.tplink.iot.view.quicksetup.base.broadcast.ble.BLEStateOnReceiver;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public class BlePrepareActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout H3;
  private RelativeLayout I3;
  private TPMaterialDialogV2 J3;
  private boolean K3;
  private Handler L3;
  private boolean M3 = true;
  private BLEStateOnReceiver N3;
  private ImageView p0;
  private ImageView p1;
  private LinearLayout p2;
  private LinearLayout p3;
  private ImageView y;
  private TPCircleProgressBar z;
  
  private void A1()
  {
    BLEStateOnReceiver localBLEStateOnReceiver = this.N3;
    if (localBLEStateOnReceiver != null)
    {
      unregisterReceiver(localBLEStateOnReceiver);
      this.N3 = null;
    }
  }
  
  private void m1()
  {
    if (d.b(this)) {
      finish();
    }
  }
  
  private void n1()
  {
    boolean bool1 = d.c(this);
    boolean bool2 = d.f(this);
    if ((bool1) && (bool2)) {
      this.p3.setVisibility(8);
    } else {
      this.p3.setVisibility(0);
    }
    if (bool1)
    {
      this.H3.setVisibility(8);
    }
    else
    {
      this.H3.setVisibility(0);
      this.p0.setEnabled(true);
      this.p0.setImageResource(2131690425);
    }
    if (bool2)
    {
      this.I3.setVisibility(8);
    }
    else
    {
      this.I3.setVisibility(0);
      this.p1.setEnabled(true);
      this.p1.setImageResource(2131690425);
    }
  }
  
  private void o1()
  {
    if (d.d(this))
    {
      this.p2.setVisibility(8);
    }
    else
    {
      this.y.setEnabled(true);
      this.y.setImageResource(2131690425);
      this.p2.setVisibility(0);
    }
  }
  
  private void p1()
  {
    o1();
    if (this.K3) {
      n1();
    }
  }
  
  private void q1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("package:");
    localStringBuilder.append(getPackageName());
    startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(localStringBuilder.toString())));
  }
  
  private void r1()
  {
    this.L3 = new Handler();
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    Object localObject = (LinearLayout)findViewById(2131363259);
    this.p3 = ((LinearLayout)localObject);
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    boolean bool;
    if (i >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    this.K3 = bool;
    if (!bool) {
      j = 8;
    }
    ((LinearLayout)localObject).setVisibility(j);
    this.y = ((ImageView)findViewById(2131362827));
    localObject = (TPCircleProgressBar)findViewById(2131363711);
    this.z = ((TPCircleProgressBar)localObject);
    ((TPCircleProgressBar)localObject).setProgressBarColor(ContextCompat.getColor(this, 2131099808));
    this.p0 = ((ImageView)findViewById(2131362841));
    this.p1 = ((ImageView)findViewById(2131362845));
    this.H3 = ((RelativeLayout)findViewById(2131363894));
    this.I3 = ((RelativeLayout)findViewById(2131363377));
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.p2 = ((LinearLayout)findViewById(2131363262));
  }
  
  private void s1()
  {
    if (this.N3 == null)
    {
      BLEStateOnReceiver localBLEStateOnReceiver = new BLEStateOnReceiver();
      this.N3 = localBLEStateOnReceiver;
      localBLEStateOnReceiver.b(new d());
      registerReceiver(this.N3, BLEStateOnReceiver.a());
    }
  }
  
  private void t1()
  {
    d.g(this);
  }
  
  private void u1()
  {
    y1();
    if (this.K3)
    {
      w1();
      x1();
    }
  }
  
  private void v1(boolean paramBoolean)
  {
    if (this.z.e())
    {
      this.z.i();
      this.z.setVisibility(4);
      this.y.setVisibility(0);
    }
    if (paramBoolean)
    {
      this.y.setEnabled(false);
      this.y.setImageResource(2131690248);
    }
    else
    {
      this.y.setEnabled(true);
      this.y.setImageResource(2131690425);
    }
  }
  
  private void w1()
  {
    if (d.c(this))
    {
      this.p0.setEnabled(false);
      this.p0.setImageResource(2131690248);
    }
    else
    {
      this.p0.setEnabled(true);
      this.p0.setImageResource(2131690425);
    }
  }
  
  private void x1()
  {
    if (d.f(this))
    {
      this.p1.setEnabled(false);
      this.p1.setImageResource(2131690248);
    }
    else
    {
      this.p1.setEnabled(true);
      this.p1.setImageResource(2131690425);
    }
  }
  
  private void y1()
  {
    if (d.d(this))
    {
      this.y.setEnabled(false);
      this.y.setImageResource(2131690248);
    }
    else if (!this.z.e())
    {
      this.y.setEnabled(true);
      this.y.setImageResource(2131690425);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362845: 
      b.c(this);
      break;
    case 2131362841: 
      startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
      break;
    case 2131362827: 
      t1();
      break;
    case 2131362826: 
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558459);
    r1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.L3;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.J3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.J3 = null;
    }
    A1();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (!this.K3) {
      return;
    }
    b.a(paramInt, paramArrayOfString, paramArrayOfInt, new c());
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.M3)
    {
      this.M3 = false;
      p1();
      s1();
    }
    else
    {
      u1();
      m1();
    }
  }
  
  void z1()
  {
    Object localObject = this.J3;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this).inflate(2131559101, null, false);
    localView.findViewById(2131364572).setOnClickListener(new a());
    localView.findViewById(2131364571).setOnClickListener(new b());
    localObject = new TPMaterialDialogV2.Builder(this);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.J3 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (BlePrepareActivity.e1(BlePrepareActivity.this) != null) {
        BlePrepareActivity.e1(BlePrepareActivity.this).dismiss();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (BlePrepareActivity.e1(BlePrepareActivity.this) != null) {
        BlePrepareActivity.e1(BlePrepareActivity.this).dismiss();
      }
      BlePrepareActivity.f1(BlePrepareActivity.this);
    }
  }
  
  class c
    implements com.tplink.iot.view.quicksetup.base.ble.a
  {
    c() {}
    
    public void a()
    {
      if ((!ActivityCompat.shouldShowRequestPermissionRationale(BlePrepareActivity.this, "android.permission.ACCESS_COARSE_LOCATION")) || (!ActivityCompat.shouldShowRequestPermissionRationale(BlePrepareActivity.this, "android.permission.ACCESS_FINE_LOCATION"))) {
        BlePrepareActivity.this.z1();
      }
    }
    
    public void b()
    {
      BlePrepareActivity.g1(BlePrepareActivity.this);
      BlePrepareActivity.h1(BlePrepareActivity.this);
    }
  }
  
  class d
    implements com.tplink.iot.view.quicksetup.base.broadcast.ble.a
  {
    d() {}
    
    public void a()
    {
      BlePrepareActivity.i1(BlePrepareActivity.this, true);
      BlePrepareActivity.j1(BlePrepareActivity.this).postDelayed(new a(), 200L);
    }
    
    public void b()
    {
      BlePrepareActivity.i1(BlePrepareActivity.this, false);
    }
    
    public void c()
    {
      BlePrepareActivity.k1(BlePrepareActivity.this).setVisibility(8);
      BlePrepareActivity.l1(BlePrepareActivity.this).setVisibility(0);
      BlePrepareActivity.l1(BlePrepareActivity.this).h();
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        if ((!BlePrepareActivity.this.isDestroyed()) && (!BlePrepareActivity.this.isFinishing())) {
          BlePrepareActivity.h1(BlePrepareActivity.this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BlePrepareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */