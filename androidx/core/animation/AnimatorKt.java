package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class AnimatorKt
{
  public static final Animator.AnimatorListener addListener(Animator paramAnimator, final l<? super Animator, p> paraml1, final l<? super Animator, p> paraml2, final l<? super Animator, p> paraml3, l<? super Animator, p> paraml4)
  {
    j.f(paramAnimator, "$this$addListener");
    j.f(paraml1, "onEnd");
    j.f(paraml2, "onStart");
    j.f(paraml3, "onCancel");
    j.f(paraml4, "onRepeat");
    paraml1 = new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        paraml3.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        paraml1.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onRepeat.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        paraml2.invoke(paramAnonymousAnimator);
      }
    };
    paramAnimator.addListener(paraml1);
    return paraml1;
  }
  
  @RequiresApi(19)
  public static final Animator.AnimatorPauseListener addPauseListener(Animator paramAnimator, final l<? super Animator, p> paraml1, l<? super Animator, p> paraml2)
  {
    j.f(paramAnimator, "$this$addPauseListener");
    j.f(paraml1, "onResume");
    j.f(paraml2, "onPause");
    paraml1 = new Animator.AnimatorPauseListener()
    {
      public void onAnimationPause(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onPause.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationResume(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        paraml1.invoke(paramAnonymousAnimator);
      }
    };
    paramAnimator.addPauseListener(paraml1);
    return paraml1;
  }
  
  public static final Animator.AnimatorListener doOnCancel(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnCancel");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onCancel.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
    };
    paramAnimator.addListener(paraml);
    return paraml;
  }
  
  public static final Animator.AnimatorListener doOnEnd(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnEnd");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onEnd.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
    };
    paramAnimator.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Animator.AnimatorPauseListener doOnPause(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnPause");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorPauseListener()
    {
      public void onAnimationPause(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onPause.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationResume(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
    };
    paramAnimator.addPauseListener(paraml);
    return paraml;
  }
  
  public static final Animator.AnimatorListener doOnRepeat(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnRepeat");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onRepeat.invoke(paramAnonymousAnimator);
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
    };
    paramAnimator.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Animator.AnimatorPauseListener doOnResume(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnResume");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorPauseListener()
    {
      public void onAnimationPause(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationResume(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onResume.invoke(paramAnonymousAnimator);
      }
    };
    paramAnimator.addPauseListener(paraml);
    return paraml;
  }
  
  public static final Animator.AnimatorListener doOnStart(Animator paramAnimator, l<? super Animator, p> paraml)
  {
    j.f(paramAnimator, "$this$doOnStart");
    j.f(paraml, "action");
    paraml = new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        j.f(paramAnonymousAnimator, "animator");
        this.$onStart.invoke(paramAnonymousAnimator);
      }
    };
    paramAnimator.addListener(paraml);
    return paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\animation\AnimatorKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */