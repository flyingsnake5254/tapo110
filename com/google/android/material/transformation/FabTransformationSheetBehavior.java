package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.animator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  @Nullable
  private Map<View, Integer> importantForAccessibilityMap;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void updateImportantForAccessibility(@NonNull View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localObject;
    int i = localCoordinatorLayout.getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      this.importantForAccessibilityMap = new HashMap(i);
    }
    for (int j = 0; j < i; j++)
    {
      View localView = localCoordinatorLayout.getChildAt(j);
      int k;
      if (((localView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior))) {
        k = 1;
      } else {
        k = 0;
      }
      if ((localView != paramView) && (k == 0)) {
        if (!paramBoolean)
        {
          localObject = this.importantForAccessibilityMap;
          if ((localObject != null) && (((Map)localObject).containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)this.importantForAccessibilityMap.get(localView)).intValue());
          }
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 16) {
            this.importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          ViewCompat.setImportantForAccessibility(localView, 4);
        }
      }
    }
    if (!paramBoolean) {
      this.importantForAccessibilityMap = null;
    }
  }
  
  @NonNull
  protected FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    }
    FabTransformationBehavior.FabTransformationSpec localFabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
    localFabTransformationSpec.timings = MotionSpec.createFromResource(paramContext, i);
    localFabTransformationSpec.positioning = new Positioning(17, 0.0F, 0.0F);
    return localFabTransformationSpec;
  }
  
  @CallSuper
  protected boolean onExpandedStateChange(@NonNull View paramView1, @NonNull View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateImportantForAccessibility(paramView2, paramBoolean1);
    return super.onExpandedStateChange(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transformation\FabTransformationSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */