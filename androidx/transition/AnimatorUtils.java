package androidx.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.util.ArrayList;

class AnimatorUtils
{
  static void addPauseListener(@NonNull Animator paramAnimator, @NonNull AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
    }
  }
  
  static void pause(@NonNull Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAnimator.pause();
    }
    else
    {
      ArrayList localArrayList = paramAnimator.getListeners();
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i);
          if ((localAnimatorListener instanceof AnimatorPauseListenerCompat)) {
            ((AnimatorPauseListenerCompat)localAnimatorListener).onAnimationPause(paramAnimator);
          }
          i++;
        }
      }
    }
  }
  
  static void resume(@NonNull Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAnimator.resume();
    }
    else
    {
      ArrayList localArrayList = paramAnimator.getListeners();
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i);
          if ((localAnimatorListener instanceof AnimatorPauseListenerCompat)) {
            ((AnimatorPauseListenerCompat)localAnimatorListener).onAnimationResume(paramAnimator);
          }
          i++;
        }
      }
    }
  }
  
  static abstract interface AnimatorPauseListenerCompat
  {
    public abstract void onAnimationPause(Animator paramAnimator);
    
    public abstract void onAnimationResume(Animator paramAnimator);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\AnimatorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */