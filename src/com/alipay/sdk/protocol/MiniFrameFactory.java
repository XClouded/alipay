package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.Envelope;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.tid.TidInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniFrameFactory
{
    public static MiniWindowFrame a(FrameData paramFrameData) throws NetErrorException, FailOperatingException, AppErrorException {
        Request localRequest = paramFrameData.a();
        Response localResponse = paramFrameData.b();
        JSONObject localJSONObject = paramFrameData.c();
        String str = "程序发生错误";
        MiniWindowFrame localMiniWindowFrame = null;

        if (localJSONObject.has("form")) {
            (localMiniWindowFrame = new MiniWindowFrame(localRequest, localResponse)).a(paramFrameData.c());
        } else if (localJSONObject.has("status")) {
            paramFrameData = MiniStatus.a(localJSONObject.optString("status"));

            switch (1.a[paramFrameData.ordinal()]) {
            case 1:
            case 2:
            case 3:
                (localMiniWindowFrame = new MiniWindowFrame(localRequest, localResponse)).a(localJSONObject);
                break;
            case 4:
                TidInfo.d();
                break;
            default:
                paramFrameData = TextUtils.isEmpty(paramFrameData = localJSONObject.optString("msg")) ? str : paramFrameData;
                throw new FailOperatingException(paramFrameData);
            }
        } else { throw new FailOperatingException(str); }

        return localMiniWindowFrame;
    }

    public final void b(FrameData paramFrameData) throws NetErrorException, FailOperatingException, AppErrorException {
        Response localResponse = paramFrameData.b();
        JSONObject localJSONObject = paramFrameData.c();

        Object localObject1 = paramFrameData.a().d();
        Object localObject2;
        if (TextUtils.isEmpty((localObject2 = paramFrameData.b().a()).d())) {
            ((Envelope)localObject2).d(((Envelope)localObject1).d());
        }
        if (TextUtils.isEmpty(((Envelope)localObject2).e())) {
            ((Envelope)localObject2).e(((Envelope)localObject1).e());
        }
        if (TextUtils.isEmpty(((Envelope)localObject2).c())) {
            ((Envelope)localObject2).c(((Envelope)localObject1).c());
        }
        if (TextUtils.isEmpty(((Envelope)localObject2).b())) {
            ((Envelope)localObject2).b(((Envelope)localObject1).b());
        }

        localObject1 = "session";

        if ((localObject2 = localJSONObject.optJSONObject("reflected_data")) != null) {
            new StringBuilder("session = ").append(((JSONObject)localObject2).optString((String)localObject1, "")).toString();
            paramFrameData.b().a((JSONObject)localObject2);
        } else if (localJSONObject.has((String)localObject1)) {
            localObject2 = new JSONObject();
            try {
                ((JSONObject)localObject2).put((String)localObject1, localJSONObject.optString((String)localObject1));

                if (!TextUtils.isEmpty(paramFrameData = TidInfo.c().a())) {
                    ((JSONObject)localObject2).put("tid", paramFrameData);
                }
                localResponse.a((JSONObject)localObject2);
            } catch (JSONException localJSONException) {
                throw new AppErrorException(getClass(), "can not put reflected values");
            }

        }

        localResponse.b(localJSONObject.optString("end_code", "0"));
        localResponse.e(localJSONObject.optString("user_id", ""));
        paramFrameData = localJSONObject.optString("result");
        try {
            paramFrameData = URLDecoder.decode(localJSONObject.optString("result"), "UTF-8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        localResponse.c(paramFrameData);
        localResponse.d(localJSONObject.optString("memo", ""));
    }

}
