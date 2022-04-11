package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.BlePlugConnectAPActivity;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

public class ApNamePasswordInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button p0;
  private QuickSetupInfoBean p1;
  private TPMaterialDialogV2 p2;
  private TPMaterialDialogV2 p3;
  private DrawableEditText y;
  private DrawableEditText z;
  
  private boolean h1()
  {
    return d.g(this.y.getText().toString(), this.z.getText().toString());
  }
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p1 = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
      }
    }
  }
  
  private void j1()
  {
    String str1 = this.y.getText().toString();
    String str2 = this.z.getText().toString();
    WirelessInfoParams localWirelessInfoParams = new WirelessInfoParams();
    localWirelessInfoParams.setSsid(str1);
    if (TextUtils.isEmpty(str2))
    {
      localWirelessInfoParams.setKeyType("none");
    }
    else
    {
      localWirelessInfoParams.setPassword(str2);
      localWirelessInfoParams.setKeyType("wpa2_psk");
    }
    d.E(this, BlePlugConnectAPActivity.class, this.p1, localWirelessInfoParams, 160);
    n1();
  }
  
  private void k1()
  {
    this.y.f(new a());
  }
  
  private void l1()
  {
    this.z.f(new b());
  }
  
  private void m1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    this.y = ((DrawableEditText)findViewById(2131362510));
    this.z = ((DrawableEditText)findViewById(2131362512));
    Button localButton = (Button)findViewById(2131362037);
    this.p0 = localButton;
    localButton.setText(getString(2131952438));
    this.p0.setEnabled(false);
    this.p0.setOnClickListener(this);
    k1();
    l1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  private void n1()
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
    if (localQuickSetupInfoBean != null) {
      r.t(localQuickSetupInfoBean.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
    }
  }
  
  private void o1()
  {
    Object localObject = this.y.getText().toString();
    String str = this.z.getText().toString();
    View localView = LayoutInflater.from(this).inflate(2131559183, null, false);
    ((TextView)localView.findViewById(2131364644)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131364567)).setText(str);
    localObject = new TPMaterialDialogV2.Builder(this).w(localView).l(2131952391, 2131099804, null).o(2131952438, 2131099808, new d()).g(8, 8).a();
    this.p3 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  private void p1()
  {
    TPMaterialDialogV2 localTPMaterialDialogV2 = new TPMaterialDialogV2.Builder(this).h(2131953503).l(2131952391, 2131099804, null).o(2131953504, 2131099808, new c()).g(8, 8).a();
    this.p2 = localTPMaterialDialogV2;
    localTPMaterialDialogV2.show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 160)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    switch (paramInt2)
    {
    default: 
      break;
    case -1703: 
      s0.r(this, getString(2131953520), 5000L);
      break;
    case -1704: 
      s0.r(this, getString(2131953508), 5000L);
      break;
    case -1705: 
      s0.r(this, getString(2131953525), 5000L);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        finish();
      }
    }
    else
    {
      d.I(this);
      if (TextUtils.isEmpty(this.z.getText().toString())) {
        p1();
      } else {
        o1();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558627);
    i1();
    m1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.p2;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p2 = null;
    }
    localTPMaterialDialogV2 = this.p3;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p3 = null;
    }
    s0.g();
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      ApNamePasswordInputActivity.f1(ApNamePasswordInputActivity.this).setEnabled(ApNamePasswordInputActivity.e1(ApNamePasswordInputActivity.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements TextWatcher
  {
    b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      ApNamePasswordInputActivity.f1(ApNamePasswordInputActivity.this).setEnabled(ApNamePasswordInputActivity.e1(ApNamePasswordInputActivity.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      ApNamePasswordInputActivity.g1(ApNamePasswordInputActivity.this);
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      ApNamePasswordInputActivity.g1(ApNamePasswordInputActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\ApNamePasswordInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */