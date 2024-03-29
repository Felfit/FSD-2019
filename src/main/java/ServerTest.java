import io.atomix.utils.net.Address;

import java.util.ArrayList;

public class ServerTest {
    public static void main(String[] args) {

        ArrayList<Address> servers = new ArrayList<>(); // encher
        int n = 10;
        int port = 10000;
        for(int i = 0; i < n; i++) {
            servers.add(Address.from(port + i));
        }

        for(int i = 0; i < n; i++) {
            Server s = new Server(i, servers, Address.from(port + i), "Cluster");
            s.start();
            if(i == n - 1) s.send("Teste");
        }

    }
}
