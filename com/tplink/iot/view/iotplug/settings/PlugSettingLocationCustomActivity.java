package com.tplink.iot.view.iotplug.settings;

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
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.DrawableEditText;

public class PlugSettingLocationCustomActivity
  extends BaseActivity
  implements TextWatcher
{
  private CharSequence p0;
  private String p1;
  private DrawableEditText y;
  private MenuItem z;
  
  private void e1(String paramString)
  {
    Intent localIntent = new Intent(this, PlugSettingLocationActivity.class);
    localIntent.putExtra("custom_location", paramString);
    setResult(1, localIntent);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.p0.toString().getBytes().length;
    boolean bool = true;
    if (i > 64)
    {
      paramEditable.delete(this.p0.length() - 1, this.p0.length());
      this.y.setText(paramEditable);
      this.y.setSelection(paramEditable.length());
    }
    MenuItem localMenuItem = this.z;
    if (localMenuItem != null)
    {
      if ((TextUtils.isEmpty(paramEditable)) || (paramEditable.toString().equals(this.p1))) {
        bool = false;
      }
      localMenuItem.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558611);
    this.p1 = getIntent().getStringExtra("old_custom_location");
    paramBundle = (DrawableEditText)findViewById(2131362506);
    this.y = paramBundle;
    paramBundle.f(this);
    this.y.m();
    c1(getString(2131952474));
    if (!TextUtils.isEmpty(this.p1)) {
      l.m(this.y, this.p1);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    this.z = paramMenu.findItem(2131362300);
    boolean bool;
    if ((this.y != null) && (((TextUtils.isEmpty(this.p1)) && (!TextUtils.isEmpty(this.y.getText()))) || (!TextUtils.equals(this.p1, this.y.getText().toString())))) {
      bool = true;
    } else {
      bool = false;
    }
    this.z.setEnabled(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      e1(this.y.getText().toString());
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p0 = paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\PlugSettingLocationCustomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */