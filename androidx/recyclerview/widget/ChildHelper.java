package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper
{
  private static final boolean DEBUG = false;
  private static final String TAG = "ChildrenHelper";
  final Bucket mBucket;
  final Callback mCallback;
  final List<View> mHiddenViews;
  
  ChildHelper(Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mBucket = new Bucket();
    this.mHiddenViews = new ArrayList();
  }
  
  private int getOffset(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int i = this.mCallback.getChildCount();
    int j = paramInt;
    while (j < i)
    {
      int k = paramInt - (j - this.mBucket.countOnesBefore(j));
      if (k == 0)
      {
        while (this.mBucket.get(j)) {
          j++;
        }
        return j;
      }
      j += k;
    }
    return -1;
  }
  
  private void hideViewInternal(View paramView)
  {
    this.mHiddenViews.add(paramView);
    this.mCallback.onEnteredHiddenState(paramView);
  }
  
  private boolean unhideViewInternal(View paramView)
  {
    if (this.mHiddenViews.remove(paramView))
    {
      this.mCallback.onLeftHiddenState(paramView);
      return true;
    }
    return false;
  }
  
  void addView(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    this.mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean) {
      hideViewInternal(paramView);
    }
    this.mCallback.addView(paramView, paramInt);
  }
  
  void addView(View paramView, boolean paramBoolean)
  {
    addView(paramView, -1, paramBoolean);
  }
  
  void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    this.mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean) {
      hideViewInternal(paramView);
    }
    this.mCallback.attachViewToParent(paramView, paramInt, paramLayoutParams);
  }
  
  void detachViewFromParent(int paramInt)
  {
    paramInt = getOffset(paramInt);
    this.mBucket.remove(paramInt);
    this.mCallback.detachViewFromParent(paramInt);
  }
  
  View findHiddenNonRemovedView(int paramInt)
  {
    int i = this.mHiddenViews.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)this.mHiddenViews.get(j);
      RecyclerView.ViewHolder localViewHolder = this.mCallback.getChildViewHolder(localView);
      if ((localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && (!localViewHolder.isRemoved())) {
        return localView;
      }
    }
    return null;
  }
  
  View getChildAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    return this.mCallback.getChildAt(paramInt);
  }
  
  int getChildCount()
  {
    return this.mCallback.getChildCount() - this.mHiddenViews.size();
  }
  
  View getUnfilteredChildAt(int paramInt)
  {
    return this.mCallback.getChildAt(paramInt);
  }
  
  int getUnfilteredChildCount()
  {
    return this.mCallback.getChildCount();
  }
  
  void hide(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      this.mBucket.set(i);
      hideViewInternal(paramView);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  int indexOfChild(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i == -1) {
      return -1;
    }
    if (this.mBucket.get(i)) {
      return -1;
    }
    return i - this.mBucket.countOnesBefore(i);
  }
  
  boolean isHidden(View paramView)
  {
    return this.mHiddenViews.contains(paramView);
  }
  
  void removeAllViewsUnfiltered()
  {
    this.mBucket.reset();
    for (int i = this.mHiddenViews.size() - 1; i >= 0; i--)
    {
      this.mCallback.onLeftHiddenState((View)this.mHiddenViews.get(i));
      this.mHiddenViews.remove(i);
    }
    this.mCallback.removeAllViews();
  }
  
  void removeView(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (this.mBucket.remove(i)) {
      unhideViewInternal(paramView);
    }
    this.mCallback.removeViewAt(i);
  }
  
  void removeViewAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    View localView = this.mCallback.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.mBucket.remove(paramInt)) {
      unhideViewInternal(localView);
    }
    this.mCallback.removeViewAt(paramInt);
  }
  
  boolean removeViewIfHidden(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i == -1)
    {
      unhideViewInternal(paramView);
      return true;
    }
    if (this.mBucket.get(i))
    {
      this.mBucket.remove(i);
      unhideViewInternal(paramView);
      this.mCallback.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mBucket.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(this.mHiddenViews.size());
    return localStringBuilder.toString();
  }
  
  void unhide(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      if (this.mBucket.get(i))
      {
        this.mBucket.clear(i);
        unhideViewInternal(paramView);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("trying to unhide a view that was not hidden");
      localStringBuilder.append(paramView);
      throw new RuntimeException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static class Bucket
  {
    static final int BITS_PER_WORD = 64;
    static final long LAST_BIT = Long.MIN_VALUE;
    long mData = 0L;
    Bucket mNext;
    
    private void ensureNext()
    {
      if (this.mNext == null) {
        this.mNext = new Bucket();
      }
    }
    
    void clear(int paramInt)
    {
      if (paramInt >= 64)
      {
        Bucket localBucket = this.mNext;
        if (localBucket != null) {
          localBucket.clear(paramInt - 64);
        }
      }
      else
      {
        this.mData &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
      }
    }
    
    int countOnesBefore(int paramInt)
    {
      Bucket localBucket = this.mNext;
      if (localBucket == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.mData);
        }
        return Long.bitCount(this.mData & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.mData & (1L << paramInt) - 1L);
      }
      return localBucket.countOnesBefore(paramInt - 64) + Long.bitCount(this.mData);
    }
    
    boolean get(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        return this.mNext.get(paramInt - 64);
      }
      boolean bool;
      if ((this.mData & 1L << paramInt) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void insert(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        this.mNext.insert(paramInt - 64, paramBoolean);
      }
      else
      {
        long l1 = this.mData;
        boolean bool;
        if ((0x8000000000000000 & l1) != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        long l2 = (1L << paramInt) - 1L;
        this.mData = ((l1 & (l2 ^ 0xFFFFFFFFFFFFFFFF)) << 1 | l1 & l2);
        if (paramBoolean) {
          set(paramInt);
        } else {
          clear(paramInt);
        }
        if ((bool) || (this.mNext != null))
        {
          ensureNext();
          this.mNext.insert(0, bool);
        }
      }
    }
    
    boolean remove(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        return this.mNext.remove(paramInt - 64);
      }
      long l1 = 1L << paramInt;
      long l2 = this.mData;
      boolean bool;
      if ((l2 & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      l2 &= (l1 ^ 0xFFFFFFFFFFFFFFFF);
      this.mData = l2;
      l1 -= 1L;
      this.mData = (l2 & l1 | Long.rotateRight((l1 ^ 0xFFFFFFFFFFFFFFFF) & l2, 1));
      Bucket localBucket = this.mNext;
      if (localBucket != null)
      {
        if (localBucket.get(0)) {
          set(63);
        }
        this.mNext.remove(0);
      }
      return bool;
    }
    
    void reset()
    {
      this.mData = 0L;
      Bucket localBucket = this.mNext;
      if (localBucket != null) {
        localBucket.reset();
      }
    }
    
    void set(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        this.mNext.set(paramInt - 64);
      }
      else
      {
        this.mData |= 1L << paramInt;
      }
    }
    
    public String toString()
    {
      Object localObject;
      if (this.mNext == null)
      {
        localObject = Long.toBinaryString(this.mData);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mNext.toString());
        ((StringBuilder)localObject).append("xx");
        ((StringBuilder)localObject).append(Long.toBinaryString(this.mData));
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
  }
  
  static abstract interface Callback
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract RecyclerView.ViewHolder getChildViewHolder(View paramView);
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void onEnteredHiddenState(View paramView);
    
    public abstract void onLeftHiddenState(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ChildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */