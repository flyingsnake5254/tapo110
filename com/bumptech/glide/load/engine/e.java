package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.a0.a.b;
import com.bumptech.glide.load.f;
import java.io.File;

class e<DataType>
  implements a.b
{
  private final a<DataType> a;
  private final DataType b;
  private final f c;
  
  e(a<DataType> parama, DataType paramDataType, f paramf)
  {
    this.a = parama;
    this.b = paramDataType;
    this.c = paramf;
  }
  
  public boolean a(@NonNull File paramFile)
  {
    return this.a.a(this.b, paramFile, this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */