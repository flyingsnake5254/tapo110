package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet
{
  final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList();
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  private boolean mIsStarted;
  ViewPropertyAnimatorListener mListener;
  private final ViewPropertyAnimatorListenerAdapter mProxyListener = new ViewPropertyAnimatorListenerAdapter()
  {
    private int mProxyEndCount = 0;
    private boolean mProxyStarted = false;
    
    public void onAnimationEnd(View paramAnonymousView)
    {
      int i = this.mProxyEndCount + 1;
      this.mProxyEndCount = i;
      if (i == ViewPropertyAnimatorCompatSet.this.mAnimators.size())
      {
        paramAnonymousView = ViewPropertyAnimatorCompatSet.this.mListener;
        if (paramAnonymousView != null) {
          paramAnonymousView.onAnimationEnd(null);
        }
        onEnd();
      }
    }
    
    public void onAnimationStart(View paramAnonymousView)
    {
      if (this.mProxyStarted) {
        return;
      }
      this.mProxyStarted = true;
      paramAnonymousView = ViewPropertyAnimatorCompatSet.this.mListener;
      if (paramAnonymousView != null) {
        paramAnonymousView.onAnimationStart(null);
      }
    }
    
    void onEnd()
    {
      this.mProxyEndCount = 0;
      this.mProxyStarted = false;
      ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
    }
  };
  
  public void cancel()
  {
    if (!this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  void onAnimationsEnded()
  {
    this.mIsStarted = false;
  }
  
  public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!this.mIsStarted) {
      this.mAnimators.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2)
  {
    this.mAnimators.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.setStartDelay(paramViewPropertyAnimatorCompat1.getDuration());
    this.mAnimators.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setDuration(long paramLong)
  {
    if (!this.mIsStarted) {
      this.mDuration = paramLong;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator paramInterpolator)
  {
    if (!this.mIsStarted) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!this.mIsStarted) {
      this.mListener = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public void start()
  {
    if (this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      long l = this.mDuration;
      if (l >= 0L) {
        localViewPropertyAnimatorCompat.setDuration(l);
      }
      Interpolator localInterpolator = this.mInterpolator;
      if (localInterpolator != null) {
        localViewPropertyAnimatorCompat.setInterpolator(localInterpolator);
      }
      if (this.mListener != null) {
        localViewPropertyAnimatorCompat.setListener(this.mProxyListener);
      }
      localViewPropertyAnimatorCompat.start();
    }
    this.mIsStarted = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\ViewPropertyAnimatorCompatSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */