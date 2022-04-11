package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class TextInputEditText
  extends AppCompatEditText
{
  private final Rect parentRect = new Rect();
  private boolean textInputLayoutFocusedRectEnabled;
  
  public TextInputEditText(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.TextInputEditText, paramInt, R.style.Widget_Design_TextInputEditText, new int[0]);
    setTextInputLayoutFocusedRectEnabled(paramContext.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
    paramContext.recycle();
  }
  
  @NonNull
  private String getAccessibilityNodeInfoText(@NonNull TextInputLayout paramTextInputLayout)
  {
    Editable localEditable = getText();
    Object localObject1 = paramTextInputLayout.getHint();
    Object localObject2 = paramTextInputLayout.getHelperText();
    Object localObject3 = paramTextInputLayout.getError();
    boolean bool1 = TextUtils.isEmpty(localEditable);
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool3 = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
    boolean bool4 = TextUtils.isEmpty((CharSequence)localObject3) ^ true;
    String str = "";
    if ((bool2 ^ true)) {
      paramTextInputLayout = ((CharSequence)localObject1).toString();
    } else {
      paramTextInputLayout = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramTextInputLayout);
    if (((bool4) || (bool3)) && (!TextUtils.isEmpty(paramTextInputLayout))) {
      paramTextInputLayout = ", ";
    } else {
      paramTextInputLayout = "";
    }
    ((StringBuilder)localObject1).append(paramTextInputLayout);
    paramTextInputLayout = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramTextInputLayout);
    if (bool4) {
      paramTextInputLayout = (TextInputLayout)localObject3;
    } else if (bool3) {
      paramTextInputLayout = (TextInputLayout)localObject2;
    } else {
      paramTextInputLayout = "";
    }
    ((StringBuilder)localObject1).append(paramTextInputLayout);
    localObject3 = ((StringBuilder)localObject1).toString();
    if ((bool1 ^ true))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localEditable);
      paramTextInputLayout = str;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramTextInputLayout = new StringBuilder();
        paramTextInputLayout.append(", ");
        paramTextInputLayout.append((String)localObject3);
        paramTextInputLayout = paramTextInputLayout.toString();
      }
      ((StringBuilder)localObject2).append(paramTextInputLayout);
      return ((StringBuilder)localObject2).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      return (String)localObject3;
    }
    return "";
  }
  
  @Nullable
  private CharSequence getHintFromLayout()
  {
    Object localObject = getTextInputLayout();
    if (localObject != null) {
      localObject = ((TextInputLayout)localObject).getHint();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  @Nullable
  private TextInputLayout getTextInputLayout()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  public void getFocusedRect(@Nullable Rect paramRect)
  {
    super.getFocusedRect(paramRect);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (this.textInputLayoutFocusedRectEnabled) && (paramRect != null))
    {
      localTextInputLayout.getFocusedRect(this.parentRect);
      paramRect.bottom = this.parentRect.bottom;
    }
  }
  
  public boolean getGlobalVisibleRect(@Nullable Rect paramRect, @Nullable Point paramPoint)
  {
    boolean bool = super.getGlobalVisibleRect(paramRect, paramPoint);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (this.textInputLayoutFocusedRectEnabled) && (paramRect != null))
    {
      localTextInputLayout.getGlobalVisibleRect(this.parentRect, paramPoint);
      paramRect.bottom = this.parentRect.bottom;
    }
    return bool;
  }
  
  @Nullable
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.isProvidingHint())) {
      return localTextInputLayout.getHint();
    }
    return super.getHint();
  }
  
  public boolean isTextInputLayoutFocusedRectEnabled()
  {
    return this.textInputLayoutFocusedRectEnabled;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.isProvidingHint()) && (super.getHint() == null) && (ManufacturerUtils.isMeizuDevice())) {
      setHint("");
    }
  }
  
  @Nullable
  public InputConnection onCreateInputConnection(@NonNull EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null)) {
      paramEditorInfo.hintText = getHintFromLayout();
    }
    return localInputConnection;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((Build.VERSION.SDK_INT < 23) && (localTextInputLayout != null)) {
      paramAccessibilityNodeInfo.setText(getAccessibilityNodeInfoText(localTextInputLayout));
    }
  }
  
  public boolean requestRectangleOnScreen(@Nullable Rect paramRect)
  {
    boolean bool = super.requestRectangleOnScreen(paramRect);
    paramRect = getTextInputLayout();
    if ((paramRect != null) && (this.textInputLayoutFocusedRectEnabled))
    {
      this.parentRect.set(0, paramRect.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), paramRect.getWidth(), paramRect.getHeight());
      paramRect.requestRectangleOnScreen(this.parentRect, true);
    }
    return bool;
  }
  
  public void setTextInputLayoutFocusedRectEnabled(boolean paramBoolean)
  {
    this.textInputLayoutFocusedRectEnabled = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\TextInputEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */