package com.tplink.iot.widget.autofixtextview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private TextView a;
  private TextPaint b;
  private float c;
  private int d;
  private float e;
  private float f;
  private float g;
  private boolean h;
  private boolean i;
  private ArrayList<d> j;
  private TextWatcher k = new c(null);
  private View.OnLayoutChangeListener l = new b(null);
  
  private a(TextView paramTextView)
  {
    float f1 = paramTextView.getContext().getResources().getDisplayMetrics().scaledDensity;
    this.a = paramTextView;
    this.b = new TextPaint();
    v(paramTextView.getTextSize());
    this.d = i(paramTextView);
    this.e = (f1 * 8.0F);
    this.f = this.c;
    this.g = 0.5F;
  }
  
  private void c()
  {
    float f1 = this.a.getTextSize();
    this.i = true;
    d(this.a, this.b, this.f, this.e, this.d, this.g);
    this.i = false;
    float f2 = this.a.getTextSize();
    if (f2 != f1) {
      m(f2, f1);
    }
  }
  
  private static void d(TextView paramTextView, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    float f1 = paramTextView.getTextSize();
    if ((paramInt > 0) && (paramInt != Integer.MAX_VALUE))
    {
      int m = paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight();
      if (m <= 0) {
        return;
      }
      Object localObject1 = paramTextView.getText();
      Object localObject2 = paramTextView.getTransformationMethod();
      Object localObject3 = localObject1;
      if (localObject2 != null) {
        localObject3 = ((TransformationMethod)localObject2).getTransformation((CharSequence)localObject1, paramTextView);
      }
      localObject2 = paramTextView.getContext();
      localObject1 = Resources.getSystem();
      if (localObject2 != null) {
        localObject1 = ((Context)localObject2).getResources();
      }
      localObject1 = ((Resources)localObject1).getDisplayMetrics();
      if (f1 >= paramFloat1) {
        f1 = paramFloat1;
      }
      paramTextPaint.set(paramTextView.getPaint());
      paramTextPaint.setTextSize(f1);
      float f2;
      if ((paramInt != 1) || (paramTextPaint.measureText((CharSequence)localObject3, 0, ((CharSequence)localObject3).length()) <= m))
      {
        f2 = f1;
        if (h((CharSequence)localObject3, paramTextPaint, f1, m, (DisplayMetrics)localObject1) <= paramInt) {}
      }
      else
      {
        paramFloat1 = g((CharSequence)localObject3, paramTextPaint, m, paramInt, 0.0F, paramFloat1, paramFloat3, (DisplayMetrics)localObject1);
        f2 = paramFloat1;
        if (paramFloat1 < paramFloat2) {
          f2 = paramFloat2;
        }
      }
      paramTextView.setTextSize(0, f2);
    }
  }
  
  public static a e(TextView paramTextView, AttributeSet paramAttributeSet, int paramInt)
  {
    a locala = new a(paramTextView);
    boolean bool = true;
    if (paramAttributeSet != null)
    {
      paramTextView = paramTextView.getContext();
      int m = (int)locala.k();
      float f1 = locala.l();
      paramTextView = paramTextView.obtainStyledAttributes(paramAttributeSet, b.AutofitTextView, paramInt, 0);
      bool = paramTextView.getBoolean(2, true);
      paramInt = paramTextView.getDimensionPixelSize(0, m);
      f1 = paramTextView.getFloat(1, f1);
      paramTextView.recycle();
      locala.r(0, paramInt).s(f1);
    }
    locala.n(bool);
    return locala;
  }
  
  public static a f(TextView paramTextView, AttributeSet paramAttributeSet, int paramInt)
  {
    a locala = new a(paramTextView);
    boolean bool = true;
    if (paramAttributeSet != null)
    {
      paramTextView = paramTextView.getContext();
      int m = (int)locala.k();
      float f1 = locala.l();
      paramTextView = paramTextView.obtainStyledAttributes(paramAttributeSet, b.AutofitRadioButton, paramInt, 0);
      bool = paramTextView.getBoolean(2, true);
      paramInt = paramTextView.getDimensionPixelSize(0, m);
      f1 = paramTextView.getFloat(1, f1);
      paramTextView.recycle();
      locala.r(0, paramInt).s(f1);
    }
    locala.n(bool);
    return locala;
  }
  
  private static float g(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = (paramFloat2 + paramFloat3) / 2.0F;
    int m = 0;
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, f1, paramDisplayMetrics));
    StaticLayout localStaticLayout;
    int n;
    if (paramInt != 1)
    {
      localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      n = localStaticLayout.getLineCount();
    }
    else
    {
      localStaticLayout = null;
      n = 1;
    }
    if (n > paramInt)
    {
      if (paramFloat3 - paramFloat2 < paramFloat4) {
        return paramFloat2;
      }
      return g(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f1, paramFloat4, paramDisplayMetrics);
    }
    if (n < paramInt) {
      return g(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f1, paramFloat3, paramFloat4, paramDisplayMetrics);
    }
    float f2 = 0.0F;
    if (paramInt == 1) {
      f2 = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
    } else {
      while (m < n)
      {
        float f3 = f2;
        if (localStaticLayout.getLineWidth(m) > f2) {
          f3 = localStaticLayout.getLineWidth(m);
        }
        m++;
        f2 = f3;
      }
    }
    if (paramFloat3 - paramFloat2 < paramFloat4) {
      return paramFloat2;
    }
    if (f2 > paramFloat1) {
      return g(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f1, paramFloat4, paramDisplayMetrics);
    }
    if (f2 < paramFloat1) {
      return g(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f1, paramFloat3, paramFloat4, paramDisplayMetrics);
    }
    return f1;
  }
  
  private static int h(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, DisplayMetrics paramDisplayMetrics)
  {
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat1, paramDisplayMetrics));
    return new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount();
  }
  
  private static int i(TextView paramTextView)
  {
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    int m;
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      m = 1;
    } else if (Build.VERSION.SDK_INT >= 16) {
      m = paramTextView.getMaxLines();
    } else {
      m = -1;
    }
    return m;
  }
  
  private void m(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d)((Iterator)localObject).next()).a(paramFloat1, paramFloat2);
    }
  }
  
  private void t(float paramFloat)
  {
    if (paramFloat != this.f)
    {
      this.f = paramFloat;
      c();
    }
  }
  
  private void u(float paramFloat)
  {
    if (paramFloat != this.e)
    {
      this.e = paramFloat;
      c();
    }
  }
  
  private void v(float paramFloat)
  {
    if (this.c != paramFloat) {
      this.c = paramFloat;
    }
  }
  
  public a b(d paramd)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    this.j.add(paramd);
    return this;
  }
  
  public float j()
  {
    return this.f;
  }
  
  public float k()
  {
    return this.e;
  }
  
  public float l()
  {
    return this.g;
  }
  
  public a n(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      if (paramBoolean)
      {
        this.a.addTextChangedListener(this.k);
        this.a.addOnLayoutChangeListener(this.l);
        c();
      }
      else
      {
        this.a.removeTextChangedListener(this.k);
        this.a.removeOnLayoutChangeListener(this.l);
        this.a.setTextSize(0, this.c);
      }
    }
    return this;
  }
  
  public a o(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      c();
    }
    return this;
  }
  
  public a p(float paramFloat)
  {
    return q(2, paramFloat);
  }
  
  public a q(int paramInt, float paramFloat)
  {
    Context localContext = this.a.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    t(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    return this;
  }
  
  public a r(int paramInt, float paramFloat)
  {
    Context localContext = this.a.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    u(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    return this;
  }
  
  public a s(float paramFloat)
  {
    if (this.g != paramFloat)
    {
      this.g = paramFloat;
      c();
    }
    return this;
  }
  
  public void w(int paramInt, float paramFloat)
  {
    if (this.i) {
      return;
    }
    Context localContext = this.a.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    v(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
  }
  
  private class b
    implements View.OnLayoutChangeListener
  {
    private b() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      a.a(a.this);
    }
  }
  
  private class c
    implements TextWatcher
  {
    private c() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      a.a(a.this);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(float paramFloat1, float paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\autofixtextview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */