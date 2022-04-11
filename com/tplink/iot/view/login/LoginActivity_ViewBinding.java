package com.tplink.iot.view.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;

public class LoginActivity_ViewBinding
  implements Unbinder
{
  private LoginActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity paramLoginActivity, View paramView)
  {
    this.b = paramLoginActivity;
    paramLoginActivity.mAccountEmailEditText = ((DrawableEditText)c.d(paramView, 2131362549, "field 'mAccountEmailEditText'", DrawableEditText.class));
    paramLoginActivity.mAccountPasswordEditText = ((DrawableEditText)c.d(paramView, 2131362550, "field 'mAccountPasswordEditText'", DrawableEditText.class));
    View localView = c.c(paramView, 2131364630, "field 'mSignUpTextview' and method 'signUp'");
    paramLoginActivity.mSignUpTextview = ((TextView)c.b(localView, 2131364630, "field 'mSignUpTextview'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramLoginActivity));
    localView = c.c(paramView, 2131364520, "field 'mLoginForgetTextview' and method 'loginForget'");
    paramLoginActivity.mLoginForgetTextview = ((TextView)c.b(localView, 2131364520, "field 'mLoginForgetTextview'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new b(paramLoginActivity));
    localView = c.c(paramView, 2131362076, "field 'mLoginBtnTextview' and method 'login'");
    paramLoginActivity.mLoginBtnTextview = ((TextView)c.b(localView, 2131362076, "field 'mLoginBtnTextview'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new c(paramLoginActivity));
    paramLoginActivity.mIncorrectInfoTv = ((TextView)c.d(paramView, 2131364487, "field 'mIncorrectInfoTv'", TextView.class));
    paramView = c.c(paramView, 2131362199, "field 'mCbRememberMe' and method 'onPolicyCheckedChanged'");
    paramLoginActivity.mCbRememberMe = ((CheckBox)c.b(paramView, 2131362199, "field 'mCbRememberMe'", CheckBox.class));
    this.f = paramView;
    ((CompoundButton)paramView).setOnCheckedChangeListener(new d(paramLoginActivity));
  }
  
  @CallSuper
  public void a()
  {
    LoginActivity localLoginActivity = this.b;
    if (localLoginActivity != null)
    {
      this.b = null;
      localLoginActivity.mAccountEmailEditText = null;
      localLoginActivity.mAccountPasswordEditText = null;
      localLoginActivity.mSignUpTextview = null;
      localLoginActivity.mLoginForgetTextview = null;
      localLoginActivity.mLoginBtnTextview = null;
      localLoginActivity.mIncorrectInfoTv = null;
      localLoginActivity.mCbRememberMe = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      ((CompoundButton)this.f).setOnCheckedChangeListener(null);
      this.f = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(LoginActivity paramLoginActivity) {}
    
    public void a(View paramView)
    {
      paramLoginActivity.signUp();
    }
  }
  
  class b
    extends b
  {
    b(LoginActivity paramLoginActivity) {}
    
    public void a(View paramView)
    {
      paramLoginActivity.loginForget();
    }
  }
  
  class c
    extends b
  {
    c(LoginActivity paramLoginActivity) {}
    
    public void a(View paramView)
    {
      paramLoginActivity.login();
    }
  }
  
  class d
    implements CompoundButton.OnCheckedChangeListener
  {
    d(LoginActivity paramLoginActivity) {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramLoginActivity.onPolicyCheckedChanged(paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\LoginActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */