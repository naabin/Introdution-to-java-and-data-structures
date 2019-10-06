package com.practice;

import java.util.Collection;
import java.util.Iterator;

public interface MyList<E> extends Collection<E> {
	
	/**
	 * 
	 * @param index
	 * @param e
	 * @apiNote Add a new element from this list at the specified index
	 */
	public void add(int index, E e);
	
	/**
	 * 
	 * @param index
	 * @return the element from this list at the specified index
	 * Return -1 if not match
	 */
	public E get(int index);
	
	/**
	 * 
	 * @param e
	 * @return the index of the first matching element in the list
	 * Return -1 if no match
	 */
	public int indexOf(Object e);
	
	/**
	 * 
	 * @param e
	 * @return Return the last matching element in the list
	 * Return -1 if no match
	 */
	public int lastIndexOf(E e);
	
	/**
	 * 
	 * @param index
	 * @return Remove the element at the specified position in this list
	 * Shift any subsequent elements to the left
	 * Return the element that was removed form the list
	 */
	public E remove(int index);
	
	/**
	 * 
	 * @param index
	 * @param e
	 * @return Replace the element at the specified position in this list
	 * with the specified element and returns the new set
	 */
	public E set(int index, E e);

	@Override
	default int size() {
		return 0;
	}

	@Override
	default boolean isEmpty() {
		return size() == 0;
	}

	@Override
	default boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Add a new element to the end of the list
	 */
	@Override
	default boolean add(E e) {
		add(size(), e);
		return true;
	}

	@Override
	default boolean remove(Object o) {
		if(indexOf(o) >= 0) {
			remove(indexOf(o));
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	default boolean containsAll(Collection<?> c) {
		return true;
	}

	@Override
	default boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	default boolean removeAll(Collection<?> c) {
		return true;
	}

	@Override
	default boolean retainAll(Collection<?> c) {
		
		return true;
	}

	@Override
	default void clear() {
	}	
}
