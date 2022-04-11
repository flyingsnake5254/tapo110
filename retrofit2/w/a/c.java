package retrofit2.w.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.f;

final class c<T>
  implements f<ResponseBody, T>
{
  private final Gson a;
  private final TypeAdapter<T> b;
  
  c(Gson paramGson, TypeAdapter<T> paramTypeAdapter)
  {
    this.a = paramGson;
    this.b = paramTypeAdapter;
  }
  
  public T a(ResponseBody paramResponseBody)
    throws IOException
  {
    Object localObject1 = this.a.r(paramResponseBody.charStream());
    try
    {
      Object localObject2 = this.b.read((a)localObject1);
      JsonToken localJsonToken = ((a)localObject1).G();
      localObject1 = JsonToken.END_DOCUMENT;
      if (localJsonToken == localObject1) {
        return (T)localObject2;
      }
      localObject2 = new com/google/gson/JsonIOException;
      ((JsonIOException)localObject2).<init>("JSON document was not fully consumed.");
      throw ((Throwable)localObject2);
    }
    finally
    {
      paramResponseBody.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\w\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */