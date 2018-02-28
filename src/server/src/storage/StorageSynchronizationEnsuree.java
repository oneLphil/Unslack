package storage;

import java.util.HashSet;
import java.util.Set;

import sun.misc.Lock;

/* Singleton Class to ensure threadsafe behaviour when accessing storage */
public class StorageSynchronizationEnsuree<T> {

	// singleton properties
	private static StorageSynchronizationEnsuree<Integer> se;
	public static StorageSynchronizationEnsuree<Integer> getInstance() {
		if (se == null) {
			se = new StorageSynchronizationEnsuree<Integer>();
		}
		return se;
	}
	
	// set of rooms currently in use
	private Set<T> inUse;
	// lock to protect r/w to the set of rooms
	private Lock setLock = new Lock();
	
	private StorageSynchronizationEnsuree() {
		inUse = new HashSet<T>();
	}
	
	// spins until able to insert self into room
	public void lockStorage(T room) {
		boolean locked = false;
		while(!locked) {
			
			try {
				setLock.lock();
			} catch (InterruptedException e) {
				e.printStackTrace();
				continue;
			}
		
			if (!inUse.contains(room)) {
				inUse.add(room);
				locked = true;
			}

			setLock.unlock();
		}
	}

	// remove self from room
	// throw RuntimeException if the room was not present
	public void unlockStorage(T room) {
		try {
			setLock.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		boolean wasLocked = inUse.remove(room);
		setLock.unlock();
		if (!wasLocked) {
			throw new RuntimeException();
		}
	}
	
}
