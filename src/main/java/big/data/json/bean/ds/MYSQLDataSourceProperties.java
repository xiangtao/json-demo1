package big.data.json.bean.ds;

public class MYSQLDataSourceProperties extends DBMSSourceProperties {

    @Override
    public DataSourceType getType() {
        return DataSourceType.MYSQL;
    }

    @Override
    public String toJsonString() {
        return null;
    }
}
