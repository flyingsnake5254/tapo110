package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.i;
import java.io.IOException;

public class a<DataType>
  implements g<DataType, BitmapDrawable>
{
  private final g<DataType, Bitmap> a;
  private final Resources b;
  
  public a(@NonNull Resources paramResources, @NonNull g<DataType, Bitmap> paramg)
  {
    this.b = ((Resources)i.d(paramResources));
    this.a = ((g)i.d(paramg));
  }
  
  public boolean a(@NonNull DataType paramDataType, @NonNull f paramf)
    throws IOException
  {
    return this.a.a(paramDataType, paramf);
  }
  
  public u<BitmapDrawable> b(@NonNull DataType paramDataType, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    paramDataType = this.a.b(paramDataType, paramInt1, paramInt2, paramf);
    return s.f(this.b, paramDataType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */