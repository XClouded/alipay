package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class JsBridge
{
    private IJsCallback a;
    private Context b;

    public JsBridge(Context paramContext, IJsCallback paramIJsCallback) {
        this.b = paramContext;
        this.a = paramIJsCallback;
    }

    public final void a(String paramString) {
        Object localObject1 = null;
        String str = null;
        try {
            if (TextUtils.isEmpty(str = (localObject1 = new JSONObject(paramString)).getString("clientId"))) {
                return;
            }
            paramString = null;

            if (((localObject2 = ((JSONObject)localObject1).getJSONObject("param")) instanceof JSONObject)) {
                paramString = (JSONObject)localObject2;
            }

            Object localObject2 = ((JSONObject)localObject1).getString("func");
            localObject1 = ((JSONObject)localObject1).getString("bundleName");
            CallInfo localCallInfo;
            (localCallInfo = new CallInfo("call")).b((String)localObject1);
            localCallInfo.c((String)localObject2);
            localCallInfo.a(paramString);
            localCallInfo.a(str);
            localObject1 = localCallInfo;
            paramString = this;
            if (TextUtils.isEmpty(((CallInfo)localObject1).b())) {
                paramString.a(((CallInfo)localObject1).a(), CallInfo.CallError.c);
                return;
            }
            localObject1 = new Runnable() {
                public void run() {
                    CallInfo.CallError localCallError;
                    if ((localCallError = JsBridge.a(JsBridge.this, this.a)) !=  CallInfo.CallError.a)
                        try {
                            JsBridge.a(JsBridge.this, this.a.a(), localCallError);
                            return;
                        } catch (JSONException localJSONException) {
                            localJSONException.printStackTrace();
                        }
                }
            };
            if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0) {
                ((Runnable)localObject1).run();
                return;
            }

            new Handler(Looper.getMainLooper()).post((Runnable)localObject1);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
            if (!TextUtils.isEmpty(str))
                try {
                    a(str, CallInfo.CallError.d);
                    return;
                } catch (JSONException localJSONException) {
                    localJSONException.printStackTrace();
                }
        }
    }

    private void a(CallInfo paramCallInfo) throws JSONException {
        if (paramCallInfo == null) {
            return;
        }

        if (TextUtils.isEmpty(paramCallInfo.b())) {
            a(paramCallInfo.a(), CallInfo.CallError.c);

            return;
        }

        paramCallInfo = new Runnable() {
            public void run() {
                CallInfo.CallError localCallError;
                if ((localCallError = JsBridge.a(JsBridge.this, this.a)) != CallInfo.CallError.a)
                try {
                    JsBridge.a(JsBridge.this, this.a.a(), localCallError);
                    return;
                } catch (JSONException localJSONException) {
                    localJSONException.printStackTrace();
                }
            }
        };
        if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0) {
            paramCallInfo.run();
            return;
        }
        new Handler(Looper.getMainLooper()).post(paramCallInfo);
    }

    private void a(String paramString, CallInfo.CallError paramCallError) throws JSONException {
        if (TextUtils.isEmpty(paramString))
            return;
        JSONObject localJSONObject;
        (localJSONObject = new JSONObject()).put("error", paramCallError.ordinal());
        (paramCallError = new CallInfo("callback")).a(localJSONObject);
        paramCallError.a(paramString);
        this.a.a(paramCallError);
    }

    private static void a(Runnable paramRunnable) {
        if (paramRunnable == null) {
            return;
        }

        if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0) {
            paramRunnable.run(); return;
        }
        new Handler(Looper.getMainLooper()).post(paramRunnable);
    }

    private CallInfo.CallError b(CallInfo paramCallInfo) {
        if ((paramCallInfo != null) && ("toast".equals(paramCallInfo.b()))) {
            final CallInfo localCallInfo = paramCallInfo; paramCallInfo = this;
            JSONObject localJSONObject;
            String str = (localJSONObject = localCallInfo.c()).optString("content");
            int i = localJSONObject.optInt("duration");
            int j = 1;
            if (i < 2500)
                j = 0;
            Toast.makeText(paramCallInfo.b, str, j).show();
            new Timer().schedule(new TimerTask() {
                public void run() {
                    JSONObject localJSONObject = new JSONObject();
                    try {
                        localJSONObject.put("toastCallBack", "true");
                    }
                    catch (JSONException localJSONException) {
                        localJSONException.printStackTrace();
                    }
                    CallInfo localCallInfo;
                    (localCallInfo = new CallInfo("callback")).a(localCallInfo.a());
                    localCallInfo.a(localJSONObject);
                    JsBridge.a(JsBridge.this).a(localCallInfo);
                }
            } , j);
        }
        return CallInfo.CallError.a;
    }

    private void c(CallInfo paramCallInfo) {
        JSONObject localJSONObject;
        String str = (localJSONObject = paramCallInfo.c()).optString("content");

        int i = localJSONObject.optInt("duration");
        int j = 1;
        if (i < 2500) {
            j = 0;
        }
        Toast.makeText(this.b, str, j).show();

        new Timer().schedule(new TimerTask() {
            public void run() {
                JSONObject localJSONObject = new JSONObject();
                try {
                    localJSONObject.put("toastCallBack", "true");
                }
                catch (JSONException localJSONException) {
                    localJSONException.printStackTrace();
                }
                CallInfo localCallInfo;
                (localCallInfo = new CallInfo("callback")).a(localCallInfo.a());
                localCallInfo.a(localJSONObject);
                JsBridge.a(JsBridge.this).a(localCallInfo);
            }
        }, j);
    }
}

