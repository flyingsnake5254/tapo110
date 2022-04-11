package retrofit2.w.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.f;

final class b<T>
  implements f<T, RequestBody>
{
  private static final MediaType a = MediaType.get("application/json; charset=UTF-8");
  private static final Charset b = Charset.forName("UTF-8");
  private final Gson c;
  private final TypeAdapter<T> d;
  
  b(Gson paramGson, TypeAdapter<T> paramTypeAdapter)
  {
    this.c = paramGson;
    this.d = paramTypeAdapter;
  }
  
  public RequestBody a(T paramT)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    Object localObject = new OutputStreamWriter(localBuffer.outputStream(), b);
    localObject = this.c.s((Writer)localObject);
    this.d.write((com.google.gson.stream.b)localObject, paramT);
    ((com.google.gson.stream.b)localObject).close();
    return RequestBody.create(a, localBuffer.readByteString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\w\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */