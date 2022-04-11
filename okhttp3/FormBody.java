package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody
  extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
  private final List<String> encodedNames;
  private final List<String> encodedValues;
  
  FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.immutableList(paramList1);
    this.encodedValues = Util.immutableList(paramList2);
  }
  
  private long writeOrCountBytes(@Nullable BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBufferedSink = new Buffer();
    } else {
      paramBufferedSink = paramBufferedSink.buffer();
    }
    int i = 0;
    int j = this.encodedNames.size();
    while (i < j)
    {
      if (i > 0) {
        paramBufferedSink.writeByte(38);
      }
      paramBufferedSink.writeUtf8((String)this.encodedNames.get(i));
      paramBufferedSink.writeByte(61);
      paramBufferedSink.writeUtf8((String)this.encodedValues.get(i));
      i++;
    }
    long l;
    if (paramBoolean)
    {
      l = paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    else
    {
      l = 0L;
    }
    return l;
  }
  
  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }
  
  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }
  
  public String encodedName(int paramInt)
  {
    return (String)this.encodedNames.get(paramInt);
  }
  
  public String encodedValue(int paramInt)
  {
    return (String)this.encodedValues.get(paramInt);
  }
  
  public String name(int paramInt)
  {
    return HttpUrl.percentDecode(encodedName(paramInt), true);
  }
  
  public int size()
  {
    return this.encodedNames.size();
  }
  
  public String value(int paramInt)
  {
    return HttpUrl.percentDecode(encodedValue(paramInt), true);
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  public static final class Builder
  {
    private final Charset charset;
    private final List<String> names = new ArrayList();
    private final List<String> values = new ArrayList();
    
    public Builder()
    {
      this(null);
    }
    
    public Builder(Charset paramCharset)
    {
      this.charset = paramCharset;
    }
    
    public Builder add(String paramString1, String paramString2)
    {
      Objects.requireNonNull(paramString1, "name == null");
      Objects.requireNonNull(paramString2, "value == null");
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
      return this;
    }
    
    public Builder addEncoded(String paramString1, String paramString2)
    {
      Objects.requireNonNull(paramString1, "name == null");
      Objects.requireNonNull(paramString2, "value == null");
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
      return this;
    }
    
    public FormBody build()
    {
      return new FormBody(this.names, this.values);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\FormBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */