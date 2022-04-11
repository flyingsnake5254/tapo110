package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public abstract class HttpObjectDecoder
  extends ByteToMessageDecoder
{
  private static final Pattern COMMA_PATTERN = Pattern.compile(",");
  public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
  public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
  public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
  public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
  public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
  public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
  public static final boolean DEFAULT_VALIDATE_HEADERS = true;
  private static final String EMPTY_VALUE = "";
  private final boolean allowDuplicateContentLengths;
  private long chunkSize;
  private final boolean chunkedSupported;
  private long contentLength = Long.MIN_VALUE;
  private State currentState = State.SKIP_CONTROL_CHARS;
  private final HeaderParser headerParser;
  private final LineParser lineParser;
  private final int maxChunkSize;
  private HttpMessage message;
  private CharSequence name;
  private volatile boolean resetRequested;
  private LastHttpContent trailer;
  protected final boolean validateHeaders;
  private CharSequence value;
  
  protected HttpObjectDecoder()
  {
    this(4096, 8192, 8192, true);
  }
  
  protected HttpObjectDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean, true);
  }
  
  protected HttpObjectDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, 128);
  }
  
  protected HttpObjectDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, false);
  }
  
  protected HttpObjectDecoder(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, boolean paramBoolean3)
  {
    ObjectUtil.checkPositive(paramInt1, "maxInitialLineLength");
    ObjectUtil.checkPositive(paramInt2, "maxHeaderSize");
    ObjectUtil.checkPositive(paramInt3, "maxChunkSize");
    AppendableCharSequence localAppendableCharSequence = new AppendableCharSequence(paramInt4);
    this.lineParser = new LineParser(localAppendableCharSequence, paramInt1);
    this.headerParser = new HeaderParser(localAppendableCharSequence, paramInt2);
    this.maxChunkSize = paramInt3;
    this.chunkedSupported = paramBoolean1;
    this.validateHeaders = paramBoolean2;
    this.allowDuplicateContentLengths = paramBoolean3;
  }
  
  private long contentLength()
  {
    if (this.contentLength == Long.MIN_VALUE) {
      this.contentLength = HttpUtil.getContentLength(this.message, -1L);
    }
    return this.contentLength;
  }
  
  private static int findEndOfString(AppendableCharSequence paramAppendableCharSequence)
  {
    for (int i = paramAppendableCharSequence.length() - 1; i > 0; i--) {
      if (!Character.isWhitespace(paramAppendableCharSequence.charAtUnsafe(i))) {
        return i + 1;
      }
    }
    return 0;
  }
  
  private static int findNonSPLenient(AppendableCharSequence paramAppendableCharSequence, int paramInt)
  {
    while (paramInt < paramAppendableCharSequence.length())
    {
      char c = paramAppendableCharSequence.charAtUnsafe(paramInt);
      if (isSPLenient(c))
      {
        paramInt++;
      }
      else
      {
        if (!Character.isWhitespace(c)) {
          return paramInt;
        }
        throw new IllegalArgumentException("Invalid separator");
      }
    }
    return paramAppendableCharSequence.length();
  }
  
  private static int findNonWhitespace(AppendableCharSequence paramAppendableCharSequence, int paramInt, boolean paramBoolean)
  {
    while (paramInt < paramAppendableCharSequence.length())
    {
      char c = paramAppendableCharSequence.charAtUnsafe(paramInt);
      if (!Character.isWhitespace(c)) {
        return paramInt;
      }
      if ((paramBoolean) && (!isOWS(c)))
      {
        paramAppendableCharSequence = new StringBuilder();
        paramAppendableCharSequence.append("Invalid separator, only a single space or horizontal tab allowed, but received a '");
        paramAppendableCharSequence.append(c);
        paramAppendableCharSequence.append("'");
        throw new IllegalArgumentException(paramAppendableCharSequence.toString());
      }
      paramInt++;
    }
    return paramAppendableCharSequence.length();
  }
  
  private static int findSPLenient(AppendableCharSequence paramAppendableCharSequence, int paramInt)
  {
    while (paramInt < paramAppendableCharSequence.length())
    {
      if (isSPLenient(paramAppendableCharSequence.charAtUnsafe(paramInt))) {
        return paramInt;
      }
      paramInt++;
    }
    return paramAppendableCharSequence.length();
  }
  
  private static int getChunkSize(String paramString)
  {
    String str = paramString.trim();
    for (int i = 0;; i++)
    {
      paramString = str;
      if (i >= str.length()) {
        break label59;
      }
      char c = str.charAt(i);
      if ((c == ';') || (Character.isWhitespace(c)) || (Character.isISOControl(c))) {
        break;
      }
    }
    paramString = str.substring(0, i);
    label59:
    return Integer.parseInt(paramString, 16);
  }
  
  private HttpContent invalidChunk(ByteBuf paramByteBuf, Exception paramException)
  {
    this.currentState = State.BAD_MESSAGE;
    paramByteBuf.skipBytes(paramByteBuf.readableBytes());
    paramByteBuf = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
    paramByteBuf.setDecoderResult(DecoderResult.failure(paramException));
    this.message = null;
    this.trailer = null;
    return paramByteBuf;
  }
  
  private HttpMessage invalidMessage(ByteBuf paramByteBuf, Exception paramException)
  {
    this.currentState = State.BAD_MESSAGE;
    paramByteBuf.skipBytes(paramByteBuf.readableBytes());
    if (this.message == null) {
      this.message = createInvalidMessage();
    }
    this.message.setDecoderResult(DecoderResult.failure(paramException));
    paramByteBuf = this.message;
    this.message = null;
    return paramByteBuf;
  }
  
  private static boolean isOWS(char paramChar)
  {
    boolean bool;
    if ((paramChar != ' ') && (paramChar != '\t')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isSPLenient(char paramChar)
  {
    boolean bool;
    if ((paramChar != ' ') && (paramChar != '\t') && (paramChar != '\013') && (paramChar != '\f') && (paramChar != '\r')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private State readHeaders(ByteBuf paramByteBuf)
  {
    HttpMessage localHttpMessage = this.message;
    HttpHeaders localHttpHeaders = localHttpMessage.headers();
    Object localObject1 = this.headerParser.parse(paramByteBuf);
    String[] arrayOfString = null;
    if (localObject1 == null) {
      return null;
    }
    int i;
    Object localObject3;
    if (((AppendableCharSequence)localObject1).length() > 0) {
      do
      {
        i = ((AppendableCharSequence)localObject1).charAtUnsafe(0);
        localObject2 = this.name;
        if ((localObject2 != null) && ((i == 32) || (i == 9)))
        {
          localObject2 = ((AppendableCharSequence)localObject1).toString().trim();
          localObject3 = String.valueOf(this.value);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(' ');
          ((StringBuilder)localObject1).append((String)localObject2);
          this.value = ((StringBuilder)localObject1).toString();
        }
        else
        {
          if (localObject2 != null) {
            localHttpHeaders.add((CharSequence)localObject2, this.value);
          }
          splitHeader((AppendableCharSequence)localObject1);
        }
        localObject2 = this.headerParser.parse(paramByteBuf);
        if (localObject2 == null) {
          return null;
        }
        localObject1 = localObject2;
      } while (((AppendableCharSequence)localObject2).length() > 0);
    }
    paramByteBuf = this.name;
    if (paramByteBuf != null) {
      localHttpHeaders.add(paramByteBuf, this.value);
    }
    this.name = null;
    this.value = null;
    Object localObject2 = localHttpHeaders.getAll(HttpHeaderNames.CONTENT_LENGTH);
    if (!((List)localObject2).isEmpty())
    {
      int j = ((List)localObject2).size();
      int k = 1;
      i = k;
      if (j <= 1) {
        if (((String)((List)localObject2).get(0)).indexOf(',') >= 0) {
          i = k;
        } else {
          i = 0;
        }
      }
      if ((i != 0) && (localHttpMessage.protocolVersion() == HttpVersion.HTTP_1_1))
      {
        if (this.allowDuplicateContentLengths)
        {
          localObject3 = ((List)localObject2).iterator();
          localObject1 = arrayOfString;
          if (((Iterator)localObject3).hasNext())
          {
            paramByteBuf = (String)((Iterator)localObject3).next();
            arrayOfString = COMMA_PATTERN.split(paramByteBuf, -1);
            k = arrayOfString.length;
            i = 0;
            paramByteBuf = (ByteBuf)localObject1;
            for (;;)
            {
              localObject1 = paramByteBuf;
              if (i >= k) {
                break;
              }
              localObject1 = arrayOfString[i].trim();
              if (paramByteBuf == null) {
                paramByteBuf = (ByteBuf)localObject1;
              } else {
                if (!((String)localObject1).equals(paramByteBuf)) {
                  break label411;
                }
              }
              i++;
            }
            label411:
            paramByteBuf = new StringBuilder();
            paramByteBuf.append("Multiple Content-Length values found: ");
            paramByteBuf.append(localObject2);
            throw new IllegalArgumentException(paramByteBuf.toString());
          }
          localHttpHeaders.set(HttpHeaderNames.CONTENT_LENGTH, localObject1);
          this.contentLength = Long.parseLong((String)localObject1);
        }
        else
        {
          paramByteBuf = new StringBuilder();
          paramByteBuf.append("Multiple Content-Length values found: ");
          paramByteBuf.append(localObject2);
          throw new IllegalArgumentException(paramByteBuf.toString());
        }
      }
      else {
        this.contentLength = Long.parseLong((String)((List)localObject2).get(0));
      }
    }
    if (isContentAlwaysEmpty(localHttpMessage))
    {
      HttpUtil.setTransferEncodingChunked(localHttpMessage, false);
      return State.SKIP_CONTROL_CHARS;
    }
    if (HttpUtil.isTransferEncodingChunked(localHttpMessage))
    {
      if ((!((List)localObject2).isEmpty()) && (localHttpMessage.protocolVersion() == HttpVersion.HTTP_1_1)) {
        handleTransferEncodingChunkedWithContentLength(localHttpMessage);
      }
      return State.READ_CHUNK_SIZE;
    }
    if (contentLength() >= 0L) {
      return State.READ_FIXED_LENGTH_CONTENT;
    }
    return State.READ_VARIABLE_LENGTH_CONTENT;
  }
  
  private LastHttpContent readTrailingHeaders(ByteBuf paramByteBuf)
  {
    Object localObject1 = this.headerParser.parse(paramByteBuf);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = this.trailer;
    if ((((AppendableCharSequence)localObject1).length() == 0) && (localObject2 == null)) {
      return LastHttpContent.EMPTY_LAST_CONTENT;
    }
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
      this.trailer = ((LastHttpContent)localObject3);
    }
    localObject2 = null;
    while (((AppendableCharSequence)localObject1).length() > 0)
    {
      int i = ((AppendableCharSequence)localObject1).charAtUnsafe(0);
      Object localObject5;
      if ((localObject2 != null) && ((i == 32) || (i == 9)))
      {
        localObject4 = ((LastHttpContent)localObject3).trailingHeaders().getAll((CharSequence)localObject2);
        localObject5 = localObject2;
        if (!((List)localObject4).isEmpty())
        {
          i = ((List)localObject4).size() - 1;
          String str = ((AppendableCharSequence)localObject1).toString().trim();
          localObject1 = (String)((List)localObject4).get(i);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject1);
          ((StringBuilder)localObject5).append(str);
          ((List)localObject4).set(i, ((StringBuilder)localObject5).toString());
          localObject5 = localObject2;
        }
      }
      else
      {
        splitHeader((AppendableCharSequence)localObject1);
        localObject2 = this.name;
        if ((!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase((CharSequence)localObject2)) && (!HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase((CharSequence)localObject2)) && (!HttpHeaderNames.TRAILER.contentEqualsIgnoreCase((CharSequence)localObject2))) {
          ((LastHttpContent)localObject3).trailingHeaders().add((CharSequence)localObject2, this.value);
        }
        localObject5 = this.name;
        this.name = null;
        this.value = null;
      }
      Object localObject4 = this.headerParser.parse(paramByteBuf);
      localObject1 = localObject4;
      localObject2 = localObject5;
      if (localObject4 == null) {
        return null;
      }
    }
    this.trailer = null;
    return (LastHttpContent)localObject3;
  }
  
  private void resetNow()
  {
    Object localObject = this.message;
    this.message = null;
    this.name = null;
    this.value = null;
    this.contentLength = Long.MIN_VALUE;
    this.lineParser.reset();
    this.headerParser.reset();
    this.trailer = null;
    if (!isDecodingRequest())
    {
      localObject = (HttpResponse)localObject;
      if ((localObject != null) && (isSwitchingToNonHttp1Protocol((HttpResponse)localObject)))
      {
        this.currentState = State.UPGRADED;
        return;
      }
    }
    this.resetRequested = false;
    this.currentState = State.SKIP_CONTROL_CHARS;
  }
  
  private void splitHeader(AppendableCharSequence paramAppendableCharSequence)
  {
    int i = paramAppendableCharSequence.length();
    int j = findNonWhitespace(paramAppendableCharSequence, 0, false);
    for (int k = j; k < i; k++)
    {
      char c = paramAppendableCharSequence.charAtUnsafe(k);
      if ((c == ':') || ((!isDecodingRequest()) && (isOWS(c)))) {
        break;
      }
    }
    if (k != i)
    {
      int n;
      for (int m = k;; m++)
      {
        n = m;
        if (m >= i) {
          break;
        }
        if (paramAppendableCharSequence.charAtUnsafe(m) == ':')
        {
          n = m + 1;
          break;
        }
      }
      this.name = paramAppendableCharSequence.subStringUnsafe(j, k);
      k = findNonWhitespace(paramAppendableCharSequence, n, true);
      if (k == i) {
        this.value = "";
      } else {
        this.value = paramAppendableCharSequence.subStringUnsafe(k, findEndOfString(paramAppendableCharSequence));
      }
      return;
    }
    throw new IllegalArgumentException("No colon found");
  }
  
  private static String[] splitInitialLine(AppendableCharSequence paramAppendableCharSequence)
  {
    int i = findNonSPLenient(paramAppendableCharSequence, 0);
    int j = findSPLenient(paramAppendableCharSequence, i);
    int k = findNonSPLenient(paramAppendableCharSequence, j);
    int m = findSPLenient(paramAppendableCharSequence, k);
    int n = findNonSPLenient(paramAppendableCharSequence, m);
    int i1 = findEndOfString(paramAppendableCharSequence);
    String str1 = paramAppendableCharSequence.subStringUnsafe(i, j);
    String str2 = paramAppendableCharSequence.subStringUnsafe(k, m);
    if (n < i1) {
      paramAppendableCharSequence = paramAppendableCharSequence.subStringUnsafe(n, i1);
    } else {
      paramAppendableCharSequence = "";
    }
    return new String[] { str1, str2, paramAppendableCharSequence };
  }
  
  protected abstract HttpMessage createInvalidMessage();
  
  protected abstract HttpMessage createMessage(String[] paramArrayOfString)
    throws Exception;
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.resetRequested) {
      resetNow();
    }
    paramChannelHandlerContext = 1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;
    int i;
    long l2;
    switch (paramChannelHandlerContext[this.currentState.ordinal()])
    {
    default: 
      break;
    case 11: 
      i = paramByteBuf.readableBytes();
      if (i > 0) {
        paramList.add(paramByteBuf.readBytes(i));
      }
      break;
    case 10: 
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      break;
    case 9: 
      try
      {
        paramChannelHandlerContext = readTrailingHeaders(paramByteBuf);
        if (paramChannelHandlerContext == null) {
          return;
        }
        paramList.add(paramChannelHandlerContext);
        resetNow();
        return;
      }
      catch (Exception paramChannelHandlerContext)
      {
        paramList.add(invalidChunk(paramByteBuf, paramChannelHandlerContext));
        return;
      }
    case 6: 
      i = paramByteBuf.readableBytes();
      if (i == 0) {
        return;
      }
      i = Math.min(i, this.maxChunkSize);
      long l1 = i;
      l2 = this.chunkSize;
      if (l1 > l2) {
        i = (int)l2;
      }
      paramChannelHandlerContext = paramByteBuf.readRetainedSlice(i);
      l2 = this.chunkSize - i;
      this.chunkSize = l2;
      if (l2 == 0L)
      {
        paramList.add(new DefaultLastHttpContent(paramChannelHandlerContext, this.validateHeaders));
        resetNow();
      }
      else
      {
        paramList.add(new DefaultHttpContent(paramChannelHandlerContext));
      }
      return;
    case 5: 
      i = Math.min(paramByteBuf.readableBytes(), this.maxChunkSize);
      if (i > 0) {
        paramList.add(new DefaultHttpContent(paramByteBuf.readRetainedSlice(i)));
      }
      return;
    case 2: 
    case 7: 
    case 8: 
      try
      {
        paramChannelHandlerContext = this.lineParser.parse(paramByteBuf);
        if (paramChannelHandlerContext == null) {
          return;
        }
        i = getChunkSize(paramChannelHandlerContext.toString());
        this.chunkSize = i;
        if (i == 0)
        {
          this.currentState = State.READ_CHUNK_FOOTER;
          return;
        }
        this.currentState = State.READ_CHUNKED_CONTENT;
        i = Math.min(Math.min((int)this.chunkSize, this.maxChunkSize), paramByteBuf.readableBytes());
        if (i == 0) {
          return;
        }
        paramChannelHandlerContext = new DefaultHttpContent(paramByteBuf.readRetainedSlice(i));
        this.chunkSize -= i;
        paramList.add(paramChannelHandlerContext);
        if (this.chunkSize != 0L) {
          return;
        }
        this.currentState = State.READ_CHUNK_DELIMITER;
        int j = paramByteBuf.writerIndex();
        int k;
        for (i = paramByteBuf.readerIndex();; i = k)
        {
          k = i;
          if (j <= i) {
            break;
          }
          k = i + 1;
          if (paramByteBuf.getByte(i) == 10)
          {
            this.currentState = State.READ_CHUNK_SIZE;
            break;
          }
        }
        paramByteBuf.readerIndex(k);
        return;
      }
      catch (Exception paramChannelHandlerContext)
      {
        paramList.add(invalidChunk(paramByteBuf, paramChannelHandlerContext));
        return;
      }
    case 1: 
    case 3: 
    case 4: 
      try
      {
        Object localObject = this.lineParser.parse(paramByteBuf);
        if (localObject == null) {
          return;
        }
        localObject = splitInitialLine((AppendableCharSequence)localObject);
        if (localObject.length < 3)
        {
          this.currentState = State.SKIP_CONTROL_CHARS;
          return;
        }
        this.message = createMessage((String[])localObject);
        this.currentState = State.READ_HEADER;
        try
        {
          localObject = readHeaders(paramByteBuf);
          if (localObject == null) {
            return;
          }
          this.currentState = ((State)localObject);
          i = paramChannelHandlerContext[localObject.ordinal()];
          if (i != 1)
          {
            if (i != 2)
            {
              l2 = contentLength();
              if ((l2 != 0L) && ((l2 != -1L) || (!isDecodingRequest())))
              {
                paramList.add(this.message);
                if (localObject == State.READ_FIXED_LENGTH_CONTENT) {
                  this.chunkSize = l2;
                }
                return;
              }
              paramList.add(this.message);
              paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
              resetNow();
              return;
            }
            if (this.chunkedSupported)
            {
              paramList.add(this.message);
              return;
            }
            paramChannelHandlerContext = new java/lang/IllegalArgumentException;
            paramChannelHandlerContext.<init>("Chunked messages not supported");
            throw paramChannelHandlerContext;
          }
          paramList.add(this.message);
          paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
          resetNow();
          return;
        }
        catch (Exception paramChannelHandlerContext)
        {
          paramList.add(invalidMessage(paramByteBuf, paramChannelHandlerContext));
          return;
        }
        return;
      }
      catch (Exception paramChannelHandlerContext)
      {
        paramList.add(invalidMessage(paramByteBuf, paramChannelHandlerContext));
      }
    }
  }
  
  protected void decodeLast(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    super.decodeLast(paramChannelHandlerContext, paramByteBuf, paramList);
    if (this.resetRequested) {
      resetNow();
    }
    paramChannelHandlerContext = this.message;
    if (paramChannelHandlerContext != null)
    {
      boolean bool1 = HttpUtil.isTransferEncodingChunked(paramChannelHandlerContext);
      if ((this.currentState == State.READ_VARIABLE_LENGTH_CONTENT) && (!paramByteBuf.isReadable()) && (!bool1))
      {
        paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
        resetNow();
        return;
      }
      if (this.currentState == State.READ_HEADER)
      {
        paramList.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
        resetNow();
        return;
      }
      boolean bool2 = isDecodingRequest();
      int i = 1;
      int j = i;
      if (!bool2) {
        if (bool1) {
          j = i;
        } else if (contentLength() > 0L) {
          j = i;
        } else {
          j = 0;
        }
      }
      if (j == 0) {
        paramList.add(LastHttpContent.EMPTY_LAST_CONTENT);
      }
      resetNow();
    }
  }
  
  protected void handleTransferEncodingChunkedWithContentLength(HttpMessage paramHttpMessage)
  {
    paramHttpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
    this.contentLength = Long.MIN_VALUE;
  }
  
  protected boolean isContentAlwaysEmpty(HttpMessage paramHttpMessage)
  {
    boolean bool1 = paramHttpMessage instanceof HttpResponse;
    boolean bool2 = false;
    if (bool1)
    {
      paramHttpMessage = (HttpResponse)paramHttpMessage;
      int i = paramHttpMessage.status().code();
      if ((i >= 100) && (i < 200))
      {
        if ((i != 101) || (paramHttpMessage.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT)) || (!paramHttpMessage.headers().contains(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET, true))) {
          bool2 = true;
        }
        return bool2;
      }
      if ((i == 204) || (i == 304)) {
        return true;
      }
    }
    return false;
  }
  
  protected abstract boolean isDecodingRequest();
  
  protected boolean isSwitchingToNonHttp1Protocol(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.status().code();
    int j = HttpResponseStatus.SWITCHING_PROTOCOLS.code();
    boolean bool1 = false;
    if (i != j) {
      return false;
    }
    paramHttpResponse = paramHttpResponse.headers().get(HttpHeaderNames.UPGRADE);
    boolean bool2;
    if (paramHttpResponse != null)
    {
      bool2 = bool1;
      if (!paramHttpResponse.contains(HttpVersion.HTTP_1_0.text()))
      {
        bool2 = bool1;
        if (paramHttpResponse.contains(HttpVersion.HTTP_1_1.text())) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public void reset()
  {
    this.resetRequested = true;
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof HttpExpectationFailedEvent))
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()];
      if ((i == 2) || (i == 5) || (i == 6)) {
        reset();
      }
    }
    super.userEventTriggered(paramChannelHandlerContext, paramObject);
  }
  
  private static class HeaderParser
    implements ByteProcessor
  {
    private final int maxLength;
    private final AppendableCharSequence seq;
    private int size;
    
    HeaderParser(AppendableCharSequence paramAppendableCharSequence, int paramInt)
    {
      this.seq = paramAppendableCharSequence;
      this.maxLength = paramInt;
    }
    
    protected final void increaseCount()
    {
      int i = this.size + 1;
      this.size = i;
      int j = this.maxLength;
      if (i <= j) {
        return;
      }
      throw newException(j);
    }
    
    protected TooLongFrameException newException(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HTTP header is larger than ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bytes.");
      return new TooLongFrameException(localStringBuilder.toString());
    }
    
    public AppendableCharSequence parse(ByteBuf paramByteBuf)
    {
      int i = this.size;
      this.seq.reset();
      int j = paramByteBuf.forEachByte(this);
      if (j == -1)
      {
        this.size = i;
        return null;
      }
      paramByteBuf.readerIndex(j + 1);
      return this.seq;
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      char c = (char)(paramByte & 0xFF);
      if (c == '\n')
      {
        paramByte = this.seq.length();
        if (paramByte >= 1)
        {
          AppendableCharSequence localAppendableCharSequence = this.seq;
          paramByte--;
          if (localAppendableCharSequence.charAtUnsafe(paramByte) == '\r')
          {
            this.size -= 1;
            this.seq.setLength(paramByte);
          }
        }
        return false;
      }
      increaseCount();
      this.seq.append(c);
      return true;
    }
    
    public void reset()
    {
      this.size = 0;
    }
  }
  
  private final class LineParser
    extends HttpObjectDecoder.HeaderParser
  {
    LineParser(AppendableCharSequence paramAppendableCharSequence, int paramInt)
    {
      super(paramInt);
    }
    
    protected TooLongFrameException newException(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("An HTTP line is larger than ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bytes.");
      return new TooLongFrameException(localStringBuilder.toString());
    }
    
    public AppendableCharSequence parse(ByteBuf paramByteBuf)
    {
      reset();
      return super.parse(paramByteBuf);
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      if (HttpObjectDecoder.this.currentState == HttpObjectDecoder.State.SKIP_CONTROL_CHARS)
      {
        char c = (char)(paramByte & 0xFF);
        if ((!Character.isISOControl(c)) && (!Character.isWhitespace(c)))
        {
          HttpObjectDecoder.access$002(HttpObjectDecoder.this, HttpObjectDecoder.State.READ_INITIAL);
        }
        else
        {
          increaseCount();
          return true;
        }
      }
      return super.process(paramByte);
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("SKIP_CONTROL_CHARS", 0);
      SKIP_CONTROL_CHARS = localState1;
      State localState2 = new State("READ_INITIAL", 1);
      READ_INITIAL = localState2;
      State localState3 = new State("READ_HEADER", 2);
      READ_HEADER = localState3;
      State localState4 = new State("READ_VARIABLE_LENGTH_CONTENT", 3);
      READ_VARIABLE_LENGTH_CONTENT = localState4;
      State localState5 = new State("READ_FIXED_LENGTH_CONTENT", 4);
      READ_FIXED_LENGTH_CONTENT = localState5;
      State localState6 = new State("READ_CHUNK_SIZE", 5);
      READ_CHUNK_SIZE = localState6;
      State localState7 = new State("READ_CHUNKED_CONTENT", 6);
      READ_CHUNKED_CONTENT = localState7;
      State localState8 = new State("READ_CHUNK_DELIMITER", 7);
      READ_CHUNK_DELIMITER = localState8;
      State localState9 = new State("READ_CHUNK_FOOTER", 8);
      READ_CHUNK_FOOTER = localState9;
      State localState10 = new State("BAD_MESSAGE", 9);
      BAD_MESSAGE = localState10;
      State localState11 = new State("UPGRADED", 10);
      UPGRADED = localState11;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7, localState8, localState9, localState10, localState11 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpObjectDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */