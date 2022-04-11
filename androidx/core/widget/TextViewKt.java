package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TextViewKt
{
  public static final TextWatcher addTextChangedListener(TextView paramTextView, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> paramr1, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> paramr2, l<? super Editable, p> paraml)
  {
    j.f(paramTextView, "$this$addTextChangedListener");
    j.f(paramr1, "beforeTextChanged");
    j.f(paramr2, "onTextChanged");
    j.f(paraml, "afterTextChanged");
    paramr1 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        this.$afterTextChanged.invoke(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramr1.invoke(paramAnonymousCharSequence, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramr2.invoke(paramAnonymousCharSequence, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
      }
    };
    paramTextView.addTextChangedListener(paramr1);
    return paramr1;
  }
  
  public static final TextWatcher doAfterTextChanged(TextView paramTextView, l<? super Editable, p> paraml)
  {
    j.f(paramTextView, "$this$doAfterTextChanged");
    j.f(paraml, "action");
    paraml = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        this.$afterTextChanged.invoke(paramAnonymousEditable);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramTextView.addTextChangedListener(paraml);
    return paraml;
  }
  
  public static final TextWatcher doBeforeTextChanged(TextView paramTextView, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> paramr)
  {
    j.f(paramTextView, "$this$doBeforeTextChanged");
    j.f(paramr, "action");
    paramr = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.$beforeTextChanged.invoke(paramAnonymousCharSequence, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    paramTextView.addTextChangedListener(paramr);
    return paramr;
  }
  
  public static final TextWatcher doOnTextChanged(TextView paramTextView, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, p> paramr)
  {
    j.f(paramTextView, "$this$doOnTextChanged");
    j.f(paramr, "action");
    paramr = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.$onTextChanged.invoke(paramAnonymousCharSequence, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
      }
    };
    paramTextView.addTextChangedListener(paramr);
    return paramr;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\TextViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */