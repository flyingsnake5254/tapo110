package com.tplink.iot.view.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.account.AccountChangePasswordViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.PassWordEditText;
import com.tplink.iot.widget.PassWordEditText.d;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class AccountChangePasswordActivity
  extends BaseActivity
{
  private PassWordEditText p0 = null;
  private PassWordEditText p1 = null;
  private AccountChangePasswordViewModel p2 = null;
  private LinearLayout y = null;
  private TPRefreshableButton z = null;
  
  private void i1()
  {
    if (p1())
    {
      this.p2.m(this.p0.getText().toString());
    }
    else
    {
      this.z.h();
      s0.p(this, getString(2131951711));
    }
  }
  
  private void j1()
  {
    b1(2131952392);
    this.y = ((LinearLayout)findViewById(2131361851));
    this.p0 = ((PassWordEditText)findViewById(2131361924));
    this.p1 = ((PassWordEditText)findViewById(2131361923));
    TPRefreshableButton localTPRefreshableButton = (TPRefreshableButton)findViewById(2131363540);
    this.z = localTPRefreshableButton;
    localTPRefreshableButton.setEnabled(false);
    this.p0.m();
    b.d.w.f.a.j(this);
    this.p0.setOnTextChangeListener(new a());
    this.p1.setOnTextChangeListener(new b());
    this.p1.setOnFocusChangeListener(new a(this));
    this.z.setOnClickListener(new c());
  }
  
  private void m1(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      this.z.h();
      if (paramInteger.intValue() != 0) {
        s0.p(this, getString(2131952444));
      } else {
        startActivityForResult(new Intent(this, AccountPasswordChangedActivity.class), 0);
      }
    }
  }
  
  private void n1()
  {
    this.p2.l().observe(this, new d());
  }
  
  private boolean o1(String paramString)
  {
    return f0.e(paramString);
  }
  
  private boolean p1()
  {
    boolean bool;
    if ((o1(this.p0.getText().toString())) && (o1(this.p1.getText().toString())) && (q1())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean q1()
  {
    return this.p0.getText().toString().equals(this.p1.getText().toString());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1);
      finish();
    }
    else
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558431);
    this.p2 = ((AccountChangePasswordViewModel)ViewModelProviders.of(this).get(AccountChangePasswordViewModel.class));
    j1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    n1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() != 16908332) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    b.d.w.f.a.g(this);
    finish();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  class a
    implements PassWordEditText.d
  {
    a() {}
    
    public void i0(String paramString)
    {
      AccountChangePasswordActivity.f1(AccountChangePasswordActivity.this).setEnabled(AccountChangePasswordActivity.e1(AccountChangePasswordActivity.this));
    }
  }
  
  class b
    implements PassWordEditText.d
  {
    b() {}
    
    public void i0(String paramString)
    {
      AccountChangePasswordActivity.f1(AccountChangePasswordActivity.this).setEnabled(AccountChangePasswordActivity.e1(AccountChangePasswordActivity.this));
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      b.d.w.f.a.g(AccountChangePasswordActivity.this);
      AccountChangePasswordActivity.g1(AccountChangePasswordActivity.this);
    }
  }
  
  class d
    implements Observer<Integer>
  {
    d() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      AccountChangePasswordActivity.h1(AccountChangePasswordActivity.this, paramInteger);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\account\AccountChangePasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */