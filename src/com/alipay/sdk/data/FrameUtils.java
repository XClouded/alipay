package com.alipay.sdk.data;

import android.text.TextUtils;
import com.alipay.sdk.cons.GlobalConstants;
import com.alipay.sdk.exception.UnZipException;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.tid.TidInfo;
import com.alipay.sdk.util.DeviceInfo;
import com.alipay.sdk.util.JsonUtils;
import com.alipay.sdk.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public class FrameUtils
{
    private static final String a = "Msp-Param";

    public static Request a(InteractionData paramInteractionData, String paramString, JSONObject paramJSONObject) {
        Object localObject1 = GlobalContext.a();
        Object localObject2 = TidInfo.c();
        paramJSONObject = JsonUtils.a(null, paramJSONObject);
        try {
            paramJSONObject.put("tid", ((TidInfo)localObject2).a());
            paramJSONObject.put("user_agent", ((GlobalContext)localObject1).c().a((TidInfo)localObject2));
            paramJSONObject.put("has_alipay", Utils.b(((GlobalContext)localObject1).b()));
            paramJSONObject.put("has_msp_app", Utils.a(((GlobalContext)localObject1).b()));
            paramJSONObject.put("external_info", paramString);
            paramJSONObject.put("app_key", "2014052600006128");
            paramJSONObject.put("utdid", ((GlobalContext)localObject1).g());
            paramJSONObject.put("new_client_key", ((TidInfo)localObject2).b()); } catch (JSONException localJSONException) {
        }
        localObject1 = paramJSONObject;
        Object localObject3;
        (localObject3 = new Envelope()).b(GlobalConstants.b);
        ((Envelope)localObject3).c("com.alipay.mobilecashier");
        ((Envelope)localObject3).d("/cashier/main");
        ((Envelope)localObject3).e("4.0.2");
        Object localObject4 = null;
        if (localObject1 != null)
            (localObject4 = new Request((Envelope)localObject3, (JSONObject)localObject1)).a(true);

        if ((paramJSONObject = localObject4) != null) {
            localObject3 = paramString;
            localObject2 = paramJSONObject;
            localObject1 = paramInteractionData;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && ((localObject4 = ((String)localObject3).split("&")).length != 0)) {
                paramInteractionData = null;
                paramString = null;
                localObject3 = null;
                Object localObject5 = null;
                for (Object localObject6 : localObject4) {
                    Object localObject7;
                    if (TextUtils.isEmpty(paramInteractionData))
                        paramInteractionData = !(localObject7 = localObject6).contains("biz_type") ? null : d(localObject7);
                    if (TextUtils.isEmpty(paramString)) paramString = !(localObject7 = localObject6).contains("biz_no") ? null : d(localObject7);
                    if (TextUtils.isEmpty((CharSequence)localObject3))
                        localObject3 = (!(localObject7 = localObject6).contains("trade_no")) || (localObject7.startsWith("out_trade_no")) ? null : d(localObject7);
                    if (TextUtils.isEmpty((CharSequence)localObject5))
                        localObject5 = !(localObject7 = localObject6).contains("app_userid") ? null : d(localObject7);
                }
                localObject4 = new StringBuilder();
                if (!TextUtils.isEmpty(paramInteractionData))
                    ((StringBuilder)localObject4).append("biz_type=" + paramInteractionData + ";");
                if (!TextUtils.isEmpty(paramString))
                    ((StringBuilder)localObject4).append("biz_no=" + paramString + ";");
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                    ((StringBuilder)localObject4).append("trade_no=" + (String)localObject3 + ";");
                if (!TextUtils.isEmpty((CharSequence)localObject5))
                    ((StringBuilder)localObject4).append("app_userid=" + (String)localObject5 + ";");
                if (((StringBuilder)localObject4).length() != 0) {
                    String str;
                    if ((str = ((StringBuilder)localObject4).toString()).endsWith(";"))
                        str = str.substring(0, str.length() - 1);
                        ((InteractionData)localObject1).a(new Header[] { new BasicHeader("Msp-Param", str) });
                        ((Request)localObject2).a((InteractionData)localObject1);
                }
            }
        }
        return paramJSONObject;
    }

    private static Request a(JSONObject paramJSONObject, boolean paramBoolean) {
        Envelope localEnvelope;
        (localEnvelope = new Envelope()).b(GlobalConstants.b);
        localEnvelope.c("com.alipay.mobilecashier");
        localEnvelope.d("/cashier/main");
        localEnvelope.e("4.0.2");
        Request localRequest = null;
        if (paramJSONObject != null) {
            (localRequest = new Request(localEnvelope, paramJSONObject)).a(paramBoolean);
        }
        return localRequest;
    }

    private static void a(InteractionData paramInteractionData, Request paramRequest, String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }

        if ((paramString = paramString.split("&")).length == 0) {
            return;
        }

        Object localObject1 = null;
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        for (Object localObject5 : paramString) {
            Object localObject6;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject1 = !(localObject6 = localObject5).contains("biz_type") ? null : d(localObject6);
            }

            if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject2 = !(localObject6 = localObject5).contains("biz_no") ? null : d(localObject6);
            }

            if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject3 = (!(localObject6 = localObject5).contains("trade_no")) || (localObject6.startsWith("out_trade_no")) ? null : d(localObject6);
            }
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
                localObject4 = !(localObject6 = localObject5).contains("app_userid") ? null : d(localObject6);
            }
        }

        paramString = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString.append("biz_type=" + (String)localObject1 + ";");
        }

        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramString.append("biz_no=" + (String)localObject2 + ";");
        }

        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            paramString.append("trade_no=" + (String)localObject3 + ";");
        }

        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            paramString.append("app_userid=" + (String)localObject4 + ";");
        }

        if (paramString.length() == 0)
            return;
        String str;
        if ((str = paramString.toString()).endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }

        paramInteractionData.a(new Header[] { new BasicHeader("Msp-Param", str) });

        paramRequest.a(paramInteractionData);
    }

    private static String a(String paramString) {
        if (!paramString.contains("biz_type")) {
            return null;
        }
        return d(paramString);
    }

    private static String b(String paramString) {
        if (!paramString.contains("biz_no")) {
            return null;
        }
        return d(paramString);
    }

    private static String c(String paramString) {
        if ((!paramString.contains("trade_no")) || (paramString.startsWith("out_trade_no"))) {
            return null;
        }
        return d(paramString);
    }

    private static String d(String paramString) {
        paramString = paramString.split("=");
        String str = null;
        if (paramString.length > 1) {
            if (paramString[1].contains("\"")) {
                str = str.replaceAll("\"", "");
            }
        }
        return str;
    }

    private static String e(String paramString) {
        if (!paramString.contains("app_userid")) {
            return null;
        }
        return d(paramString);
    }

    public static void a(InteractionData paramInteractionData, HttpResponse paramHttpResponse) {
        paramHttpResponse = paramHttpResponse.getHeaders("Msp-Param");
        if ((paramInteractionData != null) && (paramHttpResponse.length > 0))
            paramInteractionData.a(paramHttpResponse);
    }

    public static byte[] a(byte[] paramArrayOfByte) throws UnZipException {
        byte[] arrayOfByte = null;
        try {
            paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
            GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
            arrayOfByte = new byte[4096];
            int i = 0;
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            while ((i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length)) != -1) {
                localByteArrayOutputStream.write(arrayOfByte, 0, i);
            }
            arrayOfByte = localByteArrayOutputStream.toByteArray();
            localByteArrayOutputStream.flush();
            localByteArrayOutputStream.close();
            localGZIPInputStream.close();
            paramArrayOfByte.close();
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            localUnsupportedEncodingException.printStackTrace();
            throw new UnZipException("UnsupportedEncodingException");
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
            throw new UnZipException("IOException");
        }
        return arrayOfByte;
    }

    public static Request a() {
        Envelope localEnvelope = new Envelope();
        localEnvelope.b(GlobalConstants.b);
        localEnvelope.c("com.alipay.mobilecashier");
        localEnvelope.d("/device/findAccount");
        localEnvelope.e("3.0.0");

        GlobalContext localGlobalContext = GlobalContext.a();
        TidInfo localTidInfo = TidInfo.c();
        JSONObject localJSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(localTidInfo.a()))
                localJSONObject.put("tid", localTidInfo.a());
            else {
                localTidInfo.b(localTidInfo.b());
            }
            localJSONObject.put("utdid", localGlobalContext.g());
            localJSONObject.put("app_key", "2014052600006128");
            localJSONObject.put("new_client_key", localTidInfo.b());
            localJSONObject.put("imei", DeviceInfo.a(localGlobalContext.b()).b());
            localJSONObject.put("imsi", DeviceInfo.a(localGlobalContext.b()).a());
        } catch (JSONException localJSONException) {

        }
        return new Request(localEnvelope, localJSONObject);
    }
}
