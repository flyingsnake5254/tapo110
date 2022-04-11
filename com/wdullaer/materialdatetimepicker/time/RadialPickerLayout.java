package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.Calendar;
import java.util.List;

public class RadialPickerLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  private RadialTextsView H3;
  private RadialTextsView I3;
  private RadialTextsView J3;
  private RadialSelectorView K3;
  private RadialSelectorView L3;
  private RadialSelectorView M3;
  private View N3;
  private int[] O3;
  private boolean P3;
  private int Q3 = -1;
  private boolean R3;
  private boolean S3;
  private int T3;
  private float U3;
  private float V3;
  private AccessibilityManager W3;
  private Handler X3 = new Handler();
  private final int c;
  private final int d;
  private Timepoint f;
  private boolean p0;
  private int p1;
  private CircleView p2;
  private AmPmCirclesView p3;
  private a q;
  private c x;
  private boolean y;
  private Timepoint z;
  
  public RadialPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener(this);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.d = ViewConfiguration.getTapTimeout();
    this.R3 = false;
    paramAttributeSet = new CircleView(paramContext);
    this.p2 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new AmPmCirclesView(paramContext);
    this.p3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialSelectorView(paramContext);
    this.K3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialSelectorView(paramContext);
    this.L3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialSelectorView(paramContext);
    this.M3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialTextsView(paramContext);
    this.H3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialTextsView(paramContext);
    this.I3 = paramAttributeSet;
    addView(paramAttributeSet);
    paramAttributeSet = new RadialTextsView(paramContext);
    this.J3 = paramAttributeSet;
    addView(paramAttributeSet);
    n();
    this.f = null;
    this.P3 = true;
    paramAttributeSet = new View(paramContext);
    this.N3 = paramAttributeSet;
    paramAttributeSet.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.N3.setBackgroundColor(ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_transparent_black));
    this.N3.setVisibility(4);
    addView(this.N3);
    this.W3 = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.y = false;
  }
  
  private int getCurrentlyShowingValue()
  {
    int i = getCurrentItemShowing();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return -1;
        }
        return this.z.d();
      }
      return this.z.c();
    }
    return this.z.b();
  }
  
  private int k(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    int i = getCurrentItemShowing();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return -1;
        }
        return this.M3.a(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
      }
      return this.L3.a(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
    }
    return this.K3.a(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
  }
  
  private Timepoint l(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = getCurrentItemShowing();
    int j = 0;
    if ((!paramBoolean2) && ((i == 1) || (i == 2))) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      k = s(paramInt);
    } else {
      k = r(paramInt, 0);
    }
    int m = 6;
    if (i == 0) {
      m = 30;
    }
    if (i == 0)
    {
      if (this.p0)
      {
        if ((k != 0) || (!paramBoolean1))
        {
          paramInt = k;
          if (k != 360) {
            break label167;
          }
          paramInt = k;
          if (paramBoolean1) {
            break label167;
          }
          break label165;
        }
      }
      else
      {
        paramInt = k;
        if (k != 0) {
          break label167;
        }
      }
      paramInt = 360;
      break label167;
    }
    else
    {
      paramInt = k;
      if (k != 360) {
        break label167;
      }
      if (i != 1)
      {
        paramInt = k;
        if (i != 2) {
          break label167;
        }
      }
    }
    label165:
    paramInt = 0;
    label167:
    int k = paramInt / m;
    m = k;
    if (i == 0)
    {
      m = k;
      if (this.p0)
      {
        m = k;
        if (!paramBoolean1)
        {
          m = k;
          if (paramInt != 0) {
            m = k + 12;
          }
        }
      }
    }
    k = m;
    if (i == 0)
    {
      k = m;
      if (this.q.getVersion() != TimePickerDialog.Version.VERSION_1)
      {
        k = m;
        if (this.p0) {
          k = (m + 12) % 24;
        }
      }
    }
    Timepoint localTimepoint;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          localTimepoint = this.z;
        } else {
          localTimepoint = new Timepoint(this.z.b(), this.z.c(), k);
        }
      }
      else {
        localTimepoint = new Timepoint(this.z.b(), k, this.z.d());
      }
    }
    else
    {
      m = k;
      if (!this.p0)
      {
        m = k;
        if (getIsCurrentlyAmOrPm() == 1)
        {
          m = k;
          if (paramInt != 360) {
            m = k + 12;
          }
        }
      }
      if ((!this.p0) && (getIsCurrentlyAmOrPm() == 0) && (paramInt == 360)) {
        paramInt = j;
      } else {
        paramInt = m;
      }
      localTimepoint = new Timepoint(paramInt, this.z.c(), this.z.d());
    }
    return localTimepoint;
  }
  
  private boolean m(int paramInt)
  {
    boolean bool1 = false;
    if ((paramInt <= 12) && (paramInt != 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = paramInt;
    if (this.q.getVersion() != TimePickerDialog.Version.VERSION_1) {
      i = paramInt ^ 0x1;
    }
    boolean bool2 = bool1;
    if (this.p0)
    {
      bool2 = bool1;
      if (i != 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void n()
  {
    this.O3 = new int['ũ'];
    int i = 0;
    int j = 0;
    int k = 8;
    int m = 1;
    while (i < 361)
    {
      this.O3[i] = j;
      if (m == k)
      {
        j += 6;
        if (j == 360) {
          m = 7;
        } else if (j % 30 == 0) {
          m = 14;
        } else {
          m = 4;
        }
        int n = 1;
        k = m;
        m = n;
      }
      else
      {
        m++;
      }
      i++;
    }
  }
  
  private void o(Timepoint paramTimepoint, boolean paramBoolean, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          paramInt = paramTimepoint.d();
          this.M3.b(paramInt * 6, false, paramBoolean);
          this.J3.setSelection(paramTimepoint.d());
        }
      }
      else
      {
        paramInt = paramTimepoint.c();
        this.L3.b(paramInt * 6, false, paramBoolean);
        this.I3.setSelection(paramTimepoint.c());
        if (paramTimepoint.d() != this.z.d())
        {
          paramInt = paramTimepoint.d();
          this.M3.b(paramInt * 6, false, paramBoolean);
          this.J3.setSelection(paramTimepoint.d());
        }
      }
    }
    else
    {
      paramInt = paramTimepoint.b();
      boolean bool1 = m(paramInt);
      int i = paramInt % 12;
      int j = i * 360 / 12;
      boolean bool2 = this.p0;
      if (!bool2) {
        paramInt = i;
      }
      i = paramInt;
      if (!bool2)
      {
        i = paramInt;
        if (paramInt == 0) {
          i = paramInt + 12;
        }
      }
      this.K3.b(j, bool1, paramBoolean);
      this.H3.setSelection(i);
      if (paramTimepoint.c() != this.z.c())
      {
        paramInt = paramTimepoint.c();
        this.L3.b(paramInt * 6, bool1, paramBoolean);
        this.I3.setSelection(paramTimepoint.c());
      }
      if (paramTimepoint.d() != this.z.d())
      {
        paramInt = paramTimepoint.d();
        this.M3.b(paramInt * 6, bool1, paramBoolean);
        this.J3.setSelection(paramTimepoint.d());
      }
    }
    paramInt = getCurrentItemShowing();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          this.M3.invalidate();
          this.J3.invalidate();
        }
      }
      else
      {
        this.L3.invalidate();
        this.I3.invalidate();
      }
    }
    else
    {
      this.K3.invalidate();
      this.H3.invalidate();
    }
  }
  
  private Timepoint p(Timepoint paramTimepoint, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return this.q.b(paramTimepoint, Timepoint.TYPE.MINUTE);
      }
      return this.q.b(paramTimepoint, Timepoint.TYPE.HOUR);
    }
    return this.q.b(paramTimepoint, null);
  }
  
  private void q(int paramInt, Timepoint paramTimepoint)
  {
    paramTimepoint = p(paramTimepoint, paramInt);
    this.z = paramTimepoint;
    o(paramTimepoint, false, paramInt);
  }
  
  private static int r(int paramInt1, int paramInt2)
  {
    int i = paramInt1 / 30 * 30;
    int j = i + 30;
    if (paramInt2 != 1)
    {
      if (paramInt2 == -1)
      {
        paramInt2 = i;
        if (paramInt1 != i) {
          return paramInt2;
        }
        return i - 30;
      }
      if (paramInt1 - i < j - paramInt1) {
        return i;
      }
    }
    paramInt2 = j;
    return paramInt2;
  }
  
  private int s(int paramInt)
  {
    int[] arrayOfInt = this.O3;
    if (arrayOfInt == null) {
      return -1;
    }
    return arrayOfInt[paramInt];
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.getText().clear();
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).set(10, getHours());
      ((Calendar)localObject).set(12, getMinutes());
      ((Calendar)localObject).set(13, getSeconds());
      long l = ((Calendar)localObject).getTimeInMillis();
      int i;
      if (this.p0) {
        i = 129;
      } else {
        i = 1;
      }
      localObject = DateUtils.formatDateTime(getContext(), l, i);
      paramAccessibilityEvent.getText().add(localObject);
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public int getCurrentItemShowing()
  {
    int i = this.p1;
    int j = i;
    if (i != 0)
    {
      j = i;
      if (i != 1)
      {
        j = i;
        if (i != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Current item showing was unfortunately set to ");
          localStringBuilder.append(this.p1);
          Log.e("RadialPickerLayout", localStringBuilder.toString());
          j = -1;
        }
      }
    }
    return j;
  }
  
  public int getHours()
  {
    return this.z.b();
  }
  
  public int getIsCurrentlyAmOrPm()
  {
    if (this.z.e()) {
      return 0;
    }
    if (this.z.f()) {
      return 1;
    }
    return -1;
  }
  
  public int getMinutes()
  {
    return this.z.c();
  }
  
  public int getSeconds()
  {
    return this.z.d();
  }
  
  public Timepoint getTime()
  {
    return this.z;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
      paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
    }
    else if (i >= 16)
    {
      paramAccessibilityNodeInfo.addAction(4096);
      paramAccessibilityNodeInfo.addAction(8192);
    }
    else
    {
      paramAccessibilityNodeInfo.addAction(4096);
      paramAccessibilityNodeInfo.addAction(8192);
    }
  }
  
  public boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramView = new Boolean[1];
    paramView[0] = Boolean.FALSE;
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          if (!this.P3)
          {
            Log.e("RadialPickerLayout", "Input was disabled, but received ACTION_MOVE.");
            return true;
          }
          float f3 = Math.abs(f2 - this.V3);
          float f4 = Math.abs(f1 - this.U3);
          if (!this.R3)
          {
            i = this.c;
            if ((f4 <= i) && (f3 <= i)) {}
          }
          else
          {
            i = this.Q3;
            if ((i != 0) && (i != 1))
            {
              if (this.T3 != -1)
              {
                this.R3 = true;
                this.X3.removeCallbacksAndMessages(null);
                i = k(f1, f2, true, paramView);
                if (i != -1)
                {
                  paramMotionEvent = p(l(i, paramView[0].booleanValue(), false), getCurrentItemShowing());
                  o(paramMotionEvent, true, getCurrentItemShowing());
                  if (paramMotionEvent != null)
                  {
                    paramView = this.f;
                    if ((paramView == null) || (!paramView.equals(paramMotionEvent)))
                    {
                      this.q.a();
                      this.f = paramMotionEvent;
                      this.x.a(paramMotionEvent);
                    }
                  }
                }
                return true;
              }
            }
            else
            {
              this.X3.removeCallbacksAndMessages(null);
              if (this.p3.a(f1, f2) != this.Q3)
              {
                this.p3.setAmOrPmPressed(-1);
                this.p3.invalidate();
                this.Q3 = -1;
              }
            }
          }
        }
      }
      else
      {
        if (!this.P3)
        {
          Log.d("RadialPickerLayout", "Input was disabled, but received ACTION_UP.");
          this.x.b();
          return true;
        }
        this.X3.removeCallbacksAndMessages(null);
        this.S3 = false;
        i = this.Q3;
        if ((i != 0) && (i != 1))
        {
          if (this.T3 != -1)
          {
            i = k(f1, f2, this.R3, paramView);
            if (i != -1)
            {
              paramView = p(l(i, paramView[0].booleanValue(), this.R3 ^ true), getCurrentItemShowing());
              o(paramView, false, getCurrentItemShowing());
              this.z = paramView;
              this.x.a(paramView);
              this.x.c(getCurrentItemShowing());
            }
          }
          this.R3 = false;
          return true;
        }
        i = this.p3.a(f1, f2);
        this.p3.setAmOrPmPressed(-1);
        this.p3.invalidate();
        if (i == this.Q3)
        {
          this.p3.setAmOrPm(i);
          if (getIsCurrentlyAmOrPm() != i)
          {
            paramView = new Timepoint(this.z);
            i = this.Q3;
            if (i == 0) {
              paramView.h();
            } else if (i == 1) {
              paramView.i();
            }
            paramView = p(paramView, 0);
            o(paramView, false, 0);
            this.z = paramView;
            this.x.a(paramView);
          }
        }
        this.Q3 = -1;
      }
      return false;
    }
    if (!this.P3) {
      return true;
    }
    this.U3 = f1;
    this.V3 = f2;
    this.f = null;
    this.R3 = false;
    this.S3 = true;
    if ((!this.p0) && (this.q.getVersion() == TimePickerDialog.Version.VERSION_1)) {
      this.Q3 = this.p3.a(f1, f2);
    } else {
      this.Q3 = -1;
    }
    i = this.Q3;
    if ((i != 0) && (i != 1))
    {
      i = k(f1, f2, this.W3.isTouchExplorationEnabled(), paramView);
      this.T3 = i;
      paramMotionEvent = l(i, paramView[0].booleanValue(), false);
      if (this.q.c(paramMotionEvent, getCurrentItemShowing())) {
        this.T3 = -1;
      }
      if (this.T3 != -1)
      {
        this.q.a();
        this.X3.postDelayed(new b(paramView), this.d);
      }
    }
    else
    {
      this.q.a();
      this.T3 = -1;
      this.X3.postDelayed(new a(), this.d);
    }
    return true;
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (paramInt == 4096) {
      paramInt = 1;
    } else if (paramInt == 8192) {
      paramInt = -1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      int k = getCurrentlyShowingValue();
      int m = getCurrentItemShowing();
      i = 6;
      if (m == 0)
      {
        i = 30;
        k %= 12;
      }
      else if ((m != 1) && (m != 2))
      {
        i = 0;
      }
      int n = r(k * i, paramInt) / i;
      if (m == 0)
      {
        if (this.p0)
        {
          paramInt = 23;
          i = j;
        }
        else
        {
          paramInt = 12;
          i = 1;
        }
      }
      else
      {
        paramInt = 55;
        i = j;
      }
      if (n > paramInt)
      {
        k = i;
      }
      else
      {
        k = n;
        if (n < i) {
          k = paramInt;
        }
      }
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2) {
            paramBundle = this.z;
          } else {
            paramBundle = new Timepoint(this.z.b(), this.z.c(), k);
          }
        }
        else {
          paramBundle = new Timepoint(this.z.b(), k, this.z.d());
        }
      }
      else {
        paramBundle = new Timepoint(k, this.z.c(), this.z.d());
      }
      q(m, paramBundle);
      this.x.a(paramBundle);
      return true;
    }
    return false;
  }
  
  public void setAmOrPm(int paramInt)
  {
    this.p3.setAmOrPm(paramInt);
    this.p3.invalidate();
    Timepoint localTimepoint = new Timepoint(this.z);
    if (paramInt == 0) {
      localTimepoint.h();
    } else if (paramInt == 1) {
      localTimepoint.i();
    }
    localTimepoint = p(localTimepoint, 0);
    o(localTimepoint, false, 0);
    this.z = localTimepoint;
    this.x.a(localTimepoint);
  }
  
  public void setOnValueSelectedListener(c paramc)
  {
    this.x = paramc;
  }
  
  public void setTime(Timepoint paramTimepoint)
  {
    q(0, paramTimepoint);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      RadialPickerLayout.d(RadialPickerLayout.this).setAmOrPmPressed(RadialPickerLayout.c(RadialPickerLayout.this));
      RadialPickerLayout.d(RadialPickerLayout.this).invalidate();
    }
  }
  
  class b
    implements Runnable
  {
    b(Boolean[] paramArrayOfBoolean) {}
    
    public void run()
    {
      RadialPickerLayout.e(RadialPickerLayout.this, true);
      RadialPickerLayout localRadialPickerLayout = RadialPickerLayout.this;
      RadialPickerLayout.g(localRadialPickerLayout, RadialPickerLayout.i(localRadialPickerLayout, RadialPickerLayout.h(localRadialPickerLayout), paramView[0].booleanValue(), false));
      localRadialPickerLayout = RadialPickerLayout.this;
      RadialPickerLayout.g(localRadialPickerLayout, RadialPickerLayout.j(localRadialPickerLayout, RadialPickerLayout.f(localRadialPickerLayout), RadialPickerLayout.this.getCurrentItemShowing()));
      localRadialPickerLayout = RadialPickerLayout.this;
      RadialPickerLayout.a(localRadialPickerLayout, RadialPickerLayout.f(localRadialPickerLayout), true, RadialPickerLayout.this.getCurrentItemShowing());
      RadialPickerLayout.b(RadialPickerLayout.this).a(RadialPickerLayout.f(RadialPickerLayout.this));
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Timepoint paramTimepoint);
    
    public abstract void b();
    
    public abstract void c(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\RadialPickerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */