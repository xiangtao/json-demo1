package big.data.json.bean.ds;

public enum DataSourceType {

    FILE,
    MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://", true),
    PALO("com.mysql.jdbc.Driver", true),
    Hive2("org.apache.hive.jdbc.HiveDriver"),
    KYLIN,
    MONGO,
    PRESTO("com.facebook.presto.jdbc.PrestoDriver");

    private String driverClass;
    private String jdbcPrefix;
    private boolean isSupport;

    private DataSourceType() {
        this.driverClass = "";
        isSupport = false;
    }

    private DataSourceType(String driverClass) {
        this.driverClass = driverClass;
        isSupport = false;
    }

    private DataSourceType(String driverClass, boolean isSupport) {
        this.driverClass = driverClass;
        this.isSupport = isSupport;
    }

    private DataSourceType(String driverClass, String jdbcPrefix, boolean isSupport) {
        this.driverClass = driverClass;
        this.isSupport = isSupport;
        this.jdbcPrefix = jdbcPrefix;
    }


    public String getDriverClass() {
        return driverClass;
    }

    public String getJdbcPrefix() {
        return jdbcPrefix;
    }

    public boolean getIsSupport() {
        return isSupport;
    }
}
