package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressLint({"UnknownNullness"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl
{
  protected static void bfsAddViewChildren(List<View> paramList, View paramView)
  {
    int i = paramList.size();
    if (containedBeforeIndex(paramList, paramView, i)) {
      return;
    }
    paramList.add(paramView);
    for (int j = i; j < paramList.size(); j++)
    {
      paramView = (View)paramList.get(j);
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int k = localViewGroup.getChildCount();
        for (int m = 0; m < k; m++)
        {
          paramView = localViewGroup.getChildAt(m);
          if (!containedBeforeIndex(paramList, paramView, i)) {
            paramList.add(paramView);
          }
        }
      }
    }
  }
  
  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (paramList.get(i) == paramView) {
        return true;
      }
    }
    return false;
  }
  
  static String findKeyForValue(Map<String, String> paramMap, String paramString)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if (paramString.equals(paramMap.getValue())) {
        return (String)paramMap.getKey();
      }
    }
    return null;
  }
  
  protected static boolean isNullOrEmpty(List paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract void addTarget(Object paramObject, View paramView);
  
  public abstract void addTargets(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean canHandle(Object paramObject);
  
  void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0) {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (ViewGroupCompat.isTransitionGroup(paramView))
        {
          paramArrayList.add(paramView);
        }
        else
        {
          int i = paramView.getChildCount();
          for (int j = 0; j < i; j++) {
            captureTransitioningViews(paramArrayList, paramView.getChildAt(j));
          }
        }
      }
      else
      {
        paramArrayList.add(paramView);
      }
    }
  }
  
  public abstract Object cloneTransition(Object paramObject);
  
  void findNamedViews(Map<String, View> paramMap, @NonNull View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = paramView.getChildCount();
        for (int j = 0; j < i; j++) {
          findNamedViews(paramMap, paramView.getChildAt(j));
        }
      }
    }
  }
  
  protected void getBoundsOnScreen(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);
  
  ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)paramArrayList.get(j);
      localArrayList.add(ViewCompat.getTransitionName(localView));
      ViewCompat.setTransitionName(localView, null);
    }
    return localArrayList;
  }
  
  public abstract void removeTarget(Object paramObject, View paramView);
  
  public abstract void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  void scheduleNameReset(ViewGroup paramViewGroup, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    OneShotPreDrawListener.add(paramViewGroup, new Runnable()
    {
      public void run()
      {
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++)
        {
          View localView = (View)paramArrayList.get(j);
          String str = ViewCompat.getTransitionName(localView);
          ViewCompat.setTransitionName(localView, (String)paramMap.get(str));
        }
      }
    });
  }
  
  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void setEpicenter(Object paramObject, Rect paramRect);
  
  public abstract void setEpicenter(Object paramObject, View paramView);
  
  public void setListenerForTransitionEnd(@NonNull Fragment paramFragment, @NonNull Object paramObject, @NonNull CancellationSignal paramCancellationSignal, @NonNull Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  void setNameOverridesOrdered(View paramView, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    OneShotPreDrawListener.add(paramView, new Runnable()
    {
      public void run()
      {
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++)
        {
          View localView = (View)paramArrayList.get(j);
          String str = ViewCompat.getTransitionName(localView);
          if (str != null) {
            ViewCompat.setTransitionName(localView, FragmentTransitionImpl.findKeyForValue(paramMap, str));
          }
        }
      }
    });
  }
  
  void setNameOverridesReordered(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int i = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (View)paramArrayList1.get(j);
      String str = ViewCompat.getTransitionName((View)localObject);
      localArrayList.add(str);
      if (str != null)
      {
        ViewCompat.setTransitionName((View)localObject, null);
        localObject = (String)paramMap.get(str);
        for (int k = 0; k < i; k++) {
          if (((String)localObject).equals(paramArrayList.get(k)))
          {
            ViewCompat.setTransitionName((View)paramArrayList2.get(k), str);
            break;
          }
        }
      }
    }
    OneShotPreDrawListener.add(paramView, new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < i; i++)
        {
          ViewCompat.setTransitionName((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
          ViewCompat.setTransitionName((View)paramArrayList1.get(i), (String)localArrayList.get(i));
        }
      }
    });
  }
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object wrapTransitionInSet(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentTransitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */