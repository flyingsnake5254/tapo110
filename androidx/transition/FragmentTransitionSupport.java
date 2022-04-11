package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal.OnCancelListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport
  extends FragmentTransitionImpl
{
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    boolean bool;
    if ((FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetIds())) && (FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetNames())) && (FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetTypes()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void addTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
  }
  
  public void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof TransitionSet;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      i = ((TransitionSet)paramObject).getTransitionCount();
      while (j < i)
      {
        addTargets(((TransitionSet)paramObject).getTransitionAt(j), paramArrayList);
        j++;
      }
    }
    if ((!hasSimpleTarget((Transition)paramObject)) && (FragmentTransitionImpl.isNullOrEmpty(((Transition)paramObject).getTargets())))
    {
      int k = paramArrayList.size();
      for (j = i; j < k; j++) {
        ((Transition)paramObject).addTarget((View)paramArrayList.get(j));
      }
    }
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean canHandle(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object cloneTransition(Object paramObject)
  {
    if (paramObject != null) {
      paramObject = ((Transition)paramObject).clone();
    } else {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().addTransition((Transition)paramObject1).addTransition((Transition)paramObject2).setOrdering(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
      }
      ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void removeTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
  }
  
  public void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    Transition localTransition = (Transition)paramObject;
    boolean bool = localTransition instanceof TransitionSet;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramObject = (TransitionSet)localTransition;
      i = ((TransitionSet)paramObject).getTransitionCount();
      while (j < i)
      {
        replaceTargets(((TransitionSet)paramObject).getTransitionAt(j), paramArrayList1, paramArrayList2);
        j++;
      }
    }
    if (!hasSimpleTarget(localTransition))
    {
      paramObject = localTransition.getTargets();
      if ((((List)paramObject).size() == paramArrayList1.size()) && (((List)paramObject).containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          j = 0;
        } else {
          j = paramArrayList2.size();
        }
        while (i < j)
        {
          localTransition.addTarget((View)paramArrayList2.get(i));
          i++;
        }
        for (j = paramArrayList1.size() - 1; j >= 0; j--) {
          localTransition.removeTarget((View)paramArrayList1.get(j));
        }
      }
    }
  }
  
  public void scheduleHideFragmentView(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).addListener(new Transition.TransitionListener()
    {
      public void onTransitionCancel(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
      {
        paramAnonymousTransition.removeListener(this);
        paramView.setVisibility(8);
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++) {
          ((View)paramArrayList.get(j)).setVisibility(0);
        }
      }
      
      public void onTransitionPause(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionResume(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionStart(@NonNull Transition paramAnonymousTransition)
      {
        paramAnonymousTransition.removeListener(this);
        paramAnonymousTransition.addListener(this);
      }
    });
  }
  
  public void scheduleRemoveTargets(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new TransitionListenerAdapter()
    {
      public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
      {
        paramAnonymousTransition.removeListener(this);
      }
      
      public void onTransitionStart(@NonNull Transition paramAnonymousTransition)
      {
        paramAnonymousTransition = paramObject2;
        if (paramAnonymousTransition != null) {
          FragmentTransitionSupport.this.replaceTargets(paramAnonymousTransition, paramArrayList1, null);
        }
        paramAnonymousTransition = paramObject3;
        if (paramAnonymousTransition != null) {
          FragmentTransitionSupport.this.replaceTargets(paramAnonymousTransition, paramArrayList2, null);
        }
        paramAnonymousTransition = paramObject4;
        if (paramAnonymousTransition != null) {
          FragmentTransitionSupport.this.replaceTargets(paramAnonymousTransition, paramArrayList3, null);
        }
      }
    });
  }
  
  public void setEpicenter(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public Rect onGetEpicenter(@NonNull Transition paramAnonymousTransition)
        {
          paramAnonymousTransition = paramRect;
          if ((paramAnonymousTransition != null) && (!paramAnonymousTransition.isEmpty())) {
            return paramRect;
          }
          return null;
        }
      });
    }
  }
  
  public void setEpicenter(final Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      Transition localTransition = (Transition)paramObject;
      paramObject = new Rect();
      getBoundsOnScreen(paramView, (Rect)paramObject);
      localTransition.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public Rect onGetEpicenter(@NonNull Transition paramAnonymousTransition)
        {
          return paramObject;
        }
      });
    }
  }
  
  public void setListenerForTransitionEnd(@NonNull final Fragment paramFragment, @NonNull Object paramObject, @NonNull CancellationSignal paramCancellationSignal, @NonNull final Runnable paramRunnable)
  {
    paramFragment = (Transition)paramObject;
    paramCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
    {
      public void onCancel()
      {
        paramFragment.cancel();
      }
    });
    paramFragment.addListener(new Transition.TransitionListener()
    {
      public void onTransitionCancel(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
      {
        paramRunnable.run();
      }
      
      public void onTransitionPause(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionResume(@NonNull Transition paramAnonymousTransition) {}
      
      public void onTransitionStart(@NonNull Transition paramAnonymousTransition) {}
    });
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    TransitionSet localTransitionSet = (TransitionSet)paramObject;
    paramObject = localTransitionSet.getTargets();
    ((List)paramObject).clear();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++) {
      FragmentTransitionImpl.bfsAddViewChildren((List)paramObject, (View)paramArrayList.get(j));
    }
    ((List)paramObject).add(paramView);
    paramArrayList.add(paramView);
    addTargets(localTransitionSet, paramArrayList);
  }
  
  public void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      ((Transition)paramObject).getTargets().clear();
      ((Transition)paramObject).getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object wrapTransitionInSet(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    return localTransitionSet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\FragmentTransitionSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */