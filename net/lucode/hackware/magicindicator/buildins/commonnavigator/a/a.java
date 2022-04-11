package net.lucode.hackware.magicindicator.buildins.commonnavigator.a;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class a
{
  private final DataSetObservable a = new DataSetObservable();
  
  public abstract int a();
  
  public abstract c b(Context paramContext);
  
  public abstract d c(Context paramContext, int paramInt);
  
  public float d(Context paramContext, int paramInt)
  {
    return 1.0F;
  }
  
  public final void e()
  {
    this.a.notifyChanged();
  }
  
  public final void f(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public final void g(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */