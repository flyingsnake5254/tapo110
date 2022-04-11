package com.jcraft.jsch;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;

public class ChannelSftp
  extends ChannelSession
{
  public static final int APPEND = 2;
  private static final int LOCAL_MAXIMUM_PACKET_SIZE = 32768;
  private static final int LOCAL_WINDOW_SIZE_MAX = 2097152;
  private static final int MAX_MSG_LENGTH = 262144;
  public static final int OVERWRITE = 0;
  public static final int RESUME = 1;
  private static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
  private static final int SSH_FILEXFER_ATTR_EXTENDED = Integer.MIN_VALUE;
  private static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
  private static final int SSH_FILEXFER_ATTR_SIZE = 1;
  private static final int SSH_FILEXFER_ATTR_UIDGID = 2;
  private static final int SSH_FXF_APPEND = 4;
  private static final int SSH_FXF_CREAT = 8;
  private static final int SSH_FXF_EXCL = 32;
  private static final int SSH_FXF_READ = 1;
  private static final int SSH_FXF_TRUNC = 16;
  private static final int SSH_FXF_WRITE = 2;
  private static final byte SSH_FXP_ATTRS = 105;
  private static final byte SSH_FXP_CLOSE = 4;
  private static final byte SSH_FXP_DATA = 103;
  private static final byte SSH_FXP_EXTENDED = -56;
  private static final byte SSH_FXP_EXTENDED_REPLY = -55;
  private static final byte SSH_FXP_FSETSTAT = 10;
  private static final byte SSH_FXP_FSTAT = 8;
  private static final byte SSH_FXP_HANDLE = 102;
  private static final byte SSH_FXP_INIT = 1;
  private static final byte SSH_FXP_LSTAT = 7;
  private static final byte SSH_FXP_MKDIR = 14;
  private static final byte SSH_FXP_NAME = 104;
  private static final byte SSH_FXP_OPEN = 3;
  private static final byte SSH_FXP_OPENDIR = 11;
  private static final byte SSH_FXP_READ = 5;
  private static final byte SSH_FXP_READDIR = 12;
  private static final byte SSH_FXP_READLINK = 19;
  private static final byte SSH_FXP_REALPATH = 16;
  private static final byte SSH_FXP_REMOVE = 13;
  private static final byte SSH_FXP_RENAME = 18;
  private static final byte SSH_FXP_RMDIR = 15;
  private static final byte SSH_FXP_SETSTAT = 9;
  private static final byte SSH_FXP_STAT = 17;
  private static final byte SSH_FXP_STATUS = 101;
  private static final byte SSH_FXP_SYMLINK = 20;
  private static final byte SSH_FXP_VERSION = 2;
  private static final byte SSH_FXP_WRITE = 6;
  public static final int SSH_FX_BAD_MESSAGE = 5;
  public static final int SSH_FX_CONNECTION_LOST = 7;
  public static final int SSH_FX_EOF = 1;
  public static final int SSH_FX_FAILURE = 4;
  public static final int SSH_FX_NO_CONNECTION = 6;
  public static final int SSH_FX_NO_SUCH_FILE = 2;
  public static final int SSH_FX_OK = 0;
  public static final int SSH_FX_OP_UNSUPPORTED = 8;
  public static final int SSH_FX_PERMISSION_DENIED = 3;
  private static final String UTF8 = "UTF-8";
  private static final String file_separator = File.separator;
  private static final char file_separatorc;
  private static boolean fs_is_bs;
  private int[] ackid = new int[1];
  private Buffer buf;
  private int client_version = 3;
  private String cwd;
  private boolean extension_hardlink = false;
  private boolean extension_posix_rename = false;
  private boolean extension_statvfs = false;
  private Hashtable extensions = null;
  private String fEncoding = "UTF-8";
  private boolean fEncoding_is_utf8 = true;
  private String home;
  private boolean interactive = false;
  private InputStream io_in = null;
  private String lcwd;
  private Buffer obuf;
  private Packet opacket;
  private Packet packet;
  private RequestQueue rq = new RequestQueue(16);
  private int seq = 1;
  private int server_version = 3;
  private String version = String.valueOf(3);
  
  static
  {
    int i = File.separatorChar;
    file_separatorc = (char)i;
    boolean bool;
    if ((byte)i == 92) {
      bool = true;
    } else {
      bool = false;
    }
    fs_is_bs = bool;
  }
  
  public ChannelSftp()
  {
    setLocalWindowSizeMax(2097152);
    setLocalWindowSize(2097152);
    setLocalPacketSize(32768);
  }
  
  /* Error */
  private void _get(String paramString, OutputStream paramOutputStream, SftpProgressMonitor paramSftpProgressMonitor, int paramInt, long paramLong)
    throws SftpException
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 202	com/jcraft/jsch/ChannelSftp:fEncoding	Ljava/lang/String;
    //   5: invokestatic 233	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 237	com/jcraft/jsch/ChannelSftp:sendOPENR	([B)V
    //   14: new 12	com/jcraft/jsch/ChannelSftp$Header
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: invokespecial 240	com/jcraft/jsch/ChannelSftp$Header:<init>	(Lcom/jcraft/jsch/ChannelSftp;)V
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   28: aload_1
    //   29: invokespecial 246	com/jcraft/jsch/ChannelSftp:header	(Lcom/jcraft/jsch/Buffer;Lcom/jcraft/jsch/ChannelSftp$Header;)Lcom/jcraft/jsch/ChannelSftp$Header;
    //   32: astore_1
    //   33: aload_1
    //   34: getfield 249	com/jcraft/jsch/ChannelSftp$Header:length	I
    //   37: istore 7
    //   39: aload_1
    //   40: getfield 252	com/jcraft/jsch/ChannelSftp$Header:type	I
    //   43: istore 8
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   50: iload 7
    //   52: invokespecial 256	com/jcraft/jsch/ChannelSftp:fill	(Lcom/jcraft/jsch/Buffer;I)V
    //   55: iload 8
    //   57: bipush 101
    //   59: if_icmpeq +27 -> 86
    //   62: iload 8
    //   64: bipush 102
    //   66: if_icmpne +6 -> 72
    //   69: goto +17 -> 86
    //   72: new 225	com/jcraft/jsch/SftpException
    //   75: astore_1
    //   76: aload_1
    //   77: iconst_4
    //   78: ldc_w 258
    //   81: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   84: aload_1
    //   85: athrow
    //   86: iload 8
    //   88: bipush 101
    //   90: if_icmpne +22 -> 112
    //   93: aload_0
    //   94: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   97: invokevirtual 267	com/jcraft/jsch/Buffer:getInt	()I
    //   100: istore 8
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   107: iload 8
    //   109: invokespecial 270	com/jcraft/jsch/ChannelSftp:throwStatusError	(Lcom/jcraft/jsch/Buffer;I)V
    //   112: aload_0
    //   113: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   116: invokevirtual 274	com/jcraft/jsch/Buffer:getString	()[B
    //   119: astore 9
    //   121: lconst_0
    //   122: lstore 10
    //   124: iload 4
    //   126: iconst_1
    //   127: if_icmpne +9 -> 136
    //   130: lload 5
    //   132: lconst_0
    //   133: ladd
    //   134: lstore 10
    //   136: aload_0
    //   137: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   140: invokevirtual 277	com/jcraft/jsch/ChannelSftp$RequestQueue:init	()V
    //   143: aload_0
    //   144: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   147: getfield 281	com/jcraft/jsch/Buffer:buffer	[B
    //   150: arraylength
    //   151: istore 4
    //   153: aload_0
    //   154: getfield 182	com/jcraft/jsch/ChannelSftp:server_version	I
    //   157: ifne +18 -> 175
    //   160: lload 10
    //   162: lstore 5
    //   164: iconst_1
    //   165: istore 4
    //   167: sipush 1024
    //   170: istore 8
    //   172: goto +17 -> 189
    //   175: lload 10
    //   177: lstore 5
    //   179: iload 4
    //   181: bipush 13
    //   183: isub
    //   184: istore 8
    //   186: iconst_1
    //   187: istore 4
    //   189: aload_0
    //   190: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   193: invokevirtual 284	com/jcraft/jsch/ChannelSftp$RequestQueue:count	()I
    //   196: iload 4
    //   198: if_icmpge +28 -> 226
    //   201: aload_0
    //   202: aload 9
    //   204: lload 5
    //   206: iload 8
    //   208: aload_0
    //   209: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   212: invokespecial 288	com/jcraft/jsch/ChannelSftp:sendREAD	([BJILcom/jcraft/jsch/ChannelSftp$RequestQueue;)V
    //   215: lload 5
    //   217: iload 8
    //   219: i2l
    //   220: ladd
    //   221: lstore 5
    //   223: goto -34 -> 189
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   231: aload_1
    //   232: invokespecial 246	com/jcraft/jsch/ChannelSftp:header	(Lcom/jcraft/jsch/Buffer;Lcom/jcraft/jsch/ChannelSftp$Header;)Lcom/jcraft/jsch/ChannelSftp$Header;
    //   235: astore_1
    //   236: aload_1
    //   237: getfield 249	com/jcraft/jsch/ChannelSftp$Header:length	I
    //   240: istore 7
    //   242: aload_1
    //   243: getfield 252	com/jcraft/jsch/ChannelSftp$Header:type	I
    //   246: istore 12
    //   248: aload_0
    //   249: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   252: aload_1
    //   253: getfield 291	com/jcraft/jsch/ChannelSftp$Header:rid	I
    //   256: invokevirtual 295	com/jcraft/jsch/ChannelSftp$RequestQueue:get	(I)Lcom/jcraft/jsch/ChannelSftp$RequestQueue$Request;
    //   259: astore 13
    //   261: iload 12
    //   263: bipush 101
    //   265: if_icmpne +41 -> 306
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   273: iload 7
    //   275: invokespecial 256	com/jcraft/jsch/ChannelSftp:fill	(Lcom/jcraft/jsch/Buffer;I)V
    //   278: aload_0
    //   279: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   282: invokevirtual 267	com/jcraft/jsch/Buffer:getInt	()I
    //   285: istore 14
    //   287: iload 14
    //   289: iconst_1
    //   290: if_icmpne +6 -> 296
    //   293: goto +20 -> 313
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   301: iload 14
    //   303: invokespecial 270	com/jcraft/jsch/ChannelSftp:throwStatusError	(Lcom/jcraft/jsch/Buffer;I)V
    //   306: iload 12
    //   308: bipush 103
    //   310: if_icmpeq +6 -> 316
    //   313: goto +162 -> 475
    //   316: aload_0
    //   317: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   320: invokevirtual 298	com/jcraft/jsch/Buffer:rewind	()V
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   328: getfield 281	com/jcraft/jsch/Buffer:buffer	[B
    //   331: iconst_0
    //   332: iconst_4
    //   333: invokespecial 301	com/jcraft/jsch/ChannelSftp:fill	([BII)I
    //   336: pop
    //   337: aload_0
    //   338: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   341: invokevirtual 267	com/jcraft/jsch/Buffer:getInt	()I
    //   344: istore 12
    //   346: iload 7
    //   348: iconst_4
    //   349: isub
    //   350: iload 12
    //   352: isub
    //   353: istore 15
    //   355: iload 12
    //   357: istore 7
    //   359: iload 7
    //   361: ifle +152 -> 513
    //   364: aload_0
    //   365: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   368: getfield 281	com/jcraft/jsch/Buffer:buffer	[B
    //   371: astore 16
    //   373: iload 7
    //   375: aload 16
    //   377: arraylength
    //   378: if_icmple +11 -> 389
    //   381: aload 16
    //   383: arraylength
    //   384: istore 14
    //   386: goto +7 -> 393
    //   389: iload 7
    //   391: istore 14
    //   393: aload_0
    //   394: getfield 194	com/jcraft/jsch/ChannelSftp:io_in	Ljava/io/InputStream;
    //   397: aload 16
    //   399: iconst_0
    //   400: iload 14
    //   402: invokevirtual 306	java/io/InputStream:read	([BII)I
    //   405: istore 14
    //   407: iload 14
    //   409: ifge +6 -> 415
    //   412: goto -99 -> 313
    //   415: aload_2
    //   416: aload_0
    //   417: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   420: getfield 281	com/jcraft/jsch/Buffer:buffer	[B
    //   423: iconst_0
    //   424: iload 14
    //   426: invokevirtual 312	java/io/OutputStream:write	([BII)V
    //   429: iload 14
    //   431: i2l
    //   432: lstore 10
    //   434: iload 7
    //   436: iload 14
    //   438: isub
    //   439: istore 7
    //   441: aload_3
    //   442: ifnull +68 -> 510
    //   445: aload_3
    //   446: lload 10
    //   448: invokeinterface 317 3 0
    //   453: ifne +57 -> 510
    //   456: aload_0
    //   457: iload 7
    //   459: i2l
    //   460: invokespecial 321	com/jcraft/jsch/ChannelSftp:skip	(J)V
    //   463: iload 15
    //   465: ifle +10 -> 475
    //   468: aload_0
    //   469: iload 15
    //   471: i2l
    //   472: invokespecial 321	com/jcraft/jsch/ChannelSftp:skip	(J)V
    //   475: aload_2
    //   476: invokevirtual 324	java/io/OutputStream:flush	()V
    //   479: aload_3
    //   480: ifnull +9 -> 489
    //   483: aload_3
    //   484: invokeinterface 327 1 0
    //   489: aload_0
    //   490: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   493: aload_1
    //   494: aload_0
    //   495: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   498: invokevirtual 331	com/jcraft/jsch/ChannelSftp$RequestQueue:cancel	(Lcom/jcraft/jsch/ChannelSftp$Header;Lcom/jcraft/jsch/Buffer;)V
    //   501: aload_0
    //   502: aload 9
    //   504: aload_1
    //   505: invokespecial 335	com/jcraft/jsch/ChannelSftp:_sendCLOSE	([BLcom/jcraft/jsch/ChannelSftp$Header;)Z
    //   508: pop
    //   509: return
    //   510: goto -151 -> 359
    //   513: iload 15
    //   515: ifle +10 -> 525
    //   518: aload_0
    //   519: iload 15
    //   521: i2l
    //   522: invokespecial 321	com/jcraft/jsch/ChannelSftp:skip	(J)V
    //   525: iload 12
    //   527: i2l
    //   528: lstore 10
    //   530: lload 10
    //   532: aload 13
    //   534: getfield 338	com/jcraft/jsch/ChannelSftp$RequestQueue$Request:length	J
    //   537: lcmp
    //   538: ifge +58 -> 596
    //   541: aload_0
    //   542: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   545: aload_1
    //   546: aload_0
    //   547: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   550: invokevirtual 331	com/jcraft/jsch/ChannelSftp$RequestQueue:cancel	(Lcom/jcraft/jsch/ChannelSftp$Header;Lcom/jcraft/jsch/Buffer;)V
    //   553: aload_0
    //   554: aload 9
    //   556: aload 13
    //   558: getfield 341	com/jcraft/jsch/ChannelSftp$RequestQueue$Request:offset	J
    //   561: lload 10
    //   563: ladd
    //   564: aload 13
    //   566: getfield 338	com/jcraft/jsch/ChannelSftp$RequestQueue$Request:length	J
    //   569: lload 10
    //   571: lsub
    //   572: l2i
    //   573: aload_0
    //   574: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   577: invokespecial 288	com/jcraft/jsch/ChannelSftp:sendREAD	([BJILcom/jcraft/jsch/ChannelSftp$RequestQueue;)V
    //   580: aload 13
    //   582: getfield 341	com/jcraft/jsch/ChannelSftp$RequestQueue$Request:offset	J
    //   585: aload 13
    //   587: getfield 338	com/jcraft/jsch/ChannelSftp$RequestQueue$Request:length	J
    //   590: ladd
    //   591: lstore 5
    //   593: goto +3 -> 596
    //   596: iload 4
    //   598: aload_0
    //   599: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   602: invokevirtual 344	com/jcraft/jsch/ChannelSftp$RequestQueue:size	()I
    //   605: if_icmpge +9 -> 614
    //   608: iinc 4 1
    //   611: goto +3 -> 614
    //   614: goto +33 -> 647
    //   617: astore 16
    //   619: aload 16
    //   621: getfield 345	com/jcraft/jsch/ChannelSftp$RequestQueue$OutOfOrderException:offset	J
    //   624: lstore 5
    //   626: aload_0
    //   627: aload_1
    //   628: getfield 249	com/jcraft/jsch/ChannelSftp$Header:length	I
    //   631: i2l
    //   632: invokespecial 321	com/jcraft/jsch/ChannelSftp:skip	(J)V
    //   635: aload_0
    //   636: getfield 209	com/jcraft/jsch/ChannelSftp:rq	Lcom/jcraft/jsch/ChannelSftp$RequestQueue;
    //   639: aload_1
    //   640: aload_0
    //   641: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   644: invokevirtual 331	com/jcraft/jsch/ChannelSftp$RequestQueue:cancel	(Lcom/jcraft/jsch/ChannelSftp$Header;Lcom/jcraft/jsch/Buffer;)V
    //   647: goto -458 -> 189
    //   650: astore_1
    //   651: aload_1
    //   652: instanceof 225
    //   655: ifne +16 -> 671
    //   658: new 225	com/jcraft/jsch/SftpException
    //   661: dup
    //   662: iconst_4
    //   663: ldc_w 258
    //   666: aload_1
    //   667: invokespecial 348	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   670: athrow
    //   671: aload_1
    //   672: checkcast 225	com/jcraft/jsch/SftpException
    //   675: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	this	ChannelSftp
    //   0	676	1	paramString	String
    //   0	676	2	paramOutputStream	OutputStream
    //   0	676	3	paramSftpProgressMonitor	SftpProgressMonitor
    //   0	676	4	paramInt	int
    //   0	676	5	paramLong	long
    //   37	421	7	i	int
    //   43	175	8	j	int
    //   119	436	9	arrayOfByte1	byte[]
    //   122	448	10	l	long
    //   246	280	12	k	int
    //   259	327	13	localRequest	ChannelSftp.RequestQueue.Request
    //   285	154	14	m	int
    //   353	167	15	n	int
    //   371	27	16	arrayOfByte2	byte[]
    //   617	3	16	localOutOfOrderException	ChannelSftp.RequestQueue.OutOfOrderException
    // Exception table:
    //   from	to	target	type
    //   248	261	617	com/jcraft/jsch/ChannelSftp$RequestQueue$OutOfOrderException
    //   9	55	650	java/lang/Exception
    //   72	86	650	java/lang/Exception
    //   93	112	650	java/lang/Exception
    //   112	121	650	java/lang/Exception
    //   136	160	650	java/lang/Exception
    //   189	215	650	java/lang/Exception
    //   226	248	650	java/lang/Exception
    //   248	261	650	java/lang/Exception
    //   268	287	650	java/lang/Exception
    //   296	306	650	java/lang/Exception
    //   316	346	650	java/lang/Exception
    //   364	386	650	java/lang/Exception
    //   393	407	650	java/lang/Exception
    //   415	429	650	java/lang/Exception
    //   445	463	650	java/lang/Exception
    //   468	475	650	java/lang/Exception
    //   475	479	650	java/lang/Exception
    //   483	489	650	java/lang/Exception
    //   489	509	650	java/lang/Exception
    //   518	525	650	java/lang/Exception
    //   530	593	650	java/lang/Exception
    //   596	608	650	java/lang/Exception
    //   619	647	650	java/lang/Exception
  }
  
  private SftpATTRS _lstat(String paramString)
    throws SftpException
  {
    try
    {
      sendLSTAT(Util.str2byte(paramString, this.fEncoding));
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      paramString = header(this.buf, paramString);
      int i = paramString.length;
      int j = paramString.type;
      fill(this.buf, i);
      if (j != 105)
      {
        if (j == 101)
        {
          j = this.buf.getInt();
          throwStatusError(this.buf, j);
        }
        paramString = new com/jcraft/jsch/SftpException;
        paramString.<init>(4, "");
        throw paramString;
      }
      paramString = SftpATTRS.getATTR(this.buf);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  private byte[] _realpath(String paramString)
    throws SftpException, IOException, Exception
  {
    sendREALPATH(Util.str2byte(paramString, this.fEncoding));
    paramString = new Header();
    paramString = header(this.buf, paramString);
    int i = paramString.length;
    int j = paramString.type;
    fill(this.buf, i);
    if ((j != 101) && (j != 104)) {
      throw new SftpException(4, "");
    }
    if (j == 101)
    {
      i = this.buf.getInt();
      throwStatusError(this.buf, i);
    }
    i = this.buf.getInt();
    paramString = null;
    while (i > 0)
    {
      paramString = this.buf.getString();
      if (this.server_version <= 3) {
        this.buf.getString();
      }
      SftpATTRS.getATTR(this.buf);
      i--;
    }
    return paramString;
  }
  
  private boolean _sendCLOSE(byte[] paramArrayOfByte, Header paramHeader)
    throws Exception
  {
    sendCLOSE(paramArrayOfByte);
    return checkStatus(null, paramHeader);
  }
  
  private void _setStat(String paramString, SftpATTRS paramSftpATTRS)
    throws SftpException
  {
    try
    {
      sendSETSTAT(Util.str2byte(paramString, this.fEncoding), paramSftpATTRS);
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      paramString = header(this.buf, paramString);
      int i = paramString.length;
      int j = paramString.type;
      fill(this.buf, i);
      if (j == 101)
      {
        i = this.buf.getInt();
        if (i != 0) {
          throwStatusError(this.buf, i);
        }
        return;
      }
      paramString = new com/jcraft/jsch/SftpException;
      paramString.<init>(4, "");
      throw paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  private SftpATTRS _stat(String paramString)
    throws SftpException
  {
    return _stat(Util.str2byte(paramString, this.fEncoding));
  }
  
  private SftpATTRS _stat(byte[] paramArrayOfByte)
    throws SftpException
  {
    try
    {
      sendSTAT(paramArrayOfByte);
      paramArrayOfByte = new com/jcraft/jsch/ChannelSftp$Header;
      paramArrayOfByte.<init>(this);
      paramArrayOfByte = header(this.buf, paramArrayOfByte);
      int i = paramArrayOfByte.length;
      int j = paramArrayOfByte.type;
      fill(this.buf, i);
      if (j != 105)
      {
        if (j == 101)
        {
          i = this.buf.getInt();
          throwStatusError(this.buf, i);
        }
        paramArrayOfByte = new com/jcraft/jsch/SftpException;
        paramArrayOfByte.<init>(4, "");
        throw paramArrayOfByte;
      }
      paramArrayOfByte = SftpATTRS.getATTR(this.buf);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!(paramArrayOfByte instanceof SftpException)) {
        throw new SftpException(4, "", paramArrayOfByte);
      }
      throw ((SftpException)paramArrayOfByte);
    }
  }
  
  private SftpStatVFS _statVFS(String paramString)
    throws SftpException
  {
    return _statVFS(Util.str2byte(paramString, this.fEncoding));
  }
  
  private SftpStatVFS _statVFS(byte[] paramArrayOfByte)
    throws SftpException
  {
    if (this.extension_statvfs) {
      try
      {
        sendSTATVFS(paramArrayOfByte);
        paramArrayOfByte = new com/jcraft/jsch/ChannelSftp$Header;
        paramArrayOfByte.<init>(this);
        paramArrayOfByte = header(this.buf, paramArrayOfByte);
        int i = paramArrayOfByte.length;
        int j = paramArrayOfByte.type;
        fill(this.buf, i);
        if (j != 201)
        {
          if (j == 101)
          {
            j = this.buf.getInt();
            throwStatusError(this.buf, j);
          }
          paramArrayOfByte = new com/jcraft/jsch/SftpException;
          paramArrayOfByte.<init>(4, "");
          throw paramArrayOfByte;
        }
        paramArrayOfByte = SftpStatVFS.getStatVFS(this.buf);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!(paramArrayOfByte instanceof SftpException)) {
          throw new SftpException(4, "", paramArrayOfByte);
        }
        throw ((SftpException)paramArrayOfByte);
      }
    }
    throw new SftpException(8, "statvfs@openssh.com is not supported");
  }
  
  private boolean checkStatus(int[] paramArrayOfInt, Header paramHeader)
    throws IOException, SftpException
  {
    paramHeader = header(this.buf, paramHeader);
    int i = paramHeader.length;
    int j = paramHeader.type;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = paramHeader.rid;
    }
    fill(this.buf, i);
    if (j == 101)
    {
      j = this.buf.getInt();
      if (j != 0) {
        throwStatusError(this.buf, j);
      }
      return true;
    }
    throw new SftpException(4, "");
  }
  
  private int fill(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt1;
    while (paramInt2 > 0)
    {
      int j = this.io_in.read(paramArrayOfByte, i, paramInt2);
      if (j > 0)
      {
        i += j;
        paramInt2 -= j;
      }
      else
      {
        throw new IOException("inputstream is closed");
      }
    }
    return i - paramInt1;
  }
  
  private void fill(Buffer paramBuffer, int paramInt)
    throws IOException
  {
    paramBuffer.reset();
    fill(paramBuffer.buffer, 0, paramInt);
    paramBuffer.skip(paramInt);
  }
  
  private String getCwd()
    throws SftpException
  {
    if (this.cwd == null) {
      this.cwd = getHome();
    }
    return this.cwd;
  }
  
  private Vector glob_local(String paramString)
    throws Exception
  {
    Vector localVector = new Vector();
    Object localObject = Util.str2byte(paramString, "UTF-8");
    int i = localObject.length - 1;
    int j = i;
    if (i >= 0)
    {
      if ((localObject[i] != 42) && (localObject[i] != 63)) {}
      for (;;)
      {
        i--;
        break;
        j = i;
        if (fs_is_bs) {
          break label121;
        }
        j = i;
        if (i <= 0) {
          break label121;
        }
        j = i;
        if (localObject[(i - 1)] != 92) {
          break label121;
        }
        i--;
        j = i;
        if (i <= 0) {
          break label121;
        }
        j = i;
        if (localObject[(i - 1)] != 92) {
          break label121;
        }
        i--;
      }
    }
    label121:
    i = j;
    if (j < 0)
    {
      if (!fs_is_bs) {
        paramString = Util.unquote(paramString);
      }
      localVector.addElement(paramString);
      return localVector;
    }
    while ((i >= 0) && (localObject[i] != file_separatorc) && ((!fs_is_bs) || (localObject[i] != 47))) {
      i--;
    }
    if (i < 0)
    {
      if (!fs_is_bs) {
        paramString = Util.unquote(paramString);
      }
      localVector.addElement(paramString);
      return localVector;
    }
    j = 0;
    if (i == 0)
    {
      paramString = new byte[1];
      paramString[0] = ((byte)(byte)file_separatorc);
    }
    else
    {
      paramString = new byte[i];
      System.arraycopy(localObject, 0, paramString, 0, i);
    }
    int k = localObject.length - i - 1;
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(localObject, i + 1, arrayOfByte, 0, k);
    try
    {
      localObject = new java/io/File;
      ((File)localObject).<init>(Util.byte2str(paramString, "UTF-8"));
      localObject = ((File)localObject).list();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(Util.byte2str(paramString));
      localStringBuilder.append(file_separator);
      paramString = localStringBuilder.toString();
      for (i = j; i < localObject.length; i++) {
        if (Util.glob(arrayOfByte, Util.str2byte(localObject[i], "UTF-8")))
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(paramString);
          localStringBuilder.append(localObject[i]);
          localVector.addElement(localStringBuilder.toString());
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return localVector;
  }
  
  private Vector glob_remote(String paramString)
    throws Exception
  {
    Vector localVector = new Vector();
    int i = paramString.lastIndexOf('/');
    if (i < 0)
    {
      localVector.addElement(Util.unquote(paramString));
      return localVector;
    }
    if (i == 0) {
      j = 1;
    } else {
      j = i;
    }
    Object localObject1 = paramString.substring(0, j);
    Object localObject2 = paramString.substring(i + 1);
    localObject1 = Util.unquote((String)localObject1);
    paramString = new byte[1][];
    if (!isPattern((String)localObject2, paramString))
    {
      paramString = (String)localObject1;
      if (!((String)localObject1).equals("/"))
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append("/");
        paramString = paramString.toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(Util.unquote((String)localObject2));
      localVector.addElement(((StringBuilder)localObject1).toString());
      return localVector;
    }
    byte[] arrayOfByte1 = paramString[0];
    sendOPENDIR(Util.str2byte((String)localObject1, this.fEncoding));
    paramString = new Header();
    paramString = header(this.buf, paramString);
    int j = paramString.length;
    i = paramString.type;
    fill(this.buf, j);
    if ((i != 101) && (i != 102)) {
      throw new SftpException(4, "");
    }
    if (i == 101)
    {
      j = this.buf.getInt();
      throwStatusError(this.buf, j);
    }
    byte[] arrayOfByte2 = this.buf.getString();
    localObject2 = null;
    for (;;)
    {
      sendREADDIR(arrayOfByte2);
      Header localHeader = header(this.buf, paramString);
      i = localHeader.length;
      j = localHeader.type;
      if ((j != 101) && (j != 104)) {
        throw new SftpException(4, "");
      }
      if (j == 101)
      {
        fill(this.buf, i);
        if (_sendCLOSE(arrayOfByte2, localHeader)) {
          return localVector;
        }
        return null;
      }
      this.buf.rewind();
      fill(this.buf.buffer, 0, 4);
      j = i - 4;
      i = this.buf.getInt();
      this.buf.reset();
      while (i > 0)
      {
        int k = j;
        Object localObject3;
        if (j > 0)
        {
          this.buf.shift();
          localObject3 = this.buf;
          paramString = ((Buffer)localObject3).buffer;
          k = paramString.length;
          int m = ((Buffer)localObject3).index;
          if (k > m + j) {
            k = j;
          } else {
            k = paramString.length - m;
          }
          k = this.io_in.read(paramString, m, k);
          if (k <= 0) {
            break;
          }
          paramString = this.buf;
          paramString.index += k;
          k = j - k;
        }
        byte[] arrayOfByte3 = this.buf.getString();
        if (this.server_version <= 3) {
          this.buf.getString();
        }
        SftpATTRS.getATTR(this.buf);
        if (!this.fEncoding_is_utf8)
        {
          paramString = Util.byte2str(arrayOfByte3, this.fEncoding);
          localObject3 = Util.str2byte(paramString, "UTF-8");
        }
        else
        {
          localObject3 = arrayOfByte3;
          paramString = null;
        }
        Object localObject4 = localObject2;
        if (Util.glob(arrayOfByte1, (byte[])localObject3))
        {
          localObject3 = paramString;
          if (paramString == null) {
            localObject3 = Util.byte2str(arrayOfByte3, this.fEncoding);
          }
          paramString = (String)localObject2;
          if (localObject2 == null) {
            if (!((String)localObject1).endsWith("/"))
            {
              paramString = new StringBuilder();
              paramString.append((String)localObject1);
              paramString.append("/");
              paramString = paramString.toString();
            }
            else
            {
              paramString = (String)localObject1;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append((String)localObject3);
          localVector.addElement(((StringBuilder)localObject2).toString());
          localObject4 = paramString;
        }
        i--;
        localObject2 = localObject4;
        j = k;
      }
      paramString = localHeader;
    }
  }
  
  private Header header(Buffer paramBuffer, Header paramHeader)
    throws IOException
  {
    paramBuffer.rewind();
    fill(paramBuffer.buffer, 0, 9);
    paramHeader.length = (paramBuffer.getInt() - 5);
    paramHeader.type = (paramBuffer.getByte() & 0xFF);
    paramHeader.rid = paramBuffer.getInt();
    return paramHeader;
  }
  
  private static boolean isLocalAbsolutePath(String paramString)
  {
    return new File(paramString).isAbsolute();
  }
  
  private boolean isPattern(String paramString)
  {
    return isPattern(paramString, null);
  }
  
  private boolean isPattern(String paramString, byte[][] paramArrayOfByte)
  {
    paramString = Util.str2byte(paramString, "UTF-8");
    if (paramArrayOfByte != null) {
      paramArrayOfByte[0] = paramString;
    }
    return isPattern(paramString);
  }
  
  private boolean isPattern(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    while (j < i) {
      if ((paramArrayOfByte[j] != 42) && (paramArrayOfByte[j] != 63))
      {
        int k = j;
        if (paramArrayOfByte[j] == 92)
        {
          int m = j + 1;
          k = j;
          if (m < i) {
            k = m;
          }
        }
        j = k + 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private boolean isRemoteDir(String paramString)
  {
    try
    {
      sendSTAT(Util.str2byte(paramString, this.fEncoding));
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      paramString = header(this.buf, paramString);
      int i = paramString.length;
      int j = paramString.type;
      fill(this.buf, i);
      if (j != 105) {
        return false;
      }
      boolean bool = SftpATTRS.getATTR(this.buf).isDir();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private String isUnique(String paramString)
    throws SftpException, Exception
  {
    Vector localVector = glob_remote(paramString);
    if (localVector.size() == 1) {
      return (String)localVector.elementAt(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is not unique: ");
    localStringBuilder.append(localVector.toString());
    throw new SftpException(4, localStringBuilder.toString());
  }
  
  private String localAbsolutePath(String paramString)
  {
    if (isLocalAbsolutePath(paramString)) {
      return paramString;
    }
    Object localObject1 = this.lcwd;
    Object localObject2 = file_separator;
    if (((String)localObject1).endsWith((String)localObject2))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.lcwd);
      ((StringBuilder)localObject2).append(paramString);
      return ((StringBuilder)localObject2).toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.lcwd);
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(paramString);
    return ((StringBuilder)localObject1).toString();
  }
  
  private void putHEAD(byte paramByte, int paramInt)
    throws Exception
  {
    putHEAD(this.buf, paramByte, paramInt);
  }
  
  private void putHEAD(Buffer paramBuffer, byte paramByte, int paramInt)
    throws Exception
  {
    paramBuffer.putByte((byte)94);
    paramBuffer.putInt(this.recipient);
    paramBuffer.putInt(paramInt + 4);
    paramBuffer.putInt(paramInt);
    paramBuffer.putByte(paramByte);
  }
  
  private void read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, SftpException
  {
    while (paramInt2 > 0)
    {
      int i = this.io_in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i > 0)
      {
        paramInt1 += i;
        paramInt2 -= i;
      }
      else
      {
        throw new SftpException(4, "");
      }
    }
  }
  
  private String remoteAbsolutePath(String paramString)
    throws SftpException
  {
    if (paramString.charAt(0) == '/') {
      return paramString;
    }
    String str = getCwd();
    if (str.endsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void sendCLOSE(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)4, paramArrayOfByte);
  }
  
  private void sendFSTAT(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)8, paramArrayOfByte);
  }
  
  private void sendHARDLINK(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    sendPacketPath((byte)0, paramArrayOfByte1, paramArrayOfByte2, "hardlink@openssh.com");
  }
  
  private void sendINIT()
    throws Exception
  {
    this.packet.reset();
    putHEAD((byte)1, 5);
    this.buf.putInt(3);
    getSession().write(this.packet, this, 9);
  }
  
  private void sendLSTAT(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)7, paramArrayOfByte);
  }
  
  private void sendMKDIR(byte[] paramArrayOfByte, SftpATTRS paramSftpATTRS)
    throws Exception
  {
    this.packet.reset();
    int i = paramArrayOfByte.length;
    if (paramSftpATTRS != null) {
      j = paramSftpATTRS.length();
    } else {
      j = 4;
    }
    putHEAD((byte)14, i + 9 + j);
    Object localObject = this.buf;
    int j = this.seq;
    this.seq = (j + 1);
    ((Buffer)localObject).putInt(j);
    this.buf.putString(paramArrayOfByte);
    if (paramSftpATTRS != null) {
      paramSftpATTRS.dump(this.buf);
    } else {
      this.buf.putInt(0);
    }
    localObject = getSession();
    Packet localPacket = this.packet;
    i = paramArrayOfByte.length;
    if (paramSftpATTRS != null) {
      j = paramSftpATTRS.length();
    } else {
      j = 4;
    }
    ((Session)localObject).write(localPacket, this, i + 9 + j + 4);
  }
  
  private void sendOPEN(byte[] paramArrayOfByte, int paramInt)
    throws Exception
  {
    this.packet.reset();
    putHEAD((byte)3, paramArrayOfByte.length + 17);
    Buffer localBuffer = this.buf;
    int i = this.seq;
    this.seq = (i + 1);
    localBuffer.putInt(i);
    this.buf.putString(paramArrayOfByte);
    this.buf.putInt(paramInt);
    this.buf.putInt(0);
    getSession().write(this.packet, this, paramArrayOfByte.length + 17 + 4);
  }
  
  private void sendOPENA(byte[] paramArrayOfByte)
    throws Exception
  {
    sendOPEN(paramArrayOfByte, 10);
  }
  
  private void sendOPENDIR(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)11, paramArrayOfByte);
  }
  
  private void sendOPENR(byte[] paramArrayOfByte)
    throws Exception
  {
    sendOPEN(paramArrayOfByte, 1);
  }
  
  private void sendOPENW(byte[] paramArrayOfByte)
    throws Exception
  {
    sendOPEN(paramArrayOfByte, 26);
  }
  
  private void sendPacketPath(byte paramByte, byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath(paramByte, paramArrayOfByte, null);
  }
  
  private void sendPacketPath(byte paramByte, byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    this.packet.reset();
    int i = paramArrayOfByte.length + 9;
    int j;
    if (paramString == null)
    {
      putHEAD(paramByte, i);
      paramString = this.buf;
      j = this.seq;
      this.seq = (j + 1);
      paramString.putInt(j);
    }
    else
    {
      i += paramString.length() + 4;
      putHEAD((byte)-56, i);
      Buffer localBuffer = this.buf;
      j = this.seq;
      this.seq = (j + 1);
      localBuffer.putInt(j);
      this.buf.putString(Util.str2byte(paramString));
    }
    this.buf.putString(paramArrayOfByte);
    getSession().write(this.packet, this, i + 4);
  }
  
  private void sendPacketPath(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    sendPacketPath(paramByte, paramArrayOfByte1, paramArrayOfByte2, null);
  }
  
  private void sendPacketPath(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
    throws Exception
  {
    this.packet.reset();
    int i = paramArrayOfByte1.length + 13 + paramArrayOfByte2.length;
    int j;
    if (paramString == null)
    {
      putHEAD(paramByte, i);
      paramString = this.buf;
      j = this.seq;
      this.seq = (j + 1);
      paramString.putInt(j);
    }
    else
    {
      i += paramString.length() + 4;
      putHEAD((byte)-56, i);
      Buffer localBuffer = this.buf;
      j = this.seq;
      this.seq = (j + 1);
      localBuffer.putInt(j);
      this.buf.putString(Util.str2byte(paramString));
    }
    this.buf.putString(paramArrayOfByte1);
    this.buf.putString(paramArrayOfByte2);
    getSession().write(this.packet, this, i + 4);
  }
  
  private void sendREAD(byte[] paramArrayOfByte, long paramLong, int paramInt)
    throws Exception
  {
    sendREAD(paramArrayOfByte, paramLong, paramInt, null);
  }
  
  private void sendREAD(byte[] paramArrayOfByte, long paramLong, int paramInt, RequestQueue paramRequestQueue)
    throws Exception
  {
    this.packet.reset();
    putHEAD((byte)5, paramArrayOfByte.length + 21);
    Buffer localBuffer = this.buf;
    int i = this.seq;
    this.seq = (i + 1);
    localBuffer.putInt(i);
    this.buf.putString(paramArrayOfByte);
    this.buf.putLong(paramLong);
    this.buf.putInt(paramInt);
    getSession().write(this.packet, this, paramArrayOfByte.length + 21 + 4);
    if (paramRequestQueue != null) {
      paramRequestQueue.add(this.seq - 1, paramLong, paramInt);
    }
  }
  
  private void sendREADDIR(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)12, paramArrayOfByte);
  }
  
  private void sendREADLINK(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)19, paramArrayOfByte);
  }
  
  private void sendREALPATH(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)16, paramArrayOfByte);
  }
  
  private void sendREMOVE(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)13, paramArrayOfByte);
  }
  
  private void sendRENAME(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    String str;
    if (this.extension_posix_rename) {
      str = "posix-rename@openssh.com";
    } else {
      str = null;
    }
    sendPacketPath((byte)18, paramArrayOfByte1, paramArrayOfByte2, str);
  }
  
  private void sendRMDIR(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)15, paramArrayOfByte);
  }
  
  private void sendSETSTAT(byte[] paramArrayOfByte, SftpATTRS paramSftpATTRS)
    throws Exception
  {
    this.packet.reset();
    putHEAD((byte)9, paramArrayOfByte.length + 9 + paramSftpATTRS.length());
    Buffer localBuffer = this.buf;
    int i = this.seq;
    this.seq = (i + 1);
    localBuffer.putInt(i);
    this.buf.putString(paramArrayOfByte);
    paramSftpATTRS.dump(this.buf);
    getSession().write(this.packet, this, paramArrayOfByte.length + 9 + paramSftpATTRS.length() + 4);
  }
  
  private void sendSTAT(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)17, paramArrayOfByte);
  }
  
  private void sendSTATVFS(byte[] paramArrayOfByte)
    throws Exception
  {
    sendPacketPath((byte)0, paramArrayOfByte, "statvfs@openssh.com");
  }
  
  private void sendSYMLINK(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    sendPacketPath((byte)20, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private int sendWRITE(byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
    throws Exception
  {
    this.opacket.reset();
    Buffer localBuffer = this.obuf;
    byte[] arrayOfByte = localBuffer.buffer;
    int i = arrayOfByte.length;
    int j = localBuffer.index;
    int k = paramInt2;
    if (i < j + 13 + 21 + paramArrayOfByte1.length + paramInt2 + 128) {
      k = arrayOfByte.length - (j + 13 + 21 + paramArrayOfByte1.length + 128);
    }
    putHEAD(localBuffer, (byte)6, paramArrayOfByte1.length + 21 + k);
    localBuffer = this.obuf;
    paramInt2 = this.seq;
    this.seq = (paramInt2 + 1);
    localBuffer.putInt(paramInt2);
    this.obuf.putString(paramArrayOfByte1);
    this.obuf.putLong(paramLong);
    localBuffer = this.obuf;
    if (localBuffer.buffer != paramArrayOfByte2)
    {
      localBuffer.putString(paramArrayOfByte2, paramInt1, k);
    }
    else
    {
      localBuffer.putInt(k);
      this.obuf.skip(k);
    }
    getSession().write(this.opacket, this, paramArrayOfByte1.length + 21 + k + 4);
    return k;
  }
  
  private void setCwd(String paramString)
  {
    this.cwd = paramString;
  }
  
  private void skip(long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = this.io_in.skip(paramLong);
      if (l <= 0L) {
        break;
      }
      paramLong -= l;
    }
  }
  
  private void throwStatusError(Buffer paramBuffer, int paramInt)
    throws SftpException
  {
    if ((this.server_version >= 3) && (paramBuffer.getLength() >= 4)) {
      throw new SftpException(paramInt, Util.byte2str(paramBuffer.getString(), "UTF-8"));
    }
    throw new SftpException(paramInt, "Failure");
  }
  
  public void _put(InputStream paramInputStream, String paramString, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    for (;;)
    {
      try
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        localObject1 = Util.str2byte(paramString, this.fEncoding);
        l1 = 0L;
        if (paramInt != 1) {
          if (paramInt != 2) {
            continue;
          }
        }
      }
      catch (Exception paramInputStream)
      {
        Object localObject1;
        long l1;
        long l2;
        int i;
        int j;
        byte[] arrayOfByte;
        int k;
        int m;
        int n;
        label714:
        if (!(paramInputStream instanceof SftpException)) {
          throw new SftpException(4, paramInputStream.toString(), paramInputStream);
        }
        throw ((SftpException)paramInputStream);
      }
      try
      {
        l2 = _stat((byte[])localObject1).getSize();
      }
      catch (Exception localException) {}
    }
    l2 = 0L;
    if ((paramInt == 1) && (l2 > 0L) && (paramInputStream.skip(l2) < l2))
    {
      paramInputStream = new com/jcraft/jsch/SftpException;
      paramSftpProgressMonitor = new java/lang/StringBuilder;
      paramSftpProgressMonitor.<init>();
      paramSftpProgressMonitor.append("failed to resume for ");
      paramSftpProgressMonitor.append(paramString);
      paramInputStream.<init>(4, paramSftpProgressMonitor.toString());
      throw paramInputStream;
    }
    if (paramInt == 0) {
      sendOPENW((byte[])localObject1);
    } else {
      sendOPENA((byte[])localObject1);
    }
    paramString = new com/jcraft/jsch/ChannelSftp$Header;
    paramString.<init>(this);
    localObject1 = header(this.buf, paramString);
    i = ((Header)localObject1).length;
    j = ((Header)localObject1).type;
    fill(this.buf, i);
    if ((j != 101) && (j != 102))
    {
      paramInputStream = new com/jcraft/jsch/SftpException;
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      paramString.append("invalid type=");
      paramString.append(j);
      paramInputStream.<init>(4, paramString.toString());
      throw paramInputStream;
    }
    if (j == 101)
    {
      i = this.buf.getInt();
      throwStatusError(this.buf, i);
    }
    arrayOfByte = this.buf.getString();
    if ((paramInt == 1) || (paramInt == 2)) {
      l1 = 0L + l2;
    }
    k = this.seq;
    paramString = this.obuf.buffer;
    m = arrayOfByte.length + 39;
    i = paramString.length - m - 128;
    n = this.rq.size();
    for (j = 0;; j = paramInt)
    {
      int i1 = i;
      int i2 = m;
      int i3 = 0;
      int i4;
      int i6;
      do
      {
        i4 = paramInputStream.read(paramString, i2, i1);
        int i5 = i2;
        i6 = i1;
        paramInt = i3;
        if (i4 > 0)
        {
          i5 = i2 + i4;
          i6 = i1 - i4;
          paramInt = i3 + i4;
        }
        if (i6 <= 0) {
          break;
        }
        i2 = i5;
        i1 = i6;
        i3 = paramInt;
      } while (i4 > 0);
      if (paramInt <= 0)
      {
        paramInt = j;
      }
      else
      {
        i6 = paramInt;
        i1 = paramInt;
        for (paramInt = j; i6 > 0; paramInt = j)
        {
          i2 = this.seq;
          i3 = paramInt;
          if (i2 - 1 != k)
          {
            j = paramInt;
            if (i2 - k - paramInt < n) {}
          }
          else
          {
            for (i3 = paramInt;; i3++)
            {
              j = i3;
              if (this.seq - k - i3 < n) {
                break label714;
              }
              j = i3;
              if (!checkStatus(this.ackid, (Header)localObject1)) {
                break label714;
              }
              paramInt = this.ackid[0];
              if ((k > paramInt) || (paramInt > this.seq - 1))
              {
                j = this.seq;
                if (paramInt != j) {
                  break;
                }
                PrintStream localPrintStream = System.err;
                localObject2 = new java/lang/StringBuilder;
                ((StringBuilder)localObject2).<init>();
                ((StringBuilder)localObject2).append("ack error: startid=");
                ((StringBuilder)localObject2).append(k);
                ((StringBuilder)localObject2).append(" seq=");
                ((StringBuilder)localObject2).append(this.seq);
                ((StringBuilder)localObject2).append(" _ackid=");
                ((StringBuilder)localObject2).append(paramInt);
                localPrintStream.println(((StringBuilder)localObject2).toString());
              }
            }
            paramString = new com/jcraft/jsch/SftpException;
            paramInputStream = new java/lang/StringBuilder;
            paramInputStream.<init>();
            paramInputStream.append("ack error: startid=");
            paramInputStream.append(k);
            paramInputStream.append(" seq=");
            paramInputStream.append(this.seq);
            paramInputStream.append(" _ackid=");
            paramInputStream.append(paramInt);
            paramString.<init>(4, paramInputStream.toString());
            throw paramString;
          }
          i6 -= sendWRITE(arrayOfByte, l1, paramString, 0, i6);
          Object localObject2 = this.obuf.buffer;
          if (paramString != localObject2)
          {
            i = localObject2.length - m - 128;
            paramString = (String)localObject2;
          }
        }
        l2 = i1;
        l1 += l2;
        if ((paramSftpProgressMonitor == null) || (paramSftpProgressMonitor.count(l2))) {
          continue;
        }
      }
      i = this.seq;
      while ((i - k > paramInt) && (checkStatus(null, (Header)localObject1))) {
        paramInt++;
      }
      if (paramSftpProgressMonitor != null) {
        paramSftpProgressMonitor.end();
      }
      _sendCLOSE(arrayOfByte, (Header)localObject1);
      return;
    }
  }
  
  public void cd(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = isUnique(remoteAbsolutePath(paramString));
      Object localObject1 = _realpath(paramString);
      Object localObject2 = _stat((byte[])localObject1);
      int i = ((SftpATTRS)localObject2).getFlags();
      if ((i & 0x4) != 0)
      {
        if (((SftpATTRS)localObject2).isDir())
        {
          setCwd(Util.byte2str((byte[])localObject1, this.fEncoding));
          return;
        }
        localObject2 = new com/jcraft/jsch/SftpException;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Can't change directory: ");
        ((StringBuilder)localObject1).append(paramString);
        ((SftpException)localObject2).<init>(4, ((StringBuilder)localObject1).toString());
        throw ((Throwable)localObject2);
      }
      localObject1 = new com/jcraft/jsch/SftpException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("Can't change directory: ");
      ((StringBuilder)localObject2).append(paramString);
      ((SftpException)localObject1).<init>(4, ((StringBuilder)localObject2).toString());
      throw ((Throwable)localObject1);
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void chgrp(int paramInt, String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      for (int j = 0; j < i; j++)
      {
        String str = (String)localVector.elementAt(j);
        paramString = _stat(str);
        paramString.setFLAGS(0);
        paramString.setUIDGID(paramString.uid, paramInt);
        _setStat(str, paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void chmod(int paramInt, String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      for (int j = 0; j < i; j++)
      {
        String str = (String)localVector.elementAt(j);
        paramString = _stat(str);
        paramString.setFLAGS(0);
        paramString.setPERMISSIONS(paramInt);
        _setStat(str, paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void chown(int paramInt, String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      for (int j = 0; j < i; j++)
      {
        String str = (String)localVector.elementAt(j);
        paramString = _stat(str);
        paramString.setFLAGS(0);
        paramString.setUIDGID(paramInt, paramString.gid);
        _setStat(str, paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void disconnect()
  {
    super.disconnect();
  }
  
  public void exit()
  {
    disconnect();
  }
  
  public InputStream get(String paramString)
    throws SftpException
  {
    return get(paramString, null, 0L);
  }
  
  public InputStream get(String paramString, int paramInt)
    throws SftpException
  {
    return get(paramString, null, 0L);
  }
  
  public InputStream get(String paramString, SftpProgressMonitor paramSftpProgressMonitor)
    throws SftpException
  {
    return get(paramString, paramSftpProgressMonitor, 0L);
  }
  
  public InputStream get(String paramString, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    return get(paramString, paramSftpProgressMonitor, 0L);
  }
  
  public InputStream get(final String paramString, SftpProgressMonitor paramSftpProgressMonitor, final long paramLong)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      String str = isUnique(remoteAbsolutePath(paramString));
      paramString = Util.str2byte(str, this.fEncoding);
      SftpATTRS localSftpATTRS = _stat(paramString);
      if (paramSftpProgressMonitor != null) {
        paramSftpProgressMonitor.init(1, str, "??", localSftpATTRS.getSize());
      }
      sendOPENR(paramString);
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      paramString = header(this.buf, paramString);
      int i = paramString.length;
      int j = paramString.type;
      fill(this.buf, i);
      if ((j != 101) && (j != 102))
      {
        paramString = new com/jcraft/jsch/SftpException;
        paramString.<init>(4, "");
        throw paramString;
      }
      if (j == 101)
      {
        j = this.buf.getInt();
        throwStatusError(this.buf, j);
      }
      paramString = this.buf.getString();
      this.rq.init();
      paramString = new InputStream()
      {
        byte[] _data;
        boolean closed;
        ChannelSftp.Header header;
        long offset;
        int request_max;
        long request_offset;
        byte[] rest_byte;
        int rest_length;
        
        public void close()
          throws IOException
        {
          if (this.closed) {
            return;
          }
          this.closed = true;
          SftpProgressMonitor localSftpProgressMonitor = paramString;
          if (localSftpProgressMonitor != null) {
            localSftpProgressMonitor.end();
          }
          ChannelSftp.this.rq.cancel(this.header, ChannelSftp.this.buf);
          try
          {
            ChannelSftp.this._sendCLOSE(this.val$handle, this.header);
            return;
          }
          catch (Exception localException)
          {
            throw new IOException("error");
          }
        }
        
        public int read()
          throws IOException
        {
          if (this.closed) {
            return -1;
          }
          if (read(this._data, 0, 1) == -1) {
            return -1;
          }
          return this._data[0] & 0xFF;
        }
        
        public int read(byte[] paramAnonymousArrayOfByte)
          throws IOException
        {
          if (this.closed) {
            return -1;
          }
          return read(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
        }
        
        public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          if (this.closed) {
            return -1;
          }
          Objects.requireNonNull(paramAnonymousArrayOfByte);
          if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 >= 0) && (paramAnonymousInt1 + paramAnonymousInt2 <= paramAnonymousArrayOfByte.length))
          {
            int i = 0;
            if (paramAnonymousInt2 == 0) {
              return 0;
            }
            int j = this.rest_length;
            if (j > 0)
            {
              if (j <= paramAnonymousInt2) {
                paramAnonymousInt2 = j;
              }
              System.arraycopy(this.rest_byte, 0, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              paramAnonymousInt1 = this.rest_length;
              if (paramAnonymousInt2 != paramAnonymousInt1)
              {
                paramAnonymousArrayOfByte = this.rest_byte;
                System.arraycopy(paramAnonymousArrayOfByte, paramAnonymousInt2, paramAnonymousArrayOfByte, 0, paramAnonymousInt1 - paramAnonymousInt2);
              }
              paramAnonymousArrayOfByte = paramString;
              if ((paramAnonymousArrayOfByte != null) && (!paramAnonymousArrayOfByte.count(paramAnonymousInt2)))
              {
                close();
                return -1;
              }
              this.rest_length -= paramAnonymousInt2;
              return paramAnonymousInt2;
            }
            j = paramAnonymousInt2;
            if (ChannelSftp.this.buf.buffer.length - 13 < paramAnonymousInt2) {
              j = ChannelSftp.this.buf.buffer.length - 13;
            }
            int k = ChannelSftp.this.server_version;
            int m = 1024;
            paramAnonymousInt2 = j;
            if (k == 0)
            {
              paramAnonymousInt2 = j;
              if (j > 1024) {
                paramAnonymousInt2 = 1024;
              }
            }
            ChannelSftp.this.rq.count();
            j = ChannelSftp.this.buf.buffer.length;
            if (ChannelSftp.this.server_version == 0) {
              j = m;
            } else {
              j -= 13;
            }
            while (ChannelSftp.this.rq.count() < this.request_max) {
              try
              {
                localObject = ChannelSftp.this;
                ((ChannelSftp)localObject).sendREAD(this.val$handle, this.request_offset, j, ((ChannelSftp)localObject).rq);
                this.request_offset += j;
              }
              catch (Exception paramAnonymousArrayOfByte)
              {
                throw new IOException("error");
              }
            }
            Object localObject = ChannelSftp.this;
            localObject = ((ChannelSftp)localObject).header(((ChannelSftp)localObject).buf, this.header);
            this.header = ((ChannelSftp.Header)localObject);
            this.rest_length = ((ChannelSftp.Header)localObject).length;
            j = ((ChannelSftp.Header)localObject).type;
            m = ((ChannelSftp.Header)localObject).rid;
            try
            {
              localObject = ChannelSftp.this.rq.get(this.header.rid);
              if ((j != 101) && (j != 103)) {
                throw new IOException("error");
              }
              if (j == 101)
              {
                paramAnonymousArrayOfByte = ChannelSftp.this;
                paramAnonymousArrayOfByte.fill(paramAnonymousArrayOfByte.buf, this.rest_length);
                paramAnonymousInt1 = ChannelSftp.this.buf.getInt();
                this.rest_length = 0;
                if (paramAnonymousInt1 == 1)
                {
                  close();
                  return -1;
                }
                throw new IOException("error");
              }
              ChannelSftp.this.buf.rewind();
              ChannelSftp localChannelSftp = ChannelSftp.this;
              localChannelSftp.fill(localChannelSftp.buf.buffer, 0, 4);
              j = ChannelSftp.this.buf.getInt();
              m = this.rest_length - 4;
              this.rest_length = m;
              m -= j;
              long l1 = this.offset;
              long l2 = j;
              this.offset = (l1 + l2);
              if (j > 0)
              {
                if (j <= paramAnonymousInt2) {
                  paramAnonymousInt2 = j;
                }
                k = ChannelSftp.this.io_in.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
                if (k < 0) {
                  return -1;
                }
                j -= k;
                this.rest_length = j;
                if (j > 0)
                {
                  paramAnonymousInt2 = i;
                  paramAnonymousInt1 = j;
                  if (this.rest_byte.length < j)
                  {
                    this.rest_byte = new byte[j];
                    paramAnonymousInt1 = j;
                    paramAnonymousInt2 = i;
                  }
                  while (paramAnonymousInt1 > 0)
                  {
                    j = ChannelSftp.this.io_in.read(this.rest_byte, paramAnonymousInt2, paramAnonymousInt1);
                    if (j <= 0) {
                      break;
                    }
                    paramAnonymousInt2 += j;
                    paramAnonymousInt1 -= j;
                  }
                }
                if (m > 0) {
                  ChannelSftp.this.io_in.skip(m);
                }
                if (l2 < ((ChannelSftp.RequestQueue.Request)localObject).length)
                {
                  ChannelSftp.this.rq.cancel(this.header, ChannelSftp.this.buf);
                  try
                  {
                    paramAnonymousArrayOfByte = ChannelSftp.this;
                    paramAnonymousArrayOfByte.sendREAD(this.val$handle, ((ChannelSftp.RequestQueue.Request)localObject).offset + l2, (int)(((ChannelSftp.RequestQueue.Request)localObject).length - l2), paramAnonymousArrayOfByte.rq);
                    this.request_offset = (((ChannelSftp.RequestQueue.Request)localObject).offset + ((ChannelSftp.RequestQueue.Request)localObject).length);
                  }
                  catch (Exception paramAnonymousArrayOfByte)
                  {
                    throw new IOException("error");
                  }
                }
                if (this.request_max < ChannelSftp.this.rq.size()) {
                  this.request_max += 1;
                }
                paramAnonymousArrayOfByte = paramString;
                if ((paramAnonymousArrayOfByte != null) && (!paramAnonymousArrayOfByte.count(k)))
                {
                  close();
                  return -1;
                }
                return k;
              }
              return 0;
            }
            catch (SftpException localSftpException)
            {
              paramAnonymousArrayOfByte = new StringBuilder();
              paramAnonymousArrayOfByte.append("error: ");
              paramAnonymousArrayOfByte.append(localSftpException.toString());
              throw new IOException(paramAnonymousArrayOfByte.toString());
            }
            catch (ChannelSftp.RequestQueue.OutOfOrderException paramAnonymousArrayOfByte)
            {
              this.request_offset = paramAnonymousArrayOfByte.offset;
              skip(this.header.length);
              ChannelSftp.this.rq.cancel(this.header, ChannelSftp.this.buf);
              return 0;
            }
          }
          throw new IndexOutOfBoundsException();
        }
      };
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void get(String paramString, OutputStream paramOutputStream)
    throws SftpException
  {
    get(paramString, paramOutputStream, null, 0, 0L);
  }
  
  public void get(String paramString, OutputStream paramOutputStream, SftpProgressMonitor paramSftpProgressMonitor)
    throws SftpException
  {
    get(paramString, paramOutputStream, paramSftpProgressMonitor, 0, 0L);
  }
  
  public void get(String paramString, OutputStream paramOutputStream, SftpProgressMonitor paramSftpProgressMonitor, int paramInt, long paramLong)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = isUnique(remoteAbsolutePath(paramString));
      if (paramSftpProgressMonitor != null)
      {
        paramSftpProgressMonitor.init(1, paramString, "??", _stat(paramString).getSize());
        if (paramInt == 1) {
          paramSftpProgressMonitor.count(paramLong);
        }
      }
      _get(paramString, paramOutputStream, paramSftpProgressMonitor, paramInt, paramLong);
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void get(String paramString1, String paramString2)
    throws SftpException
  {
    get(paramString1, paramString2, null, 0);
  }
  
  public void get(String paramString1, String paramString2, SftpProgressMonitor paramSftpProgressMonitor)
    throws SftpException
  {
    get(paramString1, paramString2, paramSftpProgressMonitor, 0);
  }
  
  /* Error */
  public void get(String paramString1, String paramString2, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	com/jcraft/jsch/ChannelSftp:io_in	Ljava/io/InputStream;
    //   4: checkcast 675	com/jcraft/jsch/Channel$MyPipedInputStream
    //   7: invokevirtual 678	com/jcraft/jsch/Channel$MyPipedInputStream:updateReadSide	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 712	com/jcraft/jsch/ChannelSftp:remoteAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: aload_2
    //   18: invokespecial 779	com/jcraft/jsch/ChannelSftp:localAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 550	com/jcraft/jsch/ChannelSftp:glob_remote	(Ljava/lang/String;)Ljava/util/Vector;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 551	java/util/Vector:size	()I
    //   34: istore 6
    //   36: iload 6
    //   38: ifeq +832 -> 870
    //   41: new 156	java/io/File
    //   44: astore_1
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 782	java/io/File:isDirectory	()Z
    //   54: istore 7
    //   56: iload 7
    //   58: ifeq +64 -> 122
    //   61: getstatic 161	com/jcraft/jsch/ChannelSftp:file_separator	Ljava/lang/String;
    //   64: astore 8
    //   66: aload_2
    //   67: astore_1
    //   68: aload_2
    //   69: aload 8
    //   71: invokevirtual 532	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifne +29 -> 103
    //   77: new 479	java/lang/StringBuilder
    //   80: astore_1
    //   81: aload_1
    //   82: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   85: aload_1
    //   86: aload_2
    //   87: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: aload 8
    //   94: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore_1
    //   103: new 784	java/lang/StringBuffer
    //   106: astore 8
    //   108: aload 8
    //   110: aload_1
    //   111: invokespecial 785	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: astore_2
    //   116: aload 8
    //   118: astore_1
    //   119: goto +11 -> 130
    //   122: iload 6
    //   124: iconst_1
    //   125: if_icmpgt +731 -> 856
    //   128: aconst_null
    //   129: astore_1
    //   130: aconst_null
    //   131: astore 8
    //   133: iconst_0
    //   134: istore 9
    //   136: iconst_0
    //   137: istore 10
    //   139: aload_1
    //   140: astore 11
    //   142: iload 9
    //   144: iload 6
    //   146: if_icmpge +709 -> 855
    //   149: aload 8
    //   151: astore_1
    //   152: aload 5
    //   154: iload 9
    //   156: invokevirtual 555	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   159: checkcast 184	java/lang/String
    //   162: astore 12
    //   164: aload 8
    //   166: astore_1
    //   167: aload_0
    //   168: aload 12
    //   170: invokespecial 726	com/jcraft/jsch/ChannelSftp:_stat	(Ljava/lang/String;)Lcom/jcraft/jsch/SftpATTRS;
    //   173: astore 13
    //   175: aload 8
    //   177: astore_1
    //   178: aload 13
    //   180: invokevirtual 547	com/jcraft/jsch/SftpATTRS:isDir	()Z
    //   183: istore 14
    //   185: iload 14
    //   187: ifne +603 -> 790
    //   190: iload 7
    //   192: ifeq +300 -> 492
    //   195: aload 12
    //   197: bipush 47
    //   199: invokevirtual 499	java/lang/String:lastIndexOf	(I)I
    //   202: istore 15
    //   204: iload 15
    //   206: iconst_m1
    //   207: if_icmpne +14 -> 221
    //   210: aload 11
    //   212: aload 12
    //   214: invokevirtual 788	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: goto +18 -> 236
    //   221: aload 11
    //   223: aload 12
    //   225: iload 15
    //   227: iconst_1
    //   228: iadd
    //   229: invokevirtual 505	java/lang/String:substring	(I)Ljava/lang/String;
    //   232: invokevirtual 788	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: aload 11
    //   238: invokevirtual 789	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   241: astore 8
    //   243: aload 8
    //   245: astore_1
    //   246: aload 8
    //   248: ldc_w 791
    //   251: invokevirtual 795	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   254: iconst_m1
    //   255: if_icmpeq +209 -> 464
    //   258: aload 8
    //   260: astore_1
    //   261: new 156	java/io/File
    //   264: astore 16
    //   266: aload 8
    //   268: astore_1
    //   269: aload 16
    //   271: aload_2
    //   272: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: aload 8
    //   277: astore_1
    //   278: aload 16
    //   280: invokevirtual 798	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   283: astore 16
    //   285: aload 8
    //   287: astore_1
    //   288: new 156	java/io/File
    //   291: astore 17
    //   293: aload 8
    //   295: astore_1
    //   296: aload 17
    //   298: aload 8
    //   300: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   303: aload 8
    //   305: astore_1
    //   306: aload 17
    //   308: invokevirtual 798	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   311: astore 17
    //   313: aload 8
    //   315: astore_1
    //   316: aload 17
    //   318: invokevirtual 634	java/lang/String:length	()I
    //   321: aload 16
    //   323: invokevirtual 634	java/lang/String:length	()I
    //   326: if_icmple +79 -> 405
    //   329: aload 8
    //   331: astore_1
    //   332: aload 17
    //   334: iconst_0
    //   335: aload 16
    //   337: invokevirtual 634	java/lang/String:length	()I
    //   340: iconst_1
    //   341: iadd
    //   342: invokevirtual 503	java/lang/String:substring	(II)Ljava/lang/String;
    //   345: astore 17
    //   347: aload 8
    //   349: astore_1
    //   350: new 479	java/lang/StringBuilder
    //   353: astore 18
    //   355: aload 8
    //   357: astore_1
    //   358: aload 18
    //   360: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   363: aload 8
    //   365: astore_1
    //   366: aload 18
    //   368: aload 16
    //   370: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 8
    //   376: astore_1
    //   377: aload 18
    //   379: getstatic 161	com/jcraft/jsch/ChannelSftp:file_separator	Ljava/lang/String;
    //   382: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 8
    //   388: astore_1
    //   389: aload 17
    //   391: aload 18
    //   393: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifeq +6 -> 405
    //   402: goto +62 -> 464
    //   405: aload 8
    //   407: astore_1
    //   408: new 225	com/jcraft/jsch/SftpException
    //   411: astore_3
    //   412: aload 8
    //   414: astore_1
    //   415: new 479	java/lang/StringBuilder
    //   418: astore_2
    //   419: aload 8
    //   421: astore_1
    //   422: aload_2
    //   423: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   426: aload 8
    //   428: astore_1
    //   429: aload_2
    //   430: ldc_w 800
    //   433: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 8
    //   439: astore_1
    //   440: aload_2
    //   441: aload 12
    //   443: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 8
    //   449: astore_1
    //   450: aload_3
    //   451: iconst_4
    //   452: aload_2
    //   453: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   459: aload 8
    //   461: astore_1
    //   462: aload_3
    //   463: athrow
    //   464: aload 8
    //   466: astore_1
    //   467: aload 11
    //   469: aload_2
    //   470: invokevirtual 634	java/lang/String:length	()I
    //   473: aload 8
    //   475: invokevirtual 634	java/lang/String:length	()I
    //   478: invokevirtual 804	java/lang/StringBuffer:delete	(II)Ljava/lang/StringBuffer;
    //   481: pop
    //   482: aload 8
    //   484: astore_1
    //   485: goto +9 -> 494
    //   488: astore_1
    //   489: goto +406 -> 895
    //   492: aload_2
    //   493: astore_1
    //   494: iload 10
    //   496: istore 14
    //   498: new 156	java/io/File
    //   501: astore 8
    //   503: iload 10
    //   505: istore 14
    //   507: aload 8
    //   509: aload_1
    //   510: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: iload 4
    //   515: iconst_1
    //   516: if_icmpne +104 -> 620
    //   519: iload 10
    //   521: istore 14
    //   523: aload 13
    //   525: invokevirtual 682	com/jcraft/jsch/SftpATTRS:getSize	()J
    //   528: lstore 19
    //   530: iload 10
    //   532: istore 14
    //   534: aload 8
    //   536: invokevirtual 806	java/io/File:length	()J
    //   539: lload 19
    //   541: lcmp
    //   542: istore 15
    //   544: iload 15
    //   546: ifgt +9 -> 555
    //   549: iload 15
    //   551: ifne +69 -> 620
    //   554: return
    //   555: iload 10
    //   557: istore 14
    //   559: new 225	com/jcraft/jsch/SftpException
    //   562: astore_3
    //   563: iload 10
    //   565: istore 14
    //   567: new 479	java/lang/StringBuilder
    //   570: astore_2
    //   571: iload 10
    //   573: istore 14
    //   575: aload_2
    //   576: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   579: iload 10
    //   581: istore 14
    //   583: aload_2
    //   584: ldc_w 684
    //   587: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: iload 10
    //   593: istore 14
    //   595: aload_2
    //   596: aload_1
    //   597: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: iload 10
    //   603: istore 14
    //   605: aload_3
    //   606: iconst_4
    //   607: aload_2
    //   608: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   614: iload 10
    //   616: istore 14
    //   618: aload_3
    //   619: athrow
    //   620: aload_3
    //   621: ifnull +47 -> 668
    //   624: iload 10
    //   626: istore 14
    //   628: aload_3
    //   629: iconst_1
    //   630: aload 12
    //   632: aload_1
    //   633: aload 13
    //   635: invokevirtual 682	com/jcraft/jsch/SftpATTRS:getSize	()J
    //   638: invokeinterface 763 6 0
    //   643: iload 4
    //   645: iconst_1
    //   646: if_icmpne +22 -> 668
    //   649: iload 10
    //   651: istore 14
    //   653: aload_3
    //   654: aload 8
    //   656: invokevirtual 806	java/io/File:length	()J
    //   659: invokeinterface 317 3 0
    //   664: pop
    //   665: goto +3 -> 668
    //   668: iload 10
    //   670: istore 14
    //   672: aload 8
    //   674: invokevirtual 809	java/io/File:exists	()Z
    //   677: istore 10
    //   679: iload 4
    //   681: ifne +17 -> 698
    //   684: new 811	java/io/FileOutputStream
    //   687: astore 8
    //   689: aload 8
    //   691: aload_1
    //   692: invokespecial 812	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   695: goto +14 -> 709
    //   698: new 811	java/io/FileOutputStream
    //   701: dup
    //   702: aload_1
    //   703: iconst_1
    //   704: invokespecial 815	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   707: astore 8
    //   709: new 156	java/io/File
    //   712: astore 13
    //   714: aload 13
    //   716: aload_1
    //   717: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   720: aload_0
    //   721: aload 12
    //   723: aload 8
    //   725: aload_3
    //   726: iload 4
    //   728: aload 13
    //   730: invokevirtual 806	java/io/File:length	()J
    //   733: invokespecial 772	com/jcraft/jsch/ChannelSftp:_get	(Ljava/lang/String;Ljava/io/OutputStream;Lcom/jcraft/jsch/SftpProgressMonitor;IJ)V
    //   736: iload 10
    //   738: istore 14
    //   740: aload 8
    //   742: invokevirtual 818	java/io/FileOutputStream:close	()V
    //   745: iinc 9 1
    //   748: aload_1
    //   749: astore 8
    //   751: goto -609 -> 142
    //   754: astore_2
    //   755: goto +7 -> 762
    //   758: astore_2
    //   759: aconst_null
    //   760: astore 8
    //   762: aload 8
    //   764: ifnull +12 -> 776
    //   767: iload 10
    //   769: istore 14
    //   771: aload 8
    //   773: invokevirtual 818	java/io/FileOutputStream:close	()V
    //   776: iload 10
    //   778: istore 14
    //   780: aload_2
    //   781: athrow
    //   782: astore_2
    //   783: iload 14
    //   785: istore 10
    //   787: goto +63 -> 850
    //   790: aload 8
    //   792: astore_1
    //   793: new 225	com/jcraft/jsch/SftpException
    //   796: astore_2
    //   797: aload 8
    //   799: astore_1
    //   800: new 479	java/lang/StringBuilder
    //   803: astore_3
    //   804: aload 8
    //   806: astore_1
    //   807: aload_3
    //   808: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   811: aload 8
    //   813: astore_1
    //   814: aload_3
    //   815: ldc_w 820
    //   818: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 8
    //   824: astore_1
    //   825: aload_3
    //   826: aload 12
    //   828: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 8
    //   834: astore_1
    //   835: aload_2
    //   836: iconst_4
    //   837: aload_3
    //   838: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   844: aload 8
    //   846: astore_1
    //   847: aload_2
    //   848: athrow
    //   849: astore_2
    //   850: aload_1
    //   851: astore_3
    //   852: goto +47 -> 899
    //   855: return
    //   856: new 225	com/jcraft/jsch/SftpException
    //   859: astore_1
    //   860: aload_1
    //   861: iconst_4
    //   862: ldc_w 822
    //   865: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   868: aload_1
    //   869: athrow
    //   870: new 225	com/jcraft/jsch/SftpException
    //   873: astore_1
    //   874: aload_1
    //   875: iconst_2
    //   876: ldc_w 824
    //   879: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   882: aload_1
    //   883: athrow
    //   884: iconst_0
    //   885: istore 10
    //   887: astore_1
    //   888: goto +7 -> 895
    //   891: astore_1
    //   892: iconst_0
    //   893: istore 10
    //   895: aconst_null
    //   896: astore_3
    //   897: aload_1
    //   898: astore_2
    //   899: iload 10
    //   901: ifne +37 -> 938
    //   904: aload_3
    //   905: ifnull +33 -> 938
    //   908: new 156	java/io/File
    //   911: dup
    //   912: aload_3
    //   913: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   916: astore_1
    //   917: aload_1
    //   918: invokevirtual 809	java/io/File:exists	()Z
    //   921: ifeq +17 -> 938
    //   924: aload_1
    //   925: invokevirtual 806	java/io/File:length	()J
    //   928: lconst_0
    //   929: lcmp
    //   930: ifne +8 -> 938
    //   933: aload_1
    //   934: invokevirtual 826	java/io/File:delete	()Z
    //   937: pop
    //   938: aload_2
    //   939: instanceof 225
    //   942: ifne +16 -> 958
    //   945: new 225	com/jcraft/jsch/SftpException
    //   948: dup
    //   949: iconst_4
    //   950: ldc_w 258
    //   953: aload_2
    //   954: invokespecial 348	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   957: athrow
    //   958: aload_2
    //   959: checkcast 225	com/jcraft/jsch/SftpException
    //   962: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	963	0	this	ChannelSftp
    //   0	963	1	paramString1	String
    //   0	963	2	paramString2	String
    //   0	963	3	paramSftpProgressMonitor	SftpProgressMonitor
    //   0	963	4	paramInt	int
    //   27	126	5	localVector	Vector
    //   34	113	6	i	int
    //   54	137	7	bool1	boolean
    //   64	781	8	localObject1	Object
    //   134	612	9	j	int
    //   137	763	10	bool2	boolean
    //   140	328	11	str1	String
    //   162	665	12	str2	String
    //   173	556	13	localObject2	Object
    //   183	601	14	bool3	boolean
    //   202	27	15	k	int
    //   542	8	15	bool4	boolean
    //   264	105	16	localObject3	Object
    //   291	99	17	localObject4	Object
    //   353	39	18	localStringBuilder	StringBuilder
    //   528	12	19	l	long
    // Exception table:
    //   from	to	target	type
    //   195	204	488	java/lang/Exception
    //   210	218	488	java/lang/Exception
    //   221	236	488	java/lang/Exception
    //   236	243	488	java/lang/Exception
    //   709	736	754	finally
    //   684	695	758	finally
    //   698	709	758	finally
    //   498	503	782	java/lang/Exception
    //   507	513	782	java/lang/Exception
    //   523	530	782	java/lang/Exception
    //   534	544	782	java/lang/Exception
    //   559	563	782	java/lang/Exception
    //   567	571	782	java/lang/Exception
    //   575	579	782	java/lang/Exception
    //   583	591	782	java/lang/Exception
    //   595	601	782	java/lang/Exception
    //   605	614	782	java/lang/Exception
    //   618	620	782	java/lang/Exception
    //   628	643	782	java/lang/Exception
    //   653	665	782	java/lang/Exception
    //   672	679	782	java/lang/Exception
    //   740	745	782	java/lang/Exception
    //   771	776	782	java/lang/Exception
    //   780	782	782	java/lang/Exception
    //   152	164	849	java/lang/Exception
    //   167	175	849	java/lang/Exception
    //   178	185	849	java/lang/Exception
    //   246	258	849	java/lang/Exception
    //   261	266	849	java/lang/Exception
    //   269	275	849	java/lang/Exception
    //   278	285	849	java/lang/Exception
    //   288	293	849	java/lang/Exception
    //   296	303	849	java/lang/Exception
    //   306	313	849	java/lang/Exception
    //   316	329	849	java/lang/Exception
    //   332	347	849	java/lang/Exception
    //   350	355	849	java/lang/Exception
    //   358	363	849	java/lang/Exception
    //   366	374	849	java/lang/Exception
    //   377	386	849	java/lang/Exception
    //   389	402	849	java/lang/Exception
    //   408	412	849	java/lang/Exception
    //   415	419	849	java/lang/Exception
    //   422	426	849	java/lang/Exception
    //   429	437	849	java/lang/Exception
    //   440	447	849	java/lang/Exception
    //   450	459	849	java/lang/Exception
    //   462	464	849	java/lang/Exception
    //   467	482	849	java/lang/Exception
    //   793	797	849	java/lang/Exception
    //   800	804	849	java/lang/Exception
    //   807	811	849	java/lang/Exception
    //   814	822	849	java/lang/Exception
    //   825	832	849	java/lang/Exception
    //   835	844	849	java/lang/Exception
    //   847	849	849	java/lang/Exception
    //   856	870	884	java/lang/Exception
    //   870	884	884	java/lang/Exception
    //   0	36	891	java/lang/Exception
    //   41	56	891	java/lang/Exception
    //   61	66	891	java/lang/Exception
    //   68	103	891	java/lang/Exception
    //   103	114	891	java/lang/Exception
  }
  
  public int getBulkRequests()
  {
    return this.rq.size();
  }
  
  public String getExtension(String paramString)
  {
    Hashtable localHashtable = this.extensions;
    if (localHashtable == null) {
      return null;
    }
    return (String)localHashtable.get(paramString);
  }
  
  public String getHome()
    throws SftpException
  {
    if (this.home == null) {
      try
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        this.home = Util.byte2str(_realpath(""), this.fEncoding);
      }
      catch (Exception localException)
      {
        if (!(localException instanceof SftpException)) {
          throw new SftpException(4, "", localException);
        }
        throw ((SftpException)localException);
      }
    }
    return this.home;
  }
  
  public int getServerVersion()
    throws SftpException
  {
    if (isConnected()) {
      return this.server_version;
    }
    throw new SftpException(4, "The channel is not connected.");
  }
  
  public void hardlink(String paramString1, String paramString2)
    throws SftpException
  {
    if (this.extension_hardlink) {
      try
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        String str1 = remoteAbsolutePath(paramString1);
        String str2 = remoteAbsolutePath(paramString2);
        str1 = isUnique(str1);
        int i = 0;
        paramString2 = str1;
        int j;
        if (paramString1.charAt(0) != '/')
        {
          paramString1 = getCwd();
          j = paramString1.length();
          if (!paramString1.endsWith("/")) {
            i = 1;
          }
          paramString2 = str1.substring(j + i);
        }
        if (!isPattern(str2))
        {
          paramString1 = Util.unquote(str2);
          sendHARDLINK(Util.str2byte(paramString2, this.fEncoding), Util.str2byte(paramString1, this.fEncoding));
          paramString1 = new com/jcraft/jsch/ChannelSftp$Header;
          paramString1.<init>(this);
          paramString1 = header(this.buf, paramString1);
          j = paramString1.length;
          i = paramString1.type;
          fill(this.buf, j);
          if (i == 101)
          {
            i = this.buf.getInt();
            if (i == 0) {
              return;
            }
            throwStatusError(this.buf, i);
            return;
          }
          paramString1 = new com/jcraft/jsch/SftpException;
          paramString1.<init>(4, "");
          throw paramString1;
        }
        paramString1 = new com/jcraft/jsch/SftpException;
        paramString1.<init>(4, str2);
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        if (!(paramString1 instanceof SftpException)) {
          throw new SftpException(4, "", paramString1);
        }
        throw ((SftpException)paramString1);
      }
    }
    throw new SftpException(8, "hardlink@openssh.com is not supported");
  }
  
  void init() {}
  
  public void lcd(String paramString)
    throws SftpException
  {
    paramString = localAbsolutePath(paramString);
    if (new File(paramString).isDirectory()) {}
    try
    {
      Object localObject = new java/io/File;
      ((File)localObject).<init>(paramString);
      localObject = ((File)localObject).getCanonicalPath();
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.lcwd = paramString;
    return;
    throw new SftpException(2, "No such directory");
  }
  
  public String lpwd()
  {
    return this.lcwd;
  }
  
  public Vector ls(String paramString)
    throws SftpException
  {
    final Vector localVector = new Vector();
    ls(paramString, new LsEntrySelector()
    {
      public int select(ChannelSftp.LsEntry paramAnonymousLsEntry)
      {
        localVector.addElement(paramAnonymousLsEntry);
        return 0;
      }
    });
    return localVector;
  }
  
  public void ls(String paramString, LsEntrySelector paramLsEntrySelector)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = remoteAbsolutePath(paramString);
      new Vector();
      int i = paramString.lastIndexOf('/');
      if (i == 0) {
        j = 1;
      } else {
        j = i;
      }
      int k = 0;
      Object localObject1 = paramString.substring(0, j);
      Object localObject2 = paramString.substring(i + 1);
      localObject1 = Util.unquote((String)localObject1);
      Object localObject3 = new byte[1][];
      boolean bool1 = isPattern((String)localObject2, (byte[][])localObject3);
      if (bool1)
      {
        paramString = localObject3[0];
      }
      else
      {
        paramString = Util.unquote(paramString);
        if (_stat(paramString).isDir())
        {
          localObject1 = paramString;
          paramString = null;
        }
        else if (this.fEncoding_is_utf8)
        {
          paramString = Util.unquote(localObject3[0]);
        }
        else
        {
          paramString = Util.str2byte(Util.unquote((String)localObject2), this.fEncoding);
        }
      }
      sendOPENDIR(Util.str2byte((String)localObject1, this.fEncoding));
      localObject1 = new com/jcraft/jsch/ChannelSftp$Header;
      ((Header)localObject1).<init>(this);
      localObject1 = header(this.buf, (Header)localObject1);
      i = ((Header)localObject1).length;
      int j = ((Header)localObject1).type;
      fill(this.buf, i);
      int m = 101;
      if ((j != 101) && (j != 102))
      {
        paramString = new com/jcraft/jsch/SftpException;
        paramString.<init>(4, "");
        throw paramString;
      }
      if (j == 101)
      {
        j = this.buf.getInt();
        throwStatusError(this.buf, j);
      }
      byte[] arrayOfByte1 = this.buf.getString();
      j = 0;
      for (;;)
      {
        int n = 1;
        localObject2 = localObject1;
        if (j != 0) {
          break;
        }
        sendREADDIR(arrayOfByte1);
        localObject2 = header(this.buf, (Header)localObject1);
        i = ((Header)localObject2).length;
        int i1 = ((Header)localObject2).type;
        if ((i1 != m) && (i1 != 104))
        {
          paramString = new com/jcraft/jsch/SftpException;
          paramString.<init>(4, "");
          throw paramString;
        }
        if (i1 == m)
        {
          fill(this.buf, i);
          i1 = this.buf.getInt();
          if (i1 == 1) {
            break;
          }
          throwStatusError(this.buf, i1);
        }
        this.buf.rewind();
        fill(this.buf.buffer, k, 4);
        i -= 4;
        i1 = this.buf.getInt();
        this.buf.reset();
        int i2 = k;
        int i3 = m;
        m = n;
        if (i1 > 0)
        {
          k = i;
          if (i > 0)
          {
            this.buf.shift();
            localObject3 = this.buf;
            localObject1 = ((Buffer)localObject3).buffer;
            k = localObject1.length;
            i3 = ((Buffer)localObject3).index;
            if (k > i3 + i) {
              k = i;
            } else {
              k = localObject1.length - i3;
            }
            k = fill((byte[])localObject1, i3, k);
            localObject1 = this.buf;
            ((Buffer)localObject1).index += k;
            k = i - k;
          }
          byte[] arrayOfByte2 = this.buf.getString();
          if (this.server_version <= 3) {
            localObject3 = this.buf.getString();
          } else {
            localObject3 = null;
          }
          SftpATTRS localSftpATTRS = SftpATTRS.getATTR(this.buf);
          if (j == m) {
            i1--;
          }
          for (;;)
          {
            i3 = 101;
            i2 = 0;
            i = k;
            break;
            boolean bool2;
            Object localObject4;
            if (paramString == null)
            {
              localObject1 = null;
              bool2 = true;
            }
            else if (!bool1)
            {
              bool2 = Util.array_equals(paramString, arrayOfByte2);
              localObject1 = null;
            }
            else
            {
              if (!this.fEncoding_is_utf8)
              {
                localObject1 = Util.byte2str(arrayOfByte2, this.fEncoding);
                localObject4 = Util.str2byte((String)localObject1, "UTF-8");
              }
              else
              {
                localObject4 = arrayOfByte2;
                localObject1 = null;
              }
              bool2 = Util.glob(paramString, (byte[])localObject4);
            }
            if (bool2)
            {
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = Util.byte2str(arrayOfByte2, this.fEncoding);
              }
              if (localObject3 == null)
              {
                localObject1 = new java/lang/StringBuilder;
                ((StringBuilder)localObject1).<init>();
                ((StringBuilder)localObject1).append(localSftpATTRS.toString());
                ((StringBuilder)localObject1).append(" ");
                ((StringBuilder)localObject1).append((String)localObject4);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = Util.byte2str((byte[])localObject3, this.fEncoding);
              }
              localObject3 = new com/jcraft/jsch/ChannelSftp$LsEntry;
              ((LsEntry)localObject3).<init>(this, (String)localObject4, (String)localObject1, localSftpATTRS);
              j = paramLsEntrySelector.select((LsEntry)localObject3);
            }
            i1--;
            m = 1;
          }
        }
        localObject1 = localObject2;
        m = i3;
        k = i2;
      }
      _sendCLOSE(arrayOfByte1, (Header)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public SftpATTRS lstat(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = _lstat(isUnique(remoteAbsolutePath(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void mkdir(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      sendMKDIR(Util.str2byte(remoteAbsolutePath(paramString), this.fEncoding), null);
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      paramString = header(this.buf, paramString);
      int i = paramString.length;
      int j = paramString.type;
      fill(this.buf, i);
      if (j == 101)
      {
        j = this.buf.getInt();
        if (j == 0) {
          return;
        }
        throwStatusError(this.buf, j);
        return;
      }
      paramString = new com/jcraft/jsch/SftpException;
      paramString.<init>(4, "");
      throw paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public OutputStream put(String paramString)
    throws SftpException
  {
    return put(paramString, null, 0);
  }
  
  public OutputStream put(String paramString, int paramInt)
    throws SftpException
  {
    return put(paramString, null, paramInt);
  }
  
  public OutputStream put(String paramString, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    return put(paramString, paramSftpProgressMonitor, paramInt, 0L);
  }
  
  /* Error */
  public OutputStream put(final String paramString, final SftpProgressMonitor paramSftpProgressMonitor, int paramInt, long paramLong)
    throws SftpException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	com/jcraft/jsch/ChannelSftp:io_in	Ljava/io/InputStream;
    //   4: checkcast 675	com/jcraft/jsch/Channel$MyPipedInputStream
    //   7: invokevirtual 678	com/jcraft/jsch/Channel$MyPipedInputStream:updateReadSide	()V
    //   10: aload_0
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 712	com/jcraft/jsch/ChannelSftp:remoteAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 714	com/jcraft/jsch/ChannelSftp:isUnique	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 892	com/jcraft/jsch/ChannelSftp:isRemoteDir	(Ljava/lang/String;)Z
    //   25: ifne +226 -> 251
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 202	com/jcraft/jsch/ChannelSftp:fEncoding	Ljava/lang/String;
    //   33: invokestatic 233	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;Ljava/lang/String;)[B
    //   36: astore 6
    //   38: lconst_0
    //   39: lstore 7
    //   41: iload_3
    //   42: iconst_1
    //   43: if_icmpeq +12 -> 55
    //   46: lload 7
    //   48: lstore 9
    //   50: iload_3
    //   51: iconst_2
    //   52: if_icmpne +14 -> 66
    //   55: aload_0
    //   56: aload 6
    //   58: invokespecial 384	com/jcraft/jsch/ChannelSftp:_stat	([B)Lcom/jcraft/jsch/SftpATTRS;
    //   61: invokevirtual 682	com/jcraft/jsch/SftpATTRS:getSize	()J
    //   64: lstore 9
    //   66: aload_2
    //   67: ifnull +17 -> 84
    //   70: aload_2
    //   71: iconst_0
    //   72: ldc_w 894
    //   75: aload_1
    //   76: ldc2_w 895
    //   79: invokeinterface 763 6 0
    //   84: iload_3
    //   85: ifne +12 -> 97
    //   88: aload_0
    //   89: aload 6
    //   91: invokespecial 686	com/jcraft/jsch/ChannelSftp:sendOPENW	([B)V
    //   94: goto +9 -> 103
    //   97: aload_0
    //   98: aload 6
    //   100: invokespecial 688	com/jcraft/jsch/ChannelSftp:sendOPENA	([B)V
    //   103: new 12	com/jcraft/jsch/ChannelSftp$Header
    //   106: astore_1
    //   107: aload_1
    //   108: aload_0
    //   109: invokespecial 240	com/jcraft/jsch/ChannelSftp$Header:<init>	(Lcom/jcraft/jsch/ChannelSftp;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   117: aload_1
    //   118: invokespecial 246	com/jcraft/jsch/ChannelSftp:header	(Lcom/jcraft/jsch/Buffer;Lcom/jcraft/jsch/ChannelSftp$Header;)Lcom/jcraft/jsch/ChannelSftp$Header;
    //   121: astore_1
    //   122: aload_1
    //   123: getfield 249	com/jcraft/jsch/ChannelSftp$Header:length	I
    //   126: istore 11
    //   128: aload_1
    //   129: getfield 252	com/jcraft/jsch/ChannelSftp$Header:type	I
    //   132: istore 12
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   139: iload 11
    //   141: invokespecial 256	com/jcraft/jsch/ChannelSftp:fill	(Lcom/jcraft/jsch/Buffer;I)V
    //   144: iload 12
    //   146: bipush 101
    //   148: if_icmpeq +27 -> 175
    //   151: iload 12
    //   153: bipush 102
    //   155: if_icmpne +6 -> 161
    //   158: goto +17 -> 175
    //   161: new 225	com/jcraft/jsch/SftpException
    //   164: astore_1
    //   165: aload_1
    //   166: iconst_4
    //   167: ldc_w 258
    //   170: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   173: aload_1
    //   174: athrow
    //   175: iload 12
    //   177: bipush 101
    //   179: if_icmpne +22 -> 201
    //   182: aload_0
    //   183: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   186: invokevirtual 267	com/jcraft/jsch/Buffer:getInt	()I
    //   189: istore 11
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   196: iload 11
    //   198: invokespecial 270	com/jcraft/jsch/ChannelSftp:throwStatusError	(Lcom/jcraft/jsch/Buffer;I)V
    //   201: aload_0
    //   202: getfield 242	com/jcraft/jsch/ChannelSftp:buf	Lcom/jcraft/jsch/Buffer;
    //   205: invokevirtual 274	com/jcraft/jsch/Buffer:getString	()[B
    //   208: astore_1
    //   209: iload_3
    //   210: iconst_1
    //   211: if_icmpeq +14 -> 225
    //   214: iload_3
    //   215: iconst_2
    //   216: if_icmpne +6 -> 222
    //   219: goto +6 -> 225
    //   222: goto +10 -> 232
    //   225: lload 4
    //   227: lload 9
    //   229: ladd
    //   230: lstore 4
    //   232: new 6	com/jcraft/jsch/ChannelSftp$1
    //   235: dup
    //   236: aload_0
    //   237: aload_1
    //   238: iconst_1
    //   239: newarray <illegal type>
    //   241: dup
    //   242: iconst_0
    //   243: lload 4
    //   245: lastore
    //   246: aload_2
    //   247: invokespecial 899	com/jcraft/jsch/ChannelSftp$1:<init>	(Lcom/jcraft/jsch/ChannelSftp;[B[JLcom/jcraft/jsch/SftpProgressMonitor;)V
    //   250: areturn
    //   251: new 225	com/jcraft/jsch/SftpException
    //   254: astore_2
    //   255: new 479	java/lang/StringBuilder
    //   258: astore 6
    //   260: aload 6
    //   262: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   265: aload 6
    //   267: aload_1
    //   268: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: ldc_w 901
    //   277: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: iconst_4
    //   283: aload 6
    //   285: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: aload_1
    //   295: instanceof 225
    //   298: ifne +16 -> 314
    //   301: new 225	com/jcraft/jsch/SftpException
    //   304: dup
    //   305: iconst_4
    //   306: ldc_w 258
    //   309: aload_1
    //   310: invokespecial 348	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: athrow
    //   314: aload_1
    //   315: checkcast 225	com/jcraft/jsch/SftpException
    //   318: athrow
    //   319: astore 13
    //   321: lload 7
    //   323: lstore 9
    //   325: goto -259 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	ChannelSftp
    //   0	328	1	paramString	String
    //   0	328	2	paramSftpProgressMonitor	SftpProgressMonitor
    //   0	328	3	paramInt	int
    //   0	328	4	paramLong	long
    //   36	248	6	localObject	Object
    //   39	283	7	l1	long
    //   48	276	9	l2	long
    //   126	71	11	i	int
    //   132	48	12	j	int
    //   319	1	13	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	38	293	java/lang/Exception
    //   70	84	293	java/lang/Exception
    //   88	94	293	java/lang/Exception
    //   97	103	293	java/lang/Exception
    //   103	144	293	java/lang/Exception
    //   161	175	293	java/lang/Exception
    //   182	201	293	java/lang/Exception
    //   201	209	293	java/lang/Exception
    //   232	251	293	java/lang/Exception
    //   251	293	293	java/lang/Exception
    //   55	66	319	java/lang/Exception
  }
  
  public void put(InputStream paramInputStream, String paramString)
    throws SftpException
  {
    put(paramInputStream, paramString, null, 0);
  }
  
  public void put(InputStream paramInputStream, String paramString, int paramInt)
    throws SftpException
  {
    put(paramInputStream, paramString, null, paramInt);
  }
  
  public void put(InputStream paramInputStream, String paramString, SftpProgressMonitor paramSftpProgressMonitor)
    throws SftpException
  {
    put(paramInputStream, paramString, paramSftpProgressMonitor, 0);
  }
  
  public void put(InputStream paramInputStream, String paramString, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    Object localObject = paramString;
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      localObject = paramString;
      paramString = remoteAbsolutePath(paramString);
      localObject = paramString;
      Vector localVector = glob_remote(paramString);
      localObject = paramString;
      int i = localVector.size();
      if (i != 1)
      {
        paramInputStream = paramString;
        if (i == 0)
        {
          localObject = paramString;
          if (isPattern(paramString))
          {
            localObject = paramString;
            paramInputStream = new com/jcraft/jsch/SftpException;
            localObject = paramString;
            paramInputStream.<init>(4, paramString);
            localObject = paramString;
            throw paramInputStream;
          }
          localObject = paramString;
          paramInputStream = Util.unquote(paramString);
        }
        localObject = paramInputStream;
        paramString = new com/jcraft/jsch/SftpException;
        localObject = paramInputStream;
        paramString.<init>(4, localVector.toString());
        localObject = paramInputStream;
        throw paramString;
      }
      localObject = paramString;
      paramString = (String)localVector.elementAt(0);
      if (paramSftpProgressMonitor != null) {}
      try
      {
        paramSftpProgressMonitor.init(0, "-", paramString, -1L);
        _put(paramInputStream, paramString, paramSftpProgressMonitor, paramInt);
        return;
      }
      catch (Exception paramInputStream)
      {
        localObject = paramString;
      }
      if (!(paramInputStream instanceof SftpException)) {
        break label236;
      }
    }
    catch (Exception paramInputStream) {}
    paramInputStream = (SftpException)paramInputStream;
    if ((paramInputStream.id == 4) && (isRemoteDir((String)localObject)))
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append((String)localObject);
      paramInputStream.append(" is a directory");
      throw new SftpException(4, paramInputStream.toString());
    }
    throw paramInputStream;
    label236:
    throw new SftpException(4, paramInputStream.toString(), paramInputStream);
  }
  
  public void put(String paramString1, String paramString2)
    throws SftpException
  {
    put(paramString1, paramString2, null, 0);
  }
  
  public void put(String paramString1, String paramString2, int paramInt)
    throws SftpException
  {
    put(paramString1, paramString2, null, paramInt);
  }
  
  public void put(String paramString1, String paramString2, SftpProgressMonitor paramSftpProgressMonitor)
    throws SftpException
  {
    put(paramString1, paramString2, paramSftpProgressMonitor, 0);
  }
  
  /* Error */
  public void put(String paramString1, String paramString2, SftpProgressMonitor paramSftpProgressMonitor, int paramInt)
    throws SftpException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	com/jcraft/jsch/ChannelSftp:io_in	Ljava/io/InputStream;
    //   4: checkcast 675	com/jcraft/jsch/Channel$MyPipedInputStream
    //   7: invokevirtual 678	com/jcraft/jsch/Channel$MyPipedInputStream:updateReadSide	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 779	com/jcraft/jsch/ChannelSftp:localAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: aload_2
    //   18: invokespecial 712	com/jcraft/jsch/ChannelSftp:remoteAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokespecial 550	com/jcraft/jsch/ChannelSftp:glob_remote	(Ljava/lang/String;)Ljava/util/Vector;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 551	java/util/Vector:size	()I
    //   34: istore 6
    //   36: iload 6
    //   38: iconst_1
    //   39: if_icmpeq +51 -> 90
    //   42: iload 6
    //   44: ifne +31 -> 75
    //   47: aload_0
    //   48: aload 5
    //   50: invokespecial 844	com/jcraft/jsch/ChannelSftp:isPattern	(Ljava/lang/String;)Z
    //   53: ifeq +16 -> 69
    //   56: new 225	com/jcraft/jsch/SftpException
    //   59: astore_1
    //   60: aload_1
    //   61: iconst_4
    //   62: aload 5
    //   64: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   67: aload_1
    //   68: athrow
    //   69: aload 5
    //   71: invokestatic 458	com/jcraft/jsch/Util:unquote	(Ljava/lang/String;)Ljava/lang/String;
    //   74: pop
    //   75: new 225	com/jcraft/jsch/SftpException
    //   78: astore_1
    //   79: aload_1
    //   80: iconst_4
    //   81: aload_2
    //   82: invokevirtual 558	java/util/Vector:toString	()Ljava/lang/String;
    //   85: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   88: aload_1
    //   89: athrow
    //   90: aload_2
    //   91: iconst_0
    //   92: invokevirtual 555	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   95: checkcast 184	java/lang/String
    //   98: astore_2
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 892	com/jcraft/jsch/ChannelSftp:isRemoteDir	(Ljava/lang/String;)Z
    //   104: istore 7
    //   106: aload_0
    //   107: aload_1
    //   108: invokespecial 916	com/jcraft/jsch/ChannelSftp:glob_local	(Ljava/lang/String;)Ljava/util/Vector;
    //   111: astore 8
    //   113: aload 8
    //   115: invokevirtual 551	java/util/Vector:size	()I
    //   118: istore 9
    //   120: iload 7
    //   122: ifeq +54 -> 176
    //   125: aload_2
    //   126: astore_1
    //   127: aload_2
    //   128: ldc_w 512
    //   131: invokevirtual 532	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   134: ifne +30 -> 164
    //   137: new 479	java/lang/StringBuilder
    //   140: astore_1
    //   141: aload_1
    //   142: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   145: aload_1
    //   146: aload_2
    //   147: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_1
    //   152: ldc_w 512
    //   155: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_1
    //   164: new 784	java/lang/StringBuffer
    //   167: astore_2
    //   168: aload_2
    //   169: aload_1
    //   170: invokespecial 785	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   173: goto +13 -> 186
    //   176: iload 9
    //   178: iconst_1
    //   179: if_icmpgt +358 -> 537
    //   182: aload_2
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_2
    //   186: iconst_0
    //   187: istore 6
    //   189: iload 6
    //   191: iload 9
    //   193: if_icmpge +343 -> 536
    //   196: aload 8
    //   198: iload 6
    //   200: invokevirtual 555	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   203: checkcast 184	java/lang/String
    //   206: astore 10
    //   208: iload 7
    //   210: ifeq +110 -> 320
    //   213: aload 10
    //   215: getstatic 166	com/jcraft/jsch/ChannelSftp:file_separatorc	C
    //   218: invokevirtual 499	java/lang/String:lastIndexOf	(I)I
    //   221: istore 11
    //   223: iload 11
    //   225: istore 12
    //   227: getstatic 168	com/jcraft/jsch/ChannelSftp:fs_is_bs	Z
    //   230: ifeq +37 -> 267
    //   233: aload 10
    //   235: bipush 47
    //   237: invokevirtual 499	java/lang/String:lastIndexOf	(I)I
    //   240: istore 13
    //   242: iload 11
    //   244: istore 12
    //   246: iload 13
    //   248: iconst_m1
    //   249: if_icmpeq +18 -> 267
    //   252: iload 11
    //   254: istore 12
    //   256: iload 13
    //   258: iload 11
    //   260: if_icmple +7 -> 267
    //   263: iload 13
    //   265: istore 12
    //   267: iload 12
    //   269: iconst_m1
    //   270: if_icmpne +13 -> 283
    //   273: aload_2
    //   274: aload 10
    //   276: invokevirtual 788	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   279: pop
    //   280: goto +17 -> 297
    //   283: aload_2
    //   284: aload 10
    //   286: iload 12
    //   288: iconst_1
    //   289: iadd
    //   290: invokevirtual 505	java/lang/String:substring	(I)Ljava/lang/String;
    //   293: invokevirtual 788	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   296: pop
    //   297: aload_2
    //   298: invokevirtual 789	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   301: astore 5
    //   303: aload_2
    //   304: aload_1
    //   305: invokevirtual 634	java/lang/String:length	()I
    //   308: aload 5
    //   310: invokevirtual 634	java/lang/String:length	()I
    //   313: invokevirtual 804	java/lang/StringBuffer:delete	(II)Ljava/lang/StringBuffer;
    //   316: pop
    //   317: goto +6 -> 323
    //   320: aload_1
    //   321: astore 5
    //   323: lconst_0
    //   324: lstore 14
    //   326: lload 14
    //   328: lstore 16
    //   330: iload 4
    //   332: iconst_1
    //   333: if_icmpne +93 -> 426
    //   336: aload_0
    //   337: aload 5
    //   339: invokespecial 726	com/jcraft/jsch/ChannelSftp:_stat	(Ljava/lang/String;)Lcom/jcraft/jsch/SftpATTRS;
    //   342: invokevirtual 682	com/jcraft/jsch/SftpATTRS:getSize	()J
    //   345: lstore 16
    //   347: lload 16
    //   349: lstore 14
    //   351: new 156	java/io/File
    //   354: astore 18
    //   356: aload 18
    //   358: aload 10
    //   360: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: aload 18
    //   365: invokevirtual 806	java/io/File:length	()J
    //   368: lload 14
    //   370: lcmp
    //   371: istore 12
    //   373: iload 12
    //   375: iflt +13 -> 388
    //   378: lload 14
    //   380: lstore 16
    //   382: iload 12
    //   384: ifne +42 -> 426
    //   387: return
    //   388: new 225	com/jcraft/jsch/SftpException
    //   391: astore_2
    //   392: new 479	java/lang/StringBuilder
    //   395: astore_1
    //   396: aload_1
    //   397: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   400: aload_1
    //   401: ldc_w 684
    //   404: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: aload 5
    //   411: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_2
    //   416: iconst_4
    //   417: aload_1
    //   418: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   424: aload_2
    //   425: athrow
    //   426: aload_3
    //   427: ifnull +49 -> 476
    //   430: new 156	java/io/File
    //   433: astore 18
    //   435: aload 18
    //   437: aload 10
    //   439: invokespecial 473	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: aload_3
    //   443: iconst_0
    //   444: aload 10
    //   446: aload 5
    //   448: aload 18
    //   450: invokevirtual 806	java/io/File:length	()J
    //   453: invokeinterface 763 6 0
    //   458: iload 4
    //   460: iconst_1
    //   461: if_icmpne +15 -> 476
    //   464: aload_3
    //   465: lload 16
    //   467: invokeinterface 317 3 0
    //   472: pop
    //   473: goto +3 -> 476
    //   476: new 918	java/io/FileInputStream
    //   479: astore 18
    //   481: aload 18
    //   483: aload 10
    //   485: invokespecial 919	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   488: aload_0
    //   489: aload 18
    //   491: aload 5
    //   493: aload_3
    //   494: iload 4
    //   496: invokevirtual 908	com/jcraft/jsch/ChannelSftp:_put	(Ljava/io/InputStream;Ljava/lang/String;Lcom/jcraft/jsch/SftpProgressMonitor;I)V
    //   499: aload 18
    //   501: invokevirtual 920	java/io/FileInputStream:close	()V
    //   504: iinc 6 1
    //   507: goto -318 -> 189
    //   510: astore_2
    //   511: aload 18
    //   513: astore_1
    //   514: aload_2
    //   515: astore_3
    //   516: aload_1
    //   517: astore_2
    //   518: goto +8 -> 526
    //   521: astore_1
    //   522: aconst_null
    //   523: astore_2
    //   524: aload_1
    //   525: astore_3
    //   526: aload_2
    //   527: ifnull +7 -> 534
    //   530: aload_2
    //   531: invokevirtual 920	java/io/FileInputStream:close	()V
    //   534: aload_3
    //   535: athrow
    //   536: return
    //   537: new 225	com/jcraft/jsch/SftpException
    //   540: astore_1
    //   541: aload_1
    //   542: iconst_4
    //   543: ldc_w 922
    //   546: invokespecial 261	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;)V
    //   549: aload_1
    //   550: athrow
    //   551: astore_1
    //   552: aload_1
    //   553: instanceof 225
    //   556: ifne +17 -> 573
    //   559: new 225	com/jcraft/jsch/SftpException
    //   562: dup
    //   563: iconst_4
    //   564: aload_1
    //   565: invokevirtual 709	java/lang/Exception:toString	()Ljava/lang/String;
    //   568: aload_1
    //   569: invokespecial 348	com/jcraft/jsch/SftpException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   572: athrow
    //   573: aload_1
    //   574: checkcast 225	com/jcraft/jsch/SftpException
    //   577: athrow
    //   578: astore 18
    //   580: goto -229 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	ChannelSftp
    //   0	583	1	paramString1	String
    //   0	583	2	paramString2	String
    //   0	583	3	paramSftpProgressMonitor	SftpProgressMonitor
    //   0	583	4	paramInt	int
    //   21	471	5	str1	String
    //   34	471	6	i	int
    //   104	105	7	bool1	boolean
    //   111	86	8	localVector	Vector
    //   118	76	9	j	int
    //   206	278	10	str2	String
    //   221	40	11	k	int
    //   225	65	12	m	int
    //   371	12	12	bool2	boolean
    //   240	24	13	n	int
    //   324	55	14	l1	long
    //   328	138	16	l2	long
    //   354	158	18	localObject	Object
    //   578	1	18	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   488	499	510	finally
    //   476	488	521	finally
    //   0	36	551	java/lang/Exception
    //   47	69	551	java/lang/Exception
    //   69	75	551	java/lang/Exception
    //   75	90	551	java/lang/Exception
    //   90	120	551	java/lang/Exception
    //   127	164	551	java/lang/Exception
    //   164	173	551	java/lang/Exception
    //   196	208	551	java/lang/Exception
    //   213	223	551	java/lang/Exception
    //   227	242	551	java/lang/Exception
    //   273	280	551	java/lang/Exception
    //   283	297	551	java/lang/Exception
    //   297	317	551	java/lang/Exception
    //   351	373	551	java/lang/Exception
    //   388	426	551	java/lang/Exception
    //   430	458	551	java/lang/Exception
    //   464	473	551	java/lang/Exception
    //   499	504	551	java/lang/Exception
    //   530	534	551	java/lang/Exception
    //   534	536	551	java/lang/Exception
    //   537	551	551	java/lang/Exception
    //   336	347	578	java/lang/Exception
  }
  
  public String pwd()
    throws SftpException
  {
    return getCwd();
  }
  
  public void quit()
  {
    disconnect();
  }
  
  public String readlink(String paramString)
    throws SftpException
  {
    try
    {
      if (this.server_version >= 3)
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        sendREADLINK(Util.str2byte(isUnique(remoteAbsolutePath(paramString)), this.fEncoding));
        paramString = new com/jcraft/jsch/ChannelSftp$Header;
        paramString.<init>(this);
        paramString = header(this.buf, paramString);
        int i = paramString.length;
        int j = paramString.type;
        fill(this.buf, i);
        if ((j != 101) && (j != 104))
        {
          paramString = new com/jcraft/jsch/SftpException;
          paramString.<init>(4, "");
          throw paramString;
        }
        paramString = null;
        if (j == 104)
        {
          j = this.buf.getInt();
          for (i = 0; i < j; i++)
          {
            paramString = this.buf.getString();
            if (this.server_version <= 3) {
              this.buf.getString();
            }
            SftpATTRS.getATTR(this.buf);
          }
          return Util.byte2str(paramString, this.fEncoding);
        }
        i = this.buf.getInt();
        throwStatusError(this.buf, i);
        return null;
      }
      paramString = new com/jcraft/jsch/SftpException;
      paramString.<init>(8, "The remote sshd is too old to support symlink operation.");
      throw paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public String realpath(String paramString)
    throws SftpException
  {
    try
    {
      paramString = Util.byte2str(_realpath(remoteAbsolutePath(paramString)), this.fEncoding);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void rename(String paramString1, String paramString2)
    throws SftpException
  {
    if (this.server_version >= 2) {
      try
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        Object localObject = remoteAbsolutePath(paramString1);
        paramString1 = remoteAbsolutePath(paramString2);
        paramString2 = isUnique((String)localObject);
        localObject = glob_remote(paramString1);
        int i = ((Vector)localObject).size();
        if (i < 2)
        {
          if (i == 1)
          {
            paramString1 = (String)((Vector)localObject).elementAt(0);
          }
          else
          {
            if (isPattern(paramString1)) {
              break label193;
            }
            paramString1 = Util.unquote(paramString1);
          }
          sendRENAME(Util.str2byte(paramString2, this.fEncoding), Util.str2byte(paramString1, this.fEncoding));
          paramString1 = new com/jcraft/jsch/ChannelSftp$Header;
          paramString1.<init>(this);
          paramString1 = header(this.buf, paramString1);
          i = paramString1.length;
          int j = paramString1.type;
          fill(this.buf, i);
          if (j == 101)
          {
            i = this.buf.getInt();
            if (i == 0) {
              return;
            }
            throwStatusError(this.buf, i);
            return;
          }
          paramString1 = new com/jcraft/jsch/SftpException;
          paramString1.<init>(4, "");
          throw paramString1;
          label193:
          paramString2 = new com/jcraft/jsch/SftpException;
          paramString2.<init>(4, paramString1);
          throw paramString2;
        }
        paramString1 = new com/jcraft/jsch/SftpException;
        paramString1.<init>(4, ((Vector)localObject).toString());
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        if (!(paramString1 instanceof SftpException)) {
          throw new SftpException(4, "", paramString1);
        }
        throw ((SftpException)paramString1);
      }
    }
    throw new SftpException(8, "The remote sshd is too old to support rename operation.");
  }
  
  public void rm(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      int j = 0;
      while (j < i)
      {
        sendREMOVE(Util.str2byte((String)localVector.elementAt(j), this.fEncoding));
        paramString = header(this.buf, paramString);
        int k = paramString.length;
        int m = paramString.type;
        fill(this.buf, k);
        if (m == 101)
        {
          m = this.buf.getInt();
          if (m != 0) {
            throwStatusError(this.buf, m);
          }
          j++;
        }
        else
        {
          paramString = new com/jcraft/jsch/SftpException;
          paramString.<init>(4, "");
          throw paramString;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void rmdir(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      paramString = new com/jcraft/jsch/ChannelSftp$Header;
      paramString.<init>(this);
      int j = 0;
      while (j < i)
      {
        sendRMDIR(Util.str2byte((String)localVector.elementAt(j), this.fEncoding));
        paramString = header(this.buf, paramString);
        int k = paramString.length;
        int m = paramString.type;
        fill(this.buf, k);
        if (m == 101)
        {
          k = this.buf.getInt();
          if (k != 0) {
            throwStatusError(this.buf, k);
          }
          j++;
        }
        else
        {
          paramString = new com/jcraft/jsch/SftpException;
          paramString.<init>(4, "");
          throw paramString;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void setBulkRequests(int paramInt)
    throws JSchException
  {
    if (paramInt > 0)
    {
      this.rq = new RequestQueue(paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBulkRequests: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be greater than 0.");
    throw new JSchException(localStringBuilder.toString());
  }
  
  public void setFilenameEncoding(String paramString)
    throws SftpException
  {
    int i = getServerVersion();
    if ((3 <= i) && (i <= 5) && (!paramString.equals("UTF-8"))) {
      throw new SftpException(4, "The encoding can not be changed for this sftp server.");
    }
    String str = paramString;
    if (paramString.equals("UTF-8")) {
      str = "UTF-8";
    }
    this.fEncoding = str;
    this.fEncoding_is_utf8 = str.equals("UTF-8");
  }
  
  public void setMtime(String paramString, int paramInt)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      Vector localVector = glob_remote(remoteAbsolutePath(paramString));
      int i = localVector.size();
      for (int j = 0; j < i; j++)
      {
        paramString = (String)localVector.elementAt(j);
        SftpATTRS localSftpATTRS = _stat(paramString);
        localSftpATTRS.setFLAGS(0);
        localSftpATTRS.setACMODTIME(localSftpATTRS.getATime(), paramInt);
        _setStat(paramString, localSftpATTRS);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void setStat(String paramString, SftpATTRS paramSftpATTRS)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = glob_remote(remoteAbsolutePath(paramString));
      int i = paramString.size();
      for (int j = 0; j < i; j++) {
        _setStat((String)paramString.elementAt(j), paramSftpATTRS);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void start()
    throws JSchException
  {
    try
    {
      Object localObject1 = new java/io/PipedOutputStream;
      ((PipedOutputStream)localObject1).<init>();
      this.io.setOutputStream((OutputStream)localObject1);
      Object localObject2 = new com/jcraft/jsch/Channel$MyPipedInputStream;
      ((Channel.MyPipedInputStream)localObject2).<init>(this, (PipedOutputStream)localObject1, this.rmpsize);
      this.io.setInputStream((InputStream)localObject2);
      localObject2 = this.io.in;
      this.io_in = ((InputStream)localObject2);
      if (localObject2 != null)
      {
        localObject2 = new com/jcraft/jsch/RequestSftp;
        ((RequestSftp)localObject2).<init>();
        ((Request)localObject2).request(getSession(), this);
        localObject2 = new com/jcraft/jsch/Buffer;
        ((Buffer)localObject2).<init>(this.lmpsize);
        this.buf = ((Buffer)localObject2);
        localObject2 = new com/jcraft/jsch/Packet;
        ((Packet)localObject2).<init>(this.buf);
        this.packet = ((Packet)localObject2);
        localObject2 = new com/jcraft/jsch/Buffer;
        ((Buffer)localObject2).<init>(this.rmpsize);
        this.obuf = ((Buffer)localObject2);
        localObject2 = new com/jcraft/jsch/Packet;
        ((Packet)localObject2).<init>(this.obuf);
        this.opacket = ((Packet)localObject2);
        sendINIT();
        localObject2 = new com/jcraft/jsch/ChannelSftp$Header;
        ((Header)localObject2).<init>(this);
        localObject2 = header(this.buf, (Header)localObject2);
        int i = ((Header)localObject2).length;
        if (i <= 262144)
        {
          this.server_version = ((Header)localObject2).rid;
          localObject2 = new java/util/Hashtable;
          ((Hashtable)localObject2).<init>();
          this.extensions = ((Hashtable)localObject2);
          if (i > 0)
          {
            fill(this.buf, i);
            while (i > 0)
            {
              localObject1 = this.buf.getString();
              int j = localObject1.length;
              localObject2 = this.buf.getString();
              i = i - (j + 4) - (localObject2.length + 4);
              this.extensions.put(Util.byte2str((byte[])localObject1), Util.byte2str((byte[])localObject2));
            }
          }
          localObject2 = this.extensions.get("posix-rename@openssh.com");
          if ((localObject2 != null) && (this.extensions.get("posix-rename@openssh.com").equals("1"))) {
            this.extension_posix_rename = true;
          }
          if ((this.extensions.get("statvfs@openssh.com") != null) && (this.extensions.get("statvfs@openssh.com").equals("2"))) {
            this.extension_statvfs = true;
          }
          if ((this.extensions.get("hardlink@openssh.com") != null) && (this.extensions.get("hardlink@openssh.com").equals("1"))) {
            this.extension_hardlink = true;
          }
          localObject2 = new java/io/File;
          ((File)localObject2).<init>(".");
          this.lcwd = ((File)localObject2).getCanonicalPath();
          return;
        }
        localObject1 = new com/jcraft/jsch/SftpException;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Received message is too long: ");
        ((StringBuilder)localObject2).append(i);
        ((SftpException)localObject1).<init>(4, ((StringBuilder)localObject2).toString());
        throw ((Throwable)localObject1);
      }
      localObject2 = new com/jcraft/jsch/JSchException;
      ((JSchException)localObject2).<init>("channel is down");
      throw ((Throwable)localObject2);
    }
    catch (Exception localException)
    {
      if (!(localException instanceof JSchException)) {
        throw new JSchException(localException.toString(), localException);
      }
      throw ((JSchException)localException);
    }
  }
  
  public SftpATTRS stat(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = _stat(isUnique(remoteAbsolutePath(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public SftpStatVFS statVFS(String paramString)
    throws SftpException
  {
    try
    {
      ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
      paramString = _statVFS(isUnique(remoteAbsolutePath(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (!(paramString instanceof SftpException)) {
        throw new SftpException(4, "", paramString);
      }
      throw ((SftpException)paramString);
    }
  }
  
  public void symlink(String paramString1, String paramString2)
    throws SftpException
  {
    if (this.server_version >= 3) {
      try
      {
        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
        String str1 = remoteAbsolutePath(paramString1);
        String str2 = remoteAbsolutePath(paramString2);
        str1 = isUnique(str1);
        int i = 0;
        paramString2 = str1;
        int j;
        if (paramString1.charAt(0) != '/')
        {
          paramString1 = getCwd();
          j = paramString1.length();
          if (!paramString1.endsWith("/")) {
            i = 1;
          }
          paramString2 = str1.substring(j + i);
        }
        if (!isPattern(str2))
        {
          paramString1 = Util.unquote(str2);
          sendSYMLINK(Util.str2byte(paramString2, this.fEncoding), Util.str2byte(paramString1, this.fEncoding));
          paramString1 = new com/jcraft/jsch/ChannelSftp$Header;
          paramString1.<init>(this);
          paramString1 = header(this.buf, paramString1);
          i = paramString1.length;
          j = paramString1.type;
          fill(this.buf, i);
          if (j == 101)
          {
            i = this.buf.getInt();
            if (i == 0) {
              return;
            }
            throwStatusError(this.buf, i);
            return;
          }
          paramString1 = new com/jcraft/jsch/SftpException;
          paramString1.<init>(4, "");
          throw paramString1;
        }
        paramString1 = new com/jcraft/jsch/SftpException;
        paramString1.<init>(4, str2);
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        if (!(paramString1 instanceof SftpException)) {
          throw new SftpException(4, "", paramString1);
        }
        throw ((SftpException)paramString1);
      }
    }
    throw new SftpException(8, "The remote sshd is too old to support symlink operation.");
  }
  
  public String version()
  {
    return this.version;
  }
  
  class Header
  {
    int length;
    int rid;
    int type;
    
    Header() {}
  }
  
  public class LsEntry
    implements Comparable
  {
    private SftpATTRS attrs;
    private String filename;
    private String longname;
    
    LsEntry(String paramString1, String paramString2, SftpATTRS paramSftpATTRS)
    {
      setFilename(paramString1);
      setLongname(paramString2);
      setAttrs(paramSftpATTRS);
    }
    
    public int compareTo(Object paramObject)
      throws ClassCastException
    {
      if ((paramObject instanceof LsEntry)) {
        return this.filename.compareTo(((LsEntry)paramObject).getFilename());
      }
      throw new ClassCastException("a decendent of LsEntry must be given.");
    }
    
    public SftpATTRS getAttrs()
    {
      return this.attrs;
    }
    
    public String getFilename()
    {
      return this.filename;
    }
    
    public String getLongname()
    {
      return this.longname;
    }
    
    void setAttrs(SftpATTRS paramSftpATTRS)
    {
      this.attrs = paramSftpATTRS;
    }
    
    void setFilename(String paramString)
    {
      this.filename = paramString;
    }
    
    void setLongname(String paramString)
    {
      this.longname = paramString;
    }
    
    public String toString()
    {
      return this.longname;
    }
  }
  
  public static abstract interface LsEntrySelector
  {
    public static final int BREAK = 1;
    public static final int CONTINUE = 0;
    
    public abstract int select(ChannelSftp.LsEntry paramLsEntry);
  }
  
  private class RequestQueue
  {
    int count;
    int head;
    Request[] rrq = null;
    
    RequestQueue(int paramInt)
    {
      this.rrq = new Request[paramInt];
      for (paramInt = 0;; paramInt++)
      {
        this$1 = this.rrq;
        if (paramInt >= ChannelSftp.this.length) {
          break;
        }
        ChannelSftp.this[paramInt] = new Request();
      }
      init();
    }
    
    void add(int paramInt1, long paramLong, int paramInt2)
    {
      int i = this.count;
      if (i == 0) {
        this.head = 0;
      }
      int j = this.head + i;
      Request[] arrayOfRequest = this.rrq;
      int k = j;
      if (j >= arrayOfRequest.length) {
        k = j - arrayOfRequest.length;
      }
      arrayOfRequest[k].id = paramInt1;
      arrayOfRequest[k].offset = paramLong;
      arrayOfRequest[k].length = paramInt2;
      this.count = (i + 1);
    }
    
    void cancel(ChannelSftp.Header paramHeader, Buffer paramBuffer)
      throws IOException
    {
      int i = this.count;
      for (int j = 0; j < i; j++)
      {
        paramHeader = ChannelSftp.this.header(paramBuffer, paramHeader);
        int k = paramHeader.length;
        for (int m = 0;; m++)
        {
          Request[] arrayOfRequest = this.rrq;
          if (m >= arrayOfRequest.length) {
            break;
          }
          if (arrayOfRequest[m].id == paramHeader.rid)
          {
            arrayOfRequest[m].id = 0;
            break;
          }
        }
        ChannelSftp.this.skip(k);
      }
      init();
    }
    
    int count()
    {
      return this.count;
    }
    
    Request get(int paramInt)
      throws ChannelSftp.RequestQueue.OutOfOrderException, SftpException
    {
      int i = this.count;
      int j = 1;
      this.count = (i - 1);
      i = this.head;
      int k = i + 1;
      this.head = k;
      Object localObject = this.rrq;
      if (k == localObject.length) {
        this.head = 0;
      }
      if (localObject[i].id != paramInt)
      {
        long l = getOffset();
        for (i = 0;; i++)
        {
          localObject = this.rrq;
          if (i >= localObject.length) {
            break;
          }
          if (localObject[i].id == paramInt)
          {
            localObject[i].id = 0;
            i = j;
            break label113;
          }
        }
        i = 0;
        label113:
        if (i != 0) {
          throw new OutOfOrderException(l);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RequestQueue: unknown request id ");
        ((StringBuilder)localObject).append(paramInt);
        throw new SftpException(4, ((StringBuilder)localObject).toString());
      }
      localObject[i].id = 0;
      return localObject[i];
    }
    
    long getOffset()
    {
      long l1 = Long.MAX_VALUE;
      int i = 0;
      for (;;)
      {
        Request[] arrayOfRequest = this.rrq;
        if (i >= arrayOfRequest.length) {
          break;
        }
        long l2;
        if (arrayOfRequest[i].id == 0)
        {
          l2 = l1;
        }
        else
        {
          l2 = l1;
          if (l1 > arrayOfRequest[i].offset) {
            l2 = arrayOfRequest[i].offset;
          }
        }
        i++;
        l1 = l2;
      }
      return l1;
    }
    
    void init()
    {
      this.count = 0;
      this.head = 0;
    }
    
    int size()
    {
      return this.rrq.length;
    }
    
    class OutOfOrderException
      extends Exception
    {
      long offset;
      
      OutOfOrderException(long paramLong)
      {
        this.offset = paramLong;
      }
    }
    
    class Request
    {
      int id;
      long length;
      long offset;
      
      Request() {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelSftp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */