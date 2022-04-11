package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Scene
{
  private Context mContext;
  private Runnable mEnterAction;
  private Runnable mExitAction;
  private View mLayout;
  private int mLayoutId = -1;
  private ViewGroup mSceneRoot;
  
  public Scene(@NonNull ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
  }
  
  private Scene(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    this.mContext = paramContext;
    this.mSceneRoot = paramViewGroup;
    this.mLayoutId = paramInt;
  }
  
  public Scene(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    this.mSceneRoot = paramViewGroup;
    this.mLayout = paramView;
  }
  
  @Nullable
  public static Scene getCurrentScene(@NonNull ViewGroup paramViewGroup)
  {
    return (Scene)paramViewGroup.getTag(R.id.transition_current_scene);
  }
  
  @NonNull
  public static Scene getSceneForLayout(@NonNull ViewGroup paramViewGroup, @LayoutRes int paramInt, @NonNull Context paramContext)
  {
    int i = R.id.transition_scene_layoutid_cache;
    Object localObject1 = (SparseArray)paramViewGroup.getTag(i);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new SparseArray();
      paramViewGroup.setTag(i, localObject2);
    }
    localObject1 = (Scene)((SparseArray)localObject2).get(paramInt);
    if (localObject1 != null) {
      return (Scene)localObject1;
    }
    paramViewGroup = new Scene(paramViewGroup, paramInt, paramContext);
    ((SparseArray)localObject2).put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  static void setCurrentScene(@NonNull ViewGroup paramViewGroup, @Nullable Scene paramScene)
  {
    paramViewGroup.setTag(R.id.transition_current_scene, paramScene);
  }
  
  public void enter()
  {
    if ((this.mLayoutId > 0) || (this.mLayout != null))
    {
      getSceneRoot().removeAllViews();
      if (this.mLayoutId > 0) {
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
      } else {
        this.mSceneRoot.addView(this.mLayout);
      }
    }
    Runnable localRunnable = this.mEnterAction;
    if (localRunnable != null) {
      localRunnable.run();
    }
    setCurrentScene(this.mSceneRoot, this);
  }
  
  public void exit()
  {
    if (getCurrentScene(this.mSceneRoot) == this)
    {
      Runnable localRunnable = this.mExitAction;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  @NonNull
  public ViewGroup getSceneRoot()
  {
    return this.mSceneRoot;
  }
  
  boolean isCreatedFromLayoutResource()
  {
    boolean bool;
    if (this.mLayoutId > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setEnterAction(@Nullable Runnable paramRunnable)
  {
    this.mEnterAction = paramRunnable;
  }
  
  public void setExitAction(@Nullable Runnable paramRunnable)
  {
    this.mExitAction = paramRunnable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\Scene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */