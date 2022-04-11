package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public class ShapeAppearancePathProvider
{
  private final Path boundsPath = new Path();
  private final ShapePath[] cornerPaths = new ShapePath[4];
  private final Matrix[] cornerTransforms = new Matrix[4];
  private boolean edgeIntersectionCheckEnabled = true;
  private final Matrix[] edgeTransforms = new Matrix[4];
  private final Path overlappedEdgePath = new Path();
  private final PointF pointF = new PointF();
  private final float[] scratch = new float[2];
  private final float[] scratch2 = new float[2];
  private final ShapePath shapePath = new ShapePath();
  
  public ShapeAppearancePathProvider()
  {
    for (int i = 0; i < 4; i++)
    {
      this.cornerPaths[i] = new ShapePath();
      this.cornerTransforms[i] = new Matrix();
      this.edgeTransforms[i] = new Matrix();
    }
  }
  
  private float angleOfEdge(int paramInt)
  {
    return (paramInt + 1) * 90;
  }
  
  private void appendCornerPath(@NonNull ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    this.scratch[0] = this.cornerPaths[paramInt].getStartX();
    this.scratch[1] = this.cornerPaths[paramInt].getStartY();
    this.cornerTransforms[paramInt].mapPoints(this.scratch);
    Path localPath;
    float[] arrayOfFloat;
    if (paramInt == 0)
    {
      localPath = paramShapeAppearancePathSpec.path;
      arrayOfFloat = this.scratch;
      localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    else
    {
      localPath = paramShapeAppearancePathSpec.path;
      arrayOfFloat = this.scratch;
      localPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    this.cornerPaths[paramInt].applyToPath(this.cornerTransforms[paramInt], paramShapeAppearancePathSpec.path);
    paramShapeAppearancePathSpec = paramShapeAppearancePathSpec.pathListener;
    if (paramShapeAppearancePathSpec != null) {
      paramShapeAppearancePathSpec.onCornerPathCreated(this.cornerPaths[paramInt], this.cornerTransforms[paramInt], paramInt);
    }
  }
  
  private void appendEdgePath(@NonNull ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    int i = (paramInt + 1) % 4;
    this.scratch[0] = this.cornerPaths[paramInt].getEndX();
    this.scratch[1] = this.cornerPaths[paramInt].getEndY();
    this.cornerTransforms[paramInt].mapPoints(this.scratch);
    this.scratch2[0] = this.cornerPaths[i].getStartX();
    this.scratch2[1] = this.cornerPaths[i].getStartY();
    this.cornerTransforms[i].mapPoints(this.scratch2);
    Object localObject1 = this.scratch;
    float f1 = localObject1[0];
    Object localObject2 = this.scratch2;
    f1 = Math.max((float)Math.hypot(f1 - localObject2[0], localObject1[1] - localObject2[1]) - 0.001F, 0.0F);
    float f2 = getEdgeCenterForIndex(paramShapeAppearancePathSpec.bounds, paramInt);
    this.shapePath.reset(0.0F, 0.0F);
    localObject2 = getEdgeTreatmentForIndex(paramInt, paramShapeAppearancePathSpec.shapeAppearanceModel);
    ((EdgeTreatment)localObject2).getEdgePath(f1, f2, paramShapeAppearancePathSpec.interpolation, this.shapePath);
    localObject1 = new Path();
    this.shapePath.applyToPath(this.edgeTransforms[paramInt], (Path)localObject1);
    if ((this.edgeIntersectionCheckEnabled) && (Build.VERSION.SDK_INT >= 19) && ((((EdgeTreatment)localObject2).forceIntersection()) || (pathOverlapsCorner((Path)localObject1, paramInt)) || (pathOverlapsCorner((Path)localObject1, i))))
    {
      ((Path)localObject1).op((Path)localObject1, this.boundsPath, Path.Op.DIFFERENCE);
      this.scratch[0] = this.shapePath.getStartX();
      this.scratch[1] = this.shapePath.getStartY();
      this.edgeTransforms[paramInt].mapPoints(this.scratch);
      localObject2 = this.overlappedEdgePath;
      localObject1 = this.scratch;
      ((Path)localObject2).moveTo(localObject1[0], localObject1[1]);
      this.shapePath.applyToPath(this.edgeTransforms[paramInt], this.overlappedEdgePath);
    }
    else
    {
      this.shapePath.applyToPath(this.edgeTransforms[paramInt], paramShapeAppearancePathSpec.path);
    }
    paramShapeAppearancePathSpec = paramShapeAppearancePathSpec.pathListener;
    if (paramShapeAppearancePathSpec != null) {
      paramShapeAppearancePathSpec.onEdgePathCreated(this.shapePath, this.edgeTransforms[paramInt], paramInt);
    }
  }
  
  private void getCoordinatesOfCorner(int paramInt, @NonNull RectF paramRectF, @NonNull PointF paramPointF)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramPointF.set(paramRectF.right, paramRectF.top);
        } else {
          paramPointF.set(paramRectF.left, paramRectF.top);
        }
      }
      else {
        paramPointF.set(paramRectF.left, paramRectF.bottom);
      }
    }
    else {
      paramPointF.set(paramRectF.right, paramRectF.bottom);
    }
  }
  
  private CornerSize getCornerSizeForIndex(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.getTopRightCornerSize();
        }
        return paramShapeAppearanceModel.getTopLeftCornerSize();
      }
      return paramShapeAppearanceModel.getBottomLeftCornerSize();
    }
    return paramShapeAppearanceModel.getBottomRightCornerSize();
  }
  
  private CornerTreatment getCornerTreatmentForIndex(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.getTopRightCorner();
        }
        return paramShapeAppearanceModel.getTopLeftCorner();
      }
      return paramShapeAppearanceModel.getBottomLeftCorner();
    }
    return paramShapeAppearanceModel.getBottomRightCorner();
  }
  
  private float getEdgeCenterForIndex(@NonNull RectF paramRectF, int paramInt)
  {
    float[] arrayOfFloat = this.scratch;
    ShapePath[] arrayOfShapePath = this.cornerPaths;
    arrayOfFloat[0] = arrayOfShapePath[paramInt].endX;
    arrayOfFloat[1] = arrayOfShapePath[paramInt].endY;
    this.cornerTransforms[paramInt].mapPoints(arrayOfFloat);
    if ((paramInt != 1) && (paramInt != 3)) {
      return Math.abs(paramRectF.centerY() - this.scratch[1]);
    }
    return Math.abs(paramRectF.centerX() - this.scratch[0]);
  }
  
  private EdgeTreatment getEdgeTreatmentForIndex(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.getRightEdge();
        }
        return paramShapeAppearanceModel.getTopEdge();
      }
      return paramShapeAppearanceModel.getLeftEdge();
    }
    return paramShapeAppearanceModel.getBottomEdge();
  }
  
  @RequiresApi(19)
  private boolean pathOverlapsCorner(Path paramPath, int paramInt)
  {
    Path localPath = new Path();
    this.cornerPaths[paramInt].applyToPath(this.cornerTransforms[paramInt], localPath);
    RectF localRectF = new RectF();
    boolean bool1 = true;
    paramPath.computeBounds(localRectF, true);
    localPath.computeBounds(localRectF, true);
    paramPath.op(localPath, Path.Op.INTERSECT);
    paramPath.computeBounds(localRectF, true);
    boolean bool2 = bool1;
    if (localRectF.isEmpty()) {
      if ((localRectF.width() > 1.0F) && (localRectF.height() > 1.0F)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    Object localObject = getCornerSizeForIndex(paramInt, paramShapeAppearancePathSpec.shapeAppearanceModel);
    getCornerTreatmentForIndex(paramInt, paramShapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[paramInt], 90.0F, paramShapeAppearancePathSpec.interpolation, paramShapeAppearancePathSpec.bounds, (CornerSize)localObject);
    float f = angleOfEdge(paramInt);
    this.cornerTransforms[paramInt].reset();
    getCoordinatesOfCorner(paramInt, paramShapeAppearancePathSpec.bounds, this.pointF);
    paramShapeAppearancePathSpec = this.cornerTransforms[paramInt];
    localObject = this.pointF;
    paramShapeAppearancePathSpec.setTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    this.cornerTransforms[paramInt].preRotate(f);
  }
  
  private void setEdgePathAndTransform(int paramInt)
  {
    this.scratch[0] = this.cornerPaths[paramInt].getEndX();
    this.scratch[1] = this.cornerPaths[paramInt].getEndY();
    this.cornerTransforms[paramInt].mapPoints(this.scratch);
    float f = angleOfEdge(paramInt);
    this.edgeTransforms[paramInt].reset();
    Matrix localMatrix = this.edgeTransforms[paramInt];
    float[] arrayOfFloat = this.scratch;
    localMatrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.edgeTransforms[paramInt].preRotate(f);
  }
  
  public void calculatePath(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, @NonNull Path paramPath)
  {
    calculatePath(paramShapeAppearanceModel, paramFloat, paramRectF, null, paramPath);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void calculatePath(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, PathListener paramPathListener, @NonNull Path paramPath)
  {
    paramPath.rewind();
    this.overlappedEdgePath.rewind();
    this.boundsPath.rewind();
    this.boundsPath.addRect(paramRectF, Path.Direction.CW);
    paramShapeAppearanceModel = new ShapeAppearancePathSpec(paramShapeAppearanceModel, paramFloat, paramRectF, paramPathListener, paramPath);
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= 4) {
        break;
      }
      setCornerPathAndTransform(paramShapeAppearanceModel, j);
      setEdgePathAndTransform(j);
    }
    while (k < 4)
    {
      appendCornerPath(paramShapeAppearanceModel, k);
      appendEdgePath(paramShapeAppearanceModel, k);
      k++;
    }
    paramPath.close();
    this.overlappedEdgePath.close();
    if ((Build.VERSION.SDK_INT >= 19) && (!this.overlappedEdgePath.isEmpty())) {
      paramPath.op(this.overlappedEdgePath, Path.Op.UNION);
    }
  }
  
  void setEdgeIntersectionCheckEnable(boolean paramBoolean)
  {
    this.edgeIntersectionCheckEnabled = paramBoolean;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static abstract interface PathListener
  {
    public abstract void onCornerPathCreated(ShapePath paramShapePath, Matrix paramMatrix, int paramInt);
    
    public abstract void onEdgePathCreated(ShapePath paramShapePath, Matrix paramMatrix, int paramInt);
  }
  
  static final class ShapeAppearancePathSpec
  {
    @NonNull
    public final RectF bounds;
    public final float interpolation;
    @NonNull
    public final Path path;
    @Nullable
    public final ShapeAppearancePathProvider.PathListener pathListener;
    @NonNull
    public final ShapeAppearanceModel shapeAppearanceModel;
    
    ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, @Nullable ShapeAppearancePathProvider.PathListener paramPathListener, Path paramPath)
    {
      this.pathListener = paramPathListener;
      this.shapeAppearanceModel = paramShapeAppearanceModel;
      this.interpolation = paramFloat;
      this.bounds = paramRectF;
      this.path = paramPath;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\ShapeAppearancePathProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */