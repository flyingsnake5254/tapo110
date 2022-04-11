package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  static final boolean DBG = false;
  private static final int[] DEFAULT_MATCH_ORDER = { 2, 1, 3, 4 };
  private static final String LOG_TAG = "Transition";
  private static final int MATCH_FIRST = 1;
  public static final int MATCH_ID = 3;
  private static final String MATCH_ID_STR = "id";
  public static final int MATCH_INSTANCE = 1;
  private static final String MATCH_INSTANCE_STR = "instance";
  public static final int MATCH_ITEM_ID = 4;
  private static final String MATCH_ITEM_ID_STR = "itemId";
  private static final int MATCH_LAST = 4;
  public static final int MATCH_NAME = 2;
  private static final String MATCH_NAME_STR = "name";
  private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion()
  {
    public Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
  private ArrayList<Animator> mAnimators = new ArrayList();
  boolean mCanRemoveViews = false;
  ArrayList<Animator> mCurrentAnimators = new ArrayList();
  long mDuration = -1L;
  private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mEndValuesList;
  private boolean mEnded = false;
  private EpicenterCallback mEpicenterCallback;
  private TimeInterpolator mInterpolator = null;
  private ArrayList<TransitionListener> mListeners = null;
  private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
  private String mName = getClass().getName();
  private ArrayMap<String, String> mNameOverrides;
  private int mNumInstances = 0;
  TransitionSet mParent = null;
  private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
  private boolean mPaused = false;
  TransitionPropagation mPropagation;
  private ViewGroup mSceneRoot = null;
  private long mStartDelay = -1L;
  private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mStartValuesList;
  private ArrayList<View> mTargetChildExcludes = null;
  private ArrayList<View> mTargetExcludes = null;
  private ArrayList<Integer> mTargetIdChildExcludes = null;
  private ArrayList<Integer> mTargetIdExcludes = null;
  ArrayList<Integer> mTargetIds = new ArrayList();
  private ArrayList<String> mTargetNameExcludes = null;
  private ArrayList<String> mTargetNames = null;
  private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
  private ArrayList<Class<?>> mTargetTypeExcludes = null;
  private ArrayList<Class<?>> mTargetTypes = null;
  ArrayList<View> mTargets = new ArrayList();
  
  public Transition() {}
  
  @SuppressLint({"RestrictedApi"})
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      setDuration(l);
    }
    l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      setStartDelay(l);
    }
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i > 0) {
      setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = TypedArrayUtils.getNamedString(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(parseMatchOrder(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void addUnmatched(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= paramArrayMap1.size()) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.valueAt(j);
      if (isValidTarget(localTransitionValues.view))
      {
        this.mStartValuesList.add(localTransitionValues);
        this.mEndValuesList.add(null);
      }
    }
    while (k < paramArrayMap2.size())
    {
      paramArrayMap1 = (TransitionValues)paramArrayMap2.valueAt(k);
      if (isValidTarget(paramArrayMap1.view))
      {
        this.mEndValuesList.add(paramArrayMap1);
        this.mStartValuesList.add(null);
      }
      k++;
    }
  }
  
  private static void addViewValues(TransitionValuesMaps paramTransitionValuesMaps, View paramView, TransitionValues paramTransitionValues)
  {
    paramTransitionValuesMaps.mViewValues.put(paramView, paramTransitionValues);
    int i = paramView.getId();
    if (i >= 0) {
      if (paramTransitionValuesMaps.mIdValues.indexOfKey(i) >= 0) {
        paramTransitionValuesMaps.mIdValues.put(i, null);
      } else {
        paramTransitionValuesMaps.mIdValues.put(i, paramView);
      }
    }
    paramTransitionValues = ViewCompat.getTransitionName(paramView);
    if (paramTransitionValues != null) {
      if (paramTransitionValuesMaps.mNameValues.containsKey(paramTransitionValues)) {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, null);
      } else {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramTransitionValues = (ListView)paramView.getParent();
      if (paramTransitionValues.getAdapter().hasStableIds())
      {
        long l = paramTransitionValues.getItemIdAtPosition(paramTransitionValues.getPositionForView(paramView));
        if (paramTransitionValuesMaps.mItemIdValues.indexOfKey(l) >= 0)
        {
          paramView = (View)paramTransitionValuesMaps.mItemIdValues.get(l);
          if (paramView != null)
          {
            ViewCompat.setHasTransientState(paramView, false);
            paramTransitionValuesMaps.mItemIdValues.put(l, null);
          }
        }
        else
        {
          ViewCompat.setHasTransientState(paramView, true);
          paramTransitionValuesMaps.mItemIdValues.put(l, paramView);
        }
      }
    }
  }
  
  private static boolean alreadyContains(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[paramInt];
    for (int j = 0; j < paramInt; j++) {
      if (paramArrayOfInt[j] == i) {
        return true;
      }
    }
    return false;
  }
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getId();
    Object localObject = this.mTargetIdExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i)))) {
      return;
    }
    localObject = this.mTargetExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = this.mTargetTypeExcludes;
    int j = 0;
    int m;
    if (localObject != null)
    {
      int k = ((ArrayList)localObject).size();
      for (m = 0; m < k; m++) {
        if (((Class)this.mTargetTypeExcludes.get(m)).isInstance(paramView)) {
          return;
        }
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new TransitionValues(paramView);
      if (paramBoolean) {
        captureStartValues((TransitionValues)localObject);
      } else {
        captureEndValues((TransitionValues)localObject);
      }
      ((TransitionValues)localObject).mTargetedTransitions.add(this);
      capturePropagationValues((TransitionValues)localObject);
      if (paramBoolean) {
        addViewValues(this.mStartValues, paramView, (TransitionValues)localObject);
      } else {
        addViewValues(this.mEndValues, paramView, (TransitionValues)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = this.mTargetIdChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i)))) {
        return;
      }
      localObject = this.mTargetChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = this.mTargetTypeChildExcludes;
      if (localObject != null)
      {
        i = ((ArrayList)localObject).size();
        for (m = 0; m < i; m++) {
          if (((Class)this.mTargetTypeChildExcludes.get(m)).isInstance(paramView)) {
            return;
          }
        }
      }
      paramView = (ViewGroup)paramView;
      for (m = j; m < paramView.getChildCount(); m++) {
        captureHierarchy(paramView.getChildAt(m), paramBoolean);
      }
    }
  }
  
  private ArrayList<Integer> excludeId(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramInt > 0) {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, Integer.valueOf(paramInt));
      } else {
        localObject = ArrayListManager.remove(paramArrayList, Integer.valueOf(paramInt));
      }
    }
    return (ArrayList<Integer>)localObject;
  }
  
  private static <T> ArrayList<T> excludeObject(ArrayList<T> paramArrayList, T paramT, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramT != null) {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, paramT);
      } else {
        localObject = ArrayListManager.remove(paramArrayList, paramT);
      }
    }
    return (ArrayList<T>)localObject;
  }
  
  private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> paramArrayList, Class<?> paramClass, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramClass != null) {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, paramClass);
      } else {
        localObject = ArrayListManager.remove(paramArrayList, paramClass);
      }
    }
    return (ArrayList<Class<?>>)localObject;
  }
  
  private ArrayList<View> excludeView(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramView != null) {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, paramView);
      } else {
        localObject = ArrayListManager.remove(paramArrayList, paramView);
      }
    }
    return (ArrayList<View>)localObject;
  }
  
  private static ArrayMap<Animator, AnimationInfo> getRunningAnimators()
  {
    ArrayMap localArrayMap1 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap2 = localArrayMap1;
    if (localArrayMap1 == null)
    {
      localArrayMap2 = new ArrayMap();
      sRunningAnimators.set(localArrayMap2);
    }
    return localArrayMap2;
  }
  
  private static boolean isValidMatch(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 1) || (paramInt > 4)) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isValueChanged(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, String paramString)
  {
    paramTransitionValues1 = paramTransitionValues1.values.get(paramString);
    paramTransitionValues2 = paramTransitionValues2.values.get(paramString);
    boolean bool1 = true;
    boolean bool2;
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null))
    {
      bool2 = false;
    }
    else
    {
      bool2 = bool1;
      if (paramTransitionValues1 != null) {
        if (paramTransitionValues2 == null) {
          bool2 = bool1;
        } else {
          bool2 = true ^ paramTransitionValues1.equals(paramTransitionValues2);
        }
      }
    }
    return bool2;
  }
  
  private void matchIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int i = paramSparseArray1.size();
    for (int j = 0; j < i; j++)
    {
      View localView1 = (View)paramSparseArray1.valueAt(j);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(j));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }
  
  private void matchInstances(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    for (int i = paramArrayMap1.size() - 1; i >= 0; i--)
    {
      Object localObject = (View)paramArrayMap1.keyAt(i);
      if ((localObject != null) && (isValidTarget((View)localObject)))
      {
        localObject = (TransitionValues)paramArrayMap2.remove(localObject);
        if ((localObject != null) && (isValidTarget(((TransitionValues)localObject).view)))
        {
          TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.removeAt(i);
          this.mStartValuesList.add(localTransitionValues);
          this.mEndValuesList.add(localObject);
        }
      }
    }
  }
  
  private void matchItemIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2)
  {
    int i = paramLongSparseArray1.size();
    for (int j = 0; j < i; j++)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(j);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(j));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }
  
  private void matchNames(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4)
  {
    int i = paramArrayMap3.size();
    for (int j = 0; j < i; j++)
    {
      View localView1 = (View)paramArrayMap3.valueAt(j);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(j));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }
  
  private void matchStartAndEnd(TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(paramTransitionValuesMaps1.mViewValues);
    ArrayMap localArrayMap2 = new ArrayMap(paramTransitionValuesMaps2.mViewValues);
    for (int i = 0;; i++)
    {
      int[] arrayOfInt = this.mMatchOrder;
      if (i >= arrayOfInt.length) {
        break;
      }
      int j = arrayOfInt[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              matchItemIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mItemIdValues, paramTransitionValuesMaps2.mItemIdValues);
            }
          }
          else {
            matchIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mIdValues, paramTransitionValuesMaps2.mIdValues);
          }
        }
        else {
          matchNames(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mNameValues, paramTransitionValuesMaps2.mNameValues);
        }
      }
      else {
        matchInstances(localArrayMap1, localArrayMap2);
      }
    }
    addUnmatched(localArrayMap1, localArrayMap2);
  }
  
  private static int[] parseMatchOrder(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 3;
      }
      else if ("instance".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 1;
      }
      else if ("name".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 2;
      }
      else if ("itemId".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 4;
      }
      else
      {
        if (!((String)localObject).isEmpty()) {
          break label133;
        }
        localObject = new int[paramString.length - 1];
        System.arraycopy(paramString, 0, localObject, 0, i);
        i--;
        paramString = (String)localObject;
      }
      i++;
      continue;
      label133:
      paramString = new StringBuilder();
      paramString.append("Unknown match type in matchOrder: '");
      paramString.append((String)localObject);
      paramString.append("'");
      throw new InflateException(paramString.toString());
    }
    return paramString;
  }
  
  private void runAnimator(Animator paramAnimator, final ArrayMap<Animator, AnimationInfo> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramArrayMap.remove(paramAnonymousAnimator);
          Transition.this.mCurrentAnimators.remove(paramAnonymousAnimator);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Transition.this.mCurrentAnimators.add(paramAnonymousAnimator);
        }
      });
      animate(paramAnimator);
    }
  }
  
  @NonNull
  public Transition addListener(@NonNull TransitionListener paramTransitionListener)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTransitionListener);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull View paramView)
  {
    this.mTargets.add(paramView);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull Class<?> paramClass)
  {
    if (this.mTargetTypes == null) {
      this.mTargetTypes = new ArrayList();
    }
    this.mTargetTypes.add(paramClass);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull String paramString)
  {
    if (this.mTargetNames == null) {
      this.mTargetNames = new ArrayList();
    }
    this.mTargetNames.add(paramString);
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      end();
    }
    else
    {
      if (getDuration() >= 0L) {
        paramAnimator.setDuration(getDuration());
      }
      if (getStartDelay() >= 0L) {
        paramAnimator.setStartDelay(getStartDelay() + paramAnimator.getStartDelay());
      }
      if (getInterpolator() != null) {
        paramAnimator.setInterpolator(getInterpolator());
      }
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          Transition.this.end();
          paramAnonymousAnimator.removeListener(this);
        }
      });
      paramAnimator.start();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void cancel()
  {
    for (int i = this.mCurrentAnimators.size() - 1; i >= 0; i--) {
      ((Animator)this.mCurrentAnimators.get(i)).cancel();
    }
    ArrayList localArrayList = this.mListeners;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      for (i = 0; i < j; i++) {
        ((TransitionListener)localArrayList.get(i)).onTransitionCancel(this);
      }
    }
  }
  
  public abstract void captureEndValues(@NonNull TransitionValues paramTransitionValues);
  
  void capturePropagationValues(TransitionValues paramTransitionValues)
  {
    if ((this.mPropagation != null) && (!paramTransitionValues.values.isEmpty()))
    {
      String[] arrayOfString = this.mPropagation.getPropagationProperties();
      if (arrayOfString == null) {
        return;
      }
      int i = 0;
      for (int j = 0; j < arrayOfString.length; j++) {
        if (!paramTransitionValues.values.containsKey(arrayOfString[j]))
        {
          j = i;
          break label75;
        }
      }
      j = 1;
      label75:
      if (j == 0) {
        this.mPropagation.captureValues(paramTransitionValues);
      }
    }
  }
  
  public abstract void captureStartValues(@NonNull TransitionValues paramTransitionValues);
  
  void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    clearValues(paramBoolean);
    int i = this.mTargetIds.size();
    int j = 0;
    Object localObject1;
    if ((i > 0) || (this.mTargets.size() > 0))
    {
      localObject1 = this.mTargetNames;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = this.mTargetTypes;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label80;
        }
      }
    }
    captureHierarchy(paramViewGroup, paramBoolean);
    break label302;
    label80:
    Object localObject2;
    for (i = 0; i < this.mTargetIds.size(); i++)
    {
      localObject1 = paramViewGroup.findViewById(((Integer)this.mTargetIds.get(i)).intValue());
      if (localObject1 != null)
      {
        localObject2 = new TransitionValues((View)localObject1);
        if (paramBoolean) {
          captureStartValues((TransitionValues)localObject2);
        } else {
          captureEndValues((TransitionValues)localObject2);
        }
        ((TransitionValues)localObject2).mTargetedTransitions.add(this);
        capturePropagationValues((TransitionValues)localObject2);
        if (paramBoolean) {
          addViewValues(this.mStartValues, (View)localObject1, (TransitionValues)localObject2);
        } else {
          addViewValues(this.mEndValues, (View)localObject1, (TransitionValues)localObject2);
        }
      }
    }
    for (i = 0; i < this.mTargets.size(); i++)
    {
      paramViewGroup = (View)this.mTargets.get(i);
      localObject1 = new TransitionValues(paramViewGroup);
      if (paramBoolean) {
        captureStartValues((TransitionValues)localObject1);
      } else {
        captureEndValues((TransitionValues)localObject1);
      }
      ((TransitionValues)localObject1).mTargetedTransitions.add(this);
      capturePropagationValues((TransitionValues)localObject1);
      if (paramBoolean) {
        addViewValues(this.mStartValues, paramViewGroup, (TransitionValues)localObject1);
      } else {
        addViewValues(this.mEndValues, paramViewGroup, (TransitionValues)localObject1);
      }
    }
    label302:
    if (!paramBoolean)
    {
      paramViewGroup = this.mNameOverrides;
      if (paramViewGroup != null)
      {
        int k = paramViewGroup.size();
        paramViewGroup = new ArrayList(k);
        int m;
        for (i = 0;; i++)
        {
          m = j;
          if (i >= k) {
            break;
          }
          localObject1 = (String)this.mNameOverrides.keyAt(i);
          paramViewGroup.add(this.mStartValues.mNameValues.remove(localObject1));
        }
        while (m < k)
        {
          localObject2 = (View)paramViewGroup.get(m);
          if (localObject2 != null)
          {
            localObject1 = (String)this.mNameOverrides.valueAt(m);
            this.mStartValues.mNameValues.put(localObject1, localObject2);
          }
          m++;
        }
      }
    }
  }
  
  void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mStartValues.mViewValues.clear();
      this.mStartValues.mIdValues.clear();
      this.mStartValues.mItemIdValues.clear();
    }
    else
    {
      this.mEndValues.mViewValues.clear();
      this.mEndValues.mIdValues.clear();
      this.mEndValues.mItemIdValues.clear();
    }
  }
  
  public Transition clone()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      Object localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>();
      localTransition.mAnimators = ((ArrayList)localObject);
      localObject = new androidx/transition/TransitionValuesMaps;
      ((TransitionValuesMaps)localObject).<init>();
      localTransition.mStartValues = ((TransitionValuesMaps)localObject);
      localObject = new androidx/transition/TransitionValuesMaps;
      ((TransitionValuesMaps)localObject).<init>();
      localTransition.mEndValues = ((TransitionValuesMaps)localObject);
      localTransition.mStartValuesList = null;
      localTransition.mEndValuesList = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i = paramArrayList1.size();
    long l1 = Long.MAX_VALUE;
    int j = 0;
    int k;
    while (j < i)
    {
      Object localObject1 = (TransitionValues)paramArrayList1.get(j);
      paramTransitionValuesMaps1 = (TransitionValues)paramArrayList2.get(j);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((TransitionValues)localObject1).mTargetedTransitions.contains(this)) {
          localObject2 = null;
        }
      }
      TransitionValuesMaps localTransitionValuesMaps = paramTransitionValuesMaps1;
      if (paramTransitionValuesMaps1 != null)
      {
        localTransitionValuesMaps = paramTransitionValuesMaps1;
        if (!paramTransitionValuesMaps1.mTargetedTransitions.contains(this)) {
          localTransitionValuesMaps = null;
        }
      }
      if ((localObject2 == null) && (localTransitionValuesMaps == null)) {}
      do
      {
        do
        {
          l2 = l1;
          k = j;
          break;
          if ((localObject2 != null) && (localTransitionValuesMaps != null) && (!isTransitionRequired((TransitionValues)localObject2, localTransitionValuesMaps))) {
            k = 0;
          } else {
            k = 1;
          }
        } while (k == 0);
        paramTransitionValuesMaps1 = createAnimator(paramViewGroup, (TransitionValues)localObject2, localTransitionValuesMaps);
      } while (paramTransitionValuesMaps1 == null);
      View localView;
      Object localObject3;
      if (localTransitionValuesMaps != null)
      {
        localView = localTransitionValuesMaps.view;
        String[] arrayOfString = getTransitionProperties();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new TransitionValues(localView);
          localObject1 = (TransitionValues)paramTransitionValuesMaps2.mViewValues.get(localView);
          k = j;
          if (localObject1 != null) {
            for (m = 0;; m++)
            {
              k = j;
              if (m >= arrayOfString.length) {
                break;
              }
              ((TransitionValues)localObject3).values.put(arrayOfString[m], ((TransitionValues)localObject1).values.get(arrayOfString[m]));
            }
          }
          j = k;
          int m = localArrayMap.size();
          for (k = 0; k < m; k++)
          {
            localObject1 = (AnimationInfo)localArrayMap.get((Animator)localArrayMap.keyAt(k));
            if ((((AnimationInfo)localObject1).mValues != null) && (((AnimationInfo)localObject1).mView == localView) && (((AnimationInfo)localObject1).mName.equals(getName())) && (((AnimationInfo)localObject1).mValues.equals(localObject3)))
            {
              paramTransitionValuesMaps1 = null;
              localObject1 = localObject3;
              break label411;
            }
          }
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = null;
        }
      }
      else
      {
        label411:
        localView = ((TransitionValues)localObject2).view;
        localObject1 = null;
      }
      long l2 = l1;
      k = j;
      if (paramTransitionValuesMaps1 != null)
      {
        localObject3 = this.mPropagation;
        l2 = l1;
        if (localObject3 != null)
        {
          l2 = ((TransitionPropagation)localObject3).getStartDelay(paramViewGroup, this, (TransitionValues)localObject2, localTransitionValuesMaps);
          localSparseIntArray.put(this.mAnimators.size(), (int)l2);
          l2 = Math.min(l2, l1);
        }
        localArrayMap.put(paramTransitionValuesMaps1, new AnimationInfo(localView, getName(), this, ViewUtils.getWindowId(paramViewGroup), (TransitionValues)localObject1));
        this.mAnimators.add(paramTransitionValuesMaps1);
        k = j;
      }
      j = k + 1;
      l1 = l2;
    }
    if (localSparseIntArray.size() != 0) {
      for (j = 0; j < localSparseIntArray.size(); j++)
      {
        k = localSparseIntArray.keyAt(j);
        paramViewGroup = (Animator)this.mAnimators.get(k);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(j) - l1 + paramViewGroup.getStartDelay());
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void end()
  {
    int i = this.mNumInstances - 1;
    this.mNumInstances = i;
    if (i == 0)
    {
      Object localObject = this.mListeners;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        for (i = 0; i < j; i++) {
          ((TransitionListener)((ArrayList)localObject).get(i)).onTransitionEnd(this);
        }
      }
      for (i = 0; i < this.mStartValues.mItemIdValues.size(); i++)
      {
        localObject = (View)this.mStartValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
      }
      for (i = 0; i < this.mEndValues.mItemIdValues.size(); i++)
      {
        localObject = (View)this.mEndValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
      }
      this.mEnded = true;
    }
  }
  
  @NonNull
  public Transition excludeChildren(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetExcludes = excludeView(this.mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull String paramString, boolean paramBoolean)
  {
    this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void forceToEnd(ViewGroup paramViewGroup)
  {
    Object localObject = getRunningAnimators();
    int i = ((SimpleArrayMap)localObject).size();
    if ((paramViewGroup != null) && (i != 0))
    {
      WindowIdImpl localWindowIdImpl = ViewUtils.getWindowId(paramViewGroup);
      paramViewGroup = new ArrayMap((SimpleArrayMap)localObject);
      ((SimpleArrayMap)localObject).clear();
      i--;
      while (i >= 0)
      {
        localObject = (AnimationInfo)paramViewGroup.valueAt(i);
        if ((((AnimationInfo)localObject).mView != null) && (localWindowIdImpl != null) && (localWindowIdImpl.equals(((AnimationInfo)localObject).mWindowId))) {
          ((Animator)paramViewGroup.keyAt(i)).end();
        }
        i--;
      }
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  @Nullable
  public Rect getEpicenter()
  {
    EpicenterCallback localEpicenterCallback = this.mEpicenterCallback;
    if (localEpicenterCallback == null) {
      return null;
    }
    return localEpicenterCallback.onGetEpicenter(this);
  }
  
  @Nullable
  public EpicenterCallback getEpicenterCallback()
  {
    return this.mEpicenterCallback;
  }
  
  @Nullable
  public TimeInterpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  TransitionValues getMatchedTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.mParent;
    if (localObject1 != null) {
      return ((Transition)localObject1).getMatchedTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject1 = this.mStartValuesList;
    } else {
      localObject1 = this.mEndValuesList;
    }
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int i = ((ArrayList)localObject1).size();
    int j = -1;
    int m;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= i) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)((ArrayList)localObject1).get(k);
      if (localTransitionValues == null) {
        return null;
      }
      if (localTransitionValues.view == paramView)
      {
        m = k;
        break;
      }
    }
    paramView = (View)localObject2;
    if (m >= 0)
    {
      if (paramBoolean) {
        paramView = this.mEndValuesList;
      } else {
        paramView = this.mStartValuesList;
      }
      paramView = (TransitionValues)paramView.get(m);
    }
    return paramView;
  }
  
  @NonNull
  public String getName()
  {
    return this.mName;
  }
  
  @NonNull
  public PathMotion getPathMotion()
  {
    return this.mPathMotion;
  }
  
  @Nullable
  public TransitionPropagation getPropagation()
  {
    return this.mPropagation;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  @NonNull
  public List<Integer> getTargetIds()
  {
    return this.mTargetIds;
  }
  
  @Nullable
  public List<String> getTargetNames()
  {
    return this.mTargetNames;
  }
  
  @Nullable
  public List<Class<?>> getTargetTypes()
  {
    return this.mTargetTypes;
  }
  
  @NonNull
  public List<View> getTargets()
  {
    return this.mTargets;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  @Nullable
  public TransitionValues getTransitionValues(@NonNull View paramView, boolean paramBoolean)
  {
    Object localObject = this.mParent;
    if (localObject != null) {
      return ((Transition)localObject).getTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = this.mStartValues;
    } else {
      localObject = this.mEndValues;
    }
    return (TransitionValues)((TransitionValuesMaps)localObject).mViewValues.get(paramView);
  }
  
  public boolean isTransitionRequired(@Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramTransitionValues1 != null)
    {
      bool2 = bool1;
      if (paramTransitionValues2 != null)
      {
        Object localObject = getTransitionProperties();
        if (localObject != null)
        {
          int i = localObject.length;
          for (int j = 0;; j++)
          {
            bool2 = bool1;
            if (j >= i) {
              break label117;
            }
            if (isValueChanged(paramTransitionValues1, paramTransitionValues2, localObject[j])) {
              break;
            }
          }
        }
        localObject = paramTransitionValues1.values.keySet().iterator();
        do
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!isValueChanged(paramTransitionValues1, paramTransitionValues2, (String)((Iterator)localObject).next()));
        bool2 = true;
      }
    }
    label117:
    return bool2;
  }
  
  boolean isValidTarget(View paramView)
  {
    int i = paramView.getId();
    ArrayList localArrayList = this.mTargetIdExcludes;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(i)))) {
      return false;
    }
    localArrayList = this.mTargetExcludes;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = this.mTargetTypeExcludes;
    int k;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      for (k = 0; k < j; k++) {
        if (((Class)this.mTargetTypeExcludes.get(k)).isInstance(paramView)) {
          return false;
        }
      }
    }
    if ((this.mTargetNameExcludes != null) && (ViewCompat.getTransitionName(paramView) != null) && (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(paramView)))) {
      return false;
    }
    if ((this.mTargetIds.size() == 0) && (this.mTargets.size() == 0))
    {
      localArrayList = this.mTargetTypes;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = this.mTargetNames;
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          return true;
        }
      }
    }
    if ((!this.mTargetIds.contains(Integer.valueOf(i))) && (!this.mTargets.contains(paramView)))
    {
      localArrayList = this.mTargetNames;
      if ((localArrayList != null) && (localArrayList.contains(ViewCompat.getTransitionName(paramView)))) {
        return true;
      }
      if (this.mTargetTypes != null) {
        for (k = 0; k < this.mTargetTypes.size(); k++) {
          if (((Class)this.mTargetTypes.get(k)).isInstance(paramView)) {
            return true;
          }
        }
      }
      return false;
    }
    return true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void pause(View paramView)
  {
    if (!this.mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = ViewUtils.getWindowId(paramView);
      i--;
      while (i >= 0)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
        if ((localAnimationInfo.mView != null) && (paramView.equals(localAnimationInfo.mWindowId))) {
          AnimatorUtils.pause((Animator)localArrayMap.keyAt(i));
        }
        i--;
      }
      paramView = this.mListeners;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        int j = paramView.size();
        for (i = 0; i < j; i++) {
          ((TransitionListener)paramView.get(i)).onTransitionPause(this);
        }
      }
      this.mPaused = true;
    }
  }
  
  void playTransition(ViewGroup paramViewGroup)
  {
    this.mStartValuesList = new ArrayList();
    this.mEndValuesList = new ArrayList();
    matchStartAndEnd(this.mStartValues, this.mEndValues);
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    WindowIdImpl localWindowIdImpl = ViewUtils.getWindowId(paramViewGroup);
    i--;
    while (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      if (localAnimator != null)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.get(localAnimator);
        if ((localAnimationInfo != null) && (localAnimationInfo.mView != null) && (localWindowIdImpl.equals(localAnimationInfo.mWindowId)))
        {
          TransitionValues localTransitionValues1 = localAnimationInfo.mValues;
          View localView = localAnimationInfo.mView;
          TransitionValues localTransitionValues2 = getTransitionValues(localView, true);
          TransitionValues localTransitionValues3 = getMatchedTransitionValues(localView, true);
          TransitionValues localTransitionValues4 = localTransitionValues3;
          if (localTransitionValues2 == null)
          {
            localTransitionValues4 = localTransitionValues3;
            if (localTransitionValues3 == null) {
              localTransitionValues4 = (TransitionValues)this.mEndValues.mViewValues.get(localView);
            }
          }
          int j;
          if (((localTransitionValues2 != null) || (localTransitionValues4 != null)) && (localAnimationInfo.mTransition.isTransitionRequired(localTransitionValues1, localTransitionValues4))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              localArrayMap.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i--;
    }
    createAnimators(paramViewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
    runAnimators();
  }
  
  @NonNull
  public Transition removeListener(@NonNull TransitionListener paramTransitionListener)
  {
    ArrayList localArrayList = this.mListeners;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramTransitionListener);
    if (this.mListeners.size() == 0) {
      this.mListeners = null;
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull View paramView)
  {
    this.mTargets.remove(paramView);
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull Class<?> paramClass)
  {
    ArrayList localArrayList = this.mTargetTypes;
    if (localArrayList != null) {
      localArrayList.remove(paramClass);
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull String paramString)
  {
    ArrayList localArrayList = this.mTargetNames;
    if (localArrayList != null) {
      localArrayList.remove(paramString);
    }
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void resume(View paramView)
  {
    if (this.mPaused)
    {
      if (!this.mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        WindowIdImpl localWindowIdImpl = ViewUtils.getWindowId(paramView);
        i--;
        while (i >= 0)
        {
          paramView = (AnimationInfo)localArrayMap.valueAt(i);
          if ((paramView.mView != null) && (localWindowIdImpl.equals(paramView.mWindowId))) {
            AnimatorUtils.resume((Animator)localArrayMap.keyAt(i));
          }
          i--;
        }
        paramView = this.mListeners;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          int j = paramView.size();
          for (i = 0; i < j; i++) {
            ((TransitionListener)paramView.get(i)).onTransitionResume(this);
          }
        }
      }
      this.mPaused = false;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    this.mAnimators.clear();
    end();
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    this.mCanRemoveViews = paramBoolean;
  }
  
  @NonNull
  public Transition setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(@Nullable EpicenterCallback paramEpicenterCallback)
  {
    this.mEpicenterCallback = paramEpicenterCallback;
  }
  
  @NonNull
  public Transition setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    this.mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length) {
        if (isValidMatch(paramVarArgs[i]))
        {
          if (!alreadyContains(paramVarArgs, i)) {
            i++;
          } else {
            throw new IllegalArgumentException("matches contains a duplicate value");
          }
        }
        else {
          throw new IllegalArgumentException("matches contains invalid value");
        }
      }
      this.mMatchOrder = ((int[])paramVarArgs.clone());
    }
    else
    {
      this.mMatchOrder = DEFAULT_MATCH_ORDER;
    }
  }
  
  public void setPathMotion(@Nullable PathMotion paramPathMotion)
  {
    if (paramPathMotion == null) {
      this.mPathMotion = STRAIGHT_PATH_MOTION;
    } else {
      this.mPathMotion = paramPathMotion;
    }
  }
  
  public void setPropagation(@Nullable TransitionPropagation paramTransitionPropagation)
  {
    this.mPropagation = paramTransitionPropagation;
  }
  
  Transition setSceneRoot(ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
    return this;
  }
  
  @NonNull
  public Transition setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void start()
  {
    if (this.mNumInstances == 0)
    {
      ArrayList localArrayList = this.mListeners;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)this.mListeners.clone();
        int i = localArrayList.size();
        for (int j = 0; j < i; j++) {
          ((TransitionListener)localArrayList.get(j)).onTransitionStart(this);
        }
      }
      this.mEnded = false;
    }
    this.mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(getClass().getSimpleName());
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject1).append(": ");
    paramString = ((StringBuilder)localObject1).toString();
    localObject1 = paramString;
    if (this.mDuration != -1L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("dur(");
      ((StringBuilder)localObject1).append(this.mDuration);
      ((StringBuilder)localObject1).append(") ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (this.mStartDelay != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("dly(");
      paramString.append(this.mStartDelay);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject1 = paramString;
    if (this.mInterpolator != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("interp(");
      ((StringBuilder)localObject1).append(this.mInterpolator);
      ((StringBuilder)localObject1).append(") ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (this.mTargetIds.size() <= 0)
    {
      paramString = (String)localObject1;
      if (this.mTargets.size() <= 0) {}
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("tgts(");
      paramString = paramString.toString();
      int i = this.mTargetIds.size();
      int j = 0;
      localObject1 = paramString;
      if (i > 0) {
        for (i = 0;; i++)
        {
          localObject1 = paramString;
          if (i >= this.mTargetIds.size()) {
            break;
          }
          localObject1 = paramString;
          if (i > 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(", ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append(this.mTargetIds.get(i));
          paramString = paramString.toString();
        }
      }
      Object localObject2 = localObject1;
      if (this.mTargets.size() > 0)
      {
        paramString = (String)localObject1;
        for (i = j;; i++)
        {
          localObject2 = paramString;
          if (i >= this.mTargets.size()) {
            break;
          }
          localObject1 = paramString;
          if (i > 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(", ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append(this.mTargets.get(i));
          paramString = paramString.toString();
        }
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append(")");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static class AnimationInfo
  {
    String mName;
    Transition mTransition;
    TransitionValues mValues;
    View mView;
    WindowIdImpl mWindowId;
    
    AnimationInfo(View paramView, String paramString, Transition paramTransition, WindowIdImpl paramWindowIdImpl, TransitionValues paramTransitionValues)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.mValues = paramTransitionValues;
      this.mWindowId = paramWindowIdImpl;
      this.mTransition = paramTransition;
    }
  }
  
  private static class ArrayListManager
  {
    static <T> ArrayList<T> add(ArrayList<T> paramArrayList, T paramT)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList();
      }
      if (!((ArrayList)localObject).contains(paramT)) {
        ((ArrayList)localObject).add(paramT);
      }
      return (ArrayList<T>)localObject;
    }
    
    static <T> ArrayList<T> remove(ArrayList<T> paramArrayList, T paramT)
    {
      ArrayList<T> localArrayList = paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList.remove(paramT);
        localArrayList = paramArrayList;
        if (paramArrayList.isEmpty()) {
          localArrayList = null;
        }
      }
      return localArrayList;
    }
  }
  
  public static abstract class EpicenterCallback
  {
    public abstract Rect onGetEpicenter(@NonNull Transition paramTransition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface MatchOrder {}
  
  public static abstract interface TransitionListener
  {
    public abstract void onTransitionCancel(@NonNull Transition paramTransition);
    
    public abstract void onTransitionEnd(@NonNull Transition paramTransition);
    
    public abstract void onTransitionPause(@NonNull Transition paramTransition);
    
    public abstract void onTransitionResume(@NonNull Transition paramTransition);
    
    public abstract void onTransitionStart(@NonNull Transition paramTransition);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */