package com.handmark.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class e
  implements d
{
  private final HashSet<LoadingLayout> c = new HashSet();
  
  public void a(LoadingLayout paramLoadingLayout)
  {
    if (paramLoadingLayout != null) {
      this.c.add(paramLoadingLayout);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */