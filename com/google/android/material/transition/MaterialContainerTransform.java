package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public final class MaterialContainerTransform
  extends Transition
{
  private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS;
  private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1F, 0.4F), new ProgressThresholds(0.1F, 1.0F), new ProgressThresholds(0.1F, 1.0F), new ProgressThresholds(0.1F, 0.9F), null);
  private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS;
  private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6F, 0.9F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.2F, 0.9F), null);
  private static final float ELEVATION_NOT_SET = -1.0F;
  public static final int FADE_MODE_CROSS = 2;
  public static final int FADE_MODE_IN = 0;
  public static final int FADE_MODE_OUT = 1;
  public static final int FADE_MODE_THROUGH = 3;
  public static final int FIT_MODE_AUTO = 0;
  public static final int FIT_MODE_HEIGHT = 2;
  public static final int FIT_MODE_WIDTH = 1;
  private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
  private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
  private static final String TAG = MaterialContainerTransform.class.getSimpleName();
  public static final int TRANSITION_DIRECTION_AUTO = 0;
  public static final int TRANSITION_DIRECTION_ENTER = 1;
  public static final int TRANSITION_DIRECTION_RETURN = 2;
  private static final String[] TRANSITION_PROPS = { "materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance" };
  @ColorInt
  private int containerColor;
  private boolean drawDebugEnabled;
  @IdRes
  private int drawingViewId;
  private boolean elevationShadowEnabled;
  @ColorInt
  private int endContainerColor;
  private float endElevation;
  @Nullable
  private ShapeAppearanceModel endShapeAppearanceModel;
  @Nullable
  private View endView;
  @IdRes
  private int endViewId;
  private int fadeMode;
  @Nullable
  private ProgressThresholds fadeProgressThresholds;
  private int fitMode;
  private boolean holdAtEndEnabled;
  @Nullable
  private ProgressThresholds scaleMaskProgressThresholds;
  @Nullable
  private ProgressThresholds scaleProgressThresholds;
  @ColorInt
  private int scrimColor;
  @Nullable
  private ProgressThresholds shapeMaskProgressThresholds;
  @ColorInt
  private int startContainerColor;
  private float startElevation;
  @Nullable
  private ShapeAppearanceModel startShapeAppearanceModel;
  @Nullable
  private View startView;
  @IdRes
  private int startViewId;
  private int transitionDirection;
  
  static
  {
    DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0F, 0.25F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 0.75F), null);
    DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6F, 0.9F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.3F, 0.9F), null);
  }
  
  public MaterialContainerTransform()
  {
    boolean bool = false;
    this.drawDebugEnabled = false;
    this.holdAtEndEnabled = false;
    this.drawingViewId = 16908290;
    this.startViewId = -1;
    this.endViewId = -1;
    this.containerColor = 0;
    this.startContainerColor = 0;
    this.endContainerColor = 0;
    this.scrimColor = 1375731712;
    this.transitionDirection = 0;
    this.fadeMode = 0;
    this.fitMode = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    }
    this.elevationShadowEnabled = bool;
    this.startElevation = -1.0F;
    this.endElevation = -1.0F;
    setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
  }
  
  private ProgressThresholdsGroup buildThresholdsGroup(boolean paramBoolean)
  {
    PathMotion localPathMotion = getPathMotion();
    if ((!(localPathMotion instanceof ArcMotion)) && (!(localPathMotion instanceof MaterialArcMotion))) {
      return getThresholdsOrDefault(paramBoolean, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }
    return getThresholdsOrDefault(paramBoolean, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
  }
  
  private static RectF calculateDrawableBounds(View paramView1, @Nullable View paramView2, float paramFloat1, float paramFloat2)
  {
    if (paramView2 != null)
    {
      paramView1 = TransitionUtils.getLocationOnScreen(paramView2);
      paramView1.offset(paramFloat1, paramFloat2);
      return paramView1;
    }
    return new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
  }
  
  private static ShapeAppearanceModel captureShapeAppearance(@NonNull View paramView, @NonNull RectF paramRectF, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(paramView, paramShapeAppearanceModel), paramRectF);
  }
  
  private static void captureValues(@NonNull TransitionValues paramTransitionValues, @Nullable View paramView, @IdRes int paramInt, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != -1)
    {
      paramTransitionValues.view = TransitionUtils.findDescendantOrAncestorById(paramTransitionValues.view, paramInt);
    }
    else if (paramView != null)
    {
      paramTransitionValues.view = paramView;
    }
    else
    {
      paramView = paramTransitionValues.view;
      paramInt = R.id.mtrl_motion_snapshot_view;
      if ((paramView.getTag(paramInt) instanceof View))
      {
        paramView = (View)paramTransitionValues.view.getTag(paramInt);
        paramTransitionValues.view.setTag(paramInt, null);
        paramTransitionValues.view = paramView;
      }
    }
    View localView = paramTransitionValues.view;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      if (localView.getParent() == null) {
        paramView = TransitionUtils.getRelativeBounds(localView);
      } else {
        paramView = TransitionUtils.getLocationOnScreen(localView);
      }
      paramTransitionValues.values.put("materialContainerTransition:bounds", paramView);
      paramTransitionValues.values.put("materialContainerTransition:shapeAppearance", captureShapeAppearance(localView, paramView, paramShapeAppearanceModel));
    }
  }
  
  private static float getElevationOrDefault(float paramFloat, View paramView)
  {
    if (paramFloat == -1.0F) {
      paramFloat = ViewCompat.getElevation(paramView);
    }
    return paramFloat;
  }
  
  private static ShapeAppearanceModel getShapeAppearance(@NonNull View paramView, @Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramShapeAppearanceModel != null) {
      return paramShapeAppearanceModel;
    }
    int i = R.id.mtrl_motion_snapshot_view;
    if ((paramView.getTag(i) instanceof ShapeAppearanceModel)) {
      return (ShapeAppearanceModel)paramView.getTag(i);
    }
    paramShapeAppearanceModel = paramView.getContext();
    i = getTransitionShapeAppearanceResId(paramShapeAppearanceModel);
    if (i != -1) {
      return ShapeAppearanceModel.builder(paramShapeAppearanceModel, i, 0).build();
    }
    if ((paramView instanceof Shapeable)) {
      return ((Shapeable)paramView).getShapeAppearanceModel();
    }
    return ShapeAppearanceModel.builder().build();
  }
  
  private ProgressThresholdsGroup getThresholdsOrDefault(boolean paramBoolean, ProgressThresholdsGroup paramProgressThresholdsGroup1, ProgressThresholdsGroup paramProgressThresholdsGroup2)
  {
    if (!paramBoolean) {
      paramProgressThresholdsGroup1 = paramProgressThresholdsGroup2;
    }
    return new ProgressThresholdsGroup((ProgressThresholds)TransitionUtils.defaultIfNull(this.fadeProgressThresholds, paramProgressThresholdsGroup1.fade), (ProgressThresholds)TransitionUtils.defaultIfNull(this.scaleProgressThresholds, paramProgressThresholdsGroup1.scale), (ProgressThresholds)TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, paramProgressThresholdsGroup1.scaleMask), (ProgressThresholds)TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, paramProgressThresholdsGroup1.shapeMask), null);
  }
  
  @StyleRes
  private static int getTransitionShapeAppearanceResId(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(new int[] { R.attr.transitionShapeAppearance });
    int i = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    return i;
  }
  
  private boolean isEntering(@NonNull RectF paramRectF1, @NonNull RectF paramRectF2)
  {
    int i = this.transitionDirection;
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return false;
        }
        paramRectF1 = new StringBuilder();
        paramRectF1.append("Invalid transition direction: ");
        paramRectF1.append(this.transitionDirection);
        throw new IllegalArgumentException(paramRectF1.toString());
      }
      return true;
    }
    if (TransitionUtils.calculateArea(paramRectF2) > TransitionUtils.calculateArea(paramRectF1)) {
      bool = true;
    }
    return bool;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
  }
  
  @Nullable
  public Animator createAnimator(@NonNull final ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable final TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null))
    {
      RectF localRectF1 = (RectF)paramTransitionValues1.values.get("materialContainerTransition:bounds");
      ShapeAppearanceModel localShapeAppearanceModel1 = (ShapeAppearanceModel)paramTransitionValues1.values.get("materialContainerTransition:shapeAppearance");
      if ((localRectF1 != null) && (localShapeAppearanceModel1 != null))
      {
        RectF localRectF2 = (RectF)paramTransitionValues2.values.get("materialContainerTransition:bounds");
        ShapeAppearanceModel localShapeAppearanceModel2 = (ShapeAppearanceModel)paramTransitionValues2.values.get("materialContainerTransition:shapeAppearance");
        if ((localRectF2 != null) && (localShapeAppearanceModel2 != null))
        {
          final View localView = paramTransitionValues1.view;
          paramTransitionValues2 = paramTransitionValues2.view;
          if (paramTransitionValues2.getParent() != null) {
            paramViewGroup = paramTransitionValues2;
          } else {
            paramViewGroup = localView;
          }
          if (this.drawingViewId == paramViewGroup.getId())
          {
            localObject = (View)paramViewGroup.getParent();
            paramTransitionValues1 = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
          }
          else
          {
            paramViewGroup = TransitionUtils.findAncestorById(paramViewGroup, this.drawingViewId);
            paramTransitionValues1 = null;
          }
          final Object localObject = TransitionUtils.getLocationOnScreen(paramViewGroup);
          float f1 = -((RectF)localObject).left;
          float f2 = -((RectF)localObject).top;
          paramTransitionValues1 = calculateDrawableBounds(paramViewGroup, paramTransitionValues1, f1, f2);
          localRectF1.offset(f1, f2);
          localRectF2.offset(f1, f2);
          boolean bool = isEntering(localRectF1, localRectF2);
          localObject = new TransitionDrawable(getPathMotion(), localView, localRectF1, localShapeAppearanceModel1, getElevationOrDefault(this.startElevation, localView), paramTransitionValues2, localRectF2, localShapeAppearanceModel2, getElevationOrDefault(this.endElevation, paramTransitionValues2), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, bool, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, bool), FitModeEvaluators.get(this.fitMode, bool, localRectF1, localRectF2), buildThresholdsGroup(bool), this.drawDebugEnabled, null);
          ((Drawable)localObject).setBounds(Math.round(paramTransitionValues1.left), Math.round(paramTransitionValues1.top), Math.round(paramTransitionValues1.right), Math.round(paramTransitionValues1.bottom));
          paramTransitionValues1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          paramTransitionValues1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              MaterialContainerTransform.TransitionDrawable.access$200(localObject, paramAnonymousValueAnimator.getAnimatedFraction());
            }
          });
          addListener(new TransitionListenerAdapter()
          {
            public void onTransitionEnd(@NonNull Transition paramAnonymousTransition)
            {
              MaterialContainerTransform.this.removeListener(this);
              if (MaterialContainerTransform.this.holdAtEndEnabled) {
                return;
              }
              localView.setAlpha(1.0F);
              paramTransitionValues2.setAlpha(1.0F);
              ViewUtils.getOverlay(paramViewGroup).remove(localObject);
            }
            
            public void onTransitionStart(@NonNull Transition paramAnonymousTransition)
            {
              ViewUtils.getOverlay(paramViewGroup).add(localObject);
              localView.setAlpha(0.0F);
              paramTransitionValues2.setAlpha(0.0F);
            }
          });
          return paramTransitionValues1;
        }
        Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
      }
      Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    }
    return null;
  }
  
  @ColorInt
  public int getContainerColor()
  {
    return this.containerColor;
  }
  
  @IdRes
  public int getDrawingViewId()
  {
    return this.drawingViewId;
  }
  
  @ColorInt
  public int getEndContainerColor()
  {
    return this.endContainerColor;
  }
  
  public float getEndElevation()
  {
    return this.endElevation;
  }
  
  @Nullable
  public ShapeAppearanceModel getEndShapeAppearanceModel()
  {
    return this.endShapeAppearanceModel;
  }
  
  @Nullable
  public View getEndView()
  {
    return this.endView;
  }
  
  @IdRes
  public int getEndViewId()
  {
    return this.endViewId;
  }
  
  public int getFadeMode()
  {
    return this.fadeMode;
  }
  
  @Nullable
  public ProgressThresholds getFadeProgressThresholds()
  {
    return this.fadeProgressThresholds;
  }
  
  public int getFitMode()
  {
    return this.fitMode;
  }
  
  @Nullable
  public ProgressThresholds getScaleMaskProgressThresholds()
  {
    return this.scaleMaskProgressThresholds;
  }
  
  @Nullable
  public ProgressThresholds getScaleProgressThresholds()
  {
    return this.scaleProgressThresholds;
  }
  
  @ColorInt
  public int getScrimColor()
  {
    return this.scrimColor;
  }
  
  @Nullable
  public ProgressThresholds getShapeMaskProgressThresholds()
  {
    return this.shapeMaskProgressThresholds;
  }
  
  @ColorInt
  public int getStartContainerColor()
  {
    return this.startContainerColor;
  }
  
  public float getStartElevation()
  {
    return this.startElevation;
  }
  
  @Nullable
  public ShapeAppearanceModel getStartShapeAppearanceModel()
  {
    return this.startShapeAppearanceModel;
  }
  
  @Nullable
  public View getStartView()
  {
    return this.startView;
  }
  
  @IdRes
  public int getStartViewId()
  {
    return this.startViewId;
  }
  
  public int getTransitionDirection()
  {
    return this.transitionDirection;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return TRANSITION_PROPS;
  }
  
  public boolean isDrawDebugEnabled()
  {
    return this.drawDebugEnabled;
  }
  
  public boolean isElevationShadowEnabled()
  {
    return this.elevationShadowEnabled;
  }
  
  public boolean isHoldAtEndEnabled()
  {
    return this.holdAtEndEnabled;
  }
  
  public void setAllContainerColors(@ColorInt int paramInt)
  {
    this.containerColor = paramInt;
    this.startContainerColor = paramInt;
    this.endContainerColor = paramInt;
  }
  
  public void setContainerColor(@ColorInt int paramInt)
  {
    this.containerColor = paramInt;
  }
  
  public void setDrawDebugEnabled(boolean paramBoolean)
  {
    this.drawDebugEnabled = paramBoolean;
  }
  
  public void setDrawingViewId(@IdRes int paramInt)
  {
    this.drawingViewId = paramInt;
  }
  
  public void setElevationShadowEnabled(boolean paramBoolean)
  {
    this.elevationShadowEnabled = paramBoolean;
  }
  
  public void setEndContainerColor(@ColorInt int paramInt)
  {
    this.endContainerColor = paramInt;
  }
  
  public void setEndElevation(float paramFloat)
  {
    this.endElevation = paramFloat;
  }
  
  public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.endShapeAppearanceModel = paramShapeAppearanceModel;
  }
  
  public void setEndView(@Nullable View paramView)
  {
    this.endView = paramView;
  }
  
  public void setEndViewId(@IdRes int paramInt)
  {
    this.endViewId = paramInt;
  }
  
  public void setFadeMode(int paramInt)
  {
    this.fadeMode = paramInt;
  }
  
  public void setFadeProgressThresholds(@Nullable ProgressThresholds paramProgressThresholds)
  {
    this.fadeProgressThresholds = paramProgressThresholds;
  }
  
  public void setFitMode(int paramInt)
  {
    this.fitMode = paramInt;
  }
  
  public void setHoldAtEndEnabled(boolean paramBoolean)
  {
    this.holdAtEndEnabled = paramBoolean;
  }
  
  public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds paramProgressThresholds)
  {
    this.scaleMaskProgressThresholds = paramProgressThresholds;
  }
  
  public void setScaleProgressThresholds(@Nullable ProgressThresholds paramProgressThresholds)
  {
    this.scaleProgressThresholds = paramProgressThresholds;
  }
  
  public void setScrimColor(@ColorInt int paramInt)
  {
    this.scrimColor = paramInt;
  }
  
  public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds paramProgressThresholds)
  {
    this.shapeMaskProgressThresholds = paramProgressThresholds;
  }
  
  public void setStartContainerColor(@ColorInt int paramInt)
  {
    this.startContainerColor = paramInt;
  }
  
  public void setStartElevation(float paramFloat)
  {
    this.startElevation = paramFloat;
  }
  
  public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.startShapeAppearanceModel = paramShapeAppearanceModel;
  }
  
  public void setStartView(@Nullable View paramView)
  {
    this.startView = paramView;
  }
  
  public void setStartViewId(@IdRes int paramInt)
  {
    this.startViewId = paramInt;
  }
  
  public void setTransitionDirection(int paramInt)
  {
    this.transitionDirection = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FadeMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FitMode {}
  
  public static class ProgressThresholds
  {
    @FloatRange(from=0.0D, to=1.0D)
    private final float end;
    @FloatRange(from=0.0D, to=1.0D)
    private final float start;
    
    public ProgressThresholds(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
    {
      this.start = paramFloat1;
      this.end = paramFloat2;
    }
    
    @FloatRange(from=0.0D, to=1.0D)
    public float getEnd()
    {
      return this.end;
    }
    
    @FloatRange(from=0.0D, to=1.0D)
    public float getStart()
    {
      return this.start;
    }
  }
  
  private static class ProgressThresholdsGroup
  {
    @NonNull
    private final MaterialContainerTransform.ProgressThresholds fade;
    @NonNull
    private final MaterialContainerTransform.ProgressThresholds scale;
    @NonNull
    private final MaterialContainerTransform.ProgressThresholds scaleMask;
    @NonNull
    private final MaterialContainerTransform.ProgressThresholds shapeMask;
    
    private ProgressThresholdsGroup(@NonNull MaterialContainerTransform.ProgressThresholds paramProgressThresholds1, @NonNull MaterialContainerTransform.ProgressThresholds paramProgressThresholds2, @NonNull MaterialContainerTransform.ProgressThresholds paramProgressThresholds3, @NonNull MaterialContainerTransform.ProgressThresholds paramProgressThresholds4)
    {
      this.fade = paramProgressThresholds1;
      this.scale = paramProgressThresholds2;
      this.scaleMask = paramProgressThresholds3;
      this.shapeMask = paramProgressThresholds4;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TransitionDirection {}
  
  private static final class TransitionDrawable
    extends Drawable
  {
    private static final int COMPAT_SHADOW_COLOR = -7829368;
    private static final int SHADOW_COLOR = 754974720;
    private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3F;
    private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5F;
    private final MaterialShapeDrawable compatShadowDrawable;
    private final Paint containerPaint;
    private float currentElevation;
    private float currentElevationDy;
    private final RectF currentEndBounds;
    private final RectF currentEndBoundsMasked;
    private RectF currentMaskBounds;
    private final RectF currentStartBounds;
    private final RectF currentStartBoundsMasked;
    private final Paint debugPaint;
    private final Path debugPath;
    private final float displayHeight;
    private final float displayWidth;
    private final boolean drawDebugEnabled;
    private final boolean elevationShadowEnabled;
    private final RectF endBounds;
    private final Paint endContainerPaint;
    private final float endElevation;
    private final ShapeAppearanceModel endShapeAppearanceModel;
    private final View endView;
    private final boolean entering;
    private final FadeModeEvaluator fadeModeEvaluator;
    private FadeModeResult fadeModeResult;
    private final FitModeEvaluator fitModeEvaluator;
    private FitModeResult fitModeResult;
    private final MaskEvaluator maskEvaluator;
    private final float motionPathLength;
    private final PathMeasure motionPathMeasure;
    private final float[] motionPathPosition;
    private float progress;
    private final MaterialContainerTransform.ProgressThresholdsGroup progressThresholds;
    private final Paint scrimPaint;
    private final Paint shadowPaint;
    private final RectF startBounds;
    private final Paint startContainerPaint;
    private final float startElevation;
    private final ShapeAppearanceModel startShapeAppearanceModel;
    private final View startView;
    
    private TransitionDrawable(PathMotion paramPathMotion, View paramView1, RectF paramRectF1, ShapeAppearanceModel paramShapeAppearanceModel1, float paramFloat1, View paramView2, RectF paramRectF2, ShapeAppearanceModel paramShapeAppearanceModel2, float paramFloat2, @ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, FadeModeEvaluator paramFadeModeEvaluator, FitModeEvaluator paramFitModeEvaluator, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup, boolean paramBoolean3)
    {
      Paint localPaint1 = new Paint();
      this.containerPaint = localPaint1;
      Paint localPaint2 = new Paint();
      this.startContainerPaint = localPaint2;
      Paint localPaint3 = new Paint();
      this.endContainerPaint = localPaint3;
      this.shadowPaint = new Paint();
      Paint localPaint4 = new Paint();
      this.scrimPaint = localPaint4;
      this.maskEvaluator = new MaskEvaluator();
      float[] arrayOfFloat = new float[2];
      this.motionPathPosition = arrayOfFloat;
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
      this.compatShadowDrawable = localMaterialShapeDrawable;
      Paint localPaint5 = new Paint();
      this.debugPaint = localPaint5;
      this.debugPath = new Path();
      this.startView = paramView1;
      this.startBounds = paramRectF1;
      this.startShapeAppearanceModel = paramShapeAppearanceModel1;
      this.startElevation = paramFloat1;
      this.endView = paramView2;
      this.endBounds = paramRectF2;
      this.endShapeAppearanceModel = paramShapeAppearanceModel2;
      this.endElevation = paramFloat2;
      this.entering = paramBoolean1;
      this.elevationShadowEnabled = paramBoolean2;
      this.fadeModeEvaluator = paramFadeModeEvaluator;
      this.fitModeEvaluator = paramFitModeEvaluator;
      this.progressThresholds = paramProgressThresholdsGroup;
      this.drawDebugEnabled = paramBoolean3;
      paramShapeAppearanceModel1 = (WindowManager)paramView1.getContext().getSystemService("window");
      paramView1 = new DisplayMetrics();
      paramShapeAppearanceModel1.getDefaultDisplay().getMetrics(paramView1);
      this.displayWidth = paramView1.widthPixels;
      this.displayHeight = paramView1.heightPixels;
      localPaint1.setColor(paramInt1);
      localPaint2.setColor(paramInt2);
      localPaint3.setColor(paramInt3);
      localMaterialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
      localMaterialShapeDrawable.setShadowCompatibilityMode(2);
      localMaterialShapeDrawable.setShadowBitmapDrawingEnable(false);
      localMaterialShapeDrawable.setShadowColor(-7829368);
      paramView1 = new RectF(paramRectF1);
      this.currentStartBounds = paramView1;
      this.currentStartBoundsMasked = new RectF(paramView1);
      paramView1 = new RectF(paramView1);
      this.currentEndBounds = paramView1;
      this.currentEndBoundsMasked = new RectF(paramView1);
      paramView1 = getMotionPathPoint(paramRectF1);
      paramShapeAppearanceModel1 = getMotionPathPoint(paramRectF2);
      paramPathMotion = new PathMeasure(paramPathMotion.getPath(paramView1.x, paramView1.y, paramShapeAppearanceModel1.x, paramShapeAppearanceModel1.y), false);
      this.motionPathMeasure = paramPathMotion;
      this.motionPathLength = paramPathMotion.getLength();
      arrayOfFloat[0] = paramRectF1.centerX();
      arrayOfFloat[1] = paramRectF1.top;
      localPaint4.setStyle(Paint.Style.FILL);
      localPaint4.setShader(TransitionUtils.createColorShader(paramInt4));
      localPaint5.setStyle(Paint.Style.STROKE);
      localPaint5.setStrokeWidth(10.0F);
      updateProgress(0.0F);
    }
    
    private static float calculateElevationDxMultiplier(RectF paramRectF, float paramFloat)
    {
      return (paramRectF.centerX() / (paramFloat / 2.0F) - 1.0F) * 0.3F;
    }
    
    private static float calculateElevationDyMultiplier(RectF paramRectF, float paramFloat)
    {
      return paramRectF.centerY() / paramFloat * 1.5F;
    }
    
    private void drawDebugCumulativePath(Canvas paramCanvas, RectF paramRectF, Path paramPath, @ColorInt int paramInt)
    {
      paramRectF = getMotionPathPoint(paramRectF);
      if (this.progress == 0.0F)
      {
        paramPath.reset();
        paramPath.moveTo(paramRectF.x, paramRectF.y);
      }
      else
      {
        paramPath.lineTo(paramRectF.x, paramRectF.y);
        this.debugPaint.setColor(paramInt);
        paramCanvas.drawPath(paramPath, this.debugPaint);
      }
    }
    
    private void drawDebugRect(Canvas paramCanvas, RectF paramRectF, @ColorInt int paramInt)
    {
      this.debugPaint.setColor(paramInt);
      paramCanvas.drawRect(paramRectF, this.debugPaint);
    }
    
    private void drawElevationShadow(Canvas paramCanvas)
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
      if (Build.VERSION.SDK_INT > 28) {
        drawElevationShadowWithPaintShadowLayer(paramCanvas);
      } else {
        drawElevationShadowWithMaterialShapeDrawable(paramCanvas);
      }
      paramCanvas.restore();
    }
    
    private void drawElevationShadowWithMaterialShapeDrawable(Canvas paramCanvas)
    {
      MaterialShapeDrawable localMaterialShapeDrawable = this.compatShadowDrawable;
      RectF localRectF = this.currentMaskBounds;
      localMaterialShapeDrawable.setBounds((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
      this.compatShadowDrawable.setElevation(this.currentElevation);
      this.compatShadowDrawable.setShadowVerticalOffset((int)this.currentElevationDy);
      this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
      this.compatShadowDrawable.draw(paramCanvas);
    }
    
    private void drawElevationShadowWithPaintShadowLayer(Canvas paramCanvas)
    {
      ShapeAppearanceModel localShapeAppearanceModel = this.maskEvaluator.getCurrentShapeAppearanceModel();
      if (localShapeAppearanceModel.isRoundRect(this.currentMaskBounds))
      {
        float f = localShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
        paramCanvas.drawRoundRect(this.currentMaskBounds, f, f, this.shadowPaint);
      }
      else
      {
        paramCanvas.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
      }
    }
    
    private void drawEndView(Canvas paramCanvas)
    {
      maybeDrawContainerColor(paramCanvas, this.endContainerPaint);
      Rect localRect = getBounds();
      RectF localRectF = this.currentEndBounds;
      TransitionUtils.transform(paramCanvas, localRect, localRectF.left, localRectF.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation()
      {
        public void run(Canvas paramAnonymousCanvas)
        {
          MaterialContainerTransform.TransitionDrawable.this.endView.draw(paramAnonymousCanvas);
        }
      });
    }
    
    private void drawStartView(Canvas paramCanvas)
    {
      maybeDrawContainerColor(paramCanvas, this.startContainerPaint);
      Rect localRect = getBounds();
      RectF localRectF = this.currentStartBounds;
      TransitionUtils.transform(paramCanvas, localRect, localRectF.left, localRectF.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation()
      {
        public void run(Canvas paramAnonymousCanvas)
        {
          MaterialContainerTransform.TransitionDrawable.this.startView.draw(paramAnonymousCanvas);
        }
      });
    }
    
    private static PointF getMotionPathPoint(RectF paramRectF)
    {
      return new PointF(paramRectF.centerX(), paramRectF.top);
    }
    
    private void maybeDrawContainerColor(Canvas paramCanvas, Paint paramPaint)
    {
      if ((paramPaint.getColor() != 0) && (paramPaint.getAlpha() > 0)) {
        paramCanvas.drawRect(getBounds(), paramPaint);
      }
    }
    
    private void setProgress(float paramFloat)
    {
      if (this.progress != paramFloat) {
        updateProgress(paramFloat);
      }
    }
    
    private void updateProgress(float paramFloat)
    {
      this.progress = paramFloat;
      Object localObject1 = this.scrimPaint;
      if (this.entering) {
        f1 = TransitionUtils.lerp(0.0F, 255.0F, paramFloat);
      } else {
        f1 = TransitionUtils.lerp(255.0F, 0.0F, paramFloat);
      }
      ((Paint)localObject1).setAlpha((int)f1);
      this.motionPathMeasure.getPosTan(this.motionPathLength * paramFloat, this.motionPathPosition, null);
      localObject1 = this.motionPathPosition;
      float f2 = localObject1[0];
      float f1 = localObject1[1];
      float f3 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$500(this.progressThresholds).start))).floatValue();
      float f4 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$500(this.progressThresholds).end))).floatValue();
      Object localObject2 = this.fitModeEvaluator.evaluate(paramFloat, f3, f4, this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
      this.fitModeResult = ((FitModeResult)localObject2);
      localObject1 = this.currentStartBounds;
      f3 = ((FitModeResult)localObject2).currentStartWidth;
      ((RectF)localObject1).set(f2 - f3 / 2.0F, f1, f3 / 2.0F + f2, ((FitModeResult)localObject2).currentStartHeight + f1);
      localObject2 = this.currentEndBounds;
      localObject1 = this.fitModeResult;
      f3 = ((FitModeResult)localObject1).currentEndWidth;
      ((RectF)localObject2).set(f2 - f3 / 2.0F, f1, f2 + f3 / 2.0F, ((FitModeResult)localObject1).currentEndHeight + f1);
      this.currentStartBoundsMasked.set(this.currentStartBounds);
      this.currentEndBoundsMasked.set(this.currentEndBounds);
      f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$600(this.progressThresholds).start))).floatValue();
      f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$600(this.progressThresholds).end))).floatValue();
      boolean bool = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
      if (bool) {
        localObject1 = this.currentStartBoundsMasked;
      } else {
        localObject1 = this.currentEndBoundsMasked;
      }
      f1 = TransitionUtils.lerp(0.0F, 1.0F, f2, f1, paramFloat);
      if (!bool) {
        f1 = 1.0F - f1;
      }
      this.fitModeEvaluator.applyMask((RectF)localObject1, f1, this.fitModeResult);
      this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
      this.maskEvaluator.evaluate(paramFloat, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
      this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, paramFloat);
      f2 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
      f3 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
      f1 = this.currentElevation;
      f2 = (int)(f2 * f1);
      f3 = (int)(f3 * f1);
      this.currentElevationDy = f3;
      this.shadowPaint.setShadowLayer(f1, f2, f3, 754974720);
      f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$400(this.progressThresholds).start))).floatValue();
      f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholdsGroup.access$400(this.progressThresholds).end))).floatValue();
      this.fadeModeResult = this.fadeModeEvaluator.evaluate(paramFloat, f2, f1);
      if (this.startContainerPaint.getColor() != 0) {
        this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
      }
      if (this.endContainerPaint.getColor() != 0) {
        this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
      }
      invalidateSelf();
    }
    
    public void draw(@NonNull Canvas paramCanvas)
    {
      if (this.scrimPaint.getAlpha() > 0) {
        paramCanvas.drawRect(getBounds(), this.scrimPaint);
      }
      int i;
      if (this.drawDebugEnabled) {
        i = paramCanvas.save();
      } else {
        i = -1;
      }
      if ((this.elevationShadowEnabled) && (this.currentElevation > 0.0F)) {
        drawElevationShadow(paramCanvas);
      }
      this.maskEvaluator.clip(paramCanvas);
      maybeDrawContainerColor(paramCanvas, this.containerPaint);
      if (this.fadeModeResult.endOnTop)
      {
        drawStartView(paramCanvas);
        drawEndView(paramCanvas);
      }
      else
      {
        drawEndView(paramCanvas);
        drawStartView(paramCanvas);
      }
      if (this.drawDebugEnabled)
      {
        paramCanvas.restoreToCount(i);
        drawDebugCumulativePath(paramCanvas, this.currentStartBounds, this.debugPath, -65281);
        drawDebugRect(paramCanvas, this.currentStartBoundsMasked, 65280);
        drawDebugRect(paramCanvas, this.currentStartBounds, -16711936);
        drawDebugRect(paramCanvas, this.currentEndBoundsMasked, -16711681);
        drawDebugRect(paramCanvas, this.currentEndBounds, -16776961);
      }
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public void setAlpha(int paramInt)
    {
      throw new UnsupportedOperationException("Setting alpha on is not supported");
    }
    
    public void setColorFilter(@Nullable ColorFilter paramColorFilter)
    {
      throw new UnsupportedOperationException("Setting a color filter is not supported");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\MaterialContainerTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */