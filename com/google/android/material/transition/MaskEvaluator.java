package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class MaskEvaluator
{
  private ShapeAppearanceModel currentShapeAppearanceModel;
  private final Path endPath = new Path();
  private final Path path = new Path();
  private final ShapeAppearancePathProvider pathProvider = new ShapeAppearancePathProvider();
  private final Path startPath = new Path();
  
  void clip(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramCanvas.clipPath(this.path);
    }
    else
    {
      paramCanvas.clipPath(this.startPath);
      paramCanvas.clipPath(this.endPath, Region.Op.UNION);
    }
  }
  
  void evaluate(float paramFloat, ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, MaterialContainerTransform.ProgressThresholds paramProgressThresholds)
  {
    paramShapeAppearanceModel1 = TransitionUtils.lerp(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, paramRectF3, paramProgressThresholds.getStart(), paramProgressThresholds.getEnd(), paramFloat);
    this.currentShapeAppearanceModel = paramShapeAppearanceModel1;
    this.pathProvider.calculatePath(paramShapeAppearanceModel1, 1.0F, paramRectF2, this.startPath);
    this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0F, paramRectF3, this.endPath);
    if (Build.VERSION.SDK_INT >= 23) {
      this.path.op(this.startPath, this.endPath, Path.Op.UNION);
    }
  }
  
  ShapeAppearanceModel getCurrentShapeAppearanceModel()
  {
    return this.currentShapeAppearanceModel;
  }
  
  Path getPath()
  {
    return this.path;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\MaskEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */