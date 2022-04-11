package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import java.util.List;

public class TPEyeballEditText
  extends FrameLayout
  implements View.OnClickListener
{
  private int H3 = -1;
  private String I3 = "";
  private TextWatcher J3 = null;
  private Typeface K3;
  private boolean L3 = false;
  private int M3 = -1;
  private CharSequence N3 = null;
  private View.OnFocusChangeListener O3 = null;
  private View P3 = null;
  private AdapterView.OnItemClickListener Q3 = null;
  private b R3 = null;
  private int S3 = -1;
  private float T3 = 0.0F;
  private final int c = (int)(getResources().getDisplayMetrics().density * 15.0F);
  private AppCompatAutoCompleteTextView d = null;
  private ImageView f = null;
  private Context p0 = null;
  private String p1 = "";
  private int p2 = 15;
  private int p3 = -1;
  private ImageView q = null;
  private View x = null;
  private boolean y = false;
  private boolean z = false;
  
  public TPEyeballEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPEyeballEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPEyeballEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.p0 = paramContext;
    i(paramContext, paramAttributeSet);
  }
  
  private void f()
  {
    this.d.setText("");
  }
  
  private void g()
  {
    int i = this.d.getSelectionStart();
    if (!this.y)
    {
      this.d.setInputType(129);
      this.d.setTypeface(this.K3);
      this.f.setImageResource(r0.common_eye_closed_selector);
    }
    else
    {
      this.d.setInputType(1);
      this.d.setTypeface(this.K3);
      this.f.setImageResource(u0.ic_eye_open_normal);
    }
    Selection.setSelection(this.d.getText(), i);
  }
  
  private void h(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setSublineColor(p0.common_tplink_teal);
      this.q.post(new a());
    }
    else
    {
      setSublineColor(p0.common_tplink_light_gray);
      this.q.setVisibility(8);
      if (this.S3 == 1) {
        this.d.setPadding((int)this.T3, 0, b.d.w.f.a.a(this.p0, 26.0F), 0);
      } else {
        this.d.setPadding(b.d.w.f.a.a(this.p0, 26.0F), 0, b.d.w.f.a.a(this.p0, 26.0F), 0);
      }
    }
  }
  
  private void i(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.P3 = LayoutInflater.from(paramContext).inflate(t0.eyeball_edittext_main, this, true);
    this.d = ((AppCompatAutoCompleteTextView)findViewById(s0.edittext));
    this.f = ((ImageView)findViewById(s0.ic_eyeball_iv));
    this.q = ((ImageView)findViewById(s0.ic_clear_iv));
    this.x = findViewById(s0.subline_view);
    this.d.setOnFocusChangeListener(new z(this));
    this.f.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.f.setVisibility(8);
    this.K3 = this.d.getTypeface();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPEyeballEditText);
    boolean bool = paramContext.getBoolean(x0.TPEyeballEditText_hasEyeball, false);
    this.z = bool;
    if (bool)
    {
      this.f.setVisibility(0);
      this.d.setPadding(b.d.w.f.a.a(this.p0, 51.0F), 0, b.d.w.f.a.a(this.p0, 51.0F), 0);
      this.d.setInputType(129);
      this.d.setTypeface(this.K3);
    }
    else
    {
      this.f.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.q.getLayoutParams()).rightMargin = b.d.w.f.a.a(this.p0, 3.0F);
      this.d.setPadding(b.d.w.f.a.a(this.p0, 26.0F), 0, b.d.w.f.a.a(this.p0, 26.0F), 0);
      this.d.setInputType(1);
    }
    this.S3 = paramContext.getInteger(x0.TPEyeballEditText_textGravity, 0);
    this.T3 = paramContext.getDimension(x0.TPEyeballEditText_textPaddingLeft, b.d.w.f.a.a(this.p0, 7.0F));
    if (this.S3 == 1)
    {
      this.d.setGravity(3);
      if (this.z) {
        this.d.setPadding((int)this.T3, 0, b.d.w.f.a.a(this.p0, 51.0F), 0);
      } else {
        this.d.setPadding((int)this.T3, 0, b.d.w.f.a.a(this.p0, 26.0F), 0);
      }
    }
    paramAttributeSet = paramContext.getString(x0.TPEyeballEditText_hint);
    this.p1 = paramAttributeSet;
    this.d.setHint(paramAttributeSet);
    paramAttributeSet = paramContext.getString(x0.TPEyeballEditText_text);
    this.I3 = paramAttributeSet;
    this.d.setText(paramAttributeSet);
    int i = paramContext.getDimensionPixelSize(x0.TPEyeballEditText_textSize, this.c);
    this.p2 = i;
    this.d.setTextSize(0, i);
    i = paramContext.getColor(x0.TPEyeballEditText_textColor, ContextCompat.getColor(this.p0, p0.common_tplink_dark_gray));
    this.p3 = i;
    this.d.setTextColor(i);
    i = paramContext.getColor(x0.TPEyeballEditText_textColorHint, -1);
    this.H3 = i;
    if (i != -1) {
      this.d.setHintTextColor(i);
    }
    bool = paramContext.getBoolean(x0.TPEyeballEditText_password, false);
    this.L3 = bool;
    if (bool)
    {
      this.d.setInputType(129);
      this.d.setTypeface(this.K3);
      this.d.setTextColor(this.p3);
      this.d.setTextSize(0, this.p2);
      i = this.H3;
      if (i != -1) {
        this.d.setHintTextColor(i);
      }
    }
    i = paramContext.getInt(x0.TPEyeballEditText_android_imeOptions, 0);
    this.M3 = i;
    this.d.setImeOptions(i);
    paramAttributeSet = paramContext.getText(x0.TPEyeballEditText_android_imeActionLabel);
    this.N3 = paramAttributeSet;
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      this.d.setImeActionLabel(this.N3, this.M3);
    }
    this.d.setOnItemClickListener(new y(this));
    paramContext.recycle();
  }
  
  public EditText getEditText()
  {
    return this.d;
  }
  
  public Editable getText()
  {
    return this.d.getText();
  }
  
  public void onClick(View paramView)
  {
    if (s0.ic_eyeball_iv == paramView.getId())
    {
      this.y ^= true;
      g();
      b localb = this.R3;
      if (localb != null) {
        localb.a(this.y);
      }
    }
    if (s0.ic_clear_iv == paramView.getId()) {
      f();
    }
  }
  
  public void setEmailList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.d.setAdapter(new com.tplink.libtpcontrols.y0.a(this.p0, paramList));
    }
  }
  
  public void setNormalList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.d.setAdapter(new ArrayAdapter(this.p0, t0.auto_complete_normal_adapter, paramList));
    }
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.d.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public void setOnEyeballVisibleChangedListener(b paramb)
  {
    this.R3 = paramb;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.O3 = paramOnFocusChangeListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.Q3 = paramOnItemClickListener;
  }
  
  public void setSublineColor(@ColorRes int paramInt)
  {
    this.x.setBackground(getResources().getDrawable(paramInt));
  }
  
  public void setText(int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.d.setText(paramCharSequence);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      TPEyeballEditText.a(TPEyeballEditText.this).setVisibility(0);
      if (TPEyeballEditText.b(TPEyeballEditText.this) == 1) {
        TPEyeballEditText.e(TPEyeballEditText.this).setPadding((int)TPEyeballEditText.c(TPEyeballEditText.this), 0, b.d.w.f.a.a(TPEyeballEditText.d(TPEyeballEditText.this), 51.0F), 0);
      } else {
        TPEyeballEditText.e(TPEyeballEditText.this).setPadding(b.d.w.f.a.a(TPEyeballEditText.d(TPEyeballEditText.this), 51.0F), 0, b.d.w.f.a.a(TPEyeballEditText.d(TPEyeballEditText.this), 51.0F), 0);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPEyeballEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */