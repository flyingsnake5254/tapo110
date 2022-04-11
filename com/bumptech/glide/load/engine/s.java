package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s<Data, ResourceType, Transcode>
{
  private final Class<Data> a;
  private final Pools.Pool<List<Throwable>> b;
  private final List<? extends i<Data, ResourceType, Transcode>> c;
  private final String d;
  
  public s(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<i<Data, ResourceType, Transcode>> paramList, Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramClass;
    this.b = paramPool;
    this.c = ((List)com.bumptech.glide.util.i.c(paramList));
    paramList = new StringBuilder();
    paramList.append("Failed LoadPath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.d = paramList.toString();
  }
  
  private u<Transcode> b(e<Data> parame, @NonNull f paramf, int paramInt1, int paramInt2, i.a<ResourceType> parama, List<Throwable> paramList)
    throws GlideException
  {
    int i = this.c.size();
    Object localObject1 = null;
    Object localObject3;
    for (int j = 0;; j++)
    {
      Object localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      localObject2 = (i)this.c.get(j);
      try
      {
        localObject2 = ((i)localObject2).a(parame, paramInt1, paramInt2, paramf, parama);
        localObject1 = localObject2;
      }
      catch (GlideException localGlideException)
      {
        paramList.add(localGlideException);
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        break;
      }
    }
    if (localObject3 != null) {
      return (u<Transcode>)localObject3;
    }
    throw new GlideException(this.d, new ArrayList(paramList));
  }
  
  public u<Transcode> a(e<Data> parame, @NonNull f paramf, int paramInt1, int paramInt2, i.a<ResourceType> parama)
    throws GlideException
  {
    List localList = (List)com.bumptech.glide.util.i.d(this.b.acquire());
    try
    {
      parame = b(parame, paramf, paramInt1, paramInt2, parama, localList);
      return parame;
    }
    finally
    {
      this.b.release(localList);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadPath{decodePaths=");
    localStringBuilder.append(Arrays.toString(this.c.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */