package xyz.lukasz.armchair.common.database;

import com.pivovarit.function.ThrowingFunction;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

@UtilityClass
public final class Queries {

    /**
     * Simplifies the database query process,
     * processing all the necessary exception handling.
     * @param dataSource The data source.
     * @param logger A SLF4J logger instance.
     * @param statementProvider A method returning a prepared statement.
     */
    public static void runQuery(
        DataSource dataSource,
        Logger logger,
        ThrowingFunction<Connection, PreparedStatement, SQLException> statementProvider) {
        runQuery(dataSource, logger, statementProvider, Queries::ignoreResult);
    }

    /**
     * Simplifies the database query process,
     * processing all the necessary exception handling.
     * @param dataSource The data source.
     * @param logger A SLF4J logger instance.
     * @param statementSupplier A method returning a prepared statement.
     * @param setFunction A method working on the ResultSet created by executing the query.
     * @return A user-provided object created in setFunction,
     *         or null if the executed query raised an error (eg. a database connection times out).
     */
    public static <T> @Nullable T runQuery(
        DataSource dataSource,
        Logger logger,
        ThrowingFunction<Connection, PreparedStatement, SQLException> statementSupplier,
        ThrowingFunction<ResultSet, T, SQLException> setFunction) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        T result = null;

        try {
            connection = dataSource.getConnection();
            statement = statementSupplier.apply(connection);
            resultSet = statement.executeQuery();
            result = setFunction.apply(resultSet);
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }

        return result;
    }

    /**
     * Ignores the result of a query.
     * @param resultSet A result set.
     * @return Null value.
     */
    @Contract("_ -> null")
    public static Object ignoreResult(@Nullable ResultSet resultSet) {
        return null;
    }
}
