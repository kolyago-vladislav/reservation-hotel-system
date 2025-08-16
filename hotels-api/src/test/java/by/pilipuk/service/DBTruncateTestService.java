package by.pilipuk.service;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.util.List;

@Service
public class DBTruncateTestService {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DBTruncateTestService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String TRUNCATE_TABLES = """
                        TRUNCATE TABLE %s RESTART IDENTITY CASCADE;
                        """;

    public void truncateAllTables() {
        TABLES_NAMES.forEach(table -> jdbcTemplate.execute(TRUNCATE_TABLES.formatted(table), PreparedStatement::execute));
    }

    public static final List<String> TABLES_NAMES = List.of(
            "hotel.rooms",
            "hotel.hotels",
            "hotel.addresses",
            "hotel.dict_cities",
            "hotel.dict_countries",
            "hotel.room_types"
    );
}