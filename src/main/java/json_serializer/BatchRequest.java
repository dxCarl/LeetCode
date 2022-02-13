package json_serializer;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiao
 */
@Getter
@Setter
public class BatchRequest {
    /**
     * 获取批次操作类型
     *
     * @return
     */
    private int requestType;
}
