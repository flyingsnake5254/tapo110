package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
abstract class TransitionListenerAdapter
  implements Transition.TransitionListener
{
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {}
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\TransitionListenerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */