package main.constant;

public class StringConstant {
    public static final String CS_HOST = "cs-host";
    public static final String DIVIDER = " ";
    public static final String UNION = "\"";
    public static final String REGEX = "(?=([^"+UNION+"]*"+UNION+"[^"+UNION+"]*"+UNION+")*[^"+UNION+"]*$)["+DIVIDER+"]+";
    public static final String FIELDS_START = "#Fields:";
    public static final char SERVICE_MARK = '#';
    public static final String HOST = "Host: ";
    public static final String COUNT = " Count: ";
    public static final String FILE_PATH = "log";
    public static final String FILE_NAME = "log_example.log";
    public static final String WAIT_UPDATE = "wait updating...";
    public static final String FINISH = "finish";
    public static final String STOP_SYMBOL = "procrastinator:((";
    public static final String STOP_COMMAND = "please input \"" + STOP_SYMBOL+"\" to stop tracking";
    public static final String UNABLE_PATH = "unable path";
    public static final String FILE_TEST_PATH = "src/test/output.txt";
}
