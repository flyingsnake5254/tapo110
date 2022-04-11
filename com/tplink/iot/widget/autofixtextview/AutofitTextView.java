package com.tplink.iot.widget.autofixtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public class AutofitTextView
  extends AppCompatTextView
  implements a.d
{
  private a c;
  
  public AutofitTextView(Context paramContext)
  {
    super(paramContext);
    b(paramContext, null, 0);
  }
  
  public AutofitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet, 0);
  }
  
  public AutofitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.c = a.e(this, paramAttributeSet, paramInt).b(this);
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public a getAutofitHelper()
  {
    return this.c;
  }
  
  public float getMaxTextSize()
  {
    return this.c.j();
  }
  
  public float getMinTextSize()
  {
    return this.c.k();
  }
  
  public float getPrecision()
  {
    return this.c.l();
  }
  
  public void setLines(int paramInt)
  {
    super.setLines(paramInt);
    a locala = this.c;
    if (locala != null) {
      locala.o(paramInt);
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    a locala = this.c;
    if (locala != null) {
      locala.o(paramInt);
    }
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    this.c.p(paramFloat);
  }
  
  public void setMinTextSize(int paramInt)
  {
    this.c.r(2, paramInt);
  }
  
  public void setPrecision(float paramFloat)
  {
    this.c.s(paramFloat);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    this.c.n(paramBoolean);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    a locala = this.c;
    if (locala != null) {
      locala.w(paramInt, paramFloat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\autofixtextview\AutofitTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */