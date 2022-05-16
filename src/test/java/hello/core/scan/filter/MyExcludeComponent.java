package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
