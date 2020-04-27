//package modernity.api.plugin;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * Indicates a plugin for the Modernity. All classes annotated with {@code @ModernityPlugin} are recognized by the
// * Modernity mod and loaded right before construction time.
// * <p>
// * A distribution side may be given as optional {@code value} argument to make your plugin only load on a
// * specific distribution:
// * <ul>
// * <li>{@link ModernityPlugin.Side#COMMON COMMON}: The plugin always loads (default)</li>
// * <li>{@link ModernityPlugin.Side#CLIENT CLIENT}: The plugin only loads on the client distribution</li>
// * <li>{@link ModernityPlugin.Side#SERVER SERVER}: The plugin only loads on the dedicated server distribution</li>
// * </ul>
// * <p>
// * Example:
// * <pre>
// * &#64;ModernityPlugin( ModernityPlugin.Side.CLIENT )
// * public class MyClientPlugin implements ILifecycleListener {
// *     &#64;Override
// *     public void modernitySetup( IModernity modernity ) {
// *         System.out.println( "Plugin loaded" );
// *     }
// * }
// * </pre>
// * Once the Modernity loads this plugin, it will print "{@code Plugin loaded}" once the Modernity finished setup-time
// * loading. For more info, check the wiki on GitHub
// */
//@Retention( RetentionPolicy.RUNTIME )
//@Target( ElementType.TYPE )
//public @interface ModernityPlugin {
//    Side value() default Side.COMMON;
//
//    enum Side {
//        COMMON,
//        CLIENT,
//        SERVER
//    }
//}