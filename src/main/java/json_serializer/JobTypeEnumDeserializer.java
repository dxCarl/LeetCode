package json_serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class JobTypeEnumDeserializer implements ObjectDeserializer {
    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        Integer code = defaultJSONParser.parseObject(Integer.class);
        if (null == code) {
            return null;
        }
        JobTypeEnums jobTypeByCode = JobTypeEnums.getJobTypeByCode(code);
        return (T) jobTypeByCode;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
