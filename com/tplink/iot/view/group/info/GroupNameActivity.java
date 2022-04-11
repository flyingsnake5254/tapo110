package com.tplink.iot.view.group.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class GroupNameActivity
  extends BaseActivity
  implements TextWatcher
{
  private boolean H3 = false;
  private CharSequence I3;
  private GroupSettingViewModel p0;
  private String p1;
  private String p2;
  private String p3;
  private DrawableEditText y;
  private MenuItem z;
  
  private void f1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.p2 = localIntent.getStringExtra("group_id");
      this.p3 = localIntent.getStringExtra("group_name");
      this.H3 = (TextUtils.isEmpty(this.p2) ^ true);
    }
  }
  
  private void g1()
  {
    b1(2131953795);
    DrawableEditText localDrawableEditText = (DrawableEditText)findViewById(2131362507);
    this.y = localDrawableEditText;
    localDrawableEditText.m();
    this.y.f(this);
    if (this.H3) {
      this.p1 = this.p0.p(this.p2);
    } else {
      this.p1 = this.p3;
    }
    if (!TextUtils.isEmpty(this.p1))
    {
      this.y.setText(this.p1);
      this.y.setSelection(this.p1.length());
    }
  }
  
  public static void h1(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, GroupNameActivity.class);
    localIntent.putExtra("group_name", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void i1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupNameActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void j1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void k1()
  {
    if (this.H3) {
      m1();
    } else {
      l1();
    }
  }
  
  private void l1()
  {
    String str = this.y.getText().toString().trim();
    Intent localIntent = getIntent();
    localIntent.putExtra("group_name", str);
    setResult(-1, localIntent);
    finish();
  }
  
  private void m1()
  {
    String str = this.y.getText().toString().trim();
    s0.l(this);
    this.p0.v(this.p2, str);
  }
  
  private void n1()
  {
    this.p0.t().observe(this, new a());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.I3.toString().getBytes().length;
    boolean bool = true;
    if (i > 64)
    {
      paramEditable.delete(this.I3.length() - 1, this.I3.length());
      this.y.setText(paramEditable);
      this.y.setSelection(paramEditable.length());
    }
    if (this.z != null)
    {
      if (TextUtils.isEmpty(paramEditable.toString())) {
        bool = false;
      } else if (!TextUtils.isEmpty(this.p1)) {
        bool = true ^ this.p1.equals(paramEditable.toString());
      }
      this.z.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558533);
    f1();
    this.p0 = ((GroupSettingViewModel)ViewModelProviders.of(this).get(GroupSettingViewModel.class));
    g1();
    n1();
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
      k1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.I3 = paramCharSequence;
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        GroupNameActivity.this.finish();
      }
      else
      {
        s0.g();
        GroupNameActivity.e1(GroupNameActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\info\GroupNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */