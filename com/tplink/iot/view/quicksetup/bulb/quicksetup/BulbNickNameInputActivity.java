package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

public class BulbNickNameInputActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBundle p0;
  private CharSequence p1;
  private BulbQuickSetupViewModel p2;
  private DrawableEditText y;
  private Button z;
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p0 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void j1()
  {
    String str = this.y.getText().toString();
    QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean();
    localQuickSetupDeviceInfoBean.setNickname(str);
    List localList = this.p2.R();
    if ((localList != null) && (!localList.isEmpty())) {
      a.b(this, BulbLocationSelectActivity.class, this.p0, localQuickSetupDeviceInfoBean);
    } else {
      a.b(this, BulbLocationCustomActivity.class, this.p0, localQuickSetupDeviceInfoBean);
    }
    r.k(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5(), str);
  }
  
  private void k1()
  {
    this.y.f(new a());
  }
  
  private void l1()
  {
    Object localObject = (Button)findViewById(2131362037);
    this.z = ((Button)localObject);
    ((Button)localObject).setText(getString(2131952438));
    this.z.setEnabled(true);
    this.z.setOnClickListener(this);
    localObject = (DrawableEditText)findViewById(2131362492);
    this.y = ((DrawableEditText)localObject);
    ((DrawableEditText)localObject).setText(b.j(this.p0.getDeviceModel()));
    k1();
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
  }
  
  public static void m1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, BulbNickNameInputActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
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
    setContentView(2131558620);
    paramBundle = this.p0;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    paramBundle = (BulbQuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbQuickSetupViewModel.class);
    this.p2 = paramBundle;
    paramBundle.B0(this.p0.getDeviceModel());
    l1();
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
        paramEditable.delete(BulbNickNameInputActivity.e1(BulbNickNameInputActivity.this).length() - 1, BulbNickNameInputActivity.e1(BulbNickNameInputActivity.this).length());
        BulbNickNameInputActivity.g1(BulbNickNameInputActivity.this).setText(paramEditable);
        BulbNickNameInputActivity.g1(BulbNickNameInputActivity.this).setSelection(paramEditable.length());
      }
      BulbNickNameInputActivity.h1(BulbNickNameInputActivity.this).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      BulbNickNameInputActivity.f1(BulbNickNameInputActivity.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\quicksetup\BulbNickNameInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */