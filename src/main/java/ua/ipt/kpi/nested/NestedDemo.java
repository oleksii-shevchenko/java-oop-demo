package ua.ipt.kpi.nested;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NestedDemo {
    public static void main(String[] args) {
        List<String> commands = List.of("INSERT", "SELECT", "UPDATE", "DELETE");
        for (String command : commands) {
            System.out.println(CassandraConnection.createConnectionFactory().create().execute(command));
        }

        // Creating out of outer class
        CassandraConnection.CassandraConnectionFactory factory = new CassandraConnection.CassandraConnectionFactory();
    }
}

interface Connection {
    String execute(String query);
}

interface ConnectionFactory {
    Connection create();
}

class CassandraConnection implements Connection {
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConnection.class);

    private static final String DEFAULT_ENDPOINT = "localhost";

    private final long connectionId;

    private CassandraConnection() {
        this(DEFAULT_ENDPOINT);
    }

    private CassandraConnection(String endpoint) {
        this.connectionId = ThreadLocalRandom.current().nextInt();

        LOGGER.info("Opened connection to Cassandra [endpoint={}, connection-id={}]", endpoint, connectionId);
    }

    @Override
    public String execute(String query) {
        return "Returned From Cassandra DB [query=" + query + ", connection-id=" + connectionId + "]";
    }

    public static class CassandraConnectionFactory implements ConnectionFactory {
        private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConnectionFactory.class);

        public CassandraConnectionFactory() {}

        @Override
        public Connection create() {
            LOGGER.info("Creating connection using default endpoint [endpoint={}]", DEFAULT_ENDPOINT);
            return new CassandraConnection();
        }
    }

    public static CassandraConnectionFactory createConnectionFactory() {
        return new CassandraConnectionFactory();
    }
}
