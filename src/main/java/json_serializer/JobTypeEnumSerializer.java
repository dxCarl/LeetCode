package json_serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class JobTypeEnumSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        JobTypeEnums jobTypeEnums = (JobTypeEnums) o;
        jsonSerializer.out.writeString(jobTypeEnums.getCode().toString());
    }
}
