package com.alipay.sdk.util;

import com.alipay.sdk.cons.GlobalConstants;
import com.alipay.sdk.encrypt.Rsa;
import com.alipay.sdk.encrypt.TriDes;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils
{
    public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
        JSONObject localJSONObject1 = new JSONObject();
        try {
            paramJSONObject1 = null; paramJSONObject2 = (paramJSONObject1 = new JSONObject[] { paramJSONObject1, paramJSONObject2 }).length;
            for (JSONObject localJSONObject2 = 0; localJSONObject2 < paramJSONObject2; localJSONObject2++) {
                Object localObject;
                if ((localObject = paramJSONObject1[localJSONObject2]) != null) {
                    Iterator localIterator = localObject.keys();

                    while (localIterator.hasNext()) {
                        String str = (String)localIterator.next();
                        localJSONObject1.put(str, localObject.get(str));
                    }
                }
            }
        } catch (JSONException localJSONException) {  }

        return localJSONObject1;
    }

    public static String a(String paramString1, String paramString2) {
        String str = GlobalConstants.d;
        str = Rsa.a(paramString1, str);
        paramString1 = TriDes.a(paramString1, paramString2);
        return String.format(Locale.getDefault(), "%08X%s%08X%s", new Object[] { Integer.valueOf(str.length()), str, Integer.valueOf(paramString1.length()), paramString1 });
    }

}
