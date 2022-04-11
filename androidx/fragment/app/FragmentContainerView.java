package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.R.styleable;
import java.util.ArrayList;

public final class FragmentContainerView
  extends FrameLayout
{
  private ArrayList<View> mDisappearingFragmentChildren;
  private boolean mDrawDisappearingViewsFirst = true;
  private ArrayList<View> mTransitioningFragmentViews;
  
  public FragmentContainerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FragmentContainerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FragmentContainerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
  }
  
  FragmentContainerView(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, @NonNull FragmentManager paramFragmentManager)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getClassAttribute();
    Object localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FragmentContainerView);
    Object localObject2 = str;
    if (str == null) {
      localObject2 = ((TypedArray)localObject1).getString(R.styleable.FragmentContainerView_android_name);
    }
    str = ((TypedArray)localObject1).getString(R.styleable.FragmentContainerView_android_tag);
    ((TypedArray)localObject1).recycle();
    int i = getId();
    localObject1 = paramFragmentManager.findFragmentById(i);
    if ((localObject2 != null) && (localObject1 == null))
    {
      if (i <= 0)
      {
        if (str != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(" with tag ");
          paramContext.append(str);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("FragmentContainerView must have an android:id to add Fragment ");
        paramAttributeSet.append((String)localObject2);
        paramAttributeSet.append(paramContext);
        throw new IllegalStateException(paramAttributeSet.toString());
      }
      localObject2 = paramFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), (String)localObject2);
      ((Fragment)localObject2).onInflate(paramContext, paramAttributeSet, null);
      paramFragmentManager.beginTransaction().setReorderingAllowed(true).add(this, (Fragment)localObject2, str).commitNowAllowingStateLoss();
    }
  }
  
  private void addDisappearingFragmentView(@NonNull View paramView)
  {
    if (paramView.getAnimation() == null)
    {
      ArrayList localArrayList = this.mTransitioningFragmentViews;
      if ((localArrayList == null) || (!localArrayList.contains(paramView))) {}
    }
    else
    {
      if (this.mDisappearingFragmentChildren == null) {
        this.mDisappearingFragmentChildren = new ArrayList();
      }
      this.mDisappearingFragmentChildren.add(paramView);
    }
  }
  
  public void addView(@NonNull View paramView, int paramInt, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    if (FragmentManager.getViewFragment(paramView) != null)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  protected boolean addViewInLayout(@NonNull View paramView, int paramInt, @Nullable ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (FragmentManager.getViewFragment(paramView) != null) {
      return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  protected void dispatchDraw(@NonNull Canvas paramCanvas)
  {
    if ((this.mDrawDisappearingViewsFirst) && (this.mDisappearingFragmentChildren != null)) {
      for (int i = 0; i < this.mDisappearingFragmentChildren.size(); i++) {
        super.drawChild(paramCanvas, (View)this.mDisappearingFragmentChildren.get(i), getDrawingTime());
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(@NonNull Canvas paramCanvas, @NonNull View paramView, long paramLong)
  {
    if (this.mDrawDisappearingViewsFirst)
    {
      ArrayList localArrayList = this.mDisappearingFragmentChildren;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (this.mDisappearingFragmentChildren.contains(paramView))) {
        return false;
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void endViewTransition(@NonNull View paramView)
  {
    ArrayList localArrayList = this.mTransitioningFragmentViews;
    if (localArrayList != null)
    {
      localArrayList.remove(paramView);
      localArrayList = this.mDisappearingFragmentChildren;
      if ((localArrayList != null) && (localArrayList.remove(paramView))) {
        this.mDrawDisappearingViewsFirst = true;
      }
    }
    super.endViewTransition(paramView);
  }
  
  @NonNull
  @RequiresApi(20)
  public WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    for (int i = 0; i < getChildCount(); i++) {
      getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(paramWindowInsets));
    }
    return paramWindowInsets;
  }
  
  public void removeAllViewsInLayout()
  {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      addDisappearingFragmentView(getChildAt(i));
    }
    super.removeAllViewsInLayout();
  }
  
  protected void removeDetachedView(@NonNull View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      addDisappearingFragmentView(paramView);
    }
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeView(@NonNull View paramView)
  {
    addDisappearingFragmentView(paramView);
    super.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    addDisappearingFragmentView(getChildAt(paramInt));
    super.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(@NonNull View paramView)
  {
    addDisappearingFragmentView(paramView);
    super.removeViewInLayout(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      addDisappearingFragmentView(getChildAt(i));
    }
    super.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      addDisappearingFragmentView(getChildAt(i));
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    this.mDrawDisappearingViewsFirst = paramBoolean;
  }
  
  public void setLayoutTransition(@Nullable LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      super.setLayoutTransition(paramLayoutTransition);
      return;
    }
    throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
  }
  
  public void startViewTransition(@NonNull View paramView)
  {
    if (paramView.getParent() == this)
    {
      if (this.mTransitioningFragmentViews == null) {
        this.mTransitioningFragmentViews = new ArrayList();
      }
      this.mTransitioningFragmentViews.add(paramView);
    }
    super.startViewTransition(paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */