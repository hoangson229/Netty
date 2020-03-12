package netty.mutilrequesttype;

public class GetDataRequest implements IRequest{
    private String command;

    public GetDataRequest(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
