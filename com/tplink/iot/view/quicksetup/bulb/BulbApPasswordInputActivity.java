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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import b.d.w.e.b;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

public class BulbApPasswordInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private e H3;
  private CheckBox p0;
  private QuickSetupInfoBundle p1;
  private WirelessInfoParams p2 = null;
  private TPMaterialDialogV2 p3;
  private DrawableEditText y;
  private Button z;
  
  private void h1()
  {
    if (this.p1.inNeedDisplayInherit()) {
      k1();
    } else {
      p1();
    }
  }
  
  private boolean i1(String paramString)
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
  
  private void j1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p1 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
        this.p2 = ((WirelessInfoParams)((Bundle)localObject).getSerializable("ap_ssid"));
      }
    }
  }
  
  private void k1()
  {
    r1();
    BulbInheritBeforeSetQsInfoActivity.h1(this, this.p1, this.p2);
  }
  
  private void l1()
  {
    r1();
    SoftAPBulbConnectAPActivity.y1(this, this.p1, this.p2);
    r.t(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
    finish();
  }
  
  private void m1()
  {
    this.y.f(new a());
    String str = com.tplink.libtpnetwork.Utils.o.h0().V(this.p2.getSsid());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wirelessPwd=");
    localStringBuilder.append(str);
    b.d.w.c.a.e("wireless", localStringBuilder.toString());
    if (!TextUtils.isEmpty(str))
    {
      this.y.setText(str);
      this.y.setSelection(str.length());
      this.p0.setChecked(true);
    }
  }
  
  private void n1()
  {
    this.H3 = new e(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((TextView)findViewById(2131364536)).setText(this.p2.getSsid());
    ((TextView)findViewById(2131364618)).setOnClickListener(this);
    this.p0 = ((CheckBox)findViewById(2131362212));
    Button localButton = (Button)findViewById(2131362037);
    this.z = localButton;
    localButton.setText(getString(2131952438));
    this.z.setEnabled(false);
    this.z.setOnClickListener(this);
    this.y = ((DrawableEditText)findViewById(2131362512));
    m1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  public static void o1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle, WirelessInfoParams paramWirelessInfoParams)
  {
    Intent localIntent = new Intent(paramContext, BulbApPasswordInputActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    if (paramWirelessInfoParams != null) {
      localBundle.putSerializable("ap_ssid", paramWirelessInfoParams);
    }
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void p1()
  {
    if (com.tplink.iot.view.quicksetup.bulb.utils.a.f(this, this.p1)) {
      l1();
    } else {
      this.H3.d(this.p1.getBulbSSID());
    }
  }
  
  private void q1()
  {
    Object localObject = this.p2.getSsid();
    String str = this.y.getText().toString();
    View localView = LayoutInflater.from(this).inflate(2131559183, null, false);
    ((TextView)localView.findViewById(2131364644)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131364567)).setText(str);
    localObject = new TPMaterialDialogV2.Builder(this).w(localView).l(2131952391, 2131099804, null).o(2131952438, 2131099808, new b()).g(8, 8).a();
    this.p3 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  private void r1()
  {
    String str = this.y.getText().toString();
    this.p2.setPassword(str);
    com.tplink.iot.view.quicksetup.bulb.utils.a.g(this.p0.isChecked(), this.p2);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if ((i == 2131362826) || (i == 2131364618)) {
        finish();
      }
    }
    else
    {
      d.I(this);
      q1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558673);
    j1();
    n1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    Object localObject = this.H3;
    if (localObject != null) {
      ((e)localObject).b();
    }
    localObject = this.p3;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.p3 = null;
    }
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      BulbApPasswordInputActivity.f1(BulbApPasswordInputActivity.this).setEnabled(BulbApPasswordInputActivity.e1(BulbApPasswordInputActivity.this, paramEditable.toString()));
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
      BulbApPasswordInputActivity.g1(BulbApPasswordInputActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbApPasswordInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */