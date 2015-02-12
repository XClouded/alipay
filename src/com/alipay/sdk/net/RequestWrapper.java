package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.Envelope;
import com.alipay.sdk.data.FrameUtils;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import com.alipay.sdk.encrypt.Base64;
import com.alipay.sdk.encrypt.MD5;
import com.alipay.sdk.encrypt.TriDes;
import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.exception.UnZipException;
import com.alipay.sdk.protocol.FrameData;
import com.alipay.sdk.protocol.FrameFactoryManager;
import com.alipay.sdk.sys.GlobalContext;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestWrapper
{
    private int a = 0;
    private InteractionData b;

    public RequestWrapper(InteractionData paramInteractionData) {
        this.b = paramInteractionData;
    }

    public RequestWrapper() {

    }

    public final FrameData a(Context paramContext, Request paramRequest, boolean paramBoolean) throws NetErrorException, FailOperatingException, AppErrorException, UnZipException {
        Response localResponse = new Response();
        Object localObject;
        if ((paramContext = a(paramContext, paramRequest, localResponse)).optBoolean("gzip")) {
            if (((localObject = paramContext.optJSONObject("form")) != null) && (((JSONObject)localObject).has("quickpay"))) {
                localObject = Base64.a(((JSONObject)localObject).optString("quickpay"));
                try {
                    String str1 = MD5.a(localObject = FrameUtils.a((byte[])localObject));
                    String str2 = paramContext.optString("md5");
                    if (TextUtils.equals(str1, str2)) {
                        localObject = new String((byte[])localObject, "utf-8");
                        paramContext.put("form", new JSONObject((String)localObject));
                        break label165;
                    }
                    throw new UnZipException("client md5  not equal server md5");
                } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                    throw new UnZipException("unzip byte array unsupport encoding");
                } catch (UnZipException localUnZipException) {
                    throw localUnZipException;
                } catch (JSONException localJSONException) {
                    throw new UnZipException("unzip string not jsonObject");
                }
            }
        } else {
            localResponse.b();
        }

        label165: new StringBuilder("responsestring decoded ").append(paramContext).toString();
        (localObject = new FrameData(paramRequest, localResponse)).a(paramContext);
        if (paramBoolean) {
            return localObject;
        }
        return FrameFactoryManager.a((FrameData)localObject);
    }

    private JSONObject a(Context paramContext, Request paramRequest, Response paramResponse) throws NetErrorException, FailOperatingException, AppErrorException {
        Object localObject1 = GlobalContext.f();
        try {
            Object localObject2 = a(paramContext, paramRequest.a(), paramRequest.a((String)localObject1).toString(), paramRequest.b(), paramResponse);
            paramResponse.a(Calendar.getInstance().getTimeInMillis());
            if (paramRequest.c()) {
                Object localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = paramResponse;
                paramResponse = paramRequest;
                paramRequest = paramContext;
                paramContext = this;
                localObject3 = a((String)localObject3, (Response)localObject1);
                paramContext.a += 1;
                if (((Response)localObject1).c() != 0)
                    throw new FailOperatingException(((Response)localObject1).d());
                paramContext.a = 0;
                if (TextUtils.isEmpty(paramRequest = ((JSONObject)localObject3).optString("res_data")))
                    throw new AppErrorException(paramContext.getClass(), "response data is empty");
                paramContext = TriDes.b((String)localObject2, paramRequest);
                new StringBuilder("respData:").append(paramContext).toString();
                paramContext = (((Response)localObject1).c() == 1000) && (paramContext.a < 3) ? paramContext.a(paramRequest, paramResponse, (Response)localObject1) : new JSONObject(paramContext);
            } else {
                localObject1 = localObject2;
                paramResponse = paramResponse;
                paramRequest = null;
                paramContext = null;
                localObject2 = a((String)localObject1, paramResponse);
                new StringBuilder("respData:").append(((JSONObject)localObject2).toString()).toString();
            }
            return (Context)localObject2;
        } catch (NetErrorException localNetErrorException) {
            throw localNetErrorException;
        } catch (FailOperatingException localFailOperatingException) {
            throw localFailOperatingException;
        } catch (AppErrorException localAppErrorException) {
            throw localAppErrorException;
        } catch (Exception localException) {

        }
        throw new NetErrorException();
    }

    private static String a(String paramString) {
        FileInputStream localFileInputStream = null;
        try {
            localFileInputStream = new FileInputStream(paramString);
            paramString = new BufferedReader(new InputStreamReader(localFileInputStream));

            char[] arrayOfChar = new char[2048];
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            while ((i = paramString.read(arrayOfChar)) > 0) {
                localStringBuilder.append(arrayOfChar, 0, i);
            }

            paramString.close();
            paramString = localStringBuilder.toString();
            try {
                localFileInputStream.close();
            } catch (IOException localIOException1) {
                localIOException1.printStackTrace();
            }
            return paramString;
        } catch (Exception localException) {

        } finally {
            if (localFileInputStream != null) {
                try {
                    localFileInputStream.close();
                } catch (IOException localIOException3) {
                    localIOException3.printStackTrace();
                }
            }
        }

        return null;
    }

    private JSONObject a(Context paramContext, Request paramRequest, Response paramResponse, String paramString1, String paramString2) throws JSONException, AppErrorException, NetErrorException, FailOperatingException {
        paramString2 = a(paramString2, paramResponse);
        if ((paramResponse.c() == 1000) && (this.a < 3)) {
            this.a += 1;
            return a(paramContext, paramRequest, paramResponse);
        }
        if (paramResponse.c() != 0) {
            throw new FailOperatingException(paramResponse.d());
        }
        this.a = 0;

        if (TextUtils.isEmpty(paramContext = paramString2.optString("res_data"))) {
        throw new AppErrorException(getClass(), "response data is empty");
        }

        paramContext = TriDes.b(paramString1, paramContext);
        new StringBuilder("respData:").append(paramContext).toString();
        return new JSONObject(paramContext);
    }

    private static JSONObject a(Response paramResponse, String paramString) throws JSONException, AppErrorException {
        paramResponse = a(paramString, paramResponse);
        new StringBuilder("respData:").append(paramResponse.toString()).toString();
        return paramResponse;
    }

    private String a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData, Response paramResponse) throws NetErrorException {
        try {
            paramString1 = (paramContext = RequestUtils.a(paramContext, paramString1, paramString2, paramInteractionData)).getStatusLine();
            paramResponse.a(paramString1.getStatusCode());
            paramResponse.a(paramString1.getReasonPhrase());

            FrameUtils.a(this.b, paramContext);

            return RequestUtils.a(paramContext);
        } catch (Exception localException) {
            throw new NetErrorException();
        } finally {
            RequestUtils.a();
        }
        throw paramContext;
    }

    private static JSONObject a(String paramString, Response paramResponse) throws JSONException, AppErrorException {
        if ((paramString = new JSONObject(paramString).optJSONObject("data")) != null) {
            paramResponse.a(paramString.optInt("code", 503));
            paramResponse.a(paramString.optString("error_msg", ""));

            if ((paramString = paramString.optJSONObject("params")) != null) {
                Object localObject;
                if (paramResponse.c() == 1000) {
                    if (!TextUtils.isEmpty(localObject = paramString.optString("public_key")))
                        GlobalContext.a().c().a((String)localObject);
                }

                (localObject = new Envelope()).d(paramString.optString("next_api_name"));
                ((Envelope)localObject).e(paramString.optString("next_api_version"));
                ((Envelope)localObject).c(paramString.optString("next_namespace"));
                ((Envelope)localObject).b(paramString.optString("next_request_url"));
                paramResponse.a((Envelope)localObject);

                return paramString;
            }
            paramResponse.c();
        } else {
            paramResponse.a(503);
            paramResponse.a("");
        }
        return null;
    }

    private static void a(JSONObject paramJSONObject) {
        if (!TextUtils.isEmpty(paramJSONObject = paramJSONObject.optString("public_key"))) {
            GlobalContext.a().c().a(paramJSONObject);
        }
    }

}
