package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;

public class StompSubframeDecoder
  extends ReplayingDecoder<State>
{
  private static final int DEFAULT_CHUNK_SIZE = 8132;
  private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
  private int alreadyReadChunkSize;
  private final Utf8LineParser commandParser;
  private long contentLength = -1L;
  private final HeaderParser headerParser;
  private LastStompContentSubframe lastContent;
  private final int maxChunkSize;
  
  public StompSubframeDecoder()
  {
    this(1024, 8132);
  }
  
  public StompSubframeDecoder(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, false);
  }
  
  public StompSubframeDecoder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(State.SKIP_CONTROL_CHARACTERS);
    ObjectUtil.checkPositive(paramInt1, "maxLineLength");
    ObjectUtil.checkPositive(paramInt2, "maxChunkSize");
    this.maxChunkSize = paramInt2;
    this.commandParser = new Utf8LineParser(new AppendableCharSequence(16), paramInt1);
    this.headerParser = new HeaderParser(new AppendableCharSequence(128), paramInt1, paramBoolean);
  }
  
  public StompSubframeDecoder(boolean paramBoolean)
  {
    this(1024, 8132, paramBoolean);
  }
  
  private static long getContentLength(StompHeaders paramStompHeaders)
  {
    AsciiString localAsciiString = StompHeaders.CONTENT_LENGTH;
    long l = paramStompHeaders.getLong(localAsciiString, 0L);
    if (l >= 0L) {
      return l;
    }
    paramStompHeaders = new StringBuilder();
    paramStompHeaders.append(localAsciiString);
    paramStompHeaders.append(" must be non-negative");
    throw new DecoderException(paramStompHeaders.toString());
  }
  
  private StompCommand readCommand(ByteBuf paramByteBuf)
  {
    paramByteBuf = this.commandParser.parse(paramByteBuf);
    if (paramByteBuf != null)
    {
      paramByteBuf = paramByteBuf.toString();
      try
      {
        StompCommand localStompCommand = StompCommand.valueOf(paramByteBuf);
        return localStompCommand;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot to parse command ");
        localStringBuilder.append(paramByteBuf);
        throw new DecoderException(localStringBuilder.toString());
      }
    }
    throw new DecoderException("Failed to read command from channel");
  }
  
  private State readHeaders(ByteBuf paramByteBuf, StompHeaders paramStompHeaders)
  {
    while (this.headerParser.parseHeader(paramStompHeaders, paramByteBuf)) {}
    if (paramStompHeaders.contains(StompHeaders.CONTENT_LENGTH))
    {
      long l = getContentLength(paramStompHeaders);
      this.contentLength = l;
      if (l == 0L) {
        return State.FINALIZE_FRAME_READ;
      }
    }
    return State.READ_CONTENT;
  }
  
  private void resetDecoder()
  {
    checkpoint(State.SKIP_CONTROL_CHARACTERS);
    this.contentLength = -1L;
    this.alreadyReadChunkSize = 0;
    this.lastContent = null;
  }
  
  private static void skipControlCharacters(ByteBuf paramByteBuf)
  {
    int i;
    do
    {
      i = paramByteBuf.readByte();
    } while ((i == 13) || (i == 10));
    paramByteBuf.readerIndex(paramByteBuf.readerIndex() - 1);
  }
  
  private static void skipNullCharacter(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readByte();
    if (i == 0) {
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("unexpected byte in buffer ");
    paramByteBuf.append(i);
    paramByteBuf.append(" while expecting NULL byte");
    throw new IllegalStateException(paramByteBuf.toString());
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int[] arrayOfInt = 1.$SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State;
    int i = arrayOfInt[((State)state()).ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          break label122;
        }
        paramByteBuf.skipBytes(actualReadableBytes());
      }
    }
    else
    {
      skipControlCharacters(paramByteBuf);
      checkpoint(State.READ_HEADERS);
    }
    Object localObject1 = StompCommand.UNKNOWN;
    Object localObject2 = null;
    Object localObject3;
    try
    {
      localObject3 = readCommand(paramByteBuf);
      localObject1 = localObject3;
      DefaultStompHeadersSubframe localDefaultStompHeadersSubframe = new io/netty/handler/codec/stomp/DefaultStompHeadersSubframe;
      localObject1 = localObject3;
      localDefaultStompHeadersSubframe.<init>((StompCommand)localObject3);
      try
      {
        checkpoint(readHeaders(paramByteBuf, localDefaultStompHeadersSubframe.headers()));
        paramList.add(localDefaultStompHeadersSubframe);
        try
        {
          label122:
          i = arrayOfInt[((State)state()).ordinal()];
          if (i != 4)
          {
            if (i != 5) {
              break label514;
            }
          }
          else
          {
            int j = paramByteBuf.readableBytes();
            if (j == 0) {
              return;
            }
            int k = this.maxChunkSize;
            i = j;
            if (j > k) {
              i = k;
            }
            long l = this.contentLength;
            if (l >= 0L)
            {
              k = (int)(l - this.alreadyReadChunkSize);
              j = i;
              if (i > k) {
                j = k;
              }
              paramChannelHandlerContext = ByteBufUtil.readBytes(paramChannelHandlerContext.alloc(), paramByteBuf, j);
              i = this.alreadyReadChunkSize + j;
              this.alreadyReadChunkSize = i;
              if (i >= this.contentLength)
              {
                localObject1 = new io/netty/handler/codec/stomp/DefaultLastStompContentSubframe;
                ((DefaultLastStompContentSubframe)localObject1).<init>(paramChannelHandlerContext);
                this.lastContent = ((LastStompContentSubframe)localObject1);
                checkpoint(State.FINALIZE_FRAME_READ);
              }
              else
              {
                paramByteBuf = new io/netty/handler/codec/stomp/DefaultStompContentSubframe;
                paramByteBuf.<init>(paramChannelHandlerContext);
                paramList.add(paramByteBuf);
              }
            }
            else
            {
              j = ByteBufUtil.indexOf(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.writerIndex(), (byte)0);
              if (j == paramByteBuf.readerIndex())
              {
                checkpoint(State.FINALIZE_FRAME_READ);
              }
              else
              {
                if (j > 0) {
                  i = j - paramByteBuf.readerIndex();
                } else {
                  i = paramByteBuf.writerIndex() - paramByteBuf.readerIndex();
                }
                paramChannelHandlerContext = ByteBufUtil.readBytes(paramChannelHandlerContext.alloc(), paramByteBuf, i);
                this.alreadyReadChunkSize += i;
                if (j <= 0) {
                  break label459;
                }
                localObject1 = new io/netty/handler/codec/stomp/DefaultLastStompContentSubframe;
                ((DefaultLastStompContentSubframe)localObject1).<init>(paramChannelHandlerContext);
                this.lastContent = ((LastStompContentSubframe)localObject1);
                checkpoint(State.FINALIZE_FRAME_READ);
              }
            }
          }
          skipNullCharacter(paramByteBuf);
          if (this.lastContent == null) {
            this.lastContent = LastStompContentSubframe.EMPTY_LAST_CONTENT;
          }
          paramList.add(this.lastContent);
          resetDecoder();
          break label514;
          label459:
          paramByteBuf = new io/netty/handler/codec/stomp/DefaultStompContentSubframe;
          paramByteBuf.<init>(paramChannelHandlerContext);
          paramList.add(paramByteBuf);
          return;
        }
        catch (Exception paramChannelHandlerContext)
        {
          paramByteBuf = new DefaultLastStompContentSubframe(Unpooled.EMPTY_BUFFER);
          paramByteBuf.setDecoderResult(DecoderResult.failure(paramChannelHandlerContext));
          paramList.add(paramByteBuf);
          checkpoint(State.BAD_FRAME);
        }
        label514:
        return;
      }
      catch (Exception paramByteBuf)
      {
        paramChannelHandlerContext = localDefaultStompHeadersSubframe;
        localObject1 = localObject3;
      }
      localObject3 = paramChannelHandlerContext;
    }
    catch (Exception paramByteBuf)
    {
      paramChannelHandlerContext = (ChannelHandlerContext)localObject2;
    }
    if (paramChannelHandlerContext == null) {
      localObject3 = new DefaultStompHeadersSubframe((StompCommand)localObject1);
    }
    ((DecoderResultProvider)localObject3).setDecoderResult(DecoderResult.failure(paramByteBuf));
    paramList.add(localObject3);
    checkpoint(State.BAD_FRAME);
  }
  
  private static final class HeaderParser
    extends StompSubframeDecoder.Utf8LineParser
  {
    private String name;
    private boolean valid;
    private final boolean validateHeaders;
    
    HeaderParser(AppendableCharSequence paramAppendableCharSequence, int paramInt, boolean paramBoolean)
    {
      super(paramInt);
      this.validateHeaders = paramBoolean;
    }
    
    boolean parseHeader(StompHeaders paramStompHeaders, ByteBuf paramByteBuf)
    {
      paramByteBuf = super.parse(paramByteBuf);
      if ((paramByteBuf != null) && ((this.name != null) || (paramByteBuf.length() != 0)))
      {
        if (this.valid)
        {
          paramStompHeaders.add(this.name, paramByteBuf.toString());
        }
        else if (this.validateHeaders)
        {
          if (StringUtil.isNullOrEmpty(this.name))
          {
            paramStompHeaders = new StringBuilder();
            paramStompHeaders.append("received an invalid header line '");
            paramStompHeaders.append(paramByteBuf.toString());
            paramStompHeaders.append('\'');
            throw new IllegalArgumentException(paramStompHeaders.toString());
          }
          paramStompHeaders = new StringBuilder();
          paramStompHeaders.append(this.name);
          paramStompHeaders.append(':');
          paramStompHeaders.append(paramByteBuf.toString());
          paramByteBuf = paramStompHeaders.toString();
          paramStompHeaders = new StringBuilder();
          paramStompHeaders.append("a header value or name contains a prohibited character ':', ");
          paramStompHeaders.append(paramByteBuf);
          throw new IllegalArgumentException(paramStompHeaders.toString());
        }
        return true;
      }
      return false;
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      if (paramByte == 58) {
        if (this.name == null)
        {
          AppendableCharSequence localAppendableCharSequence = charSequence();
          if (localAppendableCharSequence.length() != 0)
          {
            this.name = localAppendableCharSequence.substring(0, localAppendableCharSequence.length());
            localAppendableCharSequence.reset();
            this.valid = true;
            return true;
          }
          this.name = "";
        }
        else
        {
          this.valid = false;
        }
      }
      return super.process(paramByte);
    }
    
    protected void reset()
    {
      this.name = null;
      this.valid = false;
      super.reset();
    }
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("SKIP_CONTROL_CHARACTERS", 0);
      SKIP_CONTROL_CHARACTERS = localState1;
      State localState2 = new State("READ_HEADERS", 1);
      READ_HEADERS = localState2;
      State localState3 = new State("READ_CONTENT", 2);
      READ_CONTENT = localState3;
      State localState4 = new State("FINALIZE_FRAME_READ", 3);
      FINALIZE_FRAME_READ = localState4;
      State localState5 = new State("BAD_FRAME", 4);
      BAD_FRAME = localState5;
      State localState6 = new State("INVALID_CHUNK", 5);
      INVALID_CHUNK = localState6;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6 };
    }
  }
  
  private static class Utf8LineParser
    implements ByteProcessor
  {
    private final AppendableCharSequence charSeq;
    private char interim;
    private int lineLength;
    private final int maxLineLength;
    private boolean nextRead;
    
    Utf8LineParser(AppendableCharSequence paramAppendableCharSequence, int paramInt)
    {
      this.charSeq = ((AppendableCharSequence)ObjectUtil.checkNotNull(paramAppendableCharSequence, "charSeq"));
      this.maxLineLength = paramInt;
    }
    
    AppendableCharSequence charSequence()
    {
      return this.charSeq;
    }
    
    AppendableCharSequence parse(ByteBuf paramByteBuf)
    {
      reset();
      int i = paramByteBuf.forEachByte(this);
      if (i == -1) {
        return null;
      }
      paramByteBuf.readerIndex(i + 1);
      return this.charSeq;
    }
    
    public boolean process(byte paramByte)
      throws Exception
    {
      if (paramByte == 13)
      {
        this.lineLength += 1;
        return true;
      }
      if (paramByte == 10) {
        return false;
      }
      int i = this.lineLength + 1;
      this.lineLength = i;
      if (i <= this.maxLineLength)
      {
        if (this.nextRead)
        {
          this.interim = ((char)(char)((paramByte & 0x3F) << 6 | this.interim));
          this.nextRead = false;
        }
        else
        {
          i = this.interim;
          if (i != 0)
          {
            this.charSeq.append((char)(paramByte & 0x3F | i));
            this.interim = ((char)0);
          }
          else if (paramByte >= 0)
          {
            this.charSeq.append((char)paramByte);
          }
          else if ((paramByte & 0xE0) == 192)
          {
            this.interim = ((char)(char)((paramByte & 0x1F) << 6));
          }
          else
          {
            this.interim = ((char)(char)((paramByte & 0xF) << 12));
            this.nextRead = true;
          }
        }
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("An STOMP line is larger than ");
      localStringBuilder.append(this.maxLineLength);
      localStringBuilder.append(" bytes.");
      throw new TooLongFrameException(localStringBuilder.toString());
    }
    
    protected void reset()
    {
      this.charSeq.reset();
      this.lineLength = 0;
      this.interim = ((char)0);
      this.nextRead = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\StompSubframeDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */