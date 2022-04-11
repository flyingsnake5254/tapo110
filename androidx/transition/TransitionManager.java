package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager
{
  private static final String LOG_TAG = "TransitionManager";
  private static Transition sDefaultTransition = new AutoTransition();
  static ArrayList<ViewGroup> sPendingTransitions = new ArrayList();
  private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal();
  private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap();
  private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap();
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup)
  {
    beginDelayedTransition(paramViewGroup, null);
  }
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup, @Nullable Transition paramTransition)
  {
    if ((!sPendingTransitions.contains(paramViewGroup)) && (ViewCompat.isLaidOut(paramViewGroup)))
    {
      sPendingTransitions.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = sDefaultTransition;
      }
      paramTransition = localTransition.clone();
      sceneChangeSetup(paramViewGroup, paramTransition);
      Scene.setCurrentScene(paramViewGroup, null);
      sceneChangeRunTransition(paramViewGroup, paramTransition);
    }
  }
  
  private static void changeScene(Scene paramScene, Transition paramTransition)
  {
    ViewGroup localViewGroup = paramScene.getSceneRoot();
    if (!sPendingTransitions.contains(localViewGroup))
    {
      Scene localScene = Scene.getCurrentScene(localViewGroup);
      if (paramTransition == null)
      {
        if (localScene != null) {
          localScene.exit();
        }
        paramScene.enter();
      }
      else
      {
        sPendingTransitions.add(localViewGroup);
        paramTransition = paramTransition.clone();
        paramTransition.setSceneRoot(localViewGroup);
        if ((localScene != null) && (localScene.isCreatedFromLayoutResource())) {
          paramTransition.setCanRemoveViews(true);
        }
        sceneChangeSetup(localViewGroup, paramTransition);
        paramScene.enter();
        sceneChangeRunTransition(localViewGroup, paramTransition);
      }
    }
  }
  
  public static void endTransitions(ViewGroup paramViewGroup)
  {
    sPendingTransitions.remove(paramViewGroup);
    ArrayList localArrayList = (ArrayList)getRunningTransitions().get(paramViewGroup);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localArrayList = new ArrayList(localArrayList);
      for (int i = localArrayList.size() - 1; i >= 0; i--) {
        ((Transition)localArrayList.get(i)).forceToEnd(paramViewGroup);
      }
    }
  }
  
  static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions()
  {
    Object localObject = (WeakReference)sRunningTransitions.get();
    if (localObject != null)
    {
      localObject = (ArrayMap)((WeakReference)localObject).get();
      if (localObject != null) {
        return (ArrayMap<ViewGroup, ArrayList<Transition>>)localObject;
      }
    }
    localObject = new ArrayMap();
    WeakReference localWeakReference = new WeakReference(localObject);
    sRunningTransitions.set(localWeakReference);
    return (ArrayMap<ViewGroup, ArrayList<Transition>>)localObject;
  }
  
  private Transition getTransition(Scene paramScene)
  {
    Object localObject = paramScene.getSceneRoot();
    if (localObject != null)
    {
      localObject = Scene.getCurrentScene((ViewGroup)localObject);
      if (localObject != null)
      {
        ArrayMap localArrayMap = (ArrayMap)this.mScenePairTransitions.get(paramScene);
        if (localArrayMap != null)
        {
          localObject = (Transition)localArrayMap.get(localObject);
          if (localObject != null) {
            return (Transition)localObject;
          }
        }
      }
    }
    paramScene = (Transition)this.mSceneTransitions.get(paramScene);
    if (paramScene == null) {
      paramScene = sDefaultTransition;
    }
    return paramScene;
  }
  
  public static void go(@NonNull Scene paramScene)
  {
    changeScene(paramScene, sDefaultTransition);
  }
  
  public static void go(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    changeScene(paramScene, paramTransition);
  }
  
  private static void sceneChangeRunTransition(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new MultiListener(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
  
  private static void sceneChangeSetup(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)getRunningTransitions().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).pause(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.captureValues(paramViewGroup, true);
    }
    paramViewGroup = Scene.getCurrentScene(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.exit();
    }
  }
  
  public void setTransition(@NonNull Scene paramScene1, @NonNull Scene paramScene2, @Nullable Transition paramTransition)
  {
    ArrayMap localArrayMap1 = (ArrayMap)this.mScenePairTransitions.get(paramScene2);
    ArrayMap localArrayMap2 = localArrayMap1;
    if (localArrayMap1 == null)
    {
      localArrayMap2 = new ArrayMap();
      this.mScenePairTransitions.put(paramScene2, localArrayMap2);
    }
    localArrayMap2.put(paramScene1, paramTransition);
  }
  
  public void setTransition(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    this.mSceneTransitions.put(paramScene, paramTransition);
  }
  
  public void transitionTo(@NonNull Scene paramScene)
  {
    changeScene(paramScene, getTransition(paramScene));
  }
  
  private static class MultiListener
    implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener
  {
    ViewGroup mSceneRoot;
    Transition mTransition;
    
    MultiListener(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.mTransition = paramTransition;
      this.mSceneRoot = paramViewGroup;
    }
    
    private void removeListeners()
    {
      this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
      this.mSceneRoot.removeOnAttachStateChangeListener(this);
    }
    
    public boolean onPreDraw()
    {
      removeListeners();
      if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
        return true;
      }
      final ArrayMap localArrayMap = TransitionManager.getRunningTransitions();
      ArrayList localArrayList1 = (ArrayList)localArrayMap.get(this.mSceneRoot);
      ArrayList localArrayList2 = null;
      Object localObject;
      if (localArrayList1 == null)
      {
        localObject = new ArrayList();
        localArrayMap.put(this.mSceneRoot, localObject);
      }
      else
      {
        localObject = localArrayList1;
        if (localArrayList1.size() > 0)
        {
          localArrayList2 = new ArrayList(localArrayList1);
          localObject = localArrayList1;
        }
      }
      ((ArrayList)localObject).add(this.mTransition);
      this.mTransition.addListener(new TransitionListenerAdapter()
      {
        public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
        {
          ((ArrayList)localArrayMap.get(TransitionManager.MultiListener.this.mSceneRoot)).remove(paramAnonymousTransition);
          paramAnonymousTransition.removeListener(this);
        }
      });
      this.mTransition.captureValues(this.mSceneRoot, false);
      if (localArrayList2 != null)
      {
        localObject = localArrayList2.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).resume(this.mSceneRoot);
        }
      }
      this.mTransition.playTransition(this.mSceneRoot);
      return true;
    }
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      removeListeners();
      TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
      paramView = (ArrayList)TransitionManager.getRunningTransitions().get(this.mSceneRoot);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).resume(this.mSceneRoot);
        }
      }
      this.mTransition.clearValues(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */