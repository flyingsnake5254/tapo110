package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R.styleable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavGraph
  extends NavDestination
  implements Iterable<NavDestination>
{
  final SparseArrayCompat<NavDestination> mNodes = new SparseArrayCompat();
  private int mStartDestId;
  private String mStartDestIdName;
  
  public NavGraph(@NonNull Navigator<? extends NavGraph> paramNavigator)
  {
    super(paramNavigator);
  }
  
  public final void addAll(@NonNull NavGraph paramNavGraph)
  {
    paramNavGraph = paramNavGraph.iterator();
    while (paramNavGraph.hasNext())
    {
      NavDestination localNavDestination = (NavDestination)paramNavGraph.next();
      paramNavGraph.remove();
      addDestination(localNavDestination);
    }
  }
  
  public final void addDestination(@NonNull NavDestination paramNavDestination)
  {
    int i = paramNavDestination.getId();
    if (i != 0)
    {
      if (i != getId())
      {
        localObject = (NavDestination)this.mNodes.get(i);
        if (localObject == paramNavDestination) {
          return;
        }
        if (paramNavDestination.getParent() == null)
        {
          if (localObject != null) {
            ((NavDestination)localObject).setParent(null);
          }
          paramNavDestination.setParent(this);
          this.mNodes.put(paramNavDestination.getId(), paramNavDestination);
          return;
        }
        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Destination ");
      ((StringBuilder)localObject).append(paramNavDestination);
      ((StringBuilder)localObject).append(" cannot have the same id as graph ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
  }
  
  public final void addDestinations(@NonNull Collection<NavDestination> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      NavDestination localNavDestination = (NavDestination)paramCollection.next();
      if (localNavDestination != null) {
        addDestination(localNavDestination);
      }
    }
  }
  
  public final void addDestinations(@NonNull NavDestination... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      NavDestination localNavDestination = paramVarArgs[j];
      if (localNavDestination != null) {
        addDestination(localNavDestination);
      }
    }
  }
  
  public final void clear()
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }
  
  @Nullable
  public final NavDestination findNode(@IdRes int paramInt)
  {
    return findNode(paramInt, true);
  }
  
  @Nullable
  final NavDestination findNode(@IdRes int paramInt, boolean paramBoolean)
  {
    NavDestination localNavDestination = (NavDestination)this.mNodes.get(paramInt);
    if (localNavDestination == null) {
      if ((paramBoolean) && (getParent() != null)) {
        localNavDestination = getParent().findNode(paramInt);
      } else {
        localNavDestination = null;
      }
    }
    return localNavDestination;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public String getDisplayName()
  {
    String str;
    if (getId() != 0) {
      str = super.getDisplayName();
    } else {
      str = "the root navigation";
    }
    return str;
  }
  
  @NonNull
  String getStartDestDisplayName()
  {
    if (this.mStartDestIdName == null) {
      this.mStartDestIdName = Integer.toString(this.mStartDestId);
    }
    return this.mStartDestIdName;
  }
  
  @IdRes
  public final int getStartDestination()
  {
    return this.mStartDestId;
  }
  
  @NonNull
  public final Iterator<NavDestination> iterator()
  {
    new Iterator()
    {
      private int mIndex = -1;
      private boolean mWentToNext = false;
      
      public boolean hasNext()
      {
        int i = this.mIndex;
        boolean bool = true;
        if (i + 1 >= NavGraph.this.mNodes.size()) {
          bool = false;
        }
        return bool;
      }
      
      public NavDestination next()
      {
        if (hasNext())
        {
          this.mWentToNext = true;
          SparseArrayCompat localSparseArrayCompat = NavGraph.this.mNodes;
          int i = this.mIndex + 1;
          this.mIndex = i;
          return (NavDestination)localSparseArrayCompat.valueAt(i);
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        if (this.mWentToNext)
        {
          ((NavDestination)NavGraph.this.mNodes.valueAt(this.mIndex)).setParent(null);
          NavGraph.this.mNodes.removeAt(this.mIndex);
          this.mIndex -= 1;
          this.mWentToNext = false;
          return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element");
      }
    };
  }
  
  @Nullable
  NavDestination.DeepLinkMatch matchDeepLink(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest)
  {
    Object localObject = super.matchDeepLink(paramNavDeepLinkRequest);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      NavDestination.DeepLinkMatch localDeepLinkMatch = ((NavDestination)localIterator.next()).matchDeepLink(paramNavDeepLinkRequest);
      if ((localDeepLinkMatch != null) && ((localObject == null) || (localDeepLinkMatch.compareTo((NavDestination.DeepLinkMatch)localObject) > 0))) {
        localObject = localDeepLinkMatch;
      }
    }
    return (NavDestination.DeepLinkMatch)localObject;
  }
  
  public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    super.onInflate(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.NavGraphNavigator);
    setStartDestination(paramAttributeSet.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
    this.mStartDestIdName = NavDestination.getDisplayName(paramContext, this.mStartDestId);
    paramAttributeSet.recycle();
  }
  
  public final void remove(@NonNull NavDestination paramNavDestination)
  {
    int i = this.mNodes.indexOfKey(paramNavDestination.getId());
    if (i >= 0)
    {
      ((NavDestination)this.mNodes.valueAt(i)).setParent(null);
      this.mNodes.removeAt(i);
    }
  }
  
  public final void setStartDestination(@IdRes int paramInt)
  {
    if (paramInt != getId())
    {
      this.mStartDestId = paramInt;
      this.mStartDestIdName = null;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start destination ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" cannot use the same id as the graph ");
    localStringBuilder.append(this);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" startDestination=");
    Object localObject = findNode(getStartDestination());
    if (localObject == null)
    {
      localObject = this.mStartDestIdName;
      if (localObject == null)
      {
        localStringBuilder.append("0x");
        localStringBuilder.append(Integer.toHexString(this.mStartDestId));
      }
      else
      {
        localStringBuilder.append((String)localObject);
      }
    }
    else
    {
      localStringBuilder.append("{");
      localStringBuilder.append(((NavDestination)localObject).toString());
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */