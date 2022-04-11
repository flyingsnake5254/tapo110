package com.tplink.iot.view.account;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.f.a;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.account.AccountChangeNameViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class AccountChangeNameActivity
  extends BaseActivity
  implements TextWatcher
{
  private MenuItem p0;
  private String p1;
  private AccountChangeNameViewModel p2 = null;
  private LinearLayout y;
  private DrawableEditText z;
  
  private void h1()
  {
    a.g(this);
    this.p2.i(this.z.getText().toString());
  }
  
  private boolean i1(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.p1))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void j1()
  {
    if (i1(this.z.getText().toString())) {
      l1();
    } else {
      finish();
    }
  }
  
  private void k1(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 1)
          {
            s0.g();
            s0.p(this, getString(2131951723));
          }
        }
        else
        {
          s0.g();
          finish();
        }
      }
      else {
        s0.l(this);
      }
    }
  }
  
  private void l1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131952581, 2131099840).o(2131952404, 2131099808, new c()).l(2131952391, 2131099804, null).g(8, 8).b(false).a().show();
  }
  
  private void m1()
  {
    this.p2.j().observe(this, new a());
    this.p2.k().observe(this, new b());
  }
  
  private boolean n1(CharSequence paramCharSequence)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramCharSequence)) && (!paramCharSequence.equals(this.p1))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    MenuItem localMenuItem = this.p0;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(n1(paramEditable.toString()));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onBackPressed()
  {
    j1();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558430);
    this.p2 = ((AccountChangeNameViewModel)ViewModelProviders.of(this).get(AccountChangeNameViewModel.class));
    setSupportActionBar((Toolbar)findViewById(2131364275));
    b1(2131952437);
    a1(2131689570);
    this.y = ((LinearLayout)findViewById(2131361922));
    paramBundle = (DrawableEditText)findViewById(2131362511);
    this.z = paramBundle;
    paramBundle.f(this);
    this.z.m();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    m1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623940, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362299);
    this.p0 = localMenuItem;
    localMenuItem.setEnabled(false);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i != 16908332)
    {
      if (i == 2131362299) {
        h1();
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }
    j1();
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  class a
    implements Observer<String>
  {
    a() {}
    
    public void a(@Nullable String paramString)
    {
      AccountChangeNameActivity.e1(AccountChangeNameActivity.this, paramString);
      AccountChangeNameActivity.f1(AccountChangeNameActivity.this).setText(paramString);
      Selection.setSelection(AccountChangeNameActivity.f1(AccountChangeNameActivity.this).getText(), AccountChangeNameActivity.f1(AccountChangeNameActivity.this).getText().length());
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      AccountChangeNameActivity.g1(AccountChangeNameActivity.this, paramInteger);
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      AccountChangeNameActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\account\AccountChangeNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */