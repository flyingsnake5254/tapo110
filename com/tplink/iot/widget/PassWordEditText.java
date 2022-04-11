package com.tplink.iot.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tplink.iot.Utils.f0;

public class PassWordEditText
  extends DrawableEditText
{
  private String R3 = "";
  private d S3;
  
  public PassWordEditText(Context paramContext)
  {
    super(paramContext);
    q();
  }
  
  public PassWordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q();
  }
  
  public PassWordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q();
  }
  
  public void q()
  {
    f(new a());
    setFilters(new InputFilter[] { new b(), new InputFilter.LengthFilter(32) });
    setOnFocusChangeListener(new c());
  }
  
  public void setOnTextChangeListener(d paramd)
  {
    this.S3 = paramd;
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = PassWordEditText.this;
      PassWordEditText.o(paramEditable, paramEditable.getText().toString());
      if (f0.d(PassWordEditText.n(PassWordEditText.this)))
      {
        PassWordEditText.this.setHelpText(null);
        PassWordEditText.this.setErrorText(2131951739);
      }
      else
      {
        PassWordEditText.this.setHelpText(null);
        PassWordEditText.this.setErrorText(null);
      }
      if (PassWordEditText.p(PassWordEditText.this) != null) {
        PassWordEditText.p(PassWordEditText.this).i0(PassWordEditText.n(PassWordEditText.this));
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements InputFilter
  {
    b() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if ((f0.d(PassWordEditText.n(PassWordEditText.this))) && (!PassWordEditText.this.k()))
      {
        PassWordEditText.this.setHelpText(null);
        PassWordEditText.this.setErrorText(2131951739);
        return "";
      }
      return null;
    }
  }
  
  class c
    implements View.OnFocusChangeListener
  {
    c() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (!paramBoolean) {
        if (!f0.e(PassWordEditText.n(PassWordEditText.this)))
        {
          PassWordEditText.this.setHelpText(null);
          PassWordEditText.this.setErrorText(2131951740);
        }
        else
        {
          PassWordEditText.this.setHelpText(null);
          PassWordEditText.this.setErrorText(null);
        }
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void i0(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\PassWordEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */