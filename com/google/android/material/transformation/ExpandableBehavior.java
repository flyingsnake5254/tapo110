package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior
  extends CoordinatorLayout.Behavior<View>
{
  private static final int STATE_COLLAPSED = 2;
  private static final int STATE_EXPANDED = 1;
  private static final int STATE_UNINITIALIZED = 0;
  private int currentState = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean didStateChange(boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramBoolean)
    {
      int i = this.currentState;
      if (i != 0)
      {
        paramBoolean = bool2;
        if (i != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramBoolean = bool1;
    if (this.currentState == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  @Nullable
  public static <T extends ExpandableBehavior> T from(@NonNull View paramView, @NonNull Class<T> paramClass)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.LayoutParams))
    {
      paramView = ((CoordinatorLayout.LayoutParams)paramView).getBehavior();
      if ((paramView instanceof ExpandableBehavior)) {
        return (ExpandableBehavior)paramClass.cast(paramView);
      }
      throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  @Nullable
  protected ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramView);
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)localList.get(j);
      if (layoutDependsOn(paramCoordinatorLayout, paramView, localView)) {
        return (ExpandableWidget)localView;
      }
    }
    return null;
  }
  
  public abstract boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  @CallSuper
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (ExpandableWidget)paramView2;
    if (didStateChange(paramCoordinatorLayout.isExpanded()))
    {
      int i;
      if (paramCoordinatorLayout.isExpanded()) {
        i = 1;
      } else {
        i = 2;
      }
      this.currentState = i;
      return onExpandedStateChange((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.isExpanded(), true);
    }
    return false;
  }
  
  protected abstract boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  @CallSuper
  public boolean onLayoutChild(@NonNull final CoordinatorLayout paramCoordinatorLayout, @NonNull final View paramView, final int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView))
    {
      paramCoordinatorLayout = findExpandableWidget(paramCoordinatorLayout, paramView);
      if ((paramCoordinatorLayout != null) && (didStateChange(paramCoordinatorLayout.isExpanded())))
      {
        if (paramCoordinatorLayout.isExpanded()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        this.currentState = paramInt;
        paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            paramView.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.currentState == paramInt)
            {
              ExpandableBehavior localExpandableBehavior = ExpandableBehavior.this;
              ExpandableWidget localExpandableWidget = paramCoordinatorLayout;
              localExpandableBehavior.onExpandedStateChange((View)localExpandableWidget, paramView, localExpandableWidget.isExpanded(), false);
            }
            return false;
          }
        });
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transformation\ExpandableBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */