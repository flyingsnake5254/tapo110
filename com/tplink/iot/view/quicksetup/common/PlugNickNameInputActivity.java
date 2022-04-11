package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.PlugIoTLocationCustomActivity;
import com.tplink.iot.view.quicksetup.ble.PlugIoTLocationSelectActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

public class PlugNickNameInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBean p0;
  private CharSequence p1;
  private QuickSetupViewModel p2;
  private DrawableEditText y;
  private Button z;
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p0 = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
      }
    }
  }
  
  private void j1()
  {
    String str = this.y.getText().toString();
    QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean();
    localQuickSetupDeviceInfoBean.setNickname(str);
    if (d.W(this.p0)) {
      k1(localQuickSetupDeviceInfoBean);
    } else {
      l1(localQuickSetupDeviceInfoBean);
    }
    o1(str);
  }
  
  private void k1(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    List localList = this.p2.Z();
    if ((localList != null) && (!localList.isEmpty())) {
      d.C(this, PlugIoTLocationSelectActivity.class, this.p0, paramQuickSetupDeviceInfoBean);
    } else {
      d.C(this, PlugIoTLocationCustomActivity.class, this.p0, paramQuickSetupDeviceInfoBean);
    }
  }
  
  private void l1(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    d.C(this, PlugLocationSelectActivity.class, this.p0, paramQuickSetupDeviceInfoBean);
  }
  
  private void m1()
  {
    this.y.f(new a());
  }
  
  private void n1()
  {
    Button localButton = (Button)findViewById(2131362037);
    this.z = localButton;
    localButton.setText(getString(2131952438));
    this.z.setEnabled(true);
    this.z.setOnClickListener(this);
    this.y = ((DrawableEditText)findViewById(2131362492));
    m1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  private void o1(String paramString)
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.p0;
    if (localQuickSetupInfoBean != null) {
      r.k(localQuickSetupInfoBean.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5(), paramString);
    }
  }
  
  public static void p1(Context paramContext, QuickSetupInfoBean paramQuickSetupInfoBean)
  {
    Intent localIntent = new Intent(paramContext, PlugNickNameInputActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      j1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    i1();
    if (d.L(this.p0))
    {
      paramBundle = this.p0;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = paramBundle.getDeviceIdMD5();
      }
      this.p2 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    }
    setContentView(2131558630);
    n1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().getBytes().length > 64)
      {
        paramEditable.delete(PlugNickNameInputActivity.e1(PlugNickNameInputActivity.this).length() - 1, PlugNickNameInputActivity.e1(PlugNickNameInputActivity.this).length());
        PlugNickNameInputActivity.g1(PlugNickNameInputActivity.this).setText(paramEditable);
        PlugNickNameInputActivity.g1(PlugNickNameInputActivity.this).setSelection(paramEditable.length());
      }
      PlugNickNameInputActivity.h1(PlugNickNameInputActivity.this).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      PlugNickNameInputActivity.f1(PlugNickNameInputActivity.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\PlugNickNameInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */