package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Context;
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
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

public class BulbApNamePasswordInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPMaterialDialogV2 H3;
  private Button p0;
  private QuickSetupInfoBundle p1;
  private e p2;
  private TPMaterialDialogV2 p3;
  private DrawableEditText y;
  private DrawableEditText z;
  
  private void h1()
  {
    if (this.p1.inNeedDisplayInherit()) {
      l1();
    } else {
      r1();
    }
  }
  
  private boolean i1()
  {
    return d.g(this.y.getText().toString(), this.z.getText().toString());
  }
  
  private void j1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p1 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private WirelessInfoParams k1()
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
    return localWirelessInfoParams;
  }
  
  private void l1()
  {
    BulbInheritBeforeSetQsInfoActivity.h1(this, this.p1, k1());
  }
  
  private void m1()
  {
    SoftAPBulbConnectAPActivity.y1(this, this.p1, k1());
    r.t(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
    finish();
  }
  
  private void n1()
  {
    this.y.f(new a());
  }
  
  private void o1()
  {
    this.z.f(new b());
  }
  
  private void p1()
  {
    this.p2 = new e(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    this.y = ((DrawableEditText)findViewById(2131362510));
    this.z = ((DrawableEditText)findViewById(2131362512));
    Button localButton = (Button)findViewById(2131362037);
    this.p0 = localButton;
    localButton.setText(getString(2131952438));
    this.p0.setEnabled(false);
    this.p0.setOnClickListener(this);
    n1();
    o1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  public static void q1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, BulbApNamePasswordInputActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void r1()
  {
    if (a.f(this, this.p1)) {
      m1();
    } else {
      this.p2.d(this.p1.getBulbSSID());
    }
  }
  
  private void s1()
  {
    Object localObject = this.y.getText().toString();
    String str = this.z.getText().toString();
    View localView = LayoutInflater.from(this).inflate(2131559183, null, false);
    ((TextView)localView.findViewById(2131364644)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131364567)).setText(str);
    localObject = new TPMaterialDialogV2.Builder(this).w(localView).l(2131952391, 2131099804, null).o(2131952438, 2131099808, new d()).g(8, 8).a();
    this.H3 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  private void t1()
  {
    TPMaterialDialogV2 localTPMaterialDialogV2 = new TPMaterialDialogV2.Builder(this).h(2131953503).l(2131952391, 2131099804, null).o(2131953504, 2131099808, new c()).g(8, 8).a();
    this.p3 = localTPMaterialDialogV2;
    localTPMaterialDialogV2.show();
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
        t1();
      } else {
        s1();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558672);
    j1();
    p1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    Object localObject = this.p2;
    if (localObject != null) {
      ((e)localObject).b();
    }
    localObject = this.p3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.p3 = null;
    }
    localObject = this.H3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.H3 = null;
    }
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      BulbApNamePasswordInputActivity.f1(BulbApNamePasswordInputActivity.this).setEnabled(BulbApNamePasswordInputActivity.e1(BulbApNamePasswordInputActivity.this));
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
      BulbApNamePasswordInputActivity.f1(BulbApNamePasswordInputActivity.this).setEnabled(BulbApNamePasswordInputActivity.e1(BulbApNamePasswordInputActivity.this));
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
      BulbApNamePasswordInputActivity.g1(BulbApNamePasswordInputActivity.this);
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      BulbApNamePasswordInputActivity.g1(BulbApNamePasswordInputActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbApNamePasswordInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */