package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class TimeAxisLayout
  extends FrameLayout
  implements TimeAxisHorizontalScrollView.b, TimeAxisScaleView.a
{
  private static final String c = TimeAxisLayout.class.getSimpleName();
  private boolean H3 = false;
  private int I3;
  private int J3;
  private int K3;
  private boolean L3 = false;
  private boolean M3 = false;
  private int N3 = 0;
  private int O3 = 0;
  private TimeAxisHorizontalScrollView d;
  private TimeAxisScaleView f;
  private b p0;
  private boolean p1 = false;
  private boolean p2 = false;
  private boolean p3 = false;
  private ImageView q;
  private ImageView x;
  private TextView y;
  private Handler z;
  
  public TimeAxisLayout(Context paramContext)
  {
    super(paramContext);
    q(paramContext);
  }
  
  public TimeAxisLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q(paramContext);
  }
  
  public TimeAxisLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q(paramContext);
  }
  
  private void p()
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null)
    {
      localTimeAxisScaleView.setRecordTimes(null);
      this.f.setMotionDetectTimes(null);
      this.f.setMotionDetectTimesV2(null);
      this.f.setBabyCryDetectTimes(null);
      this.f.setPersonDetectTimes(null);
      this.f.setAreaIntrusionDetectTimes(null);
      this.f.setLineCrossingDetectTimes(null);
      this.f.setCameraTamperDetectTimes(null);
    }
  }
  
  private void q(Context paramContext)
  {
    this.z = new c(null);
    paramContext = LayoutInflater.from(paramContext).inflate(2131559443, this, true);
    this.d = ((TimeAxisHorizontalScrollView)paramContext.findViewById(2131364222));
    this.f = ((TimeAxisScaleView)paramContext.findViewById(2131364221));
    this.q = ((ImageView)paramContext.findViewById(2131364219));
    this.x = ((ImageView)paramContext.findViewById(2131364220));
    this.y = ((TextView)paramContext.findViewById(2131364223));
    this.d.setScrollViewListener(this);
    this.f.setScaleViewListener(this);
    paramContext = this.x;
    if (paramContext != null)
    {
      paramContext = (AnimationDrawable)paramContext.getDrawable();
      if ((paramContext != null) && (!paramContext.isRunning())) {
        paramContext.start();
      }
    }
    t(Status.INIT);
  }
  
  private boolean r(int paramInt)
  {
    boolean bool;
    if ((this.M3) && (paramInt > this.N3 * 3600 + this.O3 * 60)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void setCurrentTimeInternal(int paramInt)
  {
    this.K3 = paramInt;
    this.J3 = paramInt;
    this.I3 = paramInt;
    int i = Math.max(0, paramInt);
    this.I3 = i;
    if (this.M3) {
      paramInt = 90000;
    } else {
      paramInt = 86400;
    }
    paramInt = Math.min(paramInt, i);
    this.I3 = paramInt;
    if ((!this.p2) && (!this.p1))
    {
      paramInt = this.f.f(paramInt);
      if (paramInt == this.d.getScrollX())
      {
        b localb = this.p0;
        if (localb != null) {
          localb.y0(this.K3, false, r(this.I3));
        }
      }
      else
      {
        this.H3 = true;
        this.d.scrollTo(paramInt, 0);
      }
    }
  }
  
  public void a()
  {
    int i = Math.max(0, this.I3);
    this.I3 = i;
    if (this.M3) {
      j = 90000;
    } else {
      j = 86400;
    }
    int j = Math.min(j, i);
    this.I3 = j;
    j = this.f.f(j);
    this.p3 = true;
    this.d.scrollTo(j, 0);
  }
  
  public void b()
  {
    if (this.p1)
    {
      this.p1 = false;
      this.p0.L();
    }
    setCurrentTimeInternal(this.K3);
  }
  
  public void c() {}
  
  public void d(TimeAxisHorizontalScrollView paramTimeAxisHorizontalScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTimeAxisHorizontalScrollView = this.f;
    if (paramTimeAxisHorizontalScrollView == null) {
      return;
    }
    if (this.p1) {
      return;
    }
    this.p2 = true;
    if ((paramInt1 >= 0) && (paramTimeAxisHorizontalScrollView.getValidLength() != 0)) {
      this.I3 = this.f.d(paramInt1);
    } else {
      this.I3 = 0;
    }
    if (this.H3)
    {
      this.H3 = false;
      this.p2 = false;
      paramInt1 = this.J3;
      this.K3 = paramInt1;
      paramTimeAxisHorizontalScrollView = this.p0;
      if (paramTimeAxisHorizontalScrollView != null) {
        paramTimeAxisHorizontalScrollView.y0(paramInt1, false, r(this.I3));
      }
    }
    else if (this.p3)
    {
      this.p3 = false;
      this.p2 = false;
    }
    else
    {
      paramInt2 = this.I3;
      this.K3 = paramInt2;
      paramTimeAxisHorizontalScrollView = this.p0;
      if (paramTimeAxisHorizontalScrollView != null) {
        paramTimeAxisHorizontalScrollView.y0(paramInt2, true, r(paramInt2));
      }
      long l;
      if (this.L3) {
        l = 1500L;
      } else {
        l = 200L;
      }
      paramTimeAxisHorizontalScrollView = this.z;
      paramTimeAxisHorizontalScrollView.sendMessageDelayed(paramTimeAxisHorizontalScrollView.obtainMessage(0, paramInt1, this.I3), l);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.L3 = true;
    } else if ((i == 1) || (i == 3)) {
      this.L3 = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (!this.p1) {
      this.p1 = true;
    }
  }
  
  public void f(float paramFloat)
  {
    this.f.setZoomScale(paramFloat);
    setCurrentTimeInternal(this.K3);
    this.p0.T();
  }
  
  public void g() {}
  
  public int getCurrentTime()
  {
    return this.K3;
  }
  
  public boolean getShowTimeAxis()
  {
    return this.f.i();
  }
  
  public float getZoomRation()
  {
    return this.f.getZoomRatio();
  }
  
  public void o()
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if ((localTimeAxisScaleView != null) && (i != 0)) {
      localTimeAxisScaleView.setBlankWidth(j / 2);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    setCurrentTimeInternal(paramParcelable.c);
    this.f.setZoomRatio(paramParcelable.d);
    Object localObject1 = paramParcelable.f;
    Object localObject2 = new ArrayList(localObject1.length / 2 + 1);
    int j;
    for (int i = 0; i < localObject1.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject2).add(new int[] { localObject1[j], localObject1[(j + 1)] });
    }
    this.f.setRecordTimes((ArrayList)localObject2);
    localObject2 = paramParcelable.q;
    localObject1 = new ArrayList(localObject2.length / 2 + 1);
    for (i = 0; i < localObject2.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject1).add(new int[] { localObject2[j], localObject2[(j + 1)] });
    }
    this.f.setMotionDetectTimes((ArrayList)localObject1);
    localObject1 = paramParcelable.x;
    localObject2 = new ArrayList(localObject1.length / 2 + 1);
    for (i = 0; i < localObject1.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject2).add(new int[] { localObject1[j], localObject1[(j + 1)] });
    }
    this.f.setMotionDetectTimesV2((ArrayList)localObject2);
    localObject2 = paramParcelable.y;
    localObject1 = new ArrayList(localObject2.length / 2 + 1);
    for (i = 0; i < localObject2.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject1).add(new int[] { localObject2[j], localObject2[(j + 1)] });
    }
    this.f.setBabyCryDetectTimes((ArrayList)localObject1);
    localObject1 = paramParcelable.z;
    localObject2 = new ArrayList(localObject1.length / 2 + 1);
    for (i = 0; i < localObject1.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject2).add(new int[] { localObject1[j], localObject1[(j + 1)] });
    }
    this.f.setPersonDetectTimes((ArrayList)localObject2);
    localObject1 = paramParcelable.p0;
    localObject2 = new ArrayList(localObject1.length / 2 + 1);
    for (i = 0; i < localObject1.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject2).add(new int[] { localObject1[j], localObject1[(j + 1)] });
    }
    this.f.setAreaIntrusionDetectTimes((ArrayList)localObject2);
    localObject2 = paramParcelable.p1;
    localObject1 = new ArrayList(localObject2.length / 2 + 1);
    for (i = 0; i < localObject2.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject1).add(new int[] { localObject2[j], localObject2[(j + 1)] });
    }
    this.f.setLineCrossingDetectTimes((ArrayList)localObject1);
    localObject1 = paramParcelable.p2;
    localObject2 = new ArrayList(localObject1.length / 2 + 1);
    for (i = 0; i < localObject1.length / 2; i++)
    {
      j = i * 2;
      ((ArrayList)localObject2).add(new int[] { localObject1[j], localObject1[(j + 1)] });
    }
    this.f.setCameraTamperDetectTimes((ArrayList)localObject2);
    super.onRestoreInstanceState(paramParcelable.getSuperState());
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = this.K3;
    localSavedState.d = this.f.getZoomRatio();
    Object localObject1 = this.f.getRecordTimes();
    Object localObject2 = new int[((ArrayList)localObject1).size() * 2];
    int j;
    for (int i = 0; i < ((ArrayList)localObject1).size(); i++)
    {
      j = i * 2;
      localObject2[j] = ((int[])localObject1.get(i))[0];
      localObject2[(j + 1)] = ((int[])localObject1.get(i))[1];
    }
    localSavedState.f = ((int[])localObject2);
    localObject1 = this.f.getMotionDetectTimes();
    localObject2 = new int[((ArrayList)localObject1).size() * 2];
    for (i = 0; i < ((ArrayList)localObject1).size(); i++)
    {
      j = i * 2;
      localObject2[j] = ((int[])localObject1.get(i))[0];
      localObject2[(j + 1)] = ((int[])localObject1.get(i))[1];
    }
    localSavedState.q = ((int[])localObject2);
    localObject1 = this.f.getMotionDetectTimesV2();
    localObject2 = new int[((ArrayList)localObject1).size() * 2];
    for (i = 0; i < ((ArrayList)localObject1).size(); i++)
    {
      j = i * 2;
      localObject2[j] = ((int[])localObject1.get(i))[0];
      localObject2[(j + 1)] = ((int[])localObject1.get(i))[1];
    }
    localSavedState.x = ((int[])localObject2);
    localObject2 = this.f.getBabyCryDetectTimes();
    localObject1 = new int[((ArrayList)localObject2).size() * 2];
    for (i = 0; i < ((ArrayList)localObject2).size(); i++)
    {
      j = i * 2;
      localObject1[j] = ((int[])localObject2.get(i))[0];
      localObject1[(j + 1)] = ((int[])localObject2.get(i))[1];
    }
    localSavedState.y = ((int[])localObject1);
    localObject2 = this.f.getPersonDetectTimes();
    localObject1 = new int[((ArrayList)localObject2).size() * 2];
    for (i = 0; i < ((ArrayList)localObject2).size(); i++)
    {
      j = i * 2;
      localObject1[j] = ((int[])localObject2.get(i))[0];
      localObject1[(j + 1)] = ((int[])localObject2.get(i))[1];
    }
    localSavedState.z = ((int[])localObject1);
    localObject2 = this.f.getAreaIntrusionDetectTimes();
    localObject1 = new int[((ArrayList)localObject2).size() * 2];
    for (i = 0; i < ((ArrayList)localObject2).size(); i++)
    {
      j = i * 2;
      localObject1[j] = ((int[])localObject2.get(i))[0];
      localObject1[(j + 1)] = ((int[])localObject2.get(i))[1];
    }
    localSavedState.p0 = ((int[])localObject1);
    localObject1 = this.f.getLineCrossingDetectTimes();
    localObject2 = new int[((ArrayList)localObject1).size() * 2];
    for (i = 0; i < ((ArrayList)localObject1).size(); i++)
    {
      j = i * 2;
      localObject2[j] = ((int[])localObject1.get(i))[0];
      localObject2[(j + 1)] = ((int[])localObject1.get(i))[1];
    }
    localSavedState.p1 = ((int[])localObject2);
    localObject2 = this.f.getCameraTamperDetectTimes();
    localObject1 = new int[((ArrayList)localObject2).size() * 2];
    for (i = 0; i < ((ArrayList)localObject2).size(); i++)
    {
      j = i * 2;
      localObject1[j] = ((int[])localObject2.get(i))[0];
      localObject1[(j + 1)] = ((int[])localObject2.get(i))[1];
    }
    localSavedState.p2 = ((int[])localObject1);
    return localSavedState;
  }
  
  public void s(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.M3 = paramBoolean;
    this.N3 = paramInt1;
    this.O3 = paramInt2;
    this.f.l(paramBoolean, paramInt1, paramInt2);
  }
  
  public void setAreaIntrusionDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setAreaIntrusionDetectTimes(paramArrayList);
    }
  }
  
  public void setBabyCryDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setBabyCryDetectTimes(paramArrayList);
    }
  }
  
  public void setCameraTamperDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setCameraTamperDetectTimes(paramArrayList);
    }
  }
  
  public void setCurrentTime(int paramInt)
  {
    setCurrentTimeInternal(paramInt);
  }
  
  public void setIOnTimeChangedListener(b paramb)
  {
    this.p0 = paramb;
  }
  
  public void setInterceptTouch(boolean paramBoolean)
  {
    this.d.setInterceptTouch(paramBoolean);
  }
  
  public void setLineCrossingDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setLineCrossingDetectTimes(paramArrayList);
    }
  }
  
  public void setMotionDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setMotionDetectTimes(paramArrayList);
    }
  }
  
  public void setMotionDetectTimesV2(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setMotionDetectTimesV2(paramArrayList);
    }
  }
  
  public void setPersonDetectTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setPersonDetectTimes(paramArrayList);
    }
  }
  
  public void setRecordTimes(ArrayList<int[]> paramArrayList)
  {
    TimeAxisScaleView localTimeAxisScaleView = this.f;
    if (localTimeAxisScaleView != null) {
      localTimeAxisScaleView.setRecordTimes(paramArrayList);
    }
  }
  
  public void setZoomRatio(float paramFloat)
  {
    this.f.setZoomRatio(paramFloat);
  }
  
  public void t(Status paramStatus)
  {
    int i = a.a[paramStatus.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        this.y.setVisibility(8);
        this.x.setVisibility(8);
        this.q.setVisibility(0);
      }
    }
    else
    {
      this.q.setVisibility(0);
      this.y.setVisibility(8);
      this.x.setVisibility(8);
      p();
      setCurrentTime(43200);
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int c;
    float d;
    int[] f;
    int[] p0;
    int[] p1;
    int[] p2;
    int[] q;
    int[] x;
    int[] y;
    int[] z;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readFloat();
      this.f = paramParcel.createIntArray();
      this.q = paramParcel.createIntArray();
      this.x = paramParcel.createIntArray();
      this.y = paramParcel.createIntArray();
      this.z = paramParcel.createIntArray();
      this.p0 = paramParcel.createIntArray();
      this.p1 = paramParcel.createIntArray();
      this.p2 = paramParcel.createIntArray();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeIntArray(this.f);
      paramParcel.writeIntArray(this.q);
      paramParcel.writeIntArray(this.x);
      paramParcel.writeIntArray(this.y);
      paramParcel.writeIntArray(this.z);
      paramParcel.writeIntArray(this.p0);
      paramParcel.writeIntArray(this.p1);
      paramParcel.writeIntArray(this.p2);
    }
    
    static final class a
      implements Parcelable.Creator<TimeAxisLayout.SavedState>
    {
      public TimeAxisLayout.SavedState a(Parcel paramParcel)
      {
        return new TimeAxisLayout.SavedState(paramParcel);
      }
      
      public TimeAxisLayout.SavedState[] b(int paramInt)
      {
        return new TimeAxisLayout.SavedState[paramInt];
      }
    }
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("INIT", 0);
      INIT = localStatus1;
      Status localStatus2 = new Status("LOADING", 1);
      LOADING = localStatus2;
      Status localStatus3 = new Status("TIPS", 2);
      TIPS = localStatus3;
      Status localStatus4 = new Status("DATA", 3);
      DATA = localStatus4;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3, localStatus4 };
    }
  }
  
  public static abstract interface b
  {
    public abstract void L();
    
    public abstract void T();
    
    public abstract void x(int paramInt, boolean paramBoolean);
    
    public abstract void y0(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  private class c
    extends Handler
  {
    private c() {}
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if ((paramMessage.what == 0) && (paramMessage.arg1 == TimeAxisLayout.h(TimeAxisLayout.this).getScrollX()))
      {
        removeCallbacksAndMessages(null);
        int i = paramMessage.arg2;
        TimeAxisLayout.i(TimeAxisLayout.this, i);
        boolean bool;
        if ((TimeAxisLayout.j(TimeAxisLayout.this)) && (i > TimeAxisLayout.k(TimeAxisLayout.this) * 3600 + TimeAxisLayout.l(TimeAxisLayout.this) * 60)) {
          bool = true;
        } else {
          bool = false;
        }
        if (TimeAxisLayout.m(TimeAxisLayout.this) != null) {
          TimeAxisLayout.m(TimeAxisLayout.this).x(i, bool);
        }
        TimeAxisLayout.n(TimeAxisLayout.this, false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\timeaxis\TimeAxisLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */