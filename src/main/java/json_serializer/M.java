package json_serializer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xiao
 * @date 2020/10/21
 */
@Slf4j
public class M {

    public static void main(String[] args) {
//        Body body = new Body();
//        body.setJobType(JobTypeEnums.EMAIL_JOB);
//        body.setName("test");
//        String s = JSONObject.toJSONString(body);
//        Body body1 = JSONObject.parseObject(s, Body.class);
//        System.out.println(body1);
//
//        String str = "{\"async\":true,\"bizDateList\":[1633881600000],\"executeType\":0,\"period\":\"0 0 0 * * ?\",\"periodType\":1,\"postProjects\":[],\"projectBranchId\":3744,\"projectId\":2019125,\"requestType\":1,\"runtimeCommand\":{\"engine\":\"\",\"manual_runtime_params\":\"\"},\"timeRange\":\"2021/10/11~2021/10/11\"}";
//
//        BatchRequest params = JSONObject.parseObject(str, BatchRequest.class);
//        System.out.println(params);

        Date d1 = new Date();
        Date d2 = new Date(System.currentTimeMillis() + 10000L);

        final Optional<Date> min = Stream.of(d1, d2).min(Comparator.naturalOrder());
        final Optional<Date> max = Stream.of(d1, d2).max(Comparator.naturalOrder());
        final Date im = min.get();
        final Date ax = max.get();
        ZoneId zoneId = ZoneId.of("+8");
        final Instant instant = im.toInstant();
        final LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println(localDateTime.toString());

    }


}
