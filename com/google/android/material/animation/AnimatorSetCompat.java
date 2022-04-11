package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorSetCompat
{
  public static void playTogether(@NonNull AnimatorSet paramAnimatorSet, @NonNull List<Animator> paramList)
  {
    int i = paramList.size();
    long l = 0L;
    for (int j = 0; j < i; j++)
    {
      localObject = (Animator)paramList.get(j);
      l = Math.max(l, ((Animator)localObject).getStartDelay() + ((Animator)localObject).getDuration());
    }
    Object localObject = ValueAnimator.ofInt(new int[] { 0, 0 });
    ((Animator)localObject).setDuration(l);
    paramList.add(0, localObject);
    paramAnimatorSet.playTogether(paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\AnimatorSetCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */