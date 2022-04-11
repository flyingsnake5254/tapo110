package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R.id;

class ItemTouchUIUtilImpl
  implements ItemTouchUIUtil
{
  static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();
  
  private static float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
  {
    int i = paramRecyclerView.getChildCount();
    float f1 = 0.0F;
    int j = 0;
    while (j < i)
    {
      View localView = paramRecyclerView.getChildAt(j);
      float f2;
      if (localView == paramView)
      {
        f2 = f1;
      }
      else
      {
        float f3 = ViewCompat.getElevation(localView);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
      j++;
      f1 = f2;
    }
    return f1;
  }
  
  public void clearView(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = R.id.item_touch_helper_previous_elevation;
      Object localObject = paramView.getTag(i);
      if ((localObject instanceof Float)) {
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(i, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean))
    {
      paramInt = R.id.item_touch_helper_previous_elevation;
      if (paramView.getTag(paramInt) == null)
      {
        float f = ViewCompat.getElevation(paramView);
        ViewCompat.setElevation(paramView, findMaxElevation(paramRecyclerView, paramView) + 1.0F);
        paramView.setTag(paramInt, Float.valueOf(f));
      }
    }
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void onSelected(View paramView) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ItemTouchUIUtilImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */