package json_serializer;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public enum JobTypeEnums {
    YARN_JOB(1, false, "运行在yarn上的作业"),
    COMMON_JOB(2, false, "非运行在yarn上的作业"),
    HIVE_JOB(3, false, "hive thrift 异步 job"),
    HIVE_SYNC_JOB(6, true, "hive jdbc 同步 job"),
    EMAIL_JOB(5, false, "email job"),
    MR_JOB(4, false, "mr job"),
    RIDER_JOB(7, false, "rider job"),
    LANCER_JOB(8, false, "lancer job"),
    SPARK_JOB(9, false, "spark job"),
    SPARK_STREAMING_JOB(10, false, "spark streaming job"),
    SHELL_JOB(11, false, "shell job"),
    SPARK_SQL_JOB(12, false, "spark job"),
    SPARK_SQL_SYNC_JOB(13, true, "spark 同步job"),
    PYTHON_MR(14, false, "python mr"),
    PRESTO_SQL_JOB(15, false, "presto job"),
    PRESTO_SQL_SYNC_JOB(16, true, "presto 同步 job"),
    HIVE_ON_SPARK_JOB(17, true, "hive on spark job"),
    HIVE_ON_SPARK_SYNC_JOB(18, true, "hive on spark 同步 job"),
    AUTO_DISPATCHER_JOB(19, true, "auto dispatcher job"),
    HTTP_INVOKE_JOB(20, false, "http invoke job"),
    FLINK_JOB(21, false, "flink job"),
    BLUKLOAD_JOB(30, false, "hbase blukload job"),
    RIDER_INPUT_JOB(40, false, "rider inter job"),
    RIDER_OUTPUT_JOB(50, false, "rider output job"),
    ALTEREGO_OUTPUT_JOB(51, false, "alterego spark out hive warehouse job");

    private Integer code;
    private boolean sync;
    private String desc;
    static List<Integer> sqlTypeList = Arrays.asList(3, 6, 10, 12, 13, 15, 16, 17, 18, 19);

    private JobTypeEnums(Integer code, boolean sync, String desc) {
        this.code = code;
        this.sync = sync;
        this.desc = desc;
    }
    @JSONField(name = "code")
    public Integer getCode() {
        return this.code;
    }

    @JSONField(name = "code")
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isSync() {
        return this.sync;
    }

    public static JobTypeEnums getJobTypeByCode(int code) {
        Preconditions.checkArgument(code > 0, "invalid jobType code");
        JobTypeEnums[] values = values();
        JobTypeEnums[] var2 = values;
        int var3 = values.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            JobTypeEnums value = var2[var4];
            if (value.getCode() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("invalid jobType" + code);
    }

    public static boolean isSqlType(int code) {
        Preconditions.checkArgument(code > 0, "invalid jobType code");
        return sqlTypeList.contains(code);
    }

    public static void main(String[] args) {
//        System.out.println(String.valueOf(JobTypeEnums.YARN_JOB));
        System.out.println(UUID.randomUUID().hashCode());
    }

}

