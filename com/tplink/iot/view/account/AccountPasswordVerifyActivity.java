package com.tplink.iot.view.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import b.d.w.f.a;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.account.AccountPasswordVerifyViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class AccountPasswordVerifyActivity
  extends BaseActivity
{
  private DrawableEditText p0;
  private AccountPasswordVerifyViewModel p1;
  private LinearLayout y;
  private TPRefreshableButton z;
  
  private void j1()
  {
    this.y = ((LinearLayout)findViewById(2131361926));
    this.z = ((TPRefreshableButton)findViewById(2131363540));
    this.p0 = ((DrawableEditText)findViewById(2131361867));
    b1(2131952392);
    this.z.setEnabled(false);
    this.z.setOnClickListener(new a());
    b localb = new b();
    this.p0.f(localb);
    this.p0.m();
  }
  
  private void k1()
  {
    s0.p(this, getString(2131951710));
  }
  
  private void l1(i<CheckPasswordV1Result> parami)
  {
    if (parami == null)
    {
      a.g(this);
    }
    else
    {
      this.z.h();
      if (parami.b() == 0)
      {
        parami = (CheckPasswordV1Result)parami.a();
        if (parami != null)
        {
          int i = parami.getErrorCode();
          int j = parami.getLockedMinutes();
          if (i != 44875)
          {
            if (i != 44935)
            {
              if (i != 0) {
                k1();
              } else {
                startActivityForResult(new Intent(this, AccountChangePasswordActivity.class), 0);
              }
            }
            else
            {
              i = parami.getRemainAttempts();
              int k = parami.getFailedAttempts();
              int m = parami.getRemainAttempts() + parami.getFailedAttempts();
              if (k == m) {
                e.d(this, j, this.p1.h());
              } else if (i == 1) {
                e.e(this, i, m, j);
              } else {
                k1();
              }
            }
          }
          else {
            e.d(this, j, this.p1.h());
          }
        }
        else
        {
          k1();
        }
      }
      else
      {
        k1();
      }
    }
  }
  
  private void m1()
  {
    this.p1.i().observe(this, new c());
  }
  
  private boolean n1()
  {
    boolean bool;
    if (this.p0.getText().toString().length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      finish();
    } else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558433);
    this.p1 = ((AccountPasswordVerifyViewModel)ViewModelProviders.of(this).get(AccountPasswordVerifyViewModel.class));
    j1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    m1();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      AccountPasswordVerifyActivity.f1(AccountPasswordVerifyActivity.this).g(AccountPasswordVerifyActivity.e1(AccountPasswordVerifyActivity.this).getText().toString());
    }
  }
  
  class b
    implements TextWatcher
  {
    b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      AccountPasswordVerifyActivity.h1(AccountPasswordVerifyActivity.this).setEnabled(AccountPasswordVerifyActivity.g1(AccountPasswordVerifyActivity.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class c
    implements Observer<i<CheckPasswordV1Result>>
  {
    c() {}
    
    public void a(i<CheckPasswordV1Result> parami)
    {
      AccountPasswordVerifyActivity.i1(AccountPasswordVerifyActivity.this, parami);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\account\AccountPasswordVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */