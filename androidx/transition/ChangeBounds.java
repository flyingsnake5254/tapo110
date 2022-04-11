package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
  private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
  private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
  private static final Property<View, PointF> POSITION_PROPERTY = new Property(PointF.class, "position")
  {
    public PointF get(View paramAnonymousView)
    {
      return null;
    }
    
    public void set(View paramAnonymousView, PointF paramAnonymousPointF)
    {
      int i = Math.round(paramAnonymousPointF.x);
      int j = Math.round(paramAnonymousPointF.y);
      ViewUtils.setLeftTopRightBottom(paramAnonymousView, i, j, paramAnonymousView.getWidth() + i, paramAnonymousView.getHeight() + j);
    }
  };
  private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
  private static final String PROPNAME_CLIP = "android:changeBounds:clip";
  private static final String PROPNAME_PARENT = "android:changeBounds:parent";
  private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
  private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
  private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
  private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
  private static RectEvaluator sRectEvaluator = new RectEvaluator();
  private static final String[] sTransitionProperties = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private boolean mReparent = false;
  private boolean mResizeClip = false;
  private int[] mTempLocation = new int[2];
  
  static
  {
    DRAWABLE_ORIGIN_PROPERTY = new Property(PointF.class, "boundsOrigin")
    {
      private Rect mBounds = new Rect();
      
      public PointF get(Drawable paramAnonymousDrawable)
      {
        paramAnonymousDrawable.copyBounds(this.mBounds);
        paramAnonymousDrawable = this.mBounds;
        return new PointF(paramAnonymousDrawable.left, paramAnonymousDrawable.top);
      }
      
      public void set(Drawable paramAnonymousDrawable, PointF paramAnonymousPointF)
      {
        paramAnonymousDrawable.copyBounds(this.mBounds);
        this.mBounds.offsetTo(Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y));
        paramAnonymousDrawable.setBounds(this.mBounds);
      }
    };
    TOP_LEFT_PROPERTY = new Property(PointF.class, "topLeft")
    {
      public PointF get(ChangeBounds.ViewBounds paramAnonymousViewBounds)
      {
        return null;
      }
      
      public void set(ChangeBounds.ViewBounds paramAnonymousViewBounds, PointF paramAnonymousPointF)
      {
        paramAnonymousViewBounds.setTopLeft(paramAnonymousPointF);
      }
    };
    BOTTOM_RIGHT_PROPERTY = new Property(PointF.class, "bottomRight")
    {
      public PointF get(ChangeBounds.ViewBounds paramAnonymousViewBounds)
      {
        return null;
      }
      
      public void set(ChangeBounds.ViewBounds paramAnonymousViewBounds, PointF paramAnonymousPointF)
      {
        paramAnonymousViewBounds.setBottomRight(paramAnonymousPointF);
      }
    };
    BOTTOM_RIGHT_ONLY_PROPERTY = new Property(PointF.class, "bottomRight")
    {
      public PointF get(View paramAnonymousView)
      {
        return null;
      }
      
      public void set(View paramAnonymousView, PointF paramAnonymousPointF)
      {
        ViewUtils.setLeftTopRightBottom(paramAnonymousView, paramAnonymousView.getLeft(), paramAnonymousView.getTop(), Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y));
      }
    };
    TOP_LEFT_ONLY_PROPERTY = new Property(PointF.class, "topLeft")
    {
      public PointF get(View paramAnonymousView)
      {
        return null;
      }
      
      public void set(View paramAnonymousView, PointF paramAnonymousPointF)
      {
        ViewUtils.setLeftTopRightBottom(paramAnonymousView, Math.round(paramAnonymousPointF.x), Math.round(paramAnonymousPointF.y), paramAnonymousView.getRight(), paramAnonymousView.getBottom());
      }
    };
  }
  
  public ChangeBounds() {}
  
  @SuppressLint({"RestrictedApi"})
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.CHANGE_BOUNDS);
    boolean bool = TypedArrayUtils.getNamedBoolean(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    setResizeClip(bool);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramTransitionValues.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramTransitionValues.values.put("android:changeBounds:parent", paramTransitionValues.view.getParent());
      if (this.mReparent)
      {
        paramTransitionValues.view.getLocationInWindow(this.mTempLocation);
        paramTransitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.mTempLocation[0]));
        paramTransitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.mTempLocation[1]));
      }
      if (this.mResizeClip) {
        paramTransitionValues.values.put("android:changeBounds:clip", ViewCompat.getClipBounds(localView));
      }
    }
  }
  
  private boolean parentMatches(View paramView1, View paramView2)
  {
    boolean bool1 = this.mReparent;
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (bool1)
    {
      TransitionValues localTransitionValues = getMatchedTransitionValues(paramView1, true);
      if (localTransitionValues == null) {
        if (paramView1 == paramView2)
        {
          bool3 = bool2;
          break label60;
        }
      }
      while (paramView2 != localTransitionValues.view)
      {
        bool3 = false;
        break;
      }
      bool3 = bool2;
    }
    label60:
    return bool3;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  @Nullable
  public Animator createAnimator(@NonNull final ViewGroup paramViewGroup, @Nullable final TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null))
    {
      final Object localObject1 = paramTransitionValues1.values;
      final Object localObject2 = paramTransitionValues2.values;
      localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      final Object localObject3 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      if ((localObject1 != null) && (localObject3 != null))
      {
        localObject2 = paramTransitionValues2.view;
        int i;
        final int m;
        int i8;
        int i9;
        if (parentMatches((View)localObject1, (View)localObject3))
        {
          localObject1 = (Rect)paramTransitionValues1.values.get("android:changeBounds:bounds");
          paramViewGroup = (Rect)paramTransitionValues2.values.get("android:changeBounds:bounds");
          i = ((Rect)localObject1).left;
          final int j = paramViewGroup.left;
          int k = ((Rect)localObject1).top;
          m = paramViewGroup.top;
          int n = ((Rect)localObject1).right;
          final int i1 = paramViewGroup.right;
          int i2 = ((Rect)localObject1).bottom;
          final int i3 = paramViewGroup.bottom;
          int i4 = n - i;
          int i5 = i2 - k;
          int i6 = i1 - j;
          int i7 = i3 - m;
          paramTransitionValues1 = (Rect)paramTransitionValues1.values.get("android:changeBounds:clip");
          localObject1 = (Rect)paramTransitionValues2.values.get("android:changeBounds:clip");
          if (((i4 != 0) && (i5 != 0)) || ((i6 != 0) && (i7 != 0)))
          {
            if ((i == j) && (k == m)) {
              i8 = 0;
            } else {
              i8 = 1;
            }
            if (n == i1)
            {
              i9 = i8;
              if (i2 == i3) {}
            }
            else
            {
              i9 = i8 + 1;
            }
          }
          else
          {
            i9 = 0;
          }
          if ((paramTransitionValues1 == null) || (paramTransitionValues1.equals(localObject1)))
          {
            i8 = i9;
            if (paramTransitionValues1 == null)
            {
              i8 = i9;
              if (localObject1 == null) {}
            }
          }
          else
          {
            i8 = i9 + 1;
          }
          if (i8 > 0)
          {
            if (!this.mResizeClip)
            {
              paramViewGroup = (ViewGroup)localObject2;
              ViewUtils.setLeftTopRightBottom(paramViewGroup, i, k, n, i2);
              if (i8 == 2)
              {
                if ((i4 == i6) && (i5 == i7))
                {
                  paramTransitionValues1 = getPathMotion().getPath(i, k, j, m);
                  paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, POSITION_PROPERTY, paramTransitionValues1);
                }
                else
                {
                  paramTransitionValues1 = new ViewBounds(paramViewGroup);
                  paramViewGroup = getPathMotion().getPath(i, k, j, m);
                  paramTransitionValues2 = ObjectAnimatorUtils.ofPointF(paramTransitionValues1, TOP_LEFT_PROPERTY, paramViewGroup);
                  paramViewGroup = getPathMotion().getPath(n, i2, i1, i3);
                  localObject1 = ObjectAnimatorUtils.ofPointF(paramTransitionValues1, BOTTOM_RIGHT_PROPERTY, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramTransitionValues2, localObject1 });
                  paramViewGroup.addListener(new AnimatorListenerAdapter()
                  {
                    private ChangeBounds.ViewBounds mViewBounds;
                  });
                }
              }
              else if ((i == j) && (k == m))
              {
                paramTransitionValues1 = getPathMotion().getPath(n, i2, i1, i3);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, BOTTOM_RIGHT_ONLY_PROPERTY, paramTransitionValues1);
              }
              else
              {
                paramTransitionValues1 = getPathMotion().getPath(i, k, j, m);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, TOP_LEFT_ONLY_PROPERTY, paramTransitionValues1);
              }
            }
            else
            {
              localObject3 = localObject2;
              ViewUtils.setLeftTopRightBottom((View)localObject3, i, k, Math.max(i4, i6) + i, Math.max(i5, i7) + k);
              if ((i == j) && (k == m))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = getPathMotion().getPath(i, k, j, m);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(localObject3, POSITION_PROPERTY, paramViewGroup);
              }
              if (paramTransitionValues1 == null) {
                paramTransitionValues1 = new Rect(0, 0, i4, i5);
              }
              if (localObject1 == null) {
                paramTransitionValues2 = new Rect(0, 0, i6, i7);
              } else {
                paramTransitionValues2 = (TransitionValues)localObject1;
              }
              if (!paramTransitionValues1.equals(paramTransitionValues2))
              {
                ViewCompat.setClipBounds((View)localObject3, paramTransitionValues1);
                paramTransitionValues1 = ObjectAnimator.ofObject(localObject3, "clipBounds", sRectEvaluator, new Object[] { paramTransitionValues1, paramTransitionValues2 });
                paramTransitionValues1.addListener(new AnimatorListenerAdapter()
                {
                  private boolean mIsCanceled;
                  
                  public void onAnimationCancel(Animator paramAnonymousAnimator)
                  {
                    this.mIsCanceled = true;
                  }
                  
                  public void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    if (!this.mIsCanceled)
                    {
                      ViewCompat.setClipBounds(localObject3, localObject1);
                      ViewUtils.setLeftTopRightBottom(localObject3, j, m, i1, i3);
                    }
                  }
                });
              }
              else
              {
                paramTransitionValues1 = null;
              }
              paramViewGroup = TransitionUtils.mergeAnimators(paramViewGroup, paramTransitionValues1);
            }
            if ((((View)localObject2).getParent() instanceof ViewGroup))
            {
              paramTransitionValues1 = (ViewGroup)((View)localObject2).getParent();
              ViewGroupUtils.suppressLayout(paramTransitionValues1, true);
              addListener(new TransitionListenerAdapter()
              {
                boolean mCanceled = false;
                
                public void onTransitionCancel(@NonNull Transition paramAnonymousTransition)
                {
                  ViewGroupUtils.suppressLayout(paramTransitionValues1, false);
                  this.mCanceled = true;
                }
                
                public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
                {
                  if (!this.mCanceled) {
                    ViewGroupUtils.suppressLayout(paramTransitionValues1, false);
                  }
                  paramAnonymousTransition.removeListener(this);
                }
                
                public void onTransitionPause(@NonNull Transition paramAnonymousTransition)
                {
                  ViewGroupUtils.suppressLayout(paramTransitionValues1, false);
                }
                
                public void onTransitionResume(@NonNull Transition paramAnonymousTransition)
                {
                  ViewGroupUtils.suppressLayout(paramTransitionValues1, true);
                }
              });
            }
            return paramViewGroup;
          }
        }
        else
        {
          m = ((Integer)paramTransitionValues1.values.get("android:changeBounds:windowX")).intValue();
          i = ((Integer)paramTransitionValues1.values.get("android:changeBounds:windowY")).intValue();
          i9 = ((Integer)paramTransitionValues2.values.get("android:changeBounds:windowX")).intValue();
          i8 = ((Integer)paramTransitionValues2.values.get("android:changeBounds:windowY")).intValue();
          if ((m != i9) || (i != i8)) {
            break label944;
          }
        }
        return null;
        label944:
        paramViewGroup.getLocationInWindow(this.mTempLocation);
        paramTransitionValues1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject2).draw(new Canvas(paramTransitionValues1));
        paramTransitionValues1 = new BitmapDrawable(paramTransitionValues1);
        final float f = ViewUtils.getTransitionAlpha((View)localObject2);
        ViewUtils.setTransitionAlpha((View)localObject2, 0.0F);
        ViewUtils.getOverlay(paramViewGroup).add(paramTransitionValues1);
        paramTransitionValues2 = getPathMotion();
        localObject1 = this.mTempLocation;
        paramTransitionValues2 = paramTransitionValues2.getPath(m - localObject1[0], i - localObject1[1], i9 - localObject1[0], i8 - localObject1[1]);
        paramTransitionValues2 = ObjectAnimator.ofPropertyValuesHolder(paramTransitionValues1, new PropertyValuesHolder[] { PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, paramTransitionValues2) });
        paramTransitionValues2.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            ViewUtils.getOverlay(paramViewGroup).remove(paramTransitionValues1);
            ViewUtils.setTransitionAlpha(localObject2, f);
          }
        });
        return paramTransitionValues2;
      }
      return null;
    }
    return null;
  }
  
  public boolean getResizeClip()
  {
    return this.mResizeClip;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public void setResizeClip(boolean paramBoolean)
  {
    this.mResizeClip = paramBoolean;
  }
  
  private static class ViewBounds
  {
    private int mBottom;
    private int mBottomRightCalls;
    private int mLeft;
    private int mRight;
    private int mTop;
    private int mTopLeftCalls;
    private View mView;
    
    ViewBounds(View paramView)
    {
      this.mView = paramView;
    }
    
    private void setLeftTopRightBottom()
    {
      ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
      this.mTopLeftCalls = 0;
      this.mBottomRightCalls = 0;
    }
    
    void setBottomRight(PointF paramPointF)
    {
      this.mRight = Math.round(paramPointF.x);
      this.mBottom = Math.round(paramPointF.y);
      int i = this.mBottomRightCalls + 1;
      this.mBottomRightCalls = i;
      if (this.mTopLeftCalls == i) {
        setLeftTopRightBottom();
      }
    }
    
    void setTopLeft(PointF paramPointF)
    {
      this.mLeft = Math.round(paramPointF.x);
      this.mTop = Math.round(paramPointF.y);
      int i = this.mTopLeftCalls + 1;
      this.mTopLeftCalls = i;
      if (i == this.mBottomRightCalls) {
        setLeftTopRightBottom();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ChangeBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */