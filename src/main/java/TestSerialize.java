import org.apache.commons.lang3.SerializationUtils;

public class TestSerialize {

    public static void main(String[] args) {
        IRequest iRequest = new LoginRequest("hoangson", "123abc");
        byte[] data = SerializationUtils.serialize(iRequest);

        IRequest iRequest2 = SerializationUtils.deserialize(data);
        if(iRequest2 instanceof LoginRequest) {
            System.out.println("Is  LoginRequest : username" + ((LoginRequest) iRequest2).getUsername());
        }


    }
}
