package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R.attr;
import androidx.recyclerview.R.dimen;
import androidx.recyclerview.R.styleable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  static final boolean ALLOW_THREAD_GAP_WORK;
  static final boolean DEBUG = false;
  static final int DEFAULT_ORIENTATION = 1;
  static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
  static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  static final long FOREVER_NS = Long.MAX_VALUE;
  public static final int HORIZONTAL = 0;
  private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  static final int MAX_SCROLL_DURATION = 2000;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  static final boolean POST_UPDATES_ON_ANIMATION;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  static final String TRACE_PREFETCH_TAG = "RV Prefetch";
  static final String TRACE_SCROLL_TAG = "RV Scroll";
  public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
  static final boolean VERBOSE_TRACING = false;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  private EdgeEffect mBottomGlow;
  private ChildDrawingOrderCallback mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  boolean mDispatchItemsChangedEvent = false;
  private int mDispatchScrollCounter = 0;
  private int mEatenAccessibilityChangeFlags;
  @NonNull
  private EdgeEffectFactory mEdgeEffectFactory = new EdgeEffectFactory();
  boolean mEnableFastScroller;
  @VisibleForTesting
  boolean mFirstLayoutComplete;
  GapWorker mGapWorker;
  boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mInterceptRequestLayoutDepth = 0;
  private OnItemTouchListener mInterceptingOnItemTouchListener;
  boolean mIsAttached;
  ItemAnimator mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastAutoMeasureNonExactMeasuredHeight;
  private int mLastAutoMeasureNonExactMeasuredWidth;
  private boolean mLastAutoMeasureSkippedDueToExact;
  private int mLastTouchX;
  private int mLastTouchY;
  @VisibleForTesting
  LayoutManager mLayout;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutSuppressed;
  boolean mLayoutWasDefered;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerViewDataObserver mObserver = new RecyclerViewDataObserver();
  private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  private OnFlingListener mOnFlingListener;
  private final ArrayList<OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  @VisibleForTesting
  final List<ViewHolder> mPendingAccessibilityImportanceChange;
  SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
  private boolean mPreserveFocusAfterLayout;
  final Recycler mRecycler = new Recycler();
  RecyclerListener mRecyclerListener;
  final List<RecyclerListener> mRecyclerListeners = new ArrayList();
  final int[] mReusableIntPair;
  private EdgeEffect mRightGlow;
  private float mScaledHorizontalScrollFactor = Float.MIN_VALUE;
  private float mScaledVerticalScrollFactor = Float.MIN_VALUE;
  private OnScrollListener mScrollListener;
  private List<OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final State mState;
  final Rect mTempRect = new Rect();
  private final Rect mTempRect2 = new Rect();
  final RectF mTempRectF = new RectF();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new Runnable()
  {
    public void run()
    {
      RecyclerView localRecyclerView = RecyclerView.this;
      if ((localRecyclerView.mFirstLayoutComplete) && (!localRecyclerView.isLayoutRequested()))
      {
        localRecyclerView = RecyclerView.this;
        if (!localRecyclerView.mIsAttached)
        {
          localRecyclerView.requestLayout();
          return;
        }
        if (localRecyclerView.mLayoutSuppressed)
        {
          localRecyclerView.mLayoutWasDefered = true;
          return;
        }
        localRecyclerView.consumePendingUpdateOperations();
      }
    }
  };
  private VelocityTracker mVelocityTracker;
  final ViewFlinger mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool;
    if ((i != 18) && (i != 19) && (i != 20)) {
      bool = false;
    } else {
      bool = true;
    }
    FORCE_INVALIDATE_DISPLAY_LIST = bool;
    if (i >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
    if (i >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    POST_UPDATES_ON_ANIMATION = bool;
    if (i >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_THREAD_GAP_WORK = bool;
    if (i <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool;
    if (i <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    IGNORE_DETACHED_FOCUSED_CHILD = bool;
    Class localClass = Integer.TYPE;
    LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, localClass, localClass };
  }
  
  public RecyclerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.recyclerViewStyle);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool1 = true;
    this.mPreserveFocusAfterLayout = true;
    this.mViewFlinger = new ViewFlinger();
    if (ALLOW_THREAD_GAP_WORK) {
      localObject1 = new GapWorker.LayoutPrefetchRegistryImpl();
    } else {
      localObject1 = null;
    }
    this.mPrefetchRegistry = ((GapWorker.LayoutPrefetchRegistryImpl)localObject1);
    this.mState = new State();
    this.mItemsAddedOrRemoved = false;
    this.mItemsChanged = false;
    this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
    this.mPostedAnimatorRunner = false;
    this.mMinMaxLayoutPositions = new int[2];
    this.mScrollOffset = new int[2];
    this.mNestedOffsets = new int[2];
    this.mReusableIntPair = new int[2];
    this.mPendingAccessibilityImportanceChange = new ArrayList();
    this.mItemAnimatorRunner = new Runnable()
    {
      public void run()
      {
        RecyclerView.ItemAnimator localItemAnimator = RecyclerView.this.mItemAnimator;
        if (localItemAnimator != null) {
          localItemAnimator.runPendingAnimations();
        }
        RecyclerView.this.mPostedAnimatorRunner = false;
      }
    };
    this.mLastAutoMeasureNonExactMeasuredWidth = 0;
    this.mLastAutoMeasureNonExactMeasuredHeight = 0;
    this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback()
    {
      public void processAppeared(RecyclerView.ViewHolder paramAnonymousViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        RecyclerView.this.animateAppearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
      }
      
      public void processDisappeared(RecyclerView.ViewHolder paramAnonymousViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        RecyclerView.this.mRecycler.unscrapView(paramAnonymousViewHolder);
        RecyclerView.this.animateDisappearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
      }
      
      public void processPersistent(RecyclerView.ViewHolder paramAnonymousViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        paramAnonymousViewHolder.setIsRecyclable(false);
        RecyclerView localRecyclerView = RecyclerView.this;
        if (localRecyclerView.mDataSetHasChangedAfterLayout)
        {
          if (localRecyclerView.mItemAnimator.animateChange(paramAnonymousViewHolder, paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2)) {
            RecyclerView.this.postAnimationRunner();
          }
        }
        else if (localRecyclerView.mItemAnimator.animatePersistence(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2)) {
          RecyclerView.this.postAnimationRunner();
        }
      }
      
      public void unused(RecyclerView.ViewHolder paramAnonymousViewHolder)
      {
        RecyclerView localRecyclerView = RecyclerView.this;
        localRecyclerView.mLayout.removeAndRecycleView(paramAnonymousViewHolder.itemView, localRecyclerView.mRecycler);
      }
    };
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject1 = ViewConfiguration.get(paramContext);
    this.mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
    this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)localObject1, paramContext);
    this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)localObject1, paramContext);
    this.mMinFlingVelocity = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    this.mItemAnimator.setListener(this.mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    initAutofill();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    Object localObject2 = R.styleable.RecyclerView;
    localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    ViewCompat.saveAttributeDataForStyleable(this, paramContext, (int[])localObject2, paramAttributeSet, (TypedArray)localObject1, paramInt, 0);
    localObject2 = ((TypedArray)localObject1).getString(R.styleable.RecyclerView_layoutManager);
    if (((TypedArray)localObject1).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
      setDescendantFocusability(262144);
    }
    this.mClipToPadding = ((TypedArray)localObject1).getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
    boolean bool2 = ((TypedArray)localObject1).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
    this.mEnableFastScroller = bool2;
    if (bool2) {
      initFastScroller((StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), ((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), ((TypedArray)localObject1).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    }
    ((TypedArray)localObject1).recycle();
    createLayoutManager(paramContext, (String)localObject2, paramAttributeSet, paramInt, 0);
    bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = NESTED_SCROLLING_ATTRS;
      localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, paramInt, 0);
      ViewCompat.saveAttributeDataForStyleable(this, paramContext, (int[])localObject1, paramAttributeSet, (TypedArray)localObject2, paramInt, 0);
      bool2 = ((TypedArray)localObject2).getBoolean(0, true);
      ((TypedArray)localObject2).recycle();
    }
    setNestedScrollingEnabled(bool2);
  }
  
  private void addAnimatingView(ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    int i;
    if (localView.getParent() == this) {
      i = 1;
    } else {
      i = 0;
    }
    this.mRecycler.unscrapView(getChildViewHolder(localView));
    if (paramViewHolder.isTmpDetached()) {
      this.mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
    } else if (i == 0) {
      this.mChildHelper.addView(localView, true);
    } else {
      this.mChildHelper.hide(localView);
    }
  }
  
  private void animateChange(@NonNull ViewHolder paramViewHolder1, @NonNull ViewHolder paramViewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1) {
      addAnimatingView(paramViewHolder1);
    }
    if (paramViewHolder1 != paramViewHolder2)
    {
      if (paramBoolean2) {
        addAnimatingView(paramViewHolder2);
      }
      paramViewHolder1.mShadowedHolder = paramViewHolder2;
      addAnimatingView(paramViewHolder1);
      this.mRecycler.unscrapView(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    }
    if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  private void cancelScroll()
  {
    resetScroll();
    setScrollState(0);
  }
  
  static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder paramViewHolder)
  {
    Object localObject = paramViewHolder.mNestedRecyclerView;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      while (localObject != null)
      {
        if (localObject == paramViewHolder.itemView) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramViewHolder.mNestedRecyclerView = null;
    }
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          if (isInEditMode()) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = Class.forName(str, false, paramString).asSubclass(LayoutManager.class);
          paramString = null;
          try
          {
            Constructor localConstructor = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
            paramString = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
            paramContext = localConstructor;
          }
          catch (NoSuchMethodException localNoSuchMethodException) {}
          try
          {
            paramContext = localClass.getConstructor(new Class[0]);
            paramContext.setAccessible(true);
            setLayoutManager((LayoutManager)paramContext.newInstance(paramString));
          }
          catch (NoSuchMethodException paramContext)
          {
            paramContext.initCause(localNoSuchMethodException);
            IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
            paramString = new java/lang/StringBuilder;
            paramString.<init>();
            paramString.append(paramAttributeSet.getPositionDescription());
            paramString.append(": Error creating LayoutManager ");
            paramString.append(str);
            localIllegalStateException.<init>(paramString.toString(), paramContext);
            throw localIllegalStateException;
          }
          return;
        }
        catch (ClassCastException paramString)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramAttributeSet.getPositionDescription());
          paramContext.append(": Class is not a LayoutManager ");
          paramContext.append(str);
          throw new IllegalStateException(paramContext.toString(), paramString);
        }
        catch (IllegalAccessException paramString)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramAttributeSet.getPositionDescription());
          paramContext.append(": Cannot access non-public constructor ");
          paramContext.append(str);
          throw new IllegalStateException(paramContext.toString(), paramString);
        }
        catch (InstantiationException paramString)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramAttributeSet.getPositionDescription());
          paramContext.append(": Could not instantiate the LayoutManager: ");
          paramContext.append(str);
          throw new IllegalStateException(paramContext.toString(), paramString);
        }
        catch (InvocationTargetException paramString)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramAttributeSet.getPositionDescription());
          paramContext.append(": Could not instantiate the LayoutManager: ");
          paramContext.append(str);
          throw new IllegalStateException(paramContext.toString(), paramString);
        }
        catch (ClassNotFoundException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Unable to find LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
      }
    }
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int[] arrayOfInt = this.mMinMaxLayoutPositions;
    boolean bool = false;
    if ((arrayOfInt[0] != paramInt1) || (arrayOfInt[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  private void dispatchContentChangedIfNecessary()
  {
    int i = this.mEatenAccessibilityChangeFlags;
    this.mEatenAccessibilityChangeFlags = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void dispatchLayoutStep1()
  {
    Object localObject1 = this.mState;
    boolean bool = true;
    ((State)localObject1).assertLayoutStep(1);
    fillRemainingScrollValues(this.mState);
    this.mState.mIsMeasuring = false;
    startInterceptRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    localObject1 = this.mState;
    if ((!((State)localObject1).mRunSimpleAnimations) || (!this.mItemsChanged)) {
      bool = false;
    }
    ((State)localObject1).mTrackOldChangeHolders = bool;
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    ((State)localObject1).mInPreLayout = ((State)localObject1).mRunPredictiveAnimations;
    ((State)localObject1).mItemCount = this.mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int i;
    int j;
    Object localObject2;
    if (this.mState.mRunSimpleAnimations)
    {
      i = this.mChildHelper.getChildCount();
      for (j = 0; j < i; j++)
      {
        localObject2 = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
        if ((!((ViewHolder)localObject2).shouldIgnore()) && ((!((ViewHolder)localObject2).isInvalid()) || (this.mAdapter.hasStableIds())))
        {
          localObject1 = this.mItemAnimator.recordPreLayoutInformation(this.mState, (ViewHolder)localObject2, ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)localObject2), ((ViewHolder)localObject2).getUnmodifiedPayloads());
          this.mViewInfoStore.addToPreLayout((ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
          if ((this.mState.mTrackOldChangeHolders) && (((ViewHolder)localObject2).isUpdated()) && (!((ViewHolder)localObject2).isRemoved()) && (!((ViewHolder)localObject2).shouldIgnore()) && (!((ViewHolder)localObject2).isInvalid()))
          {
            long l = getChangedHolderKey((ViewHolder)localObject2);
            this.mViewInfoStore.addToOldChangeHolders(l, (ViewHolder)localObject2);
          }
        }
      }
    }
    if (this.mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      localObject1 = this.mState;
      bool = ((State)localObject1).mStructureChanged;
      ((State)localObject1).mStructureChanged = false;
      this.mLayout.onLayoutChildren(this.mRecycler, (State)localObject1);
      this.mState.mStructureChanged = bool;
      for (j = 0; j < this.mChildHelper.getChildCount(); j++)
      {
        localObject1 = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
        if ((!((ViewHolder)localObject1).shouldIgnore()) && (!this.mViewInfoStore.isInPreLayout((ViewHolder)localObject1)))
        {
          int k = ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)localObject1);
          bool = ((ViewHolder)localObject1).hasAnyOfTheFlags(8192);
          i = k;
          if (!bool) {
            i = k | 0x1000;
          }
          localObject2 = this.mItemAnimator.recordPreLayoutInformation(this.mState, (ViewHolder)localObject1, i, ((ViewHolder)localObject1).getUnmodifiedPayloads());
          if (bool) {
            recordAnimationInfoIfBouncedHiddenView((ViewHolder)localObject1, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject2);
          } else {
            this.mViewInfoStore.addToAppearedInPreLayoutHolders((ViewHolder)localObject1, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject2);
          }
        }
      }
      clearOldPositions();
    }
    else
    {
      clearOldPositions();
    }
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mState.mLayoutStep = 2;
  }
  
  private void dispatchLayoutStep2()
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    if ((this.mPendingSavedState != null) && (this.mAdapter.canRestoreState()))
    {
      localObject = this.mPendingSavedState.mLayoutState;
      if (localObject != null) {
        this.mLayout.onRestoreInstanceState((Parcelable)localObject);
      }
      this.mPendingSavedState = null;
    }
    Object localObject = this.mState;
    ((State)localObject).mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, (State)localObject);
    localObject = this.mState;
    ((State)localObject).mStructureChanged = false;
    boolean bool;
    if ((((State)localObject).mRunSimpleAnimations) && (this.mItemAnimator != null)) {
      bool = true;
    } else {
      bool = false;
    }
    ((State)localObject).mRunSimpleAnimations = bool;
    ((State)localObject).mLayoutStep = 4;
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    Object localObject = this.mState;
    ((State)localObject).mLayoutStep = 1;
    if (((State)localObject).mRunSimpleAnimations)
    {
      for (int i = this.mChildHelper.getChildCount() - 1; i >= 0; i--)
      {
        ViewHolder localViewHolder1 = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (!localViewHolder1.shouldIgnore())
        {
          long l = getChangedHolderKey(localViewHolder1);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo = this.mItemAnimator.recordPostLayoutInformation(this.mState, localViewHolder1);
          ViewHolder localViewHolder2 = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder2 != null) && (!localViewHolder2.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder2);
            boolean bool2 = this.mViewInfoStore.isDisappearing(localViewHolder1);
            if ((bool1) && (localViewHolder2 == localViewHolder1))
            {
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo);
            }
            else
            {
              localObject = this.mViewInfoStore.popFromPreLayout(localViewHolder2);
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo);
              localItemHolderInfo = this.mViewInfoStore.popFromPostLayout(localViewHolder1);
              if (localObject == null) {
                handleMissingPreInfoForChangeError(l, localViewHolder1, localViewHolder2);
              } else {
                animateChange(localViewHolder2, localViewHolder1, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject, localItemHolderInfo, bool1, bool2);
              }
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo);
          }
        }
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    localObject = this.mState;
    ((State)localObject).mPreviousLayoutItemCount = ((State)localObject).mItemCount;
    this.mDataSetHasChangedAfterLayout = false;
    this.mDispatchItemsChangedEvent = false;
    ((State)localObject).mRunSimpleAnimations = false;
    ((State)localObject).mRunPredictiveAnimations = false;
    this.mLayout.mRequestedSimpleAnimations = false;
    localObject = this.mRecycler.mChangedScrap;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.mLayout;
    if (((LayoutManager)localObject).mPrefetchMaxObservedInInitialPrefetch)
    {
      ((LayoutManager)localObject).mPrefetchMaxCountObserved = 0;
      ((LayoutManager)localObject).mPrefetchMaxObservedInInitialPrefetch = false;
      this.mRecycler.updateViewCacheSize();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mViewInfoStore.clear();
    localObject = this.mMinMaxLayoutPositions;
    if (didChildRangeChange(localObject[0], localObject[1])) {
      dispatchOnScrolled(0, 0);
    }
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchToOnItemTouchListeners(MotionEvent paramMotionEvent)
  {
    OnItemTouchListener localOnItemTouchListener = this.mInterceptingOnItemTouchListener;
    if (localOnItemTouchListener == null)
    {
      if (paramMotionEvent.getAction() == 0) {
        return false;
      }
      return findInterceptingOnItemTouchListener(paramMotionEvent);
    }
    localOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.mInterceptingOnItemTouchListener = null;
    }
    return true;
  }
  
  private boolean findInterceptingOnItemTouchListener(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = this.mOnItemTouchListeners.size();
    for (int k = 0; k < j; k++)
    {
      OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)this.mOnItemTouchListeners.get(k);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (i != 3))
      {
        this.mInterceptingOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
    }
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i = this.mChildHelper.getChildCount();
    if (i == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int j = Integer.MAX_VALUE;
    int k = Integer.MIN_VALUE;
    int m = 0;
    while (m < i)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(m));
      int n;
      if (localViewHolder.shouldIgnore())
      {
        n = k;
      }
      else
      {
        int i1 = localViewHolder.getLayoutPosition();
        int i2 = j;
        if (i1 < j) {
          i2 = i1;
        }
        j = i2;
        n = k;
        if (i1 > k)
        {
          n = i1;
          j = i2;
        }
      }
      m++;
      k = n;
    }
    paramArrayOfInt[0] = j;
    paramArrayOfInt[1] = k;
  }
  
  @Nullable
  static RecyclerView findNestedRecyclerView(@NonNull View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView localRecyclerView = findNestedRecyclerView(paramView.getChildAt(j));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
    }
    return null;
  }
  
  @Nullable
  private View findNextViewToFocus()
  {
    Object localObject = this.mState;
    int i = ((State)localObject).mFocusedItemPosition;
    if (i == -1) {
      i = 0;
    }
    int j = ((State)localObject).getItemCount();
    for (int k = i; k < j; k++)
    {
      localObject = findViewHolderForAdapterPosition(k);
      if (localObject == null) {
        break;
      }
      if (((ViewHolder)localObject).itemView.hasFocusable()) {
        return ((ViewHolder)localObject).itemView;
      }
    }
    for (i = Math.min(j, i) - 1; i >= 0; i--)
    {
      localObject = findViewHolderForAdapterPosition(i);
      if (localObject == null) {
        return null;
      }
      if (((ViewHolder)localObject).itemView.hasFocusable()) {
        return ((ViewHolder)localObject).itemView;
      }
    }
    return null;
  }
  
  static ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  static void getDecoratedBoundsWithMarginsInt(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramRect.set(paramView.getLeft() - localRect.left - localLayoutParams.leftMargin, paramView.getTop() - localRect.top - localLayoutParams.topMargin, paramView.getRight() + localRect.right + localLayoutParams.rightMargin, paramView.getBottom() + localRect.bottom + localLayoutParams.bottomMargin);
  }
  
  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    while ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      View localView = ((ViewGroup)paramView).getFocusedChild();
      paramView = localView;
      if (localView.getId() != -1)
      {
        i = localView.getId();
        paramView = localView;
      }
    }
    return i;
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString.contains(".")) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append(RecyclerView.class.getPackage().getName());
    paramContext.append('.');
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
    {
      localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
      if ((localObject != paramViewHolder1) && (getChangedHolderKey((ViewHolder)localObject) == paramLong))
      {
        paramViewHolder2 = this.mAdapter;
        if ((paramViewHolder2 != null) && (paramViewHolder2.hasStableIds()))
        {
          paramViewHolder2 = new StringBuilder();
          paramViewHolder2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramViewHolder2.append(localObject);
          paramViewHolder2.append(" \n View Holder 2:");
          paramViewHolder2.append(paramViewHolder1);
          paramViewHolder2.append(exceptionLabel());
          throw new IllegalStateException(paramViewHolder2.toString());
        }
        paramViewHolder2 = new StringBuilder();
        paramViewHolder2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramViewHolder2.append(localObject);
        paramViewHolder2.append(" \n View Holder 2:");
        paramViewHolder2.append(paramViewHolder1);
        paramViewHolder2.append(exceptionLabel());
        throw new IllegalStateException(paramViewHolder2.toString());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramViewHolder2);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramViewHolder1);
    ((StringBuilder)localObject).append(exceptionLabel());
    Log.e("RecyclerView", ((StringBuilder)localObject).toString());
  }
  
  private boolean hasUpdatedView()
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.isUpdated())) {
        return true;
      }
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  private void initAutofill()
  {
    if (ViewCompat.getImportantForAutofill(this) == 0) {
      ViewCompat.setImportantForAutofill(this, 8);
    }
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new ChildHelper.Callback()
    {
      public void addView(View paramAnonymousView, int paramAnonymousInt)
      {
        RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
        RecyclerView.this.dispatchChildAttached(paramAnonymousView);
      }
      
      public void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localViewHolder != null)
        {
          if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
          {
            paramAnonymousView = new StringBuilder();
            paramAnonymousView.append("Called attach on a child which is not detached: ");
            paramAnonymousView.append(localViewHolder);
            paramAnonymousView.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(paramAnonymousView.toString());
          }
          localViewHolder.clearTmpDetachFlag();
        }
        RecyclerView.this.attachViewToParent(paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }
      
      public void detachViewFromParent(int paramAnonymousInt)
      {
        Object localObject = getChildAt(paramAnonymousInt);
        if (localObject != null)
        {
          RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
          if (localViewHolder != null)
          {
            if ((localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("called detach on an already detached child ");
              ((StringBuilder)localObject).append(localViewHolder);
              ((StringBuilder)localObject).append(RecyclerView.this.exceptionLabel());
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
            localViewHolder.addFlags(256);
          }
        }
        RecyclerView.this.detachViewFromParent(paramAnonymousInt);
      }
      
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.this.getChildCount();
      }
      
      public RecyclerView.ViewHolder getChildViewHolder(View paramAnonymousView)
      {
        return RecyclerView.getChildViewHolderInt(paramAnonymousView);
      }
      
      public int indexOfChild(View paramAnonymousView)
      {
        return RecyclerView.this.indexOfChild(paramAnonymousView);
      }
      
      public void onEnteredHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          paramAnonymousView.onEnteredHiddenState(RecyclerView.this);
        }
      }
      
      public void onLeftHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          paramAnonymousView.onLeftHiddenState(RecyclerView.this);
        }
      }
      
      public void removeAllViews()
      {
        int i = getChildCount();
        for (int j = 0; j < i; j++)
        {
          View localView = getChildAt(j);
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeAllViews();
      }
      
      public void removeViewAt(int paramAnonymousInt)
      {
        View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
        if (localView != null)
        {
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeViewAt(paramAnonymousInt);
      }
    });
  }
  
  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = bool5;
    if (paramView2 != null)
    {
      bool7 = bool5;
      if (paramView2 != this) {
        if (paramView2 == paramView1)
        {
          bool7 = bool5;
        }
        else
        {
          if (findContainingItemView(paramView2) == null) {
            return false;
          }
          if (paramView1 == null) {
            return true;
          }
          if (findContainingItemView(paramView1) == null) {
            return true;
          }
          this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
          this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
          offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
          offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
          int i = this.mLayout.getLayoutDirection();
          int j = -1;
          int k;
          if (i == 1) {
            k = -1;
          } else {
            k = 1;
          }
          paramView2 = this.mTempRect;
          int m = paramView2.left;
          paramView1 = this.mTempRect2;
          int n = paramView1.left;
          if (((m < n) || (paramView2.right <= n)) && (paramView2.right < paramView1.right))
          {
            i = 1;
          }
          else
          {
            i1 = paramView2.right;
            i = paramView1.right;
            if (((i1 > i) || (m >= i)) && (m > n)) {
              i = -1;
            } else {
              i = 0;
            }
          }
          int i1 = paramView2.top;
          n = paramView1.top;
          if (((i1 < n) || (paramView2.bottom <= n)) && (paramView2.bottom < paramView1.bottom))
          {
            j = 1;
          }
          else
          {
            int i2 = paramView2.bottom;
            m = paramView1.bottom;
            if (((i2 <= m) && (i1 < m)) || (i1 <= n)) {
              j = 0;
            }
          }
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 17)
              {
                if (paramInt != 33)
                {
                  if (paramInt != 66)
                  {
                    if (paramInt == 130)
                    {
                      bool7 = bool6;
                      if (j > 0) {
                        bool7 = true;
                      }
                      return bool7;
                    }
                    paramView1 = new StringBuilder();
                    paramView1.append("Invalid direction: ");
                    paramView1.append(paramInt);
                    paramView1.append(exceptionLabel());
                    throw new IllegalArgumentException(paramView1.toString());
                  }
                  bool7 = bool1;
                  if (i > 0) {
                    bool7 = true;
                  }
                  return bool7;
                }
                bool7 = bool2;
                if (j < 0) {
                  bool7 = true;
                }
                return bool7;
              }
              bool7 = bool3;
              if (i < 0) {
                bool7 = true;
              }
              return bool7;
            }
            if (j <= 0)
            {
              bool7 = bool4;
              if (j == 0)
              {
                bool7 = bool4;
                if (i * k <= 0) {}
              }
            }
            else
            {
              bool7 = true;
            }
            return bool7;
          }
          if (j >= 0)
          {
            bool7 = bool5;
            if (j == 0)
            {
              bool7 = bool5;
              if (i * k >= 0) {}
            }
          }
          else
          {
            bool7 = true;
          }
        }
      }
    }
    return bool7;
  }
  
  private void nestedScrollByInternal(int paramInt1, int paramInt2, @Nullable MotionEvent paramMotionEvent, int paramInt3)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutSuppressed) {
      return;
    }
    int[] arrayOfInt = this.mReusableIntPair;
    int i = 0;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    boolean bool1 = localLayoutManager.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (bool1) {
      j = 1;
    } else {
      j = 0;
    }
    int k = j;
    if (bool2) {
      k = j | 0x2;
    }
    startNestedScroll(k, paramInt3);
    int m;
    if (bool1) {
      m = paramInt1;
    } else {
      m = 0;
    }
    int n;
    if (bool2) {
      n = paramInt2;
    } else {
      n = 0;
    }
    k = paramInt1;
    int j = paramInt2;
    if (dispatchNestedPreScroll(m, n, this.mReusableIntPair, this.mScrollOffset, paramInt3))
    {
      arrayOfInt = this.mReusableIntPair;
      k = paramInt1 - arrayOfInt[0];
      j = paramInt2 - arrayOfInt[1];
    }
    if (bool1) {
      paramInt1 = k;
    } else {
      paramInt1 = 0;
    }
    paramInt2 = i;
    if (bool2) {
      paramInt2 = j;
    }
    scrollByInternal(paramInt1, paramInt2, paramMotionEvent, paramInt3);
    paramMotionEvent = this.mGapWorker;
    if ((paramMotionEvent != null) && ((k != 0) || (j != 0))) {
      paramMotionEvent.postFromTraversal(this, k, j);
    }
    stopNestedScroll(paramInt3);
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    boolean bool;
    if ((this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      if (this.mDispatchItemsChangedEvent) {
        this.mLayout.onItemsChanged(this);
      }
    }
    if (predictiveItemAnimationsEnabled()) {
      this.mAdapterHelper.preProcess();
    } else {
      this.mAdapterHelper.consumeUpdatesInOnePass();
    }
    boolean bool1 = this.mItemsAddedOrRemoved;
    boolean bool2 = false;
    int i;
    if ((!bool1) && (!this.mItemsChanged)) {
      i = 0;
    } else {
      i = 1;
    }
    State localState = this.mState;
    if ((this.mFirstLayoutComplete) && (this.mItemAnimator != null))
    {
      bool1 = this.mDataSetHasChangedAfterLayout;
      if (((bool1) || (i != 0) || (this.mLayout.mRequestedSimpleAnimations)) && ((!bool1) || (this.mAdapter.hasStableIds())))
      {
        bool1 = true;
        break label145;
      }
    }
    bool1 = false;
    label145:
    localState.mRunSimpleAnimations = bool1;
    localState = this.mState;
    bool1 = bool2;
    if (localState.mRunSimpleAnimations)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (!this.mDataSetHasChangedAfterLayout)
        {
          bool1 = bool2;
          if (predictiveItemAnimationsEnabled()) {
            bool1 = true;
          }
        }
      }
    }
    localState.mRunPredictiveAnimations = bool1;
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = 1;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
    }
    for (;;)
    {
      j = 1;
      break label80;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
    }
    int j = 0;
    label80:
    if (paramFloat4 < 0.0F)
    {
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      j = i;
    }
    else if (paramFloat4 > 0.0F)
    {
      ensureBottomGlow();
      EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      j = i;
    }
    if ((j != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void recoverFocusFromState()
  {
    if ((this.mPreserveFocusAfterLayout) && (this.mAdapter != null) && (hasFocus()) && (getDescendantFocusability() != 393216) && ((getDescendantFocusability() != 131072) || (!isFocused())))
    {
      Object localObject1;
      if (!isFocused())
      {
        localObject1 = getFocusedChild();
        if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((((View)localObject1).getParent() == null) || (!((View)localObject1).hasFocus())))
        {
          if (this.mChildHelper.getChildCount() == 0) {
            requestFocus();
          }
        }
        else if (!this.mChildHelper.isHidden((View)localObject1)) {
          return;
        }
      }
      long l = this.mState.mFocusedItemId;
      Object localObject2 = null;
      if ((l != -1L) && (this.mAdapter.hasStableIds())) {
        localObject1 = findViewHolderForItemId(this.mState.mFocusedItemId);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (!this.mChildHelper.isHidden(((ViewHolder)localObject1).itemView)) && (((ViewHolder)localObject1).itemView.hasFocusable()))
      {
        localObject1 = ((ViewHolder)localObject1).itemView;
      }
      else
      {
        localObject1 = localObject2;
        if (this.mChildHelper.getChildCount() > 0) {
          localObject1 = findNextViewToFocus();
        }
      }
      if (localObject1 != null)
      {
        int i = this.mState.mFocusedSubChildId;
        localObject2 = localObject1;
        if (i != -1L)
        {
          View localView = ((View)localObject1).findViewById(i);
          localObject2 = localObject1;
          if (localView != null)
          {
            localObject2 = localObject1;
            if (localView.isFocusable()) {
              localObject2 = localView;
            }
          }
        }
        ((View)localObject2).requestFocus();
      }
    }
  }
  
  private void releaseGlows()
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool1 = false;
    }
    localEdgeEffect = this.mTopGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = bool1 | this.mTopGlow.isFinished();
    }
    localEdgeEffect = this.mRightGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | this.mRightGlow.isFinished();
    }
    localEdgeEffect = this.mBottomGlow;
    bool2 = bool1;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = bool1 | this.mBottomGlow.isFinished();
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void requestChildOnScreen(@NonNull View paramView1, @Nullable View paramView2)
  {
    if (paramView2 != null) {
      localObject1 = paramView2;
    } else {
      localObject1 = paramView1;
    }
    this.mTempRect.set(0, 0, ((View)localObject1).getWidth(), ((View)localObject1).getHeight());
    Object localObject1 = ((View)localObject1).getLayoutParams();
    if ((localObject1 instanceof LayoutParams))
    {
      localObject1 = (LayoutParams)localObject1;
      if (!((LayoutParams)localObject1).mInsetsDirty)
      {
        localObject1 = ((LayoutParams)localObject1).mDecorInsets;
        localObject2 = this.mTempRect;
        ((Rect)localObject2).left -= ((Rect)localObject1).left;
        ((Rect)localObject2).right += ((Rect)localObject1).right;
        ((Rect)localObject2).top -= ((Rect)localObject1).top;
        ((Rect)localObject2).bottom += ((Rect)localObject1).bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
    }
    Object localObject2 = this.mLayout;
    localObject1 = this.mTempRect;
    boolean bool1 = this.mFirstLayoutComplete;
    boolean bool2;
    if (paramView2 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((LayoutManager)localObject2).requestChildRectangleOnScreen(this, paramView1, (Rect)localObject1, bool1 ^ true, bool2);
  }
  
  private void resetFocusInfo()
  {
    State localState = this.mState;
    localState.mFocusedItemId = -1L;
    localState.mFocusedItemPosition = -1;
    localState.mFocusedSubChildId = -1;
  }
  
  private void resetScroll()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    stopNestedScroll(0);
    releaseGlows();
  }
  
  private void saveFocusInfo()
  {
    boolean bool = this.mPreserveFocusAfterLayout;
    State localState = null;
    Object localObject;
    if ((bool) && (hasFocus()) && (this.mAdapter != null)) {
      localObject = getFocusedChild();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = localState;
    } else {
      localObject = findContainingViewHolder((View)localObject);
    }
    if (localObject == null)
    {
      resetFocusInfo();
    }
    else
    {
      localState = this.mState;
      long l;
      if (this.mAdapter.hasStableIds()) {
        l = ((ViewHolder)localObject).getItemId();
      } else {
        l = -1L;
      }
      localState.mFocusedItemId = l;
      localState = this.mState;
      int i;
      if (this.mDataSetHasChangedAfterLayout) {
        i = -1;
      } else if (((ViewHolder)localObject).isRemoved()) {
        i = ((ViewHolder)localObject).mOldPosition;
      } else {
        i = ((ViewHolder)localObject).getAbsoluteAdapterPosition();
      }
      localState.mFocusedItemPosition = i;
      this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(((ViewHolder)localObject).itemView);
    }
  }
  
  private void setAdapterInternal(@Nullable Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    Adapter localAdapter = this.mAdapter;
    if (localAdapter != null)
    {
      localAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      removeAndRecycleViews();
    }
    this.mAdapterHelper.reset();
    localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    paramAdapter = this.mLayout;
    if (paramAdapter != null) {
      paramAdapter.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    this.mState.mStructureChanged = true;
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.stopSmoothScroller();
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      if (this.mLeftGlow.isFinished()) {
        this.mLeftGlow.onAbsorb(-paramInt1);
      }
    }
    else if (paramInt1 > 0)
    {
      ensureRightGlow();
      if (this.mRightGlow.isFinished()) {
        this.mRightGlow.onAbsorb(paramInt1);
      }
    }
    if (paramInt2 < 0)
    {
      ensureTopGlow();
      if (this.mTopGlow.isFinished()) {
        this.mTopGlow.onAbsorb(-paramInt2);
      }
    }
    else if (paramInt2 > 0)
    {
      ensureBottomGlow();
      if (this.mBottomGlow.isFinished()) {
        this.mBottomGlow.onAbsorb(paramInt2);
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if ((localLayoutManager == null) || (!localLayoutManager.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(@NonNull ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(@NonNull ItemDecoration paramItemDecoration, int paramInt)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    } else {
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      this.mOnChildAttachStateListeners = new ArrayList();
    }
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(@NonNull OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(@NonNull OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners == null) {
      this.mScrollListeners = new ArrayList();
    }
    this.mScrollListeners.add(paramOnScrollListener);
  }
  
  public void addRecyclerListener(@NonNull RecyclerListener paramRecyclerListener)
  {
    boolean bool;
    if (paramRecyclerListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "'listener' arg cannot be null.");
    this.mRecyclerListeners.add(paramRecyclerListener);
  }
  
  void animateAppearance(@NonNull ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void animateDisappearance(@NonNull ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(exceptionLabel());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(exceptionLabel());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
    }
  }
  
  boolean canReuseUpdatedViewHolder(ViewHolder paramViewHolder)
  {
    ItemAnimator localItemAnimator = this.mItemAnimator;
    boolean bool;
    if ((localItemAnimator != null) && (!localItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof LayoutParams)) && (this.mLayout.checkLayoutParams((LayoutParams)paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void clearOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.clearOldPosition();
      }
    }
    this.mRecycler.clearOldPositions();
  }
  
  public void clearOnChildAttachStateChangeListeners()
  {
    List localList = this.mOnChildAttachStateListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void clearOnScrollListeners()
  {
    List localList = this.mScrollListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollRange(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollRange(this.mState);
    }
    return i;
  }
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()) && (paramInt1 > 0))
    {
      this.mLeftGlow.onRelease();
      bool1 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool1 = false;
    }
    localEdgeEffect = this.mRightGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.mRightGlow.onRelease();
          bool2 = bool1 | this.mRightGlow.isFinished();
        }
      }
    }
    localEdgeEffect = this.mTopGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.mTopGlow.onRelease();
          bool1 = bool2 | this.mTopGlow.isFinished();
        }
      }
    }
    localEdgeEffect = this.mBottomGlow;
    bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.mBottomGlow.onRelease();
          bool2 = bool1 | this.mBottomGlow.isFinished();
        }
      }
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((this.mFirstLayoutComplete) && (!this.mDataSetHasChangedAfterLayout))
    {
      if (!this.mAdapterHelper.hasPendingUpdates()) {
        return;
      }
      if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (!this.mLayoutWasDefered) {
          if (hasUpdatedView()) {
            dispatchLayout();
          } else {
            this.mAdapterHelper.consumePostponedUpdates();
          }
        }
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        TraceCompat.endSection();
      }
      else if (this.mAdapterHelper.hasPendingUpdates())
      {
        TraceCompat.beginSection("RV FullInvalidate");
        dispatchLayout();
        TraceCompat.endSection();
      }
      return;
    }
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  void dispatchChildAttached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    Adapter localAdapter = this.mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewAttachedToWindow((ViewHolder)localObject);
    }
    localObject = this.mOnChildAttachStateListeners;
    if (localObject != null) {
      for (int i = ((List)localObject).size() - 1; i >= 0; i--) {
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
      }
    }
  }
  
  void dispatchChildDetached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    Adapter localAdapter = this.mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewDetachedFromWindow((ViewHolder)localObject);
    }
    localObject = this.mOnChildAttachStateListeners;
    if (localObject != null) {
      for (int i = ((List)localObject).size() - 1; i >= 0; i--) {
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
      }
    }
  }
  
  void dispatchLayout()
  {
    if (this.mAdapter == null)
    {
      Log.w("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.mState.mIsMeasuring = false;
    int i;
    if ((this.mLastAutoMeasureSkippedDueToExact) && ((this.mLastAutoMeasureNonExactMeasuredWidth != getWidth()) || (this.mLastAutoMeasureNonExactMeasuredHeight != getHeight()))) {
      i = 1;
    } else {
      i = 0;
    }
    this.mLastAutoMeasureNonExactMeasuredWidth = 0;
    this.mLastAutoMeasureNonExactMeasuredHeight = 0;
    this.mLastAutoMeasureSkippedDueToExact = false;
    if (this.mState.mLayoutStep == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    else if ((!this.mAdapterHelper.hasUpdates()) && (i == 0) && (this.mLayout.getWidth() == getWidth()) && (this.mLayout.getHeight() == getHeight()))
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
    }
    else
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    dispatchLayoutStep3();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = this.mLayout;
    if (localObject != null) {
      ((LayoutManager)localObject).onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    localObject = this.mScrollListener;
    if (localObject != null) {
      ((OnScrollListener)localObject).onScrollStateChanged(this, paramInt);
    }
    localObject = this.mScrollListeners;
    if (localObject != null) {
      for (int i = ((List)localObject).size() - 1; i >= 0; i--) {
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
      }
    }
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    this.mDispatchScrollCounter += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i - paramInt1, j - paramInt2);
    onScrolled(paramInt1, paramInt2);
    Object localObject = this.mScrollListener;
    if (localObject != null) {
      ((OnScrollListener)localObject).onScrolled(this, paramInt1, paramInt2);
    }
    localObject = this.mScrollListeners;
    if (localObject != null) {
      for (j = ((List)localObject).size() - 1; j >= 0; j--) {
        ((OnScrollListener)this.mScrollListeners.get(j)).onScrolled(this, paramInt1, paramInt2);
      }
    }
    this.mDispatchScrollCounter -= 1;
  }
  
  void dispatchPendingImportantForAccessibilityChanges()
  {
    for (int i = this.mPendingAccessibilityImportanceChange.size() - 1; i >= 0; i--)
    {
      ViewHolder localViewHolder = (ViewHolder)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localViewHolder.itemView.getParent() == this) && (!localViewHolder.shouldIgnore()))
      {
        int j = localViewHolder.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localViewHolder.itemView, j);
          localViewHolder.mPendingAccessibilityState = -1;
        }
      }
    }
    this.mPendingAccessibilityImportanceChange.clear();
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = this.mItemDecorations.size();
    int j = 0;
    for (int k = 0; k < i; k++) {
      ((ItemDecoration)this.mItemDecorations.get(k)).onDrawOver(paramCanvas, this, this.mState);
    }
    EdgeEffect localEdgeEffect = this.mLeftGlow;
    int m = 1;
    int n;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()))
    {
      n = paramCanvas.save();
      if (this.mClipToPadding) {
        k = getPaddingBottom();
      } else {
        k = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + k, 0.0F);
      localEdgeEffect = this.mLeftGlow;
      if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
        i = 1;
      } else {
        i = 0;
      }
      paramCanvas.restoreToCount(n);
    }
    else
    {
      i = 0;
    }
    localEdgeEffect = this.mTopGlow;
    k = i;
    if (localEdgeEffect != null)
    {
      k = i;
      if (!localEdgeEffect.isFinished())
      {
        n = paramCanvas.save();
        if (this.mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localEdgeEffect = this.mTopGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          k = 1;
        } else {
          k = 0;
        }
        k = i | k;
        paramCanvas.restoreToCount(n);
      }
    }
    localEdgeEffect = this.mRightGlow;
    i = k;
    if (localEdgeEffect != null)
    {
      i = k;
      if (!localEdgeEffect.isFinished())
      {
        n = paramCanvas.save();
        int i1 = getWidth();
        if (this.mClipToPadding) {
          i = getPaddingTop();
        } else {
          i = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(i, -i1);
        localEdgeEffect = this.mRightGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          i = 1;
        } else {
          i = 0;
        }
        i = k | i;
        paramCanvas.restoreToCount(n);
      }
    }
    localEdgeEffect = this.mBottomGlow;
    k = i;
    if (localEdgeEffect != null)
    {
      k = i;
      if (!localEdgeEffect.isFinished())
      {
        n = paramCanvas.save();
        paramCanvas.rotate(180.0F);
        if (this.mClipToPadding) {
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
        } else {
          paramCanvas.translate(-getWidth(), -getHeight());
        }
        localEdgeEffect = this.mBottomGlow;
        k = j;
        if (localEdgeEffect != null)
        {
          k = j;
          if (localEdgeEffect.draw(paramCanvas)) {
            k = 1;
          }
        }
        k = i | k;
        paramCanvas.restoreToCount(n);
      }
    }
    if ((k == 0) && (this.mItemAnimator != null) && (this.mItemDecorations.size() > 0) && (this.mItemAnimator.isRunning())) {
      k = m;
    }
    if (k != 0) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
    this.mBottomGlow = localEdgeEffect;
    if (this.mClipToPadding) {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
    this.mLeftGlow = localEdgeEffect;
    if (this.mClipToPadding) {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
    }
  }
  
  void ensureRightGlow()
  {
    if (this.mRightGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
    this.mRightGlow = localEdgeEffect;
    if (this.mClipToPadding) {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
    }
  }
  
  void ensureTopGlow()
  {
    if (this.mTopGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
    this.mTopGlow = localEdgeEffect;
    if (this.mClipToPadding) {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  String exceptionLabel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(this.mAdapter);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(this.mLayout);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  final void fillRemainingScrollValues(State paramState)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.mViewFlinger.mOverScroller;
      paramState.mRemainingScrollHorizontal = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramState.mRemainingScrollVertical = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
    }
    else
    {
      paramState.mRemainingScrollHorizontal = 0;
      paramState.mRemainingScrollVertical = 0;
    }
  }
  
  @Nullable
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    for (int i = this.mChildHelper.getChildCount() - 1; i >= 0; i--)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
    }
    return null;
  }
  
  @Nullable
  public View findContainingItemView(@NonNull View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent != this) {
      paramView = null;
    }
    return paramView;
  }
  
  @Nullable
  public ViewHolder findContainingViewHolder(@NonNull View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = getChildViewHolder(paramView);
    }
    return paramView;
  }
  
  @Nullable
  public ViewHolder findViewHolderForAdapterPosition(int paramInt)
  {
    boolean bool = this.mDataSetHasChangedAfterLayout;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < i)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          localObject2 = localObject1;
          if (getAdapterPositionInRecyclerView(localViewHolder) == paramInt) {
            if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
              localObject2 = localViewHolder;
            } else {
              return localViewHolder;
            }
          }
        }
      }
      j++;
      localObject1 = localObject2;
    }
    return (ViewHolder)localObject1;
  }
  
  public ViewHolder findViewHolderForItemId(long paramLong)
  {
    Adapter localAdapter = this.mAdapter;
    ViewHolder localViewHolder = null;
    Object localObject1 = null;
    Object localObject2 = localViewHolder;
    if (localAdapter != null) {
      if (!localAdapter.hasStableIds())
      {
        localObject2 = localViewHolder;
      }
      else
      {
        int i = this.mChildHelper.getUnfilteredChildCount();
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= i) {
            break;
          }
          localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
          localObject2 = localObject1;
          if (localViewHolder != null)
          {
            localObject2 = localObject1;
            if (!localViewHolder.isRemoved())
            {
              localObject2 = localObject1;
              if (localViewHolder.getItemId() == paramLong) {
                if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
                  localObject2 = localViewHolder;
                } else {
                  return localViewHolder;
                }
              }
            }
          }
          j++;
          localObject1 = localObject2;
        }
      }
    }
    return (ViewHolder)localObject2;
  }
  
  @Nullable
  public ViewHolder findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  @Nullable
  public ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Nullable
  ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    Object localObject1 = null;
    int j = 0;
    while (j < i)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          if (paramBoolean)
          {
            if (localViewHolder.mPosition != paramInt)
            {
              localObject2 = localObject1;
              break label116;
            }
          }
          else if (localViewHolder.getLayoutPosition() != paramInt)
          {
            localObject2 = localObject1;
            break label116;
          }
          if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
            localObject2 = localViewHolder;
          } else {
            return localViewHolder;
          }
        }
      }
      label116:
      j++;
      localObject1 = localObject2;
    }
    return (ViewHolder)localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    Object localObject = this.mLayout;
    int i = 0;
    if (localObject == null)
    {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    }
    if (this.mLayoutSuppressed) {
      return false;
    }
    boolean bool1 = ((LayoutManager)localObject).canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    int j;
    if (bool1)
    {
      j = paramInt1;
      if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
    }
    else
    {
      j = 0;
    }
    int k;
    if (bool2)
    {
      k = paramInt2;
      if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
    }
    else
    {
      k = 0;
    }
    if ((j == 0) && (k == 0)) {
      return false;
    }
    float f1 = j;
    float f2 = k;
    if (!dispatchNestedPreFling(f1, f2))
    {
      boolean bool3;
      if ((!bool1) && (!bool2)) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      dispatchNestedFling(f1, f2, bool3);
      localObject = this.mOnFlingListener;
      if ((localObject != null) && (((OnFlingListener)localObject).onFling(j, k))) {
        return true;
      }
      if (bool3)
      {
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramInt2 = paramInt1;
        if (bool2) {
          paramInt2 = paramInt1 | 0x2;
        }
        startNestedScroll(paramInt2, 1);
        paramInt1 = this.mMaxFlingVelocity;
        paramInt1 = Math.max(-paramInt1, Math.min(j, paramInt1));
        paramInt2 = this.mMaxFlingVelocity;
        paramInt2 = Math.max(-paramInt2, Math.min(k, paramInt2));
        this.mViewFlinger.fling(paramInt1, paramInt2);
        return true;
      }
    }
    return false;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    localObject = this.mAdapter;
    int i = 1;
    int j;
    if ((localObject != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutSuppressed)) {
      j = 1;
    } else {
      j = 0;
    }
    localObject = FocusFinder.getInstance();
    if ((j != 0) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.mLayout.canScrollVertically())
      {
        if (paramInt == 2) {
          k = 130;
        } else {
          k = 33;
        }
        if (((FocusFinder)localObject).findNextFocus(this, paramView, k) == null) {
          m = 1;
        } else {
          m = 0;
        }
        j = m;
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
        {
          paramInt = k;
          j = m;
        }
      }
      else
      {
        j = 0;
      }
      int m = j;
      int k = paramInt;
      if (j == 0)
      {
        m = j;
        k = paramInt;
        if (this.mLayout.canScrollHorizontally())
        {
          if (this.mLayout.getLayoutDirection() == 1) {
            j = 1;
          } else {
            j = 0;
          }
          if (paramInt == 2) {
            k = 1;
          } else {
            k = 0;
          }
          if ((j ^ k) != 0) {
            j = 66;
          } else {
            j = 17;
          }
          if (((FocusFinder)localObject).findNextFocus(this, paramView, j) == null) {
            k = i;
          } else {
            k = 0;
          }
          if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
            paramInt = j;
          }
          m = k;
          k = paramInt;
        }
      }
      if (m != 0)
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(paramView, k, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      paramInt = k;
    }
    else
    {
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
      if ((localObject == null) && (j != 0))
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
    }
    if ((localObject != null) && (!((View)localObject).hasFocusable()))
    {
      if (getFocusedChild() == null) {
        return super.focusSearch(paramView, paramInt);
      }
      requestChildOnScreen((View)localObject, null);
      return paramView;
    }
    if (!isPreferredNextFocus(paramView, (View)localObject, paramInt)) {
      localObject = super.focusSearch(paramView, paramInt);
    }
    return (View)localObject;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    Object localObject = this.mLayout;
    if (localObject != null) {
      return ((LayoutManager)localObject).generateDefaultLayoutParams();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RecyclerView has no LayoutManager");
    ((StringBuilder)localObject).append(exceptionLabel());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(getContext(), paramAttributeSet);
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("RecyclerView has no LayoutManager");
    paramAttributeSet.append(exceptionLabel());
    throw new IllegalStateException(paramAttributeSet.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("RecyclerView has no LayoutManager");
    paramLayoutParams.append(exceptionLabel());
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return "androidx.recyclerview.widget.RecyclerView";
  }
  
  @Nullable
  public Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getAdapterPositionInRecyclerView(ViewHolder paramViewHolder)
  {
    if ((!paramViewHolder.hasAnyOfTheFlags(524)) && (paramViewHolder.isBound())) {
      return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
    }
    return -1;
  }
  
  public int getBaseline()
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      return localLayoutManager.getBaseline();
    }
    return super.getBaseline();
  }
  
  long getChangedHolderKey(ViewHolder paramViewHolder)
  {
    long l;
    if (this.mAdapter.hasStableIds()) {
      l = paramViewHolder.getItemId();
    } else {
      l = paramViewHolder.mPosition;
    }
    return l;
  }
  
  public int getChildAdapterPosition(@NonNull View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    int i;
    if (paramView != null) {
      i = paramView.getAbsoluteAdapterPosition();
    } else {
      i = -1;
    }
    return i;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    ChildDrawingOrderCallback localChildDrawingOrderCallback = this.mChildDrawingOrderCallback;
    if (localChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(@NonNull View paramView)
  {
    Adapter localAdapter = this.mAdapter;
    long l1 = -1L;
    long l2 = l1;
    if (localAdapter != null) {
      if (!localAdapter.hasStableIds())
      {
        l2 = l1;
      }
      else
      {
        paramView = getChildViewHolderInt(paramView);
        l2 = l1;
        if (paramView != null) {
          l2 = paramView.getItemId();
        }
      }
    }
    return l2;
  }
  
  public int getChildLayoutPosition(@NonNull View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    int i;
    if (paramView != null) {
      i = paramView.getLayoutPosition();
    } else {
      i = -1;
    }
    return i;
  }
  
  @Deprecated
  public int getChildPosition(@NonNull View paramView)
  {
    return getChildAdapterPosition(paramView);
  }
  
  public ViewHolder getChildViewHolder(@NonNull View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return getChildViewHolderInt(paramView);
  }
  
  public boolean getClipToPadding()
  {
    return this.mClipToPadding;
  }
  
  @Nullable
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
  {
    getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }
  
  @NonNull
  public EdgeEffectFactory getEdgeEffectFactory()
  {
    return this.mEdgeEffectFactory;
  }
  
  @Nullable
  public ItemAnimator getItemAnimator()
  {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mInsetsDirty) {
      return localLayoutParams.mDecorInsets;
    }
    if ((this.mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid()))) {
      return localLayoutParams.mDecorInsets;
    }
    Rect localRect1 = localLayoutParams.mDecorInsets;
    localRect1.set(0, 0, 0, 0);
    int i = this.mItemDecorations.size();
    for (int j = 0; j < i; j++)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((ItemDecoration)this.mItemDecorations.get(j)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      int k = localRect1.left;
      Rect localRect2 = this.mTempRect;
      localRect1.left = (k + localRect2.left);
      localRect1.top += localRect2.top;
      localRect1.right += localRect2.right;
      localRect1.bottom += localRect2.bottom;
    }
    localLayoutParams.mInsetsDirty = false;
    return localRect1;
  }
  
  @NonNull
  public ItemDecoration getItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      return (ItemDecoration)this.mItemDecorations.get(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int getItemDecorationCount()
  {
    return this.mItemDecorations.size();
  }
  
  @Nullable
  public LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return this.mMinFlingVelocity;
  }
  
  long getNanoTime()
  {
    if (ALLOW_THREAD_GAP_WORK) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  @Nullable
  public OnFlingListener getOnFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.mPreserveFocusAfterLayout;
  }
  
  @NonNull
  public RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    boolean bool;
    if ((this.mFirstLayoutComplete) && (!this.mDataSetHasChangedAfterLayout) && (!this.mAdapterHelper.hasPendingUpdates())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback()
    {
      void dispatchUpdate(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        int i = paramAnonymousUpdateOp.cmd;
        RecyclerView localRecyclerView;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i == 8)
              {
                localRecyclerView = RecyclerView.this;
                localRecyclerView.mLayout.onItemsMoved(localRecyclerView, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, 1);
              }
            }
            else
            {
              localRecyclerView = RecyclerView.this;
              localRecyclerView.mLayout.onItemsUpdated(localRecyclerView, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, paramAnonymousUpdateOp.payload);
            }
          }
          else
          {
            localRecyclerView = RecyclerView.this;
            localRecyclerView.mLayout.onItemsRemoved(localRecyclerView, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
          }
        }
        else
        {
          localRecyclerView = RecyclerView.this;
          localRecyclerView.mLayout.onItemsAdded(localRecyclerView, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
        }
      }
      
      public RecyclerView.ViewHolder findViewHolder(int paramAnonymousInt)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.this.findViewHolderForPosition(paramAnonymousInt, true);
        if (localViewHolder == null) {
          return null;
        }
        if (RecyclerView.this.mChildHelper.isHidden(localViewHolder.itemView)) {
          return null;
        }
        return localViewHolder;
      }
      
      public void markViewHoldersUpdated(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        RecyclerView.this.viewRangeUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        RecyclerView.this.mItemsChanged = true;
      }
      
      public void offsetPositionsForAdd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForInsert(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForMove(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForMove(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForRemovingInvisible(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, true);
        Object localObject = RecyclerView.this;
        ((RecyclerView)localObject).mItemsAddedOrRemoved = true;
        localObject = ((RecyclerView)localObject).mState;
        ((RecyclerView.State)localObject).mDeletedInvisibleItemCountSincePreviousLayout += paramAnonymousInt2;
      }
      
      public void offsetPositionsForRemovingLaidOutOrNewView(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, false);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void onDispatchFirstPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }
      
      public void onDispatchSecondPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }
    });
  }
  
  @VisibleForTesting
  void initFastScroller(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 != null) && (paramDrawable1 != null) && (paramStateListDrawable2 != null) && (paramDrawable2 != null))
    {
      Resources localResources = getContext().getResources();
      new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
      return;
    }
    paramStateListDrawable1 = new StringBuilder();
    paramStateListDrawable1.append("Trying to set fast scroller without both required drawables.");
    paramStateListDrawable1.append(exceptionLabel());
    throw new IllegalArgumentException(paramStateListDrawable1.toString());
  }
  
  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0) {
      return;
    }
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  boolean isAccessibilityEnabled()
  {
    AccessibilityManager localAccessibilityManager = this.mAccessibilityManager;
    boolean bool;
    if ((localAccessibilityManager != null) && (localAccessibilityManager.isEnabled())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isAnimating()
  {
    ItemAnimator localItemAnimator = this.mItemAnimator;
    boolean bool;
    if ((localItemAnimator != null) && (localItemAnimator.isRunning())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttached;
  }
  
  public boolean isComputingLayout()
  {
    boolean bool;
    if (this.mLayoutOrScrollCounter > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isLayoutFrozen()
  {
    return isLayoutSuppressed();
  }
  
  public final boolean isLayoutSuppressed()
  {
    return this.mLayoutSuppressed;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void jumpToPositionForSmoothScroller(int paramInt)
  {
    if (this.mLayout == null) {
      return;
    }
    setScrollState(2);
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  void markItemDecorInsetsDirty()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++) {
      ((LayoutParams)this.mChildHelper.getUnfilteredChildAt(j).getLayoutParams()).mInsetsDirty = true;
    }
    this.mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.addFlags(6);
      }
    }
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }
  
  public void nestedScrollBy(int paramInt1, int paramInt2)
  {
    nestedScrollByInternal(paramInt1, paramInt2, null, 1);
  }
  
  public void offsetChildrenHorizontal(@Px int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++) {
      this.mChildHelper.getChildAt(j).offsetLeftAndRight(paramInt);
    }
  }
  
  public void offsetChildrenVertical(@Px int paramInt)
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++) {
      this.mChildHelper.getChildAt(j).offsetTopAndBottom(paramInt);
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2, false);
        this.mState.mStructureChanged = true;
      }
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    int j;
    int k;
    int m;
    if (paramInt1 < paramInt2)
    {
      j = -1;
      k = paramInt1;
      m = paramInt2;
    }
    else
    {
      m = paramInt1;
      k = paramInt2;
      j = 1;
    }
    for (int n = 0; n < i; n++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(n));
      if (localViewHolder != null)
      {
        int i1 = localViewHolder.mPosition;
        if ((i1 >= k) && (i1 <= m))
        {
          if (i1 == paramInt1) {
            localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
          } else {
            localViewHolder.offsetPosition(j, false);
          }
          this.mState.mStructureChanged = true;
        }
      }
    }
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        int k = localViewHolder.mPosition;
        if (k >= paramInt1 + paramInt2)
        {
          localViewHolder.offsetPosition(-paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
        else if (k >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
      }
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    boolean bool = true;
    this.mIsAttached = true;
    if ((!this.mFirstLayoutComplete) || (isLayoutRequested())) {
      bool = false;
    }
    this.mFirstLayoutComplete = bool;
    Object localObject1 = this.mLayout;
    if (localObject1 != null) {
      ((LayoutManager)localObject1).dispatchAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
    if (ALLOW_THREAD_GAP_WORK)
    {
      localObject1 = GapWorker.sGapWorker;
      Object localObject2 = (GapWorker)((ThreadLocal)localObject1).get();
      this.mGapWorker = ((GapWorker)localObject2);
      if (localObject2 == null)
      {
        this.mGapWorker = new GapWorker();
        localObject2 = ViewCompat.getDisplay(this);
        float f1 = 60.0F;
        float f2 = f1;
        if (!isInEditMode())
        {
          f2 = f1;
          if (localObject2 != null)
          {
            float f3 = ((Display)localObject2).getRefreshRate();
            f2 = f1;
            if (f3 >= 30.0F) {
              f2 = f3;
            }
          }
        }
        localObject2 = this.mGapWorker;
        ((GapWorker)localObject2).mFrameIntervalNs = ((1.0E9F / f2));
        ((ThreadLocal)localObject1).set(localObject2);
      }
      this.mGapWorker.add(this);
    }
  }
  
  public void onChildAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildDetachedFromWindow(@NonNull View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mItemAnimator;
    if (localObject != null) {
      ((ItemAnimator)localObject).endAnimations();
    }
    stopScroll();
    this.mIsAttached = false;
    localObject = this.mLayout;
    if (localObject != null) {
      ((LayoutManager)localObject).dispatchDetachedFromWindow(this, this.mRecycler);
    }
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
    if (ALLOW_THREAD_GAP_WORK)
    {
      localObject = this.mGapWorker;
      if (localObject != null)
      {
        ((GapWorker)localObject).remove(this);
        this.mGapWorker = null;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.mItemDecorations.size();
    for (int j = 0; j < i; j++) {
      ((ItemDecoration)this.mItemDecorations.get(j)).onDraw(paramCanvas, this, this.mState);
    }
  }
  
  void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter += 1;
  }
  
  void onExitLayoutOrScroll()
  {
    onExitLayoutOrScroll(true);
  }
  
  void onExitLayoutOrScroll(boolean paramBoolean)
  {
    int i = this.mLayoutOrScrollCounter - 1;
    this.mLayoutOrScrollCounter = i;
    if (i < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
      }
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null) {
      return false;
    }
    if (this.mLayoutSuppressed) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f2;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (this.mLayout.canScrollVertically()) {
          f1 = -paramMotionEvent.getAxisValue(9);
        } else {
          f1 = 0.0F;
        }
        f2 = f1;
        if (this.mLayout.canScrollHorizontally())
        {
          float f3 = paramMotionEvent.getAxisValue(10);
          f2 = f1;
          f1 = f3;
          break label140;
        }
      }
      else
      {
        if ((paramMotionEvent.getSource() & 0x400000) != 0)
        {
          f1 = paramMotionEvent.getAxisValue(26);
          if (this.mLayout.canScrollVertically())
          {
            f2 = -f1;
            break label138;
          }
          if (this.mLayout.canScrollHorizontally())
          {
            f2 = 0.0F;
            break label140;
          }
        }
        f2 = 0.0F;
      }
      label138:
      float f1 = 0.0F;
      label140:
      if ((f2 != 0.0F) || (f1 != 0.0F)) {
        nestedScrollByInternal((int)(f1 * this.mScaledHorizontalScrollFactor), (int)(f2 * this.mScaledVerticalScrollFactor), paramMotionEvent, 1);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mLayoutSuppressed;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    this.mInterceptingOnItemTouchListener = null;
    if (findInterceptingOnItemTouchListener(paramMotionEvent))
    {
      cancelScroll();
      return true;
    }
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null) {
      return false;
    }
    boolean bool3 = localLayoutManager.canScrollHorizontally();
    bool1 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    int i;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 5)
            {
              if (j == 6) {
                onPointerUp(paramMotionEvent);
              }
            }
            else
            {
              this.mScrollPointerId = paramMotionEvent.getPointerId(k);
              i = (int)(paramMotionEvent.getX(k) + 0.5F);
              this.mLastTouchX = i;
              this.mInitialTouchX = i;
              k = (int)(paramMotionEvent.getY(k) + 0.5F);
              this.mLastTouchY = k;
              this.mInitialTouchY = k;
            }
          }
          else {
            cancelScroll();
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
          if (j < 0)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Error processing scroll; pointer index for id ");
            paramMotionEvent.append(this.mScrollPointerId);
            paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
            Log.e("RecyclerView", paramMotionEvent.toString());
            return false;
          }
          k = (int)(paramMotionEvent.getX(j) + 0.5F);
          j = (int)(paramMotionEvent.getY(j) + 0.5F);
          if (this.mScrollState != 1)
          {
            int m = this.mInitialTouchX;
            int n = this.mInitialTouchY;
            if ((i != 0) && (Math.abs(k - m) > this.mTouchSlop))
            {
              this.mLastTouchX = k;
              k = 1;
            }
            else
            {
              k = 0;
            }
            i = k;
            if (bool1)
            {
              i = k;
              if (Math.abs(j - n) > this.mTouchSlop)
              {
                this.mLastTouchY = j;
                i = 1;
              }
            }
            if (i != 0) {
              setScrollState(1);
            }
          }
        }
      }
      else
      {
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
      }
    }
    else
    {
      if (this.mIgnoreMotionEventTillDown) {
        this.mIgnoreMotionEventTillDown = false;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      k = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = k;
      this.mInitialTouchX = k;
      k = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = k;
      this.mInitialTouchY = k;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
      }
      paramMotionEvent = this.mNestedOffsets;
      paramMotionEvent[1] = 0;
      paramMotionEvent[0] = 0;
      k = i;
      if (bool1) {
        k = i | 0x2;
      }
      startNestedScroll(k, 0);
    }
    if (this.mScrollState == 1) {
      bool2 = true;
    }
    return bool2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.mLayout;
    if (localObject == null)
    {
      defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    boolean bool1 = ((LayoutManager)localObject).isAutoMeasureEnabled();
    boolean bool2 = false;
    if (bool1)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      bool1 = bool2;
      if (i == 1073741824)
      {
        bool1 = bool2;
        if (j == 1073741824) {
          bool1 = true;
        }
      }
      this.mLastAutoMeasureSkippedDueToExact = bool1;
      if ((!bool1) && (this.mAdapter != null))
      {
        if (this.mState.mLayoutStep == 1) {
          dispatchLayoutStep1();
        }
        this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
        if (this.mLayout.shouldMeasureTwice())
        {
          this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
          this.mState.mIsMeasuring = true;
          dispatchLayoutStep2();
          this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
        }
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
      }
    }
    else
    {
      if (this.mHasFixedSize)
      {
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        return;
      }
      if (this.mAdapterUpdateDuringMeasure)
      {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        localObject = this.mState;
        if (((State)localObject).mRunPredictiveAnimations)
        {
          ((State)localObject).mInPreLayout = true;
        }
        else
        {
          this.mAdapterHelper.consumeUpdatesInOnePass();
          this.mState.mInPreLayout = false;
        }
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
      }
      else if (this.mState.mRunPredictiveAnimations)
      {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        return;
      }
      localObject = this.mAdapter;
      if (localObject != null) {
        this.mState.mItemCount = ((Adapter)localObject).getItemCount();
      } else {
        this.mState.mItemCount = 0;
      }
      startInterceptRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      stopInterceptRequestLayout(false);
      this.mState.mInPreLayout = false;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    this.mPendingSavedState = paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = this.mPendingSavedState;
    if (localObject != null)
    {
      localSavedState.copyFrom((SavedState)localObject);
    }
    else
    {
      localObject = this.mLayout;
      if (localObject != null) {
        localSavedState.mLayoutState = ((LayoutManager)localObject).onSaveInstanceState();
      } else {
        localSavedState.mLayoutState = null;
      }
    }
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(@Px int paramInt1, @Px int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.mLayoutSuppressed;
    int i = 0;
    if ((!bool) && (!this.mIgnoreMotionEventTillDown))
    {
      if (dispatchToOnItemTouchListeners(paramMotionEvent))
      {
        cancelScroll();
        return true;
      }
      Object localObject = this.mLayout;
      if (localObject == null) {
        return false;
      }
      int j = ((LayoutManager)localObject).canScrollHorizontally();
      bool = this.mLayout.canScrollVertically();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      int k = paramMotionEvent.getActionMasked();
      int m = paramMotionEvent.getActionIndex();
      if (k == 0)
      {
        localObject = this.mNestedOffsets;
        localObject[1] = 0;
        localObject[0] = 0;
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
      int[] arrayOfInt1 = this.mNestedOffsets;
      ((MotionEvent)localObject).offsetLocation(arrayOfInt1[0], arrayOfInt1[1]);
      int n;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 5)
              {
                if (k != 6)
                {
                  n = i;
                }
                else
                {
                  onPointerUp(paramMotionEvent);
                  n = i;
                }
              }
              else
              {
                this.mScrollPointerId = paramMotionEvent.getPointerId(m);
                k = (int)(paramMotionEvent.getX(m) + 0.5F);
                this.mLastTouchX = k;
                this.mInitialTouchX = k;
                m = (int)(paramMotionEvent.getY(m) + 0.5F);
                this.mLastTouchY = m;
                this.mInitialTouchY = m;
                n = i;
              }
            }
            else
            {
              cancelScroll();
              n = i;
            }
          }
          else
          {
            m = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
            if (m < 0)
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("Error processing scroll; pointer index for id ");
              paramMotionEvent.append(this.mScrollPointerId);
              paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
              Log.e("RecyclerView", paramMotionEvent.toString());
              return false;
            }
            int i1 = (int)(paramMotionEvent.getX(m) + 0.5F);
            int i2 = (int)(paramMotionEvent.getY(m) + 0.5F);
            m = this.mLastTouchX - i1;
            n = this.mLastTouchY - i2;
            int i3 = m;
            k = n;
            label451:
            int i5;
            if (this.mScrollState != 1)
            {
              i4 = m;
              if (j != 0)
              {
                if (m > 0) {
                  m = Math.max(0, m - this.mTouchSlop);
                } else {
                  m = Math.min(0, m + this.mTouchSlop);
                }
                i4 = m;
                if (m != 0)
                {
                  k = 1;
                  break label451;
                }
              }
              k = 0;
              m = i4;
              i4 = n;
              i5 = k;
              if (bool)
              {
                if (n > 0) {
                  i3 = Math.max(0, n - this.mTouchSlop);
                } else {
                  i3 = Math.min(0, n + this.mTouchSlop);
                }
                i4 = i3;
                i5 = k;
                if (i3 != 0)
                {
                  i5 = 1;
                  i4 = i3;
                }
              }
              i3 = m;
              k = i4;
              if (i5 != 0)
              {
                setScrollState(1);
                k = i4;
                i3 = m;
              }
            }
            int i4 = k;
            n = i;
            if (this.mScrollState == 1)
            {
              arrayOfInt1 = this.mReusableIntPair;
              arrayOfInt1[0] = 0;
              arrayOfInt1[1] = 0;
              if (j != 0) {
                n = i3;
              } else {
                n = 0;
              }
              if (bool) {
                i5 = i4;
              } else {
                i5 = 0;
              }
              k = i3;
              m = i4;
              if (dispatchNestedPreScroll(n, i5, arrayOfInt1, this.mScrollOffset, 0))
              {
                arrayOfInt1 = this.mReusableIntPair;
                k = i3 - arrayOfInt1[0];
                m = i4 - arrayOfInt1[1];
                int[] arrayOfInt2 = this.mNestedOffsets;
                i4 = arrayOfInt2[0];
                arrayOfInt1 = this.mScrollOffset;
                arrayOfInt2[0] = (i4 + arrayOfInt1[0]);
                arrayOfInt2[1] += arrayOfInt1[1];
                getParent().requestDisallowInterceptTouchEvent(true);
              }
              arrayOfInt1 = this.mScrollOffset;
              this.mLastTouchX = (i1 - arrayOfInt1[0]);
              this.mLastTouchY = (i2 - arrayOfInt1[1]);
              if (j != 0) {
                i4 = k;
              } else {
                i4 = 0;
              }
              if (bool) {
                i3 = m;
              } else {
                i3 = 0;
              }
              if (scrollByInternal(i4, i3, paramMotionEvent, 0)) {
                getParent().requestDisallowInterceptTouchEvent(true);
              }
              paramMotionEvent = this.mGapWorker;
              n = i;
              if (paramMotionEvent != null) {
                if (k == 0)
                {
                  n = i;
                  if (m == 0) {}
                }
                else
                {
                  paramMotionEvent.postFromTraversal(this, k, m);
                  n = i;
                }
              }
            }
          }
        }
        else
        {
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
          float f1;
          if (j != 0) {
            f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (bool) {
            f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
          } else {
            f2 = 0.0F;
          }
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetScroll();
          n = 1;
        }
      }
      else
      {
        this.mScrollPointerId = paramMotionEvent.getPointerId(0);
        m = (int)(paramMotionEvent.getX() + 0.5F);
        this.mLastTouchX = m;
        this.mInitialTouchX = m;
        m = (int)(paramMotionEvent.getY() + 0.5F);
        this.mLastTouchY = m;
        this.mInitialTouchY = m;
        m = j;
        if (bool) {
          m = j | 0x2;
        }
        startNestedScroll(m, 0);
        n = i;
      }
      if (n == 0) {
        this.mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    }
    return false;
  }
  
  void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  void processDataSetCompletelyChanged(boolean paramBoolean)
  {
    this.mDispatchItemsChangedEvent = (paramBoolean | this.mDispatchItemsChangedEvent);
    this.mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }
  
  void recordAnimationInfoIfBouncedHiddenView(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((this.mState.mTrackOldChangeHolders) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  void removeAndRecycleViews()
  {
    Object localObject = this.mItemAnimator;
    if (localObject != null) {
      ((ItemAnimator)localObject).endAnimations();
    }
    localObject = this.mLayout;
    if (localObject != null)
    {
      ((LayoutManager)localObject).removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    }
    this.mRecycler.clear();
  }
  
  boolean removeAnimatingView(View paramView)
  {
    startInterceptRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      paramView = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(paramView);
      this.mRecycler.recycleViewHolderInternal(paramView);
    }
    stopInterceptRequestLayout(bool ^ true);
    return bool;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null) {
      if (localViewHolder.isTmpDetached())
      {
        localViewHolder.clearTmpDetachFlag();
      }
      else if (!localViewHolder.shouldIgnore())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localViewHolder);
        paramView.append(exceptionLabel());
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    paramView.clearAnimation();
    dispatchChildDetached(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeItemDecoration(@NonNull ItemDecoration paramItemDecoration)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager != null) {
      localLayoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty())
    {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i))
    {
      removeItemDecoration(getItemDecorationAt(paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    List localList = this.mOnChildAttachStateListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(@NonNull OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mInterceptingOnItemTouchListener == paramOnItemTouchListener) {
      this.mInterceptingOnItemTouchListener = null;
    }
  }
  
  public void removeOnScrollListener(@NonNull OnScrollListener paramOnScrollListener)
  {
    List localList = this.mScrollListeners;
    if (localList != null) {
      localList.remove(paramOnScrollListener);
    }
  }
  
  public void removeRecyclerListener(@NonNull RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListeners.remove(paramRecyclerListener);
  }
  
  void repositionShadowingViews()
  {
    int i = this.mChildHelper.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = this.mChildHelper.getChildAt(j);
      Object localObject = getChildViewHolder(localView);
      if (localObject != null)
      {
        localObject = ((ViewHolder)localObject).mShadowingHolder;
        if (localObject != null)
        {
          localObject = ((ViewHolder)localObject).itemView;
          int k = localView.getLeft();
          int m = localView.getTop();
          if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
            ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
          }
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null)) {
      requestChildOnScreen(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i = this.mOnItemTouchListeners.size();
    for (int j = 0; j < i; j++) {
      ((OnItemTouchListener)this.mOnItemTouchListeners.get(j)).onRequestDisallowInterceptTouchEvent(paramBoolean);
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.mInterceptRequestLayoutDepth == 0) && (!this.mLayoutSuppressed)) {
      super.requestLayout();
    } else {
      this.mLayoutWasDefered = true;
    }
  }
  
  void saveOldPositions()
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(j));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.saveOldPosition();
      }
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutSuppressed) {
      return;
    }
    boolean bool1 = localLayoutManager.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      scrollByInternal(paramInt1, paramInt2, null, 0);
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, int paramInt3)
  {
    consumePendingUpdateOperations();
    Object localObject = this.mAdapter;
    boolean bool1 = true;
    int i;
    int j;
    int k;
    int m;
    if (localObject != null)
    {
      localObject = this.mReusableIntPair;
      localObject[0] = 0;
      localObject[1] = 0;
      scrollStep(paramInt1, paramInt2, (int[])localObject);
      localObject = this.mReusableIntPair;
      i = localObject[0];
      j = localObject[1];
      k = j;
      m = i;
      i = paramInt1 - i;
      j = paramInt2 - j;
    }
    else
    {
      k = 0;
      m = 0;
      i = 0;
      j = 0;
    }
    if (!this.mItemDecorations.isEmpty()) {
      invalidate();
    }
    localObject = this.mReusableIntPair;
    localObject[0] = 0;
    localObject[1] = 0;
    dispatchNestedScroll(m, k, i, j, this.mScrollOffset, paramInt3, (int[])localObject);
    localObject = this.mReusableIntPair;
    int n = localObject[0];
    int i1 = localObject[1];
    if ((localObject[0] == 0) && (localObject[1] == 0)) {
      paramInt3 = 0;
    } else {
      paramInt3 = 1;
    }
    int i2 = this.mLastTouchX;
    localObject = this.mScrollOffset;
    this.mLastTouchX = (i2 - localObject[0]);
    this.mLastTouchY -= localObject[1];
    int[] arrayOfInt = this.mNestedOffsets;
    arrayOfInt[0] += localObject[0];
    arrayOfInt[1] += localObject[1];
    if (getOverScrollMode() != 2)
    {
      if ((paramMotionEvent != null) && (!MotionEventCompat.isFromSource(paramMotionEvent, 8194))) {
        pullGlows(paramMotionEvent.getX(), i - n, paramMotionEvent.getY(), j - i1);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    }
    if ((m != 0) || (k != 0)) {
      dispatchOnScrolled(m, k);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    boolean bool2 = bool1;
    if (paramInt3 == 0)
    {
      bool2 = bool1;
      if (m == 0) {
        if (k != 0) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  void scrollStep(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt)
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    fillRemainingScrollValues(this.mState);
    if (paramInt1 != 0) {
      paramInt1 = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0) {
      paramInt2 = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
    } else {
      paramInt2 = 0;
    }
    TraceCompat.endSection();
    repositionShadowingViews();
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutSuppressed) {
      return;
    }
    stopScroll();
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localLayoutManager.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, paramRecyclerViewAccessibilityDelegate);
  }
  
  public void setAdapter(@Nullable Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    processDataSetCompletelyChanged(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback paramChildDrawingOrderCallback)
  {
    if (paramChildDrawingOrderCallback == this.mChildDrawingOrderCallback) {
      return;
    }
    this.mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    boolean bool;
    if (paramChildDrawingOrderCallback != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  @VisibleForTesting
  boolean setChildImportantForAccessibilityInternal(ViewHolder paramViewHolder, int paramInt)
  {
    if (isComputingLayout())
    {
      paramViewHolder.mPendingAccessibilityState = paramInt;
      this.mPendingAccessibilityImportanceChange.add(paramViewHolder);
      return false;
    }
    ViewCompat.setImportantForAccessibility(paramViewHolder.itemView, paramInt);
    return true;
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding) {
      invalidateGlows();
    }
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(@NonNull EdgeEffectFactory paramEdgeEffectFactory)
  {
    Preconditions.checkNotNull(paramEdgeEffectFactory);
    this.mEdgeEffectFactory = paramEdgeEffectFactory;
    invalidateGlows();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(@Nullable ItemAnimator paramItemAnimator)
  {
    ItemAnimator localItemAnimator = this.mItemAnimator;
    if (localItemAnimator != null)
    {
      localItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    if (paramItemAnimator != null) {
      paramItemAnimator.setListener(this.mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  @Deprecated
  public void setLayoutFrozen(boolean paramBoolean)
  {
    suppressLayout(paramBoolean);
  }
  
  public void setLayoutManager(@Nullable LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout) {
      return;
    }
    stopScroll();
    Object localObject;
    if (this.mLayout != null)
    {
      localObject = this.mItemAnimator;
      if (localObject != null) {
        ((ItemAnimator)localObject).endAnimations();
      }
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      this.mRecycler.clear();
      if (this.mIsAttached) {
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      }
      this.mLayout.setRecyclerView(null);
      this.mLayout = null;
    }
    else
    {
      this.mRecycler.clear();
    }
    this.mChildHelper.removeAllViewsUnfiltered();
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null) {
      if (paramLayoutManager.mRecyclerView == null)
      {
        paramLayoutManager.setRecyclerView(this);
        if (this.mIsAttached) {
          this.mLayout.dispatchAttachedToWindow(this);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LayoutManager ");
        ((StringBuilder)localObject).append(paramLayoutManager);
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView:");
        ((StringBuilder)localObject).append(paramLayoutManager.mRecyclerView.exceptionLabel());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    this.mRecycler.updateViewCacheSize();
    requestLayout();
  }
  
  @Deprecated
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      if (paramLayoutTransition == null)
      {
        suppressLayout(false);
        return;
      }
      if ((paramLayoutTransition.getAnimator(0) == null) && (paramLayoutTransition.getAnimator(1) == null) && (paramLayoutTransition.getAnimator(2) == null) && (paramLayoutTransition.getAnimator(3) == null) && (paramLayoutTransition.getAnimator(4) == null))
      {
        suppressLayout(true);
        return;
      }
    }
    if (paramLayoutTransition == null)
    {
      super.setLayoutTransition(null);
      return;
    }
    throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(@Nullable OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }
  
  @Deprecated
  public void setOnScrollListener(@Nullable OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }
  
  public void setRecycledViewPool(@Nullable RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  @Deprecated
  public void setRecyclerListener(@Nullable RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      stopScrollersInternal();
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("; using default value");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      else
      {
        this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
        return;
      }
    }
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(@Nullable ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = isComputingLayout();
    int i = 0;
    if (bool)
    {
      int j;
      if (paramAccessibilityEvent != null) {
        j = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);
      } else {
        j = 0;
      }
      if (j == 0) {
        j = i;
      }
      this.mEatenAccessibilityChangeFlags |= j;
      return true;
    }
    return false;
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, Integer.MIN_VALUE);
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, paramInt3, false);
  }
  
  void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator, int paramInt3, boolean paramBoolean)
  {
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutSuppressed) {
      return;
    }
    boolean bool = localLayoutManager.canScrollHorizontally();
    int i = 0;
    int j = paramInt1;
    if (!bool) {
      j = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if ((j != 0) || (paramInt2 != 0))
    {
      if ((paramInt3 != Integer.MIN_VALUE) && (paramInt3 <= 0)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramBoolean)
        {
          paramInt1 = i;
          if (j != 0) {
            paramInt1 = 1;
          }
          i = paramInt1;
          if (paramInt2 != 0) {
            i = paramInt1 | 0x2;
          }
          startNestedScroll(i, 1);
        }
        this.mViewFlinger.smoothScrollBy(j, paramInt2, paramInt3, paramInterpolator);
      }
      else
      {
        scrollBy(j, paramInt2);
      }
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutSuppressed) {
      return;
    }
    LayoutManager localLayoutManager = this.mLayout;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localLayoutManager.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  void startInterceptRequestLayout()
  {
    int i = this.mInterceptRequestLayoutDepth + 1;
    this.mInterceptRequestLayoutDepth = i;
    if ((i == 1) && (!this.mLayoutSuppressed)) {
      this.mLayoutWasDefered = false;
    }
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  void stopInterceptRequestLayout(boolean paramBoolean)
  {
    if (this.mInterceptRequestLayoutDepth < 1) {
      this.mInterceptRequestLayoutDepth = 1;
    }
    if ((!paramBoolean) && (!this.mLayoutSuppressed)) {
      this.mLayoutWasDefered = false;
    }
    if (this.mInterceptRequestLayoutDepth == 1)
    {
      if ((paramBoolean) && (this.mLayoutWasDefered) && (!this.mLayoutSuppressed) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      if (!this.mLayoutSuppressed) {
        this.mLayoutWasDefered = false;
      }
    }
    this.mInterceptRequestLayoutDepth -= 1;
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public final void suppressLayout(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutSuppressed)
    {
      assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutSuppressed = false;
        if ((this.mLayoutWasDefered) && (this.mLayout != null) && (this.mAdapter != null)) {
          requestLayout();
        }
        this.mLayoutWasDefered = false;
      }
      else
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
      }
    }
  }
  
  public void swapAdapter(@Nullable Adapter paramAdapter, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    processDataSetCompletelyChanged(true);
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(j);
      ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()))
      {
        int k = localViewHolder.mPosition;
        if ((k >= paramInt1) && (k < paramInt1 + paramInt2))
        {
          localViewHolder.addFlags(2);
          localViewHolder.addChangePayload(paramObject);
          ((LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
        }
      }
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
  
  public static abstract class Adapter<VH extends RecyclerView.ViewHolder>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
    
    public final void bindViewHolder(@NonNull VH paramVH, int paramInt)
    {
      int i;
      if (paramVH.mBindingAdapter == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramVH.mPosition = paramInt;
        if (hasStableIds()) {
          paramVH.mItemId = getItemId(paramInt);
        }
        paramVH.setFlags(1, 519);
        TraceCompat.beginSection("RV OnBindView");
      }
      paramVH.mBindingAdapter = this;
      onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
      if (i != 0)
      {
        paramVH.clearPayload();
        paramVH = paramVH.itemView.getLayoutParams();
        if ((paramVH instanceof RecyclerView.LayoutParams)) {
          ((RecyclerView.LayoutParams)paramVH).mInsetsDirty = true;
        }
        TraceCompat.endSection();
      }
    }
    
    boolean canRestoreState()
    {
      int i = RecyclerView.7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        bool2 = bool1;
        if (getItemCount() > 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    
    @NonNull
    public final VH createViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        TraceCompat.beginSection("RV CreateView");
        paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
        if (paramViewGroup.itemView.getParent() == null)
        {
          paramViewGroup.mItemViewType = paramInt;
          return paramViewGroup;
        }
        paramViewGroup = new java/lang/IllegalStateException;
        paramViewGroup.<init>("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        throw paramViewGroup;
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
    
    public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends RecyclerView.ViewHolder> paramAdapter, @NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramAdapter == this) {
        return paramInt;
      }
      return -1;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    @NonNull
    public final StateRestorationPolicy getStateRestorationPolicy()
    {
      return this.mStateRestorationPolicy;
    }
    
    public final boolean hasObservers()
    {
      return this.mObservable.hasObservers();
    }
    
    public final boolean hasStableIds()
    {
      return this.mHasStableIds;
    }
    
    public final void notifyDataSetChanged()
    {
      this.mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int paramInt)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1);
    }
    
    public final void notifyItemChanged(int paramInt, @Nullable Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
    }
    
    public final void notifyItemInserted(int paramInt)
    {
      this.mObservable.notifyItemRangeInserted(paramInt, 1);
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemMoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRemoved(int paramInt)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt, 1);
    }
    
    public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
    
    public abstract void onBindViewHolder(@NonNull VH paramVH, int paramInt);
    
    public void onBindViewHolder(@NonNull VH paramVH, int paramInt, @NonNull List<Object> paramList)
    {
      onBindViewHolder(paramVH, paramInt);
    }
    
    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt);
    
    public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
    
    public boolean onFailedToRecycleView(@NonNull VH paramVH)
    {
      return false;
    }
    
    public void onViewAttachedToWindow(@NonNull VH paramVH) {}
    
    public void onViewDetachedFromWindow(@NonNull VH paramVH) {}
    
    public void onViewRecycled(@NonNull VH paramVH) {}
    
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.registerObserver(paramAdapterDataObserver);
    }
    
    public void setHasStableIds(boolean paramBoolean)
    {
      if (!hasObservers())
      {
        this.mHasStableIds = paramBoolean;
        return;
      }
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void setStateRestorationPolicy(@NonNull StateRestorationPolicy paramStateRestorationPolicy)
    {
      this.mStateRestorationPolicy = paramStateRestorationPolicy;
      this.mObservable.notifyStateRestorationPolicyChanged();
    }
    
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.unregisterObserver(paramAdapterDataObserver);
    }
    
    public static enum StateRestorationPolicy
    {
      static
      {
        StateRestorationPolicy localStateRestorationPolicy1 = new StateRestorationPolicy("ALLOW", 0);
        ALLOW = localStateRestorationPolicy1;
        StateRestorationPolicy localStateRestorationPolicy2 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
        PREVENT_WHEN_EMPTY = localStateRestorationPolicy2;
        StateRestorationPolicy localStateRestorationPolicy3 = new StateRestorationPolicy("PREVENT", 2);
        PREVENT = localStateRestorationPolicy3;
        $VALUES = new StateRestorationPolicy[] { localStateRestorationPolicy1, localStateRestorationPolicy2, localStateRestorationPolicy3 };
      }
    }
  }
  
  static class AdapterDataObservable
    extends Observable<RecyclerView.AdapterDataObserver>
  {
    public boolean hasObservers()
    {
      return this.mObservers.isEmpty() ^ true;
    }
    
    public void notifyChanged()
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged();
      }
    }
    
    public void notifyItemMoved(int paramInt1, int paramInt2)
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
      }
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      }
    }
    
    public void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      }
    }
    
    public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      }
    }
    
    public void notifyStateRestorationPolicyChanged()
    {
      for (int i = this.mObservers.size() - 1; i >= 0; i--) {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onStateRestorationPolicyChanged();
      }
    }
  }
  
  public static abstract class AdapterDataObserver
  {
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
    
    public void onStateRestorationPolicyChanged() {}
  }
  
  public static abstract interface ChildDrawingOrderCallback
  {
    public abstract int onGetChildDrawingOrder(int paramInt1, int paramInt2);
  }
  
  public static class EdgeEffectFactory
  {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;
    
    @NonNull
    protected EdgeEffect createEdgeEffect(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface EdgeDirection {}
  }
  
  public static abstract class ItemAnimator
  {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private long mAddDuration = 120L;
    private long mChangeDuration = 250L;
    private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
    private ItemAnimatorListener mListener = null;
    private long mMoveDuration = 250L;
    private long mRemoveDuration = 120L;
    
    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = paramViewHolder.mFlags & 0xE;
      if (paramViewHolder.isInvalid()) {
        return 4;
      }
      int j = i;
      if ((i & 0x4) == 0)
      {
        int k = paramViewHolder.getOldPosition();
        int m = paramViewHolder.getAbsoluteAdapterPosition();
        j = i;
        if (k != -1)
        {
          j = i;
          if (m != -1)
          {
            j = i;
            if (k != m) {
              j = i | 0x800;
            }
          }
        }
      }
      return j;
    }
    
    public abstract boolean animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateChange(@NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2, @NonNull ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull ItemHolderInfo paramItemHolderInfo1, @Nullable ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animatePersistence(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
    {
      return canReuseUpdatedViewHolder(paramViewHolder);
    }
    
    public final void dispatchAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationFinished(paramViewHolder);
      ItemAnimatorListener localItemAnimatorListener = this.mListener;
      if (localItemAnimatorListener != null) {
        localItemAnimatorListener.onAnimationFinished(paramViewHolder);
      }
    }
    
    public final void dispatchAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationStarted(paramViewHolder);
    }
    
    public final void dispatchAnimationsFinished()
    {
      int i = this.mFinishedListeners.size();
      for (int j = 0; j < i; j++) {
        ((ItemAnimatorFinishedListener)this.mFinishedListeners.get(j)).onAnimationsFinished();
      }
      this.mFinishedListeners.clear();
    }
    
    public abstract void endAnimation(@NonNull RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void endAnimations();
    
    public long getAddDuration()
    {
      return this.mAddDuration;
    }
    
    public long getChangeDuration()
    {
      return this.mChangeDuration;
    }
    
    public long getMoveDuration()
    {
      return this.mMoveDuration;
    }
    
    public long getRemoveDuration()
    {
      return this.mRemoveDuration;
    }
    
    public abstract boolean isRunning();
    
    public final boolean isRunning(@Nullable ItemAnimatorFinishedListener paramItemAnimatorFinishedListener)
    {
      boolean bool = isRunning();
      if (paramItemAnimatorFinishedListener != null) {
        if (!bool) {
          paramItemAnimatorFinishedListener.onAnimationsFinished();
        } else {
          this.mFinishedListeners.add(paramItemAnimatorFinishedListener);
        }
      }
      return bool;
    }
    
    @NonNull
    public ItemHolderInfo obtainHolderInfo()
    {
      return new ItemHolderInfo();
    }
    
    public void onAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
    
    public void onAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
    
    @NonNull
    public ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }
    
    @NonNull
    public ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt, @NonNull List<Object> paramList)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }
    
    public abstract void runPendingAnimations();
    
    public void setAddDuration(long paramLong)
    {
      this.mAddDuration = paramLong;
    }
    
    public void setChangeDuration(long paramLong)
    {
      this.mChangeDuration = paramLong;
    }
    
    void setListener(ItemAnimatorListener paramItemAnimatorListener)
    {
      this.mListener = paramItemAnimatorListener;
    }
    
    public void setMoveDuration(long paramLong)
    {
      this.mMoveDuration = paramLong;
    }
    
    public void setRemoveDuration(long paramLong)
    {
      this.mRemoveDuration = paramLong;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AdapterChanges {}
    
    public static abstract interface ItemAnimatorFinishedListener
    {
      public abstract void onAnimationsFinished();
    }
    
    static abstract interface ItemAnimatorListener
    {
      public abstract void onAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder);
    }
    
    public static class ItemHolderInfo
    {
      public int bottom;
      public int changeFlags;
      public int left;
      public int right;
      public int top;
      
      @NonNull
      public ItemHolderInfo setFrom(@NonNull RecyclerView.ViewHolder paramViewHolder)
      {
        return setFrom(paramViewHolder, 0);
      }
      
      @NonNull
      public ItemHolderInfo setFrom(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
      {
        paramViewHolder = paramViewHolder.itemView;
        this.left = paramViewHolder.getLeft();
        this.top = paramViewHolder.getTop();
        this.right = paramViewHolder.getRight();
        this.bottom = paramViewHolder.getBottom();
        return this;
      }
    }
  }
  
  private class ItemAnimatorRestoreListener
    implements RecyclerView.ItemAnimator.ItemAnimatorListener
  {
    ItemAnimatorRestoreListener() {}
    
    public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      paramViewHolder.setIsRecyclable(true);
      if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null)) {
        paramViewHolder.mShadowedHolder = null;
      }
      paramViewHolder.mShadowingHolder = null;
      if ((!paramViewHolder.shouldBeKeptAsChild()) && (!RecyclerView.this.removeAnimatingView(paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached())) {
        RecyclerView.this.removeDetachedView(paramViewHolder.itemView, false);
      }
    }
  }
  
  public static abstract class ItemDecoration
  {
    @Deprecated
    public void getItemOffsets(@NonNull Rect paramRect, int paramInt, @NonNull RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
    }
    
    @Deprecated
    public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
    
    public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      onDraw(paramCanvas, paramRecyclerView);
    }
    
    @Deprecated
    public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
    
    public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      onDrawOver(paramCanvas, paramRecyclerView);
    }
  }
  
  public static abstract class LayoutManager
  {
    boolean mAutoMeasure;
    ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    ViewBoundsCheck mHorizontalBoundCheck;
    private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
    boolean mIsAttachedToWindow;
    private boolean mItemPrefetchEnabled;
    private boolean mMeasurementCacheEnabled;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations;
    @Nullable
    RecyclerView.SmoothScroller mSmoothScroller;
    ViewBoundsCheck mVerticalBoundCheck;
    private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
    private int mWidth;
    private int mWidthMode;
    
    public LayoutManager()
    {
      ViewBoundsCheck.Callback local1 = new ViewBoundsCheck.Callback()
      {
        public View getChildAt(int paramAnonymousInt)
        {
          return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        }
        
        public int getChildEnd(View paramAnonymousView)
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
          return RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView) + localLayoutParams.rightMargin;
        }
        
        public int getChildStart(View paramAnonymousView)
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
          return RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView) - localLayoutParams.leftMargin;
        }
        
        public int getParentEnd()
        {
          return RecyclerView.LayoutManager.this.getWidth() - RecyclerView.LayoutManager.this.getPaddingRight();
        }
        
        public int getParentStart()
        {
          return RecyclerView.LayoutManager.this.getPaddingLeft();
        }
      };
      this.mHorizontalBoundCheckCallback = local1;
      ViewBoundsCheck.Callback local2 = new ViewBoundsCheck.Callback()
      {
        public View getChildAt(int paramAnonymousInt)
        {
          return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
        }
        
        public int getChildEnd(View paramAnonymousView)
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
          return RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView) + localLayoutParams.bottomMargin;
        }
        
        public int getChildStart(View paramAnonymousView)
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
          return RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView) - localLayoutParams.topMargin;
        }
        
        public int getParentEnd()
        {
          return RecyclerView.LayoutManager.this.getHeight() - RecyclerView.LayoutManager.this.getPaddingBottom();
        }
        
        public int getParentStart()
        {
          return RecyclerView.LayoutManager.this.getPaddingTop();
        }
      };
      this.mVerticalBoundCheckCallback = local2;
      this.mHorizontalBoundCheck = new ViewBoundsCheck(local1);
      this.mVerticalBoundCheck = new ViewBoundsCheck(local2);
      this.mRequestedSimpleAnimations = false;
      this.mIsAttachedToWindow = false;
      this.mAutoMeasure = false;
      this.mMeasurementCacheEnabled = true;
      this.mItemPrefetchEnabled = true;
    }
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramBoolean) && (!localViewHolder.isRemoved())) {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      } else {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      }
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap()))
      {
        Object localObject;
        if (paramView.getParent() == this.mRecyclerView)
        {
          int i = this.mChildHelper.indexOfChild(paramView);
          int j = paramInt;
          if (paramInt == -1) {
            j = this.mChildHelper.getChildCount();
          }
          if (i != -1)
          {
            if (i != j) {
              this.mRecyclerView.mLayout.moveView(i, j);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            ((StringBuilder)localObject).append(this.mRecyclerView.indexOfChild(paramView));
            ((StringBuilder)localObject).append(this.mRecyclerView.exceptionLabel());
            throw new IllegalStateException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.mChildHelper.addView(paramView, paramInt, false);
          localLayoutParams.mInsetsDirty = true;
          localObject = this.mSmoothScroller;
          if ((localObject != null) && (((RecyclerView.SmoothScroller)localObject).isRunning())) {
            this.mSmoothScroller.onChildAttachedToWindow(paramView);
          }
        }
      }
      else
      {
        if (localViewHolder.isScrap()) {
          localViewHolder.unScrap();
        } else {
          localViewHolder.clearReturnedFromScrapFlag();
        }
        this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      if (localLayoutParams.mPendingInvalidate)
      {
        localViewHolder.itemView.invalidate();
        localLayoutParams.mPendingInvalidate = false;
      }
    }
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (i != Integer.MIN_VALUE)
      {
        if (i != 1073741824) {
          paramInt1 = Math.max(paramInt2, paramInt3);
        }
        return paramInt1;
      }
      return Math.min(paramInt1, Math.max(paramInt2, paramInt3));
    }
    
    private void detachViewInternal(int paramInt, @NonNull View paramView)
    {
      this.mChildHelper.detachViewFromParent(paramInt);
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      paramInt3 = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean)
      {
        if (paramInt4 < 0)
        {
          if (paramInt4 != -1) {
            break label102;
          }
          paramInt1 = paramInt2;
          if (paramInt2 == Integer.MIN_VALUE) {
            break label65;
          }
          if (paramInt2 == 0) {
            break label102;
          }
          paramInt1 = paramInt2;
          if (paramInt2 == 1073741824) {
            break label65;
          }
          break label102;
        }
      }
      else {
        if (paramInt4 < 0) {
          break label58;
        }
      }
      paramInt1 = 1073741824;
      break label106;
      label58:
      if (paramInt4 == -1) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        label65:
        paramInt4 = paramInt3;
        break label106;
        if (paramInt4 != -2) {
          break;
        }
        if ((paramInt2 != Integer.MIN_VALUE) && (paramInt2 != 1073741824)) {
          paramInt1 = 0;
        } else {
          paramInt1 = Integer.MIN_VALUE;
        }
      }
      label102:
      paramInt1 = 0;
      paramInt4 = 0;
      label106:
      return View.MeasureSpec.makeMeasureSpec(paramInt4, paramInt1);
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = 0;
      paramInt2 = Math.max(0, paramInt1 - paramInt2);
      if (paramBoolean)
      {
        if (paramInt3 < 0)
        {
          paramInt3 = 0;
          paramInt1 = i;
          break label65;
        }
      }
      else {
        if (paramInt3 < 0) {
          break label40;
        }
      }
      paramInt1 = 1073741824;
      break label65;
      label40:
      if (paramInt3 == -1) {}
      for (paramInt1 = 1073741824;; paramInt1 = Integer.MIN_VALUE)
      {
        paramInt3 = paramInt2;
        break label65;
        if (paramInt3 != -2) {
          break;
        }
      }
      label65:
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
    }
    
    private int[] getChildRectangleOnScreenScrollAmount(View paramView, Rect paramRect)
    {
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int m = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      int i2 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int i3 = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i4 = paramRect.width();
      int i5 = paramRect.height();
      int i6 = i2 - i;
      i = Math.min(0, i6);
      int i7 = i3 - j;
      j = Math.min(0, i7);
      m = i4 + i2 - (k - m);
      i2 = Math.max(0, m);
      i1 = Math.max(0, i5 + i3 - (n - i1));
      if (getLayoutDirection() == 1)
      {
        if (i2 != 0) {
          i = i2;
        } else {
          i = Math.max(i, m);
        }
      }
      else if (i == 0) {
        i = Math.min(i6, i2);
      }
      if (j == 0) {
        j = Math.min(i7, i1);
      }
      return new int[] { i, j };
    }
    
    public static Properties getProperties(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      Properties localProperties = new Properties();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      localProperties.orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      localProperties.spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      localProperties.reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      localProperties.stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return localProperties;
    }
    
    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      View localView = paramRecyclerView.getFocusedChild();
      if (localView == null) {
        return false;
      }
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int m = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      paramRecyclerView = this.mRecyclerView.mTempRect;
      getDecoratedBoundsWithMargins(localView, paramRecyclerView);
      return (paramRecyclerView.left - paramInt1 < k - m) && (paramRecyclerView.right - paramInt1 > i) && (paramRecyclerView.top - paramInt2 < n - i1) && (paramRecyclerView.bottom - paramInt2 > j);
    }
    
    private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      boolean bool1 = false;
      boolean bool2 = false;
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        return false;
      }
      if (i != Integer.MIN_VALUE)
      {
        if (i != 0)
        {
          if (i != 1073741824) {
            return false;
          }
          if (paramInt2 == paramInt1) {
            bool2 = true;
          }
          return bool2;
        }
        return true;
      }
      bool2 = bool1;
      if (paramInt2 >= paramInt1) {
        bool2 = true;
      }
      return bool2;
    }
    
    private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.shouldIgnore()) {
        return;
      }
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!this.mRecyclerView.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
      }
      else
      {
        detachViewAt(paramInt);
        paramRecycler.scrapView(paramView);
        this.mRecyclerView.mViewInfoStore.onViewDetached(localViewHolder);
      }
    }
    
    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }
    
    public void addDisappearingView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, true);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, false);
    }
    
    public void assertInLayoutOrScroll(String paramString)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.assertInLayoutOrScroll(paramString);
      }
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.assertNotInLayoutOrScroll(paramString);
      }
    }
    
    public void attachView(@NonNull View paramView)
    {
      attachView(paramView, -1);
    }
    
    public void attachView(@NonNull View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public void attachView(@NonNull View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isRemoved()) {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      } else {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      }
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
    }
    
    public void calculateItemDecorationsForChild(@NonNull View paramView, @NonNull Rect paramRect)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(localRecyclerView.getItemDecorInsetsForChild(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      boolean bool;
      if (paramLayoutParams != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
    
    public void collectInitialPrefetchPositions(int paramInt, LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
    
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public void detachAndScrapAttachedViews(@NonNull RecyclerView.Recycler paramRecycler)
    {
      for (int i = getChildCount() - 1; i >= 0; i--) {
        scrapOrRecycleView(paramRecycler, i, getChildAt(i));
      }
    }
    
    public void detachAndScrapView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(@NonNull View paramView)
    {
      int i = this.mChildHelper.indexOfChild(paramView);
      if (i >= 0) {
        detachViewInternal(i, paramView);
      }
    }
    
    public void detachViewAt(int paramInt)
    {
      detachViewInternal(paramInt, getChildAt(paramInt));
    }
    
    void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
    {
      this.mIsAttachedToWindow = true;
      onAttachedToWindow(paramRecyclerView);
    }
    
    void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      this.mIsAttachedToWindow = false;
      onDetachedFromWindow(paramRecyclerView, paramRecycler);
    }
    
    public void endAnimation(View paramView)
    {
      RecyclerView.ItemAnimator localItemAnimator = this.mRecyclerView.mItemAnimator;
      if (localItemAnimator != null) {
        localItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
      }
    }
    
    @Nullable
    public View findContainingItemView(@NonNull View paramView)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView == null) {
        return null;
      }
      paramView = localRecyclerView.findContainingItemView(paramView);
      if (paramView == null) {
        return null;
      }
      if (this.mChildHelper.isHidden(paramView)) {
        return null;
      }
      return paramView;
    }
    
    @Nullable
    public View findViewByPosition(int paramInt)
    {
      int i = getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = getChildAt(j);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if ((localViewHolder != null) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.shouldIgnore()) && ((this.mRecyclerView.mState.isPreLayout()) || (!localViewHolder.isRemoved()))) {
          return localView;
        }
      }
      return null;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public int getBaseline()
    {
      return -1;
    }
    
    public int getBottomDecorationHeight(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
    }
    
    @Nullable
    public View getChildAt(int paramInt)
    {
      Object localObject = this.mChildHelper;
      if (localObject != null) {
        localObject = ((ChildHelper)localObject).getChildAt(paramInt);
      } else {
        localObject = null;
      }
      return (View)localObject;
    }
    
    public int getChildCount()
    {
      ChildHelper localChildHelper = this.mChildHelper;
      int i;
      if (localChildHelper != null) {
        i = localChildHelper.getChildCount();
      } else {
        i = 0;
      }
      return i;
    }
    
    public boolean getClipToPadding()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      boolean bool;
      if ((localRecyclerView != null) && (localRecyclerView.mClipToPadding)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return -1;
    }
    
    public int getDecoratedBottom(@NonNull View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }
    
    public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
    {
      RecyclerView.getDecoratedBoundsWithMarginsInt(paramView, paramRect);
    }
    
    public int getDecoratedLeft(@NonNull View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }
    
    public int getDecoratedMeasuredHeight(@NonNull View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
    }
    
    public int getDecoratedMeasuredWidth(@NonNull View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredWidth() + localRect.left + localRect.right;
    }
    
    public int getDecoratedRight(@NonNull View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }
    
    public int getDecoratedTop(@NonNull View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }
    
    @Nullable
    public View getFocusedChild()
    {
      Object localObject = this.mRecyclerView;
      if (localObject == null) {
        return null;
      }
      localObject = ((ViewGroup)localObject).getFocusedChild();
      if ((localObject != null) && (!this.mChildHelper.isHidden((View)localObject))) {
        return (View)localObject;
      }
      return null;
    }
    
    @Px
    public int getHeight()
    {
      return this.mHeight;
    }
    
    public int getHeightMode()
    {
      return this.mHeightMode;
    }
    
    public int getItemCount()
    {
      Object localObject = this.mRecyclerView;
      if (localObject != null) {
        localObject = ((RecyclerView)localObject).getAdapter();
      } else {
        localObject = null;
      }
      int i;
      if (localObject != null) {
        i = ((RecyclerView.Adapter)localObject).getItemCount();
      } else {
        i = 0;
      }
      return i;
    }
    
    public int getItemViewType(@NonNull View paramView)
    {
      return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
    }
    
    public int getLayoutDirection()
    {
      return ViewCompat.getLayoutDirection(this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
    }
    
    @Px
    public int getMinimumHeight()
    {
      return ViewCompat.getMinimumHeight(this.mRecyclerView);
    }
    
    @Px
    public int getMinimumWidth()
    {
      return ViewCompat.getMinimumWidth(this.mRecyclerView);
    }
    
    @Px
    public int getPaddingBottom()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = localRecyclerView.getPaddingBottom();
      } else {
        i = 0;
      }
      return i;
    }
    
    @Px
    public int getPaddingEnd()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = ViewCompat.getPaddingEnd(localRecyclerView);
      } else {
        i = 0;
      }
      return i;
    }
    
    @Px
    public int getPaddingLeft()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = localRecyclerView.getPaddingLeft();
      } else {
        i = 0;
      }
      return i;
    }
    
    @Px
    public int getPaddingRight()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = localRecyclerView.getPaddingRight();
      } else {
        i = 0;
      }
      return i;
    }
    
    @Px
    public int getPaddingStart()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = ViewCompat.getPaddingStart(localRecyclerView);
      } else {
        i = 0;
      }
      return i;
    }
    
    @Px
    public int getPaddingTop()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      int i;
      if (localRecyclerView != null) {
        i = localRecyclerView.getPaddingTop();
      } else {
        i = 0;
      }
      return i;
    }
    
    public int getPosition(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
    }
    
    public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return -1;
    }
    
    public int getSelectionModeForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
    }
    
    public void getTransformedBoundingBox(@NonNull View paramView, boolean paramBoolean, @NonNull Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
        paramRect.set(-((Rect)localObject).left, -((Rect)localObject).top, paramView.getWidth() + ((Rect)localObject).right, paramView.getHeight() + ((Rect)localObject).bottom);
      }
      else
      {
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
      if (this.mRecyclerView != null)
      {
        Matrix localMatrix = paramView.getMatrix();
        if ((localMatrix != null) && (!localMatrix.isIdentity()))
        {
          localObject = this.mRecyclerView.mTempRectF;
          ((RectF)localObject).set(paramRect);
          localMatrix.mapRect((RectF)localObject);
          paramRect.set((int)Math.floor(((RectF)localObject).left), (int)Math.floor(((RectF)localObject).top), (int)Math.ceil(((RectF)localObject).right), (int)Math.ceil(((RectF)localObject).bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    @Px
    public int getWidth()
    {
      return this.mWidth;
    }
    
    public int getWidthMode()
    {
      return this.mWidthMode;
    }
    
    boolean hasFlexibleChildInBothOrientations()
    {
      int i = getChildCount();
      for (int j = 0; j < i; j++)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(j).getLayoutParams();
        if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
          return true;
        }
      }
      return false;
    }
    
    public boolean hasFocus()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      boolean bool;
      if ((localRecyclerView != null) && (localRecyclerView.hasFocus())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void ignoreView(@NonNull View paramView)
    {
      ViewParent localViewParent = paramView.getParent();
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((localViewParent == localRecyclerView) && (localRecyclerView.indexOfChild(paramView) != -1))
      {
        paramView = RecyclerView.getChildViewHolderInt(paramView);
        paramView.addFlags(128);
        this.mRecyclerView.mViewInfoStore.removeViewHolder(paramView);
        return;
      }
      paramView = new StringBuilder();
      paramView.append("View should be fully attached to be ignored");
      paramView.append(this.mRecyclerView.exceptionLabel());
      throw new IllegalArgumentException(paramView.toString());
    }
    
    public boolean isAttachedToWindow()
    {
      return this.mIsAttachedToWindow;
    }
    
    public boolean isAutoMeasureEnabled()
    {
      return this.mAutoMeasure;
    }
    
    public boolean isFocused()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      boolean bool;
      if ((localRecyclerView != null) && (localRecyclerView.isFocused())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final boolean isItemPrefetchEnabled()
    {
      return this.mItemPrefetchEnabled;
    }
    
    public boolean isLayoutHierarchical(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled()
    {
      return this.mMeasurementCacheEnabled;
    }
    
    public boolean isSmoothScrolling()
    {
      RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
      boolean bool;
      if ((localSmoothScroller != null) && (localSmoothScroller.isRunning())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isViewPartiallyVisible(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mHorizontalBoundCheck.isViewWithinBoundFlags(paramView, 24579)) && (this.mVerticalBoundCheck.isViewWithinBoundFlags(paramView, 24579))) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if (paramBoolean1) {
        return paramBoolean2;
      }
      return paramBoolean2 ^ true;
    }
    
    public void layoutDecorated(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.mDecorInsets;
      paramView.layout(paramInt1 + localRect.left + localLayoutParams.leftMargin, paramInt2 + localRect.top + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(@NonNull View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int i = localRect.left;
      int j = localRect.right;
      int k = localRect.top;
      int m = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + (paramInt1 + (i + j)), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + (paramInt2 + (k + m)), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void measureChildWithMargins(@NonNull View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int i = localRect.left;
      int j = localRect.right;
      int k = localRect.top;
      int m = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (i + j)), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (k + m)), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void moveView(int paramInt1, int paramInt2)
    {
      Object localObject = getChildAt(paramInt1);
      if (localObject != null)
      {
        detachViewAt(paramInt1);
        attachView((View)localObject, paramInt2);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot move a child from non-existing index:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(this.mRecyclerView.toString());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public void offsetChildrenHorizontal(@Px int paramInt)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.offsetChildrenHorizontal(paramInt);
      }
    }
    
    public void offsetChildrenVertical(@Px int paramInt)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.offsetChildrenVertical(paramInt);
      }
    }
    
    public void onAdapterChanged(@Nullable RecyclerView.Adapter paramAdapter1, @Nullable RecyclerView.Adapter paramAdapter2) {}
    
    public boolean onAddFocusables(@NonNull RecyclerView paramRecyclerView, @NonNull ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    @CallSuper
    public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
    
    @CallSuper
    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      onDetachedFromWindow(paramRecyclerView);
    }
    
    @Nullable
    public View onFocusSearchFailed(@NonNull View paramView, int paramInt, @NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      onInitializeAccessibilityEvent(localRecyclerView.mRecycler, localRecyclerView.mState, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityEvent paramAccessibilityEvent)
    {
      paramRecycler = this.mRecyclerView;
      if ((paramRecycler != null) && (paramAccessibilityEvent != null))
      {
        boolean bool1 = true;
        boolean bool2 = bool1;
        if (!paramRecycler.canScrollVertically(1))
        {
          bool2 = bool1;
          if (!this.mRecyclerView.canScrollVertically(-1))
          {
            bool2 = bool1;
            if (!this.mRecyclerView.canScrollHorizontally(-1)) {
              if (this.mRecyclerView.canScrollHorizontally(1)) {
                bool2 = bool1;
              } else {
                bool2 = false;
              }
            }
          }
        }
        paramAccessibilityEvent.setScrollable(bool2);
        paramRecycler = this.mRecyclerView.mAdapter;
        if (paramRecycler != null) {
          paramAccessibilityEvent.setItemCount(paramRecycler.getItemCount());
        }
      }
    }
    
    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      onInitializeAccessibilityNodeInfo(localRecyclerView.mRecycler, localRecyclerView.mState, paramAccessibilityNodeInfoCompat);
    }
    
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      Object localObject = RecyclerView.getChildViewHolderInt(paramView);
      if ((localObject != null) && (!((RecyclerView.ViewHolder)localObject).isRemoved()) && (!this.mChildHelper.isHidden(((RecyclerView.ViewHolder)localObject).itemView)))
      {
        localObject = this.mRecyclerView;
        onInitializeAccessibilityNodeInfoForItem(((RecyclerView)localObject).mRecycler, ((RecyclerView)localObject).mState, paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
    
    @Nullable
    public View onInterceptFocusSearch(@NonNull View paramView, int paramInt)
    {
      return null;
    }
    
    public void onItemsAdded(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsChanged(@NonNull RecyclerView paramRecyclerView) {}
    
    public void onItemsMoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemsRemoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutCompleted(RecyclerView.State paramState) {}
    
    public void onMeasure(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt1, int paramInt2)
    {
      this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView1, @Nullable View paramView2)
    {
      boolean bool;
      if ((!isSmoothScrolling()) && (!paramRecyclerView.isComputingLayout())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState, @NonNull View paramView1, @Nullable View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    @Nullable
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if (this.mSmoothScroller == paramSmoothScroller) {
        this.mSmoothScroller = null;
      }
    }
    
    boolean performAccessibilityAction(int paramInt, @Nullable Bundle paramBundle)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      return performAccessibilityAction(localRecyclerView.mRecycler, localRecyclerView.mState, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt, @Nullable Bundle paramBundle)
    {
      paramRecycler = this.mRecyclerView;
      if (paramRecycler == null) {
        return false;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192)
        {
          paramInt = 0;
          i = 0;
          break label169;
        }
        if (paramRecycler.canScrollVertically(-1)) {
          paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());
        } else {
          paramInt = 0;
        }
        i = paramInt;
        if (!this.mRecyclerView.canScrollHorizontally(-1)) {
          break label167;
        }
        i = -(getWidth() - getPaddingLeft() - getPaddingRight());
      }
      else
      {
        if (paramRecycler.canScrollVertically(1)) {
          paramInt = getHeight() - getPaddingTop() - getPaddingBottom();
        } else {
          paramInt = 0;
        }
        i = paramInt;
        if (!this.mRecyclerView.canScrollHorizontally(1)) {
          break label167;
        }
        i = getWidth() - getPaddingLeft() - getPaddingRight();
      }
      int j = paramInt;
      paramInt = i;
      int i = j;
      break label169;
      label167:
      paramInt = 0;
      label169:
      if ((i == 0) && (paramInt == 0)) {
        return false;
      }
      this.mRecyclerView.smoothScrollBy(paramInt, i, null, Integer.MIN_VALUE, true);
      return true;
    }
    
    boolean performAccessibilityActionForItem(@NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      return performAccessibilityActionForItem(localRecyclerView.mRecycler, localRecyclerView.mState, paramView, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityActionForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
    {
      return false;
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        ViewCompat.postOnAnimation(localRecyclerView, paramRunnable);
      }
    }
    
    public void removeAllViews()
    {
      for (int i = getChildCount() - 1; i >= 0; i--) {
        this.mChildHelper.removeViewAt(i);
      }
    }
    
    public void removeAndRecycleAllViews(@NonNull RecyclerView.Recycler paramRecycler)
    {
      for (int i = getChildCount() - 1; i >= 0; i--) {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
          removeAndRecycleViewAt(i, paramRecycler);
        }
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
    {
      int i = paramRecycler.getScrapCount();
      for (int j = i - 1; j >= 0; j--)
      {
        View localView = paramRecycler.getScrapViewAt(j);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if (!localViewHolder.shouldIgnore())
        {
          localViewHolder.setIsRecyclable(false);
          if (localViewHolder.isTmpDetached()) {
            this.mRecyclerView.removeDetachedView(localView, false);
          }
          RecyclerView.ItemAnimator localItemAnimator = this.mRecyclerView.mItemAnimator;
          if (localItemAnimator != null) {
            localItemAnimator.endAnimation(localViewHolder);
          }
          localViewHolder.setIsRecyclable(true);
          paramRecycler.quickRecycleScrapView(localView);
        }
      }
      paramRecycler.clearScrap();
      if (i > 0) {
        this.mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
    {
      removeView(paramView);
      paramRecycler.recycleView(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramRecycler.recycleView(localView);
    }
    
    public boolean removeCallbacks(Runnable paramRunnable)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void removeDetachedView(@NonNull View paramView)
    {
      this.mRecyclerView.removeDetachedView(paramView, false);
    }
    
    public void removeView(View paramView)
    {
      this.mChildHelper.removeView(paramView);
    }
    
    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.mChildHelper.removeViewAt(paramInt);
      }
    }
    
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramView = getChildRectangleOnScreenScrollAmount(paramView, paramRect);
      int i = paramView[0];
      int j = paramView[1];
      if (((paramBoolean2) && (!isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j))) || ((i == 0) && (j == 0))) {
        return false;
      }
      if (paramBoolean1) {
        paramRecyclerView.scrollBy(i, j);
      } else {
        paramRecyclerView.smoothScrollBy(i, j);
      }
      return true;
    }
    
    public void requestLayout()
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.requestLayout();
      }
    }
    
    public void requestSimpleAnimationsInNextLayout()
    {
      this.mRequestedSimpleAnimations = true;
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    @Deprecated
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      this.mAutoMeasure = paramBoolean;
    }
    
    void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public final void setItemPrefetchEnabled(boolean paramBoolean)
    {
      if (paramBoolean != this.mItemPrefetchEnabled)
      {
        this.mItemPrefetchEnabled = paramBoolean;
        this.mPrefetchMaxCountObserved = 0;
        RecyclerView localRecyclerView = this.mRecyclerView;
        if (localRecyclerView != null) {
          localRecyclerView.mRecycler.updateViewCacheSize();
        }
      }
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
      this.mWidthMode = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      this.mHeightMode = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.mHeight = 0;
      }
    }
    
    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      this.mRecyclerView.setMeasuredDimension(paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i + j + k, getMinimumWidth()), chooseSize(paramInt2, m + n + i1, getMinimumHeight()));
    }
    
    void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
    {
      int i = getChildCount();
      if (i == 0)
      {
        this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int j = 0;
      int k = Integer.MIN_VALUE;
      int m = Integer.MIN_VALUE;
      int n = Integer.MAX_VALUE;
      int i2;
      for (int i1 = Integer.MAX_VALUE; j < i; i1 = i2)
      {
        View localView = getChildAt(j);
        Rect localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
        i2 = localRect.left;
        int i3 = n;
        if (i2 < n) {
          i3 = i2;
        }
        i2 = localRect.right;
        n = k;
        if (i2 > k) {
          n = i2;
        }
        k = localRect.top;
        i2 = i1;
        if (k < i1) {
          i2 = k;
        }
        k = localRect.bottom;
        i1 = m;
        if (k > m) {
          i1 = k;
        }
        j++;
        k = n;
        m = i1;
        n = i3;
      }
      this.mRecyclerView.mTempRect.set(n, i1, k, m);
      setMeasuredDimension(this.mRecyclerView.mTempRect, paramInt1, paramInt2);
    }
    
    public void setMeasurementCacheEnabled(boolean paramBoolean)
    {
      this.mMeasurementCacheEnabled = paramBoolean;
    }
    
    void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.mRecyclerView = null;
        this.mChildHelper = null;
        this.mWidth = 0;
        this.mHeight = 0;
      }
      else
      {
        this.mRecyclerView = paramRecyclerView;
        this.mChildHelper = paramRecyclerView.mChildHelper;
        this.mWidth = paramRecyclerView.getWidth();
        this.mHeight = paramRecyclerView.getHeight();
      }
      this.mWidthMode = 1073741824;
      this.mHeightMode = 1073741824;
    }
    
    boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      boolean bool;
      if ((!paramView.isLayoutRequested()) && (this.mMeasurementCacheEnabled) && (isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) && (isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    boolean shouldMeasureTwice()
    {
      return false;
    }
    
    boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      boolean bool;
      if ((this.mMeasurementCacheEnabled) && (isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) && (isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
      if ((localSmoothScroller != null) && (paramSmoothScroller != localSmoothScroller) && (localSmoothScroller.isRunning())) {
        this.mSmoothScroller.stop();
      }
      this.mSmoothScroller = paramSmoothScroller;
      paramSmoothScroller.start(this.mRecyclerView, this);
    }
    
    public void stopIgnoringView(@NonNull View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.stopIgnoring();
      paramView.resetInternal();
      paramView.addFlags(4);
    }
    
    void stopSmoothScroller()
    {
      RecyclerView.SmoothScroller localSmoothScroller = this.mSmoothScroller;
      if (localSmoothScroller != null) {
        localSmoothScroller.stop();
      }
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public static abstract interface LayoutPrefetchRegistry
    {
      public abstract void addPosition(int paramInt1, int paramInt2);
    }
    
    public static class Properties
    {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect mDecorInsets = new Rect();
    boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.ViewHolder mViewHolder;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getAbsoluteAdapterPosition()
    {
      return this.mViewHolder.getAbsoluteAdapterPosition();
    }
    
    public int getBindingAdapterPosition()
    {
      return this.mViewHolder.getBindingAdapterPosition();
    }
    
    @Deprecated
    public int getViewAdapterPosition()
    {
      return this.mViewHolder.getBindingAdapterPosition();
    }
    
    public int getViewLayoutPosition()
    {
      return this.mViewHolder.getLayoutPosition();
    }
    
    @Deprecated
    public int getViewPosition()
    {
      return this.mViewHolder.getPosition();
    }
    
    public boolean isItemChanged()
    {
      return this.mViewHolder.isUpdated();
    }
    
    public boolean isItemRemoved()
    {
      return this.mViewHolder.isRemoved();
    }
    
    public boolean isViewInvalid()
    {
      return this.mViewHolder.isInvalid();
    }
    
    public boolean viewNeedsUpdate()
    {
      return this.mViewHolder.needsUpdate();
    }
  }
  
  public static abstract interface OnChildAttachStateChangeListener
  {
    public abstract void onChildViewAttachedToWindow(@NonNull View paramView);
    
    public abstract void onChildViewDetachedFromWindow(@NonNull View paramView);
  }
  
  public static abstract class OnFlingListener
  {
    public abstract boolean onFling(int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnItemTouchListener
  {
    public abstract boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
    
    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
    
    public abstract void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
  }
  
  public static abstract class OnScrollListener
  {
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt) {}
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface Orientation {}
  
  public static class RecycledViewPool
  {
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount = 0;
    SparseArray<ScrapData> mScrap = new SparseArray();
    
    private ScrapData getScrapDataForType(int paramInt)
    {
      ScrapData localScrapData1 = (ScrapData)this.mScrap.get(paramInt);
      ScrapData localScrapData2 = localScrapData1;
      if (localScrapData1 == null)
      {
        localScrapData2 = new ScrapData();
        this.mScrap.put(paramInt, localScrapData2);
      }
      return localScrapData2;
    }
    
    void attach()
    {
      this.mAttachCount += 1;
    }
    
    public void clear()
    {
      for (int i = 0; i < this.mScrap.size(); i++) {
        ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap.clear();
      }
    }
    
    void detach()
    {
      this.mAttachCount -= 1;
    }
    
    void factorInBindTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mBindRunningAverageNs = runningAverage(localScrapData.mBindRunningAverageNs, paramLong);
    }
    
    void factorInCreateTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mCreateRunningAverageNs = runningAverage(localScrapData.mCreateRunningAverageNs, paramLong);
    }
    
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int paramInt)
    {
      Object localObject = (ScrapData)this.mScrap.get(paramInt);
      if ((localObject != null) && (!((ScrapData)localObject).mScrapHeap.isEmpty()))
      {
        localObject = ((ScrapData)localObject).mScrapHeap;
        for (paramInt = ((ArrayList)localObject).size() - 1; paramInt >= 0; paramInt--) {
          if (!((RecyclerView.ViewHolder)((ArrayList)localObject).get(paramInt)).isAttachedToTransitionOverlay()) {
            return (RecyclerView.ViewHolder)((ArrayList)localObject).remove(paramInt);
          }
        }
      }
      return null;
    }
    
    public int getRecycledViewCount(int paramInt)
    {
      return getScrapDataForType(paramInt).mScrapHeap.size();
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      if (paramAdapter1 != null) {
        detach();
      }
      if ((!paramBoolean) && (this.mAttachCount == 0)) {
        clear();
      }
      if (paramAdapter2 != null) {
        attach();
      }
    }
    
    public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = paramViewHolder.getItemViewType();
      ArrayList localArrayList = getScrapDataForType(i).mScrapHeap;
      if (((ScrapData)this.mScrap.get(i)).mMaxScrap <= localArrayList.size()) {
        return;
      }
      paramViewHolder.resetInternal();
      localArrayList.add(paramViewHolder);
    }
    
    long runningAverage(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    public void setMaxRecycledViews(int paramInt1, int paramInt2)
    {
      Object localObject = getScrapDataForType(paramInt1);
      ((ScrapData)localObject).mMaxScrap = paramInt2;
      localObject = ((ScrapData)localObject).mScrapHeap;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    int size()
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.mScrap.size(); j = k)
      {
        ArrayList localArrayList = ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap;
        k = j;
        if (localArrayList != null) {
          k = j + localArrayList.size();
        }
        i++;
      }
      return j;
    }
    
    boolean willBindInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mBindRunningAverageNs;
      boolean bool;
      if ((l != 0L) && (paramLong1 + l >= paramLong2)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    boolean willCreateInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mCreateRunningAverageNs;
      boolean bool;
      if ((l != 0L) && (paramLong1 + l >= paramLong2)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    static class ScrapData
    {
      long mBindRunningAverageNs = 0L;
      long mCreateRunningAverageNs = 0L;
      int mMaxScrap = 5;
      final ArrayList<RecyclerView.ViewHolder> mScrapHeap = new ArrayList();
    }
  }
  
  public final class Recycler
  {
    static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap;
    final ArrayList<RecyclerView.ViewHolder> mCachedViews;
    ArrayList<RecyclerView.ViewHolder> mChangedScrap;
    RecyclerView.RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax;
    private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap;
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax;
    
    public Recycler()
    {
      this$1 = new ArrayList();
      this.mAttachedScrap = RecyclerView.this;
      this.mChangedScrap = null;
      this.mCachedViews = new ArrayList();
      this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(RecyclerView.this);
      this.mRequestedCacheMax = 2;
      this.mViewCacheMax = 2;
    }
    
    private void attachAccessibilityDelegateOnBind(RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.this.isAccessibilityEnabled())
      {
        paramViewHolder = paramViewHolder.itemView;
        if (ViewCompat.getImportantForAccessibility(paramViewHolder) == 0) {
          ViewCompat.setImportantForAccessibility(paramViewHolder, 1);
        }
        Object localObject = RecyclerView.this.mAccessibilityDelegate;
        if (localObject == null) {
          return;
        }
        localObject = ((RecyclerViewAccessibilityDelegate)localObject).getItemDelegate();
        if ((localObject instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
          ((RecyclerViewAccessibilityDelegate.ItemDelegate)localObject).saveOriginalDelegate(paramViewHolder);
        }
        ViewCompat.setAccessibilityDelegate(paramViewHolder, (AccessibilityDelegateCompat)localObject);
      }
    }
    
    private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      for (int i = paramViewGroup.getChildCount() - 1; i >= 0; i--)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          invalidateDisplayListInt((ViewGroup)localView, true);
        }
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
      }
      else
      {
        i = paramViewGroup.getVisibility();
        paramViewGroup.setVisibility(4);
        paramViewGroup.setVisibility(i);
      }
    }
    
    private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
    {
      paramViewHolder = paramViewHolder.itemView;
      if ((paramViewHolder instanceof ViewGroup)) {
        invalidateDisplayListInt((ViewGroup)paramViewHolder, false);
      }
    }
    
    private boolean tryBindViewHolderByDeadline(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, long paramLong)
    {
      paramViewHolder.mBindingAdapter = null;
      paramViewHolder.mOwnerRecyclerView = RecyclerView.this;
      int i = paramViewHolder.getItemViewType();
      long l = RecyclerView.this.getNanoTime();
      if ((paramLong != Long.MAX_VALUE) && (!this.mRecyclerPool.willBindInTime(i, l, paramLong))) {
        return false;
      }
      RecyclerView.this.mAdapter.bindViewHolder(paramViewHolder, paramInt1);
      paramLong = RecyclerView.this.getNanoTime();
      this.mRecyclerPool.factorInBindTime(paramViewHolder.getItemViewType(), paramLong - l);
      attachAccessibilityDelegateOnBind(paramViewHolder);
      if (RecyclerView.this.mState.isPreLayout()) {
        paramViewHolder.mPreLayoutPosition = paramInt2;
      }
      return true;
    }
    
    void addViewHolderToRecycledViewPool(@NonNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
    {
      RecyclerView.clearNestedRecyclerViewIfNotNested(paramViewHolder);
      View localView = paramViewHolder.itemView;
      Object localObject = RecyclerView.this.mAccessibilityDelegate;
      if (localObject != null)
      {
        localObject = ((RecyclerViewAccessibilityDelegate)localObject).getItemDelegate();
        if ((localObject instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
          localObject = ((RecyclerViewAccessibilityDelegate.ItemDelegate)localObject).getAndRemoveOriginalDelegateForItem(localView);
        } else {
          localObject = null;
        }
        ViewCompat.setAccessibilityDelegate(localView, (AccessibilityDelegateCompat)localObject);
      }
      if (paramBoolean) {
        dispatchViewRecycled(paramViewHolder);
      }
      paramViewHolder.mBindingAdapter = null;
      paramViewHolder.mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(paramViewHolder);
    }
    
    public void bindViewToPosition(@NonNull View paramView, int paramInt)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder != null)
      {
        int i = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
        if ((i >= 0) && (i < RecyclerView.this.mAdapter.getItemCount()))
        {
          tryBindViewHolderByDeadline(localViewHolder, i, paramInt, Long.MAX_VALUE);
          paramView = localViewHolder.itemView.getLayoutParams();
          if (paramView == null)
          {
            paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
            localViewHolder.itemView.setLayoutParams(paramView);
          }
          else if (!RecyclerView.this.checkLayoutParams(paramView))
          {
            paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(paramView);
            localViewHolder.itemView.setLayoutParams(paramView);
          }
          else
          {
            paramView = (RecyclerView.LayoutParams)paramView;
          }
          boolean bool = true;
          paramView.mInsetsDirty = true;
          paramView.mViewHolder = localViewHolder;
          if (localViewHolder.itemView.getParent() != null) {
            bool = false;
          }
          paramView.mPendingInvalidate = bool;
          return;
        }
        paramView = new StringBuilder();
        paramView.append("Inconsistency detected. Invalid item position ");
        paramView.append(paramInt);
        paramView.append("(offset:");
        paramView.append(i);
        paramView.append(").state:");
        paramView.append(RecyclerView.this.mState.getItemCount());
        paramView.append(RecyclerView.this.exceptionLabel());
        throw new IndexOutOfBoundsException(paramView.toString());
      }
      paramView = new StringBuilder();
      paramView.append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
      paramView.append(RecyclerView.this.exceptionLabel());
      throw new IllegalArgumentException(paramView.toString());
    }
    
    public void clear()
    {
      this.mAttachedScrap.clear();
      recycleAndClearCachedViews();
    }
    
    void clearOldPositions()
    {
      int i = this.mCachedViews.size();
      int j = 0;
      for (int k = 0; k < i; k++) {
        ((RecyclerView.ViewHolder)this.mCachedViews.get(k)).clearOldPosition();
      }
      i = this.mAttachedScrap.size();
      for (k = 0; k < i; k++) {
        ((RecyclerView.ViewHolder)this.mAttachedScrap.get(k)).clearOldPosition();
      }
      ArrayList localArrayList = this.mChangedScrap;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        for (k = j; k < i; k++) {
          ((RecyclerView.ViewHolder)this.mChangedScrap.get(k)).clearOldPosition();
        }
      }
    }
    
    void clearScrap()
    {
      this.mAttachedScrap.clear();
      ArrayList localArrayList = this.mChangedScrap;
      if (localArrayList != null) {
        localArrayList.clear();
      }
    }
    
    public int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.mState.getItemCount()))
      {
        if (!RecyclerView.this.mState.isPreLayout()) {
          return paramInt;
        }
        return RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid position ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". State item count is ");
      localStringBuilder.append(RecyclerView.this.mState.getItemCount());
      localStringBuilder.append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void dispatchViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      Object localObject = RecyclerView.this.mRecyclerListener;
      if (localObject != null) {
        ((RecyclerView.RecyclerListener)localObject).onViewRecycled(paramViewHolder);
      }
      int i = RecyclerView.this.mRecyclerListeners.size();
      for (int j = 0; j < i; j++) {
        ((RecyclerView.RecyclerListener)RecyclerView.this.mRecyclerListeners.get(j)).onViewRecycled(paramViewHolder);
      }
      localObject = RecyclerView.this.mAdapter;
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).onViewRecycled(paramViewHolder);
      }
      localObject = RecyclerView.this;
      if (((RecyclerView)localObject).mState != null) {
        ((RecyclerView)localObject).mViewInfoStore.removeViewHolder(paramViewHolder);
      }
    }
    
    RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
    {
      Object localObject = this.mChangedScrap;
      if (localObject != null)
      {
        int i = ((ArrayList)localObject).size();
        if (i != 0)
        {
          int j = 0;
          for (int k = 0; k < i; k++)
          {
            localObject = (RecyclerView.ViewHolder)this.mChangedScrap.get(k);
            if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject).getLayoutPosition() == paramInt))
            {
              ((RecyclerView.ViewHolder)localObject).addFlags(32);
              return (RecyclerView.ViewHolder)localObject;
            }
          }
          if (RecyclerView.this.mAdapter.hasStableIds())
          {
            paramInt = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
            if ((paramInt > 0) && (paramInt < RecyclerView.this.mAdapter.getItemCount()))
            {
              long l = RecyclerView.this.mAdapter.getItemId(paramInt);
              for (paramInt = j; paramInt < i; paramInt++)
              {
                localObject = (RecyclerView.ViewHolder)this.mChangedScrap.get(paramInt);
                if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject).getItemId() == l))
                {
                  ((RecyclerView.ViewHolder)localObject).addFlags(32);
                  return (RecyclerView.ViewHolder)localObject;
                }
              }
            }
          }
        }
      }
      return null;
    }
    
    RecyclerView.RecycledViewPool getRecycledViewPool()
    {
      if (this.mRecyclerPool == null) {
        this.mRecyclerPool = new RecyclerView.RecycledViewPool();
      }
      return this.mRecyclerPool;
    }
    
    int getScrapCount()
    {
      return this.mAttachedScrap.size();
    }
    
    @NonNull
    public List<RecyclerView.ViewHolder> getScrapList()
    {
      return this.mUnmodifiableAttachedScrap;
    }
    
    RecyclerView.ViewHolder getScrapOrCachedViewForId(long paramLong, int paramInt, boolean paramBoolean)
    {
      RecyclerView.ViewHolder localViewHolder;
      for (int i = this.mAttachedScrap.size() - 1; i >= 0; i--)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
        if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            localViewHolder.addFlags(32);
            if ((localViewHolder.isRemoved()) && (!RecyclerView.this.mState.isPreLayout())) {
              localViewHolder.setFlags(2, 14);
            }
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            this.mAttachedScrap.remove(i);
            RecyclerView.this.removeDetachedView(localViewHolder.itemView, false);
            quickRecycleScrapView(localViewHolder.itemView);
          }
        }
      }
      for (i = this.mCachedViews.size() - 1; i >= 0; i--)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.isAttachedToTransitionOverlay()))
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            if (!paramBoolean) {
              this.mCachedViews.remove(i);
            }
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            recycleCachedViewAt(i);
            return null;
          }
        }
      }
      return null;
    }
    
    RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int paramInt, boolean paramBoolean)
    {
      int i = this.mAttachedScrap.size();
      int j = 0;
      RecyclerView.ViewHolder localViewHolder;
      for (int k = 0; k < i; k++)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(k);
        if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && ((RecyclerView.this.mState.mInPreLayout) || (!localViewHolder.isRemoved())))
        {
          localViewHolder.addFlags(32);
          return localViewHolder;
        }
      }
      if (!paramBoolean)
      {
        Object localObject = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(paramInt);
        if (localObject != null)
        {
          localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
          RecyclerView.this.mChildHelper.unhide((View)localObject);
          paramInt = RecyclerView.this.mChildHelper.indexOfChild((View)localObject);
          if (paramInt != -1)
          {
            RecyclerView.this.mChildHelper.detachViewFromParent(paramInt);
            scrapView((View)localObject);
            localViewHolder.addFlags(8224);
            return localViewHolder;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
          ((StringBuilder)localObject).append(localViewHolder);
          ((StringBuilder)localObject).append(RecyclerView.this.exceptionLabel());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      i = this.mCachedViews.size();
      for (k = j; k < i; k++)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(k);
        if ((!localViewHolder.isInvalid()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isAttachedToTransitionOverlay()))
        {
          if (!paramBoolean) {
            this.mCachedViews.remove(k);
          }
          return localViewHolder;
        }
      }
      return null;
    }
    
    View getScrapViewAt(int paramInt)
    {
      return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
    }
    
    @NonNull
    public View getViewForPosition(int paramInt)
    {
      return getViewForPosition(paramInt, false);
    }
    
    View getViewForPosition(int paramInt, boolean paramBoolean)
    {
      return tryGetViewHolderForPositionByDeadline(paramInt, paramBoolean, Long.MAX_VALUE).itemView;
    }
    
    void markItemDecorInsetsDirty()
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(j)).itemView.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.mInsetsDirty = true;
        }
      }
    }
    
    void markKnownViewsInvalid()
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        localObject = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if (localObject != null)
        {
          ((RecyclerView.ViewHolder)localObject).addFlags(6);
          ((RecyclerView.ViewHolder)localObject).addChangePayload(null);
        }
      }
      Object localObject = RecyclerView.this.mAdapter;
      if ((localObject == null) || (!((RecyclerView.Adapter)localObject).hasStableIds())) {
        recycleAndClearCachedViews();
      }
    }
    
    void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
    {
      int i = this.mCachedViews.size();
      for (int j = 0; j < i; j++)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(j);
        if ((localViewHolder != null) && (localViewHolder.mPosition >= paramInt1)) {
          localViewHolder.offsetPosition(paramInt2, false);
        }
      }
    }
    
    void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      if (paramInt1 < paramInt2)
      {
        i = -1;
        j = paramInt1;
        k = paramInt2;
      }
      else
      {
        i = 1;
        k = paramInt1;
        j = paramInt2;
      }
      int m = this.mCachedViews.size();
      for (int n = 0; n < m; n++)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(n);
        if (localViewHolder != null)
        {
          int i1 = localViewHolder.mPosition;
          if ((i1 >= j) && (i1 <= k)) {
            if (i1 == paramInt1) {
              localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
            } else {
              localViewHolder.offsetPosition(i, false);
            }
          }
        }
      }
    }
    
    void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder != null)
        {
          int j = localViewHolder.mPosition;
          if (j >= paramInt1 + paramInt2)
          {
            localViewHolder.offsetPosition(-paramInt2, paramBoolean);
          }
          else if (j >= paramInt1)
          {
            localViewHolder.addFlags(8);
            recycleCachedViewAt(i);
          }
        }
      }
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      clear();
      getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
    }
    
    void quickRecycleScrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.mScrapContainer = null;
      paramView.mInChangeScrap = false;
      paramView.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(paramView);
    }
    
    void recycleAndClearCachedViews()
    {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--) {
        recycleCachedViewAt(i);
      }
      this.mCachedViews.clear();
      if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
      }
    }
    
    void recycleCachedViewAt(int paramInt)
    {
      addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(paramInt), true);
      this.mCachedViews.remove(paramInt);
    }
    
    public void recycleView(@NonNull View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isTmpDetached()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localViewHolder.isScrap()) {
        localViewHolder.unScrap();
      } else if (localViewHolder.wasReturnedFromScrap()) {
        localViewHolder.clearReturnedFromScrapFlag();
      }
      recycleViewHolderInternal(localViewHolder);
      if ((RecyclerView.this.mItemAnimator != null) && (!localViewHolder.isRecyclable())) {
        RecyclerView.this.mItemAnimator.endAnimation(localViewHolder);
      }
    }
    
    void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool1 = paramViewHolder.isScrap();
      boolean bool2 = false;
      int i = 0;
      int j = 1;
      if ((!bool1) && (paramViewHolder.itemView.getParent() == null))
      {
        if (!paramViewHolder.isTmpDetached())
        {
          if (!paramViewHolder.shouldIgnore())
          {
            bool2 = paramViewHolder.doesTransientStatePreventRecycling();
            localObject = RecyclerView.this.mAdapter;
            int k;
            if ((localObject != null) && (bool2) && (((RecyclerView.Adapter)localObject).onFailedToRecycleView(paramViewHolder))) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              k = i;
              if (paramViewHolder.isRecyclable()) {}
            }
            for (;;)
            {
              i = 0;
              break;
              if ((this.mViewCacheMax > 0) && (!paramViewHolder.hasAnyOfTheFlags(526)))
              {
                i = this.mCachedViews.size();
                k = i;
                if (i >= this.mViewCacheMax)
                {
                  k = i;
                  if (i > 0)
                  {
                    recycleCachedViewAt(0);
                    k = i - 1;
                  }
                }
                i = k;
                if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                {
                  i = k;
                  if (k > 0)
                  {
                    i = k;
                    if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(paramViewHolder.mPosition))
                    {
                      k--;
                      while (k >= 0)
                      {
                        i = ((RecyclerView.ViewHolder)this.mCachedViews.get(k)).mPosition;
                        if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(i)) {
                          break;
                        }
                        k--;
                      }
                      i = k + 1;
                    }
                  }
                }
                this.mCachedViews.add(i, paramViewHolder);
                k = 1;
              }
              else
              {
                k = 0;
              }
              if (k == 0)
              {
                addViewHolderToRecycledViewPool(paramViewHolder, true);
                i = j;
                break;
              }
            }
            RecyclerView.this.mViewInfoStore.removeViewHolder(paramViewHolder);
            if ((k == 0) && (i == 0) && (bool2))
            {
              paramViewHolder.mBindingAdapter = null;
              paramViewHolder.mOwnerRecyclerView = null;
            }
            return;
          }
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
          paramViewHolder.append(RecyclerView.this.exceptionLabel());
          throw new IllegalArgumentException(paramViewHolder.toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        ((StringBuilder)localObject).append(paramViewHolder);
        ((StringBuilder)localObject).append(RecyclerView.this.exceptionLabel());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Scrapped or attached views may not be recycled. isScrap:");
      ((StringBuilder)localObject).append(paramViewHolder.isScrap());
      ((StringBuilder)localObject).append(" isAttached:");
      if (paramViewHolder.itemView.getParent() != null) {
        bool2 = true;
      }
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(RecyclerView.this.exceptionLabel());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    void scrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramView.hasAnyOfTheFlags(12)) && (paramView.isUpdated()) && (!RecyclerView.this.canReuseUpdatedViewHolder(paramView)))
      {
        if (this.mChangedScrap == null) {
          this.mChangedScrap = new ArrayList();
        }
        paramView.setScrapContainer(this, true);
        this.mChangedScrap.add(paramView);
      }
      else
      {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.mAdapter.hasStableIds()))
        {
          paramView = new StringBuilder();
          paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
          paramView.append(RecyclerView.this.exceptionLabel());
          throw new IllegalArgumentException(paramView.toString());
        }
        paramView.setScrapContainer(this, false);
        this.mAttachedScrap.add(paramView);
      }
    }
    
    void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
    {
      RecyclerView.RecycledViewPool localRecycledViewPool = this.mRecyclerPool;
      if (localRecycledViewPool != null) {
        localRecycledViewPool.detach();
      }
      this.mRecyclerPool = paramRecycledViewPool;
      if ((paramRecycledViewPool != null) && (RecyclerView.this.getAdapter() != null)) {
        this.mRecyclerPool.attach();
      }
    }
    
    void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
    {
      this.mViewCacheExtension = paramViewCacheExtension;
    }
    
    public void setViewCacheSize(int paramInt)
    {
      this.mRequestedCacheMax = paramInt;
      updateViewCacheSize();
    }
    
    @Nullable
    RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int paramInt, boolean paramBoolean, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.mState.getItemCount()))
      {
        boolean bool1 = RecyclerView.this.mState.isPreLayout();
        boolean bool2 = true;
        if (bool1)
        {
          localObject1 = getChangedScrapViewForPosition(paramInt);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            i = 1;
            localObject2 = localObject1;
            break label70;
          }
        }
        else
        {
          localObject2 = null;
        }
        int i = 0;
        label70:
        localObject1 = localObject2;
        int j = i;
        if (localObject2 == null)
        {
          localObject2 = getScrapOrHiddenOrCachedHolderForPosition(paramInt, paramBoolean);
          localObject1 = localObject2;
          j = i;
          if (localObject2 != null) {
            if (!validateViewHolderForOffsetPosition((RecyclerView.ViewHolder)localObject2))
            {
              if (!paramBoolean)
              {
                ((RecyclerView.ViewHolder)localObject2).addFlags(4);
                if (((RecyclerView.ViewHolder)localObject2).isScrap())
                {
                  RecyclerView.this.removeDetachedView(((RecyclerView.ViewHolder)localObject2).itemView, false);
                  ((RecyclerView.ViewHolder)localObject2).unScrap();
                }
                else if (((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap())
                {
                  ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
                }
                recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
              }
              localObject1 = null;
              j = i;
            }
            else
            {
              j = 1;
              localObject1 = localObject2;
            }
          }
        }
        Object localObject2 = localObject1;
        int k = j;
        if (localObject1 == null)
        {
          k = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
          if ((k >= 0) && (k < RecyclerView.this.mAdapter.getItemCount()))
          {
            int m = RecyclerView.this.mAdapter.getItemViewType(k);
            i = j;
            if (RecyclerView.this.mAdapter.hasStableIds())
            {
              localObject2 = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(k), m, paramBoolean);
              localObject1 = localObject2;
              i = j;
              if (localObject2 != null)
              {
                ((RecyclerView.ViewHolder)localObject2).mPosition = k;
                i = 1;
                localObject1 = localObject2;
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              Object localObject3 = this.mViewCacheExtension;
              localObject2 = localObject1;
              if (localObject3 != null)
              {
                localObject3 = ((RecyclerView.ViewCacheExtension)localObject3).getViewForPositionAndType(this, paramInt, m);
                localObject2 = localObject1;
                if (localObject3 != null)
                {
                  localObject2 = RecyclerView.this.getChildViewHolder((View)localObject3);
                  if (localObject2 != null)
                  {
                    if (((RecyclerView.ViewHolder)localObject2).shouldIgnore())
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                      ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
                      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                    }
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = getRecycledViewPool().getRecycledView(m);
              if (localObject1 != null)
              {
                ((RecyclerView.ViewHolder)localObject1).resetInternal();
                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                  invalidateDisplayListInt((RecyclerView.ViewHolder)localObject1);
                }
              }
            }
            localObject2 = localObject1;
            k = i;
            if (localObject1 == null)
            {
              long l1 = RecyclerView.this.getNanoTime();
              if ((paramLong != Long.MAX_VALUE) && (!this.mRecyclerPool.willCreateInTime(m, l1, paramLong))) {
                return null;
              }
              localObject1 = RecyclerView.this;
              localObject2 = ((RecyclerView)localObject1).mAdapter.createViewHolder((ViewGroup)localObject1, m);
              if (RecyclerView.ALLOW_THREAD_GAP_WORK)
              {
                localObject1 = RecyclerView.findNestedRecyclerView(((RecyclerView.ViewHolder)localObject2).itemView);
                if (localObject1 != null) {
                  ((RecyclerView.ViewHolder)localObject2).mNestedRecyclerView = new WeakReference(localObject1);
                }
              }
              long l2 = RecyclerView.this.getNanoTime();
              this.mRecyclerPool.factorInCreateTime(m, l2 - l1);
              break label738;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("(offset:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(").state:");
            ((StringBuilder)localObject1).append(RecyclerView.this.mState.getItemCount());
            ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
            throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
          }
        }
        i = k;
        label738:
        if ((i != 0) && (!RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
        {
          ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
          if (RecyclerView.this.mState.mRunSimpleAnimations)
          {
            j = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
            localObject1 = RecyclerView.this;
            localObject1 = ((RecyclerView)localObject1).mItemAnimator.recordPreLayoutInformation(((RecyclerView)localObject1).mState, (RecyclerView.ViewHolder)localObject2, j | 0x1000, ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads());
            RecyclerView.this.recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
          }
        }
        if ((RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).isBound())) {
          ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
        } else {
          if ((!((RecyclerView.ViewHolder)localObject2).isBound()) || (((RecyclerView.ViewHolder)localObject2).needsUpdate()) || (((RecyclerView.ViewHolder)localObject2).isInvalid())) {
            break label903;
          }
        }
        paramBoolean = false;
        break label923;
        label903:
        paramBoolean = tryBindViewHolderByDeadline((RecyclerView.ViewHolder)localObject2, RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
        label923:
        localObject1 = ((RecyclerView.ViewHolder)localObject2).itemView.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
          ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
        {
          localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          localObject1 = (RecyclerView.LayoutParams)localObject1;
        }
        ((RecyclerView.LayoutParams)localObject1).mViewHolder = ((RecyclerView.ViewHolder)localObject2);
        if ((i != 0) && (paramBoolean)) {
          paramBoolean = bool2;
        } else {
          paramBoolean = false;
        }
        ((RecyclerView.LayoutParams)localObject1).mPendingInvalidate = paramBoolean;
        return (RecyclerView.ViewHolder)localObject2;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(RecyclerView.this.mState.getItemCount());
      ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
    }
    
    void unscrapView(RecyclerView.ViewHolder paramViewHolder)
    {
      if (paramViewHolder.mInChangeScrap) {
        this.mChangedScrap.remove(paramViewHolder);
      } else {
        this.mAttachedScrap.remove(paramViewHolder);
      }
      paramViewHolder.mScrapContainer = null;
      paramViewHolder.mInChangeScrap = false;
      paramViewHolder.clearReturnedFromScrapFlag();
    }
    
    void updateViewCacheSize()
    {
      RecyclerView.LayoutManager localLayoutManager = RecyclerView.this.mLayout;
      if (localLayoutManager != null) {
        i = localLayoutManager.mPrefetchMaxCountObserved;
      } else {
        i = 0;
      }
      this.mViewCacheMax = (this.mRequestedCacheMax + i);
      for (int i = this.mCachedViews.size() - 1; (i >= 0) && (this.mCachedViews.size() > this.mViewCacheMax); i--) {
        recycleCachedViewAt(i);
      }
    }
    
    boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
    {
      if (paramViewHolder.isRemoved()) {
        return RecyclerView.this.mState.isPreLayout();
      }
      int i = paramViewHolder.mPosition;
      if ((i >= 0) && (i < RecyclerView.this.mAdapter.getItemCount()))
      {
        boolean bool1 = RecyclerView.this.mState.isPreLayout();
        boolean bool2 = false;
        if ((!bool1) && (RecyclerView.this.mAdapter.getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
          return false;
        }
        if (RecyclerView.this.mAdapter.hasStableIds())
        {
          if (paramViewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(paramViewHolder.mPosition)) {
            bool2 = true;
          }
          return bool2;
        }
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      localStringBuilder.append(paramViewHolder);
      localStringBuilder.append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void viewRangeUpdate(int paramInt1, int paramInt2)
    {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder != null)
        {
          int j = localViewHolder.mPosition;
          if ((j >= paramInt1) && (j < paramInt2 + paramInt1))
          {
            localViewHolder.addFlags(2);
            recycleCachedViewAt(i);
          }
        }
      }
    }
  }
  
  public static abstract interface RecyclerListener
  {
    public abstract void onViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder);
  }
  
  private class RecyclerViewDataObserver
    extends RecyclerView.AdapterDataObserver
  {
    RecyclerViewDataObserver() {}
    
    public void onChanged()
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.mState.mStructureChanged = true;
      localRecyclerView.processDataSetCompletelyChanged(true);
      if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
        RecyclerView.this.requestLayout();
      }
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(paramInt1, paramInt2, paramObject)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(paramInt1, paramInt2, paramInt3)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onStateRestorationPolicyChanged()
    {
      Object localObject = RecyclerView.this;
      if (((RecyclerView)localObject).mPendingSavedState == null) {
        return;
      }
      localObject = ((RecyclerView)localObject).mAdapter;
      if ((localObject != null) && (((RecyclerView.Adapter)localObject).canRestoreState())) {
        RecyclerView.this.requestLayout();
      }
    }
    
    void triggerUpdateProcessor()
    {
      if (RecyclerView.POST_UPDATES_ON_ANIMATION)
      {
        localRecyclerView = RecyclerView.this;
        if ((localRecyclerView.mHasFixedSize) && (localRecyclerView.mIsAttached))
        {
          ViewCompat.postOnAnimation(localRecyclerView, localRecyclerView.mUpdateChildViewsRunnable);
          return;
        }
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      localRecyclerView.mAdapterUpdateDuringMeasure = true;
      localRecyclerView.requestLayout();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, null);
      }
      
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public RecyclerView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new RecyclerView.SavedState[paramAnonymousInt];
      }
    };
    Parcelable mLayoutState;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
      }
      this.mLayoutState = paramParcel.readParcelable(paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    void copyFrom(SavedState paramSavedState)
    {
      this.mLayoutState = paramSavedState.mLayoutState;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.mLayoutState, 0);
    }
  }
  
  public static class SimpleOnItemTouchListener
    implements RecyclerView.OnItemTouchListener
  {
    public boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
    
    public void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent) {}
  }
  
  public static abstract class SmoothScroller
  {
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final Action mRecyclingAction = new Action(0, 0);
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;
    
    @Nullable
    public PointF computeScrollVectorForPosition(int paramInt)
    {
      Object localObject = getLayoutManager();
      if ((localObject instanceof ScrollVectorProvider)) {
        return ((ScrollVectorProvider)localObject).computeScrollVectorForPosition(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      ((StringBuilder)localObject).append(ScrollVectorProvider.class.getCanonicalName());
      Log.w("RecyclerView", ((StringBuilder)localObject).toString());
      return null;
    }
    
    public View findViewByPosition(int paramInt)
    {
      return this.mRecyclerView.mLayout.findViewByPosition(paramInt);
    }
    
    public int getChildCount()
    {
      return this.mRecyclerView.mLayout.getChildCount();
    }
    
    public int getChildPosition(View paramView)
    {
      return this.mRecyclerView.getChildLayoutPosition(paramView);
    }
    
    @Nullable
    public RecyclerView.LayoutManager getLayoutManager()
    {
      return this.mLayoutManager;
    }
    
    public int getTargetPosition()
    {
      return this.mTargetPosition;
    }
    
    @Deprecated
    public void instantScrollToPosition(int paramInt)
    {
      this.mRecyclerView.scrollToPosition(paramInt);
    }
    
    public boolean isPendingInitialRun()
    {
      return this.mPendingInitialRun;
    }
    
    public boolean isRunning()
    {
      return this.mRunning;
    }
    
    protected void normalize(@NonNull PointF paramPointF)
    {
      float f1 = paramPointF.x;
      float f2 = paramPointF.y;
      f2 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      paramPointF.x /= f2;
      paramPointF.y /= f2;
    }
    
    void onAnimation(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((this.mTargetPosition == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.mPendingInitialRun) && (this.mTargetView == null) && (this.mLayoutManager != null))
      {
        localObject = computeScrollVectorForPosition(this.mTargetPosition);
        if (localObject != null)
        {
          float f = ((PointF)localObject).x;
          if ((f != 0.0F) || (((PointF)localObject).y != 0.0F)) {
            localRecyclerView.scrollStep((int)Math.signum(f), (int)Math.signum(((PointF)localObject).y), null);
          }
        }
      }
      this.mPendingInitialRun = false;
      Object localObject = this.mTargetView;
      if (localObject != null) {
        if (getChildPosition((View)localObject) == this.mTargetPosition)
        {
          onTargetFound(this.mTargetView, localRecyclerView.mState, this.mRecyclingAction);
          this.mRecyclingAction.runIfNecessary(localRecyclerView);
          stop();
        }
        else
        {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.mTargetView = null;
        }
      }
      if (this.mRunning)
      {
        onSeekTargetStep(paramInt1, paramInt2, localRecyclerView.mState, this.mRecyclingAction);
        boolean bool = this.mRecyclingAction.hasJumpTarget();
        this.mRecyclingAction.runIfNecessary(localRecyclerView);
        if ((bool) && (this.mRunning))
        {
          this.mPendingInitialRun = true;
          localRecyclerView.mViewFlinger.postOnAnimation();
        }
      }
    }
    
    protected void onChildAttachedToWindow(View paramView)
    {
      if (getChildPosition(paramView) == getTargetPosition()) {
        this.mTargetView = paramView;
      }
    }
    
    protected abstract void onSeekTargetStep(@Px int paramInt1, @Px int paramInt2, @NonNull RecyclerView.State paramState, @NonNull Action paramAction);
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected abstract void onTargetFound(@NonNull View paramView, @NonNull RecyclerView.State paramState, @NonNull Action paramAction);
    
    public void setTargetPosition(int paramInt)
    {
      this.mTargetPosition = paramInt;
    }
    
    void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
    {
      paramRecyclerView.mViewFlinger.stop();
      if (this.mStarted)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("An instance of ");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" was started more than once. Each instance of");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      this.mRecyclerView = paramRecyclerView;
      this.mLayoutManager = paramLayoutManager;
      int i = this.mTargetPosition;
      if (i != -1)
      {
        paramRecyclerView.mState.mTargetPosition = i;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.postOnAnimation();
        this.mStarted = true;
        return;
      }
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected final void stop()
    {
      if (!this.mRunning) {
        return;
      }
      this.mRunning = false;
      onStop();
      this.mRecyclerView.mState.mTargetPosition = -1;
      this.mTargetView = null;
      this.mTargetPosition = -1;
      this.mPendingInitialRun = false;
      this.mLayoutManager.onSmoothScrollerStopped(this);
      this.mLayoutManager = null;
      this.mRecyclerView = null;
    }
    
    public static class Action
    {
      public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
      private boolean mChanged = false;
      private int mConsecutiveUpdates = 0;
      private int mDuration;
      private int mDx;
      private int mDy;
      private Interpolator mInterpolator;
      private int mJumpToPosition = -1;
      
      public Action(@Px int paramInt1, @Px int paramInt2)
      {
        this(paramInt1, paramInt2, Integer.MIN_VALUE, null);
      }
      
      public Action(@Px int paramInt1, @Px int paramInt2, int paramInt3)
      {
        this(paramInt1, paramInt2, paramInt3, null);
      }
      
      public Action(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
      }
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.mDuration < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.mDuration >= 1) {
          return;
        }
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      
      public int getDuration()
      {
        return this.mDuration;
      }
      
      @Px
      public int getDx()
      {
        return this.mDx;
      }
      
      @Px
      public int getDy()
      {
        return this.mDy;
      }
      
      @Nullable
      public Interpolator getInterpolator()
      {
        return this.mInterpolator;
      }
      
      boolean hasJumpTarget()
      {
        boolean bool;
        if (this.mJumpToPosition >= 0) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public void jumpTo(int paramInt)
      {
        this.mJumpToPosition = paramInt;
      }
      
      void runIfNecessary(RecyclerView paramRecyclerView)
      {
        int i = this.mJumpToPosition;
        if (i >= 0)
        {
          this.mJumpToPosition = -1;
          paramRecyclerView.jumpToPositionForSmoothScroller(i);
          this.mChanged = false;
          return;
        }
        if (this.mChanged)
        {
          validate();
          paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
          i = this.mConsecutiveUpdates + 1;
          this.mConsecutiveUpdates = i;
          if (i > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
          }
          this.mChanged = false;
        }
        else
        {
          this.mConsecutiveUpdates = 0;
        }
      }
      
      public void setDuration(int paramInt)
      {
        this.mChanged = true;
        this.mDuration = paramInt;
      }
      
      public void setDx(@Px int paramInt)
      {
        this.mChanged = true;
        this.mDx = paramInt;
      }
      
      public void setDy(@Px int paramInt)
      {
        this.mChanged = true;
        this.mDy = paramInt;
      }
      
      public void setInterpolator(@Nullable Interpolator paramInterpolator)
      {
        this.mChanged = true;
        this.mInterpolator = paramInterpolator;
      }
      
      public void update(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.mChanged = true;
      }
    }
    
    public static abstract interface ScrollVectorProvider
    {
      @Nullable
      public abstract PointF computeScrollVectorForPosition(int paramInt);
    }
  }
  
  public static class State
  {
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    long mFocusedItemId;
    int mFocusedItemPosition;
    int mFocusedSubChildId;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPreviousLayoutItemCount = 0;
    int mRemainingScrollHorizontal;
    int mRemainingScrollVertical;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    boolean mStructureChanged = false;
    int mTargetPosition = -1;
    boolean mTrackOldChangeHolders = false;
    
    void assertLayoutStep(int paramInt)
    {
      if ((this.mLayoutStep & paramInt) != 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Layout state should be one of ");
      localStringBuilder.append(Integer.toBinaryString(paramInt));
      localStringBuilder.append(" but it is ");
      localStringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public boolean didStructureChange()
    {
      return this.mStructureChanged;
    }
    
    public <T> T get(int paramInt)
    {
      SparseArray localSparseArray = this.mData;
      if (localSparseArray == null) {
        return null;
      }
      return (T)localSparseArray.get(paramInt);
    }
    
    public int getItemCount()
    {
      int i;
      if (this.mInPreLayout) {
        i = this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
      } else {
        i = this.mItemCount;
      }
      return i;
    }
    
    public int getRemainingScrollHorizontal()
    {
      return this.mRemainingScrollHorizontal;
    }
    
    public int getRemainingScrollVertical()
    {
      return this.mRemainingScrollVertical;
    }
    
    public int getTargetScrollPosition()
    {
      return this.mTargetPosition;
    }
    
    public boolean hasTargetScrollPosition()
    {
      boolean bool;
      if (this.mTargetPosition != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isMeasuring()
    {
      return this.mIsMeasuring;
    }
    
    public boolean isPreLayout()
    {
      return this.mInPreLayout;
    }
    
    void prepareForNestedPrefetch(RecyclerView.Adapter paramAdapter)
    {
      this.mLayoutStep = 1;
      this.mItemCount = paramAdapter.getItemCount();
      this.mInPreLayout = false;
      this.mTrackOldChangeHolders = false;
      this.mIsMeasuring = false;
    }
    
    public void put(int paramInt, Object paramObject)
    {
      if (this.mData == null) {
        this.mData = new SparseArray();
      }
      this.mData.put(paramInt, paramObject);
    }
    
    public void remove(int paramInt)
    {
      SparseArray localSparseArray = this.mData;
      if (localSparseArray == null) {
        return;
      }
      localSparseArray.remove(paramInt);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("State{mTargetPosition=");
      localStringBuilder.append(this.mTargetPosition);
      localStringBuilder.append(", mData=");
      localStringBuilder.append(this.mData);
      localStringBuilder.append(", mItemCount=");
      localStringBuilder.append(this.mItemCount);
      localStringBuilder.append(", mIsMeasuring=");
      localStringBuilder.append(this.mIsMeasuring);
      localStringBuilder.append(", mPreviousLayoutItemCount=");
      localStringBuilder.append(this.mPreviousLayoutItemCount);
      localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      localStringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
      localStringBuilder.append(", mStructureChanged=");
      localStringBuilder.append(this.mStructureChanged);
      localStringBuilder.append(", mInPreLayout=");
      localStringBuilder.append(this.mInPreLayout);
      localStringBuilder.append(", mRunSimpleAnimations=");
      localStringBuilder.append(this.mRunSimpleAnimations);
      localStringBuilder.append(", mRunPredictiveAnimations=");
      localStringBuilder.append(this.mRunPredictiveAnimations);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public boolean willRunPredictiveAnimations()
    {
      return this.mRunPredictiveAnimations;
    }
    
    public boolean willRunSimpleAnimations()
    {
      return this.mRunSimpleAnimations;
    }
  }
  
  public static abstract class ViewCacheExtension
  {
    @Nullable
    public abstract View getViewForPositionAndType(@NonNull RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2);
  }
  
  class ViewFlinger
    implements Runnable
  {
    private boolean mEatRunOnAnimationRequest;
    Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    
    ViewFlinger()
    {
      Interpolator localInterpolator = RecyclerView.sQuinticInterpolator;
      this.mInterpolator = localInterpolator;
      this.mEatRunOnAnimationRequest = false;
      this.mReSchedulePostAnimationCallback = false;
      this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), localInterpolator);
    }
    
    private int computeScrollDuration(int paramInt1, int paramInt2)
    {
      int i = Math.abs(paramInt1);
      int j = Math.abs(paramInt2);
      if (i > j) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      if (paramInt2 != 0) {
        paramInt1 = localRecyclerView.getWidth();
      } else {
        paramInt1 = localRecyclerView.getHeight();
      }
      if (paramInt2 != 0) {
        paramInt2 = i;
      } else {
        paramInt2 = j;
      }
      return Math.min((int)((paramInt2 / paramInt1 + 1.0F) * 300.0F), 2000);
    }
    
    private void internalPostOnAnimation()
    {
      RecyclerView.this.removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }
    
    public void fling(int paramInt1, int paramInt2)
    {
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      Interpolator localInterpolator1 = this.mInterpolator;
      Interpolator localInterpolator2 = RecyclerView.sQuinticInterpolator;
      if (localInterpolator1 != localInterpolator2)
      {
        this.mInterpolator = localInterpolator2;
        this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), localInterpolator2);
      }
      this.mOverScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      postOnAnimation();
    }
    
    void postOnAnimation()
    {
      if (this.mEatRunOnAnimationRequest) {
        this.mReSchedulePostAnimationCallback = true;
      } else {
        internalPostOnAnimation();
      }
    }
    
    public void run()
    {
      Object localObject1 = RecyclerView.this;
      if (((RecyclerView)localObject1).mLayout == null)
      {
        stop();
        return;
      }
      this.mReSchedulePostAnimationCallback = false;
      this.mEatRunOnAnimationRequest = true;
      ((RecyclerView)localObject1).consumePendingUpdateOperations();
      localObject1 = this.mOverScroller;
      if (((OverScroller)localObject1).computeScrollOffset())
      {
        int i = ((OverScroller)localObject1).getCurrX();
        int j = ((OverScroller)localObject1).getCurrY();
        int k = i - this.mLastFlingX;
        int m = j - this.mLastFlingY;
        this.mLastFlingX = i;
        this.mLastFlingY = j;
        Object localObject2 = RecyclerView.this;
        Object localObject3 = ((RecyclerView)localObject2).mReusableIntPair;
        localObject3[0] = 0;
        localObject3[1] = 0;
        j = k;
        i = m;
        if (((RecyclerView)localObject2).dispatchNestedPreScroll(k, m, (int[])localObject3, null, 1))
        {
          localObject3 = RecyclerView.this.mReusableIntPair;
          j = k - localObject3[0];
          i = m - localObject3[1];
        }
        if (RecyclerView.this.getOverScrollMode() != 2) {
          RecyclerView.this.considerReleasingGlowsOnScroll(j, i);
        }
        localObject2 = RecyclerView.this;
        if (((RecyclerView)localObject2).mAdapter != null)
        {
          localObject3 = ((RecyclerView)localObject2).mReusableIntPair;
          localObject3[0] = 0;
          localObject3[1] = 0;
          ((RecyclerView)localObject2).scrollStep(j, i, (int[])localObject3);
          localObject3 = RecyclerView.this;
          localObject2 = ((RecyclerView)localObject3).mReusableIntPair;
          n = localObject2[0];
          i1 = localObject2[1];
          int i2 = j - n;
          int i3 = i - i1;
          localObject3 = ((RecyclerView)localObject3).mLayout.mSmoothScroller;
          j = i2;
          m = i1;
          i = n;
          k = i3;
          if (localObject3 != null)
          {
            j = i2;
            m = i1;
            i = n;
            k = i3;
            if (!((RecyclerView.SmoothScroller)localObject3).isPendingInitialRun())
            {
              j = i2;
              m = i1;
              i = n;
              k = i3;
              if (((RecyclerView.SmoothScroller)localObject3).isRunning())
              {
                j = RecyclerView.this.mState.getItemCount();
                if (j == 0)
                {
                  ((RecyclerView.SmoothScroller)localObject3).stop();
                  j = i2;
                  m = i1;
                  i = n;
                  k = i3;
                }
                else if (((RecyclerView.SmoothScroller)localObject3).getTargetPosition() >= j)
                {
                  ((RecyclerView.SmoothScroller)localObject3).setTargetPosition(j - 1);
                  ((RecyclerView.SmoothScroller)localObject3).onAnimation(n, i1);
                  j = i2;
                  m = i1;
                  i = n;
                  k = i3;
                }
                else
                {
                  ((RecyclerView.SmoothScroller)localObject3).onAnimation(n, i1);
                  j = i2;
                  m = i1;
                  i = n;
                  k = i3;
                }
              }
            }
          }
        }
        else
        {
          m = 0;
          i1 = 0;
          k = i;
          i = i1;
        }
        if (!RecyclerView.this.mItemDecorations.isEmpty()) {
          RecyclerView.this.invalidate();
        }
        localObject3 = RecyclerView.this;
        localObject2 = ((RecyclerView)localObject3).mReusableIntPair;
        localObject2[0] = 0;
        localObject2[1] = 0;
        ((RecyclerView)localObject3).dispatchNestedScroll(i, m, j, k, null, 1, (int[])localObject2);
        localObject2 = RecyclerView.this;
        localObject3 = ((RecyclerView)localObject2).mReusableIntPair;
        int n = j - localObject3[0];
        int i1 = k - localObject3[1];
        if ((i != 0) || (m != 0)) {
          ((RecyclerView)localObject2).dispatchOnScrolled(i, m);
        }
        if (!RecyclerView.this.awakenScrollBars()) {
          RecyclerView.this.invalidate();
        }
        if (((OverScroller)localObject1).getCurrX() == ((OverScroller)localObject1).getFinalX()) {
          j = 1;
        } else {
          j = 0;
        }
        if (((OverScroller)localObject1).getCurrY() == ((OverScroller)localObject1).getFinalY()) {
          k = 1;
        } else {
          k = 0;
        }
        if ((!((OverScroller)localObject1).isFinished()) && (((j == 0) && (n == 0)) || ((k == 0) && (i1 == 0)))) {
          j = 0;
        } else {
          j = 1;
        }
        localObject3 = RecyclerView.this.mLayout.mSmoothScroller;
        if ((localObject3 != null) && (((RecyclerView.SmoothScroller)localObject3).isPendingInitialRun())) {
          k = 1;
        } else {
          k = 0;
        }
        if ((k == 0) && (j != 0))
        {
          if (RecyclerView.this.getOverScrollMode() != 2)
          {
            i = (int)((OverScroller)localObject1).getCurrVelocity();
            if (n < 0) {
              j = -i;
            } else if (n > 0) {
              j = i;
            } else {
              j = 0;
            }
            if (i1 < 0) {
              i = -i;
            } else if (i1 <= 0) {
              i = 0;
            }
            RecyclerView.this.absorbGlows(j, i);
          }
          if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
          }
        }
        else
        {
          postOnAnimation();
          localObject3 = RecyclerView.this;
          localObject1 = ((RecyclerView)localObject3).mGapWorker;
          if (localObject1 != null) {
            ((GapWorker)localObject1).postFromTraversal((RecyclerView)localObject3, i, m);
          }
        }
      }
      localObject1 = RecyclerView.this.mLayout.mSmoothScroller;
      if ((localObject1 != null) && (((RecyclerView.SmoothScroller)localObject1).isPendingInitialRun())) {
        ((RecyclerView.SmoothScroller)localObject1).onAnimation(0, 0);
      }
      this.mEatRunOnAnimationRequest = false;
      if (this.mReSchedulePostAnimationCallback)
      {
        internalPostOnAnimation();
      }
      else
      {
        RecyclerView.this.setScrollState(0);
        RecyclerView.this.stopNestedScroll(1);
      }
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
    {
      int i = paramInt3;
      if (paramInt3 == Integer.MIN_VALUE) {
        i = computeScrollDuration(paramInt1, paramInt2);
      }
      Interpolator localInterpolator = paramInterpolator;
      if (paramInterpolator == null) {
        localInterpolator = RecyclerView.sQuinticInterpolator;
      }
      if (this.mInterpolator != localInterpolator)
      {
        this.mInterpolator = localInterpolator;
        this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), localInterpolator);
      }
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      RecyclerView.this.setScrollState(2);
      this.mOverScroller.startScroll(0, 0, paramInt1, paramInt2, i);
      if (Build.VERSION.SDK_INT < 23) {
        this.mOverScroller.computeScrollOffset();
      }
      postOnAnimation();
    }
    
    public void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.mOverScroller.abortAnimation();
    }
  }
  
  public static abstract class ViewHolder
  {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = ;
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    @NonNull
    public final View itemView;
    RecyclerView.Adapter<? extends ViewHolder> mBindingAdapter;
    int mFlags;
    boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    @VisibleForTesting
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    RecyclerView.Recycler mScrapContainer = null;
    ViewHolder mShadowedHolder = null;
    ViewHolder mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public ViewHolder(@NonNull View paramView)
    {
      if (paramView != null)
      {
        this.itemView = paramView;
        return;
      }
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void createPayloadsIfNeeded()
    {
      if (this.mPayloads == null)
      {
        ArrayList localArrayList = new ArrayList();
        this.mPayloads = localArrayList;
        this.mUnmodifiedPayloads = Collections.unmodifiableList(localArrayList);
      }
    }
    
    void addChangePayload(Object paramObject)
    {
      if (paramObject == null)
      {
        addFlags(1024);
      }
      else if ((0x400 & this.mFlags) == 0)
      {
        createPayloadsIfNeeded();
        this.mPayloads.add(paramObject);
      }
    }
    
    void addFlags(int paramInt)
    {
      this.mFlags = (paramInt | this.mFlags);
    }
    
    void clearOldPosition()
    {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
    }
    
    void clearPayload()
    {
      List localList = this.mPayloads;
      if (localList != null) {
        localList.clear();
      }
      this.mFlags &= 0xFBFF;
    }
    
    void clearReturnedFromScrapFlag()
    {
      this.mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag()
    {
      this.mFlags &= 0xFEFF;
    }
    
    boolean doesTransientStatePreventRecycling()
    {
      boolean bool;
      if (((this.mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(this.itemView))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      this.mPosition = paramInt1;
    }
    
    public final int getAbsoluteAdapterPosition()
    {
      RecyclerView localRecyclerView = this.mOwnerRecyclerView;
      if (localRecyclerView == null) {
        return -1;
      }
      return localRecyclerView.getAdapterPositionInRecyclerView(this);
    }
    
    @Deprecated
    public final int getAdapterPosition()
    {
      return getBindingAdapterPosition();
    }
    
    @Nullable
    public final RecyclerView.Adapter<? extends ViewHolder> getBindingAdapter()
    {
      return this.mBindingAdapter;
    }
    
    public final int getBindingAdapterPosition()
    {
      if (this.mBindingAdapter == null) {
        return -1;
      }
      Object localObject = this.mOwnerRecyclerView;
      if (localObject == null) {
        return -1;
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null) {
        return -1;
      }
      int i = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
      if (i == -1) {
        return -1;
      }
      return ((RecyclerView.Adapter)localObject).findRelativeAdapterPositionIn(this.mBindingAdapter, this, i);
    }
    
    public final long getItemId()
    {
      return this.mItemId;
    }
    
    public final int getItemViewType()
    {
      return this.mItemViewType;
    }
    
    public final int getLayoutPosition()
    {
      int i = this.mPreLayoutPosition;
      int j = i;
      if (i == -1) {
        j = this.mPosition;
      }
      return j;
    }
    
    public final int getOldPosition()
    {
      return this.mOldPosition;
    }
    
    @Deprecated
    public final int getPosition()
    {
      int i = this.mPreLayoutPosition;
      int j = i;
      if (i == -1) {
        j = this.mPosition;
      }
      return j;
    }
    
    List<Object> getUnmodifiedPayloads()
    {
      if ((this.mFlags & 0x400) == 0)
      {
        List localList = this.mPayloads;
        if ((localList != null) && (localList.size() != 0)) {
          return this.mUnmodifiedPayloads;
        }
        return FULLUPDATE_PAYLOADS;
      }
      return FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int paramInt)
    {
      boolean bool;
      if ((paramInt & this.mFlags) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isAdapterPositionUnknown()
    {
      boolean bool;
      if (((this.mFlags & 0x200) == 0) && (!isInvalid())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    boolean isAttachedToTransitionOverlay()
    {
      boolean bool;
      if ((this.itemView.getParent() != null) && (this.itemView.getParent() != this.mOwnerRecyclerView)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isBound()
    {
      int i = this.mFlags;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      return bool;
    }
    
    boolean isInvalid()
    {
      boolean bool;
      if ((this.mFlags & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final boolean isRecyclable()
    {
      boolean bool;
      if (((this.mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(this.itemView))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isRemoved()
    {
      boolean bool;
      if ((this.mFlags & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isScrap()
    {
      boolean bool;
      if (this.mScrapContainer != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isTmpDetached()
    {
      boolean bool;
      if ((this.mFlags & 0x100) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isUpdated()
    {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean needsUpdate()
    {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
      if (this.mPreLayoutPosition == -1) {
        this.mPreLayoutPosition = this.mPosition;
      }
      if (paramBoolean) {
        this.mPreLayoutPosition += paramInt;
      }
      this.mPosition += paramInt;
      if (this.itemView.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
      }
    }
    
    void onEnteredHiddenState(RecyclerView paramRecyclerView)
    {
      int i = this.mPendingAccessibilityState;
      if (i != -1) {
        this.mWasImportantForAccessibilityBeforeHidden = i;
      } else {
        this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
      }
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }
    
    void onLeftHiddenState(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void resetInternal()
    {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
      this.mPendingAccessibilityState = -1;
      RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }
    
    void saveOldPosition()
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
    }
    
    void setFlags(int paramInt1, int paramInt2)
    {
      this.mFlags = (paramInt1 & paramInt2 | this.mFlags & (paramInt2 ^ 0xFFFFFFFF));
    }
    
    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i = this.mIsRecyclableCount;
      if (paramBoolean) {
        i--;
      } else {
        i++;
      }
      this.mIsRecyclableCount = i;
      if (i < 0)
      {
        this.mIsRecyclableCount = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
        Log.e("View", localStringBuilder.toString());
      }
      else if ((!paramBoolean) && (i == 1))
      {
        this.mFlags |= 0x10;
      }
      else if ((paramBoolean) && (i == 0))
      {
        this.mFlags &= 0xFFFFFFEF;
      }
    }
    
    void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
    {
      this.mScrapContainer = paramRecycler;
      this.mInChangeScrap = paramBoolean;
    }
    
    boolean shouldBeKeptAsChild()
    {
      boolean bool;
      if ((this.mFlags & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean shouldIgnore()
    {
      boolean bool;
      if ((this.mFlags & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void stopIgnoring()
    {
      this.mFlags &= 0xFF7F;
    }
    
    public String toString()
    {
      Object localObject;
      if (getClass().isAnonymousClass()) {
        localObject = "ViewHolder";
      } else {
        localObject = getClass().getSimpleName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      localStringBuilder.append(" position=");
      localStringBuilder.append(this.mPosition);
      localStringBuilder.append(" id=");
      localStringBuilder.append(this.mItemId);
      localStringBuilder.append(", oldPos=");
      localStringBuilder.append(this.mOldPosition);
      localStringBuilder.append(", pLpos:");
      localStringBuilder.append(this.mPreLayoutPosition);
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      if (isScrap())
      {
        localStringBuilder.append(" scrap ");
        if (this.mInChangeScrap) {
          localObject = "[changeScrap]";
        } else {
          localObject = "[attachedScrap]";
        }
        localStringBuilder.append((String)localObject);
      }
      if (isInvalid()) {
        localStringBuilder.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder.append(" unbound");
      }
      if (needsUpdate()) {
        localStringBuilder.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder.append(" removed");
      }
      if (shouldIgnore()) {
        localStringBuilder.append(" ignored");
      }
      if (isTmpDetached()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!isRecyclable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" not recyclable(");
        ((StringBuilder)localObject).append(this.mIsRecyclableCount);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (isAdapterPositionUnknown()) {
        localStringBuilder.append(" undefined adapter position");
      }
      if (this.itemView.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    void unScrap()
    {
      this.mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap()
    {
      boolean bool;
      if ((this.mFlags & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */