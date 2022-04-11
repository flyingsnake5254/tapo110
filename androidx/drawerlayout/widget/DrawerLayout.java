package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import androidx.drawerlayout.R.attr;
import androidx.drawerlayout.R.dimen;
import androidx.drawerlayout.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
  implements Openable
{
  private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
  private static final boolean ALLOW_EDGE_LOCK = false;
  static final boolean CAN_HIDE_DESCENDANTS;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNDEFINED = 3;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final int[] THEME_ATTRS;
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private static boolean sEdgeSizeUsingSystemGestureInsets;
  private final AccessibilityViewCommand mActionDismiss = new AccessibilityViewCommand()
  {
    public boolean perform(@NonNull View paramAnonymousView, @Nullable AccessibilityViewCommand.CommandArguments paramAnonymousCommandArguments)
    {
      if ((DrawerLayout.this.isDrawerOpen(paramAnonymousView)) && (DrawerLayout.this.getDrawerLockMode(paramAnonymousView) != 2))
      {
        DrawerLayout.this.closeDrawer(paramAnonymousView);
        return true;
      }
      return false;
    }
  };
  private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
  private Rect mChildHitRect;
  private Matrix mChildInvertedMatrix;
  private boolean mChildrenCanceledTouch;
  private boolean mDrawStatusBarBackground;
  private float mDrawerElevation;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  @Nullable
  private DrawerListener mListener;
  private List<DrawerListener> mListeners;
  private int mLockModeEnd = 3;
  private int mLockModeLeft = 3;
  private int mLockModeRight = 3;
  private int mLockModeStart = 3;
  private int mMinDrawerMargin;
  private final ArrayList<View> mNonDrawerViews;
  private final ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowEnd = null;
  private Drawable mShadowLeft = null;
  private Drawable mShadowLeftResolved;
  private Drawable mShadowRight = null;
  private Drawable mShadowRightResolved;
  private Drawable mShadowStart = null;
  private Drawable mStatusBarBackground;
  private CharSequence mTitleLeft;
  private CharSequence mTitleRight;
  
  static
  {
    boolean bool1 = true;
    THEME_ATTRS = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    int i = Build.VERSION.SDK_INT;
    boolean bool2;
    if (i >= 19) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    CAN_HIDE_DESCENDANTS = bool2;
    if (i >= 21) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    SET_DRAWER_SHADOW_FROM_ELEVATION = bool2;
    if (i >= 29) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    sEdgeSizeUsingSystemGestureInsets = bool2;
  }
  
  public DrawerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.drawerLayoutStyle);
  }
  
  public DrawerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = ((int)(64.0F * f + 0.5F));
    f *= 400.0F;
    Object localObject1 = new ViewDragCallback(3);
    this.mLeftCallback = ((ViewDragCallback)localObject1);
    Object localObject2 = new ViewDragCallback(5);
    this.mRightCallback = ((ViewDragCallback)localObject2);
    ViewDragHelper localViewDragHelper = ViewDragHelper.create(this, 1.0F, (ViewDragHelper.Callback)localObject1);
    this.mLeftDragger = localViewDragHelper;
    localViewDragHelper.setEdgeTrackingEnabled(1);
    localViewDragHelper.setMinVelocity(f);
    ((ViewDragCallback)localObject1).setDragger(localViewDragHelper);
    localObject1 = ViewDragHelper.create(this, 1.0F, (ViewDragHelper.Callback)localObject2);
    this.mRightDragger = ((ViewDragHelper)localObject1);
    ((ViewDragHelper)localObject1).setEdgeTrackingEnabled(2);
    ((ViewDragHelper)localObject1).setMinVelocity(f);
    ((ViewDragCallback)localObject2).setDragger((ViewDragHelper)localObject1);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    setMotionEventSplittingEnabled(false);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          public WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
          {
            paramAnonymousView = (DrawerLayout)paramAnonymousView;
            boolean bool;
            if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramAnonymousView.setChildInsets(paramAnonymousWindowInsets, bool);
            return paramAnonymousWindowInsets.consumeSystemWindowInsets();
          }
        });
        setSystemUiVisibility(1280);
        localObject2 = paramContext.obtainStyledAttributes(THEME_ATTRS);
      }
      try
      {
        this.mStatusBarBackground = ((TypedArray)localObject2).getDrawable(0);
        ((TypedArray)localObject2).recycle();
      }
      finally
      {
        ((TypedArray)localObject2).recycle();
      }
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DrawerLayout, paramInt, 0);
    try
    {
      paramInt = R.styleable.DrawerLayout_elevation;
      if (paramAttributeSet.hasValue(paramInt)) {
        this.mDrawerElevation = paramAttributeSet.getDimension(paramInt, 0.0F);
      } else {
        this.mDrawerElevation = getResources().getDimension(R.dimen.def_drawer_elevation);
      }
      paramAttributeSet.recycle();
      this.mNonDrawerViews = new ArrayList();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private boolean dispatchTransformedGenericPointerEvent(MotionEvent paramMotionEvent, View paramView)
  {
    boolean bool;
    if (!paramView.getMatrix().isIdentity())
    {
      paramMotionEvent = getTransformedMotionEvent(paramMotionEvent, paramView);
      bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.recycle();
    }
    else
    {
      float f1 = getScrollX() - paramView.getLeft();
      float f2 = getScrollY() - paramView.getTop();
      paramMotionEvent.offsetLocation(f1, f2);
      bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.offsetLocation(-f1, -f2);
    }
    return bool;
  }
  
  private MotionEvent getTransformedMotionEvent(MotionEvent paramMotionEvent, View paramView)
  {
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1, f2);
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      if (this.mChildInvertedMatrix == null) {
        this.mChildInvertedMatrix = new Matrix();
      }
      paramView.invert(this.mChildInvertedMatrix);
      paramMotionEvent.transform(this.mChildInvertedMatrix);
    }
    return paramMotionEvent;
  }
  
  static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private static boolean hasOpaqueBackground(View paramView)
  {
    paramView = paramView.getBackground();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramView != null)
    {
      bool2 = bool1;
      if (paramView.getOpacity() == -1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean hasPeekingDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++) {
      if (((LayoutParams)getChildAt(j).getLayoutParams()).isPeeking) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasVisibleDrawer()
  {
    boolean bool;
    if (findVisibleDrawer() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean includeChildForAccessibility(View paramView)
  {
    boolean bool;
    if ((ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isInBoundsOfChild(float paramFloat1, float paramFloat2, View paramView)
  {
    if (this.mChildHitRect == null) {
      this.mChildHitRect = new Rect();
    }
    paramView.getHitRect(this.mChildHitRect);
    return this.mChildHitRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private void mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (DrawableCompat.isAutoMirrored(paramDrawable))) {
      DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    }
  }
  
  private Drawable resolveLeftShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = this.mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowStart;
      }
    }
    else
    {
      localDrawable = this.mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowEnd;
      }
    }
    return this.mShadowLeft;
  }
  
  private Drawable resolveRightShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = this.mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowEnd;
      }
    }
    else
    {
      localDrawable = this.mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return this.mShadowStart;
      }
    }
    return this.mShadowRight;
  }
  
  private void resolveShadowDrawables()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    this.mShadowLeftResolved = resolveLeftShadow();
    this.mShadowRightResolved = resolveRightShadow();
  }
  
  private void updateChildAccessibilityAction(View paramView)
  {
    AccessibilityNodeInfoCompat.AccessibilityActionCompat localAccessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
    ViewCompat.removeAccessibilityAction(paramView, localAccessibilityActionCompat.getId());
    if ((isDrawerOpen(paramView)) && (getDrawerLockMode(paramView) != 2)) {
      ViewCompat.replaceAccessibilityAction(paramView, localAccessibilityActionCompat, null, this.mActionDismiss);
    }
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      } else {
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }
  
  public void addDrawerListener(@NonNull DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {
      return;
    }
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramDrawerListener);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    View localView;
    while (k < i)
    {
      localView = getChildAt(k);
      if (isDrawerView(localView))
      {
        if (isDrawerOpen(localView))
        {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          m = 1;
        }
      }
      else {
        this.mNonDrawerViews.add(localView);
      }
      k++;
    }
    if (m == 0)
    {
      m = this.mNonDrawerViews.size();
      for (k = j; k < m; k++)
      {
        localView = (View)this.mNonDrawerViews.get(k);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
    }
    this.mNonDrawerViews.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() == null) && (!isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    } else {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    if (!CAN_HIDE_DESCENDANTS) {
      ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate);
    }
  }
  
  void cancelChildViewTouch()
  {
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int i = getChildCount();
      for (int j = 0; j < i; j++) {
        getChildAt(j).dispatchTouchEvent(localMotionEvent);
      }
      localMotionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    }
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    boolean bool;
    if ((getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void close()
  {
    closeDrawer(8388611);
  }
  
  public void closeDrawer(int paramInt)
  {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      closeDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void closeDrawer(@NonNull View paramView)
  {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.mFirstLayout)
      {
        ((LayoutParams)localObject).onScreen = 0.0F;
        ((LayoutParams)localObject).openState = 0;
      }
      else if (paramBoolean)
      {
        ((LayoutParams)localObject).openState |= 0x4;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 0.0F);
        updateDrawerState(0, paramView);
        paramView.setVisibility(4);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      m = k;
      if (isDrawerView(localView)) {
        if ((paramBoolean) && (!localLayoutParams.isPeeking))
        {
          m = k;
        }
        else
        {
          m = localView.getWidth();
          boolean bool;
          if (checkDrawerViewAbsoluteGravity(localView, 3)) {
            bool = this.mLeftDragger.smoothSlideViewTo(localView, -m, localView.getTop());
          } else {
            bool = this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
          }
          m = k | bool;
          localLayoutParams.isPeeking = false;
        }
      }
      j++;
    }
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (k != 0) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    int i = getChildCount();
    float f = 0.0F;
    for (int j = 0; j < i; j++) {
      f = Math.max(f, ((LayoutParams)getChildAt(j).getLayoutParams()).onScreen);
    }
    this.mScrimOpacity = f;
    boolean bool1 = this.mLeftDragger.continueSettling(true);
    boolean bool2 = this.mRightDragger.continueSettling(true);
    if ((bool1) || (bool2)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() != 10) && (this.mScrimOpacity > 0.0F))
    {
      int i = getChildCount();
      if (i != 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        i--;
        while (i >= 0)
        {
          View localView = getChildAt(i);
          if ((isInBoundsOfChild(f1, f2, localView)) && (!isContentView(localView)) && (dispatchTransformedGenericPointerEvent(paramMotionEvent, localView))) {
            return true;
          }
          i--;
        }
      }
      return false;
    }
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  void dispatchOnDrawerClosed(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((((LayoutParams)localObject).openState & 0x1) == 1)
    {
      ((LayoutParams)localObject).openState = 0;
      localObject = this.mListeners;
      if (localObject != null) {
        for (int i = ((List)localObject).size() - 1; i >= 0; i--) {
          ((DrawerListener)this.mListeners.get(i)).onDrawerClosed(paramView);
        }
      }
      updateChildrenImportantForAccessibility(paramView, false);
      updateChildAccessibilityAction(paramView);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void dispatchOnDrawerOpened(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((((LayoutParams)localObject).openState & 0x1) == 0)
    {
      ((LayoutParams)localObject).openState = 1;
      localObject = this.mListeners;
      if (localObject != null) {
        for (int i = ((List)localObject).size() - 1; i >= 0; i--) {
          ((DrawerListener)this.mListeners.get(i)).onDrawerOpened(paramView);
        }
      }
      updateChildrenImportantForAccessibility(paramView, true);
      updateChildAccessibilityAction(paramView);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    List localList = this.mListeners;
    if (localList != null) {
      for (int i = localList.size() - 1; i >= 0; i--) {
        ((DrawerListener)this.mListeners.get(i)).onDrawerSlide(paramView, paramFloat);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = getHeight();
    boolean bool1 = isContentView(paramView);
    int j = getWidth();
    int k = paramCanvas.save();
    int m = 0;
    int n = j;
    int i3;
    if (bool1)
    {
      int i1 = getChildCount();
      n = 0;
      for (m = 0; n < i1; m = i3)
      {
        View localView = getChildAt(n);
        int i2 = j;
        i3 = m;
        if (localView != paramView)
        {
          i2 = j;
          i3 = m;
          if (localView.getVisibility() == 0)
          {
            i2 = j;
            i3 = m;
            if (hasOpaqueBackground(localView))
            {
              i2 = j;
              i3 = m;
              if (isDrawerView(localView)) {
                if (localView.getHeight() < i)
                {
                  i2 = j;
                  i3 = m;
                }
                else
                {
                  int i4;
                  if (checkDrawerViewAbsoluteGravity(localView, 3))
                  {
                    i4 = localView.getRight();
                    i2 = j;
                    i3 = m;
                    if (i4 > m)
                    {
                      i3 = i4;
                      i2 = j;
                    }
                  }
                  else
                  {
                    i4 = localView.getLeft();
                    i2 = j;
                    i3 = m;
                    if (i4 < j)
                    {
                      i2 = i4;
                      i3 = m;
                    }
                  }
                }
              }
            }
          }
        }
        n++;
        j = i2;
      }
      paramCanvas.clipRect(m, 0, j, getHeight());
      n = j;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(k);
    float f = this.mScrimOpacity;
    if ((f > 0.0F) && (bool1))
    {
      j = this.mScrimColor;
      i3 = (int)(((0xFF000000 & j) >>> 24) * f);
      this.mScrimPaint.setColor(j & 0xFFFFFF | i3 << 24);
      paramCanvas.drawRect(m, 0.0F, n, getHeight(), this.mScrimPaint);
    }
    else if ((this.mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
    {
      m = this.mShadowLeftResolved.getIntrinsicWidth();
      j = paramView.getRight();
      n = this.mLeftDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min(j / n, 1.0F));
      this.mShadowLeftResolved.setBounds(j, paramView.getTop(), m + j, paramView.getBottom());
      this.mShadowLeftResolved.setAlpha((int)(f * 255.0F));
      this.mShadowLeftResolved.draw(paramCanvas);
    }
    else if ((this.mShadowRightResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 5)))
    {
      m = this.mShadowRightResolved.getIntrinsicWidth();
      j = paramView.getLeft();
      i3 = getWidth();
      n = this.mRightDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min((i3 - j) / n, 1.0F));
      this.mShadowRightResolved.setBounds(j - m, paramView.getTop(), j, paramView.getBottom());
      this.mShadowRightResolved.setAlpha((int)(f * 255.0F));
      this.mShadowRightResolved.draw(paramCanvas);
    }
    return bool2;
  }
  
  View findDrawerWithGravity(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    for (paramInt = 0; paramInt < j; paramInt++)
    {
      View localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
    }
    return null;
  }
  
  View findOpenDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((((LayoutParams)localView.getLayoutParams()).openState & 0x1) == 1) {
        return localView;
      }
    }
    return null;
  }
  
  View findVisibleDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
        return localView;
      }
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
    } else if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    } else {
      paramLayoutParams = new LayoutParams(paramLayoutParams);
    }
    return paramLayoutParams;
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return this.mDrawerElevation;
    }
    return 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 8388611)
        {
          if (paramInt == 8388613)
          {
            paramInt = this.mLockModeEnd;
            if (paramInt != 3) {
              return paramInt;
            }
            if (i == 0) {
              paramInt = this.mLockModeRight;
            } else {
              paramInt = this.mLockModeLeft;
            }
            if (paramInt != 3) {
              return paramInt;
            }
          }
        }
        else
        {
          paramInt = this.mLockModeStart;
          if (paramInt != 3) {
            return paramInt;
          }
          if (i == 0) {
            paramInt = this.mLockModeLeft;
          } else {
            paramInt = this.mLockModeRight;
          }
          if (paramInt != 3) {
            return paramInt;
          }
        }
      }
      else
      {
        paramInt = this.mLockModeRight;
        if (paramInt != 3) {
          return paramInt;
        }
        if (i == 0) {
          paramInt = this.mLockModeEnd;
        } else {
          paramInt = this.mLockModeStart;
        }
        if (paramInt != 3) {
          return paramInt;
        }
      }
    }
    else
    {
      paramInt = this.mLockModeLeft;
      if (paramInt != 3) {
        return paramInt;
      }
      if (i == 0) {
        paramInt = this.mLockModeStart;
      } else {
        paramInt = this.mLockModeEnd;
      }
      if (paramInt != 3) {
        return paramInt;
      }
    }
    return 0;
  }
  
  public int getDrawerLockMode(@NonNull View paramView)
  {
    if (isDrawerView(paramView)) {
      return getDrawerLockMode(((LayoutParams)paramView.getLayoutParams()).gravity);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @Nullable
  public CharSequence getDrawerTitle(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return this.mTitleLeft;
    }
    if (paramInt == 5) {
      return this.mTitleRight;
    }
    return null;
  }
  
  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }
  
  float getDrawerViewOffset(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  @Nullable
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.mStatusBarBackground;
  }
  
  boolean isContentView(View paramView)
  {
    boolean bool;
    if (((LayoutParams)paramView.getLayoutParams()).gravity == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerOpen(localView);
    }
    return false;
  }
  
  public boolean isDrawerOpen(@NonNull View paramView)
  {
    if (isDrawerView(paramView))
    {
      int i = ((LayoutParams)paramView.getLayoutParams()).openState;
      boolean bool = true;
      if ((i & 0x1) != 1) {
        bool = false;
      }
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerVisible(localView);
    }
    return false;
  }
  
  public boolean isDrawerVisible(@NonNull View paramView)
  {
    if (isDrawerView(paramView))
    {
      boolean bool;
      if (((LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean isOpen()
  {
    return isDrawerOpen(8388611);
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f1 = getDrawerViewOffset(paramView);
    float f2 = paramView.getWidth();
    int i = (int)(f1 * f2);
    i = (int)(f2 * paramFloat) - i;
    if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
      i = -i;
    }
    paramView.offsetLeftAndRight(i);
    setDrawerViewOffset(paramView, paramFloat);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object localObject = this.mLastInsets;
        if (localObject != null)
        {
          i = ((WindowInsets)localObject).getSystemWindowInsetTop();
          break label49;
        }
      }
      int i = 0;
      label49:
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool2 = this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool3 = true;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label87;
          }
        }
        else
        {
          if (!this.mLeftDragger.checkTouchSlop(3)) {
            break label87;
          }
          this.mLeftCallback.removeCallbacks();
          this.mRightCallback.removeCallbacks();
          break label87;
        }
      }
      closeDrawers(true);
      this.mChildrenCanceledTouch = false;
      label87:
      i = 0;
    }
    else
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.mScrimOpacity > 0.0F)
      {
        paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
        {
          i = 1;
          break label158;
        }
      }
      i = 0;
      label158:
      this.mChildrenCanceledTouch = false;
    }
    boolean bool4 = bool3;
    if (!(bool1 | bool2))
    {
      bool4 = bool3;
      if (i == 0)
      {
        bool4 = bool3;
        if (!hasPeekingDrawer()) {
          if (this.mChildrenCanceledTouch) {
            bool4 = bool3;
          } else {
            bool4 = false;
          }
        }
      }
    }
    return bool4;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers();
      }
      boolean bool;
      if (paramKeyEvent != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int i = paramInt3 - paramInt1;
    int j = getChildCount();
    Object localObject1;
    Object localObject2;
    for (paramInt3 = 0; paramInt3 < j; paramInt3++)
    {
      localObject1 = getChildAt(paramInt3);
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
        if (isContentView((View)localObject1))
        {
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
          ((View)localObject1).layout(paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).topMargin, ((View)localObject1).getMeasuredWidth() + paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).topMargin + ((View)localObject1).getMeasuredHeight());
        }
        else
        {
          int k = ((View)localObject1).getMeasuredWidth();
          int m = ((View)localObject1).getMeasuredHeight();
          float f;
          int n;
          if (checkDrawerViewAbsoluteGravity((View)localObject1, 3))
          {
            paramInt1 = -k;
            f = k;
            n = paramInt1 + (int)(((LayoutParams)localObject2).onScreen * f);
            f = (k + n) / f;
          }
          else
          {
            f = k;
            n = i - (int)(((LayoutParams)localObject2).onScreen * f);
            f = (i - n) / f;
          }
          int i1;
          if (f != ((LayoutParams)localObject2).onScreen) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          paramInt1 = ((LayoutParams)localObject2).gravity & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
              ((View)localObject1).layout(n, paramInt1, k + n, m + paramInt1);
            }
            else
            {
              paramInt1 = paramInt4 - paramInt2;
              ((View)localObject1).layout(n, paramInt1 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((View)localObject1).getMeasuredHeight(), k + n, paramInt1 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin);
            }
          }
          else
          {
            int i2 = paramInt4 - paramInt2;
            int i3 = (i2 - m) / 2;
            paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
            if (i3 >= paramInt1)
            {
              int i4 = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
              paramInt1 = i3;
              if (i3 + m > i2 - i4) {
                paramInt1 = i2 - i4 - m;
              }
            }
            ((View)localObject1).layout(n, paramInt1, k + n, m + paramInt1);
          }
          if (i1 != 0) {
            setDrawerViewOffset((View)localObject1, f);
          }
          if (((LayoutParams)localObject2).onScreen > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (((View)localObject1).getVisibility() != paramInt1) {
            ((View)localObject1).setVisibility(paramInt1);
          }
        }
      }
    }
    if (sEdgeSizeUsingSystemGestureInsets)
    {
      localObject2 = getRootWindowInsets();
      if (localObject2 != null)
      {
        localObject2 = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)localObject2).getSystemGestureInsets();
        localObject1 = this.mLeftDragger;
        ((ViewDragHelper)localObject1).setEdgeSize(Math.max(((ViewDragHelper)localObject1).getDefaultEdgeSize(), ((Insets)localObject2).left));
        localObject1 = this.mRightDragger;
        ((ViewDragHelper)localObject1).setEdgeSize(Math.max(((ViewDragHelper)localObject1).getDefaultEdgeSize(), ((Insets)localObject2).right));
      }
    }
    this.mInLayout = false;
    this.mFirstLayout = false;
  }
  
  @SuppressLint({"WrongConstant"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int i1;
    if (i == 1073741824)
    {
      n = k;
      i1 = m;
      if (j == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label763;
      }
      if (i == 0) {
        k = 300;
      }
      n = k;
      i1 = m;
      if (j == 0)
      {
        i1 = 300;
        n = k;
      }
    }
    setMeasuredDimension(n, i1);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      j = 1;
    } else {
      j = 0;
    }
    int i2 = ViewCompat.getLayoutDirection(this);
    int i3 = getChildCount();
    i = 0;
    m = 0;
    k = 0;
    while (i < i3)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams;
      int i4;
      Object localObject;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (j != 0)
        {
          i4 = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, i2);
          WindowInsets localWindowInsets;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              localWindowInsets = (WindowInsets)this.mLastInsets;
              if (i4 == 3)
              {
                localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
              }
              else
              {
                localObject = localWindowInsets;
                if (i4 == 5) {
                  localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
                }
              }
              localView.dispatchApplyWindowInsets((WindowInsets)localObject);
            }
          }
          else if (Build.VERSION.SDK_INT >= 21)
          {
            localWindowInsets = (WindowInsets)this.mLastInsets;
            if (i4 == 3)
            {
              localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
            }
            else
            {
              localObject = localWindowInsets;
              if (i4 == 5) {
                localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
              }
            }
            localLayoutParams.leftMargin = ((WindowInsets)localObject).getSystemWindowInsetLeft();
            localLayoutParams.topMargin = ((WindowInsets)localObject).getSystemWindowInsetTop();
            localLayoutParams.rightMargin = ((WindowInsets)localObject).getSystemWindowInsetRight();
            localLayoutParams.bottomMargin = ((WindowInsets)localObject).getSystemWindowInsetBottom();
          }
        }
        if (isContentView(localView)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(n - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
      }
      else
      {
        break label692;
      }
      if (isDrawerView(localView))
      {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION)
        {
          float f1 = ViewCompat.getElevation(localView);
          float f2 = this.mDrawerElevation;
          if (f1 != f2) {
            ViewCompat.setElevation(localView, f2);
          }
        }
        int i5 = getDrawerViewAbsoluteGravity(localView) & 0x7;
        if (i5 == 3) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (((i4 != 0) && (m != 0)) || ((i4 == 0) && (k != 0)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Child drawer has absolute gravity ");
          ((StringBuilder)localObject).append(gravityToString(i5));
          ((StringBuilder)localObject).append(" but this ");
          ((StringBuilder)localObject).append("DrawerLayout");
          ((StringBuilder)localObject).append(" already has a drawer view along that edge");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        if (i4 != 0) {
          m = 1;
        } else {
          k = 1;
        }
        localView.measure(ViewGroup.getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        label692:
        i++;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Child ");
        ((StringBuilder)localObject).append(localView);
        ((StringBuilder)localObject).append(" at index ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return;
    label763:
    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    int i = localSavedState.openDrawerGravity;
    if (i != 0)
    {
      paramParcelable = findDrawerWithGravity(i);
      if (paramParcelable != null) {
        openDrawer(paramParcelable);
      }
    }
    i = localSavedState.lockModeLeft;
    if (i != 3) {
      setDrawerLockMode(i, 3);
    }
    i = localSavedState.lockModeRight;
    if (i != 3) {
      setDrawerLockMode(i, 5);
    }
    i = localSavedState.lockModeStart;
    if (i != 3) {
      setDrawerLockMode(i, 8388611);
    }
    i = localSavedState.lockModeEnd;
    if (i != 3) {
      setDrawerLockMode(i, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    resolveShadowDrawables();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i = getChildCount();
    int j = 0;
    while (j < i)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(j).getLayoutParams();
      int k = localLayoutParams.openState;
      int m = 1;
      int n;
      if (k == 1) {
        n = 1;
      } else {
        n = 0;
      }
      if (k != 2) {
        m = 0;
      }
      if ((n == 0) && (m == 0)) {
        j++;
      } else {
        localSavedState.openDrawerGravity = localLayoutParams.gravity;
      }
    }
    localSavedState.lockModeLeft = this.mLockModeLeft;
    localSavedState.lockModeRight = this.mLockModeRight;
    localSavedState.lockModeStart = this.mLockModeStart;
    localSavedState.lockModeEnd = this.mLockModeEnd;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    boolean bool = false;
    float f1;
    float f2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3)
        {
          closeDrawers(true);
          this.mChildrenCanceledTouch = false;
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
        {
          f1 -= this.mInitialMotionX;
          f2 -= this.mInitialMotionY;
          i = this.mLeftDragger.getTouchSlop();
          if (f1 * f1 + f2 * f2 < i * i)
          {
            paramMotionEvent = findOpenDrawer();
            if ((paramMotionEvent != null) && (getDrawerLockMode(paramMotionEvent) != 2)) {
              break label160;
            }
          }
        }
        bool = true;
        label160:
        closeDrawers(bool);
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.mChildrenCanceledTouch = false;
    }
    return true;
  }
  
  public void open()
  {
    openDrawer(8388611);
  }
  
  public void openDrawer(int paramInt)
  {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      openDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void openDrawer(@NonNull View paramView)
  {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(@NonNull View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.mFirstLayout)
      {
        ((LayoutParams)localObject).onScreen = 1.0F;
        ((LayoutParams)localObject).openState = 1;
        updateChildrenImportantForAccessibility(paramView, true);
        updateChildAccessibilityAction(paramView);
      }
      else if (paramBoolean)
      {
        ((LayoutParams)localObject).openState |= 0x2;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 1.0F);
        updateDrawerState(0, paramView);
        paramView.setVisibility(0);
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void removeDrawerListener(@NonNull DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {
      return;
    }
    List localList = this.mListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramDrawerListener);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.mDrawerElevation = paramFloat;
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, this.mDrawerElevation);
      }
    }
  }
  
  @Deprecated
  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    DrawerListener localDrawerListener = this.mListener;
    if (localDrawerListener != null) {
      removeDrawerListener(localDrawerListener);
    }
    if (paramDrawerListener != null) {
      addDrawerListener(paramDrawerListener);
    }
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            this.mLockModeEnd = paramInt1;
          }
        }
        else {
          this.mLockModeStart = paramInt1;
        }
      }
      else {
        this.mLockModeRight = paramInt1;
      }
    }
    else {
      this.mLockModeLeft = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i == 3) {
        localObject = this.mLeftDragger;
      } else {
        localObject = this.mRightDragger;
      }
      ((ViewDragHelper)localObject).cancel();
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2)
      {
        localObject = findDrawerWithGravity(i);
        if (localObject != null) {
          openDrawer((View)localObject);
        }
      }
    }
    else
    {
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        closeDrawer((View)localObject);
      }
    }
  }
  
  public void setDrawerLockMode(int paramInt, @NonNull View paramView)
  {
    if (isDrawerView(paramView))
    {
      setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer with appropriate layout_gravity");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2)
  {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    if ((paramInt & 0x800003) == 8388611)
    {
      this.mShadowStart = paramDrawable;
    }
    else if ((paramInt & 0x800005) == 8388613)
    {
      this.mShadowEnd = paramDrawable;
    }
    else if ((paramInt & 0x3) == 3)
    {
      this.mShadowLeft = paramDrawable;
    }
    else
    {
      if ((paramInt & 0x5) != 5) {
        return;
      }
      this.mShadowRight = paramDrawable;
    }
    resolveShadowDrawables();
    invalidate();
  }
  
  public void setDrawerTitle(int paramInt, @Nullable CharSequence paramCharSequence)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      this.mTitleLeft = paramCharSequence;
    } else if (paramInt == 5) {
      this.mTitleRight = paramCharSequence;
    }
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.onScreen) {
      return;
    }
    localLayoutParams.onScreen = paramFloat;
    dispatchOnDrawerSlide(paramView, paramFloat);
  }
  
  public void setScrimColor(@ColorInt int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    this.mStatusBarBackground = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(@Nullable Drawable paramDrawable)
  {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    this.mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  void updateDrawerState(int paramInt, View paramView)
  {
    int i = this.mLeftDragger.getViewDragState();
    int j = this.mRightDragger.getViewDragState();
    int k = 2;
    int m;
    if ((i != 1) && (j != 1))
    {
      m = k;
      if (i != 2) {
        if (j == 2) {
          m = k;
        } else {
          m = 0;
        }
      }
    }
    else
    {
      m = 1;
    }
    if ((paramView != null) && (paramInt == 0))
    {
      float f = ((LayoutParams)paramView.getLayoutParams()).onScreen;
      if (f == 0.0F) {
        dispatchOnDrawerClosed(paramView);
      } else if (f == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      }
    }
    if (m != this.mDrawerState)
    {
      this.mDrawerState = m;
      paramView = this.mListeners;
      if (paramView != null) {
        for (paramInt = paramView.size() - 1; paramInt >= 0; paramInt--) {
          ((DrawerListener)this.mListeners.get(paramInt)).onDrawerStateChanged(m);
        }
      }
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
    {
      int i = paramViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = paramViewGroup.getChildAt(j);
        if (DrawerLayout.includeChildForAccessibility(localView)) {
          paramAccessibilityNodeInfoCompat.addChild(localView);
        }
      }
    }
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramView = paramAccessibilityEvent.getText();
        paramAccessibilityEvent = DrawerLayout.this.findVisibleDrawer();
        if (paramAccessibilityEvent != null)
        {
          int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(paramAccessibilityEvent);
          paramAccessibilityEvent = DrawerLayout.this.getDrawerTitle(i);
          if (paramAccessibilityEvent != null) {
            paramView.add(paramAccessibilityEvent);
          }
        }
        return true;
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS)
      {
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      }
      else
      {
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
        paramAccessibilityNodeInfoCompat.setSource(paramView);
        ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
        if ((localViewParent instanceof View)) {
          paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
        }
        copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
        localAccessibilityNodeInfoCompat.recycle();
        addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
      }
      paramAccessibilityNodeInfoCompat.setClassName("androidx.drawerlayout.widget.DrawerLayout");
      paramAccessibilityNodeInfoCompat.setFocusable(false);
      paramAccessibilityNodeInfoCompat.setFocused(false);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((!DrawerLayout.CAN_HIDE_DESCENDANTS) && (!DrawerLayout.includeChildForAccessibility(paramView))) {
        return false;
      }
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
  }
  
  static final class ChildAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if (!DrawerLayout.includeChildForAccessibility(paramView)) {
        paramAccessibilityNodeInfoCompat.setParent(null);
      }
    }
  }
  
  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed(@NonNull View paramView);
    
    public abstract void onDrawerOpened(@NonNull View paramView);
    
    public abstract void onDrawerSlide(@NonNull View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int FLAG_IS_CLOSING = 4;
    private static final int FLAG_IS_OPENED = 1;
    private static final int FLAG_IS_OPENING = 2;
    public int gravity = 0;
    boolean isPeeking;
    float onScreen;
    int openState;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2);
    }
    
    public LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(@NonNull ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(@NonNull LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public DrawerLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new DrawerLayout.SavedState[paramAnonymousInt];
      }
    };
    int lockModeEnd;
    int lockModeLeft;
    int lockModeRight;
    int lockModeStart;
    int openDrawerGravity = 0;
    
    public SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.openDrawerGravity = paramParcel.readInt();
      this.lockModeLeft = paramParcel.readInt();
      this.lockModeRight = paramParcel.readInt();
      this.lockModeStart = paramParcel.readInt();
      this.lockModeEnd = paramParcel.readInt();
    }
    
    public SavedState(@NonNull Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.openDrawerGravity);
      paramParcel.writeInt(this.lockModeLeft);
      paramParcel.writeInt(this.lockModeRight);
      paramParcel.writeInt(this.lockModeStart);
      paramParcel.writeInt(this.lockModeEnd);
    }
  }
  
  public static abstract class SimpleDrawerListener
    implements DrawerLayout.DrawerListener
  {
    public void onDrawerClosed(View paramView) {}
    
    public void onDrawerOpened(View paramView) {}
    
    public void onDrawerSlide(View paramView, float paramFloat) {}
    
    public void onDrawerStateChanged(int paramInt) {}
  }
  
  private class ViewDragCallback
    extends ViewDragHelper.Callback
  {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new Runnable()
    {
      public void run()
      {
        DrawerLayout.ViewDragCallback.this.peekDrawer();
      }
    };
    
    ViewDragCallback(int paramInt)
    {
      this.mAbsGravity = paramInt;
    }
    
    private void closeOtherDrawer()
    {
      int i = this.mAbsGravity;
      int j = 3;
      if (i == 3) {
        j = 5;
      }
      View localView = DrawerLayout.this.findDrawerWithGravity(j);
      if (localView != null) {
        DrawerLayout.this.closeDrawer(localView);
      }
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      }
      paramInt2 = DrawerLayout.this.getWidth();
      return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      int i;
      if (DrawerLayout.this.isDrawerView(paramView)) {
        i = paramView.getWidth();
      } else {
        i = 0;
      }
      return i;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      View localView;
      if ((paramInt1 & 0x1) == 1) {
        localView = DrawerLayout.this.findDrawerWithGravity(3);
      } else {
        localView = DrawerLayout.this.findDrawerWithGravity(5);
      }
      if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0)) {
        this.mDragger.captureChildView(localView, paramInt2);
      }
    }
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
      closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout.this.updateDrawerState(paramInt, this.mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
        f = paramInt1 + paramInt2;
      } else {
        f = DrawerLayout.this.getWidth() - paramInt1;
      }
      f /= paramInt2;
      DrawerLayout.this.setDrawerViewOffset(paramView, f);
      if (f == 0.0F) {
        paramInt1 = 4;
      } else {
        paramInt1 = 0;
      }
      paramView.setVisibility(paramInt1);
      DrawerLayout.this.invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.this.getDrawerViewOffset(paramView);
      int i = paramView.getWidth();
      int j;
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        boolean bool = paramFloat1 < 0.0F;
        if ((!bool) && ((bool) || (paramFloat2 <= 0.5F))) {
          j = -i;
        } else {
          j = 0;
        }
      }
      else
      {
        int k = DrawerLayout.this.getWidth();
        if (paramFloat1 >= 0.0F)
        {
          j = k;
          if (paramFloat1 == 0.0F)
          {
            j = k;
            if (paramFloat2 <= 0.5F) {}
          }
        }
        else
        {
          j = k - i;
        }
      }
      this.mDragger.settleCapturedViewAt(j, paramView.getTop());
      DrawerLayout.this.invalidate();
    }
    
    void peekDrawer()
    {
      int i = this.mDragger.getEdgeSize();
      int j = this.mAbsGravity;
      int k = 0;
      if (j == 3) {
        j = 1;
      } else {
        j = 0;
      }
      View localView;
      if (j != 0)
      {
        localView = DrawerLayout.this.findDrawerWithGravity(3);
        if (localView != null) {
          k = -localView.getWidth();
        }
        k += i;
      }
      else
      {
        localView = DrawerLayout.this.findDrawerWithGravity(5);
        k = DrawerLayout.this.getWidth() - i;
      }
      if ((localView != null) && (((j != 0) && (localView.getLeft() < k)) || ((j == 0) && (localView.getLeft() > k) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.mDragger.smoothSlideViewTo(localView, k, localView.getTop());
        localLayoutParams.isPeeking = true;
        DrawerLayout.this.invalidate();
        closeOtherDrawer();
        DrawerLayout.this.cancelChildViewTouch();
      }
    }
    
    public void removeCallbacks()
    {
      DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
    }
    
    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      this.mDragger = paramViewDragHelper;
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      boolean bool;
      if ((DrawerLayout.this.isDrawerView(paramView)) && (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) && (DrawerLayout.this.getDrawerLockMode(paramView) == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\drawerlayout\widget\DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */