package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder
  extends FrameLayout
{
  private boolean mAttached;
  @NonNull
  private ViewGroup mParent;
  
  GhostViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    setClipChildren(false);
    this.mParent = paramViewGroup;
    paramViewGroup.setTag(R.id.ghost_view_holder, this);
    ViewGroupUtils.getOverlay(this.mParent).add(this);
    this.mAttached = true;
  }
  
  static GhostViewHolder getHolder(@NonNull ViewGroup paramViewGroup)
  {
    return (GhostViewHolder)paramViewGroup.getTag(R.id.ghost_view_holder);
  }
  
  private int getInsertIndex(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = getChildCount() - 1;
    int j = 0;
    while (j <= i)
    {
      int k = (j + i) / 2;
      getParents(((GhostViewPort)getChildAt(k)).mView, localArrayList);
      if (isOnTop(paramArrayList, localArrayList)) {
        j = k + 1;
      } else {
        i = k - 1;
      }
      localArrayList.clear();
    }
    return j;
  }
  
  private static void getParents(View paramView, ArrayList<View> paramArrayList)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      getParents((View)localViewParent, paramArrayList);
    }
    paramArrayList.add(paramView);
  }
  
  private static boolean isOnTop(View paramView1, View paramView2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
    int i = localViewGroup.getChildCount();
    int j = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((j >= 21) && (paramView1.getZ() != paramView2.getZ()))
    {
      if (paramView1.getZ() > paramView2.getZ()) {
        bool2 = true;
      }
      return bool2;
    }
    for (j = 0; j < i; j++)
    {
      View localView = localViewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(localViewGroup, j));
      if (localView == paramView1)
      {
        bool2 = bool1;
        break label113;
      }
      if (localView == paramView2) {
        break;
      }
    }
    bool2 = true;
    label113:
    return bool2;
  }
  
  private static boolean isOnTop(ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    boolean bool1 = paramArrayList1.isEmpty();
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (!bool1)
    {
      bool3 = bool2;
      if (!paramArrayList2.isEmpty()) {
        if (paramArrayList1.get(0) != paramArrayList2.get(0))
        {
          bool3 = bool2;
        }
        else
        {
          int i = Math.min(paramArrayList1.size(), paramArrayList2.size());
          for (int j = 1; j < i; j++)
          {
            View localView1 = (View)paramArrayList1.get(j);
            View localView2 = (View)paramArrayList2.get(j);
            if (localView1 != localView2) {
              return isOnTop(localView1, localView2);
            }
          }
          if (paramArrayList2.size() == i) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
        }
      }
    }
    return bool3;
  }
  
  void addGhostView(GhostViewPort paramGhostViewPort)
  {
    ArrayList localArrayList = new ArrayList();
    getParents(paramGhostViewPort.mView, localArrayList);
    int i = getInsertIndex(localArrayList);
    if ((i >= 0) && (i < getChildCount())) {
      addView(paramGhostViewPort, i);
    } else {
      addView(paramGhostViewPort);
    }
  }
  
  public void onViewAdded(View paramView)
  {
    if (this.mAttached)
    {
      super.onViewAdded(paramView);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (((getChildCount() == 1) && (getChildAt(0) == paramView)) || (getChildCount() == 0))
    {
      this.mParent.setTag(R.id.ghost_view_holder, null);
      ViewGroupUtils.getOverlay(this.mParent).remove(this);
      this.mAttached = false;
    }
  }
  
  void popToOverlayTop()
  {
    if (this.mAttached)
    {
      ViewGroupUtils.getOverlay(this.mParent).remove(this);
      ViewGroupUtils.getOverlay(this.mParent).add(this);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\GhostViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */