//package bridge;
//
//import jdk.internal.reflect.CallerSensitive;
//import jdk.internal.reflect.Reflection;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverAction;
//import java.sql.DriverInfo;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.Enumeration;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.stream.Stream;
//
//public class Example {
//    // List of registered JDBC drivers
//    private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
//    // Used in ensureDriversInitialized() to synchronize driversInitialized
//    private final static Object lockForInitDrivers = new Object();
//    private static volatile boolean driversInitialized;
//
//    @CallerSensitive
//    public static Connection getConnection(String url) throws SQLException {
//        java.util.Properties info = new java.util.Properties();
//        return (getConnection(url, info, Reflection.getCallerClass()));
//    }
//
//    public static void registerDriver(java.sql.Driver driver, DriverAction da) throws SQLException {
//        /* Register the driver if it has not already been added to our list */
//        if (driver != null) {
//            registeredDrivers.addIfAbsent(new DriverInfo(driver, da));
//        } else {
//            // This is for compatibility with the original DriverManager
//            throw new NullPointerException();
//        }
//        println("registerDriver: " + driver);
//    }
//
//    /**
//     * Retrieves an Enumeration with all of the currently loaded JDBC drivers
//     * to which the current caller has access.
//     *
//     * <P><B>Note:</B> The classname of a driver can be found using
//     * <CODE>d.getClass().getName()</CODE>
//     *
//     * @return the list of JDBC Drivers loaded by the caller's class loader
//     * @see #drivers()
//     */
//    @CallerSensitive
//    public static Enumeration<Driver> getDrivers() {
//        ensureDriversInitialized();
//
//        return Collections.enumeration(getDrivers(Reflection.getCallerClass()));
//    }
//
//    //  Worker method called by the public getConnection() methods.
//    private static Connection getConnection(String url, java.util.Properties info, Class<?> caller) throws SQLException {
//        // Walk through the loaded registeredDrivers attempting to make a connection.
//        // Remember the first exception that gets raised so we can reraise it.
//        SQLException reason = null;
//        for (DriverInfo aDriver : registeredDrivers) {
//            try {
//                println("    trying " + aDriver.driver.getClass().getName());
//                Connection con = aDriver.driver.connect(url, info);
//                if (con != null) {
//                    // Success!
//                    println("getConnection returning " + aDriver.driver.getClass().getName());
//                    return (con);
//                }
//            } catch (SQLException ex) {
//                if (reason == null) {
//                    reason = ex;
//                }
//            }
//        }
//
//        // if we got here nobody could connect.
//        if (reason != null) {
//            println("getConnection failed: " + reason);
//            throw reason;
//        }
//        println("getConnection: no suitable driver found for " + url);
//        throw new SQLException("No suitable driver found for " + url, "08001");
//    }
//
//    /**
//     * Retrieves a Stream with all of the currently loaded JDBC drivers
//     * to which the current caller has access.
//     *
//     * @return the stream of JDBC Drivers loaded by the caller's class loader
//     * @since 9
//     */
//    @CallerSensitive
//    public static Stream<Driver> drivers() {
//        ensureDriversInitialized();
//
//        return getDrivers(Reflection.getCallerClass()).stream();
//    }
//}
