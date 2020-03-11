public class GetDataResponse implements IResponse {

    private String command;

    private String resultData;

    public GetDataResponse(String command, String resultData) {
        this.command = command;
        this.resultData = resultData;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }
}
