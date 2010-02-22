package checkers.nullness.quals;

import java.lang.annotation.*;
import java.io.File;

import checkers.nullness.NullnessChecker;

/**
 * Indicates that if the method returns false, then the value expressions
 * are non-null.
 * <p>
 *
 * For instance, if {@link PriorityQueue#isEmpty()} is false, then
 * {@link PriorityQueue#peek()} is nonnull.  You can express
 * this relationship as:
 *
 * <pre><code>  @AssertNonNullIfFalse({"peek()"})
 *   public boolean isEmpty() { ... }
 * </code></pre>
 * <p>
 *
 * @see NonNull
 * @see NullnessChecker
 * @checker.framework.manual #nullness-checker Nullness Checker
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AssertNonNullIfFalse {

    /**
     * The value can be:
     *
     * <ol>
     * <li>fields on receiver object.  The value should simply be the
     * field name, e.g. {@code next}, {@code parent}.
     *
     * <li>no-arg method members on the receiver object:  The value
     * would be the method signature, e.g. {@code list()}
     *
     * <li>method argument:  The value should be {@code #} followed
     * by the parameter index (index starts with 0), e.g. {@code #2}.
     * </ol>
     */
    String[] value();
}
