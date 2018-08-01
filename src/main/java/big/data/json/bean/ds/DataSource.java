package big.data.json.bean.ds;

/**
 * 数据源
 */
public class DataSource {

    private int id;
    private String name;
    private DataSourceType dataSourceType;
    private DataSourceProperties dataSourceProperties;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public DataSourceProperties getDataSourceProperties() {
        return dataSourceProperties;
    }

    public void setDataSourceProperties(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataSourceType=" + dataSourceType +
                ", dataSourceProperties=" + dataSourceProperties +
                '}';
    }
}
