package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tplink.iot.b;
import kotlin.jvm.internal.j;

public final class ItemInfoLayout
  extends FrameLayout
{
  private final TextView c;
  private final TextView d;
  private final View f;
  
  public ItemInfoLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public ItemInfoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public ItemInfoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View localView1 = LayoutInflater.from(paramContext).inflate(2131559423, this, true);
    View localView2 = localView1.findViewById(2131364688);
    j.d(localView2, "rootView.findViewById(R.id.tv_title)");
    this.c = ((TextView)localView2);
    localView2 = localView1.findViewById(2131364488);
    j.d(localView2, "rootView.findViewById(R.id.tv_info)");
    this.d = ((TextView)localView2);
    localView1 = localView1.findViewById(2131362470);
    j.d(localView1, "rootView.findViewById(R.id.divider)");
    this.f = localView1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ItemInfoLayout);
    setTitleText(paramContext.getString(2));
    setInfoText(paramContext.getString(1));
    setDividerLineVisibility(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  public final void setDividerLineVisibility(boolean paramBoolean)
  {
    View localView = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public final void setInfoText(@StringRes int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public final void setInfoText(String paramString)
  {
    TextView localTextView = this.d;
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText(paramString);
  }
  
  public final void setTitleText(@StringRes int paramInt)
  {
    this.c.setText(paramInt);
  }
  
  public final void setTitleText(String paramString)
  {
    TextView localTextView = this.c;
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\ItemInfoLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */