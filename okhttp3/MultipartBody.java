package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody
  extends RequestBody
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE = { 58, 32 };
  private static final byte[] CRLF = { 13, 10 };
  private static final byte[] DASHDASH = { 45, 45 };
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.get("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final MediaType originalType;
  private final List<Part> parts;
  
  static
  {
    ALTERNATIVE = MediaType.get("multipart/alternative");
    DIGEST = MediaType.get("multipart/digest");
    PARALLEL = MediaType.get("multipart/parallel");
    FORM = MediaType.get("multipart/form-data");
  }
  
  MultipartBody(ByteString paramByteString, MediaType paramMediaType, List<Part> paramList)
  {
    this.boundary = paramByteString;
    this.originalType = paramMediaType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaType);
    localStringBuilder.append("; boundary=");
    localStringBuilder.append(paramByteString.utf8());
    this.contentType = MediaType.get(localStringBuilder.toString());
    this.parts = Util.immutableList(paramList);
  }
  
  static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString.charAt(j);
      if (c != '\n')
      {
        if (c != '\r')
        {
          if (c != '"') {
            paramStringBuilder.append(c);
          } else {
            paramStringBuilder.append("%22");
          }
        }
        else {
          paramStringBuilder.append("%0D");
        }
      }
      else {
        paramStringBuilder.append("%0A");
      }
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  private long writeOrCountBytes(@Nullable BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = new Buffer();
      paramBufferedSink = (BufferedSink)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramBufferedSink;
      paramBufferedSink = (BufferedSink)localObject2;
    }
    int i = this.parts.size();
    long l1 = 0L;
    for (int j = 0; j < i; j++)
    {
      localObject2 = (Part)this.parts.get(j);
      Object localObject3 = ((Part)localObject2).headers;
      localObject2 = ((Part)localObject2).body;
      ((BufferedSink)localObject1).write(DASHDASH);
      ((BufferedSink)localObject1).write(this.boundary);
      ((BufferedSink)localObject1).write(CRLF);
      if (localObject3 != null)
      {
        int k = ((Headers)localObject3).size();
        for (int m = 0; m < k; m++) {
          ((BufferedSink)localObject1).writeUtf8(((Headers)localObject3).name(m)).write(COLONSPACE).writeUtf8(((Headers)localObject3).value(m)).write(CRLF);
        }
      }
      localObject3 = ((RequestBody)localObject2).contentType();
      if (localObject3 != null) {
        ((BufferedSink)localObject1).writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject3).toString()).write(CRLF);
      }
      l2 = ((RequestBody)localObject2).contentLength();
      if (l2 != -1L)
      {
        ((BufferedSink)localObject1).writeUtf8("Content-Length: ").writeDecimalLong(l2).write(CRLF);
      }
      else if (paramBoolean)
      {
        paramBufferedSink.clear();
        return -1L;
      }
      localObject3 = CRLF;
      ((BufferedSink)localObject1).write((byte[])localObject3);
      if (paramBoolean) {
        l1 += l2;
      } else {
        ((RequestBody)localObject2).writeTo((BufferedSink)localObject1);
      }
      ((BufferedSink)localObject1).write((byte[])localObject3);
    }
    Object localObject2 = DASHDASH;
    ((BufferedSink)localObject1).write((byte[])localObject2);
    ((BufferedSink)localObject1).write(this.boundary);
    ((BufferedSink)localObject1).write((byte[])localObject2);
    ((BufferedSink)localObject1).write(CRLF);
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + paramBufferedSink.size();
      paramBufferedSink.clear();
    }
    return l2;
  }
  
  public String boundary()
  {
    return this.boundary.utf8();
  }
  
  public long contentLength()
    throws IOException
  {
    long l = this.contentLength;
    if (l != -1L) {
      return l;
    }
    l = writeOrCountBytes(null, true);
    this.contentLength = l;
    return l;
  }
  
  public MediaType contentType()
  {
    return this.contentType;
  }
  
  public Part part(int paramInt)
  {
    return (Part)this.parts.get(paramInt);
  }
  
  public List<Part> parts()
  {
    return this.parts;
  }
  
  public int size()
  {
    return this.parts.size();
  }
  
  public MediaType type()
  {
    return this.originalType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  public static final class Builder
  {
    private final ByteString boundary;
    private final List<MultipartBody.Part> parts = new ArrayList();
    private MediaType type = MultipartBody.MIXED;
    
    public Builder()
    {
      this(UUID.randomUUID().toString());
    }
    
    public Builder(String paramString)
    {
      this.boundary = ByteString.encodeUtf8(paramString);
    }
    
    public Builder addFormDataPart(String paramString1, String paramString2)
    {
      return addPart(MultipartBody.Part.createFormData(paramString1, paramString2));
    }
    
    public Builder addFormDataPart(String paramString1, @Nullable String paramString2, RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.createFormData(paramString1, paramString2, paramRequestBody));
    }
    
    public Builder addPart(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.create(paramHeaders, paramRequestBody));
    }
    
    public Builder addPart(MultipartBody.Part paramPart)
    {
      Objects.requireNonNull(paramPart, "part == null");
      this.parts.add(paramPart);
      return this;
    }
    
    public Builder addPart(RequestBody paramRequestBody)
    {
      return addPart(MultipartBody.Part.create(paramRequestBody));
    }
    
    public MultipartBody build()
    {
      if (!this.parts.isEmpty()) {
        return new MultipartBody(this.boundary, this.type, this.parts);
      }
      throw new IllegalStateException("Multipart body must have at least one part.");
    }
    
    public Builder setType(MediaType paramMediaType)
    {
      Objects.requireNonNull(paramMediaType, "type == null");
      if (paramMediaType.type().equals("multipart"))
      {
        this.type = paramMediaType;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multipart != ");
      localStringBuilder.append(paramMediaType);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public static final class Part
  {
    final RequestBody body;
    @Nullable
    final Headers headers;
    
    private Part(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
    {
      this.headers = paramHeaders;
      this.body = paramRequestBody;
    }
    
    public static Part create(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
    {
      Objects.requireNonNull(paramRequestBody, "body == null");
      if ((paramHeaders != null) && (paramHeaders.get("Content-Type") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Type");
      }
      if ((paramHeaders != null) && (paramHeaders.get("Content-Length") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Length");
      }
      return new Part(paramHeaders, paramRequestBody);
    }
    
    public static Part create(RequestBody paramRequestBody)
    {
      return create(null, paramRequestBody);
    }
    
    public static Part createFormData(String paramString1, String paramString2)
    {
      return createFormData(paramString1, null, RequestBody.create(null, paramString2));
    }
    
    public static Part createFormData(String paramString1, @Nullable String paramString2, RequestBody paramRequestBody)
    {
      Objects.requireNonNull(paramString1, "name == null");
      StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
      MultipartBody.appendQuotedString(localStringBuilder, paramString1);
      if (paramString2 != null)
      {
        localStringBuilder.append("; filename=");
        MultipartBody.appendQuotedString(localStringBuilder, paramString2);
      }
      return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", localStringBuilder.toString()).build(), paramRequestBody);
    }
    
    public RequestBody body()
    {
      return this.body;
    }
    
    @Nullable
    public Headers headers()
    {
      return this.headers;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\MultipartBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */