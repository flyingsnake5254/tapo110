package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class i<DataType, ResourceType, Transcode>
{
  private final Class<DataType> a;
  private final List<? extends g<DataType, ResourceType>> b;
  private final com.bumptech.glide.load.k.g.e<ResourceType, Transcode> c;
  private final Pools.Pool<List<Throwable>> d;
  private final String e;
  
  public i(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends g<DataType, ResourceType>> paramList, com.bumptech.glide.load.k.g.e<ResourceType, Transcode> parame, Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramClass;
    this.b = paramList;
    this.c = parame;
    this.d = paramPool;
    paramList = new StringBuilder();
    paramList.append("Failed DecodePath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.e = paramList.toString();
  }
  
  @NonNull
  private u<ResourceType> b(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, @NonNull f paramf)
    throws GlideException
  {
    List localList = (List)com.bumptech.glide.util.i.d(this.d.acquire());
    try
    {
      parame = c(parame, paramInt1, paramInt2, paramf, localList);
      return parame;
    }
    finally
    {
      this.d.release(localList);
    }
  }
  
  @NonNull
  private u<ResourceType> c(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, @NonNull f paramf, List<Throwable> paramList)
    throws GlideException
  {
    int i = this.b.size();
    Object localObject1 = null;
    int j = 0;
    Object localObject3;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      g localg = (g)this.b.get(j);
      localObject2 = localObject1;
      try
      {
        if (!localg.a(parame.a(), paramf)) {
          break label161;
        }
        localObject2 = localg.b(parame.a(), paramInt1, paramInt2, paramf);
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      if (Log.isLoggable("DecodePath", 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to decode data for ");
        localStringBuilder.append(localg);
        Log.v("DecodePath", localStringBuilder.toString(), localIOException);
      }
      paramList.add(localIOException);
      localObject3 = localObject1;
      label161:
      if (localObject3 != null) {
        break;
      }
      j++;
      localObject1 = localObject3;
    }
    if (localObject3 != null) {
      return (u<ResourceType>)localObject3;
    }
    throw new GlideException(this.e, new ArrayList(paramList));
  }
  
  public u<Transcode> a(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, @NonNull f paramf, a<ResourceType> parama)
    throws GlideException
  {
    parame = parama.a(b(parame, paramInt1, paramInt2, paramf));
    return this.c.a(parame, paramf);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodePath{ dataClass=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", decoders=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", transcoder=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  static abstract interface a<ResourceType>
  {
    @NonNull
    public abstract u<ResourceType> a(@NonNull u<ResourceType> paramu);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */