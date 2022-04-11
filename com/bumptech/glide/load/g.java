package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import java.io.IOException;

public abstract interface g<T, Z>
{
  public abstract boolean a(@NonNull T paramT, @NonNull f paramf)
    throws IOException;
  
  @Nullable
  public abstract u<Z> b(@NonNull T paramT, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */