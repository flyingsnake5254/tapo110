package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import b.d.w.c.a;
import com.tplink.iot.b;
import java.util.concurrent.atomic.AtomicBoolean;

public class CloudTerraceControlPanel
  extends View
{
  float H3;
  float I3;
  int J3;
  int K3;
  int L3;
  int M3;
  int N3;
  int O3;
  int P3;
  int Q3;
  float R3;
  private final boolean[] c = new boolean[4];
  private final float d = 1.19F;
  private final float f = 0.83F;
  c p0;
  float p1;
  float p2;
  float p3;
  Paint q = new Paint();
  RectF x = new RectF();
  Bitmap y;
  b z;
  
  public CloudTerraceControlPanel(Context paramContext)
  {
    this(paramContext, null);
    d(null);
  }
  
  public CloudTerraceControlPanel(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramAttributeSet);
  }
  
  public CloudTerraceControlPanel(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramAttributeSet);
  }
  
  private float a(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private void b(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat2 / 2.0F;
    RectF localRectF = this.x;
    int i = this.P3;
    localRectF.top = (i - paramFloat1);
    localRectF.bottom = (i + paramFloat1);
    i = this.O3;
    localRectF.left = (i - paramFloat1);
    localRectF.right = (i + paramFloat1);
    this.q.setStrokeWidth(paramFloat2);
    this.q.setColor(paramInt);
    paramCanvas.drawArc(this.x, paramFloat3, paramFloat4, false, this.q);
  }
  
  private Bitmap c(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    localOptions.inSampleSize = 1;
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
  }
  
  private void d(AttributeSet paramAttributeSet)
  {
    this.q.setColor(-65536);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setAntiAlias(true);
    this.p3 = a(43.0F);
    this.H3 = a(6.0F);
    Object localObject = new b(null);
    this.z = ((b)localObject);
    ((b)localObject).a(1500L);
    this.z.b(500L);
    if (getContext() != null)
    {
      localObject = getContext().obtainStyledAttributes(paramAttributeSet, b.CloudTerraceControlPanel);
      this.J3 = ((TypedArray)localObject).getColor(5, 0);
      this.M3 = ((TypedArray)localObject).getColor(2, 0);
      this.K3 = ((TypedArray)localObject).getColor(4, -986896);
      this.L3 = ((TypedArray)localObject).getColor(1, -1644826);
      this.Q3 = ((TypedArray)localObject).getColor(7, 0);
      this.N3 = ((TypedArray)localObject).getColor(6, 844924350);
      this.R3 = ((TypedArray)localObject).getDimension(8, a(6.0F));
      this.I3 = ((TypedArray)localObject).getDimension(3, a(18.0F));
      paramAttributeSet = ((TypedArray)localObject).getDrawable(0);
      if (paramAttributeSet == null) {
        this.y = c(2131689545);
      } else {
        this.y = ((BitmapDrawable)paramAttributeSet).getBitmap();
      }
      ((TypedArray)localObject).recycle();
    }
  }
  
  public int getClickedArea()
  {
    for (int i = 0; i < 4; i++) {
      if (this.c[i] != 0) {
        return i;
      }
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.O3 == 0)
    {
      this.O3 = (getWidth() >> 1);
      this.P3 = (getHeight() >> 1);
    }
    float f1 = this.I3;
    b(paramCanvas, f1, f1, this.M3, 0.0F, 360.0F);
    float f2 = this.I3;
    f1 = this.H3;
    b(paramCanvas, f2 + f1, f1, this.L3, 0.0F, 360.0F);
    b(paramCanvas, this.p2, this.p3, this.J3, 0.0F, 360.0F);
    f1 = this.p2;
    f2 = this.R3;
    b(paramCanvas, f1 + f2, f2, this.Q3, 0.0F, 360.0F);
    for (int i = 0; i < 4; i++)
    {
      this.q.setColor(this.K3);
      this.q.setStrokeWidth(a(1.0F));
      int j = this.O3;
      float f3 = j;
      float f4 = this.p2;
      float f5 = f4 / 3.0F;
      int k = this.P3;
      f2 = k;
      float f6 = f4 / 3.0F;
      f1 = j;
      paramCanvas.drawLine(f3 + f5, f2 - f6, f4 / 7.0F * 4.0F + f1, k - f4 / 7.0F * 4.0F, this.q);
      Bitmap localBitmap = this.y;
      paramCanvas.drawBitmap(localBitmap, this.O3 + this.p2 / 2.0F, this.P3 - (localBitmap.getHeight() >> 1), null);
      if (this.c[i] != 0) {
        b(paramCanvas, this.p2 - a(6.0F), this.p3 - a(12.0F), this.N3, -40.0F, 80.0F);
      }
      paramCanvas.rotate(90.0F, this.O3, this.P3);
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.p1 == 0.0F)
    {
      float f1;
      if (getHeight() < getWidth()) {
        f1 = getHeight();
      } else {
        f1 = getWidth() - this.R3 * 2.0F;
      }
      this.p1 = f1;
      this.p2 = (f1 / 2.0F);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.P3;
    float f3 = i;
    float f4 = i;
    i = this.O3;
    f3 = (f2 - f3) * (f2 - f4) + (f1 - i) * (f1 - i);
    float f5 = this.I3;
    f4 = this.H3;
    int j = 0;
    i = 0;
    if (f3 < (f5 + f4) * (f5 + f4)) {
      k = 1;
    } else {
      k = 0;
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m == 2) {
          break label249;
        }
        if (m == 3) {}
      }
      for (k = i;; k = i)
      {
        i = 0;
        n = 0;
        break;
        if (this.z.d) {
          this.p0.b();
        }
        this.z.e();
        k = 0;
        for (i = 0; k < 4; i = m)
        {
          paramMotionEvent = this.c;
          m = i;
          if (paramMotionEvent[k] != 0)
          {
            paramMotionEvent[k] = 0;
            m = i;
            if (i == 0) {
              m = 1;
            }
          }
          k++;
        }
      }
    }
    else if (k == 0)
    {
      i = 1;
      break label252;
    }
    label249:
    i = 0;
    label252:
    f4 = this.p2;
    if ((f3 <= f4 * f4) && (k == 0))
    {
      k = this.P3;
      f3 = k;
      int i1 = this.O3;
      f3 = (f2 - f3) / (f1 - i1);
      paramMotionEvent = this.c;
      int i2 = paramMotionEvent[3];
      if ((f2 < k) && ((f3 > 1.19F) || (f3 < -1.19F))) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if (i2 != i3)
      {
        paramMotionEvent[3] ^= 0x1;
        if (paramMotionEvent[3] != 0)
        {
          i = 1;
          m = 1;
        }
        else
        {
          m = 1;
          n = 1;
          break label395;
        }
      }
      else
      {
        m = 0;
      }
      n = 0;
      label395:
      i2 = paramMotionEvent[1];
      if ((f2 > k) && ((f3 > 1.19F) || (f3 < -1.19F))) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      k = m;
      int i4 = n;
      int i5 = i;
      if (i2 != i3)
      {
        paramMotionEvent[1] ^= 0x1;
        k = m;
        if (m == 0) {
          k = 1;
        }
        if (paramMotionEvent[1] != 0)
        {
          i5 = 1;
          i4 = n;
        }
        else
        {
          i4 = 1;
          i5 = i;
        }
      }
      i2 = paramMotionEvent[0];
      if ((f1 > i1) && (-0.83F < f3) && (f3 < 0.83F)) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      m = k;
      n = i4;
      i = i5;
      if (i2 != i3)
      {
        paramMotionEvent[0] ^= 0x1;
        m = k;
        if (k == 0) {
          m = 1;
        }
        if (paramMotionEvent[0] != 0)
        {
          i = 1;
          n = i4;
        }
        else
        {
          n = 1;
          i = i5;
        }
      }
      i2 = paramMotionEvent[2];
      int i3 = j;
      if (f1 < i1)
      {
        i3 = j;
        if (-1.19F < f3)
        {
          i3 = j;
          if (f3 < 0.83F) {
            i3 = 1;
          }
        }
      }
      if (i2 != i3)
      {
        paramMotionEvent[2] ^= 0x1;
        if (m == 0) {
          k = 1;
        } else {
          k = m;
        }
        m = k;
        if (paramMotionEvent[2] != 0)
        {
          i = 1;
          break label761;
        }
      }
      else
      {
        k = m;
        break label761;
      }
    }
    else
    {
      n = 0;
      for (k = 0; n < 4; k = m)
      {
        paramMotionEvent = this.c;
        m = k;
        if (paramMotionEvent[n] != 0)
        {
          paramMotionEvent[n] = 0;
          m = k;
          if (k == 0) {
            m = 1;
          }
        }
        n++;
      }
      m = k;
    }
    int n = 1;
    int k = m;
    label761:
    if (k != 0) {
      invalidate();
    }
    if (n != 0)
    {
      if (this.z.d) {
        this.p0.b();
      }
      this.z.e();
    }
    if (i != 0)
    {
      this.z.d();
      performClick();
    }
    return true;
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setOnLongPressListener(@Nullable c paramc)
  {
    this.p0 = paramc;
    this.z.c(paramc);
  }
  
  private static class b
    extends Handler
  {
    CloudTerraceControlPanel.c a;
    long b;
    long c;
    boolean d = false;
    private String e = "LongPressHandler";
    AtomicBoolean f = new AtomicBoolean(false);
    
    void a(long paramLong)
    {
      this.c = paramLong;
    }
    
    void b(long paramLong)
    {
      this.b = paramLong;
    }
    
    void c(CloudTerraceControlPanel.c paramc)
    {
      this.a = paramc;
    }
    
    void d()
    {
      if ((!this.f.get()) && (this.a != null))
      {
        sendEmptyMessageDelayed(0, this.b);
        a.c(this.e, "start");
        this.f.set(true);
      }
    }
    
    void e()
    {
      if (this.f.get())
      {
        this.f.lazySet(false);
        removeMessages(0);
        this.d = false;
        a.c(this.e, "stop");
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      sendEmptyMessageDelayed(0, this.c);
      if (!this.d) {
        this.d = true;
      }
      paramMessage = this.a;
      if (paramMessage != null)
      {
        paramMessage.a();
        a.c(this.e, "trigger");
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\CloudTerraceControlPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */