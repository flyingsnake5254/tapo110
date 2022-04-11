package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  private static final int MIN_DELAY = 500;
  private static final int MIN_SHOW_TIME = 500;
  private final Runnable mDelayedHide = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar localContentLoadingProgressBar = ContentLoadingProgressBar.this;
      localContentLoadingProgressBar.mPostedHide = false;
      localContentLoadingProgressBar.mStartTime = -1L;
      localContentLoadingProgressBar.setVisibility(8);
    }
  };
  private final Runnable mDelayedShow = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar localContentLoadingProgressBar = ContentLoadingProgressBar.this;
      localContentLoadingProgressBar.mPostedShow = false;
      if (!localContentLoadingProgressBar.mDismissed)
      {
        localContentLoadingProgressBar.mStartTime = System.currentTimeMillis();
        ContentLoadingProgressBar.this.setVisibility(0);
      }
    }
  };
  boolean mDismissed = false;
  boolean mPostedHide = false;
  boolean mPostedShow = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void removeCallbacks()
  {
    removeCallbacks(this.mDelayedHide);
    removeCallbacks(this.mDelayedShow);
  }
  
  public void hide()
  {
    try
    {
      this.mDismissed = true;
      removeCallbacks(this.mDelayedShow);
      this.mPostedShow = false;
      long l1 = System.currentTimeMillis();
      long l2 = this.mStartTime;
      l1 -= l2;
      if ((l1 < 500L) && (l2 != -1L))
      {
        if (!this.mPostedHide)
        {
          postDelayed(this.mDelayedHide, 500L - l1);
          this.mPostedHide = true;
        }
      }
      else {
        setVisibility(8);
      }
      return;
    }
    finally {}
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }
  
  public void show()
  {
    try
    {
      this.mStartTime = -1L;
      this.mDismissed = false;
      removeCallbacks(this.mDelayedHide);
      this.mPostedHide = false;
      if (!this.mPostedShow)
      {
        postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\ContentLoadingProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */