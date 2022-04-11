package com.tplink.iot.view.colorbulb.effect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.DrawableEditText;

public class LightEffectNameEditActivity
  extends BaseActivity
  implements TextWatcher
{
  private String p0;
  private CharSequence p1;
  private MenuItem y;
  private DrawableEditText z;
  
  public static void e1(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, LightEffectNameEditActivity.class);
    localIntent.putExtra("effect_old_name", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.p1.toString().getBytes().length;
    boolean bool = true;
    if (i > 64)
    {
      paramEditable.delete(this.p1.length() - 1, this.p1.length());
      this.z.setText(paramEditable);
      this.z.setSelection(paramEditable.length());
    }
    if (this.y != null)
    {
      if (TextUtils.isEmpty(paramEditable.toString())) {
        bool = false;
      } else if (!TextUtils.isEmpty(this.p0)) {
        bool = true ^ this.p0.equals(paramEditable.toString());
      }
      this.y.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558561);
    b1(2131953711);
    this.p0 = getIntent().getStringExtra("effect_old_name");
    paramBundle = (DrawableEditText)findViewById(2131362510);
    this.z = paramBundle;
    paramBundle.m();
    this.z.f(this);
    if (!TextUtils.isEmpty(this.p0))
    {
      this.z.setText(this.p0);
      this.z.setSelection(this.p0.length());
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623954, paramMenu);
    this.y = paramMenu.findItem(2131361892);
    boolean bool;
    if ((this.z != null) && (((TextUtils.isEmpty(this.p0)) && (!TextUtils.isEmpty(this.z.getText()))) || (!TextUtils.equals(this.p0, this.z.getText().toString())))) {
      bool = true;
    } else {
      bool = false;
    }
    this.y.setEnabled(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361892)
    {
      String str = this.z.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("name", str);
      setResult(-1, localIntent);
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p1 = paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\effect\LightEffectNameEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */