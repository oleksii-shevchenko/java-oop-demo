package ua.ipt.kpi.hw.infra;

import java.util.function.Function;

/**
 * General data container (collection). Operations this
 * null MUST not be supported and throw an {@link RuntimeException}.
 * @param <T> Elements of the list
 */
public interface List<T> extends Iterable<T> {
    /**
     * Add element to list
     * @param value The value to add
     */
    void add(T value);

    /**
     * Check is list contains element (accordingly to equals)
     * @param value The value to check
     * @return Boolean value that indicates presence of the element in the list
     */
    boolean contains(T value);

    /**
     * Get element by index. It must thrown an {@link RuntimeException} if list
     * is empty or index out of size range.
     * @param index The index of the element
     * @return Element of the list
     */
    T get(int index);

    /**
     * Deletes ALL elements from the list that are
     * equal to specified. In case there is not such
     * element DO not throw an exception
     * @param value The value to compare
     * @return Always return the object that was passed as an argument
     */
    T delete(T value);

    /**
     * Delete element from the list by index. In case of empty list
     * or index out of range throw {@link RuntimeException}.
     * @param index Index of the element
     * @return Deleted element
     */
    T delete(int index);

    /**
     * Update element of the list by index. In case of empty list
     * or index out of range throw {@link RuntimeException}.
     * @param index Index of the element
     * @return Old value
     */
    T update(int index, T value);

    /**
     * @return Returns list size
     */
    int size();

    /**
     * Process all list elements by given function and creates
     * a new {@link List} from output elements. If processor returns
     * null it MUST not be included in resulting list.
     * @param processor Element processor
     * @param <V> Element processor output element
     * @return List of processed elements
     */
    <V> List<V> process(Function<T, V> processor);
}
