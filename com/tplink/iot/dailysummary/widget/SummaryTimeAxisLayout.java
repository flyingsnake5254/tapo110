package com.tplink.iot.dailysummary.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.dailysummary.model.c;
import com.tplink.iot.databinding.LayoutSummaryTimeAxisBinding;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SummaryTimeAxisLayout
  extends FrameLayout
  implements SummaryTimeAxisHorizontalScrollView.a, SummaryTimeAxisScaleView.b
{
  public static final a c = new a(null);
  private long H3;
  private LayoutSummaryTimeAxisBinding d;
  private SummaryTimeAxisHorizontalScrollView f;
  private boolean p0;
  private long p1;
  private boolean p2;
  private boolean p3;
  private SummaryTimeAxisScaleView q;
  private Handler x;
  private b y;
  private boolean z;
  
  public SummaryTimeAxisLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public SummaryTimeAxisLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public SummaryTimeAxisLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559233, this, true);
    paramContext = (LayoutSummaryTimeAxisBinding)paramAttributeSet;
    Object localObject = paramContext.d;
    j.d(localObject, "timeAxisScrollview");
    this.f = ((SummaryTimeAxisHorizontalScrollView)localObject);
    localObject = paramContext.c;
    j.d(localObject, "timeAxisScaleview");
    this.q = ((SummaryTimeAxisScaleView)localObject);
    localObject = p.a;
    j.d(paramAttributeSet, "DataBindingUtil.inflate<…meAxisScaleview\n        }");
    this.d = paramContext;
    this.x = new c();
    this.f.setScrollViewListener(this);
    this.q.setScaleViewListener(this);
  }
  
  private final void f(long paramLong)
  {
    this.p1 = paramLong;
    this.q.e(this.p2, paramLong);
  }
  
  private final void setTimeByPlayer(long paramLong)
  {
    f(paramLong);
    if (!this.z)
    {
      int i = this.q.c(this.p1);
      if (i == this.f.getScrollX())
      {
        b localb = this.y;
        if (localb != null) {
          localb.x(this.p1, false);
        }
      }
      else
      {
        this.p0 = true;
        this.f.scrollTo(i, 0);
      }
    }
  }
  
  public void a()
  {
    int i = this.q.c(this.p1);
    this.f.scrollTo(i, 0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    j.e(paramMotionEvent, "ev");
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.p3 = true;
    } else if ((i == 1) || (i == 3)) {
      this.p3 = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void e(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
    this.q.e(paramBoolean, this.p1);
  }
  
  public final long getPlayerCurrentTime()
  {
    return this.H3;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i != 0) {
      this.q.setBlankWidth(j / 2);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.z = true;
    f(this.q.b(paramInt1));
    Object localObject;
    if (this.p0)
    {
      this.p0 = false;
      localObject = this.y;
      if (localObject != null) {
        ((b)localObject).x(this.p1, false);
      }
      this.z = false;
    }
    else
    {
      localObject = this.y;
      if (localObject != null) {
        ((b)localObject).x(this.p1, true);
      }
      if (this.p3) {
        paramInt2 = 1500;
      } else {
        paramInt2 = 200;
      }
      long l = paramInt2;
      localObject = this.x;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0, paramInt1, (int)(this.p1 / 'Ϩ')), l);
    }
  }
  
  public final void setClipSplitPointList(ArrayList<Long> paramArrayList)
  {
    j.e(paramArrayList, "splitPointList");
    this.q.setClipSplitPointList(paramArrayList);
  }
  
  public final void setOnTimeChangedListener(b paramb)
  {
    if (paramb != null) {
      this.y = paramb;
    }
  }
  
  public final void setPlayerCurrentTime(long paramLong)
  {
    setTimeByPlayer(paramLong);
  }
  
  public final void setSummaryDuration(long paramLong)
  {
    this.q.setSummaryDuration(paramLong);
  }
  
  public final void setThumbnailList(LinkedList<c> paramLinkedList)
  {
    j.e(paramLinkedList, "thumbnailList");
    this.q.setThumbnailList(paramLinkedList);
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract void K0(long paramLong);
    
    public abstract void x(long paramLong, boolean paramBoolean);
  }
  
  public final class c
    extends Handler
  {
    public c() {}
    
    public void handleMessage(Message paramMessage)
    {
      j.e(paramMessage, "msg");
      super.handleMessage(paramMessage);
      if ((paramMessage.what == 0) && (paramMessage.arg1 == SummaryTimeAxisLayout.c(SummaryTimeAxisLayout.this).getScrollX()))
      {
        removeCallbacksAndMessages(null);
        int i = paramMessage.arg2;
        paramMessage = SummaryTimeAxisLayout.b(SummaryTimeAxisLayout.this);
        if (paramMessage != null) {
          paramMessage.K0(i * 1000L);
        }
        SummaryTimeAxisLayout.d(SummaryTimeAxisLayout.this, false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\widget\SummaryTimeAxisLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */