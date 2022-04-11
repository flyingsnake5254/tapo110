package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.List;

public class DrawableEditText
  extends FrameLayout
  implements View.OnClickListener, TextWatcher
{
  private View.OnFocusChangeListener H3 = null;
  private AdapterView.OnItemClickListener I3 = null;
  private List<TextWatcher> J3 = new ArrayList();
  private boolean K3;
  private boolean L3 = false;
  private boolean M3 = false;
  private boolean N3 = false;
  private Drawable O3 = null;
  private Drawable P3 = null;
  private Drawable Q3 = null;
  private View c = null;
  private AppCompatAutoCompleteTextView d = null;
  private ImageView f = null;
  private ImageView p0 = null;
  private int p1 = -1;
  private CharSequence p2 = null;
  private boolean p3 = false;
  private ImageView q = null;
  private View x = null;
  private TextView y = null;
  private TextView z = null;
  
  public DrawableEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j(paramContext, paramAttributeSet);
  }
  
  private void g()
  {
    if ((this.M3) && (this.q.getVisibility() != 0)) {
      this.q.post(new c());
    }
  }
  
  private void h()
  {
    this.K3 = true;
    int i = this.d.getSelectionStart();
    if (!this.p3)
    {
      this.d.setInputType(129);
      this.d.setTypeface(Typeface.DEFAULT);
      this.f.setImageResource(2131690431);
    }
    else
    {
      this.d.setInputType(1);
      this.d.setTypeface(Typeface.DEFAULT);
      this.f.setImageResource(2131690432);
    }
    Selection.setSelection(this.d.getText(), i);
    this.K3 = false;
  }
  
  private void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setLineColor(2131099808);
      setHintDrawable(this.P3);
      if (this.d.getText().length() > 0) {
        g();
      }
    }
    else
    {
      setLineColor(2131099776);
      setHintDrawable(this.O3);
      if (this.M3) {
        this.q.setVisibility(4);
      }
    }
  }
  
  private void j(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = LayoutInflater.from(paramContext).inflate(2131559114, this, true);
    this.d = ((AppCompatAutoCompleteTextView)findViewById(2131362515));
    this.p0 = ((ImageView)findViewById(2131362517));
    this.f = ((ImageView)findViewById(2131362522));
    this.q = ((ImageView)findViewById(2131362516));
    this.x = findViewById(2131362520);
    this.y = ((TextView)findViewById(2131362518));
    this.z = ((TextView)findViewById(2131362519));
    this.f.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.d.setOnItemClickListener(new a());
    this.d.setOnFocusChangeListener(new b());
    f(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.DrawableEditText);
    this.d.setTextAppearance(getContext(), paramContext.getResourceId(24, 2132018081));
    float f1 = paramContext.getDimension(28, -1.0F);
    paramAttributeSet = paramContext.getColorStateList(25);
    Object localObject = paramContext.getColorStateList(20);
    String str1 = paramContext.getString(23);
    String str2 = paramContext.getString(16);
    if (f1 != -1.0F) {
      this.d.setTextSize(f1);
    }
    if (paramAttributeSet != null) {
      this.d.setTextColor(paramAttributeSet);
    }
    if (localObject != null) {
      this.d.setHintTextColor((ColorStateList)localObject);
    }
    if (str1 != null)
    {
      this.d.setText(str1);
      this.d.setSelection(str1.length());
    }
    if (str2 != null) {
      this.d.setHint(str2);
    }
    this.O3 = paramContext.getDrawable(17);
    paramAttributeSet = paramContext.getDrawable(19);
    this.P3 = paramAttributeSet;
    if (paramAttributeSet == null) {
      this.P3 = this.O3;
    }
    paramAttributeSet = paramContext.getDrawable(18);
    this.Q3 = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      paramAttributeSet = this.P3;
      if (paramAttributeSet != null) {
        this.Q3 = paramAttributeSet;
      } else {
        this.Q3 = this.O3;
      }
    }
    paramAttributeSet = this.O3;
    int i;
    if (paramAttributeSet != null)
    {
      this.p0.setImageDrawable(paramAttributeSet);
      i = paramContext.getDimensionPixelSize(26, b.d.w.f.a.a(getContext(), 14.0F));
      j = paramContext.getDimensionPixelSize(27, b.d.w.f.a.a(getContext(), 14.0F));
      paramAttributeSet = this.d;
      paramAttributeSet.setPadding(i, paramAttributeSet.getPaddingTop(), j, this.d.getPaddingBottom());
    }
    else
    {
      this.p0.setImageDrawable(null);
      j = paramContext.getDimensionPixelSize(26, 0);
      i = paramContext.getDimensionPixelSize(27, 0);
      paramAttributeSet = this.d;
      paramAttributeSet.setPadding(j, paramAttributeSet.getPaddingTop(), i, this.d.getPaddingBottom());
    }
    paramAttributeSet = paramContext.getDrawable(4);
    if (paramAttributeSet != null) {
      this.q.setImageDrawable(paramAttributeSet);
    }
    boolean bool = paramContext.getBoolean(5, true);
    this.M3 = bool;
    if (bool) {
      this.q.setVisibility(4);
    } else {
      this.q.setVisibility(8);
    }
    paramAttributeSet = paramContext.getDrawable(21);
    if (paramAttributeSet != null) {
      this.f.setImageDrawable(paramAttributeSet);
    }
    int j = paramContext.getInt(1, 1);
    this.d.setInputType(j);
    this.d.setTypeface(Typeface.DEFAULT);
    if (j == 129) {
      this.f.setVisibility(0);
    } else if (j == 18) {
      this.f.setVisibility(0);
    } else if (j == 145) {
      this.f.setVisibility(0);
    } else if (j == 225) {
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
    }
    this.y.setTextAppearance(getContext(), paramContext.getResourceId(8, 2132018093));
    f1 = paramContext.getDimension(10, -1.0F);
    paramAttributeSet = paramContext.getColorStateList(9);
    localObject = paramContext.getDrawable(6);
    this.L3 = paramContext.getBoolean(7, true);
    if (f1 != -1.0F) {
      this.y.setTextSize(f1);
    }
    if (paramAttributeSet != null) {
      this.y.setTextColor(paramAttributeSet);
    }
    if (localObject != null) {
      this.y.setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    if (this.L3) {
      this.y.setVisibility(4);
    } else {
      this.y.setVisibility(8);
    }
    this.z.setTextAppearance(getContext(), paramContext.getResourceId(13, 2132018051));
    f1 = paramContext.getDimension(15, -1.0F);
    localObject = paramContext.getColorStateList(14);
    paramAttributeSet = paramContext.getDrawable(11);
    this.N3 = paramContext.getBoolean(12, true);
    if (f1 != -1.0F) {
      this.z.setTextSize(f1);
    }
    if (localObject != null) {
      this.z.setTextColor((ColorStateList)localObject);
    }
    if (paramAttributeSet != null) {
      this.z.setCompoundDrawables(null, null, paramAttributeSet, null);
    }
    if (this.N3) {
      this.z.setVisibility(4);
    } else {
      this.z.setVisibility(8);
    }
    j = paramContext.getInt(2, 0);
    this.p1 = j;
    this.d.setImeOptions(j);
    paramAttributeSet = paramContext.getText(3);
    this.p2 = paramAttributeSet;
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      this.d.setImeActionLabel(this.p2, this.p1);
    }
    j = paramContext.getInt(0, -1);
    if (j != -1) {
      this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(j) });
    }
    if (this.f.getVisibility() == 0)
    {
      this.p3 = paramContext.getBoolean(22, false);
      h();
    }
    paramContext.recycle();
  }
  
  private void setHintDrawable(Drawable paramDrawable)
  {
    this.p0.setImageDrawable(paramDrawable);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0) {
      g();
    } else if (this.M3) {
      this.q.setVisibility(4);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void f(TextWatcher paramTextWatcher)
  {
    if (!this.J3.contains(paramTextWatcher))
    {
      this.J3.add(paramTextWatcher);
      this.d.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public EditText getEditText()
  {
    return this.d;
  }
  
  public View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.H3;
  }
  
  public Editable getText()
  {
    return this.d.getText();
  }
  
  public boolean k()
  {
    return this.K3;
  }
  
  public void l(TextWatcher paramTextWatcher)
  {
    this.J3.remove(paramTextWatcher);
    this.d.removeTextChangedListener(paramTextWatcher);
  }
  
  public void m()
  {
    this.d.setFocusable(true);
    this.d.setFocusableInTouchMode(true);
    this.d.requestFocus();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362516)
    {
      if (i == 2131362522)
      {
        this.p3 ^= true;
        h();
      }
    }
    else {
      this.d.setText("");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public <T extends ListAdapter,  extends Filterable> void setAdapter(T paramT)
  {
    this.d.setAdapter(paramT);
  }
  
  public void setEmailList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.d.setAdapter(new com.tplink.libtpcontrols.y0.a(getContext(), paramList));
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.d.setEnabled(paramBoolean);
    this.q.setEnabled(paramBoolean);
    this.f.setEnabled(paramBoolean);
  }
  
  public void setErrorText(int paramInt)
  {
    setErrorText(getContext().getResources().getText(paramInt));
  }
  
  public void setErrorText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      this.y.setVisibility(0);
      setLineColor(2131099812);
      setHintDrawable(this.Q3);
    }
    else
    {
      if (this.L3) {
        this.y.setVisibility(4);
      } else {
        this.y.setVisibility(8);
      }
      i(this.d.isFocused());
    }
    this.y.setText(paramCharSequence);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    this.d.setFilters(paramArrayOfInputFilter);
  }
  
  public void setHelpText(int paramInt)
  {
    setHelpText(getContext().getResources().getText(paramInt));
  }
  
  public void setHelpText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
      this.z.setVisibility(0);
    } else if (this.N3) {
      this.z.setVisibility(4);
    } else {
      this.z.setVisibility(8);
    }
    this.z.setText(paramCharSequence);
  }
  
  public void setHint(int paramInt)
  {
    this.d.setHint(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    this.d.setHint(paramCharSequence);
  }
  
  public void setLineColor(@ColorRes int paramInt)
  {
    this.x.setBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setMaxLength(int paramInt)
  {
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setNormalList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.d.setAdapter(new ArrayAdapter(getContext(), 2131558731, paramList));
    }
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.d.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.H3 = paramOnFocusChangeListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.I3 = paramOnItemClickListener;
  }
  
  public void setSelectAllOnFocus(boolean paramBoolean)
  {
    this.d.setSelectAllOnFocus(paramBoolean);
  }
  
  public void setSelection(int paramInt)
  {
    this.d.setSelection(paramInt);
  }
  
  public void setText(int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.d.setText(paramCharSequence);
  }
  
  public void setThreshold(int paramInt)
  {
    this.d.setThreshold(paramInt);
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (DrawableEditText.a(DrawableEditText.this) != null) {
        DrawableEditText.a(DrawableEditText.this).onItemClick(paramAdapterView, DrawableEditText.b(DrawableEditText.this), paramInt, paramLong);
      }
    }
  }
  
  class b
    implements View.OnFocusChangeListener
  {
    b() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      DrawableEditText.c(DrawableEditText.this, paramBoolean);
      if (DrawableEditText.d(DrawableEditText.this) != null) {
        DrawableEditText.d(DrawableEditText.this).onFocusChange(DrawableEditText.b(DrawableEditText.this), paramBoolean);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      DrawableEditText.e(DrawableEditText.this).setVisibility(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\DrawableEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */