package com.tplink.iot.view.signup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.PassWordEditText;

public class SignUpByEmailActivity_ViewBinding
  implements Unbinder
{
  private SignUpByEmailActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private TextWatcher i;
  
  @UiThread
  public SignUpByEmailActivity_ViewBinding(final SignUpByEmailActivity paramSignUpByEmailActivity, View paramView)
  {
    this.b = paramSignUpByEmailActivity;
    View localView = c.c(paramView, 2131363326, "field 'mLayoutContainer' and method 'onContainerClicked'");
    paramSignUpByEmailActivity.mLayoutContainer = ((LinearLayout)c.b(localView, 2131363326, "field 'mLayoutContainer'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramSignUpByEmailActivity));
    paramSignUpByEmailActivity.mRegisterTitle = ((TextView)c.d(paramView, 2131364592, "field 'mRegisterTitle'", TextView.class));
    paramSignUpByEmailActivity.mRegisterAgreePolicyText = ((TextView)c.d(paramView, 2131362259, "field 'mRegisterAgreePolicyText'", TextView.class));
    localView = c.c(paramView, 2131362258, "field 'mRegisterAgreePolicyCBox' and method 'onPolicyCheckedChanged'");
    paramSignUpByEmailActivity.mRegisterAgreePolicyCBox = ((CheckBox)c.b(localView, 2131362258, "field 'mRegisterAgreePolicyCBox'", CheckBox.class));
    this.d = localView;
    ((CompoundButton)localView).setOnCheckedChangeListener(new b(paramSignUpByEmailActivity));
    paramSignUpByEmailActivity.mSubscribeEmailCBox = ((CheckBox)c.d(paramView, 2131362211, "field 'mSubscribeEmailCBox'", CheckBox.class));
    localView = c.c(paramView, 2131362260, "field 'mRegisterBtnTextview' and method 'register'");
    paramSignUpByEmailActivity.mRegisterBtnTextview = ((TextView)c.b(localView, 2131362260, "field 'mRegisterBtnTextview'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new c(paramSignUpByEmailActivity));
    localView = c.c(paramView, 2131362262, "field 'mRegisterEmailEditText' and method 'onEmailFocusChange'");
    paramSignUpByEmailActivity.mRegisterEmailEditText = ((DrawableEditText)c.b(localView, 2131362262, "field 'mRegisterEmailEditText'", DrawableEditText.class));
    this.f = localView;
    localView.setOnFocusChangeListener(new d(paramSignUpByEmailActivity));
    paramSignUpByEmailActivity.mRegisterPswEditText = ((PassWordEditText)c.d(paramView, 2131362263, "field 'mRegisterPswEditText'", PassWordEditText.class));
    localView = c.c(paramView, 2131362261, "field 'mRegisterConfirmPswEditText' and method 'onConfirmPswFocusChange'");
    paramSignUpByEmailActivity.mRegisterConfirmPswEditText = ((PassWordEditText)c.b(localView, 2131362261, "field 'mRegisterConfirmPswEditText'", PassWordEditText.class));
    this.g = localView;
    localView.setOnFocusChangeListener(new e(paramSignUpByEmailActivity));
    paramView = c.c(paramView, 2131362515, "method 'EditTextChanged'");
    this.h = paramView;
    paramSignUpByEmailActivity = new f(paramSignUpByEmailActivity);
    this.i = paramSignUpByEmailActivity;
    ((TextView)paramView).addTextChangedListener(paramSignUpByEmailActivity);
  }
  
  @CallSuper
  public void a()
  {
    SignUpByEmailActivity localSignUpByEmailActivity = this.b;
    if (localSignUpByEmailActivity != null)
    {
      this.b = null;
      localSignUpByEmailActivity.mLayoutContainer = null;
      localSignUpByEmailActivity.mRegisterTitle = null;
      localSignUpByEmailActivity.mRegisterAgreePolicyText = null;
      localSignUpByEmailActivity.mRegisterAgreePolicyCBox = null;
      localSignUpByEmailActivity.mSubscribeEmailCBox = null;
      localSignUpByEmailActivity.mRegisterBtnTextview = null;
      localSignUpByEmailActivity.mRegisterEmailEditText = null;
      localSignUpByEmailActivity.mRegisterPswEditText = null;
      localSignUpByEmailActivity.mRegisterConfirmPswEditText = null;
      this.c.setOnClickListener(null);
      this.c = null;
      ((CompoundButton)this.d).setOnCheckedChangeListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnFocusChangeListener(null);
      this.f = null;
      this.g.setOnFocusChangeListener(null);
      this.g = null;
      ((TextView)this.h).removeTextChangedListener(this.i);
      this.i = null;
      this.h = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void a(View paramView)
    {
      paramSignUpByEmailActivity.onContainerClicked();
    }
  }
  
  class b
    implements CompoundButton.OnCheckedChangeListener
  {
    b(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramSignUpByEmailActivity.onPolicyCheckedChanged(paramCompoundButton, paramBoolean);
    }
  }
  
  class c
    extends b
  {
    c(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void a(View paramView)
    {
      paramSignUpByEmailActivity.register();
    }
  }
  
  class d
    implements View.OnFocusChangeListener
  {
    d(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramSignUpByEmailActivity.onEmailFocusChange(paramView, paramBoolean);
    }
  }
  
  class e
    implements View.OnFocusChangeListener
  {
    e(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramSignUpByEmailActivity.onConfirmPswFocusChange(paramView, paramBoolean);
    }
  }
  
  class f
    implements TextWatcher
  {
    f(SignUpByEmailActivity paramSignUpByEmailActivity) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramSignUpByEmailActivity.EditTextChanged();
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\signup\SignUpByEmailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */