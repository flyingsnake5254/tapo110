package uk.co.senab.photoview.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
public class a
  extends d
{
  protected final OverScroller a;
  private boolean b = false;
  
  public a(Context paramContext)
  {
    this.a = new OverScroller(paramContext);
  }
  
  public boolean a()
  {
    if (this.b)
    {
      this.a.computeScrollOffset();
      this.b = false;
    }
    return this.a.computeScrollOffset();
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.forceFinished(paramBoolean);
  }
  
  public int d()
  {
    return this.a.getCurrX();
  }
  
  public int e()
  {
    return this.a.getCurrY();
  }
  
  public boolean g()
  {
    return this.a.isFinished();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\uk\co\senab\photoview\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */