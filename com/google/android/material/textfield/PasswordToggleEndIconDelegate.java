package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.internal.CheckableImageButton;

class PasswordToggleEndIconDelegate
  extends EndIconDelegate
{
  private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener()
  {
    public void onEditTextAttached(@NonNull TextInputLayout paramAnonymousTextInputLayout)
    {
      EditText localEditText = paramAnonymousTextInputLayout.getEditText();
      paramAnonymousTextInputLayout.setEndIconVisible(true);
      paramAnonymousTextInputLayout.setEndIconCheckable(true);
      paramAnonymousTextInputLayout = PasswordToggleEndIconDelegate.this;
      paramAnonymousTextInputLayout.endIconView.setChecked(paramAnonymousTextInputLayout.hasPasswordTransformation() ^ true);
      localEditText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
      localEditText.addTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
    }
  };
  private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener()
  {
    public void onEndIconChanged(@NonNull TextInputLayout paramAnonymousTextInputLayout, int paramAnonymousInt)
    {
      paramAnonymousTextInputLayout = paramAnonymousTextInputLayout.getEditText();
      if ((paramAnonymousTextInputLayout != null) && (paramAnonymousInt == 1))
      {
        paramAnonymousTextInputLayout.setTransformationMethod(PasswordTransformationMethod.getInstance());
        paramAnonymousTextInputLayout.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
      }
    }
  };
  private final TextWatcher textWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      paramAnonymousCharSequence = PasswordToggleEndIconDelegate.this;
      paramAnonymousCharSequence.endIconView.setChecked(paramAnonymousCharSequence.hasPasswordTransformation() ^ true);
    }
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  PasswordToggleEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private boolean hasPasswordTransformation()
  {
    EditText localEditText = this.textInputLayout.getEditText();
    boolean bool;
    if ((localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isInputTypePassword(EditText paramEditText)
  {
    boolean bool;
    if ((paramEditText != null) && ((paramEditText.getInputType() == 16) || (paramEditText.getInputType() == 128) || (paramEditText.getInputType() == 144) || (paramEditText.getInputType() == 224))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void initialize()
  {
    this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.design_password_eye));
    Object localObject = this.textInputLayout;
    ((TextInputLayout)localObject).setEndIconContentDescription(((LinearLayout)localObject).getResources().getText(R.string.password_toggle_content_description));
    this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = PasswordToggleEndIconDelegate.this.textInputLayout.getEditText();
        if (paramAnonymousView == null) {
          return;
        }
        int i = paramAnonymousView.getSelectionEnd();
        if (PasswordToggleEndIconDelegate.this.hasPasswordTransformation()) {
          paramAnonymousView.setTransformationMethod(null);
        } else {
          paramAnonymousView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (i >= 0) {
          paramAnonymousView.setSelection(i);
        }
      }
    });
    this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
    this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
    localObject = this.textInputLayout.getEditText();
    if (isInputTypePassword((EditText)localObject)) {
      ((EditText)localObject).setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\PasswordToggleEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */