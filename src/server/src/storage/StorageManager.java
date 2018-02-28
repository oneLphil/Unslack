package storage;

public class StorageManager {

	private StorageSynchronizationEnsuree<Integer> SSE = StorageSynchronizationEnsuree.getInstance();
	
	public StorageManager() {
		SSE.lockStorage(1);
		SSE.unlockStorage(1);
	}
	
}
