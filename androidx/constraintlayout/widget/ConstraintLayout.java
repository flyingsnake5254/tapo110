package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Analyzer;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.ResolutionAnchor;
import androidx.constraintlayout.solver.widgets.ResolutionDimension;
import androidx.constraintlayout.solver.widgets.ResolutionNode;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean CACHE_MEASURED_DIMENSION = false;
  private static final boolean DEBUG = false;
  public static final int DESIGN_INFO_ID = 0;
  private static final String TAG = "ConstraintLayout";
  private static final boolean USE_CONSTRAINTS_HELPER = true;
  public static final String VERSION = "ConstraintLayout-1.1.3";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
  private ConstraintSet mConstraintSet = null;
  private int mConstraintSetId = -1;
  private HashMap<String, Integer> mDesignIds = new HashMap();
  private boolean mDirtyHierarchy = true;
  private int mLastMeasureHeight = -1;
  int mLastMeasureHeightMode = 0;
  int mLastMeasureHeightSize = -1;
  private int mLastMeasureWidth = -1;
  int mLastMeasureWidthMode = 0;
  int mLastMeasureWidthSize = -1;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = Integer.MAX_VALUE;
  private int mMaxWidth = Integer.MAX_VALUE;
  private Metrics mMetrics;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 7;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView = (View)this.mChildrenByIds.get(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localView = findViewById(paramInt);
      localObject = localView;
      if (localView != null)
      {
        localObject = localView;
        if (localView != this)
        {
          localObject = localView;
          if (localView.getParent() == this)
          {
            onViewAdded(localView);
            localObject = localView;
          }
        }
      }
    }
    if (localObject == this) {
      return this.mLayoutWidget;
    }
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((LayoutParams)((View)localObject).getLayoutParams()).widget;
    }
    return (ConstraintWidget)localObject;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth)
        {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMinWidth);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight)
        {
          this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMinHeight);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth)
        {
          this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxWidth);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight)
        {
          this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxHeight);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          this.mOptimizationLevel = paramAttributeSet.getInt(k, this.mOptimizationLevel);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_constraintSet)
        {
          k = paramAttributeSet.getResourceId(k, 0);
          try
          {
            ConstraintSet localConstraintSet = new androidx/constraintlayout/widget/ConstraintSet;
            localConstraintSet.<init>();
            this.mConstraintSet = localConstraintSet;
            localConstraintSet.load(getContext(), k);
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            this.mConstraintSet = null;
          }
          this.mConstraintSetId = k;
        }
      }
      paramAttributeSet.recycle();
    }
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop() + getPaddingBottom();
    int j = getPaddingLeft() + getPaddingRight();
    int k = getChildCount();
    for (int m = 0; m < k; m++)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        ConstraintWidget localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          int n = localLayoutParams.width;
          int i1 = localLayoutParams.height;
          boolean bool1 = localLayoutParams.horizontalDimensionFixed;
          boolean bool2;
          if (!bool1)
          {
            bool2 = localLayoutParams.verticalDimensionFixed;
            if ((!bool2) && ((bool1) || (localLayoutParams.matchConstraintDefaultWidth != 1)) && (n != -1) && ((bool2) || ((localLayoutParams.matchConstraintDefaultHeight != 1) && (i1 != -1))))
            {
              i2 = 0;
              break label194;
            }
          }
          int i2 = 1;
          label194:
          int i3;
          int i4;
          int i5;
          if (i2 != 0)
          {
            if (n == 0)
            {
              i3 = ViewGroup.getChildMeasureSpec(paramInt1, j, -2);
              i2 = 1;
            }
            else if (n == -1)
            {
              i3 = ViewGroup.getChildMeasureSpec(paramInt1, j, -1);
              i2 = 0;
            }
            else
            {
              if (n == -2) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              i3 = ViewGroup.getChildMeasureSpec(paramInt1, j, n);
            }
            if (i1 == 0)
            {
              i4 = ViewGroup.getChildMeasureSpec(paramInt2, i, -2);
              i5 = 1;
            }
            else if (i1 == -1)
            {
              i4 = ViewGroup.getChildMeasureSpec(paramInt2, i, -1);
              i5 = 0;
            }
            else
            {
              if (i1 == -2) {
                i5 = 1;
              } else {
                i5 = 0;
              }
              i4 = ViewGroup.getChildMeasureSpec(paramInt2, i, i1);
            }
            localView.measure(i3, i4);
            Metrics localMetrics = this.mMetrics;
            if (localMetrics != null) {
              localMetrics.measures += 1L;
            }
            if (n == -2) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            localConstraintWidget.setWidthWrapContent(bool2);
            if (i1 == -2) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            localConstraintWidget.setHeightWrapContent(bool2);
            i4 = localView.getMeasuredWidth();
            i3 = localView.getMeasuredHeight();
          }
          else
          {
            i2 = 0;
            i5 = 0;
            i3 = i1;
            i4 = n;
          }
          localConstraintWidget.setWidth(i4);
          localConstraintWidget.setHeight(i3);
          if (i2 != 0) {
            localConstraintWidget.setWrapWidth(i4);
          }
          if (i5 != 0) {
            localConstraintWidget.setWrapHeight(i3);
          }
          if (localLayoutParams.needsBaseline)
          {
            i2 = localView.getBaseline();
            if (i2 != -1) {
              localConstraintWidget.setBaselineDistance(i2);
            }
          }
        }
      }
    }
  }
  
  private void internalMeasureDimensions(int paramInt1, int paramInt2)
  {
    Object localObject1 = this;
    int i = getPaddingTop() + getPaddingBottom();
    int j = getPaddingLeft() + getPaddingRight();
    int k = getChildCount();
    long l1;
    View localView;
    LayoutParams localLayoutParams;
    ConstraintWidget localConstraintWidget;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    Object localObject2;
    boolean bool;
    for (int m = 0;; m++)
    {
      l1 = 1L;
      if (m >= k) {
        break;
      }
      localView = ((ViewGroup)localObject1).getChildAt(m);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          n = localLayoutParams.width;
          i1 = localLayoutParams.height;
          if ((n != 0) && (i1 != 0))
          {
            if (n == -2) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            i3 = ViewGroup.getChildMeasureSpec(paramInt1, j, n);
            if (i1 == -2) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            localView.measure(i3, ViewGroup.getChildMeasureSpec(paramInt2, i, i1));
            localObject2 = ((ConstraintLayout)localObject1).mMetrics;
            if (localObject2 != null) {
              ((Metrics)localObject2).measures += 1L;
            }
            if (n == -2) {
              bool = true;
            } else {
              bool = false;
            }
            localConstraintWidget.setWidthWrapContent(bool);
            if (i1 == -2) {
              bool = true;
            } else {
              bool = false;
            }
            localConstraintWidget.setHeightWrapContent(bool);
            i1 = localView.getMeasuredWidth();
            n = localView.getMeasuredHeight();
            localConstraintWidget.setWidth(i1);
            localConstraintWidget.setHeight(n);
            if (i2 != 0) {
              localConstraintWidget.setWrapWidth(i1);
            }
            if (i4 != 0) {
              localConstraintWidget.setWrapHeight(n);
            }
            if (localLayoutParams.needsBaseline)
            {
              i2 = localView.getBaseline();
              if (i2 != -1) {
                localConstraintWidget.setBaselineDistance(i2);
              }
            }
            if ((localLayoutParams.horizontalDimensionFixed) && (localLayoutParams.verticalDimensionFixed))
            {
              localConstraintWidget.getResolutionWidth().resolve(i1);
              localConstraintWidget.getResolutionHeight().resolve(n);
            }
          }
          else
          {
            localConstraintWidget.getResolutionWidth().invalidate();
            localConstraintWidget.getResolutionHeight().invalidate();
          }
        }
      }
    }
    ((ConstraintLayout)localObject1).mLayoutWidget.solveGraph();
    for (int i5 = 0;; i5++)
    {
      n = paramInt1;
      localObject1 = this;
      if (i5 >= k) {
        break;
      }
      localView = ((ViewGroup)localObject1).getChildAt(i5);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          i3 = localLayoutParams.width;
          i2 = localLayoutParams.height;
          if ((i3 == 0) || (i2 == 0))
          {
            Object localObject3 = ConstraintAnchor.Type.LEFT;
            localObject2 = localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject3).getResolutionNode();
            Object localObject4 = ConstraintAnchor.Type.RIGHT;
            ResolutionAnchor localResolutionAnchor = localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject4).getResolutionNode();
            if ((localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject3).getTarget() != null) && (localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject4).getTarget() != null)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            Object localObject5 = ConstraintAnchor.Type.TOP;
            localObject3 = localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject5).getResolutionNode();
            Object localObject6 = ConstraintAnchor.Type.BOTTOM;
            localObject4 = localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject6).getResolutionNode();
            int i6;
            if ((localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject5).getTarget() != null) && (localConstraintWidget.getAnchor((ConstraintAnchor.Type)localObject6).getTarget() != null)) {
              i6 = 1;
            } else {
              i6 = 0;
            }
            if ((i3 == 0) && (i2 == 0) && (i4 != 0) && (i6 != 0))
            {
              l1 = 1L;
            }
            else
            {
              localObject6 = ((ConstraintLayout)localObject1).mLayoutWidget.getHorizontalDimensionBehaviour();
              localObject5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
              if (localObject6 != localObject5) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (((ConstraintLayout)localObject1).mLayoutWidget.getVerticalDimensionBehaviour() != localObject5) {
                m = 1;
              } else {
                m = 0;
              }
              if (i1 == 0) {
                localConstraintWidget.getResolutionWidth().invalidate();
              }
              if (m == 0) {
                localConstraintWidget.getResolutionHeight().invalidate();
              }
              if (i3 == 0)
              {
                if ((i1 != 0) && (localConstraintWidget.isSpreadWidth()) && (i4 != 0) && (((ResolutionNode)localObject2).isResolved()) && (localResolutionAnchor.isResolved()))
                {
                  i3 = (int)(localResolutionAnchor.getResolvedValue() - ((ResolutionAnchor)localObject2).getResolvedValue());
                  localConstraintWidget.getResolutionWidth().resolve(i3);
                  n = ViewGroup.getChildMeasureSpec(n, j, i3);
                }
                else
                {
                  n = ViewGroup.getChildMeasureSpec(n, j, -2);
                  i4 = 1;
                  i7 = 0;
                  i8 = i3;
                  break label930;
                }
              }
              else
              {
                if (i3 != -1) {
                  break label895;
                }
                n = ViewGroup.getChildMeasureSpec(n, j, -1);
              }
              i4 = 0;
              int i8 = i3;
              int i7 = i1;
              break label930;
              label895:
              if (i3 == -2) {
                i4 = 1;
              } else {
                i4 = 0;
              }
              n = ViewGroup.getChildMeasureSpec(n, j, i3);
              i7 = i1;
              i8 = i3;
              label930:
              if (i2 == 0)
              {
                if ((m != 0) && (localConstraintWidget.isSpreadHeight()) && (i6 != 0) && (((ResolutionNode)localObject3).isResolved()) && (((ResolutionNode)localObject4).isResolved()))
                {
                  i3 = (int)(((ResolutionAnchor)localObject4).getResolvedValue() - ((ResolutionAnchor)localObject3).getResolvedValue());
                  localConstraintWidget.getResolutionHeight().resolve(i3);
                  i1 = ViewGroup.getChildMeasureSpec(paramInt2, i, i3);
                }
                else
                {
                  i1 = ViewGroup.getChildMeasureSpec(paramInt2, i, -2);
                  i3 = i2;
                  m = 0;
                  i2 = 1;
                  break label1092;
                }
              }
              else
              {
                if (i2 != -1) {
                  break label1054;
                }
                i1 = ViewGroup.getChildMeasureSpec(paramInt2, i, -1);
                i3 = i2;
              }
              i2 = 0;
              break label1092;
              label1054:
              if (i2 == -2) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              i6 = ViewGroup.getChildMeasureSpec(paramInt2, i, i2);
              i3 = i2;
              i2 = i1;
              i1 = i6;
              label1092:
              localView.measure(n, i1);
              localObject1 = ((ConstraintLayout)localObject1).mMetrics;
              if (localObject1 != null) {
                ((Metrics)localObject1).measures += 1L;
              }
              long l2 = 1L;
              if (i8 == -2) {
                bool = true;
              } else {
                bool = false;
              }
              localConstraintWidget.setWidthWrapContent(bool);
              if (i3 == -2) {
                bool = true;
              } else {
                bool = false;
              }
              localConstraintWidget.setHeightWrapContent(bool);
              n = localView.getMeasuredWidth();
              i1 = localView.getMeasuredHeight();
              localConstraintWidget.setWidth(n);
              localConstraintWidget.setHeight(i1);
              if (i4 != 0) {
                localConstraintWidget.setWrapWidth(n);
              }
              if (i2 != 0) {
                localConstraintWidget.setWrapHeight(i1);
              }
              if (i7 != 0) {
                localConstraintWidget.getResolutionWidth().resolve(n);
              } else {
                localConstraintWidget.getResolutionWidth().remove();
              }
              if (m != 0) {
                localConstraintWidget.getResolutionHeight().resolve(i1);
              } else {
                localConstraintWidget.getResolutionHeight().remove();
              }
              if (localLayoutParams.needsBaseline)
              {
                m = localView.getBaseline();
                l1 = l2;
                if (m != -1)
                {
                  localConstraintWidget.setBaselineDistance(m);
                  l1 = l2;
                }
              }
              else
              {
                l1 = l2;
              }
            }
          }
        }
      }
    }
  }
  
  private void setChildrenConstraints()
  {
    boolean bool = isInEditMode();
    int i = getChildCount();
    int j = 0;
    int k = -1;
    if (bool)
    {
      m = 0;
      while (m < i)
      {
        Object localObject1 = getChildAt(m);
        try
        {
          localObject2 = getResources().getResourceName(((View)localObject1).getId());
          setDesignInformation(0, localObject2, Integer.valueOf(((View)localObject1).getId()));
          n = ((String)localObject2).indexOf('/');
          localObject3 = localObject2;
          if (n != -1) {
            localObject3 = ((String)localObject2).substring(n + 1);
          }
          getTargetWidget(((View)localObject1).getId()).setDebugName((String)localObject3);
          m++;
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          Object localObject2;
          int n;
          Object localObject3;
          int i1;
          for (;;) {}
        }
      }
    }
    for (int m = 0; m < i; m++)
    {
      localObject3 = getViewWidget(getChildAt(m));
      if (localObject3 != null) {
        ((ConstraintWidget)localObject3).reset();
      }
    }
    if (this.mConstraintSetId != -1) {
      for (m = 0; m < i; m++)
      {
        localObject3 = getChildAt(m);
        if ((((View)localObject3).getId() == this.mConstraintSetId) && ((localObject3 instanceof Constraints))) {
          this.mConstraintSet = ((Constraints)localObject3).getConstraintSet();
        }
      }
    }
    localObject3 = this.mConstraintSet;
    if (localObject3 != null) {
      ((ConstraintSet)localObject3).applyToInternal(this);
    }
    this.mLayoutWidget.removeAllChildren();
    n = this.mConstraintHelpers.size();
    if (n > 0) {
      for (m = 0; m < n; m++) {
        ((ConstraintHelper)this.mConstraintHelpers.get(m)).updatePreLayout(this);
      }
    }
    for (m = 0; m < i; m++)
    {
      localObject3 = getChildAt(m);
      if ((localObject3 instanceof Placeholder)) {
        ((Placeholder)localObject3).updatePreLayout(this);
      }
    }
    i1 = 0;
    for (m = k; i1 < i; m = k)
    {
      localObject1 = getChildAt(i1);
      localObject2 = getViewWidget((View)localObject1);
      int i2;
      if (localObject2 == null)
      {
        i2 = j;
        k = m;
      }
      else
      {
        localObject3 = (LayoutParams)((View)localObject1).getLayoutParams();
        ((LayoutParams)localObject3).validate();
        if (((LayoutParams)localObject3).helped) {
          ((LayoutParams)localObject3).helped = j;
        } else if (bool) {
          try
          {
            String str = getResources().getResourceName(((View)localObject1).getId());
            setDesignInformation(j, str, Integer.valueOf(((View)localObject1).getId()));
            str = str.substring(str.indexOf("id/") + 3);
            getTargetWidget(((View)localObject1).getId()).setDebugName(str);
          }
          catch (Resources.NotFoundException localNotFoundException2) {}
        }
        ((ConstraintWidget)localObject2).setVisibility(((View)localObject1).getVisibility());
        if (((LayoutParams)localObject3).isInPlaceholder) {
          ((ConstraintWidget)localObject2).setVisibility(8);
        }
        ((ConstraintWidget)localObject2).setCompanionWidget(localObject1);
        this.mLayoutWidget.add((ConstraintWidget)localObject2);
        if ((!((LayoutParams)localObject3).verticalDimensionFixed) || (!((LayoutParams)localObject3).horizontalDimensionFixed)) {
          this.mVariableDimensionsWidgets.add(localObject2);
        }
        float f;
        if (((LayoutParams)localObject3).isGuideline)
        {
          localObject2 = (androidx.constraintlayout.solver.widgets.Guideline)localObject2;
          k = ((LayoutParams)localObject3).resolvedGuideBegin;
          n = ((LayoutParams)localObject3).resolvedGuideEnd;
          f = ((LayoutParams)localObject3).resolvedGuidePercent;
          if (Build.VERSION.SDK_INT < 17)
          {
            k = ((LayoutParams)localObject3).guideBegin;
            n = ((LayoutParams)localObject3).guideEnd;
            f = ((LayoutParams)localObject3).guidePercent;
          }
          if (f != -1.0F)
          {
            ((androidx.constraintlayout.solver.widgets.Guideline)localObject2).setGuidePercent(f);
            i2 = j;
            k = m;
          }
          else if (k != m)
          {
            ((androidx.constraintlayout.solver.widgets.Guideline)localObject2).setGuideBegin(k);
            i2 = j;
            k = m;
          }
          else
          {
            i2 = j;
            k = m;
            if (n != m)
            {
              ((androidx.constraintlayout.solver.widgets.Guideline)localObject2).setGuideEnd(n);
              i2 = j;
              k = m;
            }
          }
        }
        else
        {
          int i3 = ((LayoutParams)localObject3).leftToLeft;
          if ((i3 == m) && (((LayoutParams)localObject3).leftToRight == m) && (((LayoutParams)localObject3).rightToLeft == m) && (((LayoutParams)localObject3).rightToRight == m) && (((LayoutParams)localObject3).startToStart == m) && (((LayoutParams)localObject3).startToEnd == m) && (((LayoutParams)localObject3).endToStart == m) && (((LayoutParams)localObject3).endToEnd == m) && (((LayoutParams)localObject3).topToTop == m) && (((LayoutParams)localObject3).topToBottom == m) && (((LayoutParams)localObject3).bottomToTop == m) && (((LayoutParams)localObject3).bottomToBottom == m) && (((LayoutParams)localObject3).baselineToBaseline == m) && (((LayoutParams)localObject3).editorAbsoluteX == m) && (((LayoutParams)localObject3).editorAbsoluteY == m) && (((LayoutParams)localObject3).circleConstraint == m) && (((ViewGroup.MarginLayoutParams)localObject3).width != m))
          {
            i2 = j;
            k = m;
            if (((ViewGroup.MarginLayoutParams)localObject3).height != m) {}
          }
          else
          {
            j = ((LayoutParams)localObject3).resolvedLeftToLeft;
            n = ((LayoutParams)localObject3).resolvedLeftToRight;
            m = ((LayoutParams)localObject3).resolvedRightToLeft;
            k = ((LayoutParams)localObject3).resolvedRightToRight;
            i2 = ((LayoutParams)localObject3).resolveGoneLeftMargin;
            int i4 = ((LayoutParams)localObject3).resolveGoneRightMargin;
            f = ((LayoutParams)localObject3).resolvedHorizontalBias;
            if (Build.VERSION.SDK_INT < 17)
            {
              int i5 = ((LayoutParams)localObject3).leftToRight;
              k = ((LayoutParams)localObject3).rightToLeft;
              n = ((LayoutParams)localObject3).rightToRight;
              i4 = ((LayoutParams)localObject3).goneLeftMargin;
              i2 = ((LayoutParams)localObject3).goneRightMargin;
              f = ((LayoutParams)localObject3).horizontalBias;
              j = i5;
              m = i3;
              if (i3 == -1)
              {
                j = i5;
                m = i3;
                if (i5 == -1)
                {
                  m = ((LayoutParams)localObject3).startToStart;
                  if (m != -1)
                  {
                    j = i5;
                  }
                  else
                  {
                    i6 = ((LayoutParams)localObject3).startToEnd;
                    j = i5;
                    m = i3;
                    if (i6 != -1)
                    {
                      j = i6;
                      m = i3;
                    }
                  }
                }
              }
              if ((k == -1) && (n == -1))
              {
                i3 = ((LayoutParams)localObject3).endToStart;
                if (i3 != -1)
                {
                  k = n;
                  n = i3;
                }
                for (;;)
                {
                  i3 = i2;
                  i2 = i4;
                  i4 = j;
                  j = m;
                  m = n;
                  n = i4;
                  i4 = i3;
                  break label1170;
                  i3 = ((LayoutParams)localObject3).endToEnd;
                  if (i3 == -1) {
                    break;
                  }
                  n = k;
                  k = i3;
                }
              }
              i3 = j;
              i5 = i4;
              i4 = i2;
              int i6 = n;
              j = m;
              m = k;
              n = i3;
              i2 = i5;
              k = i6;
            }
            label1170:
            i3 = ((LayoutParams)localObject3).circleConstraint;
            if (i3 != -1)
            {
              localObject1 = getTargetWidget(i3);
              if (localObject1 != null) {
                ((ConstraintWidget)localObject2).connectCircularConstraint((ConstraintWidget)localObject1, ((LayoutParams)localObject3).circleAngle, ((LayoutParams)localObject3).circleRadius);
              }
            }
            else
            {
              Object localObject4;
              if (j != -1)
              {
                localObject4 = getTargetWidget(j);
                if (localObject4 != null)
                {
                  localObject1 = ConstraintAnchor.Type.LEFT;
                  ((ConstraintWidget)localObject2).immediateConnect((ConstraintAnchor.Type)localObject1, (ConstraintWidget)localObject4, (ConstraintAnchor.Type)localObject1, ((ViewGroup.MarginLayoutParams)localObject3).leftMargin, i2);
                }
              }
              else if (n != -1)
              {
                localObject1 = getTargetWidget(n);
                if (localObject1 != null) {
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject1, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams)localObject3).leftMargin, i2);
                }
              }
              if (m != -1)
              {
                localObject1 = getTargetWidget(m);
                if (localObject1 != null) {
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject1, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams)localObject3).rightMargin, i4);
                }
              }
              else if (k != -1)
              {
                localObject1 = getTargetWidget(k);
                if (localObject1 != null)
                {
                  localObject4 = ConstraintAnchor.Type.RIGHT;
                  ((ConstraintWidget)localObject2).immediateConnect((ConstraintAnchor.Type)localObject4, (ConstraintWidget)localObject1, (ConstraintAnchor.Type)localObject4, ((ViewGroup.MarginLayoutParams)localObject3).rightMargin, i4);
                }
              }
              m = ((LayoutParams)localObject3).topToTop;
              if (m != -1)
              {
                localObject4 = getTargetWidget(m);
                if (localObject4 != null)
                {
                  localObject1 = ConstraintAnchor.Type.TOP;
                  ((ConstraintWidget)localObject2).immediateConnect((ConstraintAnchor.Type)localObject1, (ConstraintWidget)localObject4, (ConstraintAnchor.Type)localObject1, ((ViewGroup.MarginLayoutParams)localObject3).topMargin, ((LayoutParams)localObject3).goneTopMargin);
                }
              }
              else
              {
                m = ((LayoutParams)localObject3).topToBottom;
                if (m != -1)
                {
                  localObject1 = getTargetWidget(m);
                  if (localObject1 != null) {
                    ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject1, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams)localObject3).topMargin, ((LayoutParams)localObject3).goneTopMargin);
                  }
                }
              }
              m = ((LayoutParams)localObject3).bottomToTop;
              if (m != -1)
              {
                localObject1 = getTargetWidget(m);
                if (localObject1 != null) {
                  ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject1, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin, ((LayoutParams)localObject3).goneBottomMargin);
                }
              }
              else
              {
                m = ((LayoutParams)localObject3).bottomToBottom;
                if (m != -1)
                {
                  localObject4 = getTargetWidget(m);
                  if (localObject4 != null)
                  {
                    localObject1 = ConstraintAnchor.Type.BOTTOM;
                    ((ConstraintWidget)localObject2).immediateConnect((ConstraintAnchor.Type)localObject1, (ConstraintWidget)localObject4, (ConstraintAnchor.Type)localObject1, ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin, ((LayoutParams)localObject3).goneBottomMargin);
                  }
                }
              }
              m = ((LayoutParams)localObject3).baselineToBaseline;
              if (m != -1)
              {
                localObject4 = (View)this.mChildrenByIds.get(m);
                localObject1 = getTargetWidget(((LayoutParams)localObject3).baselineToBaseline);
                if ((localObject1 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof LayoutParams)))
                {
                  localObject4 = (LayoutParams)((View)localObject4).getLayoutParams();
                  ((LayoutParams)localObject3).needsBaseline = true;
                  ((LayoutParams)localObject4).needsBaseline = true;
                  localObject4 = ConstraintAnchor.Type.BASELINE;
                  ((ConstraintWidget)localObject2).getAnchor((ConstraintAnchor.Type)localObject4).connect(((ConstraintWidget)localObject1).getAnchor((ConstraintAnchor.Type)localObject4), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                  ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).reset();
                  ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                }
              }
              if ((f >= 0.0F) && (f != 0.5F)) {
                ((ConstraintWidget)localObject2).setHorizontalBiasPercent(f);
              }
              f = ((LayoutParams)localObject3).verticalBias;
              if ((f >= 0.0F) && (f != 0.5F)) {
                ((ConstraintWidget)localObject2).setVerticalBiasPercent(f);
              }
            }
            if (bool)
            {
              m = ((LayoutParams)localObject3).editorAbsoluteX;
              if ((m != -1) || (((LayoutParams)localObject3).editorAbsoluteY != -1)) {
                ((ConstraintWidget)localObject2).setOrigin(m, ((LayoutParams)localObject3).editorAbsoluteY);
              }
            }
            if (!((LayoutParams)localObject3).horizontalDimensionFixed)
            {
              if (((ViewGroup.MarginLayoutParams)localObject3).width == -1)
              {
                ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams)localObject3).leftMargin;
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams)localObject3).rightMargin;
              }
              else
              {
                ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                ((ConstraintWidget)localObject2).setWidth(0);
              }
            }
            else
            {
              ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
              ((ConstraintWidget)localObject2).setWidth(((ViewGroup.MarginLayoutParams)localObject3).width);
            }
            if (!((LayoutParams)localObject3).verticalDimensionFixed)
            {
              if (((ViewGroup.MarginLayoutParams)localObject3).height == -1)
              {
                ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams)localObject3).topMargin;
                ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin;
              }
              else
              {
                ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                ((ConstraintWidget)localObject2).setHeight(0);
              }
            }
            else
            {
              ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
              ((ConstraintWidget)localObject2).setHeight(((ViewGroup.MarginLayoutParams)localObject3).height);
            }
            k = -1;
            i2 = 0;
            localObject1 = ((LayoutParams)localObject3).dimensionRatio;
            if (localObject1 != null) {
              ((ConstraintWidget)localObject2).setDimensionRatio((String)localObject1);
            }
            ((ConstraintWidget)localObject2).setHorizontalWeight(((LayoutParams)localObject3).horizontalWeight);
            ((ConstraintWidget)localObject2).setVerticalWeight(((LayoutParams)localObject3).verticalWeight);
            ((ConstraintWidget)localObject2).setHorizontalChainStyle(((LayoutParams)localObject3).horizontalChainStyle);
            ((ConstraintWidget)localObject2).setVerticalChainStyle(((LayoutParams)localObject3).verticalChainStyle);
            ((ConstraintWidget)localObject2).setHorizontalMatchStyle(((LayoutParams)localObject3).matchConstraintDefaultWidth, ((LayoutParams)localObject3).matchConstraintMinWidth, ((LayoutParams)localObject3).matchConstraintMaxWidth, ((LayoutParams)localObject3).matchConstraintPercentWidth);
            ((ConstraintWidget)localObject2).setVerticalMatchStyle(((LayoutParams)localObject3).matchConstraintDefaultHeight, ((LayoutParams)localObject3).matchConstraintMinHeight, ((LayoutParams)localObject3).matchConstraintMaxHeight, ((LayoutParams)localObject3).matchConstraintPercentHeight);
          }
        }
      }
      i1++;
      j = i2;
    }
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    getLayoutParams();
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0) {
        if (i == 1073741824) {}
      }
      for (localDimensionBehaviour2 = localDimensionBehaviour1;; localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
      {
        paramInt1 = 0;
        break;
        paramInt1 = Math.min(this.mMaxWidth, paramInt1) - (n + i1);
        localDimensionBehaviour2 = localDimensionBehaviour1;
        break;
      }
    }
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0) {
        if (j == 1073741824) {}
      }
      for (;;)
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(this.mMaxHeight, paramInt2) - (k + m);
        break;
        localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      }
    }
    localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    this.mLayoutWidget.setMinWidth(0);
    this.mLayoutWidget.setMinHeight(0);
    this.mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour2);
    this.mLayoutWidget.setWidth(paramInt1);
    this.mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour1);
    this.mLayoutWidget.setHeight(paramInt2);
    this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
    this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
  }
  
  private void updateHierarchy()
  {
    int i = getChildCount();
    int j = 0;
    int m;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= i) {
        break;
      }
      if (getChildAt(k).isLayoutRequested())
      {
        m = 1;
        break;
      }
    }
    if (m != 0)
    {
      this.mVariableDimensionsWidgets.clear();
      setChildrenConstraints();
    }
  }
  
  private void updatePostMeasures()
  {
    int i = getChildCount();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      View localView = getChildAt(k);
      if ((localView instanceof Placeholder)) {
        ((Placeholder)localView).updatePostMeasure(this);
      }
    }
    i = this.mConstraintHelpers.size();
    if (i > 0) {
      for (k = j; k < i; k++) {
        ((ConstraintHelper)this.mConstraintHelpers.get(k)).updatePostMeasure(this);
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int i = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      for (int j = 0; j < i; j++)
      {
        Object localObject = getChildAt(j);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int k = Integer.parseInt(localObject[0]);
              int m = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int i1 = Integer.parseInt(localObject[3]);
              k = (int)(k / 1080.0F * f1);
              m = (int)(m / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = k;
              float f4 = m;
              float f5 = k + n;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = m + i1;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
      }
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mMetrics = paramMetrics;
    this.mLayoutWidget.fillMetrics(paramMetrics);
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      String str = (String)paramObject;
      paramObject = this.mDesignIds;
      if ((paramObject != null) && (((HashMap)paramObject).containsKey(str))) {
        return this.mDesignIds.get(str);
      }
    }
    return null;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizationLevel()
  {
    return this.mLayoutWidget.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt)
  {
    return (View)this.mChildrenByIds.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = ((LayoutParams)paramView.getLayoutParams()).widget;
    }
    return paramView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      ConstraintWidget localConstraintWidget = ((LayoutParams)localObject).widget;
      if (((localView.getVisibility() != 8) || (((LayoutParams)localObject).isGuideline) || (((LayoutParams)localObject).isHelper) || (paramBoolean)) && (!((LayoutParams)localObject).isInPlaceholder))
      {
        int i = localConstraintWidget.getDrawX();
        int j = localConstraintWidget.getDrawY();
        paramInt4 = localConstraintWidget.getWidth() + i;
        int k = localConstraintWidget.getHeight() + j;
        localView.layout(i, j, paramInt4, k);
        if ((localView instanceof Placeholder))
        {
          localObject = ((Placeholder)localView).getContent();
          if (localObject != null)
          {
            ((View)localObject).setVisibility(0);
            ((View)localObject).layout(i, j, paramInt4, k);
          }
        }
      }
    }
    paramInt3 = this.mConstraintHelpers.size();
    if (paramInt3 > 0) {
      for (paramInt1 = paramInt2; paramInt1 < paramInt3; paramInt1++) {
        ((ConstraintHelper)this.mConstraintHelpers.get(paramInt1)).updatePostLayout(this);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = getPaddingLeft();
    int i1 = getPaddingTop();
    this.mLayoutWidget.setX(n);
    this.mLayoutWidget.setY(i1);
    this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
    this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = this.mLayoutWidget;
      boolean bool;
      if (getLayoutDirection() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((ConstraintWidgetContainer)localObject1).setRtl(bool);
    }
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    int i2 = this.mLayoutWidget.getWidth();
    int i3 = this.mLayoutWidget.getHeight();
    int i4;
    if (this.mDirtyHierarchy)
    {
      this.mDirtyHierarchy = false;
      updateHierarchy();
      i4 = 1;
    }
    else
    {
      i4 = 0;
    }
    int i5;
    if ((this.mOptimizationLevel & 0x8) == 8) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    if (i5 != 0)
    {
      this.mLayoutWidget.preOptimize();
      this.mLayoutWidget.optimizeForDimensions(i2, i3);
      internalMeasureDimensions(paramInt1, paramInt2);
    }
    else
    {
      internalMeasureChildren(paramInt1, paramInt2);
    }
    updatePostMeasures();
    if ((getChildCount() > 0) && (i4 != 0)) {
      Analyzer.determineGroups(this.mLayoutWidget);
    }
    Object localObject1 = this.mLayoutWidget;
    if (((ConstraintWidgetContainer)localObject1).mGroupsWrapOptimized)
    {
      if ((((ConstraintWidgetContainer)localObject1).mHorizontalWrapOptimized) && (i == Integer.MIN_VALUE))
      {
        i4 = ((ConstraintWidgetContainer)localObject1).mWrapFixedWidth;
        if (i4 < j) {
          ((ConstraintWidget)localObject1).setWidth(i4);
        }
        this.mLayoutWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
      localObject1 = this.mLayoutWidget;
      if ((((ConstraintWidgetContainer)localObject1).mVerticalWrapOptimized) && (k == Integer.MIN_VALUE))
      {
        i4 = ((ConstraintWidgetContainer)localObject1).mWrapFixedHeight;
        if (i4 < m) {
          ((ConstraintWidget)localObject1).setHeight(i4);
        }
        this.mLayoutWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
    }
    int i6;
    if ((this.mOptimizationLevel & 0x20) == 32)
    {
      i4 = this.mLayoutWidget.getWidth();
      i6 = this.mLayoutWidget.getHeight();
      if ((this.mLastMeasureWidth != i4) && (i == 1073741824)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, i4);
      }
      if ((this.mLastMeasureHeight != i6) && (k == 1073741824)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, i6);
      }
      localObject1 = this.mLayoutWidget;
      if ((((ConstraintWidgetContainer)localObject1).mHorizontalWrapOptimized) && (((ConstraintWidgetContainer)localObject1).mWrapFixedWidth > j)) {
        Analyzer.setPosition(((ConstraintWidgetContainer)localObject1).mWidgetGroups, 0, j);
      }
      localObject1 = this.mLayoutWidget;
      if ((((ConstraintWidgetContainer)localObject1).mVerticalWrapOptimized) && (((ConstraintWidgetContainer)localObject1).mWrapFixedHeight > m)) {
        Analyzer.setPosition(((ConstraintWidgetContainer)localObject1).mWidgetGroups, 1, m);
      }
    }
    if (getChildCount() > 0) {
      solveLinearSystem("First pass");
    }
    int i7 = this.mVariableDimensionsWidgets.size();
    j = i1 + getPaddingBottom();
    int i8 = n + getPaddingRight();
    if (i7 > 0)
    {
      Object localObject2 = this.mLayoutWidget.getHorizontalDimensionBehaviour();
      localObject1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      if (localObject2 == localObject1) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() == localObject1) {
        i6 = 1;
      } else {
        i6 = 0;
      }
      i1 = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
      n = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
      int i9 = 0;
      m = 0;
      i4 = 0;
      while (i9 < i7)
      {
        localObject2 = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i9);
        View localView = (View)((ConstraintWidget)localObject2).getCompanionWidget();
        if (localView != null)
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((!localLayoutParams.isHelper) && (!localLayoutParams.isGuideline))
          {
            int i10 = localView.getVisibility();
            k = m;
            if (i10 != 8)
            {
              while ((i5 != 0) && (((ConstraintWidget)localObject2).getResolutionWidth().isResolved()) && (((ConstraintWidget)localObject2).getResolutionHeight().isResolved())) {}
              m = localLayoutParams.width;
              if ((m == -2) && (localLayoutParams.horizontalDimensionFixed)) {
                m = ViewGroup.getChildMeasureSpec(paramInt1, i8, m);
              } else {
                m = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject2).getWidth(), 1073741824);
              }
              i10 = localLayoutParams.height;
              if ((i10 == -2) && (localLayoutParams.verticalDimensionFixed)) {
                i10 = ViewGroup.getChildMeasureSpec(paramInt2, j, i10);
              } else {
                i10 = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject2).getHeight(), 1073741824);
              }
              localView.measure(m, i10);
              localObject1 = this.mMetrics;
              if (localObject1 != null) {
                ((Metrics)localObject1).additionalMeasures += 1L;
              }
              int i11 = localView.getMeasuredWidth();
              i10 = localView.getMeasuredHeight();
              m = i1;
              if (i11 != ((ConstraintWidget)localObject2).getWidth())
              {
                ((ConstraintWidget)localObject2).setWidth(i11);
                if (i5 != 0) {
                  ((ConstraintWidget)localObject2).getResolutionWidth().resolve(i11);
                }
                m = i1;
                if (i != 0)
                {
                  m = i1;
                  if (((ConstraintWidget)localObject2).getRight() > i1) {
                    m = Math.max(i1, ((ConstraintWidget)localObject2).getRight() + ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                  }
                }
                k = 1;
              }
              if (i10 != ((ConstraintWidget)localObject2).getHeight())
              {
                ((ConstraintWidget)localObject2).setHeight(i10);
                if (i5 != 0) {
                  ((ConstraintWidget)localObject2).getResolutionHeight().resolve(i10);
                }
                i1 = n;
                if (i6 != 0)
                {
                  i1 = n;
                  if (((ConstraintWidget)localObject2).getBottom() > n) {
                    i1 = Math.max(n, ((ConstraintWidget)localObject2).getBottom() + ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                  }
                }
                n = i1;
                k = 1;
              }
              i1 = k;
              if (localLayoutParams.needsBaseline)
              {
                i10 = localView.getBaseline();
                i1 = k;
                if (i10 != -1)
                {
                  i1 = k;
                  if (i10 != ((ConstraintWidget)localObject2).getBaselineDistance())
                  {
                    ((ConstraintWidget)localObject2).setBaselineDistance(i10);
                    i1 = 1;
                  }
                }
              }
              if (Build.VERSION.SDK_INT >= 11) {
                i4 = ViewGroup.combineMeasuredStates(i4, localView.getMeasuredState());
              }
              k = i1;
              i1 = m;
              m = k;
            }
          }
        }
        i9++;
      }
      if (m != 0)
      {
        this.mLayoutWidget.setWidth(i2);
        this.mLayoutWidget.setHeight(i3);
        if (i5 != 0) {
          this.mLayoutWidget.solveGraph();
        }
        solveLinearSystem("2nd pass");
        if (this.mLayoutWidget.getWidth() < i1)
        {
          this.mLayoutWidget.setWidth(i1);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (this.mLayoutWidget.getHeight() < n)
        {
          this.mLayoutWidget.setHeight(n);
          n = 1;
        }
        else
        {
          n = i1;
        }
        if (n != 0) {
          solveLinearSystem("3rd pass");
        }
      }
      for (n = 0; n < i7; n++)
      {
        localObject1 = (ConstraintWidget)this.mVariableDimensionsWidgets.get(n);
        localObject2 = (View)((ConstraintWidget)localObject1).getCompanionWidget();
        if (localObject2 != null)
        {
          while (((((View)localObject2).getMeasuredWidth() == ((ConstraintWidget)localObject1).getWidth()) && (((View)localObject2).getMeasuredHeight() == ((ConstraintWidget)localObject1).getHeight())) || (((ConstraintWidget)localObject1).getVisibility() == 8)) {}
          ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject1).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject1).getHeight(), 1073741824));
          localObject1 = this.mMetrics;
          if (localObject1 != null) {
            ((Metrics)localObject1).additionalMeasures += 1L;
          }
        }
      }
    }
    else
    {
      i4 = 0;
    }
    n = this.mLayoutWidget.getWidth() + i8;
    i1 = this.mLayoutWidget.getHeight() + j;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = ViewGroup.resolveSizeAndState(n, paramInt1, i4);
      i4 = ViewGroup.resolveSizeAndState(i1, paramInt2, i4 << 16);
      paramInt2 = Math.min(this.mMaxWidth, paramInt1 & 0xFFFFFF);
      i4 = Math.min(this.mMaxHeight, i4 & 0xFFFFFF);
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
        paramInt1 = paramInt2 | 0x1000000;
      }
      paramInt2 = i4;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
        paramInt2 = i4 | 0x1000000;
      }
      setMeasuredDimension(paramInt1, paramInt2);
      this.mLastMeasureWidth = paramInt1;
      this.mLastMeasureHeight = paramInt2;
    }
    else
    {
      setMeasuredDimension(n, i1);
      this.mLastMeasureWidth = n;
      this.mLastMeasureHeight = i1;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof androidx.constraintlayout.solver.widgets.Guideline)))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      localObject = new androidx.constraintlayout.solver.widgets.Guideline();
      localLayoutParams.widget = ((ConstraintWidget)localObject);
      localLayoutParams.isGuideline = true;
      ((androidx.constraintlayout.solver.widgets.Guideline)localObject).setOrientation(localLayoutParams.orientation);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).validateParams();
      ((LayoutParams)paramView.getLayoutParams()).isHelper = true;
      if (!this.mConstraintHelpers.contains(localObject)) {
        this.mConstraintHelpers.add(localObject);
      }
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    ConstraintWidget localConstraintWidget = getViewWidget(paramView);
    this.mLayoutWidget.remove(localConstraintWidget);
    this.mConstraintHelpers.remove(paramView);
    this.mVariableDimensionsWidgets.remove(localConstraintWidget);
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
    this.mLastMeasureWidth = -1;
    this.mLastMeasureHeight = -1;
    this.mLastMeasureWidthSize = -1;
    this.mLastMeasureHeightSize = -1;
    this.mLastMeasureWidthMode = 0;
    this.mLastMeasureHeightMode = 0;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.mDesignIds == null) {
        this.mDesignIds = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      this.mDesignIds.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected void solveLinearSystem(String paramString)
  {
    this.mLayoutWidget.layout();
    paramString = this.mMetrics;
    if (paramString != null) {
      paramString.resolutions += 1L;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0F;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0F;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public boolean helped = false;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = -1.0F;
    boolean isGuideline = false;
    boolean isHelper = false;
    boolean isInPlaceholder = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int matchConstraintDefaultHeight = 0;
    public int matchConstraintDefaultWidth = 0;
    public int matchConstraintMaxHeight = 0;
    public int matchConstraintMaxWidth = 0;
    public int matchConstraintMinHeight = 0;
    public int matchConstraintMinWidth = 0;
    public float matchConstraintPercentHeight = 1.0F;
    public float matchConstraintPercentWidth = 1.0F;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    int resolvedGuideBegin;
    int resolvedGuideEnd;
    float resolvedGuidePercent;
    float resolvedHorizontalBias = 0.5F;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = -1.0F;
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramContext.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramContext.getIndex(j);
        int m = Table.map.get(k);
        String str;
        switch (m)
        {
        default: 
          switch (m)
          {
          default: 
            break;
          case 50: 
            this.editorAbsoluteY = paramContext.getDimensionPixelOffset(k, this.editorAbsoluteY);
            break;
          case 49: 
            this.editorAbsoluteX = paramContext.getDimensionPixelOffset(k, this.editorAbsoluteX);
            break;
          case 48: 
            this.verticalChainStyle = paramContext.getInt(k, 0);
            break;
          case 47: 
            this.horizontalChainStyle = paramContext.getInt(k, 0);
            break;
          case 46: 
            this.verticalWeight = paramContext.getFloat(k, this.verticalWeight);
            break;
          case 45: 
            this.horizontalWeight = paramContext.getFloat(k, this.horizontalWeight);
            break;
          case 44: 
            paramAttributeSet = paramContext.getString(k);
            this.dimensionRatio = paramAttributeSet;
            this.dimensionRatioValue = NaN.0F;
            this.dimensionRatioSide = -1;
            if (paramAttributeSet != null)
            {
              m = paramAttributeSet.length();
              k = this.dimensionRatio.indexOf(',');
              if ((k > 0) && (k < m - 1))
              {
                paramAttributeSet = this.dimensionRatio.substring(0, k);
                if (paramAttributeSet.equalsIgnoreCase("W")) {
                  this.dimensionRatioSide = 0;
                } else if (paramAttributeSet.equalsIgnoreCase("H")) {
                  this.dimensionRatioSide = 1;
                }
                k++;
              }
              else
              {
                k = 0;
              }
              int n = this.dimensionRatio.indexOf(':');
              if ((n >= 0) && (n < m - 1))
              {
                paramAttributeSet = this.dimensionRatio.substring(k, n);
                str = this.dimensionRatio.substring(n + 1);
                if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                  continue;
                }
              }
            }
            break;
          }
          break;
        }
        try
        {
          float f1 = Float.parseFloat(paramAttributeSet);
          f2 = Float.parseFloat(str);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            continue;
          }
          if (this.dimensionRatioSide == 1) {
            this.dimensionRatioValue = Math.abs(f2 / f1);
          } else {
            this.dimensionRatioValue = Math.abs(f1 / f2);
          }
        }
        catch (NumberFormatException paramAttributeSet)
        {
          float f2;
          continue;
        }
        paramAttributeSet = this.dimensionRatio.substring(k);
        if (paramAttributeSet.length() > 0)
        {
          this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
          continue;
          this.matchConstraintPercentHeight = Math.max(0.0F, paramContext.getFloat(k, this.matchConstraintPercentHeight));
          continue;
          try
          {
            this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(k, this.matchConstraintMaxHeight);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(k, this.matchConstraintMaxHeight) != -2) {
              continue;
            }
          }
          this.matchConstraintMaxHeight = -2;
          continue;
          try
          {
            this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(k, this.matchConstraintMinHeight);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(k, this.matchConstraintMinHeight) != -2) {
              continue;
            }
          }
          this.matchConstraintMinHeight = -2;
          continue;
          this.matchConstraintPercentWidth = Math.max(0.0F, paramContext.getFloat(k, this.matchConstraintPercentWidth));
          continue;
          try
          {
            this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(k, this.matchConstraintMaxWidth);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(k, this.matchConstraintMaxWidth) != -2) {
              continue;
            }
          }
          this.matchConstraintMaxWidth = -2;
          continue;
          try
          {
            this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(k, this.matchConstraintMinWidth);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(k, this.matchConstraintMinWidth) != -2) {
              continue;
            }
          }
          this.matchConstraintMinWidth = -2;
          continue;
          k = paramContext.getInt(k, 0);
          this.matchConstraintDefaultHeight = k;
          if (k == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            continue;
            k = paramContext.getInt(k, 0);
            this.matchConstraintDefaultWidth = k;
            if (k == 1)
            {
              Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
              continue;
              this.verticalBias = paramContext.getFloat(k, this.verticalBias);
              continue;
              this.horizontalBias = paramContext.getFloat(k, this.horizontalBias);
              continue;
              this.constrainedHeight = paramContext.getBoolean(k, this.constrainedHeight);
              continue;
              this.constrainedWidth = paramContext.getBoolean(k, this.constrainedWidth);
              continue;
              this.goneEndMargin = paramContext.getDimensionPixelSize(k, this.goneEndMargin);
              continue;
              this.goneStartMargin = paramContext.getDimensionPixelSize(k, this.goneStartMargin);
              continue;
              this.goneBottomMargin = paramContext.getDimensionPixelSize(k, this.goneBottomMargin);
              continue;
              this.goneRightMargin = paramContext.getDimensionPixelSize(k, this.goneRightMargin);
              continue;
              this.goneTopMargin = paramContext.getDimensionPixelSize(k, this.goneTopMargin);
              continue;
              this.goneLeftMargin = paramContext.getDimensionPixelSize(k, this.goneLeftMargin);
              continue;
              m = paramContext.getResourceId(k, this.endToEnd);
              this.endToEnd = m;
              if (m == -1)
              {
                this.endToEnd = paramContext.getInt(k, -1);
                continue;
                m = paramContext.getResourceId(k, this.endToStart);
                this.endToStart = m;
                if (m == -1)
                {
                  this.endToStart = paramContext.getInt(k, -1);
                  continue;
                  m = paramContext.getResourceId(k, this.startToStart);
                  this.startToStart = m;
                  if (m == -1)
                  {
                    this.startToStart = paramContext.getInt(k, -1);
                    continue;
                    m = paramContext.getResourceId(k, this.startToEnd);
                    this.startToEnd = m;
                    if (m == -1)
                    {
                      this.startToEnd = paramContext.getInt(k, -1);
                      continue;
                      m = paramContext.getResourceId(k, this.baselineToBaseline);
                      this.baselineToBaseline = m;
                      if (m == -1)
                      {
                        this.baselineToBaseline = paramContext.getInt(k, -1);
                        continue;
                        m = paramContext.getResourceId(k, this.bottomToBottom);
                        this.bottomToBottom = m;
                        if (m == -1)
                        {
                          this.bottomToBottom = paramContext.getInt(k, -1);
                          continue;
                          m = paramContext.getResourceId(k, this.bottomToTop);
                          this.bottomToTop = m;
                          if (m == -1)
                          {
                            this.bottomToTop = paramContext.getInt(k, -1);
                            continue;
                            m = paramContext.getResourceId(k, this.topToBottom);
                            this.topToBottom = m;
                            if (m == -1)
                            {
                              this.topToBottom = paramContext.getInt(k, -1);
                              continue;
                              m = paramContext.getResourceId(k, this.topToTop);
                              this.topToTop = m;
                              if (m == -1)
                              {
                                this.topToTop = paramContext.getInt(k, -1);
                                continue;
                                m = paramContext.getResourceId(k, this.rightToRight);
                                this.rightToRight = m;
                                if (m == -1)
                                {
                                  this.rightToRight = paramContext.getInt(k, -1);
                                  continue;
                                  m = paramContext.getResourceId(k, this.rightToLeft);
                                  this.rightToLeft = m;
                                  if (m == -1)
                                  {
                                    this.rightToLeft = paramContext.getInt(k, -1);
                                    continue;
                                    m = paramContext.getResourceId(k, this.leftToRight);
                                    this.leftToRight = m;
                                    if (m == -1)
                                    {
                                      this.leftToRight = paramContext.getInt(k, -1);
                                      continue;
                                      m = paramContext.getResourceId(k, this.leftToLeft);
                                      this.leftToLeft = m;
                                      if (m == -1)
                                      {
                                        this.leftToLeft = paramContext.getInt(k, -1);
                                        continue;
                                        this.guidePercent = paramContext.getFloat(k, this.guidePercent);
                                        continue;
                                        this.guideEnd = paramContext.getDimensionPixelOffset(k, this.guideEnd);
                                        continue;
                                        this.guideBegin = paramContext.getDimensionPixelOffset(k, this.guideBegin);
                                        continue;
                                        f2 = paramContext.getFloat(k, this.circleAngle) % 360.0F;
                                        this.circleAngle = f2;
                                        if (f2 < 0.0F)
                                        {
                                          this.circleAngle = ((360.0F - f2) % 360.0F);
                                          continue;
                                          this.circleRadius = paramContext.getDimensionPixelSize(k, this.circleRadius);
                                          continue;
                                          m = paramContext.getResourceId(k, this.circleConstraint);
                                          this.circleConstraint = m;
                                          if (m == -1)
                                          {
                                            this.circleConstraint = paramContext.getInt(k, -1);
                                            continue;
                                            this.orientation = paramContext.getInt(k, this.orientation);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramContext.recycle();
      validate();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.circleConstraint = paramLayoutParams.circleConstraint;
      this.circleRadius = paramLayoutParams.circleRadius;
      this.circleAngle = paramLayoutParams.circleAngle;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.goneLeftMargin = paramLayoutParams.goneLeftMargin;
      this.goneTopMargin = paramLayoutParams.goneTopMargin;
      this.goneRightMargin = paramLayoutParams.goneRightMargin;
      this.goneBottomMargin = paramLayoutParams.goneBottomMargin;
      this.goneStartMargin = paramLayoutParams.goneStartMargin;
      this.goneEndMargin = paramLayoutParams.goneEndMargin;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.dimensionRatioValue = paramLayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = paramLayoutParams.dimensionRatioSide;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.constrainedHeight = paramLayoutParams.constrainedHeight;
      this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
      this.matchConstraintPercentWidth = paramLayoutParams.matchConstraintPercentWidth;
      this.matchConstraintPercentHeight = paramLayoutParams.matchConstraintPercentHeight;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.horizontalDimensionFixed = paramLayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = paramLayoutParams.verticalDimensionFixed;
      this.needsBaseline = paramLayoutParams.needsBaseline;
      this.isGuideline = paramLayoutParams.isGuideline;
      this.resolvedLeftToLeft = paramLayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = paramLayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = paramLayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = paramLayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = paramLayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = paramLayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = paramLayoutParams.resolvedHorizontalBias;
      this.widget = paramLayoutParams.widget;
    }
    
    public void reset()
    {
      ConstraintWidget localConstraintWidget = this.widget;
      if (localConstraintWidget != null) {
        localConstraintWidget.reset();
      }
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i = this.leftMargin;
      int j = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      this.resolvedGuideBegin = this.guideBegin;
      this.resolvedGuideEnd = this.guideEnd;
      this.resolvedGuidePercent = this.guidePercent;
      paramInt = getLayoutDirection();
      int k = 0;
      if (1 == paramInt) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        paramInt = this.startToEnd;
        if (paramInt != -1) {
          this.resolvedRightToLeft = paramInt;
        }
        for (;;)
        {
          paramInt = 1;
          break;
          int m = this.startToStart;
          paramInt = k;
          if (m == -1) {
            break;
          }
          this.resolvedRightToRight = m;
        }
        k = this.endToStart;
        if (k != -1)
        {
          this.resolvedLeftToRight = k;
          paramInt = 1;
        }
        k = this.endToEnd;
        if (k != -1)
        {
          this.resolvedLeftToLeft = k;
          paramInt = 1;
        }
        k = this.goneStartMargin;
        if (k != -1) {
          this.resolveGoneRightMargin = k;
        }
        k = this.goneEndMargin;
        if (k != -1) {
          this.resolveGoneLeftMargin = k;
        }
        if (paramInt != 0) {
          this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
        }
        if ((this.isGuideline) && (this.orientation == 1))
        {
          float f = this.guidePercent;
          if (f != -1.0F)
          {
            this.resolvedGuidePercent = (1.0F - f);
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
          }
          else
          {
            paramInt = this.guideBegin;
            if (paramInt != -1)
            {
              this.resolvedGuideEnd = paramInt;
              this.resolvedGuideBegin = -1;
              this.resolvedGuidePercent = -1.0F;
            }
            else
            {
              paramInt = this.guideEnd;
              if (paramInt != -1)
              {
                this.resolvedGuideBegin = paramInt;
                this.resolvedGuideEnd = -1;
                this.resolvedGuidePercent = -1.0F;
              }
            }
          }
        }
      }
      else
      {
        paramInt = this.startToEnd;
        if (paramInt != -1) {
          this.resolvedLeftToRight = paramInt;
        }
        paramInt = this.startToStart;
        if (paramInt != -1) {
          this.resolvedLeftToLeft = paramInt;
        }
        paramInt = this.endToStart;
        if (paramInt != -1) {
          this.resolvedRightToLeft = paramInt;
        }
        paramInt = this.endToEnd;
        if (paramInt != -1) {
          this.resolvedRightToRight = paramInt;
        }
        paramInt = this.goneStartMargin;
        if (paramInt != -1) {
          this.resolveGoneLeftMargin = paramInt;
        }
        paramInt = this.goneEndMargin;
        if (paramInt != -1) {
          this.resolveGoneRightMargin = paramInt;
        }
      }
      if ((this.endToStart == -1) && (this.endToEnd == -1) && (this.startToStart == -1) && (this.startToEnd == -1))
      {
        paramInt = this.rightToLeft;
        if (paramInt != -1)
        {
          this.resolvedRightToLeft = paramInt;
          if ((this.rightMargin <= 0) && (j > 0)) {
            this.rightMargin = j;
          }
        }
        else
        {
          paramInt = this.rightToRight;
          if (paramInt != -1)
          {
            this.resolvedRightToRight = paramInt;
            if ((this.rightMargin <= 0) && (j > 0)) {
              this.rightMargin = j;
            }
          }
        }
        paramInt = this.leftToLeft;
        if (paramInt != -1)
        {
          this.resolvedLeftToLeft = paramInt;
          if ((this.leftMargin <= 0) && (i > 0)) {
            this.leftMargin = i;
          }
        }
        else
        {
          paramInt = this.leftToRight;
          if (paramInt != -1)
          {
            this.resolvedLeftToRight = paramInt;
            if ((this.leftMargin <= 0) && (i > 0)) {
              this.leftMargin = i;
            }
          }
        }
      }
    }
    
    public void validate()
    {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      int i = this.width;
      if ((i == -2) && (this.constrainedWidth))
      {
        this.horizontalDimensionFixed = false;
        this.matchConstraintDefaultWidth = 1;
      }
      int j = this.height;
      if ((j == -2) && (this.constrainedHeight))
      {
        this.verticalDimensionFixed = false;
        this.matchConstraintDefaultHeight = 1;
      }
      if ((i == 0) || (i == -1))
      {
        this.horizontalDimensionFixed = false;
        if ((i == 0) && (this.matchConstraintDefaultWidth == 1))
        {
          this.width = -2;
          this.constrainedWidth = true;
        }
      }
      if ((j == 0) || (j == -1))
      {
        this.verticalDimensionFixed = false;
        if ((j == 0) && (this.matchConstraintDefaultHeight == 1))
        {
          this.height = -2;
          this.constrainedHeight = true;
        }
      }
      if ((this.guidePercent != -1.0F) || (this.guideBegin != -1) || (this.guideEnd != -1))
      {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
          this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
        }
        ((androidx.constraintlayout.solver.widgets.Guideline)this.widget).setOrientation(this.orientation);
      }
    }
    
    private static class Table
    {
      public static final int ANDROID_ORIENTATION = 1;
      public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
      public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
      public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
      public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
      public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
      public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
      public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
      public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
      public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
      public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
      public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
      public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
      public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
      public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
      public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
      public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
      public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
      public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
      public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
      public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
      public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
      public static final int LAYOUT_GONE_MARGIN_END = 26;
      public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
      public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
      public static final int LAYOUT_GONE_MARGIN_START = 25;
      public static final int LAYOUT_GONE_MARGIN_TOP = 22;
      public static final int UNUSED = 0;
      public static final SparseIntArray map;
      
      static
      {
        SparseIntArray localSparseIntArray = new SparseIntArray();
        map = localSparseIntArray;
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\widget\ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */