package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.ColorInt;
import com.tplink.libtpnetwork.cameranetwork.util.e;

public class ChangeableAreaView
  extends View
{
  @ColorInt
  private int H3;
  private int I3;
  private int J3;
  private int K3;
  private int L3;
  private int M3;
  @ColorInt
  private int N3;
  private int O3;
  private int P3;
  private int Q3;
  private Bitmap R3;
  private a S3;
  private Paint T3 = new Paint();
  private Paint U3 = new Paint();
  private Paint V3 = new Paint();
  private Context c;
  private int d;
  private int f;
  private long p0;
  private boolean p1;
  private boolean p2;
  private boolean p3;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public ChangeableAreaView(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    e();
  }
  
  private void b(int paramInt)
  {
    paramInt = this.z + paramInt;
    this.z = paramInt;
    if (paramInt > ((ViewGroup)getParent()).getHeight()) {
      this.z = ((ViewGroup)getParent()).getHeight();
    }
    paramInt = this.z;
    int i = this.y;
    int j = this.J3;
    if (paramInt - i < j) {
      this.z = (j + i);
    }
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    this.q = (paramView.getLeft() + paramInt1);
    this.y = (paramView.getTop() + paramInt2);
    this.x = (paramView.getRight() + paramInt1);
    this.z = (paramView.getBottom() + paramInt2);
    if (this.q < 0)
    {
      this.q = 0;
      this.x = (paramView.getWidth() + 0);
    }
    if (this.x > ((ViewGroup)getParent()).getWidth())
    {
      paramInt1 = ((ViewGroup)getParent()).getWidth();
      this.x = paramInt1;
      this.q = (paramInt1 - paramView.getWidth());
    }
    if (this.y < 0)
    {
      this.y = 0;
      this.z = (0 + paramView.getHeight());
    }
    if (this.z > ((ViewGroup)getParent()).getHeight())
    {
      paramInt1 = ((ViewGroup)getParent()).getHeight();
      this.z = paramInt1;
      this.y = (paramInt1 - paramView.getHeight());
    }
    paramView.layout(this.q, this.y, this.x, this.z);
    invalidate();
  }
  
  private void e()
  {
    setWillNotDraw(false);
    setClickable(true);
    setBackgroundColor(getResources().getColor(2131100200));
    Object localObject = BitmapFactory.decodeResource(getResources(), 2131690320);
    this.R3 = ((Bitmap)localObject);
    this.Q3 = (((Bitmap)localObject).getWidth() / 2);
    localObject = new Paint(4);
    this.T3 = ((Paint)localObject);
    ((Paint)localObject).setAntiAlias(true);
    this.V3.setAntiAlias(true);
    this.V3.setDither(true);
    this.U3.setAntiAlias(true);
    this.U3.setDither(true);
    this.J3 = e.a(80, this.c);
    int i = e.a(32, this.c);
    this.O3 = i;
    this.P3 = Math.max(i / 2, this.Q3);
    this.p2 = true;
    this.N3 = getResources().getColor(2131100196);
    this.H3 = getResources().getColor(2131100150);
    i(false);
  }
  
  private void f(int paramInt)
  {
    paramInt = this.q + paramInt;
    this.q = paramInt;
    if (paramInt < 0) {
      this.q = 0;
    }
    int i = this.x;
    int j = this.q;
    paramInt = this.J3;
    if (i - j < paramInt) {
      this.q = (i - paramInt);
    }
  }
  
  private void g(int paramInt)
  {
    paramInt = this.x + paramInt;
    this.x = paramInt;
    if (paramInt > ((ViewGroup)getParent()).getWidth()) {
      this.x = ((ViewGroup)getParent()).getWidth();
    }
    paramInt = this.x;
    int i = this.q;
    int j = this.J3;
    if (paramInt - i < j) {
      this.x = (i + j);
    }
  }
  
  private void h(int paramInt)
  {
    paramInt = this.y + paramInt;
    this.y = paramInt;
    if (paramInt < 0) {
      this.y = 0;
    }
    paramInt = this.z;
    int i = this.y;
    int j = this.J3;
    if (paramInt - i < j) {
      this.y = (paramInt - j);
    }
  }
  
  protected void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX() - this.d;
    int j = (int)paramMotionEvent.getRawY() - this.f;
    switch (this.I3)
    {
    default: 
      break;
    case 9: 
      c(paramView, i, j);
      break;
    case 8: 
      g(i);
      b(j);
      break;
    case 7: 
      f(i);
      b(j);
      break;
    case 6: 
      g(i);
      h(j);
      break;
    case 5: 
      f(i);
      h(j);
      break;
    case 4: 
      g(i);
      break;
    case 3: 
      b(j);
      break;
    case 2: 
      f(i);
      break;
    case 1: 
      h(j);
    }
    if (this.I3 != 9) {
      paramView.layout(this.q, this.y, this.x, this.z);
    }
    this.d = ((int)paramMotionEvent.getRawX());
    this.f = ((int)paramMotionEvent.getRawY());
  }
  
  protected int d(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramView.getLeft();
    int j = paramView.getRight();
    int k = paramView.getBottom();
    int m = paramView.getTop();
    int n = this.O3;
    if ((paramInt1 < n) && (paramInt2 < n)) {
      return 5;
    }
    if ((paramInt2 < n) && (j - i - paramInt1 < n)) {
      return 6;
    }
    if ((paramInt1 < n) && (k - m - paramInt2 < n)) {
      return 7;
    }
    j = j - i - paramInt1;
    if ((j < n) && (k - m - paramInt2 < n)) {
      return 8;
    }
    if (paramInt1 < n) {
      return 2;
    }
    if (paramInt2 < n) {
      return 1;
    }
    if (j < n) {
      return 4;
    }
    if (k - m - paramInt2 < n) {
      return 3;
    }
    return 9;
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p1 = true;
      this.M3 = e.a(2, this.c);
      this.K3 = e.a(2, this.c);
      this.L3 = e.a(10, this.c);
    }
    else
    {
      this.p1 = false;
      this.p3 = false;
      this.M3 = e.a(1, this.c);
      this.K3 = e.a(0, this.c);
      this.L3 = e.a(0, this.c);
    }
    invalidate();
  }
  
  public void j()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i = this.q;
    localLayoutParams.leftMargin = i;
    int j = this.y;
    localLayoutParams.topMargin = j;
    localLayoutParams.width = (this.x - i);
    localLayoutParams.height = (this.z - j);
    setLayoutParams(localLayoutParams);
  }
  
  public void k()
  {
    this.q = getLeft();
    this.x = getRight();
    this.y = getTop();
    this.z = getBottom();
    int i = ((ViewGroup)getParent()).getWidth();
    int j = ((ViewGroup)getParent()).getHeight();
    int k = e.a(80, getContext());
    int m;
    if (getWidth() < k)
    {
      m = this.q + k;
      this.x = m;
      if (m > i)
      {
        this.x = i;
        this.q = (i - k);
      }
    }
    if (getHeight() < k)
    {
      m = this.y + k;
      this.z = m;
      if (m > j)
      {
        this.z = j;
        this.y = (j - k);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.T3.setColor(this.N3);
    int i = this.P3;
    float f1 = i;
    float f2 = i;
    int j = getWidth();
    i = this.P3;
    paramCanvas.drawRect(f1, f2, j - i, i + this.M3, this.T3);
    paramCanvas.drawRect(this.P3, getHeight() - this.P3 - this.M3, getWidth() - this.P3, getHeight() - this.P3, this.T3);
    i = this.P3;
    f2 = i;
    j = this.M3;
    paramCanvas.drawRect(f2, i + j, i + j, getHeight() - this.P3 - this.M3, this.T3);
    int k = getWidth();
    i = this.P3;
    j = this.M3;
    paramCanvas.drawRect(k - i - j, i + j, getWidth() - this.P3, getHeight() - this.M3 - this.P3, this.T3);
    this.V3.setColor(this.H3);
    j = this.P3;
    i = this.M3;
    paramCanvas.drawRect(j + i, j + i, getWidth() - this.P3 - this.M3, getHeight() - this.P3 - this.M3, this.V3);
    if ((this.p1) && (this.p2))
    {
      Bitmap localBitmap = this.R3;
      j = getWidth();
      i = this.P3;
      k = this.Q3;
      paramCanvas.drawBitmap(localBitmap, j - i - k, i - k, this.U3);
    }
    i = this.P3;
    j = this.K3;
    paramCanvas.drawRect(i - j, i - j, i - j + this.L3, i, this.T3);
    j = this.P3;
    i = this.K3;
    paramCanvas.drawRect(j - i, j, j, j + this.L3 - i, this.T3);
    f2 = this.P3 - this.K3;
    i = getHeight();
    j = this.P3;
    paramCanvas.drawRect(f2, i - j, j - this.K3 + this.L3, getHeight() - this.P3 + this.K3, this.T3);
    f2 = this.P3 - this.K3;
    j = getHeight();
    i = this.P3;
    paramCanvas.drawRect(f2, j - i + this.K3 - this.L3, i, getHeight() - this.P3, this.T3);
    paramCanvas.drawRect(getWidth() - this.P3 + this.K3 - this.L3, getHeight() - this.P3, getWidth() + this.K3 - this.P3, getHeight() - this.P3 + this.K3, this.T3);
    paramCanvas.drawRect(getWidth() - this.P3, getHeight() - this.P3 + this.K3 - this.L3, getWidth() + this.K3 - this.P3, getHeight() - this.P3, this.T3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.p2) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          a(this, paramMotionEvent);
        }
      }
      else
      {
        this.S3.h0(this);
        if ((this.p3) && (this.I3 == 6) && (System.currentTimeMillis() - this.p0 <= 300L))
        {
          paramMotionEvent = this.S3;
          if (paramMotionEvent != null) {
            paramMotionEvent.O(this);
          }
        }
        this.I3 = 0;
        if (!this.p3) {
          this.p3 = true;
        }
      }
    }
    else
    {
      if (!this.p3)
      {
        a locala = this.S3;
        if (locala != null) {
          locala.H(this);
        }
      }
      k();
      this.f = ((int)paramMotionEvent.getRawY());
      this.d = ((int)paramMotionEvent.getRawX());
      this.I3 = d(this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.p0 = System.currentTimeMillis();
    }
    j();
    invalidate();
    return true;
  }
  
  public void setAreaInnerColor(@ColorInt int paramInt)
  {
    this.H3 = paramInt;
  }
  
  public void setAreaViewListener(a parama)
  {
    if (this.S3 == null) {
      this.S3 = parama;
    }
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.N3 = paramInt;
  }
  
  public void setCanBeEdit(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
    if (paramBoolean)
    {
      this.P3 = Math.max(this.O3 / 2, this.Q3);
      this.J3 = e.a(80, this.c);
    }
    else
    {
      this.P3 = 0;
      this.J3 = e.a(48, this.c);
    }
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void H(ChangeableAreaView paramChangeableAreaView);
    
    public abstract void O(ChangeableAreaView paramChangeableAreaView);
    
    public abstract void h0(ChangeableAreaView paramChangeableAreaView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\ChangeableAreaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */