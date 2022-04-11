package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R.styleable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NavDestination
{
  private static final HashMap<String, Class<?>> sClasses = new HashMap();
  private SparseArrayCompat<NavAction> mActions;
  private HashMap<String, NavArgument> mArguments;
  private ArrayList<NavDeepLink> mDeepLinks;
  private int mId;
  private String mIdName;
  private CharSequence mLabel;
  private final String mNavigatorName;
  private NavGraph mParent;
  
  public NavDestination(@NonNull Navigator<? extends NavDestination> paramNavigator)
  {
    this(NavigatorProvider.getNameForNavigator(paramNavigator.getClass()));
  }
  
  public NavDestination(@NonNull String paramString)
  {
    this.mNavigatorName = paramString;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  static String getDisplayName(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt <= 16777215) {
      return Integer.toString(paramInt);
    }
    try
    {
      paramContext = paramContext.getResources().getResourceName(paramInt);
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext) {}
    return Integer.toString(paramInt);
  }
  
  @NonNull
  protected static <C> Class<? extends C> parseClassFromName(@NonNull Context paramContext, @NonNull String paramString, @NonNull Class<? extends C> paramClass)
  {
    Object localObject = paramString;
    if (paramString.charAt(0) == '.')
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    HashMap localHashMap = sClasses;
    Class localClass = (Class)localHashMap.get(localObject);
    paramString = localClass;
    if (localClass == null) {
      try
      {
        paramString = Class.forName((String)localObject, true, paramContext.getClassLoader());
        localHashMap.put(localObject, paramString);
      }
      catch (ClassNotFoundException paramContext)
      {
        throw new IllegalArgumentException(paramContext);
      }
    }
    if (paramClass.isAssignableFrom(paramString)) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject);
    paramContext.append(" must be a subclass of ");
    paramContext.append(paramClass);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public final void addArgument(@NonNull String paramString, @NonNull NavArgument paramNavArgument)
  {
    if (this.mArguments == null) {
      this.mArguments = new HashMap();
    }
    this.mArguments.put(paramString, paramNavArgument);
  }
  
  public final void addDeepLink(@NonNull NavDeepLink paramNavDeepLink)
  {
    if (this.mDeepLinks == null) {
      this.mDeepLinks = new ArrayList();
    }
    this.mDeepLinks.add(paramNavDeepLink);
  }
  
  public final void addDeepLink(@NonNull String paramString)
  {
    addDeepLink(new NavDeepLink.Builder().setUriPattern(paramString).build());
  }
  
  @Nullable
  Bundle addInDefaultArgs(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      localObject1 = this.mArguments;
      if ((localObject1 == null) || (((HashMap)localObject1).isEmpty())) {
        return null;
      }
    }
    Object localObject1 = new Bundle();
    Object localObject2 = this.mArguments;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((NavArgument)((Map.Entry)localObject3).getValue()).putDefaultValue((String)((Map.Entry)localObject3).getKey(), (Bundle)localObject1);
      }
    }
    if (paramBundle != null)
    {
      ((Bundle)localObject1).putAll(paramBundle);
      localObject2 = this.mArguments;
      if (localObject2 != null)
      {
        localObject3 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject3).next();
          if (!((NavArgument)((Map.Entry)localObject2).getValue()).verify((String)((Map.Entry)localObject2).getKey(), paramBundle))
          {
            paramBundle = new StringBuilder();
            paramBundle.append("Wrong argument type for '");
            paramBundle.append((String)((Map.Entry)localObject2).getKey());
            paramBundle.append("' in argument bundle. ");
            paramBundle.append(((NavArgument)((Map.Entry)localObject2).getValue()).getType().getName());
            paramBundle.append(" expected.");
            throw new IllegalArgumentException(paramBundle.toString());
          }
        }
      }
    }
    return (Bundle)localObject1;
  }
  
  @NonNull
  int[] buildDeepLinkIds()
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    Object localObject2;
    for (Object localObject1 = this;; localObject1 = localObject2)
    {
      localObject2 = ((NavDestination)localObject1).getParent();
      if ((localObject2 == null) || (((NavGraph)localObject2).getStartDestination() != ((NavDestination)localObject1).getId())) {
        localArrayDeque.addFirst(localObject1);
      }
      if (localObject2 == null)
      {
        localObject1 = new int[localArrayDeque.size()];
        int i = 0;
        localObject2 = localArrayDeque.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i] = ((NavDestination)((Iterator)localObject2).next()).getId();
          i++;
        }
        return (int[])localObject1;
      }
    }
  }
  
  @Nullable
  public final NavAction getAction(@IdRes int paramInt)
  {
    Object localObject1 = this.mActions;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (NavAction)((SparseArrayCompat)localObject1).get(paramInt);
    }
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (getParent() != null) {
        localObject1 = getParent().getAction(paramInt);
      }
    }
    return (NavAction)localObject1;
  }
  
  @NonNull
  public final Map<String, NavArgument> getArguments()
  {
    Object localObject = this.mArguments;
    if (localObject == null) {
      localObject = Collections.emptyMap();
    } else {
      localObject = Collections.unmodifiableMap((Map)localObject);
    }
    return (Map<String, NavArgument>)localObject;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public String getDisplayName()
  {
    if (this.mIdName == null) {
      this.mIdName = Integer.toString(this.mId);
    }
    return this.mIdName;
  }
  
  @IdRes
  public final int getId()
  {
    return this.mId;
  }
  
  @Nullable
  public final CharSequence getLabel()
  {
    return this.mLabel;
  }
  
  @NonNull
  public final String getNavigatorName()
  {
    return this.mNavigatorName;
  }
  
  @Nullable
  public final NavGraph getParent()
  {
    return this.mParent;
  }
  
  public boolean hasDeepLink(@NonNull Uri paramUri)
  {
    return hasDeepLink(new NavDeepLinkRequest(paramUri, null, null));
  }
  
  public boolean hasDeepLink(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest)
  {
    boolean bool;
    if (matchDeepLink(paramNavDeepLinkRequest) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  DeepLinkMatch matchDeepLink(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest)
  {
    Object localObject1 = this.mDeepLinks;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    label18:
    Object localObject2;
    for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      NavDeepLink localNavDeepLink = (NavDeepLink)localIterator.next();
      localObject2 = paramNavDeepLinkRequest.getUri();
      if (localObject2 != null) {
        localObject2 = localNavDeepLink.getMatchingArguments((Uri)localObject2, getArguments());
      } else {
        localObject2 = null;
      }
      String str = paramNavDeepLinkRequest.getAction();
      boolean bool;
      if ((str != null) && (str.equals(localNavDeepLink.getAction()))) {
        bool = true;
      } else {
        bool = false;
      }
      str = paramNavDeepLinkRequest.getMimeType();
      int i;
      if (str != null) {
        i = localNavDeepLink.getMimeTypeMatchRating(str);
      } else {
        i = -1;
      }
      if ((localObject2 == null) && (!bool) && (i <= -1)) {
        break label18;
      }
      localObject2 = new DeepLinkMatch(this, (Bundle)localObject2, localNavDeepLink.isExactDeepLink(), bool, i);
      if ((localObject1 != null) && (((DeepLinkMatch)localObject2).compareTo((DeepLinkMatch)localObject1) <= 0)) {
        break label18;
      }
    }
    return (DeepLinkMatch)localObject1;
  }
  
  @CallSuper
  public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.Navigator);
    setId(paramAttributeSet.getResourceId(R.styleable.Navigator_android_id, 0));
    this.mIdName = getDisplayName(paramContext, this.mId);
    setLabel(paramAttributeSet.getText(R.styleable.Navigator_android_label));
    paramAttributeSet.recycle();
  }
  
  public final void putAction(@IdRes int paramInt1, @IdRes int paramInt2)
  {
    putAction(paramInt1, new NavAction(paramInt2));
  }
  
  public final void putAction(@IdRes int paramInt, @NonNull NavAction paramNavAction)
  {
    if (supportsActions())
    {
      if (paramInt != 0)
      {
        if (this.mActions == null) {
          this.mActions = new SparseArrayCompat();
        }
        this.mActions.put(paramInt, paramNavAction);
        return;
      }
      throw new IllegalArgumentException("Cannot have an action with actionId 0");
    }
    paramNavAction = new StringBuilder();
    paramNavAction.append("Cannot add action ");
    paramNavAction.append(paramInt);
    paramNavAction.append(" to ");
    paramNavAction.append(this);
    paramNavAction.append(" as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    throw new UnsupportedOperationException(paramNavAction.toString());
  }
  
  public final void removeAction(@IdRes int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = this.mActions;
    if (localSparseArrayCompat == null) {
      return;
    }
    localSparseArrayCompat.remove(paramInt);
  }
  
  public final void removeArgument(@NonNull String paramString)
  {
    HashMap localHashMap = this.mArguments;
    if (localHashMap == null) {
      return;
    }
    localHashMap.remove(paramString);
  }
  
  public final void setId(@IdRes int paramInt)
  {
    this.mId = paramInt;
    this.mIdName = null;
  }
  
  public final void setLabel(@Nullable CharSequence paramCharSequence)
  {
    this.mLabel = paramCharSequence;
  }
  
  final void setParent(NavGraph paramNavGraph)
  {
    this.mParent = paramNavGraph;
  }
  
  boolean supportsActions()
  {
    return true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    String str = this.mIdName;
    if (str == null)
    {
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(this.mId));
    }
    else
    {
      localStringBuilder.append(str);
    }
    localStringBuilder.append(")");
    if (this.mLabel != null)
    {
      localStringBuilder.append(" label=");
      localStringBuilder.append(this.mLabel);
    }
    return localStringBuilder.toString();
  }
  
  @Retention(RetentionPolicy.CLASS)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface ClassType
  {
    Class<?> value();
  }
  
  static class DeepLinkMatch
    implements Comparable<DeepLinkMatch>
  {
    @NonNull
    private final NavDestination mDestination;
    private final boolean mHasMatchingAction;
    private final boolean mIsExactDeepLink;
    @Nullable
    private final Bundle mMatchingArgs;
    private final int mMimeTypeMatchLevel;
    
    DeepLinkMatch(@NonNull NavDestination paramNavDestination, @Nullable Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.mDestination = paramNavDestination;
      this.mMatchingArgs = paramBundle;
      this.mIsExactDeepLink = paramBoolean1;
      this.mHasMatchingAction = paramBoolean2;
      this.mMimeTypeMatchLevel = paramInt;
    }
    
    public int compareTo(@NonNull DeepLinkMatch paramDeepLinkMatch)
    {
      boolean bool = this.mIsExactDeepLink;
      if ((bool) && (!paramDeepLinkMatch.mIsExactDeepLink)) {
        return 1;
      }
      if ((!bool) && (paramDeepLinkMatch.mIsExactDeepLink)) {
        return -1;
      }
      Bundle localBundle = this.mMatchingArgs;
      if ((localBundle != null) && (paramDeepLinkMatch.mMatchingArgs == null)) {
        return 1;
      }
      if ((localBundle == null) && (paramDeepLinkMatch.mMatchingArgs != null)) {
        return -1;
      }
      if (localBundle != null)
      {
        int i = localBundle.size() - paramDeepLinkMatch.mMatchingArgs.size();
        if (i > 0) {
          return 1;
        }
        if (i < 0) {
          return -1;
        }
      }
      bool = this.mHasMatchingAction;
      if ((bool) && (!paramDeepLinkMatch.mHasMatchingAction)) {
        return 1;
      }
      if ((!bool) && (paramDeepLinkMatch.mHasMatchingAction)) {
        return -1;
      }
      return this.mMimeTypeMatchLevel - paramDeepLinkMatch.mMimeTypeMatchLevel;
    }
    
    @NonNull
    NavDestination getDestination()
    {
      return this.mDestination;
    }
    
    @Nullable
    Bundle getMatchingArgs()
    {
      return this.mMatchingArgs;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDestination.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */