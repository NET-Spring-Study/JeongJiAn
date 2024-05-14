package hello.core.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("Call Constructor, url = " + url);
        connect();
        call("init msg");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String msg) {
        System.out.println("call: " + url + " message = " + msg);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }
}
