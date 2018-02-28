package tests;

import org.junit.Before;
import org.junit.Test;
import storage.StorageSynchronizationEnsuree;

public class StorageSynchronizationEnsureeTest {

	// util
	
	public StorageSynchronizationEnsuree<Integer> sync;

	public StorageSynchronizationEnsuree<Integer> createSyncEnsuree() {
		return StorageSynchronizationEnsuree.getInstance();
	}
	
	@Before
	public void setupSynchronization() {
		sync = createSyncEnsuree();
	}
	
	// tests
	
	@Test
	public void lockAndUnlockARoom() throws Exception {
		sync.lockStorage(0);
		sync.unlockStorage(0);
	}
	
	@Test(expected=RuntimeException.class)
	public void unlockNewRoom() throws Exception {
		sync.unlockStorage(0);
	}
	
	@Test
	public void lockSameRoomMultipleTimes() {
		sync.lockStorage(0);
		sync.unlockStorage(0);
		sync.lockStorage(0);
		sync.unlockStorage(0);
	}
	
	@Test
	public void lockAndUnlockMultipleRooms() {
		sync.lockStorage(0);
		sync.lockStorage(1);
		sync.unlockStorage(0);
		sync.unlockStorage(1);
	}
}
