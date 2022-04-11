package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback
{
  private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
  private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
  private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
  private static final int MAX_IMAGE_SIZE = 1048576;
  private Matrix mTempMatrix;
  
  private static Bitmap createDrawableBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i > 0) && (j > 0))
    {
      float f = Math.min(1.0F, 1048576.0F / (i * j));
      if (((paramDrawable instanceof BitmapDrawable)) && (f == 1.0F)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = (int)(i * f);
      j = (int)(j * f);
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Rect localRect = paramDrawable.getBounds();
      int k = localRect.left;
      int m = localRect.top;
      int n = localRect.right;
      int i1 = localRect.bottom;
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      paramDrawable.setBounds(k, m, n, i1);
      return localBitmap;
    }
    return null;
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      Drawable localDrawable = ((ImageView)localObject1).getBackground();
      if ((localObject2 != null) && (localDrawable == null))
      {
        localObject2 = createDrawableBitmap((Drawable)localObject2);
        if (localObject2 != null)
        {
          paramView = new Bundle();
          paramView.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
          paramView.putString("sharedElement:snapshot:imageScaleType", ((ImageView)localObject1).getScaleType().toString());
          if (((ImageView)localObject1).getScaleType() == ImageView.ScaleType.MATRIX)
          {
            paramRectF = ((ImageView)localObject1).getImageMatrix();
            paramMatrix = new float[9];
            paramRectF.getValues(paramMatrix);
            paramView.putFloatArray("sharedElement:snapshot:imageMatrix", paramMatrix);
          }
          return paramView;
        }
      }
    }
    int i = Math.round(paramRectF.width());
    int j = Math.round(paramRectF.height());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (j > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (i * j));
        i = (int)(i * f);
        j = (int)(j * f);
        if (this.mTempMatrix == null) {
          this.mTempMatrix = new Matrix();
        }
        this.mTempMatrix.set(paramMatrix);
        this.mTempMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
        this.mTempMatrix.postScale(f, f);
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        paramMatrix.concat(this.mTempMatrix);
        paramView.draw(paramMatrix);
      }
    }
    return (Parcelable)localObject1;
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    boolean bool = paramParcelable instanceof Bundle;
    Object localObject = null;
    if (bool)
    {
      paramParcelable = (Bundle)paramParcelable;
      localObject = (Bitmap)paramParcelable.getParcelable("sharedElement:snapshot:bitmap");
      if (localObject == null) {
        return null;
      }
      paramContext = new ImageView(paramContext);
      paramContext.setImageBitmap((Bitmap)localObject);
      paramContext.setScaleType(ImageView.ScaleType.valueOf(paramParcelable.getString("sharedElement:snapshot:imageScaleType")));
      localObject = paramContext;
      if (paramContext.getScaleType() == ImageView.ScaleType.MATRIX)
      {
        paramParcelable = paramParcelable.getFloatArray("sharedElement:snapshot:imageMatrix");
        localObject = new Matrix();
        ((Matrix)localObject).setValues(paramParcelable);
        paramContext.setImageMatrix((Matrix)localObject);
        localObject = paramContext;
      }
    }
    else if ((paramParcelable instanceof Bitmap))
    {
      paramParcelable = (Bitmap)paramParcelable;
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setImageBitmap(paramParcelable);
    }
    return (View)localObject;
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public void onRejectSharedElements(List<View> paramList) {}
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
  {
    paramOnSharedElementsReadyListener.onSharedElementsReady();
  }
  
  public static abstract interface OnSharedElementsReadyListener
  {
    public abstract void onSharedElementsReady();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\SharedElementCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */