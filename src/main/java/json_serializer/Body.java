package json_serializer;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Body {
    @JSONField(serializeUsing = JobTypeEnumSerializer.class, deserializeUsing = JobTypeEnumDeserializer.class)
    private JobTypeEnums jobType;

    private String name;
}
