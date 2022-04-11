package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.b;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import kotlin.jvm.internal.j;

public final class CameraLoadingView
  extends RelativeLayout
{
  private final TPCircleProgressBar c;
  private final TextView d;
  
  public CameraLoadingView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public CameraLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public CameraLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext);
    j.d(paramContext, "LayoutInflater.from(context)");
    Object localObject1 = paramContext.inflate(2131558734, this, true);
    j.d(localObject1, "inflater.inflate(R.layou…ading_dialog, this, true)");
    paramContext = (LinearLayout)((View)localObject1).findViewById(2131362017);
    Object localObject2 = ((View)localObject1).findViewById(2131363711);
    j.d(localObject2, "view.findViewById(R.id.progress)");
    localObject2 = (TPCircleProgressBar)localObject2;
    this.c = ((TPCircleProgressBar)localObject2);
    ((TPCircleProgressBar)localObject2).setProgressBarColor(ContextCompat.getColor(getContext(), 2131100206));
    if (getVisibility() == 0) {
      ((TPCircleProgressBar)localObject2).h();
    }
    localObject1 = ((View)localObject1).findViewById(2131363452);
    j.d(localObject1, "view.findViewById(R.id.message)");
    localObject1 = (TextView)localObject1;
    this.d = ((TextView)localObject1);
    ((TextView)localObject1).setVisibility(8);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.CameraLoadingView);
    j.d(paramAttributeSet, "getContext().obtainStyle…leable.CameraLoadingView)");
    float f1 = paramAttributeSet.getDimension(0, -1.0F);
    float f2 = paramAttributeSet.getDimension(1, -1.0F);
    paramInt = f1 < 0;
    if (paramInt >= 0)
    {
      j.d(paramContext, "block");
      paramContext.getLayoutParams().height = ((int)f1);
    }
    if (paramInt >= 0)
    {
      j.d(paramContext, "block");
      paramContext.getLayoutParams().width = ((int)f2);
    }
    paramAttributeSet.recycle();
  }
  
  public final void a()
  {
    if (getVisibility() != 0) {
      return;
    }
    this.c.i();
    setVisibility(8);
  }
  
  public final void b()
  {
    if (getVisibility() == 0) {
      return;
    }
    this.c.h();
    setVisibility(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public final void setMessage(String paramString)
  {
    if (paramString != null)
    {
      int i;
      if (paramString.length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.d.setText(paramString);
        this.d.setVisibility(0);
        return;
      }
    }
    this.d.setVisibility(8);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\CameraLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */