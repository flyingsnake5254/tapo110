package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import b.d.w.h.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;

public class PlugLocationCustomActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupDeviceInfoBean p0;
  private CharSequence p1;
  private DrawableEditText y;
  private QuickSetupInfoBean z;
  
  private void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.z = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.p0 = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void i1()
  {
    String str = this.y.getText().toString();
    this.p0.setLocation(a.b(str));
    d.C(this, PlugIconSelectActivity.class, this.z, this.p0);
  }
  
  private void j1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    final Button localButton = (Button)findViewById(2131362037);
    localButton.setText(getString(2131952438));
    localButton.setOnClickListener(this);
    localButton.setEnabled(false);
    DrawableEditText localDrawableEditText = (DrawableEditText)findViewById(2131362493);
    this.y = localDrawableEditText;
    localDrawableEditText.f(new a(localButton));
    this.y.getEditText().requestFocus();
    this.y.getEditText().setFocusable(true);
    this.y.getEditText().setFocusableInTouchMode(true);
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
    else {
      i1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558628);
    h1();
    j1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
  }
  
  class a
    implements TextWatcher
  {
    a(Button paramButton) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().getBytes().length > 64)
      {
        paramEditable.delete(PlugLocationCustomActivity.e1(PlugLocationCustomActivity.this).length() - 1, PlugLocationCustomActivity.e1(PlugLocationCustomActivity.this).length());
        PlugLocationCustomActivity.g1(PlugLocationCustomActivity.this).setText(paramEditable);
        PlugLocationCustomActivity.g1(PlugLocationCustomActivity.this).setSelection(paramEditable.length());
      }
      localButton.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      PlugLocationCustomActivity.f1(PlugLocationCustomActivity.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\PlugLocationCustomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */