package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.Des;
import com.alipay.sdk.util.DeviceInfo;
import java.lang.ref.WeakReference;

final class TidDbHelper extends SQLiteOpenHelper
{
    private static final String a = "msp.db";
    private static final int b = 1;
    private WeakReference c;

    public TidDbHelper(Context paramContext) {
        super(paramContext, "msp.db", null, 1);
        this.c = new WeakReference(paramContext);
    }

    public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
        paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }
    // ERROR //
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4) { // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 54	com/alipay/sdk/tid/TidDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: dup
    //   8: astore 5
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 50	com/alipay/sdk/tid/TidDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    //   15: ifeq +17 -> 32
    //   18: aload_0
    //   19: aload 5
    //   21: aload_1
    //   22: aload_2
    //   23: aload_3
    //   24: aload 4
    //   26: invokespecial 51	com/alipay/sdk/tid/TidDbHelper:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   29: goto +199 -> 228
    //   32: aload_0
    //   33: aload 5
    //   35: aload_1
    //   36: aload_2
    //   37: aload_3
    //   38: aload 4
    //   40: astore 7
    //   42: astore 6
    //   44: astore 4
    //   46: astore_3
    //   47: astore_2
    //   48: astore_1
    //   49: ldc 5
    //   51: astore 8
    //   53: aload 6
    //   55: aload_1
    //   56: getfield 38	com/alipay/sdk/tid/TidDbHelper:c	Ljava/lang/ref/WeakReference;
    //   59: invokevirtual 60	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   62: checkcast 18	android/content/Context
    //   65: invokestatic 55	com/alipay/sdk/util/DeviceInfo:c	(Landroid/content/Context;)Ljava/lang/String;
    //   68: invokestatic 47	com/alipay/sdk/encrypt/Des:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 6
    //   73: aload_2
    //   74: aload 8
    //   76: iconst_3
    //   77: anewarray 28	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_3
    //   83: aload 4
    //   85: invokestatic 52	com/alipay/sdk/tid/TidDbHelper:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload 6
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: aload 7
    //   98: aastore
    //   99: invokevirtual 42	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: iconst_0
    //   103: istore_1
    //   104: ldc 11
    //   106: astore_3
    //   107: aload_2
    //   108: aload_3
    //   109: aconst_null
    //   110: invokevirtual 44	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   113: dup
    //   114: astore_3
    //   115: invokeinterface 67 1 0
    //   120: bipush 14
    //   122: if_icmpgt +12 -> 134
    //   125: aload_3
    //   126: invokeinterface 66 1 0
    //   131: goto +97 -> 228
    //   134: aload_3
    //   135: invokeinterface 67 1 0
    //   140: bipush 14
    //   142: isub
    //   143: dup
    //   144: istore 4
    //   146: anewarray 29	java/lang/String
    //   149: astore 6
    //   151: aload_3
    //   152: invokeinterface 70 1 0
    //   157: ifeq +32 -> 189
    //   160: aload 6
    //   162: iload_1
    //   163: aload_3
    //   164: iconst_0
    //   165: invokeinterface 69 2 0
    //   170: aastore
    //   171: iinc 1 1
    //   174: aload_3
    //   175: invokeinterface 71 1 0
    //   180: ifeq +9 -> 189
    //   183: iload 4
    //   185: iload_1
    //   186: if_icmpgt -26 -> 160
    //   189: aload_3
    //   190: invokeinterface 66 1 0
    //   195: iconst_0
    //   196: istore_1
    //   197: iload_1
    //   198: aload 6
    //   200: arraylength
    //   201: if_icmpge +27 -> 228
    //   204: aload 6
    //   206: iload_1
    //   207: aaload
    //   208: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +11 -> 222
    //   214: aload_2
    //   215: aload 6
    //   217: iload_1
    //   218: aaload
    //   219: invokestatic 49	com/alipay/sdk/tid/TidDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   222: iinc 1 1
    //   225: goto -28 -> 197
    //   228: aload 5
    //   230: ifnull +58 -> 288
    //   233: aload 5
    //   235: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   238: ifeq +50 -> 288
    //   241: aload 5
    //   243: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   246: return
    //   247: pop
    //   248: aload 5
    //   250: ifnull +38 -> 288
    //   253: aload 5
    //   255: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   258: ifeq +30 -> 288
    //   261: aload 5
    //   263: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   266: return
    //   267: astore_1
    //   268: aload 5
    //   270: ifnull +16 -> 286
    //   273: aload 5
    //   275: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   278: ifeq +8 -> 286
    //   281: aload 5
    //   283: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   286: aload_1
    //   287: athrow
    //   288: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	228	247	java/lang/Exception
    //   3	228	267	finally }
    // ERROR //
    public final void a(String paramString1, String paramString2) { // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 54	com/alipay/sdk/tid/TidDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_0
    //   8: aload_3
    //   9: aload_1
    //   10: aload_2
    //   11: ldc 2
    //   13: ldc 2
    //   15: invokespecial 51	com/alipay/sdk/tid/TidDbHelper:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_3
    //   19: aload_1
    //   20: aload_2
    //   21: invokestatic 52	com/alipay/sdk/tid/TidDbHelper:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 49	com/alipay/sdk/tid/TidDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   27: aload_3
    //   28: ifnull +50 -> 78
    //   31: aload_3
    //   32: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   35: ifeq +43 -> 78
    //   38: aload_3
    //   39: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   42: return
    //   43: pop
    //   44: aload_3
    //   45: ifnull +33 -> 78
    //   48: aload_3
    //   49: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   52: ifeq +26 -> 78
    //   55: aload_3
    //   56: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   59: return
    //   60: astore_1
    //   61: aload_3
    //   62: ifnull +14 -> 76
    //   65: aload_3
    //   66: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   69: ifeq +7 -> 76
    //   72: aload_3
    //   73: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   76: aload_1
    //   77: athrow
    //   78: return
    //
    // Exception table:
    //   from	to	target	type
    //   2	27	43	java/lang/Exception
    //   2	27	60	finally }
    // ERROR //
    public final String b(String paramString1, String paramString2) { // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 13
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 53	com/alipay/sdk/tid/TidDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: dup
    //   17: astore 5
    //   19: aload 4
    //   21: iconst_1
    //   22: anewarray 29	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokestatic 52	com/alipay/sdk/tid/TidDbHelper:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual 44	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: dup
    //   37: astore 6
    //   39: invokeinterface 70 1 0
    //   44: ifeq +12 -> 56
    //   47: aload 6
    //   49: iconst_0
    //   50: invokeinterface 69 2 0
    //   55: astore_3
    //   56: aload 6
    //   58: ifnull +10 -> 68
    //   61: aload 6
    //   63: invokeinterface 66 1 0
    //   68: aload 5
    //   70: ifnull +86 -> 156
    //   73: aload 5
    //   75: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   78: ifeq +78 -> 156
    //   81: aload 5
    //   83: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   86: goto +70 -> 156
    //   89: pop
    //   90: aload 6
    //   92: ifnull +10 -> 102
    //   95: aload 6
    //   97: invokeinterface 66 1 0
    //   102: aload 5
    //   104: ifnull +52 -> 156
    //   107: aload 5
    //   109: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   112: ifeq +44 -> 156
    //   115: aload 5
    //   117: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: goto +36 -> 156
    //   123: astore_1
    //   124: aload 6
    //   126: ifnull +10 -> 136
    //   129: aload 6
    //   131: invokeinterface 66 1 0
    //   136: aload 5
    //   138: ifnull +16 -> 154
    //   141: aload 5
    //   143: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   146: ifeq +8 -> 154
    //   149: aload 5
    //   151: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: aload_3
    //   157: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifne +21 -> 181
    //   163: aload_3
    //   164: aload_0
    //   165: getfield 38	com/alipay/sdk/tid/TidDbHelper:c	Ljava/lang/ref/WeakReference;
    //   168: invokevirtual 60	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   171: checkcast 18	android/content/Context
    //   174: invokestatic 55	com/alipay/sdk/util/DeviceInfo:c	(Landroid/content/Context;)Ljava/lang/String;
    //   177: invokestatic 48	com/alipay/sdk/encrypt/Des:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   180: astore_3
    //   181: aload_3
    //   182: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   12	56	89	java/lang/Exception
    //   12	56	123	finally }
    // ERROR //
    private long d(String paramString1, String paramString2) { // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: ldc 9
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_0
    //   13: invokevirtual 53	com/alipay/sdk/tid/TidDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: dup
    //   17: astore 6
    //   19: aload 5
    //   21: iconst_1
    //   22: anewarray 29	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokestatic 52	com/alipay/sdk/tid/TidDbHelper:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual 44	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: dup
    //   37: astore 7
    //   39: invokeinterface 70 1 0
    //   44: ifeq +32 -> 76
    //   47: new 33	java/text/SimpleDateFormat
    //   50: dup
    //   51: ldc 16
    //   53: invokestatic 65	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   56: invokespecial 61	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   59: aconst_null
    //   60: astore_1
    //   61: aload 7
    //   63: iconst_0
    //   64: invokeinterface 69 2 0
    //   69: invokevirtual 62	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   72: invokevirtual 64	java/util/Date:getTime	()J
    //   75: lstore_3
    //   76: aload 7
    //   78: ifnull +10 -> 88
    //   81: aload 7
    //   83: invokeinterface 66 1 0
    //   88: aload 6
    //   90: ifnull +86 -> 176
    //   93: aload 6
    //   95: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   98: ifeq +78 -> 176
    //   101: aload 6
    //   103: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   106: goto +70 -> 176
    //   109: pop
    //   110: aload 7
    //   112: ifnull +10 -> 122
    //   115: aload 7
    //   117: invokeinterface 66 1 0
    //   122: aload 6
    //   124: ifnull +52 -> 176
    //   127: aload 6
    //   129: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   132: ifeq +44 -> 176
    //   135: aload 6
    //   137: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   140: goto +36 -> 176
    //   143: astore_1
    //   144: aload 7
    //   146: ifnull +10 -> 156
    //   149: aload 7
    //   151: invokeinterface 66 1 0
    //   156: aload 6
    //   158: ifnull +16 -> 174
    //   161: aload 6
    //   163: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   166: ifeq +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   174: aload_1
    //   175: athrow
    //   176: lload_3
    //   177: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   12	76	109	java/lang/Exception
    //   12	76	143	finally }
    // ERROR //
    private java.util.List a() { // Byte code:
    //   0: new 34	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 63	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 53	com/alipay/sdk/tid/TidDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_2
    //   17: ldc 12
    //   19: astore 4
    //   21: aload_2
    //   22: aload 4
    //   24: aconst_null
    //   25: invokevirtual 44	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: invokeinterface 71 1 0
    //   35: ifeq +51 -> 86
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 69 2 0
    //   45: dup
    //   46: astore 4
    //   48: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +32 -> 83
    //   54: aload 4
    //   56: aload_0
    //   57: getfield 38	com/alipay/sdk/tid/TidDbHelper:c	Ljava/lang/ref/WeakReference;
    //   60: invokevirtual 60	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   63: checkcast 18	android/content/Context
    //   66: invokestatic 55	com/alipay/sdk/util/DeviceInfo:c	(Landroid/content/Context;)Ljava/lang/String;
    //   69: invokestatic 48	com/alipay/sdk/encrypt/Des:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 4
    //   74: aload_1
    //   75: aload 4
    //   77: invokeinterface 72 2 0
    //   82: pop
    //   83: goto -54 -> 29
    //   86: aload_3
    //   87: ifnull +9 -> 96
    //   90: aload_3
    //   91: invokeinterface 66 1 0
    //   96: aload_2
    //   97: ifnull +75 -> 172
    //   100: aload_2
    //   101: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   104: ifeq +68 -> 172
    //   107: aload_2
    //   108: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   111: goto +61 -> 172
    //   114: astore 4
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 66 1 0
    //   126: aload_2
    //   127: ifnull +45 -> 172
    //   130: aload_2
    //   131: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   134: ifeq +38 -> 172
    //   137: aload_2
    //   138: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: goto +31 -> 172
    //   144: astore_1
    //   145: aload_3
    //   146: ifnull +9 -> 155
    //   149: aload_3
    //   150: invokeinterface 66 1 0
    //   155: aload_2
    //   156: ifnull +14 -> 170
    //   159: aload_2
    //   160: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   163: ifeq +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: aload_1
    //   173: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   12	86	114	java/lang/Exception
    //   12	86	144	finally }
    // ERROR //
    public final String c(String paramString1, String paramString2) { // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 10
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 53	com/alipay/sdk/tid/TidDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: dup
    //   17: astore 5
    //   19: aload 4
    //   21: iconst_1
    //   22: anewarray 29	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokestatic 52	com/alipay/sdk/tid/TidDbHelper:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual 44	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: dup
    //   37: astore 6
    //   39: invokeinterface 70 1 0
    //   44: ifeq +12 -> 56
    //   47: aload 6
    //   49: iconst_0
    //   50: invokeinterface 69 2 0
    //   55: astore_3
    //   56: aload 6
    //   58: ifnull +10 -> 68
    //   61: aload 6
    //   63: invokeinterface 66 1 0
    //   68: aload 5
    //   70: ifnull +86 -> 156
    //   73: aload 5
    //   75: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   78: ifeq +78 -> 156
    //   81: aload 5
    //   83: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   86: goto +70 -> 156
    //   89: pop
    //   90: aload 6
    //   92: ifnull +10 -> 102
    //   95: aload 6
    //   97: invokeinterface 66 1 0
    //   102: aload 5
    //   104: ifnull +52 -> 156
    //   107: aload 5
    //   109: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   112: ifeq +44 -> 156
    //   115: aload 5
    //   117: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: goto +36 -> 156
    //   123: astore_1
    //   124: aload 6
    //   126: ifnull +10 -> 136
    //   129: aload 6
    //   131: invokeinterface 66 1 0
    //   136: aload 5
    //   138: ifnull +16 -> 154
    //   141: aload 5
    //   143: invokevirtual 43	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   146: ifeq +8 -> 154
    //   149: aload 5
    //   151: invokevirtual 39	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: aload_3
    //   157: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   12	56	89	java/lang/Exception
    //   12	56	123	finally }
    private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2) {
        String str = "select count(*) from tb_tid where name=?";
        int i = 0;
        Cursor localCursor = null;
        try {
            if ((localCursor = paramSQLiteDatabase.rawQuery(str, new String[] { e(paramString1, paramString2) })).moveToFirst()) {
                i = localCursor.getInt(0);
            }

            if (localCursor != null)
                localCursor.close();
        } catch (Exception localException) {
            if (localCursor != null)
                localCursor.close();
        } finally {
            if (localCursor != null)
                localCursor.close();
        }
        return false;
    }

    private static String e(String paramString1, String paramString2) {
        return paramString1 + paramString2;
    }

    private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4) {
        String str = "insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))";
        paramString3 = Des.a(paramString3, DeviceInfo.c((Context)this.c.get()));
        paramSQLiteDatabase.execSQL(str, new Object[] { e(paramString1, paramString2), paramString3, paramString4 });

        paramString1 = paramSQLiteDatabase; paramSQLiteDatabase = 0;
        paramString2 = "select name from tb_tid where tid!='' order by dt asc";
        if ((paramString2 = paramString1.rawQuery(paramString2, null)).getCount() <= 14) {
            paramString2.close(); return;
        }
        paramString4 = new String[paramString3 = paramString2.getCount() - 14];
        if (paramString2.moveToFirst())
            do {
                paramString4[paramSQLiteDatabase] = paramString2.getString(0);
                paramSQLiteDatabase++;
            } while ((paramString2.moveToNext()) && (paramString3 > paramSQLiteDatabase));
        paramString2.close();
        for (paramSQLiteDatabase = 0; paramSQLiteDatabase < paramString4.length; paramSQLiteDatabase++)
            if (!TextUtils.isEmpty(paramString4[paramSQLiteDatabase]))
                a(paramString1, paramString4[paramSQLiteDatabase]);
    }

    private void b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4) {
        String str = "update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?";
        paramString3 = Des.a(paramString3, DeviceInfo.c((Context)this.c.get()));
        paramSQLiteDatabase.execSQL(str, new Object[] { paramString3, paramString4, e(paramString1, paramString2) });
    }

    private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
        try { paramSQLiteDatabase.delete("tb_tid", "name=?", new String[] { paramString });
            return;
        } catch (Exception localException) {

        }
    }

    private static void a(SQLiteDatabase paramSQLiteDatabase) {
        int i = 0;
        Object localObject = "select name from tb_tid where tid!='' order by dt asc";

        if ((localObject = paramSQLiteDatabase.rawQuery((String)localObject, null)).getCount() <= 14) {
            ((Cursor)localObject).close();
            return;
        }
        int j;
        String[] arrayOfString = new String[j = ((Cursor)localObject).getCount() - 14];

        if (((Cursor)localObject).moveToFirst()) {
            do {
                arrayOfString[i] = ((Cursor)localObject).getString(0);
                i++;
            } while ((((Cursor)localObject).moveToNext()) && (j > i));
        }
        ((Cursor)localObject).close();
        for (i = 0; i < arrayOfString.length; i++)
            if (!TextUtils.isEmpty(arrayOfString[i]))
                a(paramSQLiteDatabase, arrayOfString[i]);
    }

}
