package com.enrique.stackblur;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NativeBlurProcess
{
  static final ExecutorService EXECUTOR;
  static final int EXECUTOR_THREADS;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    EXECUTOR_THREADS = i;
    EXECUTOR = Executors.newFixedThreadPool(i);
    System.loadLibrary("blur");
  }
  
  private static native void functionToBlur(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public Bitmap blur(Bitmap paramBitmap, float paramFloat)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    int i = EXECUTOR_THREADS;
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      int k = (int)paramFloat;
      localArrayList1.add(new NativeTask(paramBitmap, k, i, j, 1));
      localArrayList2.add(new NativeTask(paramBitmap, k, i, j, 2));
    }
    try
    {
      ExecutorService localExecutorService = EXECUTOR;
      localExecutorService.invokeAll(localArrayList1);
      localExecutorService.invokeAll(localArrayList2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    return paramBitmap;
  }
  
  private static class NativeTask
    implements Callable<Void>
  {
    private final Bitmap _bitmapOut;
    private final int _coreIndex;
    private final int _radius;
    private final int _round;
    private final int _totalCores;
    
    public NativeTask(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this._bitmapOut = paramBitmap;
      this._radius = paramInt1;
      this._totalCores = paramInt2;
      this._coreIndex = paramInt3;
      this._round = paramInt4;
    }
    
    public Void call()
      throws Exception
    {
      NativeBlurProcess.functionToBlur(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\enrique\stackblur\NativeBlurProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */