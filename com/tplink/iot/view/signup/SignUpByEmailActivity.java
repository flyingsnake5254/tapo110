package com.tplink.iot.view.signup;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.h.b;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.f;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.login.CloudRegionCode;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.about.AboutWebActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.login.CloudRegionChooseActivity;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.viewmodel.signup.SignUpViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.PassWordEditText;
import com.tplink.iot.widget.PassWordEditText.d;
import java.util.Arrays;
import java.util.List;

public class SignUpByEmailActivity
  extends BaseActivity
  implements PassWordEditText.d
{
  @BindView
  LinearLayout mLayoutContainer;
  @BindView
  CheckBox mRegisterAgreePolicyCBox;
  @BindView
  TextView mRegisterAgreePolicyText;
  @BindView
  TextView mRegisterBtnTextview;
  @BindView
  PassWordEditText mRegisterConfirmPswEditText;
  @BindView
  DrawableEditText mRegisterEmailEditText;
  @BindView
  PassWordEditText mRegisterPswEditText;
  @BindView
  TextView mRegisterTitle;
  @BindView
  CheckBox mSubscribeEmailCBox;
  private String p0 = null;
  private MenuItem y;
  private SignUpViewModel z = null;
  
  private boolean k1()
  {
    boolean bool;
    if ((b.c(this.mRegisterEmailEditText.getText().toString())) && (f0.e(this.mRegisterPswEditText.getText().toString())) && (this.mRegisterPswEditText.getText().toString().equals(this.mRegisterConfirmPswEditText.getText().toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void l1()
  {
    Intent localIntent = new Intent(this, AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131951657));
    localIntent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
    startActivity(localIntent);
    overridePendingTransition(2130772068, 2130772067);
  }
  
  private void m1()
  {
    b.d.w.f.a.g(this);
    Intent localIntent = new Intent(this, CloudRegionChooseActivity.class);
    if (!TextUtils.isEmpty(this.p0)) {
      localIntent.putExtra("REGION_CODE", this.p0);
    } else {
      localIntent.putExtra("REGION_CODE", com.tplink.iot.Utils.login.a.b(getApplicationContext()));
    }
    localIntent.putExtra("args_is_from_dashboard", false);
    startActivityForResult(localIntent, 1001);
  }
  
  private void n1()
  {
    s0.g();
    Intent localIntent = new Intent(this, SignUpCheckMailboxActivity.class);
    localIntent.putExtra("SignUpEmail", this.mRegisterEmailEditText.getText().toString().trim());
    localIntent.putExtra("SignUpPassword", this.mRegisterPswEditText.getText().toString());
    localIntent.putExtra("EmailType", 1);
    startActivityForResult(localIntent, 0);
  }
  
  private void o1()
  {
    Intent localIntent = new Intent(this, AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131951659));
    localIntent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
    startActivity(localIntent);
    overridePendingTransition(2130772068, 2130772067);
  }
  
  private void p1()
  {
    this.mRegisterEmailEditText.m();
    b.d.w.f.a.j(this);
    Object localObject = Arrays.asList(getResources().getStringArray(2130903043));
    this.mRegisterEmailEditText.setEmailList((List)localObject);
    if ((getIntent() != null) && (getIntent().getStringExtra("SignUpEmail") != null)) {
      this.mRegisterEmailEditText.setText(getIntent().getStringExtra("SignUpEmail"));
    } else {
      this.mRegisterEmailEditText.setText("");
    }
    Selection.setSelection(this.mRegisterEmailEditText.getText(), this.mRegisterEmailEditText.getText().length());
    String str = getString(2131951657);
    localObject = getString(2131951659);
    d0.g(this, this.mRegisterAgreePolicyText, 2131952070, str, (String)localObject, new a(), new b());
    this.mRegisterTitle.setFocusable(true);
    this.mRegisterTitle.setFocusableInTouchMode(true);
    v1();
  }
  
  private void q1()
  {
    this.mRegisterEmailEditText.setFilters(new InputFilter[] { new c(), new InputFilter.LengthFilter(64) });
    this.mRegisterPswEditText.setOnTextChangeListener(this);
    this.mRegisterConfirmPswEditText.setOnTextChangeListener(this);
  }
  
  private void r1()
  {
    new TPMaterialDialogV3.Builder(this).e(2131953661, 2131099799).j(2131952452, 2131099808, new f()).h(2131952391, 2131099804, null).b(false).c(false).t();
  }
  
  private void s1()
  {
    TSnackbar.x(this, 2131952611, -1).F(2131952433, new g()).I(getResources().getColor(2131099808)).N();
  }
  
  private void t1(CloudException paramCloudException)
  {
    if (paramCloudException == null)
    {
      s0.m(this, getString(2131952466));
    }
    else
    {
      s0.g();
      int i = paramCloudException.getErrCode();
      if (i != 44915) {
        if ((i != 44921) && (i != 45334) && (i != 45336))
        {
          if (i != 0)
          {
            if (i != 19)
            {
              if ((i != 16) && (i != 17))
              {
                s0.p(this, getString(2131951723));
                return;
              }
            }
            else
            {
              r1();
              return;
            }
          }
          else
          {
            n1();
            return;
          }
        }
        else
        {
          s0.p(this, getString(2131951729));
          return;
        }
      }
      s1();
    }
  }
  
  private void u1()
  {
    this.z.h().observe(this, new d());
    this.z.i().observe(this, new e());
  }
  
  private void v1()
  {
    boolean bool = com.tplink.iot.Utils.login.a.f(this.p0);
    this.mRegisterAgreePolicyCBox.setChecked(bool ^ true);
    this.mSubscribeEmailCBox.setChecked(bool ^ true);
  }
  
  private void w1()
  {
    if ((k1()) && (this.mRegisterAgreePolicyCBox.isChecked())) {
      this.mRegisterBtnTextview.setEnabled(true);
    } else {
      this.mRegisterBtnTextview.setEnabled(false);
    }
  }
  
  @OnTextChanged
  void EditTextChanged()
  {
    if (f0.c(this.mRegisterEmailEditText.getText().toString())) {
      this.mRegisterEmailEditText.setErrorText(2131951720);
    } else {
      this.mRegisterEmailEditText.setErrorText(null);
    }
    w1();
  }
  
  public void i0(String paramString)
  {
    w1();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("REGION_CODE");
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.p0 = paramIntent;
        MenuItem localMenuItem = this.y;
        if (localMenuItem != null) {
          localMenuItem.setTitle(CloudRegionCode.fromSymbol(paramIntent));
        }
        v1();
      }
    }
    else if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      finish();
    }
  }
  
  @OnFocusChange
  void onConfirmPswFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.mRegisterConfirmPswEditText.getText().toString().isEmpty()) && (!this.mRegisterConfirmPswEditText.getText().toString().equals(this.mRegisterPswEditText.getText().toString()))) {
      this.mRegisterConfirmPswEditText.setErrorText(2131951711);
    }
    w1();
  }
  
  @OnClick
  void onContainerClicked()
  {
    b.d.w.f.a.g(this);
    this.mRegisterTitle.requestFocus();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558657);
    ButterKnife.a(this);
    this.z = ((SignUpViewModel)ViewModelProviders.of(this).get(SignUpViewModel.class));
    this.p0 = com.tplink.iot.Utils.login.a.a(this);
    p1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    q1();
    u1();
    p.m();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    this.y = paramMenu.findItem(2131362300);
    if (!TextUtils.isEmpty(this.p0))
    {
      paramMenu = com.tplink.iot.Utils.login.a.c(this, this.p0);
      if (!TextUtils.isEmpty(paramMenu)) {
        this.y.setTitle(paramMenu);
      } else {
        this.y.setTitle(2131953015);
      }
    }
    else
    {
      this.y.setTitle(2131953015);
    }
    return true;
  }
  
  @OnFocusChange
  void onEmailFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.mRegisterEmailEditText.getText().toString().isEmpty()) && (!b.c(this.mRegisterEmailEditText.getText().toString()))) {
      this.mRegisterEmailEditText.setErrorText(2131951720);
    }
    w1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      b.d.w.f.a.g(this);
      finish();
      return false;
    }
    if (i == 2131362300)
    {
      m1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  @OnCheckedChanged
  void onPolicyCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    w1();
  }
  
  @OnClick
  void register()
  {
    b.d.w.f.a.g(this);
    this.z.k();
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      SignUpByEmailActivity.e1(SignUpByEmailActivity.this);
    }
  }
  
  class b
    implements d0.f
  {
    b() {}
    
    public void a()
    {
      SignUpByEmailActivity.f1(SignUpByEmailActivity.this);
    }
  }
  
  class c
    implements InputFilter
  {
    c() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if ((f0.c(SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString())) && (!SignUpByEmailActivity.this.mRegisterPswEditText.k()))
      {
        SignUpByEmailActivity.this.mRegisterEmailEditText.setHelpText(null);
        SignUpByEmailActivity.this.mRegisterEmailEditText.setErrorText(2131951720);
        return "";
      }
      return null;
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        SignUpByEmailActivity.h1(SignUpByEmailActivity.this).j(SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString().trim(), SignUpByEmailActivity.this.mRegisterPswEditText.getText().toString(), SignUpByEmailActivity.g1(SignUpByEmailActivity.this), SignUpByEmailActivity.this.mSubscribeEmailCBox.isChecked());
      }
      else
      {
        paramBoolean = SignUpByEmailActivity.this;
        s0.p(paramBoolean, paramBoolean.getString(2131953208));
      }
    }
  }
  
  class e
    implements Observer<CloudException>
  {
    e() {}
    
    public void a(@Nullable CloudException paramCloudException)
    {
      SignUpByEmailActivity.i1(SignUpByEmailActivity.this, paramCloudException);
    }
  }
  
  class f
    implements TPMaterialDialogV3.d
  {
    f() {}
    
    public void onClick(View paramView)
    {
      SignUpByEmailActivity.j1(SignUpByEmailActivity.this);
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      paramView = new Intent(SignUpByEmailActivity.this, LoginActivity.class);
      paramView.putExtra("SignUpEmail", SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString().trim());
      SignUpByEmailActivity.this.setResult(-1, paramView);
      SignUpByEmailActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\signup\SignUpByEmailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */