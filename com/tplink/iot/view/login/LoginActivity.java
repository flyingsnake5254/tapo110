package com.tplink.iot.view.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.f;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.about.c;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.about.AboutWebActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.signup.SignUpByEmailActivity;
import com.tplink.iot.view.signup.SignUpCheckMailboxActivity;
import com.tplink.iot.viewmodel.login.LoginViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;

public class LoginActivity
  extends BaseActivity
  implements TextWatcher
{
  @BindView
  DrawableEditText mAccountEmailEditText;
  @BindView
  DrawableEditText mAccountPasswordEditText;
  @BindView
  CheckBox mCbRememberMe;
  @BindView
  TextView mIncorrectInfoTv;
  @BindView
  TextView mLoginBtnTextview;
  @BindView
  TextView mLoginForgetTextview;
  @BindView
  TextView mSignUpTextview;
  private boolean p0 = false;
  private String p1 = "";
  private String p2 = "";
  private LoginViewModel p3 = null;
  private View y;
  private TPMaterialDialogV3 z;
  
  private void A1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131951727, 2131099799).o(2131952441, 2131099808, null).b(false).c(false).g(8, 8).y();
  }
  
  private void B1()
  {
    this.p3.j().observe(this, new a());
    this.p3.k().observe(this, new b());
  }
  
  private boolean C1()
  {
    boolean bool;
    if (this.mAccountEmailEditText.getText().toString().length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean D1()
  {
    boolean bool;
    if ((C1()) && (E1())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean E1()
  {
    boolean bool;
    if (this.mAccountPasswordEditText.getText().toString().length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void m1(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("SignUpE_pwd_error")) && (paramIntent.getBooleanExtra("SignUpE_pwd_error", false))) {
      A1();
    }
  }
  
  private String n1()
  {
    String str;
    if (C1()) {
      str = this.mAccountEmailEditText.getText().toString().trim();
    } else {
      str = "";
    }
    return str;
  }
  
  private String o1()
  {
    return this.mAccountEmailEditText.getText().toString().trim();
  }
  
  private void p1()
  {
    Intent localIntent = new Intent(this, AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131951657));
    localIntent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
    startActivity(localIntent);
    overridePendingTransition(2130772068, 2130772067);
  }
  
  private void q1()
  {
    Intent localIntent = new Intent(this, SignUpCheckMailboxActivity.class);
    localIntent.putExtra("SignUpEmail", this.mAccountEmailEditText.getText().toString().trim());
    localIntent.putExtra("SignUpPassword", this.mAccountPasswordEditText.getText().toString());
    localIntent.putExtra("EmailType", 1);
    localIntent.putExtra("IntoType", 5);
    startActivity(localIntent);
  }
  
  private void r1()
  {
    Intent localIntent = new Intent(this, AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131951659));
    localIntent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
    startActivity(localIntent);
    overridePendingTransition(2130772068, 2130772067);
  }
  
  private void s1()
  {
    Intent localIntent = new Intent(this, AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131952069));
    localIntent.putExtra("url", d.g());
    startActivity(localIntent);
    overridePendingTransition(2130772068, 2130772067);
  }
  
  private void t1(i<LoginV1Result> parami)
  {
    if (parami == null)
    {
      s0.l(this);
    }
    else
    {
      s0.g();
      if ((parami.b() == 0) && (parami.a() != null))
      {
        parami = (LoginV1Result)parami.a();
        int i = parami.getErrorCode();
        int j = parami.getLockedMinutes();
        if (i != 42533)
        {
          if (i != 44875)
          {
            if ((i != 44921) && (i != 45336))
            {
              if (i != 0)
              {
                switch (i)
                {
                default: 
                  s0.p(this, getString(2131951723));
                  break;
                case -20600: 
                  v1();
                  break;
                case -20601: 
                  i = parami.getFailedAttempts();
                  int k = parami.getRemainAttempts();
                  int m = parami.getRemainAttempts() + parami.getFailedAttempts();
                  if (i == m) {
                    e.d(this, j, n1());
                  } else if (k == 1) {
                    e.e(this, k, m, j);
                  } else {
                    y1();
                  }
                  break;
                case -20602: 
                  w1();
                  break;
                }
              }
              else
              {
                c.l();
                Y0();
                p.i();
              }
            }
            else
            {
              y1();
              p.g(Integer.valueOf(i), this.mAccountEmailEditText.getText().toString());
            }
          }
          else {
            e.d(this, j, n1());
          }
        }
        else {
          e.g(this);
        }
      }
      else
      {
        s0.p(this, getString(2131951723));
      }
    }
  }
  
  private void u1()
  {
    if (com.tplink.libtpnetwork.Utils.o.h0().u())
    {
      this.p1 = getIntent().getStringExtra("SignUpEmail");
      this.p2 = getIntent().getStringExtra("SignUpPassword");
      if (!TextUtils.isEmpty(this.p1)) {
        this.mAccountEmailEditText.setText(this.p1);
      }
      if (!TextUtils.isEmpty(this.p2)) {
        this.mAccountPasswordEditText.setText(this.p2);
      }
      Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
      Selection.setSelection(this.mAccountPasswordEditText.getText(), this.mAccountPasswordEditText.getText().length());
    }
    this.mAccountEmailEditText.f(this);
    this.mAccountPasswordEditText.f(this);
    this.mCbRememberMe.setChecked(com.tplink.libtpnetwork.Utils.o.h0().u());
    boolean bool = c.e();
    this.p0 = bool;
    if (!bool) {
      z1();
    } else {
      this.mAccountEmailEditText.m();
    }
  }
  
  private void v1()
  {
    TSnackbar.x(this, 2131952078, 0).F(2131953652, new c()).I(getResources().getColor(2131099808)).N();
  }
  
  private void w1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131953661, 2131099799).o(2131952452, 2131099808, new d()).l(2131952391, 2131099804, null).b(false).c(false).g(8, 8).y();
  }
  
  private void x1(TCAccountBean paramTCAccountBean)
  {
    if (paramTCAccountBean == null) {
      return;
    }
    if (!com.tplink.libtpnetwork.Utils.o.h0().u()) {
      return;
    }
    if ((TextUtils.isEmpty(this.p1)) && (!TextUtils.isEmpty(paramTCAccountBean.getCloudUserName())))
    {
      this.mAccountEmailEditText.setText(paramTCAccountBean.getCloudUserName());
      Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
    }
  }
  
  private void y1()
  {
    this.mIncorrectInfoTv.setVisibility(0);
  }
  
  private void z1()
  {
    if (this.y == null) {
      this.y = LayoutInflater.from(this).inflate(2131559339, null);
    }
    CheckBox localCheckBox1 = (CheckBox)this.y.findViewById(2131362210);
    final CheckBox localCheckBox2 = (CheckBox)this.y.findViewById(2131362214);
    if (this.z == null)
    {
      Object localObject1 = (TextView)this.y.findViewById(2131364583);
      Object localObject2 = (TextView)this.y.findViewById(2131364706);
      d0.g(this, (TextView)localObject1, 2131952070, getString(2131951657), getString(2131951659), new e(), new f());
      d0.e((TextView)localObject2, getString(2131952068, new Object[] { getString(2131952069) }), getString(2131952069), getResources().getColor(2131100138), new g());
      localObject1 = getString(2131953413);
      localObject2 = localObject1;
      if ("Agree".equals(localObject1)) {
        localObject2 = getString(2131952397);
      }
      String str = getString(2131953414);
      localObject1 = str;
      if ("Disagree".equals(str)) {
        localObject1 = getString(2131953415);
      }
      this.z = new TPMaterialDialogV3.Builder(this).n(2131953420).s(this.y).b(false).c(false).m((String)localObject2, new h(localCheckBox2)).i((String)localObject1, 2131099804, null).a();
      localCheckBox1.setOnCheckedChangeListener(new i());
    }
    if (!this.z.isShowing())
    {
      boolean bool = com.tplink.iot.Utils.login.a.f(com.tplink.iot.Utils.login.a.a(getApplicationContext()));
      localCheckBox1.setChecked(bool ^ true);
      localCheckBox2.setChecked(bool ^ true);
      this.z.show();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.mLoginBtnTextview.setEnabled(D1());
    this.mIncorrectInfoTv.setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.p0)
    {
      z1();
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @OnClick
  void login()
  {
    this.mIncorrectInfoTv.setVisibility(8);
    if (!b.d.w.f.b.h(this))
    {
      s0.p(this, getString(2131953208));
      return;
    }
    this.p3.m(o1(), this.mAccountPasswordEditText.getText().toString());
    p.f();
  }
  
  @OnClick
  void loginForget()
  {
    b.d.w.f.a.g(this);
    Intent localIntent = new Intent(this, RetrieveAccountByEmailActivity.class);
    String str;
    if (C1())
    {
      localIntent.putExtra("ResetAccountMail", this.mAccountEmailEditText.getText().toString().trim());
      str = b.d.w.h.a.g(this.mAccountEmailEditText.getText().toString().trim());
    }
    else
    {
      str = "";
    }
    startActivityForResult(localIntent, 100);
    p.e(str);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str;
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra("ResetAccountMail");
      if (!TextUtils.isEmpty(str))
      {
        this.mAccountEmailEditText.setText(str);
        this.mAccountPasswordEditText.setText("");
        Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
      }
    }
    else if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra("SignUpEmail");
      if (!TextUtils.isEmpty(str))
      {
        this.mAccountEmailEditText.setText(str);
        this.mAccountPasswordEditText.setText("");
        Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558576);
    ButterKnife.a(this);
    m1(getIntent());
    this.p3 = ((LoginViewModel)ViewModelProviders.of(this).get(LoginViewModel.class));
    u1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    B1();
    p.h();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.hasExtra("SignUpEmail")))
    {
      this.mAccountEmailEditText.setText(paramIntent.getStringExtra("SignUpEmail"));
      this.mAccountPasswordEditText.setText("");
      Selection.setSelection(this.mAccountPasswordEditText.getText(), this.mAccountPasswordEditText.getText().length());
    }
    else
    {
      this.mAccountPasswordEditText.setText("");
      this.mAccountEmailEditText.setText("");
    }
    m1(paramIntent);
  }
  
  @OnCheckedChanged
  void onPolicyCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    com.tplink.libtpnetwork.Utils.o.h0().w0(paramBoolean);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("email");
    if ((this.mAccountEmailEditText != null) && (paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.mAccountEmailEditText.setText(paramBundle);
      Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (com.tplink.iot.core.o.a() == 0) {}
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    DrawableEditText localDrawableEditText = this.mAccountEmailEditText;
    if ((localDrawableEditText != null) && (!localDrawableEditText.getText().toString().isEmpty())) {
      paramBundle.putString("email", this.mAccountEmailEditText.getText().toString());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @OnClick
  void signUp()
  {
    b.d.w.f.a.g(this);
    startActivityForResult(new Intent(this, SignUpByEmailActivity.class), 101);
    p.k();
  }
  
  class a
    implements Observer<TCAccountBean>
  {
    a() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      LoginActivity.e1(LoginActivity.this, paramTCAccountBean);
    }
  }
  
  class b
    implements Observer<i<LoginV1Result>>
  {
    b() {}
    
    public void a(i<LoginV1Result> parami)
    {
      LoginActivity.f1(LoginActivity.this, parami);
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      paramView = new Intent(LoginActivity.this, SignUpByEmailActivity.class);
      paramView.putExtra("SignUpEmail", LoginActivity.this.mAccountEmailEditText.getText().toString().trim());
      LoginActivity.this.startActivity(paramView);
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      LoginActivity.g1(LoginActivity.this);
    }
  }
  
  class e
    implements d0.g
  {
    e() {}
    
    public void a()
    {
      LoginActivity.h1(LoginActivity.this);
    }
  }
  
  class f
    implements d0.f
  {
    f() {}
    
    public void a()
    {
      LoginActivity.i1(LoginActivity.this);
    }
  }
  
  class g
    implements d0.g
  {
    g() {}
    
    public void a()
    {
      LoginActivity.j1(LoginActivity.this);
    }
  }
  
  class h
    implements TPMaterialDialogV3.d
  {
    h(CheckBox paramCheckBox) {}
    
    public void onClick(View paramView)
    {
      LoginActivity.k1(LoginActivity.this, true);
      c.i(true);
      if (localCheckBox2.isChecked())
      {
        c.j(true);
        c.d();
        com.tplink.iot.Utils.x0.b.c(true);
      }
      p.a(LoginActivity.this.mAccountEmailEditText.getText().toString());
    }
  }
  
  class i
    implements CompoundButton.OnCheckedChangeListener
  {
    i() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = LoginActivity.l1(LoginActivity.this);
      int i;
      if (paramBoolean) {
        i = 2131099808;
      } else {
        i = 2131099840;
      }
      paramCompoundButton.q(-1, paramBoolean, i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */