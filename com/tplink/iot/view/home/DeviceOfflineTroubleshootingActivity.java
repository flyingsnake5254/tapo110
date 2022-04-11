package com.tplink.iot.view.home;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.feedback.DeviceTypeListActivity;
import com.tplink.iot.view.quicksetup.base.b;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.view.quicksetup.sub.common.g;
import com.tplink.iot.widget.viewgroup.LedBlinkTitleView;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class DeviceOfflineTroubleshootingActivity
  extends BaseActivity
{
  private View p0;
  private String y;
  private String z;
  
  private void f1(String paramString)
  {
    paramString = EnumDeviceType.fromType(paramString);
    switch (d.a[paramString.ordinal()])
    {
    default: 
      break;
    case 7: 
      i1();
      break;
    case 6: 
      m1();
      break;
    case 5: 
      l1();
      break;
    case 4: 
      j1();
      break;
    case 3: 
      h1();
      break;
    case 2: 
      g1();
      break;
    case 1: 
      k1();
    }
  }
  
  private void g1()
  {
    if (com.tplink.iot.g.b.c.c.i(this.y)) {
      h.a(this.p0.findViewById(2131364677), getString(2131953266));
    }
  }
  
  private void h1()
  {
    LedBlinkTitleView localLedBlinkTitleView = (LedBlinkTitleView)this.p0.findViewById(2131364356);
    if (localLedBlinkTitleView != null)
    {
      localLedBlinkTitleView.setTitleText(com.tplink.iot.view.ipcamera.base.c.g(DeviceModel.fromValue(this.y), this.z));
      localLedBlinkTitleView.setDynamicLedColor(getResources().getColor(com.tplink.iot.view.ipcamera.base.c.h(DeviceModel.fromValue(this.y), this.z)));
    }
    localLedBlinkTitleView = (LedBlinkTitleView)this.p0.findViewById(2131364357);
    if (localLedBlinkTitleView != null)
    {
      int i = com.tplink.iot.view.ipcamera.base.c.i(DeviceModel.fromValue(this.y), this.z);
      localLedBlinkTitleView.setTitleText(i);
      localLedBlinkTitleView.setStaticLedColor(getResources().getColor(2131099958));
      if (2131953249 == i) {
        localLedBlinkTitleView.c(Integer.valueOf(getResources().getColor(2131099959)), null, 0);
      }
    }
  }
  
  private void i1()
  {
    if ("E100".equals(this.y)) {
      h.a(this.p0.findViewById(2131364606), getString(2131954156, new Object[] { Integer.valueOf(5) }));
    }
  }
  
  private void j1() {}
  
  private void k1()
  {
    LedBlinkTitleView localLedBlinkTitleView = (LedBlinkTitleView)this.p0.findViewById(2131364310);
    Object localObject = (LedBlinkTitleView)this.p0.findViewById(2131364311);
    if ("P110".equals(this.y))
    {
      if (localLedBlinkTitleView != null)
      {
        localLedBlinkTitleView.setTitleText(2131953265);
        localLedBlinkTitleView.setStaticLedColor(getResources().getColor(2131099960));
      }
      if (localObject != null)
      {
        ((LedBlinkTitleView)localObject).setTitleText(2131953257);
        ((LedBlinkTitleView)localObject).setStaticLedColor(getResources().getColor(2131099959));
        ((LedBlinkTitleView)localObject).c(Integer.valueOf(getResources().getColor(2131099958)), null, 0);
      }
    }
    else if ("P115".equals(this.y))
    {
      if (localLedBlinkTitleView != null)
      {
        localLedBlinkTitleView.setTitleText(2131953265);
        localLedBlinkTitleView.setStaticLedColor(getResources().getColor(2131099960));
      }
      if (localObject != null)
      {
        ((LedBlinkTitleView)localObject).setTitleText(2131953264);
        ((LedBlinkTitleView)localObject).setStaticLedColor(getResources().getColor(2131099961));
        ((LedBlinkTitleView)localObject).c(Integer.valueOf(getResources().getColor(2131099956)), null, 0);
      }
      localLedBlinkTitleView = (LedBlinkTitleView)this.p0.findViewById(2131364579);
      localObject = this.p0.findViewById(2131364505);
      if (localLedBlinkTitleView != null)
      {
        localLedBlinkTitleView.setTitleText(2131953242);
        localLedBlinkTitleView.setDynamicLedColor(getResources().getColor(2131099956));
      }
      h.a((View)localObject, getString(2131953243));
    }
  }
  
  private void l1()
  {
    h.a((TextView)this.p0.findViewById(2131364606), g.a(SubDeviceModel.fromValue(this.y)).c());
    if ("S200B".equals(this.y))
    {
      View localView = this.p0.findViewById(2131364679);
      if (localView != null) {
        localView.setVisibility(0);
      }
      h.a(this.p0.findViewById(2131364677), getString(2131954190));
    }
  }
  
  private void m1() {}
  
  @LayoutRes
  private int n1(String paramString)
  {
    paramString = EnumDeviceType.fromType(paramString);
    switch (d.a[paramString.ordinal()])
    {
    default: 
      finish();
      return 2131559124;
    case 7: 
      return 2131559126;
    case 6: 
      return 2131559130;
    case 5: 
      return 2131559129;
    case 4: 
      return 2131559127;
    case 3: 
      return 2131559125;
    case 2: 
      return 2131559124;
    }
    return 2131559128;
  }
  
  private void o1()
  {
    b.h(this, this.y);
  }
  
  public static void p1(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, DeviceOfflineTroubleshootingActivity.class);
    localIntent.putExtra("device_type", paramString1);
    localIntent.putExtra("device_model", paramString2);
    localIntent.putExtra("device_hw_ver", paramString3);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772038, 2130771983);
  }
  
  private void q1(TextView paramTextView)
  {
    String str = getString(2131953642);
    d0.c(paramTextView, getString(2131953641, new Object[] { str }), str, ContextCompat.getColor(this, 2131099811), new c());
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130772042);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558500);
    findViewById(2131362831).setOnClickListener(new a());
    Object localObject = getIntent().getStringExtra("device_type");
    this.y = getIntent().getStringExtra("device_model");
    this.z = getIntent().getStringExtra("device_hw_ver");
    paramBundle = (ViewStub)findViewById(2131363577);
    paramBundle.setLayoutResource(n1((String)localObject));
    this.p0 = paramBundle.inflate();
    f1((String)localObject);
    q1((TextView)this.p0.findViewById(2131364588));
    localObject = (TextView)findViewById(2131364385);
    paramBundle = getString(2131953509).toUpperCase();
    d0.c((TextView)localObject, getString(2131953510, new Object[] { paramBundle }), paramBundle, ContextCompat.getColor(this, 2131099811), new b());
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      DeviceOfflineTroubleshootingActivity.this.finish();
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      DeviceOfflineTroubleshootingActivity.this.W0(DeviceTypeListActivity.class);
    }
  }
  
  class c
    implements d0.g
  {
    c() {}
    
    public void a()
    {
      DeviceOfflineTroubleshootingActivity.e1(DeviceOfflineTroubleshootingActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\DeviceOfflineTroubleshootingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */