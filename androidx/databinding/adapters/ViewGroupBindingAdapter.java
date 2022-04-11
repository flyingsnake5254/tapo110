package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:alwaysDrawnWithCache", method="setAlwaysDrawnWithCacheEnabled", type=ViewGroup.class), @androidx.databinding.BindingMethod(attribute="android:animationCache", method="setAnimationCacheEnabled", type=ViewGroup.class), @androidx.databinding.BindingMethod(attribute="android:splitMotionEvents", method="setMotionEventSplittingEnabled", type=ViewGroup.class)})
public class ViewGroupBindingAdapter
{
  @TargetApi(11)
  @BindingAdapter({"android:animateLayoutChanges"})
  public static void setAnimateLayoutChanges(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramViewGroup.setLayoutTransition(new LayoutTransition());
    } else {
      paramViewGroup.setLayoutTransition(null);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onAnimationStart", "android:onAnimationEnd", "android:onAnimationRepeat"})
  public static void setListener(ViewGroup paramViewGroup, OnAnimationStart paramOnAnimationStart, final OnAnimationEnd paramOnAnimationEnd, final OnAnimationRepeat paramOnAnimationRepeat)
  {
    if ((paramOnAnimationStart == null) && (paramOnAnimationEnd == null) && (paramOnAnimationRepeat == null)) {
      paramViewGroup.setLayoutAnimationListener(null);
    } else {
      paramViewGroup.setLayoutAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          ViewGroupBindingAdapter.OnAnimationEnd localOnAnimationEnd = paramOnAnimationEnd;
          if (localOnAnimationEnd != null) {
            localOnAnimationEnd.onAnimationEnd(paramAnonymousAnimation);
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          ViewGroupBindingAdapter.OnAnimationRepeat localOnAnimationRepeat = paramOnAnimationRepeat;
          if (localOnAnimationRepeat != null) {
            localOnAnimationRepeat.onAnimationRepeat(paramAnonymousAnimation);
          }
        }
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          ViewGroupBindingAdapter.OnAnimationStart localOnAnimationStart = this.val$start;
          if (localOnAnimationStart != null) {
            localOnAnimationStart.onAnimationStart(paramAnonymousAnimation);
          }
        }
      });
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onChildViewAdded", "android:onChildViewRemoved"})
  public static void setListener(ViewGroup paramViewGroup, OnChildViewAdded paramOnChildViewAdded, final OnChildViewRemoved paramOnChildViewRemoved)
  {
    if ((paramOnChildViewAdded == null) && (paramOnChildViewRemoved == null)) {
      paramViewGroup.setOnHierarchyChangeListener(null);
    } else {
      paramViewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          ViewGroupBindingAdapter.OnChildViewAdded localOnChildViewAdded = this.val$added;
          if (localOnChildViewAdded != null) {
            localOnChildViewAdded.onChildViewAdded(paramAnonymousView1, paramAnonymousView2);
          }
        }
        
        public void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
        {
          ViewGroupBindingAdapter.OnChildViewRemoved localOnChildViewRemoved = paramOnChildViewRemoved;
          if (localOnChildViewRemoved != null) {
            localOnChildViewRemoved.onChildViewRemoved(paramAnonymousView1, paramAnonymousView2);
          }
        }
      });
    }
  }
  
  public static abstract interface OnAnimationEnd
  {
    public abstract void onAnimationEnd(Animation paramAnimation);
  }
  
  public static abstract interface OnAnimationRepeat
  {
    public abstract void onAnimationRepeat(Animation paramAnimation);
  }
  
  public static abstract interface OnAnimationStart
  {
    public abstract void onAnimationStart(Animation paramAnimation);
  }
  
  public static abstract interface OnChildViewAdded
  {
    public abstract void onChildViewAdded(View paramView1, View paramView2);
  }
  
  public static abstract interface OnChildViewRemoved
  {
    public abstract void onChildViewRemoved(View paramView1, View paramView2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ViewGroupBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */