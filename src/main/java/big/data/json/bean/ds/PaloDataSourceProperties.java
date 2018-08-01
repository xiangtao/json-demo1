package big.data.json.bean.ds;


public class PaloDataSourceProperties extends DBMSSourceProperties {

    private String paloUrl;

    public String getPaloUrl() {
        return paloUrl;
    }

    public void setPaloUrl(String paloUrl) {
        this.paloUrl = paloUrl;
    }

    @Override
    public DataSourceType getType() {
        return DataSourceType.PALO;
    }

    @Override
    public String toJsonString() {
        return null;
    }
}
