package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R.attr;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

class DropDownListView
  extends ListView
{
  public static final int INVALID_POSITION = -1;
  public static final int NO_POSITION = -1;
  private ViewPropertyAnimatorCompat mClickAnimation;
  private boolean mDrawsInPressedState;
  private boolean mHijackFocus;
  private Field mIsChildViewEnabled;
  private boolean mListSelectionHidden;
  private int mMotionPosition;
  ResolveHoverRunnable mResolveHoverRunnable;
  private ListViewAutoScrollHelper mScrollHelper;
  private int mSelectionBottomPadding = 0;
  private int mSelectionLeftPadding = 0;
  private int mSelectionRightPadding = 0;
  private int mSelectionTopPadding = 0;
  private GateKeeperDrawable mSelector;
  private final Rect mSelectorRect = new Rect();
  
  DropDownListView(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
    try
    {
      paramContext = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled = paramContext;
      paramContext.setAccessible(true);
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void clearPressedItem()
  {
    this.mDrawsInPressedState = false;
    setPressed(false);
    drawableStateChanged();
    Object localObject = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    localObject = this.mClickAnimation;
    if (localObject != null)
    {
      ((ViewPropertyAnimatorCompat)localObject).cancel();
      this.mClickAnimation = null;
    }
  }
  
  private void clickPressedItem(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void drawSelectorCompat(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.mSelectorRect);
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  private void positionSelectorCompat(int paramInt, View paramView)
  {
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.mSelectionLeftPadding;
    localRect.top -= this.mSelectionTopPadding;
    localRect.right += this.mSelectionRightPadding;
    localRect.bottom += this.mSelectionBottomPadding;
    try
    {
      boolean bool = this.mIsChildViewEnabled.getBoolean(this);
      if (paramView.isEnabled() != bool)
      {
        paramView = this.mIsChildViewEnabled;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
        paramView.set(this, Boolean.valueOf(bool));
        if (paramInt != -1) {
          refreshDrawableState();
        }
      }
    }
    catch (IllegalAccessException paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void positionSelectorLikeFocusCompat(int paramInt, View paramView)
  {
    Drawable localDrawable = getSelector();
    boolean bool = true;
    int i;
    if ((localDrawable != null) && (paramInt != -1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localDrawable.setVisible(false, false);
    }
    positionSelectorCompat(paramInt, paramView);
    if (i != 0)
    {
      paramView = this.mSelectorRect;
      float f1 = paramView.exactCenterX();
      float f2 = paramView.exactCenterY();
      if (getVisibility() != 0) {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
    }
  }
  
  private void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    paramView = getSelector();
    if ((paramView != null) && (paramInt != -1)) {
      DrawableCompat.setHotspot(paramView, paramFloat1, paramFloat2);
    }
  }
  
  private void setPressedItem(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mDrawsInPressedState = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (!isPressed()) {
      setPressed(true);
    }
    layoutChildren();
    int j = this.mMotionPosition;
    if (j != -1)
    {
      View localView = getChildAt(j - getFirstVisiblePosition());
      if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
        localView.setPressed(false);
      }
    }
    this.mMotionPosition = paramInt;
    float f1 = paramView.getLeft();
    float f2 = paramView.getTop();
    if (i >= 21) {
      paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2);
    }
    if (!paramView.isPressed()) {
      paramView.setPressed(true);
    }
    positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    GateKeeperDrawable localGateKeeperDrawable = this.mSelector;
    if (localGateKeeperDrawable != null) {
      localGateKeeperDrawable.setEnabled(paramBoolean);
    }
  }
  
  private boolean touchModeDrawsInPressedStateCompat()
  {
    return this.mDrawsInPressedState;
  }
  
  private void updateSelectorStateCompat()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (touchModeDrawsInPressedStateCompat()) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.mResolveHoverRunnable != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    updateSelectorStateCompat();
  }
  
  public boolean hasFocus()
  {
    boolean bool;
    if ((!this.mHijackFocus) && (!super.hasFocus())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean hasWindowFocus()
  {
    boolean bool;
    if ((!this.mHijackFocus) && (!super.hasWindowFocus())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFocused()
  {
    boolean bool;
    if ((!this.mHijackFocus) && (!super.isFocused())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isInTouchMode()
  {
    boolean bool;
    if (((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != null) && (!isInTouchMode()))
    {
      int i = localListAdapter.getCount();
      if (!getAdapter().areAllItemsEnabled())
      {
        int j;
        if (paramBoolean) {
          for (paramInt = Math.max(0, paramInt);; paramInt++)
          {
            j = paramInt;
            if (paramInt >= i) {
              break;
            }
            j = paramInt;
            if (localListAdapter.isEnabled(paramInt)) {
              break;
            }
          }
        }
        for (paramInt = Math.min(paramInt, i - 1);; paramInt--)
        {
          j = paramInt;
          if (paramInt < 0) {
            break;
          }
          j = paramInt;
          if (localListAdapter.isEnabled(paramInt)) {
            break;
          }
        }
        if ((j >= 0) && (j < i)) {
          return j;
        }
        return -1;
      }
      if ((paramInt >= 0) && (paramInt < i)) {
        return paramInt;
      }
    }
    return -1;
  }
  
  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt3 = getListPaddingTop();
    paramInt2 = getListPaddingBottom();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt3 + paramInt2;
    }
    paramInt3 += paramInt2;
    if ((i <= 0) || (localObject == null)) {
      i = 0;
    }
    int j = localListAdapter.getCount();
    localObject = null;
    int k = 0;
    int m = 0;
    int n;
    for (paramInt2 = 0; k < j; paramInt2 = n)
    {
      n = localListAdapter.getItemViewType(k);
      int i1 = m;
      if (n != m)
      {
        localObject = null;
        i1 = n;
      }
      View localView = localListAdapter.getView(k, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      m = ((ViewGroup.LayoutParams)localObject).height;
      if (m > 0) {
        m = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
      } else {
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, m);
      localView.forceLayout();
      m = paramInt3;
      if (k > 0) {
        m = paramInt3 + i;
      }
      paramInt3 = m + localView.getMeasuredHeight();
      if (paramInt3 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (k > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt2 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt3 != paramInt4) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
        return paramInt1;
      }
      n = paramInt2;
      if (paramInt5 >= 0)
      {
        n = paramInt2;
        if (k >= paramInt5) {
          n = paramInt3;
        }
      }
      k++;
      m = i1;
      localObject = localView;
    }
    return paramInt3;
  }
  
  protected void onDetachedFromWindow()
  {
    this.mResolveHoverRunnable = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {}
      }
    }
    boolean bool;
    for (;;)
    {
      paramInt = 0;
      bool = true;
      break;
      label45:
      do
      {
        paramInt = 0;
        bool = false;
        break;
        bool = true;
        break label45;
        bool = false;
        j = paramMotionEvent.findPointerIndex(paramInt);
      } while (j < 0);
      paramInt = (int)paramMotionEvent.getX(j);
      int k = (int)paramMotionEvent.getY(j);
      int j = pointToPosition(paramInt, k);
      if (j == -1)
      {
        paramInt = 1;
        break;
      }
      View localView = getChildAt(j - getFirstVisiblePosition());
      setPressedItem(localView, j, paramInt, k);
      if (i == 1) {
        clickPressedItem(localView, j);
      }
    }
    if ((!bool) || (paramInt != 0)) {
      clearPressedItem();
    }
    if (bool)
    {
      if (this.mScrollHelper == null) {
        this.mScrollHelper = new ListViewAutoScrollHelper(this);
      }
      this.mScrollHelper.setEnabled(true);
      this.mScrollHelper.onTouch(this, paramMotionEvent);
    }
    else
    {
      paramMotionEvent = this.mScrollHelper;
      if (paramMotionEvent != null) {
        paramMotionEvent.setEnabled(false);
      }
    }
    return bool;
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 10) && (this.mResolveHoverRunnable == null))
    {
      ResolveHoverRunnable localResolveHoverRunnable = new ResolveHoverRunnable();
      this.mResolveHoverRunnable = localResolveHoverRunnable;
      localResolveHoverRunnable.post();
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i != 9) && (i != 7))
    {
      setSelection(-1);
    }
    else
    {
      i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i != -1) && (i != getSelectedItemPosition()))
      {
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
        if (paramMotionEvent.isEnabled()) {
          setSelectionFromTop(i, paramMotionEvent.getTop() - getTop());
        }
        updateSelectorStateCompat();
      }
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    ResolveHoverRunnable localResolveHoverRunnable = this.mResolveHoverRunnable;
    if (localResolveHoverRunnable != null) {
      localResolveHoverRunnable.cancel();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.mListSelectionHidden = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new GateKeeperDrawable(paramDrawable);
    } else {
      localObject = null;
    }
    this.mSelector = ((GateKeeperDrawable)localObject);
    super.setSelector((Drawable)localObject);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    this.mSelectionLeftPadding = ((Rect)localObject).left;
    this.mSelectionTopPadding = ((Rect)localObject).top;
    this.mSelectionRightPadding = ((Rect)localObject).right;
    this.mSelectionBottomPadding = ((Rect)localObject).bottom;
  }
  
  private static class GateKeeperDrawable
    extends DrawableWrapper
  {
    private boolean mEnabled = true;
    
    GateKeeperDrawable(Drawable paramDrawable)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      if (this.mEnabled) {
        super.draw(paramCanvas);
      }
    }
    
    void setEnabled(boolean paramBoolean)
    {
      this.mEnabled = paramBoolean;
    }
    
    public void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public boolean setState(int[] paramArrayOfInt)
    {
      if (this.mEnabled) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.mEnabled) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  private class ResolveHoverRunnable
    implements Runnable
  {
    ResolveHoverRunnable() {}
    
    public void cancel()
    {
      DropDownListView localDropDownListView = DropDownListView.this;
      localDropDownListView.mResolveHoverRunnable = null;
      localDropDownListView.removeCallbacks(this);
    }
    
    public void post()
    {
      DropDownListView.this.post(this);
    }
    
    public void run()
    {
      DropDownListView localDropDownListView = DropDownListView.this;
      localDropDownListView.mResolveHoverRunnable = null;
      localDropDownListView.drawableStateChanged();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\DropDownListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */