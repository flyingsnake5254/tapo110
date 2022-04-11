package com.tplink.libtpcontrols;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class TPHorizontalListView
  extends AdapterView<ListAdapter>
{
  private AdapterView.OnItemClickListener H3;
  private AdapterView.OnItemLongClickListener I3;
  private boolean J3 = false;
  private DataSetObserver K3 = new a();
  private GestureDetector.OnGestureListener L3 = new b();
  protected ListAdapter c;
  private int d = -1;
  private int f = 0;
  protected Scroller p0;
  private GestureDetector p1;
  private Queue<View> p2 = new LinkedList();
  private AdapterView.OnItemSelectedListener p3;
  protected int q;
  protected int x;
  private int y = Integer.MAX_VALUE;
  private int z = 0;
  
  public TPHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k();
  }
  
  private void g(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams1 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = localLayoutParams1;
    if (localLayoutParams1 == null) {
      localLayoutParams2 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams2, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
  }
  
  private void h(int paramInt)
  {
    View localView = getChildAt(getChildCount() - 1);
    int i = 0;
    if (localView != null) {
      j = localView.getRight();
    } else {
      j = 0;
    }
    j(j, paramInt);
    localView = getChildAt(0);
    int j = i;
    if (localView != null) {
      j = localView.getLeft();
    }
    i(j, paramInt);
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    while (paramInt1 + paramInt2 > 0)
    {
      int i = this.d;
      if (i < 0) {
        break;
      }
      View localView = this.c.getView(i, (View)this.p2.poll(), this);
      g(localView, 0);
      paramInt1 -= localView.getMeasuredWidth();
      this.d -= 1;
      this.z -= localView.getMeasuredWidth();
    }
  }
  
  private void j(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 < getWidth()) && (this.f < this.c.getCount()))
    {
      View localView = this.c.getView(this.f, (View)this.p2.poll(), this);
      g(localView, -1);
      paramInt1 += localView.getMeasuredWidth();
      if (this.f == this.c.getCount() - 1) {
        this.y = (this.q + paramInt1 - getWidth());
      }
      if (this.y < 0) {
        this.y = 0;
      }
      this.f += 1;
    }
  }
  
  private void k()
  {
    try
    {
      this.d = -1;
      this.f = 0;
      this.z = 0;
      this.q = 0;
      this.x = 0;
      this.y = Integer.MAX_VALUE;
      Object localObject1 = new android/widget/Scroller;
      ((Scroller)localObject1).<init>(getContext());
      this.p0 = ((Scroller)localObject1);
      localObject1 = new android/view/GestureDetector;
      ((GestureDetector)localObject1).<init>(getContext(), this.L3);
      this.p1 = ((GestureDetector)localObject1);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  private void n(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int i = this.z + paramInt;
      this.z = i;
      for (paramInt = 0; paramInt < getChildCount(); paramInt++)
      {
        View localView = getChildAt(paramInt);
        int j = localView.getMeasuredWidth();
        localView.layout(i, 0, i + j, localView.getMeasuredHeight());
        i += j + localView.getPaddingRight();
      }
    }
  }
  
  private void o(int paramInt)
  {
    for (View localView = getChildAt(0); (localView != null) && (localView.getRight() + paramInt <= 0); localView = getChildAt(0))
    {
      this.z += localView.getMeasuredWidth();
      this.p2.offer(localView);
      removeViewInLayout(localView);
      this.d += 1;
    }
    for (localView = getChildAt(getChildCount() - 1); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getChildAt(getChildCount() - 1))
    {
      this.p2.offer(localView);
      removeViewInLayout(localView);
      this.f -= 1;
    }
  }
  
  private void p()
  {
    try
    {
      k();
      removeAllViewsInLayout();
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    return this.p1.onTouchEvent(paramMotionEvent) | bool;
  }
  
  public ListAdapter getAdapter()
  {
    return this.c;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected boolean l(MotionEvent paramMotionEvent)
  {
    this.p0.forceFinished(true);
    return true;
  }
  
  protected boolean m(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      this.p0.fling(this.x, 0, (int)-paramFloat1, 0, 0, this.y, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      Object localObject1 = this.c;
      if (localObject1 == null) {
        return;
      }
      if (this.J3)
      {
        paramInt1 = this.q;
        k();
        removeAllViewsInLayout();
        this.x = paramInt1;
        this.J3 = false;
      }
      if (this.p0.computeScrollOffset()) {
        this.x = this.p0.getCurrX();
      }
      if (this.x <= 0)
      {
        this.x = 0;
        this.p0.forceFinished(true);
      }
      paramInt2 = this.x;
      paramInt1 = this.y;
      if (paramInt2 >= paramInt1)
      {
        this.x = paramInt1;
        this.p0.forceFinished(true);
      }
      paramInt1 = this.q - this.x;
      o(paramInt1);
      h(paramInt1);
      n(paramInt1);
      this.q = this.x;
      if (!this.p0.isFinished())
      {
        localObject1 = new com/tplink/libtpcontrols/k0;
        ((k0)localObject1).<init>(this);
        post((Runnable)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.c;
    if (localListAdapter != null) {
      localListAdapter.unregisterDataSetObserver(this.K3);
    }
    this.c = paramListAdapter;
    paramListAdapter.registerDataSetObserver(this.K3);
    p();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.H3 = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.I3 = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.p3 = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
  
  class a
    extends DataSetObserver
  {
    a() {}
    
    public void onChanged()
    {
      synchronized (TPHorizontalListView.this)
      {
        TPHorizontalListView.a(TPHorizontalListView.this, true);
        TPHorizontalListView.this.invalidate();
        TPHorizontalListView.this.requestLayout();
        return;
      }
    }
    
    public void onInvalidated()
    {
      TPHorizontalListView.b(TPHorizontalListView.this);
      TPHorizontalListView.this.invalidate();
      TPHorizontalListView.this.requestLayout();
    }
  }
  
  class b
    extends GestureDetector.SimpleOnGestureListener
  {
    b() {}
    
    private boolean a(MotionEvent paramMotionEvent, View paramView)
    {
      Rect localRect = new Rect();
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = paramView.getWidth();
      int k = arrayOfInt[1];
      localRect.set(i, k, j + i, paramView.getHeight() + k);
      return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return TPHorizontalListView.this.l(paramMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return TPHorizontalListView.this.m(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      int i = TPHorizontalListView.this.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = TPHorizontalListView.this.getChildAt(j);
        if (a(paramMotionEvent, localView))
        {
          if (TPHorizontalListView.f(TPHorizontalListView.this) == null) {
            break;
          }
          AdapterView.OnItemLongClickListener localOnItemLongClickListener = TPHorizontalListView.f(TPHorizontalListView.this);
          TPHorizontalListView localTPHorizontalListView = TPHorizontalListView.this;
          i = TPHorizontalListView.d(localTPHorizontalListView);
          paramMotionEvent = TPHorizontalListView.this;
          localOnItemLongClickListener.onItemLongClick(localTPHorizontalListView, localView, i + 1 + j, paramMotionEvent.c.getItemId(TPHorizontalListView.d(paramMotionEvent) + 1 + j));
          break;
        }
      }
    }
    
    public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      synchronized (TPHorizontalListView.this)
      {
        paramMotionEvent2 = TPHorizontalListView.this;
        paramMotionEvent2.x += (int)paramFloat1;
        paramMotionEvent2.requestLayout();
        return true;
      }
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      for (int i = 0; i < TPHorizontalListView.this.getChildCount(); i++)
      {
        View localView = TPHorizontalListView.this.getChildAt(i);
        if (a(paramMotionEvent, localView))
        {
          if (TPHorizontalListView.c(TPHorizontalListView.this) != null)
          {
            localObject = TPHorizontalListView.c(TPHorizontalListView.this);
            localTPHorizontalListView = TPHorizontalListView.this;
            j = TPHorizontalListView.d(localTPHorizontalListView);
            paramMotionEvent = TPHorizontalListView.this;
            ((AdapterView.OnItemClickListener)localObject).onItemClick(localTPHorizontalListView, localView, j + 1 + i, paramMotionEvent.c.getItemId(TPHorizontalListView.d(paramMotionEvent) + 1 + i));
          }
          if (TPHorizontalListView.e(TPHorizontalListView.this) == null) {
            break;
          }
          paramMotionEvent = TPHorizontalListView.e(TPHorizontalListView.this);
          Object localObject = TPHorizontalListView.this;
          int j = TPHorizontalListView.d((TPHorizontalListView)localObject);
          TPHorizontalListView localTPHorizontalListView = TPHorizontalListView.this;
          paramMotionEvent.onItemSelected((AdapterView)localObject, localView, j + 1 + i, localTPHorizontalListView.c.getItemId(TPHorizontalListView.d(localTPHorizontalListView) + 1 + i));
          break;
        }
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPHorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */