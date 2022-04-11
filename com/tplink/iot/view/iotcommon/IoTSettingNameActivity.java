package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotcommon.IoTSettingNameViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.DrawableEditText;

public class IoTSettingNameActivity
  extends BaseActivity
  implements TextWatcher
{
  private MenuItem p0;
  private IoTSettingNameViewModel p1;
  private String p2;
  private CharSequence p3;
  private String y;
  private DrawableEditText z;
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.p3.toString().getBytes().length;
    boolean bool = true;
    if (i > 64)
    {
      paramEditable.delete(this.p3.length() - 1, this.p3.length());
      this.z.setText(paramEditable);
      this.z.setSelection(paramEditable.length());
    }
    if (this.p0 != null)
    {
      if (TextUtils.isEmpty(paramEditable.toString())) {
        bool = false;
      } else if (!TextUtils.isEmpty(this.p2)) {
        bool = true ^ this.p2.equals(paramEditable.toString());
      }
      this.p0.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558551);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = paramBundle;
    this.p1 = ((IoTSettingNameViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(IoTSettingNameViewModel.class));
    b1(2131953820);
    paramBundle = (DrawableEditText)findViewById(2131362507);
    this.z = paramBundle;
    paramBundle.m();
    this.z.f(this);
    paramBundle = this.p1.j();
    this.p2 = paramBundle;
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.z.setText(this.p2);
      this.z.setSelection(this.p2.length());
    }
    else
    {
      paramBundle = this.p1.g(this);
      l.m(this.z, paramBundle);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    this.p0 = paramMenu.findItem(2131362300);
    boolean bool;
    if ((this.z != null) && (((TextUtils.isEmpty(this.p2)) && (!TextUtils.isEmpty(this.z.getText()))) || (!TextUtils.equals(this.p2, this.z.getText().toString())))) {
      bool = true;
    } else {
      bool = false;
    }
    this.p0.setEnabled(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      paramMenuItem = this.z.getText().toString();
      this.p1.k(paramMenuItem);
      i.h(this.y, paramMenuItem);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p3 = paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTSettingNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */