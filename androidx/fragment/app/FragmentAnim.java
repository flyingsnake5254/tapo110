package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal.OnCancelListener;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R.anim;
import androidx.fragment.R.id;

class FragmentAnim
{
  static void animateRemoveFragment(@NonNull final Fragment paramFragment, @NonNull AnimationOrAnimator paramAnimationOrAnimator, @NonNull final FragmentTransition.Callback paramCallback)
  {
    final View localView = paramFragment.mView;
    ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    final CancellationSignal localCancellationSignal = new CancellationSignal();
    localCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
    {
      public void onCancel()
      {
        if (this.val$fragment.getAnimatingAway() != null)
        {
          View localView = this.val$fragment.getAnimatingAway();
          this.val$fragment.setAnimatingAway(null);
          localView.clearAnimation();
        }
        this.val$fragment.setAnimator(null);
      }
    });
    paramCallback.onStart(paramFragment, localCancellationSignal);
    if (paramAnimationOrAnimator.animation != null)
    {
      paramAnimationOrAnimator = new EndViewTransitionAnimation(paramAnimationOrAnimator.animation, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      paramAnimationOrAnimator.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          this.val$container.post(new Runnable()
          {
            public void run()
            {
              if (FragmentAnim.2.this.val$fragment.getAnimatingAway() != null)
              {
                FragmentAnim.2.this.val$fragment.setAnimatingAway(null);
                FragmentAnim.2 local2 = FragmentAnim.2.this;
                local2.val$callback.onComplete(local2.val$fragment, local2.val$signal);
              }
            }
          });
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      paramFragment.mView.startAnimation(paramAnimationOrAnimator);
    }
    else
    {
      paramAnimationOrAnimator = paramAnimationOrAnimator.animator;
      paramFragment.setAnimator(paramAnimationOrAnimator);
      paramAnimationOrAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.val$container.endViewTransition(localView);
          paramAnonymousAnimator = paramFragment.getAnimator();
          paramFragment.setAnimator(null);
          if ((paramAnonymousAnimator != null) && (this.val$container.indexOfChild(localView) < 0)) {
            paramCallback.onComplete(paramFragment, localCancellationSignal);
          }
        }
      });
      paramAnimationOrAnimator.setTarget(paramFragment.mView);
      paramAnimationOrAnimator.start();
    }
  }
  
  static AnimationOrAnimator loadAnimation(@NonNull Context paramContext, @NonNull FragmentContainer paramFragmentContainer, @NonNull Fragment paramFragment, boolean paramBoolean)
  {
    int i = paramFragment.getNextTransition();
    int j = paramFragment.getNextAnim();
    int k = 0;
    paramFragment.setNextAnim(0);
    paramFragmentContainer = paramFragmentContainer.onFindViewById(paramFragment.mContainerId);
    if (paramFragmentContainer != null)
    {
      m = R.id.visible_removing_fragment_view_tag;
      if (paramFragmentContainer.getTag(m) != null) {
        paramFragmentContainer.setTag(m, null);
      }
    }
    paramFragmentContainer = paramFragment.mContainer;
    if ((paramFragmentContainer != null) && (paramFragmentContainer.getLayoutTransition() != null)) {
      return null;
    }
    paramFragmentContainer = paramFragment.onCreateAnimation(i, paramBoolean, j);
    if (paramFragmentContainer != null) {
      return new AnimationOrAnimator(paramFragmentContainer);
    }
    paramFragmentContainer = paramFragment.onCreateAnimator(i, paramBoolean, j);
    if (paramFragmentContainer != null) {
      return new AnimationOrAnimator(paramFragmentContainer);
    }
    if (j != 0)
    {
      boolean bool = "anim".equals(paramContext.getResources().getResourceTypeName(j));
      m = k;
      if (bool) {
        try
        {
          paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, j);
          if (paramFragmentContainer != null)
          {
            paramFragmentContainer = new AnimationOrAnimator(paramFragmentContainer);
            return paramFragmentContainer;
          }
          m = 1;
        }
        catch (RuntimeException paramFragmentContainer)
        {
          m = k;
        }
        catch (Resources.NotFoundException paramContext)
        {
          throw paramContext;
        }
      }
      if (m == 0) {
        try
        {
          paramFragmentContainer = AnimatorInflater.loadAnimator(paramContext, j);
          if (paramFragmentContainer != null)
          {
            paramFragmentContainer = new AnimationOrAnimator(paramFragmentContainer);
            return paramFragmentContainer;
          }
        }
        catch (RuntimeException paramFragmentContainer)
        {
          if (!bool)
          {
            paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, j);
            if (paramFragmentContainer != null) {
              return new AnimationOrAnimator(paramFragmentContainer);
            }
          }
          else
          {
            throw paramFragmentContainer;
          }
        }
      }
    }
    if (i == 0) {
      return null;
    }
    int m = transitToAnimResourceId(i, paramBoolean);
    if (m < 0) {
      return null;
    }
    return new AnimationOrAnimator(AnimationUtils.loadAnimation(paramContext, m));
  }
  
  @AnimRes
  private static int transitToAnimResourceId(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          paramInt = -1;
        } else if (paramBoolean) {
          paramInt = R.anim.fragment_close_enter;
        } else {
          paramInt = R.anim.fragment_close_exit;
        }
      }
      else if (paramBoolean) {
        paramInt = R.anim.fragment_fade_enter;
      } else {
        paramInt = R.anim.fragment_fade_exit;
      }
    }
    else if (paramBoolean) {
      paramInt = R.anim.fragment_open_enter;
    } else {
      paramInt = R.anim.fragment_open_exit;
    }
    return paramInt;
  }
  
  static class AnimationOrAnimator
  {
    public final Animation animation;
    public final Animator animator;
    
    AnimationOrAnimator(Animator paramAnimator)
    {
      this.animation = null;
      this.animator = paramAnimator;
      if (paramAnimator != null) {
        return;
      }
      throw new IllegalStateException("Animator cannot be null");
    }
    
    AnimationOrAnimator(Animation paramAnimation)
    {
      this.animation = paramAnimation;
      this.animator = null;
      if (paramAnimation != null) {
        return;
      }
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  private static class EndViewTransitionAnimation
    extends AnimationSet
    implements Runnable
  {
    private boolean mAnimating = true;
    private final View mChild;
    private boolean mEnded;
    private final ViewGroup mParent;
    private boolean mTransitionEnded;
    
    EndViewTransitionAnimation(@NonNull Animation paramAnimation, @NonNull ViewGroup paramViewGroup, @NonNull View paramView)
    {
      super();
      this.mParent = paramViewGroup;
      this.mChild = paramView;
      addAnimation(paramAnimation);
      paramViewGroup.post(this);
    }
    
    public boolean getTransformation(long paramLong, @NonNull Transformation paramTransformation)
    {
      this.mAnimating = true;
      if (this.mEnded) {
        return this.mTransitionEnded ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        this.mEnded = true;
        OneShotPreDrawListener.add(this.mParent, this);
      }
      return true;
    }
    
    public boolean getTransformation(long paramLong, @NonNull Transformation paramTransformation, float paramFloat)
    {
      this.mAnimating = true;
      if (this.mEnded) {
        return this.mTransitionEnded ^ true;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        this.mEnded = true;
        OneShotPreDrawListener.add(this.mParent, this);
      }
      return true;
    }
    
    public void run()
    {
      if ((!this.mEnded) && (this.mAnimating))
      {
        this.mAnimating = false;
        this.mParent.post(this);
      }
      else
      {
        this.mParent.endViewTransition(this.mChild);
        this.mTransitionEnded = true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentAnim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */