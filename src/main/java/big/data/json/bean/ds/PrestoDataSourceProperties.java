package big.data.json.bean.ds;

public class PrestoDataSourceProperties  extends DBMSSourceProperties {

    private String catalog;
    private String source;

    @Override
    public DataSourceType getType() {
        return DataSourceType.PRESTO;
    }

    @Override
    public String toJsonString() {
        return null;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
