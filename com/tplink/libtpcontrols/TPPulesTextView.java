package com.tplink.libtpcontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import io.reactivex.e0.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TPPulesTextView
  extends AppCompatTextView
{
  private boolean c = false;
  private CharSequence d = "";
  private List<String> f = new ArrayList();
  private c q;
  private long x = 500L;
  private TimeUnit y = TimeUnit.MILLISECONDS;
  
  public TPPulesTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPPulesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TPPulesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c localc = this.q;
    if ((localc != null) && (!localc.isDisposed())) {
      this.q.dispose();
    }
  }
  
  public void setDefaultText(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPPulesTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */