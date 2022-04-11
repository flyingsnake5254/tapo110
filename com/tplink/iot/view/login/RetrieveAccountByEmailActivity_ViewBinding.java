package com.tplink.iot.view.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.widget.DrawableEditText;

public class RetrieveAccountByEmailActivity_ViewBinding
  implements Unbinder
{
  private RetrieveAccountByEmailActivity b;
  private View c;
  private View d;
  private View e;
  private View f;
  private TextWatcher g;
  
  @UiThread
  public RetrieveAccountByEmailActivity_ViewBinding(final RetrieveAccountByEmailActivity paramRetrieveAccountByEmailActivity, View paramView)
  {
    this.b = paramRetrieveAccountByEmailActivity;
    View localView = c.c(paramView, 2131363840, "field 'mResetEmailEt' and method 'onResetEmailFocusChange'");
    paramRetrieveAccountByEmailActivity.mResetEmailEt = ((DrawableEditText)c.b(localView, 2131363840, "field 'mResetEmailEt'", DrawableEditText.class));
    this.c = localView;
    localView.setOnFocusChangeListener(new a(paramRetrieveAccountByEmailActivity));
    localView = c.c(paramView, 2131363842, "field 'mResetPwdButton' and method 'resetPwd'");
    paramRetrieveAccountByEmailActivity.mResetPwdButton = ((Button)c.b(localView, 2131363842, "field 'mResetPwdButton'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new b(paramRetrieveAccountByEmailActivity));
    localView = c.c(paramView, 2131361930, "method 'onContainerClicked'");
    this.e = localView;
    localView.setOnClickListener(new c(paramRetrieveAccountByEmailActivity));
    paramView = c.c(paramView, 2131362515, "method 'EditTextChanged'");
    this.f = paramView;
    paramRetrieveAccountByEmailActivity = new d(paramRetrieveAccountByEmailActivity);
    this.g = paramRetrieveAccountByEmailActivity;
    ((TextView)paramView).addTextChangedListener(paramRetrieveAccountByEmailActivity);
  }
  
  @CallSuper
  public void a()
  {
    RetrieveAccountByEmailActivity localRetrieveAccountByEmailActivity = this.b;
    if (localRetrieveAccountByEmailActivity != null)
    {
      this.b = null;
      localRetrieveAccountByEmailActivity.mResetEmailEt = null;
      localRetrieveAccountByEmailActivity.mResetPwdButton = null;
      this.c.setOnFocusChangeListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      ((TextView)this.f).removeTextChangedListener(this.g);
      this.g = null;
      this.f = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    implements View.OnFocusChangeListener
  {
    a(RetrieveAccountByEmailActivity paramRetrieveAccountByEmailActivity) {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramRetrieveAccountByEmailActivity.onResetEmailFocusChange(paramView, paramBoolean);
    }
  }
  
  class b
    extends b
  {
    b(RetrieveAccountByEmailActivity paramRetrieveAccountByEmailActivity) {}
    
    public void a(View paramView)
    {
      paramRetrieveAccountByEmailActivity.resetPwd();
    }
  }
  
  class c
    extends b
  {
    c(RetrieveAccountByEmailActivity paramRetrieveAccountByEmailActivity) {}
    
    public void a(View paramView)
    {
      paramRetrieveAccountByEmailActivity.onContainerClicked();
    }
  }
  
  class d
    implements TextWatcher
  {
    d(RetrieveAccountByEmailActivity paramRetrieveAccountByEmailActivity) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramRetrieveAccountByEmailActivity.EditTextChanged();
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\RetrieveAccountByEmailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */