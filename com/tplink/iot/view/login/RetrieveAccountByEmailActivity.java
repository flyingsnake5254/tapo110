package com.tplink.iot.view.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.f.a;
import b.d.w.h.b;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.signup.SignUpByEmailActivity;
import com.tplink.iot.view.signup.SignUpCheckMailboxActivity;
import com.tplink.iot.viewmodel.login.RetrieveAccountViewModel;
import com.tplink.iot.viewmodel.signup.SignUpCheckViewModel;
import com.tplink.iot.widget.DrawableEditText;
import java.util.Arrays;
import java.util.List;

public class RetrieveAccountByEmailActivity
  extends BaseActivity
{
  @BindView
  DrawableEditText mResetEmailEt;
  @BindView
  Button mResetPwdButton;
  private RetrieveAccountViewModel y = null;
  private SignUpCheckViewModel z = null;
  
  private void h1()
  {
    Intent localIntent = new Intent(this, SignUpCheckMailboxActivity.class);
    localIntent.putExtra("SignUpEmail", this.mResetEmailEt.getText().toString().trim());
    localIntent.putExtra("EmailType", 1);
    localIntent.putExtra("IntoType", 6);
    localIntent.addFlags(33554432);
    startActivity(localIntent);
  }
  
  private void i1()
  {
    Intent localIntent = new Intent(this, SignUpCheckMailboxActivity.class);
    localIntent.putExtra("SignUpEmail", this.mResetEmailEt.getText().toString().trim());
    localIntent.putExtra("EmailType", 2);
    localIntent.addFlags(33554432);
    startActivity(localIntent);
    finish();
  }
  
  private void j1()
  {
    Object localObject = Arrays.asList(getResources().getStringArray(2130903043));
    this.mResetEmailEt.setEmailList((List)localObject);
    this.mResetPwdButton.setEnabled(false);
    this.mResetEmailEt.setFocusable(true);
    this.mResetEmailEt.requestFocus();
    a.j(this);
    if (getIntent() != null)
    {
      localObject = getIntent().getStringExtra("ResetAccountMail");
      if (localObject != null)
      {
        this.mResetEmailEt.setText((CharSequence)localObject);
        Selection.setSelection(this.mResetEmailEt.getText(), this.mResetEmailEt.getText().length());
      }
    }
    this.mResetEmailEt.m();
  }
  
  private void k1()
  {
    TSnackbar.x(this, 2131952078, -1).F(2131953652, new d()).I(getResources().getColor(2131099808)).N();
  }
  
  private void l1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131952612, 2131099799).o(2131952386, 2131099808, new c()).l(2131952391, 2131099804, null).b(false).c(false).g(8, 8).y();
  }
  
  private void m1(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      s0.m(this, getString(2131952466));
      return;
    }
    s0.g();
    int i = paramInteger.intValue();
    if (i != 45336) {
      switch (i)
      {
      default: 
        s0.p(this, getString(2131951708));
        break;
      case 19: 
        l1();
        break;
      case 18: 
        k1();
        break;
      case 16: 
      case 17: 
        this.y.h(this.mResetEmailEt.getText().toString().trim());
        break;
      }
    } else {
      s0.p(this, getString(2131951729));
    }
  }
  
  private void n1(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      s0.m(this, getString(2131952466));
    }
    else
    {
      s0.g();
      int i = paramInteger.intValue();
      if (i != 44534)
      {
        if (i != 44936)
        {
          if (i != 45336)
          {
            if (i != 0) {
              s0.p(this, getString(2131952444));
            } else {
              i1();
            }
          }
          else {
            s0.p(this, getString(2131951729));
          }
        }
        else {
          k1();
        }
      }
      else {
        e.f(this);
      }
    }
  }
  
  private void o1()
  {
    this.y.g().observe(this, new a());
    this.z.i().observe(this, new b());
  }
  
  private void p1()
  {
    if (TextUtils.isEmpty(this.mResetEmailEt.getText().toString())) {
      this.mResetPwdButton.setEnabled(false);
    } else if (!b.c(this.mResetEmailEt.getText().toString())) {
      this.mResetPwdButton.setEnabled(false);
    } else {
      this.mResetPwdButton.setEnabled(true);
    }
  }
  
  @OnTextChanged
  void EditTextChanged()
  {
    if (f0.c(this.mResetEmailEt.getText().toString())) {
      this.mResetEmailEt.setErrorText(2131951720);
    } else {
      this.mResetEmailEt.setErrorText(null);
    }
    p1();
  }
  
  @OnClick
  void onContainerClicked()
  {
    a.g(this);
    this.mResetEmailEt.clearFocus();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558633);
    ButterKnife.a(this);
    this.y = ((RetrieveAccountViewModel)ViewModelProviders.of(this).get(RetrieveAccountViewModel.class));
    this.z = ((SignUpCheckViewModel)ViewModelProviders.of(this).get(SignUpCheckViewModel.class));
    j1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    o1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      a.g(this);
      finish();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  @OnFocusChange
  void onResetEmailFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mResetEmailEt.setErrorText(null);
    } else if ((!this.mResetEmailEt.getText().toString().isEmpty()) && (!b.c(this.mResetEmailEt.getText().toString()))) {
      this.mResetEmailEt.setErrorText(2131951720);
    }
  }
  
  @OnClick
  void resetPwd()
  {
    a.g(this);
    this.z.h(this.mResetEmailEt.getText().toString().trim());
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      RetrieveAccountByEmailActivity.e1(RetrieveAccountByEmailActivity.this, paramInteger);
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      RetrieveAccountByEmailActivity.f1(RetrieveAccountByEmailActivity.this, paramInteger);
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      RetrieveAccountByEmailActivity.g1(RetrieveAccountByEmailActivity.this);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      paramView = new Intent(RetrieveAccountByEmailActivity.this, SignUpByEmailActivity.class);
      paramView.putExtra("SignUpEmail", RetrieveAccountByEmailActivity.this.mResetEmailEt.getText().toString().trim());
      RetrieveAccountByEmailActivity.this.startActivity(paramView);
      RetrieveAccountByEmailActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\RetrieveAccountByEmailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */