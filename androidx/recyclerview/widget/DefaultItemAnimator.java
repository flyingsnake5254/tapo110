package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator
  extends SimpleItemAnimator
{
  private static final boolean DEBUG = false;
  private static TimeInterpolator sDefaultInterpolator;
  ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
  ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
  ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
  ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
  private ArrayList<ChangeInfo> mPendingChanges = new ArrayList();
  private ArrayList<MoveInfo> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();
  
  private void animateRemoveImpl(final RecyclerView.ViewHolder paramViewHolder)
  {
    final View localView = paramViewHolder.itemView;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mRemoveAnimations.add(paramViewHolder);
    localViewPropertyAnimator.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        localView.setAlpha(1.0F);
        DefaultItemAnimator.this.dispatchRemoveFinished(paramViewHolder);
        DefaultItemAnimator.this.mRemoveAnimations.remove(paramViewHolder);
        DefaultItemAnimator.this.dispatchFinishedWhenDone();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        DefaultItemAnimator.this.dispatchRemoveStarting(paramViewHolder);
      }
    }).start();
  }
  
  private void endChangeAnimation(List<ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = paramList.size() - 1; i >= 0; i--)
    {
      ChangeInfo localChangeInfo = (ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramViewHolder)) && (localChangeInfo.oldHolder == null) && (localChangeInfo.newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
    }
  }
  
  private void endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.oldHolder;
    if (localViewHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, localViewHolder);
    }
    localViewHolder = paramChangeInfo.newHolder;
    if (localViewHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, localViewHolder);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.newHolder;
    boolean bool = false;
    if (localViewHolder == paramViewHolder)
    {
      paramChangeInfo.newHolder = null;
    }
    else
    {
      if (paramChangeInfo.oldHolder != paramViewHolder) {
        break label70;
      }
      paramChangeInfo.oldHolder = null;
      bool = true;
    }
    paramViewHolder.itemView.setAlpha(1.0F);
    paramViewHolder.itemView.setTranslationX(0.0F);
    paramViewHolder.itemView.setTranslationY(0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
    label70:
    return false;
  }
  
  private void resetAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    if (sDefaultInterpolator == null) {
      sDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramViewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
    endAnimation(paramViewHolder);
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    paramViewHolder.itemView.setAlpha(0.0F);
    this.mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  void animateAddImpl(final RecyclerView.ViewHolder paramViewHolder)
  {
    final View localView = paramViewHolder.itemView;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mAddAnimations.add(paramViewHolder);
    localViewPropertyAnimator.alpha(1.0F).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        localView.setAlpha(1.0F);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        DefaultItemAnimator.this.dispatchAddFinished(paramViewHolder);
        DefaultItemAnimator.this.mAddAnimations.remove(paramViewHolder);
        DefaultItemAnimator.this.dispatchFinishedWhenDone();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        DefaultItemAnimator.this.dispatchAddStarting(paramViewHolder);
      }
    }).start();
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = paramViewHolder1.itemView.getTranslationX();
    float f2 = paramViewHolder1.itemView.getTranslationY();
    float f3 = paramViewHolder1.itemView.getAlpha();
    resetAnimation(paramViewHolder1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramViewHolder1.itemView.setTranslationX(f1);
    paramViewHolder1.itemView.setTranslationY(f2);
    paramViewHolder1.itemView.setAlpha(f3);
    if (paramViewHolder2 != null)
    {
      resetAnimation(paramViewHolder2);
      paramViewHolder2.itemView.setTranslationX(-i);
      paramViewHolder2.itemView.setTranslationY(-j);
      paramViewHolder2.itemView.setAlpha(0.0F);
    }
    this.mPendingChanges.add(new ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  void animateChangeImpl(final ChangeInfo paramChangeInfo)
  {
    final Object localObject1 = paramChangeInfo.oldHolder;
    final View localView = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((RecyclerView.ViewHolder)localObject1).itemView;
    }
    final Object localObject2 = paramChangeInfo.newHolder;
    if (localObject2 != null) {
      localView = ((RecyclerView.ViewHolder)localObject2).itemView;
    }
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate().setDuration(getChangeDuration());
      this.mChangeAnimations.add(paramChangeInfo.oldHolder);
      ((ViewPropertyAnimator)localObject2).translationX(paramChangeInfo.toX - paramChangeInfo.fromX);
      ((ViewPropertyAnimator)localObject2).translationY(paramChangeInfo.toY - paramChangeInfo.fromY);
      ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localObject2.setListener(null);
          localObject1.setAlpha(1.0F);
          localObject1.setTranslationX(0.0F);
          localObject1.setTranslationY(0.0F);
          DefaultItemAnimator.this.dispatchChangeFinished(paramChangeInfo.oldHolder, true);
          DefaultItemAnimator.this.mChangeAnimations.remove(paramChangeInfo.oldHolder);
          DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          DefaultItemAnimator.this.dispatchChangeStarting(paramChangeInfo.oldHolder, true);
        }
      }).start();
    }
    if (localView != null)
    {
      localObject1 = localView.animate();
      this.mChangeAnimations.add(paramChangeInfo.newHolder);
      ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          localObject1.setListener(null);
          localView.setAlpha(1.0F);
          localView.setTranslationX(0.0F);
          localView.setTranslationY(0.0F);
          DefaultItemAnimator.this.dispatchChangeFinished(paramChangeInfo.newHolder, false);
          DefaultItemAnimator.this.mChangeAnimations.remove(paramChangeInfo.newHolder);
          DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          DefaultItemAnimator.this.dispatchChangeStarting(paramChangeInfo.newHolder, false);
        }
      }).start();
    }
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 += (int)localView.getTranslationX();
    int i = paramInt2 + (int)paramViewHolder.itemView.getTranslationY();
    resetAnimation(paramViewHolder);
    int j = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - i;
    if ((j == 0) && (paramInt2 == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (j != 0) {
      localView.setTranslationX(-j);
    }
    if (paramInt2 != 0) {
      localView.setTranslationY(-paramInt2);
    }
    this.mPendingMoves.add(new MoveInfo(paramViewHolder, paramInt1, i, paramInt3, paramInt4));
    return true;
  }
  
  void animateMoveImpl(final RecyclerView.ViewHolder paramViewHolder, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
  {
    final View localView = paramViewHolder.itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      localView.animate().translationX(0.0F);
    }
    if (paramInt2 != 0) {
      localView.animate().translationY(0.0F);
    }
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mMoveAnimations.add(paramViewHolder);
    localViewPropertyAnimator.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        if (paramInt1 != 0) {
          localView.setTranslationX(0.0F);
        }
        if (paramInt2 != 0) {
          localView.setTranslationY(0.0F);
        }
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localViewPropertyAnimator.setListener(null);
        DefaultItemAnimator.this.dispatchMoveFinished(paramViewHolder);
        DefaultItemAnimator.this.mMoveAnimations.remove(paramViewHolder);
        DefaultItemAnimator.this.dispatchFinishedWhenDone();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        DefaultItemAnimator.this.dispatchMoveStarting(paramViewHolder);
      }
    }).start();
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    this.mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    boolean bool;
    if ((paramList.isEmpty()) && (!super.canReuseUpdatedViewHolder(paramViewHolder, paramList))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  void cancelAll(List<RecyclerView.ViewHolder> paramList)
  {
    for (int i = paramList.size() - 1; i >= 0; i--) {
      ((RecyclerView.ViewHolder)paramList.get(i)).itemView.animate().cancel();
    }
  }
  
  void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    localView.animate().cancel();
    for (int i = this.mPendingMoves.size() - 1; i >= 0; i--) {
      if (((MoveInfo)this.mPendingMoves.get(i)).holder == paramViewHolder)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.mPendingMoves.remove(i);
      }
    }
    endChangeAnimation(this.mPendingChanges, paramViewHolder);
    if (this.mPendingRemovals.remove(paramViewHolder))
    {
      localView.setAlpha(1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.mPendingAdditions.remove(paramViewHolder))
    {
      localView.setAlpha(1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    ArrayList localArrayList;
    for (i = this.mChangesList.size() - 1; i >= 0; i--)
    {
      localArrayList = (ArrayList)this.mChangesList.get(i);
      endChangeAnimation(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        this.mChangesList.remove(i);
      }
    }
    for (i = this.mMovesList.size() - 1; i >= 0; i--)
    {
      localArrayList = (ArrayList)this.mMovesList.get(i);
      for (int j = localArrayList.size() - 1; j >= 0; j--) {
        if (((MoveInfo)localArrayList.get(j)).holder == paramViewHolder)
        {
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList.remove(j);
          if (!localArrayList.isEmpty()) {
            break;
          }
          this.mMovesList.remove(i);
          break;
        }
      }
    }
    for (i = this.mAdditionsList.size() - 1; i >= 0; i--)
    {
      localArrayList = (ArrayList)this.mAdditionsList.get(i);
      if (localArrayList.remove(paramViewHolder))
      {
        localView.setAlpha(1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          this.mAdditionsList.remove(i);
        }
      }
    }
    this.mRemoveAnimations.remove(paramViewHolder);
    this.mAddAnimations.remove(paramViewHolder);
    this.mChangeAnimations.remove(paramViewHolder);
    this.mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public void endAnimations()
  {
    Object localObject1;
    Object localObject2;
    for (int i = this.mPendingMoves.size() - 1; i >= 0; i--)
    {
      localObject1 = (MoveInfo)this.mPendingMoves.get(i);
      localObject2 = ((MoveInfo)localObject1).holder.itemView;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      dispatchMoveFinished(((MoveInfo)localObject1).holder);
      this.mPendingMoves.remove(i);
    }
    for (i = this.mPendingRemovals.size() - 1; i >= 0; i--)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.mPendingRemovals.get(i));
      this.mPendingRemovals.remove(i);
    }
    for (i = this.mPendingAdditions.size() - 1; i >= 0; i--)
    {
      localObject1 = (RecyclerView.ViewHolder)this.mPendingAdditions.get(i);
      ((RecyclerView.ViewHolder)localObject1).itemView.setAlpha(1.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject1);
      this.mPendingAdditions.remove(i);
    }
    for (i = this.mPendingChanges.size() - 1; i >= 0; i--) {
      endChangeAnimationIfNecessary((ChangeInfo)this.mPendingChanges.get(i));
    }
    this.mPendingChanges.clear();
    if (!isRunning()) {
      return;
    }
    int j;
    for (i = this.mMovesList.size() - 1; i >= 0; i--)
    {
      ArrayList localArrayList = (ArrayList)this.mMovesList.get(i);
      for (j = localArrayList.size() - 1; j >= 0; j--)
      {
        localObject1 = (MoveInfo)localArrayList.get(j);
        localObject2 = ((MoveInfo)localObject1).holder.itemView;
        ((View)localObject2).setTranslationY(0.0F);
        ((View)localObject2).setTranslationX(0.0F);
        dispatchMoveFinished(((MoveInfo)localObject1).holder);
        localArrayList.remove(j);
        if (localArrayList.isEmpty()) {
          this.mMovesList.remove(localArrayList);
        }
      }
    }
    for (i = this.mAdditionsList.size() - 1; i >= 0; i--)
    {
      localObject1 = (ArrayList)this.mAdditionsList.get(i);
      for (j = ((ArrayList)localObject1).size() - 1; j >= 0; j--)
      {
        localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(j);
        ((RecyclerView.ViewHolder)localObject2).itemView.setAlpha(1.0F);
        dispatchAddFinished((RecyclerView.ViewHolder)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.mAdditionsList.remove(localObject1);
        }
      }
    }
    for (i = this.mChangesList.size() - 1; i >= 0; i--)
    {
      localObject1 = (ArrayList)this.mChangesList.get(i);
      for (j = ((ArrayList)localObject1).size() - 1; j >= 0; j--)
      {
        endChangeAnimationIfNecessary((ChangeInfo)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.mChangesList.remove(localObject1);
        }
      }
    }
    cancelAll(this.mRemoveAnimations);
    cancelAll(this.mMoveAnimations);
    cancelAll(this.mAddAnimations);
    cancelAll(this.mChangeAnimations);
    dispatchAnimationsFinished();
  }
  
  public boolean isRunning()
  {
    boolean bool;
    if ((this.mPendingAdditions.isEmpty()) && (this.mPendingChanges.isEmpty()) && (this.mPendingMoves.isEmpty()) && (this.mPendingRemovals.isEmpty()) && (this.mMoveAnimations.isEmpty()) && (this.mRemoveAnimations.isEmpty()) && (this.mAddAnimations.isEmpty()) && (this.mChangeAnimations.isEmpty()) && (this.mMovesList.isEmpty()) && (this.mAdditionsList.isEmpty()) && (this.mChangesList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.mPendingRemovals.isEmpty() ^ true;
    boolean bool2 = this.mPendingMoves.isEmpty() ^ true;
    boolean bool3 = this.mPendingChanges.isEmpty() ^ true;
    boolean bool4 = this.mPendingAdditions.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool3)) {
      return;
    }
    final Object localObject1 = this.mPendingRemovals.iterator();
    while (((Iterator)localObject1).hasNext()) {
      animateRemoveImpl((RecyclerView.ViewHolder)((Iterator)localObject1).next());
    }
    this.mPendingRemovals.clear();
    final Object localObject2;
    if (bool2)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll(this.mPendingMoves);
      this.mMovesList.add(localObject2);
      this.mPendingMoves.clear();
      localObject1 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject2.iterator();
          while (localIterator.hasNext())
          {
            DefaultItemAnimator.MoveInfo localMoveInfo = (DefaultItemAnimator.MoveInfo)localIterator.next();
            DefaultItemAnimator.this.animateMoveImpl(localMoveInfo.holder, localMoveInfo.fromX, localMoveInfo.fromY, localMoveInfo.toX, localMoveInfo.toY);
          }
          localObject2.clear();
          DefaultItemAnimator.this.mMovesList.remove(localObject2);
        }
      };
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((MoveInfo)((ArrayList)localObject2).get(0)).holder.itemView, (Runnable)localObject1, getRemoveDuration());
      } else {
        ((Runnable)localObject1).run();
      }
    }
    if (bool3)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.mPendingChanges);
      this.mChangesList.add(localObject1);
      this.mPendingChanges.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)localIterator.next();
            DefaultItemAnimator.this.animateChangeImpl(localChangeInfo);
          }
          localObject1.clear();
          DefaultItemAnimator.this.mChangesList.remove(localObject1);
        }
      };
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((ChangeInfo)((ArrayList)localObject1).get(0)).oldHolder.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool4)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll(this.mPendingAdditions);
      this.mAdditionsList.add(localObject2);
      this.mPendingAdditions.clear();
      localObject1 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject2.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
            DefaultItemAnimator.this.animateAddImpl(localViewHolder);
          }
          localObject2.clear();
          DefaultItemAnimator.this.mAdditionsList.remove(localObject2);
        }
      };
      if ((!bool1) && (!bool2) && (!bool3))
      {
        ((Runnable)localObject1).run();
      }
      else
      {
        long l1 = 0L;
        long l2;
        if (bool1) {
          l2 = getRemoveDuration();
        } else {
          l2 = 0L;
        }
        if (bool2) {
          l3 = getMoveDuration();
        } else {
          l3 = 0L;
        }
        if (bool3) {
          l1 = getChangeDuration();
        }
        long l3 = Math.max(l3, l1);
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)((ArrayList)localObject2).get(0)).itemView, (Runnable)localObject1, l2 + l3);
      }
    }
  }
  
  private static class ChangeInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder newHolder;
    public RecyclerView.ViewHolder oldHolder;
    public int toX;
    public int toY;
    
    private ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      this.oldHolder = paramViewHolder1;
      this.newHolder = paramViewHolder2;
    }
    
    ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramViewHolder1, paramViewHolder2);
      this.fromX = paramInt1;
      this.fromY = paramInt2;
      this.toX = paramInt3;
      this.toY = paramInt4;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChangeInfo{oldHolder=");
      localStringBuilder.append(this.oldHolder);
      localStringBuilder.append(", newHolder=");
      localStringBuilder.append(this.newHolder);
      localStringBuilder.append(", fromX=");
      localStringBuilder.append(this.fromX);
      localStringBuilder.append(", fromY=");
      localStringBuilder.append(this.fromY);
      localStringBuilder.append(", toX=");
      localStringBuilder.append(this.toX);
      localStringBuilder.append(", toY=");
      localStringBuilder.append(this.toY);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static class MoveInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder holder;
    public int toX;
    public int toY;
    
    MoveInfo(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.holder = paramViewHolder;
      this.fromX = paramInt1;
      this.fromY = paramInt2;
      this.toX = paramInt3;
      this.toY = paramInt4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\DefaultItemAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */