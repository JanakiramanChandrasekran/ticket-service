package integration;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class RestClientAdapter {

    private final String host;

    public RestClientAdapter(final String host) {
        this.host = host;
    }

    public RestClient getClient() {
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(host).setLogLevel(LogLevel.BASIC).build();
        return restAdapter.create(RestClient.class);
    }
}
