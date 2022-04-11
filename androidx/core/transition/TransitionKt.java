package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class TransitionKt
{
  @RequiresApi(19)
  public static final Transition.TransitionListener addListener(Transition paramTransition, l<? super Transition, p> paraml1, final l<? super Transition, p> paraml2, final l<? super Transition, p> paraml3, final l<? super Transition, p> paraml4, final l<? super Transition, p> paraml5)
  {
    j.f(paramTransition, "$this$addListener");
    j.f(paraml1, "onEnd");
    j.f(paraml2, "onStart");
    j.f(paraml3, "onCancel");
    j.f(paraml4, "onResume");
    j.f(paraml5, "onPause");
    paraml1 = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        paraml3.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onEnd.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        paraml5.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        paraml4.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        paraml2.invoke(paramAnonymousTransition);
      }
    };
    paramTransition.addListener(paraml1);
    return paraml1;
  }
  
  @RequiresApi(19)
  public static final Transition.TransitionListener doOnCancel(Transition paramTransition, l<? super Transition, p> paraml)
  {
    j.f(paramTransition, "$this$doOnCancel");
    j.f(paraml, "action");
    paraml = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onCancel.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
    };
    paramTransition.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Transition.TransitionListener doOnEnd(Transition paramTransition, l<? super Transition, p> paraml)
  {
    j.f(paramTransition, "$this$doOnEnd");
    j.f(paraml, "action");
    paraml = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onEnd.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
    };
    paramTransition.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Transition.TransitionListener doOnPause(Transition paramTransition, l<? super Transition, p> paraml)
  {
    j.f(paramTransition, "$this$doOnPause");
    j.f(paraml, "action");
    paraml = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onPause.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
    };
    paramTransition.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Transition.TransitionListener doOnResume(Transition paramTransition, l<? super Transition, p> paraml)
  {
    j.f(paramTransition, "$this$doOnResume");
    j.f(paraml, "action");
    paraml = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onResume.invoke(paramAnonymousTransition);
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
    };
    paramTransition.addListener(paraml);
    return paraml;
  }
  
  @RequiresApi(19)
  public static final Transition.TransitionListener doOnStart(Transition paramTransition, l<? super Transition, p> paraml)
  {
    j.f(paramTransition, "$this$doOnStart");
    j.f(paraml, "action");
    paraml = new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
      }
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        j.f(paramAnonymousTransition, "transition");
        this.$onStart.invoke(paramAnonymousTransition);
      }
    };
    paramTransition.addListener(paraml);
    return paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\transition\TransitionKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */