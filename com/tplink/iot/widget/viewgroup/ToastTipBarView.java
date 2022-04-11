package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.core.widget.ImageViewCompat;
import com.tplink.iot.b;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ToastTipBarView
  extends FrameLayout
{
  private final View c;
  private final TextView d;
  private final TextView f;
  private final ImageView q;
  private boolean x = true;
  
  public ToastTipBarView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public ToastTipBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public ToastTipBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View localView1 = LayoutInflater.from(paramContext).inflate(2131559446, this, true);
    View localView2 = localView1.findViewById(2131363918);
    j.d(localView2, "findViewById(R.id.root)");
    this.c = localView2;
    localView2 = localView1.findViewById(2131364667);
    j.d(localView2, "findViewById(R.id.tv_text)");
    this.d = ((TextView)localView2);
    localView2 = localView1.findViewById(2131364327);
    j.d(localView2, "findViewById(R.id.tv_action)");
    this.f = ((TextView)localView2);
    localView1 = localView1.findViewById(2131362998);
    j.d(localView1, "findViewById(R.id.iv_arrow_right)");
    this.q = ((ImageView)localView1);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.ToastTipBarView);
    if (paramAttributeSet.hasValue(4)) {
      setMessage(paramAttributeSet.getString(4));
    }
    if (paramAttributeSet.hasValue(0)) {
      setActionText(paramAttributeSet.getString(0));
    }
    if (paramAttributeSet.hasValue(1)) {
      setActionTextColor(paramAttributeSet.getColor(1, paramContext.getResources().getColor(2131099808)));
    }
    setArrowRightColor(paramAttributeSet.getColor(2, -1));
    setArrowRightVisible(paramAttributeSet.getBoolean(3, false));
    paramAttributeSet.recycle();
    a();
  }
  
  private final void setActionTextWithUnderline(CharSequence paramCharSequence)
  {
    if (this.x)
    {
      int i;
      if (paramCharSequence.length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        TextView localTextView = this.f;
        SpannableString localSpannableString = new SpannableString(paramCharSequence);
        localSpannableString.setSpan(new UnderlineSpan(), 0, paramCharSequence.length(), 33);
        paramCharSequence = p.a;
        localTextView.setText(localSpannableString);
        return;
      }
    }
    this.f.setText(paramCharSequence);
  }
  
  public final void a()
  {
    setVisibility(8);
  }
  
  public final void b()
  {
    if (getVisibility() != 0) {
      c();
    }
  }
  
  public final void c()
  {
    setVisibility(0);
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772062));
  }
  
  public final void d(int paramInt)
  {
    c();
    new Handler().postDelayed(new a(this), paramInt);
  }
  
  public final void setActionText(@StringRes int paramInt)
  {
    String str = getContext().getString(paramInt);
    j.d(str, "context.getString(resId)");
    setActionTextWithUnderline(str);
  }
  
  public final void setActionText(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    setActionTextWithUnderline(paramString);
  }
  
  public final void setActionTextColor(@ColorInt int paramInt)
  {
    this.f.setTextColor(paramInt);
  }
  
  public final void setActionTextUnderlineEnabled(boolean paramBoolean)
  {
    this.x = paramBoolean;
    Object localObject = this.f.getText();
    if (localObject == null) {
      localObject = "";
    }
    setActionTextWithUnderline((CharSequence)localObject);
  }
  
  public final void setArrowRightColor(@ColorInt int paramInt)
  {
    ImageViewCompat.setImageTintList(this.q, ColorStateList.valueOf(paramInt));
  }
  
  public final void setArrowRightVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.q;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public final void setMessage(@StringRes int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public final void setMessage(String paramString)
  {
    TextView localTextView = this.d;
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText(paramString);
  }
  
  public final void setMessageColor(@ColorInt int paramInt)
  {
    this.d.setTextColor(paramInt);
  }
  
  public final void setOnActionTextClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnTipBarClickListener(View.OnClickListener paramOnClickListener)
  {
    setOnClickListener(paramOnClickListener);
  }
  
  static final class a
    implements Runnable
  {
    a(ToastTipBarView paramToastTipBarView) {}
    
    public final void run()
    {
      this.c.a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\ToastTipBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */