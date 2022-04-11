package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  private static final int FLAG_CHANGE_EPICENTER = 8;
  private static final int FLAG_CHANGE_INTERPOLATOR = 1;
  private static final int FLAG_CHANGE_PATH_MOTION = 4;
  private static final int FLAG_CHANGE_PROPAGATION = 2;
  public static final int ORDERING_SEQUENTIAL = 1;
  public static final int ORDERING_TOGETHER = 0;
  private int mChangeFlags = 0;
  int mCurrentListeners;
  private boolean mPlayTogether = true;
  boolean mStarted = false;
  private ArrayList<Transition> mTransitions = new ArrayList();
  
  public TransitionSet() {}
  
  @SuppressLint({"RestrictedApi"})
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_SET);
    setOrdering(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  private void addTransitionInternal(@NonNull Transition paramTransition)
  {
    this.mTransitions.add(paramTransition);
    paramTransition.mParent = this;
  }
  
  private void setupStartEndListeners()
  {
    TransitionSetListener localTransitionSetListener = new TransitionSetListener(this);
    Iterator localIterator = this.mTransitions.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).addListener(localTransitionSetListener);
    }
    this.mCurrentListeners = this.mTransitions.size();
  }
  
  @NonNull
  public TransitionSet addListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    return (TransitionSet)super.addListener(paramTransitionListener);
  }
  
  @NonNull
  public TransitionSet addTarget(@IdRes int paramInt)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).addTarget(paramInt);
    }
    return (TransitionSet)super.addTarget(paramInt);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull View paramView)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).addTarget(paramView);
    }
    return (TransitionSet)super.addTarget(paramView);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull Class<?> paramClass)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).addTarget(paramClass);
    }
    return (TransitionSet)super.addTarget(paramClass);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull String paramString)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).addTarget(paramString);
    }
    return (TransitionSet)super.addTarget(paramString);
  }
  
  @NonNull
  public TransitionSet addTransition(@NonNull Transition paramTransition)
  {
    addTransitionInternal(paramTransition);
    long l = this.mDuration;
    if (l >= 0L) {
      paramTransition.setDuration(l);
    }
    if ((this.mChangeFlags & 0x1) != 0) {
      paramTransition.setInterpolator(getInterpolator());
    }
    if ((this.mChangeFlags & 0x2) != 0) {
      paramTransition.setPropagation(getPropagation());
    }
    if ((this.mChangeFlags & 0x4) != 0) {
      paramTransition.setPathMotion(getPathMotion());
    }
    if ((this.mChangeFlags & 0x8) != 0) {
      paramTransition.setEpicenterCallback(getEpicenterCallback());
    }
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void cancel()
  {
    super.cancel();
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).cancel();
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    if (isValidTarget(paramTransitionValues.view))
    {
      Iterator localIterator = this.mTransitions.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramTransitionValues.view))
        {
          localTransition.captureEndValues(paramTransitionValues);
          paramTransitionValues.mTargetedTransitions.add(localTransition);
        }
      }
    }
  }
  
  void capturePropagationValues(TransitionValues paramTransitionValues)
  {
    super.capturePropagationValues(paramTransitionValues);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).capturePropagationValues(paramTransitionValues);
    }
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    if (isValidTarget(paramTransitionValues.view))
    {
      Iterator localIterator = this.mTransitions.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramTransitionValues.view))
        {
          localTransition.captureStartValues(paramTransitionValues);
          paramTransitionValues.mTargetedTransitions.add(localTransition);
        }
      }
    }
  }
  
  public Transition clone()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.clone();
    localTransitionSet.mTransitions = new ArrayList();
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      localTransitionSet.addTransitionInternal(((Transition)this.mTransitions.get(j)).clone());
    }
    return localTransitionSet;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2)
  {
    long l1 = getStartDelay();
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++)
    {
      Transition localTransition = (Transition)this.mTransitions.get(j);
      if ((l1 > 0L) && ((this.mPlayTogether) || (j == 0)))
      {
        long l2 = localTransition.getStartDelay();
        if (l2 > 0L) {
          localTransition.setStartDelay(l2 + l1);
        } else {
          localTransition.setStartDelay(l1);
        }
      }
      localTransition.createAnimators(paramViewGroup, paramTransitionValuesMaps1, paramTransitionValuesMaps2, paramArrayList1, paramArrayList2);
    }
  }
  
  @NonNull
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramInt, paramBoolean);
    }
    return super.excludeTarget(paramInt, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramView, paramBoolean);
    }
    return super.excludeTarget(paramView, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramClass, paramBoolean);
    }
    return super.excludeTarget(paramClass, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull String paramString, boolean paramBoolean)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramString, paramBoolean);
    }
    return super.excludeTarget(paramString, paramBoolean);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void forceToEnd(ViewGroup paramViewGroup)
  {
    super.forceToEnd(paramViewGroup);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).forceToEnd(paramViewGroup);
    }
  }
  
  public int getOrdering()
  {
    return this.mPlayTogether ^ true;
  }
  
  @Nullable
  public Transition getTransitionAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mTransitions.size())) {
      return (Transition)this.mTransitions.get(paramInt);
    }
    return null;
  }
  
  public int getTransitionCount()
  {
    return this.mTransitions.size();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void pause(View paramView)
  {
    super.pause(paramView);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).pause(paramView);
    }
  }
  
  @NonNull
  public TransitionSet removeListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    return (TransitionSet)super.removeListener(paramTransitionListener);
  }
  
  @NonNull
  public TransitionSet removeTarget(@IdRes int paramInt)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramInt);
    }
    return (TransitionSet)super.removeTarget(paramInt);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull View paramView)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramView);
    }
    return (TransitionSet)super.removeTarget(paramView);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull Class<?> paramClass)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramClass);
    }
    return (TransitionSet)super.removeTarget(paramClass);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull String paramString)
  {
    for (int i = 0; i < this.mTransitions.size(); i++) {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramString);
    }
    return (TransitionSet)super.removeTarget(paramString);
  }
  
  @NonNull
  public TransitionSet removeTransition(@NonNull Transition paramTransition)
  {
    this.mTransitions.remove(paramTransition);
    paramTransition.mParent = null;
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void resume(View paramView)
  {
    super.resume(paramView);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).resume(paramView);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void runAnimators()
  {
    if (this.mTransitions.isEmpty())
    {
      start();
      end();
      return;
    }
    setupStartEndListeners();
    Object localObject;
    if (!this.mPlayTogether)
    {
      for (int i = 1; i < this.mTransitions.size(); i++) {
        ((Transition)this.mTransitions.get(i - 1)).addListener(new TransitionListenerAdapter()
        {
          public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
          {
            this.val$nextTransition.runAnimators();
            paramAnonymousTransition.removeListener(this);
          }
        });
      }
      localObject = (Transition)this.mTransitions.get(0);
      if (localObject != null) {
        ((Transition)localObject).runAnimators();
      }
    }
    else
    {
      localObject = this.mTransitions.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).runAnimators();
      }
    }
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    super.setCanRemoveViews(paramBoolean);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).setCanRemoveViews(paramBoolean);
    }
  }
  
  @NonNull
  public TransitionSet setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    if (this.mDuration >= 0L)
    {
      ArrayList localArrayList = this.mTransitions;
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        for (int j = 0; j < i; j++) {
          ((Transition)this.mTransitions.get(j)).setDuration(paramLong);
        }
      }
    }
    return this;
  }
  
  public void setEpicenterCallback(Transition.EpicenterCallback paramEpicenterCallback)
  {
    super.setEpicenterCallback(paramEpicenterCallback);
    this.mChangeFlags |= 0x8;
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).setEpicenterCallback(paramEpicenterCallback);
    }
  }
  
  @NonNull
  public TransitionSet setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    this.mChangeFlags |= 0x1;
    ArrayList localArrayList = this.mTransitions;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      for (int j = 0; j < i; j++) {
        ((Transition)this.mTransitions.get(j)).setInterpolator(paramTimeInterpolator);
      }
    }
    return (TransitionSet)super.setInterpolator(paramTimeInterpolator);
  }
  
  @NonNull
  public TransitionSet setOrdering(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.mPlayTogether = false;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid parameter for TransitionSet ordering: ");
        localStringBuilder.append(paramInt);
        throw new AndroidRuntimeException(localStringBuilder.toString());
      }
    }
    else {
      this.mPlayTogether = true;
    }
    return this;
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    super.setPathMotion(paramPathMotion);
    this.mChangeFlags |= 0x4;
    if (this.mTransitions != null) {
      for (int i = 0; i < this.mTransitions.size(); i++) {
        ((Transition)this.mTransitions.get(i)).setPathMotion(paramPathMotion);
      }
    }
  }
  
  public void setPropagation(TransitionPropagation paramTransitionPropagation)
  {
    super.setPropagation(paramTransitionPropagation);
    this.mChangeFlags |= 0x2;
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).setPropagation(paramTransitionPropagation);
    }
  }
  
  TransitionSet setSceneRoot(ViewGroup paramViewGroup)
  {
    super.setSceneRoot(paramViewGroup);
    int i = this.mTransitions.size();
    for (int j = 0; j < i; j++) {
      ((Transition)this.mTransitions.get(j)).setSceneRoot(paramViewGroup);
    }
    return this;
  }
  
  @NonNull
  public TransitionSet setStartDelay(long paramLong)
  {
    return (TransitionSet)super.setStartDelay(paramLong);
  }
  
  String toString(String paramString)
  {
    Object localObject = super.toString(paramString);
    for (int i = 0; i < this.mTransitions.size(); i++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      Transition localTransition = (Transition)this.mTransitions.get(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("  ");
      localStringBuilder.append(localTransition.toString(((StringBuilder)localObject).toString()));
      localObject = localStringBuilder.toString();
    }
    return (String)localObject;
  }
  
  static class TransitionSetListener
    extends TransitionListenerAdapter
  {
    TransitionSet mTransitionSet;
    
    TransitionSetListener(TransitionSet paramTransitionSet)
    {
      this.mTransitionSet = paramTransitionSet;
    }
    
    public void onTransitionEnd(@NonNull Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.mTransitionSet;
      int i = localTransitionSet.mCurrentListeners - 1;
      localTransitionSet.mCurrentListeners = i;
      if (i == 0)
      {
        localTransitionSet.mStarted = false;
        localTransitionSet.end();
      }
      paramTransition.removeListener(this);
    }
    
    public void onTransitionStart(@NonNull Transition paramTransition)
    {
      paramTransition = this.mTransitionSet;
      if (!paramTransition.mStarted)
      {
        paramTransition.start();
        this.mTransitionSet.mStarted = true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */