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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import b.d.w.e.b;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.BlePlugConnectAPActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

public class ApPasswordInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CheckBox p0;
  private TPMaterialDialogV2 p1;
  private QuickSetupInfoBean p2;
  private WirelessInfoParams p3 = null;
  private DrawableEditText y;
  private Button z;
  
  private boolean h1(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 8))
    {
      if (paramString.length() > 64) {
        return false;
      }
      return b.b(paramString);
    }
    return false;
  }
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p2 = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.p3 = ((WirelessInfoParams)((Bundle)localObject).getSerializable("ap_ssid"));
      }
    }
  }
  
  private void j1()
  {
    String str = this.y.getText().toString();
    this.p3.setPassword(str);
    a.g(this.p0.isChecked(), this.p3);
    d.E(this, BlePlugConnectAPActivity.class, this.p2, this.p3, 160);
    m1();
  }
  
  private void k1()
  {
    this.y.f(new a());
    String str = com.tplink.libtpnetwork.Utils.o.h0().V(this.p3.getSsid());
    if (!TextUtils.isEmpty(str))
    {
      this.y.setText(str);
      this.y.setSelection(str.length());
      this.p0.setChecked(true);
    }
  }
  
  private void l1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((TextView)findViewById(2131364536)).setText(this.p3.getSsid());
    ((TextView)findViewById(2131364618)).setOnClickListener(this);
    this.p0 = ((CheckBox)findViewById(2131362212));
    Button localButton = (Button)findViewById(2131362037);
    this.z = localButton;
    localButton.setText(getString(2131952438));
    this.z.setEnabled(false);
    this.z.setOnClickListener(this);
    this.y = ((DrawableEditText)findViewById(2131362512));
    k1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  private void m1()
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.p2;
    if (localQuickSetupInfoBean != null) {
      r.t(localQuickSetupInfoBean.getDeviceType(), this.p2.getDeviceModel(), this.p2.getDeviceIdMD5());
    }
  }
  
  private void n1()
  {
    String str = this.p3.getSsid();
    Object localObject = this.y.getText().toString();
    View localView = LayoutInflater.from(this).inflate(2131559183, null, false);
    ((TextView)localView.findViewById(2131364644)).setText(str);
    ((TextView)localView.findViewById(2131364567)).setText((CharSequence)localObject);
    localObject = new TPMaterialDialogV2.Builder(this).w(localView).l(2131952391, 2131099804, null).o(2131952438, 2131099808, new b()).g(8, 8).a();
    this.p1 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
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
      if (i != 2131362826)
      {
        if (i == 2131364618) {
          finish();
        }
      }
      else {
        finish();
      }
    }
    else
    {
      d.I(this);
      n1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558631);
    i1();
    l1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.p1;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p1 = null;
    }
    s0.g();
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      ApPasswordInputActivity.f1(ApPasswordInputActivity.this).setEnabled(ApPasswordInputActivity.e1(ApPasswordInputActivity.this, paramEditable.toString()));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      ApPasswordInputActivity.g1(ApPasswordInputActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\ApPasswordInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */