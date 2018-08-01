package big.data.json.bean.ds;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 数据集属性类
 * @author taox
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MYSQLDataSourceProperties.class, name = "MYSQL"),
        @JsonSubTypes.Type(value = PaloDataSourceProperties.class, name = "PALO"),
        @JsonSubTypes.Type(value = PrestoDataSourceProperties.class, name = "PRESTO")
})
public abstract class DataSourceProperties {

    /**
     * 得到数据集类型
     * @return
     */
    public abstract DataSourceType getType();


    public abstract String toJsonString();


}
